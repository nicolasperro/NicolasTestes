# PLANO DE TESTES - US: Detecção de Transações PIX Duplicadas

**User Story:** Como usuário do App, ao iniciar, enviar ou agendar uma transação, quero ser alertado quando existir uma transação igual já realizada, em processamento ou agendada para o mesmo dia, para evitar duplicidade e decidir se irei prosseguir ou cancelar.

---

## CASOS DE TESTE FUNCIONAIS - DETECÇÃO DE DUPLICIDADE

### CT-001: Detecção de Transação Já Realizada
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar que o sistema detecta transações já realizadas conforme período definido

**BDD:**
- **Dado** que realizei uma transação PIX com dados específicos recentemente (dentro do período definido)
- **Quando** tento fazer uma nova transação com os mesmos dados
- **Então** o sistema deve detectar a duplicidade
- **E** exibir o alerta "Transação duplicada" antes da solicitação do PIN

**EVIDÊNCIAS:**

---

### CT-002: Detecção de Transação Em Processamento
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar que o sistema detecta transações que estão em processamento

**BDD:**
- **Dado** que tenho uma transação PIX em processamento com dados específicos
- **Quando** tento fazer uma nova transação com os mesmos dados
- **Então** o sistema deve detectar a duplicidade
- **E** exibir o alerta "Transação duplicada" antes da solicitação do PIN

**EVIDÊNCIAS:**

---

### CT-003: Detecção de Transação Agendada para Mesmo Dia
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar que o sistema detecta transações agendadas para o mesmo dia

**BDD:**
- **Dado** que tenho uma transação PIX agendada para hoje com dados específicos
- **Quando** tento fazer uma nova transação ou agendamento com os mesmos dados para hoje
- **Então** o sistema deve detectar a duplicidade
- **E** exibir o alerta "Transação duplicada" antes da solicitação do PIN

**EVIDÊNCIAS:**

---

### CT-004: Exibição de Mensagem - Transação Já Realizada
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Validar a mensagem específica para transações já realizadas

**BDD:**
- **Dado** que o sistema detectou uma transação já realizada
- **Quando** o alerta de duplicidade é exibido
- **Então** deve mostrar o título "Transação duplicada"
- **E** deve exibir a mensagem "Você já efetuou um pagamento com os mesmos dados recentemente. Tem certeza que deseja continuar com a transação? Se precisar de ajuda, entre em contato com nosso suporte."

**EVIDÊNCIAS:**

---

### CT-005: Exibição de Mensagem - Transação Em Processamento
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Validar a mensagem específica para transações em processamento

**BDD:**
- **Dado** que o sistema detectou uma transação em processamento
- **Quando** o alerta de duplicidade é exibido
- **Então** deve mostrar o título "Transação duplicada"
- **E** deve exibir a mensagem "Você já efetuou um pagamento com os mesmos dados recentemente. Tem certeza que deseja continuar com a transação? Se precisar de ajuda, entre em contato com nosso suporte."

**EVIDÊNCIAS:**

---

### CT-006: Exibição de Mensagem - Transação Agendada
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Validar a mensagem específica para transações agendadas

**BDD:**
- **Dado** que o sistema detectou uma transação agendada para hoje
- **Quando** o alerta de duplicidade é exibido
- **Então** deve mostrar o título "Transação duplicada"
- **E** deve exibir a mensagem "Você já agendou um pagamento com os mesmos dados para hoje. Tem certeza que deseja continuar com a transação? Se precisar de ajuda, entre em contato com nosso suporte."

**EVIDÊNCIAS:**

---

### CT-007: Funcionalidade Botão "Transferir Novamente"
**Tipo:** Funcional / Navegação
**Criticidade:** Alta
**Descrição:** Validar que o botão "Transferir novamente" permite prosseguir com a transação

**BDD:**
- **Dado** que o alerta de transação duplicada está sendo exibido
- **Quando** clico no botão "Transferir novamente"
- **Então** o alerta deve ser fechado
- **E** o sistema deve prosseguir com o fluxo normal de transferência
- **E** deve solicitar o PIN normalmente

