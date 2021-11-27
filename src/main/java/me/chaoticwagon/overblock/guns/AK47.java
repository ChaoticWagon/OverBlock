package me.chaoticwagon.overblock.guns;

import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class AK47 extends Gun implements Listener {

    @Override
    public String getName() {
        return "AK47";
    }
    @Override
    public GunType getGunType(){
        return GunType.ASSAULT_RIFLE;
    }

    @Override
    public double getDamage() {
        return 4.5;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public double getRange() {
        return 0;
    }

    @Override
    public double getFireRate() {
        return 0;
    }

    @Override
    public int getAmmo() {
        return 30;
    }

    @Override
    public FiringMode getFiringMode() {
        return FiringMode.SEMIAUTO;
    }

    @Override
    public double getReloadTime() {
        return 4.0;
    }

    @EventHandler
    public void onShoot(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)) return;
        if(!p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(getName())) return;

        Snowball bullet = p.getWorld().spawn(p.getEyeLocation(), Snowball.class);
        bullet.setShooter(p);
        bullet.setVelocity(p.getLocation().getDirection().multiply(2));


    }
}
