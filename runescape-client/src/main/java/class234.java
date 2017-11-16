import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
public class class234 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field3210;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)[Lit;",
      garbageValue = "1054329665"
   )
   static class246[] method4092() {
      return new class246[]{class246.field3326, class246.field3329, class246.field3328};
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-2119727416"
   )
   static final String method4091(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class222.getColTags(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class222.getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class222.getColTags(16776960) + var1 + "</col>");
   }
}
