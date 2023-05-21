package entities;

public class Pedido {
    private int id;
    private Cliente cliente;
    private String dataPedido;
    private String statusPedido;

    public Pedido(int id, Cliente cliente, String dataPedido, String statusPedido) {
        this.id = id;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }
}
