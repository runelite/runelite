import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
@Implements("ClanChat")
public class ClanChat extends UserList {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	@Export("localUser")
	final Usernamed localUser;
	@ObfuscatedName("z")
	@Export("name")
	public String name;
	@ObfuscatedName("n")
	@Export("owner")
	public String owner;
	@ObfuscatedName("h")
	@Export("minKick")
	public byte minKick;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 591472141
	)
	@Export("rank")
	public int rank;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1862278063
	)
	int field3609;

	@ObfuscatedSignature(
		signature = "(Lll;Ljj;)V"
	)
	public ClanChat(LoginType var1, Usernamed var2) {
		super(100);
		this.name = null;
		this.owner = null;
		this.field3609 = 1;
		this.loginType = var1;
		this.localUser = var2;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Ljw;",
		garbageValue = "-734254876"
	)
	@Export("newInstance")
	User newInstance() {
		return new ClanMate();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)[Ljw;",
		garbageValue = "1353779565"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new ClanMate[var1];
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "682747367"
	)
	@Export("readName")
	final void readName(String var1) {
		String var3 = StudioGame.base37DecodeLong(MouseHandler.method1041(var1));
		if (var3 == null) {
			var3 = "";
		}

		this.name = var3;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-7"
	)
	@Export("setOwner")
	final void setOwner(String var1) {
		String var3 = StudioGame.base37DecodeLong(MouseHandler.method1041(var1));
		if (var3 == null) {
			var3 = "";
		}

		this.owner = var3;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "110384625"
	)
	@Export("readUpdate")
	public final void readUpdate(Buffer var1) {
		this.setOwner(var1.readStringCp1252NullTerminated());
		long var2 = var1.readLong();
		this.readName(GameObject.method3262(var2));
		this.minKick = var1.readByte();
		int var4 = var1.readUnsignedByte();
		if (var4 != 255) {
			this.clear();

			for (int var5 = 0; var5 < var4; ++var5) {
				ClanMate var6 = (ClanMate)this.addLastNoPreviousUsername(new Username(var1.readStringCp1252NullTerminated(), this.loginType));
				int var7 = var1.readUnsignedShort();
				var6.set(var7, ++this.field3609 - 1);
				var6.rank = var1.readByte();
				var1.readStringCp1252NullTerminated();
				this.isLocalPlayer(var6);
			}

		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "1536132448"
	)
	public final void method5217(Buffer var1) {
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

			var6.set(var3, ++this.field3609 - 1);
			var6.rank = var4;
			this.isLocalPlayer(var6);
		}

	}

	@ObfuscatedName("cl")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-116"
	)
	@Export("clearFriends")
	public final void clearFriends() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsFriend();
		}

	}

	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1536312249"
	)
	@Export("invalidateIgnoreds")
	public final void invalidateIgnoreds() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsIgnored();
		}

	}

	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		signature = "(Ljl;I)V",
		garbageValue = "1986230893"
	)
	@Export("isLocalPlayer")
	final void isLocalPlayer(ClanMate var1) {
		if (var1.getUsername().equals(this.localUser.username())) {
			this.rank = var1.rank;
		}

	}
}
