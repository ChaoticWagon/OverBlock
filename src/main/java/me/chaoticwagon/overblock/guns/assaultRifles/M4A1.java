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

public class M4A1 extends Gun implements Listener {

    @Override
    public String getName() {
        return "M4A1";
    }
    @Override
    public GunType getGunType(){
        return GunType.ASSAULT_RIFLE;
    }

    @Override
    public double getDamage() {
        return 3;
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
        return FiringMode.AUTO;
    }

    @Override
    public double getReloadTime() {
        return 2.5;
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

    @EventHandler
    public void onHit(ProjectileHitEvent e){
        if (!(e.getEntity().getShooter() instanceof Player)) return;
        if (!(e.getHitEntity() instanceof Player)) return;
        if (!(e.getEntity() instanceof Snowball)) return;

        Player p = (Player) e.getEntity().getShooter();
        Player target =  (Player) e.getHitEntity();
        target.damage(getDamage());
    }


}
