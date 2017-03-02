import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public class class138 {
   @ObfuscatedName("l")
   public static class182 field1913;
   @ObfuscatedName("i")
   public static class182 field1914;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1281581675
   )
   public static int field1915 = 0;
   @ObfuscatedName("b")
   public static class182 field1916;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1037126251
   )
   static int field1917;
   @ObfuscatedName("h")
   public static class182 field1918;
   @ObfuscatedName("kf")
   @ObfuscatedGetter(
      intValue = -1510954183
   )
   static int field1919;

   class138() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-227262338"
   )
   static String method2555(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class206.field3089[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class206.field3089[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class206.field3089[(var6 & 15) << 2 | var7 >>> 6]).append(class206.field3089[var7 & 63]);
            } else {
               var3.append(class206.field3089[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class206.field3089[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class47.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method974(var0, var1, var2, var3);
      class47.field924.method2382(var5, (long)var5.id);
      class47.field923.method2531(var5);
      Client.field443 = Client.field470;
   }
}
