import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class59 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1550178843
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -861358911
   )
   public static int field732;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 323189309
   )
   public static volatile int field733;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 547325101
   )
   @Export("mouseX")
   public static volatile int mouseX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -632069887
   )
   public static volatile int field735;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 873290059
   )
   public static int field736;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1916823519
   )
   public static int field737;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1045288265
   )
   public static int field738;
   @ObfuscatedName("i")
   @Export("mouse")
   public static class59 mouse;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -920779057
   )
   public static volatile int field740;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1440568219
   )
   public static volatile int field741;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = -7864377068423967503L
   )
   public static volatile long field742;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1582994045
   )
   @Export("mouseY")
   public static volatile int mouseY;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1224546993
   )
   public static int field745;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 8827500535201521155L
   )
   public static long field746;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -1383073243
   )
   static int field747;
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 1587992235
   )
   static int field748;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -818518485
   )
   public static int field750;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field740 = var1.getX();
         field741 = var1.getY();
         field742 = XGrandExchangeOffer.method96();
         if(var1.isAltDown()) {
            field735 = 4;
            field733 = 4;
         } else if(var1.isMetaDown()) {
            field735 = 2;
            field733 = 2;
         } else {
            field735 = 1;
            field733 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field733 = 0;
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

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIS)V",
      garbageValue = "-2570"
   )
   public static final void method966(int var0, int var1, int var2, int var3, int var4) {
      class7.field239.method3531(new class8(var0, var1, var2, var3, var4));
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field733 = 0;
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = -1;
         mouseY = -1;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IIIZI)V",
      garbageValue = "467629912"
   )
   public static void method985(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class203.field2514 = 1;
      class203.field2513 = var0;
      class203.field2515 = var1;
      class157.field2280 = var2;
      class151.field2229 = var3;
      class87.field1404 = var4;
      ChatMessages.field1527 = 10000;
   }

   static {
      mouse = new class59();
      mouseIdleTicks = 0;
      field733 = 0;
      mouseX = -1;
      mouseY = -1;
      field736 = 0;
      field737 = 0;
      field738 = 0;
      field735 = 0;
      field740 = 0;
      field741 = 0;
      field742 = 0L;
      field732 = 0;
      field745 = 0;
      field750 = 0;
      field746 = 0L;
   }

   public final void focusGained(FocusEvent var1) {
   }
}
