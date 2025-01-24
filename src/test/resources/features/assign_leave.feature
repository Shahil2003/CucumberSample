Feature: Verify Assign Leave Button Navigation
  Validate that clicking the Assign Leave button navigates to the Assign Leave page.

  Scenario: Validate navigation to Assign Leave page
    Given I am logged in as an admin on the OrangeHRM dashboard
    When I click on the Assign Leave button
    Then I should be navigated to the Assign Leave page with URL "https://opensource-demo.orangehrmlive.com/web/index.php/leave/assignLeave"

  Scenario: User enters an invalid employee name and gets Invalid message
    Given I am logged in as an admin on the OrangeHRM dashboard
    When I click on the Assign Leave button
    And the user enters "sreevidhya" as the employee name in the text box
    Then the input field should highlight the "Invalid" error in red color