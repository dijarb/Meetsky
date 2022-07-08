@login
  Feature: Login Functionality
    User Story :
    As a user, I should be able to login.

    Acceptance Criteria:
    1-User can login with valid credentials
    2-User can not login with any invalid credentials
    -"Wrong username or password." should be displayed for invalid credentials
    -"Please fill out this field" message should be displayed if the password or username is empty
    3-User can see the password in a form of dots by default
    4-User can see the password explicitly if needed
    5-User can see the "Forgot password?" link on the login page and can see the "Reset Password" button on the next page after clicking on forget password link
    6-User can see valid placeholders on Username and Password fields

  Background: User should be in login page
    Given User is in login page

    @METSK-403
    Scenario: Login with valid credentials by clicking login button
      When user enters valid credentials
      And user clicks login button
      Then user can see dashboard page
      Then username is under profile icon

    @METSK-406
    Scenario: Login with valid credentials by pressing Enter Key
      When user enters valid credentials
      And user presses Enter Key
      Then user can see dashboard page
      And username is under profile icon

    @METSK-409
    Scenario: Login with incorrect credentials
      When user enters invalid credentials
      And user presses Enter Key
      Then Wrong username or password message is displayed
      Given browser is restarted
      And username and password boxes are empty
      When user enters valid username
      And user enters invalid password
      And user presses Enter Key
      Then Wrong username or password message is displayed
      Given browser is restarted
      And username and password boxes are empty
      When user enters invalid username
      And user enters valid password
      And user presses Enter Key
      Then Wrong username or password message is displayed

    @METSK-410
    Scenario: Login with missing credentials
      Given username and password boxes are empty
      When user presses Enter Key
      Then Please fill out this field message is displayed on username box

    @METSK-411
    Scenario: Login with missing password
      Given username and password boxes are empty
      When user enters valid username
      And user presses Enter Key
      Then Please fill out this field message is displayed on password box

    @METSK-412
    Scenario: Login with missing username
      Given username and password boxes are empty
      When user enters valid password
      And user presses Enter Key
      Then Please fill out this field message is displayed on username box

    @METSK-413
    Scenario: User can see password in form of dots
      When user enters valid password
      Then user can see password in form of dots

    @METSK-414
    Scenario: User can see password explicitly
      When user enters valid password
      And user clicks on the eye sign
      Then user can see password explicitly

    @METSK-415
    Scenario: User can see the "Forgot password?" link on the login page and can see
    the "Reset Password" button on the next page after clicking on forget password link
      Given user can see Forgot password? link
      And user clicks on Forgot password? link
      Then user can see Reset password text on the next page

    @METSK-416
    Scenario: User can see valid placeholders on Username and Password fields
      Given username and password boxes are empty
      Then user can see valid placeholders on Username and Password fields