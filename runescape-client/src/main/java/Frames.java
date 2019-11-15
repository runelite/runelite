import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("Frames")
public class Frames extends DualNode {
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	@Export("NetCache_responseArchiveBuffer")
	public static Buffer NetCache_responseArchiveBuffer;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "[Ldw;"
	)
	@Export("frames")
	Animation[] frames;

	@ObfuscatedSignature(
		signature = "(Lhq;Lhq;IZ)V",
		garbageValue = "0"
	)
	public Frames(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
		NodeDeque var5 = new NodeDeque();
		int var6 = var1.getGroupFileCount(var3);
		this.frames = new Animation[var6];
		int[] var7 = var1.getGroupFileIds(var3);

		for (int var8 = 0; var8 < var7.length; ++var8) {
			byte[] var9 = var1.takeFile(var3, var7[var8]);
			Skeleton var10 = null;
			int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

			for (Skeleton var12 = (Skeleton)var5.last(); var12 != null; var12 = (Skeleton)var5.previous()) {
				if (var11 == var12.id) {
					var10 = var12;
					break;
				}
			}

			if (var10 == null) {
				byte[] var13 = var2.getFile(var11, 0);
				var10 = new Skeleton(var11, var13);
				var5.addFirst(var10);
			}

			this.frames[var7[var8]] = new Animation(var9, var10);
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1903935769"
	)
	@Export("hasAlphaTransform")
	public boolean hasAlphaTransform(int var1) {
		return this.frames[var1].hasAlphaTransform;
	}

	@ObfuscatedName("fc")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "3"
	)
	@Export("forceDisconnect")
	static final void forceDisconnect(int var0) {
		class1.logOut();
		switch(var0) {
		case 1:
			Login.loginIndex = 24;
			GrandExchangeOffer.setLoginResponseString("", "You were disconnected from the server.", "");
			break;
		case 2:
			Players.method2298();
		}

	}

	@ObfuscatedName("gb")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "-13007"
	)
	static void method3397() {
		if (class215.localPlayer.x >> 7 == Client.destinationX && class215.localPlayer.y >> 7 == Client.destinationY) {
			Client.destinationX = 0;
		}

	}

	@ObfuscatedName("jp")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-244259971"
	)
	static boolean method3400(int var0) {
		for (int var1 = 0; var1 < Client.field866; ++var1) {
			if (Client.field854[var1] == var0) {
				return true;
			}
		}

		return false;
	}
}
