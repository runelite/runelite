import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
public class class106 extends class112 implements MouseWheelListener {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 770959741
   )
   int field1714 = 0;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "768002626"
   )
   public void vmethod2043(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field1714 += var1.getWheelRotation();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "745657044"
   )
   public synchronized int vmethod2042() {
      int var1 = this.field1714;
      this.field1714 = 0;
      return var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "235"
   )
   public void vmethod2053(Component var1) {
      var1.addMouseWheelListener(this);
   }
}
