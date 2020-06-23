Feature: Loggin into Application

  Scenario Outline: Positive test validating login
    Given Initialize the browser with chrome
    And Navigate to "http://qaclickacademy.com/" Site
    And Click on Login link in home page to land on Secure sign in Page
    When User enter <username> and <password> and logs in
    Then Verify that User is successfully logged in
    Examples:
      |username        |password|
      |test99@gmail.com|123456  |
      |test98@gmail.com|654321  |
