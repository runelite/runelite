import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
public class class115 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2056429051
   )
   static volatile int field1782 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1038316589
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 108007311
   )
   static volatile int field1784 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1008543237
   )
   static volatile int field1786 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1204698877
   )
   public static int field1787 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -440377273
   )
   public static int field1788 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1108065229
   )
   public static int field1789 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 707762175
   )
   static volatile int field1790 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2090686463
   )
   public static int field1791 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1772229657
   )
   static volatile int field1792 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -5721028226176254905L
   )
   static volatile long field1793 = 0L;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 166171281
   )
   public static int field1794 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 613889931
   )
   static volatile int field1795 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 60718835
   )
   public static int field1796 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 5027948808930811561L
   )
   public static long field1797 = 0L;
   @ObfuscatedName("u")
   @Export("mouse")
   public static class115 mouse = new class115();

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1795 = var1.getX();
         field1786 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1795 = -1;
         field1786 = -1;
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1795 = var1.getX();
         field1786 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != mouse) {
         field1784 = 0;
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1782 = var1.getX();
         field1792 = var1.getY();
         field1793 = class9.method117();
         if(var1.isAltDown()) {
            field1790 = 4;
            field1784 = 4;
         } else if(var1.isMetaDown()) {
            field1790 = 2;
            field1784 = 2;
         } else {
            field1790 = 1;
            field1784 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "406747573"
   )
   public static int method2182(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var4 + var6] = -128;
            } else if(var7 == 8218) {
               var3[var4 + var6] = -126;
            } else if(var7 == 402) {
               var3[var6 + var4] = -125;
            } else if(var7 == 8222) {
               var3[var4 + var6] = -124;
            } else if(var7 == 8230) {
               var3[var6 + var4] = -123;
            } else if(var7 == 8224) {
               var3[var6 + var4] = -122;
            } else if(var7 == 8225) {
               var3[var6 + var4] = -121;
            } else if(var7 == 710) {
               var3[var6 + var4] = -120;
            } else if(var7 == 8240) {
               var3[var4 + var6] = -119;
            } else if(var7 == 352) {
               var3[var6 + var4] = -118;
            } else if(var7 == 8249) {
               var3[var6 + var4] = -117;
            } else if(var7 == 338) {
               var3[var4 + var6] = -116;
            } else if(var7 == 381) {
               var3[var6 + var4] = -114;
            } else if(var7 == 8216) {
               var3[var4 + var6] = -111;
            } else if(var7 == 8217) {
               var3[var6 + var4] = -110;
            } else if(var7 == 8220) {
               var3[var4 + var6] = -109;
            } else if(var7 == 8221) {
               var3[var4 + var6] = -108;
            } else if(var7 == 8226) {
               var3[var6 + var4] = -107;
            } else if(var7 == 8211) {
               var3[var4 + var6] = -106;
            } else if(var7 == 8212) {
               var3[var4 + var6] = -105;
            } else if(var7 == 732) {
               var3[var6 + var4] = -104;
            } else if(var7 == 8482) {
               var3[var6 + var4] = -103;
            } else if(var7 == 353) {
               var3[var6 + var4] = -102;
            } else if(var7 == 8250) {
               var3[var6 + var4] = -101;
            } else if(var7 == 339) {
               var3[var6 + var4] = -100;
            } else if(var7 == 382) {
               var3[var4 + var6] = -98;
            } else if(var7 == 376) {
               var3[var6 + var4] = -97;
            } else {
               var3[var6 + var4] = 63;
            }
         } else {
            var3[var6 + var4] = (byte)var7;
         }
      }

      return var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "106"
   )
   static int method2186() {
      return ++class47.field919 - 1;
   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1784 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1795 = var1.getX();
         field1786 = var1.getY();
      }

   }
}
