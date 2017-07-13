import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("n")
   boolean field824;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 246644215
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -22027933
   )
   @Export("owner")
   int owner;

   WidgetNode() {
      this.field824 = false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;S)V",
      garbageValue = "610"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class18.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-15"
   )
   static int method1091() {
      return 9;
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1470626583"
   )
   static String method1089(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class8.sessionToken != null) {
         var3 = "/p=" + class8.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + class25.field371 + var3 + "/";
   }
}
