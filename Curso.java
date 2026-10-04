public class Curso {

    private int codigo;
    private String nome;
    private int duracao;

    // Construtor
    public Curso(int codigo, String nome, int duracao) {
        this.codigo = codigo;
        this.nome = nome;
        this.duracao = duracao;
    }

    // Getter e Setter de codigo
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // Getter e Setter de nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter de duracao
    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    // Exibe os dados do curso
    public void exibeDados() {
        System.out.println("===== DADOS DO CURSO =====");
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Duração: " + duracao + " horas");
    }
}