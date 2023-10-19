import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Escreva uma descrição da classe SmartTv aqui.
 * 
 * @author (Grupo 12) 
 */
public class SmartTv extends SmartDevice {
    
    //Variáveis de instância
    private int canal;
    private int brilho;
    private int volume;
    private float tamanho;

    /**
     * Construtores da classe SmartTv
     * Declaração de construtores por omissão (vazio), parametrizado e de cópia
     */
    /**
     * Construtor por omissão
     */
    public SmartTv() {
        super();
        this.canal = 0;
        this.brilho = 0;
        this.volume = 0;
        this.tamanho = 0;
    }

    /**
     * Construtor parametrizado
     * Invocação do construtor da classe SmartDevice
     * @param canal Canal em que está a SmartTv
     * @param brilho Brilho em que está a SmartTv
     * @param volume Volume em que está a SmartTv
     * @param tamanho Tamanho da SmartTv
     */ 
    public SmartTv(int id, int codigo_fabricante, float custo_instalacao, boolean estado, float consumo, int canal,
            int brilho, int volume, float tamanho) {
        super(id, codigo_fabricante, custo_instalacao, estado, consumo);
        this.canal = canal;
        this.brilho = brilho;
        this.volume = volume;
        this.tamanho = tamanho;
    }

    /**
     * Construtor de cópia
     * Aceita como parâmetro outro SmartDevide e utiliza os métodos 
     * de acesso aos valores das variáveis de instância
     */
    public SmartTv(SmartTv um) {
        super(um.getId(),um.getCodigo_fabricante(),um.getCusto_instalacao(),um.getEstado(),um.getConsumo());
        this.canal = um.getCanal();
        this.brilho = um.getBrilho();
        this.volume = um.getVolume();
        this.tamanho = um.getTamanho();
    }

    /**
     * Métodos de instância
     */
    /**
     * Devolve o valor do canal em que está a SmartTv
     * 
     * @return valor do canal em que está a SmartTv
     */
    public int getCanal() {
        return this.canal;
    }

    /**
     * Devolve o valor do brilho em que está a SmartTv
     * 
     * @return valor do brilho em que está a SmartTv
     */
    public int getBrilho() {
        return this.brilho;
    }

    /**
     * Devolve o valor do volume em que está a SmartTv
     * 
     * @return valor do volume em que está a SmartTv
     */
    public int getVolume() {
        return this.volume;
    }

    /**
     * Devolve o valor do tamanho da SmartTv
     * 
     * @return valor do tamanho da SmartTv
     */
    public float getTamanho() {
        return this.tamanho;
    }

     /**
     * Atualiza o valor do canal em que está a SmartTv
     * 
     * @param canal Novo valor do canal em que está a SmartTv
     */
    public void setCanal(int canal) {
        this.canal = canal;
    }

     /**
     * Atualiza o valor do brilho em que está a SmartTv
     * 
     * @param brilho Novo valor do brilho em que está a SmartTv
     */
    public void setBrilho(int brilho) {
        this.brilho = brilho;
    }

     /**
     * Atualiza o valor do volume em que está a SmartTv
     * 
     * @param volume Novo valor do volume em que está a SmartTv
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

     /**
     * Atualiza o valor do tamanho da SmartTv
     * 
     * @param tamanho Novo valor do tamanho da SmartTv
     */
    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Método de igualdade entre dois SmartTV
     * 
     * @param o SmartTv que é comparado com o recetor
     * @return boolean True ou False
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o==null) || (this.getClass() != o.getClass() )) return false;
        SmartTv n = (SmartTv) o;
        return (super.equals(n) && this.canal == n.getCanal() && this.brilho == n.getBrilho()
                && this.volume == n.getVolume() && this.tamanho == n.getTamanho());
    }

    /**
     * Método que devolve a representação em String do SmartTv
     * 
     * @return String com a informação do SmartTv
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).insert(12," SmartTv");
        sb.append("\nCanal: ").append(this.canal);
        sb.append("\nBrilho: ").append(this.brilho);
        sb.append("\nVolume: ").append(this.volume);
        sb.append("\ntamanho: ").append(this.tamanho);
        return sb.toString();
    }

    /**
     * Método que faz uma cópia do objeto recetor da mensagem
     * Para tal invoca o construtor de cópia
     * 
     * @return objeto clone do objeto que recebe a mensagem
     */
    public SmartTv clone() {
        return new SmartTv(this);
    }
    
    /**
     * Calcula o consumo do dispositivo
     */
    public float calcConsumo(LocalDate data_atual, LocalDate data_antiga) {
        float days = ChronoUnit.DAYS.between(data_antiga, data_atual);
        if(this.getEstado() == true)
            return (float) (this.getConsumo() + this.getTamanho() + this.getBrilho() + this.getVolume() * 0.003 * days);
        else {
            return 0;
        }
    }

    /**
     * Método que devolve a representação em String do SmartDevice
     * para guardar num ficheiro de texto
     */
    public String toStringLog() {
        StringBuilder sb = new StringBuilder();
        sb.append("SmartTv:").append(this.canal);
        sb.append(",").append(this.brilho);
        sb.append(",").append(this.volume);
        sb.append(",").append(this.tamanho);
        return sb.toString();
    }
}
