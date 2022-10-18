import java.util.List;

// Entity: Conta
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static final String BANCO_PADRAO = "001";
    private static int SEQUENCIAL = 1;
    private static int totalDeContas=0;

    public Conta(Banco banco, Cliente cliente) {
        this.banco=banco.getNumero();
        this.agencia=AGENCIA_PADRAO;
        this.numero=SEQUENCIAL++;
        this.cliente = cliente;
        this.totalDeContas++;
        banco.adiciona(this);
    }

    // Number of bank
    protected String banco;
    // Number of count
    protected int numero;
    // type of count
    protected String tipo;
    // Number of agency
    protected int agencia;
    // Current value
    protected double saldo;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Client
    protected Cliente cliente;

    @Override
    public void  depositar(double valor) {
       saldo+=valor;
    }

    @Override
    public void sacar(double valor) throws ErrorContaException {
        if (this.saldo >= valor) {
            saldo -= valor;
        }
        else {
            throw new ErrorContaException("Saldo insuficiente!!!!", this.saldo);
        }

    }

    @Override
    public void transferir(double valor, Conta contaDestino) throws ErrorContaException {
        try {
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
        catch (ErrorContaException e) {
            System.out.println("ERRO: " + e.getMessage());

        }
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getTotalDeContas() {
        return totalDeContas;
    }

    public void setTotalDeContas(int totalDeContas) {
        Conta.totalDeContas = totalDeContas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    protected void imprimirDados() {
        System.out.println(String.format("Banco: %s", this.banco));
        System.out.println(String.format("Tipo: %s", this.tipo));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    };

    @Override
    public String toString() {
        return "Conta{" +
                "Banco='" + banco + '\'' +
                ", numero=" + numero +
                ", Tipo='" + tipo + '\'' +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                ", cliente=" + cliente.getNome() +
                '}';
    }

    class ErrorContaException extends Exception {
        public ErrorContaException(String message, double saldo) {
            super(message + String.format("\nSaldo atual na conta é %.2f", saldo));
        }
    }


}
