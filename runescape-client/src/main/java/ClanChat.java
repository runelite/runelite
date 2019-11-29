import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
@Implements("ClanChat")
public class ClanChat extends UserList {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("localUser")
	final Usernamed localUser;
	@ObfuscatedName("i")
	@Export("name")
	public String name;
	@ObfuscatedName("k")
	@Export("owner")
	public String owner;
	@ObfuscatedName("x")
	@Export("minKick")
	public byte minKick;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 591163035
	)
	@Export("rank")
	public int rank;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1630154821
	)
	int field3639;

	@ObfuscatedSignature(
		signature = "(Llg;Ljv;)V"
	)
	public ClanChat(LoginType var1, Usernamed var2) {
		super(100);
		this.name = null;
		this.owner = null;
		this.field3639 = 1;
		this.loginType = var1;
		this.localUser = var2;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Ljr;",
		garbageValue = "-1592540968"
	)
	@Export("newInstance")
	User newInstance() {
		return new ClanMate();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IB)[Ljr;",
		garbageValue = "-122"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new ClanMate[var1];
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1093647998"
	)
	@Export("readName")
	final void readName(String var1) {
		this.name = GrandExchangeOfferTotalQuantityComparator.method97(var1);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "77"
	)
	@Export("setOwner")
	final void setOwner(String var1) {
		this.owner = GrandExchangeOfferTotalQuantityComparator.method97(var1);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkg;I)V",
		garbageValue = "2029148344"
	)
	@Export("readUpdate")
	public final void readUpdate(Buffer var1) {
		this.setOwner(var1.readStringCp1252NullTerminated());
		long var2 = var1.readLong();
		this.readName(SpriteMask.method4038(var2));
		this.minKick = var1.readByte();
		int var4 = var1.readUnsignedByte();
		if (var4 != 255) {
			this.clear();

			for (int var5 = 0; var5 < var4; ++var5) {
				ClanMate var6 = (ClanMate)this.addLastNoPreviousUsername(new Username(var1.readStringCp1252NullTerminated(), this.loginType));
				int var7 = var1.readUnsignedShort();
				var6.set(var7, ++this.field3639 - 1);
				var6.rank = var1.readByte();
				var1.readStringCp1252NullTerminated();
				this.isLocalPlayer(var6);
			}

		}
	}

	@ObfuscatedName("cr")
	@ObfuscatedSignature(
		signature = "(Lkg;I)V",
		garbageValue = "1670981116"
	)
	public final void method5329(Buffer var1) {
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

			var6.set(var3, ++this.field3639 - 1);
			var6.rank = var4;
			this.isLocalPlayer(var6);
		}

	}

	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "327438402"
	)
	@Export("clearFriends")
	public final void clearFriends() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsFriend();
		}

	}

	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "83"
	)
	@Export("invalidateIgnoreds")
	public final void invalidateIgnoreds() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsIgnored();
		}

	}

	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		signature = "(Ljs;I)V",
		garbageValue = "-2081381015"
	)
	@Export("isLocalPlayer")
	final void isLocalPlayer(ClanMate var1) {
		if (var1.getUsername().equals(this.localUser.username())) {
			this.rank = var1.rank;
		}

	}
}
