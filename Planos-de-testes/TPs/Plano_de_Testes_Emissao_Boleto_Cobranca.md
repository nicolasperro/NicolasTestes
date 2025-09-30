# PLANO DE TESTES - EMISSÃO DE BOLETO DE COBRANÇA NO INTERNET BANKING

## INFORMAÇÕES GERAIS

**User Story:** Como usuário Domínio Escritório/Empresa, eu gostaria de emitir boleto de cobrança no Internet Banking

**Descrição:** Permitir que clientes PJ do Internet Banking acessem o menu "A receber" e gerem boletos personalizados para cobrança através de um fluxo estruturado com três etapas: Informações, Pagador e Boleto Gerado.

**Criticidade:** ALTA - Funcionalidade crítica para gestão de recebíveis e cobrança de clientes PJ

**Pré-condições Gerais:**
- Usuário logado no Internet Banking com perfil PJ (Pessoa Jurídica)
- Acesso liberado para área "Conta PJ"
- Permissões para gerar boletos de cobrança

---

## CASOS DE TESTE

### CT-001: Acesso ao Menu "A Receber"
**Tipo:** Funcional / Acesso
**Criticidade:** Alta
**Descrição:** Verificar acesso ao menu "A receber" na área Conta PJ

**BDD:**
- **Dado** que sou um cliente PJ logado no Internet Banking
- **Quando** acesso a área "Conta PJ"
- **E** clico no menu "A receber"
- **Então** devo visualizar as opções disponíveis do menu
- **E** deve estar disponível a opção "Gerar Cobrança"

**EVIDÊNCIAS:**

---

### CT-002: Acesso à Funcionalidade "Gerar Cobrança"
**Tipo:** Funcional / Navegação
**Criticidade:** Alta
**Descrição:** Verificar acesso à funcionalidade de geração de boleto

**BDD:**
- **Dado** que estou no menu "A receber"
- **Quando** clico na opção "Gerar Cobrança"
- **Então** devo ser direcionado para a tela com três menus
- **E** deve exibir os menus: "Informações", "Pagador" e "Boleto gerado"
- **E** o menu "Informações" deve estar ativo inicialmente

**EVIDÊNCIAS:**

---

### CT-003: Exibição da Tela "Informações" - Elementos Básicos
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar exibição correta dos elementos básicos da tela Informações

**BDD:**
- **Dado** que estou na tela de geração de boleto
- **Quando** visualizo o menu "Informações"
- **Então** deve exibir o título "Complete as informações sobre a cobrança"
- **E** deve conter o campo "Valor" no formato R$00,00
- **E** deve exibir a mensagem "Digite um valor a partir de 5,00" abaixo do campo valor
- **E** deve conter o campo "Data de vencimento" com ícone de calendário

**EVIDÊNCIAS:**

---

### CT-004: Validação do Campo Valor - Valor Mínimo
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Verificar validação de valor mínimo R$ 5,00 no campo Valor

**BDD:**
- **Dado** que estou preenchendo as informações do boleto
- **Quando** informar um valor menor que R$ 5,00
- **E** tentar avançar
- **Então** deve exibir mensagem de erro indicando valor mínimo
- **E** não deve permitir prosseguir

**EVIDÊNCIAS:**

---

### CT-005: Formato do Campo Valor
**Tipo:** Funcional / Formatação
**Criticidade:** Alta
**Descrição:** Verificar formatação correta do campo Valor

**BDD:**
- **Dado** que estou preenchendo o campo "Valor"
- **Quando** digitar valores numéricos
- **Então** deve aplicar formatação automática R$ XX.XXX,XX
- **E** deve aceitar apenas valores numéricos
- **E** deve aplicar separadores de milhares e decimais corretos

**EVIDÊNCIAS:**

---

### CT-006: Campo Data de Vencimento - Calendário
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar funcionalidade do calendário no campo Data de Vencimento

**BDD:**
- **Dado** que estou na tela "Informações"
- **Quando** clico no ícone de calendário do campo "Data de vencimento"
- **Então** deve abrir um calendário interativo
- **E** deve permitir selecionar uma data
- **E** a data selecionada deve ser preenchida no campo no formato DD/MM/AAAA

**EVIDÊNCIAS:**

---

### CT-007: Campo Data de Vencimento - Digitação Manual
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar entrada manual de data no formato DD/MM/AAAA

