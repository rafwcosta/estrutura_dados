package Lista;

public class ListaDinamica implements Listavel {

	private int quantidade;
	private int tamanho;
	private NoDuplo ponteiroInicio;
	private NoDuplo ponteiroFim;

	public ListaDinamica() {
		this(10);
	}

	public ListaDinamica(int tamanho) {
		quantidade = 0;
		this.tamanho = tamanho;
		ponteiroInicio = null;
		ponteiroFim = null;
	}

	@Override
	public void anexar(Object dado) throws OverflowException {
		if (!estaCheia()) {
			NoDuplo noTemporario = new NoDuplo();
			noTemporario.setDado(dado);
			if (!estaVazia()) {
				ponteiroFim.setProximo(noTemporario);
				noTemporario.setAnterior(ponteiroFim);
			} else {
				ponteiroInicio = noTemporario;
			}
			ponteiroFim = noTemporario;
			quantidade++;
		} else {
			throw new OverflowException("Lista Cheia!");
		}
	}

	@Override
	public void inserir(int posicao, Object dado) throws OverflowException {
		if (!estaCheia()) {
			if ((posicao >= 0) && (posicao <= quantidade)) {
				NoDuplo noTemporario = new NoDuplo();
				noTemporario.setDado(dado);

				NoDuplo ponteiroAnterior = null;
				NoDuplo ponteiroProximo = ponteiroInicio;

				for (int i = 0; i < posicao; i++) {
					ponteiroAnterior = ponteiroProximo;
					ponteiroProximo = ponteiroProximo.getProximo();
				}

				if (ponteiroAnterior != null) {
					ponteiroAnterior.setProximo(noTemporario);
				} else {
					ponteiroInicio = noTemporario;
				}

				if (ponteiroProximo != null) {
					ponteiroProximo.setAnterior(noTemporario);
				} else {
					ponteiroFim = noTemporario;
				}

				noTemporario.setAnterior(ponteiroAnterior);
				noTemporario.setProximo(ponteiroProximo);
				quantidade++;
			} else {
				System.err.println("Índice inválido!");
			}
		} else {
			throw new OverflowException("Lista Cheia!");
		}
	}

	@Override
	public Object selecionar(int posicao) {
		if (!estaVazia()) {
			if ((posicao >= 0) && (posicao < quantidade)) {
				NoDuplo ponteiroAuxiliar = ponteiroInicio;
				for (int i = 0; i < posicao; i++) {
					ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
				}
				return ponteiroAuxiliar.getDado();
			} else {
				System.err.println("Índice inválido!");
			}
		} else {
			System.err.println("Lista Vazia!");
		}
		return null;
	}

	@Override
	public Object[] selecionarTodos() {
		Object[] dadosTemporario = new Object[quantidade];
		if (!estaVazia()) {
			NoDuplo ponteiroAuxiliar = ponteiroInicio;
			for (int i = 0; i < quantidade; i++) {
				dadosTemporario[i] = ponteiroAuxiliar.getDado();
				ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
			}
		} else {
			System.err.println("Lista Vazia!");
		}
		return dadosTemporario;
	}

	@Override
	public void atualizar(int posicao, Object novoDado) {
		if (!estaVazia()) {
			if ((posicao >= 0) && (posicao < quantidade)) {
				NoDuplo ponteiroAuxiliar = ponteiroInicio;
				for (int i = 0; i < posicao; i++) {
					ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
				}
				ponteiroAuxiliar.setDado(novoDado);
			} else {
				System.err.println("Índice inválido!");
			}
		} else {
			System.err.println("Lista Vazia!");
		}
	}

	@Override
	public Object apagar(int posicao) throws UnderflowException {
		if (!estaVazia()) {
			if ((posicao >= 0) && (posicao < quantidade)) {
				NoDuplo ponteiroAuxiliar = ponteiroInicio;
				for (int i = 0; i < posicao; i++) {
					ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
				}

				Object dadoTemporario = ponteiroAuxiliar.getDado();
				NoDuplo ponteiroAnterior = ponteiroAuxiliar.getAnterior();
				NoDuplo ponteiroProximo = ponteiroAuxiliar.getProximo();

				if (ponteiroAnterior != null) {
					ponteiroAnterior.setProximo(ponteiroProximo);
				} else {
					ponteiroInicio = ponteiroProximo;
				}

				if (ponteiroProximo != null) {
					ponteiroProximo.setAnterior(ponteiroAnterior);
				} else {
					ponteiroFim = ponteiroAnterior;
				}

				quantidade--;
				return dadoTemporario;
			} else {
				throw new IndexOutOfBoundsException("Índice inválido!");
			}
		} else {
			throw new UnderflowException("Lista Vazia!");
		}
	}

	@Override
	public boolean estaCheia() {
		return (quantidade == tamanho);
	}

	@Override
	public boolean estaVazia() {
		return (quantidade == 0);
	}

	@Override
	public String imprimir() {
		StringBuilder resultado = new StringBuilder("[");
		NoDuplo ponteiroAuxiliar = ponteiroInicio;
		for (int i = 0; i < quantidade; i++) {
			resultado.append(ponteiroAuxiliar.getDado());
			if (i < quantidade - 1) {
				resultado.append(", ");
			}
			ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
		}
		resultado.append("]");
		return resultado.toString();
	}
}
