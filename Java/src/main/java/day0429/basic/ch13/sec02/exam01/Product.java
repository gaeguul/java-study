package day0429.basic.ch13.sec02.exam01;

public class Product<T, U> {
    private T kind;
    private U model;

    public T getKind() {
        return kind;
    }

    public void setKind(T kind) {
        this.kind = kind;
    }

    public U getModel() {
        return model;
    }

    public void setModel(U model) {
        this.model = model;
    }
}
