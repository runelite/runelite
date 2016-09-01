import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
public class class109 {
   @ObfuscatedName("i")
   static byte[][][] field1921;
   @ObfuscatedName("bq")
   static class171 field1922;
   @ObfuscatedName("j")
   static int[][] field1923 = new int[128][128];
   @ObfuscatedName("z")
   static int[][] field1924 = new int[128][128];
   @ObfuscatedName("m")
   static int[] field1925 = new int[4096];
   @ObfuscatedName("p")
   static int[] field1926 = new int[4096];
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -1927266639
   )
   @Export("menuWidth")
   static int menuWidth;

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Z",
      garbageValue = "18"
   )
   static boolean method2436(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class10.method123(var0, class127.field2087);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class10.method123(Client.friends[var3].name, class127.field2087)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class10.method123(class48.localPlayer.name, class127.field2087))) {
            return true;
         } else {
            return false;
         }
      }
   }
}
