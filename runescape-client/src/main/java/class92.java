import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class92 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1506951759
   )
   static int field1417;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -457182655
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("y")
   static int[] field1423;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 161866225
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -175789169
   )
   static int field1395;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1981141253
   )
   static int field1407;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1444718875
   )
   static int field1410;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1638657825
   )
   static int field1411;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -192273371
   )
   static int field1412;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -283707853
   )
   static int field1413;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1278101167
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("af")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("ar")
   static String field1419;
   @ObfuscatedName("an")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("at")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("aw")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ad")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("az")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("ac")
   @Export("password")
   static String password;
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   static class149 field1422;
   @ObfuscatedName("ai")
   static boolean field1424;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -2057114451
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1714294669
   )
   static int field1426;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static SpritePixels field1394;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   static SpritePixels field1399;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   static IndexedSprite field1396;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   static IndexedSprite field1397;
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   static IndexData field1431;
   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "[Ljj;"
   )
   @Export("pkIcons")
   static SpritePixels[] pkIcons;
   @ObfuscatedName("b")
   static int[] field1406;
   @ObfuscatedName("f")
   static int[] field1405;
   @ObfuscatedName("d")
   static int[] field1409;
   @ObfuscatedName("c")
   static boolean field1414;

   static {
      field1417 = 0;
      loginWindowX = field1417 + 202;
      field1423 = new int[256];
      field1395 = 0;
      field1407 = 0;
      field1410 = 0;
      field1411 = 0;
      field1412 = 0;
      field1413 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      loginIndex = 0;
      field1419 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field1422 = class149.field2161;
      field1424 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field1426 = -1;
   }

   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1077798560"
   )
   static final void method1694() {
      Region.lowMemory = false;
      Client.lowMemory = false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IILfk;Lfu;B)Z",
      garbageValue = "108"
   )
   public static final boolean method1693(int var0, int var1, class163 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class162.field2262[var6][var7] = 99;
      class162.field2265[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class162.field2268[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class162.field2269[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class162.field2268[var11];
         var5 = class162.field2269[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2998(1, var4, var5, var3)) {
            class162.field2266 = var4;
            class162.field2267 = var5;
            return true;
         }

         int var15 = class162.field2265[var16][var17] + 1;
         if(var16 > 0 && class162.field2262[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class162.field2268[var18] = var4 - 1;
            class162.field2269[var18] = var5;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16 - 1][var17] = 2;
            class162.field2265[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class162.field2262[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class162.field2268[var18] = var4 + 1;
            class162.field2269[var18] = var5;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16 + 1][var17] = 8;
            class162.field2265[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class162.field2262[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class162.field2268[var18] = var4;
            class162.field2269[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16][var17 - 1] = 1;
            class162.field2265[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class162.field2262[var16][var17 + 1] == 0 && 0 == (var12[var13][var14 + 1] & 19136800)) {
            class162.field2268[var18] = var4;
            class162.field2269[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16][var17 + 1] = 4;
            class162.field2265[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class162.field2262[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class162.field2268[var18] = var4 - 1;
            class162.field2269[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16 - 1][var17 - 1] = 3;
            class162.field2265[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class162.field2262[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && 0 == (var12[var13 + 1][var14] & 19136896) && (var12[var13][var14 - 1] & 19136770) == 0) {
            class162.field2268[var18] = var4 + 1;
            class162.field2269[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16 + 1][var17 - 1] = 9;
            class162.field2265[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && 0 == class162.field2262[var16 - 1][var17 + 1] && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class162.field2268[var18] = var4 - 1;
            class162.field2269[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16 - 1][var17 + 1] = 6;
            class162.field2265[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class162.field2262[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class162.field2268[var18] = var4 + 1;
            class162.field2269[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2262[var16 + 1][var17 + 1] = 12;
            class162.field2265[var16 + 1][var17 + 1] = var15;
         }
      }

      class162.field2266 = var4;
      class162.field2267 = var5;
      return false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Liw;",
      garbageValue = "55"
   )
   public static VarPlayerType method1695(int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
         var1 = new VarPlayerType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarPlayerType.varplayers.put(var1, (long)var0);
         return var1;
      }
   }
}
