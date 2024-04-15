import java.util.ArrayList;
import java.util.List;

// Class representing a transportation option
class TransportationOption {
    private String name;
    private double carbonFootprint; // in kgCO2e per km

    public TransportationOption(String name, double carbonFootprint) {
        this.name = name;
        this.carbonFootprint = carbonFootprint;
    }

    public String getName() {
        return name;
    }

    public double getCarbonFootprint() {
        return carbonFootprint;
    }
}

// Class representing a route with multiple transportation options
class Route {
    private List<TransportationOption> options;

    public Route() {
        this.options = new ArrayList<>();
    }

    public void addOption(TransportationOption option) {
        options.add(option);
    }

    public double calculateTotalCarbonFootprint(double distance) {
        double totalCarbonFootprint = 0;
        for (TransportationOption option : options) {
            totalCarbonFootprint += option.getCarbonFootprint() * distance;
        }
        return totalCarbonFootprint;
    }
}

public class EcoFriendlyTransportationPlanner {
    public static void main(String[] args) {
        // Create transportation options
        TransportationOption walking = new TransportationOption("Walking", 0.0);
        TransportationOption cycling = new TransportationOption("Cycling", 0.0);
        TransportationOption electricCar = new TransportationOption("Electric Car", 0.04); // kgCO2e per km
        TransportationOption publicTransport = new TransportationOption("Public Transport", 0.05);
        TransportationOption carpooling = new TransportationOption("Carpooling", 0.06);

        // Create a route with multiple transportation options
        Route route = new Route();
        route.addOption(walking);
        route.addOption(cycling);
        route.addOption(electricCar);
        route.addOption(publicTransport);
        route.addOption(carpooling);

        // Calculate the total carbon footprint for a distance of 10 km
        double distance = 10.0; // km
        double totalCarbonFootprint = route.calculateTotalCarbonFootprint(distance);
        System.out.println("Total carbon footprint for the route: " + totalCarbonFootprint + " kgCO2e");
    }
}
