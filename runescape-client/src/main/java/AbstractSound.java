import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("du")
@Implements("AbstractSound")
public abstract class AbstractSound extends Node {
	@ObfuscatedName("l")
	@Export("position")
	int position;

	AbstractSound() {
	}
}
