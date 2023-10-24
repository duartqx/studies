package duartqx.com.github.viacep.service;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import duartqx.com.github.viacep.exceptions.InvalidCepException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepService<T> {
    private final String singleCepTemplate = "https://viacep.com.br/ws/%s/json/";
    private Class<T> outputClass;
    private HttpClient client;

    private Gson gson;

    public ViaCepService(Class<T> outputClass) {
        this.outputClass = outputClass;
        this.client = HttpClient.newBuilder().build();
        this.gson = new Gson();
    }

    public Object getSingle(String cep) throws
        InvalidCepException,
        IOException,
        InterruptedException,
        JsonSyntaxException
    {
        URI uri;

        try {
            uri = new URI(String.format(this.singleCepTemplate, cep));
        } catch (URISyntaxException e) {
            throw new InvalidCepException(e.getMessage());
        }

        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

        HttpResponse<String> response = this.client.send(
                request, HttpResponse.BodyHandlers.ofString()
        );

       return   gson.fromJson(response.body(), this.outputClass);
    }
}
