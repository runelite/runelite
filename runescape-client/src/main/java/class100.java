import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public class class100 extends Renderable {
   @ObfuscatedName("t")
   Sequence field1535;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 239418613
   )
   int field1536;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1674557727
   )
   int field1537;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1467440705
   )
   int field1538;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 617651141
   )
   int field1539;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -894834623
   )
   int field1540;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -274146395
   )
   int field1541;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1988196371
   )
   int field1543;
   @ObfuscatedName("bd")
   static ModIcon[] field1544;
   @ObfuscatedName("fx")
   static int[] field1545;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1279514977
   )
   int field1546;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1208682604"
   )
   protected final Model getModel() {
      if(this.field1535 != null) {
         int var1 = Client.gameCycle - this.field1543;
         if(var1 > 100 && this.field1535.frameStep > 0) {
            var1 = 100;
         }

         label66: {
            do {
               do {
                  if(var1 <= this.field1535.frameLenghts[this.field1541]) {
                     break label66;
                  }

                  var1 -= this.field1535.frameLenghts[this.field1541];
                  ++this.field1541;
               } while(this.field1541 < this.field1535.frameIDs.length);

               this.field1541 -= this.field1535.frameStep;
            } while(this.field1541 >= 0 && this.field1541 < this.field1535.frameIDs.length);

            this.field1535 = null;
         }

         this.field1543 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class43.getObjectDefinition(this.field1536);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field1537 != 1 && this.field1537 != 3) {
            var2 = var12.sizeX;
            var3 = var12.sizeY;
         } else {
            var2 = var12.sizeY;
            var3 = var12.sizeX;
         }

         int var4 = this.field1539 + (var2 >> 1);
         int var5 = this.field1539 + (var2 + 1 >> 1);
         int var6 = (var3 >> 1) + this.field1540;
         int var7 = this.field1540 + (var3 + 1 >> 1);
         int[][] var8 = class61.tileHeights[this.field1546];
         int var9 = var8[var4][var7] + var8[var5][var6] + var8[var4][var6] + var8[var5][var7] >> 2;
         int var10 = (this.field1539 << 7) + (var2 << 6);
         int var11 = (this.field1540 << 7) + (var3 << 6);
         return var12.method4586(this.field1538, this.field1537, var8, var10, var9, var11, this.field1535, this.field1541);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;LIndexDataBase;I)V",
      garbageValue = "1995507010"
   )
   public static void method1891(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      Sequence.field3601 = var0;
      class215.field2624 = var1;
      class51.field656 = var2;
   }

   class100(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field1536 = var1;
      this.field1538 = var2;
      this.field1537 = var3;
      this.field1546 = var4;
      this.field1539 = var5;
      this.field1540 = var6;
      if(var7 != -1) {
         this.field1535 = class165.getAnimation(var7);
         this.field1541 = 0;
         this.field1543 = Client.gameCycle - 1;
         if(this.field1535.replyMode == 0 && var9 != null && var9 instanceof class100) {
            class100 var10 = (class100)var9;
            if(var10.field1535 == this.field1535) {
               this.field1541 = var10.field1541;
               this.field1543 = var10.field1543;
               return;
            }
         }

         if(var8 && this.field1535.frameStep != -1) {
            this.field1541 = (int)(Math.random() * (double)this.field1535.frameIDs.length);
            this.field1543 -= (int)(Math.random() * (double)this.field1535.frameLenghts[this.field1541]);
         }
      }

   }
}
