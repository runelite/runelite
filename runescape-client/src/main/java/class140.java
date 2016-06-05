import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class140 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = 562718731
   )
   static int field2173;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1432715643
   )
   @Export("mouseIdleTicks")
   public static volatile int field2174 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1738045731
   )
   public static volatile int field2175 = 0;
   @ObfuscatedName("hj")
   @ObfuscatedGetter(
      intValue = 245905945
   )
   @Export("menuWidth")
   static int field2176;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -134807055
   )
   static volatile int field2177 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -714560167
   )
   public static int field2178 = 0;
   @ObfuscatedName("pz")
   static class221 field2179;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1642077087
   )
   static volatile int field2180 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 350444107
   )
   static volatile int field2181 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1689832555
   )
   static volatile int field2182 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -468140139
   )
   static volatile int field2183 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 8563310214065944479L
   )
   static volatile long field2184 = 0L;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -821280627
   )
   public static int field2185 = 0;
   @ObfuscatedName("t")
   @Export("mouse")
   public static class140 field2186 = new class140();
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 50544419
   )
   public static int field2187 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -7765895270942088159L
   )
   public static long field2188 = 0L;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1817545591
   )
   public static int field2189 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2080105285
   )
   public static int field2190 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1732912867
   )
   public static int field2192 = 0;

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != field2186) {
         field2174 = 0;
         field2175 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != field2186) {
         field2174 = 0;
         field2180 = var1.getX();
         field2177 = var1.getY();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(field2186 != null) {
         field2174 = 0;
         field2180 = var1.getX();
         field2177 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(field2186 != null) {
         field2174 = 0;
         field2180 = -1;
         field2177 = -1;
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(null != field2186) {
         field2174 = 0;
         field2180 = var1.getX();
         field2177 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(field2186 != null) {
         field2174 = 0;
         field2182 = var1.getX();
         field2183 = var1.getY();
         field2184 = class124.method2746();
         if(var1.isAltDown()) {
            field2181 = 4;
            field2175 = 4;
         } else if(var1.isMetaDown()) {
            field2181 = 2;
            field2175 = 2;
         } else {
            field2181 = 1;
            field2175 = 1;
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

   public final synchronized void focusLost(FocusEvent var1) {
      if(field2186 != null) {
         field2175 = 0;
      }

   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   static final void method2945(boolean var0) {
      int var1 = client.field442;
      int var2 = class10.field162;
      int var3 = class41.field966;
      if(class173.method3380(var1)) {
         class20.method548(class216.field3168[var1], -1, var2, var3, var0);
      }

   }
}
