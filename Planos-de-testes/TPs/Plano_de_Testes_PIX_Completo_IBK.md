# PLANO DE TESTES - US: Transferências PIX via Internet Banking PJ

**User Story:** Como usuário Domínio Escritório/Empresa, eu gostaria de realizar transferências PIX via Internet Banking

**Contexto:** Funcionalidade completa de transferência PIX para facilitar e agilizar pagamentos de usuários PJ

---

## CASOS DE TESTE FUNCIONAIS - NAVEGAÇÃO E ACESSO

### CT-001: Acesso à Funcionalidade Transferência PIX
**Tipo:** Funcional / Navegação
**Criticidade:** Alta
**Descrição:** Validar o acesso completo à funcionalidade de transferência PIX

**BDD:**
- **Dado** que sou um usuário PJ logado no Internet Banking
- **Quando** acesso "Conta PJ" > "Área PIX" > "Transferência via PIX"
- **Então** devo ser direcionado para a tela de transferência PIX
- **E** devo visualizar os 3 menus principais: "Recebedor", "Valor" e "Resumo/Confirmação"

**EVIDÊNCIAS:**

---

## CASOS DE TESTE FUNCIONAIS - MENU RECEBEDOR

### CT-002: Validação de Interface do Menu Recebedor
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar elementos do menu Recebedor (detalhado na #841990)

**BDD:**
- **Dado** que estou na tela de transferência PIX
- **Quando** visualizo o menu "Recebedor"
- **Então** devo ter as opções de selecionar contato existente OU informar chave PIX
- **E** devo conseguir informar chave PIX (e-mail, telefone, CPF/CNPJ, chave aleatória)

**EVIDÊNCIAS:**

---

### CT-003: Seleção de Contato Existente
**Tipo:** Funcional / Seleção
**Criticidade:** Alta
**Descrição:** Validar seleção de contato da lista existente

**BDD:**
- **Dado** que possuo contatos PIX salvos
- **Quando** acesso o menu "Recebedor"
- **E** seleciono um contato existente
- **Então** os dados do contato devem ser preenchidos automaticamente
- **E** devo conseguir avançar para o próximo menu

**EVIDÊNCIAS:**

---

### CT-004: Inserção de Nova Chave PIX
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar inserção de chaves PIX válidas

**BDD:**
- **Dado** que estou no menu "Recebedor"
- **Quando** informo uma chave PIX válida (e-mail, telefone, CPF/CNPJ, chave aleatória)
- **Então** o sistema deve validar a chave
- **E** permitir avançar para o próximo menu

**EVIDÊNCIAS:**

---

## CASOS DE TESTE FUNCIONAIS - MENU VALOR

### CT-005: Validação de Interface do Menu Valor
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar todos os elementos visuais do menu Valor

**BDD:**
- **Dado** que cheguei ao menu "Valor"
- **Quando** visualizo a tela
- **Então** devo ver o título "Informe o valor a transferir"
- **E** devo ver o saldo atual da conta
- **E** devo ver o campo "Valor a pagar" com placeholder "R$ 0,00"
- **E** devo ver os botões "Voltar" e "Avançar"
- **E** o botão "Avançar" deve estar desabilitado inicialmente

**EVIDÊNCIAS:**

---

### CT-006: Validação de Valor Válido
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar inserção de valores válidos conforme Critério 2

**BDD:**
- **Dado** que estou no menu "Valor"
- **Quando** informo um valor maior que R$ 0,00 e menor ou igual ao saldo
- **Então** o botão "Avançar" deve ser habilitado
- **E** a máscara monetária deve ser aplicada automaticamente
- **E** não deve exibir mensagens de erro

**EVIDÊNCIAS:**

---

### CT-007: Validação de Valor Zero ou Negativo - Critério 1
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar que valores inválidos mantêm botão desabilitado conforme Critério 1

**BDD:**
- **Dado** que estou no campo "Valor a pagar"
- **Quando** informo valor igual a R$ 0,00 ou negativo
- **Então** o botão "Avançar" deve permanecer desabilitado
- **E** o sistema deve impedir a inserção ou exibir erro

**EVIDÊNCIAS:**

---

### CT-008: Validação de Saldo Insuficiente - Critério 1
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar comportamento quando valor excede saldo disponível

**BDD:**
- **Dado** que estou no menu "Valor"
- **Quando** informo um valor maior que o saldo da conta
- **Então** o botão "Avançar" deve permanecer desabilitado
- **E** deve exibir a mensagem "Saldo insuficiente. Por favor, verifique o valor informado."
- **E** a mensagem deve aparecer abaixo do campo "Valor"

**EVIDÊNCIAS:**

---

### CT-009: Validação de Caracteres Não Numéricos
**Tipo:** Funcional / Validação
**Criticidade:** Média
**Descrição:** Validar que não são aceitos caracteres inválidos

**BDD:**
- **Dado** que estou no campo "Valor a pagar"
- **Quando** tento inserir letras ou símbolos não numéricos
- **Então** o campo não deve aceitar os caracteres inválidos
- **E** deve manter apenas números e símbolos monetários válidos

**EVIDÊNCIAS:**

---

### CT-010: Atualização em Tempo Real do Botão
**Tipo:** Funcional / Interface
**Criticidade:** Média
**Descrição:** Validar habilitação/desabilitação instantânea do botão

**BDD:**
- **Dado** que estou digitando no campo "Valor a pagar"
- **Quando** altero o valor de inválido para válido (ou vice-versa)
- **Então** o botão "Avançar" deve ser habilitado/desabilitado instantaneamente
- **E** a atualização deve ser em tempo real

**EVIDÊNCIAS:**

---

### CT-011: Transição do Menu Valor para Revisão - Critério 2
**Tipo:** Funcional / Fluxo
**Criticidade:** Alta
**Descrição:** Validar navegação após inserir valor válido

**BDD:**
- **Dado** que informei um valor válido no menu "Valor"
- **Quando** clico no botão "Avançar"
- **Então** devo ser direcionado ao menu "Revisão" com todos os dados corretos
- **E** o menu "Valor" deve ficar verde com ícone de confirmado

**EVIDÊNCIAS:**

---

## CASOS DE TESTE FUNCIONAIS - MENU REVISÃO

### CT-012: Validação de Interface do Menu Revisão
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar todos os elementos do menu Revisão

**BDD:**
- **Dado** que cheguei ao menu "Revisão"
- **Quando** visualizo a tela
- **Então** devo ver o título "Revise e confirme os dados da transferência"
- **E** devo ver o Quadro 1 com valor no formato R$ XXX.XXX,XX
- **E** devo ver o Quadro 2 com tipo "Transferência Pix" e data DD/MM/AAAA
- **E** devo ver o Quadro 3 com dados do pagador (esquerda) e recebedor (direita)
- **E** devo ver os botões "Voltar" e "Confirmar"

**EVIDÊNCIAS:**

---

### CT-013: Validação da Opção "Adicionar à Lista de Contatos" - Novo Contato
**Tipo:** Funcional / Gestão de Contatos
**Criticidade:** Alta
**Descrição:** Validar comportamento para contatos não salvos

**BDD:**
- **Dado** que estou no menu "Revisão" com um contato não salvo
- **Quando** visualizo a opção "Adicionar à lista de contatos"
- **Então** devo ver a mensagem "Para facilitar o envio de novos pagamentos para este recebedor, adicione o contato à lista."
- **E** a opção deve estar desmarcada e habilitada para seleção

**EVIDÊNCIAS:**

---

### CT-014: Validação da Opção "Adicionar à Lista de Contatos" - Contato Existente - Critério 5
**Tipo:** Funcional / Gestão de Contatos
**Criticidade:** Alta
**Descrição:** Validar comportamento para contatos já salvos

**BDD:**
- **Dado** que estou no menu "Revisão" com um contato já salvo
- **Quando** visualizo a opção "Adicionar à lista de contatos"
- **Então** a opção deve aparecer selecionada e desabilitada
- **E** não deve ser possível desmarcar a opção

**EVIDÊNCIAS:**

---

### CT-015: Funcionalidade de Agendamento - Critério 6
**Tipo:** Funcional / Agendamento
**Criticidade:** Média
**Descrição:** Validar agendamento de transferência PIX

**BDD:**
- **Dado** que estou no menu "Revisão"
- **Quando** clico no ícone de calendário
- **E** seleciono uma data futura dentro do prazo permitido pelo Banco Central
- **Então** a data de pagamento deve ser atualizada para a data selecionada
- **E** deve exibir corretamente no formato DD/MM/AAAA

**EVIDÊNCIAS:**

---

### CT-016: Botão Voltar do Menu Revisão
**Tipo:** Funcional / Navegação
**Criticidade:** Média
**Descrição:** Validar retorno para o menu Valor

**BDD:**
- **Dado** que estou no menu "Revisão"
- **Quando** clico no botão "Voltar"
- **Então** devo retornar para o menu "Valor"
- **E** os dados previamente informados devem estar preservados

**EVIDÊNCIAS:**

---

## CASOS DE TESTE FUNCIONAIS - AUTENTICAÇÃO

### CT-017: Solicitação de PIN
**Tipo:** Funcional / Autenticação
**Criticidade:** Alta
**Descrição:** Validar fluxo de solicitação do PIN

**BDD:**
- **Dado** que estou no menu "Revisão" com dados preenchidos
- **Quando** clico no botão "Confirmar"
- **Então** devo ser direcionado para a tela de inserção do PIN
- **E** deve exibir campo com máscara para ocultar caracteres
- **E** o botão "Confirmar" deve ficar habilitado após preenchimento

**EVIDÊNCIAS:**

---

### CT-018: PIN Correto - Processamento da Transação
**Tipo:** Funcional / Autenticação
**Criticidade:** Alta
**Descrição:** Validar processamento com PIN correto

**BDD:**
- **Dado** que estou na tela de inserção do PIN
- **Quando** informo o PIN correto e clico em "Confirmar"
- **Então** devo ser direcionado para a tela de confirmação da transação
- **E** deve exibir "Tudo Certo! Sua transferência foi realizada com sucesso"

**EVIDÊNCIAS:**

---

### CT-019: PIN Incorreto
**Tipo:** Funcional / Autenticação
**Criticidade:** Alta
**Descrição:** Validar comportamento com PIN incorreto

**BDD:**
- **Dado** que estou na tela de inserção do PIN
- **Quando** informo um PIN incorreto
- **Então** deve exibir mensagem "PIN incorreto. Por favor, verifique e tente novamente" no canto superior
- **E** devo ter nova oportunidade para inserir o PIN correto

**EVIDÊNCIAS:**

---

## CASOS DE TESTE FUNCIONAIS - TELA DE CONFIRMAÇÃO

### CT-020: Validação da Tela de Confirmação
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar todos os elementos da tela de sucesso

**BDD:**
- **Dado** que a transação foi realizada com sucesso
- **Quando** visualizo a tela de confirmação
- **Então** devo ver o Quadro 1 com "Tudo Certo!" e mensagem de sucesso
- **E** devo ver o Quadro 2 com nome do beneficiário
- **E** devo ver o Quadro 3 com dados bancários de origem e destino
- **E** devo ver os botões "Ver comprovante", "Compartilhar comprovante" e "Fazer nova transferência"

**EVIDÊNCIAS:**

---

### CT-021: Funcionalidade Ver Comprovante - Critério 4
**Tipo:** Funcional / Comprovante
**Criticidade:** Alta
**Descrição:** Validar abertura e conteúdo do comprovante conforme padrão do banco

**BDD:**
- **Dado** que estou na tela de confirmação
- **Quando** clico no botão "Ver comprovante"
- **Então** deve abrir uma modal no canto direito da tela
- **E** deve exibir "Comprovante de Transferência Pix" como título
- **E** deve conter valor, tipo de transação, data/hora, dados bancários, chave PIX e código de autenticação
- **E** deve ter botão "X" para fechar

**EVIDÊNCIAS:**

---

### CT-022: Compartilhar Comprovante
**Tipo:** Funcional / Comprovante
**Criticidade:** Média
**Descrição:** Validar download/compartilhamento do comprovante

**BDD:**
- **Dado** que estou visualizando o comprovante na modal
- **Quando** clico no botão "Compartilhar comprovante"
- **Então** deve realizar download do comprovante em PDF ou imagem
- **E** o arquivo deve seguir o padrão visual do Internet Banking

**EVIDÊNCIAS:**

---

### CT-023: Erro na Geração do Comprovante
**Tipo:** Funcional / Tratamento de Erro
**Criticidade:** Média
**Descrição:** Validar tratamento de erro na geração do comprovante

**BDD:**
- **Dado** que ocorreu erro na geração do comprovante
- **Quando** tento visualizar o comprovante
- **Então** deve exibir a mensagem "Não foi possível exibir o comprovante. Por favor, tente novamente."

**EVIDÊNCIAS:**

---

### CT-024: Fazer Nova Transferência - Critério 7
**Tipo:** Funcional / Navegação
**Criticidade:** Média
**Descrição:** Validar retorno para área PIX

**BDD:**
- **Dado** que estou na tela de confirmação
- **Quando** clico no botão "Fazer nova transferência"
- **Então** devo ser direcionado para a área PIX
- **E** devo estar pronto para iniciar novo fluxo

**EVIDÊNCIAS:**

---

## CASOS DE TESTE FUNCIONAIS - GESTÃO DE CONTATOS

### CT-025: Salvamento de Novo Contato - Critério 3
**Tipo:** Funcional / Gestão de Contatos
**Criticidade:** Alta
**Descrição:** Validar salvamento de contato quando opção marcada

**BDD:**
- **Dado** que marquei a opção "Adicionar à lista de contatos" para um novo contato
- **Quando** confirmo a transferência com sucesso
- **Então** o contato deve ser salvo na lista de contatos
- **E** deve estar disponível para futuras transferências

**EVIDÊNCIAS:**

---

### CT-026: Prevenção de Contato Duplicado
**Tipo:** Funcional / Validação
**Criticidade:** Média
**Descrição:** Validar que não é permitido cadastrar o mesmo contato PIX duas vezes

**BDD:**
- **Dado** que tento adicionar um contato com chave PIX já existente
- **Quando** confirmo a transferência
- **Então** o sistema deve detectar a duplicidade
- **E** não deve criar um novo contato duplicado

**EVIDÊNCIAS:**

---

## CASOS DE TESTE NÃO FUNCIONAIS

### CT-027: Performance - Tempo de Resposta
**Tipo:** Performance
**Criticidade:** Alta
**Descrição:** Validar que o sistema responde em até 2 segundos conforme requisito

**BDD:**
- **Dado** que estou realizando qualquer ação na transferência PIX
- **Quando** clico em qualquer botão ou preencho campos
- **Então** o sistema deve responder em até 2 segundos
- **E** deve fornecer feedback visual durante processamento

**EVIDÊNCIAS:**

---

### CT-028: Compatibilidade Multi-browser
**Tipo:** Compatibilidade
**Criticidade:** Alta
**Descrição:** Validar funcionamento nos navegadores especificados

**BDD:**
- **Dado** que acesso o Internet Banking em Chrome, Edge, Firefox e Safari (versões dos últimos 2 anos)
- **Quando** realizo uma transferência PIX completa
- **Então** a funcionalidade deve comportar-se identicamente
- **E** todas as máscaras e validações devem funcionar corretamente

**EVIDÊNCIAS:**

---

### CT-029: Máscaras e Validações Instantâneas
**Tipo:** Performance / Interface
**Criticidade:** Média
**Descrição:** Validar que máscaras e validações são instantâneas e amigáveis

**BDD:**
- **Dado** que estou inserindo dados nos campos da transferência
- **Quando** digito valores ou textos
- **Então** as máscaras devem ser aplicadas instantaneamente
- **E** as validações devem ser amigáveis e claras

**EVIDÊNCIAS:**

---

## CASOS DE TESTE DE SEGURANÇA

### CT-030: Conformidade com LGPD
**Tipo:** Segurança
**Criticidade:** Alta
**Descrição:** Validar proteção de dados conforme LGPD

**BDD:**
- **Dado** que realizo uma transferência PIX
- **Quando** visualizo comprovantes e telas
- **Então** dados sensíveis como CPF/CNPJ devem estar adequadamente protegidos
- **E** informações devem seguir as diretrizes da LGPD

**EVIDÊNCIAS:**

---

### CT-031: Segurança do PIN
**Tipo:** Segurança
**Criticidade:** Alta
**Descrição:** Validar proteção durante inserção do PIN

**BDD:**
- **Dado** que estou inserindo o PIN
- **Quando** digito os caracteres
- **Então** todos os caracteres devem estar mascarados
- **E** o PIN não deve ser visível em qualquer momento
- **E** deve seguir as regras de segurança atuais do banco

**EVIDÊNCIAS:**

---

### CT-032: Timeout de Sessão
**Tipo:** Segurança
**Criticidade:** Alta
**Descrição:** Validar comportamento quando sessão expira

**BDD:**
- **Dado** que inicio uma transferência PIX
- **Quando** minha sessão expira durante o processo
- **Então** devo ser redirecionado para tela de login
- **E** nenhuma informação da transação deve permanecer visível

**EVIDÊNCIAS:**

---

## CASOS DE TESTE DE REGRESSÃO

### CT-033: Integração com Outras Funcionalidades PIX
**Tipo:** Regressão
**Criticidade:** Alta
**Descrição:** Validar que a funcionalidade não impacta outras funcionalidades PIX

**BDD:**
- **Dado** que a funcionalidade de transferência PIX foi implementada
- **Quando** acesso outras funcionalidades PIX (QR Code, copia e cola, etc.)
- **Então** todas devem continuar funcionando normalmente
- **E** não deve haver conflitos entre funcionalidades

**EVIDÊNCIAS:**

---

### CT-034: Teste de Agendamento com Datas Limite
**Tipo:** Funcional / Validação
**Criticidade:** Média
**Descrição:** Validar limites de agendamento conforme Banco Central

**BDD:**
- **Dado** que estou agendando uma transferência PIX
- **Quando** seleciono datas no calendário
- **Então** só devem estar disponíveis datas dentro do prazo permitido pelo Banco Central
- **E** datas fora do prazo devem estar desabilitadas

**EVIDÊNCIAS:**

---

## RESUMO DA COBERTURA DE TESTES

- **Total de Casos de Teste:** 34
- **Testes Funcionais:** 28
- **Testes Não Funcionais:** 3
- **Testes de Segurança:** 3

### Distribuição por Criticidade:
- **Alta:** 24 casos de teste
- **Média:** 10 casos de teste

### Cobertura por Menu:
- **Recebedor:** 3 casos
- **Valor:** 7 casos
- **Revisão:** 5 casos
- **Autenticação:** 3 casos
- **Confirmação:** 5 casos
- **Gestão de Contatos:** 2 casos

### Cobertura dos Critérios de Aceite:
- ✅ **Critério 1:** CT-007, CT-008 (valores inválidos)
- ✅ **Critério 2:** CT-011 (valor válido → revisão)
- ✅ **Critério 3:** CT-025 (salvamento de contato)
- ✅ **Critério 4:** CT-021 (comprovante padrão)
- ✅ **Critério 5:** CT-014 (contato existente)
- ✅ **Critério 6:** CT-015 (agendamento → comprovante)
- ✅ **Critério 7:** CT-024 (nova transferência)

### Tipos de Teste Incluídos:
- ✅ Funcionais (navegação, interface, validação)
- ✅ Fluxos completos (recebedor → valor → revisão → confirmação)
- ✅ Gestão de contatos (novo/existente/duplicado)
- ✅ Agendamento PIX
- ✅ Performance (2s de resposta)
- ✅ Compatibilidade multi-browser
- ✅ Segurança (LGPD, PIN, timeout)
- ✅ Regressão

**Objetivo:** Garantir que a funcionalidade completa de transferência PIX funcione corretamente em todos os cenários, mantendo alta performance, segurança e boa experiência do usuário PJ no Internet Banking.