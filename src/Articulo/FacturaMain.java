package Articulo;
import java.util.ArrayList;
import java.util.Scanner;

public class FacturaMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int cantidadProducto = 0, opc = 0;
		String codigoProducto = "";
		ListarArticulo la = new ListarArticulo();
		la.fillData();
		do {
			System.out.println("GESTION DE VENTAS");
			System.out.println("1- Realizar una venta (Crear factura)");
			System.out.println("2- Listar articulos");
			System.out.println("3- Listar articulos sanos");
			System.out.println("4- Pedir un codigo y mostrar los articulos que tienen el precio equivalente del articulo");
			System.out.println("5- Listar los productos con stock bajo");
			System.out.println("7- Pedir codigo de articulo y aumentar stock");
			System.out.println("0- Salir");
			System.out.println("Opcion...");
			opc = sc.nextInt();
			
			switch(opc) {
				case 1: 
					sc.nextLine();
					System.out.println("Numero factura");
					int num = sc.nextInt();
					sc.nextLine();

					System.out.println("Nombre cliente:");
					String nombre = sc.nextLine();
					System.out.println("Apellido cliente:");
					String apellido = sc.nextLine();
					
					Factura f = new Factura(num, nombre, apellido, new ArrayList<LineaFactura>());
					
					while (!codigoProducto.equalsIgnoreCase("END")) {
						System.out.println("Codigo producto: (END para acabar)");
						codigoProducto = sc.next();
						if (!codigoProducto.equalsIgnoreCase("END")) {
							System.out.println("Cantidad producto:");
							cantidadProducto = sc.nextInt();
							double totalLinea = la.precio(codigoProducto) * cantidadProducto;
							f.añadirLinea(codigoProducto, cantidadProducto, totalLinea);
							
							
						}else {
							f.print();
							System.out.println();
							System.out.println();
						}
						
			        }break;
					
				case 2:
					System.out.println();
					System.out.println();
					for(Articulo a: la.lista ) {
						System.out.println(a.printCaracteristicas());
						
					}
					
					System.out.println();
					System.out.println();
			}
		}while(opc != 0);
		
	}

}
