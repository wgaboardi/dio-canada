public class ContaCorrente extends Conta {
    public ContaCorrente(Banco banco,Cliente cliente) {
        super(banco, cliente);
        super.tipo="Corrente";
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("==== Extrato Conta Corrente: ====");
        super.imprimirDados();

    }


}
