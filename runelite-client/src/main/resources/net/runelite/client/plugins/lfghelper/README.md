# LFG Helper - RuneLite Plugin

LFG Helper is a RuneLite plugin that helps players find groups for PvM content in Old School RuneScape. It allows users to quickly post LFG (Looking For Group) requests to a designated Discord server via a webhook.

## Features
✅ Simple form-based UI for entering LFG details  
✅ Automatically includes the player's in-game name in the LFG request  
✅ Supports boss name, clan chat, team size, loot type (splits/FFA), and world selection  
✅ Sends formatted messages to a Discord webhook  
✅ Prevents spam by enforcing a cooldown between submissions  
✅ Disables submission if required fields are empty

## How It Works
1. Open the **LFG Helper** panel in RuneLite.
2. **Configure the webhook and role ID**
    - Your server owner will provide a **Discord webhook URL** and a **PVMer role ID**.
    - Enter these in the plugin configuration settings.
3. Fill out the form:
    - **Boss Name**: Name of the boss you're looking to fight.
    - **Clan Chat**: The in-game clan chat for organizing the group.
    - **Team Size**: Enter `99` if there is no limit.
    - **Loot Type**: Splits or Free-for-All.
    - **World**: The world number for the event.
4. Click **Submit** to send the request to the designated Discord channel.
5. Ensure you are logged in before submitting. If not, the plugin will notify you.

## Setting Up Discord Integration (For Server Owners)
To use this plugin, server owners need to set up the following:

### 1️⃣ Create a Webhook
A webhook is required for the plugin to send LFG messages to your Discord server.
- In Discord, go to **Server Settings → Integrations → Webhooks**
- Create a new webhook and copy the **Webhook URL**
- Provide this URL to users who will be using the plugin

### 2️⃣ Create a "PVMer" Role
To allow the plugin to tag players looking for groups, create a role named **PVMer** (or another role of your choice).
- Go to **Server Settings → Roles → Create Role**
- Assign this role to users who want LFG notifications
- Copy the **Role ID** and provide it to plugin users

🔹 **No Security Risk**: Sharing the role ID does not pose any security concerns as long as no additional permissions are assigned to the role. The ID is simply used for tagging in Discord messages.

## Example Discord Message
@PVMer, [Player Name] is starting a group for [Boss Name]!<br>
Boss: [Boss Name]<br>
Clan Chat: [Clan Chat]<br>
Team Size: [Size]<br>
Loot Type: [Splits/FFA]<br>
World: [World]
![image](https://github.com/user-attachments/assets/c0d4c6ba-e1a7-4fd6-a042-951b34f11142)
![image](https://github.com/user-attachments/assets/5e033f0e-9cd2-4b79-a216-29265a5d84d7)
![image](https://github.com/user-attachments/assets/1ea58b69-acf3-44fc-ba33-b205b158db83)

