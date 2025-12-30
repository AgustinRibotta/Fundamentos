/*
 * Crea una función que reciba dos parámetros de tipo cadena de texto y retorne un número.
 * - La función imprime todos los números del 1 al 100. Teniendo en cuenta que:
 *   - Si el número es múltiplo de 3, muestra la cadena de texto del primer parámetro.
 *   - Si el número es múltiplo de 5, muestra la cadena de texto del segundo parámetro.
 *   - Si el número es múltiplo de 3 y de 5, muestra las dos cadenas de texto concatenadas.
 *   - La función retorna el número de veces que se ha impreso el número en lugar de los textos.

int function (String a, String b) -> n = i != a or i != b
for ( i = 1, i > 101, i++){}
if (i % 3 == 0 ) -> a
if (i % 5 == 0) -> b
if (i % 3 == 0 && i % 5 == 0) -> a and  b

*/

public class FunctionsAndScope {

    public static int aOrb (String a, String b){
        int n = 0;
        for (int i = 1; i < 101; i++){
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(a + b);
            } else if (i % 3 == 0) {
                System.out.println(a);
            }else if ( i % 5 == 0) {
                System.out.println(b);
            }else {
                n++;
            }
        }
        return n;
    }


    public static void main(String[] args) {
        System.out.println(FunctionsAndScope.aOrb("ho", "la"));
            
            
    }
}

