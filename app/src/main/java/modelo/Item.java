package modelo;

public class Item {
    private Long codigo;
    private String ImageUrl;
    private String nome;
    private String descricao;
    private String vistoPorUltimo;
    private boolean status;

    public Item(String nome, String descricao, boolean status) {
       // ImageUrl = imageUrl;
        this.nome = nome;
        this.descricao = descricao;
       // this.vistoPorUltimo = vistoPorUltimo;
        this.status = status;
    }

    public Long getCodigo(){
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getVistoPorUltimo() {
        return vistoPorUltimo;
    }

    public void setVistoPorUltimo(String vistoPorUltimo) {
        this.vistoPorUltimo = vistoPorUltimo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
