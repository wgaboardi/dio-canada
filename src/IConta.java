public interface IConta {
    void depositar(double valor);
    void sacar(double valor) throws Conta.ErrorContaException;
    void transferir(double valor, Conta contaDestino) throws Conta.ErrorContaException;
    void imprimirExtrato();
}
