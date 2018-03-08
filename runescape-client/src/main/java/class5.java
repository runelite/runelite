import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
final class class5 implements class0 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 466042085
   )
   static int field30;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1599027539
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("aa")
   protected static GarbageCollectorMXBean field32;
   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   @Export("fontBold12")
   static Font fontBold12;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "2"
   )
   public static int method15(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 = var0 * var2;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "372741659"
   )
   static final void method14(int var0) {
      class38.method549();

      for(class80 var1 = (class80)class80.field1240.getFront(); var1 != null; var1 = (class80)class80.field1240.getNext()) {
         if(var1.field1250 != null) {
            var1.method1794();
         }
      }

      int var4 = Client.method1275(var0).configType;
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

            if(var3 != Client.field1079) {
               if(Client.field1079 == 0 && Client.field1080 != -1) {
                  CombatInfo1.method1668(Varbit.indexTrack1, Client.field1080, 0, var3, false);
                  Client.field956 = false;
               } else if(var3 == 0) {
                  ScriptState.method1124();
                  Client.field956 = false;
               } else {
                  ISAACCipher.method3847(var3);
               }

               Client.field1079 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field899 = 127;
            }

            if(var2 == 1) {
               Client.field899 = 96;
            }

            if(var2 == 2) {
               Client.field899 = 64;
            }

            if(var2 == 3) {
               Client.field899 = 32;
            }

            if(var2 == 4) {
               Client.field899 = 0;
            }
         }

         if(var4 == 5) {
            Client.field1022 = var2;
         }

         if(var4 == 6) {
            Client.field1010 = var2;
         }

         if(var4 == 9) {
            Client.field1011 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field1083 = 127;
            }

            if(var2 == 1) {
               Client.field1083 = 96;
            }

            if(var2 == 2) {
               Client.field1083 = 64;
            }

            if(var2 == 3) {
               Client.field1083 = 32;
            }

            if(var2 == 4) {
               Client.field1083 = 0;
            }
         }

         if(var4 == 17) {
            Client.field1016 = var2 & 65535;
         }

         if(var4 == 18) {
            Client.playerAttackOption = (AttackOption)WorldMapRectangle.forOrdinal(class229.method4159(), var2);
            if(Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field890 = -1;
            } else {
               Client.field890 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            Client.npcAttackOption = (AttackOption)WorldMapRectangle.forOrdinal(class229.method4159(), var2);
            if(Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }
}
