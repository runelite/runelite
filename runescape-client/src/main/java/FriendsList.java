import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("FriendsList")
public class FriendsList extends UserList {
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lmu;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -374978569
	)
	int field3643;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lje;"
	)
	@Export("friendLoginUpdates")
	public LinkDeque friendLoginUpdates;

	@ObfuscatedSignature(
		signature = "(Lmu;)V"
	)
	public FriendsList(LoginType var1) {
		super(400);
		this.field3643 = 1;
		this.friendLoginUpdates = new LinkDeque();
		this.loginType = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Ljd;",
		garbageValue = "2016619159"
	)
	@Export("newInstance")
	User newInstance() {
		return new Friend();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)[Ljd;",
		garbageValue = "2126056206"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new Friend[var1];
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ljv;ZI)Z",
		garbageValue = "547540517"
	)
	@Export("isFriended")
	public boolean isFriended(Username var1, boolean var2) {
		Friend var3 = (Friend)this.getByUsername(var1);
		if (var3 == null) {
			return false;
		} else {
			return !var2 || var3.world != 0;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkf;II)V",
		garbageValue = "2066125669"
	)
	@Export("read")
	public void read(Buffer var1, int var2) {
		while (true) {
			if (var1.offset < var2) {
				boolean var3 = var1.readUnsignedByte() == 1;
				Username var4 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
				Username var5 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
				int var6 = var1.readUnsignedShort();
				int var7 = var1.readUnsignedByte();
				int var8 = var1.readUnsignedByte();
				boolean var9 = (var8 & 2) != 0;
				boolean var10 = (var8 & 1) != 0;
				if (var6 > 0) {
					var1.readStringCp1252NullTerminated();
					var1.readUnsignedByte();
					var1.readInt();
				}

				var1.readStringCp1252NullTerminated();
				if (var4 != null && var4.hasCleanName()) {
					Friend var11 = (Friend)this.getByCurrentUsername(var4);
					if (var3) {
						Friend var12 = (Friend)this.getByCurrentUsername(var5);
						if (var12 != null && var11 != var12) {
							if (var11 != null) {
								this.remove(var12);
							} else {
								var11 = var12;
							}
						}
					}

					if (var11 != null) {
						this.changeName(var11, var4, var5);
						if (var6 != var11.world) {
							boolean var14 = true;

							for (FriendLoginUpdate var13 = (FriendLoginUpdate)this.friendLoginUpdates.last(); var13 != null; var13 = (FriendLoginUpdate)this.friendLoginUpdates.previous()) {
								if (var13.username.equals(var4)) {
									if (var6 != 0 && var13.world == 0) {
										var13.remove();
										var14 = false;
									} else if (var6 == 0 && var13.world != 0) {
										var13.remove();
										var14 = false;
									}
								}
							}

							if (var14) {
								this.friendLoginUpdates.addFirst(new FriendLoginUpdate(var4, var6));
							}
						}
					} else {
						if (this.getSize() >= 400) {
							continue;
						}

						var11 = (Friend)this.addLast(var4, var5);
					}

					if (var6 != var11.world) {
						var11.int2 = ++this.field3643 - 1;
						if (var11.world == -1 && var6 == 0) {
							var11.int2 = -(var11.int2 * -782754599) * -1246846103;
						}

						var11.world = var6;
					}

					var11.rank = var7;
					var11.field3650 = var9;
					var11.field3651 = var10;
					continue;
				}

				throw new IllegalStateException();
			}

			this.sort();
			return;
		}
	}
}
