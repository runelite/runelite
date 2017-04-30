import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class115 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1908681181
   )
   public static int field1799;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1876836511
   )
   @Export("mouseIdleTicks")
   static volatile int mouseIdleTicks;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1744435211
   )
   public static volatile int field1801;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 37330559
   )
   public static int field1802;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 585714265
   )
   @Export("mouseY")
   public static volatile int mouseY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -291560687
   )
   public static int field1805;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1439228953
   )
   public static int field1806;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1856076585
   )
   public static volatile int field1807;
   @ObfuscatedName("d")
   @Export("mouse")
   public static class115 mouse;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 941214543
   )
   public static volatile int field1809;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -473000331
   )
   public static volatile int field1810;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 215800197
   )
   public static int field1811;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -726765429
   )
   @Export("mouseX")
   public static volatile int mouseX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1978892205
   )
   public static int field1813;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -6106567573784004277L
   )
   public static long field1814;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -2679474711508405225L
   )
   public static volatile long field1817;

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1801 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = -1;
         mouseY = -1;
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   static {
      mouse = new class115();
      mouseIdleTicks = 0;
      field1801 = 0;
      mouseX = -1;
      mouseY = -1;
      field1799 = 0;
      field1805 = 0;
      field1806 = 0;
      field1807 = 0;
      field1810 = 0;
      field1809 = 0;
      field1817 = 0L;
      field1811 = 0;
      field1802 = 0;
      field1813 = 0;
      field1814 = 0L;
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field1801 = 0;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1810 = var1.getX();
         field1809 = var1.getY();
         field1817 = class72.method1421();
         if(var1.isAltDown()) {
            field1807 = 4;
            field1801 = 4;
         } else if(var1.isMetaDown()) {
            field1807 = 2;
            field1801 = 2;
         } else {
            field1807 = 1;
            field1801 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   static final void method2231() {
      int[] var0 = class45.field894;

      int var1;
      for(var1 = 0; var1 < class45.field891; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(var2 != null && var2.field615 > 0) {
            --var2.field615;
            if(var2.field615 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field321; ++var1) {
         int var4 = Client.field350[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(var3 != null && var3.field615 > 0) {
            --var3.field615;
            if(var3.field615 == 0) {
               var3.overhead = null;
            }
         }
      }

   }
}
