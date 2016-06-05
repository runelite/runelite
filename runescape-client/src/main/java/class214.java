import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class214 {
   @ObfuscatedName("h")
   String field3155;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 4017095301383608841L
   )
   public final long field3156;
   @ObfuscatedName("g")
   public final class220 field3157;
   @ObfuscatedName("s")
   static class154 field3158;
   @ObfuscatedName("z")
   String field3159;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -731834415
   )
   public final int field3160;
   @ObfuscatedName("dr")
   @Export("region")
   static class86 field3161;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-11"
   )
   public String method3889() {
      return this.field3155;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1800855781"
   )
   public String method3890() {
      return this.field3159;
   }

   class214(class119 var1, byte var2, int var3) {
      this.field3155 = var1.method2476();
      this.field3159 = var1.method2476();
      this.field3160 = var1.method2470();
      this.field3156 = var1.method2474();
      int var4 = var1.method2505();
      int var5 = var1.method2505();
      this.field3157 = new class220();
      this.field3157.method3927(2);
      this.field3157.method3931(var2);
      this.field3157.field3176 = var4;
      this.field3157.field3174 = var5;
      this.field3157.field3171 = 0;
      this.field3157.field3175 = 0;
      this.field3157.field3172 = var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;I)[Lclass80;",
      garbageValue = "-2089484791"
   )
   public static class80[] method3893(class167 var0, String var1, String var2) {
      int var3 = var0.method3236(var1);
      int var4 = var0.method3237(var3, var2);
      return class115.method2409(var0, var3, var4);
   }
}
