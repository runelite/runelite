import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ee")
public class class145 extends class131 implements MouseWheelListener {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -732532415
   )
   int field2230 = 0;

   @ObfuscatedName("w")
   public void vmethod3122(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("x")
   public void vmethod3123(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2230 += var1.getWheelRotation();
   }

   @ObfuscatedName("t")
   public synchronized int vmethod3129() {
      int var1 = this.field2230;
      this.field2230 = 0;
      return var1;
   }
}
