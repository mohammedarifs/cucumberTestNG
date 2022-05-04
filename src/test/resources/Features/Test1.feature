
@Test
Feature: Sample sign in

	@Test
  Scenario: Sign in to page
    Given Im sign in page
    When I enter user
    * I enter pass
    * I click login
    Then I verify message