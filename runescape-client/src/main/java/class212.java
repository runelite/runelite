import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class212 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -180456041
   )
   public final int field3143;
   @ObfuscatedName("i")
   static final class212 field3144 = new class212(8, 1, "", "");
   @ObfuscatedName("g")
   static final class212 field3145 = new class212(5, 2, "", "");
   @ObfuscatedName("y")
   final String field3146;
   @ObfuscatedName("z")
   static final class212 field3147 = new class212(3, 4, "", "");
   @ObfuscatedName("r")
   static final class212 field3148 = new class212(7, 5, "", "");
   @ObfuscatedName("f")
   static final class212 field3149 = new class212(1, 6, "", "");
   @ObfuscatedName("s")
   static final class212 field3150 = new class212(4, 7, "", "");
   @ObfuscatedName("d")
   public static final class212 field3151;
   @ObfuscatedName("h")
   static final class212 field3152 = new class212(2, 3, "", "");
   @ObfuscatedName("t")
   public static final class212 field3153 = new class212(6, 0, "", "");

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;)V",
      garbageValue = "6"
   )
   class212(int var1, int var2, String var3, String var4) {
      this.field3143 = var1;
      this.field3146 = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lclass212;)V",
      garbageValue = "0"
   )
   class212(int var1, int var2, String var3, String var4, boolean var5, class212[] var6) {
      this.field3143 = var1;
      this.field3146 = var4;
   }

   static {
      field3151 = new class212(0, -1, "", "", true, new class212[]{field3153, field3144, field3145, field3147, field3152});
   }

   public String toString() {
      return this.field3146;
   }
}
