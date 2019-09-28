import java.awt.Component;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public class class83 {
	@ObfuscatedName("z")
	static final BigInteger field1148;
	@ObfuscatedName("n")
	static final BigInteger field1149;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 1818915939
	)
	static int field1145;

	static {
		field1148 = new BigInteger("10001", 16);
		field1149 = new BigInteger("a8cda33f9c45f0b9d1675c38ec69da6be4143320190060c229bb35ed91677a4447e09e77031e824aed13bfab51ba180bbda7e279a128f3eb016e9b0dd752a948431798626fc36ac10e036d945f2752d0d874c65a86d3e001a17bf9d63d8bc263b07be4ebc613d01781023a07de698e75248b582e682f1751395f61b9ec1bcbb3", 16);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Ljava/awt/Component;I)V",
		garbageValue = "2076208439"
	)
	static void method2069(Component var0) {
		var0.removeKeyListener(KeyHandler.KeyHandler_instance);
		var0.removeFocusListener(KeyHandler.KeyHandler_instance);
		KeyHandler.field373 = -1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lhp;IIIZI)V",
		garbageValue = "-476776598"
	)
	public static void method2068(AbstractArchive var0, int var1, int var2, int var3, boolean var4) {
		class197.field2386 = 1;
		class197.musicTrackArchive = var0;
		class188.musicTrackGroupId = var1;
		class49.musicTrackFileId = var2;
		TileItem.field1223 = var3;
		WorldMapSectionType.musicTrackBoolean = var4;
		MusicPatchNode2.field2382 = 10000;
	}
}
