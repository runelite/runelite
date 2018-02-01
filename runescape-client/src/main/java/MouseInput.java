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
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lbb;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 654790203
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -886897949
   )
   @Export("MouseHandler_currentButton")
   public static volatile int MouseHandler_currentButton;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1443878151
   )
   @Export("mouseX")
   public static volatile int mouseX;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1885886773
   )
   @Export("mouseY")
   public static volatile int mouseY;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1871732367
   )
   @Export("mouseCurrentButton")
   public static int mouseCurrentButton;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2014715911
   )
   @Export("mouseLastX")
   public static int mouseLastX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1517615511
   )
   @Export("mouseLastY")
   public static int mouseLastY;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 739817041
   )
   @Export("MouseHandler_lastButton")
   public static volatile int MouseHandler_lastButton;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1076387091
   )
   @Export("MouseHandler_lastPressedX")
   public static volatile int MouseHandler_lastPressedX;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 416871713
   )
   @Export("MouseHandler_lastPressedY")
   public static volatile int MouseHandler_lastPressedY;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 9117763537011108053L
   )
   @Export("MouseHandler_lastPressedTimeMillis")
   public static volatile long MouseHandler_lastPressedTimeMillis;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -13738411
   )
   @Export("mouseLastButton")
   public static int mouseLastButton;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1885768613
   )
   @Export("mouseLastPressedX")
   public static int mouseLastPressedX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 996880025
   )
   @Export("mouseLastPressedY")
   public static int mouseLastPressedY;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 2407381000152208753L
   )
   @Export("mouseLastPressedTimeMillis")
   public static long mouseLastPressedTimeMillis;

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
      garbageValue = "438060503"
   )
   final int method984(MouseEvent var1) {
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

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         MouseHandler_currentButton = 0;
      }

   }

   @Export("mousePressed")
   @ObfuscatedName("mousePressed")
   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         MouseHandler_lastPressedX = var1.getX();
         MouseHandler_lastPressedY = var1.getY();
         MouseHandler_lastPressedTimeMillis = ScriptVarType.currentTimeMs();
         MouseHandler_lastButton = this.method984(var1);
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1870328581"
   )
   static int method991(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var2.itemIds[var4] == var1) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-980675991"
   )
   public static void method1010() {
      KitDefinition.identKits.reset();
   }
}
