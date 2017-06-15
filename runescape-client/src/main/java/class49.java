import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public final class class49 implements class156, MouseWheelListener {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -328045085
   )
   int field633;

   class49() {
      this.field633 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-123"
   )
   void method694(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "21246"
   )
   void method695(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field633 += var1.getWheelRotation();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "127"
   )
   public synchronized int vmethod2858() {
      int var1 = this.field633;
      this.field633 = 0;
      return var1;
   }
}
