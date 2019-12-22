Feature: We are testing weather API
  Scenario: Weather check
    Given city is: London
    When we are requesting weather
    Then lon is -0.13
    And lat is 51.51