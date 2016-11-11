import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class148 extends class134 implements MouseWheelListener {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -51406865
   )
   int field2261 = 0;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "44"
   )
   public void vmethod3136(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "37"
   )
   public void vmethod3137(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2261 += var1.getWheelRotation();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "915472761"
   )
   public synchronized int vmethod3138() {
      int var1 = this.field2261;
      this.field2261 = 0;
      return var1;
   }
}
