import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Escreva uma descrição da classe SmartVacuum aqui.
 * 
 * @author (Grupo 12)
 */
public class SmartVacuum extends SmartDevice {
    
    //Variáveis de instância
    private int peso_dispositivo;
    private int peso_atual;
    private int peso_maximo;

    /**
     * Construtores da classe SmartVacuum
     * Declaração de construtores por omissão (vazio), parametrizado e de cópia
    */
    public SmartVacuum() {
        super();
        this.peso_dispositivo = 0;
        this.peso_atual = 0;
        this.peso_maximo = 0;
    }

    /**
     * Construtor parametrizado
     * Evocação do construtor da classe SmartVacuum
     * @param peso_dispositivo peso base do SmartVacuum
     * @param peso_atual peso atual do SmartVacuum
     * @param peso_maximo peso maximo do SmartVacuum
     */
    public SmartVacuum(int id, int codigo_fabricante, float custo_instalacao, boolean estado, float consumo,
            int peso_dispositivo, int peso_atual, int peso_maximo) {
        super(id, codigo_fabricante, custo_instalacao, estado, consumo);
        this.peso_dispositivo = peso_dispositivo;
        this.peso_atual = peso_atual;
        this.peso_maximo = peso_maximo;
    }

    /**
     * Construtor de cópia
     * Aceita como parâmetro outro SmartVacuum e utiliza os métodos 
     * de acesso aos valores das variáveis de instância
     */
    public SmartVacuum(SmartVacuum um) {
        super(um.getId(),um.getCodigo_fabricante(),um.getCusto_instalacao(),um.getEstado(),um.getConsumo());
        this.peso_dispositivo = um.getPeso_dispositivo();
        this.peso_atual = um.getPeso_atual();
        this.peso_maximo = um.getPeso_maximo();
    }

    /**
     * Métodos de instância
     */
    /**
     * Devolve o peso base do SmartVacuum
     * 
     * @return valor do peso base do SmartVacuum
     */
    public int getPeso_dispositivo() {
        return this.peso_dispositivo;
    }
    
    /**
     * Devolve o peso atual do SmartVacuum
     * 
     * @return valor do peso atual do SmartVacuum
     */
    public int getPeso_atual() {
        return this.peso_atual;
    }

    /**
     * Devolve o peso maximo do SmartVacuum
     * 
     * @return valor do peso maximo do SmartVacuum
     */
    public int getPeso_maximo() {
        return this.peso_maximo;
    }

    /**
     * Atualiza peso base do SmartVacuum
     *
     * @param peso_dispositivo Novo valor do peso base do SmartVacuum
     */
    public void setPeso_dispositivo(int peso_dispositivo) {
        this.peso_dispositivo = peso_dispositivo;
    }

    /**
     * Atualiza peso atual do SmartVacuum
     *
     * @param peso_atual Novo valor do peso atual do SmartVacuum
     */
    public void setPeso_atual(int peso_atual) {
        this.peso_atual = peso_atual;
    }

    /**
     * Atualiza peso maximo do SmartVacuum
     *
     * @param peso_maximo Novo valor do peso maximo do SmartVacuum
     */
    public void setPeso_maximo(int peso_maximo) {
        this.peso_maximo = peso_maximo;
    }

    /**
     * Método de igualdade entre dois SmartVacuum
     * 
     * @param o SmartVacuum que é comparado com o recetor
     * @return boolean True ou False
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o==null) || (this.getClass() != o.getClass() )) return false;
        SmartVacuum n = (SmartVacuum) o;
        return (super.equals(n) && this.peso_dispositivo == n.getPeso_dispositivo() 
                && this.peso_atual == n.getPeso_atual()
                && this.peso_maximo == n.getPeso_maximo());
    }

    /**
     * Método que devolve a representação em String do SmartVacuum
     * 
     * @return String com a informação do SmartVacuum
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).insert(12," SmartVacuum");
        sb.append("\nPeso do Dispositivo: ").append(this.peso_dispositivo);
        sb.append("\nPeso Atual: ").append(this.peso_atual);
        sb.append("\nPeso Máximo: ").append(this.peso_maximo);
        return sb.toString();
    }

    /**
     * Método que faz uma cópia do objeto recetor da mensagem
     * Para tal invoca o construtor de cópia
     * 
     * @return objeto clone do objeto que recebe a mensagem
     */
    public SmartVacuum clone() {
        return new SmartVacuum(this);
    }
    
    /**
     * Calcula o consumo do dispositivo
     */
    public float calcConsumo(LocalDate data_atual, LocalDate data_antiga) {
        float days = ChronoUnit.DAYS.between(data_antiga, data_atual);
        if(this.getEstado() == true)
            return (float) (this.getConsumo() + this.getPeso_atual() * 0.02 * days)/2;
        else {
            return 0;
        }
    }
    
    /**
     * Método que devolve a representação em String do SmartVacuum
     * para guardar num ficheiro de texto
     */
    public String toStringLog() {
        StringBuilder sb = new StringBuilder();
        sb.append("SmartVacuum:");
        sb.append(this.peso_dispositivo);
        sb.append(",").append(this.peso_atual);
        sb.append(",").append(this.peso_maximo);
        return sb.toString();
    }
}