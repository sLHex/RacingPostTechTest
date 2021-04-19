$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./features/RacingPostTechnicalTest.feature");
formatter.feature({
  "name": "Testing big race events",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@RacingPost"
    }
  ]
});
formatter.scenario({
  "name": "That the first event date is in the future",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RacingPost"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on “https://www.racingpost.com/racecards/”",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.i_am_on_https_www_racingpost_com_racecards()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the “Big Race Entries” header",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.i_click_the_Big_Race_Entries_header()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The date of the next big race event is in the future",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.the_date_of_the_next_big_race_event_is_in_the_future()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Today\u0027s offers is being displayed",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RacingPost"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on “https://www.racingpost.com/racecards/”",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.i_am_on_https_www_racingpost_com_racecards()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the “Big Race Entries” header",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.i_click_the_Big_Race_Entries_header()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see today\u0027s offers",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_see_today_s_offers()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});