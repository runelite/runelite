import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("SecureRandomFuture")
public class SecureRandomFuture {
	@ObfuscatedName("rq")
	@ObfuscatedGetter(
		intValue = 163955328
	)
	static int field1228;
	@ObfuscatedName("cb")
	@ObfuscatedGetter(
		intValue = 515695907
	)
	public static int field1230;
	@ObfuscatedName("z")
	@Export("executor")
	ExecutorService executor;
	@ObfuscatedName("n")
	@Export("future")
	Future future;

	SecureRandomFuture() {
		this.executor = Executors.newSingleThreadExecutor();
		this.future = this.executor.submit(new SecureRandomCallable());
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-128121805"
	)
	@Export("shutdown")
	void shutdown() {
		this.executor.shutdown();
		this.executor = null;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-55622200"
	)
	@Export("isDone")
	boolean isDone() {
		return this.future.isDone();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Ljava/security/SecureRandom;",
		garbageValue = "311645204"
	)
	@Export("get")
	SecureRandom get() {
		try {
			return (SecureRandom)this.future.get();
		} catch (Exception var2) {
			return AttackOption.method2081();
		}
	}

	@ObfuscatedName("ha")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1765847825"
	)
	static void method2138() {
		for (int var0 = 0; var0 < Client.menuOptionsCount; ++var0) {
			if (BZip2State.method5703(Client.menuOpcodes[var0])) {
				if (var0 < Client.menuOptionsCount - 1) {
					for (int var1 = var0; var1 < Client.menuOptionsCount - 1; ++var1) {
						Client.menuActions[var1] = Client.menuActions[var1 + 1];
						Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
						Client.menuOpcodes[var1] = Client.menuOpcodes[var1 + 1];
						Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
						Client.menuArguments1[var1] = Client.menuArguments1[var1 + 1];
						Client.menuArguments2[var1] = Client.menuArguments2[var1 + 1];
						Client.menuShiftClick[var1] = Client.menuShiftClick[var1 + 1];
					}
				}

				--var0;
				--Client.menuOptionsCount;
			}
		}

		UserComparator6.calculateMenuBounds(FriendSystem.menuWidth / 2 + UrlRequester.menuX, class51.menuY);
	}
}