**EVIDÊNCIAS:**

---

### CT-008: Funcionalidade Botão "Cancelar"
**Tipo:** Funcional / Navegação
**Criticidade:** Alta
**Descrição:** Validar que o botão "Cancelar" cancela a transação e retorna à área PIX

**BDD:**
- **Dado** que o alerta de transação duplicada está sendo exibido
- **Quando** clico no botão "Cancelar"
- **Então** o alerta deve ser fechado
- **E** a transação deve ser cancelada
- **E** devo retornar para a área PIX

**EVIDÊNCIAS:**

---

### CT-009: Priorização de Motivos - Múltiplas Duplicidades
**Tipo:** Funcional / Lógica de Negócio
**Criticidade:** Alta
**Descrição:** Validar que o sistema exibe apenas o motivo mais relevante quando há múltiplas duplicidades

**BDD:**
- **Dado** que tenho transações com os mesmos dados: uma já realizada, uma em processamento e uma agendada
- **Quando** tento fazer uma nova transação com esses dados
- **Então** o sistema deve exibir apenas uma mensagem
- **E** deve priorizar na ordem: em processamento > agendada > já realizada

**EVIDÊNCIAS:**

---

### CT-010: Timing do Alerta - Antes do PIN
**Tipo:** Funcional / Fluxo
**Criticidade:** Alta
**Descrição:** Validar que o alerta aparece antes da solicitação do PIN

**BDD:**
- **Dado** que estou fazendo uma transação PIX duplicada
- **Quando** preencho todos os dados da transação
- **E** prossigo para finalizar
- **Então** o alerta de duplicidade deve aparecer antes da tela de PIN
- **E** o PIN não deve ser solicitado até que eu escolha uma ação

**EVIDÊNCIAS:**

---

## CASOS DE TESTE DE VALIDAÇÃO

### CT-011: Validação de Critérios de Igualdade
**Tipo:** Funcional / Validação
**Criticidade:** Média
**Descrição:** Validar quais dados são considerados para determinar transações iguais

**BDD:**
- **Dado** que tenho uma transação PIX realizada
- **Quando** faço uma nova transação alterando apenas um campo (ex: descrição)
- **Então** devo validar se o sistema considera como duplicada ou não
- **E** confirmar quais campos são usados na comparação

**EVIDÊNCIAS:**

---

### CT-012: Transações Similares Mas Não Iguais
**Tipo:** Funcional / Validação
**Criticidade:** Média
**Descrição:** Validar que transações similares mas com dados diferentes não são consideradas duplicadas

**BDD:**
- **Dado** que realizei uma transação PIX para um destinatário
- **Quando** faço uma nova transação para o mesmo destinatário com valor diferente
- **Então** o sistema não deve detectar como duplicada
- **E** deve permitir prosseguir sem alerta

**EVIDÊNCIAS:**

---

### CT-013: Período de Detecção de Transações Realizadas
**Tipo:** Funcional / Validação
**Criticidade:** Média
**Descrição:** Validar o período considerado para transações já realizadas

**BDD:**
- **Dado** que realizei uma transação PIX há X tempo (conforme período definido)
- **Quando** faço uma transação idêntica
- **Então** devo validar se ainda é detectada como duplicada
- **E** confirmar os limites temporais da detecção

**EVIDÊNCIAS:**

---

### CT-014: Transações Agendadas para Dias Diferentes
**Tipo:** Funcional / Validação
**Criticidade:** Média
**Descrição:** Validar que transações agendadas para dias diferentes não são detectadas como duplicadas

**BDD:**
- **Dado** que tenho uma transação PIX agendada para amanhã
- **Quando** faço uma transação ou agendamento igual para hoje
- **Então** o sistema não deve detectar como duplicada
- **E** deve permitir prosseguir sem alerta

**EVIDÊNCIAS:**

---

## CASOS DE TESTE NÃO FUNCIONAIS

### CT-015: Teste de Performance - Detecção de Duplicidade
**Tipo:** Performance
**Criticidade:** Média
**Descrição:** Validar que a verificação de duplicidade não impacta significativamente a performance

