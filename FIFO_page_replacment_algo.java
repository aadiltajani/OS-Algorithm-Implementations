//  FIFO(first in first out) Page Replacement Algorithm Implementation
import java.util.Scanner;
class FIFO_page_replacment_algo{
    static int pf;
    static int point=0;
    public static void main(String [] args){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter no. of page frames and no. of pages : ");
        pf=in.nextInt();
        int p=in.nextInt();
        int a[]=new int [p];
        System.out.print("\nEnter pages: ");
        for(int i=0;i<p;i++){
            a[i]=in.nextInt();
        }
        //Aadil 180420107558
        int page[]=new int [pf];
        int miss=0;
        FIFO_page_replacment_algo ob=new FIFO_page_replacment_algo();
        for(int i=0;i<p;i++){
            miss+=ob.replace(a[i],page);
            System.out.println();
            for(int j=0;j<pf;j++){
                System.out.print(page[j]+"|");
                if(j==miss-1)
                    break;
            }
        }
        System.out.println("\n\nTotal page faults: "+miss+"   FIFO Page Replacement Algorithm -Aadil Tajani");
    }
    public int replace(int d,int a[]){
        for(int i=0;i<pf;i++){
            if(a[i]==d){
                System.out.print("\t"+d+"->hit");
                return 0;
            }
        }
        System.out.print("\t"+d+"->miss, "+d+" entered");
        a[point]=d;
        point++;
        point%=pf;
        return 1;
    }
}