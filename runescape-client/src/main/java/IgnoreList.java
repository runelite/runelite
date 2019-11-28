import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("IgnoreList")
public class IgnoreList extends UserList {
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	@Export("loginType")
	final LoginType loginType;

	@ObfuscatedSignature(
		signature = "(Llg;)V"
	)
	public IgnoreList(LoginType var1) {
		super(400);
		this.loginType = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Ljr;",
		garbageValue = "-1592540968"
	)
	@Export("newInstance")
	User newInstance() {
		return new Ignored();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IB)[Ljr;",
		garbageValue = "-122"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new Ignored[var1];
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkg;II)V",
		garbageValue = "931957014"
	)
	@Export("read")
	public void read(Buffer var1, int var2) {
		while (true) {
			if (var1.offset < var2) {
				int var3 = var1.readUnsignedByte();
				boolean var4 = (var3 & 1) == 1;
				Username var5 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
				Username var6 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
				var1.readStringCp1252NullTerminated();
				if (var5 != null && var5.hasCleanName()) {
					Ignored var7 = (Ignored)this.getByCurrentUsername(var5);
					if (var4) {
						Ignored var8 = (Ignored)this.getByCurrentUsername(var6);
						if (var8 != null && var7 != var8) {
							if (var7 != null) {
								this.remove(var8);
							} else {
								var7 = var8;
							}
						}
					}

					if (var7 != null) {
						this.changeName(var7, var5, var6);
						continue;
					}

					if (this.getSize() < 400) {
						int var9 = this.getSize();
						var7 = (Ignored)this.addLast(var5, var6);
						var7.id = var9;
					}
					continue;
				}

				throw new IllegalStateException();
			}

			return;
		}
	}
}