**BDD:**
- **Dado** que estou fazendo uma transação PIX
- **Quando** o sistema verifica duplicidades
- **Então** a verificação deve ser concluída em até 3 segundos
- **E** não deve causar travamentos na interface

**EVIDÊNCIAS:**

---

### CT-016: Teste de Disponibilidade - Falha na Verificação
**Tipo:** Confiabilidade
**Criticidade:** Média
**Descrição:** Validar comportamento quando o serviço de verificação de duplicidade falha

**BDD:**
- **Dado** que o serviço de verificação de duplicidade está indisponível
- **Quando** tento fazer uma transação PIX
- **Então** o sistema deve permitir prosseguir com a transação
- **E** deve registrar o erro para monitoramento

**EVIDÊNCIAS:**

---

### CT-017: Teste de Segurança - Bypass da Verificação
**Tipo:** Segurança
**Criticidade:** Alta
**Descrição:** Tentar burlar a verificação de duplicidade

**BDD:**
- **Dado** que existe uma transação duplicada
- **Quando** tento manipular a requisição para ignorar a verificação
- **Então** o sistema deve manter a verificação no backend
- **E** deve exibir o alerta independente de manipulações frontend

**EVIDÊNCIAS:**

---

## CASOS DE TESTE DE REGRESSÃO

### CT-018: Teste de Regressão - Fluxo Normal Sem Duplicidade
**Tipo:** Regressão
**Criticidade:** Alta
**Descrição:** Validar que transações sem duplicidade seguem o fluxo normal

**BDD:**
- **Dado** que estou fazendo uma transação PIX única (sem duplicidades)
- **Quando** prossigo com a transação
- **Então** não deve aparecer nenhum alerta de duplicidade
- **E** o fluxo deve prosseguir diretamente para a solicitação do PIN

**EVIDÊNCIAS:**

---

### CT-019: Teste de Integração com Feature Flags
**Tipo:** Regressão / Integração
**Criticidade:** Alta
**Descrição:** Validar funcionamento com feature flags ativadas/desativadas

**BDD:**
- **Dado** que a feature de detecção de duplicidade possui uma feature flag
- **Quando** a flag está ativada, a detecção deve funcionar normalmente
- **E** quando a flag está desativada, não deve haver verificação
- **Então** a transição entre estados não deve causar erros

**EVIDÊNCIAS:**

---

### CT-020: Teste de Múltiplos Usuários
**Tipo:** Funcional / Concorrência
**Criticidade:** Média
**Descrição:** Validar que a detecção funciona corretamente para múltiplos usuários simultâneos

**BDD:**
- **Dado** que múltiplos usuários fazem transações simultaneamente
- **Quando** alguns deles têm transações duplicadas
- **Então** cada usuário deve ver apenas alertas de suas próprias duplicidades
- **E** não deve haver interferência entre usuários diferentes

**EVIDÊNCIAS:**

---

## RESUMO DA COBERTURA DE TESTES

- **Total de Casos de Teste:** 20
- **Testes Funcionais:** 16
- **Testes Não Funcionais:** 4
- **Critérios de Aceite Cobertos:** 100%

### Distribuição por Criticidade:
- **Alta:** 14 casos de teste
- **Média:** 6 casos de teste

### Cenários de Duplicidade Cobertos:
- **Transação já realizada:** 4 casos
- **Transação em processamento:** 2 casos  
- **Transação agendada:** 3 casos
- **Múltiplas duplicidades:** 1 caso

### Técnicas de Teste Aplicadas:
- Particionamento de Equivalência
- Análise de Valor Limite
- Teste de Estado da Interface
- Teste de Lógica de Negócio
- Teste de Concorrência
- Teste de Feature Flag

### Tipos de Teste Incluídos:
- ✅ Funcionais
- ✅ Interface
- ✅ Validação
- ✅ Navegação
- ✅ Lógica de Negócio
- ✅ Regressão
- ✅ Performance
- ✅ Confiabilidade
- ✅ Segurança
- ✅ Integração
