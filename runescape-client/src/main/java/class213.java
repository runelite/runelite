import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
public class class213 {
   @ObfuscatedName("d")
   public static char[] field3144 = new char[64];
   @ObfuscatedName("c")
   static char[] field3145;
   @ObfuscatedName("n")
   static int[] field3146;
   @ObfuscatedName("au")
   static IndexData field3150;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3144[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3144[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3144[var0] = (char)(var0 + 48 - 52);
      }

      field3144[62] = 43;
      field3144[63] = 47;
      field3145 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3145[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3145[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3145[var0] = (char)(var0 + 48 - 52);
      }

      field3145[62] = 42;
      field3145[63] = 45;
      field3146 = new int[128];

      for(var0 = 0; var0 < field3146.length; ++var0) {
         field3146[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3146[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3146[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3146[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3146;
      field3146[43] = 62;
      var2[42] = 62;
      int[] var1 = field3146;
      field3146[47] = 63;
      var1[45] = 63;
   }

   class213() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "164240564"
   )
   static String method4037(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }
}
