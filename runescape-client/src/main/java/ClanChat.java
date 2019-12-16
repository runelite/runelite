import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
@Implements("ClanChat")
public class ClanChat extends UserList {
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("localUser")
	final Usernamed localUser;
	@ObfuscatedName("d")
	@Export("name")
	public String name;
	@ObfuscatedName("c")
	@Export("owner")
	public String owner;
	@ObfuscatedName("o")
	@Export("minKick")
	public byte minKick;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 208405129
	)
	@Export("rank")
	public int rank;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1142922895
	)
	int field3614;

	@ObfuscatedSignature(
		signature = "(Lll;Ljv;)V"
	)
	public ClanChat(LoginType var1, Usernamed var2) {
		super(100);
		this.name = null;
		this.owner = null;
		this.field3614 = 1;
		this.loginType = var1;
		this.localUser = var2;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)Ljy;",
		garbageValue = "68"
	)
	@Export("newInstance")
	User newInstance() {
		return new ClanMate();
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IB)[Ljy;",
		garbageValue = "32"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new ClanMate[var1];
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "505839882"
	)
	@Export("readName")
	final void readName(String var1) {
		String var3 = CollisionMap.base37DecodeLong(class226.method4101(var1));
		if (var3 == null) {
			var3 = "";
		}

		this.name = var3;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1040645085"
	)
	@Export("setOwner")
	final void setOwner(String var1) {
		String var3 = CollisionMap.base37DecodeLong(class226.method4101(var1));
		if (var3 == null) {
			var3 = "";
		}

		this.owner = var3;
	}

	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		signature = "(Lkq;I)V",
		garbageValue = "171385473"
	)
	@Export("readUpdate")
	public final void readUpdate(Buffer var1) {
		this.setOwner(var1.readStringCp1252NullTerminated());
		long var2 = var1.readLong();
		this.readName(WorldMapIcon_0.method201(var2));
		this.minKick = var1.readByte();
		int var4 = var1.readUnsignedByte();
		if (var4 != 255) {
			this.clear();

			for (int var5 = 0; var5 < var4; ++var5) {
				ClanMate var6 = (ClanMate)this.addLastNoPreviousUsername(new Username(var1.readStringCp1252NullTerminated(), this.loginType));
				int var7 = var1.readUnsignedShort();
				var6.set(var7, ++this.field3614 - 1);
				var6.rank = var1.readByte();
				var1.readStringCp1252NullTerminated();
				this.isLocalPlayer(var6);
			}

		}
	}

	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		signature = "(Lkq;I)V",
		garbageValue = "-1031148737"
	)
	public final void method5262(Buffer var1) {
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

			var6.set(var3, ++this.field3614 - 1);
			var6.rank = var4;
			this.isLocalPlayer(var6);
		}

	}

	@ObfuscatedName("cr")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1039852282"
	)
	@Export("clearFriends")
	public final void clearFriends() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsFriend();
		}

	}

	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "32"
	)
	@Export("invalidateIgnoreds")
	public final void invalidateIgnoreds() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsIgnored();
		}

	}

	@ObfuscatedName("cz")
	@ObfuscatedSignature(
		signature = "(Ljd;I)V",
		garbageValue = "667645943"
	)
	@Export("isLocalPlayer")
	final void isLocalPlayer(ClanMate var1) {
		if (var1.getUsername().equals(this.localUser.username())) {
			this.rank = var1.rank;
		}

	}
}
