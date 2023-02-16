public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(10);
        list.add("1");
        list.add("12");
        list.add("123");
        list.add("1234");
        list.add("12345");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println("___");

        list.add(2, "555");
        System.out.println(list);
        System.out.println("___");

        list.set(2, "111");
        System.out.println(list);
        System.out.println("___");

        list.remove(2);
        System.out.println(list);
        System.out.println("___");

        list.remove("1");
        System.out.println(list);
        System.out.println("___");

        System.out.println(list.contains("12"));
        System.out.println("___");

        System.out.println(list.indexOf("12"));
        System.out.println("___");

        System.out.println(list.lastIndexOf("123"));
        System.out.println("___");

        System.out.println(list.get(3));
        System.out.println("___");

        MyArrayList list1 = new MyArrayList(4);
        list1.add("12");
        list1.add("123");
        list1.add("1234");
        list1.add("12345");

        System.out.println(list1.equals(list));

        System.out.println(list.isEmpty());
        System.out.println("___");

        list1.clear();
        System.out.println(list1);


    }
}