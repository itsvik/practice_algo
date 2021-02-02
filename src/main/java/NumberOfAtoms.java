import java.util.*;

public class NumberOfAtoms {

    static Map<String, Integer> atoms = new TreeMap<>();

    public static void main(String[] args) {
        countOfAtoms("(" +
                "(N42)24" +
                "(OB40Li30CHe3O48LiNN26)33" +
                "(C12Li48N30H13HBe31)21" +
                "(BHN30Li26BCBe47N40)15" +
                "(H5)16" +
                ")14", 1);
        atoms.entrySet().stream().forEach(e -> System.out.print(e.getKey() + (e.getValue() > 1 ? e.getValue() : "")));
    }

    public static void countOfAtoms(String formula, int multiplier) {
        if (!formula.contains("(")) {
            parse(formula, multiplier);
        } else {
            Stack<Integer> stack = new Stack<>();
            List<Integer> braces = new ArrayList<>();
            for (int i = 0; i < formula.length() - 1; i++) {
                if(formula.charAt(i) == '('){
                    stack.add(i);
                } else {
                    braces.add(stack.pop());
                    braces.add(i);
                }
            }
            int start = formula.indexOf("(");
            int end = formula.lastIndexOf(")");
            if (start != 0)
                parse(formula.substring(0, start), multiplier);
            int mul = 1;
            if (end == formula.length() - 1) {
                mul = 1;
            } else {
                mul = Integer.parseInt(formula.substring(end + 1));
            }
            countOfAtoms(formula.substring(start + 1, end), mul*multiplier);
        }
    }

    public static void parse(String formula, int multiplier) {
        StringBuilder atom = new StringBuilder();
        for (int i = 0; i < formula.length(); i++) {
            if (isCapitalChar(formula.charAt(i)) ) {
                if(atom.length() > 0)
                    putToMap(formula, i-1, atom.toString(), multiplier);
                atom = new StringBuilder().append(formula.charAt(i));
            } else if (isSmallChar(formula.charAt(i))) {
                atom.append(formula.charAt(i));
            }
        }
        putToMap(formula, formula.length()-1, atom.toString(), multiplier);
    }

    private static void putToMap(String formula, int i, String atom, int multiplier) {
        StringBuilder number = new StringBuilder();
        while (!(isSmallChar(formula.charAt(i)) || isCapitalChar(formula.charAt(i)))) {
            number.append(formula.charAt(i));
            i--;
        }
        if (number.length() == 0) {
            number.append(1);
        }
        atoms.put(atom, atoms.getOrDefault(atom, 0) + Integer.parseInt(number.reverse().toString()) * multiplier);
    }

    public static boolean isCapitalChar(char c) {
        return (c > 'A' && c < 'Z');
    }

    public static boolean isSmallChar(char c) {
        return (c > 'a' && c < 'z');
    }

}
