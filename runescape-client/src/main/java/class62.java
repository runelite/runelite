import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class62 {
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1325111917
   )
   static int field1280;
   @ObfuscatedName("l")
   class170 field1281;
   @ObfuscatedName("c")
   class199 field1282 = new class199(256);
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -1468921329
   )
   static int field1286;
   @ObfuscatedName("b")
   public static short[] field1287;
   @ObfuscatedName("h")
   class199 field1289 = new class199(256);
   @ObfuscatedName("e")
   class170 field1291;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass65;",
      garbageValue = "-28"
   )
   class65 method1358(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class65 var7 = (class65)this.field1289.method3864(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class61 var8 = class61.method1356(this.field1291, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method1342();
            this.field1289.method3865(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1304.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass65;",
      garbageValue = "-90"
   )
   class65 method1359(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class65 var7 = (class65)this.field1289.method3864(var5);
      if(var7 != null) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class73 var8 = (class73)this.field1282.method3864(var5);
         if(null == var8) {
            var8 = class73.method1630(this.field1281, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1282.method3865(var8, var5);
         }

         var7 = var8.method1631(var3);
         if(null == var7) {
            return null;
         } else {
            var8.method4000();
            this.field1289.method3865(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass65;",
      garbageValue = "-1557160984"
   )
   public class65 method1360(int var1, int[] var2) {
      if(this.field1291.method3416() == 1) {
         return this.method1358(0, var1, var2);
      } else if(this.field1291.method3352(var1) == 1) {
         return this.method1358(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass65;",
      garbageValue = "-53"
   )
   public class65 method1361(int var1, int[] var2) {
      if(this.field1281.method3416() == 1) {
         return this.method1359(0, var1, var2);
      } else if(this.field1281.method3352(var1) == 1) {
         return this.method1359(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(Lclass176;II)I",
      garbageValue = "-1610590669"
   )
   static final int method1364(class176 var0, int var1) {
      if(var0.field2906 != null && var1 < var0.field2906.length) {
         try {
            int[] var2 = var0.field2906[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = client.field337[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = client.field431[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = client.field432[var2[var4++]];
               }

               int var9;
               class176 var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class19.method212(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class9.method108(var11).field1196 || client.field388)) {
                     for(var12 = 0; var12 < var10.field2912.length; ++var12) {
                        if(1 + var11 == var10.field2912[var12]) {
                           var7 += var10.field2809[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class179.field2944[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class158.field2343[client.field431[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class179.field2944[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class118.field2035.field35;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class158.field2344[var9]) {
                        var7 += client.field431[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class19.method212(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class9.method108(var11).field1196 || client.field388)) {
                     for(var12 = 0; var12 < var10.field2912.length; ++var12) {
                        if(var11 + 1 == var10.field2912[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = client.field489;
               }

               if(var6 == 12) {
                  var7 = client.field460;
               }

               if(var6 == 13) {
                  var9 = class179.field2944[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class174.method3475(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class118.field2035.field896 >> 7) + class19.field286;
               }

               if(var6 == 19) {
                  var7 = (class118.field2035.field879 >> 7) + class6.field128;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
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
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Lclass106;",
      garbageValue = "-123"
   )
   @Export("getFrames")
   static class106 method1367(int var0) {
      class106 var1 = (class106)class44.field1022.method3834((long)var0);
      if(null != var1) {
         return var1;
      } else {
         class170 var3 = class44.field1020;
         class170 var4 = class44.field1026;
         boolean var5 = true;
         int[] var6 = var3.method3346(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3398(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3398(var9, 0);
               if(null == var10) {
                  var5 = false;
               }
            }
         }

         class106 var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new class106(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-11"
   )
   public static void method1369(boolean var0) {
      if(null != class174.field2760) {
         try {
            class122 var1 = new class122(4);
            var1.method2795(var0?2:3);
            var1.method2675(0);
            class174.field2760.method3083(var1.field2054, 0, 4);
         } catch (IOException var4) {
            try {
               class174.field2760.method3088();
            } catch (Exception var3) {
               ;
            }

            ++class174.field2775;
            class174.field2760 = null;
         }

      }
   }

   public class62(class170 var1, class170 var2) {
      this.field1291 = var1;
      this.field1281 = var2;
   }
}
