import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class143 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 340335873
   )
   public static volatile int field2182 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 454883131
   )
   public static volatile int field2183 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1482112173
   )
   public static int field2184 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 628194457
   )
   public static volatile int field2186 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -216990439
   )
   public static volatile int field2187 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1505465163
   )
   public static int field2188 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1544457985
   )
   public static int field2189 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 640037475
   )
   public static volatile int field2190 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -783561469
   )
   public static volatile int field2191 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1092239795
   )
   public static int field2192 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 7767156824277440783L
   )
   public static volatile long field2193 = 0L;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1682925067
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("s")
   @Export("mouse")
   public static class143 mouse = new class143();
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -821333917
   )
   public static int field2196 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -3649583451536482249L
   )
   public static long field2197 = 0L;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1138051231
   )
   public static int field2198 = 0;
   @ObfuscatedName("bv")
   static class171 field2200;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2191 = var1.getX();
         field2183 = var1.getY();
         field2193 = class113.method2394();
         if(var1.isAltDown()) {
            field2190 = 4;
            field2182 = 4;
         } else if(var1.isMetaDown()) {
            field2190 = 2;
            field2182 = 2;
         } else {
            field2190 = 1;
            field2182 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field2187 = var1.getX();
         field2186 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2187 = -1;
         field2186 = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2187 = var1.getX();
         field2186 = var1.getY();
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field2182 = 0;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field2182 = 0;
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

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2187 = var1.getX();
         field2186 = var1.getY();
      }

   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IIB)Lclass110;",
      garbageValue = "-95"
   )
   static class110 method2968(int var0, int var1) {
      Client.field547.field1920 = var0;
      Client.field547.field1917 = var1;
      Client.field547.field1918 = 1;
      Client.field547.field1919 = 1;
      return Client.field547;
   }
}
