import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class46 extends class28 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1911866693
   )
   int field585;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 352141443
   )
   int field583;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1312677505
   )
   int field584;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1278901949
   )
   int field582;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgy;Lgy;B)V",
      garbageValue = "-95"
   )
   void method641(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class37.field505.field507) {
         throw new IllegalStateException("");
      } else {
         super.field414 = var2.readUnsignedByte();
         super.field410 = var2.readUnsignedByte();
         super.field411 = var2.readUnsignedShort();
         super.field420 = var2.readUnsignedShort();
         this.field585 = var2.readUnsignedByte();
         this.field583 = var2.readUnsignedByte();
         super.field422 = var2.readUnsignedShort();
         super.field413 = var2.readUnsignedShort();
         this.field584 = var2.readUnsignedByte();
         this.field582 = var2.readUnsignedByte();
         super.field410 = Math.min(super.field410, 4);
         super.field423 = new short[1][64][64];
         super.field416 = new short[super.field410][64][64];
         super.field418 = new byte[super.field410][64][64];
         super.field419 = new byte[super.field410][64][64];
         super.field417 = new class31[super.field410][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class36.field500.field501) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field422 && var5 == super.field413 && var6 == this.field584 && var7 == this.field582) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method225(var8 + this.field584 * 8, var9 + this.field582 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1625254779"
   )
   boolean method642(int var1, int var2) {
      return var1 < this.field584 * 8?false:(var2 < this.field582 * 8?false:(var1 >= this.field584 * 8 + 8?false:var2 < this.field582 * 8 + 8));
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1959359789"
   )
   int method644() {
      return this.field585;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "60822844"
   )
   int method645() {
      return this.field583;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "109638280"
   )
   int method650() {
      return this.field584;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-386482167"
   )
   int method647() {
      return this.field582;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class46)) {
         return false;
      } else {
         class46 var2 = (class46)var1;
         return super.field422 == var2.field422 && var2.field413 == super.field413?this.field584 == var2.field584 && var2.field582 == this.field582:false;
      }
   }

   public int hashCode() {
      return super.field422 | super.field413 << 8 | this.field584 << 16 | this.field582 << 24;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Lly;",
      garbageValue = "2093977496"
   )
   static SpritePixels method666() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class332.field3995;
      var0.maxHeight = class332.field3991;
      var0.offsetX = class332.field3990[0];
      var0.offsetY = class332.offsetsY[0];
      var0.width = Varbit.field3539[0];
      var0.height = BoundingBox2D.field242[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = class332.spritePixels[0];
      var0.pixels = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.pixels[var3] = class332.field3994[var2[var3] & 255];
      }

      class151.method3208();
      return var0;
   }
}
