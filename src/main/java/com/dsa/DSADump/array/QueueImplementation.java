package com.dsa.DSADump.array;

public class QueueImplementation {

    int capacity;
    int front,rear;
    int queue[];

    public QueueImplementation(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.rear = 0;
        queue=new int[capacity];
    }

    public void insert(int value){
        if(rear==capacity){
            System.out.println("---OVERFLOW---");
        }
        else{
            queue[rear]=value;
            rear++;
        }
    }

    public void delete(){
        if(front==rear){
            System.out.println("---UNDERFLOW---");
        }
        else{
            System.out.println(queue[front]);
            for(int i=0;i<rear-1;i++){
                queue[i]=queue[i+1];
            }

            rear--;
        }

    }

    public void display() {
        if (front == rear) {
            System.out.println("---Queue is Empty---");
        }
        for (int i = front; i < rear; i++) {
            System.out.print(queue[i]+" ");
        }
    }

    public static void main(String args[]){
    QueueImplementation q=new QueueImplementation(10);
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);
        q.insert(6);
        q.insert(7);

        q.display();

        q.delete();
        q.delete();
        q.delete();
        q.delete();

        q.display();

    }
}
