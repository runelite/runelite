import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
public class class290 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   public static final class290 field3841;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   static final class290 field3835;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   static final class290 field3837;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   static final class290 field3838;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   static final class290 field3839;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   static final class290 field3844;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   static final class290 field3836;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   static final class290 field3842;
   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   public static final class290 field3843;
   @ObfuscatedName("d")
   @Export("identifier")
   final String identifier;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -189736661
   )
   public final int field3845;

   static {
      field3841 = new class290(8, 0, "", "");
      field3835 = new class290(0, 1, "", "");
      field3837 = new class290(4, 2, "", "");
      field3838 = new class290(3, 3, "", "");
      field3839 = new class290(5, 4, "", "");
      field3844 = new class290(6, 5, "", "");
      field3836 = new class290(1, 6, "", "");
      field3842 = new class290(7, 7, "", "");
      field3843 = new class290(2, -1, "", "", true, new class290[]{field3841, field3835, field3837, field3839, field3838});
   }

   class290(int var1, int var2, String var3, String var4) {
      this.field3845 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lkt;)V"
   )
   class290(int var1, int var2, String var3, String var4, boolean var5, class290[] var6) {
      this.field3845 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
