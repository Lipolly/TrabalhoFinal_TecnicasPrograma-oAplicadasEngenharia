package br.ufla.gac111.s2021_2.Turhrock;
public class Pocao extends Item
{
    private String nome, descricao, nomeInteiro;
    private int vida;
    
    /**
     * define os valores de poção
     */
    public Pocao(String nome, String nomeInteiro, String descricao, int vida)
    {
        super(nome, nomeInteiro, descricao, vida, 0, 0);
    }
    
    /**
     * sobrescreve a descricao longa do item para se adequar á poção
     */
    @Override
    public String descricaoLonga()
    {
        String descricaoLonga = super.descricaoLonga();
        descricaoLonga += "\nPoder de cura: " + super.getVida() + "\n";
        return descricaoLonga;
    }
}
