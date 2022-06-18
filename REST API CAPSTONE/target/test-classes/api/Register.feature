Feature: As a user on register page

  Scenario: User register with valid data
    Given user post regist endpoint1
    When user regist using valid data
    Then user succes regist respon 200 OK on regist 1
    And user get a message proses register berhasil

