import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class36 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   static final class36 field477;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   static final class36 field473;
   @ObfuscatedName("n")
   static int[] field475;
   @ObfuscatedName("v")
   static int[] field476;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1922838445
   )
   final int field474;

   static {
      field477 = new class36(0);
      field473 = new class36(1);
   }

   class36(int var1) {
      this.field474 = var1;
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-91"
   )
   static final String method537(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class37.getColTags(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class37.getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class37.getColTags(16776960) + var1 + "</col>");
   }
}
