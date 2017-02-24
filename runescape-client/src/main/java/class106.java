import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public class class106 extends class112 implements MouseWheelListener {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1413603921
   )
   int field1730 = 0;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-997560499"
   )
   public void vmethod2149(Component var1) {
      var1.addMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field1730 += var1.getWheelRotation();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2129195278"
   )
   public synchronized int vmethod2153() {
      int var1 = this.field1730;
      this.field1730 = 0;
      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-2048667501"
   )
   public void vmethod2146(Component var1) {
      var1.removeMouseWheelListener(this);
   }
}
