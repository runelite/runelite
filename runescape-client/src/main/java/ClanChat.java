import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
@Implements("ClanChat")
public class ClanChat extends UserList {
	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("worldSelectRightSprite")
	static IndexedSprite worldSelectRightSprite;
	@ObfuscatedName("go")
	@Export("regionLandArchiveIds")
	static int[] regionLandArchiveIds;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Llu;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("localUser")
	final Usernamed localUser;
	@ObfuscatedName("d")
	@Export("name")
	public String name;
	@ObfuscatedName("f")
	@Export("owner")
	public String owner;
	@ObfuscatedName("c")
	@Export("minKick")
	public byte minKick;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1566602861
	)
	@Export("rank")
	public int rank;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 984476847
	)
	int field3616;

	@ObfuscatedSignature(
		signature = "(Llu;Ljs;)V"
	)
	public ClanChat(LoginType var1, Usernamed var2) {
		super(100);
		this.name = null;
		this.owner = null;
		this.field3616 = 1;
		this.loginType = var1;
		this.localUser = var2;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)Lju;",
		garbageValue = "-192021045"
	)
	@Export("newInstance")
	User newInstance() {
		return new ClanMate();
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(II)[Lju;",
		garbageValue = "518998026"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new ClanMate[var1];
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-16"
	)
	@Export("readName")
	final void readName(String var1) {
		this.name = FaceNormal.base37Decode(var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "1"
	)
	@Export("setOwner")
	final void setOwner(String var1) {
		this.owner = FaceNormal.base37Decode(var1);
	}

	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		signature = "(Lky;B)V",
		garbageValue = "8"
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

				for (long var13 = var2; var13 != 0L; var13 /= 37L) {
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
				var9.set(var10, ++this.field3616 - 1);
				var9.rank = var1.readByte();
				var1.readStringCp1252NullTerminated();
				this.isLocalPlayer(var9);
			}

		}
	}

	@ObfuscatedName("cc")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "-1757818732"
	)
	public final void method5135(Buffer var1) {
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

			var6.set(var3, ++this.field3616 - 1);
			var6.rank = var4;
			this.isLocalPlayer(var6);
		}

	}

	@ObfuscatedName("cd")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1788817000"
	)
	@Export("clearFriends")
	public final void clearFriends() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsFriend();
		}

	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-109825958"
	)
	@Export("invalidateIgnoreds")
	public final void invalidateIgnoreds() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsIgnored();
		}

	}

	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		signature = "(Ljr;I)V",
		garbageValue = "-54614880"
	)
	@Export("isLocalPlayer")
	final void isLocalPlayer(ClanMate var1) {
		if (var1.getUsername().equals(this.localUser.username())) {
			this.rank = var1.rank;
		}

	}
}
