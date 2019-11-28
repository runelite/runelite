import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("UserList")
public abstract class UserList {
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1586707149
	)
	@Export("capacity")
	final int capacity;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1996430119
	)
	@Export("size")
	int size;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "[Ljr;"
	)
	@Export("array")
	User[] array;
	@ObfuscatedName("h")
	@Export("usernamesMap")
	HashMap usernamesMap;
	@ObfuscatedName("y")
	@Export("previousUsernamesMap")
	HashMap previousUsernamesMap;
	@ObfuscatedName("w")
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Ljr;",
		garbageValue = "-1592540968"
	)
	@Export("newInstance")
	abstract User newInstance();

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IB)[Ljr;",
		garbageValue = "-122"
	)
	@Export("newTypedArray")
	abstract User[] newTypedArray(int var1);

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1907320088"
	)
	@Export("clear")
	public void clear() {
		this.size = 0;
		Arrays.fill(this.array, (Object)null);
		this.usernamesMap.clear();
		this.previousUsernamesMap.clear();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-375744774"
	)
	@Export("getSize")
	public int getSize() {
		return this.size;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1219500573"
	)
	@Export("isFull")
	public boolean isFull() {
		return this.capacity == this.size;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljb;I)Z",
		garbageValue = "-149111552"
	)
	@Export("contains")
	public boolean contains(Username var1) {
		if (!var1.hasCleanName()) {
			return false;
		} else {
			return this.usernamesMap.containsKey(var1) ? true : this.previousUsernamesMap.containsKey(var1);
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljb;I)Ljr;",
		garbageValue = "1256071424"
	)
	@Export("getByUsername")
	public User getByUsername(Username var1) {
		User var2 = this.getByCurrentUsername(var1);
		return var2 != null ? var2 : this.getByPreviousUsername(var1);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljb;I)Ljr;",
		garbageValue = "1486275589"
	)
	@Export("getByCurrentUsername")
	User getByCurrentUsername(Username var1) {
		return !var1.hasCleanName() ? null : (User)this.usernamesMap.get(var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljb;I)Ljr;",
		garbageValue = "-434760429"
	)
	@Export("getByPreviousUsername")
	User getByPreviousUsername(Username var1) {
		return !var1.hasCleanName() ? null : (User)this.previousUsernamesMap.get(var1);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljb;I)Z",
		garbageValue = "1488829277"
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljr;I)V",
		garbageValue = "-23502299"
	)
	@Export("remove")
	final void remove(User var1) {
		int var2 = this.indexOf(var1);
		if (var2 != -1) {
			this.arrayRemove(var2);
			this.mapRemove(var1);
		}
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(Ljb;I)Ljr;",
		garbageValue = "16711680"
	)
	@Export("addLastNoPreviousUsername")
	User addLastNoPreviousUsername(Username var1) {
		return this.addLast(var1, (Username)null);
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(Ljb;Ljb;I)Ljr;",
		garbageValue = "-1408051568"
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

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(II)Ljr;",
		garbageValue = "1364470025"
	)
	@Export("get")
	public final User get(int var1) {
		if (var1 >= 0 && var1 < this.size) {
			return this.array[var1];
		} else {
			throw new ArrayIndexOutOfBoundsException(var1);
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-23"
	)
	@Export("sort")
	public final void sort() {
		if (this.comparator == null) {
			Arrays.sort(this.array, 0, this.size);
		} else {
			Arrays.sort(this.array, 0, this.size, this.comparator);
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(Ljr;Ljb;Ljb;B)V",
		garbageValue = "48"
	)
	@Export("changeName")
	final void changeName(User var1, Username var2, Username var3) {
		this.mapRemove(var1);
		var1.set(var2, var3);
		this.mapPut(var1);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(Ljr;I)I",
		garbageValue = "790634054"
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

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(Ljr;I)V",
		garbageValue = "-1688950859"
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

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(Ljr;B)V",
		garbageValue = "-92"
	)
	@Export("arrayAddLast")
	final void arrayAddLast(User var1) {
		this.array[++this.size - 1] = var1;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(Ljr;I)V",
		garbageValue = "314346043"
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

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "602871517"
	)
	@Export("arrayRemove")
	final void arrayRemove(int var1) {
		--this.size;
		if (var1 < this.size) {
			System.arraycopy(this.array, var1 + 1, this.array, var1, this.size - var1);
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "67"
	)
	@Export("removeComparator")
	public final void removeComparator() {
		this.comparator = null;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(Ljava/util/Comparator;B)V",
		garbageValue = "99"
	)
	@Export("addComparator")
	public final void addComparator(Comparator var1) {
		if (this.comparator == null) {
			this.comparator = var1;
		} else if (this.comparator instanceof AbstractUserComparator) {
			((AbstractUserComparator)this.comparator).addComparator(var1);
		}

	}

	@ObfuscatedName("jn")
	@ObfuscatedSignature(
		signature = "(Lhl;I)V",
		garbageValue = "1273300851"
	)
	static final void method5233(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 324) {
			if (Client.field906 == -1) {
				Client.field906 = var0.spriteId2;
				Client.field907 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field906;
			} else {
				var0.spriteId2 = Client.field907;
			}

		} else if (var1 == 325) {
			if (Client.field906 == -1) {
				Client.field906 = var0.spriteId2;
				Client.field907 = var0.spriteId;
			}

			if (Client.playerAppearance.isFemale) {
				var0.spriteId2 = Client.field907;
			} else {
				var0.spriteId2 = Client.field906;
			}

		} else if (var1 == 327) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 0;
		} else if (var1 == 328) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 1;
		}
	}
}
