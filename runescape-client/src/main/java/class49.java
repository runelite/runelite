import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public final class class49 implements class156, MouseWheelListener {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 178007497
   )
   int field653;

   class49() {
      this.field653 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1803850038"
   )
   void method757(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1069966957"
   )
   void method758(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2140143046"
   )
   public synchronized int vmethod2960() {
      int var1 = this.field653;
      this.field653 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field653 += var1.getWheelRotation();
   }
}
