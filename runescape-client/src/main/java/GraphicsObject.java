import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("lr")
   @ObfuscatedGetter(
      intValue = -465586463
   )
   static int field1358;
   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1291553661
   )
   @Export("id")
   int id;
   @ObfuscatedName("t")
   @Export("finished")
   boolean finished;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1877573441
   )
   int field1357;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2057826415
   )
   int field1354;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   Sequence field1347;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1784457741
   )
   @Export("level")
   int level;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1619850511
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1072741549
   )
   @Export("y")
   int y;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1557286641
   )
   @Export("height")
   int height;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 338622339
   )
   @Export("startCycle")
   int startCycle;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1354 = 0;
      this.field1357 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = class155.getSpotAnimType(this.id).field3326;
      if(var8 != -1) {
         this.finished = false;
         this.field1347 = class204.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Leb;",
      garbageValue = "1172124455"
   )
   protected final Model getModel() {
      Spotanim var1 = class155.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.method4436(this.field1354);
      } else {
         var2 = var1.method4436(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "54"
   )
   final void method1727(int var1) {
      if(!this.finished) {
         this.field1357 += var1;

         while(this.field1357 > this.field1347.frameLenghts[this.field1354]) {
            this.field1357 -= this.field1347.frameLenghts[this.field1354];
            ++this.field1354;
            if(this.field1354 >= this.field1347.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Lei;",
      garbageValue = "1355432419"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = class19.method144(Sequence.skel_ref, Sequence.skin_ref, var0, false);
         if(var1 != null) {
            Sequence.skeletons.put(var1, (long)var0);
         }

         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)[Lkr;",
      garbageValue = "-863365301"
   )
   static SpritePixels[] method1735() {
      SpritePixels[] var0 = new SpritePixels[class15.field298];

      for(int var1 = 0; var1 < class15.field298; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class287.field3808;
         var2.maxHeight = class164.field2325;
         var2.offsetX = class287.field3807[var1];
         var2.offsetY = World.offsetsY[var1];
         var2.width = class236.field3238[var1];
         var2.height = FileSystem.field3207[var1];
         int var3 = var2.width * var2.height;
         byte[] var4 = class208.spritePixels[var1];
         var2.image = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.image[var5] = class181.field2456[var4[var5] & 255];
         }
      }

      Actor.method1605();
      return var0;
   }
}
