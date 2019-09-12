import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class197 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("musicPatchesArchive")
	public static AbstractArchive musicPatchesArchive;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("musicSamplesArchive")
	public static AbstractArchive musicSamplesArchive;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("soundEffectsArchive")
	public static AbstractArchive soundEffectsArchive;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	@Export("midiPcmStream")
	public static MidiPcmStream midiPcmStream;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1354024537
	)
	public static int field2376;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("musicTrackArchive")
	public static AbstractArchive musicTrackArchive;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -497843855
	)
	@Export("musicTrackGroupId")
	public static int musicTrackGroupId;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -393064307
	)
	@Export("musicTrackFileId")
	public static int musicTrackFileId;
	@ObfuscatedName("fk")
	@ObfuscatedSignature(
		signature = "Lkf;"
	)
	@Export("fontPlain12")
	static Font fontPlain12;
	@ObfuscatedName("gz")
	@Export("regions")
	static int[] regions;

	static {
		field2376 = 0;
	}

	@ObfuscatedName("iq")
	@ObfuscatedSignature(
		signature = "([Lhy;Lhy;ZI)V",
		garbageValue = "-974819502"
	)
	@Export("revalidateWidgetScroll")
	static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
		int var3 = var1.scrollWidth != 0 ? var1.scrollWidth : var1.width;
		int var4 = var1.scrollHeight != 0 ? var1.scrollHeight : var1.height;
		class80.resizeInterface(var0, var1.id, var3, var4, var2);
		if (var1.children != null) {
			class80.resizeInterface(var1.children, var1.id, var3, var4, var2);
		}

		InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.get((long)var1.id);
		if (var5 != null) {
			Occluder.resizeComponents(var5.group, var3, var4, var2);
		}

		if (var1.contentType == 1337) {
		}

	}

	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1549074319"
	)
	@Export("clanKickUser")
	static final void clanKickUser(String var0) {
		if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
			PacketBufferNode var1 = MenuAction.getPacketBufferNode(ClientPacket.field2218, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(Varcs.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}
	}
}
