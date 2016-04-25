package net.runelite.api;

public enum GameState
{
   UNKNOWN(-1),
   STARTING(0),
   LOGIN_SCREEN(10),
   LOGGING_IN(20),
   LOADING(25),
   LOGGED_IN(30),
   HOPPING(45);

   private final int state;

   GameState(int state)
   {
	   this.state = state;
   }

   public static GameState of(int state)
   {
	   for (GameState gs : GameState.values())
		   if (gs.state == state)
			   return gs;
	   return UNKNOWN;
   }
}
