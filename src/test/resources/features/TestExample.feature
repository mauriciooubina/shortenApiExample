Feature: Api example
  As an api user I want to execute request in order to get proper responses

  @Test
  Scenario Outline: Example scenarios OK
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonRequestName>' and ''
    Then I will get the proper status code '<statusCode>'
    And I will get the proper response in Shorten with json '<jsonResponseName>'

    Examples:
      | jsonRequestName | statusCode | operation | entity  | jsonResponseName |
      | shorten         | 200        | POST      | SHORTEN | shorten          |

  @Test
  Scenario Outline: Example Error scenarios
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonRequestName>' and ''
    Then I will get the proper status code '<statusCode>'
    And I will get the error response in Shorten with json '<jsonResponseName>'

    Examples:
      | jsonRequestName     | statusCode | operation | entity              | jsonResponseName    |
      | shortenInvalidUrl   | 400        | POST      | SHORTEN_ERROR       | shortenInvalidUrl   |
      | shortenEmptyBody    | 400        | POST      | SHORTEN_ERROR       | shortenEmptyBody    |

