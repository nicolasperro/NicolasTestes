# PLANO DE TESTES - US: Transferência PIX via Copia e Cola - Internet Banking PJ

**User Story:** Como usuário Domínio Escritório/Empresa, eu gostaria de realizar transferências PIX via chave COPIA E COLA pelo Internet Banking

**Contexto:** Funcionalidade para facilitar envios de valores a outros usuários/instituições através de código PIX no Internet Banking PJ

---

## CASOS DE TESTE FUNCIONAIS - NAVEGAÇÃO E ACESSO

### CT-001: Acesso à funcionalidade Transferência via PIX
**Tipo:** Funcional / Navegação
**Criticidade:** Alta
**Descrição:** Validar o acesso completo à funcionalidade de transferência PIX via copia e cola

**BDD:**
- **Dado** que sou um usuário PJ logado no Internet Banking
- **Quando** acesso "Conta PJ" > "Área PIX" > "Transferência via PIX"
- **Então** devo ser direcionado para a tela de transferência PIX copia e cola
- **E** devo visualizar os 3 menus: "Código PIX", "Valor" e "Revisão"

**EVIDÊNCIAS:**

---

## CASOS DE TESTE FUNCIONAIS - MENU CÓDIGO PIX

### CT-002: Validação de Interface do Menu Código PIX
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar se todos os elementos do menu Código PIX estão presentes e corretos

**BDD:**
- **Dado** que estou na tela de transferência PIX copia e cola
- **Quando** visualizo o menu "Código PIX"
- **Então** devo ver o título "Informe o código, copia e cola para fazer uma transferência"
- **E** devo ver o campo "Código" para informar caracteres alfanuméricos
- **E** devo ver os botões "Voltar" e "Avançar"
- **E** o botão "Avançar" deve estar desabilitado inicialmente

**EVIDÊNCIAS:**

---

### CT-003: Inserção de Código PIX Válido
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar inserção de código PIX válido no campo

**BDD:**
- **Dado** que estou no menu "Código PIX"
- **Quando** informo um código PIX válido no campo "Código"
- **Então** o botão "Avançar" deve ser habilitado
- **E** o campo deve aceitar caracteres alfanuméricos

**EVIDÊNCIAS:**

---

### CT-004: Funcionalidade Botão Voltar - Menu Código PIX
**Tipo:** Funcional / Navegação
**Criticidade:** Média
**Descrição:** Validar que o botão Voltar retorna para a área PIX

**BDD:**
- **Dado** que estou no menu "Código PIX"
- **Quando** clico no botão "Voltar"
- **Então** devo retornar para a área PIX

**EVIDÊNCIAS:**

---

### CT-005: Transição para Menu Valor - Código Sem Valor
**Tipo:** Funcional / Fluxo
**Criticidade:** Alta
**Descrição:** Validar navegação quando código PIX não possui valor definido

**BDD:**
- **Dado** que informei um código PIX sem valor definido
- **Quando** clico no botão "Avançar"
- **Então** o menu "Código PIX" deve ficar verde com ícone de confirmado
- **E** devo ser direcionado para o menu "Valor"

**EVIDÊNCIAS:**

---

### CT-006: Transição Direta para Revisão - Código Com Valor
**Tipo:** Funcional / Fluxo
**Criticidade:** Alta
**Descrição:** Validar que códigos PIX com valor definido pulam direto para revisão

**BDD:**
- **Dado** que informei um código PIX com valor pré-definido
- **Quando** clico no botão "Avançar"
- **Então** o menu "Código PIX" deve ficar verde com ícone de confirmado
- **E** devo ser direcionado diretamente para o menu "Revisão"

**EVIDÊNCIAS:**

---

## CASOS DE TESTE FUNCIONAIS - MENU VALOR

### CT-007: Validação de Interface do Menu Valor
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar elementos visuais do menu Valor

**BDD:**
- **Dado** que cheguei ao menu "Valor" (código sem valor definido)
- **Quando** visualizo a tela
- **Então** devo ver o título "Informe o valor a transferir"
- **E** devo ver o saldo atual da conta
- **E** devo ver o campo "Valor a pagar"
- **E** devo ver os botões "Voltar" e "Avançar"

**EVIDÊNCIAS:**

---

### CT-008: Validação de Valor Válido
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar inserção de valores válidos (maior que 0,00)

**BDD:**
- **Dado** que estou no menu "Valor"
- **Quando** informo um valor maior que R$ 0,00 e menor ou igual ao saldo
- **Então** o botão "Avançar" deve ser habilitado
- **E** não deve exibir mensagens de erro

**EVIDÊNCIAS:**

---

### CT-009: Validação de Valor Zero ou Negativo
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar que valores inválidos não são aceitos

**BDD:**
- **Dado** que estou no campo "Valor a pagar"
- **Quando** informo valor igual a R$ 0,00 ou negativo
- **Então** o botão "Avançar" deve permanecer desabilitado
- **E** o sistema deve impedir a inserção ou exibir erro

**EVIDÊNCIAS:**

---

