import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public final class class61 {
   @ObfuscatedName("e")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("ah")
   static java.awt.Font field745;
   @ObfuscatedName("n")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -659698319
   )
   static int field753;
   @ObfuscatedName("t")
   static final int[] field749;
   @ObfuscatedName("p")
   static final int[] field750;
   @ObfuscatedName("f")
   static final int[] field751;
   @ObfuscatedName("b")
   static final int[] field752;
   @ObfuscatedName("x")
   static final int[] field755;
   @ObfuscatedName("i")
   static final int[] field747;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1098141467
   )
   static int field757;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2115544477
   )
   static int field743;
   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("w")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("s")
   static int[][][] field748;
   @ObfuscatedName("r")
   static int[][] field756;
   @ObfuscatedName("l")
   static int[] field746;
   @ObfuscatedName("h")
   static int[] field742;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field753 = 99;
      field749 = new int[]{1, 2, 4, 8};
      field750 = new int[]{16, 32, 64, 128};
      field751 = new int[]{1, 0, -1, 0};
      field752 = new int[]{0, -1, 0, 1};
      field755 = new int[]{1, -1, -1, 1};
      field747 = new int[]{-1, -1, 1, 1};
      field757 = (int)(Math.random() * 17.0D) - 8;
      field743 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[BLfq;I)V",
      garbageValue = "-1596688326"
   )
   static void method1070(int var0, byte[] var1, IndexFile var2) {
      FileSystem var3 = new FileSystem();
      var3.field3189 = 0;
      var3.hash = (long)var0;
      var3.field3185 = var1;
      var3.index = var2;
      Deque var4 = class237.field3215;
      synchronized(class237.field3215) {
         class237.field3215.addFront(var3);
      }

      Object var9 = class237.field3217;
      synchronized(class237.field3217) {
         if(class237.field3216 == 0) {
            class237.field3219 = new Thread(new class237());
            class237.field3219.setDaemon(true);
            class237.field3219.start();
            class237.field3219.setPriority(5);
         }

         class237.field3216 = 600;
      }
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(Lcp;I)V",
      garbageValue = "1988785546"
   )
   static final void method1051(Actor var0) {
      if(var0.field1252 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1239 + 1 > Ignore.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field1252 - var0.field1238;
         int var2 = Client.gameCycle - var0.field1238;
         int var3 = var0.field1254 * 64 + var0.field1247 * 128;
         int var4 = var0.field1254 * 64 + var0.field1251 * 128;
         int var5 = var0.field1248 * 128 + var0.field1254 * 64;
         int var6 = var0.field1254 * 64 + var0.field1228 * 128;
         var0.x = (var3 * (var1 - var2) + var5 * var2) / var1;
         var0.y = (var6 * var2 + var4 * (var1 - var2)) / var1;
      }

      var0.field1263 = 0;
      var0.orientation = var0.field1253;
      var0.angle = var0.orientation;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIILia;II)V",
      garbageValue = "-748953701"
   )
   static void method1068(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class82 var5 = new class82();
      var5.field1315 = var0;
      var5.field1305 = var1 * 128;
      var5.field1304 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field1307 = (var6 + var1) * 128;
      var5.field1308 = (var7 + var2) * 128;
      var5.field1310 = var3.ambientSoundId;
      var5.field1306 = var3.field3457 * 128;
      var5.field1303 = var3.field3472;
      var5.field1313 = var3.field3473;
      var5.field1311 = var3.field3474;
      if(var3.impostorIds != null) {
         var5.field1317 = var3;
         var5.method1609();
      }

      class82.field1314.addFront(var5);
      if(var5.field1311 != null) {
         var5.field1309 = var5.field1303 + (int)(Math.random() * (double)(var5.field1313 - var5.field1303));
      }

   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method1042() {
      Client.field1131 = 0;
      int var0 = (class54.localPlayer.x >> 7) + class25.baseX;
      int var1 = (class54.localPlayer.y >> 7) + ScriptEvent.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field1131 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field1131 = 1;
      }

      if(Client.field1131 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field1131 = 0;
      }

   }
}
