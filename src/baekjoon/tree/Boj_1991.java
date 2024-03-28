package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1991 {
    static Node[] tree;
    static class Node {
        char val;
        Node left;
        Node right;

        public Node(char c) {
            this.val = c;
            this.left = null;
            this.right = null;
        }

        public static void inorder(Node node) {
            if (node == null) return;
            inorder(node.left);
            System.out.print(node.val);
            inorder(node.right);
        }

        public static void preorder(Node node) {
            if (node == null) return;
            System.out.print(node.val);
            preorder(node.left);
            preorder(node.right);
        }

        public static void postorder(Node node) {
            if (node == null) return;
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.val);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n+1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parentVal = st.nextToken().charAt(0);
            char leftVal = st.nextToken().charAt(0);
            char rightVal = st.nextToken().charAt(0);
            //부모노드가 생성되지 않은 경우
            if(tree[parentVal - 'A'] == null) tree[parentVal-'A'] = new Node(parentVal);
            if(leftVal != '.'){
                tree[leftVal - 'A']= new Node(leftVal);
                tree[parentVal - 'A'] = tree[leftVal - 'A'];
            }
            if(rightVal != '.'){
                tree[rightVal - 'A'] = new Node(rightVal);
                tree[parentVal - 'A'] = tree[rightVal - 'A'];
            }
        }
        Node.preorder(tree[0]);
        System.out.println();
        Node.inorder(tree[0]);
        System.out.println();
        Node.postorder(tree[0]);
        br.close();
    }
}