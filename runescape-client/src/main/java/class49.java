import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public final class class49 implements class157, MouseWheelListener {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -730390075
   )
   int field602;

   class49() {
      this.field602 = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1253358471"
   )
   void method812(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1726271649"
   )
   void method805(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "16"
   )
   public synchronized int vmethod3080() {
      int var1 = this.field602;
      this.field602 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field602 += var1.getWheelRotation();
   }
}
