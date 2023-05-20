package blog.rasvi.io.vertx4future;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;

public class Vertx4future {

    public Future<JsonObject> fetchJsonData(WebClient client, String url) {
        Future<HttpResponse<Buffer>> future = client.getAbs(url).send();
        return future.map(res -> res.bodyAsJsonObject());
    }

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        try {
            WebClient client = WebClient.create(vertx);
            
        } finally {
            vertx.close();
        }
    }
}
