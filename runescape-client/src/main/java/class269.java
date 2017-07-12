import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class269 {
   @ObfuscatedName("i")
   public static char[] field3684;
   @ObfuscatedName("a")
   static int[] field3685;
   @ObfuscatedName("w")
   static char[] field3687;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "124"
   )
   static int method4863(int var0) {
      MessageNode var1 = (MessageNode)class98.field1546.method3478((long)var0);
      return var1 == null?-1:(var1.next == class98.field1548.field2492?-1:((MessageNode)var1.next).id);
   }

   static {
      field3684 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3684[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3684[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3684[var0] = (char)(var0 + 48 - 52);
      }

      field3684[62] = 43;
      field3684[63] = 47;
      field3687 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3687[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3687[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3687[var0] = (char)(var0 + 48 - 52);
      }

      field3687[62] = 42;
      field3687[63] = 45;
      field3685 = new int[128];

      for(var0 = 0; var0 < field3685.length; ++var0) {
         field3685[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3685[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3685[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3685[var0] = var0 - 48 + 52;
      }

      int[] var1 = field3685;
      field3685[43] = 62;
      var1[42] = 62;
      int[] var2 = field3685;
      field3685[47] = 63;
      var2[45] = 63;
   }
}
