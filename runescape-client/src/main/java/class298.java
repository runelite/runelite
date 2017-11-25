import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
public class class298 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   public static final class298 field3916;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   static final class298 field3907;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   static final class298 field3909;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   static final class298 field3910;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   static final class298 field3911;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   static final class298 field3912;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   static final class298 field3913;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   static final class298 field3908;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lku;"
   )
   public static final class298 field3915;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 443107057
   )
   public final int field3917;
   @ObfuscatedName("l")
   @Export("identifier")
   final String identifier;

   static {
      field3916 = new class298(7, 0, "", "");
      field3907 = new class298(8, 1, "", "");
      field3909 = new class298(0, 2, "", "");
      field3910 = new class298(5, 3, "", "");
      field3911 = new class298(1, 4, "", "");
      field3912 = new class298(3, 5, "", "");
      field3913 = new class298(6, 6, "", "");
      field3908 = new class298(4, 7, "", "");
      field3915 = new class298(2, -1, "", "", true, new class298[]{field3916, field3907, field3909, field3911, field3910});
   }

   class298(int var1, int var2, String var3, String var4) {
      this.field3917 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lku;)V"
   )
   class298(int var1, int var2, String var3, String var4, boolean var5, class298[] var6) {
      this.field3917 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
