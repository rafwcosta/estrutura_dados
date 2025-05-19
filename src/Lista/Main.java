package Lista;

public class Main {
    public static void main(String[] args) {
        try {
            ListaDinamica lista = new ListaDinamica(5);
            lista.anexar("A");
            lista.anexar("B");
            lista.inserir(1, "X");
            lista.atualizar(0, "Z");
            System.out.println(lista.imprimir());
            System.out.println("Removido: " + lista.apagar(1));
            System.out.println(lista.imprimir());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
