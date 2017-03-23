import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class106 extends class112 implements MouseWheelListener {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -775418873
   )
   int field1751 = 0;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1834402333"
   )
   public void vmethod2134(Component var1) {
      var1.addMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field1751 += var1.getWheelRotation();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-113"
   )
   public synchronized int vmethod2136() {
      int var1 = this.field1751;
      this.field1751 = 0;
      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "51"
   )
   public void vmethod2143(Component var1) {
      var1.removeMouseWheelListener(this);
   }
}
