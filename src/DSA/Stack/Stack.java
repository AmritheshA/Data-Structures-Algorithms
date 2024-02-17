package DSA.Stack;

class StackNode<Type> {
    Type value;
    StackNode<Type> next;

    public StackNode(Type value) {
        this.value = value;
    }
}

public class Stack<Type> {
    StackNode<Type> top;

    public void push(Type value) {

        StackNode<Type> newNode = new StackNode<>(value);

        if (top == null) {
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
    }

    public Type pop(){

        if (top == null) {
            System.out.println("Stack is empty");
            throw new NullPointerException("Stack is empty");
        }
        Type value = top.value;
        top = top.next;
        return value;
    }

    public boolean isContains(int value){

        StackNode<Type> current = top;

        while (current != null){
            if(current.value.equals(value)){
                return true;
            }
        }
        return false;
    }


    public void display() {

        StackNode<Type> current = top;

        if(top == null) {
            System.out.println("Stack is empty");
            return;
        }

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.pop();
        stack.pop();

        stack.isContains(20);

        stack.display();


    }


}
