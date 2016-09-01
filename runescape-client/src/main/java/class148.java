import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class148 extends class134 implements MouseWheelListener {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 357236561
   )
   int field2265 = 0;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1011694172"
   )
   public void vmethod3161(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1814309000"
   )
   public synchronized int vmethod3163() {
      int var1 = this.field2265;
      this.field2265 = 0;
      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "2126260861"
   )
   public void vmethod3166(Component var1) {
      var1.addMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2265 += var1.getWheelRotation();
   }
}
