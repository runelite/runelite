import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("hx")
@Implements("PlayerType")
public enum PlayerType implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	@Export("PlayerType_normal")
	PlayerType_normal(0, -1, true, false, true),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	@Export("PlayerType_playerModerator")
	PlayerType_playerModerator(1, 0, true, true, true),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	@Export("PlayerType_jagexModerator")
	PlayerType_jagexModerator(2, 1, true, true, false),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	@Export("PlayerType_ironman")
	PlayerType_ironman(3, 2, false, false, true),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	@Export("PlayerType_ultimateIronman")
	PlayerType_ultimateIronman(4, 3, false, false, true),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhx;"
	)
	@Export("PlayerType_hardcoreIronman")
	PlayerType_hardcoreIronman(5, 10, false, false, true);

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		signature = "[Llt;"
	)
	@Export("worldSelectFlagSprites")
	static IndexedSprite[] worldSelectFlagSprites;
	@ObfuscatedName("fr")
	@ObfuscatedSignature(
		signature = "Lfc;"
	)
	@Export("socketTask")
	static Task socketTask;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 981686395
	)
	@Export("id")
	final int id;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 113800329
	)
	@Export("modIcon")
	public final int modIcon;
	@ObfuscatedName("d")
	@Export("isPrivileged")
	public final boolean isPrivileged;
	@ObfuscatedName("z")
	@Export("isUser")
	public final boolean isUser;

	PlayerType(int var3, int var4, boolean var5, boolean var6, boolean var7) {
		this.id = var3;
		this.modIcon = var4;
		this.isPrivileged = var6;
		this.isUser = var7;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1410702910"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(ILkx;Lio;I)V",
		garbageValue = "1911728475"
	)
	static void method4120(int var0, ArchiveDisk var1, Archive var2) {
		byte[] var3 = null;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			for (ArchiveDiskAction var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.last(); var5 != null; var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.previous()) {
				if ((long)var0 == var5.key && var1 == var5.archiveDisk && var5.type == 0) {
					var3 = var5.data;
					break;
				}
			}
		}

		if (var3 != null) {
			var2.load(var1, var0, var3, true);
		} else {
			byte[] var4 = var1.read(var0);
			var2.load(var1, var0, var4, true);
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lhz;II)Z",
		garbageValue = "1300216140"
	)
	@Export("SpriteBuffer_bufferFileFlat")
	public static boolean SpriteBuffer_bufferFileFlat(AbstractArchive var0, int var1) {
		byte[] var2 = var0.takeFileFlat(var1);
		if (var2 == null) {
			return false;
		} else {
			GrandExchangeOfferWorldComparator.SpriteBuffer_decode(var2);
			return true;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "1"
	)
	static int method4121(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 == ScriptOpcodes.IF_GETINVOBJECT) {
			var3 = Player.getWidget(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.itemId;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETINVCOUNT) {
			var3 = Player.getWidget(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.IF_HASSUB) {
			int var5 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var5);
			if (var4 != null) {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 1;
			} else {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETTOP) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.rootInterface;
			return 1;
		} else {
			return 2;
		}
	}
}
