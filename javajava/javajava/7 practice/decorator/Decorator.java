package decorator;

interface Text {
    String display();
}


class PlainText implements Text {
    private String content;

    public PlainText(String content) {
        this.content = content;
    }

    public String display() {
        return content;
    }
}

abstract class TextDecorator implements Text {
    protected Text decoratedText;

    public TextDecorator(Text decoratedText) {
        this.decoratedText = decoratedText;
    }

    public String display() {
        return decoratedText.display();
    }
}

class BoldDecorator extends TextDecorator {
    public BoldDecorator(Text decoratedText) {
        super(decoratedText);
    }

    public String display() {
        return "<bold>" + super.display() + "</bold>";
    }
}

class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(Text decoratedText) {
        super(decoratedText);
    }

    public String display() {
        return "<i>" + super.display() + "</i>";
    }
}

class UnderlineDecorator extends TextDecorator {
    public UnderlineDecorator(Text decoratedText) {
        super(decoratedText);
    }

    public String display() {
        return "<underline>" + super.display() + "</underline>";
    }
}
