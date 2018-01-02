import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.LinkedHashMap;

@ObfuscatedName("ex")
public enum class150 implements Enumerated {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   field2094(3, 0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   field2090(1, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   field2091(2, 2),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   field2092(0, 3);

   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -684082815
   )
   public final int field2093;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -955917495
   )
   final int field2089;

   class150(int var3, int var4) {
      this.field2093 = var3;
      this.field2089 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1035813094"
   )
   public int rsOrdinal() {
      return this.field2089;
   }

   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1184897100"
   )
   static final void method2932(boolean var0) {
      if(var0) {
         Client.field1063 = class91.field1346?field2090:field2092;
      } else {
         LinkedHashMap var1 = class2.preferences.preferences;
         String var3 = class91.username;
         int var4 = var3.length();
         int var5 = 0;

         for(int var6 = 0; var6 < var4; ++var6) {
            var5 = (var5 << 5) - var5 + var3.charAt(var6);
         }

         Client.field1063 = var1.containsKey(Integer.valueOf(var5))?field2094:field2091;
      }

   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "761047601"
   )
   static final void method2933(int var0) {
      CombatInfoListHolder.method1630();
      AbstractScene.method236();
      int var1 = class25.method182(var0).configType;
      if(var1 != 0) {
         int var2 = VarpSettingsStore.widgetSettings[var0];
         if(var1 == 1) {
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

         if(var1 == 3) {
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

            if(var3 != Client.field845) {
               if(Client.field845 == 0 && Client.field850 != -1) {
                  class2.method3(class29.indexTrack1, Client.field850, 0, var3, false);
                  Client.field1008 = false;
               } else if(var3 == 0) {
                  class282.field3753.method3849();
                  class214.field2620 = 1;
                  class214.field2623 = null;
                  Client.field1008 = false;
               } else {
                  OwnWorldComparator.method1116(var3);
               }

               Client.field845 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field1066 = 127;
            }

            if(var2 == 1) {
               Client.field1066 = 96;
            }

            if(var2 == 2) {
               Client.field1066 = 64;
            }

            if(var2 == 3) {
               Client.field1066 = 32;
            }

            if(var2 == 4) {
               Client.field1066 = 0;
            }
         }

         if(var1 == 5) {
            Client.field965 = var2;
         }

         if(var1 == 6) {
            Client.field990 = var2;
         }

         if(var1 == 9) {
            Client.field991 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field1067 = 127;
            }

            if(var2 == 1) {
               Client.field1067 = 96;
            }

            if(var2 == 2) {
               Client.field1067 = 64;
            }

            if(var2 == 3) {
               Client.field1067 = 32;
            }

            if(var2 == 4) {
               Client.field1067 = 0;
            }
         }

         if(var1 == 17) {
            Client.field996 = var2 & 65535;
         }

         if(var1 == 18) {
            Client.playerAttackOption = (AttackOption)class91.forOrdinal(FrameMap.method2688(), var2);
            if(Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field957 = -1;
            } else {
               Client.field957 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            Client.npcAttackOption = (AttackOption)class91.forOrdinal(FrameMap.method2688(), var2);
            if(Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }
}
