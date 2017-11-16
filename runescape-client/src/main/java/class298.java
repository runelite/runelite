import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kz")
public class class298 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   public static final class298 field3918;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static final class298 field3909;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static final class298 field3916;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static final class298 field3911;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static final class298 field3912;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static final class298 field3913;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static final class298 field3914;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static final class298 field3915;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   public static final class298 field3908;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1123407387
   )
   public final int field3919;
   @ObfuscatedName("d")
   @Export("identifier")
   final String identifier;

   static {
      field3918 = new class298(0, 0, "", "");
      field3909 = new class298(5, 1, "", "");
      field3916 = new class298(3, 2, "", "");
      field3911 = new class298(8, 3, "", "");
      field3912 = new class298(2, 4, "", "");
      field3913 = new class298(1, 5, "", "");
      field3914 = new class298(7, 6, "", "");
      field3915 = new class298(6, 7, "", "");
      field3908 = new class298(4, -1, "", "", true, new class298[]{field3918, field3909, field3916, field3912, field3911});
   }

   class298(int var1, int var2, String var3, String var4) {
      this.field3919 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lkz;)V"
   )
   class298(int var1, int var2, String var3, String var4, boolean var5, class298[] var6) {
      this.field3919 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
