# PLANO DE TESTES - US 02: Depósito por Boleto - Internet Banking PJ

**User Story:** Como cliente PJ do Internet Banking, quero acessar o menu "A receber" e clicar em "Depósito por boleto", para gerar um boleto e realizar um depósito na minha conta PJ.

---

## CASOS DE TESTE FUNCIONAIS

### CT-001: Acesso à funcionalidade de Depósito por Boleto
**Tipo:** Funcional
**Criticidade:** Alta
**Descrição:** Validar o acesso completo à funcionalidade de depósito por boleto através do menu A receber

**BDD:**
- **Dado** que sou um cliente PJ logado no Internet Banking
- **Quando** acesso a área "Conta PJ" > menu "A receber" > clico em "Depósito por boleto"
- **Então** devo ser direcionado para uma tela com os menus "Valor" e "Boleto gerado"

**EVIDÊNCIAS:**

---

### CT-002: Validação do Menu Valor - Elementos Visuais
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar se todos os elementos visuais do menu Valor estão presentes e corretos

**BDD:**
- **Dado** que estou na tela de "Depósito por boleto"
- **Quando** visualizo o menu "Valor"
- **Então** devo ver o título "Informe o valor que deseja depositar"
- **E** devo ver o campo "Valor" no formato R$ 00,00
- **E** devo ver a mensagem "Digite um valor a partir de R$ 5,00" abaixo do campo
- **E** devo ver os botões "Voltar" e "Avançar"

**EVIDÊNCIAS:**

---

### CT-003: Validação de Valor Mínimo - Valor Abaixo do Limite
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar que valores abaixo de R$ 5,00 impedem o avanço no fluxo

**BDD:**
- **Dado** que estou no menu "Valor" da tela de depósito por boleto
- **Quando** informo um valor inferior a R$ 5,00 (ex: R$ 4,99)
- **Então** o botão "Avançar" deve permanecer desabilitado
- **E** a mensagem de valor mínimo deve ser exibida

**EVIDÊNCIAS:**

---

### CT-004: Validação de Valor Mínimo - Valor Igual ao Limite
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Validar que o valor exato de R$ 5,00 habilita o botão Avançar

**BDD:**
- **Dado** que estou no menu "Valor" da tela de depósito por boleto
- **Quando** informo exatamente R$ 5,00
- **Então** o botão "Avançar" deve ficar habilitado
- **E** devo conseguir prosseguir para o próximo menu

**EVIDÊNCIAS:**

---

### CT-005: Validação de Valor Mínimo - Valor Acima do Limite
**Tipo:** Funcional / Validação
**Criticidade:** Média
**Descrição:** Validar que valores superiores a R$ 5,00 permitem o avanço no fluxo

**BDD:**
- **Dado** que estou no menu "Valor" da tela de depósito por boleto
- **Quando** informo um valor superior a R$ 5,00 (ex: R$ 100,00)
- **Então** o botão "Avançar" deve ficar habilitado
- **E** devo conseguir prosseguir para o próximo menu

**EVIDÊNCIAS:**

---

### CT-006: Funcionalidade do Botão Voltar
**Tipo:** Funcional / Navegação
**Criticidade:** Média
**Descrição:** Validar que o botão Voltar retorna à listagem de cobranças

**BDD:**
- **Dado** que estou no menu "Valor" da tela de depósito por boleto
- **Quando** clico no botão "Voltar"
- **Então** devo retornar para a listagem de cobranças do menu "A receber"

**EVIDÊNCIAS:**

---

### CT-007: Transição entre Menus - Confirmação Visual
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Validar a mudança visual do menu Valor após confirmar valor válido

**BDD:**
- **Dado** que estou no menu "Valor" com um valor válido informado (≥ R$ 5,00)
- **Quando** clico no botão "Avançar"
- **Então** o menu "Valor" deve ficar verde com ícone de confirmado
- **E** devo ser direcionado para o menu "Boleto gerado"

**EVIDÊNCIAS:**

---

### CT-008: Validação do Menu Boleto Gerado - Elementos Visuais
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar se todos os elementos do menu Boleto Gerado estão presentes

**BDD:**
- **Dado** que avancei para o menu "Boleto gerado"
- **Quando** visualizo a tela
- **Então** devo ver o título "O boleto de depósito foi gerado, utilize o código de barras para realizar o depósito na sua conta PJ"
- **E** devo ver o valor da cobrança gerada
- **E** devo ver o campo "Código de barras" com código gerado
- **E** devo ver o botão "Copiar código" ao lado do campo
- **E** devo ver a mensagem "Aguarde até 5 minutos para pagar. Não altere o código de barras ou pague em duplicidade."

