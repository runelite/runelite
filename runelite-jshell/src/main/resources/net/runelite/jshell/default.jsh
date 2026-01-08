// Welcome to the RuneLite Development Shell
// Everything executed here runs on the client thread by default.
// By default client, clientThread, configManager and log are in scope
// You can subscribe to the Event Bus by using subscribe(Event.class, ev -> handler);
// and you can access things in the global injector module with var thing = inject(Thing.class);
// Press Ctrl+R or F10 to execute the contents of this editor

log.info("Hello {}", client.getGameState());
