import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class214 {
   @ObfuscatedName("p")
   public final class220 field3159;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 4713624296931677749L
   )
   public final long field3160;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1047806493
   )
   public final int field3161;
   @ObfuscatedName("x")
   String field3162;
   @ObfuscatedName("d")
   String field3163;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1234851996"
   )
   public String method3924() {
      return this.field3162;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1271184778"
   )
   public String method3925() {
      return this.field3163;
   }

   class214(class119 var1, byte var2, int var3) {
      this.field3162 = var1.method2500();
      this.field3163 = var1.method2500();
      this.field3161 = var1.method2584();
      this.field3160 = var1.method2498();
      int var4 = var1.method2497();
      int var5 = var1.method2497();
      this.field3159 = new class220();
      this.field3159.method3969(2);
      this.field3159.method3970(var2);
      this.field3159.field3176 = var4;
      this.field3159.field3177 = var5;
      this.field3159.field3174 = 0;
      this.field3159.field3179 = 0;
      this.field3159.field3178 = var3;
   }
}