**EVIDÊNCIAS:**

---

### CT-009: Funcionalidade Copiar Código de Barras
**Tipo:** Funcional
**Criticidade:** Alta
**Descrição:** Validar que o botão Copiar código funciona corretamente

**BDD:**
- **Dado** que estou no menu "Boleto gerado" com código de barras visível
- **Quando** clico no botão "Copiar código"
- **Então** o código de barras deve ser copiado para a área de transferência
- **E** devo conseguir colar o código em outro local

**EVIDÊNCIAS:**

---

### CT-010: Saída da Funcionalidade
**Tipo:** Funcional / Navegação
**Criticidade:** Média
**Descrição:** Validar que é possível sair da funcionalidade clicando em outras áreas

**BDD:**
- **Dado** que estou na tela de "Depósito por boleto"
- **Quando** clico em qualquer outra área/menu do sistema
- **Então** devo sair da tela de depósito por boleto
- **E** ser redirecionado para a área clicada

**EVIDÊNCIAS:**

---

### CT-011: Validação de Formato de Entrada - Caracteres Especiais
**Tipo:** Funcional / Validação
**Criticidade:** Média
**Descrição:** Validar que o campo Valor aceita apenas formato monetário correto

**BDD:**
- **Dado** que estou no campo "Valor" do menu de depósito
- **Quando** tento inserir caracteres especiais ou letras
- **Então** o campo deve aceitar apenas números e formato monetário
- **E** deve manter o formato R$ 00,00

**EVIDÊNCIAS:**

---

### CT-012: Teste de Regressão - Navegação Completa
**Tipo:** Regressão
**Criticidade:** Alta
**Descrição:** Validar o fluxo completo da funcionalidade após implementação

**BDD:**
- **Dado** que sou um cliente PJ logado no Internet Banking
- **Quando** executo o fluxo completo: acesso Conta PJ → A receber → Depósito por boleto → informo valor válido → avanço → visualizo boleto → copio código
- **Então** todo o fluxo deve funcionar sem erros
- **E** todas as funcionalidades devem estar operantes

**EVIDÊNCIAS:**

---

## CASOS DE TESTE NÃO FUNCIONAIS

### CT-013: Teste de Performance - Geração de Boleto
**Tipo:** Performance
**Criticidade:** Média
**Descrição:** Validar o tempo de resposta na geração do boleto

**BDD:**
- **Dado** que informo um valor válido no menu "Valor"
- **Quando** clico em "Avançar"
- **Então** o boleto deve ser gerado em até 5 segundos
- **E** a tela deve carregar completamente

**EVIDÊNCIAS:**

---

### CT-014: Teste de Compatibilidade Multi-browser
**Tipo:** Compatibilidade
**Criticidade:** Média
**Descrição:** Validar funcionamento em diferentes navegadores

**BDD:**
- **Dado** que acesso a funcionalidade em diferentes navegadores (Chrome, Firefox, Edge, Safari)
- **Quando** executo o fluxo de depósito por boleto
- **Então** a funcionalidade deve comportar-se identicamente em todos os navegadores
- **E** a interface deve manter a consistência visual

**EVIDÊNCIAS:**

---

### CT-015: Teste de Segurança - Autenticação
**Tipo:** Segurança
**Criticidade:** Alta
**Descrição:** Validar comportamento quando sessão expira durante uso

**BDD:**
- **Dado** que minha sessão expirou durante o uso da funcionalidade
- **Quando** tento realizar qualquer ação na tela de depósito
- **Então** devo ser redirecionado para a tela de login
- **E** nenhuma informação sensível deve permanecer visível

**EVIDÊNCIAS:**

---

## RESUMO DA COBERTURA DE TESTES

- **Total de Casos de Teste:** 15
- **Testes Funcionais:** 12
- **Testes Não Funcionais:** 3
- **Critérios de Aceite Cobertos:** 100%

### Distribuição por Criticidade:
- **Alta:** 9 casos de teste
- **Média:** 6 casos de teste

### Técnicas de Teste Aplicadas:
- Análise de Valor Limite
- Particionamento de Equivalência
- Teste de Caminho Feliz
- Checklist de Interface
- Teste de Fluxo Completo
- Teste Cross-browser

### Tipos de Teste Incluídos:
- ✅ Funcionais
- ✅ Interface
- ✅ Validação
- ✅ Navegação
- ✅ Regressão
- ✅ Performance
- ✅ Compatibilidade
- ✅ Segurança
