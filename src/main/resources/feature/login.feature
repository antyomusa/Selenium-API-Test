@All
  Feature: Login

    @Test1 @Positive @Login
    Scenario: Login
      Given The user is on login page
      When The user fill username and password
      And The user click login button
      Then User verify login result

    @Test2 @Negative @Login
    Scenario: Login
      Given The user is on login page
      When The user fill invalid username and password
      And The user click login button
      Then User get error message