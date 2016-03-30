import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public final class class5 {
   @ObfuscatedName("e")
   static byte[][][] field93;
   @ObfuscatedName("l")
   static int[] field94;
   @ObfuscatedName("j")
   public static class59 field95;
   @ObfuscatedName("w")
   @Export("tileHeights")
   static int[][][] field96 = new int[4][105][105];
   @ObfuscatedName("v")
   static int[][] field97;
   @ObfuscatedName("r")
   static final int[] field98 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("o")
   static final int[] field100 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("h")
   static final int[] field101 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("k")
   static final int[] field102 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("f")
   static final int[] field103 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("cc")
   static class146 field104;
   @ObfuscatedName("n")
   static final int[] field105 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 528350797
   )
   static int field106 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1544222357
   )
   static int field107 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1942512641
   )
   static int field108 = 99;
   @ObfuscatedName("x")
   @Export("tileSettings")
   static byte[][][] field109 = new byte[4][104][104];

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1308978484"
   )
   static final void method62(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)client.field482.method3836(); var10 != null; var10 = (class16)client.field482.method3841()) {
         if(var10.field243 == var0 && var10.field238 == var1 && var10.field239 == var2 && var10.field249 == var3) {
            var9 = var10;
            break;
         }
      }

      if(null == var9) {
         var9 = new class16();
         var9.field243 = var0;
         var9.field249 = var3;
         var9.field238 = var1;
         var9.field239 = var2;
         class20.method580(var9);
         client.field482.method3834(var9);
      }

      var9.field250 = var4;
      var9.field245 = var5;
      var9.field251 = var6;
      var9.field246 = var7;
      var9.field247 = var8;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-466596852"
   )
   static final void method91() {
      for(class6 var0 = (class6)client.field427.method3836(); null != var0; var0 = (class6)client.field427.method3841()) {
         if(var0.field113 == class82.field1437 && client.field305 <= var0.field119) {
            if(client.field305 >= var0.field118) {
               if(var0.field128 > 0) {
                  class34 var1 = client.field331[var0.field128 - 1];
                  if(var1 != null && var1.field849 >= 0 && var1.field849 < 13312 && var1.field819 >= 0 && var1.field819 < 13312) {
                     var0.method95(var1.field849, var1.field819, class43.method938(var1.field849, var1.field819, var0.field113) - var0.field117, client.field305);
                  }
               }

               if(var0.field128 < 0) {
                  int var2 = -var0.field128 - 1;
                  class2 var3;
                  if(client.field416 == var2) {
                     var3 = class167.field2692;
                  } else {
                     var3 = client.field415[var2];
                  }

                  if(null != var3 && var3.field849 >= 0 && var3.field849 < 13312 && var3.field819 >= 0 && var3.field819 < 13312) {
                     var0.method95(var3.field849, var3.field819, class43.method938(var3.field849, var3.field819, var0.field113) - var0.field117, client.field305);
                  }
               }

               var0.method99(client.field370);
               class3.field75.method1919(class82.field1437, (int)var0.field124, (int)var0.field125, (int)var0.field126, 60, var0, var0.field132, -1, false);
            }
         } else {
            var0.method3935();
         }
      }

   }

   @ObfuscatedName("w")
   static class80[] method92(class167 var0, int var1, int var2) {
      if(!class121.method2747(var0, var1, var2)) {
         return null;
      } else {
         class80[] var4 = new class80[class178.field2922];

         for(int var5 = 0; var5 < class178.field2922; ++var5) {
            class80 var6 = var4[var5] = new class80();
            var6.field1426 = class76.field1387;
            var6.field1422 = class76.field1385;
            var6.field1424 = class76.field1392[var5];
            var6.field1420 = class76.field1388[var5];
            var6.field1425 = class76.field1389[var5];
            var6.field1423 = class76.field1390[var5];
            var6.field1421 = class76.field1391;
            var6.field1427 = class10.field180[var5];
         }

         class21.method582();
         return var4;
      }
   }

   @ObfuscatedName("df")
   static final void method93(class3 var0, boolean var1) {
      int var2 = var0.field74;
      int var3 = (int)var0.field3123;
      var0.method3935();
      if(var1) {
         class48.method1033(var2);
      }

      class104.method2297(var2);
      class173 var4 = class52.method1115(var3);
      if(null != var4) {
         class134.method2877(var4);
      }

      class32.method727();
      if(-1 != client.field454) {
         class39.method797(client.field454, 1);
      }

   }
}
