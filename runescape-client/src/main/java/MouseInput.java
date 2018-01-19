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

@ObfuscatedName("bi")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1663662679
   )
   @Export("MouseHandler_lastButton")
   static volatile int MouseHandler_lastButton;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lbi;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 283652217
   )
   @Export("mouseIdleTicks")
   static volatile int mouseIdleTicks;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -249650989
   )
   @Export("MouseHandler_currentButton")
   static volatile int MouseHandler_currentButton;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -353659367
   )
   @Export("mouseX")
   static volatile int mouseX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 456570953
   )
   @Export("mouseY")
   static volatile int mouseY;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1506002783
   )
   @Export("mouseCurrentButton")
   public static int mouseCurrentButton;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1745090453
   )
   @Export("mouseLastX")
   public static int mouseLastX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1332932541
   )
   @Export("mouseLastY")
   public static int mouseLastY;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1338500667
   )
   @Export("MouseHandler_lastPressedX")
   static volatile int MouseHandler_lastPressedX;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 705271259
   )
   @Export("MouseHandler_lastPressedY")
   static volatile int MouseHandler_lastPressedY;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -3893203364507036079L
   )
   @Export("MouseHandler_lastPressedTimeMillis")
   static volatile long MouseHandler_lastPressedTimeMillis;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -898339579
   )
   @Export("mouseLastButton")
   public static int mouseLastButton;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1319375247
   )
   @Export("mouseLastPressedX")
   public static int mouseLastPressedX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -488033289
   )
   @Export("mouseLastPressedY")
   public static int mouseLastPressedY;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 5366304121087764859L
   )
   @Export("mouseLastPressedTimeMillis")
   public static long mouseLastPressedTimeMillis;
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("indexCache10")
   static IndexData indexCache10;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = -505541463
   )
   @Export("cameraY")
   static int cameraY;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      MouseHandler_currentButton = 0;
      mouseX = -1;
      mouseY = -1;
      mouseCurrentButton = 0;
      mouseLastX = 0;
      mouseLastY = 0;
      MouseHandler_lastButton = 0;
      MouseHandler_lastPressedX = 0;
      MouseHandler_lastPressedY = 0;
      MouseHandler_lastPressedTimeMillis = 0L;
      mouseLastButton = 0;
      mouseLastPressedX = 0;
      mouseLastPressedY = 0;
      mouseLastPressedTimeMillis = 0L;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;I)I",
      garbageValue = "-300853652"
   )
   final int method1021(MouseEvent var1) {
      int var2 = var1.getButton();
      return !var1.isAltDown() && var2 != 2?(!var1.isMetaDown() && var2 != 3?1:2):4;
   }

   @Export("mousePressed")
   @ObfuscatedName("mousePressed")
   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         MouseHandler_lastPressedX = var1.getX();
         MouseHandler_lastPressedY = var1.getY();
         MouseHandler_lastPressedTimeMillis = class60.currentTimeMs();
         MouseHandler_lastButton = this.method1021(var1);
         if(MouseHandler_lastButton != 0) {
            MouseHandler_currentButton = MouseHandler_lastButton;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

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

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         MouseHandler_currentButton = 0;
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

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "549805496"
   )
   static final void method1025() {
      if(Client.field1084 > 0) {
         class1.method0();
      } else {
         Client.field894.method5097();
         ClanMember.setGameState(40);
         class40.field525 = Client.field915.getSocket();
         Client.field915.method1903();
      }
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1651198612"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class61.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class61.tileHeights[var5][var3][var4] + var6 * class61.tileHeights[var5][var3 + 1][var4] >> 7;
         int var9 = class61.tileHeights[var5][var3 + 1][var4 + 1] * var6 + class61.tileHeights[var5][var3][var4 + 1] * (128 - var6) >> 7;
         return var8 * (128 - var7) + var7 * var9 >> 7;
      } else {
         return 0;
      }
   }
}
