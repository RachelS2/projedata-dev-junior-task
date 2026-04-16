import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

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

    public String pegarSalarioFormatado() {
        // Retorna o salário formatado em Reais Brasileiros
        NumberFormat formatadorDeMoeda = NumberFormat.getInstance(new Locale("pt", "BR"));
        return "R$" + formatadorDeMoeda.format((pegarSalario()));
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
                ", Data de Nascimento: " + pegarDataDeNascimentoFormatada() +
                ", Salário: " + pegarSalarioFormatado() +
                ", Função: " + pegarFuncao();
    }
}
