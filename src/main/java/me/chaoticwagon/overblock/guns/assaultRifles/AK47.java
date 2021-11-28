package me.chaoticwagon.overblock.guns.assaultRifles;

import me.chaoticwagon.overblock.guns.FiringMode;
import me.chaoticwagon.overblock.guns.Gun;
import me.chaoticwagon.overblock.guns.GunType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;

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

    boolean isReloading = false;
    long time;
    Map<Player,Integer> currentAmmo = new HashMap<Player, Integer>();

    @EventHandler
    public void onShoot(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)) return;
        if(!p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(getName())) return;

        if (!currentAmmo.containsKey(p)){
            currentAmmo.put(p, getAmmo());
        }

        if(currentAmmo.get(p) == 0) {
            reload(p);
            if (isReloading) {
                p.sendMessage("Reloading...");
                e.setCancelled(true);
                return;
            }
        }

        Snowball bullet = p.getWorld().spawn(p.getEyeLocation(), Snowball.class);
        bullet.setShooter(p);
        bullet.setVelocity(p.getLocation().getDirection().multiply(4));
        currentAmmo.put(p, currentAmmo.get(p) - 1);
        p.sendMessage(currentAmmo.get(p) + " bullets left");
    }
    @EventHandler
    public void onHit(ProjectileHitEvent e){
        if (!(e.getEntity().getShooter() instanceof Player)) return;
        if (!(e.getHitEntity() instanceof Player)) return;
        if (!(e.getEntity() instanceof Snowball)) return;

        Player p = (Player) e.getEntity().getShooter();
        Player target =  (Player) e.getHitEntity();
        target.damage(getDamage());
        p.sendMessage(target.getName() + " now has " + target.getHealth() + " health");
    }
    public void reload(Player p){
        if (!isReloading) {
            time =  (System.currentTimeMillis() + ((long) getReloadTime() * 1000));
            isReloading = true;

        }else{
            if (System.currentTimeMillis() > time) {
                currentAmmo.put(p, getAmmo());
                isReloading = false;
            }
        }

    }

}
