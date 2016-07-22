import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public class class148 extends class134 implements MouseWheelListener {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 25660233
   )
   int field2273 = 0;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1169137639"
   )
   public void vmethod3155(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "25"
   )
   public void vmethod3156(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2273 += var1.getWheelRotation();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "3"
   )
   public synchronized int vmethod3159() {
      int var1 = this.field2273;
      this.field2273 = 0;
      return var1;
   }
}
