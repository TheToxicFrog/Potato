package net.TheToxicFrog.potato;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class PotatoExecuter implements CommandExecutor{
	public ItemStack generatePotato(Collection<Object> args) {
	    ItemStack potato = ItemStack.builder()
	        .itemType(ItemTypes.POTATO)
	        .build();

	    potato.offer(Keys.DISPLAY_NAME, Text.of(StringUtils.join(args.toArray()," ")));
	    return potato;
	}
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException{
		if(!(src instanceof Player)) {
			src.sendMessage(Text.of(TextColors.RED, "/Potato can't be used via console."));
		}
		Player player = (Player) src;
		player.sendMessage(Text.of(TextColors.GREEN, "You have been potatofied!"));
	    player.setItemInHand(HandTypes.MAIN_HAND, generatePotato(args.getAll("potatoArg1")));
		return CommandResult.success();
	}
}
