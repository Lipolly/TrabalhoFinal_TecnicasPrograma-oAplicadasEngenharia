package br.ufla.gac111.s2021_2.Turhrock;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Personagem
{
    private String nome, elmo, peitoral, grevas, calcas;
    private int vida, vidaAtual, dano, desvio, ouro;
    private ArrayList<Item> mochila;
    Queue<Acessorio> corpo = new LinkedList<>();

    /**
     * Construtor para objetos da classe Personagem
     */
    public Personagem(String nome)
    {
        this.nome = nome;
        vida = 50;
        vidaAtual = 30;
        ouro = 10000;
        dano = 10;
        desvio = 5;
        mochila = new ArrayList<Item>();

        elmo = "";
        peitoral = "";
        calcas = "";
        grevas = "";
    }
    
    /**
     * mostra o item que está no slot de elmo
     */
    public String getElmo()
    {
        return elmo;
    }
    
    /**
     * mostra o item que está no slot de peitoral
     */
    public String getPeitoral()
    {
        return peitoral;
    }
    
    /**
     * mostra o item que está no slot de calças
     */
    public String getcalcas()
    {
        return calcas;
    }
    
    /**
     * mostra o item que está no slot de grevas
     */
    public String getGrevas()
    {
        return grevas;
    }
    
    /**
     * tira valores da vida
     */
    public void defVida(int valor)
    {
        vida -= valor;
    }
    
    /**
     * tira valores do dano
     */
    public void defDano(int valor)
    {
        dano -= valor;
    }
    
    /**
     * tira valores do desvio
     */
    public void defDesvio(int valor)
    {
        desvio -= valor;
    }
    
    /**
     * tira valores do ouro
     */
    public boolean defOuro(int valor)
    {
        if(checarOuro(valor)){
            ouro -= valor;
            return true;
        }
        return false;
    }
    
    /**
     * aumenta valores da vida
     */
    public void impVida(int valor)
    {
        vida += valor;
    }
    
    /**
     * aumenta valores do dano
     */
    public void impDano(int valor)
    {
        dano += valor;
    }
    
    /**
     * aumenta valores do desvio
     */
    public void impDesvio(int valor)
    {
        desvio += valor;
    }
    
    /**
     * aumenta valores do ouro
     */
    public void impOuro(int valor)
    {
        ouro += valor;
    }
    
    /**
     * mostra o dano
     */
    public int getDano()
    {
        return dano;
    }
    
    /**
     * mostra o ouro
     */
    public int getOuro()
    {
        return ouro;
    }
    
    /**
     * mostra o desvio
     */
    public int getDesvio()
    {
        return desvio;
    }
    
    /**
     * mostra a vida
     */
    public int getVida()
    {
        return vida;
    }
    
    /**
     * mostra a vida atual
     */
    public int getVidaAtual()
    {
        return vidaAtual;
    }
    
    /**
     * mostra o nome
     */
    public String getNome()
    {
        return nome;
    }
    
    /**
     * checa se depois da operação o ouro ficara ou não negativo
     */
    public boolean checarOuro(int valor)
    {
        int x = getOuro() - valor;
        if(x < 0){
            return false;
        }
        return true;
    }
    
    /**
     * adiciona o item na mochila
     */
    public void adicionarMochila(Item item)
    {
        mochila.add(item);
    }
    
    /**
     * muda o item habilitado nos slots de armadura
     */
    public void mudarTipo(String tipo, String descricao)
    {
        if(tipo.equals("elmo")){
            elmo = descricao;
        }
        if(tipo.equals("peitoral")){
            peitoral = descricao;
        }
        if(tipo.equals("calcas")){
            calcas = descricao;
        }
        else{
            grevas = descricao;
        }
    }
    
    /**
     * habilita o item
     */
    public void ativarItem(Item item)
    {
        impVida(item.getVida());
        impDano(item.getDano());
        impDesvio(item.getDesvio());
    }
    
    /**
     * desabilita o item
     */
    public void desativarItem(Item item)
    {
        defVida(item.getVida());
        defDano(item.getDano());
        defDesvio(item.getDesvio());
    }
    
    /**
     * corrige a vida atual para nunca ficar maior que a vida maxima
     */
    public void corrigirVida()
    {
        if(vidaAtual > vida){
            vidaAtual = vida;
        }
    }
    
    /**
     * procura o item na mochila
     */
    public Item procura(String nome)
    {
        for(Item itemAux : mochila){
            if(itemAux instanceof Pocao){
                if(itemAux.getNomeInteiro().equals(nome)){
                    return itemAux;
                }
            }
        }
        return null;
    }
    
    /**
     * mostra os itens dentro da mochila
     */
    public String verItens()
    {
        String itens = "Itens da mochila: \n";
        for(Item itemAux : mochila){
            itens += "\t\t" + itemAux.getNomeInteiro() + "\n ";
        }

        itens += "Numero de itens obtidos: " + mochila.size();
        return itens;
    }
    
    /**
     * usa uma poção da mochila
     */
    public void usarItem(Pocao item)
    {
        mochila.remove(item);
        vidaAtual += item.getVida();
        corrigirVida();
    }
    
    /**
     * mostra a vida e vida atual
     */
    public String verVida()
    {
        String verVida = "Vida atual: " + getVidaAtual() + " | " + getVida();
        return verVida;
    }
}
