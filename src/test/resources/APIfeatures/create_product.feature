Feature: Title of your feature
  I want to use this template for my feature file

  
  Scenario Outline: [Create product] create product with target value
    When load "createProduct" xml template
    Then update node under "packingModeList" with data table as below
      | nodeKey        | value            |
      | updateType     | <type>           |
      | storeProductCd | <storeProductCd> |
    Then send create <APIFunction> request

    Examples: 
      | type | storeProductCd |
      |    1 |   202006102130 |

  @test001
  Scenario Outline: [Create product] create complex product with target value
    When load "createProduct" xml template
    Then update node under "packingModeList" with data table as below
      | nodeKey        | value            |
      | updateType     | 1                |
      | storeProductCd | 1111111111111111 |
    Then load "productModelList" xml template to prapre complex data modelList
    Then add "productModelList" under "arg0" with value as data table
      | nodeKey         | value             |
      | updateType      | 2                 |
      | commonProductCd | 22222222222222222 |
    # 这个再写一遍就是再加一个list
    Then add "productModelList" under "arg0" with value as data table
      | nodeKey         | value             |
      | updateType      | 3                 |
      | commonProductCd | 33333333333333333 |
    #Then send create <APIFunction> request

    Examples: 
      | type | storeProductCd | commonProductCd |
      |    1 |   202006102130 |    202006102130 |
