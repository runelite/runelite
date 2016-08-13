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
      int var1 = var0.length();
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = 42;
      }

      String var4 = new String(var2);
      return var4;
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1267073377"
   )
   static String method3023(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field297 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field297 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field297 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field297 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field297 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class48.field1097 != null) {
         var3 = "/p=" + class48.field1097;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field326 + "/a=" + class133.field2112 + var3 + "/";
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1046110870"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class47.method1008();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field349 = 0;
            Client.field411 = 0;
            Client.field308 = 0;
         }

         if(var0 != 20 && var0 != 40 && class52.field1153 != null) {
            class52.field1153.method3131();
            class52.field1153 = null;
         }

         if(Client.gameState == 25) {
            Client.field527 = 0;
            Client.field342 = 0;
            Client.field350 = 1;
            Client.field493 = 0;
            Client.field534 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class141.method3074(class107.canvas, XClanMember.field644, Client.field451, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class141.method3074(class107.canvas, XClanMember.field644, Client.field451, false, 4);
            } else {
               ChatMessages.method226();
            }
         } else {
            class141.method3074(class107.canvas, XClanMember.field644, Client.field451, true, 0);
         }

         Client.gameState = var0;
      }

   }
}
