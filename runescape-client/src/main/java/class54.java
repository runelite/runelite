import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class54 {
   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "[Llm;"
   )
   static SpritePixels[] field605;
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("indexCache4")
   static IndexData indexCache4;
   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   static TextureProvider field607;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(Lbq;I)V",
      garbageValue = "-1703157038"
   )
   static final void method810(Actor var0) {
      int var1 = var0.field1140 - Client.gameCycle;
      int var2 = var0.field1136 * 128 + var0.field1098 * 64;
      int var3 = var0.field1108 * 128 + var0.field1098 * 64;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field1128 = 0;
      var0.orientation = var0.field1142;
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(Lgu;I)V",
      garbageValue = "1379576029"
   )
   static final void method809(PacketBuffer var0) {
      for(int var1 = 0; var1 < Client.pendingNpcFlagsCount; ++var1) {
         int var2 = Client.pendingNpcFlagsIndices[var1];
         NPC var3 = Client.cachedNPCs[var2];
         int var4 = var0.readUnsignedByte();
         int var5;
         int var6;
         int var7;
         int var8;
         if((var4 & 8) != 0) {
            var5 = var0.method3575();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = var0.getUSmart();
                  if(var7 == 32767) {
                     var7 = var0.getUSmart();
                     var9 = var0.getUSmart();
                     var8 = var0.getUSmart();
                     var10 = var0.getUSmart();
                  } else if(var7 != 32766) {
                     var9 = var0.getUSmart();
                  } else {
                     var7 = -1;
                  }

                  var11 = var0.getUSmart();
                  var3.method1621(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = var0.method3575();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  if(var9 != 32767) {
                     var10 = var0.getUSmart();
                     var11 = var0.readUnsignedByteNegate();
                     int var12 = var9 > 0?var0.method3577():var11;
                     var3.method1623(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method1622(var8);
                  }
               }
            }
         }

         if((var4 & 1) != 0) {
            var3.graphic = var0.method3666();
            var5 = var0.method3595();
            var3.field1135 = var5 >> 16;
            var3.graphicsDelay = (var5 & 65535) + Client.gameCycle;
            var3.field1104 = 0;
            var3.field1144 = 0;
            if(var3.graphicsDelay > Client.gameCycle) {
               var3.field1104 = -1;
            }

            if(var3.graphic == 65535) {
               var3.graphic = -1;
            }
         }

         if((var4 & 32) != 0) {
            var5 = var0.method3699();
            var6 = var0.method3699();
            var7 = var3.x - (var5 - ScriptState.baseX - ScriptState.baseX) * 64;
            var8 = var3.y - (var6 - WorldMapType1.baseY - WorldMapType1.baseY) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.field1122 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 2) != 0) {
            var3.interacting = var0.readUnsignedShortOb1();
            if(var3.interacting == 65535) {
               var3.interacting = -1;
            }
         }

         if((var4 & 4) != 0) {
            var3.overhead = var0.readString();
            var3.overheadTextCyclesRemaining = 100;
         }

         if((var4 & 16) != 0) {
            var5 = var0.readUnsignedShort();
            if(var5 == 65535) {
               var5 = -1;
            }

            var6 = var0.method3575();
            if(var5 == var3.animation && var5 != -1) {
               var7 = Occluder.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.field1133 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field1094 = 0;
               }

               if(var7 == 2) {
                  var3.field1094 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || Occluder.getAnimation(var5).forcedPriority >= Occluder.getAnimation(var3.animation).forcedPriority) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.field1133 = 0;
               var3.actionAnimationDisable = var6;
               var3.field1094 = 0;
               var3.field1153 = var3.queueSize;
            }
         }

         if((var4 & 64) != 0) {
            var3.composition = Tile.getNpcDefinition(var0.method3666());
            var3.field1098 = var3.composition.field3661;
            var3.field1147 = var3.composition.field3628;
            var3.field1102 = var3.composition.field3648;
            var3.field1099 = var3.composition.field3642;
            var3.field1130 = var3.composition.field3641;
            var3.field1105 = var3.composition.field3639;
            var3.idlePoseAnimation = var3.composition.field3636;
            var3.field1100 = var3.composition.field3637;
            var3.field1101 = var3.composition.field3638;
         }
      }

   }
}
