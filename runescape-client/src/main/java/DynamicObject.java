import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljw;"
   )
   Sequence field1556;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -627765911
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1199585115
   )
   int field1558;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1297874311
   )
   @Export("type")
   int type;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -760983661
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 971408931
   )
   @Export("level")
   int level;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -833484053
   )
   int field1557;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1914222313
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 822187107
   )
   @Export("sceneY")
   int sceneY;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLew;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1556 = class216.getAnimation(var7);
         this.field1557 = 0;
         this.field1558 = Client.gameCycle - 1;
         if(this.field1556.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(this.field1556 == var10.field1556) {
               this.field1557 = var10.field1557;
               this.field1558 = var10.field1558;
               return;
            }
         }

         if(var8 && this.field1556.frameStep != -1) {
            this.field1557 = (int)(Math.random() * (double)this.field1556.frameIDs.length);
            this.field1558 -= (int)(Math.random() * (double)this.field1556.frameLenghts[this.field1557]);
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Lem;",
      garbageValue = "-1455933636"
   )
   protected final Model getModel() {
      if(this.field1556 != null) {
         int var1 = Client.gameCycle - this.field1558;
         if(var1 > 100 && this.field1556.frameStep > 0) {
            var1 = 100;
         }

         label57: {
            do {
               do {
                  if(var1 <= this.field1556.frameLenghts[this.field1557]) {
                     break label57;
                  }

                  var1 -= this.field1556.frameLenghts[this.field1557];
                  ++this.field1557;
               } while(this.field1557 < this.field1556.frameIDs.length);

               this.field1557 -= this.field1556.frameStep;
            } while(this.field1557 >= 0 && this.field1557 < this.field1556.frameIDs.length);

            this.field1556 = null;
         }

         this.field1558 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = GameObject.getObjectDefinition(this.id);
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
         int var5 = this.sceneX + (var2 + 1 >> 1);
         int var6 = (var3 >> 1) + this.sceneY;
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var4][var6] + var8[var5][var6] + var8[var4][var7] + var8[var5][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4539(this.type, this.orientation, var8, var10, var9, var11, this.field1556, this.field1557);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lcp;I)V",
      garbageValue = "-429348353"
   )
   static void method1864(World var0) {
      if(var0.method1550() != Client.isMembers) {
         Client.isMembers = var0.method1550();
         class21.method178(var0.method1550());
      }

      class22.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class262.field3628 = Client.socketType == 0?'ꩊ':var0.id + '鱀';
      WorldMapData.field472 = Client.socketType == 0?443:var0.id + '썐';
      class111.myWorldPort = class262.field3628;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "-1133561284"
   )
   static int method1865(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         Ignore.intStackSize -= 2;
         var3 = class82.intStack[Ignore.intStackSize];
         int var4 = class82.intStack[Ignore.intStackSize + 1];
         if(!Client.field1178) {
            Client.field956 = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class82.intStack[++Ignore.intStackSize - 1] = Client.field956;
         return 1;
      } else if(var0 == 5506) {
         class82.intStack[++Ignore.intStackSize - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class82.intStack[--Ignore.intStackSize];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field1020 = var3;
         return 1;
      } else if(var0 == 5531) {
         class82.intStack[++Ignore.intStackSize - 1] = Client.field1020;
         return 1;
      } else {
         return 2;
      }
   }
}
