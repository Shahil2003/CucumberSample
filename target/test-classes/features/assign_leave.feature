Feature: Verify Assign Leave Button Navigation
  Validate that clicking the Assign Leave button navigates to the Assign Leave page.

  Scenario: Validate navigation to Assign Leave page
    Given I am logged in as an admin on the OrangeHRM dashboard
    When I click on the Assign Leave button
    Then I should be navigated to the Assign Leave page with URL "https://opensource-demo.orangehrmlive.com/web/index.php/leave/assignLeave"
