import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("bk")
   static String field1139;
   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -192007303
   )
   @Export("level")
   int level;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -857676255
   )
   @Export("type")
   int type;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1747003545
   )
   @Export("x")
   int x;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 283970895
   )
   @Export("y")
   int y;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1550908355
   )
   int field1133;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1908693387
   )
   int field1132;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2147432269
   )
   int field1138;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1520890741
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 563702817
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -511347447
   )
   int field1136;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -626664157
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1988829397
   )
   @Export("hitpoints")
   int hitpoints;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILhf;B)Lcx;",
      garbageValue = "52"
   )
   static Script method1491(int var0, class226 var1) {
      Script var2 = (Script)Script.field1436.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = class29.indexScripts.getFile(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = class29.indexScripts.method4114(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = class96.method1822(var5);
               if(var2 != null) {
                  Script.field1436.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1579857137"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class295.field3847 = var1.readUnsignedShort();
      WidgetNode.field774 = new int[class295.field3847];
      class285.offsetsY = new int[class295.field3847];
      class295.field3848 = new int[class295.field3847];
      class295.field3845 = new int[class295.field3847];
      class70.spritePixels = new byte[class295.field3847][];
      var1.offset = var0.length - 7 - class295.field3847 * 8;
      class295.field3846 = var1.readUnsignedShort();
      class224.field2850 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class295.field3847; ++var3) {
         WidgetNode.field774[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class295.field3847; ++var3) {
         class285.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class295.field3847; ++var3) {
         class295.field3848[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class295.field3847; ++var3) {
         class295.field3845[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class295.field3847 * 8 - (var2 - 1) * 3;
      class278.field3733 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class278.field3733[var3] = var1.read24BitInt();
         if(class278.field3733[var3] == 0) {
            class278.field3733[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class295.field3847; ++var3) {
         int var4 = class295.field3848[var3];
         int var5 = class295.field3845[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class70.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.readByte();
               }
            }
         }
      }

   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1020948518"
   )
   static int method1494() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(Lbw;II)V",
      garbageValue = "35125449"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class168.method3096(var0.x, var0.y, var1);
   }
}
