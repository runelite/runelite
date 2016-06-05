import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("FrameMap")
public class class102 extends class208 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 236003305
   )
   int field1769;
   @ObfuscatedName("g")
   int[] field1771;
   @ObfuscatedName("h")
   int[][] field1772;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1401897363
   )
   int field1773;
   @ObfuscatedName("b")
   static int[][][] field1774;
   @ObfuscatedName("n")
   public static String field1776;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)Lclass44;",
      garbageValue = "1"
   )
   @Export("getKitDefinition")
   public static class44 method2236(int var0) {
      class44 var1 = (class44)class44.field1026.method3716((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class178.field2936.method3221(3, var0);
         var1 = new class44();
         if(null != var2) {
            var1.method896(new class119(var2));
         }

         class44.field1026.method3724(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1130067814"
   )
   public static int method2237(String var0) {
      return var0.length() + 1;
   }

   class102(int var1, byte[] var2) {
      this.field1773 = var1;
      class119 var3 = new class119(var2);
      this.field1769 = var3.method2494();
      this.field1771 = new int[this.field1769];
      this.field1772 = new int[this.field1769][];

      int var4;
      for(var4 = 0; var4 < this.field1769; ++var4) {
         this.field1771[var4] = var3.method2494();
      }

      for(var4 = 0; var4 < this.field1769; ++var4) {
         this.field1772[var4] = new int[var3.method2494()];
      }

      for(var4 = 0; var4 < this.field1769; ++var4) {
         for(int var5 = 0; var5 < this.field1772[var4].length; ++var5) {
            this.field1772[var4][var5] = var3.method2494();
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;IIIIIIB)V",
      garbageValue = "-39"
   )
   static final void method2238(class119 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.field83[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2494();
            if(var7 == 0) {
               if(var1 == 0) {
                  class5.field100[0][var2][var3] = -class111.method2390(932731 + var2 + var4, 556238 + var3 + var5) * 8;
               } else {
                  class5.field100[var1][var2][var3] = class5.field100[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.method2494();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class5.field100[0][var2][var3] = -var8 * 8;
               } else {
                  class5.field100[var1][var2][var3] = class5.field100[var1 - 1][var2][var3] - 8 * var8;
               }
               break;
            }

            if(var7 <= 49) {
               class5.field87[var1][var2][var3] = var0.method2469();
               class5.field86[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class47.field1081[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class5.field83[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class161.field2672[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2494();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.method2494();
               break;
            }

            if(var7 <= 49) {
               var0.method2494();
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "728854068"
   )
   public static String method2239(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = '�';
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = '�';
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 240) {
            if(1 + var5 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 248) {
            if(2 + var5 < var6 && (var0[var5] & 192) == 128 && (var0[1 + var5] & 192) == 128 && (var0[2 + var5] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = '�';
               } else {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else {
            var8 = '�';
         }
      }

      return new String(var3, 0, var4);
   }
}
