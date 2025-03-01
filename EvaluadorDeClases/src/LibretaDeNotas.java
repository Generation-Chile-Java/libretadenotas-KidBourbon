

import java.util.*;

public class LibretaDeNotas {
    /*Crear la clase:
    Crea la clase LibretaDeNotas para que pueda evaluar y almacenar las calificaciones de una lista de estudiantes.✅
    Utiliza un HashMap para almacenar las calificaciones de los estudiantes, donde la llave es el nombre del estudiante y el valor es un ArrayList de notas.✅
    Solicita al usuario que ingrese la cantidad de alumnos y la cantidad de notas por alumno.✅
    Solicita el nombre de cada alumno y las notas correspondientes, almacenándolas en el HashMap.✅
Recorrer el HashMap y Evaluar Calificaciones:
    Utiliza un bucle (por ejemplo, for o foreach) para recorrer el HashMap de calificaciones.✅
    Calcular Promedio, Nota Máxima y Mínima por Estudiante:✅
Después de evaluar las calificaciones, calcula y muestra para cada estudiante:
    Promedio de Notas:
        Suma todas las calificaciones y divide por la cantidad total de notas.
        Nota Máxima: Encuentra la calificación más alta en el ArrayList.✅
        Nota Mínima: Encuentra la calificación más baja en el ArrayList.✅

Menú de Opciones:
Muestra un menú con las siguientes opciones:✅
1. Mostrar el Promedio de Notas por Estudiante.
2. Mostrar si la Nota es Aprobatoria o Reprobatoria por Estudiante.
3. Mostrar si la Nota está por Sobre o por Debajo del Promedio del Curso por Estudiante.
0. Salir del Menú.
Utiliza un bucle para permitir al usuario seleccionar opciones hasta que ingrese 0 para salir.
Operaciones del Menú:
    Opción 1: Mostrar el Promedio de Notas por Estudiante.✅
    Muestra el promedio de notas por cada estudiante calculado previamente.✅
    Opción 2: Mostrar si la Nota es Aprobatoria o Reprobatoria por Estudiante.✅
    Solicita al usuario ingresar el nombre de un estudiante y una nota, luego verifica si es aprobatoria o reprobatoria según una nota de aprobación definida.✅
    Opción 3: Mostrar si la Nota está por Sobre o por Debajo del Promedio del Curso por Estudiante.✅
    Solicita al usuario ingresar el nombre de un estudiante y una nota, luego verifica si está por sobre o por debajo del promedio general.✅
Validaciones:
    Implementa validaciones para asegurar que las notas ingresadas estén en un rango válido y que la cantidad de alumnos sea un número positivo.✅

Usa lo aprendido y usa clases de estudiante

*/


    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {


        Map<String, ArrayList> listaNotas = new HashMap<>();
        ArrayList<Double> notas;

/*
        notas = new ArrayList<>();
        notas.add(1.0);
        notas.add(1.0);
        notas.add(1.0);
        listaNotas.put("lennon", notas);
        notas = new ArrayList<>();
        notas.add(5.0);
        notas.add(5.0);
        notas.add(5.0);
        listaNotas.put("daniel", notas);
        notas = new ArrayList<>();
        notas.add(10.0);
        notas.add(10.0);
        notas.add(10.0);
        listaNotas.put("pablo", notas);
        System.out.println(listaNotas);*/





        System.out.println("Ingrese la cantidad de alumnos");
        int canAlumnos = validaNumero();
        System.out.println("ingrese la cantidad de notas por alumno");
        int canNotas = validaNumero();


        for (int i = 0; i < canAlumnos; i++) {
            notas = new ArrayList<>();
            System.out.println("Ingrese nombre del alumno");
            sc.nextLine();
            String alumno = sc.nextLine();

            for (int j = 0; j < canNotas; j++) {
                System.out.println("Ingrese nota "+j+1+" del estudiante : "+ alumno );
                notas.add(ingresoNota());

            }

            listaNotas.put(alumno, notas);

        }



        imprimirPromedios(listaNotas);

        notaMax(listaNotas);
        notaMin(listaNotas);
        notaMaxTotal(listaNotas);
        notaMinTotal(listaNotas);
        menu(listaNotas);

        //aprobacion(listaNotas);
        //promedioCurso(listaNotas);
        //notaPromedioCurso(listaNotas);


    }

    public static void imprimirListaNotas(Map<String, ArrayList> listaNotas) {

        for (String key : listaNotas.keySet()) {
            System.out.println("Alumno : " + key + " -  Notas : " + listaNotas.get(key));
        }
    }

    public static void imprimirPromedios(Map<String, ArrayList> listaNotas) {
        for (String key : listaNotas.keySet()) {
            ArrayList<Double> notas = listaNotas.get(key);
            double total = 0;
            for (int i = 0; i < notas.size(); i++) {
                total += notas.get(i);
            }
            total = total / listaNotas.size();

            System.out.println("Alumno : " + key + " - Notas :" + listaNotas.get(key) + " -  Promedio : " + total);
        }

    }

    public static void notaMax(Map<String, ArrayList> listaNotas) {

        for (String key : listaNotas.keySet()) {
            ArrayList<Double> notas = listaNotas.get(key);
            Double max = notas.stream().max(Double::compareTo).get();
            System.out.println("La nota maxima del alumno : " + key + " - Notas : " + max);

        }

    }

