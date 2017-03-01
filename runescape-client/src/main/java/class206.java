import java.io.File;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
public class class206 {
   @ObfuscatedName("x")
   public static char[] field3097 = new char[64];
   @ObfuscatedName("n")
   static char[] field3098;
   @ObfuscatedName("m")
   static class178 field3099;
   @ObfuscatedName("y")
   public static File field3100;
   @ObfuscatedName("g")
   static int[] field3101;

   class206() throws Throwable {
      throw new Error();
   }

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3097[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3097[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3097[var0] = (char)(var0 + 48 - 52);
      }

      field3097[62] = 43;
      field3097[63] = 47;
      field3098 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3098[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3098[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3098[var0] = (char)(var0 + 48 - 52);
      }

      field3098[62] = 42;
      field3098[63] = 45;
      field3101 = new int[128];

      for(var0 = 0; var0 < field3101.length; ++var0) {
         field3101[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3101[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3101[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3101[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field3101;
      field3101[43] = 62;
      var2[42] = 62;
      int[] var1 = field3101;
      field3101[47] = 63;
      var1[45] = 63;
   }
}
