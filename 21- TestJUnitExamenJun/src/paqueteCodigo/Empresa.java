package paqueteCodigo;
import java.util.ArrayList;
  
public class Empresa 
{    
    private String nombre;
    private int parqueMax;
    private ArrayList<Camion> listaCamiones;

    public Empresa (String nombre, int parqueMax)
    {
        this.nombre=nombre;
        this.parqueMax=parqueMax;
        this.listaCamiones= new ArrayList <Camion>();      
    }
    
    
    public String getNombre(){    
        return nombre;
    }
    
    public int getParque(){    
        return parqueMax;
    } 
    
    public Camion buscarCamion(String matric) //devuelve  el Camion cuya matrícula coincide con la que se pide
    { //si no lo encuentra, devuelve null. La matrícula debe tener una longitud de 7 caracteres

    	Camion camion=null; 
    	int i=0; boolean encontrado=false;
    	if (matric.length()!=7)
    		System.out.println("Error en la matrícula, no tiene 7 caracteres");
    	else {
    		while (encontrado==false && i<listaCamiones.size())
    			if (listaCamiones.get(i).getMatricula().equalsIgnoreCase(matric)){
    				camion=listaCamiones.get(i);
    				encontrado=true;
    			}
    			else
    				i++;
    	}
    	return camion;       
    }
    
    public boolean insertarCamion(Camion Camion)
    {
    	if (listaCamiones.size()==parqueMax){
    		System.out.println("No se puede añadir más vehículos a la empresa porque supera el parque máximo");
    		return false; //si falla la inserción se retorna false
    	}
    	else 
    		if (buscarCamion(Camion.getMatricula())!=null){
    			System.out.println ("Ya existe el Camion a añadir");
    			return false; //ídem
    		}  
    		else {

    			listaCamiones.add(Camion);
    			System.out.println("Se ha añadido el vehículo "+Camion.getMatricula());
    			return true; // si se hace el alta correctamente se devuelve true

    		}

    }

    public boolean borrarCamion(Camion Camion)
    {
    	Camion vehic=buscarCamion(Camion.getMatricula());

    	if (vehic==null){
    		System.out.println ("No se encuentra el Camion a borrar");
    		return false; //si falla el borrado se retorna false
    	}
    	else {
    		listaCamiones.remove(Camion);
    		System.out.println("Se ha borrado correctamente");
    		return true;

    	}
       }
        
        public void listarCamions() {   
           
            System.out.println ("Empresa: "+ this.getNombre() +" parque de Camions; "+getParque());
            for (Camion camion:listaCamiones){
            	System.out.println(camion.toString());
            }
            	
            	
           /* for (int i=0; i<listaCamiones.size(); i++) {
                  System.out.println(listaCamiones.get(i).toString());
                }*/
          }

		
        
      
           
    }