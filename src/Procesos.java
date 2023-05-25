import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

public class Procesos {
	HashMap<String, ArrayList<String>> paises;
	ArrayList<String> ciudades;
	
	public Procesos() {
		paises=new HashMap<String, ArrayList<String>>();
	}
	
	public void iniciar() {        
		String menu="ENTRADA A MENÚ PAISES\n";
		menu+="1. Registrar país\n";
		menu+="2. Registrar ciudades\n";
		menu+="3. Imprimir info paises\n";
		menu+="4. Consultar ciudades por país\n";
		menu+="5. Consultar ciudad\n";
		menu+="6. Abandonar\n";
		
		int opc=0;
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog((menu)));
			
			validarMenu(opc);
		} while (opc!=6);
	}

	private void validarMenu(int opc) {
		switch (opc) {
		case 1:
			registrarPais();
			break;

		case 2:
			registrarCiudad();
			break;
			
		case 3:
			imprimirDatos(paises);
			break;
			
		case 4:
			consultaCiudadporPais();
			break;
			
		case 5:
			consultaCiudad();
			break;
			
		case 6: JOptionPane.showMessageDialog(null,"Cerrando",
				"Cierre del sistema",JOptionPane.CLOSED_OPTION);
			break;
			
		default:JOptionPane.showMessageDialog(null,"Error",
				"No es una opción válida ",JOptionPane.ERROR_MESSAGE);
			break;
		}
		
	}

	private void registrarPais() {
	    ciudades = new ArrayList<String>();
		String pais=JOptionPane.showInputDialog("Ingrese el país");
		paises.put(pais, ciudades);
		System.out.println(paises);
	}
	
	 private void registrarCiudad() { 
	    String ciudad="", resp="";
	    String pais=JOptionPane.showInputDialog("Ingrese el país al que agregará las ciudades");
	    	if (paises.containsKey(pais)) {
		    	do {	
		    		ciudad=JOptionPane.showInputDialog("Ingrese la ciudad del país");
		            ciudades.add(ciudad);
		            resp=JOptionPane.showInputDialog("Ingrese 'SI' para ingresar otra ciudad");
			    	System.out.println(paises);
				} while (resp.equalsIgnoreCase("si"));
			}
	    System.out.println(paises);
	    paises.put(pais, ciudades);
	    System.out.println(paises);
	 }

//  FORMA DE IMPRIMIR MAPA #1	 
	private void imprimirDatos(HashMap<String, ArrayList<String>> paises) {
			
			Iterator<String> iterator=paises.keySet().iterator();
			
			while (iterator.hasNext()) {
				String llave = iterator.next();
				System.out.println(llave +" - "+paises.get(llave));
				
			}
	}
	
//  FORMA DE IMPRIMIR MAPA #2
//	public void imprimirMapaForma2() {
//
//	        for (String documento:mapEstudiantes.keySet()) {
//	            System.out.println(documento + " - "+mapEstudiantes.get(documento));
//	        }
//
//	 }
	
	private void consultaCiudadporPais() {
		String validar="";
		String paisCon=JOptionPane.showInputDialog("Ingrese el país del que desea consultar las ciudades");
		if (paises.containsKey(paisCon)) {
			System.out.println("El país "+paisCon+" tiene las ciudades:");
			for (int i = 0; i < paises.get(paisCon).size(); i++) {
				System.out.println(paises.get(paisCon).get(i));
			}
		}else {
			JOptionPane.showMessageDialog(null, "El pais no se encuentra registrado");
			validar=JOptionPane.showInputDialog("¿Desea registrar el país ingresado?");
			if (validar.equalsIgnoreCase("si")) {
				registrarPais();
			}else {
				JOptionPane.showConfirmDialog(null, "Salió");
		}
	}
		
	}
	
	public void consultaCiudad() {
		String city = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad");
		
		for (Map.Entry<String, ArrayList<String>> entry : paises.entrySet()) {
            String clave = entry.getKey();
            ArrayList<String> lista = entry.getValue();
            if(lista.contains(city)) {
            	System.out.println("La ciudad "+city + " se encontró en el país " + clave);
            }
        }	
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	

	

