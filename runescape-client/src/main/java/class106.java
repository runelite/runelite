import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public class class106 extends class112 implements MouseWheelListener {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -958981141
   )
   int field1713;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1065815514"
   )
   public synchronized int vmethod2113() {
      int var1 = this.field1713;
      this.field1713 = 0;
      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "1"
   )
   public void vmethod2102(Component var1) {
      var1.addMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field1713 += var1.getWheelRotation();
   }

   public class106() {
      this.field1713 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "59"
   )
   public void vmethod2103(Component var1) {
      var1.removeMouseWheelListener(this);
   }
}
