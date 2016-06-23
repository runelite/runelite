import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class145 extends class131 implements MouseWheelListener {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1127199195
   )
   int field2209 = 0;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "8"
   )
   public void vmethod3135(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-557998794"
   )
   public void vmethod3136(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2209 += var1.getWheelRotation();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "305248911"
   )
   public synchronized int vmethod3141() {
      int var1 = this.field2209;
      this.field2209 = 0;
      return var1;
   }
}
