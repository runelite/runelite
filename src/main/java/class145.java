import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eb")
public class class145 extends class131 implements MouseWheelListener {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 588487907
   )
   int field2207 = 0;

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2207 += var1.getWheelRotation();
   }

   @ObfuscatedName("s")
   public synchronized int vmethod3105() {
      int var1 = this.field2207;
      this.field2207 = 0;
      return var1;
   }

   @ObfuscatedName("w")
   public void vmethod3110(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("f")
   public void vmethod3113(Component var1) {
      var1.removeMouseWheelListener(this);
   }
}
