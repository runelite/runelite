import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public final class class49 implements class156, MouseWheelListener {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1487631565
   )
   int field616;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1876688483"
   )
   void method741(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-801961824"
   )
   void method742(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field616 += var1.getWheelRotation();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1028029173"
   )
   public synchronized int vmethod3012() {
      int var1 = this.field616;
      this.field616 = 0;
      return var1;
   }

   class49() {
      this.field616 = 0;
   }
}
