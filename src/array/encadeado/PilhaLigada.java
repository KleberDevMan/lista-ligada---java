/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array.encadeado;

/**
 *
 * @author Kleber Junio
 */
public class PilhaLigada<T> extends ListaLigadaNoCabeca<T>{
    
    //Metodo que insere um elemento na ultima posicao da lista
    public void iserir(T valor){
        super.adicionarEm(0, valor);
    }
    //Metodo que remove um elemento da ultima posicao da lista
    public T remover(){
        return (T) this.remover(0);
    }
    
    //Metodo para visualizar os elemetos da pilha
    @Override
    public String toString() {
        return super.toString();
    }
}
