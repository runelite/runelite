import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
@Implements("Buddy")
public class Buddy extends User {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1985676249
	)
	@Export("world")
	public int world;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1502929201
	)
	@Export("int2")
	public int int2;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -588738279
	)
	@Export("rank")
	public int rank;

	Buddy() {
		this.world = -1;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(IIS)V",
		garbageValue = "13296"
	)
	@Export("set")
	void set(int var1, int var2) {
		this.world = var1;
		this.int2 = var2;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1862219925"
	)
	@Export("getWorld")
	public int getWorld() {
		return this.world;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-127464442"
	)
	@Export("hasWorld")
	public boolean hasWorld() {
		return this.world > 0;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "595265698"
	)
	static void method5251() {
		if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
			Login.currentLoginField = 1;
		} else {
			Login.currentLoginField = 0;
		}

	}
}
