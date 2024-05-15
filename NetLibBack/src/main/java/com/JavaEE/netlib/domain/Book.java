    package com.JavaEE.netlib.domain;

    import jakarta.persistence.*;

    @Entity
    @Table(name="books")
    public class Book {
        @Id
        @SequenceGenerator(
                name = "bookSequence",
                sequenceName = "bookSequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "bookSequence"
        )
        private Long id;
        private String title;
        private String author;
        private String genre;
        private double price;
        @ManyToOne
        private Order order;


        public Book() {
        }

        public Book(Long id, String title, String author, String genre, double price) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.price = price;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

