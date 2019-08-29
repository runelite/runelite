import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("ParamDefinition")
public class ParamDefinition extends DualNode {
	@ObfuscatedName("pk")
	@ObfuscatedSignature(
		signature = "Lls;"
	)
	@Export("sceneMinimapSprite")
	static Sprite sceneMinimapSprite;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("ParamDefinition_cached")
	static EvictingDualNodeHashTable ParamDefinition_cached;
	@ObfuscatedName("i")
	@Export("type")
	char type;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1184264069
	)
	@Export("defaultInt")
	public int defaultInt;
	@ObfuscatedName("u")
	@Export("defaultStr")
	public String defaultStr;
	@ObfuscatedName("n")
	@Export("autoDisable")
	boolean autoDisable;

	static {
		ParamDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	ParamDefinition() {
		this.autoDisable = true;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-549748029"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "207270503"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lky;II)V",
		garbageValue = "1082151718"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			byte var4 = var1.readByte();
			int var5 = var4 & 255;
			if (var5 == 0) {
				throw new IllegalArgumentException("" + Integer.toString(var5, 16));
			}

			if (var5 >= 128 && var5 < 160) {
				char var6 = class287.cp1252AsciiExtension[var5 - 128];
				if (var6 == 0) {
					var6 = '?';
				}

				var5 = var6;
			}

			char var3 = (char)var5;
			this.type = var3;
		} else if (var2 == 2) {
			this.defaultInt = var1.readInt();
		} else if (var2 == 4) {
			this.autoDisable = false;
		} else if (var2 == 5) {
			this.defaultStr = var1.readStringCp1252NullTerminated();
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "38"
	)
	@Export("isString")
	public boolean isString() {
		return this.type == 's';
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/awt/Component;S)V",
		garbageValue = "-10016"
	)
	static void method4420(Component var0) {
		var0.removeKeyListener(KeyHandler.KeyHandler_instance);
		var0.removeFocusListener(KeyHandler.KeyHandler_instance);
		KeyHandler.field378 = -1;
	}

	@ObfuscatedName("ja")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1970542013"
	)
	static final void method4424() {
		PacketBufferNode var0 = MenuAction.getPacketBufferNode(ClientPacket.field2205, Client.packetWriter.isaacCipher);
		Client.packetWriter.addNode(var0);

		for (InterfaceParent var1 = (InterfaceParent)Client.interfaceParents.first(); var1 != null; var1 = (InterfaceParent)Client.interfaceParents.next()) {
			if (var1.type == 0 || var1.type == 3) {
				VarpDefinition.closeInterface(var1, true);
			}
		}

		if (Client.meslayerContinueWidget != null) {
			FriendSystem.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

	}

	@ObfuscatedName("kx")
	@ObfuscatedSignature(
		signature = "(Lhp;B)I",
		garbageValue = "-97"
	)
	@Export("getWidgetClickMask")
	static int getWidgetClickMask(Widget var0) {
		IntegerNode var1 = (IntegerNode)Client.widgetClickMasks.get(((long)var0.id << 32) + (long)var0.childIndex);
		return var1 != null ? var1.integer : var0.clickMask;
	}
}
