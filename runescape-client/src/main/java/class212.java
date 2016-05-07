import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public class class212 {
   @ObfuscatedName("d")
   static final class212 field3144 = new class212(6, 4, "", "");
   @ObfuscatedName("j")
   static final class212 field3145 = new class212(5, 1, "", "");
   @ObfuscatedName("p")
   static final class212 field3146 = new class212(4, 2, "", "");
   @ObfuscatedName("x")
   static final class212 field3147 = new class212(2, 3, "", "");
   @ObfuscatedName("s")
   public static final class212 field3148 = new class212(1, 0, "", "");
   @ObfuscatedName("u")
   static final class212 field3149 = new class212(3, 5, "", "");
   @ObfuscatedName("o")
   static final class212 field3150 = new class212(7, 6, "", "");
   @ObfuscatedName("b")
   static final class212 field3151 = new class212(8, 7, "", "");
   @ObfuscatedName("k")
   public static final class212 field3152;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 425481425
   )
   public final int field3153;
   @ObfuscatedName("l")
   final String field3154;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lclass212;)V",
      garbageValue = "0"
   )
   class212(int var1, int var2, String var3, String var4, boolean var5, class212[] var6) {
      this.field3153 = var1;
      this.field3154 = var4;
   }

   public String toString() {
      return this.field3154;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;)V",
      garbageValue = "1"
   )
   class212(int var1, int var2, String var3, String var4) {
      this.field3153 = var1;
      this.field3154 = var4;
   }

   static {
      field3152 = new class212(0, -1, "", "", true, new class212[]{field3148, field3145, field3146, field3144, field3147});
   }
}
