package categorias.enums;

/**
 * Se eu quiser fazer um getMaterial quem cuida disso é o enum?
 * A String referente ao material... Quem cuida disso é o enum?
 * Pra evitar que eu tenha de mudar em todos os produtos que tiverem esses materiais?
 */
public enum TipoMaterial {
        JEANS("JEANS"),
        COURO("COURO"),
        MOLETON("MOLETON"),
        VELUDO("VELUDO");

        // Tipo do material não pode ser alterável... Por isso não tem set aqui dentro.
        // Cada produto pode ter um setTipoMaterial... ao vai estar alterando o enum e não esse valor específico aqui.
        private final String material;

        // Construtor de um enum já é privado por default.
        TipoMaterial(String material) {
                this.material = material;
        }

        public String getMaterial() {
                return material;
        }
}