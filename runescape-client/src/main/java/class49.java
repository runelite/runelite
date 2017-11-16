import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public final class class49 implements class157, MouseWheelListener {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -933951091
   )
   int field577;

   class49() {
      this.field577 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-197056414"
   )
   void method692(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "977801244"
   )
   void method697(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1614179796"
   )
   public synchronized int vmethod2987() {
      int var1 = this.field577;
      this.field577 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field577 += var1.getWheelRotation();
   }
}
