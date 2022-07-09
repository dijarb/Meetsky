@logout
Feature: Logout Functionality
  User Story :
  As a user, I should be able to log out.

  Acceptance Criteria:
  1-User can log out and ends up in login page
  2-User can not go to home page again by clicking step back button after successfully logged out.

  Background: User is logged in
    Given User is logged in

  @METSK-420
  Scenario: user logs out
    When user clicks on profile icon
    And user clicks logout button
    Then User is in login page

  @METSK-423
  Scenario: user tries to go to home page again by clicking step back button after successfully logged out
    When user clicks on profile icon
    And user clicks logout button
    Then User is in login page
    And User clicks step back button
    Then User is in login page
