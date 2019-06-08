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

@ObfuscatedName("bb")
@Implements("MouseHandler")
public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lbb;"
   )
   @Export("MouseHandler_instance")
   public static MouseHandler MouseHandler_instance;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1080652669
   )
   @Export("MouseHandler_idleCycles")
   public static volatile int MouseHandler_idleCycles;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 642308075
   )
   @Export("MouseHandler_currentButton0")
   public static volatile int MouseHandler_currentButton0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1048471439
   )
   @Export("MouseHandler_x0")
   public static volatile int MouseHandler_x0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2000222973
   )
   @Export("MouseHandler_y0")
   public static volatile int MouseHandler_y0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -5429651987476437823L
   )
   @Export("MouseHandler_millis0")
   public static volatile long MouseHandler_millis0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1291011547
   )
   @Export("MouseHandler_y")
   public static int MouseHandler_y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2044247305
   )
   @Export("MouseHandler_currentButton")
   public static int MouseHandler_currentButton;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -649043937
   )
   @Export("MouseHandler_x")
   public static int MouseHandler_x;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -7587574528523107151L
   )
   @Export("MouseHandler_millis")
   public static long MouseHandler_millis;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 590718769
   )
   @Export("MouseHandler_lastButton0")
   public static volatile int MouseHandler_lastButton0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -813801905
   )
   @Export("MouseHandler_lastPressedX0")
   public static volatile int MouseHandler_lastPressedX0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 14138669
   )
   @Export("MouseHandler_lastPressedY0")
   public static volatile int MouseHandler_lastPressedY0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 3555003757894628243L
   )
   @Export("MouseHandler_lastPressedTimeMillis0")
   public static volatile long MouseHandler_lastPressedTimeMillis0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2126310249
   )
   @Export("MouseHandler_lastButton")
   public static int MouseHandler_lastButton;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1853704165
   )
   @Export("MouseHandler_lastPressedX")
   public static int MouseHandler_lastPressedX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1876967757
   )
   @Export("MouseHandler_lastPressedY")
   public static int MouseHandler_lastPressedY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 3806612340723844439L
   )
   @Export("MouseHandler_lastPressedTimeMillis")
   public static long MouseHandler_lastPressedTimeMillis;
   @ObfuscatedName("gb")
   @Export("regionLandArchiveIds")
   static int[] regionLandArchiveIds;
   @ObfuscatedName("hz")
   @ObfuscatedGetter(
      intValue = -215744973
   )
   @Export("oculusOrbFocalPointX")
   static int oculusOrbFocalPointX;

   static {
      MouseHandler_instance = new MouseHandler();
      MouseHandler_idleCycles = 0;
      MouseHandler_currentButton0 = 0;
      MouseHandler_x0 = -1;
      MouseHandler_y0 = -1;
      MouseHandler_millis0 = -1L;
      MouseHandler_currentButton = 0;
      MouseHandler_x = 0;
      MouseHandler_y = 0;
      MouseHandler_millis = 0L;
      MouseHandler_lastButton0 = 0;
      MouseHandler_lastPressedX0 = 0;
      MouseHandler_lastPressedY0 = 0;
      MouseHandler_lastPressedTimeMillis0 = 0L;
      MouseHandler_lastButton = 0;
      MouseHandler_lastPressedX = 0;
      MouseHandler_lastPressedY = 0;
      MouseHandler_lastPressedTimeMillis = 0L;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;I)I",
      garbageValue = "-965288682"
   )
   @Export("getButton")
   final int getButton(MouseEvent var1) {
      int var2 = var1.getButton();
      return !var1.isAltDown() && var2 != 2?(!var1.isMetaDown() && var2 != 3?1:2):4;
   }

   @Export("mouseMoved")
   @ObfuscatedName("mouseMoved")
   public final synchronized void mouseMoved(MouseEvent var1) {
      if(MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_x0 = var1.getX();
         MouseHandler_y0 = var1.getY();
         MouseHandler_millis0 = var1.getWhen();
      }

   }

   @Export("mousePressed")
   @ObfuscatedName("mousePressed")
   public final synchronized void mousePressed(MouseEvent var1) {
      if(MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_lastPressedX0 = var1.getX();
         MouseHandler_lastPressedY0 = var1.getY();
         MouseHandler_lastPressedTimeMillis0 = class203.currentTimeMs();
         MouseHandler_lastButton0 = this.getButton(var1);
         if(MouseHandler_lastButton0 != 0) {
            MouseHandler_currentButton0 = MouseHandler_lastButton0;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @Export("mouseReleased")
   @ObfuscatedName("mouseReleased")
   public final synchronized void mouseReleased(MouseEvent var1) {
      if(MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_currentButton0 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @Export("mouseClicked")
   @ObfuscatedName("mouseClicked")
   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @Export("mouseExited")
   @ObfuscatedName("mouseExited")
   public final synchronized void mouseExited(MouseEvent var1) {
      if(MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_x0 = -1;
         MouseHandler_y0 = -1;
         MouseHandler_millis0 = var1.getWhen();
      }

   }

   @Export("mouseDragged")
   @ObfuscatedName("mouseDragged")
   public final synchronized void mouseDragged(MouseEvent var1) {
      this.mouseMoved(var1);
   }

   @Export("focusGained")
   @ObfuscatedName("focusGained")
   public final void focusGained(FocusEvent var1) {
   }

   @Export("focusLost")
   @ObfuscatedName("focusLost")
   public final synchronized void focusLost(FocusEvent var1) {
      if(MouseHandler_instance != null) {
         MouseHandler_currentButton0 = 0;
      }

   }

   @Export("mouseEntered")
   @ObfuscatedName("mouseEntered")
   public final synchronized void mouseEntered(MouseEvent var1) {
      this.mouseMoved(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)J",
      garbageValue = "1909006131"
   )
   static long method1083(int var0, int var1, int var2) {
      return (long)(var2 << 16 | var0 << 8 | var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1860098743"
   )
   public static int method1085(CharSequence var0) {
      return IgnoreList.method5438(var0, 10, true);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "876254587"
   )
   static void method1084(boolean var0) {
      Login.Login_response1 = "";
      Login.Login_response2 = "Enter your username/email & password.";
      Login.Login_response3 = "";
      Login.loginIndex = 2;
      if(var0) {
         Login.Login_password = "";
      }

      Messages.method2200();
      class196.method3740();
   }
}
