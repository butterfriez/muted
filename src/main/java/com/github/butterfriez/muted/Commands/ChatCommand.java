package com.github.butterfriez.muted.Commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import org.json.JSONObject;

import static com.github.butterfriez.muted.MutedMod.MutedServerCommunicator;

public class ChatCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "mc";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName();
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length > 0) {
            StringBuilder str = new StringBuilder();
            for (String arg : args) {
                str.append(arg).append(" ");
            }

            JSONObject message = new JSONObject();
            message.put("room", MutedServerCommunicator.getRoomString());
            JSONObject messageData = new JSONObject();
            messageData.put("message", str.toString());
            messageData.put("username", sender.getDisplayName().getUnformattedText());
            message.put("data", messageData.toString());
            MutedServerCommunicator.send(message.toString());
        }
    }
}
