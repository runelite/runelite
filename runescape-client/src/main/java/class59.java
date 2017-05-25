import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class59 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -6241900171626895147L
   )
   public static long field715;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -806188681
   )
   @Export("mouseIdleTicks")
   static volatile int mouseIdleTicks;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1799222615
   )
   public static int field717;
   @ObfuscatedName("i")
   @Export("mouse")
   static class59 mouse;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2105352335
   )
   static volatile int field720;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -630773307
   )
   public static int field721;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -494966575
   )
   public static int field722;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -340168263
   )
   static volatile int field723;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -383658549
   )
   static volatile int field724;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 109859673
   )
   static volatile int field725;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -1386567575218064451L
   )
   static volatile long field726;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1031282807
   )
   public static int field727;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1837799465
   )
   public static int field729;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -775677157
   )
   @Export("mouseY")
   static volatile int mouseY;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 120516181
   )
   static int field731;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -115778013
   )
   public static int field732;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -506248187
   )
   @Export("mouseX")
   static volatile int mouseX;

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field720 = 0;
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

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
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
      mouse = new class59();
      mouseIdleTicks = 0;
      field720 = 0;
      mouseX = -1;
      mouseY = -1;
      field732 = 0;
      field721 = 0;
      field722 = 0;
      field723 = 0;
      field724 = 0;
      field725 = 0;
      field726 = 0L;
      field727 = 0;
      field717 = 0;
      field729 = 0;
      field715 = 0L;
   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-48"
   )
   static final void method998(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var2 - var0;
      int var7 = var3 - var1;
      int var8 = var6 >= 0?var6:-var6;
      int var9 = var7 >= 0?var7:-var7;
      int var10 = var8;
      if(var8 < var9) {
         var10 = var9;
      }

      if(var10 != 0) {
         int var11 = (var6 << 16) / var10;
         int var12 = (var7 << 16) / var10;
         if(var12 <= var11) {
            var11 = -var11;
         } else {
            var12 = -var12;
         }

         int var13 = var12 * var5 >> 17;
         int var14 = var5 * var12 + 1 >> 17;
         int var15 = var11 * var5 >> 17;
         int var16 = var5 * var11 + 1 >> 17;
         var0 -= Rasterizer2D.field3749;
         var1 -= Rasterizer2D.field3746;
         int var17 = var0 + var13;
         int var18 = var0 - var14;
         int var19 = var6 + var0 - var14;
         int var20 = var0 + var6 + var13;
         int var21 = var1 + var15;
         int var22 = var1 - var16;
         int var23 = var1 + var7 - var16;
         int var24 = var1 + var7 + var15;
         class136.setRasterClippingEnabled(var17, var18, var19);
         class136.rasterFlat(var21, var22, var23, var17, var18, var19, var4);
         class136.setRasterClippingEnabled(var17, var19, var20);
         class136.rasterFlat(var21, var23, var24, var17, var19, var20, var4);
      }
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field720 = 0;
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field724 = var1.getX();
         field725 = var1.getY();
         field726 = class226.method4147();
         if(var1.isAltDown()) {
            field723 = 4;
            field720 = 4;
         } else if(var1.isMetaDown()) {
            field723 = 2;
            field720 = 2;
         } else {
            field723 = 1;
            field720 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(LWidget;I)LWidget;",
      garbageValue = "2080044679"
   )
   static Widget method1028(Widget var0) {
      int var1 = NPC.method1730(class43.method626(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = class261.method4792(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }
}
