import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
public class class106 extends class112 implements MouseWheelListener {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -256314411
   )
   int field1724 = 0;

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field1724 += var1.getWheelRotation();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-141877539"
   )
   public void vmethod2134(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "25104"
   )
   public synchronized int vmethod2133() {
      int var1 = this.field1724;
      this.field1724 = 0;
      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "605815837"
   )
   public void vmethod2135(Component var1) {
      var1.removeMouseWheelListener(this);
   }
}
