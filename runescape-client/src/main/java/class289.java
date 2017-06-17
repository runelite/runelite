import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kl")
public class class289 {
   @ObfuscatedName("i")
   static final class289 field3849;
   @ObfuscatedName("m")
   static final class289 field3850;
   @ObfuscatedName("o")
   final String field3851;
   @ObfuscatedName("w")
   static final class289 field3852;
   @ObfuscatedName("p")
   public static final class289 field3853;
   @ObfuscatedName("z")
   static final class289 field3854;
   @ObfuscatedName("j")
   static final class289 field3855;
   @ObfuscatedName("t")
   static final class289 field3856;
   @ObfuscatedName("f")
   public static final class289 field3857;
   @ObfuscatedName("e")
   static final class289 field3858;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1521644589
   )
   public final int field3859;

   class289(int var1, int var2, String var3, String var4, boolean var5, class289[] var6) {
      this.field3859 = var1;
      this.field3851 = var4;
   }

   public String toString() {
      return this.field3851;
   }

   class289(int var1, int var2, String var3, String var4) {
      this.field3859 = var1;
      this.field3851 = var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "599115961"
   )
   static final int method5224(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var2 * (var1 & 16711935) + var3 * (var0 & 16711935) & -16711936) + (var3 * (var0 & '\uff00') + (var1 & '\uff00') * var2 & 16711680) >> 8;
   }

   static {
      field3853 = new class289(8, 0, "", "");
      field3850 = new class289(6, 1, "", "");
      field3858 = new class289(2, 2, "", "");
      field3856 = new class289(1, 3, "", "");
      field3852 = new class289(5, 4, "", "");
      field3854 = new class289(7, 5, "", "");
      field3855 = new class289(0, 6, "", "");
      field3849 = new class289(4, 7, "", "");
      field3857 = new class289(3, -1, "", "", true, new class289[]{field3853, field3850, field3858, field3852, field3856});
   }
}
