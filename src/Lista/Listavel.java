package Lista;

public interface Listavel {
    void anexar(Object dado) throws OverflowException;
    void inserir(int posicao, Object dado) throws OverflowException;
    Object selecionar(int posicao);
    Object[] selecionarTodos();
    void atualizar(int posicao, Object novoDado);
    Object apagar(int posicao) throws UnderflowException;
    boolean estaCheia();
    boolean estaVazia();
    String imprimir();
}
