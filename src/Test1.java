import javax.management.NotificationEmitter;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test1 {


    public static void main(String Args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("src/sample_input.txt"));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());

        ArrayList<Node>arr[];



        for (int repeat = 0; repeat < T; repeat++) {
            int N = Integer.parseInt(bf.readLine());
            arr = new ArrayList[N];


            st = new StringTokenizer(bf.readLine());
            for(int i = 0; i<N; i++){
                int temp =  Integer.parseInt(st.nextToken());
                arr[temp] = new ArrayList<>();
            }
            for(int i = 0; i<N;i++){
                for(int k = 1+i; k<N;k++){
//                    if(isSquareNumber(arr[i]+arr[k])){

//                    }
                }
            }

        }
    }

    public static boolean isSquareNumber(int input){
        boolean isSquareNumber = false;

        long sqrt = (long)Math.sqrt(input);

        if(sqrt*sqrt == input) isSquareNumber = true;

        return isSquareNumber;
    }

    public static class Node{
        int index;
        int value;

        public Node(int index,int value){
            this.index = index;
            this.value = value;
        }
    }


}
