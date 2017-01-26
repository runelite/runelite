import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 86443815
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 953032909
   )
   @Export("health")
   int health;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 734614977
   )
   int field656;
   @ObfuscatedName("j")
   static SpritePixels field658;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1269401779
   )
   int field661;
   @ObfuscatedName("lx")
   static class216 field662;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2025066366"
   )
   static void method601() {
      class41.username = class41.username.trim();
      if(class41.username.length() == 0) {
         MessageNode.method204("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = World.method652();
         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = Widget.method3216(var1, class41.username);
         }

         switch(var0) {
         case 2:
            MessageNode.method204("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class41.loginIndex = 6;
            break;
         case 3:
            MessageNode.method204("", "Error connecting to server.", "");
            break;
         case 4:
            MessageNode.method204("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            MessageNode.method204("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            MessageNode.method204("", "Error connecting to server.", "");
            break;
         case 7:
            MessageNode.method204("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1928734839"
   )
   static final void method602(boolean var0) {
      class85.method1692();
      ++Client.field348;
      if(Client.field348 >= 50 || var0) {
         Client.field348 = 0;
         if(!Client.field332 && Friend.field152 != null) {
            Client.field394.method3037(249);

            try {
               Friend.field152.method2073(Client.field394.payload, 0, Client.field394.offset);
               Client.field394.offset = 0;
            } catch (IOException var2) {
               Client.field332 = true;
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "170821749"
   )
   void method604(int var1, int var2, int var3, int var4) {
      this.field661 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field656 = var4;
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "-2129724396"
   )
   static String method606(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var4 = var0.indexOf("%" + var2);
               if(var4 == -1) {
                  break;
               }

               var0 = var0.substring(0, var4) + class179.method3265(ChatLineBuffer.method895(var1, var2 - 1)) + var0.substring(2 + var4);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var3 = "";
            if(class30.field690 != null) {
               var3 = class154.method3009(class30.field690.field1665);
               if(class30.field690.field1664 != null) {
                  var3 = (String)class30.field690.field1664;
               }
            }

            var0 = var0.substring(0, var2) + var3 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field661 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field656 = var4;
   }
}
