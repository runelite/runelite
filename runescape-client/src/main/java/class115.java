import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class115 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -441747499
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -941690739
   )
   public static int field1794 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1371697963
   )
   static volatile int field1795 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1973423763
   )
   static volatile int field1796 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1008353267
   )
   static volatile int field1797 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -2881921218050336025L
   )
   static volatile long field1798 = 0L;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 794556041
   )
   public static int field1799 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -255802545
   )
   public static int field1800 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1838541471
   )
   static volatile int field1801 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1629624767
   )
   static volatile int field1802 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1667557995
   )
   static volatile int field1803 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 358826443
   )
   public static int field1804 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -220469997
   )
   public static int field1805 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -3397407121390736969L
   )
   public static long field1806 = 0L;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2124200977
   )
   public static int field1807 = 0;
   @ObfuscatedName("o")
   @Export("mouse")
   static class115 mouse = new class115();
   @ObfuscatedName("ao")
   static boolean field1809;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1802 = var1.getX();
         field1803 = var1.getY();
         field1798 = class22.method224();
         if(var1.isAltDown()) {
            field1801 = 4;
            field1795 = 4;
         } else if(var1.isMetaDown()) {
            field1801 = 2;
            field1795 = 2;
         } else {
            field1801 = 1;
            field1795 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "1372472484"
   )
   public static int method2195(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = 1 + (var0 << 4);
      }

      return var2;
   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1796 = var1.getX();
         field1797 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1796 = -1;
         field1797 = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1796 = var1.getX();
         field1797 = var1.getY();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1796 = var1.getX();
         field1797 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != mouse) {
         field1795 = 0;
      }

   }

   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1727842570"
   )
   static void method2213(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class47.field924; ++var4) {
         ItemComposition var5 = PlayerComposition.getItemDefinition(var4);
         if((!var1 || var5.field2975) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class162.field2279 = -1;
               Renderable.field1544 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[2 * var2.length];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      Renderable.field1544 = var2;
      class15.field162 = 0;
      class162.field2279 = var3;
      String[] var8 = new String[class162.field2279];

      for(int var9 = 0; var9 < class162.field2279; ++var9) {
         var8[var9] = PlayerComposition.getItemDefinition(var2[var9]).name;
      }

      short[] var10 = Renderable.field1544;
      class25.method613(var8, var10, 0, var8.length - 1);
   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1795 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }
}
