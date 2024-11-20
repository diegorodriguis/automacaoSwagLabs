#language:pt

@carrinho @regressivos
Funcionalidade: Carrinho
  Testar funcionalidade de carrinho por completo

  @adicionarItem
  Esquema do Cenario: Teste de carrinho <identificacao>
    Quando os campos de login sejam preechidos da seguinte forma
      | login    | standard_user |
      | password | secret_sauce  |
    Quando for realizado o clique no botao sign in
    Entao deve ser logado no sistema
    E adiciono um item no carrinho
    E acesso ao carrinho pela pagina principal
    Entao valido item adicionado com sucesso

    Exemplos:
      | identificacao  |
      | adicionar item |

  @removerItem
  Esquema do Cenario: Teste de carrinho <identificacao>
    Quando os campos de login sejam preechidos da seguinte forma
      | login    | standard_user |
      | password | secret_sauce  |
    Quando for realizado o clique no botao sign in
    Entao deve ser logado no sistema
    E adiciono um item no carrinho
    E acesso ao carrinho pela pagina principal
    Entao valido item adicionado com sucesso
    E clico em remover do carrinho
    E valido carrinho vazio

    Exemplos:
      | identificacao |
      | remover item  |