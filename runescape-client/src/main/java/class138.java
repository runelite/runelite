import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class138 {
   @ObfuscatedName("g")
   static File field2137;
   @ObfuscatedName("l")
   static boolean field2138 = false;
   @ObfuscatedName("bv")
   static class171 field2139;
   @ObfuscatedName("i")
   static int[] field2141;
   @ObfuscatedName("r")
   static Hashtable field2144 = new Hashtable(16);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "80"
   )
   public static String method3018(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = 42;
      }

      String var1 = new String(var3);
      return var1;
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1267073377"
   )
   static String method3023(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(client.field297 == 1) {
         var0 = var0 + "-wtrc";
      } else if(client.field297 == 2) {
         var0 = var0 + "-wtqa";
      } else if(client.field297 == 3) {
         var0 = var0 + "-wtwip";
      } else if(client.field297 == 5) {
         var0 = var0 + "-wti";
      } else if(client.field297 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class48.field1097 != null) {
         var3 = "/p=" + class48.field1097;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + client.field326 + "/a=" + class133.field2112 + var3 + "/";
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1046110870"
   )
   @Export("setGameState")
   static void method3024(int var0) {
      if(var0 != client.field303) {
         if(client.field303 == 0) {
            class47.method1008();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            client.field349 = 0;
            client.field411 = 0;
            client.field308 = 0;
         }

         if(var0 != 20 && var0 != 40 && class52.field1153 != null) {
            class52.field1153.method3131();
            class52.field1153 = null;
         }

         if(client.field303 == 25) {
            client.field527 = 0;
            client.field342 = 0;
            client.field350 = 1;
            client.field493 = 0;
            client.field534 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class141.method3074(class107.field1867, class25.field644, client.field451, true, client.field303 == 11?4:0);
            } else if(var0 == 11) {
               class141.method3074(class107.field1867, class25.field644, client.field451, false, 4);
            } else {
               class19.method226();
            }
         } else {
            class141.method3074(class107.field1867, class25.field644, client.field451, true, 0);
         }

         client.field303 = var0;
      }
   }
}
