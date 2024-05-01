
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { map, catchError, startWith, filter } from 'rxjs/operators';
import { ApiResponse } from './domain/api-response';
import { Image } from './domain/image';
import { Data } from './domain/data';
import { ImageService } from './service/image.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  imagesState$: Observable<{ appState: string, appData?: ApiResponse<Image>, error?: HttpErrorResponse }>;
  currentIndex = 0;
  url!: string
  duration!: string
  images: Image[] = [];

  constructor(private imageService: ImageService) { }


  ngOnInit(): void {
    this.getImagesList();
  }

  getImagesList(): void {
    this.imagesState$ = this.imageService.getImages()
    .pipe(
          map((response: ApiResponse<Image>) => {
            console.log(response);
            console.log('images', response.data.images);
            this.images = response.data.images;
            console.log('before', this.images);
            this.playSlideshow();
            console.log('Images:', this.images);
            return ({ appState: 'APP_LOADED', appData: response});
          }),
          startWith({ appState: 'APP_LOADING' }),
          catchError((error: HttpErrorResponse) =>{
            return of({ appState: 'APP_ERROR', error })}
            )
        )
  }

   playSlideshow() {
     setInterval(() => {
       console.log('Current Index, Start:', this.currentIndex); // Log current index
       console.log('THIS.IMAGES.LENGTH, Start:', this.images.length); // Log current index
       console.log('THIS.IMAGES, Start:', this.images); // Log current index
       this.currentIndex = (this.currentIndex + 1) % this.images.length;
     }, this.images[this.currentIndex].duration);
   }

  saveImage(){
    var inputData = {
      url: this.url,
      duration: this.duration
    }
    console.log(inputData, 'inputData');
    this.imageService.saveImage(inputData).subscribe({
      next: (res: any) => {
        console.log(res, 'response');
        alert(res.message)
        this.url = '';
        this.duration = '';
        this.getImagesList();
      },
      error: (err: any) => {
        console.log(err, 'error');
      }
    });
  }

  deleteImage(event:any, imageId: string){
    if(confirm('Are your sure you want to delete this image?')){
      event.target.innerText = "Deleting ...";
      this.imageService.deleteImage(imageId).subscribe((res:any) => {
        this.getImagesList();
        alert(res.message);
        this.getImagesList();
      });
    }
  }

}

