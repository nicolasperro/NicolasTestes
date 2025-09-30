# PLANO DE TESTES - US: Correção Bug Exportação PDF Android

**User Story:** Como usuário do Domínio Minha empresa ou Domínio Meu escritório quero poder realizar a exportação em PDF do meu Extrato para Apps comuns dentro do meu aparelho celular ANDROID V11 ou menor.

**Tipo:** Correção de Bug  
**Contexto:** Funcionalidade já desenvolvida mas com bug impedindo exportação em Android V11 ou menor

---

## CASOS DE TESTE DE CORREÇÃO - ANDROID V11 OU MENOR

### CT-001: Exportação Bem-sucedida para Email - Android V11
**Tipo:** Funcional / Bug Fix
**Criticidade:** Alta
**Descrição:** Validar que a exportação de PDF funciona corretamente para aplicativos de email em Android V11

**BDD:**
- **Dado** que estou logado no SuperApp com uma conta que possui movimentações financeiras
- **E** estou usando um dispositivo Android versão 11
- **Quando** acesso o extrato e seleciono "Exportar PDF"
- **E** escolho um aplicativo de email para compartilhar
- **Então** devo ser redirecionado para o aplicativo de email escolhido
- **E** o PDF do extrato deve estar anexado no email
- **E** ao retornar ao SuperApp, devo ver a tela de sucesso da exportação

**EVIDÊNCIAS:**

---

### CT-002: Exportação Bem-sucedida para WhatsApp - Android V11
**Tipo:** Funcional / Bug Fix
**Criticidade:** Alta
**Descrição:** Validar que a exportação de PDF funciona corretamente para WhatsApp em Android V11

**BDD:**
- **Dado** que estou logado no SuperApp com extrato populado
- **E** estou usando um dispositivo Android versão 11
- **Quando** tento exportar o extrato em PDF
- **E** seleciono WhatsApp na lista de aplicativos
- **Então** devo ser redirecionado para o WhatsApp
- **E** o PDF deve estar disponível para envio
- **E** ao retornar ao SuperApp, a tela de sucesso deve ser exibida

**EVIDÊNCIAS:**

---

### CT-003: Exportação para Salvar em Arquivos - Android V11
**Tipo:** Funcional / Bug Fix
**Criticidade:** Alta
**Descrição:** Validar que é possível salvar o PDF diretamente nos arquivos do dispositivo Android V11

**BDD:**
- **Dado** que estou no extrato da conta com movimentações
- **E** estou usando Android versão 11
- **Quando** seleciono exportar PDF
- **E** escolho a opção "Salvar em arquivos" ou similar
- **Então** devo ser direcionado para o gerenciador de arquivos
- **E** conseguir salvar o PDF no local desejado
- **E** ver a confirmação de sucesso no SuperApp

**EVIDÊNCIAS:**

---

### CT-004: Exportação para Instagram - Android V11
**Tipo:** Funcional / Bug Fix
**Criticidade:** Média
**Descrição:** Validar exportação para aplicativos de redes sociais como Instagram

**BDD:**
- **Dado** que possuo extrato com movimentações financeiras
- **E** estou usando dispositivo Android V11
- **Quando** exporto o extrato em PDF
- **E** seleciono Instagram na lista de compartilhamento
- **Então** devo ser redirecionado para o Instagram
- **E** o PDF deve estar disponível para compartilhamento
- **E** a tela de sucesso deve aparecer ao retornar

**EVIDÊNCIAS:**

---

### CT-005: Teste em Android V10 - Regressão
**Tipo:** Regressão
**Criticidade:** Alta
**Descrição:** Verificar que a correção não quebrou funcionalidade em versões anteriores

**BDD:**
- **Dado** que estou usando um dispositivo Android versão 10
- **E** possuo extrato com movimentações
- **Quando** exporto o extrato em PDF para qualquer aplicativo
- **Então** o fluxo deve funcionar normalmente
- **E** devo ser redirecionado corretamente para o app escolhido
- **E** ver a tela de sucesso ao retornar

**EVIDÊNCIAS:**

---

### CT-006: Teste em Android V9 - Regressão
**Tipo:** Regressão
**Criticidade:** Média
**Descrição:** Verificar funcionamento em versões mais antigas

**BDD:**
- **Dado** que estou usando Android versão 9
- **E** tenho extrato populado na conta
- **Quando** realizo exportação PDF para email
- **Então** o processo deve ser concluído com sucesso
- **E** não deve haver regressões na funcionalidade

**EVIDÊNCIAS:**

---

## CASOS DE TESTE DE VALIDAÇÃO - CENÁRIOS ESPECÍFICOS

### CT-007: Validação com Múltiplas Opções de App - Android V11
**Tipo:** Funcional / Exploratório
**Criticidade:** Média
**Descrição:** Testar exportação com diferentes aplicativos disponíveis no dispositivo

**BDD:**
- **Dado** que tenho múltiplos apps de compartilhamento instalados
- **E** estou usando Android V11
- **Quando** exporto o PDF do extrato
- **Então** devo ver a lista completa de aplicativos disponíveis
- **E** conseguir exportar para qualquer um deles com sucesso

**EVIDÊNCIAS:**

---

