import java.awt.Graphics;
import java.util.IllegalFormatWidthException;
import static javafx.scene.input.KeyCode.T;

// Lista Simplesmente Encadeada DinÃ¢mica com Tail
public class LSEDTail <T> {
	private Celula head;
	private Celula tail;
	private long size;

	private class Celula {
		Object item;
		Celula prox;
	}

	// Fazer lista vazia
	public LSEDTail() {
		head = null;
		tail = null;
		size = 0;
	}
        
        public int elementos(){
            return  (int) size;
        }
        
        public T get(int indice){
            Celula aux = head; 
            int cont = 0;
            if(indice < size){
                while(cont != indice){
                aux = aux.prox;
                cont++;
                }
            }
            else{
                throw new ArrayIndexOutOfBoundsException();
            }
           
            return (T) aux.item;
        }

	public boolean isVazia() {
		return head == null;
	}

	// InserÃ§Ã£o final
	public void insereNoFinal(T item) {
		if (item == null)
			throw new NullPointerException();
		else {
			if (head == null) { // Lista vazia
				// inserÃ§Ã£o do primeiro elemento
				head = new Celula();
				head.item = item;
				tail = head;
			} else {
				tail.prox = new Celula();
				tail.prox.item = item;
				tail = tail.prox;
				// aux.prox.prox = null; nÃ£o Ã© necessÃ¡rio no java
			}
			size++;
		}
	}

	public void insere(T item) {
		if (item == null)
			throw new NullPointerException();
		else {
			Celula novo = new Celula();
			novo.item = item;
			novo.prox = head;
			if (isVazia())
				tail = novo;
			head = novo;
		}
	}
	
	public void insere(int posicao, Object item) {
		
	}

	public T excluir(T item) {
		if (isVazia())
			throw new IllegalArgumentException("Lista vazia!");
		else {
			// pesquisar o elemento a ser excluido
			Celula aux = head, ant = null;
			while (aux != null && !aux.item.equals(item)) {
				ant = aux;
				aux = aux.prox;
			}
			if (aux == null)
				throw new IllegalArgumentException("Elemento nÃ£o encontrado!");
			else {
				if (aux == head)
					head = aux.prox; // inicio
				else
					ant.prox = aux.prox; // meio
				if (aux == tail)
					tail = ant; // fim
				size--;
				return (T) aux.item;
			}
		}

	}
        
        
        public void imprimi(Graphics g){
            Celula aux = head;
             
            
        }

	public void imprimir() {
		Celula aux = head;
		System.out.print("Lista: ");
		while (aux != null) {
			System.out.print(aux.item + "\t");
			aux = aux.prox;
		}
		System.out.println();
	}

}
