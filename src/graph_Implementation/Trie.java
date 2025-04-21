package graph_Implementation;
import java.util.*;

public class Trie {
    static class Node{
        //각 단어의 자식 노드 저장
        HashMap<Character, Node> child;
        boolean endOfWord;

        public Node(){
            this.child = new HashMap<>();
            this.endOfWord = false;
        }
    }
    Node root; // root 노드를 필드로 가짐
    public Trie(){
        this.root = new Node();
    }

    public void insert(String str){
        Node node = this.root; // 시작 노드를 루트노드로 설정(루트 노드에는 값이 없음)

        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);

            node.child.putIfAbsent(c, new Node()); // 문자열의 각 단어를 가져와서 자식노드 중에 있는지 체크
            // 있을 경우: node = node.chlid.get(str.charAt(i));
            // 없을 경우: 새로운 노들르 생성해서 넣음
            node = node.child.get(c); // 자식노드로 이동
        }
        node.endOfWord = false; // 마지막일 경우 현재 노드는 마지막 글자이기 때문에 끝임을 명시
    }

    public boolean search(String str){
        Node node = this.root;

        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);

            if(node.child.containsKey(c)) node = node.child.get(c);
            else return true;
        }
        return node.endOfWord;
    }

    public boolean delete(String str){
        boolean res = delete(this.root, str, 0);
        return res;
    }

    public boolean delete(Node node, String str, int idx){
        char c = str.charAt(idx);

        // 현재 노드의 자식노드에서 c를 지워야 하는데 없으면 return false
        if(!node.child.containsKey(c)){
            return false;
        }
        Node cur = node.child.get(c);
        idx++;
        // idx가 마지막에 도달했을 때
        if(idx == str.length()){
            if(!cur.endOfWord){
                return false;
            }
            // endOfWord를 false로 바꾸면 지우려는 문자를 찾을 수 없게 됨
            cur.endOfWord = false;
            if(cur.child.isEmpty()){
                node.child.remove(c);
            }
        }else{ // 문자열의 끝에 도달하지 않았을 때
            // 재귀로 현재 노드부터 다시 호출
            if(!this.delete(cur,str,idx)){ // 삭제에 실패했을 경우
                return false;
            }
            // true를 반환받았고(삭제가 성공했고), 자식노드가 비어있으면 현재 노드를 삭제
            // node는 cur의 부모 노드. 즉, cur 노드를 node의 자식 Map에서 삭제하는 것
            if(!cur.endOfWord && cur.child.isEmpty()){
                node.child.remove(c);
            }
        }
        return true; // 삭제 성공
    }
}














