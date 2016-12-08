import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1163943835
   )
   int field1323;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -228962579
   )
   @Export("x")
   int x;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1938032191
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1498545929
   )
   int field1326;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 180207807
   )
   int field1327;
   @ObfuscatedName("c")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("h")
   class85 field1329;
   @ObfuscatedName("u")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("k")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 390602959
   )
   int field1333;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -684387653
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("j")
   int[] field1335 = new int[5];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1611939547
   )
   int field1336 = 0;
   @ObfuscatedName("x")
   boolean field1337;
   @ObfuscatedName("i")
   boolean field1338;
   @ObfuscatedName("s")
   boolean field1339;
   @ObfuscatedName("y")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -790311829
   )
   int field1341;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1563561193
   )
   int field1342;
   @ObfuscatedName("v")
   class77 field1343;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1960288851
   )
   int field1344;
   @ObfuscatedName("t")
   Tile field1345;
   @ObfuscatedName("pc")
   public static class103 field1346;
   @ObfuscatedName("l")
   @Export("wallObject")
   WallObject wallObject;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "-1490099028"
   )
   public static void method1518(String var0, boolean var1, boolean var2) {
      Frames.method1849(var0, var1, "openjs", var2);
   }

   Tile(int var1, int var2, int var3) {
      this.plane = var1 * -684387653;
      this.field1326 = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2099923221"
   )
   static final void method1519() {
      int var0 = Client.field505 + class5.localPlayer.x;
      int var1 = class5.localPlayer.y + Client.field515;
      if(PlayerComposition.field2190 - var0 < -500 || PlayerComposition.field2190 - var0 > 500 || class114.field1803 - var1 < -500 || class114.field1803 - var1 > 500) {
         PlayerComposition.field2190 = var0;
         class114.field1803 = var1;
      }

      if(PlayerComposition.field2190 != var0) {
         PlayerComposition.field2190 += (var0 - PlayerComposition.field2190) / 16;
      }

      if(var1 != class114.field1803) {
         class114.field1803 += (var1 - class114.field1803) / 16;
      }

      int var2;
      int var3;
      if(class115.field1822 == 4 && class148.field2047) {
         var2 = class115.field1821 - Client.field519;
         Client.field552 = var2 * 2;
         Client.field519 = var2 != -1 && var2 != 1?(class115.field1821 + Client.field519) / 2:class115.field1821;
         var3 = Client.field374 - class115.field1814;
         Client.field502 = var3 * 2;
         Client.field374 = var3 != -1 && var3 != 1?(class115.field1814 + Client.field374) / 2:class115.field1814;
      } else {
         if(class105.field1728[96]) {
            Client.field502 += (-24 - Client.field502) / 2;
         } else if(class105.field1728[97]) {
            Client.field502 += (24 - Client.field502) / 2;
         } else {
            Client.field502 /= 2;
         }

         if(class105.field1728[98]) {
            Client.field552 += (12 - Client.field552) / 2;
         } else if(class105.field1728[99]) {
            Client.field552 += (-12 - Client.field552) / 2;
         } else {
            Client.field552 /= 2;
         }

         Client.field519 = class115.field1821;
         Client.field374 = class115.field1814;
      }

      Client.mapAngle = Client.field502 / 2 + Client.mapAngle & 2047;
      Client.field370 += Client.field552 / 2;
      if(Client.field370 < 128) {
         Client.field370 = 128;
      }

      if(Client.field370 > 383) {
         Client.field370 = 383;
      }

      var2 = PlayerComposition.field2190 >> 7;
      var3 = class114.field1803 >> 7;
      int var4 = ChatLineBuffer.method896(PlayerComposition.field2190, class114.field1803, class63.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
            for(int var7 = var3 - 4; var7 <= 4 + var3; ++var7) {
               int var8 = class63.plane;
               if(var8 < 3 && (class10.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class10.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = 192 * var5;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < '耀') {
         var6 = '耀';
      }

      if(var6 > Client.field379) {
         Client.field379 += (var6 - Client.field379) / 24;
      } else if(var6 < Client.field379) {
         Client.field379 += (var6 - Client.field379) / 80;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "406339351"
   )
   public static boolean method1520(CharSequence var0) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();
      int var6 = 0;

      boolean var1;
      while(true) {
         if(var6 >= var5) {
            var1 = var3;
            break;
         }

         label87: {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(var7 == 45) {
                  var2 = true;
                  break label87;
               }

               if(var7 == 43) {
                  break label87;
               }
            }

            int var9;
            if(var7 >= 48 && var7 <= 57) {
               var9 = var7 - 48;
            } else if(var7 >= 65 && var7 <= 90) {
               var9 = var7 - 55;
            } else {
               if(var7 < 97 || var7 > 122) {
                  var1 = false;
                  break;
               }

               var9 = var7 - 87;
            }

            if(var9 >= 10) {
               var1 = false;
               break;
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var4 * 10 + var9;
            if(var4 != var8 / 10) {
               var1 = false;
               break;
            }

            var4 = var8;
            var3 = true;
         }

         ++var6;
      }

      return var1;
   }
}
