package com.fr0zenst0rm.TrollPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author fr0zenst0rm
 */

public final class TrollPlugin extends JavaPlugin

{
  @Override
  public void onDisable() {}
  
  @Override
  public void onEnable() {}
  
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("troll")) {
      if (args.length == 0) {
        sender.sendMessage("Use " + ChatColor.RED + "/troll <player>");
      } else {
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target != null) {
                Location location = target.getLocation();
                location.setY(256);
                Location b_loc = location;
                b_loc.setY(250);
                Block fallblock = b_loc.getBlock();
                fallblock.setTypeId(20);
                location.setY(252);
                target.teleport(location);
                target.sendMessage(ChatColor.YELLOW + "You just got trolled by " + sender.getName());
                sender.sendMessage(ChatColor.RED + "Success! " + target.getName() + " got trolled");
                getLogger().info(sender.getName() + " trolled " + target.getName());
                return true;
            } else {
                sender.sendMessage(ChatColor.DARK_RED + "Player " + args[0] + " is not online!");
                return true;
            }
      }
    }
    if (cmd.getName().equalsIgnoreCase("trollplugin")) {
        PluginDescriptionFile pdf = getDescription();
        String version = pdf.getVersion();
        String plgname = pdf.getName();
        String message = "This is " + plgname + " v" + version + " by fr0zenst0rm";
        String message2 = ChatColor.YELLOW + "Use " + ChatColor.RED + "/troll <player>" +
                ChatColor.YELLOW + " to troll a player you don't like.";
        sender.sendMessage(ChatColor.YELLOW + message);
        sender.sendMessage(message2);
    }
    return false;
  }
} 