**BDD:**
- **Dado** que estou preenchendo a data de vencimento
- **Quando** digitar uma data manualmente
- **Então** deve aceitar o formato DD/MM/AAAA
- **E** deve aplicar máscara de formatação automaticamente
- **E** deve validar se a data é válida

**EVIDÊNCIAS:**

---

### CT-008: Campos Juros e Multa
**Tipo:** Funcional / Interface
**Criticidade:** Média
**Descrição:** Verificar funcionalidade dos campos Juros mensais e Multa por atraso

**BDD:**
- **Dado** que estou na tela "Informações"
- **Quando** preencher os campos "Juros mensais (%)" e "Multa por atraso (%)"
- **Então** deve aceitar apenas valores numéricos
- **E** deve aplicar formatação percentual
- **E** deve permitir valores decimais

**EVIDÊNCIAS:**

---

### CT-009: Checkbox "Aplicar Desconto" - Estado Inicial
**Tipo:** Funcional / Interface
**Criticidade:** Média
**Descrição:** Verificar estado inicial do checkbox Aplicar Desconto

**BDD:**
- **Dado** que estou na tela "Informações"
- **Quando** visualizo a seção de desconto
- **Então** deve exibir o checkbox "Aplicar desconto" desmarcado
- **E** deve exibir a mensagem "Habilite esta opção para oferecer um desconto ao pagador caso o boleto seja pago antes da data de vencimento"
- **E** os campos de desconto não devem estar visíveis

**EVIDÊNCIAS:**

---

### CT-010: Habilitação de Campos de Desconto
**Tipo:** Funcional / Interface
**Criticidade:** Média
**Descrição:** Verificar habilitação de campos ao marcar checkbox de desconto

**BDD:**
- **Dado** que estou na tela "Informações"
- **Quando** marcar o checkbox "Aplicar desconto"
- **Então** deve exibir o título "Escolha o tipo de desconto que deseja oferecer"
- **E** deve exibir as opções "Percentual" e "Valor"
- **E** nenhuma opção deve estar selecionada inicialmente

**EVIDÊNCIAS:**

---

### CT-011: Desconto Percentual - Habilitação de Campos
**Tipo:** Funcional / Interface
**Criticidade:** Média
**Descrição:** Verificar habilitação de campos ao selecionar desconto percentual

**BDD:**
- **Dado** que marquei "Aplicar desconto"
- **Quando** selecionar a opção "Percentual"
- **Então** deve habilitar o campo "Desconto (%)"
- **E** deve habilitar o campo "Data limite para desconto" com calendário
- **E** deve permitir digitação manual da data no formato DD/MM/AAAA

**EVIDÊNCIAS:**

---

### CT-012: Desconto Valor - Habilitação de Campos
**Tipo:** Funcional / Interface
**Criticidade:** Média
**Descrição:** Verificar habilitação de campos ao selecionar desconto por valor

**BDD:**
- **Dado** que marquei "Aplicar desconto"
- **Quando** selecionar a opção "Valor"
- **Então** deve habilitar o campo "Valor do desconto" 
- **E** deve aceitar valores em reais com formatação R$ XX,XX
- **E** deve habilitar o campo "Data limite para desconto" com calendário

**EVIDÊNCIAS:**

---

### CT-013: Botão "Voltar" - Menu Informações
**Tipo:** Funcional / Navegação
**Criticidade:** Média
**Descrição:** Verificar funcionalidade do botão Voltar na tela Informações

**BDD:**
- **Dado** que estou na tela "Informações"
- **Quando** clico no botão "Voltar"
- **Então** devo ser redirecionado para a home do menu "A receber"
- **E** os dados preenchidos devem ser perdidos

**EVIDÊNCIAS:**

---

### CT-014: Botão "Avançar" - Menu Informações
**Tipo:** Funcional / Navegação
**Criticidade:** Alta
**Descrição:** Verificar avanço da tela Informações para Pagador

**BDD:**
- **Dado** que preenchi todos os campos obrigatórios da tela "Informações"
- **Quando** clico no botão "Avançar"
- **Então** devo ser direcionado para o menu "Pagador"
- **E** o menu "Informações" deve ficar verde com ícone de confirmado
- **E** o menu "Pagador" deve ficar ativo

**EVIDÊNCIAS:**

---

### CT-015: Validação de Campos Obrigatórios - Informações
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Verificar validação de campos obrigatórios antes de avançar

