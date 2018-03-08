import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kx")
public class class303 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   public static final class303 field3850;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   public static final class303 field3846;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   public static final class303 field3847;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1605633609
   )
   @Export("revision")
   public static int revision;

   static {
      field3850 = new class303();
      field3846 = new class303();
      field3847 = new class303();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "45"
   )
   public static String method5404(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 131) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != '.' && var5 != '?' && var5 != '!') {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
