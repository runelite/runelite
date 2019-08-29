import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("GrandExchangeOfferOwnWorldComparator")
public class GrandExchangeOfferOwnWorldComparator implements Comparator {
	@ObfuscatedName("gd")
	@ObfuscatedSignature(
		signature = "[Llq;"
	)
	@Export("mapSceneSprites")
	static IndexedSprite[] mapSceneSprites;
	@ObfuscatedName("s")
	@Export("filterWorlds")
	boolean filterWorlds;

	GrandExchangeOfferOwnWorldComparator() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lq;Lq;I)I",
		garbageValue = "-1137362043"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		if (var2.world == var1.world) {
			return 0;
		} else {
			if (this.filterWorlds) {
				if (Client.worldId == var1.world) {
					return -1;
				}

				if (var2.world == Client.worldId) {
					return 1;
				}
			}

			return var1.world < var2.world ? -1 : 1;
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "1333427398"
	)
	@Export("setLoginResponseString")
	static void setLoginResponseString(String var0, String var1, String var2) {
		Login.Login_response1 = var0;
		Login.Login_response2 = var1;
		Login.Login_response3 = var2;
	}

	@ObfuscatedName("ev")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-84"
	)
	@Export("getLoginError")
	static void getLoginError(int var0) {
		if (var0 == -3) {
			setLoginResponseString("Connection timed out.", "Please try using a different world.", "");
		} else if (var0 == -2) {
			setLoginResponseString("", "Error connecting to server.", "");
		} else if (var0 == -1) {
			setLoginResponseString("No response from server.", "Please try using a different world.", "");
		} else if (var0 == 3) {
			Login.loginIndex = 3;
			Login.field1161 = 1;
		} else if (var0 == 4) {
			Login.loginIndex = 12;
			Login.field1160 = 0;
		} else if (var0 == 5) {
			Login.field1161 = 2;
			setLoginResponseString("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
		} else if (var0 == 68 || !Client.onMobile && var0 == 6) {
			setLoginResponseString("RuneScape has been updated!", "Please reload this page.", "");
		} else if (var0 == 7) {
			setLoginResponseString("This world is full.", "Please use a different world.", "");
		} else if (var0 == 8) {
			setLoginResponseString("Unable to connect.", "Login server offline.", "");
		} else if (var0 == 9) {
			setLoginResponseString("Login limit exceeded.", "Too many connections from your address.", "");
		} else if (var0 == 10) {
			setLoginResponseString("Unable to connect.", "Bad session id.", "");
		} else if (var0 == 11) {
			setLoginResponseString("We suspect someone knows your password.", "Press 'change your password' on front page.", "");
		} else if (var0 == 12) {
			setLoginResponseString("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
		} else if (var0 == 13) {
			setLoginResponseString("Could not complete login.", "Please try using a different world.", "");
		} else if (var0 == 14) {
			setLoginResponseString("The server is being updated.", "Please wait 1 minute and try again.", "");
		} else if (var0 == 16) {
			setLoginResponseString("Too many login attempts.", "Please wait a few minutes before trying again.", "");
		} else if (var0 == 17) {
			setLoginResponseString("You are standing in a members-only area.", "To play on this world move to a free area first", "");
		} else if (var0 == 18) {
			Login.loginIndex = 12;
			Login.field1160 = 1;
		} else if (var0 == 19) {
			setLoginResponseString("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
		} else if (var0 == 20) {
			setLoginResponseString("Invalid loginserver requested.", "Please try using a different world.", "");
		} else if (var0 == 22) {
			setLoginResponseString("Malformed login packet.", "Please try again.", "");
		} else if (var0 == 23) {
			setLoginResponseString("No reply from loginserver.", "Please wait 1 minute and try again.", "");
		} else if (var0 == 24) {
			setLoginResponseString("Error loading your profile.", "Please contact customer support.", "");
		} else if (var0 == 25) {
			setLoginResponseString("Unexpected loginserver response.", "Please try using a different world.", "");
		} else if (var0 == 26) {
			setLoginResponseString("This computers address has been blocked", "as it was used to break our rules.", "");
		} else if (var0 == 27) {
			setLoginResponseString("", "Service unavailable.", "");
		} else if (var0 == 31) {
			setLoginResponseString("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
		} else if (var0 == 32) {
			setLoginResponseString("Your attempt to log into your account was", "unsuccessful.  Don't worry, you can sort", "this out by visiting the billing system.");
		} else if (var0 == 37) {
			setLoginResponseString("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
		} else if (var0 == 38) {
			setLoginResponseString("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
		} else if (var0 == 55) {
			Login.loginIndex = 8;
		} else {
			if (var0 == 56) {
				setLoginResponseString("Enter the 6-digit code generated by your", "authenticator app.", "");
				FloorDecoration.updateGameState(11);
				return;
			}

			if (var0 == 57) {
				setLoginResponseString("The code you entered was incorrect.", "Please try again.", "");
				FloorDecoration.updateGameState(11);
				return;
			}

			if (var0 == 61) {
				Login.loginIndex = 7;
			} else {
				setLoginResponseString("Unexpected server response", "Please try using a different world.", "");
			}
		}

		FloorDecoration.updateGameState(10);
	}
}
