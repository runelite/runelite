import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1415515943
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1160229935
   )
   @Export("type")
   int type;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -528657293
   )
   @Export("id")
   int id;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 7318589
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1995687351
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("j")
   Sequence field1544;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 868437739
   )
   int field1545;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1262643903
   )
   int field1546;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 848916855
   )
   @Export("level")
   int level;

   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1544 = GameEngine.getAnimation(var7);
         this.field1545 = 0;
         this.field1546 = Client.gameCycle - 1;
         if(this.field1544.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(this.field1544 == var10.field1544) {
               this.field1545 = var10.field1545;
               this.field1546 = var10.field1546;
               return;
            }
         }

         if(var8 && this.field1544.frameStep != -1) {
            this.field1545 = (int)(Math.random() * (double)this.field1544.frameIDs.length);
            this.field1546 -= (int)(Math.random() * (double)this.field1544.frameLenghts[this.field1545]);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-2066149273"
   )
   protected final Model getModel() {
      if(this.field1544 != null) {
         int var1 = Client.gameCycle - this.field1546;
         if(var1 > 100 && this.field1544.frameStep > 0) {
            var1 = 100;
         }

         label47: {
            do {
               do {
                  if(var1 <= this.field1544.frameLenghts[this.field1545]) {
                     break label47;
                  }

                  var1 -= this.field1544.frameLenghts[this.field1545];
                  ++this.field1545;
               } while(this.field1545 < this.field1544.frameIDs.length);

               this.field1545 -= this.field1544.frameStep;
            } while(this.field1545 >= 0 && this.field1545 < this.field1544.frameIDs.length);

            this.field1544 = null;
         }

         this.field1546 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class29.getObjectDefinition(this.id);
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
         int var6 = this.sceneY + (var3 >> 1);
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var5][var7] + var8[var4][var6] + var8[var5][var6] + var8[var4][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4395(this.type, this.orientation, var8, var10, var9, var11, this.field1544, this.field1545);
      }
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1048477201"
   )
   static void method1762() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(class28.method248(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("p")
   static final int method1763(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(0.0D != var2) {
         double var12;
         if(var4 < 0.5D) {
            var12 = (var2 + 1.0D) * var4;
         } else {
            var12 = var2 + var4 - var4 * var2;
         }

         double var14 = var4 * 2.0D - var12;
         double var16 = var0 + 0.3333333333333333D;
         if(var16 > 1.0D) {
            --var16;
         }

         double var18 = var0 - 0.3333333333333333D;
         if(var18 < 0.0D) {
            ++var18;
         }

         if(var16 * 6.0D < 1.0D) {
            var6 = var14 + (var12 - var14) * 6.0D * var16;
         } else if(var16 * 2.0D < 1.0D) {
            var6 = var12;
         } else if(3.0D * var16 < 2.0D) {
            var6 = var14 + (0.6666666666666666D - var16) * (var12 - var14) * 6.0D;
         } else {
            var6 = var14;
         }

         if(var0 * 6.0D < 1.0D) {
            var8 = var0 * (var12 - var14) * 6.0D + var14;
         } else if(var0 * 2.0D < 1.0D) {
            var8 = var12;
         } else if(3.0D * var0 < 2.0D) {
            var8 = 6.0D * (var12 - var14) * (0.6666666666666666D - var0) + var14;
         } else {
            var8 = var14;
         }

         if(var18 * 6.0D < 1.0D) {
            var10 = 6.0D * (var12 - var14) * var18 + var14;
         } else if(var18 * 2.0D < 1.0D) {
            var10 = var12;
         } else if(var18 * 3.0D < 2.0D) {
            var10 = (0.6666666666666666D - var18) * (var12 - var14) * 6.0D + var14;
         } else {
            var10 = var14;
         }
      }

      int var20 = (int)(256.0D * var6);
      int var13 = (int)(256.0D * var8);
      int var21 = (int)(256.0D * var10);
      int var15 = (var13 << 8) + (var20 << 16) + var21;
      return var15;
   }
}
