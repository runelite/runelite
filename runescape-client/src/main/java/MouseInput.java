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
   @Export("MouseHandler_currentButton")
   static volatile int MouseHandler_currentButton;
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
   @Export("mouseCurrentButton")
   public static int mouseCurrentButton;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 950879603
   )
   @Export("MouseHandler_lastButton")
   static volatile int MouseHandler_lastButton;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 44956887
   )
   @Export("MouseHandler_lastPressedX")
   static volatile int MouseHandler_lastPressedX;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -279978491
   )
   @Export("MouseHandler_lastPressedY")
   static volatile int MouseHandler_lastPressedY;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 5150089180744596517L
   )
   @Export("MouseHandler_lastPressedTimeMillis")
   static volatile long MouseHandler_lastPressedTimeMillis;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -661549847
   )
   @Export("mouseLastButton")
   public static int mouseLastButton;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -786964945
   )
   @Export("mouseLastPressedX")
   public static int mouseLastPressedX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 851446851
   )
   @Export("mouseLastPressedY")
   public static int mouseLastPressedY;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 7402575198471548381L
   )
   @Export("mouseLastPressedTimeMillis")
   public static long mouseLastPressedTimeMillis;
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
   @Export("fonts")
   static Fonts fonts;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      MouseHandler_currentButton = 0;
      mouseX = -1;
      mouseY = -1;
      mouseCurrentButton = 0;
      field703 = 0;
      field715 = 0;
      MouseHandler_lastButton = 0;
      MouseHandler_lastPressedX = 0;
      MouseHandler_lastPressedY = 0;
      MouseHandler_lastPressedTimeMillis = 0L;
      mouseLastButton = 0;
      mouseLastPressedX = 0;
      mouseLastPressedY = 0;
      mouseLastPressedTimeMillis = 0L;
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
         MouseHandler_currentButton = 0;
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
         MouseHandler_currentButton = 0;
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

   @Export("mousePressed")
   @ObfuscatedName("mousePressed")
   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         MouseHandler_lastPressedX = var1.getX();
         MouseHandler_lastPressedY = var1.getY();
         MouseHandler_lastPressedTimeMillis = ServerPacket.currentTimeMs();
         MouseHandler_lastButton = this.method1008(var1);
         if(MouseHandler_lastButton != 0) {
            MouseHandler_currentButton = MouseHandler_lastButton;
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
                  var4.objs = var3.field2761;
                  GZipDecompressor.method3234(var4, 2000000);
               }
            }

         }
      }
   }
}
