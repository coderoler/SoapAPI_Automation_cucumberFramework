Feature: this is test for create product
  I want to use this template for my feature file

#Background:
#	Given initialize webDriver
#	Then Login <user> to WMS web page

  Scenario Outline: [Create product] create product with target value
    Given I send "createProduct" request to get response with param datatable
      | key    | value     |
      | itemID | <item_ID> |

    Examples: 
      | item_ID | product_name | err_message |
      | 2321434 | cvckjsafesjf |             |

  Scenario Outline: Test for SOAP API
    Given I send "getDomesticAirlinesTime" request to get response with param datatable
      | key    | value     |
      | itemID | <item_ID> |

    #    Then the error massage should equls <err_message>
    Examples: 
      | item_ID | product_name | err_message |
      | 2321434 | cvckjsafesjf |             |

  Scenario Outline: [Create product] create product with target value
    When load <fileName> xml templete
    Then update node under <parentNode> with data table as below
      | nodeKey        | value            |
      | updateType     | <type>           |
      | storeProductCd | <storeProductCd> |
    Then send create <APIFunction> request

    Examples: 
      | type | storeProductCd |
      |    1 |   202006102130 |

  Scenario Outline: [Create product] create complex product with target value
    When load <fileName> xml templete
    Then update node under <parentNode> with data table as below
      | nodeKey        | value            |
      | updateType     | <type>           |
      | storeProductCd | <storeProductCd> |
    Then use <nodeListFile> to add <nodeList> under <parentNode> with value as data table 
      | nodeKey         | value             |
      | updateType      | <type>            |
      | commonProductCd | <commonProductCd> |
    # 这个再写一遍就是再加一个list  
    Then use <nodeListFile> to add <nodeList> under <parentNode> with value as data table 
      | nodeKey         | value             |
      | updateType      | <type>            |
      | commonProductCd | <commonProductCd> |
    Then send create <APIFunction> request

    Examples: 
      | type | storeProductCd | commonProductCd |
      |    1 |   202006102130 |    202006102130 |
