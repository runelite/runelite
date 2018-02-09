import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class1 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   static final class1 field3;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   static final class1 field1;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   static final class1 field6;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   static final class1 field5;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   static final class1 field4;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   static final class1 field2;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   static final class1 field8;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "[Lcy;"
   )
   @Export("idxFiles")
   public static CacheFile[] idxFiles;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1490207965
   )
   final int field7;

   static {
      field3 = new class1(6);
      field1 = new class1(4);
      field6 = new class1(0);
      field5 = new class1(5);
      field4 = new class1(2);
      field2 = new class1(1);
      field8 = new class1(3);
   }

   class1(int var1) {
      this.field7 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-363235480"
   )
   static void method0() {
      if(class89.Login_isUsernameRemembered && class89.username != null && class89.username.length() > 0) {
         class89.field1317 = 1;
      } else {
         class89.field1317 = 0;
      }

   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "645767125"
   )
   static final void method1(int var0) {
      class20.method158();
      Buffer.method3749();
      int var1 = class160.method3258(var0).configType;
      if(var1 != 0) {
         int var2 = class222.widgetSettings[var0];
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

            if(var3 != Client.field1057) {
               if(Client.field1057 == 0 && Client.field902 != -1) {
                  class3.method7(class231.indexTrack1, Client.field902, 0, var3, false);
                  Client.field1059 = false;
               } else if(var3 == 0) {
                  class25.field356.method4139();
                  class214.field2617 = 1;
                  class214.field2614 = null;
                  Client.field1059 = false;
               } else {
                  class111.method2337(var3);
               }

               Client.field1057 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field1058 = 127;
            }

            if(var2 == 1) {
               Client.field1058 = 96;
            }

            if(var2 == 2) {
               Client.field1058 = 64;
            }

            if(var2 == 3) {
               Client.field1058 = 32;
            }

            if(var2 == 4) {
               Client.field1058 = 0;
            }
         }

         if(var1 == 5) {
            Client.field855 = var2;
         }

         if(var1 == 6) {
            Client.field986 = var2;
         }

         if(var1 == 9) {
            Client.field1065 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field878 = 127;
            }

            if(var2 == 1) {
               Client.field878 = 96;
            }

            if(var2 == 2) {
               Client.field878 = 64;
            }

            if(var2 == 3) {
               Client.field878 = 32;
            }

            if(var2 == 4) {
               Client.field878 = 0;
            }
         }

         if(var1 == 17) {
            Client.field992 = var2 & 65535;
         }

         if(var1 == 18) {
            Client.playerAttackOption = (AttackOption)Projectile.forOrdinal(class185.method3758(), var2);
            if(Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field953 = -1;
            } else {
               Client.field953 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            Client.npcAttackOption = (AttackOption)Projectile.forOrdinal(class185.method3758(), var2);
            if(Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }
}
