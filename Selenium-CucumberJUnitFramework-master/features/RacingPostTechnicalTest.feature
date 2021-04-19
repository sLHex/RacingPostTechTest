@RacingPost
Feature: Testing big race events
  Scenario: That the first event date is in the future
    Given I am on “https://www.racingpost.com/racecards/”
    When I click the “Big Race Entries” header
    Then The date of the next big race event is in the future


  Scenario: Check Today's offers is being displayed
    Given I am on “https://www.racingpost.com/racecards/”
    When I click the “Big Race Entries” header
    Then I see today's offers
