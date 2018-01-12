import net.runelite.mapping.*;

import java.awt.event.*;

@ObfuscatedName("bx")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 384145967
   )
   public static int field679;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lbx;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -363108789
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 523049731
   )
   @Export("MouseHandler_currentButton")
   static volatile int MouseHandler_currentButton;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1376819745
   )
   @Export("mouseX")
   static volatile int mouseX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 202010869
   )
   @Export("mouseY")
   static volatile int mouseY;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -333228559
   )
   @Export("mouseCurrentButton")
   public static int mouseCurrentButton;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 850764321
   )
   public static int field682;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1453893085
   )
   @Export("MouseHandler_lastButton")
   static volatile int MouseHandler_lastButton;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -384786981
   )
   @Export("MouseHandler_lastPressedX")
   static volatile int MouseHandler_lastPressedX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -348709505
   )
   @Export("MouseHandler_lastPressedY")
   static volatile int MouseHandler_lastPressedY;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -7398409833473874705L
   )
   @Export("MouseHandler_lastPressedTimeMillis")
   static volatile long MouseHandler_lastPressedTimeMillis;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 872384249
   )
   @Export("mouseLastButton")
   public static int mouseLastButton;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1046301689
   )
   @Export("mouseLastPressedX")
   public static int mouseLastPressedX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1913046979
   )
   @Export("mouseLastPressedY")
   public static int mouseLastPressedY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -8309155304464128139L
   )
   @Export("mouseLastPressedTimeMillis")
   public static long mouseLastPressedTimeMillis;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1447683255
   )
   static int field683;
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexCache3")
   static IndexData indexCache3;
   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   static AbstractSocket field685;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -245636329
   )
   @Export("cameraX")
   static int cameraX;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      MouseHandler_currentButton = 0;
      mouseX = -1;
      mouseY = -1;
      mouseCurrentButton = 0;
      field679 = 0;
      field682 = 0;
      MouseHandler_lastButton = 0;
      MouseHandler_lastPressedX = 0;
      MouseHandler_lastPressedY = 0;
      MouseHandler_lastPressedTimeMillis = 0L;
      mouseLastButton = 0;
      mouseLastPressedX = 0;
      mouseLastPressedY = 0;
      mouseLastPressedTimeMillis = 0L;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;I)I",
      garbageValue = "-527612612"
   )
   final int method961(MouseEvent var1) {
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
         MouseHandler_lastPressedTimeMillis = Preferences.currentTimeMs();
         MouseHandler_lastButton = this.method961(var1);
         if(MouseHandler_lastButton != 0) {
            MouseHandler_currentButton = MouseHandler_lastButton;
         }
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

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         MouseHandler_currentButton = 0;
      }

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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZZI)Lkg;",
      garbageValue = "192151126"
   )
   static IndexedSprite method974(boolean var0, boolean var1) {
      return var0?(var1?WorldMapType2.field492:class91.field1333):(var1?class234.field2945:CombatInfoListHolder.field1267);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1922897196"
   )
   static void method959() {
      if(class91.Login_isUsernameRemembered && class91.username != null && class91.username.length() > 0) {
         class91.field1345 = 1;
      } else {
         class91.field1345 = 0;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "194913091"
   )
   @Export("cs2_2800s")
   static int cs2_2800s(int var0, Script var1, boolean var2) {
      Widget var3 = VertexNormal.getWidget(class82.intStack[--class82.intStackSize]);
      if(var0 == 2800) {
         int[] var4 = class82.intStack;
         int var5 = ++class82.intStackSize - 1;
         int var7 = class36.getWidgetConfig(var3);
         int var6 = var7 >> 11 & 63;
         var4[var5] = var6;
         return 1;
      } else if(var0 != 2801) {
         if(var0 == 2802) {
            if(var3.name == null) {
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
            } else {
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var8 = class82.intStack[--class82.intStackSize];
         --var8;
         if(var3.actions != null && var8 < var3.actions.length && var3.actions[var8] != null) {
            class82.scriptStringStack[++class35.scriptStringStackSize - 1] = var3.actions[var8];
         } else {
            class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }
}
