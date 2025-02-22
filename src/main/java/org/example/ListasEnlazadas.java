package org.example;

public class ListasEnlazadas {

    private Nodo cabeza;

    public ListasEnlazadas() {
        cabeza = null;
    }

    // Método para agregar un nuevo nodo al final de la lista
    public void agregar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.enlace!= null) {
                actual = actual.enlace;
            }
            actual.enlace = nuevoNodo;
        }
    }

    // Método para eliminar un nodo con un dato específico
    public void eliminar(int dato) {
        if (cabeza == null) {
            return;
        }
        if (cabeza.dato == dato) {
            cabeza = cabeza.enlace;
            return;
        }
        Nodo actual = cabeza;
        while (actual.enlace!= null && actual.enlace.dato!= dato) {
            actual = actual.enlace;
        }
        if (actual.enlace!= null) {
            actual.enlace = actual.enlace.enlace;
        }
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }

    // Clase Nodo
    private class Nodo {
        int dato;
        Nodo enlace;

        public Nodo(int dato) {
            this.dato = dato;
            this.enlace = null;
        }
    }

    // Método para imprimir la lista (opcional)
    public void imprimirLista() {
        Nodo actual = cabeza;
        while (actual!= null) {
            System.out.print(actual.dato + " ");
            actual = actual.enlace;
        }
        System.out.println();
    }

    public static void main(String args) {
        ListasEnlazadas lista = new ListasEnlazadas();
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.imprimirLista(); // Imprime: 10 20 30

        lista.eliminar(20);
        lista.imprimirLista(); // Imprime: 10 30

        System.out.println(lista.estaVacia()); // Imprime: false
    }
}
