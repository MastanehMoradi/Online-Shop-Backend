package com.example.shop_store_back.service;

import com.example.shop_store_back.data.Player;
import com.example.shop_store_back.data.Team;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PlayerService {
    private List<Player> players = new ArrayList<>();
    AtomicInteger id = new AtomicInteger(0);

    @PostConstruct
    private void init(){
        players.add(new Player(id.incrementAndGet(), "name1", Team.DC));
        players.add(new Player(id.incrementAndGet(), "name2", Team.CSK));
        players.add(new Player(id.incrementAndGet(), "name3", Team.MI));
        players.add(new Player(id.incrementAndGet(), "name4", Team.DC));
        players.add(new Player(id.incrementAndGet(), "name5", Team.CSK));
    }


    public List<Player> findAll(){
        return players;
    }

    public Optional<Player> findOne(Integer id){
        return players.stream().filter(player -> player.id()== id).findFirst();
    }

    public Player create(String name, Team team){
        Player player = new Player(id.incrementAndGet(),name, team);
        players.add(player);
        return player;
    }

    public  Player delete(Integer id){
        Player player = players.stream().filter(player1 -> player1.id()==id).findFirst().orElseThrow();
        players.remove(player);
        return player;
    }

    public Player update(Integer id, String name, Team team){
        Player updatePlayer = new Player(id, name, team);
        Optional<Player> optional = players.stream().filter(player1 -> player1.id()==id).findFirst();
        if(optional.isPresent()){
            Player player = optional.get();
            int index = players.indexOf(player);
            players.set(index, updatePlayer);
        }else {
            throw new RuntimeException();
        }
        return updatePlayer;
    }
}
