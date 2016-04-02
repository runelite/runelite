import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("Tile")
public final class class101 extends class208 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -790409051
   )
   int field1711;
   @ObfuscatedName("o")
   boolean field1712;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1830144775
   )
   @Export("plane")
   int field1713;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1219854323
   )
   int field1714 = 0;
   @ObfuscatedName("p")
   class89 field1715;
   @ObfuscatedName("h")
   class97 field1716;
   @ObfuscatedName("g")
   class87 field1717;
   @ObfuscatedName("a")
   class94 field1718;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 571104751
   )
   int field1719;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1099275311
   )
   int field1720;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 839081717
   )
   int field1721;
   @ObfuscatedName("n")
   @Export("objects")
   class98[] field1722 = new class98[5];
   @ObfuscatedName("y")
   int[] field1723 = new int[5];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2118768409
   )
   @Export("y")
   int field1724;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 466440139
   )
   int field1725;
   @ObfuscatedName("l")
   boolean field1726;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -180059923
   )
   @Export("x")
   int field1727;
   @ObfuscatedName("k")
   @Export("itemLayer")
   class99 field1728;
   @ObfuscatedName("r")
   class93 field1729;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1906879917
   )
   int field1730;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -337775779
   )
   int field1731;
   @ObfuscatedName("bc")
   static String field1732;
   @ObfuscatedName("t")
   class101 field1733;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = -1480473949
   )
   static int field1734;
   @ObfuscatedName("c")
   boolean field1736;

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1589757647"
   )
   static final void method2309(int var0, int var1, int var2, int var3) {
      client.field373 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class32.field731;
      int[] var7 = class32.field732;

      int var8;
      for(var8 = 0; var8 < var6 + client.field317; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = client.field387[var7[var8]];
            if(var7[var8] == client.field409) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = client.field316[client.field318[var8 - var6]];
         }

         class9.method125((class37)var9, var8, var0, var1);
      }

      if(var4) {
         class9.method125(client.field387[client.field409], var5, var0, var1);
      }

      for(var8 = 0; var8 < client.field373; ++var8) {
         int var18 = client.field356[var8];
         int var10 = client.field376[var8];
         int var11 = client.field378[var8];
         int var12 = client.field405[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(var10 + 2 > client.field376[var14] - client.field405[var14] && var10 - var12 < client.field376[var14] + 2 && var18 - var11 < client.field378[var14] + client.field356[var14] && var18 + var11 > client.field356[var14] - client.field378[var14] && client.field376[var14] - client.field405[var14] < var10) {
                  var10 = client.field376[var14] - client.field405[var14];
                  var13 = true;
               }
            }
         }

         client.field300 = client.field356[var8];
         client.field386 = client.field376[var8] = var10;
         String var19 = client.field344[var8];
         if(client.field440 == 0) {
            int var15 = 16776960;
            if(client.field395[var8] < 6) {
               var15 = client.field278[client.field395[var8]];
            }

            if(6 == client.field395[var8]) {
               var15 = client.field384 % 20 < 10?16711680:16776960;
            }

            if(client.field395[var8] == 7) {
               var15 = client.field384 % 20 < 10?255:'\uffff';
            }

            if(8 == client.field395[var8]) {
               var15 = client.field384 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(client.field395[var8] == 9) {
               var16 = 150 - client.field381[var8];
               if(var16 < 50) {
                  var15 = var16 * 1280 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16776960 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = 5 * (var16 - 100) + '\uff00';
               }
            }

            if(10 == client.field395[var8]) {
               var16 = 150 - client.field381[var8];
               if(var16 < 50) {
                  var15 = 5 * var16 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = 327680 * (var16 - 100) + 255 - (var16 - 100) * 5;
               }
            }

            if(11 == client.field395[var8]) {
               var16 = 150 - client.field381[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = (var16 - 50) * 327685 + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - (var16 - 100) * 327680;
               }
            }

            if(0 == client.field380[var8]) {
               class124.field2022.method4010(var19, var0 + client.field300, client.field386 + var1, var15, 0);
            }

            if(client.field380[var8] == 1) {
               class124.field2022.method4023(var19, client.field300 + var0, client.field386 + var1, var15, 0, client.field384);
            }

            if(client.field380[var8] == 2) {
               class124.field2022.method4041(var19, var0 + client.field300, var1 + client.field386, var15, 0, client.field384);
            }

            if(client.field380[var8] == 3) {
               class124.field2022.method4024(var19, client.field300 + var0, var1 + client.field386, var15, 0, client.field384, 150 - client.field381[var8]);
            }

            if(client.field380[var8] == 4) {
               var16 = (150 - client.field381[var8]) * (class124.field2022.method4074(var19) + 100) / 150;
               class79.method1804(var0 + client.field300 - 50, var1, var0 + client.field300 + 50, var1 + var3);
               class124.field2022.method4019(var19, 50 + var0 + client.field300 - var16, var1 + client.field386, var15, 0);
               class79.method1803(var0, var1, var0 + var2, var3 + var1);
            }

            if(5 == client.field380[var8]) {
               var16 = 150 - client.field381[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class79.method1804(var0, client.field386 + var1 - class124.field2022.field3188 - 1, var2 + var0, 5 + var1 + client.field386);
               class124.field2022.method4010(var19, client.field300 + var0, var1 + client.field386 + var17, var15, 0);
               class79.method1803(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class124.field2022.method4010(var19, var0 + client.field300, var1 + client.field386, 16776960, 0);
         }
      }

   }

   class101(int var1, int var2, int var3) {
      this.field1711 = this.field1713 = var1;
      this.field1727 = var2;
      this.field1724 = var3;
   }
}
