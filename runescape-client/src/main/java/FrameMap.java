import java.awt.Image;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("w")
   public static String[] field1817;
   @ObfuscatedName("e")
   int[] field1818;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -139752031
   )
   int field1819;
   @ObfuscatedName("g")
   int[][] field1820;
   @ObfuscatedName("gt")
   static Widget field1821;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1594129467
   )
   public static int field1823;
   @ObfuscatedName("qf")
   protected static Image field1824;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1221130967
   )
   int field1825;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-512960036"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(World.worldServersDownload == null) {
            World.worldServersDownload = new class18(class40.field898, new URL(WidgetNode.field72));
         } else {
            byte[] var0 = World.worldServersDownload.method198();
            if(null != var0) {
               Buffer var1 = new Buffer(var0);
               World.field685 = var1.method2546();
               VertexNormal.worldList = new World[World.field685];

               World var3;
               for(int var2 = 0; var2 < World.field685; var3.index = var2++) {
                  var3 = VertexNormal.worldList[var2] = new World();
                  var3.id = var1.method2546();
                  var3.mask = var1.method2549();
                  var3.address = var1.method2552();
                  var3.activity = var1.method2552();
                  var3.location = var1.method2544();
                  var3.playerCount = var1.method2547();
               }

               class23.method562(VertexNormal.worldList, 0, VertexNormal.worldList.length - 1, World.field681, World.field671);
               World.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         World.worldServersDownload = null;
      }

      return false;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)[LSpritePixels;",
      garbageValue = "-40"
   )
   static SpritePixels[] method2319() {
      SpritePixels[] var0 = new SpritePixels[class79.field1436];

      for(int var1 = 0; var1 < class79.field1436; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.field1453 = class169.field2713;
         var2.field1459 = class79.field1435;
         var2.field1458 = class79.field1439[var1];
         var2.field1457 = class79.field1438[var1];
         var2.width = class79.field1443[var1];
         var2.height = class79.field1440[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = class79.field1441[var1];
         var2.image = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.image[var5] = class129.field2092[var4[var5] & 255];
         }
      }

      ChatLineBuffer.method649();
      return var0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "0"
   )
   public static boolean method2320(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   FrameMap(int var1, byte[] var2) {
      this.field1825 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1819 = var3.method2544();
      this.field1818 = new int[this.field1819];
      this.field1820 = new int[this.field1819][];

      int var4;
      for(var4 = 0; var4 < this.field1819; ++var4) {
         this.field1818[var4] = var3.method2544();
      }

      for(var4 = 0; var4 < this.field1819; ++var4) {
         this.field1820[var4] = new int[var3.method2544()];
      }

      for(var4 = 0; var4 < this.field1819; ++var4) {
         for(int var5 = 0; var5 < this.field1820[var4].length; ++var5) {
            this.field1820[var4][var5] = var3.method2544();
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-755621947"
   )
   static final void method2321(Actor var0) {
      var0.field838 = false;
      Sequence var1;
      if(var0.poseAnimation != -1) {
         var1 = class192.getAnimation(var0.poseAnimation);
         if(null != var1 && var1.field1011 != null) {
            ++var0.field866;
            if(var0.poseFrame < var1.field1011.length && var0.field866 > var1.field1019[var0.poseFrame]) {
               var0.field866 = 1;
               ++var0.poseFrame;
               Frames.method2326(var1, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var1.field1011.length) {
               var0.field866 = 0;
               var0.poseFrame = 0;
               Frames.method2326(var1, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field835) {
         if(var0.field873 < 0) {
            var0.field873 = 0;
         }

         int var3 = Sequence.method929(var0.graphic).field1033;
         if(var3 != -1) {
            Sequence var2 = class192.getAnimation(var3);
            if(var2 != null && null != var2.field1011) {
               ++var0.field874;
               if(var0.field873 < var2.field1011.length && var0.field874 > var2.field1019[var0.field873]) {
                  var0.field874 = 1;
                  ++var0.field873;
                  Frames.method2326(var2, var0.field873, var0.x, var0.y);
               }

               if(var0.field873 >= var2.field1011.length && (var0.field873 < 0 || var0.field873 >= var2.field1011.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var1 = class192.getAnimation(var0.animation);
         if(var1.precedenceAnimating == 1 && var0.field894 > 0 && var0.field881 <= Client.gameCycle && var0.field882 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var1 = class192.getAnimation(var0.animation);
         if(null != var1 && var1.field1011 != null) {
            ++var0.field880;
            if(var0.actionFrame < var1.field1011.length && var0.field880 > var1.field1019[var0.actionFrame]) {
               var0.field880 = 1;
               ++var0.actionFrame;
               Frames.method2326(var1, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var1.field1011.length) {
               var0.actionFrame -= var1.field1012;
               ++var0.field871;
               if(var0.field871 >= var1.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var1.field1011.length) {
                  Frames.method2326(var1, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field838 = var1.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }
}
