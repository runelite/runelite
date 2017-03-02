import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public class class106 extends class112 implements MouseWheelListener {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1573968221
   )
   int field1721 = 0;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1425006577"
   )
   public void vmethod2162(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "236"
   )
   public void vmethod2152(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field1721 += var1.getWheelRotation();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "69"
   )
   public synchronized int vmethod2147() {
      int var1 = this.field1721;
      this.field1721 = 0;
      return var1;
   }
}
