import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("do")
public class class115 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -353758181
   )
   @Export("mouseIdleTicks")
   static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("o")
   @Export("mouse")
   public static class115 mouse = new class115();
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 107902685
   )
   public static volatile int field1811 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1467926661
   )
   public static volatile int field1812 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -2408670727503321453L
   )
   public static long field1813 = 0L;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1235537309
   )
   public static int field1814 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -829735009
   )
   public static volatile int field1816 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1768799215
   )
   public static volatile int field1817 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2869177
   )
   public static volatile int field1818 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 4599964928899080219L
   )
   public static volatile long field1819 = 0L;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1170018149
   )
   public static int field1820 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 374092531
   )
   public static int field1821 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1081412297
   )
   public static int field1822 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1831031327
   )
   public static int field1823 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 47392597
   )
   public static int field1825 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -825767599
   )
   public static volatile int field1827 = 0;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1817 = var1.getX();
         field1818 = var1.getY();
         field1819 = class114.method2154();
         if(var1.isAltDown()) {
            field1816 = 4;
            field1827 = 4;
         } else if(var1.isMetaDown()) {
            field1816 = 2;
            field1827 = 2;
         } else {
            field1816 = 1;
            field1827 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1811 = var1.getX();
         field1812 = var1.getY();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1811 = var1.getX();
         field1812 = var1.getY();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1811 = var1.getX();
         field1812 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field1827 = 0;
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1811 = -1;
         field1812 = -1;
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1827 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }
}
