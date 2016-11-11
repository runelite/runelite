import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class59 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -218707653
   )
   int field1230;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -61769347
   )
   public static int field1231;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 688744663
   )
   int field1232;
   @ObfuscatedName("d")
   int[] field1234;
   @ObfuscatedName("a")
   class69[] field1235 = new class69[8];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2052615099
   )
   int field1236 = 32;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 4582963224848570243L
   )
   long field1237 = class34.method738();
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1413636349
   )
   int field1238;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -205449329
   )
   public static int field1239;
   @ObfuscatedName("g")
   static class75 field1240;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -6045341952024261097L
   )
   long field1241 = 0L;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1966780893
   )
   int field1242 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1237754653
   )
   int field1243 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1255907171
   )
   int field1244 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -4045605421598964093L
   )
   long field1245 = 0L;
   @ObfuscatedName("k")
   boolean field1246 = true;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -370276907
   )
   int field1247 = 0;
   @ObfuscatedName("am")
   class69[] field1249 = new class69[8];
   @ObfuscatedName("cl")
   static class146 field1250;
   @ObfuscatedName("l")
   class69 field1251;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass69;II)V",
      garbageValue = "1546608218"
   )
   final void method1216(class69 var1, int var2) {
      int var3 = var2 >> 5;
      class69 var4 = this.field1249[var3];
      if(null == var4) {
         this.field1235[var3] = var1;
      } else {
         var4.field1318 = var1;
      }

      this.field1249[var3] = var1;
      var1.field1319 = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "256"
   )
   public final synchronized void method1217() {
      this.field1246 = true;

      try {
         this.vmethod1553();
      } catch (Exception var2) {
         this.vmethod1550();
         this.field1241 = class34.method738() + 2000L;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1162333784"
   )
   final void method1220(int var1) {
      this.field1247 -= var1;
      if(this.field1247 < 0) {
         this.field1247 = 0;
      }

      if(this.field1251 != null) {
         this.field1251.vmethod3743(var1);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-67"
   )
   void vmethod1563(Component var1) throws Exception {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "93215286"
   )
   void vmethod1549(int var1) throws Exception {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1681968704"
   )
   int vmethod1552() throws Exception {
      return this.field1238;
   }

   @ObfuscatedName("v")
   void vmethod1551() throws Exception {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1952324551"
   )
   void vmethod1550() {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1836293824"
   )
   void vmethod1553() throws Exception {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-395705396"
   )
   public final synchronized void method1239() {
      if(null != this.field1234) {
         long var1 = class34.method738();

         try {
            if(this.field1241 != 0L) {
               if(var1 < this.field1241) {
                  return;
               }

               this.vmethod1549(this.field1238);
               this.field1241 = 0L;
               this.field1246 = true;
            }

            int var3 = this.vmethod1552();
            if(this.field1244 - var3 > this.field1242) {
               this.field1242 = this.field1244 - var3;
            }

            int var4 = this.field1230 + this.field1232;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1238) {
               this.field1238 += 1024;
               if(this.field1238 > 16384) {
                  this.field1238 = 16384;
               }

               this.vmethod1550();
               this.vmethod1549(this.field1238);
               var3 = 0;
               this.field1246 = true;
               if(var4 + 256 > this.field1238) {
                  var4 = this.field1238 - 256;
                  this.field1232 = var4 - this.field1230;
               }
            }

            while(var3 < var4) {
               this.method1245(this.field1234, 256);
               this.vmethod1551();
               var3 += 256;
            }

            if(var1 > this.field1245) {
               if(!this.field1246) {
                  if(this.field1242 == 0 && this.field1243 == 0) {
                     this.vmethod1550();
                     this.field1241 = var1 + 2000L;
                     return;
                  }

                  this.field1232 = Math.min(this.field1243, this.field1242);
                  this.field1243 = this.field1242;
               } else {
                  this.field1246 = false;
               }

               this.field1242 = 0;
               this.field1245 = var1 + 2000L;
            }

            this.field1244 = var3;
         } catch (Exception var7) {
            this.vmethod1550();
            this.field1241 = 2000L + var1;
         }

         try {
            if(var1 > this.field1237 + 500000L) {
               var1 = this.field1237;
            }

            while(var1 > 5000L + this.field1237) {
               this.method1220(256);
               this.field1237 += (long)(256000 / field1239);
            }
         } catch (Exception var6) {
            this.field1237 = var1;
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1245(int[] var1, int var2) {
      int var3 = var2;
      if(class222.field3221) {
         var3 = var2 << 1;
      }

      class123.method2754(var1, 0, var3);
      this.field1247 -= var2;
      if(this.field1251 != null && this.field1247 <= 0) {
         this.field1247 += field1239 >> 4;
         class21.method545(this.field1251);
         this.method1216(this.field1251, this.field1251.vmethod1502());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class69 var10;
         label137:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if(var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class69 var11 = this.field1235[var7];

                  label131:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label131;
                        }

                        class68 var12 = var11.field1317;
                        if(null != var12 && var12.field1316 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1318;
                        } else {
                           var11.field1320 = true;
                           int var13 = var11.vmethod3745();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1316 += var13;
                           }

                           if(var4 >= this.field1236) {
                              break label137;
                           }

                           class69 var14 = var11.vmethod3756();
                           if(var14 != null) {
                              for(int var15 = var11.field1319; null != var14; var14 = var11.vmethod3744()) {
                                 this.method1216(var14, var15 * var14.vmethod1502() >> 8);
                              }
                           }

                           class69 var17 = var11.field1318;
                           var11.field1318 = null;
                           if(var10 == null) {
                              this.field1235[var7] = var17;
                           } else {
                              var10.field1318 = var17;
                           }

                           if(var17 == null) {
                              this.field1249[var7] = var10;
                           }

                           var11 = var17;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class69 var16 = this.field1235[var6];
            class69[] var18 = this.field1235;
            this.field1249[var6] = null;

            for(var18[var6] = null; null != var16; var16 = var10) {
               var10 = var16.field1318;
               var16.field1318 = null;
            }
         }
      }

      if(this.field1247 < 0) {
         this.field1247 = 0;
      }

      if(null != this.field1251) {
         this.field1251.vmethod3746(var1, 0, var2);
      }

      this.field1237 = class34.method738();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-18"
   )
   public final void method1255() {
      this.field1246 = true;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "586591522"
   )
   public static void method1257(Buffer var0, int var1) {
      if(null != class152.field2283) {
         try {
            class152.field2283.method4174(0L);
            class152.field2283.method4179(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-76"
   )
   public final synchronized void method1258() {
      if(field1240 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == field1240.field1409[var2]) {
               field1240.field1409[var2] = null;
            }

            if(field1240.field1409[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1240.field1403 = true;

            while(field1240.field1404) {
               PlayerComposition.method3511(50L);
            }

            field1240 = null;
         }
      }

      this.vmethod1550();
      this.field1234 = null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass69;I)V",
      garbageValue = "-543867871"
   )
   public final synchronized void method1262(class69 var1) {
      this.field1251 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LGameEngine;B)V",
      garbageValue = "4"
   )
   static void method1264(GameEngine var0) {
      int var1;
      int var2;
      int var3;
      int var13;
      if(class33.worldSelectShown) {
         if(class143.field2210 == 1 || !class4.field81 && class143.field2210 == 4) {
            var1 = 280 + class33.field755;
            if(class143.field2211 >= var1 && class143.field2211 <= 14 + var1 && class143.field2212 >= 4 && class143.field2212 <= 18) {
               NPCComposition.method837(0, 0);
            } else if(class143.field2211 >= 15 + var1 && class143.field2211 <= var1 + 80 && class143.field2212 >= 4 && class143.field2212 <= 18) {
               NPCComposition.method837(0, 1);
            } else {
               var2 = class33.field755 + 390;
               if(class143.field2211 >= var2 && class143.field2211 <= var2 + 14 && class143.field2212 >= 4 && class143.field2212 <= 18) {
                  NPCComposition.method837(1, 0);
               } else if(class143.field2211 >= var2 + 15 && class143.field2211 <= 80 + var2 && class143.field2212 >= 4 && class143.field2212 <= 18) {
                  NPCComposition.method837(1, 1);
               } else {
                  var3 = 500 + class33.field755;
                  if(class143.field2211 >= var3 && class143.field2211 <= 14 + var3 && class143.field2212 >= 4 && class143.field2212 <= 18) {
                     NPCComposition.method837(2, 0);
                  } else if(class143.field2211 >= var3 + 15 && class143.field2211 <= var3 + 80 && class143.field2212 >= 4 && class143.field2212 <= 18) {
                     NPCComposition.method837(2, 1);
                  } else {
                     var13 = class33.field755 + 610;
                     if(class143.field2211 >= var13 && class143.field2211 <= var13 + 14 && class143.field2212 >= 4 && class143.field2212 <= 18) {
                        NPCComposition.method837(3, 0);
                     } else if(class143.field2211 >= var13 + 15 && class143.field2211 <= 80 + var13 && class143.field2212 >= 4 && class143.field2212 <= 18) {
                        NPCComposition.method837(3, 1);
                     } else if(class143.field2211 >= class33.field755 + 708 && class143.field2212 >= 4 && class143.field2211 <= 50 + 708 + class33.field755 && class143.field2212 <= 20) {
                        class33.worldSelectShown = false;
                        class33.field745.method1748(class33.field755, 0);
                        class164.field2694.method1748(class33.field755 + 382, 0);
                        Client.field583.method1905(382 + class33.field755 - Client.field583.originalWidth / 2, 18);
                     } else if(class33.field771 != -1) {
                        World var5 = VertexNormal.worldList[class33.field771];
                        Friend.selectWorld(var5);
                        class33.worldSelectShown = false;
                        class33.field745.method1748(class33.field755, 0);
                        class164.field2694.method1748(class33.field755 + 382, 0);
                        Client.field583.method1905(382 + class33.field755 - Client.field583.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((class143.field2210 == 1 || !class4.field81 && class143.field2210 == 4) && class143.field2211 >= 765 + class33.field755 - 50 && class143.field2212 >= 453) {
            Player.field42.field157 = !Player.field42.field157;
            class127.method2819();
            if(!Player.field42.field157) {
               class171 var9 = Client.field476;
               var2 = var9.method3304("scape main");
               var3 = var9.method3305(var2, "");
               GroundObject.method2209(var9, var2, var3, 255, false);
            } else {
               Item.method659();
            }
         }

         if(Client.gameState != 5) {
            ++class33.field748;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.field310 == 0) {
                  if(class143.field2210 == 1 || !class4.field81 && class143.field2210 == 4) {
                     var1 = 5 + class33.field755;
                     short var11 = 463;
                     byte var12 = 100;
                     byte var4 = 35;
                     if(class143.field2211 >= var1 && class143.field2211 <= var1 + var12 && class143.field2212 >= var11 && class143.field2212 <= var4 + var11) {
                        class138.method2915();
                        return;
                     }
                  }

                  if(null != World.worldServersDownload) {
                     class138.method2915();
                  }
               }

               var1 = class143.field2210;
               var2 = class143.field2211;
               var3 = class143.field2212;
               if(!class4.field81 && var1 == 4) {
                  var1 = 1;
               }

               short var10;
               if(class33.loginIndex == 0) {
                  var13 = 180 + class33.loginWindowX - 80;
                  var10 = 291;
                  if(var1 == 1 && var2 >= var13 - 75 && var2 <= 75 + var13 && var3 >= var10 - 20 && var3 <= var10 + 20) {
                     class113.method2460(class118.method2485("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var13 = 80 + class33.loginWindowX + 180;
                  if(var1 == 1 && var2 >= var13 - 75 && var2 <= 75 + var13 && var3 >= var10 - 20 && var3 <= 20 + var10) {
                     if((Client.flags & 33554432) != 0) {
                        class33.field752 = "";
                        class33.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class33.loginMessage2 = "Your normal account will not be affected.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class33.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class33.loginMessage2 = "Players can attack each other almost everywhere";
                           class33.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class33.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class33.loginMessage2 = "Players can attack each other";
                           class33.loginMessage3 = "almost everywhere.";
                        }

                        class33.field752 = "Warning!";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class33.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class33.loginMessage2 = "The Protect Item prayer will";
                        class33.loginMessage3 = "not work on this world.";
                        class33.field752 = "Warning!";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     }
                  }
               } else if(class33.loginIndex != 1) {
                  short var14;
                  if(class33.loginIndex == 2) {
                     var14 = 231;
                     var13 = var14 + 30;
                     if(var1 == 1 && var3 >= var13 - 15 && var3 < var13) {
                        class33.loginIndex2 = 0;
                     }

                     var13 += 15;
                     if(var1 == 1 && var3 >= var13 - 15 && var3 < var13) {
                        class33.loginIndex2 = 1;
                     }

                     var13 += 15;
                     var14 = 361;
                     if(var1 == 1 && var3 >= var14 - 15 && var3 < var14) {
                        class5.method88("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.loginIndex = 5;
                        return;
                     }

                     int var17 = 180 + class33.loginWindowX - 80;
                     short var6 = 321;
                     if(var1 == 1 && var2 >= var17 - 75 && var2 <= var17 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                        class33.username = class33.username.trim();
                        if(class33.username.length() == 0) {
                           class5.method88("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class33.field764.length() == 0) {
                           class5.method88("", "Please enter your password.", "");
                           return;
                        }

                        class5.method88("", "Connecting to server...", "");
                        class33.field765 = Player.field42.field155.containsKey(Integer.valueOf(class167.method3259(class33.username)))?class162.field2648:class162.field2646;
                        class117.setGameState(20);
                        return;
                     }

                     var17 = 80 + 180 + class33.loginWindowX;
                     if(var1 == 1 && var2 >= var17 - 75 && var2 <= var17 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                        class33.loginIndex = 0;
                        class33.username = "";
                        class33.field764 = "";
                        class157.field2336 = 0;
                        class157.authCode = "";
                        class33.field766 = true;
                     }

                     while(true) {
                        while(NPC.method758()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class129.field2093 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(class20.field597 == 13) {
                              class33.loginIndex = 0;
                              class33.username = "";
                              class33.field764 = "";
                              class157.field2336 = 0;
                              class157.authCode = "";
                              class33.field766 = true;
                           } else if(class33.loginIndex2 == 0) {
                              if(class20.field597 == 85 && class33.username.length() > 0) {
                                 class33.username = class33.username.substring(0, class33.username.length() - 1);
                              }

                              if(class20.field597 == 84 || class20.field597 == 80) {
                                 class33.loginIndex2 = 1;
                              }

                              if(var7 && class33.username.length() < 320) {
                                 class33.username = class33.username + class129.field2093;
                              }
                           } else if(class33.loginIndex2 == 1) {
                              if(class20.field597 == 85 && class33.field764.length() > 0) {
                                 class33.field764 = class33.field764.substring(0, class33.field764.length() - 1);
                              }

                              if(class20.field597 == 84 || class20.field597 == 80) {
                                 class33.loginIndex2 = 0;
                              }

                              if(class20.field597 == 84) {
                                 class33.username = class33.username.trim();
                                 if(class33.username.length() == 0) {
                                    class5.method88("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class33.field764.length() == 0) {
                                    class5.method88("", "Please enter your password.", "");
                                    return;
                                 }

                                 class5.method88("", "Connecting to server...", "");
                                 class33.field765 = Player.field42.field155.containsKey(Integer.valueOf(class167.method3259(class33.username)))?class162.field2648:class162.field2646;
                                 class117.setGameState(20);
                                 return;
                              }

                              if(var7 && class33.field764.length() < 20) {
                                 class33.field764 = class33.field764 + class129.field2093;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class33.loginIndex == 3) {
                     var13 = class33.loginWindowX + 180;
                     var10 = 276;
                     if(var1 == 1 && var2 >= var13 - 75 && var2 <= 75 + var13 && var3 >= var10 - 20 && var3 <= 20 + var10) {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     }

                     var13 = class33.loginWindowX + 180;
                     var10 = 326;
                     if(var1 == 1 && var2 >= var13 - 75 && var2 <= 75 + var13 && var3 >= var10 - 20 && var3 <= 20 + var10) {
                        class5.method88("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.loginIndex = 5;
                        return;
                     }
                  } else {
                     boolean var15;
                     int var16;
                     if(class33.loginIndex == 4) {
                        var13 = 180 + class33.loginWindowX - 80;
                        var10 = 321;
                        if(var1 == 1 && var2 >= var13 - 75 && var2 <= 75 + var13 && var3 >= var10 - 20 && var3 <= 20 + var10) {
                           class157.authCode.trim();
                           if(class157.authCode.length() != 6) {
                              class5.method88("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class157.field2336 = Integer.parseInt(class157.authCode);
                           class157.authCode = "";
                           class33.field765 = class33.field766?class162.field2645:class162.field2644;
                           class5.method88("", "Connecting to server...", "");
                           class117.setGameState(20);
                           return;
                        }

                        if(var1 == 1 && var2 >= 180 + class33.loginWindowX - 9 && var2 <= 130 + 180 + class33.loginWindowX && var3 >= 263 && var3 <= 296) {
                           class33.field766 = !class33.field766;
                        }

                        if(var1 == 1 && var2 >= class33.loginWindowX + 180 - 34 && var2 <= 34 + class33.loginWindowX + 180 && var3 >= 351 && var3 <= 363) {
                           class113.method2460(class118.method2485("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var13 = class33.loginWindowX + 180 + 80;
                        if(var1 == 1 && var2 >= var13 - 75 && var2 <= 75 + var13 && var3 >= var10 - 20 && var3 <= var10 + 20) {
                           class33.loginIndex = 0;
                           class33.username = "";
                           class33.field764 = "";
                           class157.field2336 = 0;
                           class157.authCode = "";
                        }

                        while(NPC.method758()) {
                           var15 = false;

                           for(var16 = 0; var16 < "1234567890".length(); ++var16) {
                              if(class129.field2093 == "1234567890".charAt(var16)) {
                                 var15 = true;
                                 break;
                              }
                           }

                           if(class20.field597 == 13) {
                              class33.loginIndex = 0;
                              class33.username = "";
                              class33.field764 = "";
                              class157.field2336 = 0;
                              class157.authCode = "";
                           } else {
                              if(class20.field597 == 85 && class157.authCode.length() > 0) {
                                 class157.authCode = class157.authCode.substring(0, class157.authCode.length() - 1);
                              }

                              if(class20.field597 == 84) {
                                 class157.authCode.trim();
                                 if(class157.authCode.length() != 6) {
                                    class5.method88("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class157.field2336 = Integer.parseInt(class157.authCode);
                                 class157.authCode = "";
                                 class33.field765 = class33.field766?class162.field2645:class162.field2644;
                                 class5.method88("", "Connecting to server...", "");
                                 class117.setGameState(20);
                                 return;
                              }

                              if(var15 && class157.authCode.length() < 6) {
                                 class157.authCode = class157.authCode + class129.field2093;
                              }
                           }
                        }
                     } else if(class33.loginIndex == 5) {
                        var13 = class33.loginWindowX + 180 - 80;
                        var10 = 321;
                        if(var1 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var10 - 20 && var3 <= 20 + var10) {
                           ItemComposition.method1167();
                           return;
                        }

                        var13 = 80 + class33.loginWindowX + 180;
                        if(var1 == 1 && var2 >= var13 - 75 && var2 <= 75 + var13 && var3 >= var10 - 20 && var3 <= 20 + var10) {
                           class33.loginMessage1 = "";
                           class33.loginMessage2 = "Enter your username/email & password.";
                           class33.loginMessage3 = "";
                           class33.loginIndex = 2;
                           class33.loginIndex2 = 0;
                           class33.field764 = "";
                        }

                        while(NPC.method758()) {
                           var15 = false;

                           for(var16 = 0; var16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var16) {
                              if(class129.field2093 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var16)) {
                                 var15 = true;
                                 break;
                              }
                           }

                           if(class20.field597 == 13) {
                              class33.loginMessage1 = "";
                              class33.loginMessage2 = "Enter your username/email & password.";
                              class33.loginMessage3 = "";
                              class33.loginIndex = 2;
                              class33.loginIndex2 = 0;
                              class33.field764 = "";
                           } else {
                              if(class20.field597 == 85 && class33.username.length() > 0) {
                                 class33.username = class33.username.substring(0, class33.username.length() - 1);
                              }

                              if(class20.field597 == 84) {
                                 ItemComposition.method1167();
                                 return;
                              }

                              if(var15 && class33.username.length() < 320) {
                                 class33.username = class33.username + class129.field2093;
                              }
                           }
                        }
                     } else if(class33.loginIndex == 6) {
                        while(true) {
                           do {
                              if(!NPC.method758()) {
                                 var14 = 321;
                                 if(var1 == 1 && var3 >= var14 - 20 && var3 <= var14 + 20) {
                                    class33.loginMessage1 = "";
                                    class33.loginMessage2 = "Enter your username/email & password.";
                                    class33.loginMessage3 = "";
                                    class33.loginIndex = 2;
                                    class33.loginIndex2 = 0;
                                    class33.field764 = "";
                                 }

                                 return;
                              }
                           } while(class20.field597 != 84 && class20.field597 != 13);

                           class33.loginMessage1 = "";
                           class33.loginMessage2 = "Enter your username/email & password.";
                           class33.loginMessage3 = "";
                           class33.loginIndex = 2;
                           class33.loginIndex2 = 0;
                           class33.field764 = "";
                        }
                     }
                  }
               } else {
                  while(NPC.method758()) {
                     if(class20.field597 == 84) {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     } else if(class20.field597 == 13) {
                        class33.loginIndex = 0;
                     }
                  }

                  var13 = class33.loginWindowX + 180 - 80;
                  var10 = 321;
                  if(var1 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var10 - 20 && var3 <= 20 + var10) {
                     class33.loginMessage1 = "";
                     class33.loginMessage2 = "Enter your username/email & password.";
                     class33.loginMessage3 = "";
                     class33.loginIndex = 2;
                     class33.loginIndex2 = 0;
                  }

                  var13 = 80 + class33.loginWindowX + 180;
                  if(var1 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var10 - 20 && var3 <= 20 + var10) {
                     class33.loginIndex = 0;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIIS)V",
      garbageValue = "128"
   )
   static final void method1266(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod783()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(var6.field938 != null) {
               var6 = var6.method813();
            }

            if(null == var6) {
               return;
            }
         }

         int var74 = class34.field779;
         int[] var7 = class34.field786;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.field860.method3884()) {
            class0.method2(var0, 15 + var0.field870);

            for(class26 var75 = (class26)var0.field860.method3881(); var75 != null; var75 = (class26)var0.field860.method3883()) {
               class20 var10 = var75.method585(Client.gameCycle);
               if(null == var10) {
                  if(var75.method582()) {
                     var75.unlink();
                  }
               } else {
                  class49 var11 = var75.field662;
                  SpritePixels var12 = var11.method1004();
                  SpritePixels var13 = var11.method1003();
                  int var76 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field1080 * 2 < var13.width) {
                        var76 = var11.field1080;
                     }

                     var14 = var13.width - var76 * 2;
                  } else {
                     var14 = var11.field1085;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field594;
                  int var19 = var14 * var10.field591 / var11.field1085;
                  int var20;
                  int var86;
                  if(var10.field592 > var18) {
                     var20 = var11.field1079 == 0?0:var18 / var11.field1079 * var11.field1079;
                     var21 = var10.field590 * var14 / var11.field1085;
                     var86 = var21 + (var19 - var21) * var20 / var10.field592;
                  } else {
                     var86 = var19;
                     var20 = var11.field1087 + var10.field592 - var18;
                     if(var11.field1086 >= 0) {
                        var16 = (var20 << 8) / (var11.field1087 - var11.field1086);
                     }
                  }

                  if(var10.field591 > 0 && var86 < 1) {
                     var86 = 1;
                  }

                  var20 = Client.field445 + var2 - (var14 >> 1);
                  var21 = var3 + Client.field418 - var8;
                  if(var12 != null && var13 != null) {
                     var20 -= var76;
                     if(var14 == var86) {
                        var86 += 2 * var76;
                     } else {
                        var86 += var76;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method1756(var20, var21, var16);
                        class82.method1828(var20, var21, var20 + var86, var22 + var21);
                        var13.method1756(var20, var21, var16);
                     } else {
                        var12.method1810(var20, var21);
                        class82.method1828(var20, var21, var20 + var86, var22 + var21);
                        var13.method1810(var20, var21);
                     }

                     class82.method1831(var2, var3, var2 + var4, var5 + var3);
                     var8 += 2;
                  } else {
                     if(Client.field445 > -1) {
                        class82.method1853(var20, var21, var86, 5, '\uff00');
                        class82.method1853(var86 + var20, var21, var14 - var86, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var74) {
            Player var88 = (Player)var0;
            if(var88.field45) {
               return;
            }

            if(var88.field40 != -1 || var88.field34 != -1) {
               class0.method2(var0, var0.field870 + 15);
               if(Client.field445 > -1) {
                  if(var88.field40 != -1) {
                     WidgetNode.field64[var88.field40].method1810(Client.field445 + var2 - 12, var3 + Client.field418 - var8);
                     var8 += 25;
                  }

                  if(var88.field34 != -1) {
                     class75.field1401[var88.field34].method1810(var2 + Client.field445 - 12, var3 + Client.field418 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field306 == 10 && var7[var1] == Client.field320) {
               class0.method2(var0, var0.field870 + 15);
               if(Client.field445 > -1) {
                  class137.field2130[1].method1810(var2 + Client.field445 - 12, Client.field418 + var3 - var8);
               }
            }
         } else {
            NPCComposition var89 = ((NPC)var0).composition;
            if(null != var89.field938) {
               var89 = var89.method813();
            }

            if(var89.field935 >= 0 && var89.field935 < class75.field1401.length) {
               class0.method2(var0, 15 + var0.field870);
               if(Client.field445 > -1) {
                  class75.field1401[var89.field935].method1810(var2 + Client.field445 - 12, var3 + Client.field418 - 30);
               }
            }

            if(Client.field306 == 1 && Client.field319 == Client.field342[var1 - var74] && Client.gameCycle % 20 < 10) {
               class0.method2(var0, 15 + var0.field870);
               if(Client.field445 > -1) {
                  class137.field2130[0].method1810(var2 + Client.field445 - 12, Client.field418 + var3 - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.field518 == 4 || !var0.field849 && (Client.field518 == 0 || Client.field518 == 3 || Client.field518 == 1 && class0.method0(((Player)var0).name, false))))) {
            class0.method2(var0, var0.field870);
            if(Client.field445 > -1 && Client.field396 < Client.field397) {
               Client.field401[Client.field396] = MessageNode.field811.method4062(var0.overhead) / 2;
               Client.field400[Client.field396] = MessageNode.field811.field3243;
               Client.field467[Client.field396] = Client.field445;
               Client.field399[Client.field396] = Client.field418;
               Client.field565[Client.field396] = var0.field852;
               Client.field376[Client.field396] = var0.field891;
               Client.field404[Client.field396] = var0.field847;
               Client.field405[Client.field396] = var0.overhead;
               ++Client.field396;
            }
         }

         for(int var9 = 0; var9 < 4; ++var9) {
            int var79 = var0.field875[var9];
            int var81 = var0.field877[var9];
            class51 var85 = null;
            int var80 = 0;
            if(var81 >= 0) {
               if(var79 <= Client.gameCycle) {
                  continue;
               }

               var85 = class180.method3491(var0.field877[var9]);
               var80 = var85.field1112;
               if(var85 != null && var85.field1104 != null) {
                  var85 = var85.method1037();
                  if(var85 == null) {
                     var0.field875[var9] = -1;
                     continue;
                  }
               }
            } else if(var79 < 0) {
               continue;
            }

            var14 = var0.field869[var9];
            class51 var15 = null;
            if(var14 >= 0) {
               var15 = class180.method3491(var14);
               if(var15 != null && null != var15.field1104) {
                  var15 = var15.method1037();
               }
            }

            if(var79 - var80 <= Client.gameCycle) {
               if(null == var85) {
                  var0.field875[var9] = -1;
               } else {
                  class0.method2(var0, var0.field870 / 2);
                  if(Client.field445 > -1) {
                     if(var9 == 1) {
                        Client.field418 -= 20;
                     }

                     if(var9 == 2) {
                        Client.field445 -= 15;
                        Client.field418 -= 10;
                     }

                     if(var9 == 3) {
                        Client.field445 += 15;
                        Client.field418 -= 10;
                     }

                     SpritePixels var77 = null;
                     SpritePixels var83 = null;
                     SpritePixels var82 = null;
                     SpritePixels var78 = null;
                     var21 = 0;
                     var22 = 0;
                     int var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     SpritePixels var29 = null;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     var77 = var85.method1039();
                     int var42;
                     if(var77 != null) {
                        var21 = var77.width;
                        var42 = var77.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var77.field1458;
                     }

                     var83 = var85.method1040();
                     if(null != var83) {
                        var22 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var83.field1458;
                     }

                     var82 = var85.method1041();
                     if(null != var82) {
                        var23 = var82.width;
                        var42 = var82.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var82.field1458;
                     }

                     var78 = var85.method1042();
                     if(null != var78) {
                        var24 = var78.width;
                        var42 = var78.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var78.field1458;
                     }

                     if(var15 != null) {
                        var29 = var15.method1039();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.field1458;
                        }

                        var30 = var15.method1040();
                        if(null != var30) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.field1458;
                        }

                        var31 = var15.method1041();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.field1458;
                        }

                        var32 = var15.method1042();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.field1458;
                        }
                     }

                     class227 var84 = var85.method1059();
                     if(var84 == null) {
                        var84 = class32.field737;
                     }

                     class227 var43;
                     if(null != var15) {
                        var43 = var15.method1059();
                        if(null == var43) {
                           var43 = class32.field737;
                        }
                     } else {
                        var43 = class32.field737;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var85.method1038(var0.field848[var9]);
                     int var87 = var84.method4062(var44);
                     if(var15 != null) {
                        var45 = var15.method1038(var0.field840[var9]);
                        var47 = var43.method4062(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(null == var82 && null == var78) {
                           var48 = 1;
                        } else {
                           var48 = 1 + var87 / var22;
                        }
                     }

                     if(var15 != null && var34 > 0) {
                        if(null == var31 && var32 == null) {
                           var49 = 1;
                        } else {
                           var49 = var47 / var34 + 1;
                        }
                     }

                     int var50 = 0;
                     int var51 = var50;
                     if(var21 > 0) {
                        var50 += var21;
                     }

                     var50 += 2;
                     int var52 = var50;
                     if(var23 > 0) {
                        var50 += var23;
                     }

                     int var53 = var50;
                     int var54 = var50;
                     int var55;
                     if(var22 > 0) {
                        var55 = var48 * var22;
                        var50 += var55;
                        var54 += (var55 - var87) / 2;
                     } else {
                        var50 += var87;
                     }

                     var55 = var50;
                     if(var24 > 0) {
                        var50 += var24;
                     }

                     int var56 = 0;
                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61;
                     if(var15 != null) {
                        var50 += 2;
                        var56 = var50;
                        if(var33 > 0) {
                           var50 += var33;
                        }

                        var50 += 2;
                        var57 = var50;
                        if(var35 > 0) {
                           var50 += var35;
                        }

                        var58 = var50;
                        var60 = var50;
                        if(var34 > 0) {
                           var61 = var49 * var34;
                           var50 += var61;
                           var60 += (var61 - var47) / 2;
                        } else {
                           var50 += var47;
                        }

                        var59 = var50;
                        if(var36 > 0) {
                           var50 += var36;
                        }
                     }

                     var61 = var0.field875[var9] - Client.gameCycle;
                     int var62 = var85.field1117 - var85.field1117 * var61 / var85.field1112;
                     int var63 = var85.field1118 * var61 / var85.field1112 + -var85.field1118;
                     int var64 = var62 + (var2 + Client.field445 - (var50 >> 1));
                     int var65 = Client.field418 + var3 - 12 + var63;
                     int var66 = var65;
                     int var67 = var65 + var41;
                     int var68 = var85.field1122 + var65 + 15;
                     int var69 = var68 - var84.field3244;
                     int var70 = var84.field3249 + var68;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(var15 != null) {
                        var71 = 15 + var65 + var15.field1122;
                        var72 = var71 - var43.field3244;
                        var73 = var43.field3249 + var71;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var85.field1119 >= 0) {
                        var72 = (var61 << 8) / (var85.field1112 - var85.field1119);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var77 != null) {
                           var77.method1756(var64 + var51 - var25, var65, var72);
                        }

                        if(var82 != null) {
                           var82.method1756(var64 + var52 - var27, var65, var72);
                        }

                        if(null != var83) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var83.method1756(var22 * var73 + (var64 + var53 - var26), var65, var72);
                           }
                        }

                        if(null != var78) {
                           var78.method1756(var64 + var55 - var28, var65, var72);
                        }

                        var84.method4068(var44, var54 + var64, var68, var85.field1111, 0, var72);
                        if(null != var15) {
                           if(var29 != null) {
                              var29.method1756(var64 + var56 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method1756(var64 + var57 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method1756(var64 + var58 - var38 + var34 * var73, var65, var72);
                              }
                           }

                           if(null != var32) {
                              var32.method1756(var64 + var59 - var40, var65, var72);
                           }

                           var43.method4068(var45, var64 + var60, var71, var15.field1111, 0, var72);
                        }
                     } else {
                        if(var77 != null) {
                           var77.method1810(var64 + var51 - var25, var65);
                        }

                        if(var82 != null) {
                           var82.method1810(var52 + var64 - var27, var65);
                        }

                        if(null != var83) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var83.method1810(var64 + var53 - var26 + var73 * var22, var65);
                           }
                        }

                        if(var78 != null) {
                           var78.method1810(var55 + var64 - var28, var65);
                        }

                        var84.method4124(var44, var64 + var54, var68, var85.field1111 | -16777216, 0);
                        if(var15 != null) {
                           if(var29 != null) {
                              var29.method1810(var64 + var56 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method1810(var57 + var64 - var39, var65);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method1810(var64 + var58 - var38 + var73 * var34, var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method1810(var64 + var59 - var40, var65);
                           }

                           var43.method4124(var45, var60 + var64, var71, var15.field1111 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "24"
   )
   static final void method1267() {
      class48.field1067.reset();
      class43.field996.reset();
      NPC.method757();
      class16.method190();
      WidgetNode.method50();
      ItemComposition.field1167.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      class32.method677();
      class45.field1029.reset();
      class45.field1030.reset();
      class0.method1();
      class56.field1223.reset();
      class51.field1108.reset();
      class51.spriteCache.reset();
      class51.field1106.reset();
      ItemComposition.method1166();
      class178.method3476();
      Widget.field2901.reset();
      Widget.field2817.reset();
      Widget.field2798.reset();
      Widget.field2799.reset();
      ((TextureProvider)class94.field1638).method2215();
      class23.field621.reset();
      Client.field331.method3302();
      class114.field2007.method3302();
      class21.field598.method3302();
      class109.field1929.method3302();
      class9.field173.method3302();
      Client.field476.method3302();
      VertexNormal.field1688.method3302();
      ItemComposition.field1199.method3302();
      Client.field333.method3302();
      class139.field2139.method3302();
      class5.field104.method3302();
      class116.field2015.method3302();
   }
}
