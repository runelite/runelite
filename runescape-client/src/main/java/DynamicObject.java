import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1511146089
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1680474799
   )
   @Export("type")
   int type;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1229574213
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -523905713
   )
   @Export("level")
   int level;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1851123415
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1844217227
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   Sequence field1442;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1630363609
   )
   int field1444;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 789619793
   )
   int field1436;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLen;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1442 = class158.getAnimation(var7);
         this.field1444 = 0;
         this.field1436 = Client.gameCycle - 1;
         if(this.field1442.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(this.field1442 == var10.field1442) {
               this.field1444 = var10.field1444;
               this.field1436 = var10.field1436;
               return;
            }
         }

         if(var8 && this.field1442.frameStep != -1) {
            this.field1444 = (int)(Math.random() * (double)this.field1442.frameIDs.length);
            this.field1436 -= (int)(Math.random() * (double)this.field1442.frameLenghts[this.field1444]);
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lek;",
      garbageValue = "22"
   )
   protected final Model getModel() {
      if(this.field1442 != null) {
         int var1 = Client.gameCycle - this.field1436;
         if(var1 > 100 && this.field1442.frameStep > 0) {
            var1 = 100;
         }

         label56: {
            do {
               do {
                  if(var1 <= this.field1442.frameLenghts[this.field1444]) {
                     break label56;
                  }

                  var1 -= this.field1442.frameLenghts[this.field1444];
                  ++this.field1444;
               } while(this.field1444 < this.field1442.frameIDs.length);

               this.field1444 -= this.field1442.frameStep;
            } while(this.field1444 >= 0 && this.field1444 < this.field1442.frameIDs.length);

            this.field1442 = null;
         }

         this.field1436 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = Spotanim.getObjectDefinition(this.id);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.orientation != 1 && this.orientation != 3) {
            var2 = var12.width;
            var3 = var12.length;
         } else {
            var2 = var12.length;
            var3 = var12.width;
         }

         int var4 = (var2 >> 1) + this.sceneX;
         int var5 = (var2 + 1 >> 1) + this.sceneX;
         int var6 = (var3 >> 1) + this.sceneY;
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class62.tileHeights[this.level];
         int var9 = var8[var5][var7] + var8[var5][var6] + var8[var4][var6] + var8[var4][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method5000(this.type, this.orientation, var8, var10, var9, var11, this.field1442, this.field1444);
      }
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "23"
   )
   static void method2052(int var0, int var1, int var2) {
      if(Client.field899 != 0 && var1 != 0 && Client.queuedSoundEffectCount < 50) {
         Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var0;
         Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var1;
         Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var2;
         Client.audioEffects[Client.queuedSoundEffectCount] = null;
         Client.soundLocations[Client.queuedSoundEffectCount] = 0;
         ++Client.queuedSoundEffectCount;
      }

   }
}
