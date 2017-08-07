import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class22 extends class28 {
   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   static RSSocket field341;
   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   static IndexData field342;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = 1240498665
   )
   static int field347;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfh;Lfh;B)V",
      garbageValue = "-50"
   )
   void method161(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field508.field507) {
         throw new IllegalStateException("");
      } else {
         super.field402 = var2.readUnsignedByte();
         super.field407 = var2.readUnsignedByte();
         super.field411 = var2.readUnsignedShort();
         super.field409 = var2.readUnsignedShort();
         super.field404 = var2.readUnsignedShort();
         super.field405 = var2.readUnsignedShort();
         super.field407 = Math.min(super.field407, 4);
         super.field408 = new short[1][64][64];
         super.field403 = new short[super.field407][64][64];
         super.field410 = new byte[super.field407][64][64];
         super.field413 = new byte[super.field407][64][64];
         super.field412 = new class31[super.field407][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field500.field499) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field404 && var5 == super.field405) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method225(var6, var7, var1);
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
         return super.field404 == var2.field404 && super.field405 == var2.field405;
      }
   }

   public int hashCode() {
      return super.field404 | super.field405 << 8;
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-33"
   )
   static final void method167() {
      for(GraphicsObject var0 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var0.level == class29.plane && !var0.finished) {
            if(Client.gameCycle >= var0.startCycle) {
               var0.method1687(Client.field1020);
               if(var0.finished) {
                  var0.unlink();
               } else {
                  class84.region.method2722(var0.level, var0.x, var0.y, var0.height, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }
}
