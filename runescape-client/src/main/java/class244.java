import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public class class244 extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   static NodeCache field3303;
   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Widget field3302;
   @ObfuscatedName("x")
   public boolean field3301;

   static {
      field3303 = new NodeCache(64);
   }

   class244() {
      this.field3301 = false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfw;II)V",
      garbageValue = "-1230219673"
   )
   void method4301(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3301 = true;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfw;I)V",
      garbageValue = "1723477205"
   )
   void method4300(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4301(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lim;I)V",
      garbageValue = "1849099308"
   )
   public static void method4307(IndexDataBase var0) {
      class95.field1464 = var0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "15"
   )
   static final int method4299(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + var2 / 2 + (var0 / 4 << 10);
      return var3;
   }
}
