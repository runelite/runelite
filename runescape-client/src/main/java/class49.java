import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public final class class49 implements class156, MouseWheelListener {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1225523503
   )
   int field616;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1165806257"
   )
   void method715(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "606222834"
   )
   void method716(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "71"
   )
   public synchronized int vmethod2970() {
      int var1 = this.field616;
      this.field616 = 0;
      return var1;
   }

   class49() {
      this.field616 = 0;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field616 += var1.getWheelRotation();
   }
}
