Feature: Flipkart Search Validation

  Scenario: Washing Machine Search
    Given User launches Flipkart website
    When User searches for Washing Machine and sorts by popularity
    Then Print count of items having rating less than or equal to 4 stars

  Scenario: iPhone Search
    Given User launches Flipkart website
    When User searches for iPhone
    Then Print title and discount percentage of items having more than 17 percent discount

  Scenario: Coffee Mug Search
    Given User launches Flipkart website
    When User searches for Coffee Mug and selects 4 stars and above
    Then Print title and image URL of top 5 products with highest reviews