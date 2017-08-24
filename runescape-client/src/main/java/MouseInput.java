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

@ObfuscatedName("br")
@Implements("MouseInput")
public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lbr;"
   )
   @Export("mouse")
   public static MouseInput mouse;
   @ObfuscatedName("n")
   static volatile int field744;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1796761787
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2133431837
   )
   @Export("mouseX")
   static volatile int mouseX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -534109533
   )
   static volatile int field749;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 58069931
   )
   public static int field754;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1024995521
   )
   @Export("mouseY")
   static volatile int mouseY;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -469467209
   )
   public static int field752;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1798561819
   )
   static volatile int field750;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -53447627
   )
   public static int field747;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1648982393
   )
   public static int field745;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -982142813
   )
   public static int field753;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1743853869
   )
   static volatile int field748;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 478400027
   )
   public static int field739;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 4636196276748822291L
   )
   static volatile long field751;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 1071589525981010893L
   )
   public static long field755;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -598539657
   )
   static int field756;

   static {
      mouse = new MouseInput();
      mouseIdleTicks = 0;
      field744 = 0;
      mouseX = -1;
      mouseY = -1;
      field745 = 0;
      field752 = 0;
      field747 = 0;
      field748 = 0;
      field749 = 0;
      field750 = 0;
      field751 = 0L;
      field754 = 0;
      field753 = 0;
      field739 = 0;
      field755 = 0L;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/event/MouseEvent;I)I",
      garbageValue = "-461601545"
   )
   final int method1031(MouseEvent var1) {
      int var2 = var1.getButton();
      return !var1.isAltDown() && var2 != 2?(!var1.isMetaDown() && var2 != 3?1:2):4;
   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field744 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field749 = var1.getX();
         field750 = var1.getY();
         field751 = class45.currentTimeMs();
         field748 = this.method1031(var1);
         if(field748 != 0) {
            field744 = field748 * 950242191;
         }
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
         field744 = 0;
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "102"
   )
   public static int method1048(String var0) {
      return var0.length() + 2;
   }
}
