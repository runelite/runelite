import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
@Implements("ClanChat")
public class ClanChat extends UserList {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lmv;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("localUser")
	final Usernamed localUser;
	@ObfuscatedName("m")
	@Export("name")
	public String name;
	@ObfuscatedName("p")
	@Export("owner")
	public String owner;
	@ObfuscatedName("h")
	@Export("minKick")
	public byte minKick;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1887951893
	)
	@Export("rank")
	public int rank;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 404560335
	)
	int field3628;

	@ObfuscatedSignature(
		signature = "(Lmv;Ljh;)V"
	)
	public ClanChat(LoginType var1, Usernamed var2) {
		super(100);
		this.name = null;
		this.owner = null;
		this.field3628 = 1;
		this.loginType = var1;
		this.localUser = var2;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(S)Ljk;",
		garbageValue = "30683"
	)
	@Export("newInstance")
	User newInstance() {
		return new ClanMate();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)[Ljk;",
		garbageValue = "19"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new ClanMate[var1];
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-26"
	)
	@Export("readName")
	final void readName(String var1) {
		String var3 = WorldMapArea.base37DecodeLong(VerticalAlignment.method4424(var1));
		if (var3 == null) {
			var3 = "";
		}

		this.name = var3;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-11"
	)
	@Export("setOwner")
	final void setOwner(String var1) {
		String var3 = WorldMapArea.base37DecodeLong(VerticalAlignment.method4424(var1));
		if (var3 == null) {
			var3 = "";
		}

		this.owner = var3;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkp;I)V",
		garbageValue = "-866668156"
	)
	@Export("readUpdate")
	public final void readUpdate(Buffer var1) {
		this.setOwner(var1.readStringCp1252NullTerminated());
		long var2 = var1.readLong();
		long var5 = var2;
		String var4;
		int var7;
		if (var2 > 0L && var2 < 6582952005840035281L) {
			if (0L == var2 % 37L) {
				var4 = null;
			} else {
				var7 = 0;

				for (long var13 = var2; var13 != 0L; var13 /= 37L) {
					++var7;
				}

				StringBuilder var15 = new StringBuilder(var7);

				while (0L != var5) {
					long var11 = var5;
					var5 /= 37L;
					var15.append(class289.base37Table[(int)(var11 - var5 * 37L)]);
				}

				var4 = var15.reverse().toString();
			}
		} else {
			var4 = null;
		}

		this.readName(var4);
		this.minKick = var1.readByte();
		var7 = var1.readUnsignedByte();
		if (var7 != 255) {
			this.clear();

			for (int var8 = 0; var8 < var7; ++var8) {
				ClanMate var9 = (ClanMate)this.addLastNoPreviousUsername(new Username(var1.readStringCp1252NullTerminated(), this.loginType));
				int var10 = var1.readUnsignedShort();
				var9.set(var10, ++this.field3628 - 1);
				var9.rank = var1.readByte();
				var1.readStringCp1252NullTerminated();
				this.isLocalPlayer(var9);
			}

		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkp;I)V",
		garbageValue = "1239861248"
	)
	public final void method5296(Buffer var1) {
		Username var2 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
		int var3 = var1.readUnsignedShort();
		byte var4 = var1.readByte();
		boolean var5 = false;
		if (var4 == -128) {
			var5 = true;
		}

		ClanMate var6;
		if (var5) {
			if (this.getSize() == 0) {
				return;
			}

			var6 = (ClanMate)this.getByCurrentUsername(var2);
			if (var6 != null && var6.getWorld() == var3) {
				this.remove(var6);
			}
		} else {
			var1.readStringCp1252NullTerminated();
			var6 = (ClanMate)this.getByCurrentUsername(var2);
			if (var6 == null) {
				if (this.getSize() > super.capacity) {
					return;
				}

				var6 = (ClanMate)this.addLastNoPreviousUsername(var2);
			}

			var6.set(var3, ++this.field3628 - 1);
			var6.rank = var4;
			this.isLocalPlayer(var6);
		}

	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "58"
	)
	@Export("clearFriends")
	public final void clearFriends() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsFriend();
		}

	}

	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-275876635"
	)
	@Export("invalidateIgnoreds")
	public final void invalidateIgnoreds() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsIgnored();
		}

	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		signature = "(Ljt;I)V",
		garbageValue = "1790054092"
	)
	@Export("isLocalPlayer")
	final void isLocalPlayer(ClanMate var1) {
		if (var1.getUsername().equals(this.localUser.username())) {
			this.rank = var1.rank;
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lhn;I[B[BI)V",
		garbageValue = "1586924151"
	)
	@Export("Widget_setKey")
	static final void Widget_setKey(Widget var0, int var1, byte[] var2, byte[] var3) {
		if (var0.field2702 == null) {
			if (var2 == null) {
				return;
			}

			var0.field2702 = new byte[11][];
			var0.field2648 = new byte[11][];
			var0.field2649 = new int[11];
			var0.field2560 = new int[11];
		}

		var0.field2702[var1] = var2;
		if (var2 != null) {
			var0.field2646 = true;
		} else {
			var0.field2646 = false;

			for (int var4 = 0; var4 < var0.field2702.length; ++var4) {
				if (var0.field2702[var4] != null) {
					var0.field2646 = true;
					break;
				}
			}
		}

		var0.field2648[var1] = var3;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "520942545"
	)
	@Export("isCharAlphabetic")
	public static boolean isCharAlphabetic(char var0) {
		return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}
}
