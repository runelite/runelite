import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class41 {
   @ObfuscatedName("b")
   static ModIcon field828;
   @ObfuscatedName("h")
   static ModIcon[] field829;
   @ObfuscatedName("v")
   static SpritePixels field830;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 424973791
   )
   static int field831;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1955133173
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -378479917
   )
   static int field834;
   @ObfuscatedName("ay")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1377076957
   )
   static int field836;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 128647315
   )
   static int field837;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 771220193
   )
   static int field838;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1113633037
   )
   static int field839;
   @ObfuscatedName("c")
   static ModIcon field840;
   @ObfuscatedName("aw")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ah")
   static String field843;
   @ObfuscatedName("ar")
   static class97 field844;
   @ObfuscatedName("ab")
   static String field845;
   @ObfuscatedName("an")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 242079657
   )
   static int field848;
   @ObfuscatedName("af")
   @Export("username")
   static String username;
   @ObfuscatedName("ac")
   static String field850;
   @ObfuscatedName("x")
   static int[] field851;
   @ObfuscatedName("ax")
   static boolean field852;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1663804293
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("aq")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -911135857
   )
   static int field857;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1913173373
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1346429657
   )
   static int field860 = 0;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-2"
   )
   static void method745(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method2299((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method2291(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   static {
      loginWindowX = field860 + 202;
      field851 = new int[256];
      field836 = 0;
      field848 = 0;
      field838 = 0;
      field839 = 0;
      field834 = 0;
      field831 = 0;
      field837 = 10;
      field843 = "";
      loginIndex = 0;
      field845 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      field850 = "";
      field844 = class97.field1622;
      field852 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field857 = -1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "-2101929191"
   )
   static final void method764(class159 var0) {
      var0.method2969();
      int var1 = Client.localInteractingIndex;
      Player var2 = class5.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field273 = var1;
      int var3 = var0.method2986(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class107.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method227() << 6);
      var2.pathY[0] = var6 - XClanMember.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method227() << 6);
      class63.plane = var2.field256 = var4;
      if(null != class45.field917[var1]) {
         var2.method210(class45.field917[var1]);
      }

      class45.field900 = 0;
      class45.field902[++class45.field900 - 1] = var1;
      class45.field898[var1] = 0;
      class45.field903 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2986(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class45.field897[var7] = var11 + (var9 << 28) + (var10 << 14);
            class45.field906[var7] = 0;
            class45.field913[var7] = -1;
            class45.field905[++class45.field903 - 1] = var7;
            class45.field898[var7] = 0;
         }
      }

      var0.method2992();
   }
}
