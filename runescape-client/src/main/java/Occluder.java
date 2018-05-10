import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static IndexedSprite field1844;
   @ObfuscatedName("cj")
   @Export("currentTypedKey")
   public static char currentTypedKey;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 617260111
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 242440289
   )
   @Export("maxTIleX")
   int maxTIleX;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -906482335
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -822062233
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -754905395
   )
   @Export("type")
   int type;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1606352773
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 85911845
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -451208931
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 574942283
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -111629493
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1649709051
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -691877509
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1691264071
   )
   int field1827;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1885408739
   )
   int field1839;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 364478629
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2008346895
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1385685981
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1299910263
   )
   @Export("maxNormalY")
   int maxNormalY;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)[Lix;",
      garbageValue = "27340"
   )
   public static JagexGame[] method3112() {
      return new JagexGame[]{JagexGame.field3153, JagexGame.field3155, JagexGame.field3159, JagexGame.field3156, JagexGame.field3154, JagexGame.field3158};
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "862300710"
   )
   static void method3110() {
      if(class78.username == null || class78.username.length() <= 0) {
         if(ScriptState.preferences.rememberedUsername != null) {
            class78.username = ScriptState.preferences.rememberedUsername;
            class78.Login_isUsernameRemembered = true;
         } else {
            class78.Login_isUsernameRemembered = false;
         }

      }
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1977010069"
   )
   static final void method3113(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field841 - Client.field745) * var5 / 100 + Client.field745;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field707) {
         var15 = Client.field707;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field863) {
            var6 = Client.field863;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field847) {
         var15 = Client.field847;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field844) {
            var6 = Client.field844;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field615 - Client.field842) * var5 / 100 + Client.field842;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.buildVisibilityMaps(var14, 500, 800, var2, var3);
      }

      Client.Viewport_xOffset = var0;
      Client.Viewport_yOffset = var1;
      Client.viewportWidth = var2;
      Client.viewportHeight = var3;
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "188281095"
   )
   static final void method3111(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = Graphics3D.SINE[var6];
         var12 = Graphics3D.COSINE[var6];
         var13 = var12 * var9 - var11 * var5 >> 16;
         var10 = var11 * var9 + var5 * var12 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = Graphics3D.SINE[var7];
         var12 = Graphics3D.COSINE[var7];
         var13 = var11 * var10 + var12 * var8 >> 16;
         var10 = var10 * var12 - var8 * var11 >> 16;
         var8 = var13;
      }

      WorldMapType3.cameraX = var0 - var8;
      Size.cameraZ = var1 - var9;
      class13.cameraY = var2 - var10;
      class146.cameraPitch = var3;
      WidgetNode.cameraYaw = var4;
      if(Client.field678 == 1 && Client.rights >= 2 && Client.gameCycle % 50 == 0 && (Signlink.field1979 >> 7 != MilliTimer.localPlayer.x >> 7 || ItemContainer.field481 >> 7 != MilliTimer.localPlayer.y >> 7)) {
         var11 = MilliTimer.localPlayer.field581;
         var12 = (Signlink.field1979 >> 7) + class178.baseX;
         var13 = (ItemContainer.field481 >> 7) + CombatInfoListHolder.baseY;
         class145.method3194(var12, var13, var11, true);
      }

   }
}
