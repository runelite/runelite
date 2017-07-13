import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public final class class49 implements class156, MouseWheelListener {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 822458169
   )
   int field611;

   class49() {
      this.field611 = 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "393932872"
   )
   void method757(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1542201013"
   )
   void method753(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-120"
   )
   public synchronized int vmethod2964() {
      int var1 = this.field611;
      this.field611 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field611 += var1.getWheelRotation();
   }
}
