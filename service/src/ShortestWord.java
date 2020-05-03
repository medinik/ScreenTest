import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

class ShortestWord {

    private String shortestWord(String input) {
        if(Objects.isNull(input)|| input.trim().isEmpty()) {
            return "Empty input";
        }
        String maxLength = Arrays.stream(input.split(" "))
                .min(Comparator.comparingInt(String::length)).get();

        return String.format("%s, %d", maxLength, maxLength.length());
    }

    public void tests() {
        String case1 = null;
        String case2 = "    ";
        String case3 = "The cow jumped over the moon";
        String case4 = "The cow on the moo";

        boolean result = assertThat(shortestWord(case1), "Empty input") &&
                assertThat(shortestWord(case2), "Empty input") &&
                assertThat(shortestWord(case3), "The, 3") &&
                assertThat(shortestWord(case4), "on, 2");

        if(result){
            System.out.println("All tests shortest word passed");
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
