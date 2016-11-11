import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
public class class217 {
   @ObfuscatedName("n")
   String field3203;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1675236519
   )
   public final int field3204;
   @ObfuscatedName("e")
   public final XGrandExchangeOffer field3205;
   @ObfuscatedName("g")
   String field3206;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 3672652730536312087L
   )
   public final long field3207;

   class217(Buffer var1, byte var2, int var3) {
      this.field3206 = var1.method2552();
      this.field3203 = var1.method2552();
      this.field3204 = var1.method2546();
      this.field3207 = var1.method2566();
      int var4 = var1.method2549();
      int var5 = var1.method2549();
      this.field3205 = new XGrandExchangeOffer();
      this.field3205.method4028(2);
      this.field3205.method4034(var2);
      this.field3205.price = var4;
      this.field3205.totalQuantity = var5;
      this.field3205.quantitySold = 0;
      this.field3205.spent = 0;
      this.field3205.itemId = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "2133391091"
   )
   public String method3978() {
      return this.field3206;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "42"
   )
   public String method3979() {
      return this.field3203;
   }
}
