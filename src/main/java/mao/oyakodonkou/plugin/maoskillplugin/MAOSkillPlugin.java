package mao.oyakodonkou.plugin.maoskillplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MAOSkillPlugin extends JavaPlugin {

    boolean DamageUp = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (label.equalsIgnoreCase("skillfishing")) { //釣りスキル
            sender.sendMessage("Fishing Skill OK");
        }

        if (label.equalsIgnoreCase("damageup")) {

            if(DamageUp == false) {
                DamageUp = true ;
                sender.sendMessage("Enable DamageUp!");
            }else {
                DamageUp = false ;
                sender.sendMessage("Disble DamageUp!");
            }

        }

        return true;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        double damage = e.getDamage();
        EntityType type = e.getEntityType();
        if (type != EntityType.PLAYER) {
            if(DamageUp == true){
                e.setDamage(damage * 100);
            }
            else {
                e.setDamage(damage * 1);
            }
        }
    }




}
