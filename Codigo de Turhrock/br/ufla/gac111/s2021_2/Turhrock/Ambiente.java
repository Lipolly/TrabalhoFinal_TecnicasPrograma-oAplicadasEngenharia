package br.ufla.gac111.s2021_2.Turhrock;
import java.util.HashMap;

public class Ambiente 
{
    private String descricao, tipo;
    private int nivel;
    private HashMap<String, Ambiente> saidas;
    private Pocao pocao;
    
    /**
     * Define o ambiente com as saidas
     */
    public Ambiente(String descricao, String tipo) 
    {
        this.descricao = descricao;
        this.tipo = tipo;
        saidas = new HashMap<>();
    }
    
    /**
     * Define o ambiente de combate
     */
    public Ambiente(String descricao, String tipo, int nivel) 
    {
        this(descricao, tipo);
        this.nivel = nivel;
    }
    
    /**
     * Define o ambiente com item do tipo poção
     */
    public Ambiente(String descricao, String tipo, Pocao pocao) 
    {
        this(descricao, tipo);
        this.pocao = pocao;
    }
    
    /**
     * Mostra o nivel de combate do ambiente
     */
    public int getNivel()
    {
        return nivel;
    }
    
    /**
     * Mostra o tipo de ambiente
     */
    public String getTipo()
    {
        return tipo;
    }
    
    /**
     * Muda o tipo de ambiente
     */
    public void alterarTipo(String novoTipo)
    {
        tipo = novoTipo;
    }
    
    /**
     * Retorna o ambiente de acordo com a direção que quer ir (HashMap)
     */
    public Ambiente getSaida(String direcao){
        return saidas.get(direcao);
    }
    
    /**
     * Mostra se tem item no ambiente
     */
    public boolean temItem()
    {
        if(pocao != null){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Mostra a descrição completa do ambiente
     */
    public String getDescricaoLonga(){
        String descricaoLonga = "Voce esta " + getDescricao();
        String saidas = "\nSaidas: " + getSaidasPossiveis();
        if(temItem() != true){
            return descricaoLonga + "\nAqui você não encontra nada" + saidas + "\n";
        }
        else{
            return descricaoLonga + "\nAqui você enxerga uma " + pocao.getDescricao() + "\n" + saidas + "\n";
        }
    }
    
    /**
     * Funçao que ajusta a saída de uma a uma.
     */
    public void ajustarSaida(String direcao, Ambiente saida){
        if (saida != null) {
            saidas.put(direcao, saida);
        }
    }

    /**
     * @return A descricao do ambiente.
     */
    public String getDescricao()
    {
        return descricao;
    }
    
    /**
     * Mostra a poção que está no item
     */
    public Pocao getItem()
    {
        if(temItem()){
            return pocao;
        }
        else{
            return null;
        }
    }
    
    /**
     * Mostra o nome do item
     */
    public String getItemNome()
    {
        if(getItem() != null){
            return pocao.getNome();
        }
        else{
            return "nada";
        }
    }
    
    /**
     * Retira o item do ambiente
     */
    public Pocao retItem()
    {
        Pocao pocaoAux = pocao;
        pocao = null;
        return pocaoAux;
    }
    
    /**
     * Mostr as saidas possiveis do ambiente
     */
    public String getSaidasPossiveis(){
        String direcoes = " ";
        for (String direcao : saidas.keySet()) {
            direcoes += direcao + " ";
        }
        return direcoes;
    }
}
