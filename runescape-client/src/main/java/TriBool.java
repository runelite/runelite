import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
@Implements("TriBool")
public class TriBool {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("TriBool_unknown")
	public static final TriBool TriBool_unknown;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("TriBool_true")
	public static final TriBool TriBool_true;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("TriBool_false")
	public static final TriBool TriBool_false;

	static {
		TriBool_unknown = new TriBool();
		TriBool_true = new TriBool();
		TriBool_false = new TriBool();
	}

	TriBool() {
	}
}
