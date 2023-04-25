package br.ufla.gac111.s2021_2.Turhrock;
public class Acessorio extends Item
{
    private String nome, descricao, nomeInteiro;
    private int vida, dano, desvio;
    
    /**
     * define o acessorio
     */
    public Acessorio(String nome, String nomeInteiro, String descricao, int vida, int dano, int desvio)
    {
        super(nome, nomeInteiro, descricao, vida, dano, desvio);
    }
    
    /**
     * sobrescreve a descrição longa do item para se adequar ao acessorio
     */
    @Override
    public String descricaoLonga()//Precisa chamar o super. antes do getDano? 
    {
        String descricaoLonga = super.descricaoLonga();
        descricaoLonga += "Atributos: " + "\n\t Dano: " + super.getDano() + "\n\t Vida: " + super.getVida() + "\n\t Desvio: " + super.getDesvio();
        return descricaoLonga;
    }
}
