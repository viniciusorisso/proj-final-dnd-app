<p align="center">
  <img src="http://www.dnd5eapi.co/public/favicon.ico"/>
</p>
<hr>
<h1>Colaborador</h1>
- [Vinicius de Oliveira Risso](https://github.com/viniciusorisso)

<hr>
<h2>Sobre o trabalho</h2>

<p>Tenha uma imersão diferente com o aplicativo Dnd App, em sua primeira versão ele abraange a lista de magias, items base e com roladores de dados automáticos. Conta com uma interface simples e limpa para conseguir acessar as informações importantes com agilidade.</p>


<h2>Ferramentas</h2>
<p> O aplicativo Dnd App utilizou, além da api do [Dnd 5 edição](http://www.dnd5eapi.co/), cujo disponibilizou todos os dados das magias e equipamentos utilizados na aplicação. </p>
<p> Foi utilizado como base a IDE Android Studio, junto da linguagem Kotlin que oferece diversas features que ajudam no desenvolvimento se comparado com Java.</>
<p> Junto do Kotlin, utilizei o gerenciador de pacotes gradle, junto de outras libs que facilitaram (umas dificultaram o entendimento, mas ajudaram para a implementação de uma arquitetura baseada no Clean), sendo elas:
  Koin para utilizar o conceito de Injeção de dependências, Moshi que equivale ao Gson, mas com sintaxe um pouco diferente.
  Room para utilizar um equivalente à um SGBD local e Retrofit para ser um cliente HTTP para a aplicação</p>
  
<h2>Funcionalidades</h2>
<p> O aplicativo conta com algumas funcionalidades, sendo elas: a tela inicial, onde se pode rolar dados (d4, d6, d8, d10, d12, d20) e obter um valor randômico; a tela de spells, onde se tem uma lista de magias listadas pelo nome, se clicar vai para uma tela com mais informações; a tela de equipamentos, onde se tem uma lista de equipamentos listados pelo nome, se clicar vai para uma tela com mais informações; </p>

<h2>Implementação</h2>
<p> Alguns conceitos foram utilizados para o sistema funcionar de maneira mais próxima de um sistema de grande escala. A injeção de dependências com o Koin foi fundamental para a o funcionamento, existe um arquivo chamado Modules.kt, onde se está declarado todas as dependências. A ideia por trás foi muito interessante, mas gastei muito tempo tentando entender de fato como algumas coisas funcionavam. Em cima da comunicação Room + Retrofit também foram utilizadas hierarquias de pastas mais definidas para melhor organização em cima da arquitetura.
Existem pastas de domain e data, onde estão separados as classes model, das entidades, dtos, além dos mappers para fazer os respectivos parses, os repositories e etc. Dentro do padrão utilizado, também foi criada uma pasta util que tem classes que ajudaram a organizar mais as requests e os parsers. Infelizmente, o projeto que foi planejado precisou sofrer mudanças de escopo para sua versão, dado a quantidade de conceitos envolvidos por trás de utilizar uma arquitetura mais complexa e outras libs.
Também foi utilizado o getExtraString e putExtra para passagem de parâmetros entre as fragments e as activities de mais detalhes. De maneira geral, as telas possuem entre 2-3 arquivos, sendo o base (que herda da Fragment ou Activity), Adapter (onde tempos adaptadores importantes principalmente para o funcionamento das listas usando RecyclerViews) e as ViewModels. O padrão é bem didático, mas pode ser confuso as vezes já que, pessoalmente, tive muito problema com passagens de contexto por parâmetros.
Por fim, também foi utilizado uma base na arquitetura Model-View-ViewModel (MVVM) fornecendo limpeza e clareza no código.</p>


<h2>Imagens do App</h2>
<div align="center" max-height="400px">
  <img src="https://user-images.githubusercontent.com/32266875/216913841-9baedfe0-9f84-495a-ae62-35280aff44c3.png" />
  <img src="https://user-images.githubusercontent.com/32266875/216913885-7dd583b2-5c9d-444b-a5ad-e013ba6474ea.png" />
  <img src="https://user-images.githubusercontent.com/32266875/216913926-b549f491-861a-46ff-a494-57ef500ffc11.png" />
  <img src="https://user-images.githubusercontent.com/32266875/216913992-afdabbff-f383-453e-b3cb-0f6882a4903b.png" />

</div>

- [Youtube Vídeo](https://youtu.be/Wbytjb4bjIc)
