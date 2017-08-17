import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class45 extends class28 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 348652393
   )
   int field592;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 595382543
   )
   int field597;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -274275987
   )
   int field595;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -575865611
   )
   int field594;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "625904177"
   )
   int method676() {
      return this.field594;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-97"
   )
   boolean method666(int var1, int var2) {
      return var1 < this.field594 * 8?false:(var2 < this.field595 * 8?false:(var1 >= 8 + this.field594 * 8?false:var2 < 8 + this.field595 * 8));
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "740008290"
   )
   int method664() {
      return this.field595;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfb;Lfb;I)V",
      garbageValue = "-1368940923"
   )
   void method674(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field510.field509) {
         throw new IllegalStateException("");
      } else {
         super.field414 = var2.readUnsignedByte();
         super.field415 = var2.readUnsignedByte();
         super.field416 = var2.readUnsignedShort();
         super.field411 = var2.readUnsignedShort();
         this.field597 = var2.readUnsignedByte();
         this.field592 = var2.readUnsignedByte();
         super.field424 = var2.readUnsignedShort();
         super.field413 = var2.readUnsignedShort();
         this.field594 = var2.readUnsignedByte();
         this.field595 = var2.readUnsignedByte();
         super.field415 = Math.min(super.field415, 4);
         super.field419 = new short[1][64][64];
         super.field417 = new short[super.field415][64][64];
         super.field412 = new byte[super.field415][64][64];
         super.field423 = new byte[super.field415][64][64];
         super.field420 = new class31[super.field415][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field502.field503) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field424 && var5 == super.field413 && var6 == this.field594 && var7 == this.field595) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method237(var8 + this.field594 * 8, var9 + this.field595 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-360521105"
   )
   int method667() {
      return this.field597;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-337666434"
   )
   int method668() {
      return this.field592;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return super.field424 == var2.field424 && super.field413 == var2.field413?this.field594 == var2.field594 && var2.field595 == this.field595:false;
      }
   }

   public int hashCode() {
      return super.field424 | super.field413 << 8 | this.field594 << 16 | this.field595 << 24;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "243437649"
   )
   static int method689() {
      return 9;
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1363827348"
   )
   static final void method688(boolean var0) {
      for(int var1 = 0; var1 < Client.field958; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method4671()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1219 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field1028[var4][var5] == Client.field1071) {
                     continue;
                  }

                  Client.field1028[var4][var5] = Client.field1071;
               }

               if(!var2.composition.field3570) {
                  var3 -= Integer.MIN_VALUE;
               }

               class36.region.method2713(class35.plane, var2.x, var2.y, class25.getTileHeight(var2.x + (var2.field1219 * 64 - 64), var2.field1219 * 64 - 64 + var2.y, class35.plane), 60 + (var2.field1219 * 64 - 64), var2, var2.angle, var3, var2.field1221);
            }
         }
      }

   }
}
