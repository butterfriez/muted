package com.github.butterfriez.muted;

import com.github.butterfriez.muted.Commands.ChatCommand;
import com.github.butterfriez.muted.Commands.Command;
import com.github.butterfriez.muted.Networking.ServerCommunicator;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "muted", useMetadata=true)
public class MutedMod {
    /**
     * TODO:
     *  Add chat tabs
     */

    public final static ServerCommunicator MutedServerCommunicator = new ServerCommunicator();
    public final static String PREFIX = "muted";
    public final static String CHAT_PREFIX = "§8[§6" + PREFIX + "§8]:§f ";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new Command());
        ClientCommandHandler.instance.registerCommand(new ChatCommand());
    }
}
