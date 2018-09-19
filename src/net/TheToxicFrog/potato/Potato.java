package net.TheToxicFrog.potato;

import java.util.logging.Logger;

import org.spongepowered.api.Game;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

import com.google.inject.Inject;

@Plugin(id="potato", name="Potato", version="0.1")
public class Potato {
	
	@Inject
	Game game;
	
	@Inject
	Logger logger;
	
	@Listener
	public void onInit(GameInitializationEvent e) {
		CommandSpec potatoCmd = CommandSpec.builder()
			    .description(Text.of("PotatoPotatoPotatoPotatoPotato..."))
			    .arguments(GenericArguments.allOf(GenericArguments.string(Text.of("potatoArg1"))))
			    .executor(new PotatoExecuter())
			    .build();
		game.getCommandManager().register(this, potatoCmd,"potato");
	}
}
