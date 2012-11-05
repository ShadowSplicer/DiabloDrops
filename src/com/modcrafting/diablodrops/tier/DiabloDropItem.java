package com.modcrafting.diablodrops.tier;

import net.minecraft.server.ItemStack;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagString;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.inventory.CraftItemStack;

import com.modcrafting.diablodrops.DiabloDrops;

public class DiabloDropItem extends CraftItemStack
{

	DiabloDrops plugin;
	ChatColor color;

	public DiabloDropItem(Material mat, DiabloDrops instance, String colorString)
	{
		super(mat, 1);
		plugin = instance;
		color = ChatColor.valueOf(colorString);
		if (color == null)
		{
			color = ChatColor.values()[plugin.gen
					.nextInt(ChatColor.values().length)];
		}
		ItemStack mitem = this.getHandle();
		if (mitem.tag == null)
		{
			mitem.tag = new NBTTagCompound();
		}
		mitem.tag.setInt("RepairCost", 2);
		NBTTagCompound ntag = new NBTTagCompound();
		String name = color + name();
		NBTTagString p = new NBTTagString(name);
		p.setName(name);
		p.data = name;
		ntag.set("Name", p);
		ntag.setString("Name", name);
		mitem.tag.setCompound("display", ntag);
	}

	public String name()
	{
		String prefix = plugin.prefix.get(plugin.gen.nextInt(plugin.prefix
				.size() - 1));
		String suffix = plugin.suffix.get(plugin.gen.nextInt(plugin.suffix
				.size() - 1));
		return prefix + " " + suffix;
	}
}
