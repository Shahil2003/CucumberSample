Feature: Login Feature

  Scenario: Verify Admin can login using valid username and Password
    Given I open the OrangeHRM login page
    When I enter username "Admin" and password "admin123"
    And I click the login button
    Then I should see the dashboard page with title "Dashboard"

  Scenario: Verify Admin login with valid username and invalid password
    Given I open the OrangeHRM login page
    When I enter username "Admin" and password "wrongpassword"
    And I click the login button
    Then I should see an error message "Invalid credentials"

  Scenario: Verify login with enter Blank username and valid password
    Given I open the OrangeHRM login page
    When I enter username "" and password "admin123"
    And I click the login button
    Then I should see another error message "Required"
