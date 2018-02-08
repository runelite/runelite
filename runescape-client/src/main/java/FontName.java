import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("FontName")
public class FontName {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   @Export("FontName_plain11")
   public static final FontName FontName_plain11;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   @Export("FontName_plain12")
   public static final FontName FontName_plain12;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   @Export("FontName_bold12")
   public static final FontName FontName_bold12;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   public static final FontName field3750;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   public static final FontName field3754;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   public static final FontName field3752;
   @ObfuscatedName("t")
   final String field3753;
   @ObfuscatedName("d")
   String field3749;

   static {
      FontName_plain11 = new FontName("PLAIN11", "p11_full");
      FontName_plain12 = new FontName("PLAIN12", "p12_full");
      FontName_bold12 = new FontName("BOLD12", "b12_full");
      field3750 = new FontName("VERDANA11", "verdana_11pt_regular");
      field3754 = new FontName("VERDANA13", "verdana_13pt_regular");
      field3752 = new FontName("VERDANA15", "verdana_15pt_regular");
   }

   FontName(String var1, String var2) {
      this.field3753 = var1;
      this.field3749 = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[Ljx;",
      garbageValue = "-904482445"
   )
   public static FontName[] method5351() {
      return new FontName[]{FontName_plain11, FontName_bold12, FontName_plain12, field3750, field3754, field3752};
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-109"
   )
   static final int method5350(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
