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

@ObfuscatedName("bl")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lbl;"
   )
   @Export("mouse")
   static MouseInput mouse;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1923802269
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 694721139
   )
   @Export("MouseHandler_currentButton")
   static volatile int MouseHandler_currentButton;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2130241259
   )
   @Export("mouseX")
   static volatile int mouseX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1622837431
   )
   @Export("MouseHandler_lastButton")
   static volatile int MouseHandler_lastButton;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 502312673
   )
   @Export("mouseY")
   static volatile int mouseY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1156405329
   )
   @Export("mouseCurrentButton")
   public static int mouseCurrentButton;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1097308479
   )
   @Export("mouseLastX")
   public static int mouseLastX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -721576639
   )
   @Export("mouseLastY")
   public static int mouseLastY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 458103313
   )
   @Export("MouseHandler_lastPressedX")
   static volatile int MouseHandler_lastPressedX;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1595906531
   )
   @Export("MouseHandler_lastPressedY")
   static volatile int MouseHandler_lastPressedY;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 6488970622473117931L
   )
   @Export("MouseHandler_lastPressedTimeMillis")
   static volatile long MouseHandler_lastPressedTimeMillis;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -579543125
   )
   @Export("mouseLastButton")
   public static int mouseLastButton;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1824375525
   )
   @Export("mouseLastPressedX")
   public static int mouseLastPressedX;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1993404975
   )
   @Export("mouseLastPressedY")
   public static int mouseLastPressedY;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 2273062141062104299L
   )
   @Export("mouseLastPressedTimeMillis")
   public static long mouseLastPressedTimeMillis;
   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;

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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;I)I",
      garbageValue = "1391372373"
   )
   final int method1057(MouseEvent var1) {
      int var2 = var1.getButton();
      return !var1.isAltDown() && var2 != 2?(!var1.isMetaDown() && var2 != 3?1:2):4;
   }

   public final synchronized void mouseDragged(MouseEvent var1) {
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
         MouseHandler_lastPressedTimeMillis = class289.method5267();
         MouseHandler_lastButton = this.method1057(var1);
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

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = -1;
         mouseY = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

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

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;Ljr;I)V",
      garbageValue = "2147131037"
   )
   public static void method1090(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class281.field3576 = var0;
      class281.field3573 = var1;
      class281.field3567 = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1991767683"
   )
   static int method1058(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
