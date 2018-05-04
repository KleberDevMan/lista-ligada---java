package array.encadeado;

/**
 *
 * @author Kleber Junio
 * @param <T>
 */
//Classe que ultiliza um conjunto de Nos
//para implementar uma lista ligada (linkedlist)
//Nesse tipo de lista não é necessario realocar memoria,
//cada item da lista guarda o endereco de memoria do proximo item e do anterior,
//ou seja, é uma memoria em cadeia
public class ListaLigadaNoCaldaNoCabeca<T> {

    //no que armazena o endereco do primeiro elemento da lista
    private NoMelhorado vrNoCabeca = null;
    //no que armazena o endereco do ultimo elemento da lista
    private NoMelhorado vrNoCalda = null;
    //Qtd de elementos da lista
    private int qtdElementos = 0;

    //Metodo que retorna a quantidade de elementos
    public int tamanho() {
        return qtdElementos;
    }

    //Metodo usado para iserir um novo elemento
    public void adiciona(T valor) {
        //transformando o valor a ser adicionado em um nó
        NoMelhorado novo = new NoMelhorado(valor);
        qtdElementos++;//incrementa a quantidade de elementos da lista

        //verifica se existe o nó cabeca
        if (vrNoCabeca == null) {
            vrNoCabeca = novo;
            vrNoCalda = novo;
        } else {
            vrNoCalda.proximo = novo;
            novo.anterior = vrNoCalda;
            vrNoCalda = novo; //revalido o no calda
        }
    }
    
     //Metodo usado para adicionar em uma determinada posição
    public void adicionarEm(int posicao, T valor) {

        //Verifica se a posicao solicitada é uma posicao valida
        if (posicao < 0 || posicao > qtdElementos) {
            throw new ArrayIndexOutOfBoundsException("Posicao inválida!");
        }

        //Cria o novo nó e incrementa a qtd elementos da lista
        NoMelhorado novoNo = new NoMelhorado(valor);
        qtdElementos++;

        //Verifica se a posicao de insercao e a ultima
        if (posicao == qtdElementos-1) {
            vrNoCalda.proximo = novoNo;
            novoNo.anterior = vrNoCalda;
            System.out.println("colocando na ultima pos.........");
            vrNoCalda = novoNo;
            return;
        }

        //verifica se a posicao de insercao e a primeira
        if (posicao == 0) {
            //percorrendo a lista até a primeira posicao
            vrNoCabeca.anterior = novoNo;
            novoNo.proximo = vrNoCabeca;
            vrNoCabeca = novoNo;
            return;
        }

        //Variavel que percorrera a lista ate chegar na posicao desejada
        NoMelhorado aux = vrNoCabeca;

        //Percorre a lista até chegar na posicao desejada 
        for (int i = 0; i < posicao; i++) {
            aux = aux.proximo;
        }

        //Adicionando o novoNo na lista
        aux.anterior.proximo = novoNo;
        novoNo.anterior = aux.anterior;
        aux.anterior = novoNo;
        novoNo.proximo = aux;
    }

    //metodo que busca uma determinada posiçao na lista de memoria encadiada
    public T get(int posicao) {

        //Verifica se a posicao solicitada é uma posicao valida
        if (posicao < 0 || posicao > qtdElementos) {
            throw new ArrayIndexOutOfBoundsException("Posicao inválida!");
        }

        //Variavel que percorrera a lista ate chegar na posicao desejada
        NoMelhorado aux = vrNoCabeca;

        //Percorre a lista até chegar na posicao desejada 
        for (int i = 0; i < posicao; i++) {
            aux = aux.proximo;
        }
        //Devolvendo o conteudo posicao desejada
        return (T) aux.getConteudo();
    }

    //metodo que diz se a lista está vazia ou não
    public boolean isEmpty() {

        //Verifica se o primeiro elemento esta instanciado ou nao
        if (vrNoCabeca == null) {
            return true;
        }
        return false;
    }

