import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public final class class49 implements class156, MouseWheelListener {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1488791709
   )
   int field631;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-82"
   )
   void method724(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-807785110"
   )
   void method725(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   class49() {
      this.field631 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "757553795"
   )
   public synchronized int vmethod2965() {
      int var1 = this.field631;
      this.field631 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field631 += var1.getWheelRotation();
   }
}