**BDD:**
- **Dado** que estou na tela "Informações"
- **Quando** deixar campos obrigatórios em branco
- **E** tentar clicar em "Avançar"
- **Então** deve exibir mensagens de erro nos campos obrigatórios
- **E** não deve permitir avançar para próxima tela

**EVIDÊNCIAS:**

---

### CT-016: Menu "Pagador" - Primeiro Quadro
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar elementos do primeiro quadro da tela Pagador

**BDD:**
- **Dado** que estou na tela "Pagador"
- **Quando** visualizo o primeiro quadro
- **Então** deve exibir o título "Complete as informações sobre o pagador"
- **E** deve conter o campo "Nome do pagador"
- **E** deve conter o campo "CPF/CNPJ" numérico

**EVIDÊNCIAS:**

---

### CT-017: Validação Campo CPF/CNPJ - CPF
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Verificar validação e identificação de CPF (11 dígitos)

**BDD:**
- **Dado** que estou preenchendo o campo "CPF/CNPJ"
- **Quando** informar 11 dígitos numéricos
- **Então** deve identificar como CPF
- **E** deve aplicar máscara XXX.XXX.XXX-XX
- **E** deve validar se o CPF é válido

**EVIDÊNCIAS:**

---

### CT-018: Validação Campo CPF/CNPJ - CNPJ
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Verificar validação e identificação de CNPJ (14 dígitos)

**BDD:**
- **Dado** que estou preenchendo o campo "CPF/CNPJ"
- **Quando** informar 14 dígitos numéricos
- **Então** deve identificar como CNPJ
- **E** deve aplicar máscara XX.XXX.XXX/XXXX-XX
- **E** deve validar se o CNPJ é válido

**EVIDÊNCIAS:**

---

### CT-019: Menu "Pagador" - Segundo Quadro
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar elementos do segundo quadro da tela Pagador

**BDD:**
- **Dado** que estou na tela "Pagador"
- **Quando** visualizo o segundo quadro
- **Então** deve exibir o título "Complete as informações sobre o endereço do pagador"
- **E** deve conter os campos: CEP, Logradouro, Número, Complemento, Bairro
- **E** deve conter a opção "Sem número"
- **E** deve conter o campo "Descrição da cobrança"

**EVIDÊNCIAS:**

---

### CT-020: Validação Campo CEP
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Verificar validação e preenchimento automático via CEP

**BDD:**
- **Dado** que estou preenchendo o endereço do pagador
- **Quando** informar um CEP válido
- **Então** deve aplicar máscara XXXXX-XXX
- **E** deve preencher automaticamente Logradouro e Bairro
- **E** deve manter foco no campo Número

**EVIDÊNCIAS:**

---

### CT-021: Opção "Sem Número"
**Tipo:** Funcional / Interface
**Criticidade:** Média
**Descrição:** Verificar funcionalidade da opção "Sem número"

**BDD:**
- **Dado** que estou preenchendo o endereço
- **Quando** marcar a opção "Sem número"
- **Então** o campo "Número" deve ficar desabilitado
- **E** deve preencher automaticamente "S/N" ou similar
- **E** deve permitir prosseguir sem informar número

**EVIDÊNCIAS:**

---

### CT-022: Regras de Mercado - Campos de Endereço
**Tipo:** Funcional / Validação
**Criticidade:** Alta
**Descrição:** Verificar aplicação de regras de mercado nos campos de endereço

**BDD:**
- **Dado** que estou preenchendo campos de endereço
- **Quando** informar dados inválidos ou incompletos
- **Então** deve aplicar validações conforme regras de mercado
- **E** deve exibir mensagens de erro apropriadas
- **E** deve impedir preenchimento de caracteres especiais onde não permitido

**EVIDÊNCIAS:**

---

### CT-023: Botão "Voltar" - Menu Pagador
**Tipo:** Funcional / Navegação
**Criticidade:** Média
**Descrição:** Verificar retorno da tela Pagador para Informações

**BDD:**
- **Dado** que estou na tela "Pagador"
- **Quando** clico no botão "Voltar"
- **Então** devo retornar para o menu "Informações"
- **E** os dados da tela "Informações" devem estar preservados
- **E** o menu "Informações" deve voltar ao estado ativo

**EVIDÊNCIAS:**

---

### CT-024: Botão "Avançar" - Menu Pagador
**Tipo:** Funcional / Navegação
**Criticidade:** Alta
**Descrição:** Verificar avanço da tela Pagador para Boleto Gerado

