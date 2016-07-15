import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class148 extends class134 implements MouseWheelListener {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1370195785
   )
   int field2259 = 0;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "2058912018"
   )
   public void vmethod3196(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1934603405"
   )
   public synchronized int vmethod3197() {
      int var1 = this.field2259;
      this.field2259 = 0;
      return var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1788553424"
   )
   public void vmethod3202(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2259 += var1.getWheelRotation();
   }
}
