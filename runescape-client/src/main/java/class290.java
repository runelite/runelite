import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
public class class290 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final class290 field3872;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   static final class290 field3866;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   static final class290 field3871;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   static final class290 field3865;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   static final class290 field3876;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   static final class290 field3870;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   static final class290 field3869;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   static final class290 field3875;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final class290 field3873;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -557331373
   )
   public final int field3874;
   @ObfuscatedName("z")
   @Export("identifier")
   final String identifier;

   static {
      field3872 = new class290(3, 0, "", "");
      field3866 = new class290(7, 1, "", "");
      field3871 = new class290(0, 2, "", "");
      field3865 = new class290(8, 3, "", "");
      field3876 = new class290(2, 4, "", "");
      field3870 = new class290(1, 5, "", "");
      field3869 = new class290(4, 6, "", "");
      field3875 = new class290(6, 7, "", "");
      field3873 = new class290(5, -1, "", "", true, new class290[]{field3872, field3866, field3871, field3876, field3865});
   }

   class290(int var1, int var2, String var3, String var4) {
      this.field3874 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lkp;)V"
   )
   class290(int var1, int var2, String var3, String var4, boolean var5, class290[] var6) {
      this.field3874 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
