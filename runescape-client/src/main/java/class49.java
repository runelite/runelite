import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public final class class49 implements class156, MouseWheelListener {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1601155285
   )
   int field624;

   class49() {
      this.field624 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "1116"
   )
   void method701(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "17"
   )
   void method710(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "928841779"
   )
   public synchronized int vmethod2900() {
      int var1 = this.field624;
      this.field624 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field624 += var1.getWheelRotation();
   }
}
