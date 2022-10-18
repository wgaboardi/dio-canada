public class Main {

    public static void main(String[] args) throws Conta.ErrorContaException {
        Banco bb = new Banco("001","BANCO DO BRASIL");
        Cliente cliente = new Cliente("WELLINGTON","00000000000");
        Conta corrente = new ContaCorrente(bb, cliente);
        Conta poupanca = new ContaPoupanca(bb, cliente);
        corrente.depositar(100);
        poupanca.depositar(50);
        corrente.transferir(1115,poupanca);
        corrente.imprimirExtrato();
        poupanca.imprimirExtrato();
        System.out.println(String.format("Total de contas abertas: %d", corrente.getTotalDeContas()));

        bb.listaContas();
    }
}
