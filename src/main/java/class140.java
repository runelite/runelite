import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ea")
public class class140 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("a")
   public static class140 field2145 = new class140();
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2011392011
   )
   public static volatile int field2146 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 123466747
   )
   public static int field2147 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1793601277
   )
   public static volatile int field2148 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 115577727
   )
   public static volatile int field2149 = -1;
   @ObfuscatedName("gs")
   static class173 field2150;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -206915491
   )
   public static int field2151 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -478359289
   )
   public static volatile int field2153 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1251518311
   )
   public static volatile int field2154 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1195255551
   )
   public static volatile int field2155 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 8445443019831053917L
   )
   public static volatile long field2156 = 0L;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1839065713
   )
   public static int field2157 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 8525519330193258225L
   )
   public static long field2158 = 0L;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 347205827
   )
   public static int field2159 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 867070349
   )
   public static int field2160 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -960056049
   )
   public static int field2161 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -513861703
   )
   public static volatile int field2162 = -1;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != field2145) {
         field2146 = 0;
         field2154 = var1.getX();
         field2155 = var1.getY();
         field2156 = class127.method2941();
         if(var1.isAltDown()) {
            field2153 = 4;
            field2148 = 4;
         } else if(var1.isMetaDown()) {
            field2153 = 2;
            field2148 = 2;
         } else {
            field2153 = 1;
            field2148 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(field2145 != null) {
         field2146 = 0;
         field2148 = 0;
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

   public final synchronized void focusLost(FocusEvent var1) {
      if(field2145 != null) {
         field2148 = 0;
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(field2145 != null) {
         field2146 = 0;
         field2162 = var1.getX();
         field2149 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(null != field2145) {
         field2146 = 0;
         field2162 = var1.getX();
         field2149 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != field2145) {
         field2146 = 0;
         field2162 = -1;
         field2149 = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != field2145) {
         field2146 = 0;
         field2162 = var1.getX();
         field2149 = var1.getY();
      }

   }
}
