import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public final class class68 extends Node {
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = -1476992915
   )
   static int field1014;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   static Deque field1002;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -129307297
   )
   int field998;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -586243701
   )
   int field1000;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 618012917
   )
   int field1007;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1178062771
   )
   int field1001;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1692095007
   )
   int field1005;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1320451131
   )
   int field1011;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 989282411
   )
   int field1004;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   class103 field1006;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1173437159
   )
   int field997;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1534158765
   )
   int field1003;
   @ObfuscatedName("d")
   int[] field1008;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -38140803
   )
   int field1009;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lcd;"
   )
   class103 field1010;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   ObjectComposition field999;

   static {
      field1002 = new Deque();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1770938983"
   )
   void method1730() {
      int var1 = this.field1004;
      ObjectComposition var2 = this.field999.getImpostor();
      if(var2 != null) {
         this.field1004 = var2.ambientSoundId;
         this.field1011 = var2.int4 * 128;
         this.field997 = var2.int5;
         this.field1003 = var2.int6;
         this.field1008 = var2.field3437;
      } else {
         this.field1004 = -1;
         this.field1011 = 0;
         this.field997 = 0;
         this.field1003 = 0;
         this.field1008 = null;
      }

      if(var1 != this.field1004 && this.field1006 != null) {
         class141.field1906.method2050(this.field1006);
         this.field1006 = null;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;S)I",
      garbageValue = "-24553"
   )
   public static int method1745(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & '?');
         } else {
            var0[var4++] = (byte)(224 | var6 >> '\f');
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & '?');
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1360057077"
   )
   public static void method1742() {
      WorldMapRegion.field203.method4048(5);
      WorldMapRegion.field204.method4048(5);
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1208624539"
   )
   static final void method1746() {
      int[] var0 = class81.playerIndices;

      int var1;
      for(var1 = 0; var1 < class81.playerIndexesCount; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(var2 != null && var2.overheadTextCyclesRemaining > 0) {
            --var2.overheadTextCyclesRemaining;
            if(var2.overheadTextCyclesRemaining == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         int var4 = Client.npcIndices[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(var3 != null && var3.overheadTextCyclesRemaining > 0) {
            --var3.overheadTextCyclesRemaining;
            if(var3.overheadTextCyclesRemaining == 0) {
               var3.overhead = null;
            }
         }
      }

   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(Lbs;II)V",
      garbageValue = "-575882251"
   )
   static final void method1747(Actor var0, int var1) {
      if(var0.field896 > Client.gameCycle) {
         Script.method1994(var0);
      } else {
         int var2;
         int var3;
         int var4;
         int var5;
         int var7;
         if(var0.field901 >= Client.gameCycle) {
            if(var0.field901 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.actionFrameCycle + 1 > class137.getAnimation(var0.animation).frameLengths[var0.actionFrame]) {
               var2 = var0.field901 - var0.field896;
               var3 = Client.gameCycle - var0.field896;
               var4 = var0.field925 * 128 + var0.field885 * 64;
               var5 = var0.field927 * 128 + var0.field885 * 64;
               int var6 = var0.field926 * 128 + var0.field885 * 64;
               var7 = var0.field888 * 128 + var0.field885 * 64;
               var0.x = (var3 * var6 + var4 * (var2 - var3)) / var2;
               var0.y = (var7 * var3 + var5 * (var2 - var3)) / var2;
            }

            var0.field936 = 0;
            var0.orientation = var0.field931;
            var0.angle = var0.orientation;
         } else {
            var0.poseAnimation = var0.idlePoseAnimation;
            if(var0.queueSize == 0) {
               var0.field936 = 0;
            } else {
               label303: {
                  if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                     Sequence var11 = class137.getAnimation(var0.animation);
                     if(var0.field942 > 0 && var11.precedenceAnimating == 0) {
                        ++var0.field936;
                        break label303;
                     }

                     if(var0.field942 <= 0 && var11.priority == 0) {
                        ++var0.field936;
                        break label303;
                     }
                  }

                  var2 = var0.x;
                  var3 = var0.y;
                  var4 = var0.pathX[var0.queueSize - 1] * 128 + var0.field885 * 64;
                  var5 = var0.pathY[var0.queueSize - 1] * 128 + var0.field885 * 64;
                  if(var2 < var4) {
                     if(var3 < var5) {
                        var0.orientation = 1280;
                     } else if(var3 > var5) {
                        var0.orientation = 1792;
                     } else {
                        var0.orientation = 1536;
                     }
                  } else if(var2 > var4) {
                     if(var3 < var5) {
                        var0.orientation = 768;
                     } else if(var3 > var5) {
                        var0.orientation = 256;
                     } else {
                        var0.orientation = 512;
                     }
                  } else if(var3 < var5) {
                     var0.orientation = 1024;
                  } else if(var3 > var5) {
                     var0.orientation = 0;
                  }

                  byte var12 = var0.pathTraversed[var0.queueSize - 1];
                  if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                     var7 = var0.orientation - var0.angle & 2047;
                     if(var7 > 1024) {
                        var7 -= 2048;
                     }

                     int var8 = var0.field891;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = var0.field890;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = var0.field893;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = var0.field882;
                     }

                     if(var8 == -1) {
                        var8 = var0.field890;
                     }

                     var0.poseAnimation = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(var0 instanceof NPC) {
                        var10 = ((NPC)var0).composition.isClickable;
                     }

                     if(var10) {
                        if(var0.orientation != var0.angle && var0.interacting == -1 && var0.field929 != 0) {
                           var9 = 2;
                        }

                        if(var0.queueSize > 2) {
                           var9 = 6;
                        }

                        if(var0.queueSize > 3) {
                           var9 = 8;
                        }

                        if(var0.field936 > 0 && var0.queueSize > 1) {
                           var9 = 8;
                           --var0.field936;
                        }
                     } else {
                        if(var0.queueSize > 1) {
                           var9 = 6;
                        }

                        if(var0.queueSize > 2) {
                           var9 = 8;
                        }

                        if(var0.field936 > 0 && var0.queueSize > 1) {
                           var9 = 8;
                           --var0.field936;
                        }
                     }

                     if(var12 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && var0.field890 == var0.poseAnimation && var0.field894 != -1) {
                        var0.poseAnimation = var0.field894;
                     }

                     if(var4 != var2 || var3 != var5) {
                        if(var2 < var4) {
                           var0.x += var9;
                           if(var0.x > var4) {
                              var0.x = var4;
                           }
                        } else if(var2 > var4) {
                           var0.x -= var9;
                           if(var0.x < var4) {
                              var0.x = var4;
                           }
                        }

                        if(var3 < var5) {
                           var0.y += var9;
                           if(var0.y > var5) {
                              var0.y = var5;
                           }
                        } else if(var3 > var5) {
                           var0.y -= var9;
                           if(var0.y < var5) {
                              var0.y = var5;
                           }
                        }
                     }

                     if(var4 == var0.x && var5 == var0.y) {
                        --var0.queueSize;
                        if(var0.field942 > 0) {
                           --var0.field942;
                        }
                     }
                  } else {
                     var0.x = var4;
                     var0.y = var5;
                     --var0.queueSize;
                     if(var0.field942 > 0) {
                        --var0.field942;
                     }
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field896 = 0;
         var0.field901 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field885 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field885 * 64;
         var0.method1590();
      }

      if(MilliTimer.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field896 = 0;
         var0.field901 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field885 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field885 * 64;
         var0.method1590();
      }

      FaceNormal.method3083(var0);
      class33.method605(var0);
   }
}
