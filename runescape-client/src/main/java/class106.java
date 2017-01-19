import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
public class class106 extends class112 implements MouseWheelListener {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1247410539
   )
   int field1727 = 0;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "1"
   )
   public void vmethod2041(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "52"
   )
   public void vmethod2036(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-341649815"
   )
   public synchronized int vmethod2037() {
      int var1 = this.field1727;
      this.field1727 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field1727 += var1.getWheelRotation();
   }
}
