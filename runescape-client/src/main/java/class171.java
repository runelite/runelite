import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class171 extends class169 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1316741759
   )
   static int field2222;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 1172571687
   )
   static int field2218;
   @ObfuscatedName("d")
   Socket field2221;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   class163 field2223;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   GameSocket field2220;

   public class171(Socket var1, int var2, int var3) throws IOException {
      this.field2221 = var1;
      this.field2221.setSoTimeout(30000);
      this.field2221.setTcpNoDelay(true);
      this.field2221.setReceiveBufferSize(65536);
      this.field2221.setSendBufferSize(65536);
      this.field2223 = new class163(this.field2221.getInputStream(), var2);
      this.field2220 = new GameSocket(this.field2221.getOutputStream(), var3);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "723083645"
   )
   public boolean vmethod3383(int var1) throws IOException {
      return this.field2223.method3267(var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1228440200"
   )
   public int vmethod3389() throws IOException {
      return this.field2223.method3280();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1683920252"
   )
   public int vmethod3381() throws IOException {
      return this.field2223.method3268();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1694519349"
   )
   public int vmethod3399(byte[] var1, int var2, int var3) throws IOException {
      return this.field2223.method3271(var1, var2, var3);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "572887195"
   )
   public void vmethod3387(byte[] var1, int var2, int var3) throws IOException {
      this.field2220.read(var1, var2, var3);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1035620035"
   )
   public void vmethod3379() {
      this.field2220.method3423();

      try {
         this.field2221.close();
      } catch (IOException var2) {
         ;
      }

      this.field2223.method3270();
   }

   protected void finalize() {
      this.vmethod3379();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1988653782"
   )
   static boolean method3362(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgy;IIIIIII)V",
      garbageValue = "-431075244"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class62.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class62.tileHeights[0][var2];
                  int var11 = var2 + var4 + 932731;
                  int var12 = var3 + var5 + 556238;
                  int var13 = ScriptVarType.getSmoothNoise(var11 + 45365, 91923 + var12, 4) - 128 + (ScriptVarType.getSmoothNoise(var11 + 10294, var12 + 37821, 2) - 128 >> 1) + (ScriptVarType.getSmoothNoise(var11, var12, 1) - 128 >> 2);
                  var13 = (int)((double)var13 * 0.3D) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = -var13 * 8;
               } else {
                  class62.tileHeights[var1][var2][var3] = class62.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.readUnsignedByte();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class62.tileHeights[0][var2][var3] = -var14 * 8;
               } else {
                  class62.tileHeights[var1][var2][var3] = class62.tileHeights[var1 - 1][var2][var3] - var14 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class62.field744[var1][var2][var3] = var0.readByte();
               class62.field734[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class62.field739[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class62.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               UrlRequest.field2107[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(Lbk;II)V",
      garbageValue = "-1762342590"
   )
   static final void method3367(Actor var0, int var1) {
      if(var0.field1188 > Client.gameCycle) {
         ScriptVarType.method32(var0);
      } else {
         int var2;
         int var3;
         int var4;
         int var5;
         int var7;
         if(var0.field1186 >= Client.gameCycle) {
            if(var0.field1186 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1173 + 1 > class270.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
               var2 = var0.field1186 - var0.field1188;
               var3 = Client.gameCycle - var0.field1188;
               var4 = var0.field1167 * 128 + var0.field1193 * 64;
               var5 = var0.field1146 * 128 + var0.field1193 * 64;
               int var6 = var0.field1181 * 128 + var0.field1193 * 64;
               var7 = var0.field1184 * 128 + var0.field1193 * 64;
               var0.x = (var3 * var6 + var4 * (var2 - var3)) / var2;
               var0.y = (var7 * var3 + var5 * (var2 - var3)) / var2;
            }

            var0.field1197 = 0;
            var0.orientation = var0.field1187;
            var0.angle = var0.orientation;
         } else {
            var0.poseAnimation = var0.idlePoseAnimation;
            if(var0.queueSize == 0) {
               var0.field1197 = 0;
            } else {
               label316: {
                  if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                     Sequence var11 = class270.getAnimation(var0.animation);
                     if(var0.field1198 > 0 && var11.precedenceAnimating == 0) {
                        ++var0.field1197;
                        break label316;
                     }

                     if(var0.field1198 <= 0 && var11.priority == 0) {
                        ++var0.field1197;
                        break label316;
                     }
                  }

                  var2 = var0.x;
                  var3 = var0.y;
                  var4 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1193 * 64;
                  var5 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1193 * 64;
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

                     int var8 = var0.field1139;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = var0.field1163;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = var0.field1147;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = var0.field1149;
                     }

                     if(var8 == -1) {
                        var8 = var0.field1163;
                     }

                     var0.poseAnimation = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(var0 instanceof NPC) {
                        var10 = ((NPC)var0).composition.isClickable;
                     }

                     if(var10) {
                        if(var0.angle != var0.orientation && var0.interacting == -1 && var0.field1183 != 0) {
                           var9 = 2;
                        }

                        if(var0.queueSize > 2) {
                           var9 = 6;
                        }

                        if(var0.queueSize > 3) {
                           var9 = 8;
                        }

                        if(var0.field1197 > 0 && var0.queueSize > 1) {
                           var9 = 8;
                           --var0.field1197;
                        }
                     } else {
                        if(var0.queueSize > 1) {
                           var9 = 6;
                        }

                        if(var0.queueSize > 2) {
                           var9 = 8;
                        }

                        if(var0.field1197 > 0 && var0.queueSize > 1) {
                           var9 = 8;
                           --var0.field1197;
                        }
                     }

                     if(var12 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && var0.poseAnimation == var0.field1163 && var0.field1151 != -1) {
                        var0.poseAnimation = var0.field1151;
                     }

                     if(var4 != var2 || var5 != var3) {
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
                        if(var0.field1198 > 0) {
                           --var0.field1198;
                        }
                     }
                  } else {
                     var0.x = var4;
                     var0.y = var5;
                     --var0.queueSize;
                     if(var0.field1198 > 0) {
                        --var0.field1198;
                     }
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1188 = 0;
         var0.field1186 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1193 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1193 * 64;
         var0.method1628();
      }

      if(TotalQuantityComparator.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1188 = 0;
         var0.field1186 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1193 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1193 * 64;
         var0.method1628();
      }

      class254.method4644(var0);
      class45.method639(var0);
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(Liw;I)V",
      garbageValue = "-158584900"
   )
   static void method3363(Widget var0) {
      if(var0.loopCycle == Client.field1052) {
         Client.field1053[var0.boundsIndex] = true;
      }

   }
}
