import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("NPC")
public final class class36 extends class39 {
   @ObfuscatedName("l")
   @Export("composition")
   class41 field803;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "76"
   )
   final boolean vmethod794() {
      return null != this.field803;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-673381210"
   )
   final void method760(int var1, byte var2) {
      int var3 = super.field886[0];
      int var4 = super.field887[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.field863 != -1 && class22.method585(super.field863).field1028 == 1) {
         super.field863 = -1;
      }

      if(super.field849 < 9) {
         ++super.field849;
      }

      for(int var5 = super.field849; var5 > 0; --var5) {
         super.field886[var5] = super.field886[var5 - 1];
         super.field887[var5] = super.field887[var5 - 1];
         super.field888[var5] = super.field888[var5 - 1];
      }

      super.field886[0] = var3;
      super.field887[0] = var4;
      super.field888[0] = var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1036022233"
   )
   static void method762() {
      class5.field81 = 99;
      class5.field82 = new byte[4][104][104];
      class75.field1422 = new byte[4][104][104];
      class5.field88 = new byte[4][104][104];
      class5.field86 = new byte[4][104][104];
      class99.field1704 = new int[4][105][105];
      class232.field3275 = new byte[4][105][105];
      class13.field207 = new int[105][105];
      class5.field83 = new int[104];
      class5.field87 = new int[104];
      class5.field96 = new int[104];
      class37.field809 = new int[104];
      class224.field3225 = new int[104];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-818408846"
   )
   public static String method763(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class168.field2718[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "503322838"
   )
   protected final class108 vmethod1990() {
      if(null == this.field803) {
         return null;
      } else {
         class44 var1 = super.field863 != -1 && super.field864 == 0?class22.method585(super.field863):null;
         class44 var2 = super.field860 != -1 && (super.field860 != super.field838 || var1 == null)?class22.method585(super.field860):null;
         class108 var3 = this.field803.method818(var1, super.field836, var2, super.field861);
         if(null == var3) {
            return null;
         } else {
            var3.method2402();
            super.field837 = var3.field1538;
            if(super.field868 != -1 && super.field890 != -1) {
               class108 var4 = class110.method2488(super.field868).method952(super.field890);
               if(null != var4) {
                  var4.method2412(0, -super.field872, 0);
                  class108[] var5 = new class108[]{var3, var4};
                  var3 = new class108(var5, 2);
               }
            }

            if(this.field803.field913 == 1) {
               var3.field1892 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "0"
   )
   final void method770(int var1, int var2, boolean var3) {
      if(super.field863 != -1 && class22.method585(super.field863).field1028 == 1) {
         super.field863 = -1;
      }

      if(!var3) {
         int var4 = var1 - super.field886[0];
         int var5 = var2 - super.field887[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field849 < 9) {
               ++super.field849;
            }

            for(int var6 = super.field849; var6 > 0; --var6) {
               super.field886[var6] = super.field886[var6 - 1];
               super.field887[var6] = super.field887[var6 - 1];
               super.field888[var6] = super.field888[var6 - 1];
            }

            super.field886[0] = var1;
            super.field887[0] = var2;
            super.field888[0] = 1;
            return;
         }
      }

      super.field849 = 0;
      super.field839 = 0;
      super.field889 = 0;
      super.field886[0] = var1;
      super.field887[0] = var2;
      super.field875 = 128 * super.field886[0] + super.field877 * 64;
      super.field832 = super.field887[0] * 128 + super.field877 * 64;
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(Lclass176;III)V",
      garbageValue = "-1993559914"
   )
   static void method772(class176 var0, int var1, int var2) {
      if(var0.field2812 == 0) {
         var0.field2820 = var0.field2816;
      } else if(var0.field2812 == 1) {
         var0.field2820 = (var1 - var0.field2822) / 2 + var0.field2816;
      } else if(var0.field2812 == 2) {
         var0.field2820 = var1 - var0.field2822 - var0.field2816;
      } else if(var0.field2812 == 3) {
         var0.field2820 = var1 * var0.field2816 >> 14;
      } else if(var0.field2812 == 4) {
         var0.field2820 = (var1 - var0.field2822) / 2 + (var1 * var0.field2816 >> 14);
      } else {
         var0.field2820 = var1 - var0.field2822 - (var0.field2816 * var1 >> 14);
      }

      if(var0.field2925 == 0) {
         var0.field2821 = var0.field2941;
      } else if(var0.field2925 == 1) {
         var0.field2821 = var0.field2941 + (var2 - var0.field2823) / 2;
      } else if(var0.field2925 == 2) {
         var0.field2821 = var2 - var0.field2823 - var0.field2941;
      } else if(var0.field2925 == 3) {
         var0.field2821 = var0.field2941 * var2 >> 14;
      } else if(var0.field2925 == 4) {
         var0.field2821 = (var0.field2941 * var2 >> 14) + (var2 - var0.field2823) / 2;
      } else {
         var0.field2821 = var2 - var0.field2823 - (var0.field2941 * var2 >> 14);
      }

      if(client.field471 && var0.field2910 == 0) {
         if(var0.field2820 < 0) {
            var0.field2820 = 0;
         } else if(var0.field2822 + var0.field2820 > var1) {
            var0.field2820 = var1 - var0.field2822;
         }

         if(var0.field2821 < 0) {
            var0.field2821 = 0;
         } else if(var0.field2823 + var0.field2821 > var2) {
            var0.field2821 = var2 - var0.field2823;
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)[Lclass83;",
      garbageValue = "520571157"
   )
   public static class83[] method773(class170 var0, String var1, String var2) {
      int var3 = var0.method3410(var1);
      int var4 = var0.method3459(var3, var2);
      class83[] var5;
      if(!class4.method49(var0, var3, var4)) {
         var5 = null;
      } else {
         class83[] var7 = new class83[class79.field1466];

         for(int var8 = 0; var8 < class79.field1466; ++var8) {
            class83 var9 = var7[var8] = new class83();
            var9.field1496 = class79.field1454;
            var9.field1502 = class79.field1456;
            var9.field1500 = class79.field1457[var8];
            var9.field1501 = class180.field2962[var8];
            var9.field1498 = class192.field3106[var8];
            var9.field1503 = class79.field1458[var8];
            var9.field1497 = class79.field1459;
            var9.field1499 = class145.field2236[var8];
         }

         class55.method1182();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-265596313"
   )
   static int method774(int var0) {
      class37 var1 = (class37)class11.field174.method3950((long)var0);
      return var1 == null?-1:(var1.field3163 == class11.field173.field3158?-1:((class37)var1.field3163).field808);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "459242043"
   )
   static final void method776() {
      class89.field1545 = false;
      client.field301 = false;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lclass39;B)V",
      garbageValue = "14"
   )
   static final void method777(class39 var0) {
      if(var0.field878 == client.field305 || var0.field863 == -1 || var0.field864 != 0 || var0.field848 + 1 > class22.method585(var0.field863).field1018[var0.field836]) {
         int var1 = var0.field878 - var0.field891;
         int var2 = client.field305 - var0.field891;
         int var3 = var0.field873 * 128 + var0.field877 * 64;
         int var4 = var0.field877 * 64 + var0.field856 * 128;
         int var5 = var0.field877 * 64 + var0.field874 * 128;
         int var6 = var0.field876 * 128 + var0.field877 * 64;
         var0.field875 = (var5 * var2 + var3 * (var1 - var2)) / var1;
         var0.field832 = (var6 * var2 + var4 * (var1 - var2)) / var1;
      }

      var0.field889 = 0;
      var0.field882 = var0.field884;
      var0.field857 = var0.field882;
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(Lclass176;IIIIIIB)V",
      garbageValue = "59"
   )
   static final void method778(class176 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(client.field377) {
         client.field513 = 32;
      } else {
         client.field513 = 0;
      }

      client.field377 = false;
      int var7;
      if(class143.field2207 == 1 || !class214.field3188 && class143.field2207 == 4) {
         if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 && var6 < var2 + 16) {
            var0.field2850 -= 4;
            class79.method1777(var0);
         } else if(var5 >= var1 && var5 < 16 + var1 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.field2850 += 4;
            class79.method1777(var0);
         } else if(var5 >= var1 - client.field513 && var5 < client.field513 + var1 + 16 && var6 >= 16 + var2 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.field2850 = (var4 - var3) * var8 / var9;
            class79.method1777(var0);
            client.field377 = true;
         }
      }

      if(client.field491 != 0) {
         var7 = var0.field2822;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var2 + var3) {
            var0.field2850 += client.field491 * 45;
            class79.method1777(var0);
         }
      }

   }
}
