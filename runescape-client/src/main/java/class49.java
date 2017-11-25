import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public final class class49 implements class157, MouseWheelListener {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 161912637
   )
   int field593;

   class49() {
      this.field593 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1347917312"
   )
   void method748(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "589220243"
   )
   void method745(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "481124921"
   )
   public synchronized int vmethod3103() {
      int var1 = this.field593;
      this.field593 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field593 += var1.getWheelRotation();
   }
}
