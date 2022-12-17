import javax.management.NotificationEmitter;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Test1 {
    static ArrayList<Node> arr;
    static int N;
    static int Max;


    public static void main(String Args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("src/sample_input.txt"));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());


        for (int repeat = 0; repeat < T; repeat++) {
            N = Integer.parseInt(bf.readLine());
            arr = new ArrayList<>();
            st = new StringTokenizer(bf.readLine());



            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(st.nextToken());
                arr.add(new Node(i, temp));
            }
            for (int i = 0; i < N; i++) {
                for (int k = 1 + i; k < N; k++) {
                    if (isSquareNumber(arr.get(i).value + arr.get(k).value)) {
                        Node tempNodeI = arr.get(i);
                        Node tempNodeK = arr.get(k);
                        tempNodeI.inputArr(k, tempNodeK.value);
                        tempNodeK.inputArr(i, tempNodeI.value);
                    }
                }
            }
            Max = 0;
            for (int i = 0; i < N; i++) {
                boolean visited[] = new boolean[N];
                int count = 0;
                BruteForce(i, i, visited, count);
            }

            System.out.println(repeat+1+" "+Max);
        }
    }

    public static boolean isSquareNumber(int input) {
        boolean isSquareNumber = false;

        long sqrt = (long) Math.sqrt(input);

        if (sqrt * sqrt == input) isSquareNumber = true;

        return isSquareNumber;
    }

    public static class Node {
        int index;
        int value;
        ArrayList<Node> nearNodeArr = new ArrayList<>();

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public void inputArr(int index, int value) {
            this.nearNodeArr.add(new Node(index, value));
        }
    }

    public static void BruteForce(int firstIndex, int index, boolean[] visited, int count) {
        Node node = arr.get(index);
        visited[node.index] = true;
        boolean check = false;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) check = true;
        }
        if (!check) {
            Node tempNode = arr.get(firstIndex);
            for(Node i : tempNode.nearNodeArr){
                if(i.index == node.index){
                    count++;
                }
            }
            if(count>Max) Max = count;
            return;
        }

        if (!node.nearNodeArr.isEmpty()) {
            for (Node i : node.nearNodeArr) {
                if (!visited[i.index]) {
                    check = false;
                    count++;
                    BruteForce(firstIndex, i.index, visited, count);
                }
            }
        }
        if (check) {
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    BruteForce(firstIndex, i, visited, count);
                }
            }
        }
    }

}
