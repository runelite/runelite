import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("la")
public class class317 {
   @ObfuscatedName("d")
   public static char[] field3917;
   @ObfuscatedName("z")
   static char[] field3915;
   @ObfuscatedName("n")
   static int[] field3918;

   static {
      field3917 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3917[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3917[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3917[var0] = (char)(var0 + 48 - 52);
      }

      field3917[62] = '+';
      field3917[63] = '/';
      field3915 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3915[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3915[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3915[var0] = (char)(var0 + 48 - 52);
      }

      field3915[62] = '*';
      field3915[63] = '-';
      field3918 = new int[128];

      for(var0 = 0; var0 < field3918.length; ++var0) {
         field3918[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3918[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3918[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3918[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3918;
      field3918[43] = 62;
      var2[42] = 62;
      int[] var1 = field3918;
      field3918[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(Lbd;III)V",
      garbageValue = "-2118157310"
   )
   static void method5715(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class270.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1173 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1175 = 0;
         }

         if(var3 == 2) {
            var0.field1175 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class270.getAnimation(var1).forcedPriority >= class270.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1173 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1175 = 0;
         var0.field1198 = var0.queueSize;
      }

   }
}
