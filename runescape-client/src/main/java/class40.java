import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class40 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   public static final class40 field560;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   public static final class40 field559;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   public static final class40 field558;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   public static final class40 field557;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   public static final class40 field555;
   @ObfuscatedName("n")
   public final String field556;

   static {
      field560 = new class40("details");
      field559 = new class40("compositemap");
      field557 = new class40("compositetexture");
      field558 = new class40("area");
      field555 = new class40("labels");
   }

   class40(String var1) {
      this.field556 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lii;IIB)[Lkd;",
      garbageValue = "-3"
   )
   static SpritePixels[] method576(IndexDataBase var0, int var1, int var2) {
      if(!class178.method3474(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels[] var4 = new SpritePixels[class171.field2347];

         for(int var5 = 0; var5 < class171.field2347; ++var5) {
            SpritePixels var6 = var4[var5] = new SpritePixels();
            var6.maxWidth = class287.field3797;
            var6.maxHeight = class287.field3798;
            var6.offsetX = class271.field3679[var5];
            var6.offsetY = class18.offsetsY[var5];
            var6.width = class287.field3796[var5];
            var6.height = class245.field3324[var5];
            int var7 = var6.height * var6.width;
            byte[] var8 = class274.spritePixels[var5];
            var6.image = new int[var7];

            for(int var9 = 0; var9 < var7; ++var9) {
               var6.image[var9] = Varbit.field3387[var8[var9] & 255];
            }
         }

         Buffer.method3330();
         return var4;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "576338969"
   )
   static void method575() {
      if(class91.field1457 && class91.username != null && class91.username.length() > 0) {
         class91.field1461 = 1;
      } else {
         class91.field1461 = 0;
      }

   }
}
