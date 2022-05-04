Create Database Student;

-- Type
    CREATE TYPE GENDER AS ENUM('FEMALE', 'MALE','OTHER');

--student
Create Table student(
  id BIGINT NOT NULL,
  name varchar(30) NOT NULL,
  dob DATE NOT NULL,
  gender GENDER NOT NULL,
  email varchar(255),
  address varchar(512),
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);




