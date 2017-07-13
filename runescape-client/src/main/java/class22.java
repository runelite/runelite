import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class22 extends class28 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;I)V",
      garbageValue = "-1699489909"
   )
   void method159(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field489.field490) {
         throw new IllegalStateException("");
      } else {
         super.field407 = var2.readUnsignedByte();
         super.field404 = var2.readUnsignedByte();
         super.field403 = var2.readUnsignedShort();
         super.field400 = var2.readUnsignedShort();
         super.field401 = var2.readUnsignedShort();
         super.field399 = var2.readUnsignedShort();
         super.field404 = Math.min(super.field404, 4);
         super.field405 = new short[1][64][64];
         super.field410 = new short[super.field404][64][64];
         super.field406 = new byte[super.field404][64][64];
         super.field408 = new byte[super.field404][64][64];
         super.field409 = new class31[super.field404][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field487.field480) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field401 && var5 == super.field399) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method219(var6, var7, var1);
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
         return super.field401 == var2.field401 && super.field399 == var2.field399;
      }
   }

   public int hashCode() {
      return super.field401 | super.field399 << 8;
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1045640485"
   )
   static final void method168(int var0) {
      if(class33.loadWidget(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2772 = 0;
               var3.field2776 = 0;
            }
         }

      }
   }
}
