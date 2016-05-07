import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ek")
public class class140 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 8912943093828149227L
   )
   public static volatile long field2156 = 0L;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 34427727
   )
   public static volatile int field2157 = 0;
   @ObfuscatedName("s")
   public static class140 field2158 = new class140();
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1174445989
   )
   public static int field2159 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 283913597
   )
   public static volatile int field2160 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1643541955
   )
   public static int field2161 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1109564969
   )
   public static int field2162 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 104211701
   )
   public static int field2163 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -6467936210320514093L
   )
   public static long field2164 = 0L;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2141106561
   )
   public static volatile int field2165 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1093873933
   )
   public static volatile int field2166 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1852210365
   )
   public static volatile int field2167 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -676727661
   )
   public static volatile int field2168 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 734982041
   )
   public static int field2169 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1347490765
   )
   public static int field2170 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 18855539
   )
   public static volatile int field2171 = 0;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != field2158) {
         field2157 = 0;
         field2165 = var1.getX();
         field2166 = var1.getY();
         field2156 = class12.method162();
         if(var1.isAltDown()) {
            field2167 = 4;
            field2171 = 4;
         } else if(var1.isMetaDown()) {
            field2167 = 2;
            field2171 = 2;
         } else {
            field2167 = 1;
            field2171 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(field2158 != null) {
         field2157 = 0;
         field2168 = var1.getX();
         field2160 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != field2158) {
         field2157 = 0;
         field2168 = -1;
         field2160 = -1;
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(field2158 != null) {
         field2157 = 0;
         field2168 = var1.getX();
         field2160 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2158) {
         field2171 = 0;
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(field2158 != null) {
         field2157 = 0;
         field2171 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != field2158) {
         field2157 = 0;
         field2168 = var1.getX();
         field2160 = var1.getY();
      }

   }
}
