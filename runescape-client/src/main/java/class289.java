import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
public class class289 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   public static final class289 field3844;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   static final class289 field3836;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   static final class289 field3839;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   static final class289 field3838;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   static final class289 field3835;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   static final class289 field3837;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   static final class289 field3841;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   static final class289 field3842;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   public static final class289 field3843;
   @ObfuscatedName("g")
   @Export("identifier")
   final String identifier;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1199146221
   )
   public final int field3840;

   static {
      field3844 = new class289(5, 0, "", "");
      field3836 = new class289(6, 1, "", "");
      field3839 = new class289(3, 2, "", "");
      field3838 = new class289(1, 3, "", "");
      field3835 = new class289(2, 4, "", "");
      field3837 = new class289(7, 5, "", "");
      field3841 = new class289(0, 6, "", "");
      field3842 = new class289(8, 7, "", "");
      field3843 = new class289(4, -1, "", "", true, new class289[]{field3844, field3836, field3839, field3835, field3838});
   }

   class289(int var1, int var2, String var3, String var4) {
      this.field3840 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lke;)V"
   )
   class289(int var1, int var2, String var3, String var4, boolean var5, class289[] var6) {
      this.field3840 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
