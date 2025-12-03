# ProjetoFinalBackAvancado

##  Membros desevolvedores do projeto:

- Gustavo Santos, Kenji Sato, Kellyanne Karen e Layse Bruna.

##  O projeto Fábrica de Software tem como objetivo simular o funcionamento de uma fábrica real de desenvolvimento, onde aprendemos a construir a base de uma aplicação bem estruturada, seguindo boas práticas de engenharia de software.

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

- **`enums`**  -> Contem os valores fixos.
  
  - `Curso`, `Período`. 
  
  -  *Entidades do sistema*: São as classes presentes em nosso projeto.
    
     - `Aluno`, `Projeto`, `Stack`, `Professor`.
   
   - `Aluno`: Representa um participante em formação na fábrica, contendo informações pessoais, curso, período, projeto que está alocado e stacks que está aprendendo. É o principal executor das tarefas dos projetos.  
  - `Projeto`: Entidade que descreve uma atividade que o aluno está alocado, contendo tecnologias necessárias e responsáveis. Conecta alunos, professores e stacks para organizar o fluxo de desenvolvimento.
  - `Stack`: Entidade que contém um conjunto de tecnologias que descreve o que um aluno, professor ou projeto utiliza. Serve para categorizar competências e requisitos técnicos.
  - `Professor`: Entidade responsável por orientar projetos e alunos, armazenando dados como nome, área de atuação e stacks que domina.

- **`repository`** -> Auxiliando na interação da interface com o BD.
  
  - *Acesso ao banco de dados*:
    
  - `AlunoRepository`, `ProjetoRepository`, `StackRepository`.

- **`service`** -> Serve para implementar as regras de negócio, para processar os dados antes de enviar ou receber do banco de dados.
  
  - *Regras de negócio*:
    
  - `AlunoQueryService`, `ProfessorQueryService`, `ProjetoQueryService`, .

---

<details>
<summary>📦 Diagrama Banco de Dados </summary>
  
<p align="center">
<img src="https://github.com/user-attachments/assets/2fd1d7a0-2ca4-4475-a17c-e5a760a5d6e2" alt="Img 1" width="450" />
</p>
</details>


<details>
<summary>📦 Ver todos os endpoints via INSOMNIA em grade</summary>
  
<p align="center">
<img src="https://github.com/user-attachments/assets/8fc86889-cf7f-4228-80e5-be3350c1ef9f" alt="Img 1" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/405ddbd6-a537-4515-b8a6-f491847d9255" alt="Img 2" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/ddd958d3-ab73-4582-a88a-e93b23a8d300" alt="Img 3" width="500" />
</p>
<p align="center">  
<img src="https://github.com/user-attachments/assets/0a9f8a0b-2e1a-42b6-80dd-f109005b30ad" alt="Img 4" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/7637c3eb-e9e4-4d8e-82bb-2b1201239f8c" alt="Img 5" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/94382ab6-3418-4cfd-b99d-4e34920d0aa3" alt="Img 6" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/a41060b6-ffa2-45dc-851a-1b4d65ab173c" alt="Img 7" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/20f3ea81-c4cb-4905-81d9-220ec43fda20" alt="Img 8" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/409ca869-637d-44c1-a067-df4be18f415a" alt="Img 9" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/7fb984d6-16f2-4462-b784-fb0bec997799" alt="Img 10" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/1b4e317e-0e7c-4fa3-a09e-58c9589cb226" alt="Img 11" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/dd069a6b-2d5c-4ce8-8a82-e0eedb084251" alt="Img 12" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/d4bbeb56-aa16-4042-a155-39397fdd7020" alt="Img 13" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/93c1fcf2-50d2-4f98-81dd-73ab47ecfa3e" alt="Img 14" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/96da74f5-1a72-4f04-a273-4d5808926df1" alt="Img 15" width="500" /> 
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/855c40f7-ea54-4c0b-8ca3-3eb101ea07a0" alt="Img 16" width="500" /> 
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/9b02ee0c-2418-47cb-9f37-13f7b5ab1ae7" alt="Img 17" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/2c9cfdd5-171b-4e83-b0c5-39886f2c08f8" alt="Img 18" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/66618720-ff38-40b0-9d00-dea453dff123" alt="Img 19" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/e2b52dc7-afdd-4587-b9ba-7b9cde28cf8f" alt="Img 20" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/1cb2c551-bcd6-4008-bec8-2ad4241ecc55" alt="Img 21" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/612c9d4a-3be4-41f9-8ab8-2e51834d613f" alt="Img 22" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/28c19598-8fb3-477b-8af5-ffe7f2ff2360" alt="Img 23" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/736187da-7ae1-4c27-903d-6b0be959ae3f" alt="Img 24" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/08eaa341-4c18-4c9d-b24a-31e4cca20d5a" alt="Img 25" width="500" />
</p>
<p align="center">
<img src="https://github.com/user-attachments/assets/9a9499f1-48b5-409a-a896-52cf1aefea75" alt="Img 26" width="500" />
</p>
</details>
