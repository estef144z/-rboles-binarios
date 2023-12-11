public class UsaABB {

    public static void main(String[] args) {
        ABB arbol = new ABB();

        // Insertar valores en el árbol
        arbol.insertarValor(25);
        arbol.insertarValor(8);
        arbol.insertarValor(29);
        arbol.insertarValor(38);
        arbol.insertarValor(27);

        // Imprimir el árbol de forma horizontal
        System.out.println("Árbol de forma horizontal:");
        arbol.imprimirHorizontal();

        // Buscar un nodo en el árbol
        int valorBuscado = 29;
        Nodo nodoBuscado = arbol.buscarNodo(valorBuscado);
        if (nodoBuscado != null) {
            System.out.println("Nodo encontrado: " + nodoBuscado.dato);
        } else {
            System.out.println("Nodo no encontrado.");
        }

        // Recorrer el árbol en preorden
        System.out.println("Recorrido en preorden:");
        arbol.recorrerPreorden();

        // Recorrer el árbol en inorden
        System.out.println("\nRecorrido en inorden:");
        arbol.recorrerInorden();

        // Recorrer el árbol en postorden
        System.out.println("\nRecorrido en postorden:");
        arbol.recorrerPostorden();

        // Eliminar un nodo
        int valorAEliminar = 29;
        arbol.eliminarNodo(valorAEliminar);
        System.out.println("\nÁrbol después de eliminar el nodo " + valorAEliminar + ":");
        arbol.imprimirHorizontal();
    }
}

