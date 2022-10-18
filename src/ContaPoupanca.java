public class ContaPoupanca extends Conta{
    public ContaPoupanca(Banco banco, Cliente cliente) {
        super(banco, cliente);
        super.tipo="Poupança";
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirDados();
    }

}
