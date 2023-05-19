package Exercise1;

/* 
 * Задание 1.
 * 1. Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
    1) Умножьте два числа и верните произведение в виде связанного списка.
    2) Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
 *
*/

public class Program {

    public static void main(String[] args) {
        Node num1 = new Node(3);
        num1.next = new Node(4);
        num1.next.next = new Node(2);

        Node num2 = new Node(1);
        num2.next = new Node(9);
        num2.next.next = new Node(5);

        Node result = multiply(num1, num2);
        printList(result);

        Node num3 = new Node(3);
        num3.next = new Node(9);
        num3.next.next = new Node(9);

        Node num4 = new Node(-1);
        num4.next = new Node(7);
        num4.next.next = new Node(5);

        Node result2 = add(num3, num4);
        printList(result2);
    }
    static Node multiply(Node num1, Node num2) {
        int n1 = 0, n2 = 0;
        while (num1 != null && num2 != null) {
            if (num1 != null) {
                n1 = n1 * 10 + num1.data;
                num1 = num1.next;
            }
            if (num2 != null) {
                n2 = n2 * 10 + num2.data;
                num2 = num2.next;
            }
        }
        int n = n1 * n2;
        Node result = null;
        while (n > 0) {
            int remainder = n % 10;
            n /= 10;
            if (result == null) {
                result = new Node(remainder);
            } else {
                Node node = new Node(remainder);
                node.next = result;
                result = node;
            }
        }
        return result;
    }

    static Node add(Node num1, Node num2) {
        Node head1 = reverse(num1);
        Node head2 = reverse(num2);
        Node result = null;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int sum = carry;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            if (result == null) {
                result = new Node(sum);
            } else {
                Node node = new Node(sum);
                node.next = result;
                result = node;
            }
        }
        if (carry > 0) {
            Node node = new Node(carry);
            node.next = result;
            result = node;
        }
        return result;
    }

    static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
        }
        System.out.println();
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}