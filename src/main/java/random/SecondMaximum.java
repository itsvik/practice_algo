package random;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SecondMaximum {

    static final String TEST_OUT_CORRECT = "For test : %s ,Correct Value : %d";
    static final String TEST_OUT_INCORRECT = "For test : %s ,Incorrect Value : %d";

    public static void main(String[] args) {

        Map<String, BigInteger> testCases = new HashMap<>();
        testCases.put("[\"5\", \"5\", \"4\", \"2\"]", new BigInteger("4"));
        testCases.put("[\"3\", \"-2\"]", new BigInteger("-2"));
        testCases.put("[\"4\", \"4\", \"4\"]", new BigInteger("-1"));
        testCases.put("", new BigInteger("-1"));
        testCases.put("[\"-214748364801\",\"-214748364802\"]", new BigInteger("-214748364802"));

        testCases.forEach((test, value) -> {
            BigInteger secondMax = getSecondMax(test);
            if (value.equals(secondMax))
                System.out.println(String.format(TEST_OUT_CORRECT, test, secondMax));
            else
                System.err.println(String.format(TEST_OUT_INCORRECT, test, secondMax));
        });

    }

    private static BigInteger getSecondMax(String stringArray) {
//        BigInteger MIN_VALUE = new BigInteger("2").pow(1024).negate();
        final Pair pair = new Pair(null, null);
        Arrays.asList(stringArray.replace("[", "").replace("]", "").split(",")).stream()
                .map(s -> s.replaceAll("\"", "").trim())
                .filter(s -> !s.isBlank())
                .map(BigInteger::new)
                .forEach(i -> {
                    if (Optional.ofNullable(pair.max).isEmpty() || pair.max.compareTo(i) < 0) {
                        pair.secondMax = pair.max;
                        pair.max = i;
                    } else if ((Optional.ofNullable(pair.secondMax).isEmpty() || pair.secondMax.compareTo(i) < 0) && pair.max.compareTo(i) > 0) {
                        pair.secondMax = i;
                    }
                });
        return Optional.ofNullable(pair.secondMax).orElse(new BigInteger("-1"));
    }

    public static class Pair {
        BigInteger max;
        BigInteger secondMax;

        public Pair(BigInteger max, BigInteger secondMax) {
            this.max = max;
            this.secondMax = secondMax;
        }
    }

}
