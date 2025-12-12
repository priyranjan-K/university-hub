# university-hub
university related crud operation

development still is in progress

request:--

{
  "universityCode": "U01",
  "addresses": [
    {
      "houseNumber": "123",
      "addressLine1": "Main Campus",
      "city": "University City",
      "state": "State",
      "zipCode": "10001",
      "country": "USA",
      "addressType": "OFFICE"
    }
  ],
  "colleges": [
    {
      "collegeCode": "ENG",
      "collegeName": "College of Engineering",
      "status": {
        "statusCode": "ACTIVE",
        "statusReason": "Operational"
      },
      "addresses": [
        {
          "houseNumber": "456",
          "addressLine1": "Engineering Building",
          "city": "University City",
          "state": "State",
          "zipCode": "10002",
          "country": "USA",
          "addressType": "OFFICE"
        }
      ],
      "departments": [
        {
          "branches": [
            {
              "branchName": "Computer Science",
              "branchCode": "CS",
              "sections": [
                {
                  "sectionName": "A",
                  "students": [
                    {
                      "name": "Jane Doe",
                      "email": "jane.doe@example.com",
                      "gender": "Female",
                      "dateOfBirth": "2002-05-15",
                      "admissionDate": "2023-09-01",
                      "mobileNumber": "123-456-7890",
                      "address": {
                        "houseNumber": "789",
                        "addressLine1": "Student Dorms",
                        "city": "University City",
                        "state": "State",
                        "zipCode": "10003",
                        "country": "USA",
                        "addressType": "HOME"
                      },
                      "reportCard": {
                        "semester": "I",
                        "marks": "85%",
                        "reportCardStatus": "PASS"
                      }
                    }
                  ],
                  "faculties": [
                    {
                      "facultyName": "Dr. Alan Turing",
                      "majorName": "Theory of Computation",
                      "joiningDate": "1995-08-20"
                    }
                  ]
                }
              ],
              "faculty": [
                {
                  "facultyName": "Dr. Ada Lovelace",
                  "majorName": "Algorithms",
                  "joiningDate": "2005-01-10"
                }
              ]
            }
          ]
        }
      ]
    }
  ]
}
