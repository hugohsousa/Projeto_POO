import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Escreva uma descrição da classe House aqui.
 * 
 * @author (Grupo 12) 
 */
public class House {
    
    //Variáveis de instância
    private String nome;
    private int nif;
    private Supplier fornecedor;
    private int nrd;
    private Map<String,Set<SmartDevice>> dispositivos = new HashMap<String,Set<SmartDevice>>(); 

    /**
     * Construtores da classe House
     * Declaração de construtores por omissão (vazio), parametrizado e de cópia
    */
    public House() {
        this.nome = "";
        this.nif = 0;
        this.fornecedor = new Supplier();
        this.dispositivos = new HashMap<String,Set<SmartDevice>>();
        this.nrd = 0;  
    }

    /**
     * Construtor parametrizado
     * Evocação do construtor da classe House
     * @param nome peso base da House
     * @param nif numero de idenficação do proprietario da casa
     * @param fornecedor fornecedor da casa
     * @param dispositivos novo dispositivo
     */
    public House(String nome, int nif, Supplier fornecedor, Map<String,Set<SmartDevice>> dispositivos) {
        this.nome = nome;
        this.nif = nif;
        this.fornecedor = fornecedor.clone();
        Map<String,Set<SmartDevice>> novo_dispositivos = new HashMap<String,Set<SmartDevice>>();
        
        for (HashMap.Entry<String,Set<SmartDevice>> entry : dispositivos.entrySet()) {
            novo_dispositivos.put(entry.getKey(),entry.getValue().stream().collect(Collectors.toSet()));
            this.nrd += entry.getValue().size();
        }
        
        this.dispositivos = novo_dispositivos;
    }

    /**
     * Construtor de cópia
     * Aceita como parâmetro outra House e utiliza os métodos 
     * de acesso aos valores das variáveis de instância
     */
    public House(House um) {
        this.nome = um.getNome();
        this.nif = um.getNif();
        this.fornecedor = um.getFornecedor();
        this.dispositivos = um.getDispositivos();
        for (HashMap.Entry<String,Set<SmartDevice>> entry : this.dispositivos.entrySet()) {
            this.nrd += entry.getValue().size();
        }
    }

    /**
     * Métodos de instância
     */
    /**
     * Devolve o nome da House
     * 
     * @return Nome da House
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Devolve nif do proprietario da House
     * 
     * @return Nif do proprietario da House
     */
    public int getNif() {
        return this.nif;
    }

    /**
     * Devolve o fornecedor da House
     * 
     * @return Fornecedor da House
     */
    public Supplier getFornecedor() {
        return this.fornecedor;
    }

    /**
     * Devolve o novo dispositivo da House
     * 
     * @return Novo dispositivo da House
     */
    public Map<String,Set<SmartDevice>> getDispositivos() {
        Map<String,Set<SmartDevice>> novo_dispositivos = new HashMap<String,Set<SmartDevice>>();
        
        for (HashMap.Entry<String,Set<SmartDevice>> entry : this.dispositivos.entrySet()) {
            novo_dispositivos.put(entry.getKey(),entry.getValue().stream().collect(Collectors.toSet()));
        }

        return novo_dispositivos;
    }

