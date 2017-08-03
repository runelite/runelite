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
      intValue = -2068133323
   )
   int field586;

   class49() {
      this.field586 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "-25073"
   )
   void method746(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "22"
   )
   void method747(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public synchronized int vmethod2993() {
      int var1 = this.field586;
      this.field586 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field586 += var1.getWheelRotation();
   }
}
