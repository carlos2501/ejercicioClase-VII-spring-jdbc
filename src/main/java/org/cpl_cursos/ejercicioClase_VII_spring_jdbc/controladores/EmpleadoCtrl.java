package org.cpl_cursos.ejercicioClase_VII_spring_jdbc.controladores;

import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.DTOs.EmpleadoDTOLista;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.DTOs.VentasEmpleadoDTO;
import org.cpl_cursos.ejercicioClase_VII_spring_jdbc.servicios.JardineriaSrvc;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class EmpleadoCtrl {

    private final JardineriaSrvc jardineriaSrvc;
    private final Scanner scanner = new Scanner(System.in);

    public EmpleadoCtrl(JardineriaSrvc jardineriaSrvc) {
        this.jardineriaSrvc = jardineriaSrvc;
    }

    public void mostrarEmpleadosPorOficina() {
        System.out.println("\n=== EMPLEADOS POR OFICINA ===");
        List<EmpleadoDTOLista> listaEmpleados = jardineriaSrvc.listarEmpleados();
        // Procesamos la lista de empleados para rellenar el Map
        Map<String, List<EmpleadoDTOLista>> mapEmpleados = listaEmpleados.stream()
                .collect(Collectors.groupingBy(EmpleadoDTOLista::getCiudadOficina));
        // Listamos los empleados de la oficina de cada ciudad
        mapEmpleados.forEach((ciudad, empleados) -> {
            System.out.println("*** OFICINA: " + ciudad.toUpperCase() + " ***");
            empleados.forEach(this::imprimirEmpleado);
            //System.out.println();
        });
        esperarEnter();
    }

    public void mostrarVentasPorEmpleado() {
        // Procesamos la lista de ventas
        List<VentasEmpleadoDTO> listaVentas = jardineriaSrvc.listarVentasEmpleados();

        System.out.println("\n=== VENTAS POR EMPLEADO ===");
        // Cabecera
        System.out.printf("%-8s %-30s %-20s %-20s%n",
                "CÓDIGO", "NOMBRE COMPLETO", "CIUDAD", "PUESTO");
        // Creamos un Map con el código de empleado como clave y una lista de ventasEmpleadoDTO como valor de cada clave
        Map<Integer, List<VentasEmpleadoDTO>> ventasEmpleado = listaVentas.stream()
                        .collect(Collectors.groupingBy(VentasEmpleadoDTO::getCodigoEmpleado));
        // Recorremos el Map pata listarlo por código de empleado y otra sub-lista por gama
        ventasEmpleado.forEach((codEmp, ventas) -> {
            // Leemos el primer elemento de la lista de ventas para obtener los datos del empleado
            VentasEmpleadoDTO primeraVenta = ventas.getFirst();
            // los presentamos en pantalla
            System.out.printf("%-8d %-30s %-20s %-20s%n",
                    primeraVenta.getCodigoEmpleado(),
                    primeraVenta.getNombreCompleto(),
                    primeraVenta.getCiudadOficina(),
                    primeraVenta.getPuesto()
            );
            // Ponemos al cero el total de ventas del empleado
            BigDecimal totalVentasEmpleado = BigDecimal.ZERO;
            // procesamos la lista de ventas para presentar cada gama
            for(VentasEmpleadoDTO venta : ventas) {
                System.out.println("Gama: " + venta.getGama() + " -> " + venta.getVentasGama());
                totalVentasEmpleado = totalVentasEmpleado.add(venta.getVentasGama());
            }

            // Muestro el total de ventas del empleado
            System.out.println("TOTAL VENTAS DE " + primeraVenta.getNombreCompleto()+ " --> " + totalVentasEmpleado);
        });

        esperarEnter();
    }

    private void imprimirEmpleado(EmpleadoDTOLista empleado) {
        System.out.printf("  - %s %s %s (%s) - %s%n",
                empleado.getNombre(),
                empleado.getApellido1(),
                empleado.getApellido2() != null ? empleado.getApellido2() : "",
                empleado.getPuesto(),
                empleado.getEmail());
    }

    private void esperarEnter() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
}
