import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public final class class49 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 224112211
   )
   public static int field443;
   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static Widget field442;

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-276077556"
   )
   static final String method1016(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class50.getColTags(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class50.getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class50.getColTags(16776960) + var1 + "</col>");
   }
}
