import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.BeforeAll;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public class TestAssignment2 {
    @BeforeAll
    public static void prepareFiles() {
        FileDownloader.downloadFile("https://docs.google.com/spreadsheets/d/e/2PACX-1vRmL8b78ABiAtM5sgbHrgMWvLl1LvhX-kwN54mjB2TC-goKYedPlHDm-oF9NQi8IvHM0_Iix7sn7bwy/pub?gid=0&single=true&output=csv", "anagramTests.csv");
        FileDownloader.downloadFile("https://docs.google.com/spreadsheets/d/e/2PACX-1vQ-ZAbOSgyJrnAUaO5F4jNSn1Sor9mUl80iiWeKEh84z8xcFxpDrYMH-ixHGFP7f4ubi8IlPtlF_Qt2/pub?gid=0&single=true&output=csv", "addsUp.csv");
        FileDownloader.downloadFile("https://docs.google.com/spreadsheets/d/e/2PACX-1vTgvdjsh9JMo8ggppprTf0Ry5d2-oIOyadzJbsY9AiOwc97aOnrN3KOcNlOqIbfZMy7iiUmfGhPlhZV/pub?gid=0&single=true&output=csv", "oddTimes.csv");
        FileDownloader.downloadFile("https://docs.google.com/spreadsheets/d/e/2PACX-1vQNMTJzGmz2-y4hOZQ2afCX52bBiSsxlqBGRTi0tHwHgx8Qow8B1HNMaitx5yMSVlgtbRHP20RbHp0N/pub?gid=0&single=true&output=csv", "sumZero.csv");
        FileDownloader.downloadFile("https://docs.google.com/spreadsheets/d/e/2PACX-1vRIYyjk9m3cVXSoTKnHyIRre4jb89kePb1D_2FuMUzzw6xNKKPdaOKbyyNfbivFk84SsE5fx7eof1co/pub?gid=0&single=true&output=csv", "areReverses.csv");
        FileDownloader.downloadFile("https://docs.google.com/spreadsheets/d/e/2PACX-1vQRfYujALgANejhBvX__UBP7gE62wXmxIom8nV1ON4RsSDAGgTIQABt4P3JsZy144XL0vtfu7_3LznE/pub?gid=0&single=true&output=csv", "inOrderOfAppearance.csv");
        FileDownloader.downloadFile("https://docs.google.com/spreadsheets/d/e/2PACX-1vT-JDjpMozTE5oLnAg-WKVMIf68duTQuyYOhSrCufG2k3SIh6RETMXh-Kpgj1-0HW4mTwhnoI6fsz0l/pub?gid=0&single=true&output=csv", "secretCode.csv");
    }

    @ParameterizedTest(name = "[{0}:{1}:{2}]")
    @CsvFileSource(files = "anagramTests.csv", numLinesToSkip = 1)
    public void testAnagrams(String word1, String word2, boolean anagram) {
        assert Assignment2.isAnagram(word1, word2) == anagram;
    }

    @ParameterizedTest(name = "[{0}:{1}:{2}]")
    @CsvFileSource(files = "addsUp.csv", numLinesToSkip = 1)
    public void testAddsUp(String nums, int target, String output) {
        int[] op = ArrayLoader.loadArrayFromString(output);
        int[] ip = ArrayLoader.loadArrayFromString(nums);
        int[] res = Assignment2.addsUp(target, ip);
        String error = "add to: " + target + ", expected: "+ ArrayLoader.a2s(op)+" but got: "+ArrayLoader.a2s(res) + "...";
        Assertions.assertArrayEquals(op, res, error);
    }

    @ParameterizedTest(name = "[{0}:{1}]")
    @CsvFileSource(files = "oddTimes.csv", numLinesToSkip = 1)
    public void testOddTimes(String array, int output) {
        int[] ip = ArrayLoader.loadArrayFromString(array);
        int result = Assignment2.oddTimes(ip);
        Assertions.assertEquals(output, result);
    }

    @ParameterizedTest(name = "[{0}:{1}]")
    @CsvFileSource(files = "sumZero.csv", numLinesToSkip = 1)
    public void testSumOfZero(String array, boolean output) {
        int[] ip = ArrayLoader.loadArrayFromString(array);
        boolean result = Assignment2.sumOfZero(ip);
        Assertions.assertEquals(output, result);
    }

    @ParameterizedTest(name = "[{0}:{1}]")
    @CsvFileSource(files = "areReverses.csv", numLinesToSkip = 1)
    public void testAreReverses(String input, String output) {
        int[][] ip = ArrayLoader.loadNestedArrayFromString(input);
        int[][] op = ArrayLoader.loadNestedArrayFromString(output);
        int[][] result = Assignment2.areReverses(ip);
        //Assertions.assertEquals(result.length, op.length);
        for (int i = 0; i < result.length; i++) {
            String error = "Pair "+ i+", expected " + ArrayLoader.a2s(op[i]) + " but got " + ArrayLoader.a2s(result[i]);
            Assertions.assertArrayEquals(op[i], result[i], error);
        }
    }

    @ParameterizedTest(name = "[{0}:{1}]")
    @CsvFileSource(files = "inOrderOfAppearance.csv", numLinesToSkip = 1)
    public void testInOrderOfAppearance(String input, String output) {
        int[] ip = ArrayLoader.loadArrayFromString(input);
        int[] op = ArrayLoader.loadArrayFromString(output);
        int[] result = Assignment2.inOrderOfAppearance(ip);
        String error = "OrderOfAppearance expected: "+ ArrayLoader.a2s(op)+" but got: "+ArrayLoader.a2s(result) + "...";
        Assertions.assertArrayEquals(op, result, error);
    }

    @ParameterizedTest(name = "[{0}:{1}:{3}]")
    @CsvFileSource(files = "secretCode.csv", numLinesToSkip = 1)
    public void testSecretCode(String string1, String string2, boolean valid) {
        boolean result = Assignment2.secretCode(string1, string2);
        Assertions.assertEquals(valid, result);
    }
}
