@All
Feature: Login TDD

  @TDD
  Scenario Outline: Login with TDD
    Given The user is on login page tdd
    When The user fill <username> and <password> tdd
    And The user click login button tdd
    Then User verify login <result> tdd

  Examples:
    | username | password | result |
    | standard_user | secret_sauce | Passed |
    | invalid_user  | secret_sauce | Failed |
    | standard_user | invalid_sauce | Failed |
