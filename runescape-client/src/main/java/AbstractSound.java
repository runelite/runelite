import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("df")
@Implements("AbstractSound")
public abstract class AbstractSound extends Node {
	@ObfuscatedName("v")
	@Export("position")
	int position;

	AbstractSound() {
	}
}
