import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public class class140 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 15364851
   )
   public static volatile int field2128 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 238535171
   )
   @Export("mouseIdleTicks")
   public static volatile int field2129 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1640480455
   )
   public static volatile int field2130 = 0;
   @ObfuscatedName("b")
   @Export("mouse")
   public static class140 field2131 = new class140();
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1630499649
   )
   public static volatile int field2132 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1417574723
   )
   public static int field2133 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1347180707
   )
   public static int field2134 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 694427091
   )
   public static int field2135 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 535594031
   )
   public static volatile int field2136 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1327786957
   )
   public static volatile int field2137 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1820906897
   )
   public static volatile int field2138 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 4168244488976569193L
   )
   public static volatile long field2139 = 0L;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -951049823
   )
   public static int field2140 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1951140247
   )
   public static int field2141 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -20301083
   )
   public static int field2142 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 2735764516096252043L
   )
   public static long field2143 = 0L;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != field2131) {
         field2129 = 0;
         field2137 = var1.getX();
         field2138 = var1.getY();
         field2139 = class90.method2090();
         if(var1.isAltDown()) {
            field2128 = 4;
            field2130 = 4;
         } else if(var1.isMetaDown()) {
            field2128 = 2;
            field2130 = 2;
         } else {
            field2128 = 1;
            field2130 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(field2131 != null) {
         field2129 = 0;
         field2130 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(field2131 != null) {
         field2129 = 0;
         field2132 = var1.getX();
         field2136 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != field2131) {
         field2129 = 0;
         field2132 = -1;
         field2136 = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != field2131) {
         field2129 = 0;
         field2132 = var1.getX();
         field2136 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(null != field2131) {
         field2129 = 0;
         field2132 = var1.getX();
         field2136 = var1.getY();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(field2131 != null) {
         field2130 = 0;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "94"
   )
   static final void method2999(class122 var0) {
      for(int var1 = 0; var1 < class32.field745; ++var1) {
         int var2 = class32.field746[var1];
         class2 var3 = client.field410[var2];
         int var4 = var0.method2514();
         if((var4 & 4) != 0) {
            var4 += var0.method2514() << 8;
         }

         byte var5 = -1;
         int var6;
         if((var4 & 1) != 0) {
            var6 = var0.method2514();
            byte[] var7 = new byte[var6];
            class119 var8 = new class119(var7);
            var0.method2525(var7, 0, var6);
            class32.field737[var2] = var8;
            var3.method13(var8);
         }

         int var16;
         if((var4 & 64) != 0) {
            var6 = var0.method2516();
            if(var6 == '\uffff') {
               var6 = -1;
            }

            var16 = var0.method2514();
            class153.method3164(var3, var6, var16);
         }

         if((var4 & 8) != 0) {
            var3.field815 = var0.method2516();
            if(var3.field815 == '\uffff') {
               var3.field815 = -1;
            }
         }

         if((var4 & 16) != 0) {
            var3.field803 = var0.method2522();
            if(var3.field803.charAt(0) == 126) {
               var3.field803 = var3.field803.substring(1);
               class45.method955(2, var3.field26, var3.field803);
            } else if(var3 == class153.field2262) {
               class45.method955(2, var3.field26, var3.field803);
            }

            var3.field841 = false;
            var3.field807 = 0;
            var3.field804 = 0;
            var3.field806 = 150;
         }

         if((var4 & 128) != 0) {
            var6 = var0.method2516();
            var16 = var0.method2514();
            var3.method754(var6, var16, client.field296);
            var3.field812 = 300 + client.field296;
            var3.field794 = var0.method2514();
            var3.field814 = var0.method2514();
         }

         if((var4 & 32) != 0) {
            var3.field817 = var0.method2516();
            if(var3.field808 == 0) {
               var3.field840 = var3.field817;
               var3.field817 = -1;
            }
         }

         if((var4 & 2) != 0) {
            var6 = var0.method2516();
            class152 var18 = (class152)class157.method3181(class4.method39(), var0.method2514());
            boolean var17 = var0.method2514() == 1;
            int var9 = var0.method2514();
            int var10 = var0.field1976;
            if(var3.field26 != null && null != var3.field49) {
               boolean var11 = false;
               if(var18.field2252 && class45.method953(var3.field26)) {
                  var11 = true;
               }

               if(!var11 && client.field409 == 0 && !var3.field40) {
                  class32.field740.field1976 = 0;
                  var0.method2525(class32.field740.field1982, 0, var9);
                  class32.field740.field1976 = 0;
                  class119 var13 = class32.field740;
                  String var12 = class175.method3455(var13, 32767);
                  String var14 = class223.method4032(class82.method1896(var12));
                  var3.field803 = var14.trim();
                  var3.field807 = var6 >> 8;
                  var3.field804 = var6 & 255;
                  var3.field806 = 150;
                  var3.field841 = var17;
                  var3.field805 = class153.field2262 != var3 && var18.field2252 && "" != client.field503 && var14.toLowerCase().indexOf(client.field503) == -1;
                  int var15;
                  if(var18.field2250) {
                     var15 = var17?91:1;
                  } else {
                     var15 = var17?90:2;
                  }

                  if(var18.field2249 != -1) {
                     class45.method955(var15, class56.method1172(var18.field2249) + var3.field26, var14);
                  } else {
                     class45.method955(var15, var3.field26, var14);
                  }
               }
            }

            var0.field1976 = var9 + var10;
         }

         if((var4 & 256) != 0) {
            var3.field835 = var0.method2516();
            var6 = var0.method2519();
            var3.field834 = var6 >> 16;
            var3.field829 = client.field296 + (var6 & '\uffff');
            var3.field811 = 0;
            var3.field828 = 0;
            if(var3.field829 > client.field296) {
               var3.field811 = -1;
            }

            if(var3.field835 == '\uffff') {
               var3.field835 = -1;
            }
         }

         if((var4 & 1024) != 0) {
            var3.field837 = var0.method2515();
            var3.field833 = var0.method2515();
            var3.field824 = var0.method2515();
            var3.field799 = var0.method2515();
            var3.field843 = var0.method2516() + client.field296;
            var3.field845 = var0.method2516() + client.field296;
            var3.field826 = var0.method2516();
            if(var3.field29) {
               var3.field837 += var3.field50;
               var3.field833 += var3.field51;
               var3.field824 += var3.field50;
               var3.field799 += var3.field51;
               var3.field808 = 0;
            } else {
               var3.field837 += var3.field844[0];
               var3.field833 += var3.field831[0];
               var3.field824 += var3.field844[0];
               var3.field799 += var3.field831[0];
               var3.field808 = 1;
            }

            var3.field836 = 0;
         }

         if((var4 & 512) != 0) {
            var6 = var0.method2516();
            var16 = var0.method2514();
            var3.method754(var6, var16, client.field296);
            var3.field812 = client.field296 + 300;
            var3.field794 = var0.method2514();
            var3.field814 = var0.method2514();
         }

         if((var4 & 2048) != 0) {
            class32.field736[var2] = var0.method2515();
         }

         if((var4 & 8192) != 0) {
            var5 = var0.method2515();
         }

         if((var4 & 4096) != 0) {
            for(var6 = 0; var6 < 3; ++var6) {
               var3.field30[var6] = var0.method2522();
            }
         }

         if(var3.field29) {
            if(var5 == 127) {
               var3.method17(var3.field50, var3.field51);
            } else {
               byte var19;
               if(var5 != -1) {
                  var19 = var5;
               } else {
                  var19 = class32.field736[var2];
               }

               var3.method16(var3.field50, var3.field51, var19);
            }
         }
      }

   }
}
