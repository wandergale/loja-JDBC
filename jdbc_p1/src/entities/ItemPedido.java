package entities;

public class ItemPedido {
    private int id;
    private Pedido pedido;
    private Produto produto;
    private int quantidade;

    public ItemPedido(int id, Pedido pedido, Produto produto, int quantidade) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
