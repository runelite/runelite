import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class140 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 131714421
   )
   static volatile int field2122 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 503752599
   )
   public static volatile int field2123 = 0;
   @ObfuscatedName("j")
   public static class140 field2124 = new class140();
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2143457815
   )
   static volatile int field2125 = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1869698579
   )
   public static int field2126 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 546863387
   )
   public static int field2127 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1933093391
   )
   public static int field2128 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1166157639
   )
   static volatile int field2129 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1339451357
   )
   public static volatile int field2130 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1030766195
   )
   static volatile int field2131 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 692373943
   )
   static volatile int field2132 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1643529151
   )
   public static int field2134 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2097632903
   )
   public static int field2135 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1041042939
   )
   public static int field2136 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -5389995299778113427L
   )
   public static long field2137 = 0L;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -3203028209696080685L
   )
   static volatile long field2140 = 0L;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != field2124) {
         field2123 = 0;
         field2131 = var1.getX();
         field2132 = var1.getY();
         field2140 = class77.method1674();
         if(var1.isAltDown()) {
            field2129 = 4;
            field2130 = 4;
         } else if(var1.isMetaDown()) {
            field2129 = 2;
            field2130 = 2;
         } else {
            field2129 = 1;
            field2130 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != field2124) {
         field2123 = 0;
         field2130 = 0;
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
      if(field2124 != null) {
         field2123 = 0;
         field2125 = var1.getX();
         field2122 = var1.getY();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(field2124 != null) {
         field2123 = 0;
         field2125 = var1.getX();
         field2122 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2124) {
         field2130 = 0;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != field2124) {
         field2123 = 0;
         field2125 = var1.getX();
         field2122 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(field2124 != null) {
         field2123 = 0;
         field2125 = -1;
         field2122 = -1;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-103"
   )
   static void method2948(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      class172 var4 = (class172)class171.field2715.method3742(var2);
      if(null != var4) {
         class171.field2716.method3855(var4);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "750681662"
   )
   public static void method2949(boolean var0) {
      if(class72.field1334 != var0) {
         class0.method2();
         class72.field1334 = var0;
      }

   }
}
