import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
public class class280 {
   @ObfuscatedName("a")
   static char[] field3743;
   @ObfuscatedName("w")
   static char[] field3744;
   @ObfuscatedName("e")
   static int[] field3742;

   static {
      field3743 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3743[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3743[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3743[var0] = (char)(var0 + 48 - 52);
      }

      field3743[62] = '+';
      field3743[63] = '/';
      field3744 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3744[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3744[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3744[var0] = (char)(var0 + 48 - 52);
      }

      field3744[62] = '*';
      field3744[63] = '-';
      field3742 = new int[128];

      for(var0 = 0; var0 < field3742.length; ++var0) {
         field3742[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3742[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3742[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3742[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3742;
      field3742[43] = 62;
      var2[42] = 62;
      int[] var1 = field3742;
      field3742[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lib;Lib;Ljava/lang/String;Ljava/lang/String;B)Ljm;",
      garbageValue = "80"
   )
   public static Font method5002(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.getFile(var2);
      int var5 = var0.getChild(var4, var3);
      return class89.method1667(var0, var1, var4, var5);
   }
}
