import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("ld")
   @ObfuscatedGetter(
      intValue = 1051385049
   )
   static int field712;
   @ObfuscatedName("qy")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 388882203
   )
   public static int field715;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1861628303
   )
   public static int field703;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lbg;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2088370917
   )
   @Export("mouseIdleTicks")
   static volatile int mouseIdleTicks;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1369097661
   )
   static volatile int field704;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1301319561
   )
   @Export("mouseX")
   static volatile int mouseX;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1398904361
   )
   @Export("mouseY")
   static volatile int mouseY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -611046833
   )
   public static int field705;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 950879603
   )
   static volatile int field713;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 44956887
   )
   static volatile int field694;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -279978491
   )
   static volatile int field706;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 5150089180744596517L
   )
   static volatile long field707;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -661549847
   )
   public static int field708;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -786964945
   )
   public static int field709;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 851446851
   )
   public static int field710;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 7402575198471548381L
   )
   public static long field697;
   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   static class269 field716;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      field704 = 0;
      mouseX = -1;
      mouseY = -1;
      field705 = 0;
      field703 = 0;
      field715 = 0;
      field713 = 0;
      field694 = 0;
      field706 = 0;
      field707 = 0L;
      field708 = 0;
      field709 = 0;
      field710 = 0;
      field697 = 0L;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;B)I",
      garbageValue = "55"
   )
   final int method1008(MouseEvent var1) {
      int var2 = var1.getButton();
      return !var1.isAltDown() && var2 != 2?(!var1.isMetaDown() && var2 != 3?1:2):4;
   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field704 = 0;
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

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field704 = 0;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field694 = var1.getX();
         field706 = var1.getY();
         field707 = ServerPacket.currentTimeMs();
         field713 = this.method1008(var1);
         if(field713 != 0) {
            field704 = field713;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-34"
   )
   static synchronized byte[] method1044(int var0) {
      return class181.method3510(var0, false);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "34"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = class274.method5045(var0 - 1, var1 - 1) + class274.method5045(var0 + 1, var1 - 1) + class274.method5045(var0 - 1, 1 + var1) + class274.method5045(var0 + 1, 1 + var1);
      int var3 = class274.method5045(var0 - 1, var1) + class274.method5045(var0 + 1, var1) + class274.method5045(var0, var1 - 1) + class274.method5045(var0, 1 + var1);
      int var4 = class274.method5045(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "70"
   )
   static void method1012(int var0) {
      if(var0 != -1) {
         if(ISAACCipher.loadWidget(var0)) {
            Widget[] var1 = class11.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2761 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.field797 = var3.field2761;
                  GZipDecompressor.method3234(var4, 2000000);
               }
            }

         }
      }
   }
}
