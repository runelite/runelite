import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ko")
@Implements("ClanChat")
public class ClanChat extends UserList {
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lkt;"
	)
	@Export("localUser")
	final Usernamed localUser;
	@ObfuscatedName("e")
	@Export("name")
	public String name;
	@ObfuscatedName("s")
	@Export("owner")
	public String owner;
	@ObfuscatedName("p")
	@Export("minKick")
	public byte minKick;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1347537209
	)
	@Export("rank")
	public int rank;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 2146085943
	)
	int field3634;

	@ObfuscatedSignature(
		signature = "(Lmx;Lkt;)V"
	)
	public ClanChat(LoginType var1, Usernamed var2) {
		super(100);
		this.name = null;
		this.owner = null;
		this.field3634 = 1;
		this.loginType = var1;
		this.localUser = var2;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Ljd;",
		garbageValue = "-1332552421"
	)
	@Export("newInstance")
	User newInstance() {
		return new ClanMate();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)[Ljd;",
		garbageValue = "-667029686"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new ClanMate[var1];
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "105"
	)
	@Export("readName")
	final void readName(String var1) {
		this.name = DevicePcmPlayerProvider.method948(var1);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "2103961051"
	)
	@Export("setOwner")
	final void setOwner(String var1) {
		this.owner = DevicePcmPlayerProvider.method948(var1);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "1675969989"
	)
	@Export("readUpdate")
	public final void readUpdate(Buffer var1) {
		this.setOwner(var1.readStringCp1252NullTerminated());
		long var2 = var1.readLong();
		this.readName(GameObject.method3405(var2));
		this.minKick = var1.readByte();
		int var4 = var1.readUnsignedByte();
		if (var4 != 255) {
			this.clear();

			for (int var5 = 0; var5 < var4; ++var5) {
				ClanMate var6 = (ClanMate)this.addLastNoPreviousUsername(new Username(var1.readStringCp1252NullTerminated(), this.loginType));
				int var7 = var1.readUnsignedShort();
				var6.set(var7, ++this.field3634 - 1);
				var6.rank = var1.readByte();
				var1.readStringCp1252NullTerminated();
				this.isLocalPlayer(var6);
			}

		}
	}

	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "-1155305071"
	)
	public final void method5301(Buffer var1) {
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

			var6.set(var3, ++this.field3634 - 1);
			var6.rank = var4;
			this.isLocalPlayer(var6);
		}

	}

	@ObfuscatedName("cj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1797514283"
	)
	@Export("clearFriends")
	public final void clearFriends() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsFriend();
		}

	}

	@ObfuscatedName("cp")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1089464789"
	)
	@Export("invalidateIgnoreds")
	public final void invalidateIgnoreds() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsIgnored();
		}

	}

	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		signature = "(Ljt;I)V",
		garbageValue = "-66701208"
	)
	@Export("isLocalPlayer")
	final void isLocalPlayer(ClanMate var1) {
		if (var1.getUsername().equals(this.localUser.username())) {
			this.rank = var1.rank;
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1033875086"
	)
	static String method5318() {
		String var0;
		if (GrandExchangeOfferOwnWorldComparator.clientPreferences.hideUsername) {
			String var2 = Login.Login_username;
			int var4 = var2.length();
			char[] var5 = new char[var4];

			for (int var6 = 0; var6 < var4; ++var6) {
				var5[var6] = '*';
			}

			String var3 = new String(var5);
			var0 = var3;
		} else {
			var0 = Login.Login_username;
		}

		return var0;
	}
}
