import java.io.File;
import java.util.Date;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class158 {
   @ObfuscatedName("j")
   static boolean field2267;
   @ObfuscatedName("f")
   static Hashtable field2265;
   @ObfuscatedName("h")
   static File field2262;

   static {
      field2267 = false;
      field2265 = new Hashtable(16);
   }

   @ObfuscatedName("j")
   public static String method3001(long var0) {
      class183.field2441.setTime(new Date(var0));
      int var2 = class183.field2441.get(7);
      int var3 = class183.field2441.get(5);
      int var4 = class183.field2441.get(2);
      int var5 = class183.field2441.get(1);
      int var6 = class183.field2441.get(11);
      int var7 = class183.field2441.get(12);
      int var8 = class183.field2441.get(13);
      return class183.field2442[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class183.field2443[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(Lbz;IIIB)V",
      garbageValue = "-44"
   )
   static final void method2996(Player var0, int var1, int var2, int var3) {
      if(XGrandExchangeOffer.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.totalLevel == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class34.method465(var0.combatLevel, XGrandExchangeOffer.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var5;
            if(Client.itemSelectionState == 1) {
               DynamicObject.addMenuEntry("Use", Client.field1084 + " " + "->" + " " + Tile.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((class51.field664 & 8) == 8) {
                  DynamicObject.addMenuEntry(Client.field993, Client.field1085 + " " + "->" + " " + Tile.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(Client.field959 == class92.field1424) {
                           continue;
                        }

                        if(Client.field959 == class92.field1422 || Client.field959 == class92.field1426 && var0.combatLevel > XGrandExchangeOffer.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(XGrandExchangeOffer.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == XGrandExchangeOffer.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.playerMenuTypes[var5] + var6;
                     DynamicObject.addMenuEntry(Client.playerOptions[var5], Tile.getColTags(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = Tile.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-2075309812"
   )
   static final String[] method3000(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
