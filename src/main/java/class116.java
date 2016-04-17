import java.util.Date;
import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
public class class116 {
   @ObfuscatedName("a")
   Inflater field1975;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1325664391
   )
   static int field1981;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1"
   )
   class116(int var1, int var2, int var3) {
   }

   public class116() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass119;[BI)V",
      garbageValue = "-2133221424"
   )
   public void method2552(class119 var1, byte[] var2) {
      if(var1.field1993[var1.field1992] == 31 && var1.field1993[var1.field1992 + 1] == -117) {
         if(null == this.field1975) {
            this.field1975 = new Inflater(true);
         }

         try {
            this.field1975.setInput(var1.field1993, 10 + var1.field1992, var1.field1993.length - (8 + var1.field1992 + 10));
            this.field1975.inflate(var2);
         } catch (Exception var4) {
            this.field1975.reset();
            throw new RuntimeException("");
         }

         this.field1975.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;B)V",
      garbageValue = "35"
   )
   static void method2555(int var0, int var1, int var2, int var3, String var4) {
      class173 var5 = class210.method4010(var1, var2);
      if(var5 != null) {
         if(null != var5.field2806) {
            class0 var6 = new class0();
            var6.field2 = var5;
            var6.field5 = var0;
            var6.field9 = var4;
            var6.field4 = var5.field2806;
            class168.method3449(var6, 200000);
         }

         boolean var10 = true;
         if(var5.field2762 > 0) {
            var10 = class155.method3261(var5);
         }

         if(var10) {
            int var8 = class31.method776(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> var9 + 1 & 1) != 0;
            if(var7) {
               if(1 == var0) {
                  client.field338.method2873(194);
                  client.field338.method2786(var1);
                  client.field338.method2599(var2);
                  client.field338.method2599(var3);
               }

               if(2 == var0) {
                  client.field338.method2873(42);
                  client.field338.method2786(var1);
                  client.field338.method2599(var2);
                  client.field338.method2599(var3);
               }

               if(var0 == 3) {
                  client.field338.method2873(181);
                  client.field338.method2786(var1);
                  client.field338.method2599(var2);
                  client.field338.method2599(var3);
               }

               if(4 == var0) {
                  client.field338.method2873(129);
                  client.field338.method2786(var1);
                  client.field338.method2599(var2);
                  client.field338.method2599(var3);
               }

               if(5 == var0) {
                  client.field338.method2873(22);
                  client.field338.method2786(var1);
                  client.field338.method2599(var2);
                  client.field338.method2599(var3);
               }

               if(var0 == 6) {
                  client.field338.method2873(49);
                  client.field338.method2786(var1);
                  client.field338.method2599(var2);
                  client.field338.method2599(var3);
               }

               if(var0 == 7) {
                  client.field338.method2873(207);
                  client.field338.method2786(var1);
                  client.field338.method2599(var2);
                  client.field338.method2599(var3);
               }

               if(var0 == 8) {
                  client.field338.method2873(73);
                  client.field338.method2786(var1);
                  client.field338.method2599(var2);
                  client.field338.method2599(var3);
               }

               if(var0 == 9) {
                  client.field338.method2873(99);
                  client.field338.method2786(var1);
                  client.field338.method2599(var2);
                  client.field338.method2599(var3);
               }

               if(var0 == 10) {
                  client.field338.method2873(128);
                  client.field338.method2786(var1);
                  client.field338.method2599(var2);
                  client.field338.method2599(var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(Lclass173;II)I",
      garbageValue = "1963939555"
   )
   static final int method2556(class173 var0, int var1) {
      if(null != var0.field2870 && var1 < var0.field2870.length) {
         try {
            int[] var2 = var0.field2870[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(0 == var6) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = client.field429[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = client.field430[var2[var4++]];
               }

               if(3 == var6) {
                  var7 = client.field479[var2[var4++]];
               }

               int var9;
               class173 var10;
               int var11;
               int var12;
               if(4 == var6) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class20.method641(var9);
                  var11 = var2[var4++];
                  if(-1 != var11 && (!class11.method178(var11).field1138 || client.field301)) {
                     for(var12 = 0; var12 < var10.field2876.length; ++var12) {
                        if(var10.field2876[var12] == var11 + 1) {
                           var7 += var10.field2877[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class176.field2905[var2[var4++]];
               }

               if(6 == var6) {
                  var7 = class155.field2290[client.field430[var2[var4++]] - 1];
               }

               if(7 == var6) {
                  var7 = class176.field2905[var2[var4++]] * 100 / '뜛';
               }

               if(8 == var6) {
                  var7 = class5.field93.field38;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class155.field2291[var9]) {
                        var7 += client.field430[var9];
                     }
                  }
               }

               if(10 == var6) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class20.method641(var9);
                  var11 = var2[var4++];
                  if(-1 != var11 && (!class11.method178(var11).field1138 || client.field301)) {
                     for(var12 = 0; var12 < var10.field2876.length; ++var12) {
                        if(var10.field2876[var12] == 1 + var11) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(11 == var6) {
                  var7 = client.field491;
               }

               if(12 == var6) {
                  var7 = client.field458;
               }

               if(var6 == 13) {
                  var9 = class176.field2905[var2[var4++]];
                  int var14 = var2[var4++];
                  var7 = (var9 & 1 << var14) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class93.method2248(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(16 == var6) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class5.field93.field844 >> 7) + class144.field2204;
               }

               if(19 == var6) {
                  var7 = class3.field67 + (class5.field93.field819 >> 7);
               }

               if(20 == var6) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(0 == var5) {
                     var3 += var7;
                  }

                  if(1 == var5) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && 0 != var7) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var13) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("a")
   public static String method2557(long var0) {
      class111.field1953.setTime(new Date(var0));
      int var2 = class111.field1953.get(7);
      int var3 = class111.field1953.get(5);
      int var4 = class111.field1953.get(2);
      int var5 = class111.field1953.get(1);
      int var6 = class111.field1953.get(11);
      int var7 = class111.field1953.get(12);
      int var8 = class111.field1953.get(13);
      return class111.field1950[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class111.field1952[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }
}
