INPUT & OUTPUT
==============

**CREDENTIALS** john - 123

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
    
    
    In Request body - sample input object.
    
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

   *Update a student* 
    
    In Request body - sample input object.
    
       {
          "name": "Zack",
          "age": 21,
          "username": "zach",
          "password": "123",
          "address": {
              "house_no": "ZX35F",
              "street": "Marshal st",
              "city": "NYC",
              "pincode": "NY004"
          }
        }
     ##


- [DELETE] http://localhost:8080/api/student/1

   *Delete the student with id 1*
    ##

- [POST] http://localhost:8080/api/student/1/add-course

   *Add a course to the student with id 1* 
    
    In Request body - sample input object.
    
       {
         "course_name": "Java",
         "course_duration": "340 mins"
       }
     ##

- [GET] http://localhost:8080/api/student/1/remove-course/2

   *Remove the course with id 2 from the student with id 1*
    ##