**BDD:**
- **Dado** que preenchi todos os campos obrigatórios da tela "Pagador"
- **Quando** clico no botão "Avançar"
- **Então** devo ser direcionado para o menu "Boleto gerado"
- **E** o menu "Pagador" deve ficar verde com ícone de confirmado
- **E** o boleto deve ser gerado com os dados informados

**EVIDÊNCIAS:**

---

### CT-025: Tela "Boleto Gerado" - Informações Exibidas
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar informações exibidas na tela de boleto gerado

**BDD:**
- **Dado** que o boleto foi gerado com sucesso
- **Quando** visualizo a tela "Boleto gerado"
- **Então** deve exibir o título "O boleto da cobrança foi gerado, envie o código de barras, url ou QR code para o pagador"
- **E** deve exibir: Nome do pagador, CPF/CNPJ do pagador, Valor, Vencimento
- **E** todas as informações devem corresponder aos dados informados

**EVIDÊNCIAS:**

---

### CT-026: Campo Código de Barras
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar funcionalidade do campo código de barras

**BDD:**
- **Dado** que estou na tela "Boleto gerado"
- **Quando** visualizo o campo "Código de barras"
- **Então** deve exibir o código numérico completo
- **E** deve conter ícone para copiar o código
- **E** ao clicar no ícone, deve copiar o código para área de transferência

**EVIDÊNCIAS:**

---

### CT-027: QR Code PIX
**Tipo:** Funcional / Interface
**Criticidade:** Alta
**Descrição:** Verificar exibição do QR Code para pagamento PIX

**BDD:**
- **Dado** que estou na tela "Boleto gerado"
- **Quando** visualizo a seção de QR Code
- **Então** deve exibir um QR Code válido para pagamento PIX
- **E** o QR Code deve conter as informações corretas do boleto
- **E** deve ser escaneável por aplicativos de pagamento

**EVIDÊNCIAS:**

---

### CT-028: Botão "Baixar Boleto" - Abertura PDF
**Tipo:** Funcional / Geração PDF
**Criticidade:** Alta
**Descrição:** Verificar abertura do PDF do boleto em tela

**BDD:**
- **Dado** que estou na tela "Boleto gerado"
- **Quando** clico no botão "Baixar boleto"
- **Então** o PDF do boleto deve ser aberto em tela
- **E** deve conter todas as informações do boleto formatadas corretamente
- **E** deve estar disponível opção "Baixar boleto" no canto superior

**EVIDÊNCIAS:**

---

### CT-029: Download do PDF do Boleto
**Type:** Funcional / Download
**Criticidade:** Alta
**Descrição:** Verificar download do arquivo PDF do boleto

**BDD:**
- **Dado** que o PDF do boleto está aberto em tela
- **Quando** clico na opção "Baixar boleto" no canto superior
- **Então** deve iniciar o download do arquivo PDF
- **E** o arquivo deve ser salvo com nome apropriado
- **E** o PDF baixado deve estar íntegro e legível

**EVIDÊNCIAS:**

---

### CT-030: Fluxo Completo - Sem Desconto
**Tipo:** Funcional / Fluxo Completo
**Criticidade:** Alta
**Descrição:** Verificar fluxo completo de geração de boleto sem desconto

**BDD:**
- **Dado** que sou um cliente PJ autenticado
- **Quando** percorro todo o fluxo: Acesso → Informações → Pagador → Boleto Gerado
- **E** não aplico desconto
- **Então** deve gerar boleto com todas as informações corretas
- **E** deve permitir visualização, cópia do código e download do PDF

**EVIDÊNCIAS:**

---

### CT-031: Fluxo Completo - Com Desconto Percentual
**Tipo:** Funcional / Fluxo Completo
**Criticidade:** Alta
**Descrição:** Verificar fluxo completo com aplicação de desconto percentual

**BDD:**
- **Dado** que estou gerando um boleto
- **Quando** aplico desconto percentual com data limite
- **E** completo todo o fluxo
- **Então** o boleto gerado deve refletir as condições de desconto
- **E** deve conter informações sobre o desconto no PDF

**EVIDÊNCIAS:**

---

### CT-032: Fluxo Completo - Com Desconto por Valor
**Tipo:** Funcional / Fluxo Completo
**Criticidade:** Alta
**Descrição:** Verificar fluxo completo com aplicação de desconto por valor

