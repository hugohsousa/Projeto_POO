import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Escreva uma descrição da classe SmartSpeaker aqui.
 * 
 * @author (Grupo 12)
 */
public class SmartSpeaker extends SmartDevice {
    
    //Variáveis de instância
    private int volume;
    private String radio;
    private String marca;
    
    /**
     * Construtores da classe SmartSpeaker
     * Declaração de construtores por omissão (vazio), parametrizado e de cópia
    */
    public SmartSpeaker() {
        super();
        this.volume = 0;
        this.radio = "";
        this.marca = "";
    }
    
    /**
     * Construtor parametrizado
     * Evocação do construtor da classe SmartSpeaker
     * @param volume volume do SmartSpeaker
     * @param radio frequência do SmartSpeaker
     * @param marca marca do SmartSpeaker
     */
    public SmartSpeaker(int id, int codigo_fabricante, float custo_instalacao, boolean estado, float consumo,
            int volume, String radio, String marca) {
        super(id, codigo_fabricante, custo_instalacao, estado, consumo);
        this.volume = volume;
        this.radio = radio;
        this.marca = marca;
    }

    /**
     * Construtor de cópia
     * Aceita como parâmetro outro SmartSpeaker e utiliza os métodos 
     * de acesso aos valores das variáveis de instância
     */
    public SmartSpeaker(SmartSpeaker um) {
        super(um.getId(),um.getCodigo_fabricante(),um.getCusto_instalacao(),um.getEstado(),um.getConsumo());
        this.volume = um.getVolume();
        this.radio = um.getRadio();
        this.marca = um.getMarca();
    }

    /**
     * Métodos de instância
     */
    /**
     * Devolve o valor do volume do SmartSpeaker
     * 
     * @return valor do volume do SmartSpeaker
     */
    public int getVolume() {
        return this.volume;
    }

    /**
     * Devolve a estação em que está o SmartSpeaker
     * 
     * @return estação em que está o SmartSpeaker
     */
    public String getRadio() {
        return this.radio;
    }
    
    /**
     * Devolve a marca do SmartSpeaker
     * 
     * @return marca do SmartSpeaker
     */
    public String getMarca() {
        return this.marca;
    }

    /**
     * Atualiza a volume do SmartSpeaker
     *
     * @param volume Novo valor do volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Atualiza a frequência do SmartSpeaker
     *
     * @param modo Nova frequência do SmartSpeaker
     */
    public void setRadio(String radio) {
        this.radio = radio;
    }

    /**
     * Atualiza a frequência do SmartSpeaker
     *
     * @param modo Nova frequência do SmartSpeaker
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * Método de igualdade entre dois SmartSpeaker
     * 
     * @param o SmartSpeaker que é comparado com o recetor
     * @return boolean True ou False
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o==null) || (this.getClass() != o.getClass() )) return false;
        SmartSpeaker n = (SmartSpeaker) o;
        return (super.equals(n) && this.volume == n.getVolume() && this.radio.equals(n.getRadio())
                && this.marca == n.getMarca());
    }

    /**
     * Método que devolve a representação em String do SmartSpeaker
     * 
     * @return String com a informação do SmartSpeaker
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).insert(12," SmartSpeaker");
        sb.append("\nVolume: ").append(this.volume);
        sb.append("\nRadio: ").append(this.radio);
        sb.append("\nMarca: ").append(this.marca);
        return sb.toString();
    }

    /**
     * Método que faz uma cópia do objeto recetor da mensagem
     * Para tal invoca o construtor de cópia
     * 
     * @return objeto clone do objeto que recebe a mensagem
     */
    public SmartSpeaker clone() {
        return new SmartSpeaker(this);
    }
    
    /**
     * Calcula o consumo do dispositivo
     */
    public float calcConsumo(LocalDate data_atual, LocalDate data_antiga) {
        float days = ChronoUnit.DAYS.between(data_antiga, data_atual);
        if(this.getEstado() == true)
            return (float) (this.getConsumo() + this.getVolume() * 0.2 * days);
        else {
            return 0;
        }
    }
    
    /**
     * Método que devolve a representação em String do SmartSpeaker
     * para guardar num ficheiro de texto
     */
    public String toStringLog() {
        StringBuilder sb = new StringBuilder();
        sb.append("SmartSpeaker:").append(this.volume);
        sb.append(",").append(this.radio);
        sb.append(",").append(this.marca);
        return sb.toString();
    
    }
    
}
