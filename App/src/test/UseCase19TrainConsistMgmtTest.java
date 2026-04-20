package test;
import main.UseCase19TrainConsistMgmt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase19TrainConsistMgmtTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase19TrainConsistMgmt.binarySearchBogieId(bogieIds, "BG309");
        assertTrue(result, "BG309 should be found in the array.");
    }


    @Test
    void testBinarySearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase19TrainConsistMgmt.binarySearchBogieId(bogieIds, "BG999");
        assertFalse(result, "BG999 should NOT be found in the array.");
    }


    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase19TrainConsistMgmt.binarySearchBogieId(bogieIds, "BG101");
        assertTrue(result, "BG101 (first element) should be found.");
    }


    @Test
    void testBinarySearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = UseCase19TrainConsistMgmt.binarySearchBogieId(bogieIds, "BG550");
        assertTrue(result, "BG550 (last element) should be found.");
    }


    @Test
    void testBinarySearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        boolean result = UseCase19TrainConsistMgmt.binarySearchBogieId(bogieIds, "BG101");
        assertTrue(result, "BG101 in single-element array should be found.");
    }


    @Test
    void testBinarySearch_EmptyArray() {
        String[] bogieIds = {};
        boolean result = UseCase19TrainConsistMgmt.binarySearchBogieId(bogieIds, "BG101");
        assertFalse(result, "Empty array should return false (not found).");
    }


    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        boolean result = UseCase19TrainConsistMgmt.binarySearchBogieId(bogieIds, "BG205");
        assertTrue(result, "BG205 should be found even if input was unsorted.");
    }
}