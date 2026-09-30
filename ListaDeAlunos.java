public class ListaDeAlunos {

    private Aluno[] alunos;
    private int totalAlunos;

    public ListaDeAlunos(int capacidade) {

        alunos = new Aluno[capacidade];
        totalAlunos = 0;
    }

    public boolean adicionarAluno(Aluno a) {

        for(int i = 0; i < totalAlunos; i++) {

            if(alunos[i].getCodigo() ==
               a.getCodigo()) {

                return false;
            }
        }

        alunos[totalAlunos] = a;
        totalAlunos++;

        return true;
    }

    public void exibirLista() {

        for(int i = 0; i < totalAlunos; i++) {

            alunos[i].exibeDados();
        }
    }

    public Aluno buscarAluno(int codigo) {

        for(int i = 0; i < totalAlunos; i++) {

            if(alunos[i].getCodigo() == codigo) {

                return alunos[i];
            }
        }

        return null;
    }
}