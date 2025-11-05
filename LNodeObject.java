import javax.swing.JOptionPane;

public class LNodeObject<Object> {

    private Object data;
    private LNodeObject next;
    private LNodeObject head;

    public LNodeObject() {
        next = head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void error_message(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private int getSizeInternal() {
        int counter = 0;
        LNodeObject link = head;
        while (link != null) {
            link = link.next;
            counter++;
        }
        return counter;
    }
    
    public void addAtFirst(Object value) {
        LNodeObject newNode = new LNodeObject();
        newNode.data = value;

        if (isEmpty()) {
            newNode.next = null;
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    
    public void addAtLast(Object value) {
        if (isEmpty()) {
            addAtFirst(value);
        } else {
            LNodeObject link = head;
            while (link.next != null) {
                link = link.next;
            }

            LNodeObject newNode = new LNodeObject();
            newNode.data = value;
            newNode.next = null;

            link.next = newNode;
        }
    }
    
    public void addAtPosition(Object value, int position) {
        if (isEmpty()) {
            error_message("List is EMPTY. Node is added at the Beginning");
            addAtFirst(value);
        } else if (position == 1) {
            error_message("Node is added at the Beginning");
            addAtFirst(value);
        } else if (position < 1 || position > currentSize() + 1) {
            error_message(position + " IS NOT valid");
        } else if (position == currentSize() + 1) {
            error_message("Node is added at the End");
            addAtLast(value);
        } else {
            LNodeObject link = head;
            int ctr = 1;
            while (ctr < position - 1) {
                link = link.next;
                ctr++;
            }

            LNodeObject newNode = new LNodeObject();
            newNode.data = value;

            newNode.next = link.next;
            link.next = newNode;
        }
    }
    
    public void deleteAtFirst(){
        if(isEmpty()){
            error_message("Deleting Not Allowed. Linked List is empty.");
        } else {
            LNodeObject link = head;
            head = link.next;
            System.out.println("Deleting is Successful !");
        }
    }

    public void deleteAtLast(){
        if(isEmpty()){
            error_message("Deleting Not Allowed. Linked List is empty.");
        } else if (head.next == null) {
            head = null;
            System.out.println("Deleting is Successful !");
        } else {
            LNodeObject visit = head;
            LNodeObject link = null;

            while(visit.next != null){
                link = visit;
                visit = visit.next;
            }
            
            link.next = null;
            
            System.out.println("Deleting is Successful !");
        }
    }
    
    public void deleteAtPosition(int position) {
        if (isEmpty()) {
            error_message("The list is empty. Try to add a value");
        } else if (position == 1) { 
            deleteAtFirst();
        } else if (position < 1 || position > currentSize()) {
            error_message("Position " + position + " is NOT valid");
        } else {
            LNodeObject link = head;
            int ctr = 1;

            while (ctr < position - 1) {
                link = link.next;
                ctr++;
            }

            LNodeObject nodeToDelete = link.next;
            link.next = nodeToDelete.next;
            
            System.out.println("Deleting is Successful !");
        }
    }

    public Object getFirst(){ //GIAN EDWARD SAMBAS
        if(isEmpty()){
            error_message("List is empty. Cannot retrieve first element.");
            return null;
        } else {
            return (Object) head.data;
        }
    }
    
    public Object getLast(){ //GIAN EDWARD SAMBAS
        if(isEmpty()){
            error_message("List is empty. Cannot retrieve last element.");
            return null;
        } else {
            LNodeObject link = head;
            while(link.next != null){
                link = link.next;
            }
            return (Object) link.data;
        }
    }
    
    public int currentSize() {
        if (isEmpty()) {
            error_message("List is empty");
            return 0;
        }

        int counter = 1;
        LNodeObject link = head;

        while (link.next != null) {
            link = link.next;
            counter++;
        }

        return counter;
    }

    public String traverse() {
        if (isEmpty()) {
            return "List is empty";
        } else {
            String hold = "STUDENT LIST:\n"; 
            LNodeObject link = head;

            while (link != null) {
                Student1 student = (Student1) link.data;
                hold += student.getStudent() + "\n"; 
                
                link = link.next;
            }

            return hold;
        }
    }
    
    public void addInMiddle(Object value) { 
        int size = getSizeInternal();
        if (size == 0) {
            addAtFirst(value);
            error_message("List was empty. Node added at position 1 (first).");
            return;
        }
        
        int middlePosition = (size / 2) + 1;

        addAtPosition(value, middlePosition);
        System.out.println("Node " + value + " added successfully at position " + middlePosition);
    }

    public void deleteInMiddle() { 
        int size = getSizeInternal();
        if (size == 0) {
            error_message("Deletion Not Allowed. Linked List is empty.");
            return;
        }

        int positionToDelete = (size / 2) + 1;
        
        deleteAtPosition(positionToDelete);
        System.out.println("Node at position " + positionToDelete + " (Middle) deleted successfully.");
    }

    public void deleteValue(Object value) { 
        if (isEmpty()) {
            error_message("Deletion Not Allowed. Linked List is empty.");
            return;
        }

        if (head.data != null && head.data.equals(value)) {
            head = head.next;
            System.out.println("Value " + value + " deleted successfully (at first node).");
            return;
        }

        LNodeObject current = head;
        LNodeObject previous = null;

        while (current != null && (current.data == null || !current.data.equals(value))) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            error_message("Value " + value + " not found in the list. Nothing deleted.");
            return;
        }

        previous.next = current.next;
        System.out.println("Value " + value + " deleted successfully.");
    }

    public int indexOf(Object value) { 
        if (isEmpty()) {
            return -1;
        }

        LNodeObject link = head;
        int position = 1;

        while (link != null) {
            if ((link.data == null && value == null) || (link.data != null && link.data.equals(value))) {
                return position;
            }
            link = link.next;
            position++;
        }

        return -1;
    }

    public Object get(int position) { 
        int size = getSizeInternal();
        
        if (isEmpty() || position < 1 || position > size) {
            error_message("Invalid position " + position + ". List size is " + size + ".");
            return null;
        }

        LNodeObject link = head;
        int currentPos = 1;

        while (currentPos < position) {
            link = link.next;
            currentPos++;
        }

        return (Object) link.data;
    }

    public Object getNode(int position){
        Object value = null;
        if (isEmpty()) {
            error_message("The list is empty. Try to add a value");
        } else {
            LNodeObject pointer = head;
            int ctr = 0;
            
            while (ctr != position) { 
                pointer = pointer.next;
                ctr++;
            }
            value = (Object) pointer.data;
        } 
        return value;
    }
    
    public String traverseNode() {
        String hold = "";
        if (isEmpty()) {
            hold = "List is empty";
        } else {
            LNodeObject pointer = head;
            int ctr = 0;
            while (pointer != null) {
                Student1 student = (Student1) pointer.data; 
                hold += student.getStudent() + "\n";
                pointer = pointer.next;
            } 
        }
        return hold;
    }
}
