
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

    public String pegarDataDeNascimentoFormatada() {
        // Retorna a data de nascimento em formato dd/MM/yyyy
        DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatadorDeData.format((pegarDataDeNascimento()));
    }
}