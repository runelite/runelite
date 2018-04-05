import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   static IndexDataBase field1471;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1655291571
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1718995377
   )
   @Export("type")
   int type;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1725170749
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2071573869
   )
   @Export("level")
   int level;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 676600123
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 502960575
   )
   @Export("sceneY")
   int sceneY;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   Sequence field1466;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1509271593
   )
   @Export("animFrame")
   int animFrame;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1490007255
   )
   @Export("animCycleCount")
   int animCycleCount;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLed;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1466 = CombatInfo1.getAnimation(var7);
         this.animFrame = 0;
         this.animCycleCount = Client.gameCycle - 1;
         if(this.field1466.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1466 == this.field1466) {
               this.animFrame = var10.animFrame;
               this.animCycleCount = var10.animCycleCount;
               return;
            }
         }

         if(var8 && this.field1466.frameStep != -1) {
            this.animFrame = (int)(Math.random() * (double)this.field1466.frameIDs.length);
            this.animCycleCount -= (int)(Math.random() * (double)this.field1466.frameLengths[this.animFrame]);
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lei;",
      garbageValue = "1329079562"
   )
   protected final Model getModel() {
      if(this.field1466 != null) {
         int var1 = Client.gameCycle - this.animCycleCount;
         if(var1 > 100 && this.field1466.frameStep > 0) {
            var1 = 100;
         }

         label55: {
            do {
               do {
                  if(var1 <= this.field1466.frameLengths[this.animFrame]) {
                     break label55;
                  }

                  var1 -= this.field1466.frameLengths[this.animFrame];
                  ++this.animFrame;
               } while(this.animFrame < this.field1466.frameIDs.length);

               this.animFrame -= this.field1466.frameStep;
            } while(this.animFrame >= 0 && this.animFrame < this.field1466.frameIDs.length);

            this.field1466 = null;
         }

         this.animCycleCount = Client.gameCycle - var1;
      }

      ObjectComposition var12 = GameCanvas.getObjectDefinition(this.id);
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
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var4][var6] + var8[var5][var6] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method5000(this.type, this.orientation, var8, var10, var9, var11, this.field1466, this.animFrame);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "525976656"
   )
   @Export("getVarbit")
   public static int getVarbit(int var0) {
      Varbit var2 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = Varbit.varbit_ref.getConfigData(14, var0);
         var2 = new Varbit();
         if(var7 != null) {
            var2.decode(new Buffer(var7));
         }

         Varbit.varbits.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.configId;
      int var4 = var1.leastSignificantBit;
      int var5 = var1.mostSignificantBit;
      int var6 = class237.varpsMasks[var5 - var4];
      return class237.clientVarps[var3] >> var4 & var6;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "0"
   )
   public static boolean method2021(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1773768769"
   )
   static void method2024(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1230[var5] != var0) {
            var2[var4] = World.field1230[var5];
            var3[var4] = World.field1229[var5];
            ++var4;
         }
      }

      World.field1230 = var2;
      World.field1229 = var3;
      WorldMapType1.method308(World.worldList, 0, World.worldList.length - 1, World.field1230, World.field1229);
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "68774914"
   )
   static final void method2026(int var0, int var1) {
      if(class189.loadWidget(var0)) {
         class236.method4345(MouseRecorder.widgets[var0], var1);
      }
   }
}
