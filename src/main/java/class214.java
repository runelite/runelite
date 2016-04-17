import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class214 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 7893231178717289103L
   )
   public final long field3151;
   @ObfuscatedName("y")
   String field3152;
   @ObfuscatedName("d")
   public final class220 field3153;
   @ObfuscatedName("c")
   String field3154;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1827390475
   )
   public final int field3155;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-50"
   )
   public String method4033() {
      return this.field3154;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "8"
   )
   public String method4034() {
      return this.field3152;
   }

   class214(class119 var1, byte var2, int var3) {
      this.field3154 = var1.method2621();
      this.field3152 = var1.method2621();
      this.field3155 = var1.method2615();
      this.field3151 = var1.method2619();
      int var4 = var1.method2618();
      int var5 = var1.method2618();
      this.field3153 = new class220();
      this.field3153.method4075(2);
      this.field3153.method4081(var2);
      this.field3153.field3171 = var4;
      this.field3153.field3172 = var5;
      this.field3153.field3169 = 0;
      this.field3153.field3174 = 0;
      this.field3153.field3170 = var3;
   }
}
