import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gw")
@Implements("ObjectNode")
public class ObjectNode extends Node {
	@ObfuscatedName("x")
	@Export("obj")
	public final Object obj;

	public ObjectNode(Object var1) {
		this.obj = var1;
	}
}
