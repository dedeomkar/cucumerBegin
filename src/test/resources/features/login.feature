Feature: User Login

  As a user
  I want to be able to log in to the website
  So that I can access my account

#Given: Sets up the initial situation. (e.g., "Given I am logged in.")
#When: Describes an action. (e.g., "When I click the 'Submit' button.")
#Then: Describes the expected outcome. (e.g., "Then I should see a success message.")
#And/But: Adds extra steps or exceptions.


  Scenario: Successful Login
    Given I am on the login page
    And Wait for 5000
    When I enter credentials "mblaze804@gmail.com" and "qwerqwer"
    And Wait for 2000
    And I click the login button
    And Wait for 5000
    Then I should be redirected to the dashboard
    And I should see a welcome message "mblaze804"
    Then close

  Scenario: Failed Login
    Given I am on the login page
    And Wait for 5000
    When I enter credentials "wronguser" and "wrongpassword"
    And Wait for 2000
    And I click the login button
    And Wait for 5000
    Then I should see an error message
    Then close
