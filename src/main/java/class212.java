import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class212 {
   @ObfuscatedName("k")
   static final class212 field3140 = new class212(6, 5, "", "");
   @ObfuscatedName("p")
   static final class212 field3141 = new class212(3, 7, "", "");
   @ObfuscatedName("c")
   static final class212 field3142 = new class212(5, 3, "", "");
   @ObfuscatedName("y")
   static final class212 field3143 = new class212(1, 4, "", "");
   @ObfuscatedName("a")
   public static final class212 field3144 = new class212(4, 0, "", "");
   @ObfuscatedName("r")
   static final class212 field3145 = new class212(2, 6, "", "");
   @ObfuscatedName("e")
   final String field3146;
   @ObfuscatedName("q")
   public static final class212 field3147;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1019105003
   )
   public final int field3148;
   @ObfuscatedName("d")
   static final class212 field3149 = new class212(0, 2, "", "");
   @ObfuscatedName("w")
   static final class212 field3150 = new class212(8, 1, "", "");

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;)V",
      garbageValue = "4"
   )
   class212(int var1, int var2, String var3, String var4) {
      this.field3148 = var1;
      this.field3146 = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lclass212;)V",
      garbageValue = "7"
   )
   class212(int var1, int var2, String var3, String var4, boolean var5, class212[] var6) {
      this.field3148 = var1;
      this.field3146 = var4;
   }

   public String toString() {
      return this.field3146;
   }

   static {
      field3147 = new class212(7, -1, "", "", true, new class212[]{field3144, field3150, field3149, field3143, field3142});
   }
}
