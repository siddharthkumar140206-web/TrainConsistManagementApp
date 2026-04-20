package test;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase12TrainConsistMgmtTest {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    private boolean validateSafety(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream()
                .allMatch(bogie ->
                        !bogie.type.equalsIgnoreCase("Cylindrical")
                                || bogie.cargo.equalsIgnoreCase("Petroleum")
                );
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new GoodsBogie("Open", "Coal"));
        list.add(new GoodsBogie("Box", "Grain"));

        assertTrue(validateSafety(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical", "Coal"));

        assertFalse(validateSafety(list));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Open", "Coal"));
        list.add(new GoodsBogie("Box", "Grain"));

        assertTrue(validateSafety(list));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new GoodsBogie("Cylindrical", "Coal"));
        list.add(new GoodsBogie("Open", "Grain"));

        assertFalse(validateSafety(list));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> list = new ArrayList<>();

        assertTrue(validateSafety(list));
    }
}
