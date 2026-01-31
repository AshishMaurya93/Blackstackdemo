# Java Selenium Automation Framework

## Project Title
Automation Testing Framework for **bstackdemo.com** using **Java and Selenium**

---

## Project Overview
This project demonstrates an end-to-end **automation testing framework** for an e-commerce web application using **Java, Selenium WebDriver, TestNG, and Maven**.  
The framework follows the **Page Object Model (POM)** design pattern to ensure scalability, maintainability, and reusability.

---

## Application Under Test
- **Website:** https://bstackdemo.com/
- **Domain:** E-Commerce Web Application

---

## Project Objective
- Automate core functionalities of an e-commerce application  
- Implement industry-standard automation practices  
- Create a reusable and modular Selenium framework  
- Execute test cases using TestNG and Maven  

---

## Tools & Technologies
- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **WebDriverManager**
- **Git & GitHub**

---

## Framework Architecture
- **Design Pattern:** Page Object Model (POM)
- **Core Components:**
  - Base Test
  - Utility Classes
  - Page Object Classes
  - Test Classes
  - TestNG XML
  - Maven POM

---

## Project Structure
```text
src
├── main
│   └── java
│       ├── pages
│       │   ├── LoginPage.java
│       │   ├── ProductPage.java
│       │   ├── CartPage.java
│       │   └── CheckoutPage.java
│       └── utils
│           ├── ConfigReader.java
│           ├── WebDriverFactory.java
│           └── WaitUtils.java
|           └── ExtentManager.java
├── test
│   └── java
│       ├── base
│       │   └── BaseTest.java
│       └── tests
│           ├── LoginTest.java
│           ├── CartTest.java
│           └── CheckoutTest.java
├── testng.xml
└── pom.xml
```


## Test Scenarios Covered

   ## Login Tests

  TC_001: Login with valid credentials

  TC_002: Login with invalid credentials

  TC_003: Login with empty username and password

   ## Cart Tests

  TC_004: Add single product to cart

  TC_005: Add multiple products and verify cart count

  TC_006: Remove product from cart

   ## Checkout Tests

  TC_007: Place order with valid details

  TC_008: Attempt checkout without adding products (negative test)

## Test Execution

Run Tests Using Maven
mvn clean test
Run Tests Using TestNG
Right-click testng.xml

Select Run

## Reporting
TestNG default reports generated under test-output/

Framework supports integration with Extent Reports

## Version Control

Code managed using Git

Repository hosted on GitHub

Can be easily integrated with CI/CD tools like Jenkins

## Conclusion
This project showcases a complete Selenium automation testing framework suitable for college submission, practical exams, and real-world automation projects.

## Author
Ashish Maurya