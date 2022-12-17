@test
Feature: Verify Home Page is Opened


  @test
  Scenario: Verify Home Page is Opened
    Given  User Opens Home Page
    When User Search For Item "mazda mx-5"
    And Print Search Count
    Then Verify Search Result For "mazda mx-5"