    //metodo que remove um elemento da lista
    public T remover(int posicao) {

        //Verifica se a posicao solicitada é uma posicao valida
        if (posicao < 0 || posicao >= qtdElementos) {
            throw new ArrayIndexOutOfBoundsException("Posicao inválida!");
        }
        qtdElementos--;//subtraio da qtd de elementos

        //Variavel que salvará o conteudo excluido
        T copy = null;

        //Verifica se o nó a ser removido é o ultimo
        if (posicao == (qtdElementos)) {
            copy = (T) vrNoCalda.getConteudo();//salvando o conteudo do ultimo nó
            vrNoCalda = vrNoCalda.anterior; //o no calda sendo perdido. Agora ele aponta para o penultimo nó
            vrNoCalda.proximo = null; //setando o atributo proximo do no com null
            return copy;
        } else //Verifica se o nó a ser removido é o primeiro
         if (posicao == 0) {
                //Verifica se é o unico
                if (vrNoCabeca.proximo == null) {
                    copy = (T) vrNoCabeca.getConteudo();//salvando o conteudo do ultimo nó
                    vrNoCabeca = null;
                    vrNoCalda = null;
                    return copy;
                }
                //É a primeira posicao mas nao a unica, então:
                copy = (T) vrNoCabeca.getConteudo();//salvando o conteudo do ultimo nó
                vrNoCabeca = vrNoCabeca.proximo; //o no calda sendo perdido. Agora ele aponta para o penultimo nó
                vrNoCabeca.anterior = null; //setando o atributo proximo do no com null
                return copy;
            }
        //Variavel usada para se chegar na posição de remocao
        NoMelhorado aux = vrNoCabeca;

        //se a posicao de remocao nao for a primeira
        //percorrendo a lsita até chegar na posicao desejada
        for (int i = 0; i < posicao; i++) {
            aux = aux.proximo;
        }
        copy = (T) aux.getConteudo();//salvando o conteudo do ultimo nó

        //perdendo o endereco de memoria da posicao a ser removida
        aux.anterior.proximo = aux.proximo;
        aux.proximo.anterior = aux.anterior;

        return copy;
    }

    //Setando um valor em uma posição existente no array
    public T set(int posicao, T valor) {

        //Verifica se a posicao solicitada é uma posicao valida
        if (posicao < 0 || posicao >= qtdElementos) {
            throw new ArrayIndexOutOfBoundsException("Posicao inválida!");
        }

        //Veriavel usada para salvar o conteudo da posicao a ser setada
        T copy = null;

        //Verificando se a posicao de set e a ultima da lista
        if (posicao == (qtdElementos - 1)) {
            copy = (T) vrNoCalda.getConteudo();
            vrNoCalda.setConteudo(valor);//setando valor na ultima posicao da lista
            return copy;
        }
        
        //Verificando se a posicao de set e a primeira da lista
        if (posicao == 0) {
            copy = (T) vrNoCabeca.getConteudo();
            vrNoCabeca.setConteudo(valor);//setando valor na primeira posicao da lista
            return copy;
        }

        //Percorrendo a lista até a posicao desejada
        NoMelhorado aux = vrNoCalda;
        for (int i = 0; i < ((qtdElementos - 1) - posicao); i++) {
            aux = aux.anterior;
        }
        copy = (T) aux.getConteudo();
        aux.setConteudo(valor);//setando o valor na posicao desejada

        return (T) copy;
    }

    //metodo usada para imprimir os elementos da lista
    @Override
    public String toString() {

        //Verifica se a lista esta vazia
        if (vrNoCabeca == null) {
            return "[ ]";
        }

        //Variavel que sera retornada com os dados da lista
        String valores = "";

        //No auxiliar que percorrera a lista do inicio até o fim
        NoMelhorado aux = vrNoCabeca;

        
        //Vai percorrendo a lista do primeiro elemento até o ultimo
        for (int i = 0; i < qtdElementos; i++) {
            valores = valores + "[ " + aux.getConteudo() + " ]";
            aux = aux.proximo;
        }
        
        return valores;
    }

}
