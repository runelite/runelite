import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public final class class49 implements class156, MouseWheelListener {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1731171419
   )
   int field642;

   class49() {
      this.field642 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1943000995"
   )
   void method751(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "120"
   )
   void method764(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-254881564"
   )
   public synchronized int vmethod3053() {
      int var1 = this.field642;
      this.field642 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field642 += var1.getWheelRotation();
   }
}
