import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Escreva uma descrição da classe SmartAc aqui.
 * 
 * @author (Grupo 12) 
 */
public class SmartAc extends SmartDevice {
    
    //Variáveis de instância
    private float temperatura;
    private String modo;

    /**
     * Construtores da classe SmartAc
     * Declaração de construtores por omissão (vazio), parametrizado e de cópia
    */
    public SmartAc() {
        super();
        this.temperatura = 0;
        this.modo = "";
    }

    /**
     * Construtor parametrizado
     * Evocação do construtor da classe SmartAc
     * @param temperatura temperatura do SmartAc
     * @param modo modo do SmartAc
     */
    public SmartAc(int id, int codigo_fabricante, float custo_instalacao, boolean estado, float consumo,
        float temperatura, String modo) {
        super(id, codigo_fabricante, custo_instalacao, estado, consumo);
        this.temperatura = temperatura;
        this.modo = modo;
    }

    /**
     * Construtor de cópia
     * Aceita como parâmetro outro SmartAc e utiliza os métodos 
     * de acesso aos valores das variáveis de instância
     */
    public SmartAc(SmartAc um) {
        super(um.getId(),um.getCodigo_fabricante(),um.getCusto_instalacao(),um.getEstado(),um.getConsumo());
        this.temperatura = um.getTemperatura();
        this.modo = um.getModo();
    }

    /**
     * Métodos de instância
     */
    /**
     * Devolve o valor da temperatura do SmartAc
     * 
     * @return valor da temperatura do SmartAc
     */
    public float getTemperatura() {
        return temperatura;
    }

    /**
     * Devolve o modo em que está o SmartAc
     * 
     * @return modo em que está o SmartAc
     */
    public String getModo() {
        return modo;
    }
    
    /**
     * Atualiza a temperatura do SmartAc
     *
     * @param temperatura Novo valor da temperatura
     */
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * Atualiza o modo do SmartAc
     *
     * @param modo Novo modo do SmartAc
     */
    public void setModo(String modo) {
        this.modo = modo;
    }

    /**
     * Método de igualdade entre dois SmartAc
     * 
     * @param o SmartAc que é comparado com o recetor
     * @return boolean True ou False
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o==null) || (this.getClass() != o.getClass() )) return false;
        SmartAc n = (SmartAc) o;
        return (super.equals(n) && this.temperatura == n.getTemperatura() && this.modo.equals(n.getModo()));
    }

    /**
     * Método que devolve a representação em String do SmartAc
     * 
     * @return String com a informação do SmartAc
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).insert(12," SmartAc");
        sb.append("\nTemperatura: ").append(this.temperatura);
        sb.append("\nModo: ").append(this.modo);
        return sb.toString();
    }

    /**
     * Método que faz uma cópia do objeto recetor da mensagem
     * Para tal invoca o construtor de cópia
     * 
     * @return objeto clone do objeto que recebe a mensagem
     */
    public SmartAc clone() {
        return new SmartAc(this);
    }

    /**
     * Calcula o consumo do dispositivo
     */
    public float calcConsumo(LocalDate data_atual, LocalDate data_antiga) {
        float days = ChronoUnit.DAYS.between(data_antiga, data_atual);
        if(this.getEstado() == true)
            return (float) (this.getConsumo() + this.getTemperatura() * 0.03 * days);
        else {
            return 0;
        }
    }

    /**
     * Método que devolve a representação em String do SmartAc
     * para guardar num ficheiro de texto
     */
    public String toStringLog() {
        StringBuilder sb = new StringBuilder();
        sb.append("SmartAc:").append(this.temperatura);
        sb.append(",").append(this.modo);
        return sb.toString();
    }
    
}
