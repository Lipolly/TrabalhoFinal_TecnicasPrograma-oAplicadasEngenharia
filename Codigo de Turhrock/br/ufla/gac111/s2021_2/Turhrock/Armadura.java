package br.ufla.gac111.s2021_2.Turhrock;
public class Armadura extends Item
{
    private String nome, descricao, nomeInteiro, tipo;
    private int vida, dano, desvio;
    
    /**
     * define os valores de armadura
     */
    public Armadura(String nome, String nomeInteiro, String descricao, int vida, int dano, int desvio, String tipo)
    {
        super(nome, nomeInteiro, descricao, vida, dano, desvio);
        this.tipo = tipo;
    }
    
    /**
     * mostra o tipo da parte da armadura
     */
    public String getTipo()
    {
        return tipo;
    }
}
