import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class156 extends class283 {
   @ObfuscatedName("m")
   public static String[] field2108;
   @ObfuscatedName("b")
   final boolean field2110;

   public class156(boolean var1) {
      this.field2110 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "1162625146"
   )
   int method3156(ChatPlayer var1, ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field2110?var1.method5183().method5360(var2.method5183()):var2.method5183().method5360(var1.method5183())):this.method5214(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3156((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "36"
   )
   @Export("nextPowerOfTwo")
   public static int nextPowerOfTwo(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1633085108"
   )
   public static int method3161(String var0) {
      return var0.length() + 2;
   }
}
