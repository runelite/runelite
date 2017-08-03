import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
public class class251 extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   static NodeCache field3366;
   @ObfuscatedName("bl")
   static String field3368;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static IndexDataBase field3365;
   @ObfuscatedName("x")
   char field3367;
   @ObfuscatedName("f")
   boolean field3370;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1827197167
   )
   public int field3371;
   @ObfuscatedName("e")
   public String field3369;

   static {
      field3366 = new NodeCache(64);
   }

   class251() {
      this.field3370 = true;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfw;II)V",
      garbageValue = "-245270070"
   )
   void method4403(Buffer var1, int var2) {
      if(var2 == 1) {
         byte var4 = var1.readByte();
         int var5 = var4 & 255;
         if(var5 == 0) {
            throw new IllegalArgumentException("");
         }

         if(var5 >= 128 && var5 < 160) {
            char var6 = class266.field3645[var5 - 128];
            if(var6 == 0) {
               var6 = 63;
            }

            var5 = var6;
         }

         char var3 = (char)var5;
         this.field3367 = var3;
      } else if(var2 == 2) {
         this.field3371 = var1.readInt();
      } else if(var2 == 4) {
         this.field3370 = false;
      } else if(var2 == 5) {
         this.field3369 = var1.readString();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-51"
   )
   public boolean method4404() {
      return this.field3367 == 115;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1561106484"
   )
   void method4416() {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfw;I)V",
      garbageValue = "-758159836"
   )
   void method4402(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4403(var1, var2);
      }
   }
}
