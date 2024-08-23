import java.util.*;

public class Intro_Heap{
    class Heap{
        int[] arr;
        int size;

        Heap(){
            arr=new int[100];
            size=0;
        }


        public void insert(int data){
            size++;
            int index=size;
            arr[index]=data;
            
            while(index>1){
                int parentIndex=index/2;

                if(arr[parentIndex]<arr[index]){
                   
                    int temp=arr[parentIndex];
                    arr[parentIndex]=arr[index];
                    arr[index]=temp;

                    index=parentIndex;
                }
                else{
                    return;
                }
            }
        }

        public void delete(){
            if(size==0){
                System.out.println("Heap is empty");
                return;
            }
            arr[1]=arr[size];
            arr[size]=0;
            size--;
            int parentIndex=1;
            
            while(parentIndex<=size){
                int leftChildIndex=parentIndex*2;
                int rightChildIndex=parentIndex*2 + 1;

                if(leftChildIndex<=size && arr[parentIndex] < arr[leftChildIndex]){
                    int temp=arr[parentIndex];
                    arr[parentIndex]=arr[leftChildIndex];
                    arr[leftChildIndex]=temp;
                    parentIndex=leftChildIndex;
                }
                if(rightChildIndex<=size && arr[parentIndex] < arr[rightChildIndex] ){
                    int temp=arr[parentIndex];
                    arr[parentIndex]=arr[rightChildIndex];
                    arr[rightChildIndex]=temp;
                    parentIndex=rightChildIndex;
                }
                else{
                    return;
                }

            }
        }

        public void display(){
            System.out.println("Heap is");
            for(int i=1;i<=size;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }

    }

    public static void main(String a[]){
        Scanner sc=new Scanner(System.in);
        boolean flag=true;

        Intro_Heap heap=new Intro_Heap();
        Heap h=heap.new Heap();
        while(flag){
            System.out.println("Enter 1 to insert into heap\nEnter 2 to delete from heap\nEnter 3 to display heap\nEnter 0 to stop");
            int key=sc.nextInt();

            switch(key){
                case 0 -> flag=false;

                case 1 -> {
                    System.out.println("Enter the data to add into heap");
                    int data=sc.nextInt();
                    h.insert(data);
                }

                case 2 -> h.delete();

                case 3 -> h.display();
                
            }
        }

    }
}