import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public final class class49 implements class156, MouseWheelListener {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1898805501
   )
   int field638;

   class49() {
      this.field638 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "110"
   )
   void method723(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-103856930"
   )
   void method724(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-103"
   )
   public synchronized int vmethod3019() {
      int var1 = this.field638;
      this.field638 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field638 += var1.getWheelRotation();
   }
}
