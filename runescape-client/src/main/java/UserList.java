import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
@Implements("UserList")
public abstract class UserList {
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -800073163
	)
	@Export("capacity")
	final int capacity;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 894292329
	)
	@Export("size")
	int size;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "[Lju;"
	)
	@Export("array")
	User[] array;
	@ObfuscatedName("t")
	@Export("usernamesMap")
	HashMap usernamesMap;
	@ObfuscatedName("q")
	@Export("previousUsernamesMap")
	HashMap previousUsernamesMap;
	@ObfuscatedName("x")
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

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)Lju;",
		garbageValue = "-192021045"
	)
	@Export("newInstance")
	abstract User newInstance();

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(II)[Lju;",
		garbageValue = "518998026"
	)
	@Export("newTypedArray")
	abstract User[] newTypedArray(int var1);

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1494312128"
	)
	@Export("clear")
	public void clear() {
		this.size = 0;
		Arrays.fill(this.array, (Object)null);
		this.usernamesMap.clear();
		this.previousUsernamesMap.clear();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1766865148"
	)
	@Export("getSize")
	public int getSize() {
		return this.size;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-128"
	)
	@Export("isFull")
	public boolean isFull() {
		return this.size == this.capacity;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljx;S)Z",
		garbageValue = "22737"
	)
	@Export("contains")
	public boolean contains(Username var1) {
		if (!var1.hasCleanName()) {
			return false;
		} else {
			return this.usernamesMap.containsKey(var1) ? true : this.previousUsernamesMap.containsKey(var1);
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(Ljx;I)Lju;",
		garbageValue = "1058289920"
	)
	@Export("getByUsername")
	public User getByUsername(Username var1) {
		User var2 = this.getByCurrentUsername(var1);
		return var2 != null ? var2 : this.getByPreviousUsername(var1);
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ljx;I)Lju;",
		garbageValue = "558762699"
	)
	@Export("getByCurrentUsername")
	User getByCurrentUsername(Username var1) {
		return !var1.hasCleanName() ? null : (User)this.usernamesMap.get(var1);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljx;I)Lju;",
		garbageValue = "1368217697"
	)
	@Export("getByPreviousUsername")
	User getByPreviousUsername(Username var1) {
		return !var1.hasCleanName() ? null : (User)this.previousUsernamesMap.get(var1);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Ljx;B)Z",
		garbageValue = "-8"
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lju;I)V",
		garbageValue = "1902139593"
	)
	@Export("remove")
	final void remove(User var1) {
		int var2 = this.indexOf(var1);
		if (var2 != -1) {
			this.arrayRemove(var2);
			this.mapRemove(var1);
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljx;B)Lju;",
		garbageValue = "118"
	)
	@Export("addLastNoPreviousUsername")
	User addLastNoPreviousUsername(Username var1) {
		return this.addLast(var1, (Username)null);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljx;Ljx;I)Lju;",
		garbageValue = "-1015341374"
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

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)Lju;",
		garbageValue = "2118428404"
	)
	@Export("get")
	public final User get(int var1) {
		if (var1 >= 0 && var1 < this.size) {
			return this.array[var1];
		} else {
			throw new ArrayIndexOutOfBoundsException(var1);
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1838331070"
	)
	@Export("sort")
	public final void sort() {
		if (this.comparator == null) {
			Arrays.sort(this.array, 0, this.size);
		} else {
			Arrays.sort(this.array, 0, this.size, this.comparator);
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lju;Ljx;Ljx;I)V",
		garbageValue = "2089175603"
	)
	@Export("changeName")
	final void changeName(User var1, Username var2, Username var3) {
		this.mapRemove(var1);
		var1.set(var2, var3);
		this.mapPut(var1);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lju;I)I",
		garbageValue = "-2041490811"
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lju;B)V",
		garbageValue = "97"
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

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(Lju;I)V",
		garbageValue = "1221836772"
	)
	@Export("arrayAddLast")
	final void arrayAddLast(User var1) {
		this.array[++this.size - 1] = var1;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(Lju;I)V",
		garbageValue = "-1095094859"
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

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1995849592"
	)
	@Export("arrayRemove")
	final void arrayRemove(int var1) {
		--this.size;
		if (var1 < this.size) {
			System.arraycopy(this.array, var1 + 1, this.array, var1, this.size - var1);
		}

	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	@Export("removeComparator")
	public final void removeComparator() {
		this.comparator = null;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(Ljava/util/Comparator;I)V",
		garbageValue = "-1472739906"
	)
	@Export("addComparator")
	public final void addComparator(Comparator var1) {
		if (this.comparator == null) {
			this.comparator = var1;
		} else if (this.comparator instanceof AbstractUserComparator) {
			((AbstractUserComparator)this.comparator).addComparator(var1);
		}

	}

	@ObfuscatedName("s")
	@Export("sleepMillis")
	public static final void sleepMillis(long var0) {
		if (var0 > 0L) {
			if (0L == var0 % 10L) {
				long var2 = var0 - 1L;

				try {
					Thread.sleep(var2);
				} catch (InterruptedException var8) {
				}

				try {
					Thread.sleep(1L);
				} catch (InterruptedException var7) {
				}
			} else {
				try {
					Thread.sleep(var0);
				} catch (InterruptedException var6) {
				}
			}

		}
	}
}
