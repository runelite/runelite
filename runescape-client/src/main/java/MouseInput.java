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
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lbi;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1331456959
   )
   @Export("mouseIdleTicks")
   static volatile int mouseIdleTicks;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -840403113
   )
   @Export("MouseHandler_currentButton")
   public static volatile int MouseHandler_currentButton;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1473396205
   )
   @Export("mouseX")
   public static volatile int mouseX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1210195897
   )
   @Export("mouseY")
   public static volatile int mouseY;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -896776711
   )
   @Export("mouseCurrentButton")
   public static int mouseCurrentButton;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2113243559
   )
   @Export("mouseLastX")
   public static int mouseLastX;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -425794071
   )
   @Export("mouseLastY")
   public static int mouseLastY;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -686301093
   )
   @Export("MouseHandler_lastButton")
   public static volatile int MouseHandler_lastButton;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -686189529
   )
   @Export("MouseHandler_lastPressedX")
   public static volatile int MouseHandler_lastPressedX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1423574975
   )
   @Export("MouseHandler_lastPressedY")
   public static volatile int MouseHandler_lastPressedY;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 3314161609246916717L
   )
   @Export("MouseHandler_lastPressedTimeMillis")
   public static volatile long MouseHandler_lastPressedTimeMillis;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1355727431
   )
   @Export("mouseLastButton")
   public static int mouseLastButton;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1708678573
   )
   @Export("mouseLastPressedX")
   public static int mouseLastPressedX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 540133709
   )
   @Export("mouseLastPressedY")
   public static int mouseLastPressedY;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 4658616330377991295L
   )
   @Export("mouseLastPressedTimeMillis")
   public static long mouseLastPressedTimeMillis;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1828022061
   )
   static int field687;

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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;S)I",
      garbageValue = "-2894"
   )
   final int method951(MouseEvent var1) {
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

   @Export("mousePressed")
   @ObfuscatedName("mousePressed")
   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         MouseHandler_lastPressedX = var1.getX();
         MouseHandler_lastPressedY = var1.getY();
         MouseHandler_lastPressedTimeMillis = SceneTilePaint.currentTimeMs();
         MouseHandler_lastButton = this.method951(var1);
         if(MouseHandler_lastButton != 0) {
            MouseHandler_currentButton = MouseHandler_lastButton;
         }
      }

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

   public final void focusGained(FocusEvent var1) {
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

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;IZI)Lex;",
      garbageValue = "1039730793"
   )
   public static Frames method980(IndexDataBase var0, IndexDataBase var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.getChilds(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.getChild(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9;
            if(var3) {
               var9 = var1.getChild(0, var8);
            } else {
               var9 = var1.getChild(var8, 0);
            }

            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }
}
