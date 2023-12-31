package ahmedmaher.designpattern.creational;

public class AbstractFactory {
    public static void main(String[] args) {
        GUIClient guiClient1 = new GUIClient(new WindowsFactory());
        GUIClient guiClient2 = new GUIClient(new MacOSFactory());

        guiClient1.paint();
        guiClient2.paint();
    }
}

// Abstract Product
interface IButton {
    void click();
}

interface ICheckBox {
    void check();
}

// Concrete Abstract Products
class WindowsButton implements IButton {

    @Override
    public void click() {
        System.out.println("Windows Button clicked.");
    }
}

class WindowsCheckBox implements ICheckBox {

    @Override
    public void check() {
        System.out.println("Windows Checkbox checked.");
    }
}

class MacOSButton implements IButton {

    @Override
    public void click() {
        System.out.println("MacOS Button clicked.");
    }
}

class MacOSCheckBox implements ICheckBox {

    @Override
    public void check() {
        System.out.println("MacOS Checkbox checked.");
    }
}

// Abstract Factory

interface IAbstractFactory {
    IButton createButton();
    ICheckBox createCheckBox();
}

// Concrete Abstract Factory
class WindowsFactory implements IAbstractFactory {

    @Override
    public IButton createButton() {
        return new WindowsButton();
    }

    @Override
    public ICheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}

class MacOSFactory implements IAbstractFactory {

    @Override
    public IButton createButton() {
        return new MacOSButton();
    }

    @Override
    public ICheckBox createCheckBox() {
        return new MacOSCheckBox();
    }
}

// Client
class GUIClient {
    private IAbstractFactory factory;

    public GUIClient(IAbstractFactory factory) {
        this.factory = factory;
    }

    void paint() {
        IButton button = factory.createButton();
        ICheckBox checkBox = factory.createCheckBox();

        button.click();
        checkBox.check();

    }
}


