# PLANO DE TESTES - US: Solicitação de Aprovação de Transferências PIX - Operador

**User Story:** Como um operador do Domínio Escritório/Empresa, eu gostaria de solicitar aprovação de transferências PIX via internet banking

**Contexto:** Funcionalidade para operadores solicitarem transferências PIX que precisam de aprovação do Sócio Administrador via Super App

---

## CASOS DE TESTE FUNCIONAIS - FLUXO DE SOLICITAÇÃO

### CT-001: Acesso à Funcionalidade PIX como Operador
**Tipo:** Funcional / Acesso
**Criticidade:** Alta
**Descrição:** Validar que operador consegue acessar funcionalidade PIX seguindo fluxos #841990/#841997

**BDD:**
- **Dado** que sou um operador logado no Internet Banking
- **Quando** acesso "Conta PJ" > "Área PIX" > "Transferência via PIX"
- **Então** devo conseguir acessar a funcionalidade
- **E** devo seguir os mesmos fluxos já definidos nas demandas #841990 e #841997

**EVIDÊNCIAS:**

---

### CT-002: Fluxo Completo de Solicitação - Recebedor Novo
**Tipo:** Funcional / Fluxo Completo
**Criticidade:** Alta
**Descrição:** Validar fluxo completo: Recebedor > Valor > Revisão > PIN como operador

**BDD:**
- **Dado** que sou operador realizando transferência PIX
- **Quando** preencho dados do recebedor (novo contato)
- **E** informo valor válido
- **E** reviso dados na tela de revisão
- **E** confirmo com PIN correto
- **Então** devo seguir exatamente o mesmo fluxo das demandas referenciadas
- **E** não deve haver diferenças no processo até a confirmação

**EVIDÊNCIAS:**

---

### CT-003: Fluxo Completo de Solicitação - Contato Existente
**Tipo:** Funcional / Fluxo Completo
**Criticidade:** Alta
**Descrição:** Validar fluxo usando contato já salvo na lista

**BDD:**
- **Dado** que sou operador com contatos PIX salvos
- **Quando** seleciono um contato existente
- **E** informo valor e confirmo a transferência
- **Então** o fluxo deve funcionar identicamente aos usuários normais
- **E** deve processar até a etapa de confirmação normalmente

**EVIDÊNCIAS:**

---

## CASOS DE TESTE FUNCIONAIS - TELA DE SUCESSO TRANSFERÊNCIA PENDENTE

### CT-004: Validação da Tela de Transferência Pendente - Transferência Imediata
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar elementos da tela de sucesso para transferência pendente

**BDD:**
- **Dado** que sou operador e confirmei uma transferência PIX imediata
- **Quando** a solicitação é processada
- **Então** devo ver a tela com título "Transferência pendente"
- **E** devo ver a mensagem "Sua transferência está pendente de aprovação do administrador da conta."
- **E** devo ver primeiro quadro com data da transação e valor
- **E** devo ver segundo quadro à esquerda com dados do banco origem (nome, CNPJ/CPF, banco)
- **E** devo ver segundo quadro à direita com dados do banco destino (nome, CNPJ/CPF, banco)
- **E** devo ver botões "Voltar para área Pix" e "Fazer novo pagamento"

**EVIDÊNCIAS:**

---

### CT-005: Validação da Tela de Transferência Pendente - Transferência Agendada
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar elementos da tela de sucesso para transferência agendada

**BDD:**
- **Dado** que sou operador e confirmei uma transferência PIX agendada
- **Quando** a solicitação é processada
- **Então** devo ver a tela idêntica à transferência pendente
- **E** deve exibir título "Transferência pendente"
- **E** deve exibir a mesma mensagem de aprovação pendente
- **E** todos os quadros e botões devem ser idênticos à tela de transferência imediata

**EVIDÊNCIAS:**

---

### CT-006: Funcionalidade Botão "Voltar para área Pix"
**Tipo:** Funcional / Navegação
**Criticidade:** Média
**Descrição:** Validar navegação do botão voltar

