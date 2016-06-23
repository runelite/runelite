import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class32 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -278384711
   )
   static int field753 = 0;
   @ObfuscatedName("x")
   static byte[] field755 = new byte[2048];
   @ObfuscatedName("l")
   static class119[] field756 = new class119[2048];
   @ObfuscatedName("p")
   static class119 field757 = new class119(new byte[5000]);
   @ObfuscatedName("cu")
   static class224 field758;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 541365075
   )
   static int field760 = 0;
   @ObfuscatedName("n")
   static int[] field761 = new int[2048];
   @ObfuscatedName("s")
   static int[] field762 = new int[2048];
   @ObfuscatedName("r")
   static int[] field763 = new int[2048];
   @ObfuscatedName("k")
   static int[] field764 = new int[2048];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2015469595
   )
   static int field765 = 0;
   @ObfuscatedName("b")
   static byte[] field767 = new byte[2048];
   @ObfuscatedName("q")
   static int[] field768 = new int[2048];
   @ObfuscatedName("g")
   static int[] field769 = new int[2048];

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "([Lclass173;II)V",
      garbageValue = "-1534085711"
   )
   static final void method740(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(null != var3) {
            if(var3.field2798 == 0) {
               if(var3.field2767 != null) {
                  method740(var3.field2767, var1);
               }

               class3 var4 = (class3)client.field448.method3822((long)var3.field2869);
               if(null != var4) {
                  class34.method767(var4.field64, var1);
               }
            }

            class0 var5;
            if(var1 == 0 && null != var3.field2828) {
               var5 = new class0();
               var5.field1 = var3;
               var5.field0 = var3.field2828;
               class31.method737(var5, 200000);
            }

            if(var1 == 1 && var3.field2862 != null) {
               if(var3.field2755 >= 0) {
                  class173 var6 = class153.method3177(var3.field2869);
                  if(null == var6 || var6.field2767 == null || var3.field2755 >= var6.field2767.length || var3 != var6.field2767[var3.field2755]) {
                     continue;
                  }
               }

               var5 = new class0();
               var5.field1 = var3;
               var5.field0 = var3.field2862;
               class31.method737(var5, 200000);
            }
         }
      }

   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "707629694"
   )
   @Export("xteaChanged")
   static final void method745(boolean var0) {
      client.field351 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!client.field351) {
         var1 = client.field335.method2695();
         var2 = client.field335.method2588();
         var3 = client.field335.method2556();
         class37.field863 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class37.field863[var4][var5] = client.field335.method2696();
            }
         }

         class16.field243 = new int[var3];
         class164.field2652 = new int[var3];
         class175.field2897 = new int[var3];
         class135.field2087 = new byte[var3][];
         class8.field150 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (6 + var2) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class16.field243[var3] = var7;
                  class164.field2652[var3] = class89.field1563.method3300("m" + var5 + "_" + var6);
                  class175.field2897[var3] = class89.field1563.method3300("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class11.method158(var1, var2);
      } else {
         var1 = client.field335.method2556();
         var2 = client.field335.method2556();
         var3 = client.field335.method2556();
         client.field335.method2775();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field335.method2776(1);
                  if(var7 == 1) {
                     client.field352[var4][var5][var6] = client.field335.method2776(26);
                  } else {
                     client.field352[var4][var5][var6] = -1;
                  }
               }
            }
         }

         client.field335.method2791();
         class37.field863 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class37.field863[var4][var5] = client.field335.method2696();
            }
         }

         class16.field243 = new int[var3];
         class164.field2652 = new int[var3];
         class175.field2897 = new int[var3];
         class135.field2087 = new byte[var3][];
         class8.field150 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field352[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == class16.field243[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class16.field243[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class164.field2652[var3] = class89.field1563.method3300("m" + var11 + "_" + var12);
                        class175.field2897[var3] = class89.field1563.method3300("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class11.method158(var1, var2);
      }

   }
}
