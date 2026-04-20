package test;

import main.UseCase8TrainConsistMgmt;
import main.UseCase8TrainConsistMgmt.Bogie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase8TrainConsistMgmtTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("General", 90));

        List<Bogie> result = UseCase8TrainConsistMgmt.filterBogiesByCapacity(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 56));

        List<Bogie> result = UseCase8TrainConsistMgmt.filterBogiesByCapacity(bogies, 70);

        assertEquals(0, result.size());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 56));

        List<Bogie> result = UseCase8TrainConsistMgmt.filterBogiesByCapacity(bogies, 70);

        assertEquals(0, result.size());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("General", 90));
        bogies.add(new Bogie("AC Chair", 80));

        List<Bogie> result = UseCase8TrainConsistMgmt.filterBogiesByCapacity(bogies, 60);

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 56));

        List<Bogie> result = UseCase8TrainConsistMgmt.filterBogiesByCapacity(bogies, 100);

        assertEquals(0, result.size());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("General", 90));

        List<Bogie> result = UseCase8TrainConsistMgmt.filterBogiesByCapacity(bogies, 50);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = UseCase8TrainConsistMgmt.filterBogiesByCapacity(bogies, 60);

        assertEquals(0, result.size());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        int originalSize = bogies.size();
        UseCase8TrainConsistMgmt.filterBogiesByCapacity(bogies, 60);

        assertEquals(originalSize, bogies.size());
    }
}