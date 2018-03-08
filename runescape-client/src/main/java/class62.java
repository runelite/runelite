import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
public final class class62 {
   @ObfuscatedName("t")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("q")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1324987623
   )
   static int field705;
   @ObfuscatedName("a")
   static byte[][][] field711;
   @ObfuscatedName("l")
   static byte[][][] field707;
   @ObfuscatedName("b")
   static byte[][][] field708;
   @ObfuscatedName("x")
   static byte[][][] field704;
   @ObfuscatedName("p")
   static int[][] field714;
   @ObfuscatedName("u")
   static int[][][] field709;
   @ObfuscatedName("w")
   static final int[] field713;
   @ObfuscatedName("s")
   static final int[] field715;
   @ObfuscatedName("d")
   static final int[] field722;
   @ObfuscatedName("f")
   static final int[] field716;
   @ObfuscatedName("r")
   static final int[] field717;
   @ObfuscatedName("y")
   static final int[] field718;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 497605019
   )
   static int field719;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1404865251
   )
   static int field720;
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   @Export("mapMarkers")
   static SpritePixels[] mapMarkers;
   @ObfuscatedName("gh")
   @ObfuscatedGetter(
      intValue = -1517107375
   )
   @Export("cameraYaw")
   static int cameraYaw;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field705 = 99;
      field713 = new int[]{1, 2, 4, 8};
      field715 = new int[]{16, 32, 64, 128};
      field722 = new int[]{1, 0, -1, 0};
      field716 = new int[]{0, -1, 0, 1};
      field717 = new int[]{1, -1, -1, 1};
      field718 = new int[]{-1, -1, 1, 1};
      field719 = (int)(Math.random() * 17.0D) - 8;
      field720 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(Lbi;ZB)V",
      garbageValue = "8"
   )
   static void method1112(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         int var2 = var0.field837 << 14;
         var0.isLowDetail = false;
         if((Client.lowMemory && class93.playerIndexesCount > 50 || class93.playerIndexesCount > 200) && var1 && var0.poseAnimation == var0.idlePoseAnimation) {
            var0.isLowDetail = true;
         }

         int var3 = var0.x >> 7;
         int var4 = var0.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var0.model != null && Client.gameCycle >= var0.animationCycleStart && Client.gameCycle < var0.animationCycleEnd) {
               var0.isLowDetail = false;
               var0.field822 = class149.getTileHeight(var0.x, var0.y, Ignore.plane);
               var0.field1141 = Client.gameCycle;
               class38.region.method2878(Ignore.plane, var0.x, var0.y, var0.field822, 60, var0, var0.angle, var2, var0.field815, var0.field814, var0.field829, var0.field841);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field1078[var3][var4] == Client.field1043) {
                     return;
                  }

                  Client.field1078[var3][var4] = Client.field1043;
               }

               var0.field822 = class149.getTileHeight(var0.x, var0.y, Ignore.plane);
               var0.field1141 = Client.gameCycle;
               class38.region.method2877(Ignore.plane, var0.x, var0.y, var0.field822, 60, var0, var0.angle, var2, var0.field1165);
            }
         }
      }

   }
}
