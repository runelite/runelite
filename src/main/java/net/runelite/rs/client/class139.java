package net.runelite.rs.client;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("en")
public class class139 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1824425207
   )
   static volatile int field2128 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -921685599
   )
   static volatile int field2129 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 49947497
   )
   public static int field2130 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 267587693
   )
   static volatile int field2131 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 527530941
   )
   static volatile int field2132 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1789477613
   )
   public static int field2133 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1694342687
   )
   public static int field2134 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -552937419
   )
   public static int field2135 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -836247921
   )
   static volatile int field2136 = 0;
   @ObfuscatedName("mj")
   static byte field2137;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1352966479
   )
   static volatile int field2138 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 7374763612763720041L
   )
   static volatile long field2139 = 0L;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -518614831
   )
   public static int field2140 = 0;
   @ObfuscatedName("j")
   public static class139 field2141 = new class139();
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 802032525
   )
   public static int field2142 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -4001602201308208371L
   )
   public static long field2143 = 0L;
   @ObfuscatedName("c")
   static int[] field2144;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2094377827
   )
   public static volatile int field2145 = 0;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != field2141) {
         field2129 = 0;
         field2138 = var1.getX();
         field2131 = var1.getY();
         field2139 = class92.method2177();
         if(var1.isAltDown()) {
            field2136 = 4;
            field2145 = 4;
         } else if(var1.isMetaDown()) {
            field2136 = 2;
            field2145 = 2;
         } else {
            field2136 = 1;
            field2145 = 1;
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

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(field2141 != null) {
         field2129 = 0;
         field2128 = var1.getX();
         field2132 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != field2141) {
         field2129 = 0;
         field2128 = -1;
         field2132 = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(field2141 != null) {
         field2129 = 0;
         field2128 = var1.getX();
         field2132 = var1.getY();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(null != field2141) {
         field2129 = 0;
         field2128 = var1.getX();
         field2132 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2141) {
         field2145 = 0;
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(field2141 != null) {
         field2129 = 0;
         field2145 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("j")
   public static File method3005(String var0, String var1, int var2) {
      String var3 = 0 == var2?"":"" + var2;
      class21.field572 = new File(class0.field14, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      class118 var8;
      File var20;
      if(class21.field572.exists()) {
         try {
            class226 var7 = new class226(class21.field572, "rw", 10000L);

            int var9;
            for(var8 = new class118((int)var7.method4176()); var8.field1981 < var8.field1980.length; var8.field1981 += var9) {
               var9 = var7.method4177(var8.field1980, var8.field1981, var8.field1980.length - var8.field1981);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.field1981 = 0;
            var9 = var8.method2536();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.method2536();
            }

            if(var9 <= 2) {
               var4 = var8.method2562();
               if(1 == var10) {
                  var5 = var8.method2562();
               }
            } else {
               var4 = var8.method2715();
               if(1 == var10) {
                  var5 = var8.method2715();
               }
            }

            var7.method4183();
         } catch (IOException var17) {
            var17.printStackTrace();
         }

         if(var4 != null) {
            var20 = new File(var4);
            if(!var20.exists()) {
               var4 = null;
            }
         }

         if(null != var4) {
            var20 = new File(var4, "test.dat");
            if(!class0.method3(var20, true)) {
               var4 = null;
            }
         }
      }

      if(null == var4 && 0 == var2) {
         label136:
         for(int var18 = 0; var18 < class14.field209.length; ++var18) {
            for(int var21 = 0; var21 < class188.field3036.length; ++var21) {
               File var22 = new File(class188.field3036[var21] + class14.field209[var18] + File.separatorChar + var0 + File.separatorChar);
               if(var22.exists() && class0.method3(new File(var22, "test.dat"), true)) {
                  var4 = var22.toString();
                  var6 = true;
                  break label136;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class0.field14 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      File var19;
      if(var5 != null) {
         var19 = new File(var5);
         var20 = new File(var4);

         try {
            File[] var23 = var19.listFiles();
            File[] var25 = var23;

            for(int var11 = 0; var11 < var25.length; ++var11) {
               File var12 = var25[var11];
               File var13 = new File(var20, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var16) {
            var16.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         var19 = new File(var4);
         var8 = null;

         try {
            class226 var24 = new class226(class21.field572, "rw", 10000L);
            class118 var26 = new class118(500);
            var26.method2521(3);
            var26.method2521(null != var8?1:0);
            var26.method2529(var19.getPath());
            if(var8 != null) {
               var26.method2529(var19.getPath());
            }

            var24.method4185(var26.field1980, 0, var26.field1981);
            var24.method4183();
         } catch (IOException var15) {
            var15.printStackTrace();
         }
      }

      return new File(var4);
   }
}
