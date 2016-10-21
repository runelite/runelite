import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class217 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 3881108106904956555L
   )
   public final long field3192;
   @ObfuscatedName("v")
   String field3193;
   @ObfuscatedName("n")
   public final XGrandExchangeOffer field3194;
   @ObfuscatedName("t")
   String field3195;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 798556549
   )
   public final int field3196;

   class217(Buffer var1, byte var2, int var3) {
      this.field3195 = var1.method2541();
      this.field3193 = var1.method2541();
      this.field3196 = var1.method2535();
      this.field3192 = var1.method2539();
      int var4 = var1.method2538();
      int var5 = var1.method2538();
      this.field3194 = new XGrandExchangeOffer();
      this.field3194.method4065(2);
      this.field3194.method4067(var2);
      this.field3194.price = var4;
      this.field3194.totalQuantity = var5;
      this.field3194.quantitySold = 0;
      this.field3194.spent = 0;
      this.field3194.itemId = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1850095401"
   )
   public String method4027() {
      return this.field3193;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1344503258"
   )
   public String method4029() {
      return this.field3195;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-61"
   )
   public static final boolean method4030() {
      class140 var0 = class140.keyboard;
      synchronized(class140.keyboard) {
         if(class140.field2173 == class140.field2175) {
            return false;
         } else {
            class140.field2161 = class140.field2170[class140.field2173];
            class140.field2163 = class140.field2162[class140.field2173];
            class140.field2173 = class140.field2173 + 1 & 127;
            return true;
         }
      }
   }
}
