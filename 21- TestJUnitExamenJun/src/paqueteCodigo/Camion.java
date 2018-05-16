package paqueteCodigo;

public class Camion {
	
	private String matricula;
    private int limiteCarga;
    private int carga; 

    
    public Camion( String matricula, int limiteCarga, int carga)
    {
    	this.matricula=matricula;
    	this.limiteCarga=limiteCarga;
    	if (carga <= limiteCarga) 
    		this.carga=carga; 
    	else {
    		System.out.println ("La carga maxima es "+ limiteCarga); 
    		this.carga=limiteCarga;
    		}
    }
    
    public int getLimiteCarga(){
       return limiteCarga;
    }
       
    public int getCarga() {
		return carga;
	}
	
    public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Camion [matricula=" + matricula + ", limiteCarga=" + limiteCarga + ", carga=" + carga + "]";
	}

    public void descargar (int carg){ 
    	carga -= carg;
    	if (carga < 0) {
    		System.out.println("No se puede descargar más de lo que hay. La carga queda en 0");
    		carga=0;
    	}    		
    }

    public void cargar (int carg) {
     carga += carg;
     if (carga > limiteCarga)  {
    	 System.out.println ("Se ha sobrepasado la carga maxima que es "+ limiteCarga); 
    	 carga=limiteCarga;}
    }
    
    }
