import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class164 {
   @ObfuscatedName("r")
   static char[] field2704;
   @ObfuscatedName("x")
   public static char[] field2705 = new char[64];
   @ObfuscatedName("j")
   static int[] field2709;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2705[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2705[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2705[var0] = (char)(var0 + 48 - 52);
      }

      field2705[62] = 43;
      field2705[63] = 47;
      field2704 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2704[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2704[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2704[var0] = (char)(var0 + 48 - 52);
      }

      field2704[62] = 42;
      field2704[63] = 45;
      field2709 = new int[128];

      for(var0 = 0; var0 < field2709.length; ++var0) {
         field2709[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2709[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2709[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2709[var0] = var0 - 48 + 52;
      }

      int[] var2 = field2709;
      field2709[43] = 62;
      var2[42] = 62;
      int[] var1 = field2709;
      field2709[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILclass137;Lclass171;I)V",
      garbageValue = "1382873982"
   )
   static void method3221(int var0, class137 var1, class171 var2) {
      byte[] var3 = null;
      Deque var4 = class173.field2769;
      synchronized(class173.field2769) {
         for(class172 var5 = (class172)class173.field2769.method3850(); var5 != null; var5 = (class172)class173.field2769.method3852()) {
            if((long)var0 == var5.hash && var5.field2762 == var1 && var5.field2764 == 0) {
               var3 = var5.field2763;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3368(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2913(var0);
         var2.method3368(var1, var0, var8, true);
      }
   }
}
