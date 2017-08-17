import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   Sequence field1551;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1938956159
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1582719501
   )
   int field1555;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1080782985
   )
   @Export("type")
   int type;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -96689617
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 572108145
   )
   @Export("level")
   int level;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 511107937
   )
   int field1556;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1178355781
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 595645447
   )
   @Export("sceneY")
   int sceneY;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLeq;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1551 = PendingSpawn.getAnimation(var7);
         this.field1556 = 0;
         this.field1555 = Client.gameCycle - 1;
         if(this.field1551.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1551 == this.field1551) {
               this.field1556 = var10.field1556;
               this.field1555 = var10.field1555;
               return;
            }
         }

         if(var8 && this.field1551.frameStep != -1) {
            this.field1556 = (int)(Math.random() * (double)this.field1551.frameIDs.length);
            this.field1555 -= (int)(Math.random() * (double)this.field1551.frameLenghts[this.field1556]);
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Leo;",
      garbageValue = "1214595416"
   )
   protected final Model getModel() {
      if(this.field1551 != null) {
         int var1 = Client.gameCycle - this.field1555;
         if(var1 > 100 && this.field1551.frameStep > 0) {
            var1 = 100;
         }

         label55: {
            do {
               do {
                  if(var1 <= this.field1551.frameLenghts[this.field1556]) {
                     break label55;
                  }

                  var1 -= this.field1551.frameLenghts[this.field1556];
                  ++this.field1556;
               } while(this.field1556 < this.field1551.frameIDs.length);

               this.field1556 -= this.field1551.frameStep;
            } while(this.field1556 >= 0 && this.field1556 < this.field1551.frameIDs.length);

            this.field1551 = null;
         }

         this.field1555 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class37.getObjectDefinition(this.id);
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
         int var9 = var8[var4][var7] + var8[var4][var6] + var8[var5][var6] + var8[var5][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4563(this.type, this.orientation, var8, var10, var9, var11, this.field1551, this.field1556);
      }
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "1438298404"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      boolean var12 = false;
      if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
         Client.menuOptions[Client.menuOptionCount] = var0;
         Client.menuTargets[Client.menuOptionCount] = var1;
         Client.menuTypes[Client.menuOptionCount] = var2;
         Client.menuIdentifiers[Client.menuOptionCount] = var3;
         Client.menuActionParams0[Client.menuOptionCount] = var4;
         Client.menuActionParams1[Client.menuOptionCount] = var5;
         Client.field1131[Client.menuOptionCount] = var12;
         ++Client.menuOptionCount;
      }

   }
}
