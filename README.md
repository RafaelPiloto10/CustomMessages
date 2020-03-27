# Minecraft Custom Messages Plugin
A Minecraft Bukkit plugin that supports custom messages for:

* New player message
* Custom join message
* Custom chat player prefixes
* Custom `/announce` command that anonymously broadcasts a message to the server

All while being entirely configurable!

## Configurations:

### Announce
```yaml
announce-error-no-message: "&cProvide a message to run that command" # Error message when trying to announce but provided no message - '&' color codes may be used
no-permission: "&cYou do not have permissions!" # Error message when the player tries to announce, but doesn't have the permissions '&' color codes may be used
announce-message-tag: "&6[&aAnnouncement&6] &a" # Tag to identify it is an announcement - '&' color codes may be used
```

### Chat Messages 
Make sure to set permissions in your permission.yml file to set the permission ranks
```yaml
chat-format-amount: 3 # How many "ranks" you want
chat-formats: # Custom messages - First line is rank 1 (ADMIN/HOST/ETC), last line is the last rank (DEFAULT) Make sure to have a <name> and a <msg> to format correctly. '&' Color codes can be used!
  - "&l&c[ADMIN] <name>&r&f: <msg>"
  - "&r&3[Noble] <name>&r&f: <msg>"
  - "&r&f[Villager] <name>&r&f: <msg>"
```

# New Player Join Event
```yaml
custom-join: true # Custom when a player joins?
custom-join-message: "&e<name> has joined the server!" # Message to display when a player has joined - <name> must be present to display player name - '&' color codes may be used
new-player-join: true # Should a custom message be displayed when a new player has joined?
new-player-join-message: # Message to display when a new player has joined - <name> must be present to display player name - '&' color codes may be used
  - "&6-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"
  - " "
  - "&l&6WELCOME &r&e<name> to the server!"
  - "&cMake sure to join our discord server: !"
  - " "
  - "&6-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"
```
## Permissions

```yaml
default:
  custommessages:
    announce:
      use: true # Does the player have access to the announce command?
    # Different format rankings - Ensure this lines up with your config.yml
    ranks:
      1: true # Highest rank
      2: false
      3: false # Lowest rank
    customformat:
      use: true # Should prefixes be used?
```