### CT-008: Cancelamento da Exportação - Android V11
**Tipo:** Funcional / Fluxo Alternativo
**Criticidade:** Média
**Descrição:** Validar comportamento quando usuário cancela a exportação

**BDD:**
- **Dado** que inicio o processo de exportação PDF
- **E** estou em Android V11
- **Quando** a lista de aplicativos é exibida
- **E** pressiono "Voltar" ou cancelo a ação
- **Então** devo retornar ao extrato
- **E** não deve aparecer tela de sucesso indevida

**EVIDÊNCIAS:**

---

### CT-009: Extrato Vazio - Android V11
**Tipo:** Funcional / Caso Limite
**Criticidade:** Baixa
**Descrição:** Testar exportação de extrato sem movimentações

**BDD:**
- **Dado** que possuo uma conta sem movimentações financeiras
- **E** estou usando Android V11
- **Quando** tento exportar o extrato vazio em PDF
- **Então** o sistema deve gerar PDF mesmo vazio
- **E** permitir compartilhamento normal

**EVIDÊNCIAS:**

---

### CT-010: Teste de Interrupção de Rede - Android V11
**Tipo:** Funcional / Robustez
**Criticidade:** Média
**Descrição:** Validar comportamento com problemas de conectividade

**BDD:**
- **Dado** que inicio exportação do extrato
- **E** durante o processo a conexão é perdida
- **Quando** a rede é restaurada
- **Então** o sistema deve tratar o erro adequadamente
- **E** não exibir falso sucesso

**EVIDÊNCIAS:**

---

## CASOS DE TESTE NÃO FUNCIONAIS

### CT-011: Performance da Exportação - Android V11
**Tipo:** Performance
**Criticidade:** Média
**Descrição:** Validar tempo de geração e compartilhamento do PDF

**BDD:**
- **Dado** que tenho extrato com muitas movimentações (>100 itens)
- **E** estou usando Android V11
- **Quando** exporto para PDF
- **Então** o processo deve ser concluído em até 10 segundos
- **E** não deve travar a interface

**EVIDÊNCIAS:**

---

### CT-012: Compatibilidade Multi-dispositivo Android
**Tipo:** Compatibilidade
**Criticidade:** Alta
**Descrição:** Testar em diferentes modelos e marcas Android V11

**BDD:**
- **Dado** que possuo diferentes dispositivos Android V11 (Samsung, Motorola, LG, etc.)
- **Quando** testo a exportação PDF em cada um
- **Então** o comportamento deve ser consistente
- **E** todos devem redirecionar corretamente para apps escolhidos

**EVIDÊNCIAS:**

---

### CT-013: Teste de Memória - Android V11
**Tipo:** Performance / Robustez
**Criticidade:** Média
**Descrição:** Validar comportamento com pouca memória disponível

**BDD:**
- **Dado** que o dispositivo Android V11 tem pouca memória disponível
- **Quando** exporto um extrato grande em PDF
- **Então** o sistema deve gerenciar a memória adequadamente
- **E** não deve falhar ou travar

**EVIDÊNCIAS:**

---

## CASOS DE TESTE DE SEGURANÇA

### CT-014: Validação de Dados Sensíveis no PDF
**Tipo:** Segurança
**Criticidade:** Alta
**Descrição:** Verificar se dados sensíveis estão protegidos no PDF gerado

**BDD:**
- **Dado** que exporto extrato com dados financeiros
- **Quando** o PDF é compartilhado
- **Então** os dados devem estar formatados adequadamente
- **E** informações sensíveis devem estar mascaradas conforme LGPD

**EVIDÊNCIAS:**

---

### CT-015: Teste de Integridade do Arquivo PDF
**Tipo:** Segurança / Qualidade
**Criticidade:** Média
**Descrição:** Validar que o PDF gerado não está corrompido

**BDD:**
- **Dado** que exporto extrato em PDF
- **Quando** o arquivo é compartilhado
- **Então** o PDF deve abrir corretamente em visualizadores
- **E** todos os dados devem estar legíveis e íntegros

**EVIDÊNCIAS:**

---

## RESUMO DA COBERTURA DE TESTES

- **Total de Casos de Teste:** 15
- **Testes de Correção de Bug:** 6
- **Testes de Regressão:** 3
- **Testes Não Funcionais:** 4
- **Testes de Segurança:** 2

### Distribuição por Criticidade:
- **Alta:** 8 casos de teste
- **Média:** 6 casos de teste
- **Baixa:** 1 caso de teste

### Cobertura de Versões Android:
- **Android V11:** 10 casos específicos
- **Android V10:** 2 casos de regressão
- **Android V9:** 1 caso de regressão
- **Multi-versão:** 2 casos

### Aplicativos Testados:
- ✅ Email
- ✅ WhatsApp
- ✅ Instagram
- ✅ Salvar em arquivos
- ✅ Múltiplos apps

### Tipos de Teste Incluídos:
- ✅ Bug Fix (correção principal)
- ✅ Regressão (versões anteriores)
- ✅ Performance
- ✅ Compatibilidade
- ✅ Segurança
- ✅ Robustez
- ✅ Casos limite

**Objetivo:** Garantir que a correção do bug resolve o problema específico do Android V11 sem introduzir regressões e mantendo a qualidade da funcionalidade em todas as versões suportadas.
