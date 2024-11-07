#language:pt

@login @regressivos
Funcionalidade: Login
  Testar funcionalidade de login por completo

  @loginComSucesso
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preechidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
    Quando for realizado o clique no botao sign in
    Entao deve ser logado no sistema

    Exemplos:
      | identificacao       | login         | password     |
      | campos obrigatorios | standard_user | secret_sauce |

  @dadosEmBranco
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preechidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
    Quando for realizado o clique no botao sign in
    Entao valido alert de dados em branco

    Exemplos:
      | identificacao            | login         | password     |
      | campos em brancos        |               |              |
      | campo username em branco |               | secret_sauce |

  @passwordEmBranco
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preechidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
    Quando for realizado o clique no botao sign in
    Entao valido alert de password em branco

    Exemplos:
      | identificacao            | login         | password     |
      | campo password em branco | standard_user |              |

  @usuarioBloqueado
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preechidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
    Quando for realizado o clique no botao sign in
    Entao valido alert de usuario bloqueado

    Exemplos:
      | identificacao     | login           | password     |
      | usuario bloqueado | locked_out_user | secret_sauce |

  @usuarioBugado
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preechidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
    Quando for realizado o clique no botao sign in
    Entao deve ser logado no sistema

    Exemplos:
      | identificacao   | login        | password     |
      | usuario com bug | problem_user | secret_sauce |

  @usuarioTimeout
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preechidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
    Quando for realizado o clique no botao sign in
    Entao aguardo o timeout programado
    E deve ser logado no sistema

    Exemplos:
      | identificacao   | login                   | password     |
      | timout no login | performance_glitch_user | secret_sauce |
