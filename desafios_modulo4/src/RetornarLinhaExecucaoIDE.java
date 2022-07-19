public class RetornarLinhaExecucaoIDE {

    // Retorna linha de execução dessa linha...
    // Se eu colocar esse método na linha 300, vai retorna linha 300.
    private static int retornarLinhaExecucao1() {
        return Thread.currentThread().getStackTrace()[1].getLineNumber();
    }

    // Retorna a linha que foi chamada...
    // Coloquei na linha 300, mas chamei na linha 40 => vai retorna linha 40.
    private static int retornarLinhaExecucao2() {
        return Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

}