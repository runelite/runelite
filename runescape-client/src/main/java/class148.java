import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class148 extends class134 implements MouseWheelListener {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 801632251
   )
   int field2257 = 0;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "603029506"
   )
   public void vmethod3129(Component var1) {
      var1.addMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2257 += var1.getWheelRotation();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1507946839"
   )
   public synchronized int vmethod3131() {
      int var1 = this.field2257;
      this.field2257 = 0;
      return var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "1"
   )
   public void vmethod3139(Component var1) {
      var1.removeMouseWheelListener(this);
   }
}
