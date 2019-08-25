import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("ClientParameter")
public class ClientParameter {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3589;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3582;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3583;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3591;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3585;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3581;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3584;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3588;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3600;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3593;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3590;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3592;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	public static final ClientParameter field3587;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	public static final ClientParameter field3594;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3595;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3596;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3586;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3598;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	static final ClientParameter field3599;
	@ObfuscatedName("t")
	@Export("id")
	public final String id;

	static {
		field3589 = new ClientParameter("8", "8");
		field3582 = new ClientParameter("15", "15");
		field3583 = new ClientParameter("7", "7");
		field3591 = new ClientParameter("10", "10");
		field3585 = new ClientParameter("16", "16");
		field3581 = new ClientParameter("12", "12");
		field3584 = new ClientParameter("3", "3");
		field3588 = new ClientParameter("6", "6");
		field3600 = new ClientParameter("17", "17");
		field3593 = new ClientParameter("5", "5");
		field3590 = new ClientParameter("9", "9");
		field3592 = new ClientParameter("14", "14");
		field3587 = new ClientParameter("18", "18");
		field3594 = new ClientParameter("13", "13");
		field3595 = new ClientParameter("4", "4");
		field3596 = new ClientParameter("1", "1");
		field3586 = new ClientParameter("11", "11");
		field3598 = new ClientParameter("2", "2");
		field3599 = new ClientParameter("19", "19");
	}

	ClientParameter(String var1, String var2) {
		this.id = var2;
	}

	@ObfuscatedName("q")
	static double method4991(double var0) {
		return Math.exp(-var0 * var0 / 2.0D) / Math.sqrt(6.283185307179586D);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(DDII)[D",
		garbageValue = "-694088627"
	)
	public static double[] method4992(double var0, double var2, int var4) {
		int var5 = var4 * 2 + 1;
		double[] var6 = new double[var5];
		int var7 = -var4;

		for (int var8 = 0; var7 <= var4; ++var8) {
			double var11 = method4991(((double)var7 - var0) / var2) / var2;
			var6[var8] = var11;
			++var7;
		}

		return var6;
	}
}
