import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientTest {

    @Test
    void testGetContents(){
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://cv.alexanderhopgood.com"))
                .build();

        HttpClient client = HttpClient.newBuilder()
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(System.out::println)
        .join();
    }

    @Test
    void testGetHeaders(){
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://cv.alexanderhopgood.com"))
                .build();

        HttpClient client = HttpClient.newBuilder()
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::headers)
                .thenAccept(System.out::println)
                .join();
    }

    @Test
    void testGetStatusCode(){
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://cv.alexanderhopgood.com"))
                .build();

        HttpClient client = HttpClient.newBuilder()
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::statusCode)
                .thenAccept(System.out::println)
                .join();
    }
}
