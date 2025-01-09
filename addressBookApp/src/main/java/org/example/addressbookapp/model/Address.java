package org.example.addressbookapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.sql.Date;


    @Entity
    public class Address {
        @jakarta.persistence.Id
        @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Date creation;
        private String content;
        private String author;


        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
        public void setId(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public Date getCreation() {
            return creation;
        }

        public String getContent() {
            return content;
        }

        public void setCreation(Date creation) {
            this.creation = creation;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