**BDD:**
- **Dado** que estou gerando um boleto
- **Quando** aplico desconto por valor fixo com data limite
- **E** completo todo o fluxo
- **Então** o boleto gerado deve refletir o valor de desconto aplicado
- **E** deve calcular corretamente o valor líquido após desconto

**EVIDÊNCIAS:**

---

### CT-033: Validação de Autenticação PJ
**Tipo:** Segurança / Autorização
**Criticidade:** Alta
**Descrição:** Verificar que apenas clientes PJ têm acesso à funcionalidade

**BDD:**
- **Dado** que sou um usuário sem perfil PJ
- **Quando** tentar acessar o menu "A receber"
- **Então** não deve ter acesso à funcionalidade
- **E** deve exibir mensagem de acesso negado ou não exibir a opção

**EVIDÊNCIAS:**

---

### CT-034: Validação de Campos - Valores Extremos
**Tipo:** Funcional / Validação
**Criticidade:** Média
**Descrição:** Verificar comportamento com valores extremos nos campos

**BDD:**
- **Dado** que estou preenchendo os campos do boleto
- **Quando** inserir valores muito altos ou caracteres especiais
- **Então** deve aplicar validações apropriadas
- **E** deve limitar valores conforme regras de negócio
- **E** deve exibir mensagens de erro claras

**EVIDÊNCIAS:**

---

### CT-035: Performance - Geração de Boleto
**Tipo:** Performance
**Criticidade:** Média
**Descrição:** Verificar tempo de resposta na geração do boleto

**BDD:**
- **Dado** que preenchi todos os dados do boleto
- **Quando** clico em "Avançar" na tela Pagador
- **Então** o boleto deve ser gerado em até 5 segundos
- **E** deve haver indicador de progresso durante processamento

**EVIDÊNCIAS:**

---

### CT-035: Compatibilidade - Teste multi-browser
**Tipo:** Performance
**Criticidade:** Média
**Descrição:** Verificar funcionalidade igual em outros navegadores de internet

**BDD:**
- **Dado** que executo o flluxo de geração de boleto em diferentes browsers
- **Quando** executo os fluxos de geração de boleto
- **Então** a funcionalidade deve permanecer igual independentemente do navegador utilizado, sem comportamentos discrepantes

**EVIDÊNCIAS:**

---

### CT-035: Regressão - teste de funcionalidades gerais
**Tipo:** Performance
**Criticidade:** Média
**Descrição:** Verificar que outras funcionalidades padrões não foram impactadas

**BDD:**
- **Dado** que preenchi todos os dados do boleto
- **Quando** clico em "Avançar" na tela Pagador
- **Então** o boleto deve ser gerado em até 5 segundos
- **E** deve haver indicador de progresso durante processamento

**EVIDÊNCIAS:**

---

## RESUMO DE COBERTURA

**Total de Casos de Teste:** 35

**Distribuição por Criticidade:**
- Alta: 26 casos (74,3%)
- Média: 9 casos (25,7%)

**Funcionalidades Cobertas:**
- ✅ Acesso e navegação inicial
- ✅ Menu "Informações" - campos básicos e validações
- ✅ Sistema de desconto (percentual e valor)
- ✅ Menu "Pagador" - dados pessoais e endereço
- ✅ Menu "Boleto Gerado" - visualização e download
- ✅ Validações de CPF/CNPJ e endereço
- ✅ Funcionalidades de calendário e formatação
- ✅ Geração e download de PDF
- ✅ QR Code PIX
- ✅ Fluxos completos end-to-end
- ✅ Validações de segurança e autorização

**Critérios de Aceite Mapeados:**
- ✅ Acesso ao fluxo (CT-001, CT-002, CT-033)
- ✅ Tela "Informações" (CT-003 a CT-015)
- ✅ Tela "Pagador" (CT-016 a CT-024)
- ✅ Tela "Boleto gerado" (CT-025 a CT-029)
- ✅ Validações gerais (CT-030 a CT-035)

**Tipos de Teste Incluídos:**
- **Funcionais:** Interface, navegação, validação, fluxo completo
- **Segurança:** Autenticação e autorização PJ
- **Performance:** Tempo de geração de boleto
- **Usabilidade:** Formatação, máscaras e experiência do usuário

**Observações:**
- Cobertura completa de todos os três menus do fluxo
- Validações específicas para regras de mercado brasileiras
- Cenários de desconto contemplados (percentual e valor)
- Testes de integração com sistema de pagamento PIX
- Verificação de geração e integridade de PDF