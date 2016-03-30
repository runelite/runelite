import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("em")
public class class140 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("w")
   public static class140 field2163 = new class140();
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -5308510489364834835L
   )
   static volatile long field2164 = 0L;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 8438023
   )
   static volatile int field2165 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 262975031
   )
   static volatile int field2166 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1449603609
   )
   public static int field2167 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1607503269
   )
   public static int field2168 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1673230261
   )
   static volatile int field2169 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -613363979
   )
   static volatile int field2171 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 27840619
   )
   static volatile int field2172 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1940370419
   )
   static volatile int field2173 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1555122563
   )
   static volatile int field2174 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1477452279
   )
   public static int field2176 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1674096897
   )
   public static int field2177 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 8513499118618824997L
   )
   public static long field2178 = 0L;
   @ObfuscatedName("dn")
   static int[] field2180;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1295218809
   )
   public static int field2182 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 281978147
   )
   public static int field2184 = 0;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != field2163) {
         field2169 = 0;
         field2172 = var1.getX();
         field2173 = var1.getY();
         field2164 = class14.method165();
         if(var1.isAltDown()) {
            field2171 = 4;
            field2165 = 4;
         } else if(var1.isMetaDown()) {
            field2171 = 2;
            field2165 = 2;
         } else {
            field2171 = 1;
            field2165 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(field2163 != null) {
         field2169 = 0;
         field2165 = 0;
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
      if(null != field2163) {
         field2169 = 0;
         field2166 = var1.getX();
         field2174 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(field2163 != null) {
         field2169 = 0;
         field2166 = -1;
         field2174 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("e")
   static final boolean method2947(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      class119 var4 = new class119(var0);
      int var5 = -1;

      label82:
      while(true) {
         int var6 = var4.method2571();
         if(0 == var6) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method2571();
               if(0 == var9) {
                  continue label82;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.method2506() >> 2;
               int var13 = var11 + var1;
               int var14 = var2 + var10;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  class40 var15 = class22.method592(var5);
                  if(22 != var12 || !client.field413 || var15.field975 != 0 || var15.field931 == 1 || var15.field941) {
                     if(!var15.method821()) {
                        ++client.field563;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method2571();
            if(0 == var9) {
               break;
            }

            var4.method2506();
         }
      }
   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(field2163 != null) {
         field2169 = 0;
         field2166 = var1.getX();
         field2174 = var1.getY();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(field2163 != null) {
         field2169 = 0;
         field2166 = var1.getX();
         field2174 = var1.getY();
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2163) {
         field2165 = 0;
      }

   }
}
