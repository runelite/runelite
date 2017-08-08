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
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lbi;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -663327511
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks;
   @ObfuscatedName("z")
   public static volatile int field729;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1693873367
   )
   @Export("mouseX")
   public static volatile int mouseX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1137449143
   )
   public static volatile int field721;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1983349279
   )
   public static int field734;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -163889299
   )
   @Export("mouseY")
   public static volatile int mouseY;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -800064331
   )
   public static int field718;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1356714701
   )
   public static volatile int field722;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2013944849
   )
   public static int field719;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1229038907
   )
   public static int field711;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1497852919
   )
   public static int field725;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -429268149
   )
   public static int field726;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -983890295
   )
   public static volatile int field720;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -5564021905598906431L
   )
   public static volatile long field723;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = 150547967
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 4949146223556977161L
   )
   public static long field727;
   @ObfuscatedName("qw")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   static MachineInfo field731;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      field729 = 0;
      mouseX = -1;
      mouseY = -1;
      field711 = 0;
      field718 = 0;
      field719 = 0;
      field720 = 0;
      field721 = 0;
      field722 = 0;
      field723 = 0L;
      field734 = 0;
      field725 = 0;
      field726 = 0;
      field727 = 0L;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;B)I",
      garbageValue = "5"
   )
   final int method986(MouseEvent var1) {
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

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field721 = var1.getX();
         field722 = var1.getY();
         field723 = class170.currentTimeMs();
         field720 = this.method986(var1);
         if(field720 != 0) {
            field729 = field720 * -771683741;
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

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = -1;
         mouseY = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field729 = 0;
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field729 = 0;
      }

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
}
