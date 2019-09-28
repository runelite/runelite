import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("ClanChat")
public class ClanChat extends UserList {
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lju;"
	)
	@Export("localUser")
	final Usernamed localUser;
	@ObfuscatedName("i")
	@Export("name")
	public String name;
	@ObfuscatedName("c")
	@Export("owner")
	public String owner;
	@ObfuscatedName("b")
	@Export("minKick")
	public byte minKick;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 198699637
	)
	@Export("rank")
	public int rank;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -2033888675
	)
	int field3622;

	@ObfuscatedSignature(
		signature = "(Lli;Lju;)V"
	)
	public ClanChat(LoginType var1, Usernamed var2) {
		super(100);
		this.name = null;
		this.owner = null;
		this.field3622 = 1;
		this.loginType = var1;
		this.localUser = var2;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)Ljh;",
		garbageValue = "2"
	)
	@Export("newInstance")
	User newInstance() {
		return new ClanMate();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)[Ljh;",
		garbageValue = "951526901"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new ClanMate[var1];
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "969628158"
	)
	@Export("readName")
	final void readName(String var1) {
		this.name = VertexNormal.method2961(var1);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1129044853"
	)
	@Export("setOwner")
	final void setOwner(String var1) {
		this.owner = VertexNormal.method2961(var1);
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lkl;S)V",
		garbageValue = "20227"
	)
	@Export("readUpdate")
	public final void readUpdate(Buffer var1) {
		this.setOwner(var1.readStringCp1252NullTerminated());
		long var2 = var1.readLong();
		long var5 = var2;
		String var4;
		int var7;
		if (var2 > 0L && var2 < 6582952005840035281L) {
			if (var2 % 37L == 0L) {
				var4 = null;
			} else {
				var7 = 0;

				for (long var13 = var2; 0L != var13; var13 /= 37L) {
					++var7;
				}

				StringBuilder var15 = new StringBuilder(var7);

				while (0L != var5) {
					long var11 = var5;
					var5 /= 37L;
					var15.append(class288.base37Table[(int)(var11 - 37L * var5)]);
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
				var9.set(var10, ++this.field3622 - 1);
				var9.rank = var1.readByte();
				var1.readStringCp1252NullTerminated();
				this.isLocalPlayer(var9);
			}

		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lkl;B)V",
		garbageValue = "-31"
	)
	public final void method5166(Buffer var1) {
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

			var6.set(var3, ++this.field3622 - 1);
			var6.rank = var4;
			this.isLocalPlayer(var6);
		}

	}

	@ObfuscatedName("cr")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "85012014"
	)
	@Export("clearFriends")
	public final void clearFriends() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsFriend();
		}

	}

	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "313560965"
	)
	@Export("invalidateIgnoreds")
	public final void invalidateIgnoreds() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsIgnored();
		}

	}

	@ObfuscatedName("ci")
	@ObfuscatedSignature(
		signature = "(Ljo;I)V",
		garbageValue = "345857456"
	)
	@Export("isLocalPlayer")
	final void isLocalPlayer(ClanMate var1) {
		if (var1.getUsername().equals(this.localUser.username())) {
			this.rank = var1.rank;
		}

	}
}
