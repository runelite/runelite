import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public class class127 {
   @ObfuscatedName("pq")
   public static class139 field2086;
   @ObfuscatedName("f")
   static class215 field2087;

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "-87"
   )
   static String method2847(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field560 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field560 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field560 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field560 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field560 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != class40.field878) {
         var3 = "/p=" + class40.field878;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field281 + "/a=" + class110.field1938 + var3 + "/";
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "365126882"
   )
   static final String method2848(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }
}
