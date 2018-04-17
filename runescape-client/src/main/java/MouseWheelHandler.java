import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("MouseWheelHandler")
public final class MouseWheelHandler implements MouseWheel, MouseWheelListener {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1575213019
   )
   @Export("rotation")
   int rotation;

   MouseWheelHandler() {
      this.rotation = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1280348063"
   )
   @Export("addTo")
   void addTo(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1961870027"
   )
   @Export("removeFrom")
   void removeFrom(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-19384"
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
