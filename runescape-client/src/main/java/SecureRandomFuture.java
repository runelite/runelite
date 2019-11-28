import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("SecureRandomFuture")
public class SecureRandomFuture {
	@ObfuscatedName("rh")
	@ObfuscatedGetter(
		intValue = 1810494336
	)
	static int field1242;
	@ObfuscatedName("fx")
	@ObfuscatedSignature(
		signature = "Lfo;"
	)
	@Export("socketTask")
	static Task socketTask;
	@ObfuscatedName("u")
	@Export("executor")
	ExecutorService executor;
	@ObfuscatedName("f")
	@Export("future")
	Future future;

	SecureRandomFuture() {
		this.executor = Executors.newSingleThreadExecutor();
		this.future = this.executor.submit(new SecureRandomCallable());
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "3"
	)
	@Export("shutdown")
	void shutdown() {
		this.executor.shutdown();
		this.executor = null;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "583924598"
	)
	@Export("isDone")
	boolean isDone() {
		return this.future.isDone();
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(B)Ljava/security/SecureRandom;",
		garbageValue = "117"
	)
	@Export("get")
	SecureRandom get() {
		try {
			return (SecureRandom)this.future.get();
		} catch (Exception var2) {
			return NetCache.method4394();
		}
	}
}
