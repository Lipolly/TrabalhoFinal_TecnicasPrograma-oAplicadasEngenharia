package br.ufla.gac111.s2021_2.Turhrock;

public class Item
{
    private String nome, descricao, nomeInteiro;
    private int vida, dano, desvio, numero;
    private static int numeroGeral = 0;
    
    /**
     * define os valores gerais de item
     */
    public Item(String nome, String nomeInteiro, String descricao, int vida, int dano, int desvio)
    {
        this.nome = nome;
        this.nomeInteiro = nomeInteiro;
        this.vida = vida;
        this.dano = dano;
        this.desvio = desvio;
        this.descricao = descricao;
        
        numero = numeroGeral;
        numeroGeral += 1;
    }
    
    
    /**
     * mostra o numero do item
     */
    public int getNumero()
    {
        return numero;
    }
    
    /**
     * mostra a descricao do item
     */
    public String getDescricao()
    {
        return descricao;
    }
    
    /**
     * mostra o valor do item
     */
    public int getValorProduto()
    {
        int valor = 0;
        valor += (getVida() + getDano() + getDesvio())*100;
        return valor;
    }
    
    /**
     * mostra a vida que item da
     */
    public int getVida()
    {
        return vida;
    }
    
    /**
     * mostra o dano que o item da
     */
    public int getDano()
    {
        return dano;
    }
    
    /**
     * mostra o desvio que o item da
     */
    public int getDesvio()
    {
        return desvio;
    }
    
    /**
     * mostra o nome do item
     */
    public String getNome()
    {
        return nome;
    }
    
    /**
     * mostra o nome inteiro 
     */
    public String getNomeInteiro()
    {
        return nomeInteiro;
    }
    
    /**
     * mostra a descrição longa do item
     */
    public String descricaoLonga()
    {
        String descricaoLonga = "Nome do item: " + getNomeInteiro() + "\nAparencia: " + descricao;
        return descricaoLonga;
    }
}
