package org.example.addressbookapp;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class EtalabResponse {

    @JsonProperty("type")
    private String type;

    @JsonProperty("features")
    private List<Feature> features;

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class Feature {
        @JsonProperty("type")
        private String type;

        @JsonProperty("geometry")
        private Geometry geometry;

        @JsonProperty("properties")
        private Properties properties;

        // Getters et Setters

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Geometry getGeometry() {
            return geometry;
        }

        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }

        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }
    }

    public static class Geometry {
        @JsonProperty("type")
        private String type;

        @JsonProperty("coordinates")
        private List<Double> coordinates;

        public List<Double> getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(List<Double> coordinates) {
            this.coordinates = coordinates;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class Properties {
        @JsonProperty("label")
        private String label;

        @JsonProperty("city")
        private String city;

        @JsonProperty("postcode")
        private String postcode;

        @JsonProperty("district")
        private String district;

        @JsonProperty("street")
        private String street;

        @JsonProperty("context")
        private String context;

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }


        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }
    }
}
