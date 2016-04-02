import java.awt.Image;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class13 implements Runnable {
   @ObfuscatedName("e")
   boolean field194 = true;
   @ObfuscatedName("w")
   Object field195 = new Object();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2016362907
   )
   int field196 = 0;
   @ObfuscatedName("s")
   int[] field198 = new int[500];
   @ObfuscatedName("g")
   static class78 field199;
   @ObfuscatedName("jk")
   static class173[] field201;
   @ObfuscatedName("p")
   int[] field202 = new int[500];
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = 2053634457
   )
   static int field204;
   @ObfuscatedName("qx")
   protected static Image field206;

   public void run() {
      for(; this.field194; class130.method2818(50L)) {
         Object var1 = this.field195;
         synchronized(this.field195) {
            if(this.field196 < 500) {
               this.field198[this.field196] = class140.field2140;
               this.field202[this.field196] = class140.field2141;
               ++this.field196;
            }
         }
      }

   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "([Lclass173;II)V",
      garbageValue = "-460214582"
   )
   static final void method164(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(null != var3 && var1 == var3.field2774 && (!var3.field2809 || !class21.method579(var3))) {
            int var5;
            if(var3.field2757 == 0) {
               if(!var3.field2809 && class21.method579(var3) && var3 != class7.field138) {
                  continue;
               }

               method164(var0, var3.field2794);
               if(var3.field2879 != null) {
                  method164(var3.field2879, var3.field2794);
               }

               class3 var4 = (class3)client.field439.method3788((long)var3.field2794);
               if(null != var4) {
                  var5 = var4.field69;
                  if(class113.method2462(var5)) {
                     method164(class173.field2837[var5], -1);
                  }
               }
            }

            if(6 == var3.field2757) {
               if(var3.field2845 != -1 || -1 != var3.field2877) {
                  boolean var7 = class102.method2313(var3);
                  if(var7) {
                     var5 = var3.field2877;
                  } else {
                     var5 = var3.field2845;
                  }

                  if(-1 != var5) {
                     class42 var6 = class46.method974(var5);

                     for(var3.field2868 += client.field355; var3.field2868 > var6.field968[var3.field2749]; class9.method133(var3)) {
                        var3.field2868 -= var6.field968[var3.field2749];
                        ++var3.field2749;
                        if(var3.field2749 >= var6.field975.length) {
                           var3.field2749 -= var6.field965;
                           if(var3.field2749 < 0 || var3.field2749 >= var6.field975.length) {
                              var3.field2749 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2811 != 0 && !var3.field2809) {
                  int var8 = var3.field2811 >> 16;
                  var5 = var3.field2811 << 16 >> 16;
                  var8 *= client.field355;
                  var5 *= client.field355;
                  var3.field2765 = var3.field2765 + var8 & 2047;
                  var3.field2807 = var5 + var3.field2807 & 2047;
                  class9.method133(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "731177068"
   )
   static void method165() {
      for(class3 var0 = (class3)client.field439.method3794(); var0 != null; var0 = (class3)client.field439.method3791()) {
         int var1 = var0.field69;
         if(class113.method2462(var1)) {
            boolean var2 = true;
            class173[] var3 = class173.field2837[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].field2809;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.field3115;
               class173 var5 = class148.method3129(var4);
               if(null != var5) {
                  class9.method133(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   public static class130 method166(int var0) {
      class130[] var1 = new class130[]{class130.field2048, class130.field2052, class130.field2049};
      class130[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class130 var4 = var2[var3];
         if(var0 == var4.field2050) {
            return var4;
         }
      }

      return null;
   }
}
