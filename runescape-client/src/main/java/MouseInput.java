import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lbr;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1566148121
   )
   @Export("mouseIdleTicks")
   static volatile int mouseIdleTicks;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 961761349
   )
   @Export("MouseHandler_currentButton")
   public static volatile int MouseHandler_currentButton;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1003868525
   )
   @Export("mouseX")
   public static volatile int mouseX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1237185407
   )
   @Export("MouseHandler_lastButton")
   public static volatile int MouseHandler_lastButton;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1449969487
   )
   @Export("mouseY")
   public static volatile int mouseY;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1399719103
   )
   @Export("mouseCurrentButton")
   public static int mouseCurrentButton;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 222707049
   )
   @Export("mouseLastX")
   public static int mouseLastX;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1475605687
   )
   @Export("mouseLastY")
   public static int mouseLastY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1001593339
   )
   @Export("MouseHandler_lastPressedX")
   public static volatile int MouseHandler_lastPressedX;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -589842161
   )
   @Export("MouseHandler_lastPressedY")
   public static volatile int MouseHandler_lastPressedY;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -7333390758810013331L
   )
   @Export("MouseHandler_lastPressedTimeMillis")
   public static volatile long MouseHandler_lastPressedTimeMillis;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1419271779
   )
   @Export("mouseLastButton")
   public static int mouseLastButton;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 397705157
   )
   @Export("mouseLastPressedX")
   public static int mouseLastPressedX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1941139521
   )
   @Export("mouseLastPressedY")
   public static int mouseLastPressedY;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 3386584812439596305L
   )
   @Export("mouseLastPressedTimeMillis")
   public static long mouseLastPressedTimeMillis;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -524247815
   )
   static int field670;

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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;B)I",
      garbageValue = "107"
   )
   final int method1009(MouseEvent var1) {
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
         MouseHandler_lastPressedTimeMillis = class188.currentTimeMs();
         MouseHandler_lastButton = this.method1009(var1);
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

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
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

   public final synchronized void mouseEntered(MouseEvent var1) {
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

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = -1;
         mouseY = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgv;ILjava/lang/String;S)Ljava/lang/String;",
      garbageValue = "-8339"
   )
   static String method1038(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "2022946540"
   )
   static boolean method1046(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }
}
