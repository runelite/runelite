import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class145 extends class131 implements MouseWheelListener {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1247774039
   )
   int field2221 = 0;

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2221 += var1.getWheelRotation();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-110"
   )
   public void vmethod3091(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "-7680"
   )
   public void vmethod3092(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1704055059"
   )
   public synchronized int vmethod3094() {
      int var1 = this.field2221;
      this.field2221 = 0;
      return var1;
   }
}
