import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("World")
public class World {
   @ObfuscatedName("x")
   @Export("activity")
   String activity;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -749679557
   )
   @Export("index")
   int index;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1433517903
   )
   @Export("location")
   int location;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1895779109
   )
   static int field672 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1875113211
   )
   static int field673 = 0;
   @ObfuscatedName("p")
   static int[] field674 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1611932203
   )
   @Export("id")
   int id;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1239691671
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -160528355
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("e")
   @Export("address")
   String address;
   @ObfuscatedName("w")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("g")
   static int[] field686 = new int[]{0, 1, 2, 3};

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1889480508"
   )
   boolean method637() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "988118234"
   )
   public static void method638() {
      Object var0 = class183.field2729;
      synchronized(class183.field2729) {
         if(class183.field2734 != 0) {
            class183.field2734 = 1;

            try {
               class183.field2729.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1756186212"
   )
   boolean method639() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1963784237"
   )
   boolean method640() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1889054104"
   )
   boolean method642() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1890700670"
   )
   boolean method653() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2022663835"
   )
   boolean method667() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1912258839"
   )
   static final void method669(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = 6 + var2;
      int var5 = XGrandExchangeOffer.field45.method3914(var0, 250);
      int var6 = XGrandExchangeOffer.field45.method3915(var0, 250) * 13;
      class219.method4071(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      class219.method4053(var3 - var2, var4 - var2, var2 + var2 + var5, var6 + var2 + var2, 16777215);
      XGrandExchangeOffer.field45.method3921(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class45.method835(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = class107.canvas.getGraphics();
            class34.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var8) {
            class107.canvas.repaint();
         }
      } else {
         class16.method199(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass15;B)V",
      garbageValue = "-67"
   )
   static final void method671(class15 var0) {
      if(class40.localPlayer.x >> 7 == Client.flagX && Client.flagY == class40.localPlayer.y >> 7) {
         Client.flagX = 0;
      }

      int var1 = class45.field897;
      int[] var2 = class45.field902;
      int var3 = var1;
      if(class15.field158 == var0 || var0 == class15.field154) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(var0 == class15.field158) {
            var5 = class40.localPlayer;
            var6 = class40.localPlayer.field265 << 14;
         } else if(class15.field154 == var0) {
            var5 = Client.cachedPlayers[Client.field525];
            var6 = Client.field525 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class15.field155 && Client.field525 == var2[var4]) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod746() && !var5.field263) {
            var5.field261 = false;
            if((Client.field288 && var1 > 50 || var1 > 200) && var0 != class15.field158 && var5.idlePoseAnimation == var5.poseAnimation) {
               var5.field261 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(null != var5.model && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field252) {
                  var5.field261 = false;
                  var5.field243 = class11.method161(var5.x, var5.y, class166.plane);
                  class157.region.method1752(class166.plane, var5.x, var5.y, var5.field243, 60, var5, var5.angle, var6, var5.field245, var5.field258, var5.field266, var5.field260);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field391[var7][var8] == Client.field548) {
                        continue;
                     }

                     Client.field391[var7][var8] = Client.field548;
                  }

                  var5.field243 = class11.method161(var5.x, var5.y, class166.plane);
                  class157.region.method1751(class166.plane, var5.x, var5.y, var5.field243, 60, var5, var5.angle, var6, var5.field598);
               }
            }
         }
      }

   }
}
