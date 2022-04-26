@tag
Feature: This Feature file include all possible scenarios related to Login functionality of Amazon.com

  @tag1
  Scenario Outline: Login with Valid Username and Password
    Given Launch "https://devexpress.github.io/testcafe/example/"
    Then verify the Welcome page appears
    When Click on Populate button
    And click on OK button on Confirmation pop up
    #Then Verify default name "Peter Parker" appeared on the page
    And select "<feature>" option on the page
    And select os as "<operating System>"
    And select Testcafe interface as "<interface>"

    Examples:
      |feature												|operating System |interface			|
      |Remote Access,Re-Using,Analysis                      |MacOS			  |JavaScript API	    |
