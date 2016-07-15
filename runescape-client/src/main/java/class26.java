import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class26 extends class211 {
   @ObfuscatedName("h")
   class205 field659 = new class205();
   @ObfuscatedName("bl")
   static class83 field660;
   @ObfuscatedName("bf")
   protected static FontMetrics field662;
   @ObfuscatedName("c")
   class49 field667;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = -1800743925
   )
   static int field668;
   @ObfuscatedName("pj")
   static class137 field669;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass20;",
      garbageValue = "-881043882"
   )
   class20 method589(int var1) {
      class20 var2 = (class20)this.field659.method3938();
      if(var2 != null && var2.field588 <= var1) {
         for(class20 var3 = (class20)this.field659.method3940(); null != var3 && var3.field588 <= var1; var3 = (class20)this.field659.method3940()) {
            var2.method4000();
            var2 = var3;
         }

         if(var2.field590 + var2.field588 + this.field667.field1104 > var1) {
            return var2;
         } else {
            var2.method4000();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-50"
   )
   void method590(int var1, int var2, int var3, int var4) {
      class20 var5 = null;
      int var6 = 0;

      for(class20 var7 = (class20)this.field659.method3938(); null != var7; var7 = (class20)this.field659.method3940()) {
         ++var6;
         if(var1 == var7.field588) {
            var7.method535(var1, var2, var3, var4);
            return;
         }

         if(var7.field588 <= var1) {
            var5 = var7;
         }
      }

      if(null == var5) {
         if(var6 < 4) {
            this.field659.method3945(new class20(var1, var2, var3, var4));
         }

      } else {
         class205.method3937(new class20(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.field659.method3938().method4000();
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-248336062"
   )
   static final String method592(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass125;ILclass2;IB)V",
      garbageValue = "50"
   )
   static final void method595(class125 var0, int var1, class2 var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 64) != 0) {
         var5 = var0.method2610();
         byte[] var6 = new byte[var5];
         class122 var7 = new class122(var6);
         var0.method2737(var6, 0, var5);
         class34.field798[var1] = var7;
         var2.method22(var7);
      }

      int var19;
      if((var3 & 128) != 0) {
         var5 = var0.method2612();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var19 = var0.method2610();
         class117.method2531(var2, var5, var19);
      }

      if((var3 & 16) != 0) {
         var2.field876 = var0.method2612();
         if(var2.field876 == '\uffff') {
            var2.field876 = -1;
         }
      }

      if((var3 & 4) != 0) {
         var2.field873 = var0.method2617();
         if(var2.field873.charAt(0) == 126) {
            var2.field873 = var2.field873.substring(1);
            class25.method586(2, var2.field52, var2.field873);
         } else if(var2 == class118.field2035) {
            class25.method586(2, var2.field52, var2.field873);
         }

         var2.field864 = false;
         var2.field867 = 0;
         var2.field868 = 0;
         var2.field866 = 150;
      }

      int var9;
      int var10;
      if((var3 & 8) != 0) {
         var5 = var0.method2610();
         int var8;
         int var11;
         int var20;
         if(var5 > 0) {
            for(var19 = 0; var19 < var5; ++var19) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var20 = var0.method2672();
               if(var20 == 32767) {
                  var20 = var0.method2672();
                  var9 = var0.method2672();
                  var8 = var0.method2672();
                  var10 = var0.method2672();
               } else if(var20 != 32766) {
                  var9 = var0.method2672();
               } else {
                  var20 = -1;
               }

               var11 = var0.method2672();
               var2.method796(var20, var9, var8, var10, client.field567, var11);
            }
         }

         var19 = var0.method2610();
         if(var19 > 0) {
            for(var20 = 0; var20 < var19; ++var20) {
               var8 = var0.method2672();
               var9 = var0.method2672();
               if(var9 != 32767) {
                  var10 = var0.method2672();
                  var11 = var0.method2610();
                  int var12 = var9 > 0?var0.method2610():var11;
                  var2.method786(var8, client.field567, var9, var10, var11, var12);
               } else {
                  var2.method794(var8);
               }
            }
         }
      }

      if((var3 & 32) != 0) {
         var2.field878 = var0.method2612();
         if(var2.field852 == 0) {
            var2.field889 = var2.field878;
            var2.field878 = -1;
         }
      }

      if((var3 & 1) != 0) {
         var5 = var0.method2612();
         class155[] var22 = new class155[]{class155.field2313, class155.field2310, class155.field2320, class155.field2309, class155.field2311};
         class155 var23 = (class155)class25.method585(var22, var0.method2610());
         boolean var25 = var0.method2610() == 1;
         var9 = var0.method2610();
         var10 = var0.field2061;
         if(var2.field52 != null && var2.field53 != null) {
            boolean var26 = false;
            if(var23.field2321 && class118.method2542(var2.field52)) {
               var26 = true;
            }

            if(!var26 && client.field490 == 0 && !var2.field51) {
               class34.field808.field2061 = 0;
               var0.method2737(class34.field808.field2054, 0, var9);
               class34.field808.field2061 = 0;
               class122 var13 = class34.field808;
               String var21 = class48.method1027(var13, 32767);
               String var14 = class226.method4139(class46.method1015(var21));
               var2.field873 = var14.trim();
               var2.field867 = var5 >> 8;
               var2.field868 = var5 & 255;
               var2.field866 = 150;
               var2.field864 = var25;
               var2.field897 = class118.field2035 != var2 && var23.field2321 && "" != client.field404 && var14.toLowerCase().indexOf(client.field404) == -1;
               int var15;
               if(var23.field2315) {
                  var15 = var25?91:1;
               } else {
                  var15 = var25?90:2;
               }

               if(var23.field2314 != -1) {
                  int var18 = var23.field2314;
                  String var17 = "<img=" + var18 + ">";
                  class25.method586(var15, var17 + var2.field52, var14);
               } else {
                  class25.method586(var15, var2.field52, var14);
               }
            }
         }

         var0.field2061 = var10 + var9;
      }

      if((var3 & 512) != 0) {
         var2.field887 = var0.method2612();
         var5 = var0.method2614();
         var2.field891 = var5 >> 16;
         var2.field869 = client.field567 + (var5 & '\uffff');
         var2.field888 = 0;
         var2.field882 = 0;
         if(var2.field869 > client.field567) {
            var2.field888 = -1;
         }

         if(var2.field887 == '\uffff') {
            var2.field887 = -1;
         }
      }

      if((var3 & 2048) != 0) {
         var2.field892 = var0.method2611();
         var2.field894 = var0.method2611();
         var2.field893 = var0.method2611();
         var2.field895 = var0.method2611();
         var2.field883 = var0.method2612() + client.field567;
         var2.field859 = var0.method2612() + client.field567;
         var2.field862 = var0.method2612();
         if(var2.field37) {
            var2.field892 += var2.field54;
            var2.field894 += var2.field55;
            var2.field893 += var2.field54;
            var2.field895 += var2.field55;
            var2.field852 = 0;
         } else {
            var2.field892 += var2.field885[0];
            var2.field894 += var2.field906[0];
            var2.field893 += var2.field885[0];
            var2.field895 += var2.field906[0];
            var2.field852 = 1;
         }

         var2.field909 = 0;
      }

      if((var3 & 256) != 0) {
         class34.field799[var1] = var0.method2611();
      }

      if((var3 & 4096) != 0) {
         var4 = var0.method2611();
      }

      if((var3 & 1024) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.field47[var5] = var0.method2617();
         }
      }

      if(var2.field37) {
         if(var4 == 127) {
            var2.method23(var2.field54, var2.field55);
         } else {
            byte var24;
            if(var4 != -1) {
               var24 = var4;
            } else {
               var24 = class34.field799[var1];
            }

            var2.method9(var2.field54, var2.field55, var24);
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-3215898"
   )
   boolean method599() {
      return this.field659.method3934();
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1636416477"
   )
   static final void method600(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field457; ++var4) {
         if(client.field505[var4] + client.field503[var4] > var0 && client.field503[var4] < var2 + var0 && client.field504[var4] + client.field466[var4] > var1 && client.field504[var4] < var3 + var1) {
            client.field501[var4] = true;
         }
      }

   }

   class26(class49 var1) {
      this.field667 = var1;
   }

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "70066337"
   )
   static final void method602(String var0, int var1) {
      client.field336.method2854(74);
      client.field336.method2795(class29.method650(var0) + 1);
      client.field336.method2795(var1);
      client.field336.method2601(var0);
   }
}
