import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kl")
public class class298 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   public static final class298 field3910;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static final class298 field3911;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static final class298 field3912;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static final class298 field3917;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static final class298 field3914;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static final class298 field3915;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static final class298 field3916;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static final class298 field3920;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   public static final class298 field3918;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -842790413
   )
   public final int field3919;
   @ObfuscatedName("c")
   @Export("identifier")
   final String identifier;

   static {
      field3910 = new class298(8, 0, "", "");
      field3911 = new class298(2, 1, "", "");
      field3912 = new class298(4, 2, "", "");
      field3917 = new class298(7, 3, "", "");
      field3914 = new class298(5, 4, "", "");
      field3915 = new class298(1, 5, "", "");
      field3916 = new class298(3, 6, "", "");
      field3920 = new class298(0, 7, "", "");
      field3918 = new class298(6, -1, "", "", true, new class298[]{field3910, field3911, field3912, field3914, field3917});
   }

   class298(int var1, int var2, String var3, String var4) {
      this.field3919 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lkl;)V"
   )
   class298(int var1, int var2, String var3, String var4, boolean var5, class298[] var6) {
      this.field3919 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
