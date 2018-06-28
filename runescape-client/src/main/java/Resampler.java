import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("Resampler")
public class Resampler {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1984609843
   )
   @Export("storedSampleRateRatio")
   int storedSampleRateRatio;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1903277839
   )
   @Export("playbackSampleRateRatio")
   int playbackSampleRateRatio;
   @ObfuscatedName("n")
   @Export("resampleTable")
   int[][] resampleTable;

   public Resampler(int var1, int var2) {
      if(var2 != var1) {
         int var3 = ScriptEvent.method1084(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.storedSampleRateRatio = var1;
         this.playbackSampleRateRatio = var2;
         this.resampleTable = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.resampleTable[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(7.0D + var6);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = 3.141592653589793D * ((double)var8 - var6);
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var8 - var6));
               var5[var8] = (int)Math.floor(0.5D + var14 * 65536.0D);
            }
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "25"
   )
   @Export("resampleIfNecessary")
   byte[] resampleIfNecessary(byte[] var1) {
      if(this.resampleTable != null) {
         int var2 = (int)((long)var1.length * (long)this.playbackSampleRateRatio / (long)this.storedSampleRateRatio) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.resampleTable[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.playbackSampleRateRatio;
            var9 = var5 / this.storedSampleRateRatio;
            var4 += var9;
            var5 -= var9 * this.storedSampleRateRatio;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + 32768 >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "704464912"
   )
   int method2309(int var1) {
      if(this.resampleTable != null) {
         var1 = (int)((long)this.playbackSampleRateRatio * (long)var1 / (long)this.storedSampleRateRatio);
      }

      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "559329434"
   )
   int method2306(int var1) {
      if(this.resampleTable != null) {
         var1 = (int)((long)this.playbackSampleRateRatio * (long)var1 / (long)this.storedSampleRateRatio) + 6;
      }

      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1582271092"
   )
   static void method2307(String var0, String var1, String var2) {
      class78.loginMessage1 = var0;
      class78.loginMessage2 = var1;
      class78.loginMessage3 = var2;
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1066685626"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class37.clientInstance.method866();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field645 = 0;
            Client.field630 = 0;
            Client.field840.method5257(var0);
            if(var0 != 20) {
               KeyFocusListener.method761(false);
            }
         }

         if(var0 != 20 && var0 != 40 && VertexNormal.field1697 != null) {
            VertexNormal.field1697.vmethod3368();
            VertexNormal.field1697 = null;
         }

         if(Client.gameState == 25) {
            Client.field649 = 0;
            Client.field792 = 0;
            Client.field697 = 1;
            Client.field647 = 0;
            Client.field648 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               NPC.method1841(MapLabel.indexCache10, class59.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               NPC.method1841(MapLabel.indexCache10, class59.indexSprites, false, 4);
            } else if(class78.field1122) {
               class78.field1105 = null;
               class78.field1113 = null;
               class192.runeSprites = null;
               class78.field1107 = null;
               class24.field224 = null;
               class78.logoSprite = null;
               WidgetNode.titlemuteSprite = null;
               class78.field1109 = null;
               class78.field1110 = null;
               ScriptState.field469 = null;
               class13.slFlagSprites = null;
               PacketBuffer.slArrowSprites = null;
               class9.slStarSprites = null;
               Occluder.field1844 = null;
               WorldComparator.field4 = null;
               class81.field1178 = null;
               DynamicObject.field1228 = null;
               class45.field376 = null;
               class8.field51 = null;
               class83.field1206 = null;
               class297.field3701 = null;
               class274.field3569 = null;
               ISAACCipher.method3911(2);
               WorldMapType3.sendConInfo(true);
               class78.field1122 = false;
            }
         } else {
            NPC.method1841(MapLabel.indexCache10, class59.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }
}
