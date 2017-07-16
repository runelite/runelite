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

@ObfuscatedName("bn")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lbn;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -234497911
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks;
   @ObfuscatedName("e")
   public static volatile int field718;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2037090333
   )
   @Export("mouseX")
   public static volatile int mouseX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -58409057
   )
   public static volatile int field725;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1080192053
   )
   public static int field728;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 249226799
   )
   @Export("mouseY")
   public static volatile int mouseY;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1307517223
   )
   public static int field722;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 351715051
   )
   public static volatile int field726;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -209881429
   )
   public static int field723;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 448603629
   )
   public static int field721;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2021031291
   )
   public static int field735;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1905499755
   )
   public static int field730;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 127351383
   )
   public static volatile int field715;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 2946917575524692411L
   )
   public static volatile long field714;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 1550291629304733315L
   )
   public static long field729;
   @ObfuscatedName("bb")
   static String field733;
   @ObfuscatedName("nn")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   static class276 field732;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      field718 = 0;
      mouseX = -1;
      mouseY = -1;
      field721 = 0;
      field722 = 0;
      field723 = 0;
      field715 = 0;
      field725 = 0;
      field726 = 0;
      field714 = 0L;
      field728 = 0;
      field735 = 0;
      field730 = 0;
      field729 = 0L;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;B)I",
      garbageValue = "1"
   )
   final int method1028(MouseEvent var1) {
      int var2 = var1.getButton();
      return var2 == 1?(var1.isMetaDown()?2:(var1.isAltDown()?4:1)):(var2 == 2?4:(var2 == 3?2:0));
   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field725 = var1.getX();
         field726 = var1.getY();
         field714 = class46.currentTimeMs();
         field715 = this.method1028(var1);
         if(field715 != 0) {
            field718 = field715 * 612100411;
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

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field718 = 0;
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field718 = 0;
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

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(Lhy;B)Ljava/lang/String;",
      garbageValue = "-14"
   )
   static String method1029(Widget var0) {
      int var2 = class46.getWidgetConfig(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(var0.selectedAction != null && var0.selectedAction.trim().length() != 0?var0.selectedAction:null);
   }
}
