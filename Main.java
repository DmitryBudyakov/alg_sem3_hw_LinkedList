public class Main {
    public static void main(String[] args) {

        ListTwoWay<Integer> intListTwoWay = new ListTwoWay<>();
        System.out.println("--- Creating List ---");
        intListTwoWay.add(55);
        intListTwoWay.add(26);
        intListTwoWay.add(13);
        intListTwoWay.add(98);
        intListTwoWay.add(50, 0);
        intListTwoWay.addLast(111);
        System.out.println("Initial: " + intListTwoWay.toString());
        System.out.println("Initial size: " + intListTwoWay.getSize());
        System.out.println("Head: " + intListTwoWay.getHead().value);
        System.out.println("Tail: " + intListTwoWay.getTail().value);
        System.out.println("");

        System.out.println();
        System.out.println("--- List reverting ---");
        intListTwoWay.revert();
        System.out.println("List after revert: " + intListTwoWay.toString());
        System.out.println("After revert size: " + intListTwoWay.getSize());
        System.out.println("Head: " + intListTwoWay.getHead().value);
        System.out.println("Tail: " + intListTwoWay.getTail().value);
        System.out.println();
    }

}
