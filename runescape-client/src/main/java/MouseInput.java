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
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lbi;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("v")
   public static volatile int field760;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -294107055
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1491322179
   )
   @Export("mouseX")
   public static volatile int mouseX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 905144935
   )
   public static volatile int field753;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1983285637
   )
   public static int field743;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1726188587
   )
   @Export("mouseY")
   public static volatile int mouseY;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 377595057
   )
   public static int field756;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1876800097
   )
   public static volatile int field744;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 136586683
   )
   public static int field741;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -157286495
   )
   public static int field750;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 912886423
   )
   public static int field757;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 261836997
   )
   public static int field758;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1231717261
   )
   public static volatile int field752;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -4745726906387913125L
   )
   public static volatile long field755;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 656430533231465849L
   )
   public static long field759;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      field760 = 0;
      mouseX = -1;
      mouseY = -1;
      field750 = 0;
      field756 = 0;
      field741 = 0;
      field752 = 0;
      field753 = 0;
      field744 = 0;
      field755 = 0L;
      field743 = 0;
      field757 = 0;
      field758 = 0;
      field759 = 0L;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;I)I",
      garbageValue = "-1923796181"
   )
   final int method1016(MouseEvent var1) {
      int var2 = var1.getButton();
      return !var1.isAltDown() && var2 != 2?(!var1.isMetaDown() && var2 != 3?1:2):4;
   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field760 = 0;
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

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field760 = 0;
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field753 = var1.getX();
         field744 = var1.getY();
         field755 = class174.currentTimeMs();
         field752 = this.method1016(var1);
         if(field752 != 0) {
            field760 = field752 * 851890093;
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

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILhy;B)I",
      garbageValue = "44"
   )
   public static int method1024(int var0, class219 var1) {
      return (var0 + 40000 << 8) + var1.field2788;
   }
}
