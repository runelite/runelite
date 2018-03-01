import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class149 implements Comparator {
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 347762199
   )
   static int field2111;
   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   static Widget field2114;
   @ObfuscatedName("d")
   final boolean field2112;

   public class149(boolean var1) {
      this.field2112 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkz;Lkz;I)I",
      garbageValue = "601832792"
   )
   int method3186(ChatPlayer var1, ChatPlayer var2) {
      return this.field2112?var1.field3840 - var2.field3840:var2.field3840 - var1.field3840;
   }

   public int compare(Object var1, Object var2) {
      return this.method3186((ChatPlayer)var1, (ChatPlayer)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "203731076"
   )
   public static void method3194() {
      FloorUnderlayDefinition.underlays.reset();
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "140420194"
   )
   static final void method3192(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1053[var4] = true;
         }
      }

   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1852822669"
   )
   static final void method3193(int var0) {
      class2.method6();

      for(class80 var1 = (class80)class80.field1253.getFront(); var1 != null; var1 = (class80)class80.field1253.getNext()) {
         if(var1.field1242 != null) {
            var1.method1781();
         }
      }

      int var4 = class252.method4638(var0).configType;
      if(var4 != 0) {
         int var2 = class237.widgetSettings[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var2 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var2 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var2 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field981) {
               if(Client.field981 == 0 && Client.field1115 != -1) {
                  MouseRecorder.method1095(class154.indexTrack1, Client.field1115, 0, var3, false);
                  Client.field970 = false;
               } else if(var3 == 0) {
                  class197.method3836();
                  Client.field970 = false;
               } else {
                  class190.method3547(var3);
               }

               Client.field981 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field1084 = 127;
            }

            if(var2 == 1) {
               Client.field1084 = 96;
            }

            if(var2 == 2) {
               Client.field1084 = 64;
            }

            if(var2 == 3) {
               Client.field1084 = 32;
            }

            if(var2 == 4) {
               Client.field1084 = 0;
            }
         }

         if(var4 == 5) {
            Client.field924 = var2;
         }

         if(var4 == 6) {
            Client.field1012 = var2;
         }

         if(var4 == 9) {
            Client.field1013 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field911 = 127;
            }

            if(var2 == 1) {
               Client.field911 = 96;
            }

            if(var2 == 2) {
               Client.field911 = 64;
            }

            if(var2 == 3) {
               Client.field911 = 32;
            }

            if(var2 == 4) {
               Client.field911 = 0;
            }
         }

         if(var4 == 17) {
            Client.field1008 = var2 & 65535;
         }

         AttackOption[] var5;
         if(var4 == 18) {
            var5 = new AttackOption[]{AttackOption.AttackOption_hidden, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_alwaysRightClick};
            Client.playerAttackOption = (AttackOption)MapIcon.forOrdinal(var5, var2);
            if(Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field1103 = -1;
            } else {
               Client.field1103 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            var5 = new AttackOption[]{AttackOption.AttackOption_hidden, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_alwaysRightClick};
            Client.npcAttackOption = (AttackOption)MapIcon.forOrdinal(var5, var2);
            if(Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }
}
