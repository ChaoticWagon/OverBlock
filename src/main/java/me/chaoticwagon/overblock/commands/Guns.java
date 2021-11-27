package me.chaoticwagon.overblock.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Guns implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return true;

        Player player = (Player) sender;
        if (!player.hasPermission("overblock.guns")) return true;

        Inventory inv = Bukkit.createInventory(player, 9, "Guns");

        ItemStack assaultRifles = new ItemStack(Material.STICK);
        ItemMeta assaultRiflesMeta = assaultRifles.getItemMeta();
        assaultRiflesMeta.setDisplayName("Assault Rifles");
        assaultRifles.setItemMeta(assaultRiflesMeta);

        ItemStack shotguns = new ItemStack(Material.STICK);
        ItemMeta shotgunsMeta = shotguns.getItemMeta();
        shotgunsMeta.setDisplayName("Shotguns");
        shotguns.setItemMeta(shotgunsMeta);

        ItemStack smgs = new ItemStack(Material.STICK);
        ItemMeta smgsMeta = smgs.getItemMeta();
        smgsMeta.setDisplayName("SMGs");
        smgs.setItemMeta(smgsMeta);

        ItemStack pistols = new ItemStack(Material.STICK);
        ItemMeta pistolsMeta = pistols.getItemMeta();
        pistolsMeta.setDisplayName("Pistols");
        pistols.setItemMeta(pistolsMeta);

        ItemStack sniperRifles = new ItemStack(Material.STICK);
        ItemMeta sniperRiflesMeta = sniperRifles.getItemMeta();
        sniperRiflesMeta.setDisplayName("Sniper Rifles");
        sniperRifles.setItemMeta(sniperRiflesMeta);

        ItemStack rocketLaunchers = new ItemStack(Material.STICK);
        ItemMeta rocketLaunchersMeta = rocketLaunchers.getItemMeta();
        rocketLaunchersMeta.setDisplayName("Rocket Launchers");
        rocketLaunchers.setItemMeta(rocketLaunchersMeta);

        ItemStack lmgs = new ItemStack(Material.STICK);
        ItemMeta lmgsMeta = lmgs.getItemMeta();
        lmgsMeta.setDisplayName("LMGs");
        lmgs.setItemMeta(lmgsMeta);


        inv.setItem(0, assaultRifles);
        inv.setItem(1, shotguns);
        inv.setItem(2, smgs);
        inv.setItem(3, pistols);
        inv.setItem(4, sniperRifles);
        inv.setItem(5, rocketLaunchers);
        inv.setItem(6, lmgs);
        player.openInventory(inv);
        return true;
    }
}
