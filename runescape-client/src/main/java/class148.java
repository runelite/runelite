import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class148 extends class134 implements MouseWheelListener {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 375429231
   )
   int field2278 = 0;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1271826354"
   )
   public void vmethod3136(Component var1) {
      var1.addMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2278 += var1.getWheelRotation();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "5"
   )
   public synchronized int vmethod3138() {
      int var1 = this.field2278;
      this.field2278 = 0;
      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "64"
   )
   public void vmethod3142(Component var1) {
      var1.removeMouseWheelListener(this);
   }
}