    /**
     * Atualiza o nome da House
     *
     * @param nome Novo nome da House
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Atualiza o nif do proprietario da House
     *
     * @param nif Novo nif do proprietario da House
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * Atualiza o fornecedor da House
     *
     * @param nif Novo fornecedor da House
     */
    public void setFornecedor(Supplier fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * Atualiza o dispositivos da House
     *
     * @param dispositivos Novo dispositivos da House
     */
    public void setDispositivos(HashMap<String, Set<SmartDevice>> dispositivos) {
        Map<String,Set<SmartDevice>> novo_dispositivos = new HashMap<String,Set<SmartDevice>>();
        for (HashMap.Entry<String, Set<SmartDevice>> entry : dispositivos.entrySet()) {
            novo_dispositivos.put(entry.getKey(),entry.getValue().stream().collect(Collectors.toSet()));
        }
        this.dispositivos = novo_dispositivos;
    }

    /**
     * Método de igualdade entre duas House
     * 
     * @param o House que é comparado com o recetor
     * @return boolean True ou False
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o==null) || (this.getClass() != o.getClass() )) return false;
        House n = (House) o;
        return (this.nome.equals(n.getNome()) && this.nif == n.getNif() && this.fornecedor.equals(n.getFornecedor())
                && this.dispositivos.equals(n.getDispositivos()));
    }

    /**
     * Método que devolve a representação em String da House
     * 
     * @return String com a informação da House
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Casa:\n").append("Nome: ").append(this.nome);
        sb.append("\nNif: ").append(this.nif);
        sb.append("\nLista de dispositivos:\n");
        for (HashMap.Entry<String,Set<SmartDevice>> entry : this.dispositivos.entrySet()) {
            sb.append(entry.getKey().toString()).append("\n");
            for(SmartDevice s: entry.getValue()) {
                sb.append(s.toString()).append("\n");
            }
        }

        return sb.toString();
    }

    /**
     * Método que faz uma cópia do objeto recetor da mensagem
     * Para tal invoca o construtor de cópia
     * 
     * @return objeto clone do objeto que recebe a mensagem
     */
    public House clone() {
        return new House(this);
    }

    /**
    * Método que adiciona a House um SmartBulb
     */
    public void addSmartBulb(int cf, float ci, String estado, float consumo, int t,int size, float f, String div) {
        if(this.dispositivos.containsKey(div) == false) this.dispositivos.put(div,new HashSet<SmartDevice>());
        if(estado.equals("on") == true || estado.equals("On") == true || estado.equals("ON") == true) {
            this.dispositivos.get(div).add(new SmartBulb(nrd,cf,ci,true,consumo,t,size,f));
        } else {
            this.dispositivos.get(div).add(new SmartBulb(nrd,cf,ci,false,consumo,t,size,f));
        }
        this.nrd++;
    }

    /**
    * Método que adiciona a House um SmartCamera
     */
    public void addSmartCamera(int cf, float ci, String estado, float consumo, int r,int tf, String div) {
        if(this.dispositivos.containsKey(div) == false) this.dispositivos.put(div,new HashSet<SmartDevice>());

        if(estado.equals("on") == true || estado.equals("On") == true || estado.equals("ON") == true) {
            this.dispositivos.get(div).add(new SmartCamera(nrd,cf,ci,true,consumo,r,tf));
        } else {
            this.dispositivos.get(div).add(new SmartCamera(nrd,cf,ci,false,consumo,r,tf));
        }
        this.nrd++;
    }

    /**
    * Método que adiciona a House um SmartSpeake
     */
    public void addSmartSpeaker(int cf, float ci, String estado, float consumo, int v,String r, String m, String div) {
        if(this.dispositivos.containsKey(div) == false) this.dispositivos.put(div,new HashSet<SmartDevice>());

        if(estado.equals("on") == true || estado.equals("On") == true || estado.equals("ON") == true) {
            this.dispositivos.get(div).add(new SmartSpeaker(nrd,cf,ci,true,consumo,v,r,m));
        } else {
            this.dispositivos.get(div).add(new SmartSpeaker(nrd,cf,ci,false,consumo,v,r,m));
        }
        this.nrd++;
    }

    /**
    * Método que adiciona a House um SmartTv
     */
    public void addSmartTv(int cf, float ci, String estado, float consumo, int c,int b, int v, float t, String div) {
        if(this.dispositivos.containsKey(div) == false) this.dispositivos.put(div,new HashSet<SmartDevice>());
        
        if(estado.equals("on") == true || estado.equals("On") == true || estado.equals("ON") == true) {
            this.dispositivos.get(div).add(new SmartTv(nrd,cf,ci,true,consumo,c,b,v,t));
        } else {
            this.dispositivos.get(div).add(new SmartTv(nrd,cf,ci,false,consumo,c,b,v,t));
        }
        this.nrd++;                
    }

    /**
    * Método que adiciona a House um SmartVacuum
     */
    public void addSmartVacuum(int cf, float ci, String estado, float consumo, int pd,int pa, int pm, String div) {
        if(this.dispositivos.containsKey(div) == false) this.dispositivos.put(div,new HashSet<SmartDevice>());

        if(estado.equals("on") == true || estado.equals("On") == true || estado.equals("ON") == true) {
            this.dispositivos.get(div).add(new SmartVacuum(nrd,cf,ci,true,consumo,pd,pa,pm));
        } else {
            this.dispositivos.get(div).add(new SmartVacuum(nrd,cf,ci,false,consumo,pd,pa,pm));
        }
        this.nrd++;  
    }

    /**
    * Método que adiciona a House um SmartAc
     */
    public void addSmartAc(int cf, float ci, String estado, float consumo, float t,String m, String div) {
        if(this.dispositivos.containsKey(div) == false) this.dispositivos.put(div,new HashSet<SmartDevice>());

        if(estado.equals("on") == true || estado.equals("On") == true || estado.equals("ON") == true) {
            this.dispositivos.get(div).add(new SmartAc(nrd,cf,ci,true,consumo,t,m));
        } else {
            this.dispositivos.get(div).add(new SmartAc(nrd,cf,ci,false,consumo,t,m));
        }
        this.nrd++;
    }

    /**
    * Método liga todos os dispositivos da House
     */
    public void turnAllOn() {
        for (HashMap.Entry<String,Set<SmartDevice>> entry : this.dispositivos.entrySet()) {
            for(SmartDevice s: entry.getValue()) {
                s.turnOn();
            }
        }
    }

    /**
    * Método desliga todos os dispositivos da House
     */
    public void turnAllOff() {
        for (HashMap.Entry<String,Set<SmartDevice>> entry : this.dispositivos.entrySet()) {
            for(SmartDevice s: entry.getValue()) {
                s.turnOff();
            }
        }
    }
    
    /**
    * Método liga um dispositivo da House
     */
    public void turnOneOn(int idd) {
        for (HashMap.Entry<String,Set<SmartDevice>> entry : this.dispositivos.entrySet()) {
            for(SmartDevice s: entry.getValue()) {
                if(s.getId() == idd) {
                    s.turnOn();
                }
            }
        }
    }

    /**
    * Método desliga um dispositivo da House
     */
    public void turnOneOff(int idd) {
        for (HashMap.Entry<String,Set<SmartDevice>> entry : this.dispositivos.entrySet()) {
            for(SmartDevice s: entry.getValue()) {
                if(s.getId() == idd) {
                    s.turnOff();
                }
            }
        }
    }

    /**
    * Método que calculcula um consumo de um dispositivo da House
     */
    public float calcConsumoDispositivo(int idd, LocalDate data_antiga, LocalDate data_atual) {
        for (HashMap.Entry<String,Set<SmartDevice>> entry : this.dispositivos.entrySet()) {
            for(SmartDevice s: entry.getValue()) {
                if(s.getId() == idd) {
                    return s.calcConsumo(data_atual,data_antiga);
                }
            }
        }
        return 0;
    }

    /**
     * Método que devolve a representação em String da House
     * para guardar num ficheiro de texto
     */
    public Object toStringLog() {
        StringBuilder sb = new StringBuilder();
        sb.append("Casa:").append(this.nome);
        sb.append(",").append(this.nif).append(",").append(this.fornecedor.getNome()).append("\n");
        for (HashMap.Entry<String,Set<SmartDevice>> entry : this.dispositivos.entrySet()) {
            sb.append("Divisao:");
            sb.append(entry.getKey().toString()).append("\n");
            for(SmartDevice s: entry.getValue()) {
                sb.append(s.toStringLog()).append("\n");
            }
        }
        return sb.toString();
    }

    /**
    * Método que calcula o consuma da House
     */
    public float calcConsumoCasa(LocalDate data_antiga, LocalDate data_atual) {
        float i = 0;
        for (HashMap.Entry<String,Set<SmartDevice>> entry : this.dispositivos.entrySet()) {
            for(SmartDevice s: entry.getValue()) {
                i+= s.calcConsumo(data_antiga,data_atual);
            }
        }
        return i;
    }
}
