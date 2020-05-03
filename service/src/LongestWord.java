import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

class LongestWord {

    private String longestWord(String input) {
        if(Objects.isNull(input)|| input.trim().isEmpty()) {
            return "Empty input";
        }
        String maxLength = Arrays.stream(input.split(" "))
                .max(Comparator.comparingInt(String::length)).get();

        return String.format("%s, %d", maxLength, maxLength.length());
    }

    public void tests() {
        String case1 = null;
        String case2 = "    ";
        String case3 = "The cow jumped over the moon";
        String case4 = "The cow on the moo";

        boolean result = assertThat(longestWord(case1), "Empty input") &&
                assertThat(longestWord(case2), "Empty input") &&
                assertThat(longestWord(case3), "jumped, 6") &&
                assertThat(longestWord(case4), "The, 3");

        if(result){
            System.out.println("All tests for longest word passed");
        }
    }

    private boolean assertThat(String actual, String expected){
        if(!actual.equals(expected)){
            System.out.println(String.format("Test Failed! Expected %s but instead received %s",
                    actual, expected));
            return false;
        }
        return true;
    }
}
