import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public class class106 extends class112 implements MouseWheelListener {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -496727695
   )
   int field1729 = 0;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1376163365"
   )
   public void vmethod2035(Component var1) {
      var1.addMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field1729 += var1.getWheelRotation();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1116236959"
   )
   public synchronized int vmethod2036() {
      int var1 = this.field1729;
      this.field1729 = 0;
      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1548616269"
   )
   public void vmethod2044(Component var1) {
      var1.removeMouseWheelListener(this);
   }
}
