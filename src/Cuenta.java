public class Cuenta {
    private String titular;
    private double saldo;

    //Constructor
    public Cuenta(String titular, double SaldoInicial){
        this.titular = titular;
        this.saldo = SaldoInicial;
    }


    //Gets
    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void retirar(double monto) throws SaldoInsuficienteE, MontoInvalidoE {
        if (monto <= 0) {
           throw new MontoInvalidoE("El monto debe ser positivo.");
        }
        if (saldo < monto) {
            throw new SaldoInsuficienteE("Saldo insuficiente.");
        }
        saldo -= monto;
        System.out.println("Retiraste $" + monto + ". Tu saldo actual es de: $" + saldo);
    }

    public void depositar(double monto) throws MontoInvalidoE {
        if (monto <= 0) {
            throw new MontoInvalidoE("El monto debe ser positivo.");
        }
        saldo += monto;
        System.out.println("Tu deposito fue de: $" + monto + ". Tu saldo actual es de: $" + saldo);
    }

    public void transferir(Cuenta cuentaDestino, double monto) throws SaldoInsuficienteE, MontoInvalidoE{
        if (monto <= 0) {
            throw new MontoInvalidoE("El monto debe ser positivo.");
        }

        retirar(monto);
        cuentaDestino.depositar(monto);
        System.out.println("Transferiste: $"+ monto + "a" + cuentaDestino.getTitular());
    }
}
