import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class106 extends class112 implements MouseWheelListener {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 298753113
   )
   int field1726 = 0;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "43"
   )
   public void vmethod2079(Component var1) {
      var1.addMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field1726 += var1.getWheelRotation();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-42"
   )
   public synchronized int vmethod2080() {
      int var1 = this.field1726;
      this.field1726 = 0;
      return var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "30871"
   )
   public void vmethod2088(Component var1) {
      var1.removeMouseWheelListener(this);
   }
}
