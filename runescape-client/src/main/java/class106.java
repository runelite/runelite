import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public class class106 extends class112 implements MouseWheelListener {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1611028915
   )
   int field1738 = 0;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-697633624"
   )
   public void vmethod2141(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "1"
   )
   public void vmethod2142(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field1738 += var1.getWheelRotation();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1653641527"
   )
   public synchronized int vmethod2143() {
      int var1 = this.field1738;
      this.field1738 = 0;
      return var1;
   }
}
