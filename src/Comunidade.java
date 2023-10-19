import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Escreva uma descrição da classe Comunidade aqui.
 * 
 * @author (Grupo 12) 
 */
public class Comunidade {
    
    //Variáveis de instância
    private int id_regiao;
    private int nrc;
    private Map<Integer,House> casas = new HashMap<Integer,House>();

    /**
     * Construtores da classe Comunidade
     * Declaração de construtores por omissão (vazio), parametrizado e de cópia
    */
    public Comunidade() {
        this.id_regiao = 0;
        this.nrc = 0;
        this.casas = new HashMap<Integer,House>();
    }

    /**
     * Construtor parametrizado
     * Evocação do construtor da classe Comunidade
     * @param id_regiao identidade da regiao da Comunidade
     * @param casas casas da Comunidade
     * @param nrc numero de casas da Comunidade
     */
    public Comunidade(int id_regiao, Map<Integer,House> casas) {
        this.id_regiao = id_regiao;
        Map<Integer,House> n = new HashMap<Integer,House>();
        n = casas.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        this.casas = n;
        this.nrc += casas.keySet().size();
    }

    /**
     * Construtor de cópia
     * Aceita como parâmetro outra Comunidade e utiliza os métodos 
     * de acesso aos valores das variáveis de instância
     */
    public Comunidade(Comunidade um) {
        this.id_regiao = um.getId_regiao();
        this.casas = um.getCasas();
        this.nrc = um.getCasas().keySet().size();
    }

    /**
     * Métodos de instância
     */
    /**
     * Devolve o Identidade da Comunidade
     * 
     * @return Identidade da Comunidade
     */
    public int getId_regiao() {
        return this.id_regiao;
    }

    /**
     * Devolve as casas da Comunidade
     * 
     * @return Casas da Comunidade
     */
    public Map<Integer, House> getCasas() {
        Map<Integer,House> n = new HashMap<Integer,House>();
        n = this.casas.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        return n;
    }

    /**
     * Atualiza identidade da regiao da Comunidade
     *
     * @param id_regiao Nova identidade da regiao da Comunidade
     */
    public void setId_regiao(int id_regiao) {
        this.id_regiao = id_regiao;
    }

    /**
     * Atualiza casas da Comunidade
     *
     * @param casas Novas casas da Comunidade
     */
    public void setCasas(Map<Integer, House> casas) {
        Map<Integer,House> n = new HashMap<Integer,House>();
        n = casas.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        this.casas = n;
    }

    /**
     * Método de igualdade entre duas Comunidade
     * 
     * @param o Comunidade que é comparado com o recetor
     * @return boolean True ou False
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o==null) || (this.getClass() != o.getClass() )) return false;
        Comunidade n = (Comunidade) o;
        return (this.id_regiao == n.getId_regiao() && this.casas.equals(n.getCasas()));
    }

    /**
     * Método que devolve a representação em String da Comunidade
     * 
     * @return String com a informação da Comunidade
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comunidade: ").append(this.id_regiao);
        sb.append("\nLista de casas:\n");
        for (HashMap.Entry<Integer,House> entry : this.casas.entrySet()) {
            sb.append(entry.getValue().toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * Método que faz uma cópia do objeto recetor da mensagem
     * Para tal invoca o construtor de cópia
     * 
     * @return objeto clone do objeto que recebe a mensagem
     */
    public Comunidade clone() {
        return new Comunidade(this);
    }

    /**
     * Método que adicona uma casa a uma comunidade
     */
    public void addHouse(String nome, int nif, Supplier fornecedor) {
        this.nrc++;
        Map<String,Set<SmartDevice>> n = new HashMap<String,Set<SmartDevice>>();
        this.casas.put(this.nrc,new House(nome,nif,fornecedor,n));
    }

    /**
     * Método que liga todos os dispositivos de uma das casas da Comudidade
     */
    public void turnAllOn(int idcasa) {
        casas.get(idcasa).turnAllOn();
    }
    /**
     * Método que desliga todos os dispositivos de uma das casas da Comudidade
     */
    public void turnAllOff(int idcasa) {
        casas.get(idcasa).turnAllOff();
    }

    /**
     * Método que liga um dispositivo de uma das casas da Comudidade
     */
    public void turnOneOn(int idcasa, int idd) {
        casas.get(idcasa).turnOneOn(idd);
    }

    /**
     * Método que desliga um dispositivo de uma das casas da Comudidade
     */
    public void turnOneOff(int idcasa, int idd) {
        casas.get(idcasa).turnOneOff(idd);
    }

    /**
     * Método que calcula o consumo de um dispositivo em KW/h de uma casa da Comudidade
     */
    public float calcConsumoDispositivo(int idcasa, int idd, LocalDate data_antiga, LocalDate data_atual) {
        return (float) (casas.get(idcasa).calcConsumoDispositivo(idd,data_antiga,data_atual) * 0.001);
    }

    /**
     * Método que devolve a representação em String da Comudidade
     * para guardar num ficheiro de texto
     */
    public Object toStringLog() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comunidade: ").append(this.id_regiao).append("\n");
        for (HashMap.Entry<Integer,House> entry : this.casas.entrySet()) {
            sb.append(entry.getValue().toStringLog());
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * Método que calcula o consumo de um dispositivo em Euros de uma casa da Comudidade
     */
    public float calcConsumoDispositivoEur(int idcasa, int idd, LocalDate data_antiga, LocalDate data_atual) {
        return (float) (casas.get(idcasa).calcConsumoDispositivo(idd,data_antiga,data_atual) * casas.get(idcasa).getFornecedor().getCusto() * 0.001);
    }

    /**
     * Método que calcula o consumo de uma casa em KW/h da Comudidade
     */
    public float calcConsumoCasa(int idcasa, LocalDate data_antiga, LocalDate data_atual) {
        return (float) (casas.get(idcasa).calcConsumoCasa(data_atual,data_antiga) * 0.001);
    }

    /**
     * Método que calcula o consumo de uma casa em Euros da Comudidade
     */
    public float calcConsumoCasaEur(int idcasa, LocalDate data_antiga, LocalDate data_atual) {
        return (float) (casas.get(idcasa).calcConsumoCasa(data_atual,data_antiga) * casas.get(idcasa).getFornecedor().getCusto() * 0.001);
    }
}
