import Planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.ExperimentalType;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> PLANES  = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static final PassengerPlane PLANE_WITH_MAX_PASSENGER_CAPACITY
            = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(PLANES);
        boolean isTransport = true;
        for (MilitaryPlane militaryPlane : airport.getTransportMilitaryPlanes()) {
            if ((militaryPlane.getMilitaryType() != MilitaryType.TRANSPORT)) {
                isTransport = false;
                break;
            }
        }
        Assert.assertTrue(isTransport);
    }

    @Test
    public void testGetPassengerPlaneWithMaxPassengerCapacity() {
        Airport airport = new Airport(PLANES);
        Assert.assertEquals(PLANE_WITH_MAX_PASSENGER_CAPACITY, airport.getPassengerPlaneWithMaxPassengerCapacity());
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        Airport airport = new Airport(PLANES);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();

        boolean isPreviousPlaneMaxLoadCapacityLessThanCurrent = true;
        for (int i = 1; i < planesSortedByMaxLoadCapacity.size(); i++) {
            Plane previousPlane = planesSortedByMaxLoadCapacity.get(i - 1);
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            if (previousPlane.getMaxLoadCapacity()
                    > currentPlane.getMaxLoadCapacity()) {
                isPreviousPlaneMaxLoadCapacityLessThanCurrent = false;
                break;
            }
        }
        Assert.assertTrue(isPreviousPlaneMaxLoadCapacityLessThanCurrent);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(PLANES);
        boolean hasBomberPlane = false;
        for (MilitaryPlane militaryPlane : airport.getBomberMilitaryPlanes()) {
            if ((militaryPlane.getMilitaryType() == MilitaryType.BOMBER)) {
                hasBomberPlane = true;
                break;
            }
        }
        Assert.assertTrue(hasBomberPlane);
    }

    @Test
    public void testHasNoUnclassifiedPlaneInExperimentalPlanes() {
        Airport airport = new Airport(PLANES);
        boolean hasUnclassifiedPlane = false;
        for (ExperimentalPlane experimentalPlane : airport.getExperimentalPlanes()) {
            if (experimentalPlane.getClassificationLevel()
                    == ClassificationLevel.UNCLASSIFIED) {
                hasUnclassifiedPlane = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedPlane);
    }
}
