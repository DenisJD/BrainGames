package hexlet.code;

public class Cli {
    private final Engine engine;

    public Cli(Engine engine) {
        this.engine = engine;
    }

    public void greetings() {
        engine.greetUser();
    }
}
