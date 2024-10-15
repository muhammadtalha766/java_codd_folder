import java.util.Scanner;

public class BuildingCostCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double area, constableArea, roomCost = 0, kitchenCost = 0, bathroomCost = 0, garageCost = 0, doorCost = 0, windowCost = 0, tvLoungeCost = 0, totalCost;
        int numFloors, numRooms, numKitchens, numBathrooms, numGarages, numWindows, numDoors, numTVLounges;

        // Get the area of the building from the user in Square feet
        System.out.print("Enter the area of the building: ");
        area = scanner.nextDouble();

        // Get the number of floors from the user
        System.out.print("Enter the number of floors: ");
        numFloors = scanner.nextInt();

        // Calculate the constable area
        constableArea = area * 0.8; // Assume 80% of the area is constable area

        // Get the number of rooms, kitchens, bathrooms, garages, and windows from the user for each floor
        for (int i = 1; i <= numFloors; i++) {
            System.out.print("Enter the number of rooms on the " + i + "th floor: ");
            numRooms = scanner.nextInt();
            for (int j = 1; j <= numRooms; j++) {
                double length, width;
                System.out.print("Enter the dimensions Square or Rectangle (length and width) of room " + j + " on floor " + i + ": ");
                length = scanner.nextDouble();
                width = scanner.nextDouble();
                double roomArea = length * width;
                roomCost += roomArea * 25000.0; // assume PKR 25000 per square meter
                System.out.print("Enter the number of windows in room " + j + " on floor " + i + ": ");
                numWindows = scanner.nextInt();
                windowCost += numWindows * 2000.0; // assume PKR 2000 per window
                System.out.print("Enter the number of doors in room " + j + " on floor " + i + ": ");
                numDoors = scanner.nextInt();
                doorCost += numDoors * 5000.0; // assume PKR 5000 per door
            }

            System.out.print("Enter the number of kitchens on the " + i + "th floor: ");
            numKitchens = scanner.nextInt();
            for (int j = 1; j <= numKitchens; j++) {
                kitchenCost += 25000.0; // assume PKR 25000 per kitchen
                System.out.print("Enter the number of windows in kitchen " + j + " on floor " + i + ": ");
                numWindows = scanner.nextInt();
                windowCost += numWindows * 2000.0; // assume PKR 2000 per window
                System.out.print("Enter the number of doors in kitchen " + j + " on floor " + i + ": ");
                numDoors = scanner.nextInt();
                doorCost += numDoors * 5000; // assume PKR 5000 per door
            }

            System.out.print("Enter the number of bathrooms on the " + i + "th floor: ");
            numBathrooms = scanner.nextInt();
            for (int j = 1; j <= numBathrooms; j++) {
                bathroomCost += 30000.0; // assume PKR 30000 per bathroom
                System.out.print("Enter the number of doors in bathroom " + j + " on floor " + i + ": ");
                numDoors = scanner.nextInt();
                doorCost += numDoors * 5000.0; // assume PKR 5000 per door
            }

            if (numFloors != 2) {
                System.out.print("Enter the number of garages on the " + i + "th floor: ");
                numGarages = scanner.nextInt();
                for (int j = 1; j <= numGarages; j++) {
                    garageCost += 50000.0; // assume PKR 50000 per garage
                    System.out.print("Enter the number of doors in garage " + j + " on floor " + i + ": ");
                    numDoors = scanner.nextInt();
                    doorCost += numDoors * 5000.0; // assume PKR 5000 per door
                }
            }

            System.out.print("Enter the number of TV lounges on the " + i + "th floor: ");
            numTVLounges = scanner.nextInt();
            for (int j = 1; j <= numTVLounges; j++) {
                double length, width;
                System.out.print("Enter the dimensions (length and width) of TV lounge " + j + " on floor " + i + ": ");
                length = scanner.nextDouble();
                width = scanner.nextDouble();
                double tvLoungeArea = length * width;
                tvLoungeCost += tvLoungeArea * 20000.0; // assume PKR 20000 per square meter for TV lounge
            }
        }

        // Calculate the total cost
        totalCost = constableArea + roomCost + kitchenCost + bathroomCost + garageCost + doorCost + windowCost + tvLoungeCost;

        // Display the results
        System.out.println("Constable area: " + constableArea + " square meters");
        System.out.println("Room cost: PKR " + roomCost);
        System.out.println("Kitchen cost: PKR " + kitchenCost);
        System.out.println("Bathroom cost: PKR " + bathroomCost);
        System.out.println("Garage cost: PKR " + garageCost);
        System.out.println("Door cost: PKR " + doorCost);
        System.out.println("Window cost: PKR " + windowCost);
        System.out.println("TV lounge cost: PKR " + tvLoungeCost);
        System.out.println("Total cost: PKR " + totalCost);

        scanner.close();
    }
}
