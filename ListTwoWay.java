
public class ListTwoWay<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public Node<E> getHead() {
        return this.head;
    }

    public Node<E> getTail() {
        return this.tail;
    }

    public int getSize() {
        return this.size;

    }

    /**
     * Add Node to head
     * 
     * @param value
     */
    public void add(E value) {
        Node<E> newNode = new Node<>();
        newNode.value = value;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.previousNode = newNode;
            newNode.nextNode = head;
            head = newNode;
        }
        size++;
    }

    /**
     * Add new node between head and tail
     * 
     * @param value Value of new Node
     * @param index Index of Node after insert new Node
     */
    public void add(E value, int index) {
        if (index >= size || index < 0) return;
        Node<E> currentNode = head;
        Node<E> newNode = new Node<>();
        newNode.value = value;
        while (index > 0) {
            currentNode = currentNode.nextNode;
            index--;
        }
        if (currentNode.nextNode == null) {
            addLast(value);
        } else {
            Node<E> tmp = currentNode.nextNode;
            currentNode.nextNode = newNode;
            newNode.nextNode = tmp;
            newNode.previousNode = currentNode;
            tmp.previousNode = newNode;
        }
        size++;
    }

    /**
     * Add new node to the end of List
     * 
     * @param value Value of added Node
     */
    public void addLast(E value) {
        Node<E> newNode = new Node<>();
        newNode.value = value;
        newNode.previousNode = tail;
        tail.nextNode = newNode;
        tail = newNode;
        size++;
    }

    /**
     * Get Node value by index
     * 
     * @param index
     * @return value of index
     */
    public E get(int index) {
        Node<E> currentNode = head;
        int count = 0;
        while (count < index) {
            count++;
            if (currentNode.nextNode == null)
                throw new ArrayIndexOutOfBoundsException();
            currentNode = currentNode.nextNode;
        }
        return currentNode.value;
    }

    /**
     * Check existed value in the List or not
     * 
     * @param value Checked value int the List
     * @return true or false
     */
    public boolean contains(E value) {
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;

    }

    public int indexOf(E value) {
        Node<E> currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return index;
            }
            currentNode = currentNode.nextNode;
            index++;
        }
        return -1;
    }

    /**
     * Reverting of the List
     */
    public void revert() {
        if (head == null) return;
        Node<E> currentNode = head;
        while (currentNode != null) {
            Node<E> next = currentNode.nextNode;
            Node<E> previous = currentNode.previousNode;
            currentNode.nextNode = previous;
            currentNode.previousNode = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }

    /**
     * Deleting node from List by index
     * @param index Index of node in the List
     */
    public void delete(int index) {
        if (index >= size || index < 0) return;
        Node<E> currentNode = head;
        while (index > 0) {
            currentNode = currentNode.nextNode;
            index--;
        }
        if (currentNode.previousNode == null) {
            currentNode.nextNode.previousNode = null;
            head = currentNode.nextNode;
        } else {
            if (currentNode.nextNode == null) {
                currentNode.previousNode.nextNode = null;
                tail = currentNode.previousNode;
            } else {
                currentNode.previousNode.nextNode = currentNode.nextNode;
                currentNode.nextNode.previousNode = currentNode.previousNode.nextNode;
            }
        }
        size--;
    }


    @Override
    public String toString() {
        Node<E> currentNode = head;
        String output = "";
        while (currentNode != null) {
            output = output + currentNode.value + " ";
            currentNode = currentNode.nextNode;
        }
        return output;
    }

}
