//Pacote da classe
package array.encadeado;

/**
 * Descricao: Classe que implementa um arrayList
 *
 * @author FC20163243 Data: 08/02/2018 local: Catolica do Tocantins
 */
public class MeuArrayList<T> {

    //Atributos da classe
    private final int tamanho = 1000; //tamanho padrao
    private T[] array = (T[]) new Object[tamanho];
    private int finalLista = 0;//variavel que pega o ultimo elemento do array

    //Construtor da classe
    public MeuArrayList() {
    }

    //Metodo que realoca a memoria caso necessario
    private void realocar() {

        //Aloca um novo vetor com o tamanho anterior mais memoria extra
        T[] temp = (T[])new Object[array.length + tamanho];

        //Realiza a copia dos elementos para o novo vetor
        for (int posicao = 0; posicao < finalLista; posicao++) {
            temp[posicao] = array[posicao];
        }

        //Revalida a variavel de referencia da lista
        array = temp;
    }

    public boolean estaVazioOuNao() {
        //Operador ternario
        return (finalLista == 0) ? true : false;
    }

    //Metodo para realizar o adicionamento na ultima posição
    public void adicionar(T element) {
        //Verificando se ainda existe espaço no array
        if (finalLista >= array.length) {
            realocar();
        }
        //adicionando o elemento na ultima posiçao
        array[finalLista] = element;
        finalLista++;
    }

    //Metodo que devolve o tamanho atual da lista
    public int tamanho() {
        return finalLista;
    }

    public T buscarUmElementoNaLista(int pos) {
        
        //Metodo que busca um elemento na lista
        if (pos < 0 || pos >= finalLista) {
            throw new ArrayIndexOutOfBoundsException();
        }
        //Retorna o elemento procurado
        return array[pos];
    }

    public T inserir(int pos, T element) {

        T copy = null;

        if (pos < finalLista) {
            copy = array[pos];
            array[pos] = element;
        }
        return copy;
    }

    public T remover(int pos) {
        T copy = null;

        //verifica se a posição solicitada existe
        if (pos < 0 || pos >= finalLista) {
            //Lança a exeção e a remoção nao é realizada
            throw new ArrayIndexOutOfBoundsException();
        }
        //salvo o elemento
        copy = array[pos];

        //Exclui logicamente um elemento reposicionando os demais
        for (int i = pos; i < finalLista - 1; i++) {
            array[pos] = array[pos + 1];
        }
        
        //Como foi perdido uma posicao o size diminui.
        finalLista--;
        
        //Retorna o elemento excluido
        return copy;
    }

    //Metodo que insere um novo elemento na lista na posicao desejada
    public void adicionarEm(int posicao, T elemento) {
        
        //Verifica se a posicao solicitada existe
        if (posicao < 0 || posicao > finalLista){
            //Lança a exeção e a adicao nao é realizada
            throw new ArrayIndexOutOfBoundsException();
        }
        
        //Verifica se existe memoria suficiente
        if (finalLista == array.length) {
            realocar();
        } 
        
        //Se insercao na primeira posicao, desloca todos os demais elementos para a direita e insere
        if (posicao == finalLista)
        {
                array[finalLista] = elemento;
        }
        else 
        {
            //Insercao no meio ou final da lista
            for (int pos = finalLista; pos > posicao; pos--)
            {
                    array[pos] = array[pos - 1];
            }
            array[posicao] = elemento;
        }

        //Atualiza a variavel de insercao
        finalLista++;
    }
}

