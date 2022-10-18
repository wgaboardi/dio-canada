import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String numero;
    private String nome;
    private List<Conta> listaContas;

    public Banco(String numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getListaContas() {
        return listaContas;
    }

    public void setListaContas(List<Conta> listaContas) {
        this.listaContas = listaContas;
    }

    public void listaContas() {
        System.out.println("===== Lista de contas ====");
        for(Conta conta: getListaContas()) {
            System.out.println(conta.toString());
        }
    }

    public void adiciona(Conta conta) {
        if (this.getListaContas() == null) {
            List<Conta> lista = new ArrayList<>();
            lista.add(conta);
            this.setListaContas(lista);
        } else {
            this.getListaContas().add(conta);
        }
    }
}
