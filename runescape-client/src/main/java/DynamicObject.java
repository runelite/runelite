import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2021592303
   )
   @Export("id")
   int id;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1018148769
   )
   @Export("type")
   int type;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1594855673
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -943516309
   )
   @Export("level")
   int level;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 103638107
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1234520923
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   Sequence field1436;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1177637985
   )
   int field1430;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 817165579
   )
   int field1438;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLeh;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1436 = FileRequest.getAnimation(var7);
         this.field1430 = 0;
         this.field1438 = Client.gameCycle - 1;
         if(this.field1436.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1436 == this.field1436) {
               this.field1430 = var10.field1430;
               this.field1438 = var10.field1438;
               return;
            }
         }

         if(var8 && this.field1436.frameStep != -1) {
            this.field1430 = (int)(Math.random() * (double)this.field1436.frameIDs.length);
            this.field1438 -= (int)(Math.random() * (double)this.field1436.frameLenghts[this.field1430]);
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Les;",
      garbageValue = "-25440425"
   )
   protected final Model getModel() {
      if(this.field1436 != null) {
         int var1 = Client.gameCycle - this.field1438;
         if(var1 > 100 && this.field1436.frameStep > 0) {
            var1 = 100;
         }

         label55: {
            do {
               do {
                  if(var1 <= this.field1436.frameLenghts[this.field1430]) {
                     break label55;
                  }

                  var1 -= this.field1436.frameLenghts[this.field1430];
                  ++this.field1430;
               } while(this.field1430 < this.field1436.frameIDs.length);

               this.field1430 -= this.field1436.frameStep;
            } while(this.field1430 >= 0 && this.field1430 < this.field1436.frameIDs.length);

            this.field1436 = null;
         }

         this.field1438 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class219.getObjectDefinition(this.id);
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
         return var12.method4940(this.type, this.orientation, var8, var10, var9, var11, this.field1436, this.field1430);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1223595857"
   )
   static final void method2026() {
      if(!class131.Viewport_false0) {
         int var0 = Region.pitchSin;
         int var1 = Region.pitchCos;
         int var2 = Region.yawSin;
         int var3 = Region.yawCos;
         byte var4 = 50;
         short var5 = 3500;
         int var6 = (class131.Viewport_mouseX - Graphics3D.centerX) * var4 / Graphics3D.Rasterizer3D_zoom;
         int var7 = (class131.Viewport_mouseY - Graphics3D.centerY) * var4 / Graphics3D.Rasterizer3D_zoom;
         int var8 = (class131.Viewport_mouseX - Graphics3D.centerX) * var5 / Graphics3D.Rasterizer3D_zoom;
         int var9 = (class131.Viewport_mouseY - Graphics3D.centerY) * var5 / Graphics3D.Rasterizer3D_zoom;
         int var10 = Graphics3D.method2839(var7, var4, var1, var0);
         int var11 = Graphics3D.method2853(var7, var4, var1, var0);
         var7 = var10;
         var10 = Graphics3D.method2839(var9, var5, var1, var0);
         int var12 = Graphics3D.method2853(var9, var5, var1, var0);
         var9 = var10;
         var10 = Graphics3D.method2837(var6, var11, var3, var2);
         var11 = Graphics3D.method2838(var6, var11, var3, var2);
         var6 = var10;
         var10 = Graphics3D.method2837(var8, var12, var3, var2);
         var12 = Graphics3D.method2838(var8, var12, var3, var2);
         class33.field445 = (var10 + var6) / 2;
         AbstractByteBuffer.field2530 = (var9 + var7) / 2;
         class5.field28 = (var11 + var12) / 2;
         class131.field1881 = (var10 - var6) / 2;
         class222.field2709 = (var9 - var7) / 2;
         class31.field425 = (var12 - var11) / 2;
         class218.field2692 = Math.abs(class131.field1881);
         AttackOption.field1316 = Math.abs(class222.field2709);
         class36.field482 = Math.abs(class31.field425);
      }
   }
}
