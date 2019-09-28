import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("MouseWheelHandler")
public final class MouseWheelHandler implements MouseWheel, MouseWheelListener {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -2136851861
	)
	@Export("rotation")
	int rotation;

	MouseWheelHandler() {
		this.rotation = 0;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/awt/Component;B)V",
		garbageValue = "39"
	)
	@Export("addTo")
	void addTo(Component var1) {
		var1.addMouseWheelListener(this);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Ljava/awt/Component;I)V",
		garbageValue = "-2135806748"
	)
	@Export("removeFrom")
	void removeFrom(Component var1) {
		var1.removeMouseWheelListener(this);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-125"
	)
	@Export("useRotation")
	public synchronized int useRotation() {
		int var1 = this.rotation;
		this.rotation = 0;
		return var1;
	}

	public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
		this.rotation += var1.getWheelRotation();
	}
}
