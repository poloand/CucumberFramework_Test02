 # API tests for following site: https://demo.guru99.com/
  Feature: Requests tests

  #Background: opening one URL for all tests
  #  Given user opens the next URL "https://demo.guru99.com/V1/index.php"

  Scenario Outline: 01 - sending request, receiving status code
    Given user sends "GET" request to URL "http://httpbin.org/status/"
    Then check status code is <code>

    Examples:
      | code   |
      | "200"  |
