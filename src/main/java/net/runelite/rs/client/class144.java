import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ep")
public class class144 extends class130 implements MouseWheelListener {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1726578061
   )
   int field2217 = 0;

   @ObfuscatedName("l")
   public void vmethod3057(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2217 += var1.getWheelRotation();
   }

   @ObfuscatedName("a")
   public synchronized int vmethod3058() {
      int var1 = this.field2217;
      this.field2217 = 0;
      return var1;
   }

   @ObfuscatedName("j")
   public void vmethod3060(Component var1) {
      var1.addMouseWheelListener(this);
   }
}
