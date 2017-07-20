import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class152 extends RuntimeException {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1165583727
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("c")
   public static Applet field2177;
   @ObfuscatedName("o")
   public static String field2178;
   @ObfuscatedName("u")
   String field2180;
   @ObfuscatedName("g")
   Throwable field2182;

   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1887453152"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            CombatInfoListHolder.clientInstance.method838();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field946 = 0;
            Client.field949 = 0;
         }

         if(var0 != 20 && var0 != 40 && class56.field680 != null) {
            class56.field680.close();
            class56.field680 = null;
         }

         if(Client.gameState == 25) {
            Client.field974 = 0;
            Client.field970 = 0;
            Client.field971 = 1;
            Client.field972 = 0;
            Client.field1024 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class12.method56(class27.field387, class271.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class12.method56(class27.field387, class271.indexSprites, false, 4);
            } else {
               Friend.method1039();
            }
         } else {
            class12.method56(class27.field387, class271.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }
}
