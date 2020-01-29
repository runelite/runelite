import java.security.SecureRandom;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
	@ObfuscatedName("ef")
	@Export("secureRandom")
	static SecureRandom secureRandom;
	@ObfuscatedName("c")
	@Export("args")
	Object[] args;
	@ObfuscatedName("t")
	@Export("isMouseInputEvent")
	boolean isMouseInputEvent;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("widget")
	Widget widget;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1331050905
	)
	@Export("mouseX")
	int mouseX;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1279210295
	)
	@Export("mouseY")
	int mouseY;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1465065173
	)
	@Export("opIndex")
	int opIndex;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("dragTarget")
	Widget dragTarget;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -268491807
	)
	@Export("keyTyped")
	int keyTyped;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1412457419
	)
	@Export("keyPressed")
	int keyPressed;
	@ObfuscatedName("m")
	@Export("targetName")
	String targetName;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1385894557
	)
	int field582;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -891059655
	)
	@Export("type")
	int type;

	public ScriptEvent() {
		this.type = 76;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/Object;I)V",
		garbageValue = "-2105798075"
	)
	@Export("setArgs")
	public void setArgs(Object[] var1) {
		this.args = var1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "350345560"
	)
	@Export("setType")
	public void setType(int var1) {
		this.type = var1;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;II)I",
		garbageValue = "2038755818"
	)
	public static int method1202(CharSequence var0, int var1) {
		return KitDefinition.parseIntCustomRadix(var0, var1, true);
	}

	@ObfuscatedName("he")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "43843350"
	)
	static void method1203(int var0, String var1) {
		int var2 = Players.Players_count;
		int[] var3 = Players.Players_indices;
		boolean var4 = false;
		Username var5 = new Username(var1, class192.loginType);

		for (int var6 = 0; var6 < var2; ++var6) {
			Player var7 = Client.players[var3[var6]];
			if (var7 != null && var7 != class192.localPlayer && var7.username != null && var7.username.equals(var5)) {
				PacketBufferNode var8;
				if (var0 == 1) {
					var8 = TilePaint.getPacketBufferNode(ClientPacket.field2282, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(0);
					var8.packetBuffer.writeShort(var3[var6]);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 4) {
					var8 = TilePaint.getPacketBufferNode(ClientPacket.field2216, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(0);
					var8.packetBuffer.writeShortLE(var3[var6]);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 6) {
					var8 = TilePaint.getPacketBufferNode(ClientPacket.field2221, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5787(var3[var6]);
					var8.packetBuffer.writeByte(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 7) {
					var8 = TilePaint.getPacketBufferNode(ClientPacket.field2266, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5787(var3[var6]);
					var8.packetBuffer.method5602(0);
					Client.packetWriter.addNode(var8);
				}

				var4 = true;
				break;
			}
		}

		if (!var4) {
			ClientPreferences.addGameMessage(4, "", "Unable to find " + var1);
		}

	}
}
