package com.nagra.microservice.controller;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldController
{
   private final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
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


//    @Operation(summary = "Get user by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "User found"),
//            @ApiResponse(responseCode = "404", description = "User not found")
//    })
@GetMapping("api/v1/characters/")
public List<Character> getCharacter(@RequestParam String name) {

    List<Character> answer = new ArrayList<>();
    String url = "https://rickandmortyapi.com/api/character/?name="+ name;
   // logger.info("Fetching character(s) from: {}", url);
    ResponseEntity<CharacterApiResponse> response = restTemplate.getForEntity(url, CharacterApiResponse.class);
    CharacterApiResponse characterApiResponse = response.getBody();

    if (characterApiResponse.getResults() != null && !characterApiResponse.getResults().isEmpty()) {
        characterApiResponse.getResults().forEach(characterResult -> {
            answer.add(characterResult.toCharacter());
        });
        logger.info("Character(s) retrieved successfully.  Name: {}",  name);
        logger.info(" Count: {}",answer.size());
        return answer;
    } else {
        logger.warn("No character(s) found for name: {}",name);
        logger.info("Character(s) not found .  Name: {}",  name);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found");

    }
}
//    @Bean
//    public CommonsRequestLoggingFilter requestLoggingFilter() {
//        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
//        loggingFilter.setIncludeClientInfo(true);
//        loggingFilter.setIncludeQueryString(true);
//        loggingFilter.setIncludePayload(true);
//        loggingFilter.setIncludeHeaders(false);
//        return loggingFilter;
//    }



}