# API Testing Practice Project

API testing project built using Apache JMeter for functional testing (authentication, CRUD operations, negative scenarios) and basic load testing by simulating concurrent users.

---

## 📌 Overview

This project focuses on testing a REST API by covering the full contact management lifecycle, including authentication, data validation, negative scenarios, and basic load testing to evaluate API behavior under concurrent usage.

---

## 🔁 Test Flow
1. User logs in and receives an authentication token
2. Token is used for authorized requests
3. CRUD operations are executed on contacts
4. Negative scenarios validate input handling and error responses

---

## 🔧 Technologies Used

* Apache JMeter
* REST API
* JSON

---

## ✅ Test Coverage

### 1. Authentication

* Login (valid credentials)
* Login with missing credentials
* Login with missing password
* Login with incorrect username or password

---

### 2. Contact Management (CRUD)

* Add Contact
* Get Contacts
* Edit Contact
* Delete Contact

---

### 3. Negative Scenarios – Add Contact

#### Required Fields Validation

* Add Contact without firstName
* Add Contact without lastName
* Add Contact without firstName and lastName

#### Boundary Value Analysis

* Add Contact with firstName and lastName longer than 20 characters

#### Date of Birth Validation

* Invalid format (dd-mm-yyyy)
* Invalid month (yyyy-13-dd)
* Invalid date (yyyy-12-32)
* Invalid February date (2025-02-29)
* Future date of birth
* Non-numeric characters in DOB

#### Email Validation

* Invalid email format
* Invalid email (test@aa.)

#### Phone Validation

* Invalid phone length
* Phone number containing characters

---
## ⚡ Load Testing

Basic load testing was performed using JMeter Thread Groups to simulate multiple concurrent users.

* Configured multiple threads (virtual users)
* Simulated concurrent API requests
* Observed API behavior under load conditions
* Validated response stability and consistency

## 📂 Test Data

Test data is managed using CSV Data Set Config elements in JMeter.

The project uses external CSV files (located in the `testdata` folder) to support data-driven testing for:

* Valid and invalid inputs
* Boundary values
* Negative test scenarios

Ensure the file paths are correctly configured when running the tests locally.

---

## 📚 What I Learned

* Working with REST APIs
* Handling authentication tokens (Bearer Token)
* Writing effective assertions in JMeter
* Designing negative test scenarios
* Applying boundary value analysis
* Using data-driven testing with CSV files
* Performing basic load testing using JMeter
* Simulating concurrent users with Thread Groups

---

## 🐞 Known Issues (Bugs Identified)

* API accepts invalid future birthdate instead of returning a validation error
* API does not return the expected error message for incorrect login credentials

---

## 💡 Key Skills Demonstrated

* REST API Testing
* JMeter
* Functional Testing
* Negative Testing
* Boundary Value Analysis
* Data-Driven Testing
* Basic Load Testing
* Response Validation

## 🚀 Notes

This project is part of my QA portfolio and demonstrates my understanding of API testing fundamentals.

---

## ▶️ How to Run

1. Open the project in JMeter
2. Configure base URL if needed
3. Ensure CSV file paths are correctly set
4. Run the Thread Group