**BDD:**
- **Dado** que estou na tela de "Transferência pendente"
- **Quando** clico no botão "Voltar para área Pix"
- **Então** devo ser redirecionado para a área PIX
- **E** devo poder iniciar novas operações PIX

**EVIDÊNCIAS:**

---

### CT-007: Funcionalidade Botão "Fazer novo pagamento"
**Tipo:** Funcional / Navegação
**Criticidade:** Média
**Descrição:** Validar navegação do botão fazer novo pagamento

**BDD:**
- **Dado** que estou na tela de "Transferência pendente"
- **Quando** clico no botão "Fazer novo pagamento"
- **Então** devo ser redirecionado para a área PIX
- **E** devo poder iniciar uma nova transferência

**EVIDÊNCIAS:**

---

## CASOS DE TESTE FUNCIONAIS - REGRAS DE APROVAÇÃO

### CT-008: Validação de Não Efetivação sem Aprovação
**Tipo:** Funcional / Regra de Negócio
**Criticidade:** Alta
**Descrição:** Garantir que transferência não é efetivada sem aprovação do Sócio Administrador

**BDD:**
- **Dado** que sou operador e solicitei uma transferência PIX
- **Quando** a solicitação é criada
- **Então** o pagamento NÃO deve ser efetivado imediatamente
- **E** deve permanecer pendente até aprovação do Sócio Administrador
- **E** não deve aparecer como transferência realizada nos extratos

**EVIDÊNCIAS:**

---

### CT-009: Visualização da Solicitação Pendente no Super App
**Tipo:** Funcional / Integração
**Criticidade:** Alta
**Descrição:** Validar que solicitação aparece apenas no Super App para aprovação

**BDD:**
- **Dado** que operador criou solicitação de transferência PIX
- **Quando** Sócio Administrador acessa o Super App
- **Então** a solicitação pendente deve ser exibida no Super App
- **E** deve conter todos os dados da transferência para análise
- **E** deve permitir aprovação ou rejeição

**EVIDÊNCIAS:**

---

### CT-010: Solicitação NÃO Aparece no Internet Banking
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Confirmar que solicitação pendente só aparece no Super App

**BDD:**
- **Dado** que operador criou solicitação de transferência PIX
- **Quando** verifico o Internet Banking (área do operador ou administrador)
- **Então** a solicitação pendente NÃO deve aparecer no Internet Banking
- **E** deve aparecer apenas no Super App para aprovação

**EVIDÊNCIAS:**

---

## CASOS DE TESTE FUNCIONAIS - AGENDAMENTO

### CT-011: Solicitação de Transferência Agendada
**Tipo:** Funcional / Agendamento
**Criticidade:** Alta
**Descrição:** Validar criação de solicitação para transferência agendada

**BDD:**
- **Dado** que sou operador realizando transferência PIX agendada
- **Quando** seleciono data futura no calendário
- **E** confirmo a transferência
- **Então** deve ser criada solicitação de aprovação
- **E** deve exibir tela "Transferência pendente" idêntica à transferência imediata

**EVIDÊNCIAS:**

---

### CT-012: Transferência Agendada Aprovada - Menu Agendados
**Tipo:** Funcional / Pós-aprovação
**Criticidade:** Média
**Descrição:** Validar que transferência agendada aprovada aparece no menu correto

**BDD:**
- **Dado** que operador criou transferência agendada
- **E** Sócio Administrador aprovou a solicitação via Super App
- **Quando** verifico o extrato no Internet Banking
- **Então** a transferência deve aparecer no menu "Agendados" do extrato
- **E** deve conter todos os dados corretos da transferência

**EVIDÊNCIAS:**

---

## CASOS DE TESTE DE VALIDAÇÃO

### CT-013: Validação de Dados na Tela Pendente
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Verificar precisão dos dados exibidos na tela de transferência pendente

**BDD:**
- **Dado** que criei solicitação com dados específicos (valor, destinatário, data)
- **Quando** visualizo a tela "Transferência pendente"
- **Então** todos os dados devem estar corretos e formatados adequadamente
- **E** valor deve estar no formato R$ XXX.XXX,XX
- **E** data deve estar no formato DD/MM/AAAA
- **E** dados bancários devem estar completos e corretos

