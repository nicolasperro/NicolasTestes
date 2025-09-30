# PLANO DE TESTES - CONFERIR E ALTERAR DADOS DE FUNCIONÁRIOS EM PAGAMENTOS AGRUPADOS

## INFORMAÇÕES GERAIS

**User Story:** Como usuário Domínio Escritório/Empresa, eu gostaria de conferir e alterar os dados dos funcionários agrupados das contas do tipo "Folha Mensal" e "13º Salario" da listagem de pendências do Internet Banking

**Descrição:** Permitir que usuários responsáveis por pagamentos agrupados visualizem e editem dados bancários dos funcionários diretamente pela listagem, garantindo que todos os dados necessários estejam completos antes de prosseguir com o pagamento via PIX.

**Criticidade:** ALTA - Funcionalidade crítica para processo de folha de pagamento e transferências PIX para funcionários

**Pré-condições Gerais:**
- Usuário logado no Internet Banking com perfil de Domínio Escritório/Empresa
- Existir pagamentos agrupados do tipo "Folha Mensal" ou "13º Salário" na listagem de pendências
- Acesso ao módulo de pagamentos agrupados (#845488)

---

## CASOS DE TESTE

### CT-001: Acesso e Visualização da Listagem de Funcionários
**Tipo:** Funcional / Acesso
**Criticidade:** Alta
**Descrição:** Verificar acesso à listagem de funcionários de pagamento agrupado

**BDD:**
- **Dado** que o usuário está logado no Internet Banking
- **E** existe um pagamento agrupado pendente
- **Quando** o usuário acessa a listagem de funcionários
- **Então** deve visualizar todos os funcionários da folha
- **E** cada linha de funcionário deve ser clicável

**EVIDÊNCIAS:**

### CT-002: Abertura da Modal de Detalhes do Funcionário
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar abertura da modal ao clicar em funcionário

**BDD:**
- **Dado** que o usuário está na listagem de funcionários
- **Quando** clicar em uma linha de funcionário
- **Então** deve abrir uma modal no lado direito da tela
- **E** a modal deve conter o título "Detalhes do pagamento"

**EVIDÊNCIAS:**

### CT-003: Exibição de Informações na Modal - Primeiro Quadro
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar exibição do valor no primeiro quadro da modal

**BDD:**
- **Dado** que a modal de detalhes está aberta
- **Quando** verificar o primeiro quadro
- **Então** deve exibir o campo "Valor" com o valor sendo transferido

**EVIDÊNCIAS:**

### CT-004: Exibição de Informações na Modal - Segundo Quadro
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar informações do funcionário e tipo de transferência

**BDD:**
- **Dado** que a modal de detalhes está aberta
- **Quando** verificar o segundo quadro
- **Então** deve exibir o nome do funcionário
- **E** deve exibir "PIX" como tipo de transferência

**EVIDÊNCIAS:**

---

### CT-005: Campo Tipo de Chave Preenchido pelo Contador
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Verificar campo tipo de chave quando informado pelo contador

**BDD:**
- **Dado** que o contador informou um tipo de chave para o funcionário
- **Quando** abrir a modal de detalhes
- **Então** o campo "Tipo de chave" deve vir preenchido com o tipo informado

**EVIDÊNCIAS:**

---

### CT-006: Campo Tipo de Chave Sem Informação do Contador
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Verificar campo tipo de chave quando não informado pelo contador

**BDD:**
- **Dado** que o contador não informou tipo de chave para o funcionário
- **Quando** abrir a modal de detalhes
- **Então** o campo "Tipo de chave" deve ficar em branco

**EVIDÊNCIAS:**

### CT-007: Edição do Campo Tipo de Chave
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar opções disponíveis para tipo de chave

**BDD:**
- **Dado** que a modal de detalhes está aberta
- **Quando** clicar no campo "Tipo de chave"
- **Então** deve exibir as opções de chaves PIX disponíveis
- **E** deve incluir: Celular, E-mail, CPF/CNPJ, Chave Aleatória, Agência e conta

**EVIDÊNCIAS:**

---

### CT-008: Seleção de Tipo de Chave "Agência e Conta"
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar habilitação de campos para agência e conta

**BDD:**
- **Dado** que a modal de detalhes está aberta
- **Quando** selecionar "Agência e conta" no tipo de chave
- **Então** deve habilitar os campos: Banco, Agência e Conta
- **E** o campo Banco deve abrir listagem de bancos ao clicar

**EVIDÊNCIAS:**

---

### CT-009: Validação de Chave PIX - Celular
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Verificar validação de chave PIX tipo celular

**BDD:**
- **Dado** que selecionei "Celular" como tipo de chave
- **Quando** inserir um número com formato inválido
- **Então** deve exibir mensagem de erro
- **E** aceitar apenas DDD + número com 10 a 11 dígitos

**EVIDÊNCIAS:**

---

### CT-010: Validação de Chave PIX - E-mail
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Verificar validação de chave PIX tipo e-mail

**BDD:**
- **Dado** que selecionei "E-mail" como tipo de chave
- **Quando** inserir um e-mail com formato inválido
- **Então** deve exibir mensagem de erro
- **E** exigir formato válido com "@"

**EVIDÊNCIAS:**

### CT-011: Campo CPF/CNPJ Preenchido Automaticamente
**Tipo:** Funcional / Validação
**Criticidade:** Média
**Descrição:** Verificar preenchimento automático de CPF/CNPJ

**BDD:**
- **Dado** que selecionei "CPF/CNPJ" como tipo de chave
- **Quando** verificar o campo
- **Então** deve estar preenchido automaticamente
- **E** não deve permitir edição

**EVIDÊNCIAS:**

---

### CT-012: Chave Aleatória - Mensagem Informativa
**Tipo:** Funcional / Interface
**Criticidade:** Média
**Descrição:** Verificar mensagem para chave aleatória

**BDD:**
- **Dado** que selecionei "Chave Aleatória" como tipo de chave
- **Quando** verificar a interface
- **Então** não deve exibir campo de entrada
- **E** deve mostrar mensagem "Cadastre uma chave aleatória como chave PIX"

**EVIDÊNCIAS:**

---

### CT-013: Habilitação do Botão "Salvar Informações"
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar condições para habilitar botão salvar

**BDD:**
- **Dado** que a modal de detalhes está aberta
- **Quando** todos os campos obrigatórios estiverem preenchidos corretamente
- **Então** o botão "Salvar Informações" deve ficar habilitado

**EVIDÊNCIAS:**

---

### CT-014: Desabilitação do Botão "Salvar Informações"
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar botão salvar com campos incompletos

**BDD:**
- **Dado** que a modal de detalhes está aberta
- **Quando** algum campo obrigatório estiver vazio ou inválido
- **Então** o botão "Salvar Informações" deve permanecer desabilitado

**EVIDÊNCIAS:**

---

### CT-015: Funcionalidade do Botão "Voltar"
**Tipo:** Funcional / Navegação
**Criticidade:** Média
**Descrição:** Verificar retorno da modal

**BDD:**
- **Dado** que a modal de detalhes está aberta
- **Quando** clicar no ícone de retorno ao lado do título
- **Então** deve fechar a modal
- **E** retornar à listagem de funcionários

**EVIDÊNCIAS:**

### CT-016: Identificação de Funcionários com Dados Pendentes
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Verificar alerta para funcionários primeira vez no account_payables

**BDD:**
- **Dado** que existe funcionário sendo enviado pela primeira vez ao account_payables
- **Quando** visualizar a listagem
- **Então** deve exibir alerta "Dados pendentes" abaixo do nome

**EVIDÊNCIAS:**

---

### CT-017: Mensagem de Impedimento de Avanço
**Tipo:** Funcional / Regra de Negócio
**Criticidade:** Alta
**Descrição:** Verificar bloqueio de avanço com dados pendentes

**BDD:**
- **Dado** que existem funcionários com dados bancários pendentes
- **Quando** tentar avançar no processo
- **Então** deve exibir mensagem "Não é possível prosseguir. Há funcionários com dados bancários pendentes. Atualize os dados ou desmarque-os para continuar."

**EVIDÊNCIAS:**

---

### CT-018: Remoção de Alerta Após Salvar Dados
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Verificar remoção de alerta após completar dados

**BDD:**
- **Dado** que um funcionário possui alerta "Dados pendentes"
- **Quando** acessar a modal e salvar informações completas
- **Então** o alerta "Dados pendentes" deve desaparecer da listagem

**EVIDÊNCIAS:**

---

### CT-019: Acesso à Tela de Revisão
**Tipo:** Funcional / Navegação
**Criticidade:** Alta
**Descrição:** Verificar navegação para tela de revisão

**BDD:**
- **Dado** que todos os dados obrigatórios foram preenchidos
- **Quando** clicar no botão "Avançar"
- **Então** deve ser direcionado para a tela de "Revisão"
- **E** exibir título "Revise os dados e confirme o pagamento"

**EVIDÊNCIAS:**

---

### CT-020: Exibição de Valor Total na Revisão
**Tipo:** Funcional / Cálculo
**Criticidade:** Alta
**Descrição:** Verificar cálculo do valor total na revisão

**BDD:**
- **Dado** que está na tela de revisão
- **Quando** verificar o primeiro quadro
- **Então** deve exibir "Valor Total" com soma dos funcionários selecionados

**EVIDÊNCIAS:**

### CT-021: Informações do Segundo Quadro da Revisão
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar informações do pagamento na revisão

**BDD:**
- **Dado** que está na tela de revisão
- **Quando** verificar o segundo quadro
- **Então** lado esquerdo deve mostrar tipo de pagamento e tipo de transferência
- **E** lado direito deve mostrar quantidade de funcionários e data de pagamento

**EVIDÊNCIAS:**

---

### CT-022: Funcionalidade de Agendamento PIX
**Tipo:** Funcional / Agendamento
**Criticidade:** Média
**Descrição:** Verificar agendamento de pagamento PIX

**BDD:**
- **Dado** que está na tela de revisão
- **Quando** clicar no ícone de calendário
- **Então** deve permitir agendar o pagamento PIX
- **E** atualizar a data de pagamento no formato DD/MM/AAAA

**EVIDÊNCIAS:**

---

### CT-023: Informações de Funcionários Pendentes
**Tipo:** Funcional / Interface
**Criticidade:** Média
**Descrição:** Verificar dados de funcionários não selecionados

**BDD:**
- **Dado** que existem funcionários desmarcados
- **Quando** verificar o terceiro quadro da revisão
- **Então** deve exibir "Valor Pendente" e "Quantidade de funcionários pendente"

**EVIDÊNCIAS:**

---

### CT-024: Mensagem Informativa sobre Funcionários Desmarcados
**Tipo:** Funcional / Interface
**Criticidade:** Média
**Descrição:** Verificar mensagem sobre funcionários pendentes

**BDD:**
- **Dado** que está na tela de revisão
- **Quando** verificar o final da tela
- **Então** deve exibir mensagem "Os funcionários desmarcados por falta de dados bancários permanecerão na lista de pagamentos pendentes..."

**EVIDÊNCIAS:**

---

### CT-025: Botão "Voltar" na Tela de Revisão
**Tipo:** Funcional / Navegação
**Criticidade:** Média
**Descrição:** Verificar retorno da tela de revisão

**BDD:**
- **Dado** que está na tela de revisão
- **Quando** clicar no botão "Voltar"
- **Então** deve retornar para o menu "Valor"

**EVIDÊNCIAS:**

### CT-026: Confirmação de Pagamento e Inserção de PIN
**Tipo:** Funcional / Fluxo Completo
**Criticidade:** Alta
**Descrição:** Verificar fluxo de confirmação de pagamento

**BDD:**
- **Dado** que está na tela de revisão
- **Quando** clicar em "Confirmar pagamento"
- **Então** deve ser direcionado para inserção do PIN
- **E** aplicar regras da versão de mercado para PIN

**EVIDÊNCIAS:**

---

### CT-027: Seleção Parcial de Funcionários para Pagamento
**Tipo:** Funcional / Cálculo
**Criticidade:** Alta
**Descrição:** Verificar pagamento de funcionários selecionados

**BDD:**
- **Dado** que existem múltiplos funcionários na listagem
- **Quando** selecionar apenas alguns funcionários
- **Então** os campos de valores devem ser atualizados conforme somatório dos selecionados

**EVIDÊNCIAS:**

---

### CT-028: Atualização da Listagem Após Pagamento
**Tipo:** Funcional / Pós-processamento
**Criticidade:** Alta
**Descrição:** Verificar atualização da listagem pós-pagamento

**BDD:**
- **Dado** que o pagamento foi processado com sucesso
- **Quando** retornar à listagem
- **Então** deve atualizar para mostrar apenas funcionários pendentes
- **E** remover funcionários pagos da listagem

**EVIDÊNCIAS:**

---

### CT-029: Validação de Campos Obrigatórios - Agência e Conta
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Verificar validação completa para agência e conta

**BDD:**
- **Dado** que selecionei "Agência e conta" como tipo de chave
- **Quando** deixar algum campo (Banco, Agência ou Conta) vazio
- **Então** o botão "Salvar Informações" deve permanecer desabilitado
- **E** deve indicar campos obrigatórios

**EVIDÊNCIAS:**

---

### CT-030: Teste de Múltiplas Sessões de Edição
**Tipo:** Funcional / Persistência
**Criticidade:** Média
**Descrição:** Verificar comportamento com múltiplas edições

**BDD:**
- **Dado** que salvei dados de um funcionário
- **Quando** abrir novamente a modal do mesmo funcionário
- **Então** deve manter as informações salvas anteriormente
- **E** permitir nova edição se necessário

**EVIDÊNCIAS:**

---

## RESUMO DE COBERTURA

**Total de Casos de Teste:** 30

**Distribuição por Criticidade:**
- Alta: 22 casos (73,3%)
- Média: 8 casos (26,7%)

**Funcionalidades Cobertas:**
- ✅ Acesso e visualização da listagem
- ✅ Abertura e navegação da modal
- ✅ Edição de dados bancários
- ✅ Validação de tipos de chave PIX
- ✅ Gestão de pendências e alertas
- ✅ Fluxo de revisão e confirmação
- ✅ Agendamento de pagamentos
- ✅ Processamento seletivo de funcionários
- ✅ Atualização pós-pagamento

**Critérios de Aceite Mapeados:**
- ✅ Acesso e Visualização (CT-001, CT-002)
- ✅ Edição de Dados Bancários (CT-003 a CT-015, CT-029)
- ✅ Pendências e Alertas (CT-016 a CT-018)
- ✅ Fluxo de Revisão (CT-019 a CT-026)
- ✅ Finalização (CT-027, CT-028, CT-030)

**Observações:**
- Todos os critérios de aceite foram cobertos por casos de teste específicos
- Validações de diferentes tipos de chave PIX contempladas
- Fluxo completo desde visualização até confirmação de pagamento testado
- Cenários de erro e validação incluídos para maior robustez