package test;

import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmtTest {

    private final String TRAIN_ID_PATTERN = "TRN-\\d{4}";
    private final String CARGO_CODE_PATTERN = "PET-[A-Z]{2}";

    @Test
    void testRegex_ValidTrainID() {
        String trainId = "TRN-1234";
        Pattern pattern = Pattern.compile(TRAIN_ID_PATTERN);
        Matcher matcher = pattern.matcher(trainId);
        assertTrue(matcher.matches());
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        String[] invalidIds = {"TRAIN12", "TRN12A", "1234-TRN", "TRN-12", "trn-1234"};
        Pattern pattern = Pattern.compile(TRAIN_ID_PATTERN);

        for (String id : invalidIds) {
            Matcher matcher = pattern.matcher(id);
            assertFalse(matcher.matches());
        }
    }

    @Test
    void testRegex_ValidCargoCode() {
        String cargoCode = "PET-AB";
        Pattern pattern = Pattern.compile(CARGO_CODE_PATTERN);
        Matcher matcher = pattern.matcher(cargoCode);
        assertTrue(matcher.matches());
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        String[] invalidCodes = {"PET-ab", "PET123", "AB-PET", "PET-A", "pet-AB"};
        Pattern pattern = Pattern.compile(CARGO_CODE_PATTERN);

        for (String code : invalidCodes) {
            Matcher matcher = pattern.matcher(code);
            assertFalse(matcher.matches());
        }
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        Pattern pattern = Pattern.compile(TRAIN_ID_PATTERN);

        Matcher matcher1 = pattern.matcher("TRN-123");
        assertFalse(matcher1.matches());

        Matcher matcher2 = pattern.matcher("TRN-12345");
        assertFalse(matcher2.matches());

        Matcher matcher3 = pattern.matcher("TRN-1234");
        assertTrue(matcher3.matches());
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        Pattern pattern = Pattern.compile(CARGO_CODE_PATTERN);

        Matcher matcher1 = pattern.matcher("PET-ab");
        assertFalse(matcher1.matches());

        Matcher matcher2 = pattern.matcher("PET-Ab");
        assertFalse(matcher2.matches());

        Matcher matcher3 = pattern.matcher("PET-AB");
        assertTrue(matcher3.matches());
    }

    @Test
    void testRegex_EmptyInputHandling() {
        Pattern trainPattern = Pattern.compile(TRAIN_ID_PATTERN);
        Pattern cargoPattern = Pattern.compile(CARGO_CODE_PATTERN);

        Matcher trainMatcher = trainPattern.matcher("");
        Matcher cargoMatcher = cargoPattern.matcher("");

        assertFalse(trainMatcher.matches());
        assertFalse(cargoMatcher.matches());
    }

    @Test
    void testRegex_ExactPatternMatch() {
        Pattern trainPattern = Pattern.compile(TRAIN_ID_PATTERN);
        Pattern cargoPattern = Pattern.compile(CARGO_CODE_PATTERN);

        Matcher trainMatcher = trainPattern.matcher("TRN-1234-EXTRA");
        assertFalse(trainMatcher.matches());

        Matcher cargoMatcher = cargoPattern.matcher("PET-AB-EXTRA");
        assertFalse(cargoMatcher.matches());
    }
}