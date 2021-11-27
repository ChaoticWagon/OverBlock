package me.chaoticwagon.overblock.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIHandler implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals("Guns")) {
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Assault Rifles")){
                Inventory inv = Bukkit.createInventory(player, 9, "Assault Rifles");

                ItemStack AK47 = new ItemStack(Material.STICK);
                ItemMeta AK47Meta = AK47.getItemMeta();
                AK47Meta.setDisplayName("AK47");
                AK47.setItemMeta(AK47Meta);

                ItemStack M4A1 = new ItemStack(Material.STICK);
                ItemMeta M4A1Meta = M4A1.getItemMeta();
                M4A1Meta.setDisplayName("M4A1");
                M4A1.setItemMeta(M4A1Meta);

                inv.setItem(0, AK47);
                inv.setItem(1, M4A1);

                event.setCancelled(true);
                player.openInventory(inv);
            }
        }
        if (event.getView().getTitle().equalsIgnoreCase("Assault Rifles")) {

            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("AK47")) {
                ItemStack AK47 = new ItemStack(Material.STICK);
                ItemMeta AK47Meta = AK47.getItemMeta();
                AK47Meta.setDisplayName("AK47");
                AK47.setItemMeta(AK47Meta);

                player.getInventory().addItem(AK47);
                event.setCancelled(true);
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("M4A1")) {
                ItemStack M4A1 = new ItemStack(Material.STICK);
                ItemMeta M4A1Meta = M4A1.getItemMeta();
                M4A1Meta.setDisplayName("M4A1");
                M4A1.setItemMeta(M4A1Meta);

                player.getInventory().addItem(M4A1);
                event.setCancelled(true);
            }
        }

    }

}
