import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Image } from './../domain/image';
import { ApiResponse } from './../domain/api-response'

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  public serverUrl: string = 'http://localhost:8081/api/v1';

  constructor(private http: HttpClient) {}


//     console.log(serverUrl);
//     images$ = (url: string = '', duration: string =''): Observable<ApiResponse<Image>> =>
//       return this.http.get<any>('${this.serverUrl}/images');

//     console.log(images$);



  getImages(): Observable<any>{
    return this.http.get<any>('http://localhost:8081/api/v1/images');
  }

  saveImage(inputData: object){
    return this.http.post('http://localhost:8081/api/v1/addImage', inputData);
  }

  deleteImage(id: string){
      return this.http.delete('http://localhost:8081/api/v1/deleteImage/'+ encodeURIComponent(id));
    }
}
