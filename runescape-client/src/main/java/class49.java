import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public final class class49 implements class157, MouseWheelListener {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1012102983
   )
   int field630;

   class49() {
      this.field630 = 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-574963882"
   )
   void method770(Component var1) {
      var1.addMouseWheelListener(this);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1166165432"
   )
   void method771(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-434202318"
   )
   public synchronized int vmethod2993() {
      int var1 = this.field630;
      this.field630 = 0;
      return var1;
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field630 += var1.getWheelRotation();
   }
}
