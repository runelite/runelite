import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("z")
   public static boolean field1539;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   @Export("timer")
   static Timer timer;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1925052983
   )
   public static int field1533;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 383855755
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -31861719
   )
   @Export("type")
   int type;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1805786001
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -464199777
   )
   @Export("level")
   int level;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -905457245
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -129834691
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   Sequence field1544;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 131880007
   )
   int field1540;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1493316481
   )
   int field1541;

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
         this.field1544 = NPCComposition.getAnimation(var7);
         this.field1540 = 0;
         this.field1541 = Client.gameCycle - 1;
         if(this.field1544.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1544 == this.field1544) {
               this.field1540 = var10.field1540;
               this.field1541 = var10.field1541;
               return;
            }
         }

         if(var8 && this.field1544.frameStep != -1) {
            this.field1540 = (int)(Math.random() * (double)this.field1544.frameIDs.length);
            this.field1541 -= (int)(Math.random() * (double)this.field1544.frameLenghts[this.field1540]);
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Leh;",
      garbageValue = "0"
   )
   protected final Model getModel() {
      if(this.field1544 != null) {
         int var1 = Client.gameCycle - this.field1541;
         if(var1 > 100 && this.field1544.frameStep > 0) {
            var1 = 100;
         }

         label54: {
            do {
               do {
                  if(var1 <= this.field1544.frameLenghts[this.field1540]) {
                     break label54;
                  }

                  var1 -= this.field1544.frameLenghts[this.field1540];
                  ++this.field1540;
               } while(this.field1540 < this.field1544.frameIDs.length);

               this.field1540 -= this.field1544.frameStep;
            } while(this.field1540 >= 0 && this.field1540 < this.field1544.frameIDs.length);

            this.field1544 = null;
         }

         this.field1541 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = CollisionData.getObjectDefinition(this.id);
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

         int var4 = (var2 >> 1) + this.sceneX;
         int var5 = (var2 + 1 >> 1) + this.sceneX;
         int var6 = (var3 >> 1) + this.sceneY;
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var4][var6] + var8[var5][var6] + var8[var4][var7] + var8[var5][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4641(this.type, this.orientation, var8, var10, var9, var11, this.field1544, this.field1540);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "22276546"
   )
   static int method1899(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1342408474"
   )
   static final void method1904(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(WorldMapData.loadWidget(var0)) {
         class217.method4128(class215.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