**EVIDÊNCIAS:**

---

### CT-014: Validação de Layout Conforme Imagens
**Tipo:** Funcional / Interface
**Criticidade:** Média
**Descrição:** Confirmar que layout segue exatamente as imagens fornecidas

**BDD:**
- **Dado** que estou na tela "Transferência pendente"
- **Quando** comparo com as imagens de referência da US
- **Então** o layout deve seguir exatamente o padrão das imagens
- **E** posicionamento dos elementos deve estar correto
- **E** cores e formatação devem seguir o padrão estabelecido

**EVIDÊNCIAS:**

---

### CT-015: Múltiplas Solicitações Pendentes
**Tipo:** Funcional / Cenário Múltiplo
**Criticidade:** Média
**Descrição:** Validar comportamento com várias solicitações pendentes

**BDD:**
- **Dado** que sou operador
- **Quando** crio múltiplas solicitações de transferência PIX
- **Então** cada solicitação deve ser tratada independentemente
- **E** todas devem aparecer no Super App para aprovação
- **E** cada aprovação deve ser processada individualmente

**EVIDÊNCIAS:**

---

## CASOS DE TESTE NÃO FUNCIONAIS

### CT-016: Performance - Criação de Solicitação
**Tipo:** Performance
**Criticidade:** Média
**Descrição:** Validar tempo de resposta para criação de solicitação

**BDD:**
- **Dado** que sou operador finalizando transferência PIX
- **Quando** confirmo com PIN e processo a solicitação
- **Então** a tela "Transferência pendente" deve aparecer em até 3 segundos
- **E** deve haver feedback visual durante o processamento

**EVIDÊNCIAS:**

---

### CT-017: Compatibilidade Multi-browser
**Tipo:** Compatibilidade
**Criticidade:** Média
**Descrição:** Validar funcionamento em diferentes navegadores

**BDD:**
- **Dado** que acesso como operador em diferentes navegadores
- **Quando** realizo solicitação de transferência PIX
- **Então** a funcionalidade deve funcionar identicamente
- **E** a tela "Transferência pendente" deve ser exibida corretamente

**EVIDÊNCIAS:**

---

### CT-018: Integração Super App - Internet Banking
**Tipo:** Integração
**Criticidade:** Alta
**Descrição:** Validar comunicação entre sistemas

**BDD:**
- **Dado** que operador cria solicitação no Internet Banking
- **Quando** a solicitação é processada
- **Então** deve aparecer imediatamente no Super App
- **E** dados devem estar sincronizados entre os sistemas
- **E** status deve ser atualizado em tempo real

**EVIDÊNCIAS:**

---

## CASOS DE TESTE DE SEGURANÇA

### CT-019: Validação de Permissões - Operador
**Tipo:** Segurança / Autorização
**Criticidade:** Alta
**Descrição:** Confirmar que operador tem permissões corretas

**BDD:**
- **Dado** que sou usuário com perfil de operador
- **Quando** acesso funcionalidades PIX
- **Então** devo conseguir criar solicitações de transferência
- **E** NÃO devo conseguir aprovar transferências
- **E** devo ver apenas opções disponíveis para meu perfil

**EVIDÊNCIAS:**

---

### CT-020: Proteção de Dados na Solicitação
**Tipo:** Segurança / LGPD
**Criticidade:** Alta
**Descrição:** Validar proteção de dados sensíveis

**BDD:**
- **Dado** que criei solicitação com dados sensíveis
- **Quando** visualizo a tela "Transferência pendente"
- **Então** dados sensíveis devem estar adequadamente protegidos
- **E** CPF/CNPJ devem estar mascarados quando necessário
- **E** informações bancárias devem seguir padrões de segurança

**EVIDÊNCIAS:**

---

### CT-021: Auditoria de Solicitações
**Tipo:** Segurança / Auditoria
**Criticidade:** Média
**Descrição:** Validar rastro de auditoria das solicitações

