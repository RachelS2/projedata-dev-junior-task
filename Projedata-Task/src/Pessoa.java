import java.math.BigDecimal;
import java.time.LocalDate;

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
}