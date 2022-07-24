# Internship-Student-CRUD
A  Spring Boot  Rest API project that manages a collection of operations with the basic feature: fetch, save, update, delete (CRUD operations - Create, Read, Update and Delete).Demonstrating CRUD API with SpringBoot
* **Method:**

`GET`| `POST` | `DELETE` | `PUT`

* **URL**
  
    - `GET` : /students 
    - `GET` : /students/{id}
    - `POST` : /students
    - `PUT` : students/{id}
    - `DELETE` : /students/{id}


   * **URL Params**

     - **Required:**

        - `id=[integer]`

### STATUS CODE :
* **Success Response:**
  * **Code:** 200 <br />
    * **Content:** `{ id : 12 }`
    
---
* **Error Response:**
  * **Code:** 401 UNAUTHORIZED <br />
    * **Content:** `{ error : "Log in" }`
    
  OR
  * **Code:** 422 UNPROCESSABLE ENTRY <br />
    * **Content:** `{ error : "Email Invalid" }`
