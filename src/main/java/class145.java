import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class145 extends class131 implements MouseWheelListener {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1900177523
   )
   int field2205 = 0;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1116697844"
   )
   public void vmethod3205(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "214731469"
   )
   public void vmethod3206(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "313"
   )
   public synchronized int vmethod3208() {
      int var1 = this.field2205;
      this.field2205 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2205 += var1.getWheelRotation();
   }
}
