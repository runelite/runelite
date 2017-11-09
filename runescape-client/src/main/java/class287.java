import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
public class class287 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1306273883
   )
   public int field3795;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -370431331
   )
   public int field3796;

   class287(int var1, int var2, int var3, int var4) {
      this.method5130(var1, var2);
      this.method5131(var3, var4);
   }

   public class287(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "704038283"
   )
   void method5130(int var1, int var2) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "724557737"
   )
   void method5131(int var1, int var2) {
      this.field3795 = var1;
      this.field3796 = var2;
   }

   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "293916172"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class9.clientInstance.method996();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field900 = 0;
            Client.field902 = 0;
            Client.field970.method5101(var0);
            if(var0 != 20) {
               Permission.method4256(false);
            }
         }

         if(var0 != 20 && var0 != 40 && MessageNode.field823 != null) {
            MessageNode.field823.close();
            MessageNode.field823 = null;
         }

         if(Client.gameState == 25) {
            Client.field920 = 0;
            Client.field1029 = 0;
            Client.field917 = 1;
            Client.field918 = 0;
            Client.field919 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               MessageNode.method1172(AbstractSoundSystem.field1563, class96.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               MessageNode.method1172(AbstractSoundSystem.field1563, class96.indexSprites, false, 4);
            } else if(class91.field1361) {
               class91.field1333 = null;
               class91.field1334 = null;
               class91.field1335 = null;
               class91.field1336 = null;
               class91.field1368 = null;
               class91.logoSprite = null;
               class91.titlemuteSprite = null;
               WallObject.field2046 = null;
               class296.field3859 = null;
               class29.field410 = null;
               class256.field3431 = null;
               class56.field651 = null;
               class24.field350 = null;
               ItemContainer.field750 = null;
               ClanMember.field867 = null;
               ChatLineBuffer.field1458 = null;
               MessageNode.field821 = null;
               Overlay.field3653 = null;
               Permission.field3243 = null;
               class34.field466 = null;
               CombatInfoListHolder.field1288 = null;
               class13.field281 = null;
               class37.method552(2);
               class29.sendConInfo(true);
               class91.field1361 = false;
            }
         } else {
            MessageNode.method1172(AbstractSoundSystem.field1563, class96.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }
}
