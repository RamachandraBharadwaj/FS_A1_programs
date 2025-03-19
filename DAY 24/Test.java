class Test {

    int x=10;

    Test()  {  	System.out.print(x+ " ");   }

     private  Test(int x)  { 

        this.x=x;                                       //Line-5 

        System.out.print(x+ " ");   

        }

   public static void main(String[] args) 	{

       Test t=new Test(10);                    //line-9

       t.x=20;                                        //line-10

       System.out.println(this.x);              //line-11

   }

}