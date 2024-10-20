import java.util.Scanner;

 class bancoApp{
    public static void  main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        try {
            //  Información de la primera cuenta
            System.out.print("Ingresa el nombre del titular de la primera cuenta: ");
            String titular1 = scanner.nextLine();
            System.out.print("Ingresa tu saldo inicial: ");
            double saldoInicial1 = scanner.nextDouble();
            scanner.nextLine();
            Cuenta cuenta1 = new Cuenta(titular1, saldoInicial1);

            //Información de la segunda cuenta
            System.out.println("Ingresa el nombre del titular de la segunda cuenta:");
            String titular2 = scanner.nextLine();
            System.out.println("Ingresa tu saldo inicial:");
            double saldoInicial2 = scanner.nextDouble();
            Cuenta cuenta2 = new Cuenta(titular2, saldoInicial2);

            //Menú
            int opcion;
            do {
                System.out.println("\nSelecciona lo que quieres realizar:");
                System.out.println("1. Depositar en la primera cuenta:");
                System.out.println("2. Retirar de la primera cuenta:");
                System.out.println("3. Depositar en la segunda cuenta:");
                System.out.println("4. Retirar de la segunda cuenta:");
                System.out.println("5. Transferir de la primera cuenta a la segunda:");
                System.out.println("6. Salir:");
                System.out.println("Opción: ");
                opcion = scanner.nextInt();

                switch (opcion){
                    case 1: //Depositar en la primera cuenta
                        System.out.println("Ingrese el monto que vas a depositar: ");
                        double montoDepositar = scanner.nextDouble();
                        cuenta1.depositar(montoDepositar);
                        break;

                    case 2: //Retirar de la primera cuenta
                        System.out.print("Ingresa el monto a retirar: ");
                        double montoRetirar = scanner.nextDouble();
                        cuenta1.retirar(montoRetirar);
                        break;

                    case 3 : //    Depositar en la segunda cuenta
                        System.out.println("Ingrese el monto que vas a depositar: ");
                        double montoDepositar2 = scanner.nextDouble();
                        cuenta2.depositar(montoDepositar2);
                        break;

                    case 4 : //Retirar de la segunda cuenta
                        System.out.print("Ingresa el monto a retirar: ");
                        double montoRetirar2 = scanner.nextDouble();
                        cuenta2.retirar(montoRetirar2);
                        break;

                    case 5:
                        // Transferir de la primera cuenta a la segunda
                        System.out.print("Ingresa el monto a transferir: ");
                        double montoTransferir = scanner.nextDouble();
                        cuenta1.transferir(cuenta2, montoTransferir);
                        break;

                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } while (opcion != 6);

        } catch (SaldoInsuficienteE | MontoInvalidoE e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
 }
