import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
public class class279 extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   static IndexDataBase field3549;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field3550;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   IterableHashTable field3551;

   static {
      field3550 = new NodeCache(64);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-49"
   )
   void method4924() {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "-140742979"
   )
   void method4925(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4926(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgp;II)V",
      garbageValue = "-2025757497"
   )
   void method4926(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3551 = class245.readStringIntParameters(var1, this.field3551);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-28"
   )
   public int method4927(int var1, int var2) {
      return class23.method190(this.field3551, var1, var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-48"
   )
   public String method4928(int var1, String var2) {
      return class155.method3172(this.field3551, var1, var2);
   }
}
