public class a_LabelsEmBlocos {

    /**
     * Label em um for... útil quando for da break.
     */
    void labelEmLacos() {
        rowLabel: for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // Estou dando break no for maior, sem esse apelido o break seria no for mais próximo.
                if(j == 4) {
                    break rowLabel;
                }
            }
        }
    }

    /**
     * Tem como usar Label em If (tem como dar um apelido para um if).
     * Isso é útil para dar break.
     */
    void labelEmIfs(Integer b) {

        ifLabel: if(b == 3) {
            System.out.println("Tem como usar label em if ou qualquer outra coisa.");
            System.out.println("Lembrando que: labels servem principalmente para Break e Continue.");

            // Estou quebrando o if específico chamado ifLabel.
            break ifLabel;
        }
    }
}
