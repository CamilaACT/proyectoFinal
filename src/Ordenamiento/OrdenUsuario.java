package Ordenamiento;
import Clases.Usuario;
import java.util.Comparator;
import java.util.List;

public class OrdenUsuario {
    public static void Burbuja(List<Usuario> arregloBurbuja, Comparator<Usuario> comparator){
        int n = arregloBurbuja.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (comparator.compare(arregloBurbuja.get(j), arregloBurbuja.get(j+1)) > 0) {
                    Usuario temp = arregloBurbuja.get(j);
                    arregloBurbuja.set(j, arregloBurbuja.get(j + 1));
                    arregloBurbuja.set(j + 1, temp);
                }
            }
        }
    }

    public static void Insercion(List<Usuario> arregloInsercion, Comparator<Usuario> comparator) {
        int n = arregloInsercion.size();
        for (int i = 1; i < n; ++i) {
            Usuario key = arregloInsercion.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(arregloInsercion.get(j), key) > 0) {
                arregloInsercion.set(j + 1, arregloInsercion.get(j));
                j = j - 1;
            }
            arregloInsercion.set(j + 1, key);
        }
    }

    public static Usuario binarySearch(List<Usuario> menu, Comparator<Usuario> comparator, Usuario value) {
        int left = 0;
        int right = menu.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (comparator.compare(menu.get(middle), value) == 0) {
                return menu.get(middle);
            } else if (comparator.compare(menu.get(middle), value) < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return null;
    }
}
