 PickBazar Test Automation

 📌 Project Overview
This project is created to automatically test the web interface of the PickBazar e-commerce platform. Manual test steps have been automated and a structured test framework has been built. (https://shop.clarusway.net/)

![image](https://github.com/user-attachments/assets/ad2c9a70-0991-4321-9e8b-08db37cf4f70)


 🧰 Libraries and Frameworks

- **Selenium** – Web automation framework for simulating user interactions in browsers.
- **Maven** – Project build and dependency management.
- **TestNG** – Test execution, grouping, prioritization, and reporting.
- **Log4J** – Logging test steps and results.

![image](https://github.com/user-attachments/assets/152d94c5-dc30-4c41-9c7c-0276013e5ade)

 🛠 Tools Used

- IDE: IntelliJ IDEA
- Reporting: Allure Report (for test methods)
- Logging: Log4j (for page classes) 

 ![image](https://github.com/user-attachments/assets/19cebbf7-7b99-489f-9899-d772c50636a9)
 ![image](https://github.com/user-attachments/assets/d68c2dfb-7f08-414a-9d33-dd3cd70373bb)

 ✅ Key Features

- Automated tests for various user journeys
- Clear reporting and logging for debugging
- Scalable and maintainable structure following Page Object Model
- Parallel test execution using TestNG

  ![image](https://github.com/user-attachments/assets/9ac606e5-6a93-43cf-96a4-beacc700d084)

 🚀 How to Run

1. Clone the repository.
2. Open the project with IntelliJ IDEA.
3. Execute test cases using Maven or TestNG.
4. View test results via Allure Report.


 📄 Folder Structure

![image](https://github.com/user-attachments/assets/9c72c371-5995-4077-8541-6f00a2d4ed59)


📜 Pages Package Structure

- AllPages Class easies access to all page classes to be used during testing from a single place
- This structure guanties each page created as a singleton instance
  ![image](https://github.com/user-attachments/assets/5f5dccd3-b2ae-4421-a3be-b2aca2dafc9b)

- Used Logger interface for logging each action step within methods
- Implemented Page Object Model (POM) with PageFactory and @FindBy annotations to locate and initialize web elements efficiently.
- Encapsulated all the WebElements as private members
- Provided public getter methods for controlled access to elements when needed in test classes
- Called methods from utilites package -> ex. clickElement() , isWebElementDisplayed()  to reduce duplication
![image](https://github.com/user-attachments/assets/b9441555-fb0f-4b09-82ec-020e8f2e1ef4)
![image](https://github.com/user-attachments/assets/760f5ebb-e9a2-46dc-b7cc-27c8a8a9b93b)
![image](https://github.com/user-attachments/assets/d52d3f04-4d54-41cf-b6eb-db634aa3841e)
![image](https://github.com/user-attachments/assets/4f5da15b-0d69-4c4c-9a28-a6dbba402845)


📜 Test Package Structure

- Each page has its own test class, a test class has multiple test methods for each test case
- Followed a consistent structure as a startup in eact test method
- Applied Allure annotaions to imporve reporting quality and provide detailed reports 
      @Feature, @Story, @Owner, @Severity, @description
- Included Groups for grouped test executions by .xml files
- Utilized SoftAssert, to enable multiple assertion within a single test
  
  ![image](https://github.com/user-attachments/assets/fe791725-d391-4a26-af99-072626aff10b)


📜 An example Test Flow  ( TC_018_01)

- The browser is launched (Chrome/Firefox, controlled via ITestContext)
- The user is navigated to the specified URL
- The necessary pages are accessed through the AllPages object
- A product is added to the basket on the product page
- The basket is opened, and it is checked whether the product is in the basket
- Validation is performed using SoftAssert

![image](https://github.com/user-attachments/assets/ca380005-f52f-403e-bf69-0a2aa4513cc3)



📜 Utilites Package Structure

-

