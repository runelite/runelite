import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("MenuAction")
public class MenuAction {
	@ObfuscatedName("eh")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive17")
	static Archive archive17;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1152596883
	)
	@Export("param1")
	int param1;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 950122555
	)
	@Export("param0")
	int param0;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 935644857
	)
	@Export("opcode")
	int opcode;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -83774921
	)
	@Export("identifier")
	int identifier;
	@ObfuscatedName("w")
	@Export("action")
	String action;

	MenuAction() {
	}
}
