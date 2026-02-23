package HW4;

public class Linkedlist {
	static class Node {
        int key;
        Node next;
        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    static Node listInsert(Node head, Node x) {
        x.next = head;
        return x;
    }

    static Node listSearch(Node head, int key) {
        Node cur = head;
        while (cur != null) {
            if (cur.key == key) return cur;
            cur = cur.next;
        }
        return null;
    }

    static Node listDelete(Node head, Node x) {
        if (head == null || x == null) return head;
        if (head == x) {
            return head.next;
        }
        Node prev = head;
        while (prev.next != null && prev.next != x) {
            prev = prev.next;
        }
        if (prev.next == x) {
            prev.next = x.next;
        }
        return head;
    }

    static void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.key);
            if (cur.next != null) System.out.print(" -> ");
            cur = cur.next;
        }
        System.out.println();
    }
    static Node populate(int... values) {
        Node head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            head = listInsert(head, new Node(values[i]));
        }
        return head;
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        Node secondHalf = reverse(slow);
        Node secondHalfCopy = secondHalf;
        Node firstHalf = head;
        boolean ok = true;
        while (secondHalf != null) {
            if (firstHalf.key != secondHalf.key) {
                ok = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        reverse(secondHalfCopy);
        return ok;
    }

    static Node reverse(Node head) {
        Node prev = null, cur = head;
        while (cur != null) {
            Node nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }
    static int trapRainwater(int[] height) {
        if (height == null || height.length < 3) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else water += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right];
                else water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }

public static void main(String[] args) {
    Node head = null; 
    Node n1 = new Node(10);
    Node n2 = new Node(20);
    Node n3 = new Node(30);

    head = listInsert(head, n1);
    head = listInsert(head, n2);
    head = listInsert(head, n3);

    System.out.print("List after inserts: ");
    printList(head);

    int searchKey = 20;
    Node found = listSearch(head, searchKey);
    System.out.println("Search for " + searchKey + ": " + (found != null ? "FOUND" : "NOT FOUND"));

    head = listDelete(head, n2);
    System.out.print("List after deleting node(20): ");
    printList(head);

    System.out.println();

    Node p1 = populate(1, 2, 3, 2, 1);
    System.out.print("1 -> 2 -> 3 -> 2 -> 1 : ");
    System.out.println(isPalindrome(p1) ? "Palindrome" : "Not Palindrome");

    Node p2 = populate(10, 20, 20, 10);
    System.out.print("10 -> 20 -> 20 -> 10 : ");
    System.out.println(isPalindrome(p2) ? "Palindrome" : "Not Palindrome");

    Node p3 = populate(5, 10, 17);
    System.out.print("5 -> 10 -> 17 : ");
    System.out.println(isPalindrome(p3) ? "Palindrome" : "Not Palindrome");

    System.out.println();

    int[] elevation = {1, 2, 1, 4, 1, 2, 1, 5, 0, 0, 2, 1, 5};
    int ans = trapRainwater(elevation);
    System.out.println("Elevation map trapped water = " + ans + " units");
}
}
