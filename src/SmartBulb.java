import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Escreva uma descrição da classe SmartBulb aqui.
 * 
 * @author (Grupo 12) 
 */

public class SmartBulb extends SmartDevice {
    
    //Constantes
    public static final int WARM = 1;
    public static final int NEUTRAL = 0;
    public static final int COLD = -1;
    
    //Variáveis de instância
    private int tonalidade;
    private int tamanho;
    private float consumo_fixo;
    
    /**
     * Construtores da classe SmartBulb
     * Declaração de contrutores por omissão(vazio), parametrizado e de cópia
     */
    
    /**
     * Construtor por omissão
     */
    public SmartBulb() {
        super();
        this.tonalidade = NEUTRAL;
        this.tamanho = 0;
        this.consumo_fixo = 0;
    }

    /**
     * Construtor parametrizado
     * Invocação do construtor da classe SmartDevice
     * @param tonalidade Tonalidade da SmartBulb
     * @param tamanho Tamanho da SmartBulb
     * @param consumo_fixo Consumo fixo da SmartBulb
     */
    public SmartBulb(int id, int codigo_fabricante, float custo_instalacao, boolean estado, float consumo,
            int tonalidade, int tamanho, float consumo_fixo) {
        super(id, codigo_fabricante, custo_instalacao, estado, consumo);
        this.tonalidade = tonalidade;
        this.tamanho = tamanho;
        this.consumo_fixo = consumo_fixo;
    }
    
    /**
     * Construtor de cópia
     * Aceita como parâmetro outro SmartBulb e utiliza os métodos 
     * de acesso aos valores das variáveis de instância
     */
    public SmartBulb(SmartBulb um) {
        super(um.getId(),um.getCodigo_fabricante(),um.getCusto_instalacao(),um.getEstado(),um.getConsumo());
        this.tonalidade = um.getTonalidade();
        this.tamanho = um.getTamanho();
        this.consumo_fixo = um.getConsumo_fixo();
    }
    
    /**
     * Métodos de instância
     */
    /**
     * Devolve o valor da tonalidade da SmartBulb
     * 
     * @return valor da tonalidade da SmartBulb
     */
    public int getTonalidade() {
        return this.tonalidade;
    }
    
    /**
     * Devolve o valor do tamanho da SmartBulb
     * 
     * @return valor do tamanho da SmartBulb
     */
    public int getTamanho() {
        return this.tamanho;
    }
    
    /**
     * Devolve o valor do consumo fixo da SmartBulb
     * 
     * @return valor do consumo fixo da SmartBulb
     */
    public float getConsumo_fixo() {
        return this.consumo_fixo;
    }

    /**
     * Atualiza o valor da tonalidade da SmartBulb
     * 
     * @param tonalidade, Novo valor da tonalidade da SmartBulb
     */
    public void setTonalidade(int tonalidade) {
        this.tonalidade = tonalidade;
    }

    /**
     * Atualiza o valor do tamanho da SmartBulb
     * 
     * @param tamanho, Novo valor do tamanho da SmartBulb
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Atualiza o valor do consumo fixo da SmartBulb
     * 
     * @param consumo_fixo, Novo valor do consumo fixo da SmartBulb
     */
    public void setConsumo_fixo(int consumo_fixo) {
        this.consumo_fixo = consumo_fixo;
    }

    /**
     * Método de igualdade entre dois SmartBulb
     * 
     * @param o SmartBulb que é comparado com o recetor
     * @return boolean True ou False
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o==null) || (this.getClass() != o.getClass() )) return false;
        SmartBulb n = (SmartBulb) o;
        return (super.equals(n) && this.tonalidade == n.getTonalidade() && this.tamanho == n.getTamanho()
                && this.consumo_fixo == n.getConsumo_fixo());
    }

    /**
     * Método que devolve a representação em String do SmartBulb
     * 
     * @return String com a informação da SmartBulb
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).insert(12," SmartBulb");
        sb.append("\nTonalidade: ").append(this.tonalidade);
        sb.append("\nTamanho: ").append(this.tamanho);
        sb.append("\nConsumo Fixo: ").append(this.consumo_fixo);
        return sb.toString();
    }

    /**
     * Método que faz uma cópia do objeto recetor da mensagem
     * Para tal invoca o construtor de cópia
     * 
     * @return objeto clone do objeto que recebe a mensagem
     */
    public SmartBulb clone() {
        return new SmartBulb(this);
    }

    /**
     * Calcula o consumo do dispositivo
     */
    public float calcConsumo(LocalDate data_atual, LocalDate data_antiga) {
        float days = ChronoUnit.DAYS.between(data_antiga, data_atual);
        if(this.getEstado() == true)
            return (float) ((this.getConsumo_fixo() - this.getTonalidade()) * 0.02 * days);
        else {
            return 0;
        }
    }

    /**
     * Método que devolve a representação em String do SmartBulb
     * para guardar num ficheiro de texto
     */
    public String toStringLog() {
        StringBuilder sb = new StringBuilder();
        sb.append("SmartBulb:").append(this.tonalidade);
        sb.append(",").append(this.tamanho);
        sb.append(",").append(this.consumo_fixo);
        return sb.toString();
    }
}