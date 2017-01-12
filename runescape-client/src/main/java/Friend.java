import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("c")
   boolean field154;
   @ObfuscatedName("u")
   @Export("name")
   String name;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1191681189
   )
   @Export("world")
   int world;
   @ObfuscatedName("x")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("f")
   boolean field158;
   @ObfuscatedName("z")
   @Export("worldServersDownload")
   static class26 worldServersDownload;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1249588953
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("j")
   static String[] field161;
   @ObfuscatedName("jm")
   @ObfuscatedGetter(
      intValue = -1497567415
   )
   static int field163;

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "100"
   )
   static final void method174(boolean var0) {
      for(int var1 = 0; var1 < Client.field322; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field483[var1]];
         int var3 = (Client.field483[var1] << 14) + 536870912;
         if(null != var2 && var2.vmethod718() && var0 == var2.composition.isVisible && var2.composition.method3706()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field603 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field386[var4][var5] == Client.field387) {
                     continue;
                  }

                  Client.field386[var4][var5] = Client.field387;
               }

               if(!var2.composition.field3009) {
                  var3 -= Integer.MIN_VALUE;
               }

               class6.region.method1686(class60.plane, var2.x, var2.y, class176.method3243(var2.field603 * 64 - 64 + var2.x, var2.y + (var2.field603 * 64 - 64), class60.plane), 60 + (var2.field603 * 64 - 64), var2, var2.angle, var3, var2.field602);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/awt/Component;IIB)Lclass57;",
      garbageValue = "-35"
   )
   public static final class57 method175(class103 var0, Component var1, int var2, int var3) {
      if(class7.field65 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class59 var4 = new class59();
            var4.field1035 = new int[(class57.field1055?2:1) * 256];
            var4.field1049 = var3;
            var4.vmethod1069(var1);
            var4.field1033 = (var3 & -1024) + 1024;
            if(var4.field1033 > 16384) {
               var4.field1033 = 16384;
            }

            var4.vmethod1080(var4.field1033);
            if(class57.field1048 > 0 && class57.field1051 == null) {
               class57.field1051 = new class63();
               class57.field1051.field1086 = var0;
               var0.method1916(class57.field1051, class57.field1048);
            }

            if(null != class57.field1051) {
               if(null != class57.field1051.field1087[var2]) {
                  throw new IllegalArgumentException();
               }

               class57.field1051.field1087[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class57();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1679500609"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(Client.gameState != var0) {
         if(Client.gameState == 0) {
            class178.field2658 = null;
            CombatInfoListHolder.field752 = null;
            RSCanvas.field1745 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field329 = 0;
            Client.field318 = 0;
            Client.field319 = 0;
         }

         if(var0 != 20 && var0 != 40 && null != class101.field1643) {
            class101.field1643.method2026();
            class101.field1643 = null;
         }

         if(Client.gameState == 25) {
            Client.field342 = 0;
            Client.field338 = 0;
            Client.field456 = 1;
            Client.field340 = 0;
            Client.field341 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class37.method734(class165.canvas, ChatLineBuffer.field956, class0.field4, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class37.method734(class165.canvas, ChatLineBuffer.field956, class0.field4, false, 4);
            } else if(class168.field2173) {
               class41.field807 = null;
               class41.field808 = null;
               NPC.field759 = null;
               class41.field809 = null;
               class41.field840 = null;
               class229.field3246 = null;
               class38.field788 = null;
               class41.field811 = null;
               class8.field80 = null;
               class7.field67 = null;
               Ignore.field204 = null;
               XItemContainer.field133 = null;
               class65.field1102 = null;
               class185.field2730 = null;
               class41.field816 = null;
               class41.field817 = null;
               GroundObject.field1300 = null;
               TextureProvider.field1199 = null;
               class88.field1531 = null;
               class97.field1627 = null;
               class5.field48 = null;
               class41.field813 = null;
               class138.field1900 = 1;
               class138.field1903 = null;
               class47.field920 = -1;
               class0.field2 = -1;
               FrameMap.field1466 = 0;
               ChatMessages.field916 = false;
               class138.field1904 = 2;
               FrameMap.method1666(true);
               class168.field2173 = false;
            }
         } else {
            class37.method734(class165.canvas, ChatLineBuffer.field956, class0.field4, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-2"
   )
   public static boolean method177(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }
}
