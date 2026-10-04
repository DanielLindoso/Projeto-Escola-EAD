public class Aluno {

    private int codigo;
    private String nome;
    private String dataNascimento;
    private String email;
    private String senha;

    private Curso cursoMatriculado;

    private double[] notas = new double[3];
    private boolean[] lancada = new boolean[3];

    private Mensalidade[] mensalidades;
    private int numParcelas;

    public Aluno(int codigo,
                 String nome,
                 String dataNascimento,
                 String email,
                 String senha,
                 Curso cursoMatriculado) {

        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
        this.cursoMatriculado = cursoMatriculado;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Curso getCursoMatriculado() {
        return cursoMatriculado;
    }

    public void exibeDados() {

        System.out.println("------------------");
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Email: " + email);

        if(cursoMatriculado != null) {
            System.out.println(
            "Curso: "
            + cursoMatriculado.getNome());
        }
    }

    public void lancarNotas(double n1,
                            double n2,
                            double n3) {

        notas[0] = n1;
        notas[1] = n2;
        notas[2] = n3;

        lancada[0] = true;
        lancada[1] = true;
        lancada[2] = true;
    }

    public double calcularMedia() {

        return (notas[0]
               + notas[1]
               + notas[2]) / 3;
    }

    public void exibirNotas() {

        System.out.println("Notas:");

        for(int i = 0; i < notas.length; i++) {

            System.out.println(
            "Nota "
            + (i + 1)
            + ": "
            + notas[i]);
        }

        System.out.printf(
        "Média: %.2f%n",
        calcularMedia());
    }

    public void adicionarMensalidades(
    double[] valores) {

        numParcelas = valores.length;

        mensalidades =
        new Mensalidade[numParcelas];

        for(int i = 0;
            i < valores.length;
            i++) {

            mensalidades[i] =
            new Mensalidade(
            valores[i]);
        }
    }

    public void exibirMensalidades() {

        for(int i = 0;
            i < mensalidades.length;
            i++) {

            String status;

            if(mensalidades[i].isPago()) {
                status = "PAGO";
            } else {
                status = "PENDENTE";
            }

            System.out.println(
            "Parcela "
            + (i + 1)
            + " - R$ "
            + mensalidades[i].getValor()
            + " - "
            + status);
        }
    }

    public void pagarMensalidade(
    int indice) {

        if(indice >= 0 &&
           indice < mensalidades.length) {

            mensalidades[indice]
            .darBaixa();
        }
    }
}