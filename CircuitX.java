import java.util.Scanner;

class CircuitX {
    static Scanner sc = new Scanner(System.in);

    // Ohm's Law
    static void ohmsLaw() {
        System.out.println("\n====== OHM'S LAW ==========");
        System.out.println("1: Find Voltage");
        System.out.println("2: Find Current");
        System.out.println("3: Find Resistance");
        System.out.print("Enter Choice: ");
        int ch = sc.nextInt();

        if (ch == 1) {
            System.out.print("Enter Current: ");
            double i = sc.nextDouble();
            System.out.print("Enter Resistance: ");
            double r = sc.nextDouble();
            double v = i * r;

            System.out.println("Formula: V = I x R");
            System.out.println("V = " + i + " x " + r);
            System.out.println("V = " + v);
        } else if (ch == 2) {
            System.out.print("Enter Voltage: ");
            double v = sc.nextDouble();
            System.out.print("Enter Resistance: ");
            double r = sc.nextDouble();
            double i = v / r;

            System.out.println("Formula: I = V / R");
            System.out.println("I = " + v + " / " + r);
            System.out.println("I = " + i);
        } else if (ch == 3) {
            System.out.print("Enter Voltage: ");
            double v = sc.nextDouble();
            System.out.print("Enter Current: ");
            double i = sc.nextDouble();
            double r = v / i;

            System.out.println("Formula: R = V / I");
            System.out.println("R = " + v + " / " + i);
            System.out.println("R = " + r);
        } else {
            System.out.println("Invalid Choice!");
        }
    }

    // Power Calculator
    static void powerCalculator() {
        System.out.println("\n====== POWER CALCULATOR ==========");
        System.out.println("1: P = V x I");
        System.out.println("2: P = I^2 x R");
        System.out.println("3: P = V^2 / R");
        System.out.print("Enter Choice: ");
        int ch = sc.nextInt();
        double p;

        if (ch == 1) {
            System.out.print("Enter Voltage: ");
            double v = sc.nextDouble();
            System.out.print("Enter Current: ");
            double i = sc.nextDouble();
            p = v * i;

            System.out.println("Formula: P = V x I");
            System.out.println("P = " + v + " x " + i);
            System.out.println("P = " + p);
        } else if (ch == 2) {
            System.out.print("Enter Current: ");
            double i = sc.nextDouble();
            System.out.print("Enter Resistance: ");
            double r = sc.nextDouble();
            p = i * i * r;

            System.out.println("Formula: P = I^2 x R");
            System.out.println("P = " + (i * i) + " x " + r);
            System.out.println("P = " + p);
        } else if (ch == 3) {
            System.out.print("Enter Voltage: ");
            double v = sc.nextDouble();
            System.out.print("Enter Resistance: ");
            double r = sc.nextDouble();
            p = (v * v) / r;

            System.out.println("Formula: P = V^2 / R");
            System.out.println("P = " + (v * v) + " / " + r);
            System.out.println("P = " + p);
        } else {
            System.out.println("Invalid Choice!");
        }
    }

    // Resistance in Series
    static void seriesResistance() {
        System.out.println("\n--- SERIES RESISTANCE ---");
        System.out.print("How many Resistors: ");
        int n = sc.nextInt();
        double total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter R" + i + ": ");
            double r = sc.nextDouble();
            total += r;
        }

        System.out.println("\nFormula:");
        System.out.println("Req = R1 + R2 + R3 + ... + Rn");
        System.out.printf("Req = %.2f Ohms%n", total);
    }

    // Resistance in Parallel
    static void parallelResistance() {
        System.out.println("\n--- PARALLEL RESISTANCE ---");
        System.out.print("How many Resistors: ");
        int n = sc.nextInt();
        double reciprocal = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter R" + i + ": ");
            double r = sc.nextDouble();

            if (r == 0) {
                System.out.println("Resistance can't be zero.");
                return;
            }

            reciprocal += 1 / r;
        }

        double req = 1 / reciprocal;

        System.out.println("\nFormula:");
        System.out.println("1/Req = 1/R1 + 1/R2 + ... + 1/Rn");
        System.out.printf("Req = %.2f Ohms%n", req);
    }

    // Voltage Divider Rule (VDR)
    static void vdr() {
        System.out.println("\n--- VOLTAGE DIVIDER RULE ---");
        System.out.print("Enter Source Voltage: ");
        double vs = sc.nextDouble();
        System.out.print("Enter R1: ");
        double r1 = sc.nextDouble();
        System.out.print("Enter R2: ");
        double r2 = sc.nextDouble();

        double req = r1 + r2;
        double v1 = vs * r1 / req;
        double v2 = vs * r2 / req;

        System.out.println("\nStep 1: Total Resistance");
        System.out.println("Req = R1 + R2");
        System.out.println("Req = " + r1 + " + " + r2);
        System.out.println("Req = " + req);

        System.out.println("\nStep 2: Voltage across R1");
        System.out.println("V1 = Vs x R1 / Req");
        System.out.printf("V1 = %.2f V%n", v1);

        System.out.println("\nStep 3: Voltage across R2");
        System.out.println("V2 = Vs x R2 / Req");
        System.out.printf("V2 = %.2f V%n", v2);
    }

    // Current Divider Rule (CDR)
    static void cdr() {
        System.out.println("\n--- CURRENT DIVIDER RULE ---");
        System.out.print("Enter number of Resistors: ");
        int n = sc.nextInt();
        System.out.print("Enter total current: ");
        double it = sc.nextDouble();

        if (n < 3) {
            System.out.print("Enter R1: ");
            double r1 = sc.nextDouble();
            System.out.print("Enter R2: ");
            double r2 = sc.nextDouble();

            double rt = r1 + r2;
            double i1 = (it * r2) / rt;
            double i2 = (it * r1) / rt;

            System.out.println("\nCurrent through R1:");
            System.out.println("I1 = (It x R2) / (R1 + R2)");
            System.out.printf("I1 = %.2f A%n", i1);

            System.out.println("\nCurrent through R2:");
            System.out.println("I2 = (It x R1) / (R1 + R2)");
            System.out.printf("I2 = %.2f A%n", i2);
        } else {
            double[] arr = new double[n];
            double reciprocal = 0;

            for (int i = 0; i < n; i++) {
                System.out.print("Enter R" + (i + 1) + ": ");
                double r = sc.nextDouble();

                if (r == 0) {
                    System.out.println("Resistance can't be zero.");
                    return;
                }

                reciprocal += 1 / r;
                arr[i] = r;
            }

            double req = 1 / reciprocal;

            System.out.println("\nGeneral Formula:");
            System.out.println("Ix = (It x Req) / Rx");

            for (int i = 0; i < n; i++) {
                System.out.printf("I%d = %.2f A%n", i + 1, (it * req) / arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========================================");
            System.out.println("|       CIRCUITX SMART SOLVER          |");
            System.out.println("========================================");
            System.out.println("1: Ohm's Law");
            System.out.println("2: Power Calculator");
            System.out.println("3: Series Resistance");
            System.out.println("4: Parallel Resistance");
            System.out.println("5: Voltage Divider Rule (VDR)");
            System.out.println("6: Current Divider Rule (CDR)");
            System.out.println("7: Exit");
            System.out.print("\nEnter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ohmsLaw();
                    break;
                case 2:
                    powerCalculator();
                    break;
                case 3:
                    seriesResistance();
                    break;
                case 4:
                    parallelResistance();
                    break;
                case 5:
                    vdr();
                    break;
                case 6:
                    cdr();
                    break;
                case 7:
                    System.out.println("Thank you for using CircuitX!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }
}
