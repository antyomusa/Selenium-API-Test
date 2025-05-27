@All
Feature: Para Bank Registration

  @ParabankPositive @positive @register
  Scenario: Successful Registration
    Given the user is on the ParaBank homepage
    When the user clicks the register link
    Then the user should be on the registration page
    When the user enters their name
    And the user enters their address details
    And the user enters a valid username and password
    And the user confirms the password
    And the user clicks the Register button
    Then the registration should be successful

  @ParabankNegative @negative @register
  Scenario: Failed Registration - Mismatched Password
    Given the user is on the ParaBank homepage
    When the user clicks the register link
    Then the user should be on the registration page
    When the user enters their name
    And the user enters their address details
    And the user enters a valid username and password
    And the user confirms the password incorrectly
    And the user clicks the Register button
    Then an error message should appear indicating that the passwords do not match