**BDD:**
- **Dado** que operador cria solicitação de transferência
- **Quando** a solicitação é processada
- **Então** deve haver registro completo da ação
- **E** deve conter identificação do operador
- **E** deve registrar data/hora da solicitação
- **E** deve manter histórico para auditoria

**EVIDÊNCIAS:**

---

## CASOS DE TESTE DE REGRESSÃO

### CT-022: Regressão - Funcionalidades PIX Existentes
**Tipo:** Regressão
**Criticidade:** Alta
**Descrição:** Garantir que funcionalidades PIX existentes não foram impactadas

**BDD:**
- **Dado** que a funcionalidade de aprovação foi implementada
- **Quando** usuários normais (não operadores) realizam transferências PIX
- **Então** devem continuar funcionando como antes
- **E** não devem passar por processo de aprovação
- **E** devem ser efetivadas imediatamente

**EVIDÊNCIAS:**

---

### CT-023: Regressão - Fluxos #841990 e #841997
**Tipo:** Regressão
**Criticidade:** Alta
**Descrição:** Validar que fluxos base permanecem inalterados para operadores

**BDD:**
- **Dado** que sou operador usando a funcionalidade
- **Quando** navego pelos menus Recebedor > Valor > Revisão
- **Então** os fluxos devem funcionar exatamente como nas demandas #841990 e #841997
- **E** não deve haver alterações nos menus ou validações
- **E** única diferença deve ser a tela final de confirmação

**EVIDÊNCIAS:**

---

### CT-024: Teste de Diferentes Tipos de Chave PIX
**Tipo:** Funcional / Regressão
**Criticidade:** Média
**Descrição:** Validar solicitação com diferentes tipos de chave PIX

**BDD:**
- **Dado** que sou operador criando solicitações
- **Quando** uso diferentes tipos de chave PIX (e-mail, telefone, CPF/CNPJ, chave aleatória)
- **Então** todas devem criar solicitações corretamente
- **E** devem aparecer no Super App para aprovação
- **E** dados devem ser preservados adequadamente

**EVIDÊNCIAS:**

---

## RESUMO DA COBERTURA DE TESTES

- **Total de Casos de Teste:** 24
- **Testes Funcionais:** 18
- **Testes Não Funcionais:** 3
- **Testes de Segurança:** 3

### Distribuição por Criticidade:
- **Alta:** 16 casos de teste
- **Média:** 8 casos de teste

### Cobertura dos Critérios de Aceite:
- ✅ **Critério 1** (Fluxo de Solicitação): CT-001, CT-002, CT-003, CT-023
- ✅ **Critério 2** (Aprovação Necessária): CT-008, CT-009
- ✅ **Critério 3** (Tela de Sucesso): CT-004, CT-005, CT-006, CT-007, CT-013
- ✅ **Critério 4** (Visualização no Super App): CT-009, CT-010
- ✅ **Critério 5** (Agendamento): CT-011, CT-012
- ✅ **Critério 6** (Layout e Regras): CT-014, CT-008

### Cobertura por Fluxo:
- **Solicitação:** 6 casos
- **Tela Pendente:** 4 casos
- **Aprovação:** 3 casos
- **Agendamento:** 2 casos
- **Segurança:** 3 casos
- **Regressão:** 3 casos

### Tipos de Teste Incluídos:
- ✅ Funcionais (fluxo completo, interface, navegação)
- ✅ Regras de negócio (aprovação obrigatória)
- ✅ Integração (Super App ↔ Internet Banking)
- ✅ Performance
- ✅ Compatibilidade
- ✅ Segurança (permissões, LGPD, auditoria)
- ✅ Regressão (fluxos existentes)

### Cenários Especiais Cobertos:
- **Múltiplas solicitações** pendentes
- **Diferentes tipos** de chave PIX
- **Transferências agendadas** vs imediatas
- **Validação de permissões** por perfil
- **Sincronização** entre sistemas

**Objetivo:** Garantir que operadores possam criar solicitações de transferência PIX que funcionem exatamente como os fluxos existentes, mas com aprovação obrigatória do Sócio Administrador via Super App, mantendo segurança e rastreabilidade completa do processo.