# PLANO DE TESTES - US: Trava para Transferências PIX Maior que R$ 15.000,00

**User Story:** Como cliente do app bancário, eu quero ser informado sobre o limite máximo por transação e ser impedido de avançar quando excedê-lo, para garantir que minhas transferências estejam em conformidade com as regras do Banco Central e evitar erros.

---

## CASOS DE TESTE FUNCIONAIS - APP

### CT-001: Exibição de Mensagem Informativa na Tela de Valor - APP
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Validar que a mensagem informativa sobre o limite máximo é exibida na tela de valor do PIX no APP

**BDD:**
- **Dado** que estou logado no app bancário
- **Quando** inicio uma transferência PIX e acesso a tela de informar o valor
- **Então** devo ver abaixo do saldo disponível a mensagem "O valor máximo permitido por transação é de R$15.000,00."

**EVIDÊNCIAS:**

---

### CT-002: Validação de Valor Acima do Limite - Interface de Erro - APP
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar que valores acima de R$ 15.000,00 ativam o estado de erro no campo de valor

**BDD:**
- **Dado** que estou na tela de valor da transferência PIX no APP
- **Quando** digito um valor maior que R$ 15.000,00 (ex: R$ 15.000,01)
- **Então** a caixa de input do valor deve ficar com estado de erro (borda vermelha)
- **E** o botão "Continuar" deve permanecer desabilitado

**EVIDÊNCIAS:**

---

### CT-003: Exibição de Mensagem de Limite Excedido - APP
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Validar que a mensagem explicativa sobre a norma do Banco Central é exibida quando o limite é excedido

**BDD:**
- **Dado** que estou na tela de valor da transferência PIX no APP
- **Quando** digito um valor maior que R$ 15.000,00
- **Então** deve ser exibido no final da tela o título "Limite de transferência por Operação"
- **E** deve ser exibida a mensagem "Por norma do Banco Central (Resolução BCB nº 496), desde 06/09/2025, o limite para transferências via Pix e TED é de R$15.000 por transação."

**EVIDÊNCIAS:**

---

### CT-004: Habilitação do Botão Continuar com Valor Válido - APP
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar que valores menores ou iguais a R$ 15.000,00 habilitam o botão Continuar

**BDD:**
- **Dado** que estou na tela de valor da transferência PIX no APP
- **Quando** informo um valor menor ou igual a R$ 15.000,00 e que não excede meu saldo disponível
- **Então** o botão "Continuar" deve ser habilitado
- **E** não deve haver mensagens de erro ativas no campo de valor

**EVIDÊNCIAS:**

---

### CT-005: Validação de Valor Limite Exato - APP
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar comportamento com valor exato de R$ 15.000,00

**BDD:**
- **Dado** que estou na tela de valor da transferência PIX no APP
- **Quando** informo exatamente R$ 15.000,00
- **Então** o botão "Continuar" deve permanecer habilitado
- **E** não deve haver mensagens de erro
- **E** não deve haver estado de erro no campo

**EVIDÊNCIAS:**

---

## CASOS DE TESTE FUNCIONAIS - IBK (INTERNET BANKING)

### CT-006: Exibição de Mensagem Informativa na Tela de Valor - IBK
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Validar que a mensagem informativa sobre o limite máximo é exibida na tela de valor do PIX no IBK

**BDD:**
- **Dado** que estou logado no Internet Banking (IBK)
- **Quando** inicio uma transferência PIX e acesso a tela de informar o valor
- **Então** devo ver abaixo do saldo disponível a mensagem "O valor máximo permitido por transação é de R$15.000,00."

**EVIDÊNCIAS:**

---

### CT-007: Validação de Valor Acima do Limite - IBK
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar que valores acima de R$ 15.000,00 exibem mensagem de aviso no IBK

**BDD:**
- **Dado** que estou na tela de valor da transferência PIX no IBK
- **Quando** digito um valor maior que R$ 15.000,00
- **Então** uma mensagem de aviso deve ser demonstrada no canto superior da tela
- **E** a mensagem deve conter "Por norma do Banco Central (Resolução BCB nº 496), desde 06/09/2025, o limite para transferências via Pix e TED é de R$15.000 por transação."
- **E** o botão "Avançar" deve permanecer desabilitado

**EVIDÊNCIAS:**

---

### CT-008: Habilitação do Botão Avançar com Valor Válido - IBK
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar que valores válidos habilitam o botão Avançar no IBK

**BDD:**
- **Dado** que estou na tela de valor da transferência PIX no IBK
- **Quando** informo um valor menor ou igual a R$ 15.000,00 e que não excede meu saldo disponível
- **Então** o botão "Avançar" deve ser habilitado
- **E** a mensagem de aviso deve desaparecer

**EVIDÊNCIAS:**

---

## CASOS DE TESTE DE VALIDAÇÃO

### CT-009: Validação de Saldo Insuficiente com Valor Dentro do Limite
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar que a regra de saldo insuficiente continua funcionando mesmo com valores dentro do limite

**BDD:**
- **Dado** que estou na tela de valor da transferência PIX
- **Quando** informo um valor menor que R$ 15.000,00 mas maior que meu saldo disponível
- **Então** o botão "Continuar/Avançar" deve permanecer desabilitado
- **E** deve ser exibida a mensagem de saldo insuficiente (regra atual)

**EVIDÊNCIAS:**

---

