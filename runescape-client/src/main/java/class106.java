import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public class class106 extends class112 implements MouseWheelListener {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1207877269
   )
   int field1724 = 0;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1898772610"
   )
   public void vmethod2092(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-278207780"
   )
   public void vmethod2084(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-963485446"
   )
   public synchronized int vmethod2087() {
      int var1 = this.field1724;
      this.field1724 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field1724 += var1.getWheelRotation();
   }
}
