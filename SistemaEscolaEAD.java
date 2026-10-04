import java.util.Scanner;

public class SistemaEscolaEAD {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ListaDeAlunos lista = new ListaDeAlunos(100);

        Curso[][] matrizCursos = new Curso[2][2];

        matrizCursos[0][0] = new Curso(1, "Java Básico", 40);
        matrizCursos[0][1] = new Curso(2, "Banco de Dados", 60);
        matrizCursos[1][0] = new Curso(3, "Programação Web", 80);
        matrizCursos[1][1] = new Curso(4, "POO Java", 50);

        int opcao;

        do {

            System.out.println("\n===== ESCOLA EAD =====");
            System.out.println("1 - Visualizar Lista de Alunos");
            System.out.println("2 - Adicionar Aluno");
            System.out.println("3 - Sair");
            System.out.println("4 - Verificar Notas do Aluno");
            System.out.println("5 - Verificar Financeiro do Aluno");

            System.out.print("Escolha: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch(opcao) {

                case 1:

                    lista.exibirLista();

                    break;

                case 2:

                    System.out.print("Código: ");
                    int codigo = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Nome: ");
                    String nome = teclado.nextLine();

                    System.out.print("Data de nascimento: ");
                    String dataNascimento = teclado.nextLine();

                    System.out.print("Email: ");
                    String email = teclado.nextLine();

                    System.out.print("Senha: ");
                    String senha = teclado.nextLine();

                    System.out.println("\nCursos disponíveis:");

                    for(int i = 0; i < 2; i++) {

                        for(int j = 0; j < 2; j++) {

                            Curso c = matrizCursos[i][j];

                            System.out.println(
                            c.getCodigo() + " - "
                            + c.getNome());
                        }
                    }

                    System.out.print("Escolha o código do curso: ");
                    int codCurso = teclado.nextInt();
                    teclado.nextLine();

                    Curso cursoEscolhido = null;

                    for(int i = 0; i < 2; i++) {

                        for(int j = 0; j < 2; j++) {

                            if(matrizCursos[i][j].getCodigo()
                               == codCurso) {

                                cursoEscolhido =
                                matrizCursos[i][j];
                            }
                        }
                    }

                    if(cursoEscolhido == null) {

                        System.out.println(
                        "Curso inválido!");

                        break;
                    }

                    System.out.print(
                    "Aluno bolsista? (S/N): ");

                    String resp =
                    teclado.nextLine();

                    Aluno aluno;

                    if(resp.equalsIgnoreCase("S")) {

                        System.out.print(
                        "Tipo da bolsa: ");

                        String tipoBolsa =
                        teclado.nextLine();

                        aluno =
                        new AlunoBolsista(
                        codigo,
                        nome,
                        dataNascimento,
                        email,
                        senha,
                        cursoEscolhido,
                        tipoBolsa);

                    } else {

                        aluno =
                        new Aluno(
                        codigo,
                        nome,
                        dataNascimento,
                        email,
                        senha,
                        cursoEscolhido);
                    }

                    System.out.println(
                    "\nDigite as 3 notas:");

                    double n1 =
                    teclado.nextDouble();

                    double n2 =
                    teclado.nextDouble();

                    double n3 =
                    teclado.nextDouble();

                    teclado.nextLine();

                    aluno.lancarNotas(
                    n1, n2, n3);

                    double[] parcelas =
                    {250, 250, 250, 250, 250, 250};

                    aluno.adicionarMensalidades(
                    parcelas);

                    if(lista.adicionarAluno(aluno)) {

                        System.out.println(
                        "Aluno cadastrado com sucesso!");

                    } else {

                        System.out.println(
                        "Código já existente!");
                    }

                    break;

                case 4:

                    System.out.print(
                    "Digite o código do aluno: ");

                    int codBusca =
                    teclado.nextInt();

                    Aluno encontrado =
                    lista.buscarAluno(codBusca);

                    if(encontrado != null) {

                        encontrado.exibirNotas();

                    } else {

                        System.out.println(
                        "Aluno não encontrado.");
                    }

                    break;

                case 5:

                    System.out.print(
                    "Digite o código do aluno: ");

                    int codFinanceiro =
                    teclado.nextInt();

                    Aluno alunoFinanceiro =
                    lista.buscarAluno(
                    codFinanceiro);

                    if(alunoFinanceiro != null) {

                        alunoFinanceiro
                        .exibirMensalidades();

                        System.out.print(
                        "Digite a parcela para pagar (1 a 6): ");

                        int parcela =
                        teclado.nextInt();

                        alunoFinanceiro
                        .pagarMensalidade(
                        parcela - 1);

                        System.out.println(
                        "Pagamento realizado!");

                    } else {

                        System.out.println(
                        "Aluno não encontrado.");
                    }

                    break;

                case 3:

                    System.out.println(
                    "Sistema encerrado.");

                    break;

                default:

                    System.out.println(
                    "Opção inválida.");
            }

        } while(opcao != 3);

        teclado.close();
    }
}