import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
@Implements("AbstractSound")
public abstract class AbstractSound extends Node {
	@ObfuscatedName("u")
	@Export("position")
	int position;

	AbstractSound() {
	}
}
