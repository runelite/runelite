import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class145 extends class131 implements MouseWheelListener {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -913414103
   )
   int field2244 = 0;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "2083947646"
   )
   public void vmethod3072(Component var1) {
      var1.addMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2244 += var1.getWheelRotation();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-66"
   )
   public synchronized int vmethod3074() {
      int var1 = this.field2244;
      this.field2244 = 0;
      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "0"
   )
   public void vmethod3075(Component var1) {
      var1.removeMouseWheelListener(this);
   }
}
