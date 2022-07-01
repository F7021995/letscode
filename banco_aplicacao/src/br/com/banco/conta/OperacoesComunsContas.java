package br.com.banco.conta;

import java.math.BigDecimal;

public interface OperacoesComunsContas {

    void sacar(BigDecimal valorSaque);

    void transferir(Conta destino, BigDecimal valorTransferencia);

    void depositar(BigDecimal valorDeposito);

}
