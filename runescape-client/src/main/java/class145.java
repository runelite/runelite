import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class145 extends class131 implements MouseWheelListener {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1771649349
   )
   int field2194 = 0;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-223310101"
   )
   public void vmethod3114(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "934171121"
   )
   public void vmethod3115(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2194 += var1.getWheelRotation();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-12"
   )
   public synchronized int vmethod3116() {
      int var1 = this.field2194;
      this.field2194 = 0;
      return var1;
   }
}
