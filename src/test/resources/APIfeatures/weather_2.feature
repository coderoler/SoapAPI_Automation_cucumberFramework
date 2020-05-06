@test001
Feature: this is test for create product
  I want to use this template for my feature file

  
  Scenario Outline: Test for SOAP API
    Given I send "getDomesticAirlinesTime" request to get response with param datatable
      | key    | value     |
      | itemID | <item_ID> |
    Then the error massage should equls <err_message>

    Examples: 
      | item_ID | product_name | err_message |
      | 2321434 | cvckjsafesjf |             |
  		#| 3$^&%$&^% | &(*&(&**(    |           |
  		#| 下即可佛教    | 十大算法的方式    |           |
 
  @test002		
  Scenario Outline: Test for SOAP API
    Given I send "getDomesticAirlinesTime" request to get response with param datatable
      | key    | value     |
      | itemID | <item_ID> |
    Then the error massage should equls <err_message>

    Examples: 
      | item_ID | product_name | err_message |
      | 2321434 | cvckjsafesjf |             |
