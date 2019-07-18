import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("ClanChat")
public class ClanChat extends UserList {
	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("mapSceneSprites")
	static IndexedSprite[] mapSceneSprites;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lmu;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ljg;"
	)
	@Export("localUser")
	final Usernamed localUser;
	@ObfuscatedName("f")
	@Export("name")
	public String name;
	@ObfuscatedName("m")
	@Export("owner")
	public String owner;
	@ObfuscatedName("u")
	@Export("minKick")
	public byte minKick;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 737707483
	)
	@Export("rank")
	public int rank;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1009556639
	)
	int field3659;

	@ObfuscatedSignature(
		signature = "(Lmu;Ljg;)V"
	)
	public ClanChat(LoginType var1, Usernamed var2) {
		super(100);
		this.name = null;
		this.owner = null;
		this.field3659 = 1;
		this.loginType = var1;
		this.localUser = var2;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Ljd;",
		garbageValue = "2016619159"
	)
	@Export("newInstance")
	User newInstance() {
		return new ClanMate();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)[Ljd;",
		garbageValue = "2126056206"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new ClanMate[var1];
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1948396413"
	)
	final void method5231(String var1) {
		this.name = VarcInt.method4403(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "537403926"
	)
	final void method5232(String var1) {
		this.owner = VarcInt.method4403(var1);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "-1982298123"
	)
	@Export("readUpdate")
	public final void readUpdate(Buffer var1) {
		this.method5232(var1.readStringCp1252NullTerminated());
		long var2 = var1.readLong();
		this.method5231(Tile.method2855(var2));
		this.minKick = var1.readByte();
		int var4 = var1.readUnsignedByte();
		if (var4 != 255) {
			this.clear();

			for (int var5 = 0; var5 < var4; ++var5) {
				ClanMate var6 = (ClanMate)this.addLastNoPreviousUsername(new Username(var1.readStringCp1252NullTerminated(), this.loginType));
				int var7 = var1.readUnsignedShort();
				var6.set(var7, ++this.field3659 - 1);
				var6.rank = var1.readByte();
				var1.readStringCp1252NullTerminated();
				this.isLocalPlayer(var6);
			}

		}
	}

	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "-891757405"
	)
	public final void method5234(Buffer var1) {
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

			var6.set(var3, ++this.field3659 - 1);
			var6.rank = var4;
			this.isLocalPlayer(var6);
		}

	}

	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-415731818"
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
		garbageValue = "17638925"
	)
	@Export("clearIgnoreds")
	public final void clearIgnoreds() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsIgnored();
		}

	}

	@ObfuscatedName("ch")
	@ObfuscatedSignature(
		signature = "(Ljw;I)V",
		garbageValue = "1755545327"
	)
	@Export("isLocalPlayer")
	final void isLocalPlayer(ClanMate var1) {
		if (var1.getUsername().equals(this.localUser.username())) {
			this.rank = var1.rank;
		}

	}
}
