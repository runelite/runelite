import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class23 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1728185482"
   )
   static void method190() {
      if(class91.username == null || class91.username.length() <= 0) {
         if(Buffer.preferences.field1231 != null) {
            class91.username = Buffer.preferences.field1231;
            class91.field1357 = true;
         } else {
            class91.field1357 = false;
         }

      }
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1050991303"
   )
   static void method191(int var0) {
      Client.field1030 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      int var1 = Client.isResized?2:1;
      if(var1 == 1) {
         class9.clientInstance.method909(765, 503);
      } else {
         class9.clientInstance.method909(7680, 2160);
      }

      if(Client.gameState >= 25) {
         ScriptVarType.method24();
      }

   }
}
