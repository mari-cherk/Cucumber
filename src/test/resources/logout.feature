Feature: Logout the site

  Scenario Outline: Logout using the config dropdown menu

    Given I am on the Login page
    When I enter "<username>" and "<password>"
    And I click Sign in button
    Then I should go to Dashboard page
    Then Logout the site

    Examples:
      | username | password |
      | hr.doctor@hospitalrun.io | HRt3st12 |
   #   | hr.nurse@hospitalrun.io | HRt3st12 |
    #  | hr.nurse.manager@hospitalrun.io | HRt3st12 |