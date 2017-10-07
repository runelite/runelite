import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
public class class252 extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static NodeCache field3395;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3397;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   IterableHashTable field3394;

   static {
      field3395 = new NodeCache(64);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfg;II)V",
      garbageValue = "2087551226"
   )
   void method4567(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3394 = class41.method590(var1, this.field3394);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "695275878"
   )
   public int method4550(int var1, int var2) {
      return FileSystem.method4214(this.field3394, var1, var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "2"
   )
   public String method4551(int var1, String var2) {
      return class85.method1769(this.field3394, var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "5703"
   )
   void method4547() {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfg;B)V",
      garbageValue = "84"
   )
   void method4555(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4567(var1, var2);
      }
   }
}
