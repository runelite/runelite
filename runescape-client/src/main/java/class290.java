import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kj")
public class class290 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   public static final class290 field3869;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   static final class290 field3876;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   static final class290 field3875;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   static final class290 field3870;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   static final class290 field3871;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   static final class290 field3867;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   static final class290 field3873;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   static final class290 field3874;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   public static final class290 field3872;
   @ObfuscatedName("y")
   @Export("identifier")
   final String identifier;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 656532019
   )
   public final int field3868;

   static {
      field3869 = new class290(3, 0, "", "");
      field3876 = new class290(0, 1, "", "");
      field3875 = new class290(4, 2, "", "");
      field3870 = new class290(6, 3, "", "");
      field3871 = new class290(1, 4, "", "");
      field3867 = new class290(7, 5, "", "");
      field3873 = new class290(8, 6, "", "");
      field3874 = new class290(2, 7, "", "");
      field3872 = new class290(5, -1, "", "", true, new class290[]{field3869, field3876, field3875, field3871, field3870});
   }

   class290(int var1, int var2, String var3, String var4) {
      this.field3868 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lkj;)V"
   )
   class290(int var1, int var2, String var3, String var4, boolean var5, class290[] var6) {
      this.field3868 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
