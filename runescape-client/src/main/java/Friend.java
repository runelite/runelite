import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("bc")
   static class184 field147;
   @ObfuscatedName("j")
   boolean field148;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1109862945
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1712852521
   )
   @Export("world")
   int world;
   @ObfuscatedName("y")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("bm")
   static class184 field152;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = 310373979
   )
   static int field153;
   @ObfuscatedName("k")
   @Export("name")
   String name;
   @ObfuscatedName("id")
   static class38 field158;
   @ObfuscatedName("w")
   boolean field159;

   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-895558684"
   )
   static final void method189(String var0) {
      if(null != var0) {
         String var1 = Overlay.method3751(var0, Client.field282);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.friendCount; ++var2) {
               Friend var3 = Client.friends[var2];
               String var4 = var3.name;
               String var5 = Overlay.method3751(var4, Client.field282);
               boolean var6;
               if(null != var0 && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.friendCount;

                  for(int var7 = var2; var7 < Client.friendCount; ++var7) {
                     Client.friends[var7] = Client.friends[1 + var7];
                  }

                  Client.field470 = Client.field462;
                  Client.field321.method3195(114);
                  Client.field321.method2912(class105.method1999(var0));
                  Client.field321.method3097(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIIB)V",
      garbageValue = "109"
   )
   static final void method190(Player var0, int var1, int var2, int var3) {
      if(var0 != VertexNormal.localPlayer) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.field248 == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class10.method128(var0.combatLevel, VertexNormal.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field248 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field525 == 1) {
               class20.addMenuEntry("Use", Client.field431 + " " + "->" + " " + class163.method3157(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field432) {
               if((ItemComposition.field2939 & 8) == 8) {
                  class20.addMenuEntry(Client.field435, Client.field436 + " " + "->" + " " + class163.method3157(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(null != Client.playerOptions[var5]) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(Client.field304 == class40.field810) {
                           continue;
                        }

                        if(Client.field304 == class40.field817 || class40.field818 == Client.field304 && var0.combatLevel > VertexNormal.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(VertexNormal.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == VertexNormal.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriority[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = var6 + Client.field418[var5];
                     class20.addMenuEntry(Client.playerOptions[var5], class163.method3157(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class163.method3157(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BII)I",
      garbageValue = "619619465"
   )
   public static int method191(byte[] var0, int var1) {
      return class119.method2279(var0, 0, var1);
   }
}
