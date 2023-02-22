INPUT & OUTPUT
==============

**END POINTS**

- [GET] http://localhost:8080/api

    *Public URL - Welcome message*
    ##
    
- [GET] http://localhost:8080/api/student/1

    *Get details of all students*
    ##
    
- [GET] http://localhost:8080/api/students
 
   *Get details of student with id 1*
    ##

- [POST] http://localhost:8080/api/student

   *Add a new student*
    
    
    In Request body, use below sample object.
    
      {
          "name": "Zacky",
          "age": 21,
          "username": "zachy",
          "password": "123",
          "address": {
              "house_no": "ZX35F",
              "street": "Marshal st",
              "city": "NYC",
              "pincode": "NY004"
          },
          "courses": [
              {
                  "course_name": "Communication - English",
                  "course_duration": "120 mins"
              }
          ]
      }
      
     ##

- [PUT] http://localhost:8080/api/student/1
- [DELETE] http://localhost:8080/api/student/1
- [POST] http://localhost:8080/api/student/1/add-course
- [GET] http://localhost:8080/api/student/1/remove-course/2

