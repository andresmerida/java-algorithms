package dev.amerida.algoritms.common.gast_station;

import java.util.List;

public class GasStationProblem {

    public int machine(List<Integer> ar) {
        // Edge case check: List should not be empty and must have even number of elements (pairs)
        if (ar == null || ar.isEmpty() || ar.size() % 2 != 0) {
            return -1;
        }

        int totalSurplus = 0;   // Net juice across the entire circle
        int currentTank = 0;    // Juice in the car's tank for the current journey
        int startingStation = 0;

        int numStation = ar.size() / 2;
        for (int i = 0; i < numStation; i++) {
            // Extract the juice and distance for the current station 'i'
            int juice = ar.get(2 * i);
            int distance = ar.get(2 * i + 1);

            // Calculate the net juice gained/lost at the current station
            int netJuice = juice - distance;

            totalSurplus += netJuice;
            currentTank += netJuice;

            // if Car runs out of the juice, we can't start at 'startingStation'
            if (currentTank < 0) {
                startingStation = i + 1;    // the next station is our newly proposed starting point
                currentTank = 0;            // Reset the tank for the new journey
            }
        }

        // if the total surplus is negative, completing the circle is impossible
        return totalSurplus >= 0 ? startingStation : -1;
    }
}
