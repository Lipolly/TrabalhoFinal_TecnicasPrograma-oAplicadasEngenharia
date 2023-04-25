package br.ufla.gac111.s2021_2.Turhrock;
import java.util.ArrayList;

public class Loja
{
    private Item produto1, produto2, produto3, produto4, produto5;
    private ArrayList<Item> produtos;
    private int valorProduto1, valorProduto2, valorProduto3, valorProduto4, valorProduto5;
    
    /**
     * Define a loja
     */
    public Loja(Item produto1, Item produto2, Item produto3, Item produto4, Item produto5)
    {
        this.produto1 = produto1;
        this.produto2 = produto2;
        this.produto3 = produto3;
        this.produto4 = produto4;
        this.produto5 = produto5;

        produtos = new ArrayList<Item>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        produtos.add(produto5);
    }
    
    /**
     * Procura o item na loja
     */
    public Item procurarProduto(Item produto)
    {
        for(Item item : produtos){
            if(item == produto){
                return item;
            }
        }
        return null;
    }
    
    /**
     * Remove o item da loja
     * ainda não está funcionando
     */
    public void removerLoja(Item produto)
    {
        produtos.remove(produto);
    }
    
    /**
     * Compra o item da loja
     */
    public Item compra(String nome)
    {
        Item produtoFinal = null;
        for(Item produtoAux : produtos){
            if(produtoAux.getNomeInteiro().equals(nome)){
                removerLoja(produtoAux);
                produtoFinal = produtoAux;
            }
        }
        return produtoFinal;
    }
    
    /**
     * Retorna a descrição para exibir a loja
     */
    public String descricao()
    {
        String lojaAtual = "\nItens disponiveis para compra: " + "\n\t ";
        for(Item item : produtos){
            lojaAtual += item.getNomeInteiro() + " | " + item.getValorProduto() + " Turns" + "\n\t " ;
        }
        return lojaAtual;
    }
}
