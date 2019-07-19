import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
@Implements("Strings")
public class Strings {
	@ObfuscatedName("bg")
	public static String field2811;
	@ObfuscatedName("cs")
	public static String field2961;
	@ObfuscatedName("jm")
	public static String field2942;
	@ObfuscatedName("jj")
	public static String field3027;
	@ObfuscatedName("jr")
	public static String field2768;

	static {
		field2811 = "Please visit the support page for assistance.";
		field2961 = "Please visit the support page for assistance.";
		field2942 = "";
		field3027 = "Page has opened in a new window.";
		field2768 = "(Please check your popup blocker.)";
	}

	@ObfuscatedName("hg")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-495158745"
	)
	static void method4121() {
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
	}

	@ObfuscatedName("jl")
	@ObfuscatedSignature(
		signature = "(Lhj;I)V",
		garbageValue = "-2041903885"
	)
	static void method4120(Widget var0) {
		if (var0.cycle == Client.field741) {
			Client.field843[var0.rootIndex] = true;
		}

	}
}
