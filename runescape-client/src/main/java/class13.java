import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class13 {
   @ObfuscatedName("i")
   public final List field272;
   @ObfuscatedName("c")
   public static Comparator field273;
   @ObfuscatedName("e")
   public static Comparator field274;
   @ObfuscatedName("v")
   public static Comparator field275;
   @ObfuscatedName("b")
   public static Comparator field276;
   @ObfuscatedName("gz")
   static SpritePixels[] field278;
   @ObfuscatedName("dg")
   @ObfuscatedGetter(
      intValue = 2106948633
   )
   static int field279;
   @ObfuscatedName("h")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = -1257093333
   )
   @Export("cameraYaw")
   static int cameraYaw;

   static {
      field273 = new class19();
      new class12();
      field274 = new class17();
      field275 = new class18();
      field276 = new class15();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "897049009"
   )
   static final int method63(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class13(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field272 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field272.add(new class14(var1, var5, var3));
      }

   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "1707544703"
   )
   static final void method67(Player var0, int var1, int var2, int var3) {
      if(var0 != World.localPlayer) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.field896 == 0) {
               String var10 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = World.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = WorldMapData.method337(16711680);
               } else if(var9 < -6) {
                  var6 = WorldMapData.method337(16723968);
               } else if(var9 < -3) {
                  var6 = WorldMapData.method337(16740352);
               } else if(var9 < 0) {
                  var6 = WorldMapData.method337(16756736);
               } else if(var9 > 9) {
                  var6 = WorldMapData.method337('\uff00');
               } else if(var9 > 6) {
                  var6 = WorldMapData.method337(4259584);
               } else if(var9 > 3) {
                  var6 = WorldMapData.method337(8453888);
               } else if(var9 > 0) {
                  var6 = WorldMapData.method337(12648192);
               } else {
                  var6 = WorldMapData.method337(16776960);
               }

               var4 = var10 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field896 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field1083 == 1) {
               class3.addMenuEntry("Use", Client.field1084 + " " + "->" + " " + WorldMapData.method337(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field1085) {
               if((class64.field808 & 8) == 8) {
                  class3.addMenuEntry(Client.field1088, Client.field1089 + " " + "->" + " " + WorldMapData.method337(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var11 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(Client.field953 == class91.field1439) {
                           continue;
                        }

                        if(Client.field953 == class91.field1436 || class91.field1440 == Client.field953 && var0.combatLevel > World.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(World.localPlayer.team != 0 && var0.team != 0) {
                           if(World.localPlayer.team == var0.team) {
                              var11 = 2000;
                           } else {
                              var11 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var5]) {
                        var11 = 2000;
                     }

                     boolean var12 = false;
                     var7 = var11 + Client.playerMenuTypes[var5];
                     class3.addMenuEntry(Client.playerOptions[var5], WorldMapData.method337(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = WorldMapData.method337(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-147500425"
   )
   public void method68(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field272, var1);
      } else {
         Collections.sort(this.field272, Collections.reverseOrder(var1));
      }

   }
}
