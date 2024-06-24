package com.dictionary.freeApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DictionaryResponse {
    private String word;
    private String phonetic;
    private List<Phonetic> phonetics;
    private String origin;
    private List<Meaning> meanings;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public List<Phonetic> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<Phonetic> phonetics) {
        this.phonetics = phonetics;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Phonetic {
        private String text;
        private String audio;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getAudio() {
            return audio;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Meaning {
        private String partOfSpeech;
        private List<Definition> definitions;

        public String getPartOfSpeech() {
            return partOfSpeech;
        }

        public void setPartOfSpeech(String partOfSpeech) {
            this.partOfSpeech = partOfSpeech;
        }

        public List<Definition> getDefinitions() {
            return definitions;
        }

        public void setDefinitions(List<Definition> definitions) {
            this.definitions = definitions;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Definition {
            private String definition;
            private String example;
            private List<String> synonyms;
            private List<String> antonyms;

            public String getDefinition() {
                return definition;
            }

            public void setDefinition(String definition) {
                this.definition = definition;
            }

            public String getExample() {
                return example;
            }

            public void setExample(String example) {
                this.example = example;
            }

            public List<String> getSynonyms() {
                return synonyms;
            }

            public void setSynonyms(List<String> synonyms) {
                this.synonyms = synonyms;
            }

            public List<String> getAntonyms() {
                return antonyms;
            }

            public void setAntonyms(List<String> antonyms) {
                this.antonyms = antonyms;
            }
        }
    }
}
