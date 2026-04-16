
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class Pessoa {
     private String nome;
     private LocalDate dataDeNascimento;

     public Pessoa(String nome, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }
    public String pegarNome() {
        return this.nome;
    }

    public LocalDate pegarDataDeNascimento() {
        return this.dataDeNascimento;
    }

    /**
     * Retorna a data de nascimento formatada de acordo com o padrão informado.
     *
     * @param pattern padrão de formatação de data (ex: "dd/MM/yyyy", "yyyy-MM-dd")
     * @return data de nascimento formatada como String
     * @throws IllegalArgumentException se o pattern for inválido
     */
    public String pegarDataDeNascimentoFormatada(String pattern) {
        DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern(pattern);
        return formatadorDeData.format(pegarDataDeNascimento());
    }

    /**
     * Retorna a data de nascimento no formato padrão brasileiro (dd/MM/yyyy).
     *
     * @return data de nascimento formatada como string
     */
    public String pegarDataDeNascimentoFormatada() {
        return this.pegarDataDeNascimentoFormatada("dd/MM/yyyy");
    }
}