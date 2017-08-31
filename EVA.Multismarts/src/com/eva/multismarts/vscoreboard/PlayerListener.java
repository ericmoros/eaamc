package com.eva.multismarts.vscoreboard;


import com.eva.multismarts.Main;
import com.eva.multismarts.Useful_methods;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import static org.bukkit.Bukkit.getServer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;


public class PlayerListener implements Listener {
   
    private final Main plugin;
    

    public PlayerListener(Main instance) {
        this.plugin = instance;
    }
 
       public static void setBoard(Player p) {
           
        //Objetos para un uso cómodo del código
        
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        
        Objective obj = board.registerNewObjective("aaa", "bbb");
        
        Economy econ = Main.getEconomy();
        
        double playermoney = econ.getBalance(p);
        
        int numberplayers = getServer().getOnlinePlayers().size();
        
        String nameuser = p.getName();

        String ts3 = ("ts3.serverhalfife.com");
            
        //Tipo de Scoreboard y su título.
        
        obj.setDisplayName(Useful_methods.Text_formatter("&l&6EVA.H-L"));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        
        //Resultados del marcador
               //Barra limitadora del título
        
                Score bar = obj.getScore(Useful_methods.Text_formatter("&4-------------------"));
        
               //Espacios
        
                Score space1 = obj.getScore(Useful_methods.Text_formatter("&4"));
                Score space2 = obj.getScore(Useful_methods.Text_formatter("&5"));
                Score space3 = obj.getScore(Useful_methods.Text_formatter("&6"));
                
               //Nombre de usuario
         
                 Score user = obj.getScore(Useful_methods.Text_formatter("&f» &4Usuario:"));
                 Score username = obj.getScore(Useful_methods.Text_formatter("&f» "+nameuser));
        
               //Número de jugadores conectados
         
                 Score players = obj.getScore(Useful_methods.Text_formatter("&f» &4Jugadores:"));
                 Score playersscore = obj.getScore(Useful_methods.Text_formatter("&f» "+numberplayers+" en línea."));
                 
               //Dinero del jugador
               
                 Score money = obj.getScore(Useful_methods.Text_formatter("&f» &4Dinero:"));
                 Score displaymoney = obj.getScore(Useful_methods.Text_formatter("&f» "+Useful_methods.Decimal_formatter.format(playermoney)+" créditos."));
                 
               //Dirección del servidor de TeamSpeak 3.
         
                Score teamspeak = obj.getScore(Useful_methods.Text_formatter("&f» &4TeamSpeak:"));
                Score teamspeaksv = obj.getScore(Useful_methods.Text_formatter("&f» "+ts3));
        
        
        //Orden de los marcadores
        
                bar.setScore(12);
                
                user.setScore(11);
                
                username.setScore(10);
                
                space1.setScore(9);
                
                players.setScore(8);
                
                playersscore.setScore(7);
                
                space2.setScore(6);
                
                money.setScore(5);
                
                displaymoney.setScore(4);
                
                space3.setScore(3);
                
                teamspeak.setScore(2);
                
                teamspeaksv.setScore(1);
        
       //Añadirle el scoreboard al jugador
        
        p.setScoreboard(board);  
}
       //Al conectarse el jugador se le adjudica el scoreboard
       @EventHandler
       public void onJoin(PlayerJoinEvent e) {
          setBoard(e.getPlayer());
       }
       
       //Al moverse el jugador se le adjudica el scoreboard, lo que permite que se actualice constantemente
       @EventHandler
       public void onMove(PlayerMoveEvent e) {
           setBoard(e.getPlayer());
       }
}

