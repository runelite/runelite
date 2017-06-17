import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
public class class269 {
   @ObfuscatedName("p")
   static char[] field3678;
   @ObfuscatedName("m")
   static char[] field3679;
   @ObfuscatedName("e")
   static int[] field3680;
   @ObfuscatedName("rr")
   static short[] field3681;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-2072506029"
   )
   public static final boolean method4758(String var0, String var1, String var2, String var3) {
      return var0 != null && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   static {
      field3678 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3678[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3678[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3678[var0] = (char)(var0 + 48 - 52);
      }

      field3678[62] = 43;
      field3678[63] = 47;
      field3679 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3679[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3679[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3679[var0] = (char)(var0 + 48 - 52);
      }

      field3679[62] = 42;
      field3679[63] = 45;
      field3680 = new int[128];

      for(var0 = 0; var0 < field3680.length; ++var0) {
         field3680[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3680[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3680[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3680[var0] = var0 - 48 + 52;
      }

      int[] var1 = field3680;
      field3680[43] = 62;
      var1[42] = 62;
      int[] var2 = field3680;
      field3680[47] = 63;
      var2[45] = 63;
   }
}
