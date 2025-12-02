# ProjetoFinalBackAvancado

##  Membros desevolvedores do projeto:

- Gustavo Santos, Kenji Sato, Kellyanne Karen e Layse Bruna.

##  O intuito Fábrica de Software tem como objetivo simular o funcionamento de uma fábrica real de desenvolvimento, onde aprendemos a construir a base de uma aplicação bem estruturada, seguindo boas práticas de engenharia de software.

## Tecnologias Utilizadas

- **Backend:** Java 21 e Spring Boot
- **Banco de Dados:** PostgreSQL

## Estrutura de Branches

- `main`: Branch principal de desenvolvimento, onde todas as alterações e novas funcionalidades serão implementadas e testadas.

## Como Clonar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/KenjiSato97/ProjetoFinalBackAvancado.git

2. **Acesse o diretório:**
   ```bash
   cd  ProjetoFinalBackAvancado

##  **Arquitetura de Pastas**

- **`config`**
  
  - *Configurações principais*:
    

- **`controller`** -> Que tem como objetivo definir as rotas e verifica as requisições do cliente.
  
 - *Controladores de Consulta*:
    
   - `AlunoQueryController`: Consulta e busca informações de Aluno via requisições HTTP.
   - `ProfessorQueryController`: Consulta e busca informações de Professor via requisições HTTP.
   - `StackQueryController`: Consulta e busca informações de Stacks via requisições HTTP.

 - *Controladores de Comando*:
    
   - `AlunoCommandController`:Cria, atualiza e deleta informações de Aluno via requisições HTTP.
   - `ProfessorCommandController`: Cria, atualiza e deleta informações de Professor via requisições HTTP.
   - `StackCommandController`: Cria, atualiza e deleta informações de Stacks via requisições HTTP.



- **`dtos`** -> Tem como objetivo fazer a transferencia de dados de uma forma mais efeiciente entre as camadas do sistema, ajudando a facilitar os dados enviados e recebidos.
  
  -  *Transferência de dados*:
    
  - `AlunoCreateRequest`: Cria um novo aluno. 
  - `AlunoUpdateRequest`: Atualiza dados de um aluno existente. 
  -  `ProfessorCreateRequest`: Cria um novo professor. 
  - `ProfessorUpdateRequest`: Atualiza dados de um professor existente. 
  - `ProjetoCreateRequest`: Cria um novo projeto. 
  - `ProjetoUpdateRequest`: Atualiza dados de um projetoo existente. 


 
  - `AlunoResponse`: Retorna dados completos do aluno (curso, período, stacks etc.).  
  - `ProjetoResponse`: Retorna informações resumidas de um projeto. 
  - `ProfessorResponse`: Retorna dados essenciais de um professor.

- **`enums`**  -> Contem os valores fixos, como nesse caso é o status da matrícula para o uso no sistema.
  
  -  *Entidades do sistema*: São as classes presentes em nosso projeto.
    
     - `Aluno`, `Projeto`, `Professor`.

- **`repository`** -> Auxiliando na interação da interface com o BD.
  
  - *Acesso ao banco de dados*:
    
  - `AlunoRepository`, `ProjetoRepository`, `StackRepository`.

- **`service`** -> Serve para implementar as regras de negócio, para processar os dados antes de enviar ou receber do banco de dados.
  
  - *Regras de negócio*:
    
  - `AlunoQueryService`, `ProfessorQueryService`, `ProjetoQueryService`, .

---

<details>
<summary>📦 Ver todos os endpoints via INSOMNIA em grade</summary>
  
<p align="center">
<img src="https://github.com/user-attachments/assets/6ba481cd-78e1-4d01-8944-e3c4925a4229" alt="Img 1" width="600" />
<img src="https://github.com/user-attachments/assets/35665ae5-9664-4ad2-a01b-754aa918a427" alt="Img 2" width="600" />
</p>
</details>
