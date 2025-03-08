package com.github.butterfriez.muted.Commands;

import com.github.butterfriez.muted.Util.Chat;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.util.Objects;

import static com.github.butterfriez.muted.MutedMod.*;

public class Command extends CommandBase {
    @Override
    public String getCommandName() {
        return PREFIX;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + PREFIX;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.addChatMessage(new ChatComponentText(
                    Chat.GetChatBreak()
                            + "§6/" + PREFIX + " §8: " + "§fSends this usage message.\n"
                            + "§6/mc §8<§6message§8>" + " §8: " + "§fSends a message to muted server to be broadcast to other players.\n"
                            + Chat.GetChatBreak()));
        } else {
            switch (args[0]) {
                case "room":
                    String finalRoom = "";
                    if (args.length >= 2) {
                        finalRoom = args[1];
                    }

                    MutedServerCommunicator.setRoomString(finalRoom);
                    finalRoom = Objects.equals(finalRoom, "") ? "All" : finalRoom;
                    sender.addChatMessage(new ChatComponentText(
                            CHAT_PREFIX + "Set room to §b" + finalRoom + "§f."
                    ));
                    break;
            }
        }
    }
}
