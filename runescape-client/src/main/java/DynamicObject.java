import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 821490071
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1460018579
   )
   int field1544;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1560050815
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1028790775
   )
   @Export("level")
   int level;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1569154449
   )
   @Export("type")
   int type;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1184483233
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1839964555
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2003595571
   )
   int field1550;
   @ObfuscatedName("c")
   Sequence field1551;

   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "49"
   )
   static final void method1838() {
      Overlay.field3596.reset();
      class169.method3123();
      class88.method1694();
      class234.method4121();
      NPCComposition.field3593.reset();
      NPCComposition.npcModelCache.reset();
      ItemComposition.field3501.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      class31.method282();
      Spotanim.field3327.reset();
      Spotanim.field3328.reset();
      Varbit.field3385.reset();
      class241.field3290.reset();
      class254.field3419.reset();
      class254.field3420.reset();
      class254.field3421.reset();
      CombatInfo2.field3365.reset();
      CombatInfo2.spriteCache.reset();
      class252.field3403.reset();
      class251.field3388.reset();
      Area.field3295.reset();
      class82.method1583();
      class71.method1083();
      ((TextureProvider)class136.field2039).method2393();
      Script.field1534.reset();
      class69.indexInterfaces.method4139();
      Client.indexSoundEffects.method4139();
      XItemContainer.field765.method4139();
      RSCanvas.field655.method4139();
      class77.indexMaps.method4139();
      class54.indexTrack1.method4139();
      class23.indexModels.method4139();
      Client.indexSprites.method4139();
      Player.indexTextures.method4139();
      class22.field353.method4139();
      IndexData.indexTrack2.method4139();
      GroundObject.indexScripts.method4139();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)LModel;",
      garbageValue = "-1617"
   )
   protected final Model getModel() {
      if(this.field1551 != null) {
         int var1 = Client.gameCycle - this.field1544;
         if(var1 > 100 && this.field1551.frameStep > 0) {
            var1 = 100;
         }

         label67: {
            do {
               do {
                  if(var1 <= this.field1551.frameLenghts[this.field1550]) {
                     break label67;
                  }

                  var1 -= this.field1551.frameLenghts[this.field1550];
                  ++this.field1550;
               } while(this.field1550 < this.field1551.frameIDs.length);

               this.field1550 -= this.field1551.frameStep;
            } while(this.field1550 >= 0 && this.field1550 < this.field1551.frameIDs.length);

            this.field1551 = null;
         }

         this.field1544 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class61.getObjectDefinition(this.id);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.orientation != 1 && this.orientation != 3) {
            var2 = var12.sizeX;
            var3 = var12.sizeY;
         } else {
            var2 = var12.sizeY;
            var3 = var12.sizeX;
         }

         int var4 = this.sceneX + (var2 >> 1);
         int var5 = (var2 + 1 >> 1) + this.sceneX;
         int var6 = (var3 >> 1) + this.sceneY;
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var4][var7] + var8[var4][var6] + var8[var5][var6] + var8[var5][var7] >> 2;
         int var10 = (var2 << 6) + (this.sceneX << 7);
         int var11 = (var3 << 6) + (this.sceneY << 7);
         return var12.method4546(this.type, this.orientation, var8, var10, var9, var11, this.field1551, this.field1550);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)LSpotanim;",
      garbageValue = "-1827471331"
   )
   public static Spotanim method1840(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.field3327.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field3326.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.field3334 = var0;
         if(var2 != null) {
            var1.method4356(new Buffer(var2));
         }

         Spotanim.field3327.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "124"
   )
   static void method1841(int var0) {
      Client.field946 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      if(class140.method2868() == 1) {
         class46.field590.method831(765, 503);
      } else {
         class46.field590.method831(7680, 2160);
      }

      if(Client.gameState >= 25) {
         class77.method1488();
      }

   }

   @ObfuscatedName("n")
   public static final void method1842(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            Tile.method2508(var0 - 1L);
            Tile.method2508(1L);
         } else {
            Tile.method2508(var0);
         }

      }
   }

   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1551 = class169.getAnimation(var7);
         this.field1550 = 0;
         this.field1544 = Client.gameCycle - 1;
         if(this.field1551.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1551 == this.field1551) {
               this.field1550 = var10.field1550;
               this.field1544 = var10.field1544;
               return;
            }
         }

         if(var8 && this.field1551.frameStep != -1) {
            this.field1550 = (int)(Math.random() * (double)this.field1551.frameIDs.length);
            this.field1544 -= (int)(Math.random() * (double)this.field1551.frameLenghts[this.field1550]);
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "539296862"
   )
   public static int method1843(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
