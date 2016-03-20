import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("es")
public class class144 extends class130 implements MouseWheelListener {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -804533007
   )
   int field2197 = 0;

   @ObfuscatedName("s")
   public synchronized int vmethod3111() {
      int var1 = this.field2197;
      this.field2197 = 0;
      return var1;
   }

   @ObfuscatedName("f")
   public void vmethod3114(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("r")
   public void vmethod3115(Component var1) {
      var1.addMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2197 += var1.getWheelRotation();
   }
}
