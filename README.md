# Muted Mod

A Minecraft mod that enables enhanced communication between players via a WebSocket server. The mod provides functionality to send and receive real-time messages, command handling, and session-based user management.

## Features

- **WebSocket Integration**: Connect to a WebSocket server for real-time message exchange.
- **Custom Commands**:
  - `/mc <message>`: Sends a message to the server.
  - `/muted`: Displays usage instructions for commands.
- **Dynamic Room Support**: Manage and switch communication rooms seamlessly.
- **Custom Chat Styling**: Messages include styled prefixes and separators for improved chat readability.
- **Error Handling**: Handles connection issues and displays relevant errors in the console.

## Commands

### `/mc <message>`
Sends a message to the WebSocket server to be broadcast to other players.

### `/muted`
Displays usage information for available commands. Use this for guidance on how to interact with the mod’s features.

## Requirements

- **Minecraft Forge**: Ensure you have Minecraft Forge installed to use this mod.

## Installation

1. Install [Minecraft Forge](https://files.minecraftforge.net/).
2. Download the mod jar file and place it in the `mods` folder of your Minecraft directory.
3. Start Minecraft and ensure the mod is enabled.

## Basic Usage

1. Launch Minecraft with the mod installed.
2. Use `/mc <message>` to send a broadcast message via the connected WebSocket server.
3. Use `/muted` to view a help menu.

## License

This project is licensed under the MIT License.

---

Enjoy your enhanced Minecraft communication experience!