    public static void notaMaxTotal(Map<String, ArrayList> listaNotas) {
        ArrayList<Double> notas;
        ArrayList<Double> notasTotal = new ArrayList<>();

        for(String key : listaNotas.keySet()) {
            notas = listaNotas.get(key);
            for(double nota : notas) {
                notasTotal.add(nota);
            }
        }
        Double max = notasTotal.stream().max(Double::compareTo).get();
        System.out.println("La nota maxima del Curso es: " + max);
    }



    public static void notaMin(Map<String, ArrayList> listaNotas) {
        for (String key : listaNotas.keySet()) {
            ArrayList<Double> notas = listaNotas.get(key);
            Double min = notas.stream().min(Double::compareTo).get();
            System.out.println("La nota minima del alumno : " + key + " - Notas : " + min);
        }
    }

    public static void notaMinTotal(Map<String, ArrayList> listaNotas) {
        ArrayList<Double> notas;
        ArrayList<Double> notasTotal = new ArrayList<>();

        for(String key : listaNotas.keySet()) {
            notas = listaNotas.get(key);
            for(double nota : notas) {
                notasTotal.add(nota);
            }
        }
        Double max = notasTotal.stream().min(Double::compareTo).get();
        System.out.println("La nota minima del Curso es: " + max);
    }

    public static void aprobacion(Map<String, ArrayList> listaNotas) {

        System.out.println("ingrese el nombre del alumno");
        String nombre = sc.nextLine();
        System.out.println("ingrese la nota que desea aprobar");
        double nota = ingresoNota();

        double promedio = calculaPromedio(listaNotas.get(nombre));
        System.out.println("el promedio del alumno es: " + promedio);
        if (promedio >= nota) {
            System.out.println("El alumno se puede Aprobar");
        } else {
            System.out.println("El alumno se puede Reprobar");
        }


    }

    public static double calculaPromedio(ArrayList<Double> notas) {
        double promedio = 0;
        for (int i = 0; i < notas.size(); i++) {

            promedio = promedio + notas.get(i);
        }
        promedio = promedio / notas.size();
        return promedio;

    }

    public static double promedioCurso(Map<String, ArrayList> listaNotas) {
        int contador = 0;
        double promedio = 0;
        for (String key : listaNotas.keySet()) {
            ArrayList<Double> notas = listaNotas.get(key);
            double total = calculaPromedio(notas);
            promedio = promedio + total;
            contador++;
        }
        promedio = promedio / contador;
        System.out.println("El promedio del Curso es: " + promedio);
        return promedio;
    }


    public static void notaPromedioCurso(Map<String, ArrayList> listaNotas) {

        System.out.println("ingrese el nombre del alumno");
        String nombre = sc.nextLine();
        System.out.println("ingrese la nota que desea aprobar");
        double nota = ingresoNota();

        double promedio = promedioCurso(listaNotas);
        if (nota > promedio) {
            System.out.println("El alumno " + nombre + ", Su nota " + nota + " se encuentra Sobre al preomedio del Curso");
        } else if (nota == promedio) {
            System.out.println("El alumno " + nombre + ", Su nota " + nota + " se Igual al preomedio del Curso");
        } else {
            System.out.println("El alumno " + nombre + ", Su nota " + nota + " se encuentra por Debajo del preomedio del Curso");
        }


    }


    public static double ingresoNota() {
        double nota = 0;

        while (true) {
            try {
                nota = sc.nextDouble();
                if (nota >= 1 && nota <= 10) {
                    return nota;
                } else {
                    System.out.println("La nota debe estrar ente 1 y 10 Vuelve a intentar");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Debe ingresar Numero Valido");
            }
        }
    }


    public static int validaNumero() {
        int numero = 0;

        while (true) {
            try {
                numero = sc.nextInt();
                if (numero >= 1 && numero <= 10) {
                    return numero;
                } else {
                    System.out.println("Debe ingresar Numero Valido");
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Debe ingresar Numero");
            }
        }
    }


    public static void menu(Map<String, ArrayList> listaNotas) {
        boolean menu = true;
        int opcion = 0;
        do {
            try {
                System.out.println("1. Mostrar el Promedio de Notas por Estudiante.\n" +
                        "2. Mostrar si la Nota es Aprobatoria o Reprobatoria por Estudiante.\n" +
                        "3. Mostrar si la Nota está por Sobre o por Debajo del Promedio del Curso por Estudiante.\n" +
                        "0. Salir del Menú.");

                opcion = sc.nextInt();


                switch (opcion) {

                    case 1:
                        imprimirPromedios(listaNotas);
                        break;
                    case 2:
                        aprobacion(listaNotas);
                        break;
                    case 3:
                        notaPromedioCurso(listaNotas);
                        break;
                    case 0:
                        menu = false;
                        break;

                    default:
                        System.out.println("Ingrese una opcion valida.");

                }

            } catch (Exception e) {
                System.out.println("Ingrese una opcion valida.");
                sc.nextLine();
            }
            if (opcion != 0) {
                try {
                    Thread.sleep(3 * 1000);
                } catch (Exception e) {
                }
            }


        } while (menu);
    }


}
