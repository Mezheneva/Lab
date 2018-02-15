import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;



class Calculate extends Thread
{

    private static ArrayList<ArrayList<Integer>> matrix;
    private static ArrayList<ArrayList<Integer>> result;
    int r;
    int c;

    Calculate(ArrayList<ArrayList<Integer>> matr, ArrayList<ArrayList<Integer>> res,int r){
        this.matrix = matr;
        this.result = res;
        this.r = r;
    }
    @Override

    Integer calculateElement(int r, int c, ArrayList<ArrayList<Integer>> matr){
        Double sum = 0;

        if(r!=0&&c!=0) {
            sum += matr.get(r - 1).get(c-1);
        }
        if(r!=matr.size()-1&&c!=0) {
            sum += matr.get(r).get(c-1);
        }
        if(r!=matr.size()-1) {
            sum = sum + matr.get(r).get(c);
        }
        if(r!=matr.size()-1&&c!=matr.size()-1) {
            sum += matr.get(r).get(c);
        }
        if(c!=matr.size()-1) {
            sum += matr.get(r).get(c+1);
        }
        if(r!=0&&c!=matr.size()-1) {
            sum += matr.get(r - 1).get(c+1);
        }
        if(r!=0) {
            sum += matr.get(r - 1).get(c);
        }
        if(c!=0) {
            sum += matr.get(r).get(c-1);
        }

        System.out.println(sum);
        return sum;
    }
    public void run()
    {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < matrix.size(); i++) {
            temp.add(calculateElement(r,i,matrix));
        }
        result.set(r,temp);
    }

}


class Perform{

    private ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Calculate> threads;

    public Perform(int a){
        Random r = new Random();

        for(int i=0; i<a; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>(); // added ()
            ArrayList<Integer> temp2 = new ArrayList<Integer>(); // added ()
            for (int j = 0; j < a; j++) {
                temp.add(r);
                temp2.add(0);
            }
            matrix.add(temp);
            result.add(temp2);        
        }
    }


    public Perform(ArrayList<ArrayList<Integer>> matr){
        this.matrix = matr;
        int a = matr.size();
        Random r = new Random();
        r.nextDouble();

        for(int i=0;i<a;i++) {
            ArrayList<Integer> temp2 = new ArrayList<Integer>();
            for (int i = 0; i < a; i++) {
                temp2.add(0);
            }
            result.add(temp2);
        }
    }


    ArrayList<ArrayList<Integer>> getResult(){
        return result;
    }

    public void start(){
        threads = new ArrayList<Calculate>();

        for(int i=0;i<matrix.size();i++){
            threads.add(new Calculate(matrix,result,i));	//Создание потока

            threads.get(i).start();

            try{
                threads.get(i).join();
            }catch(InterruptedException e){
                System.out.println("ERROR");
            }//Запуск потока
        }

    }
}


public class lab_3
{
    public static void main(String[] args){


    }

}
