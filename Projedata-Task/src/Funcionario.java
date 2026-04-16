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

    /**
     * Sobrecarga de Método
     * @return salário em Reais como String
     */
    public String pegarSalarioFormatado() {
        // Retorna o salário formatado em Reais Brasileiros
        return this.pegarSalarioFormatado(new Locale("pt", "BR"));
    }

    /**
     * Sobrecarga de Método
     * @param locale: define o formato a ser aplicado no salário
     * @return salário formatado como String
     */
    public String pegarSalarioFormatado(Locale locale) {

        NumberFormat formatador = NumberFormat.getCurrencyInstance(locale);
        return formatador.format(pegarSalario());
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
