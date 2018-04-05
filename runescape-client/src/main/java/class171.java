import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class171 extends class169 {
   @ObfuscatedName("o")
   Socket field2235;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   class163 field2236;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   GameSocket field2237;

   class171(Socket var1, int var2, int var3) throws IOException {
      this.field2235 = var1;
      this.field2235.setSoTimeout(30000);
      this.field2235.setTcpNoDelay(true);
      this.field2235.setReceiveBufferSize(65536);
      this.field2235.setSendBufferSize(65536);
      this.field2236 = new class163(this.field2235.getInputStream(), var2);
      this.field2237 = new GameSocket(this.field2235.getOutputStream(), var3);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1585663712"
   )
   public boolean vmethod3335(int var1) throws IOException {
      return this.field2236.method3200(var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "45"
   )
   public int vmethod3334() throws IOException {
      return this.field2236.method3196();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1452513085"
   )
   public int vmethod3349() throws IOException {
      return this.field2236.method3203();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "692266189"
   )
   public int vmethod3348(byte[] var1, int var2, int var3) throws IOException {
      return this.field2236.method3198(var1, var2, var3);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1491035871"
   )
   public void vmethod3337(byte[] var1, int var2, int var3) throws IOException {
      this.field2237.read(var1, var2, var3);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-102019490"
   )
   public void vmethod3331() {
      this.field2237.method3375();

      try {
         this.field2235.close();
      } catch (IOException var2) {
         ;
      }

      this.field2236.method3204();
   }

   protected void finalize() {
      this.vmethod3331();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIILfr;Lfb;Z[I[IS)I",
      garbageValue = "20323"
   )
   public static int method3325(int var0, int var1, int var2, class178 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class177.field2285[var8][var9] = 0;
            class177.field2286[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var13;
      int var14;
      int var15;
      int var17;
      int var19;
      int var20;
      int var21;
      boolean var28;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var28 = NPC.method1878(var0, var1, var3, var4);
      } else if(var2 == 2) {
         var10 = var0;
         var11 = var1;
         byte var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class177.field2285[var12][var13] = 99;
         class177.field2286[var12][var13] = 0;
         byte var16 = 0;
         var17 = 0;
         class177.field2290[var16] = var0;
         var33 = var16 + 1;
         class177.field2287[var16] = var1;
         int[][] var27 = var4.flags;

         boolean var29;
         while(true) {
            if(var33 == var17) {
               class177.field2283 = var10;
               class177.field2289 = var11;
               var29 = false;
               break;
            }

            var10 = class177.field2290[var17];
            var11 = class177.field2287[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod3428(2, var10, var11, var4)) {
               class177.field2283 = var10;
               class177.field2289 = var11;
               var29 = true;
               break;
            }

            var21 = class177.field2286[var30][var31] + 1;
            if(var30 > 0 && class177.field2285[var30 - 1][var31] == 0 && (var27[var19 - 1][var20] & 19136782) == 0 && (var27[var19 - 1][var20 + 1] & 19136824) == 0) {
               class177.field2290[var33] = var10 - 1;
               class177.field2287[var33] = var11;
               var33 = var33 + 1 & 4095;
               class177.field2285[var30 - 1][var31] = 2;
               class177.field2286[var30 - 1][var31] = var21;
            }

            if(var30 < 126 && class177.field2285[var30 + 1][var31] == 0 && (var27[var19 + 2][var20] & 19136899) == 0 && (var27[var19 + 2][var20 + 1] & 19136992) == 0) {
               class177.field2290[var33] = var10 + 1;
               class177.field2287[var33] = var11;
               var33 = var33 + 1 & 4095;
               class177.field2285[var30 + 1][var31] = 8;
               class177.field2286[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class177.field2285[var30][var31 - 1] == 0 && (var27[var19][var20 - 1] & 19136782) == 0 && (var27[var19 + 1][var20 - 1] & 19136899) == 0) {
               class177.field2290[var33] = var10;
               class177.field2287[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class177.field2285[var30][var31 - 1] = 1;
               class177.field2286[var30][var31 - 1] = var21;
            }

            if(var31 < 126 && class177.field2285[var30][var31 + 1] == 0 && (var27[var19][var20 + 2] & 19136824) == 0 && (var27[var19 + 1][var20 + 2] & 19136992) == 0) {
               class177.field2290[var33] = var10;
               class177.field2287[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class177.field2285[var30][var31 + 1] = 4;
               class177.field2286[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class177.field2285[var30 - 1][var31 - 1] == 0 && (var27[var19 - 1][var20] & 19136830) == 0 && (var27[var19 - 1][var20 - 1] & 19136782) == 0 && (var27[var19][var20 - 1] & 19136911) == 0) {
               class177.field2290[var33] = var10 - 1;
               class177.field2287[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class177.field2285[var30 - 1][var31 - 1] = 3;
               class177.field2286[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 126 && var31 > 0 && class177.field2285[var30 + 1][var31 - 1] == 0 && (var27[var19 + 1][var20 - 1] & 19136911) == 0 && (var27[var19 + 2][var20 - 1] & 19136899) == 0 && (var27[var19 + 2][var20] & 19136995) == 0) {
               class177.field2290[var33] = var10 + 1;
               class177.field2287[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class177.field2285[var30 + 1][var31 - 1] = 9;
               class177.field2286[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 126 && class177.field2285[var30 - 1][var31 + 1] == 0 && (var27[var19 - 1][var20 + 1] & 19136830) == 0 && (var27[var19 - 1][var20 + 2] & 19136824) == 0 && (var27[var19][var20 + 2] & 19137016) == 0) {
               class177.field2290[var33] = var10 - 1;
               class177.field2287[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class177.field2285[var30 - 1][var31 + 1] = 6;
               class177.field2286[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 126 && var31 < 126 && class177.field2285[var30 + 1][var31 + 1] == 0 && (var27[var19 + 1][var20 + 2] & 19137016) == 0 && (var27[var19 + 2][var20 + 2] & 19136992) == 0 && (var27[var19 + 2][var20 + 1] & 19136995) == 0) {
               class177.field2290[var33] = var10 + 1;
               class177.field2287[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class177.field2285[var30 + 1][var31 + 1] = 12;
               class177.field2286[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else {
         var28 = class46.method705(var0, var1, var2, var3, var4);
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class177.field2283;
      var30 = class177.field2289;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field2296;
         var17 = var3.field2293;
         int var18 = var3.field2294;
         var19 = var3.field2295;

         for(var20 = var33 - var32; var20 <= var33 + var32; ++var20) {
            for(var21 = var17 - var32; var21 <= var17 + var32; ++var21) {
               int var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class177.field2286[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var33 + var18 - 1) {
                     var24 = var20 - (var33 + var18 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var17 + var19 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var26 == var31 && class177.field2286[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class177.field2286[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var30 == var1) {
         return 0;
      } else {
         var13 = 0;
         class177.field2290[var13] = var11;
         var31 = var13 + 1;
         class177.field2287[var13] = var30;

         for(var14 = var15 = class177.field2285[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class177.field2285[var11 - var9][var30 - var10]) {
            if(var15 != var14) {
               var15 = var14;
               class177.field2290[var31] = var11;
               class177.field2287[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class177.field2290[var31];
            var7[var33++] = class177.field2287[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lbr;B)V",
      garbageValue = "-18"
   )
   static void method3299(GameEngine var0) {
      int var2;
      int var3;
      int var4;
      if(class90.worldSelectShown) {
         if(MouseInput.mouseLastButton == 1 || !MapIconReference.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
            int var1 = class90.field1359 + 280;
            if(MouseInput.mouseLastPressedX >= var1 && MouseInput.mouseLastPressedX <= var1 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
               DynamicObject.method2024(0, 0);
            } else if(MouseInput.mouseLastPressedX >= var1 + 15 && MouseInput.mouseLastPressedX <= var1 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
               DynamicObject.method2024(0, 1);
            } else {
               var2 = class90.field1359 + 390;
               if(MouseInput.mouseLastPressedX >= var2 && MouseInput.mouseLastPressedX <= var2 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                  DynamicObject.method2024(1, 0);
               } else if(MouseInput.mouseLastPressedX >= var2 + 15 && MouseInput.mouseLastPressedX <= var2 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                  DynamicObject.method2024(1, 1);
               } else {
                  var3 = class90.field1359 + 500;
                  if(MouseInput.mouseLastPressedX >= var3 && MouseInput.mouseLastPressedX <= var3 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                     DynamicObject.method2024(2, 0);
                  } else if(MouseInput.mouseLastPressedX >= var3 + 15 && MouseInput.mouseLastPressedX <= var3 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                     DynamicObject.method2024(2, 1);
                  } else {
                     var4 = class90.field1359 + 610;
                     if(MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var4 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                        DynamicObject.method2024(3, 0);
                     } else if(MouseInput.mouseLastPressedX >= var4 + 15 && MouseInput.mouseLastPressedX <= var4 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                        DynamicObject.method2024(3, 1);
                     } else if(MouseInput.mouseLastPressedX >= class90.field1359 + 708 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedX <= class90.field1359 + 708 + 50 && MouseInput.mouseLastPressedY <= 20) {
                        class90.worldSelectShown = false;
                        class321.field3938.method5856(class90.field1359, 0);
                        class90.field1381.method5856(class90.field1359 + 382, 0);
                        class33.logoSprite.method5825(class90.field1359 + 382 - class33.logoSprite.width / 2, 18);
                     } else if(class90.field1390 != -1) {
                        World var5 = World.worldList[class90.field1390];
                        class45.changeWorld(var5);
                        class90.worldSelectShown = false;
                        class321.field3938.method5856(class90.field1359, 0);
                        class90.field1381.method5856(class90.field1359 + 382, 0);
                        class33.logoSprite.method5825(class90.field1359 + 382 - class33.logoSprite.width / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((MouseInput.mouseLastButton == 1 || !MapIconReference.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= class90.field1359 + 765 - 50 && MouseInput.mouseLastPressedY >= 453) {
            Client.preferences.muted = !Client.preferences.muted;
            MouseInput.method1062();
            if(!Client.preferences.muted) {
               IndexData var12 = PacketBuffer.indexTrack1;
               var2 = var12.getFile("scape main");
               var3 = var12.getChild(var2, "");
               PacketNode.method3442(var12, var2, var3, 255, false);
            } else {
               class155.method3165();
            }
         }

         if(Client.gameState != 5) {
            if(class90.field1391 == -1L) {
               class90.field1391 = class64.method1118() + 1000L;
            }

            long var13 = class64.method1118();
            boolean var22;
            if(Client.field871 != null && Client.field935 < Client.field871.size()) {
               while(true) {
                  if(Client.field935 >= Client.field871.size()) {
                     var22 = true;
                     break;
                  }

                  class64 var15 = (class64)Client.field871.get(Client.field935);
                  if(!var15.method1117()) {
                     var22 = false;
                     break;
                  }

                  ++Client.field935;
               }
            } else {
               var22 = true;
            }

            if(var22 && class90.field1389 == -1L) {
               class90.field1389 = var13;
               if(class90.field1389 > class90.field1391) {
                  class90.field1391 = class90.field1389;
               }
            }

            ++class90.field1371;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.languageId == 0) {
                  if(MouseInput.mouseLastButton == 1 || !MapIconReference.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
                     var4 = class90.field1359 + 5;
                     short var16 = 463;
                     byte var6 = 100;
                     byte var7 = 35;
                     if(MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var6 + var4 && MouseInput.mouseLastPressedY >= var16 && MouseInput.mouseLastPressedY <= var7 + var16) {
                        MouseRecorder.method1145();
                        return;
                     }
                  }

                  if(FaceNormal.listFetcher != null) {
                     MouseRecorder.method1145();
                  }
               }

               var4 = MouseInput.mouseLastButton;
               int var29 = MouseInput.mouseLastPressedX;
               int var23 = MouseInput.mouseLastPressedY;
               if(var4 == 0) {
                  var29 = MouseInput.mouseLastX;
                  var23 = MouseInput.mouseLastY;
               }

               if(!MapIconReference.middleMouseMovesCamera && var4 == 4) {
                  var4 = 1;
               }

               int var8;
               short var9;
               if(class90.loginIndex == 0) {
                  boolean var24 = false;

                  while(class160.method3183()) {
                     if(Item.currentPressedKey == 84) {
                        var24 = true;
                     }
                  }

                  var8 = WorldComparator.field279 - 80;
                  var9 = 291;
                  if(var4 == 1 && var29 >= var8 - 75 && var29 <= var8 + 75 && var23 >= var9 - 20 && var23 <= var9 + 20) {
                     label995: {
                        String var10 = VerticalAlignment.method4715("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                        if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                           try {
                              Desktop.getDesktop().browse(new URI(var10));
                              break label995;
                           } catch (Exception var21) {
                              ;
                           }
                        }

                        if(class57.field667.startsWith("win")) {
                           Buffer.method3727(var10, 0);
                        } else if(class57.field667.startsWith("mac")) {
                           CombatInfoListHolder.method1865(var10, 1, "openjs");
                        } else {
                           Buffer.method3727(var10, 2);
                        }
                     }
                  }

                  var8 = WorldComparator.field279 + 80;
                  if(var4 == 1 && var29 >= var8 - 75 && var29 <= var8 + 75 && var23 >= var9 - 20 && var23 <= var9 + 20 || var24) {
                     if((Client.flags & 33554432) != 0) {
                        class90.Login_response0 = "";
                        class90.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class90.loginMessage2 = "Your normal account will not be affected.";
                        class90.loginMessage3 = "";
                        class90.loginIndex = 1;
                        class196.method3744();
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class90.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class90.loginMessage2 = "Players can attack each other almost everywhere";
                           class90.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class90.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class90.loginMessage2 = "Players can attack each other";
                           class90.loginMessage3 = "almost everywhere.";
                        }

                        class90.Login_response0 = "Warning!";
                        class90.loginIndex = 1;
                        class196.method3744();
                     } else if((Client.flags & 1024) != 0) {
                        class90.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class90.loginMessage2 = "The Protect Item prayer will";
                        class90.loginMessage3 = "not work on this world.";
                        class90.Login_response0 = "Warning!";
                        class90.loginIndex = 1;
                        class196.method3744();
                     } else {
                        SoundTaskDataProvider.method814(false);
                     }
                  }
               } else {
                  int var25;
                  short var27;
                  if(class90.loginIndex != 1) {
                     short var26;
                     if(class90.loginIndex == 2) {
                        var26 = 201;
                        var25 = var26 + 52;
                        if(var4 == 1 && var23 >= var25 - 12 && var23 < var25 + 2) {
                           class90.field1386 = 0;
                        }

                        var25 += 15;
                        if(var4 == 1 && var23 >= var25 - 12 && var23 < var25 + 2) {
                           class90.field1386 = 1;
                        }

                        var25 += 15;
                        var26 = 361;
                        if(var4 == 1 && var23 >= var26 - 15 && var23 < var26) {
                           BoundingBox3DDrawMode.method53("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class90.loginIndex = 5;
                           return;
                        }

                        var8 = WorldComparator.field279 - 80;
                        var9 = 321;
                        if(var4 == 1 && var29 >= var8 - 75 && var29 <= var8 + 75 && var23 >= var9 - 20 && var23 <= var9 + 20) {
                           class90.username = class90.username.trim();
                           if(class90.username.length() == 0) {
                              BoundingBox3DDrawMode.method53("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class90.password.length() == 0) {
                              BoundingBox3DDrawMode.method53("", "Please enter your password.", "");
                              return;
                           }

                           BoundingBox3DDrawMode.method53("", "Connecting to server...", "");
                           WorldMapType3.method232(false);
                           class64.setGameState(20);
                           return;
                        }

                        var8 = class90.loginWindowX + 180 + 80;
                        if(var4 == 1 && var29 >= var8 - 75 && var29 <= var8 + 75 && var23 >= var9 - 20 && var23 <= var9 + 20) {
                           class90.loginIndex = 0;
                           class90.username = "";
                           class90.password = "";
                           Size.field369 = 0;
                           class37.field501 = "";
                           class90.field1385 = true;
                        }

                        var8 = WorldComparator.field279 + -117;
                        var9 = 277;
                        class90.field1374 = var29 >= var8 && var29 < var8 + NPC.field1318 && var23 >= var9 && var23 < var9 + class203.field2616;
                        if(var4 == 1 && class90.field1374) {
                           class90.Login_isUsernameRemembered = !class90.Login_isUsernameRemembered;
                           if(!class90.Login_isUsernameRemembered && Client.preferences.rememberedUsername != null) {
                              Client.preferences.rememberedUsername = null;
                              MouseInput.method1062();
                           }
                        }

                        var8 = WorldComparator.field279 + 24;
                        var9 = 277;
                        class90.field1384 = var29 >= var8 && var29 < var8 + NPC.field1318 && var23 >= var9 && var23 < var9 + class203.field2616;
                        if(var4 == 1 && class90.field1384) {
                           Client.preferences.hideUsername = !Client.preferences.hideUsername;
                           if(!Client.preferences.hideUsername) {
                              class90.username = "";
                              Client.preferences.rememberedUsername = null;
                              class196.method3744();
                           }

                           MouseInput.method1062();
                        }

                        while(true) {
                           while(class160.method3183()) {
                              boolean var17 = false;

                              for(int var18 = 0; var18 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var18) {
                                 if(class38.currentTypedKey == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var18)) {
                                    var17 = true;
                                    break;
                                 }
                              }

                              if(Item.currentPressedKey == 13) {
                                 class90.loginIndex = 0;
                                 class90.username = "";
                                 class90.password = "";
                                 Size.field369 = 0;
                                 class37.field501 = "";
                                 class90.field1385 = true;
                              } else if(class90.field1386 == 0) {
                                 if(Item.currentPressedKey == 85 && class90.username.length() > 0) {
                                    class90.username = class90.username.substring(0, class90.username.length() - 1);
                                 }

                                 if(Item.currentPressedKey == 84 || Item.currentPressedKey == 80) {
                                    class90.field1386 = 1;
                                 }

                                 if(var17 && class90.username.length() < 320) {
                                    class90.username = class90.username + class38.currentTypedKey;
                                 }
                              } else if(class90.field1386 == 1) {
                                 if(Item.currentPressedKey == 85 && class90.password.length() > 0) {
                                    class90.password = class90.password.substring(0, class90.password.length() - 1);
                                 }

                                 if(Item.currentPressedKey == 84 || Item.currentPressedKey == 80) {
                                    class90.field1386 = 0;
                                 }

                                 if(Item.currentPressedKey == 84) {
                                    class90.username = class90.username.trim();
                                    if(class90.username.length() == 0) {
                                       BoundingBox3DDrawMode.method53("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class90.password.length() == 0) {
                                       BoundingBox3DDrawMode.method53("", "Please enter your password.", "");
                                       return;
                                    }

                                    BoundingBox3DDrawMode.method53("", "Connecting to server...", "");
                                    WorldMapType3.method232(false);
                                    class64.setGameState(20);
                                    return;
                                 }

                                 if(var17 && class90.password.length() < 20) {
                                    class90.password = class90.password + class38.currentTypedKey;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class90.loginIndex == 3) {
                        var25 = class90.loginWindowX + 180;
                        var27 = 276;
                        if(var4 == 1 && var29 >= var25 - 75 && var29 <= var25 + 75 && var23 >= var27 - 20 && var23 <= var27 + 20) {
                           SoundTaskDataProvider.method814(false);
                        }

                        var25 = class90.loginWindowX + 180;
                        var27 = 326;
                        if(var4 == 1 && var29 >= var25 - 75 && var29 <= var25 + 75 && var23 >= var27 - 20 && var23 <= var27 + 20) {
                           BoundingBox3DDrawMode.method53("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class90.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var28;
                        int var30;
                        if(class90.loginIndex == 4) {
                           var25 = class90.loginWindowX + 180 - 80;
                           var27 = 321;
                           if(var4 == 1 && var29 >= var25 - 75 && var29 <= var25 + 75 && var23 >= var27 - 20 && var23 <= var27 + 20) {
                              class37.field501.trim();
                              if(class37.field501.length() != 6) {
                                 BoundingBox3DDrawMode.method53("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              Size.field369 = Integer.parseInt(class37.field501);
                              class37.field501 = "";
                              WorldMapType3.method232(true);
                              BoundingBox3DDrawMode.method53("", "Connecting to server...", "");
                              class64.setGameState(20);
                              return;
                           }

                           if(var4 == 1 && var29 >= class90.loginWindowX + 180 - 9 && var29 <= class90.loginWindowX + 180 + 130 && var23 >= 263 && var23 <= 296) {
                              class90.field1385 = !class90.field1385;
                           }

                           if(var4 == 1 && var29 >= class90.loginWindowX + 180 - 34 && var29 <= class90.loginWindowX + 34 + 180 && var23 >= 351 && var23 <= 363) {
                              label1008: {
                                 String var19 = VerticalAlignment.method4715("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                                 if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                    try {
                                       Desktop.getDesktop().browse(new URI(var19));
                                       break label1008;
                                    } catch (Exception var20) {
                                       ;
                                    }
                                 }

                                 if(class57.field667.startsWith("win")) {
                                    Buffer.method3727(var19, 0);
                                 } else if(class57.field667.startsWith("mac")) {
                                    CombatInfoListHolder.method1865(var19, 1, "openjs");
                                 } else {
                                    Buffer.method3727(var19, 2);
                                 }
                              }
                           }

                           var25 = class90.loginWindowX + 180 + 80;
                           if(var4 == 1 && var29 >= var25 - 75 && var29 <= var25 + 75 && var23 >= var27 - 20 && var23 <= var27 + 20) {
                              class90.loginIndex = 0;
                              class90.username = "";
                              class90.password = "";
                              Size.field369 = 0;
                              class37.field501 = "";
                           }

                           while(class160.method3183()) {
                              var28 = false;

                              for(var30 = 0; var30 < "1234567890".length(); ++var30) {
                                 if(class38.currentTypedKey == "1234567890".charAt(var30)) {
                                    var28 = true;
                                    break;
                                 }
                              }

                              if(Item.currentPressedKey == 13) {
                                 class90.loginIndex = 0;
                                 class90.username = "";
                                 class90.password = "";
                                 Size.field369 = 0;
                                 class37.field501 = "";
                              } else {
                                 if(Item.currentPressedKey == 85 && class37.field501.length() > 0) {
                                    class37.field501 = class37.field501.substring(0, class37.field501.length() - 1);
                                 }

                                 if(Item.currentPressedKey == 84) {
                                    class37.field501.trim();
                                    if(class37.field501.length() != 6) {
                                       BoundingBox3DDrawMode.method53("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    Size.field369 = Integer.parseInt(class37.field501);
                                    class37.field501 = "";
                                    WorldMapType3.method232(true);
                                    BoundingBox3DDrawMode.method53("", "Connecting to server...", "");
                                    class64.setGameState(20);
                                    return;
                                 }

                                 if(var28 && class37.field501.length() < 6) {
                                    class37.field501 = class37.field501 + class38.currentTypedKey;
                                 }
                              }
                           }
                        } else if(class90.loginIndex == 5) {
                           var25 = class90.loginWindowX + 180 - 80;
                           var27 = 321;
                           if(var4 == 1 && var29 >= var25 - 75 && var29 <= var25 + 75 && var23 >= var27 - 20 && var23 <= var27 + 20) {
                              WorldComparator.method69();
                              return;
                           }

                           var25 = class90.loginWindowX + 180 + 80;
                           if(var4 == 1 && var29 >= var25 - 75 && var29 <= var25 + 75 && var23 >= var27 - 20 && var23 <= var27 + 20) {
                              SoundTaskDataProvider.method814(true);
                           }

                           while(class160.method3183()) {
                              var28 = false;

                              for(var30 = 0; var30 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var30) {
                                 if(class38.currentTypedKey == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var30)) {
                                    var28 = true;
                                    break;
                                 }
                              }

                              if(Item.currentPressedKey == 13) {
                                 SoundTaskDataProvider.method814(true);
                              } else {
                                 if(Item.currentPressedKey == 85 && class90.username.length() > 0) {
                                    class90.username = class90.username.substring(0, class90.username.length() - 1);
                                 }

                                 if(Item.currentPressedKey == 84) {
                                    WorldComparator.method69();
                                    return;
                                 }

                                 if(var28 && class90.username.length() < 320) {
                                    class90.username = class90.username + class38.currentTypedKey;
                                 }
                              }
                           }
                        } else if(class90.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class160.method3183()) {
                                    var26 = 321;
                                    if(var4 == 1 && var23 >= var26 - 20 && var23 <= var26 + 20) {
                                       SoundTaskDataProvider.method814(true);
                                    }

                                    return;
                                 }
                              } while(Item.currentPressedKey != 84 && Item.currentPressedKey != 13);

                              SoundTaskDataProvider.method814(true);
                           }
                        }
                     }
                  } else {
                     while(class160.method3183()) {
                        if(Item.currentPressedKey == 84) {
                           SoundTaskDataProvider.method814(false);
                        } else if(Item.currentPressedKey == 13) {
                           class90.loginIndex = 0;
                        }
                     }

                     var25 = WorldComparator.field279 - 80;
                     var27 = 321;
                     if(var4 == 1 && var29 >= var25 - 75 && var29 <= var25 + 75 && var23 >= var27 - 20 && var23 <= var27 + 20) {
                        SoundTaskDataProvider.method814(false);
                     }

                     var25 = WorldComparator.field279 + 80;
                     if(var4 == 1 && var29 >= var25 - 75 && var29 <= var25 + 75 && var23 >= var27 - 20 && var23 <= var27 + 20) {
                        class90.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }
}
