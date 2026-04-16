import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private Funcao funcao;

    public Funcionario(String nome, LocalDate dataDeNascimento, BigDecimal salario, Funcao funcao) {
        super(nome, dataDeNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal pegarSalario() {
        return this.salario;
    }

    public Funcao pegarFuncao() {
        return this.funcao;
    }

    public void mudarSalario(BigDecimal novoSalario) {
        this.salario = novoSalario;
    }

    @Override
    public String toString() {
        return "Nome: " + pegarNome() +
                ", Data de Nascimento: " + pegarDataDeNascimento() +
                ", Salário: R$" + pegarSalario() +
                ", Função: " + pegarFuncao();
    }
}
