import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // numerosImpares();
        // sumaNumeros();
        // numerosUnicos();
        // listaAzar();
        // palabrasRepetidas();
        //bingo();
        //contarPalabras();
        //sumarValoresUnicos();
        convertirRomanoAEntero();
    }

    // Ejercicio 1.

    public static void numerosImpares() {
        List<Integer> listaNumeros = new ArrayList<>();
        // Añadir 10 numeros a la lista
        for (int i = 1; i < 11; i++) {
            listaNumeros.add(i);
        }
        // Mostrar la lista
        for (int i = 0; i < listaNumeros.size(); i++) {
            System.out.print(listaNumeros.get(i) + ", ");
        }
        System.out.println(" ");
        // Eliminar los numeros pares de la lista
        for (int i = 0; i < listaNumeros.size(); i++) {
            if (listaNumeros.get(i) % 2 == 0) {
                listaNumeros.remove(listaNumeros.get(i));
            }

        }
        for (int i = 0; i < listaNumeros.size(); i++) {
            System.out.print(listaNumeros.get(i) + ", ");
        }
    }

    // Ejercicio 2.

    public static void sumaNumeros() {
        List<Integer> listaNumeros = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            listaNumeros.add(i);
        }
        System.out.println(listaNumeros.size());

        for (int i = listaNumeros.size() - 1; i > 0; i--) {
            listaNumeros.set(i - 1, listaNumeros.get(i - 1) + listaNumeros.get(i));

            listaNumeros.remove(i);

            System.out.println(listaNumeros);
        }
    }

    // Ejercicio 3.

    public static void numerosUnicos() {
        HashSet<Integer> numeros = new HashSet<>();
        Random random = new Random();

        while (numeros.size() < 10) {
            int numero = random.nextInt(100) + 1;
            numeros.add(numero);
        }
        System.out.println(numeros);
    }

    // Ejercicio 4.

    public static void listaAzar() {

        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<String> grupo1 = new ArrayList<>();
        ArrayList<String> grupo2 = new ArrayList<>();
        ArrayList<String> grupo3 = new ArrayList<>();
        ArrayList<String> grupo4 = new ArrayList<>();
        ArrayList<String> grupo5 = new ArrayList<>();
        ArrayList<String> grupo6 = new ArrayList<>();

        nombres.add("Juan");
        nombres.add("María");
        nombres.add("Carlos");
        nombres.add("Ana");
        nombres.add("Pedro");
        nombres.add("Laura");
        nombres.add("Luis");
        nombres.add("Sofía");
        nombres.add("Javier");
        nombres.add("Elena");
        nombres.add("Diego");
        nombres.add("Paula");
        nombres.add("Alejandro");
        nombres.add("Lucía");
        nombres.add("Miguel");
        nombres.add("Carmen");
        nombres.add("Pablo");
        nombres.add("Rosa");
        nombres.add("Roberto");
        nombres.add("Isabel");
        nombres.add("Daniel");
        nombres.add("Teresa");
        nombres.add("Jorge");
        nombres.add("Beatriz");
        nombres.add("Fernando");
        nombres.add("Raquel");
        nombres.add("José");
        nombres.add("Patricia");
        nombres.add("David");
        nombres.add("Eva");

        Random random = new Random();

        while (!nombres.isEmpty()) {
            int index = random.nextInt(nombres.size());
            if (grupo1.size() < 5) {
                grupo1.add(nombres.remove(index));
            } else if (grupo2.size() < 5) {
                grupo2.add(nombres.remove(index));
            } else if (grupo3.size() < 5) {
                grupo3.add(nombres.remove(index));
            } else if (grupo4.size() < 5) {
                grupo4.add(nombres.remove(index));
            } else if (grupo5.size() < 5) {
                grupo5.add(nombres.remove(index));
            } else {
                grupo6.add(nombres.remove(index));
            }
        }
        System.out.println(grupo1);
        System.out.println(grupo2);
        System.out.println(grupo3);
        System.out.println(grupo4);
        System.out.println(grupo5);
        System.out.println(grupo6);

    }

    // Ejercicio 5.

    public static void palabrasRepetidas() {
        Scanner teclado = new Scanner(System.in);
        HashSet<String> palabras = new HashSet<>();
        String palabra = "";
        do {
            if (palabra.equals("fin")) {
                break;
            }
            System.out.println("Introduce la palabra, cuando quieras parar introduce fin");

            palabra = teclado.nextLine();

            if (!palabras.add(palabra)) {
                System.out.println("La palabra " + palabra + " ya existe en la lista");
            }

        } while (true);
        System.out.println(palabras);
        teclado.close();
    }

    // Ejercicio 6.

    public static void bingo(){
        ArrayList<Integer> bombo = new ArrayList<>();
        for (int i = 1; i <= 75; i++) {
            bombo.add(i);
        }
        ArrayList<HashSet<Integer>> cartones = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            HashSet<Integer> carton = new HashSet<>();
            while (carton.size() < 25) {
                carton.add(random.nextInt(75) + 1);
            }
            cartones.add(carton);
        }
        do  {
            if(bombo.size() == 0){
                System.out.println("No hay bolas en el bombo");
                break;
            }
            int bola = bombo.remove(random.nextInt(bombo.size()));
            for (HashSet<Integer> carton : cartones) {
                if (carton.contains(bola)) {
                    System.out.println(carton);
                    System.out.println("El carton tiene el numero " + bola);
                    carton.remove(bola);
                    if (carton.isEmpty()) {
                        System.out.println("¡Bingo!");
                        return;
                    }
                }
            }   
        }while (true);
    }

    // Ejercicio 7.

    public static void contarPalabras() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una oración:");
        String oracion = scanner.nextLine();
    
        String[] palabras = oracion.split("[\\s,.;:!?]+");    
        Map<String, Integer> conteoPalabras = new HashMap<>();     
        for (String palabra : palabras) {
            palabra = palabra.toLowerCase(); // Ignorar mayúsculas y minúsculas
            conteoPalabras.put(palabra, conteoPalabras.getOrDefault(palabra, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : conteoPalabras.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        scanner.close();
    }

    // Ejercicio 8.
    public static void sumarValoresUnicos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una lista de números separados por espacios:");
        String input = scanner.nextLine();
        
        String[] numerosStr = input.split("\\s+");
        Map<Integer, Integer> conteoNumeros = new HashMap<>();
        
        for (String numStr : numerosStr) {
            int numero = Integer.parseInt(numStr);
            conteoNumeros.put(numero, conteoNumeros.getOrDefault(numero, 0) + 1);
        }
        
        int suma = 0;
        for (Map.Entry<Integer, Integer> entry : conteoNumeros.entrySet()) {
            if (entry.getValue() == 1) {
                suma += entry.getKey();
            }
        }
        
        System.out.println("La suma de los valores únicos es: " + suma);
        
        scanner.close();
    }
    // Ejercicio 9.

    public static void convertirRomanoAEntero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un número en notación romana (por ejemplo, 'XIV'):");
        String romano = scanner.nextLine().toUpperCase();

        Map<Character, Integer> valoresRomanos = new HashMap<>();
        valoresRomanos.put('I', 1);
        valoresRomanos.put('V', 5);
        valoresRomanos.put('X', 10);
        valoresRomanos.put('L', 50);
        valoresRomanos.put('C', 100);
        valoresRomanos.put('D', 500);
        valoresRomanos.put('M', 1000);

        int total = 0;
        int longitud = romano.length();

        for (int i = 0; i < longitud; i++) {
            int valorActual = valoresRomanos.get(romano.charAt(i));
            int valorSiguiente = (i + 1 < longitud) ? valoresRomanos.get(romano.charAt(i + 1)) : 0;

            if (valorActual < valorSiguiente) {
                total -= valorActual;
            } else {
                total += valorActual;
            }
        }

        System.out.println("El número entero equivalente es: " + total);
        scanner.close();
    }
}
