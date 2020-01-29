import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("jm")
@Implements("UserList")
public abstract class UserList {
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1736832459
	)
	@Export("capacity")
	final int capacity;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 114939403
	)
	@Export("size")
	int size;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "[Ljk;"
	)
	@Export("array")
	User[] array;
	@ObfuscatedName("d")
	@Export("usernamesMap")
	HashMap usernamesMap;
	@ObfuscatedName("l")
	@Export("previousUsernamesMap")
	HashMap previousUsernamesMap;
	@ObfuscatedName("j")
	@Export("comparator")
	Comparator comparator;

	UserList(int var1) {
		this.size = 0;
		this.comparator = null;
		this.capacity = var1;
		this.array = this.newTypedArray(var1);
		this.usernamesMap = new HashMap(var1 / 8);
		this.previousUsernamesMap = new HashMap(var1 / 8);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(S)Ljk;",
		garbageValue = "30683"
	)
	@Export("newInstance")
	abstract User newInstance();

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)[Ljk;",
		garbageValue = "19"
	)
	@Export("newTypedArray")
	abstract User[] newTypedArray(int var1);

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "847313587"
	)
	@Export("clear")
	public void clear() {
		this.size = 0;
		Arrays.fill(this.array, (Object)null);
		this.usernamesMap.clear();
		this.previousUsernamesMap.clear();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-444681526"
	)
	@Export("getSize")
	public int getSize() {
		return this.size;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1093222971"
	)
	@Export("isFull")
	public boolean isFull() {
		return this.size == this.capacity;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljz;I)Z",
		garbageValue = "645077874"
	)
	@Export("contains")
	public boolean contains(Username var1) {
		if (!var1.hasCleanName()) {
			return false;
		} else {
			return this.usernamesMap.containsKey(var1) ? true : this.previousUsernamesMap.containsKey(var1);
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljz;I)Ljk;",
		garbageValue = "111553486"
	)
	@Export("getByUsername")
	public User getByUsername(Username var1) {
		User var2 = this.getByCurrentUsername(var1);
		return var2 != null ? var2 : this.getByPreviousUsername(var1);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljz;I)Ljk;",
		garbageValue = "-632690223"
	)
	@Export("getByCurrentUsername")
	User getByCurrentUsername(Username var1) {
		return !var1.hasCleanName() ? null : (User)this.usernamesMap.get(var1);
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ljz;B)Ljk;",
		garbageValue = "-97"
	)
	@Export("getByPreviousUsername")
	User getByPreviousUsername(Username var1) {
		return !var1.hasCleanName() ? null : (User)this.previousUsernamesMap.get(var1);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljz;I)Z",
		garbageValue = "379093551"
	)
	@Export("removeByUsername")
	public final boolean removeByUsername(Username var1) {
		User var2 = this.getByCurrentUsername(var1);
		if (var2 == null) {
			return false;
		} else {
			this.remove(var2);
			return true;
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljk;I)V",
		garbageValue = "144802420"
	)
	@Export("remove")
	final void remove(User var1) {
		int var2 = this.indexOf(var1);
		if (var2 != -1) {
			this.arrayRemove(var2);
			this.mapRemove(var1);
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljz;I)Ljk;",
		garbageValue = "450603537"
	)
	@Export("addLastNoPreviousUsername")
	User addLastNoPreviousUsername(Username var1) {
		return this.addLast(var1, (Username)null);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(Ljz;Ljz;B)Ljk;",
		garbageValue = "0"
	)
	@Export("addLast")
	User addLast(Username var1, Username var2) {
		if (this.getByCurrentUsername(var1) != null) {
			throw new IllegalStateException();
		} else {
			User var3 = this.newInstance();
			var3.set(var1, var2);
			this.arrayAddLast(var3);
			this.mapPut(var3);
			return var3;
		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(II)Ljk;",
		garbageValue = "1668205012"
	)
	@Export("get")
	public final User get(int var1) {
		if (var1 >= 0 && var1 < this.size) {
			return this.array[var1];
		} else {
			throw new ArrayIndexOutOfBoundsException(var1);
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1810920855"
	)
	@Export("sort")
	public final void sort() {
		if (this.comparator == null) {
			Arrays.sort(this.array, 0, this.size);
		} else {
			Arrays.sort(this.array, 0, this.size, this.comparator);
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(Ljk;Ljz;Ljz;I)V",
		garbageValue = "-1039891004"
	)
	@Export("changeName")
	final void changeName(User var1, Username var2, Username var3) {
		this.mapRemove(var1);
		var1.set(var2, var3);
		this.mapPut(var1);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(Ljk;I)I",
		garbageValue = "-147054371"
	)
	@Export("indexOf")
	final int indexOf(User var1) {
		for (int var2 = 0; var2 < this.size; ++var2) {
			if (this.array[var2] == var1) {
				return var2;
			}
		}

		return -1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(Ljk;I)V",
		garbageValue = "1037986229"
	)
	@Export("mapRemove")
	final void mapRemove(User var1) {
		if (this.usernamesMap.remove(var1.username) == null) {
			throw new IllegalStateException();
		} else {
			if (var1.previousUsername != null) {
				this.previousUsernamesMap.remove(var1.previousUsername);
			}

		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(Ljk;B)V",
		garbageValue = "127"
	)
	@Export("arrayAddLast")
	final void arrayAddLast(User var1) {
		this.array[++this.size - 1] = var1;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(Ljk;I)V",
		garbageValue = "2145132082"
	)
	@Export("mapPut")
	final void mapPut(User var1) {
		this.usernamesMap.put(var1.username, var1);
		if (var1.previousUsername != null) {
			User var2 = (User)this.previousUsernamesMap.put(var1.previousUsername, var1);
			if (var2 != null && var2 != var1) {
				var2.previousUsername = null;
			}
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "45023574"
	)
	@Export("arrayRemove")
	final void arrayRemove(int var1) {
		--this.size;
		if (var1 < this.size) {
			System.arraycopy(this.array, var1 + 1, this.array, var1, this.size - var1);
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "186565478"
	)
	@Export("removeComparator")
	public final void removeComparator() {
		this.comparator = null;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(Ljava/util/Comparator;I)V",
		garbageValue = "-144770664"
	)
	@Export("addComparator")
	public final void addComparator(Comparator var1) {
		if (this.comparator == null) {
			this.comparator = var1;
		} else if (this.comparator instanceof AbstractUserComparator) {
			((AbstractUserComparator)this.comparator).addComparator(var1);
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IILfk;Lfv;I)Z",
		garbageValue = "715183629"
	)
	public static final boolean method5167(int var0, int var1, RouteStrategy var2, CollisionMap var3) {
		int var4 = var0;
		int var5 = var1;
		byte var6 = 64;
		byte var7 = 64;
		int var8 = var0 - var6;
		int var9 = var1 - var7;
		class173.directions[var6][var7] = 99;
		class173.distances[var6][var7] = 0;
		byte var10 = 0;
		int var11 = 0;
		class173.bufferX[var10] = var0;
		byte var10001 = var10;
		int var18 = var10 + 1;
		class173.bufferY[var10001] = var1;
		int[][] var12 = var3.flags;

		while (var18 != var11) {
			var4 = class173.bufferX[var11];
			var5 = class173.bufferY[var11];
			var11 = var11 + 1 & 4095;
			int var16 = var4 - var8;
			int var17 = var5 - var9;
			int var13 = var4 - var3.xInset;
			int var14 = var5 - var3.yInset;
			if (var2.hasArrived(1, var4, var5, var3)) {
				ChatChannel.field1289 = var4;
				class173.field2093 = var5;
				return true;
			}

			int var15 = class173.distances[var16][var17] + 1;
			if (var16 > 0 && class173.directions[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
				class173.bufferX[var18] = var4 - 1;
				class173.bufferY[var18] = var5;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 - 1][var17] = 2;
				class173.distances[var16 - 1][var17] = var15;
			}

			if (var16 < 127 && class173.directions[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
				class173.bufferX[var18] = var4 + 1;
				class173.bufferY[var18] = var5;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 + 1][var17] = 8;
				class173.distances[var16 + 1][var17] = var15;
			}

			if (var17 > 0 && class173.directions[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
				class173.bufferX[var18] = var4;
				class173.bufferY[var18] = var5 - 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16][var17 - 1] = 1;
				class173.distances[var16][var17 - 1] = var15;
			}

			if (var17 < 127 && class173.directions[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
				class173.bufferX[var18] = var4;
				class173.bufferY[var18] = var5 + 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16][var17 + 1] = 4;
				class173.distances[var16][var17 + 1] = var15;
			}

			if (var16 > 0 && var17 > 0 && class173.directions[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
				class173.bufferX[var18] = var4 - 1;
				class173.bufferY[var18] = var5 - 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 - 1][var17 - 1] = 3;
				class173.distances[var16 - 1][var17 - 1] = var15;
			}

			if (var16 < 127 && var17 > 0 && class173.directions[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
				class173.bufferX[var18] = var4 + 1;
				class173.bufferY[var18] = var5 - 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 + 1][var17 - 1] = 9;
				class173.distances[var16 + 1][var17 - 1] = var15;
			}

			if (var16 > 0 && var17 < 127 && class173.directions[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
				class173.bufferX[var18] = var4 - 1;
				class173.bufferY[var18] = var5 + 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 - 1][var17 + 1] = 6;
				class173.distances[var16 - 1][var17 + 1] = var15;
			}

			if (var16 < 127 && var17 < 127 && class173.directions[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
				class173.bufferX[var18] = var4 + 1;
				class173.bufferY[var18] = var5 + 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 + 1][var17 + 1] = 12;
				class173.distances[var16 + 1][var17 + 1] = var15;
			}
		}

		ChatChannel.field1289 = var4;
		class173.field2093 = var5;
		return false;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "-495480060"
	)
	static int method5212(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? class186.field2331 : MidiPcmStream.field2444;
		if (var0 == ScriptOpcodes.CC_GETSCROLLX) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.scrollX;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETSCROLLY) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.scrollY;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETTEXT) {
			Interpreter.Interpreter_stringStack[++Message.Interpreter_stringStackSize - 1] = var3.text;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETSCROLLWIDTH) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.scrollWidth;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETSCROLLHEIGHT) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.scrollHeight;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELZOOM) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.modelZoom;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELANGLE_X) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.modelAngleX;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELANGLE_Z) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.modelAngleZ;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELANGLE_Y) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.modelAngleY;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETTRANSTOP) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.transparencyTop;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETTRANSBOT) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.transparencyBot;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETCOLOUR) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.color;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETFILLCOLOUR) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.color2;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETFILLMODE) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELTRANSPARENT) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}
}
