# Course Application Backend

This is the backend application for a course application built using Spring Boot.

## Functionality

The following required functionality has been implemented:

- Users can add, delete, retrieve, and update all courses in the database.
- Users can add, delete, retrieve, and update all students in the database.
- Users can retrieve courses or students by searching with a partial name.
- Authentication and authorization have been implemented for both users and admins.


## Usage

To start the Spring Boot application, run the following command: 'mvn spring-boot:run'

Once the application is running, you can interact with the API endpoints using tools like Postman or cURL.

## API Endpoints

The following API endpoints are available:

- "GET/course/getall": Retrieve all courses.
- "GET/course/get/{id}": Retrieve a specific course by ID.
- "GET/course/add": Add a new course.
- "GET/course/update": Update a specific course by ID.
- "GET/course/delete/{id}": Delete a specific course by ID.

- "GET/stud/getall": Retrieve all students.
- "GET/stud/get/{id}": Retrieve a specific student by ID.
- "GET/stud/add": Add a new student.
- "GET/stud/update": Update a specific student by ID.
- "GET/course/delete/{id}": Delete a specific student by ID.

- "GET/course/namecont": Retrieve courses by searching with a partial name.
- "GET/course/des/cont": Retrieve courses by searching with part of the description.
- "GET/course/name/fac/cont": Retrieve courses by searching with name of faculty the enrolled student.
- "GET/course/namecont": Retrieve students by searching with a partial name.

Please note that authentication and authorization are required for certain endpoints. Refer to the API documentation for more details.

## Configuration

The following configuration details are required:

- Database configuration: Specify the database connection details in the "application.properties" file.
- Authentication and authorization: Configure the authentication and authorization settings in the "SecurityConfig.java" file.

## Contributing

Contributions to this project are welcome. If you have any suggestions or would like to report an issue, please open a new issue or submit a pull request.