### CT-010: Validação de Saldo Insuficiente
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

### CT-011: Transição do Menu Valor para Revisão
**Tipo:** Funcional / Fluxo
**Criticidade:** Alta
**Descrição:** Validar navegação após inserir valor válido

**BDD:**
- **Dado** que informei um valor válido no menu "Valor"
- **Quando** clico no botão "Avançar"
- **Então** o menu "Valor" deve ficar verde com ícone de confirmado
- **E** devo ser direcionado para o menu "Revisão"

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
- **E** devo ver o primeiro quadro com o valor no formato R$ XXX.XXX,XX
- **E** devo ver o segundo quadro com dados do recebedor (nome, banco)
- **E** devo ver os dados do PIX (chave PIX, data de pagamento DD/MM/AAAA)
- **E** devo ver os botões "Voltar" e "Confirmar pagamento"

**EVIDÊNCIAS:**

---

### CT-013: Funcionalidade de Agendamento
**Tipo:** Funcional / Agendamento
**Criticidade:** Média
**Descrição:** Validar que é possível agendar o pagamento PIX

**BDD:**
- **Dado** que estou no menu "Revisão"
- **Quando** clico no ícone de calendário
- **Então** devo conseguir selecionar uma data futura para agendamento
- **E** a data deve ser atualizada no campo "Data de Pagamento"

**EVIDÊNCIAS:**

---

### CT-014: Botão Voltar do Menu Revisão
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

## CASOS DE TESTE FUNCIONAIS - AUTENTICAÇÃO E CONFIRMAÇÃO

### CT-015: Solicitação de PIN
**Tipo:** Funcional / Autenticação
**Criticidade:** Alta
**Descrição:** Validar fluxo de solicitação do PIN para confirmação

**BDD:**
- **Dado** que estou no menu "Revisão" com dados preenchidos
- **Quando** clico no botão "Confirmar pagamento"
- **Então** devo ser direcionado para a tela de inserção do PIN
- **E** a tela deve seguir as regras da versão de mercado

**EVIDÊNCIAS:**

---

### CT-016: PIN Correto - Confirmação da Transação
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

### CT-017: PIN Incorreto
**Tipo:** Funcional / Autenticação
**Criticidade:** Alta
**Descrição:** Validar comportamento com PIN incorreto

**BDD:**
- **Dado** que estou na tela de inserção do PIN
- **Quando** informo um PIN incorreto
- **Então** devo ver uma mensagem de erro
- **E** devo ter nova oportunidade para inserir o PIN correto
- **E** após 3 tentativas incorretas, devo ser bloqueado conforme regras

**EVIDÊNCIAS:**

---

## CASOS DE TESTE FUNCIONAIS - TELA DE CONFIRMAÇÃO

### CT-018: Validação da Tela de Confirmação
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar todos os elementos da tela de sucesso

**BDD:**
- **Dado** que a transação foi realizada com sucesso
- **Quando** visualizo a tela de confirmação
- **Então** devo ver o título "Tudo Certo!"
- **E** devo ver "Sua transferência foi realizada com sucesso"
- **E** devo ver nome do recebedor, valor e data de pagamento
- **E** devo ver dados bancários de origem e destino
- **E** devo ver os botões "Ver comprovante" e "Fazer nova transferência"

**EVIDÊNCIAS:**

---

### CT-019: Funcionalidade Ver Comprovante
**Tipo:** Funcional / Comprovante
**Criticidade:** Alta
**Descrição:** Validar abertura e conteúdo do comprovante

**BDD:**
- **Dado** que estou na tela de confirmação
- **Quando** clico no botão "Ver comprovante"
- **Então** deve abrir uma modal no canto direito da tela
- **E** deve exibir "Comprovante de Transferência Pix" como título
- **E** deve conter valor, tipo de transação, data/hora, dados bancários, chave PIX e código de autenticação
- **E** deve ter botão "X" para fechar e botão "Compartilhar comprovante"

**EVIDÊNCIAS:**

---

### CT-020: Compartilhar Comprovante
**Tipo:** Funcional / Comprovante
**Criticidade:** Média
**Descrição:** Validar download/compartilhamento do comprovante

**BDD:**
- **Dado** que estou visualizando o comprovante na modal
- **Quando** clico no botão "Compartilhar comprovante"
- **Então** deve realizar download do comprovante em PDF ou imagem
- **E** o arquivo deve conter todas as informações da transação

**EVIDÊNCIAS:**

---

### CT-021: Erro na Geração do Comprovante
**Tipo:** Funcional / Tratamento de Erro
**Criticidade:** Média
**Descrição:** Validar comportamento quando há erro na geração do comprovante

**BDD:**
- **Dado** que ocorreu erro na geração do comprovante
- **Quando** tento visualizar o comprovante
- **Então** deve exibir a mensagem "Não foi possível exibir o comprovante. Por favor, tente novamente."

**EVIDÊNCIAS:**

---

### CT-022: Fazer Nova Transferência
**Tipo:** Funcional / Navegação
**Criticidade:** Média
**Descrição:** Validar retorno para área PIX

