package com.nagra.microservice.controller;

import java.time.LocalDateTime;
import java.util.List;

public class CharacterApiResponse {
    private int count;
    private String next;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    private String prev;

    private List<CharacterResult> results;

    public List<CharacterResult> getResults() {
        return results;
    }

    public void setResults(List<CharacterResult> results) {
        this.results = results;
    }
    // getters and setters

    public static class CharacterResult {
        private int id;
        private String name;
        private String status;
        private String species;
        private String type;
        private String gender;
        private Location location;
        private String image;
        private List<String> episode;
        private String url;
        private LocalDateTime created;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setSpecies(String species) {
            this.species = species;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public List<String> getEpisode() {
            return episode;
        }

        public void setEpisode(List<String> episode) {
            this.episode = episode;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public LocalDateTime getCreated() {
            return created;
        }

        public void setCreated(LocalDateTime created) {
            this.created = created;
        }

        public Character toCharacter() {
            Character character = new Character();
            character.setId(this.getId());
            character.setName(this.getName());
            character.setImage(this.getImage());
            return character;
        }

        private String getGender() {
            return this.gender;
        }

        private String getSpecies() {
            return this.species;
        }

        private String getStatus() {
            return this.status;
        }

        private String getName() {
            return this.name;
        }
    }


    public static class Location {
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}

