package br.ufla.gac111.s2021_2.Turhrock;

public class PalavrasComando
{
    // um vetor constante que guarda todas as palavras de comandos validas
    private static final String[] comandosValidos = {
        "ir", "sair", "ajuda", "observar", "pegar", "usar", "objetivo", "invocar", "terminei", "comprar", "ver"
    };

    /**
     * Construtor - inicializa as palavras de comando.
     */
    public PalavrasComando()
    {
        // nada a fazer no momento...
    }
    
    /**
     * mostra as palavras de comando
     */
    public static String getPalavrasComandos()
    {
        String palavraLocla = "";
        for(String palavra : comandosValidos){
            palavraLocla += palavra + " ";
        }
        return palavraLocla;
    }
    
    /**
     * Verifica se uma dada String eh uma palavra de comando valida. 
     * @return true se a string dada eh um comando valido,
     * false se nao eh.
     */
    public boolean ehComando(String umaString)
    {
        for(int i = 0; i < comandosValidos.length; i++) {
            if(comandosValidos[i].equals(umaString))
                return true;
        }
        // se chegamos aqui, a string nao foi encontrada nos comandos.
        return false;
    }
}
