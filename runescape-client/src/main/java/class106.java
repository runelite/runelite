import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class106 extends class112 implements MouseWheelListener {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1767721495
   )
   int field1708 = 0;

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field1708 += var1.getWheelRotation();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "2087039052"
   )
   public void vmethod2056(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "-9495"
   )
   public void vmethod2058(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "917686579"
   )
   public synchronized int vmethod2057() {
      int var1 = this.field1708;
      this.field1708 = 0;
      return var1;
   }
}
