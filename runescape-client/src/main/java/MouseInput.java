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

@ObfuscatedName("bm")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lbm;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1439071513
   )
   @Export("mouseIdleTicks")
   static volatile int mouseIdleTicks;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1427404677
   )
   @Export("MouseHandler_lastButton")
   public static volatile int MouseHandler_lastButton;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -182030277
   )
   @Export("mouseLastX")
   public static int mouseLastX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1098928601
   )
   @Export("MouseHandler_currentButton")
   public static volatile int MouseHandler_currentButton;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2030530267
   )
   @Export("mouseX")
   public static volatile int mouseX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 632113057
   )
   @Export("mouseLastY")
   public static int mouseLastY;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 996345593
   )
   @Export("mouseY")
   public static volatile int mouseY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1624835589
   )
   @Export("mouseCurrentButton")
   public static int mouseCurrentButton;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1281394571
   )
   @Export("MouseHandler_lastPressedX")
   public static volatile int MouseHandler_lastPressedX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -641927099
   )
   @Export("MouseHandler_lastPressedY")
   public static volatile int MouseHandler_lastPressedY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 6222313394842801641L
   )
   @Export("MouseHandler_lastPressedTimeMillis")
   public static volatile long MouseHandler_lastPressedTimeMillis;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -389549781
   )
   @Export("mouseLastButton")
   public static int mouseLastButton;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -508652203
   )
   @Export("mouseLastPressedX")
   public static int mouseLastPressedX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 830982687
   )
   @Export("mouseLastPressedY")
   public static int mouseLastPressedY;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 2519054512390866111L
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;I)I",
      garbageValue = "2033806005"
   )
   final int method986(MouseEvent var1) {
      int var2 = var1.getButton();
      return !var1.isAltDown() && var2 != 2?(!var1.isMetaDown() && var2 != 3?1:2):4;
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

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         MouseHandler_currentButton = 0;
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

   public final void focusGained(FocusEvent var1) {
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
         MouseHandler_lastPressedTimeMillis = PendingSpawn.currentTimeMs();
         MouseHandler_lastButton = this.method986(var1);
         if(MouseHandler_lastButton != 0) {
            MouseHandler_currentButton = MouseHandler_lastButton;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(DDII)[D",
      garbageValue = "-1999653679"
   )
   public static double[] method1012(double var0, double var2, int var4) {
      int var5 = var4 * 2 + 1;
      double[] var6 = new double[var5];
      int var7 = -var4;

      for(int var8 = 0; var7 <= var4; ++var8) {
         double var11 = BoundingBox.method53(((double)var7 - var0) / var2) / var2;
         var6[var8] = var11;
         ++var7;
      }

      return var6;
   }
}
