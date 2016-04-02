import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("en")
public class class140 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -249286387
   )
   static volatile int field2134 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1325777447
   )
   public static int field2135 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -585866463
   )
   public static int field2136 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 678527351
   )
   static volatile int field2137 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 135925609
   )
   static volatile int field2138 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -309132047
   )
   public static volatile int field2139 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -449385255
   )
   public static int field2140 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1811584557
   )
   public static int field2141 = 0;
   @ObfuscatedName("e")
   static class140 field2142 = new class140();
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1263208543
   )
   static volatile int field2143 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 186705969
   )
   static volatile int field2144 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 6910495852400776299L
   )
   static volatile long field2145 = 0L;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -495032001
   )
   public static int field2146 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -349500293
   )
   static volatile int field2147 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1656900819
   )
   public static int field2148 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 8504411161145502587L
   )
   public static long field2149 = 0L;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != field2142) {
         field2139 = 0;
         field2143 = var1.getX();
         field2134 = var1.getY();
         field2145 = method2967();
         if(var1.isAltDown()) {
            field2144 = 4;
            field2147 = 4;
         } else if(var1.isMetaDown()) {
            field2144 = 2;
            field2147 = 2;
         } else {
            field2144 = 1;
            field2147 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != field2142) {
         field2139 = 0;
         field2147 = 0;
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
      if(field2142 != null) {
         field2139 = 0;
         field2137 = var1.getX();
         field2138 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != field2142) {
         field2139 = 0;
         field2137 = -1;
         field2138 = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != field2142) {
         field2139 = 0;
         field2137 = var1.getX();
         field2138 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2142) {
         field2147 = 0;
      }

   }

   @ObfuscatedName("f")
   public static int method2929(CharSequence var0) {
      return class174.method3424(var0, 10);
   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(field2142 != null) {
         field2139 = 0;
         field2137 = var1.getX();
         field2138 = var1.getY();
      }

   }

   @ObfuscatedName("e")
   public static void method2966(class167 var0, class167 var1, class167 var2, class167 var3) {
      class173.field2746 = var0;
      class173.field2747 = var1;
      class173.field2748 = var2;
      class119.field1981 = var3;
      class173.field2837 = new class173[class173.field2746.method3257()][];
      class173.field2745 = new boolean[class173.field2746.method3257()];
   }

   @ObfuscatedName("e")
   public static synchronized long method2967() {
      long var0 = System.currentTimeMillis();
      if(var0 < class115.field1955) {
         class115.field1954 += class115.field1955 - var0;
      }

      class115.field1955 = var0;
      return var0 + class115.field1954;
   }
}
