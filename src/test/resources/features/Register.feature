# Cucumber Framework to test the registration form for following site: https://demo.guru99.com/
  Feature: check registration form

  Scenario: 01 - validation check login-password
    Given user opens the next URL "https://demo.guru99.com/V1/index.php"
    And user enters "Login" as "mngr484758"
    And user enters "Password" as "bApAvYh"
    And user clicked the button "btnLogin"
    Then URL is "https://demo.guru99.com/V1/html/Managerhomepage.php"


  Scenario: 02 - check RESET button resets Login and Password
    Given user opens the next URL "https://demo.guru99.com/V1/index.php"
    And user enters "Login" as "mngr484758"
    And user enters "Password" as "bApAvYh"
    And user clicked the button "btnReset"
    Then check login and password fields are empty
    And field "Login" is empty
    And field "Password" is empty
    And URL is "https://demo.guru99.com/V1/index.php"
