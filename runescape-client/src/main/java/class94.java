import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public final class class94 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 176488151
   )
   int field1572;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -179334715
   )
   int field1573;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1577406263
   )
   int field1574;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 252922249
   )
   int field1575;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1738974145
   )
   int field1576;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2143357337
   )
   int field1577;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1994313113
   )
   int field1578;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1057948097
   )
   int field1579;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -50958363
   )
   int field1580;
   @ObfuscatedName("jo")
   static Widget[] field1581;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 676784927
   )
   int field1583;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1963016561
   )
   int field1584;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1344723171
   )
   int field1585;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1262914719
   )
   int field1586;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 773180131
   )
   int field1587;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1203662411
   )
   int field1588;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1493342403
   )
   int field1589;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1018363969
   )
   int field1590;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 443799521
   )
   int field1592;
   @ObfuscatedName("bj")
   static class184 field1593;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass159;IB)Z",
      garbageValue = "1"
   )
   static boolean method1855(class159 var0, int var1) {
      int var2 = var0.method2973(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2973(1) != 0) {
            method1855(var0, var1);
         }

         var3 = var0.method2973(6);
         var4 = var0.method2973(6);
         boolean var12 = var0.method2973(1) == 1;
         if(var12) {
            class45.field904[++class45.field901 - 1] = var1;
         }

         if(null != Client.cachedPlayers[var1]) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field278 = var1;
            if(null != class45.field893[var1]) {
               var6.method212(class45.field893[var1]);
            }

            var6.field655 = class45.field899[var1];
            var6.interacting = class45.field900[var1];
            var7 = class45.field898[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field624[0] = class45.field892[var1];
            var6.field277 = (byte)var8;
            var6.method198((var9 << 6) + var3 - class22.baseX, var4 + (var10 << 6) - class103.baseY);
            var6.field279 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2973(2);
         var4 = class45.field898[var1];
         class45.field898[var1] = (var4 & 268435455) + ((var3 + (var4 >> 28) & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method2973(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class45.field898[var1];
            var7 = var4 + (var11 >> 28) & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class45.field898[var1] = (var7 << 28) + (var8 << 14) + var9;
            return false;
         } else {
            var3 = var0.method2973(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class45.field898[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var11 + var7 & 255;
            class45.field898[var1] = var10 + (var9 << 14) + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-1"
   )
   static final void method1856(String var0) {
      if(null != class57.clanMembers) {
         Client.field336.method2963(223);
         class159 var1 = Client.field336;
         int var2 = var0.length() + 1;
         var1.method2708(var2);
         Client.field336.method2714(var0);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1208335362"
   )
   public static int method1857(int var0) {
      return var0 >> 11 & 63;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;Lclass182;I)V",
      garbageValue = "63439613"
   )
   public static void method1858(class182 var0, class182 var1, class182 var2, class182 var3) {
      Widget.field2240 = var0;
      Widget.field2202 = var1;
      class187.field2779 = var2;
      class60.field1086 = var3;
      Widget.widgets = new Widget[Widget.field2240.method3205()][];
      class157.validInterfaces = new boolean[Widget.field2240.method3205()];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;B)V",
      garbageValue = "105"
   )
   public static void method1859(File var0) {
      class107.field1729 = var0;
      if(!class107.field1729.exists()) {
         throw new RuntimeException("");
      } else {
         class107.field1731 = true;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)LOverlay;",
      garbageValue = "714020670"
   )
   public static Overlay method1860(int var0) {
      Overlay var1 = (Overlay)Overlay.field3046.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class32.field737.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.method3596(new Buffer(var2), var0);
         }

         var1.method3598();
         Overlay.field3046.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "2076861011"
   )
   static void method1861(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2216 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2216 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2216 == 2) {
         var0.width = var1 * var0.originalWidth >> 14;
      }

      if(var0.field2326 == 0) {
         var0.height = var0.field2221;
      } else if(var0.field2326 == 1) {
         var0.height = var2 - var0.field2221;
      } else if(var0.field2326 == 2) {
         var0.height = var2 * var0.field2221 >> 14;
      }

      if(var0.field2216 == 4) {
         var0.width = var0.height * var0.field2226 / var0.field2227;
      }

      if(var0.field2326 == 4) {
         var0.height = var0.field2227 * var0.width / var0.field2226;
      }

      if(Client.field461 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field463 = var0;
      }

      if(var3 && null != var0.field2318 && (var0.width != var4 || var5 != var0.height)) {
         class18 var6 = new class18();
         var6.field204 = var0;
         var6.field205 = var0.field2318;
         Client.field417.method2333(var6);
      }

   }
}
