import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class212 {
   @ObfuscatedName("h")
   static final class212 field3143 = new class212(5, 1, "", "");
   @ObfuscatedName("z")
   static final class212 field3144 = new class212(6, 3, "", "");
   @ObfuscatedName("m")
   static final class212 field3145 = new class212(1, 2, "", "");
   @ObfuscatedName("j")
   public static final class212 field3146 = new class212(8, 0, "", "");
   @ObfuscatedName("c")
   static final class212 field3147 = new class212(3, 7, "", "");
   @ObfuscatedName("e")
   static final class212 field3148 = new class212(7, 5, "", "");
   @ObfuscatedName("i")
   static final class212 field3149 = new class212(0, 6, "", "");
   @ObfuscatedName("x")
   static final class212 field3150 = new class212(4, 4, "", "");
   @ObfuscatedName("n")
   public static final class212 field3151;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1221001403
   )
   public final int field3152;
   @ObfuscatedName("u")
   final String field3153;

   static {
      field3151 = new class212(2, -1, "", "", true, new class212[]{field3146, field3143, field3145, field3150, field3144});
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;)V",
      garbageValue = "8"
   )
   class212(int var1, int var2, String var3, String var4) {
      this.field3152 = var1;
      this.field3153 = var4;
   }

   public String toString() {
      return this.field3153;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lclass212;)V",
      garbageValue = "2"
   )
   class212(int var1, int var2, String var3, String var4, boolean var5, class212[] var6) {
      this.field3152 = var1;
      this.field3153 = var4;
   }
}
