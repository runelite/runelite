import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("h")
   @Export("worldServersDownload")
   static class18 worldServersDownload;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1843346485
   )
   public int field3171;
   @ObfuscatedName("t")
   public int[] field3172;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1268802475
   )
   public int field3173;
   @ObfuscatedName("p")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("g")
   public int[] field3175;
   @ObfuscatedName("y")
   public int[] field3176;
   @ObfuscatedName("m")
   @Export("args")
   public byte[][][] args;
   @ObfuscatedName("f")
   @Export("methods")
   public Method[] methods;

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIIB)V",
      garbageValue = "-95"
   )
   static final void method3926(Player var0, int var1, int var2, int var3) {
      if(var0 != TextureProvider.localPlayer) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.field32 == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class9.method120(var0.combatLevel, TextureProvider.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field32 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field421 == 1) {
               class10.addMenuEntry("Use", Client.field416 + " " + "->" + " " + class188.method3706(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field270) {
               if((class124.field2042 & 8) == 8) {
                  class10.addMenuEntry(Client.field333, Client.field497 + " " + "->" + " " + class188.method3706(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.field396[var5] != null) {
                     short var6 = 0;
                     if(Client.field396[var5].equalsIgnoreCase("Attack")) {
                        if(Client.field292 == class21.field564) {
                           continue;
                        }

                        if(class21.field561 == Client.field292 || Client.field292 == class21.field562 && var0.combatLevel > TextureProvider.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(TextureProvider.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == TextureProvider.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.field513[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.field395[var5] + var6;
                     class10.addMenuEntry(Client.field396[var5], class188.method3706(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class188.method3706(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
