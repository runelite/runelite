import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class148 extends class134 implements MouseWheelListener {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 697357953
   )
   int field2252 = 0;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "64"
   )
   public void vmethod3097(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2252 += var1.getWheelRotation();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "787452028"
   )
   public synchronized int vmethod3100() {
      int var1 = this.field2252;
      this.field2252 = 0;
      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "2048700153"
   )
   public void vmethod3107(Component var1) {
      var1.addMouseWheelListener(this);
   }
}
