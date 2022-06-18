Feature: As a user on login page

  Scenario: User input valid email and password
    Given user post login endpoints
    When user login with valid email and valid password
    Then user succes login respon 200 OK on login 1
    And user receive valid token
