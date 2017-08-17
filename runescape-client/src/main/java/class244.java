import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
public class class244 extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static NodeCache field3304;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   static SpritePixels field3300;
   @ObfuscatedName("f")
   public boolean field3305;

   static {
      field3304 = new NodeCache(64);
   }

   class244() {
      this.field3305 = false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfb;IB)V",
      garbageValue = "7"
   )
   void method4347(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3305 = true;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfb;B)V",
      garbageValue = "27"
   )
   void method4334(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4347(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lfb;Ljava/lang/String;I)I",
      garbageValue = "1132162893"
   )
   public static int method4348(Buffer var0, String var1) {
      int var2 = var0.offset;
      byte[] var3 = class23.method182(var1);
      var0.putShortSmart(var3.length);
      var0.offset += class266.field3648.compress(var3, 0, var3.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }
}
