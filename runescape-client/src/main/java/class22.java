import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class22 extends class28 {
   @ObfuscatedName("am")
   static class231 field339;
   @ObfuscatedName("cd")
   @Export("indexTrack1")
   static IndexData indexTrack1;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;I)V",
      garbageValue = "-1134570030"
   )
   void method142(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field501.field509) {
         throw new IllegalStateException("");
      } else {
         super.field410 = var2.readUnsignedByte();
         super.field411 = var2.readUnsignedByte();
         super.field409 = var2.readUnsignedShort();
         super.field417 = var2.readUnsignedShort();
         super.field408 = var2.readUnsignedShort();
         super.field415 = var2.readUnsignedShort();
         super.field411 = Math.min(super.field411, 4);
         super.field412 = new short[1][64][64];
         super.field413 = new short[super.field411][64][64];
         super.field407 = new byte[super.field411][64][64];
         super.field406 = new byte[super.field411][64][64];
         super.field416 = new class31[super.field411][64][64][];
         var3 = var1.readUnsignedByte();
         if(class35.field495.field497 != var3) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field408 && super.field415 == var5) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method227(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return var2.field408 == super.field408 && super.field415 == var2.field415;
      }
   }

   public int hashCode() {
      return super.field408 | super.field415 << 8;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-103"
   )
   public static void method144() {
      PlayerComposition.field2626.reset();
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass210;I)V",
      garbageValue = "-768012209"
   )
   static final void method149(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle + Client.mapScale & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = class136.SINE[var6];
            int var9 = class136.COSINE[var6];
            var8 = var8 * 256 / (Client.mapScaleDelta + 256);
            var9 = var9 * 256 / (Client.mapScaleDelta + 256);
            int var10 = var9 * var2 + var8 * var3 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5118(var10 + var5.field2602 / 2 - var4.maxWidth / 2, var5.field2601 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2602, var5.field2601, var5.field2603, var5.field2605);
            } else {
               var4.method5047(var10 + var5.field2602 / 2 + var0 - var4.maxWidth / 2, var5.field2601 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LWorld;B)V",
      garbageValue = "0"
   )
   static void method153(World var0) {
      if(var0.method1567() != Client.isMembers) {
         Client.isMembers = var0.method1567();
         class46.method658(var0.method1567());
      }

      Client.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class13.field279 = Client.field931 == 0?'ꩊ':var0.id + '鱀';
      XItemContainer.field790 = Client.field931 == 0?443:var0.id + '썐';
      RSSocket.field2290 = class13.field279;
   }
}
