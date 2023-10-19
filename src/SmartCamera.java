import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Escreva uma descrição da classe SmartCamera aqui.
 * 
 * @author (Grupo 12)
 */
public class SmartCamera extends SmartDevice {
    
    //Variáveis de instância
    private int resolucao;
    private int tamanho_ficheiro;
    
    /**
     * Construtores da classe SmartCamera
     * Declaração de construtores por omissão (vazio), parametrizado e de cópia
    */
    public SmartCamera() {
        super();
        this.resolucao = 0;
        this.tamanho_ficheiro = 0;
    }

    /**
     * Construtor parametrizado
     * Evocação do construtor da classe SmartCamera
     * @param resolucao resuloção da imagem da SmartCamera
     * @param tamanho_ficheiro tamanho do ficheiro da SmartCamera
     */
    public SmartCamera(int id, int codigo_fabricante, float custo_instalacao, boolean estado, float consumo,
            int resolucao, int tamanho_ficheiro) {
        super(id, codigo_fabricante, custo_instalacao, estado, consumo);
        this.resolucao = resolucao;
        this.tamanho_ficheiro = tamanho_ficheiro;
    }

    /**
     * Construtor de cópia
     * Aceita como parâmetro outra SmartCamera e utiliza os métodos 
     * de acesso aos valores das variáveis de instância
     */
    public SmartCamera(SmartCamera um) {
        super(um.getId(),um.getCodigo_fabricante(),um.getCusto_instalacao(),um.getEstado(),um.getConsumo());
        this.resolucao = um.getResolucao();
        this.tamanho_ficheiro = um.getTamanho_ficheiro();
    }

    /**
     * Métodos de instância
     */
    /**
     * Devolve o valor da resolucao do SmartCamera
     * 
     * @return valor da resolucao do SmartCamera
     */
    public int getResolucao() {
        return resolucao;
    }

    /**
     * Devolve o tamanho do ficheiro da SmartCamera
     * 
     * @return tamanho do ficheiro da SmartCamera
     */
    public int getTamanho_ficheiro() {
        return tamanho_ficheiro;
    }

    /**
     * Atualiza a resolução da SmartCamera
     *
     * @param resolucao Novo valor da resolução
     */
    public void setResolucao(int resolucao) {
        this.resolucao = resolucao;
    }

    /**
     * Atualiza o tamanho do ficeiro da SmartCamera
     *
     * @param tamanho_ficheiro Novo tamanho do ficeiro da SmartCamera
     */
    public void setTamanho_ficheiro(int tamanho_ficheiro) {
        this.tamanho_ficheiro = tamanho_ficheiro;
    }

    /**
     * Método de igualdade entre dois SmartCamera
     * 
     * @param o SmartCamera que é comparado com o recetor
     * @return boolean True ou False
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o==null) || (this.getClass() != o.getClass() )) return false;
        SmartCamera n = (SmartCamera) o;
        return (super.equals(n) && this.resolucao == n.getResolucao() && this.tamanho_ficheiro == n.getTamanho_ficheiro());
    }

    /**
     * Método que devolve a representação em String do SmartCamera
     * 
     * @return String com a informação do SmartCamera
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).insert(12," SmartCamera");
        sb.append("\nResolução: ").append(this.resolucao);
        sb.append("\nTamanho do ficheiro: ").append(this.tamanho_ficheiro);
        sb.append("bits.");
        return sb.toString();
    }

    /**
     * Método que faz uma cópia do objeto recetor da mensagem
     * Para tal invoca o construtor de cópia
     * 
     * @return objeto clone do objeto que recebe a mensagem
     */
    public SmartCamera clone() {
        return new SmartCamera(this);
    }

    /**
     * Calcula o consumo do dispositivo
     */
    public float calcConsumo(LocalDate data_atual, LocalDate data_antiga) {
        float days = ChronoUnit.DAYS.between(data_antiga, data_atual);
        if(this.getEstado() == true)
            return (float) (this.getConsumo() * this.getTamanho_ficheiro() * this.getResolucao() * 0.0000001 * days);
        else {
            return 0;
        }
    }

    /**
     * Método que devolve a representação em String da SmartCamera
     * para guardar num ficheiro de texto
     */
    public String toStringLog() {
        StringBuilder sb = new StringBuilder();
        sb.append("SmartCamera:").append(this.resolucao);
        sb.append(",").append(this.tamanho_ficheiro);
        return sb.toString();
    }
}
