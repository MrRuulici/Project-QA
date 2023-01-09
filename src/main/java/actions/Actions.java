package actions;

public class Actions {

    protected final WaitStrategy wait = new WaitStrategy();
    protected final MouseActions mouseActions = new MouseActions();
    protected final KeyboardActions keyboardActions = new KeyboardActions();
    protected final BrowserActions browserActions = new BrowserActions();
}
