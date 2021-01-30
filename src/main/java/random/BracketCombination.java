package random;

public class BracketCombination {
    public static int count = 0;
    public static void main(String[] args) {
        BracketCombination bc = new BracketCombination();
        bc.combination(new char[18], 9, 0, 0, 0);
    }

    public void combination(char[] s, int t, int i, int o, int c) {
        if (i == 2*t) {
            System.out.println(++count + "--" + new String(s));
            return;
        }

        if(o < t) {
            s[i] = '(';
            combination(s, t, i+1, o+1, c);
        }
        if(c < o) {
            s[i] = ')';
            combination(s, t , i+1, o, c+1);
        }

    }
}
