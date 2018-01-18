import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
public class class263 extends CacheableNode {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static NodeCache field3485;
   @ObfuscatedName("u")
   static int[] field3483;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   IterableHashTable field3482;

   static {
      field3485 = new NodeCache(64);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method4634() {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgv;B)V",
      garbageValue = "126"
   )
   void method4653(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4636(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgv;II)V",
      garbageValue = "564587332"
   )
   void method4636(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3482 = class18.readStringIntParameters(var1, this.field3482);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "11"
   )
   public int method4637(int var1, int var2) {
      return GrandExchangeOffer.method113(this.field3482, var1, var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1322981991"
   )
   public String method4638(int var1, String var2) {
      return class239.method4279(this.field3482, var1, var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-761825193"
   )
   public static int method4654(int var0) {
      return var0 >> 17 & 7;
   }
}
