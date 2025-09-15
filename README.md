# Kubra_Ete_Case
Test automation project: Includes API, UI and performance testing

# Insider UI Automation (Java + Selenium + POM)

Automated UI tests for Insider website using **Java**, **Selenium**, and **Page Object Model (POM)**.  
Tests are designed to validate the careers flow, including filtering QA jobs by location and department.

---

## Overview

This project automates the following UI test scenarios:

1. Open [Insider homepage](https://useinsider.com/) and verify the page is loaded.  
2. Navigate to **Company > Careers**, and check that **Career page** blocks (Locations, Teams, Life at Insider) are visible.  
3. Visit [Quality Assurance Careers page](https://useinsider.com/careers/quality-assurance/), click **See all QA jobs**, filter by:
   - Location: `Istanbul, Turkey`  
   - Department: `Quality Assurance`  
   Verify that the job list is displayed.  
4. Validate that all listed jobs contain:
   - Position: `Quality Assurance`  
   - Department: `Quality Assurance`  
   - Location: `Istanbul, Turkey`  
5. Click **View Role** and verify redirection to the Lever Application form page.

   # Petstore API Automation (Java + Rest-Assured)

Automated API tests for [Petstore Swagger](https://petstore.swagger.io/) endpoints using **Java** and **Rest-Assured**.  
Tests cover **CRUD operations** with **positive** and **negative** scenarios.

---

## Overview

This project automates the following API test scenarios:

1. **Create a Pet**  
   - Positive: Valid JSON payload  
   - Negative: Missing required fields / invalid type  

2. **Read a Pet**  
   - Positive: Retrieve an existing pet by ID  
   - Negative: Retrieve a non-existing pet ID  

3. **Update a Pet**  
   - Positive: Update pet details with valid payload  
   - Negative: Update pet with invalid ID or invalid payload  

4. **Delete a Pet**  
   - Positive: Delete an existing pet by ID  
   - Negative: Delete a non-existing pet ID

 ## 3. Load Test (JMeter)

**Website:** [N11.com Header Search](https://www.n11.com/)  

### Scenario

- Test the **search module** behavior on the homepage header.  
- List the results after performing a search.  
- Single-user scenario to validate response and performance.

## Technologies & Tools

| Test Type      | Technology / Tool          | Description                                         |
|----------------|---------------------------|-----------------------------------------------------|
| UI Automation  | Java + Selenium           | Browser automation using POM and TestNG            |
| UI Automation  | TestNG                    | Test framework for assertions, grouping, and reports |
| UI Automation  | Chrome / Firefox          | Cross-browser testing (browser parameterizable)   |
| API Automation | Java + Rest-Assured       | API testing for CRUD operations on Petstore       |
| API Automation | TestNG                    | Assertions, grouping, and reporting               |
| Load Testing   | Apache JMeter             | Load and performance testing of N11 search module |
| Load Testing   | .jmx scripts              | JMeter test plan files                             |
| Build & Config | Maven                     | Project build and dependency management           |


