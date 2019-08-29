import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ds")
@Implements("AbstractSound")
public abstract class AbstractSound extends Node {
	@ObfuscatedName("n")
	@Export("position")
	int position;

	AbstractSound() {
	}
}
