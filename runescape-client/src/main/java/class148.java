import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public class class148 extends class134 implements MouseWheelListener {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -990271729
   )
   int field2259 = 0;

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2259 += var1.getWheelRotation();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "9"
   )
   public void vmethod3132(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-94"
   )
   public synchronized int vmethod3133() {
      int var1 = this.field2259;
      this.field2259 = 0;
      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1852653658"
   )
   public void vmethod3134(Component var1) {
      var1.addMouseWheelListener(this);
   }
}
