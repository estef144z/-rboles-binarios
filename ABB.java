public class ABB {
    private Nodo raiz;  // Nodo raíz del árbol

    // Constructor, inicializa la raíz como nula
    ABB() {
        this.raiz = null;
    }

    // Verifica si el árbol está vacío
    public boolean esVacio() {
        return (this.raiz == null);
    }

    // Getter para la raíz del árbol
    public Nodo regresaRaiz() {
        return this.raiz;
    }

    // Método para insertar un valor en el árbol
    public void insertarValor(int valor) {
        if (this.raiz == null) {
            // Si la raíz es nula, crea un nuevo nodo como raíz
            System.out.println("Insertando raíz: " + valor);
            this.raiz = new Nodo();
            this.raiz.dato = valor;
            this.raiz.izquierdo = null;
            this.raiz.derecho = null;
        } else {
            // Si la raíz no es nula, llama a insertarNodo para insertar el valor en el lugar adecuado
            insertarNodo(valor, this.raiz);
        }
    }
    // Método auxiliar para insertar un nodo en el árbol
    public void insertarNodo(int valor, Nodo nodoRef) {
        if (valor <= nodoRef.dato) {
            // Si el valor es menor o igual, lo inserta en el subárbol izquierdo
            if (nodoRef.izquierdo == null) {
                System.out.println("Insertando hijo izquierdo de " + nodoRef.dato + ": " + valor);
                nodoRef.izquierdo = new Nodo();
                nodoRef.izquierdo.dato = valor;
                nodoRef.izquierdo.izquierdo = null;
                nodoRef.izquierdo.derecho = null;
            } else {
                insertarNodo(valor, nodoRef.izquierdo);
            }
        } else {
            // Si el valor es mayor, lo inserta en el subárbol derecho
            if (valor > nodoRef.dato) {
                if (nodoRef.derecho == null) {
                    System.out.println("Insertando hijo derecho de " + nodoRef.dato + ": " + valor);
                    nodoRef.derecho = new Nodo();
                    nodoRef.derecho.dato = valor;
                    nodoRef.derecho.izquierdo = null;
                    nodoRef.derecho.derecho = null;
                } else {
                    insertarNodo(valor, nodoRef.derecho);
                }
            }
        }
    }
     // Método para imprimir el árbol de forma horizontal
    public void imprimirHorizontal() {
        imprimirHorizontal(this.raiz, 0);
    }

    private void imprimirHorizontal(Nodo nodo, int nivel) {
        if (nodo != null) {
            imprimirHorizontal(nodo.derecho, nivel + 1);

            for (int i = 0; i < nivel; i++) {
                System.out.print("   ");
            }

            System.out.println(nodo.dato);
            imprimirHorizontal(nodo.izquierdo, nivel + 1);
        }
    }

    // Método para buscar un nodo en el árbol
    public Nodo buscarNodo(int valor) {
        return buscarNodo(valor, this.raiz);
    }

    private Nodo buscarNodo(int valor, Nodo nodo) {
        if (nodo == null || nodo.dato == valor) {
            return nodo;
        }

        if (valor < nodo.dato) {
            return buscarNodo(valor, nodo.izquierdo);
        } else {
            return buscarNodo(valor, nodo.derecho);
        }
    }

    // Métodos para recorrer el árbol
    public void recorrerPreorden() {
        recorrerPreorden(this.raiz);
    }

    private void recorrerPreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            recorrerPreorden(nodo.izquierdo);
            recorrerPreorden(nodo.derecho);
        }
    }

    public void recorrerInorden() {
        recorrerInorden(this.raiz);
    }

    private void recorrerInorden(Nodo nodo) {
        if (nodo != null) {
            recorrerInorden(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            recorrerInorden(nodo.derecho);
        }
    }

    public void recorrerPostorden() {
        recorrerPostorden(this.raiz);
    }

    private void recorrerPostorden(Nodo nodo) {
        if (nodo != null) {
            recorrerPostorden(nodo.izquierdo);
            recorrerPostorden(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }

    // Método para eliminar un nodo
    public void eliminarNodo(int valor) {
        this.raiz = eliminarNodo(this.raiz, valor);
    }

    private Nodo eliminarNodo(Nodo nodo, int valor) {
        if (nodo == null) {
            return nodo;
        }

        if (valor < nodo.dato) {
            nodo.izquierdo = eliminarNodo(nodo.izquierdo, valor);
        } else if (valor > nodo.dato) {
            nodo.derecho = eliminarNodo(nodo.derecho, valor);
        } else {
            // Nodo con un solo hijo o sin hijos
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            // Nodo con dos hijos: encontrar el sucesor inorden (menor en el subárbol derecho)
            nodo.dato = encontrarSucesorInorden(nodo.derecho);

            // Eliminar el sucesor inorden
            nodo.derecho = eliminarNodo(nodo.derecho, nodo.dato);
        }

        return nodo;
    }

    private int encontrarSucesorInorden(Nodo nodo) {
        int sucesor = nodo.dato;
        while (nodo.izquierdo != null) {
            sucesor = nodo.izquierdo.dato;
            nodo = nodo.izquierdo;
        }
        return sucesor;
    }
}

