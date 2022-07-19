import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public abstract class MathFacil {

    /**
     * Importando 'Math.*' eu não preciso dizer 'Math.sqrt()'
     * Importando 'Math.*' eu não preciso dizer 'Math.abs' ou outros.
     */
    void programaMuitoMath() {
        double b = sqrt(64) * abs(-40);
    }

    /**
     * Se o programa for especificamente voltado em matemática: import static java.lang.Math.*;
     * Ficar usando Math.metodo, Math.metodo, Math.metodo: pode ser algo ruim.
     */
    abstract void importStatic();

}