**BDD:**
- **Dado** que estou na tela de confirmação
- **Quando** clico no botão "Fazer nova transferência"
- **Então** devo ser direcionado para a área PIX
- **E** devo conseguir iniciar uma nova transferência

**EVIDÊNCIAS:**

---

## CASOS DE TESTE NÃO FUNCIONAIS

### CT-023: Performance - Processamento da Transferência
**Tipo:** Performance
**Criticidade:** Média
**Descrição:** Validar tempo de processamento da transferência PIX

**BDD:**
- **Dado** que confirmei uma transferência PIX com PIN correto
- **Quando** o sistema processa a transação
- **Então** o processamento deve ser concluído em até 10 segundos
- **E** deve exibir feedback visual durante o processamento

**EVIDÊNCIAS:**

---

### CT-024: Compatibilidade Multi-browser
**Tipo:** Compatibilidade
**Criticidade:** Média
**Descrição:** Validar funcionamento em diferentes navegadores

**BDD:**
- **Dado** que acesso o Internet Banking em diferentes navegadores (Chrome, Firefox, Edge, Safari)
- **Quando** realizo uma transferência PIX via copia e cola
- **Então** a funcionalidade deve comportar-se identicamente
- **E** todas as interfaces devem manter consistência visual

**EVIDÊNCIAS:**

---

### CT-025: Responsividade da Interface
**Tipo:** Compatibilidade
**Criticidade:** Média
**Descrição:** Validar adaptação em diferentes resoluções de tela

**BDD:**
- **Dado** que acesso a funcionalidade em diferentes resoluções de tela
- **Quando** navego pelos menus da transferência PIX
- **Então** a interface deve adaptar-se adequadamente
- **E** todos os elementos devem permanecer acessíveis e legíveis

**EVIDÊNCIAS:**

---

## CASOS DE TESTE DE SEGURANÇA

### CT-026: Validação de Dados Sensíveis
**Tipo:** Segurança
**Criticidade:** Alta
**Descrição:** Verificar proteção de informações sensíveis

**BDD:**
- **Dado** que realizo uma transferência PIX
- **Quando** visualizo os comprovantes e telas
- **Então** dados sensíveis como CPF/CNPJ devem estar adequadamente mascarados
- **E** informações completas só devem aparecer quando necessário

**EVIDÊNCIAS:**

---

### CT-027: Timeout de Sessão
**Tipo:** Segurança
**Criticidade:** Alta
**Descrição:** Validar comportamento quando sessão expira durante transferência

**BDD:**
- **Dado** que inicio uma transferência PIX
- **Quando** minha sessão expira durante o processo
- **Então** devo ser redirecionado para tela de login
- **E** nenhuma informação da transação deve permanecer visível
- **E** devo poder retomar o processo após novo login

**EVIDÊNCIAS:**

---

## CASOS DE TESTE DE REGRESSÃO

### CT-028: Integração com Outras Funcionalidades PIX
**Tipo:** Regressão
**Criticidade:** Alta
**Descrição:** Validar que a nova funcionalidade não impacta outras funcionalidades PIX

**BDD:**
- **Dado** que a funcionalidade copia e cola foi implementada
- **Quando** acesso outras funcionalidades PIX (transferência por chave, QR Code)
- **Então** todas devem continuar funcionando normalmente
- **E** não deve haver conflitos entre as funcionalidades

**EVIDÊNCIAS:**

---

### CT-029: Teste de Códigos PIX Diversos
**Tipo:** Funcional / Exploratório
**Criticidade:** Média
**Descrição:** Testar diferentes tipos de códigos PIX

**BDD:**
- **Dado** que possuo diferentes códigos PIX (com valor, sem valor, expirados, inválidos)
- **Quando** testo cada tipo no campo "Código"
- **Então** o sistema deve tratar adequadamente cada situação
- **E** exibir mensagens apropriadas para códigos inválidos ou expirados

**EVIDÊNCIAS:**

---

## RESUMO DA COBERTURA DE TESTES

- **Total de Casos de Teste:** 29
- **Testes Funcionais:** 24
- **Testes Não Funcionais:** 3
- **Testes de Segurança:** 2

### Distribuição por Criticidade:
- **Alta:** 19 casos de teste
- **Média:** 10 casos de teste

### Cobertura por Menu:
- **Código PIX:** 5 casos
- **Valor:** 5 casos
- **Revisão:** 3 casos
- **Autenticação:** 3 casos
- **Confirmação:** 5 casos
- **Comprovante:** 3 casos

### Tipos de Teste Incluídos:
- ✅ Funcionais (navegação, interface, validação)
- ✅ Fluxos (com valor, sem valor, agendamento)
- ✅ Autenticação (PIN correto/incorreto)
- ✅ Performance
- ✅ Compatibilidade
- ✅ Segurança
- ✅ Regressão

**Objetivo:** Garantir que a funcionalidade de transferência PIX via copia e cola funcione corretamente em todos os cenários, mantendo segurança e boa experiência do usuário no Internet Banking PJ.