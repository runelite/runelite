import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("WorldMapSprite")
public final class WorldMapSprite {
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("Widget_fontsArchive")
	static AbstractArchive Widget_fontsArchive;
	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	static ServerBuild field226;
	@ObfuscatedName("x")
	@Export("tileColors")
	final int[] tileColors;

	WorldMapSprite() {
		this.tileColors = new int[4096];
	}

	WorldMapSprite(int[] var1) {
		this.tileColors = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "2"
	)
	@Export("getTileColor")
	final int getTileColor(int var1, int var2) {
		return this.tileColors[var2 * 64 + var1];
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(ILhj;ZI)V",
		garbageValue = "-310129392"
	)
	static void method380(int var0, Coord var1, boolean var2) {
		WorldMapArea var3 = class1.getWorldMap().getMapArea(var0);
		int var4 = Varps.localPlayer.plane;
		int var5 = class4.baseX * 64 + (Varps.localPlayer.x * -78439701 >> 7);
		int var6 = (Varps.localPlayer.y >> 7) + ScriptEvent.baseY;
		Coord var7 = new Coord(var4, var5, var6);
		class1.getWorldMap().method6431(var3, var7, var1, var2);
	}

	@ObfuscatedName("eh")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "79"
	)
	@Export("getLoginError")
	static void getLoginError(int var0) {
		if (var0 == -3) {
			Canvas.setLoginResponseString("Connection timed out.", "Please try using a different world.", "");
		} else if (var0 == -2) {
			Canvas.setLoginResponseString("", "Error connecting to server.", "");
		} else if (var0 == -1) {
			Canvas.setLoginResponseString("No response from server.", "Please try using a different world.", "");
		} else if (var0 == 3) {
			Login.loginIndex = 3;
			Login.field1161 = 1;
		} else if (var0 == 4) {
			Login.loginIndex = 12;
			Login.field1156 = 0;
		} else if (var0 == 5) {
			Login.field1161 = 2;
			Canvas.setLoginResponseString("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
		} else if (var0 == 68 || !Client.onMobile && var0 == 6) {
			Canvas.setLoginResponseString("RuneScape has been updated!", "Please reload this page.", "");
		} else if (var0 == 7) {
			Canvas.setLoginResponseString("This world is full.", "Please use a different world.", "");
		} else if (var0 == 8) {
			Canvas.setLoginResponseString("Unable to connect.", "Login server offline.", "");
		} else if (var0 == 9) {
			Canvas.setLoginResponseString("Login limit exceeded.", "Too many connections from your address.", "");
		} else if (var0 == 10) {
			Canvas.setLoginResponseString("Unable to connect.", "Bad session id.", "");
		} else if (var0 == 11) {
			Canvas.setLoginResponseString("We suspect someone knows your password.", "Press 'change your password' on front page.", "");
		} else if (var0 == 12) {
			Canvas.setLoginResponseString("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
		} else if (var0 == 13) {
			Canvas.setLoginResponseString("Could not complete login.", "Please try using a different world.", "");
		} else if (var0 == 14) {
			Canvas.setLoginResponseString("The server is being updated.", "Please wait 1 minute and try again.", "");
		} else if (var0 == 16) {
			Canvas.setLoginResponseString("Too many login attempts.", "Please wait a few minutes before trying again.", "");
		} else if (var0 == 17) {
			Canvas.setLoginResponseString("You are standing in a members-only area.", "To play on this world move to a free area first", "");
		} else if (var0 == 18) {
			Login.loginIndex = 12;
			Login.field1156 = 1;
		} else if (var0 == 19) {
			Canvas.setLoginResponseString("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
		} else if (var0 == 20) {
			Canvas.setLoginResponseString("Invalid loginserver requested.", "Please try using a different world.", "");
		} else if (var0 == 22) {
			Canvas.setLoginResponseString("Malformed login packet.", "Please try again.", "");
		} else if (var0 == 23) {
			Canvas.setLoginResponseString("No reply from loginserver.", "Please wait 1 minute and try again.", "");
		} else if (var0 == 24) {
			Canvas.setLoginResponseString("Error loading your profile.", "Please contact customer support.", "");
		} else if (var0 == 25) {
			Canvas.setLoginResponseString("Unexpected loginserver response.", "Please try using a different world.", "");
		} else if (var0 == 26) {
			Canvas.setLoginResponseString("This computers address has been blocked", "as it was used to break our rules.", "");
		} else if (var0 == 27) {
			Canvas.setLoginResponseString("", "Service unavailable.", "");
		} else if (var0 == 31) {
			Canvas.setLoginResponseString("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
		} else if (var0 == 32) {
			Canvas.setLoginResponseString("Your attempt to log into your account was", "unsuccessful.  Don't worry, you can sort", "this out by visiting the billing system.");
		} else if (var0 == 37) {
			Canvas.setLoginResponseString("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
		} else if (var0 == 38) {
			Canvas.setLoginResponseString("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
		} else if (var0 == 55) {
			Login.loginIndex = 8;
		} else {
			if (var0 == 56) {
				Canvas.setLoginResponseString("Enter the 6-digit code generated by your", "authenticator app.", "");
				WorldMapIcon_0.updateGameState(11);
				return;
			}

			if (var0 == 57) {
				Canvas.setLoginResponseString("The code you entered was incorrect.", "Please try again.", "");
				WorldMapIcon_0.updateGameState(11);
				return;
			}

			if (var0 == 61) {
				Login.loginIndex = 7;
			} else {
				Canvas.setLoginResponseString("Unexpected server response", "Please try using a different world.", "");
			}
		}

		WorldMapIcon_0.updateGameState(10);
	}
}
