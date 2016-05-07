import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class175 extends class204 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 855194843
   )
   public static int field2908;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 923633857
   )
   public final int field2909;
   @ObfuscatedName("p")
   public final int[] field2910;
   @ObfuscatedName("x")
   public final int[] field2911;
   @ObfuscatedName("u")
   static byte[][][] field2912;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1370285839
   )
   public final int field2914;

   class175(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2914 = var1;
      this.field2909 = var2;
      this.field2910 = var3;
      this.field2911 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "234861370"
   )
   public boolean method3427(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2911.length) {
         int var3 = this.field2911[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2910[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1572874944"
   )
   public static int method3430(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var1 + var0;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "0"
   )
   static final void method3431(boolean var0) {
      client.field471 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!client.field471) {
         var1 = client.field324.method2526();
         var2 = client.field324.method2526();
         var3 = client.field324.method2584();
         class183.field2970 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class183.field2970[var4][var5] = client.field324.method2497();
            }
         }

         class144.field2220 = new int[var3];
         class163.field2659 = new int[var3];
         class11.field172 = new int[var3];
         class20.field566 = new byte[var3][];
         class127.field2061 = new byte[var3][];
         boolean var13 = false;
         if((48 == var2 / 8 || 49 == var2 / 8) && 48 == var1 / 8) {
            var13 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (var2 + 6) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (var1 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || 49 != var6 && 149 != var6 && var6 != 147 && var5 != 50 && (var5 != 49 || 47 != var6)) {
                  class144.field2220[var3] = var7;
                  class163.field2659[var3] = class7.field132.method3253("m" + var5 + "_" + var6);
                  class11.field172[var3] = class7.field132.method3253("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class143.method2980(var2, var1);
      } else {
         var1 = client.field324.method2527();
         var2 = client.field324.method2526();
         var3 = client.field324.method2584();
         client.field324.method2739();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field324.method2750(1);
                  if(var7 == 1) {
                     client.field278[var4][var5][var6] = client.field324.method2750(26);
                  } else {
                     client.field278[var4][var5][var6] = -1;
                  }
               }
            }
         }

         client.field324.method2740();
         class183.field2970 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class183.field2970[var4][var5] = client.field324.method2497();
            }
         }

         class144.field2220 = new int[var3];
         class163.field2659 = new int[var3];
         class11.field172 = new int[var3];
         class20.field566 = new byte[var3][];
         class127.field2061 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field278[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(class144.field2220[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class144.field2220[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class163.field2659[var3] = class7.field132.method3253("m" + var11 + "_" + var12);
                        class11.field172[var3] = class7.field132.method3253("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class143.method2980(var2, var1);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)Ljava/lang/String;",
      garbageValue = "32767"
   )
   static String method3432(class119 var0, int var1) {
      try {
         int var2 = var0.method2505();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.field2005 += class222.field3187.method2429(var0.field2007, var0.field2005, var3, 0, var2);
         String var4 = class21.method567(var3, 0, var2);
         return var4;
      } catch (Exception var5) {
         return "Cabbage";
      }
   }
}
