import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("MouseWheelHandler")
public final class MouseWheelHandler implements MouseWheel, MouseWheelListener {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 441472015
   )
   @Export("rotation")
   int rotation;

   MouseWheelHandler() {
      this.rotation = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "21685107"
   )
   @Export("addTo")
   void addTo(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "956604334"
   )
   @Export("removeFrom")
   void removeFrom(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "68"
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
