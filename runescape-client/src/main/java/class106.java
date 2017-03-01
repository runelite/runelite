import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class106 extends class112 implements MouseWheelListener {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1418265815
   )
   int field1731 = 0;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-78"
   )
   public synchronized int vmethod2185() {
      int var1 = this.field1731;
      this.field1731 = 0;
      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-684605091"
   )
   public void vmethod2172(Component var1) {
      var1.addMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field1731 += var1.getWheelRotation();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "0"
   )
   public void vmethod2174(Component var1) {
      var1.removeMouseWheelListener(this);
   }
}
