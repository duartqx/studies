package duartqx.com.github.viacep.records;

public record ViaCepRecord(
    String cep,
    String logradouro,
    String complemento,
    String bairro,
    String localidade,
    String uf,
    String ddd
) {}
