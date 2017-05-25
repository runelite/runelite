import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
public class class251 extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 240748743
   )
   public int field3381;
   @ObfuscatedName("h")
   public static NodeCache field3382;
   @ObfuscatedName("u")
   char field3383;
   @ObfuscatedName("v")
   boolean field3384;
   @ObfuscatedName("g")
   public String field3385;
   @ObfuscatedName("i")
   public static IndexDataBase field3386;

   class251() {
      this.field3384 = true;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "32"
   )
   void method4493(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4497(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "673858695"
   )
   public boolean method4495() {
      return this.field3383 == 115;
   }

   static {
      field3382 = new NodeCache(64);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "0"
   )
   void method4497(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3383 = class212.method3989(var1.readByte());
      } else if(var2 == 2) {
         this.field3381 = var1.readInt();
      } else if(var2 == 4) {
         this.field3384 = false;
      } else if(var2 == 5) {
         this.field3385 = var1.readString();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "6228089"
   )
   void method4503() {
   }
}
