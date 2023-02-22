Feature: Buscar um produto

  Scenario Outline: Busca por um produto existente
    Given um produto
    When busca por um "<produto>"
    Then acha um produto
    Examples:
      | produto  |
      | notebook |

  Scenario Outline: Busca por um produto inexistente
    Given um produto
    When busca por um "<produto>"
    Then não acha um produto
    Examples:
      | produto    |
      | clonazepam |

  Scenario Outline: Busca por um produto com termos invalidos
    Given um produto
    When busca por um "<produto>"
    Then não retorna resultados
    Examples:
      | produto |
      | !@#!@#  |

  Scenario Outline: Clicar em um produto da página de resultados
    Given um produto
    When busca por um "<produto>"
    And  clica no produto escolhido
    Then o sistema deve exibir a pagina do produto
    Examples:
      | produto  |
      | notebook |

  Scenario Outline: Busca com filtro de categoria
    Given um produto
    When busca por um "<produto>"
    And seleciona uma categoria
    Then os produtos da categoria devem ser exibidos
    Examples:
      | produto  |
      | notebook |
