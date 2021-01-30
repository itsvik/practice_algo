public class ShopSeTest {

    // Input : My name is Anurag
    // Output: Anurag is name My

    public static void main(String[] args) {
        String input = "My name is Anurag";
        String[] split= input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

