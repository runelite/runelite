import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class145 extends class131 implements MouseWheelListener {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2026172173
   )
   int field2190 = 0;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1818562351"
   )
   public void vmethod3078(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-91872123"
   )
   public void vmethod3079(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2190 += var1.getWheelRotation();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2132796758"
   )
   public synchronized int vmethod3084() {
      int var1 = this.field2190;
      this.field2190 = 0;
      return var1;
   }
}
