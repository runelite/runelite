import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class148 extends class134 implements MouseWheelListener {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 629976191
   )
   int field2271 = 0;

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2271 += var1.getWheelRotation();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-2006239529"
   )
   public void vmethod3251(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "11744"
   )
   public void vmethod3252(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "467754474"
   )
   public synchronized int vmethod3254() {
      int var1 = this.field2271;
      this.field2271 = 0;
      return var1;
   }
}
