import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class215 {
   @ObfuscatedName("l")
   public static final class215 field3190 = new class215(5, 0, "", "");
   @ObfuscatedName("h")
   static final class215 field3191 = new class215(8, 4, "", "");
   @ObfuscatedName("r")
   static final class215 field3192 = new class215(7, 2, "", "");
   @ObfuscatedName("e")
   static final class215 field3193 = new class215(0, 3, "", "");
   @ObfuscatedName("g")
   static final class215 field3194 = new class215(1, 1, "", "");
   @ObfuscatedName("s")
   static final class215 field3195 = new class215(2, 5, "", "");
   @ObfuscatedName("k")
   static final class215 field3196 = new class215(3, 6, "", "");
   @ObfuscatedName("u")
   static final class215 field3197 = new class215(4, 7, "", "");
   @ObfuscatedName("n")
   public static final class215 field3198;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1895180237
   )
   public final int field3199;
   @ObfuscatedName("m")
   final String field3200;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "68"
   )
   public static int method4089(int var0) {
      return var0 >> 11 & 63;
   }

   class215(int var1, int var2, String var3, String var4, boolean var5, class215[] var6) {
      this.field3199 = var1;
      this.field3200 = var4;
   }

   public String toString() {
      return this.field3200;
   }

   class215(int var1, int var2, String var3, String var4) {
      this.field3199 = var1;
      this.field3200 = var4;
   }

   static {
      field3198 = new class215(6, -1, "", "", true, new class215[]{field3190, field3194, field3192, field3191, field3193});
   }
}
