package br.ufla.gac111.s2021_2.Turhrock;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Jogo 
{
    private Analisador analisador;
    private Ambiente ambienteAtual, ambienteAnterior;
    Ambiente inicio, cemiterio, vale, florestaNPs, florestaNPn, qg, astoufo, lab, sala2, sala4, ninho, sala3, sala8, balcao, sala5, cripta, sala0, dormitorio, sala7, templo, mundoC, ambienteRitual, sala6, escritorio, quartos, sala1, sala9, morte, sala10, ambienteLoja;
    private Pocao pocao1, pocao2, pocao3, pocao4, pocao5;
    private Acessorio item0, item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, item16, item17, item18, item19;
    private Armadura item20, item21, item22, item23;
    private Personagem personagem;
    private Loja loja;
    private String nomePocao;
    private ArrayList<Item> produtos;
    Scanner entrada = new Scanner(System.in);
    Random geracao = new Random();
    Item produto1, produto2, produto3, produto4, produto5;
    
    /**
     * Cria o jogo e incializa seu mapa interno e itens.
     */
    public Jogo() 
    {
        criarItens();
        criarAmbientes();
        analisador = new Analisador();
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes()
    {
        inicio = new Ambiente("do lado de fora da Taberna do Astoufo, bem no meio da rua, localizado no centro da cidade de Keyford.\n \n °Você consegue enxergar um caminho que segue para a saida norte. \n °Você consegue enxergar um caminho que segue para a saida leste. \n °Você percebe que a astoufo está cheia e funcionando... provavelmente tem comida boa la dentro.\n", "comum");
        cemiterio = new Ambiente("no cemiterio abandonado da antiga civilização de Keyford. \n\n °Você vê uma trilha que segue ao oeste. \n °Você vê uma outra trilha menor que segue ao sul. \n °Você vê uma enorme cripta na parte leste \n °Você enxerga um tumulo semi aberto, ao se aproximar percebe que este é a entrada para algum lugar...\n", "comum", pocao1);
        vale = new Ambiente("num vale do lado de fora de Keyford. \n\n °Você vê uma trilha que segue em direção para a parte norte Floresta Negra. \n °Você vê ao leste uma entrada esquecida para dentro da Floresta Negra... \n °Você vê um coelho seguindo para uma passagem que segue para uma trilha que fica a margem da Floresta Negra. \n °Você vê os portões de Keyford ao sul.\n", "comum");
        florestaNPs = new Ambiente("na parte sul da floresta negra...\nEstá floresta é famosa por esconder segredos  misticos e abrigar criaturas terriveis. \n\n...você passa um tempo caminhando...\n\n °Você encontra uma trilha que segue para o norte. \n °Você vê um caminho que segue para Keyford. \n °Você descobre um buraco instigante... você sente que poderia explora-lo.\n", "comum");
        florestaNPn = new Ambiente("na parte norte da floresta negra...\nEstá floresta é famosa por esconder segredos  misticos e abrigar criaturas terriveis. \n\n...você passa um tempo caminhando...\n\n °Você avista na sua frente o que parece ser a entrada de um templo antigo...\n", "comum");
        qg = new Ambiente("no Centro de operações secretas de uma guilda famosa em Turhrock \nAparentemente ninguem te viu ai... por enquanto. \nMais a frente existe uma sala que emana uma aura magica e perigosa... ao se aproximar você encontra um portal desativado... \n\n °Você vê ao leste um quarto, cujo qual está com a lucessas e barulhos veem de la. \n °Você vê uma escada que sai para o lado de fora.\n", "comum", pocao1);
        astoufo = new Ambiente("na melhor astoufo da cidade. \n\n °Você vê ao norte o balcão do bar, aparentemente está acontecendo alguma coisa ali. \n °Você vê ao leste uma porta meio aberta. \n °Você vê ao oeste um corredor que da na ala dos quartos.\n", "comum");
        lab = new Ambiente("numa sala quadrada feita de tijolos antigos, ao que parece esta esquecida a muito tempo...\nA sua chegada ativou alguma armadilha que bloqueou a passagem de volt... \n\n °Você vê uma sala ao norte. \n °Você vê uma outra sala ao leste. \n °Você vê outra sala ao sul. \n Você vê outra sala ao oeste.\n", "comum");
        sala2 = new Ambiente("em uma sala igual a anterior, entretanto é possivel ver vestigios de um acampamento ja abandonado. \n... você procura entre os entulhos... \n\n °Você vê o caminho para a sala anterior.\n", "comum", pocao2);
        sala4 = new Ambiente("uma sala um pouco destuida, as paredes estão todas rachadas e a terra invade o local... \n\n °Você vê um caminnho que segue para a proxima sala ao norte. \n °Você vê uma entrada que emana luz ao leste. \n °Você vê o caminho para a sala ao sul.\n", "comum");
        
        ninho = new Ambiente("numa trilha proxima a Floresta Negra... \n", "batalha", 0);
        sala3 = new Ambiente("numa sala com corpos mortos de animais... é possivel ver acima de sua cabeça uma passagem causada põr um antigoronamento...\n... você tenta passar por la para sai, mas nenhum esforço é o suficiente... \n\n °Você vê um caminho para seguir ao norte. \n °Você vê outro caminho para seguir ao sul. \n °Você vê uma pequena passagem aao canto da sala, ela esta coberta com teias de aranha mas talvez seja uma saida.\n", "batalha", 0);
        sala8 = new Ambiente("AS BESTAS DO LABIRINTO", "batalha", 0);//*
        
        balcao = new Ambiente("na mesa da astoufo do Astoufo. \n\nNa sua frente está o astoufo, um reptiliano que usa roupas comuns e um avental branquissimo. \nEle olha pra você e se mostra pensativo e te serve uma caneca de cerveja!\nApós beber e comer alguma coisa. \n °Você vê ao sul um caminho.\n", "batalha", 1);
        sala5 = new Ambiente("numa sala normal do labirinto... foi aqui onde você foi atacado mais cedo. \nEstranhamente, a acustica aqui é muito boa, da pra ouvir o som das criaturas ao longe... \n\n °Você vê o caminho de volta para a outra sala do labirinto.\n", "batalha", 1);      
        
        cripta = new Ambiente("OS LADRÕES DE TUMULOS", "batalha", 2);//*
        sala0 = new Ambiente("numa sala vazia do labirinto, aparentemente, alguem estava escavando por aqui... \n\n °Você vê o caminho de volta.\n", "batalha", 2);
        
        dormitorio = new Ambiente("BANDO DE FORAS DA LEI", "batalha", 3);//*
        sala7 = new Ambiente("numa sala do labirinto, repleta de tumbas abertas e reviradas.... nada de valioso por aqui. \n\n °Você vê ao norte o que parece um acampamento... \n °Você vê ao leste uma outra sala com pegadas de animais. \n °Você vê ao sul o caminho para outra sala. \n °Você vê ao oeste uma sala cheia de escrituras. \n", "batalha", 3);
        
        templo = new Ambiente("OS ASPECTOS DA DESTRUIÇÃO", "batalha", 4);//*
        
        mundoC = new Ambiente("no berço da magia cosmica de Turhock, aqui é ṕssivel invocar os seres mais poderosos do mundo... \n\n °Você vê um portal ativo para te tirar fora dai. \n °Você pode escrever 'invocar' para invocar algo terrivel...\n", "batalha", 5);
        ambienteRitual = new Ambiente("na sala de preparação dos rituais... \n... após os preparativos, você recita as palavras e uma nevoa é criada ao seu redor ... \n\n °Você deve entrar na sala da magia para enfrentar o seu destino.\n", "batalha", pocao4);
        
        sala6 = new Ambiente("A LOJA DE POÇÕES...", "loja");
        escritorio = new Ambiente("A LOJA DE POÇÕES...", "loja");
        
        quartos = new Ambiente("no corredor que segue para a ala dos quartos, você vê inumeras portas....\nUma delas está semi aberta e você vê uma cama que parece confortavel...\n... você checa para ver se não tem ninguem olhando e tira um cochilo ... você se sente revigorado. \n\n °Você vê o caminho de volta para a astoufo.\n", "descanso");//dormi
        sala1 = new Ambiente("numa sala aparentemente estavel do labirinto, aqui você vê um acampamento....\nAo investigar o local, você vê uma cama que parece confortavel...\n... você checa para ver se não existe perigo e tira um cochilo ... você se sente revigorado. \n\n °Você vê ao sul o caminho de volta para o labirinto.\n", "descanso");//dormi
        sala9 = new Ambiente("numa sala aparentemente estavel do labirinto, aqui você vê um acampamento....\nAo investigar o local, você vê uma cama que parece confortavel...\n... você checa para ver se não existe perigo e tira um cochilo ... você se sente revigorado. \n\n °Você vê ao sul o caminho de volta para o labirinto. \n °Você vê uma sala que exala uma aura mistica... parece.. um.. portal??\n", "descanso");//dormi
        
        morte = new Ambiente("num ninho de aranhas gigantes... aparentemente abandonado. \n\n °Você vê o caminho de volta.\n", "batalha", 6);
        
        sala10 = new Ambiente("em breve um combate", "comum", pocao4);
        
        ambienteLoja = new Ambiente("", "");
        
        // inicializa as saidas dos ambientes
        inicio.ajustarSaida("dentro", astoufo);
        inicio.ajustarSaida("norte", vale);
        inicio.ajustarSaida("leste", florestaNPs);
        astoufo.ajustarSaida("norte", balcao);
        astoufo.ajustarSaida("leste", escritorio);
        astoufo.ajustarSaida("oeste", quartos);
        astoufo.ajustarSaida("fora", inicio);
        balcao.ajustarSaida("sul", astoufo);
        escritorio.ajustarSaida("oeste", astoufo);
        quartos.ajustarSaida("leste", astoufo);
        cemiterio.ajustarSaida("leste", cripta);
        cemiterio.ajustarSaida("sul", florestaNPs);
        cemiterio.ajustarSaida("oeste", vale);
        cemiterio.ajustarSaida("dentro", qg);
        vale.ajustarSaida("norte", florestaNPn);
        vale.ajustarSaida("leste", cemiterio);
        vale.ajustarSaida("sul", inicio);
        vale.ajustarSaida("dentro",ninho);
        florestaNPs.ajustarSaida("norte", cemiterio);
        florestaNPs.ajustarSaida("oeste", inicio);
        florestaNPs.ajustarSaida("dentro", lab);
        florestaNPn.ajustarSaida("sul", vale);
        florestaNPn.ajustarSaida("dentro", templo);
        qg.ajustarSaida("leste", dormitorio);
        qg.ajustarSaida("fora", cemiterio);
        lab.ajustarSaida("sul", sala2);
        lab.ajustarSaida("norte", sala1);
        lab.ajustarSaida("leste", sala3);
        lab.ajustarSaida("sul", sala0);
        sala2.ajustarSaida("norte", lab);
        sala4.ajustarSaida("norte", sala7);
        sala4.ajustarSaida("leste", sala6);
        ninho.ajustarSaida("fora", vale);
        sala3.ajustarSaida("norte", sala4);
        sala3.ajustarSaida("sul", sala5);
        sala3.ajustarSaida("oeste", lab);
        sala3.ajustarSaida("dentro", morte);
        sala8.ajustarSaida("oeste", sala7);
        sala5.ajustarSaida("norte", sala3);
        cripta.ajustarSaida("oeste", cemiterio);
        sala0.ajustarSaida("leste", lab);
        dormitorio.ajustarSaida("oeste", qg);
        sala7.ajustarSaida("sul", sala4);
        sala7.ajustarSaida("leste", sala8);
        sala7.ajustarSaida("norte", sala9);
        sala7.ajustarSaida("oeste", sala10);
        templo.ajustarSaida("fora", florestaNPn);
        mundoC.ajustarSaida("dentro", qg);
        ambienteRitual.ajustarSaida("dentro", mundoC);
        sala6.ajustarSaida("oeste", sala4);
        sala1.ajustarSaida("sul", lab);
        sala9.ajustarSaida("sul", sala7);
        sala9.ajustarSaida("dentro", mundoC);
        morte.ajustarSaida("fora", sala3);
        sala10.ajustarSaida("leste", sala7);
        
        ambienteAtual = inicio;  // o jogo comeca do lado de fora
    }

    /**
     * Cria todos itens
     * Armaduras ainda não foram implementas 
     */
    private void criarItens()
    {
        produtos = new ArrayList<Item>();
        
        pocao1 = new Pocao("poção", "PoçãodeCuraI", "Uma poção de cura com propriedades duvidosas", 10);
        pocao2 = new Pocao("poção", "PoçãodeCuraII", "Uma poção de cura comum com uma coloração amarela", 20);
        pocao3 = new Pocao("poção","PoçãodeCuraIII", "Uma poção de cura vermelha escarlate", 30);
        pocao4 = new Pocao("poção","PoçãodeCuraIV", "Uma poção de cura azul cintilante", 40);
        pocao5 = new Pocao("poção","PoçãodeCuraV","Uma poção de cura roxa que borbulha", 50);
        produtos.add(pocao1);
        produtos.add(pocao2);
        produtos.add(pocao3);
        produtos.add(pocao4);
        produtos.add(pocao5);
        
        item0 = new Acessorio("anel", "Anel da Sinfonia", "", 5, 0, 3);
        item1 = new Acessorio("anel", "Anel de Multor", "", 0, 5, 3);
        item2 = new Acessorio("colar", "Colar do balanceamento", "", 5, 5, 3);
        item3 = new Acessorio("colar", "Colar de Ametoth", "", 0, 10, 5);
        item4 = new Acessorio("mascara", "Mascara da penitencia", "", 10, 10, 5);
        
        item5 = new Acessorio("colar", "Colar da pedra negra", "", 15, 5, 8);
        item6 = new Acessorio("colar", "Colar do Lord das Terras Ardentes", "", 5, 15, 8);
        item7 = new Acessorio("anel", "Anel da luz", "", 15, 15, 8);
        item8 = new Acessorio("anel", "Anel de espinhos", "", 30, 0, 10);
        item9 = new Acessorio("mascara", "Mascara Profana", "", 30, 30, 10);
        produtos.add(item0);
        produtos.add(item1);
        produtos.add(item2);
        produtos.add(item3);
        produtos.add(item4);
        produtos.add(item5);
        produtos.add(item6);
        produtos.add(item7);
        produtos.add(item8);
        produtos.add(item9);
        
        // item10 = new Acessorio("luvas", "Luvas da discordia", 20, 35, 11, 2500);
        // item11 = new Acessorio("oculos", "Oculos do senhor do sol", 35, 20, 11, 2500);
        // item12 = new Acessorio("joia", "Joia consagrada", 35, 35, 11, 2550);
        // item13 = new Acessorio("chapeu", "Chapeu do eremita", 60, 10, 12, 2550);
        // item14 = new Acessorio("colar", "Colar do guardião da floresta", 60, 60, 12, 3000);
        
        // item15 = new Acessorio("mascara", "Mascara do imortal", 50, 65, 14, 3500);
        // item16 = new Acessorio("colar", "Colar de pelo de lhama", 65, 50, 14, 3500);
        // item17 = new Acessorio("manto", "Manto Negro", 65, 65, 14, 3550);
        // item18 = new Acessorio("mascara", "Mascara da ira", 130, 30, 14, 3550);
        // item19 = new Acessorio("anel", "Anel do sinal", 130, 130, 15, 4000);
        
        item20 = new Armadura("elmo", "Elmo com selo da Ordem", "", 135, 150, 17, "elmo");
        item21 = new Armadura("armadura", "Armadura consagrada pela Ordem", "", 150, 135, 17, "peitoral");
        item22 = new Armadura("calca", "Calça consagrada pelaa Ordem", "", 150, 150, 18, "calca");
        
        item23 = new Armadura("grevas", "Grevas com pedras da Ordem", "", 200, 200, 20, "grevas");
    }
    
    /**
     * Retorna um numero aleatorio
     */
    private int aleatorio(int numero)
    {
        return geracao.nextInt(numero);
    }
    
    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar() 
    {            
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nos repetidamente lemos
        // comandos e os executamos ate o jogo terminar.
                
        boolean terminado = false;
        while (! terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Ate mais!");
    }
    
    /**
     * "Limpa" a tela
     */
    private void limparTela()
    {
        for(int i = 0; i <= 100; i++){
            System.out.println("          ");
        }
    }
    
    /**
     * Cria os produtos para a loja
     */
    private Item fazerProduto(int random)
    {
        boolean parametro = false;
        do{
            for(Item produtoAux : produtos){
                if(produtoAux.getNumero() == random){
                    parametro = true;
                    return produtoAux;
                }
            }
        }while(parametro);
        return null;
    }
    
    /**
     * Inicia o evento da loja
     */
    private void comecarLoja()
    {
        ambienteAtual = ambienteLoja;
        int numero1 = aleatorio(produtos.size());
        int numero2 = aleatorio(produtos.size());
        int numero3 = aleatorio(produtos.size());
        int numero4 = aleatorio(produtos.size());
        numero4 += 1;
        
        
        produto1 = fazerProduto(numero1);
        produto2 = fazerProduto(numero2);
        produto3 = fazerProduto(numero3);
        produto4 = fazerProduto(numero4);
        produto5 = pocao1;
        
        Loja loja = new Loja(produto1, produto2, produto3, produto4, produto5);
        System.out.println(loja.descricao());
        System.out.println("\nPara sair da loja digite 'terminei'.");
    }
    
    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas()
    {
        System.out.println();
        System.out.println("Bem-vindo a Turhrock!");
        System.out.println("Eu sou o narrador e irei te ajudar na sua jornada daqui pra frente. :D \n");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        
        System.out.println("\nMe diga o seu nome: ");
        String nome = entrada.nextLine();
        personagem = new Personagem(nome);
        System.out.println("\nDigite qualquer coisa para continuar para continuar...\n");
        entrada.next();
        limparTela();
    
        exibirAmbienteAtual();
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando) 
    {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        }
        else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        }
        else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        }
        else if (palavraDeComando.equals("observar")) {
            observar();
        }
        else if (palavraDeComando.equals("pegar")) {
            pegar(comando);
        }
        else if (palavraDeComando.equals("usar")) {
            usar(comando);
        }
        else if (palavraDeComando.equals("objetivo")) {
            objetivo();
        }
        else if (palavraDeComando.equals("invocar")) {
            invocar();
        }
        else if (palavraDeComando.equals("terminei")) {
            terminei();
        }
        else if (palavraDeComando.equals("comprar")) {
            comprarItem(comando);
        }
        else if (palavraDeComando.equals("ver")) {
            verItem(comando);
        }

        return querSair;
    }
    
    /**
     * Retira o jogador do evento da loja
     */
    private void terminei()
    {
        if(ambienteAtual == ambienteLoja){
            ambienteAtual = ambienteAnterior;
            System.out.println("\nVocê se retira deste local, de maneira clama e tranquila...\n");
            exibirAmbienteAtual();
        }
    }
    
    /**
     * Cria um combate para lutar novamente contra o boss do jogo
     * Atualmente não executara sua função pois o combate não foi implementado
     */
    private void invocar()
    {
        if(ambienteAtual == mundoC){
            mundoC.alterarTipo("batalha");
            ambienteAtual = ambienteRitual;
            exibirAmbienteAtual();
        }
        else{
            System.out.println("\nÉ preciso estar num local cosmico para invocar algo tão perigoso...\n");
        }
    }
    
    /**
     * Diz o objetivo do jogo
     */
    private void objetivo()
    {
        System.out.println("\nO objetivo do jogo é juntar todas as 4 partes da armadura consagrada da Ordem.");
    }
    
    /**
     * Mostra ao jogador seus itens e o ambiente onde ele está
     */
    private void observar()
    {
        System.out.println(personagem.verItens());
        System.out.println(personagem.verVida());
        exibirAmbienteAtual();
    }
    
    /**
     * Mostra a descrição de um item na loja
     */
    private void verItem(Comando comando)
    {
        boolean parametro = false;
        if(ambienteAtual == ambienteLoja){
            if(!checaSegundaPalavra(comando)){
                System.out.println("Ver o que?");
                return;
            }
            
            if(!parametro){
                System.out.println("Este item não está aqui");
            }
            else{
                for(Item itemAux : produtos){
                    String nome = comando.getSegundaPalavra();
                    if(itemAux.getNomeInteiro().equals(nome)){
                        System.out.println(itemAux.descricaoLonga());
                    }
                }
            }
        }
    }
    
    /**
     * Usa um item a partir de seu nome
     */
    private void usar(Comando comando)//como pedir pro usuario flaar o nome completo do item
    {
        if(!checaSegundaPalavra(comando)){
            System.out.println("Usar o que?");
            return;
        }

        String nome = comando.getSegundaPalavra();
        Item item = personagem.procura(nome);
        if(item != null){
            personagem.usarItem((Pocao)item);
            System.out.println("Item usado");
        }
        else{
            System.out.println("Este item não esta na sua mochila...");
        }
    }
    
    /**
     * compra um item que esteja na loja
     */
    private void comprarItem(Comando comando)//Precisa dar um jeito de pegar o nome completo do item pra comprar | esta dando erro na hora da compra pois nao pega o item
    {
        if(ambienteAtual == ambienteLoja){
            Item produto = null;
            boolean y;
            if(!checaSegundaPalavra(comando)){
                System.out.println("Comprar o que?");
                return;
            }
    
            String nome = comando.getSegundaPalavra();
            
            produto = loja.compra(nome);
            
            if(produto != null){
                finalizarCompra(produto);
            }
            else{
                System.out.println("Este item não está a venda");
            }
        }
    }
    
    /**
     * Confirma a compra efetuada pelo jogador
     */
    private void finalizarCompra(Item produto)
    {
        if(personagem.defOuro(produto.getValorProduto())){
            System.out.println("Item comprado.");
            personagem.adicionarMochila(produto);
        }
        else{
            System.out.println("deu erro na compra");
        }
    }
    
    /**
     * Checa se existe uma segunda palavra
     */
    private boolean checaSegundaPalavra(Comando comando)
    {
        if(!comando.temSegundaPalavra()) {
            return false;
        }
        else{
            return true;
        }
    }
    
    /**
     * Pega um item no ambiente
     */
    private void pegar(Comando comando)
    {
        if(!checaSegundaPalavra(comando)){
            System.out.println("Pegar o que?");
            return;
        }

        String nome = comando.getSegundaPalavra();
        if(ambienteAtual.getItemNome().equals(nome)){
            Pocao pocaoAmbiente = ambienteAtual.retItem();
            personagem.adicionarMochila(pocaoAmbiente);
            System.out.println("Você pega o item para si.");
        }
        else{
            System.out.println("Este item não esta aqui...");
        }
    }

    // Implementacoes dos comandos do usuario

    /**
     * Printe informacoes de ajuda.
     * Aqui nos imprimimos algo bobo e enigmatico e a lista de 
     * palavras de comando
     */
    private void imprimirAjuda() 
    {
        limparTela();
        System.out.println("Eu sou o narrador 'Ola', como não faço parte deste mundo, posso te dar uma mãozinha.");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        System.out.println(analisador.getPComandos());
    }

    /** 
     * Tenta ir em uma direcao. Se existe uma saida entra no 
     * novo ambiente, caso contrario imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando) 
    {
        if(!checaSegundaPalavra(comando)){
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = ambienteAtual.getSaida(direcao);

        if (proximoAmbiente == null) {
            System.out.println("Não tem saida.");
        }
        else {
            ambienteAnterior = ambienteAtual;
            ambienteAtual = proximoAmbiente;
            if(ambienteAtual.getTipo().equals("batalha")){
                //começarBatalha();
            }
            else if(ambienteAtual.getTipo().equals("loja")){
                comecarLoja();
            }
            else{
                exibirAmbienteAtual();
            }
        }
    }

    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver
     * se nos queremos realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrario
     */
    private boolean sair(Comando comando) 
    {
        if(checaSegundaPalavra(comando)){
            System.out.println("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nos queremos sair
        }
    }
    
    /**
     * Exibe o ambiente atual e seus detalhes
     */
    private void exibirAmbienteAtual(){   
        System.out.println(ambienteAtual.getDescricaoLonga());
    }
}
