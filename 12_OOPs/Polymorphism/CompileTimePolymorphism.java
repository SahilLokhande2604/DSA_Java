
class Shape{
    String name;

    public void area(){
        System.out.println("The area of shape is unknown");
    }

    public void area(double side){
        System.out.println("The area of square is "+(side*side));
    }

    public void area(int h,int b){
        System.out.println("The area of triangle is "+((0.5)*b*h));
    }

    public int area(int r){
        System.out.print("The area of circle is ");
        return (int) ((3.14)*r*r);
    }
}




public class CompileTimePolymorphism{
    public static void main(String args[]){
        Shape triangle=new Shape();
        triangle.area(10,11);

        // Shape square =new Shape();
        // square.area(10);  //if I use this then it will not display the square area 
        // but circle as i dont specify the datatype in the object so it assumes it as int 

        Shape square =new Shape();
        square.area((double)10);

        Shape circle=new Shape();
        int area=circle.area(7);

        System.out.println(area);

        Shape random=new Shape();
        random.area();

    }
}