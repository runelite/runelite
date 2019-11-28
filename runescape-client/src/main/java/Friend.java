import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("Friend")
public class Friend extends Buddy {
	@ObfuscatedName("u")
	boolean field3629;
	@ObfuscatedName("f")
	boolean field3630;

	Friend() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljn;I)I",
		garbageValue = "-1380403624"
	)
	@Export("compareToFriend")
	int compareToFriend(Friend var1) {
		if (super.world == Client.worldId && Client.worldId != var1.world) {
			return -1;
		} else if (Client.worldId == var1.world && super.world != Client.worldId) {
			return 1;
		} else if (super.world != 0 && var1.world == 0) {
			return -1;
		} else if (var1.world != 0 && super.world == 0) {
			return 1;
		} else if (this.field3629 && !var1.field3629) {
			return -1;
		} else if (!this.field3629 && var1.field3629) {
			return 1;
		} else if (this.field3630 && !var1.field3630) {
			return -1;
		} else if (!this.field3630 && var1.field3630) {
			return 1;
		} else {
			return super.world != 0 ? super.int2 - var1.int2 : var1.int2 - super.int2;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljr;B)I",
		garbageValue = "41"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareToFriend((Friend)var1);
	}

	public int compareTo(Object var1) {
		return this.compareToFriend((Friend)var1);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-825705813"
	)
	public static int method5293(int var0) {
		if (var0 > 0) {
			return 1;
		} else {
			return var0 < 0 ? -1 : 0;
		}
	}

	@ObfuscatedName("jy")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "0"
	)
	@Export("setTapToDrop")
	static void setTapToDrop(boolean var0) {
		Client.tapToDrop = var0;
	}

	@ObfuscatedName("jf")
	@ObfuscatedSignature(
		signature = "(IIII)Lbf;",
		garbageValue = "-252811827"
	)
	static final InterfaceParent method5303(int var0, int var1, int var2) {
		InterfaceParent var3 = new InterfaceParent();
		var3.group = var1;
		var3.type = var2;
		Client.interfaceParents.put(var3, (long)var0);
		WorldMapArea.Widget_resetModelFrames(var1);
		Widget var4 = Language.getWidget(var0);
		ScriptEvent.invalidateWidget(var4);
		if (Client.meslayerContinueWidget != null) {
			ScriptEvent.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

		Varps.method4043();
		MilliClock.revalidateWidgetScroll(FloorDecoration.Widget_interfaceComponents[var0 >> 16], var4, false);
		UserComparator9.runWidgetOnLoadListener(var1);
		if (Client.rootInterface != -1) {
			GrandExchangeEvents.runIntfCloseListeners(Client.rootInterface, 1);
		}

		return var3;
	}
}
