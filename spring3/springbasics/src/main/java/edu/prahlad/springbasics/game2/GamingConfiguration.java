package edu.prahlad.springbasics.game2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GamingConfiguration {

    @Bean
    @Primary
    public GameConsole game(){
        var game = new Mario();
        return game;
    }


    @Bean
    @Qualifier("PacMan")
    public GameConsole game2(){
        return new PacMan();
    }

    @Bean
    @Primary
    public GameRunner gameRunner(GameConsole game){
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }

    @Bean
    public GameRunner gameRunner2(@Qualifier("PacMan") GameConsole game){
        System.out.println(game);
        return new GameRunner(game);
    }

}
