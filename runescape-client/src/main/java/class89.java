import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public class class89 {
   @ObfuscatedName("m")
   static final BigInteger field1321;
   @ObfuscatedName("p")
   static final BigInteger field1322;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1967424835
   )
   @Export("canvasHeight")
   protected static int canvasHeight;

   static {
      field1321 = new BigInteger("10001", 16);
      field1322 = new BigInteger("9174b0517d68918650804bae6b42e52362ca63013fa4f12a949b4767499fab8663aed7425e9eebc10837598f081c8d6f99b3d3b81367355bf107e7b4f9e2b70f987d89910e00d47391065d8c668d1a3b18f1e54af78755ad0314d655385dcf6cdf9996b7b66b86c6ad54b72b636588d5bdecaebefb0d53a55411f52cb0277cdf", 16);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILhy;I)I",
      garbageValue = "-486971853"
   )
   public static int method1797(int var0, class226 var1) {
      return (var0 << 8) + var1.field2871;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "39"
   )
   static byte[] method1798(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(Lbq;IIIB)V",
      garbageValue = "74"
   )
   static final void method1796(Player var0, int var1, int var2, int var3) {
      if(class48.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.totalLevel == 0) {
               String var5 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = class48.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = WallObject.getColTags(16711680);
               } else if(var9 < -6) {
                  var6 = WallObject.getColTags(16723968);
               } else if(var9 < -3) {
                  var6 = WallObject.getColTags(16740352);
               } else if(var9 < 0) {
                  var6 = WallObject.getColTags(16756736);
               } else if(var9 > 9) {
                  var6 = WallObject.getColTags(65280);
               } else if(var9 > 6) {
                  var6 = WallObject.getColTags(4259584);
               } else if(var9 > 3) {
                  var6 = WallObject.getColTags(8453888);
               } else if(var9 > 0) {
                  var6 = WallObject.getColTags(12648192);
               } else {
                  var6 = WallObject.getColTags(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var10;
            if(Client.itemSelectionState == 1) {
               class60.addMenuEntry("Use", Client.field1118 + " " + "->" + " " + WallObject.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((class228.field2902 & 8) == 8) {
                  class60.addMenuEntry(Client.field1007, Client.field1008 + " " + "->" + " " + WallObject.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(Client.playerOptions[var10] != null) {
                     short var11 = 0;
                     if(Client.playerOptions[var10].equalsIgnoreCase("Attack")) {
                        if(class90.field1327 == Client.field922) {
                           continue;
                        }

                        if(Client.field922 == class90.field1325 || Client.field922 == class90.field1328 && var0.combatLevel > class48.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(class48.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class48.localPlayer.team) {
                              var11 = 2000;
                           } else {
                              var11 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var10]) {
                        var11 = 2000;
                     }

                     boolean var12 = false;
                     var7 = Client.playerMenuTypes[var10] + var11;
                     class60.addMenuEntry(Client.playerOptions[var10], WallObject.getColTags(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < Client.menuOptionCount; ++var10) {
               if(Client.menuTypes[var10] == 23) {
                  Client.menuTargets[var10] = WallObject.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
