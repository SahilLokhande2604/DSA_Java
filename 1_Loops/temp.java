public class temp {
    public static void sum(int n){
        int k=n;
        int add=0;
        int pro=1;
        while(k!=0){
            int temp=k%10;
            add=add+temp;
            pro=pro*temp;
            k=k/10;
        }
        System.out.println("The sum of digits of "+n+" is "+add);
        System.out.println("The product of digits of "+n+" is "+pro);
        System.out.println("The difference of product and sum (i.e. "+pro+" - "+add+" ) of "+n+" is "+(pro-add));
        System.out.println("\n----------------------------------------------------------------------------------------\n");
    }
    public static void main(String args[]){
        sum(10);
        sum(6789);
        sum(12345);
    }
}
