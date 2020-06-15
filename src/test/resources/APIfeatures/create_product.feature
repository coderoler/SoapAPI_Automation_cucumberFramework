Feature: Title of your feature
  I want to use this template for my feature file

  Background: 
    Given open web page

  Scenario Outline: [Create product] create product with target value
    When load "createProduct" xml template
    Then update node under "packingModeList" with data table as below
      | nodeKey        | value            |
      | updateType     | <type>           |
      | storeProductCd | <storeProductCd> |

    Examples: 
      | type | storeProductCd |
      |    1 |   202006102130 |

  @test001
  Scenario Outline: [Create product] create complex product with target value
    When load "createProduct" xml template
    Then update node under "packingModeList" with data table as below
      | nodeKey        | value            |
      | updateType     |                1 |
      | storeProductCd | 1111111111111111 |
    Then load "productModelList" xml template to prapre complex data modelList
    Then add "productModelList" under "arg0" with value as data table
      | nodeKey         | value |
      | updateType      |     2 |
      | commonProductCd |       |
    Then add "productModelList" under "arg0/packingModeList" with value as data table
      | nodeKey         | value             |
      | updateType      |                 3 |
      | commonProductCd | 33333333333333333 |
    Then send "createProduct" request

    Examples: 
      | type | storeProductCd |
      |    1 |   202006102130 |
      |    1 |   202006102130 |
