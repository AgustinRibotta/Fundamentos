/*
  * Crea una agenda de contactos por terminal.
 * - Debes implementar funcionalidades de búsqueda, inserción, actualización
 *   y eliminación de contactos.
 * - Cada contacto debe tener un nombre y un número de teléfono.
 * - El programa solicita en primer lugar cuál es la operación que se quiere realizar,
 *   y a continuación los datos necesarios para llevarla a cabo.
 * - El programa no puede dejar introducir números de teléfono no numéricos y con más
 *   de 11 dígitos (o el número de dígitos que quieras).
 * - También se debe proponer una operación de finalización del programa.

 function search
    list.search(contact)
function add
    new map 
    list.add(map)
 function update
    list.search(contact)
    map.update(name)
 contact 
 - name
 - phone number -> only number > 11 digits
 operation menu
 - search
 - add
 - update
 - exit
Store data:
 List<Map>
Contact:
 Map<Sting>
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import java.util.*;
import java.util.stream.*;

public class DataStructure {

    public List<Map<String, String>> contacts = new ArrayList<>();

    // Método para buscar contactos por nombre
    public void search(Scanner sc) {
        System.out.println("Name to search: ");
        String name = sc.nextLine();

        List<Map<String, String>> resultados = contacts.stream()
                .filter(contact -> contact.get("name").equals(name))
                .collect(Collectors.toList());

        if (resultados.isEmpty()) {
            System.out.println("No contacts found with name: " + name);
        } else {
            System.out.println("Contacts found:");
            resultados.forEach(contact -> 
                System.out.println("Name: " + contact.get("name") + ", Phone: " + contact.get("phone")));
        }
    }

    // Método para agregar un nuevo contacto
    public void add(Scanner sc) {
        Map<String, String> contact = new HashMap<>();

        System.out.println("Name: ");
        String name = sc.nextLine();

        System.out.println("Phone: ");
        String phone = sc.nextLine();

        contact.put("name", name);
        contact.put("phone", phone);
        contacts.add(contact);

        System.out.println("New contact added:");
        System.out.println("Name: " + contact.get("name"));
        System.out.println("Phone: " + contact.get("phone"));
    }

    // Método para actualizar un contacto
    public void update(Scanner sc) {
        System.out.println("Name search: ");
        String nameS = sc.nextLine();

        Optional<Map<String, String>> contacUpdate = contacts.stream()
                .filter(contact -> contact.get("name").equals(nameS))
                .findFirst();

        if (!contacUpdate.isPresent()) {
            System.out.println("Name not found");
            return;
        }

        Map<String, String> contact = contacUpdate.get();

        System.out.println("Update options:\n" +
                "1 - Phone\n" +
                "2 - Name\n" +
                "3 - Phone and Name");
        int option = sc.nextInt();
        sc.nextLine(); 

        switch (option) {
            case 1: 
                System.out.println("Phone to update: ");
                String phone = sc.nextLine();
                contact.put("phone", phone);
                break;

            case 2: 
                System.out.println("Name to update: ");
                String name = sc.nextLine();
                contact.put("name", name);
                break;

            case 3: 
                System.out.println("Phone to update: ");
                phone = sc.nextLine();
                System.out.println("Name to update: ");
                name = sc.nextLine();
                contact.put("phone", phone);
                contact.put("name", name);
                break;

            default:
                System.out.println("Invalid option");
        }

        System.out.println("Contact updated:");
        System.out.println("Name: " + contact.get("name"));
        System.out.println("Phone: " + contact.get("phone"));
    }

    // Método main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataStructure dataStructure = new DataStructure();
        boolean state = true;

        while (state) {
            System.out.println("\nContact list menu:\n" +
                    "1 - Search\n" +
                    "2 - Add\n" +
                    "3 - Update\n" +
                    "4 - Exit");

            int option = sc.nextInt();
            sc.nextLine(); 

            switch (option) {
                case 1:
                    dataStructure.search(sc);
                    break;
                case 2:
                    dataStructure.add(sc);
                    break;
                case 3:
                    dataStructure.update(sc);
                    break;
                case 4:
                    state = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

        sc.close();
        System.out.println("Exiting program...");
    }
}

