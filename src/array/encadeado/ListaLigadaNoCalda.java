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
public class ListaLigadaNoCalda<T> {

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

        //verifica se existe o nó calda
        if (vrNoCalda == null) {
            vrNoCalda = novo;
            return; //volta para o metodo que o chamou
        } else {
            vrNoCalda.proximo = novo;
            novo.anterior = vrNoCalda;
            vrNoCalda = novo;
        }
    }

    //metodo que busca uma determinada posiçao na lista de memoria encadiada
    public T get(int posicao) {

        //Verifica se a posicao solicitada é uma posicao valida
        if (posicao < 0 || posicao > qtdElementos) {
            throw new ArrayIndexOutOfBoundsException("Posicao inválida!");
        }

        //Variavel que percorrera a lista ate chegar na posicao desejada
        NoMelhorado aux = vrNoCalda;

        //Percorra a lista até o primeiro elemento
        while (aux.anterior != null) {
            aux = aux.anterior;
        }

        //Percorre a lista até chegar na posicao desejada 
        for (int i = 0; i < posicao; i++) {
            aux = aux.proximo;
        }
        //Devolvendo o conteudo posicao desejada
        return (T) aux.getConteudo();
    }

    //metodo que diz se a lista está vazia ou não
    public boolean isEmpty() {

        //Verifica se o ultimo no esta instanciado ou nao
        if (vrNoCalda == null) {
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

        //Verifica se o nó a ser removido é o ultimo
        if (posicao == qtdElementos - 1) {

            T copy = (T) vrNoCalda.getConteudo();//salvando o conteudo do ultimo nó
            vrNoCalda = vrNoCalda.anterior; //o no calda sendo perdido. Agora ele aponta para o penultimo nó
            vrNoCalda.proximo = null; //setando o atributo proximo do no com null
            qtdElementos--;//subtraio da qtd de elementos
            return copy;
        }

        //Variavel usada para se chegar na posição de remocao
        NoMelhorado aux = vrNoCalda;

        //Veriavel usada para salvar o conteudo da posicao removida
        T copy = null;

        //Se a posicao de remocao for a primeira
        if (posicao == 0) {

            //percorrendo a lista ate chegar na primeira posicao
            while (aux.anterior != null) {
                aux = aux.anterior;
                copy = (T) aux.getConteudo();
            }
            aux.proximo.anterior = null;
            qtdElementos--;//subtraio da qtd de elementos
            return copy;

        }

        //se a posicao de remocao nao for a primeira
        //percorrendo a lsita até chegar na posicao desejada
        for (int i = 0; i < ((qtdElementos - 1) - posicao); i++) {
            aux = aux.anterior;
            copy = (T) aux.getConteudo();
            aux.anterior.proximo = aux.proximo;
            aux.proximo.anterior = aux.anterior;
        }
        qtdElementos--;//subtraio da qtd de elementos

        return copy;
    }

    //Setando um valor em uma posição existente no array
    public T set(int posicao, T valor) {

        //Verifica se a posicao solicitada é uma posicao valida
        if (posicao < 0 || posicao > qtdElementos) {
            throw new ArrayIndexOutOfBoundsException("Posicao inválida!");
        }

        //Veriavel usada para salvar o conteudo da posicao a ser setada
        T copy = null;

        //Verificando se a posicao de set e a ultima da lista
        if (posicao == (tamanho() - 1)) {
            copy = (T) vrNoCalda.getConteudo();
            vrNoCalda.setConteudo(valor);//setando valor na ultima posicao da lista
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
        if (posicao == (qtdElementos - 1)) {
            vrNoCalda.proximo = novoNo;
            novoNo.anterior = vrNoCalda;
            return;
        }

        //Variavel que percorrera a lista ate a posicao desejada
        NoMelhorado aux = vrNoCalda;

        //verifica se a posicao de insercao e a primeira
        if (posicao == 0) {
            //percorrendo a lista até a primeira posicao
            while (aux.anterior != null) {
                aux = aux.anterior;
            }
            novoNo.anterior = aux.anterior;
            aux.anterior = novoNo;
            novoNo.proximo = aux;
            return;
        }

        //percorrendo a lista até a posicao desejada
        for (int i = 1; i < ((qtdElementos - 1) - posicao); i++) {
            aux = aux.anterior;
        }
        aux.anterior.proximo = novoNo;
        novoNo.anterior = aux.anterior;
        aux.anterior = novoNo;
        novoNo.proximo = aux;
    }

    //metodo usada para imprimir os elementos da lista
    @Override
    public String toString() {

        //Verifica se a lista esta vazia
        if (vrNoCalda == null) {
            return "[ ]";
        }

        //Variavel que sera retornada com os dados da lista
        String valores = "";

        //No auxiliar que percorrera a lista do final até o começo
        NoMelhorado aux = vrNoCalda;

        //Percorra a lista até o primeiro elemento
        while (aux.anterior != null) {
            aux = aux.anterior;
        }
        //Vai percorrendo a lista do primeiro elemento até o ultimo
        for (int i = 0; i < qtdElementos; i++) {
            valores = valores + "[ " + aux.getConteudo() + " ]";
            aux = aux.proximo;
        }

        return valores;
    }

}
