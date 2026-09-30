public class AlunoBolsista extends Aluno {

    private String tipoBolsa;

    public AlunoBolsista(int codigo,
                         String nome,
                         String dataNascimento,
                         String email,
                         String senha,
                         Curso curso,
                         String tipoBolsa) {

        super(codigo,
              nome,
              dataNascimento,
              email,
              senha,
              curso);

        this.tipoBolsa = tipoBolsa;
    }

    @Override
    public void exibeDados() {

        super.exibeDados();

        System.out.println("Tipo de Bolsa: "
                           + tipoBolsa);
    }
}