import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class12 extends Renderable {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1163575043
   )
   int field172;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1209192413
   )
   int field173;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1272880135
   )
   int field174;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1596935487
   )
   int field175;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 917156749
   )
   static int field176;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1491100043
   )
   int field177;
   @ObfuscatedName("n")
   Sequence field178;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 228466587
   )
   int field179;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1874023967
   )
   int field180;
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      intValue = -1440633009
   )
   static int field181;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 490801151
   )
   int field185;

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field185 = var1;
      this.field173 = var2;
      this.field180 = var3;
      this.field174 = var4;
      this.field175 = var5;
      this.field177 = var6;
      if(var7 != -1) {
         this.field178 = Friend.getAnimation(var7);
         this.field179 = 0;
         this.field172 = Client.gameCycle - 1;
         if(this.field178.replyMode == 0 && null != var9 && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(this.field178 == var10.field178) {
               this.field179 = var10.field179;
               this.field172 = var10.field172;
               return;
            }
         }

         if(var8 && this.field178.field1014 != -1) {
            this.field179 = (int)(Math.random() * (double)this.field178.field1009.length);
            this.field172 -= (int)(Math.random() * (double)this.field178.field1015[this.field179]);
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "1853658170"
   )
   protected final Model getModel() {
      if(null != this.field178) {
         int var12 = Client.gameCycle - this.field172;
         if(var12 > 100 && this.field178.field1014 > 0) {
            var12 = 100;
         }

         label61: {
            do {
               do {
                  if(var12 <= this.field178.field1015[this.field179]) {
                     break label61;
                  }

                  var12 -= this.field178.field1015[this.field179];
                  ++this.field179;
               } while(this.field179 < this.field178.field1009.length);

               this.field179 -= this.field178.field1014;
            } while(this.field179 >= 0 && this.field179 < this.field178.field1009.length);

            this.field178 = null;
         }

         this.field172 = Client.gameCycle - var12;
      }

      ObjectComposition var1 = class165.getObjectDefinition(this.field185);
      if(null != var1.impostorIds) {
         var1 = var1.getImpostor();
      }

      if(var1 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field180 != 1 && this.field180 != 3) {
            var2 = var1.field963;
            var3 = var1.field964;
         } else {
            var2 = var1.field964;
            var3 = var1.field963;
         }

         int var4 = (var2 >> 1) + this.field175;
         int var5 = (var2 + 1 >> 1) + this.field175;
         int var6 = (var3 >> 1) + this.field177;
         int var7 = (1 + var3 >> 1) + this.field177;
         int[][] var8 = class5.tileHeights[this.field174];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var5][var6] + var8[var4][var6] >> 2;
         int var10 = (this.field175 << 7) + (var2 << 6);
         int var11 = (var3 << 6) + (this.field177 << 7);
         return var1.method844(this.field173, this.field180, var8, var10, var9, var11, this.field178, this.field179);
      }
   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-1594981484"
   )
   static final void method161(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field336 == -1) {
            Client.field336 = var0.textureId;
            Client.field343 = var0.field2850;
         }

         if(Client.field554.isFemale) {
            var0.textureId = Client.field336;
         } else {
            var0.textureId = Client.field343;
         }

      } else if(var1 == 325) {
         if(Client.field336 == -1) {
            Client.field336 = var0.textureId;
            Client.field343 = var0.field2850;
         }

         if(Client.field554.isFemale) {
            var0.textureId = Client.field343;
         } else {
            var0.textureId = Client.field336;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-397393077"
   )
   static final void method163() {
      Region.field1596 = false;
      Client.field285 = false;
   }
}
