import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public final class class49 implements class157, MouseWheelListener {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1362954035
   )
   int field635;

   class49() {
      this.field635 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "2"
   )
   void method776(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "2"
   )
   void method778(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-276352670"
   )
   public synchronized int vmethod3044() {
      int var1 = this.field635;
      this.field635 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field635 += var1.getWheelRotation();
   }
}
