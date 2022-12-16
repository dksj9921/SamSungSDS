import javax.management.NotificationEmitter;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Test1 {


    public static void main(String Args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("src/sample_input.txt"));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());

        ArrayList<Node>arr = new ArrayList<>();



        for (int repeat = 0; repeat < T; repeat++) {
            int N = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            int tempArr[] = new int[N];

            for(int i = 0; i<N; i++){
                int temp =  Integer.parseInt(st.nextToken());
                arr.add(new Node(i,temp));
            }
            for(int i = 0; i<N;i++){
                for(int k = 1+i; k<N;k++){
                    if(isSquareNumber(arr.get(i).value+arr.get(k).value)){
                        arr[i].add(new Node(k,arr[k]));
                        arr[tempArr[k]].add(new Node(i,tempArr[i]));pp99
                    }
                }
            }

            Stack<Integer>stack = new Stack<>();
            for(int i = 0; i<N;i++){
                stack.push(i);
                if(!arr[tempArr[i]].isEmpty()){
                    Node k = arr[tempArr[i]].get(0);
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
        ArrayList<Node>nearNodeArr = new ArrayList<>();

        public Node(int index,int value){
            this.index = index;
            this.value = value;
        }

        public void inputArr(int index, int value){
            this.nearNodeArr.add(new Node(index,value));
        }
    }


}
