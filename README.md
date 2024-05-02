# imageUrl

The current project shows how to create a simple web application that allows users to maintain a list of image URLs and play a slideshow with crossfade transitions.

1. **Frontend Part:**
   - Develop a UI application using Angular.
   - UI features
      - manage list of images. Each image includes URL and duration stored in DB.
      - play a slideshow of added images

2. **Backend Part:**
   - Create a Java Spring Boot application and implement a RESTful APIs for UI mentioned above.
   - Examples of proposed RESTful APIs:
      - `/addImage`: Add a new image URL, including proposed duration.
      - `/deleteImage/{id}`: Delete an existing image URL.
      - `/images`: Retrieve a list of image URLs and their durations.

3. **Database:**
   - Use a relational database (e.g., MySQL, PostgreSQL) to store project data, or in-memory database (e.g., H2).


You can find more details in the README files of the respective folders.
