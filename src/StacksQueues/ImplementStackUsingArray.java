package StacksQueues;

import java.util.Stack;

public class ImplementStackUsingArray {

    int[] arr;
    int capacity;
    int top;

    public static void main(String[] args) {

        ImplementStackUsingArray stack = new ImplementStackUsingArray(100);
        stack.push(10);
        stack.push(5);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }

    public ImplementStackUsingArray(int capacity){
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.top = -1;
    }

    public void push(int x){
        if(!isFull()) {
            top++;
            arr[top] = x;
        }
    }

    public int pop(){
        if(isEmpty()){
            return -1;
        }
        return arr[top--];
    }

    public int peek(){
        if(isEmpty())
            return -1;

        return arr[top];
    }

    public boolean isFull(){
        return top+1 == capacity;
    }

    public boolean isEmpty(){
        return top == -1;
    }

}
