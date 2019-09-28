import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
@Implements("UserList")
public abstract class UserList {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 2041615959
	)
	@Export("capacity")
	final int capacity;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1842381401
	)
	@Export("size")
	int size;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "[Ljh;"
	)
	@Export("array")
	User[] array;
	@ObfuscatedName("q")
	@Export("usernamesMap")
	HashMap usernamesMap;
	@ObfuscatedName("m")
	@Export("previousUsernamesMap")
	HashMap previousUsernamesMap;
	@ObfuscatedName("y")
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)Ljh;",
		garbageValue = "2"
	)
	@Export("newInstance")
	abstract User newInstance();

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)[Ljh;",
		garbageValue = "951526901"
	)
	@Export("newTypedArray")
	abstract User[] newTypedArray(int var1);

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1173231376"
	)
	@Export("clear")
	public void clear() {
		this.size = 0;
		Arrays.fill(this.array, (Object)null);
		this.usernamesMap.clear();
		this.previousUsernamesMap.clear();
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "377492255"
	)
	@Export("getSize")
	public int getSize() {
		return this.size;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "905555090"
	)
	@Export("isFull")
	public boolean isFull() {
		return this.capacity == this.size;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljq;I)Z",
		garbageValue = "154884591"
	)
	@Export("contains")
	public boolean contains(Username var1) {
		if (!var1.hasCleanName()) {
			return false;
		} else {
			return this.usernamesMap.containsKey(var1) ? true : this.previousUsernamesMap.containsKey(var1);
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ljq;I)Ljh;",
		garbageValue = "1786549701"
	)
	@Export("getByUsername")
	public User getByUsername(Username var1) {
		User var2 = this.getByCurrentUsername(var1);
		return var2 != null ? var2 : this.getByPreviousUsername(var1);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljq;B)Ljh;",
		garbageValue = "-117"
	)
	@Export("getByCurrentUsername")
	User getByCurrentUsername(Username var1) {
		return !var1.hasCleanName() ? null : (User)this.usernamesMap.get(var1);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Ljq;I)Ljh;",
		garbageValue = "-105614622"
	)
	@Export("getByPreviousUsername")
	User getByPreviousUsername(Username var1) {
		return !var1.hasCleanName() ? null : (User)this.previousUsernamesMap.get(var1);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljq;I)Z",
		garbageValue = "396177459"
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

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljh;I)V",
		garbageValue = "-1534400390"
	)
	@Export("remove")
	final void remove(User var1) {
		int var2 = this.indexOf(var1);
		if (var2 != -1) {
			this.arrayRemove(var2);
			this.mapRemove(var1);
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljq;I)Ljh;",
		garbageValue = "1185457515"
	)
	@Export("addLastNoPreviousUsername")
	User addLastNoPreviousUsername(Username var1) {
		return this.addLast(var1, (Username)null);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ljq;Ljq;S)Ljh;",
		garbageValue = "255"
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
		signature = "(II)Ljh;",
		garbageValue = "2063225233"
	)
	@Export("get")
	public final User get(int var1) {
		if (var1 >= 0 && var1 < this.size) {
			return this.array[var1];
		} else {
			throw new ArrayIndexOutOfBoundsException(var1);
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2147144826"
	)
	@Export("sort")
	public final void sort() {
		if (this.comparator == null) {
			Arrays.sort(this.array, 0, this.size);
		} else {
			Arrays.sort(this.array, 0, this.size, this.comparator);
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(Ljh;Ljq;Ljq;B)V",
		garbageValue = "24"
	)
	@Export("changeName")
	final void changeName(User var1, Username var2, Username var3) {
		this.mapRemove(var1);
		var1.set(var2, var3);
		this.mapPut(var1);
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(Ljh;B)I",
		garbageValue = "4"
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

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(Ljh;I)V",
		garbageValue = "-1535395374"
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

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(Ljh;B)V",
		garbageValue = "3"
	)
	@Export("arrayAddLast")
	final void arrayAddLast(User var1) {
		this.array[++this.size - 1] = var1;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(Ljh;I)V",
		garbageValue = "-1752297517"
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

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "36"
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
		signature = "(B)V",
		garbageValue = "2"
	)
	@Export("removeComparator")
	public final void removeComparator() {
		this.comparator = null;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(Ljava/util/Comparator;B)V",
		garbageValue = "59"
	)
	@Export("addComparator")
	public final void addComparator(Comparator var1) {
		if (this.comparator == null) {
			this.comparator = var1;
		} else if (this.comparator instanceof AbstractUserComparator) {
			((AbstractUserComparator)this.comparator).addComparator(var1);
		}

	}
}