### CT-010: Teste de Valores Limite
**Tipo:** Funcional / Validação
**Criticidade:** Média
**Descrição:** Validar comportamento com valores próximos ao limite

**BDD:**
- **Dado** que estou na tela de valor da transferência PIX
- **Quando** testo os valores: R$ 14.999,99, R$ 15.000,00 e R$ 15.000,01
- **Então** para R$ 14.999,99 e R$ 15.000,00 o botão deve estar habilitado (se houver saldo)
- **E** para R$ 15.000,01 o botão deve estar desabilitado com mensagem de erro

**EVIDÊNCIAS:**

---

### CT-011: Correção de Valor Após Erro
**Tipo:** Funcional / Validação
**Criticidade:** Média
**Descrição:** Validar que ao corrigir um valor inválido, os erros são removidos

**BDD:**
- **Dado** que informei um valor acima de R$ 15.000,00 e o erro está sendo exibido
- **Quando** altero para um valor válido (≤ R$ 15.000,00)
- **Então** o estado de erro deve ser removido do campo
- **E** as mensagens de erro devem desaparecer
- **E** o botão "Continuar/Avançar" deve ser habilitado (se houver saldo)

**EVIDÊNCIAS:**

---

## CASOS DE TESTE NÃO FUNCIONAIS

### CT-012: Teste de Performance - Validação em Tempo Real
**Tipo:** Performance
**Criticidade:** Média
**Descrição:** Validar que a validação do limite ocorre em tempo real

**BDD:**
- **Dado** que estou digitando no campo de valor
- **Quando** ultrapasso o limite de R$ 15.000,00
- **Então** o estado de erro deve aparecer imediatamente (< 1 segundo)
- **E** a mensagem deve ser exibida sem delay perceptível

**EVIDÊNCIAS:**

---

### CT-013: Teste de Compatibilidade Multi-browser
**Tipo:** Compatibilidade
**Criticidade:** Média
**Descrição:** Validar funcionamento em diferentes navegadores (IBK)

**BDD:**
- **Dado** que acesso o IBK em diferentes navegadores (Chrome, Firefox, Edge, Safari)
- **Quando** testo a funcionalidade de limite PIX
- **Então** o comportamento deve ser idêntico em todos os navegadores
- **E** as mensagens devem ser exibidas corretamente

**EVIDÊNCIAS:**

---

### CT-014: Teste de Responsividade - APP
**Tipo:** Compatibilidade
**Criticidade:** Média
**Descrição:** Validar funcionamento em diferentes dispositivos móveis

**BDD:**
- **Dado** que acesso o APP em diferentes dispositivos (Android/iOS, diferentes tamanhos de tela)
- **Quando** testo a funcionalidade de limite PIX
- **Então** a interface deve se adaptar corretamente
- **E** as mensagens devem ser legíveis em todas as resoluções

**EVIDÊNCIAS:**

---

## CASOS DE TESTE DE REGRESSÃO

### CT-015: Teste de Regressão - Feature Flag
**Tipo:** Regressão
**Criticidade:** Alta
**Descrição:** Validar que a funcionalidade funciona corretamente com feature flag ativada/desativada

**BDD:**
- **Dado** que a feature flag está configurada
- **Quando** a flag está ativada, o limite de R$ 15.000,00 deve ser aplicado
- **E** quando a flag está desativada, o comportamento anterior deve ser mantido
- **Então** a transição entre os estados não deve causar erros na aplicação

**EVIDÊNCIAS:**

---

### CT-016: Teste de Integração com Regras Existentes
**Tipo:** Regressão / Integração
**Criticidade:** Alta
**Descrição:** Validar que as regras existentes de PIX continuam funcionando

**BDD:**
- **Dado** que a nova regra de limite foi implementada
- **Quando** executo um fluxo completo de transferência PIX com valor válido
- **Então** todas as validações anteriores (chave PIX, saldo, etc.) devem continuar funcionando
- **E** o fluxo deve ser concluído com sucesso

**EVIDÊNCIAS:**

---

## CASOS DE TESTE DE SEGURANÇA

### CT-017: Teste de Bypass de Validação
**Tipo:** Segurança
**Criticidade:** Alta
**Descrição:** Tentar burlar a validação de limite através de manipulação

**BDD:**
- **Dado** que a validação de limite está ativa
- **Quando** tento manipular o valor através de ferramentas de desenvolvedor ou requisições diretas
- **Então** a validação deve ser mantida no backend
- **E** valores acima de R$ 15.000,00 devem ser rejeitados

**EVIDÊNCIAS:**

---

## RESUMO DA COBERTURA DE TESTES

- **Total de Casos de Teste:** 17
- **Testes Funcionais:** 14
- **Testes Não Funcionais:** 3
- **Critérios de Aceite Cobertos:** 100%

### Distribuição por Criticidade:
- **Alta:** 12 casos de teste
- **Média:** 5 casos de teste

### Distribuição por Plataforma:
- **APP:** 5 casos específicos
- **IBK:** 3 casos específicos
- **Ambas plataformas:** 9 casos

### Técnicas de Teste Aplicadas:
- Análise de Valor Limite
- Particionamento de Equivalência
- Teste de Estado da Interface
- Teste de Regressão
- Teste de Feature Flag
- Teste de Segurança

### Tipos de Teste Incluídos:
- ✅ Funcionais
- ✅ Interface
- ✅ Validação
- ✅ Regressão
- ✅ Integração
- ✅ Performance
- ✅ Compatibilidade
- ✅ Segurança
- ✅ Feature Flag
