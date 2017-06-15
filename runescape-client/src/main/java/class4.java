import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class4 implements class178 {
   @ObfuscatedName("m")
   static final class4 field28;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1274599121
   )
   final int field29;
   @ObfuscatedName("e")
   static final class4 field30;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -386756799
   )
   final int field32;
   @ObfuscatedName("p")
   static final class4 field33;
   @ObfuscatedName("cq")
   @Export("indexModels")
   static IndexData indexModels;

   class4(int var1, int var2, Class var3, class0 var4) {
      this.field29 = var1;
      this.field32 = var2;
   }

   static {
      field33 = new class4(0, 0, Integer.class, new class2());
      field28 = new class4(2, 1, Long.class, new class3());
      field30 = new class4(1, 2, String.class, new class5());
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int vmethod4906() {
      return this.field32;
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "1055437563"
   )
   static final void method12(Player var0, int var1, int var2, int var3) {
      if(class20.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.totalLevel == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class229.method3972(var0.combatLevel, class20.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var5;
            if(Client.itemSelectionState == 1) {
               class44.addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + class15.method105(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field1061) {
               if((class232.spellTargetFlags & 8) == 8) {
                  class44.addMenuEntry(Client.field1064, Client.field1065 + " " + "->" + " " + class15.method105(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(Client.field928 == class91.field1410) {
                           continue;
                        }

                        if(class91.field1403 == Client.field928 || Client.field928 == class91.field1404 && var0.combatLevel > class20.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class20.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class20.localPlayer.team) {
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
                     class44.addMenuEntry(Client.playerOptions[var5], class15.method105(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class15.method105(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-131245631"
   )
   static final void method13(int var0, int var1) {
      if(class59.method961(var0)) {
         class67.method1029(Widget.widgets[var0], var1);
      }
   }
}
