import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("bs")
   static class184 field220;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1557327565
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 265462093
   )
   @Export("type")
   int type;
   @ObfuscatedName("k")
   @Export("name")
   String name;
   @ObfuscatedName("g")
   @Export("sender")
   String sender;
   @ObfuscatedName("n")
   @Export("value")
   String value;
   @ObfuscatedName("q")
   static class179 field226;
   @ObfuscatedName("dn")
   @ObfuscatedGetter(
      intValue = -915970983
   )
   static int field227;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1671700543
   )
   @Export("id")
   int id = ItemLayer.method1447();
   @ObfuscatedName("nw")
   static class65 field229;
   @ObfuscatedName("r")
   static String[] field231;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 107847965
   )
   static int field232;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = 1575178341
   )
   @Export("cameraZ")
   static int cameraZ;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   void method199(int var1, String var2, String var3, String var4) {
      this.id = ItemLayer.method1447();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZB)Z",
      garbageValue = "16"
   )
   static boolean method200(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lclass15;B)V",
      garbageValue = "61"
   )
   static final void method202(class15 var0) {
      if(Client.flagX == class39.localPlayer.x >> 7 && class39.localPlayer.y >> 7 == Client.flagY) {
         Client.flagX = 0;
      }

      int var1 = class45.field908;
      int[] var2 = class45.field903;
      int var3 = var1;
      if(var0 == class15.field158 || var0 == class15.field159) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(var0 == class15.field158) {
            var5 = class39.localPlayer;
            var6 = class39.localPlayer.field262 << 14;
         } else if(var0 == class15.field159) {
            var5 = Client.cachedPlayers[Client.field418];
            var6 = Client.field418 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class15.field161 && var2[var4] == Client.field418) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod679() && !var5.field245) {
            var5.field258 = false;
            if((Client.field289 && var1 > 50 || var1 > 200) && var0 != class15.field158 && var5.idlePoseAnimation == var5.poseAnimation) {
               var5.field258 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field249) {
                  var5.field258 = false;
                  var5.field247 = class85.method1686(var5.x, var5.y, class171.plane);
                  Client.region.method1703(class171.plane, var5.x, var5.y, var5.field247, 60, var5, var5.angle, var6, var5.field254, var5.field255, var5.field239, var5.field257);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field312 == Client.field391[var7][var8]) {
                        continue;
                     }

                     Client.field391[var7][var8] = Client.field312;
                  }

                  var5.field247 = class85.method1686(var5.x, var5.y, class171.plane);
                  Client.region.method1739(class171.plane, var5.x, var5.y, var5.field247, 60, var5, var5.angle, var6, var5.field605);
               }
            }
         }
      }

   }

   MessageNode(int var1, String var2, String var3, String var4) {
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "1032274152"
   )
   public static void method203(class182 var0) {
      class200.field3037 = var0;
   }
}
