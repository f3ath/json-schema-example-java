package f3ath;

import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

class Example {
    public static void main(String[] args) throws IOException {

        try (InputStream inputStream = getResourceAsStream("create_request.schema.json")) {
            final var rawSchema = new JSONObject(new JSONTokener(inputStream));
            final var schema = SchemaLoader.load(rawSchema);
            schema.validate(new JSONObject(new JSONTokener(getResourceAsStream("valid.json"))));
            schema.validate(new JSONObject(new JSONTokener(getResourceAsStream("invalid.json"))));
        }
    }

    private static InputStream getResourceAsStream(final String resource) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
    }

}