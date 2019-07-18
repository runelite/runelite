import java.security.SecureRandom;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("WorldMapIcon_1")
public class WorldMapIcon_1 extends AbstractWorldMapIcon {
	@ObfuscatedName("nc")
	@ObfuscatedSignature(
		signature = "[Lhj;"
	)
	static Widget[] field188;
	@ObfuscatedName("ew")
	@Export("secureRandom")
	static SecureRandom secureRandom;
	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		signature = "Lke;"
	)
	@Export("fontBold12")
	static Font fontBold12;
	@ObfuscatedName("ld")
	@ObfuscatedGetter(
		intValue = 1201486385
	)
	@Export("selectedItemSlot")
	static int selectedItemSlot;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -2025919285
	)
	@Export("objectDefId")
	final int objectDefId;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Law;"
	)
	@Export("region")
	final WorldMapRegion region;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1988411639
	)
	@Export("element")
	int element;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Las;"
	)
	@Export("label")
	WorldMapLabel label;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -727022115
	)
	@Export("subWidth")
	int subWidth;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -119069051
	)
	@Export("subHeight")
	int subHeight;

	@ObfuscatedSignature(
		signature = "(Lhv;Lhv;ILaw;)V"
	)
	WorldMapIcon_1(Coord var1, Coord var2, int var3, WorldMapRegion var4) {
		super(var1, var2);
		this.objectDefId = var3;
		this.region = var4;
		this.init();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-229566020"
	)
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Las;",
		garbageValue = "1426074195"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "14"
	)
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	@Export("init")
	void init() {
		this.element = ViewportMouse.getObjectDefinition(this.objectDefId).transform().mapIconId;
		this.label = this.region.createMapLabel(class222.getWorldMapElement(this.element));
		WorldMapElement var1 = class222.getWorldMapElement(this.getElement());
		Sprite var2 = var1.getSpriteBool(false);
		if (var2 != null) {
			this.subWidth = var2.subWidth;
			this.subHeight = var2.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1515733926"
	)
	public static boolean method295(int var0) {
		return (var0 >> 20 & 1) != 0;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)Lbj;",
		garbageValue = "377219115"
	)
	static Message method297(int var0) {
		return (Message)Messages.Messages_hashTable.get((long)var0);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "536238322"
	)
	@Export("HealthBarDefinition_clearCached")
	public static void HealthBarDefinition_clearCached() {
		HealthBarDefinition.HealthBarDefinition_cached.clear();
		HealthBarDefinition.HealthBarDefinition_cachedSprites.clear();
	}

	@ObfuscatedName("ey")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-42"
	)
	static void method296(int var0) {
		if (var0 == -3) {
			class268.setLoginResponseString("Connection timed out.", "Please try using a different world.", "");
		} else if (var0 == -2) {
			class268.setLoginResponseString("", "Error connecting to server.", "");
		} else if (var0 == -1) {
			class268.setLoginResponseString("No response from server.", "Please try using a different world.", "");
		} else if (var0 == 3) {
			Login.loginIndex = 3;
			Login.field1212 = 1;
		} else if (var0 == 4) {
			MouseRecorder.method1137(0);
		} else if (var0 == 5) {
			Login.field1212 = 2;
			class268.setLoginResponseString("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
		} else if (var0 == 68 || !Client.onMobile && var0 == 6) {
			class268.setLoginResponseString("RuneScape has been updated!", "Please reload this page.", "");
		} else if (var0 == 7) {
			class268.setLoginResponseString("This world is full.", "Please use a different world.", "");
		} else if (var0 == 8) {
			class268.setLoginResponseString("Unable to connect.", "Login server offline.", "");
		} else if (var0 == 9) {
			class268.setLoginResponseString("Login limit exceeded.", "Too many connections from your address.", "");
		} else if (var0 == 10) {
			class268.setLoginResponseString("Unable to connect.", "Bad session id.", "");
		} else if (var0 == 11) {
			class268.setLoginResponseString("We suspect someone knows your password.", "Press 'change your password' on front page.", "");
		} else if (var0 == 12) {
			class268.setLoginResponseString("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
		} else if (var0 == 13) {
			class268.setLoginResponseString("Could not complete login.", "Please try using a different world.", "");
		} else if (var0 == 14) {
			class268.setLoginResponseString("The server is being updated.", "Please wait 1 minute and try again.", "");
		} else if (var0 == 16) {
			class268.setLoginResponseString("Too many login attempts.", "Please wait a few minutes before trying again.", "");
		} else if (var0 == 17) {
			class268.setLoginResponseString("You are standing in a members-only area.", "To play on this world move to a free area first", "");
		} else if (var0 == 18) {
			MouseRecorder.method1137(1);
		} else if (var0 == 19) {
			class268.setLoginResponseString("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
		} else if (var0 == 20) {
			class268.setLoginResponseString("Invalid loginserver requested.", "Please try using a different world.", "");
		} else if (var0 == 22) {
			class268.setLoginResponseString("Malformed login packet.", "Please try again.", "");
		} else if (var0 == 23) {
			class268.setLoginResponseString("No reply from loginserver.", "Please wait 1 minute and try again.", "");
		} else if (var0 == 24) {
			class268.setLoginResponseString("Error loading your profile.", "Please contact customer support.", "");
		} else if (var0 == 25) {
			class268.setLoginResponseString("Unexpected loginserver response.", "Please try using a different world.", "");
		} else if (var0 == 26) {
			class268.setLoginResponseString("This computers address has been blocked", "as it was used to break our rules.", "");
		} else if (var0 == 27) {
			class268.setLoginResponseString("", "Service unavailable.", "");
		} else if (var0 == 31) {
			class268.setLoginResponseString("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
		} else if (var0 == 32) {
			class268.setLoginResponseString("Your attempt to log into your account was", "unsuccessful.  Don't worry, you can sort", "this out by visiting the billing system.");
		} else if (var0 == 37) {
			class268.setLoginResponseString("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
		} else if (var0 == 38) {
			class268.setLoginResponseString("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
		} else if (var0 == 55) {
			Login.loginIndex = 8;
		} else {
			if (var0 == 56) {
				class268.setLoginResponseString("Enter the 6-digit code generated by your", "authenticator app.", "");
				class96.updateGameState(11);
				return;
			}

			if (var0 == 57) {
				class268.setLoginResponseString("The code you entered was incorrect.", "Please try again.", "");
				class96.updateGameState(11);
				return;
			}

			if (var0 == 61) {
				Login.loginIndex = 7;
			} else {
				class268.setLoginResponseString("Unexpected server response", "Please try using a different world.", "");
			}
		}

		class96.updateGameState(10);
	}
}
