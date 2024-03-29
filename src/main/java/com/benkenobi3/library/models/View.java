package com.benkenobi3.library.models;

public final class View {
    public interface LIBRARY_VIEW {}
    public interface BOOK_VIEW extends LIBRARY_VIEW{}
    public interface CATEGORY_VIEW extends LIBRARY_VIEW{}
    public interface AUTHOR_VIEW extends LIBRARY_VIEW{}
    public interface PUBLISHER_VIEW extends LIBRARY_VIEW{}
    public interface ID_VIEW {}
    public interface IGNORE {}
}
