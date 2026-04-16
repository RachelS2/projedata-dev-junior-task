import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Principal {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Olá!\nEssa é a resolução do Teste Mão na Massa, para a vaga de dev júnior na Projedata, feito por Rachel Barino Silva em 16/04/2026.\nObrigada desde já pela atenção!\n");

        Funcionario maria = new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), Funcao.Operador );
        Funcionario joao = new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), Funcao.Operador );
        Funcionario caio = new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), Funcao.Coordenador );
        Funcionario miguel = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), Funcao.Diretor );
        Funcionario alice = new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), Funcao.Recepcionista );
        Funcionario heitor = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), Funcao.Operador );
        Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), Funcao.Contador );
        Funcionario laura = new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), Funcao.Gerente );
        Funcionario heloisa = new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), Funcao.Eletricista );
        Funcionario helena = new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), Funcao.Gerente );

        List<Funcionario> listaDeFuncionarios = new ArrayList<>(List.of(maria, joao, caio, miguel, alice, heitor, arthur, laura, heloisa, helena));

        listaDeFuncionarios.remove(joao);
        System.out.println("\nO funcionário João foi removido da lista.");

        DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat formatadorDeNumero = NumberFormat.getInstance(new Locale("pt", "BR"));

        System.out.println("\nImprime dados de funcionarios:");
        for (Funcionario funcionario : listaDeFuncionarios) {
            String dataFormatada = funcionario.pegarDataDeNascimento().format(formatadorDeData);
            String salarioFormatado = formatadorDeNumero.format(funcionario.pegarSalario());

            System.out.println(funcionario.toString());
        }

        System.out.println("\nAumento de 10% no salário:");
        for (Funcionario f : listaDeFuncionarios) {
            BigDecimal novoSalario = f.pegarSalario().multiply(new BigDecimal("1.10"));
            f.mudarSalario(novoSalario);
            System.out.println("O novo salário de " + f.pegarNome() + " é R$" + formatadorDeNumero.format(novoSalario));
        }
        Map<Funcao, List<Funcionario>> funcionariosPorFuncao =
                listaDeFuncionarios.stream()
                        .collect(Collectors.groupingBy(Funcionario::pegarFuncao));

        System.out.println("\nImprimindo funcionários por função:");
        for (Map.Entry<Funcao, List<Funcionario>> grupo : funcionariosPorFuncao.entrySet()) {
            System.out.println("Função: " + grupo.getKey());

            for (Funcionario funcionario : grupo.getValue()) {
                System.out.println(" - " + funcionario.pegarNome());
            }
        }


        System.out.println("\nImprimindo funcionários que nasceram em outubro ou dezembro:");
        for (Funcionario f : listaDeFuncionarios) {
            int mes = f.pegarDataDeNascimento().getMonthValue();

            if (mes == 10 || mes == 12) {
                System.out.println(f.pegarNome());
            }
        }

        System.out.println("\nFuncionário mais velho: ");
        Funcionario maisVelho = listaDeFuncionarios.stream()
                .min(Comparator.comparing(Funcionario::pegarDataDeNascimento))
                .orElse(null);
        int idade = Period.between(
                maisVelho.pegarDataDeNascimento(),
                LocalDate.now()
        ).getYears();
        System.out.println("O funcionário mais velho é: " + maisVelho.pegarNome() + ", que tem " + idade + " anos.");

        System.out.println("\nImprime lista por ordem alfabética: ");
        listaDeFuncionarios.stream()
                .sorted(Comparator.comparing(Funcionario::pegarNome))
                .forEach(System.out::println);

        BigDecimal total = BigDecimal.ZERO;
        for (Funcionario f : listaDeFuncionarios) {
            total = total.add(f.pegarSalario());
        }
        System.out.println("\nSoma dos salários dos funcionários: R$" + formatadorDeNumero.format(total) + "\n");

        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        for (Funcionario f : listaDeFuncionarios) {
            BigDecimal quantidade = f.pegarSalario()
                    .divide(salarioMinimo, 2, RoundingMode.HALF_UP);

            System.out.println(
                    f.pegarNome() + " ganha " + formatadorDeNumero.format(quantidade) + " salários mínimos."
            );
        }
    }
}