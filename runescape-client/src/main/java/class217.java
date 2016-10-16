import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public class class217 {
   @ObfuscatedName("f")
   static byte[][][] field3197;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 5627867579306111165L
   )
   public final long field3198;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1242704523
   )
   public final int field3199;
   @ObfuscatedName("y")
   String field3200;
   @ObfuscatedName("p")
   String field3201;
   @ObfuscatedName("t")
   public final XGrandExchangeOffer field3202;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "-3307"
   )
   public String method3944() {
      return this.field3200;
   }

   class217(Buffer var1, byte var2, int var3) {
      this.field3200 = var1.method2503();
      this.field3201 = var1.method2503();
      this.field3199 = var1.method2668();
      this.field3198 = var1.method2487();
      int var4 = var1.method2526();
      int var5 = var1.method2526();
      this.field3202 = new XGrandExchangeOffer();
      this.field3202.method4005(2);
      this.field3202.method3990(var2);
      this.field3202.price = var4;
      this.field3202.totalQuantity = var5;
      this.field3202.quantitySold = 0;
      this.field3202.spent = 0;
      this.field3202.itemId = var3;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public String method3948() {
      return this.field3201;
   }
}
