import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("SecureRandomFuture")
public class SecureRandomFuture {
	@ObfuscatedName("ho")
	@ObfuscatedGetter(
		intValue = -209939989
	)
	@Export("oculusOrbFocalPointX")
	static int oculusOrbFocalPointX;
	@ObfuscatedName("c")
	@Export("executor")
	ExecutorService executor;
	@ObfuscatedName("x")
	@Export("future")
	Future future;

	SecureRandomFuture() {
		this.executor = Executors.newSingleThreadExecutor();
		this.future = this.executor.submit(new SecureRandomCallable());
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "17"
	)
	@Export("shutdown")
	void shutdown() {
		this.executor.shutdown();
		this.executor = null;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1733947901"
	)
	@Export("isDone")
	boolean isDone() {
		return this.future.isDone();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Ljava/security/SecureRandom;",
		garbageValue = "1840325785"
	)
	@Export("get")
	SecureRandom get() {
		try {
			return (SecureRandom)this.future.get();
		} catch (Exception var4) {
			SecureRandom var3 = new SecureRandom();
			var3.nextInt();
			return var3;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lbs;I)V",
		garbageValue = "-1751721951"
	)
	@Export("runScriptEvent")
	public static void runScriptEvent(ScriptEvent var0) {
		GameShell.runScript(var0, 500000);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1744475740"
	)
	public static int method2101(int var0) {
		return Entity_unpackID(ViewportMouse.ViewportMouse_entityTags[var0]);
	}

	@ObfuscatedName("l")
	@Export("Entity_unpackID")
	public static int Entity_unpackID(long var0) {
		return (int)(var0 >>> 17 & 4294967295L);
	}
}
