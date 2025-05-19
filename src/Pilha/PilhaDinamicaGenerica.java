package Pilha;
import java.util.NoSuchElementException;

public class PilhaDinamicaGenerica<T> implements Empilhavel<T> {
	private int tamanho;
	private int quantidade;
	private NoDuplo<T> ponteiroTopo;
    
	public PilhaDinamicaGenerica(int tamanho) {
		this.tamanho = tamanho;
		quantidade = 0;
		ponteiroTopo = null;
	}

	public PilhaDinamicaGenerica() {
		this(10);
	}

	@Override
	public void empilhar(T dado) {
		if (estaCheia()) {
			throw new NoSuchElementException("Pilha Cheia!");
		}
		NoDuplo<T> noTemporario = new NoDuplo<T>();
		noTemporario.setDado(dado);
		noTemporario.setAnterior(ponteiroTopo);
		if (!estaVazia()) {
			ponteiroTopo.setProximo(noTemporario);
		}
		ponteiroTopo = noTemporario;
		quantidade++;		
	}
	
	@Override
	public T desempilhar() {
		if (estaVazia()) {
			throw new NoSuchElementException("Pilha Vazia!");
		}
		T dadoTopo = ponteiroTopo.getDado();
		ponteiroTopo = ponteiroTopo.getAnterior();
		quantidade--;
		if (!estaVazia()) {
			ponteiroTopo.setProximo(null);
		}
		return dadoTopo;
	}

	@Override
	public T espiar() {
		if (estaVazia()) {
			throw new NoSuchElementException("Pilha Vazia!");
		}
		T dadoTopo = ponteiroTopo.getDado();
		return dadoTopo;
	}

	@Override
	public void atualizar(T novoDado) {
		if (estaVazia()) {
			throw new NoSuchElementException("Pilha Vazia!");
		}
		ponteiroTopo.setDado(novoDado);
	}

	@Override
	public boolean estaVazia() {
		return (quantidade == 0);
	}
	
	@Override
	public boolean estaCheia() {
		return (quantidade == tamanho);
	}

	@Override
	public String imprimir() {
		NoDuplo<T> ponteiroAuxiliar = ponteiroTopo;
		String resultado = "[";
		for (int i = quantidade - 1; i >= 0; i--) {
			resultado += ponteiroAuxiliar.getDado();
			if (i != 0) {
				resultado += ",";
			}
			ponteiroAuxiliar = ponteiroAuxiliar.getAnterior();
		}
		return resultado + "]";
	}
}