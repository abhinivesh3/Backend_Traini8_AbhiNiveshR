# Backend_Traini8_AbhiNiveshR

# Project Setup Instructions

## Prerequisites
 > Java version 17
 > Maven 3.9.6

## Installation
 > Ensure that Java version 17 is installed on your system. You can download it here.
 > Install Maven version 3.9.6. You can download it here.
 > Clone this repository to your local machine.

## Running the Project
 . Navigate to the project directory.
 . Execute the following command to build the project:
          mvn clean install
 . Once the build is successful, you can run the project using:
   bash
          mvn exec:java


# First API: Create Training Center
## Description
This API creates and saves a new training center with the provided information.

Endpoint

POST /training-center/create
Request Body
json
{
  "centerName": "Example Training Center",
  "centerCode": "ABC123456DEF",
  "address": {
    "detailedAddress": "123 Example Street",
    "city": "Example City",
    "state": "Example State",
    "pincode": "123456"
  },
  "studentCapacity": 100,
  "coursesOffered": ["Course 1", "Course 2"],
  "contactEmail": "example@example.com",
  "contactPhone": "1234567890"
}
Response
Status Code: 201 (Created)
Content-Type: application/json
json
Copy code
{
  "id": "1",
  "centerName": "Example Training Center",
  "centerCode": "ABC123456DEF",
  "address": {
    "detailedAddress": "123 Example Street",
    "city": "Example City",
    "state": "Example State",
    "pincode": "123456"
  },
  "studentCapacity": 100,
  "coursesOffered": ["Course 1", "Course 2"],
  "createdOn": "28/04/2024 12:34:45",
  "contactEmail": "example@example.com",
  "contactPhone": "1234567890"
}

# Second API: Get All Training Centers
## Description
This API retrieves a list of all stored training centers.

Endpoint
GET /training-center/getAll
Response
Status Code: 200 (OK)
Content-Type: application/json
json
[
  {
    "id": "1",
    "centerName": "Example Training Center",
    "centerCode": "ABC123456DEF",
    "address": {
      "detailedAddress": "123 Example Street",
      "city": "Example City",
      "state": "Example State",
      "pincode": "123456"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Course 1", "Course 2"],
    "createdOn": "28/04/2024 12:34:45",
    "contactEmail": "example@example.com",
    "contactPhone": "1234567890"
  },
  {
    "id": "2",
    "centerName": "Second Training Center",
    ...
  },
  ...
]

Empty Response
If there are no training centers stored:

json
[]
