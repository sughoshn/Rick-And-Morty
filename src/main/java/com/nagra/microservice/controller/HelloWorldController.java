package com.nagra.microservice.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldController
{
    private final String API_URL = "https://rickandmortyapi.com/api/character/";
    RestTemplate restTemplate = new RestTemplate();
    /*@GetMapping("/characters/{id}")
    public Character getCharacterByID(@PathVariable int id) {
        String url = API_URL + id;
        ResponseEntity<CharacterResponse> responseEntity = restTemplate.getForEntity(url, CharacterResponse.class);

        CharacterResponse characterResponse = responseEntity.getBody();

        Character character = new Character();
        character.setName(characterResponse.getName());
        character.setImage(characterResponse.getImage());

        return character;
    }*/


    @GetMapping("/characters/")
    public List<Character> getCharacter(@RequestParam String name) {
        List<Character> answer = new ArrayList<>();
        String url = "https://rickandmortyapi.com/api/character/?name="+ name;
        ResponseEntity<CharacterApiResponse> response = restTemplate.getForEntity(url, CharacterApiResponse.class);
        CharacterApiResponse characterApiResponse = response.getBody();
        if (characterApiResponse.getResults() != null && !characterApiResponse.getResults().isEmpty()) {
            characterApiResponse.getResults().forEach(characterResult -> {
                answer.add(characterResult.toCharacter());
            });
            return answer;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found");
        }
    }

}