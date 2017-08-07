import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public final class class49 implements class157, MouseWheelListener {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1491355085
   )
   int field617;

   class49() {
      this.field617 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1234349780"
   )
   void method731(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "941570474"
   )
   void method732(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "111"
   )
   public synchronized int vmethod3010() {
      int var1 = this.field617;
      this.field617 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field617 += var1.getWheelRotation();
   }
}
