package co.edu.uptc.model.structure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T> implements Cloneable {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public Node<T> clone() {
        try {
            @SuppressWarnings("unchecked")
            Node<T> clonedNode = (Node<T>) super.clone();
            if (this.next != null) {
                clonedNode.next = this.next.clone();  // ClonaciÃ³n profunda del siguiente nodo
            }
            return clonedNode;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar el nodo", e);
        }
    }
}
