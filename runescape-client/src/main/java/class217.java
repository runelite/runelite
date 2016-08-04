import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
public class class217 {
   @ObfuscatedName("e")
   String field3204;
   @ObfuscatedName("h")
   String field3205;
   @ObfuscatedName("r")
   public final class223 field3206;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1507614503
   )
   public final int field3208;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -4699190258343518181L
   )
   public final long field3209;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1795962116"
   )
   public String method4101() {
      return this.field3205;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "2037462623"
   )
   public String method4102() {
      return this.field3204;
   }

   class217(class122 var1, byte var2, int var3) {
      this.field3204 = var1.method2663();
      this.field3205 = var1.method2663();
      this.field3208 = var1.method2635();
      this.field3209 = var1.method2649();
      int var4 = var1.method2620();
      int var5 = var1.method2620();
      this.field3206 = new class223();
      this.field3206.method4149(2);
      this.field3206.method4150(var2);
      this.field3206.field3216 = var4;
      this.field3206.field3214 = var5;
      this.field3206.field3218 = 0;
      this.field3206.field3217 = 0;
      this.field3206.field3215 = var3;
   }
}
