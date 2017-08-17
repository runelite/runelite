import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
public class class290 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   public static final class290 field3841;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   static final class290 field3837;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   static final class290 field3838;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   static final class290 field3839;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   static final class290 field3840;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   static final class290 field3846;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   static final class290 field3842;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   static final class290 field3845;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   public static final class290 field3844;
   @ObfuscatedName("o")
   @Export("identifier")
   final String identifier;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 619767457
   )
   public final int field3836;

   static {
      field3841 = new class290(6, 0, "", "");
      field3837 = new class290(8, 1, "", "");
      field3838 = new class290(7, 2, "", "");
      field3839 = new class290(3, 3, "", "");
      field3840 = new class290(2, 4, "", "");
      field3846 = new class290(4, 5, "", "");
      field3842 = new class290(5, 6, "", "");
      field3845 = new class290(1, 7, "", "");
      field3844 = new class290(0, -1, "", "", true, new class290[]{field3841, field3837, field3838, field3840, field3839});
   }

   class290(int var1, int var2, String var3, String var4) {
      this.field3836 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lkd;)V"
   )
   class290(int var1, int var2, String var3, String var4, boolean var5, class290[] var6) {
      this.field3836 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
