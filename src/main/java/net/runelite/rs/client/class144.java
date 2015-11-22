package net.runelite.rs.client;

import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eo")
public class class144 extends class130 implements MouseWheelListener {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1061248453
   )
   int field2195 = 0;

   @ObfuscatedName("f")
   public synchronized int vmethod3146() {
      int var1 = this.field2195;
      this.field2195 = 0;
      return var1;
   }

   @ObfuscatedName("m")
   public void vmethod3147(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      this.field2195 += var1.getWheelRotation();
   }

   @ObfuscatedName("j")
   public void vmethod3148(Component var1) {
      var1.addMouseWheelListener(this);
   }
}
