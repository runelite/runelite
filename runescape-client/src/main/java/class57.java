import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class57 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1656924149
   )
   int field1030 = 32;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -375214171
   )
   public static int field1031;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 591307629
   )
   public static int field1032;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 186876607
   )
   int field1033 = 0;
   @ObfuscatedName("i")
   boolean field1034 = true;
   @ObfuscatedName("c")
   int[] field1035;
   @ObfuscatedName("t")
   class68[] field1036 = new class68[8];
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 8820761556846533201L
   )
   long field1038 = class202.method3838();
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1040944613
   )
   int field1039;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1114991193
   )
   int field1040;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1693936805
   )
   int field1041;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 3563423922897883743L
   )
   long field1042 = 0L;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1995506443
   )
   int field1043 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1940609149
   )
   int field1044 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 927237507
   )
   int field1045 = 0;
   @ObfuscatedName("d")
   public static boolean field1046;
   @ObfuscatedName("p")
   class68 field1047;
   @ObfuscatedName("av")
   class68[] field1052 = new class68[8];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 1315467374478999425L
   )
   long field1053 = 0L;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass68;I)V",
      garbageValue = "359270614"
   )
   public final synchronized void method1041(class68 var1) {
      this.field1047 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-601444725"
   )
   final void method1042(int var1) {
      this.field1033 -= var1;
      if(this.field1033 < 0) {
         this.field1033 = 0;
      }

      if(null != this.field1047) {
         this.field1047.vmethod2752(var1);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1498636174"
   )
   void vmethod1117() throws Exception {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "540892453"
   )
   public final synchronized void method1044() {
      this.field1034 = true;

      try {
         this.vmethod1117();
      } catch (Exception var2) {
         this.vmethod1111();
         this.field1042 = class202.method3838() + 2000L;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-159108584"
   )
   public final synchronized void method1045() {
      if(this.field1035 != null) {
         long var1 = class202.method3838();

         try {
            if(this.field1042 != 0L) {
               if(var1 < this.field1042) {
                  return;
               }

               this.vmethod1108(this.field1039);
               this.field1042 = 0L;
               this.field1034 = true;
            }

            int var3 = this.vmethod1109();
            if(this.field1045 - var3 > this.field1043) {
               this.field1043 = this.field1045 - var3;
            }

            int var4 = this.field1040 + this.field1041;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1039) {
               this.field1039 += 1024;
               if(this.field1039 > 16384) {
                  this.field1039 = 16384;
               }

               this.vmethod1111();
               this.vmethod1108(this.field1039);
               var3 = 0;
               this.field1034 = true;
               if(256 + var4 > this.field1039) {
                  var4 = this.field1039 - 256;
                  this.field1041 = var4 - this.field1040;
               }
            }

            while(var3 < var4) {
               this.method1047(this.field1035, 256);
               this.vmethod1110();
               var3 += 256;
            }

            if(var1 > this.field1053) {
               if(!this.field1034) {
                  if(this.field1043 == 0 && this.field1044 == 0) {
                     this.vmethod1111();
                     this.field1042 = var1 + 2000L;
                     return;
                  }

                  this.field1041 = Math.min(this.field1044, this.field1043);
                  this.field1044 = this.field1043;
               } else {
                  this.field1034 = false;
               }

               this.field1043 = 0;
               this.field1053 = var1 + 2000L;
            }

            this.field1045 = var3;
         } catch (Exception var7) {
            this.vmethod1111();
            this.field1042 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1038) {
               var1 = this.field1038;
            }

            while(var1 > 5000L + this.field1038) {
               this.method1042(256);
               this.field1038 += (long)(256000 / field1031);
            }
         } catch (Exception var6) {
            this.field1038 = var1;
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-58"
   )
   public final void method1046() {
      this.field1034 = true;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1047(int[] var1, int var2) {
      int var3 = var2;
      if(field1046) {
         var3 = var2 << 1;
      }

      class170.method3293(var1, 0, var3);
      this.field1033 -= var2;
      if(null != this.field1047 && this.field1033 <= 0) {
         this.field1033 += field1031 >> 4;
         class0.method9(this.field1047);
         this.method1092(this.field1047, this.field1047.vmethod1370());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class68 var10;
         label138:
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
                  class68 var11 = this.field1036[var7];

                  label132:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label132;
                        }

                        class71 var12 = var11.field1135;
                        if(null != var12 && var12.field1167 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1134;
                        } else {
                           var11.field1133 = true;
                           int var13 = var11.vmethod2751();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1167 += var13;
                           }

                           if(var4 >= this.field1030) {
                              break label138;
                           }

                           class68 var14 = var11.vmethod2748();
                           if(var14 != null) {
                              for(int var17 = var11.field1136; null != var14; var14 = var11.vmethod2750()) {
                                 this.method1092(var14, var17 * var14.vmethod1370() >> 8);
                              }
                           }

                           class68 var15 = var11.field1134;
                           var11.field1134 = null;
                           if(var10 == null) {
                              this.field1036[var7] = var15;
                           } else {
                              var10.field1134 = var15;
                           }

                           if(null == var15) {
                              this.field1052[var7] = var10;
                           }

                           var11 = var15;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class68 var18 = this.field1036[var6];
            class68[] var16 = this.field1036;
            this.field1052[var6] = null;

            for(var16[var6] = null; null != var18; var18 = var10) {
               var10 = var18.field1134;
               var18.field1134 = null;
            }
         }
      }

      if(this.field1033 < 0) {
         this.field1033 = 0;
      }

      if(null != this.field1047) {
         this.field1047.vmethod2764(var1, 0, var2);
      }

      this.field1038 = class202.method3838();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "4"
   )
   void vmethod1115(Component var1) throws Exception {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1033997061"
   )
   int vmethod1109() throws Exception {
      return this.field1039;
   }

   @ObfuscatedName("f")
   void vmethod1110() throws Exception {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-652516171"
   )
   void vmethod1111() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "852764108"
   )
   public static boolean method1054(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "730327635"
   )
   public final synchronized void method1058() {
      if(class231.field3280 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class231.field3280.field1080[var2]) {
               class231.field3280.field1080[var2] = null;
            }

            if(null != class231.field3280.field1080[var2]) {
               var1 = false;
            }
         }

         if(var1) {
            class231.field3280.field1084 = true;

            while(class231.field3280.field1082) {
               class0.method12(50L);
            }

            class231.field3280 = null;
         }
      }

      this.vmethod1111();
      this.field1035 = null;
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-429126478"
   )
   static void method1064() {
      if(Client.field440) {
         Widget var0 = XGrandExchangeOffer.method69(Friend.field147, Client.field441);
         if(null != var0 && var0.field2161 != null) {
            class18 var1 = new class18();
            var1.field192 = var0;
            var1.field196 = var0.field2161;
            class164.method3225(var1, 200000);
         }

         Client.field440 = false;
         Tile.method1577(var0);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2028462161"
   )
   void vmethod1108(int var1) throws Exception {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-518832641"
   )
   public static void method1090(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class105.keyboard);
      var0.addFocusListener(class105.keyboard);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass68;II)V",
      garbageValue = "-1815690295"
   )
   final void method1092(class68 var1, int var2) {
      int var3 = var2 >> 5;
      class68 var4 = this.field1052[var3];
      if(var4 == null) {
         this.field1036[var3] = var1;
      } else {
         var4.field1134 = var1;
      }

      this.field1052[var3] = var1;
      var1.field1136 = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "-1769902706"
   )
   static void method1093(GameEngine var0) {
      int var1;
      int var2;
      int var3;
      int var13;
      if(class41.worldSelectShown) {
         if(class115.field1808 == 1 || !MessageNode.field229 && class115.field1808 == 4) {
            var1 = class41.field848 + 280;
            if(class115.field1809 >= var1 && class115.field1809 <= 14 + var1 && class115.field1806 >= 4 && class115.field1806 <= 18) {
               Ignore.method207(0, 0);
            } else if(class115.field1809 >= 15 + var1 && class115.field1809 <= var1 + 80 && class115.field1806 >= 4 && class115.field1806 <= 18) {
               Ignore.method207(0, 1);
            } else {
               var2 = 390 + class41.field848;
               if(class115.field1809 >= var2 && class115.field1809 <= var2 + 14 && class115.field1806 >= 4 && class115.field1806 <= 18) {
                  Ignore.method207(1, 0);
               } else if(class115.field1809 >= 15 + var2 && class115.field1809 <= var2 + 80 && class115.field1806 >= 4 && class115.field1806 <= 18) {
                  Ignore.method207(1, 1);
               } else {
                  var3 = 500 + class41.field848;
                  if(class115.field1809 >= var3 && class115.field1809 <= var3 + 14 && class115.field1806 >= 4 && class115.field1806 <= 18) {
                     Ignore.method207(2, 0);
                  } else if(class115.field1809 >= 15 + var3 && class115.field1809 <= var3 + 80 && class115.field1806 >= 4 && class115.field1806 <= 18) {
                     Ignore.method207(2, 1);
                  } else {
                     var13 = class41.field848 + 610;
                     if(class115.field1809 >= var13 && class115.field1809 <= var13 + 14 && class115.field1806 >= 4 && class115.field1806 <= 18) {
                        Ignore.method207(3, 0);
                     } else if(class115.field1809 >= 15 + var13 && class115.field1809 <= var13 + 80 && class115.field1806 >= 4 && class115.field1806 <= 18) {
                        Ignore.method207(3, 1);
                     } else if(class115.field1809 >= 708 + class41.field848 && class115.field1806 >= 4 && class115.field1809 <= 708 + class41.field848 + 50 && class115.field1806 <= 20) {
                        class41.worldSelectShown = false;
                        class41.field821.method4190(class41.field848, 0);
                        class41.field822.method4190(class41.field848 + 382, 0);
                        class41.field823.method4146(class41.field848 + 382 - class41.field823.originalWidth / 2, 18);
                     } else if(class41.field849 != -1) {
                        World var9 = World.worldList[class41.field849];
                        Projectile.selectWorld(var9);
                        class41.worldSelectShown = false;
                        class41.field821.method4190(class41.field848, 0);
                        class41.field822.method4190(382 + class41.field848, 0);
                        class41.field823.method4146(382 + class41.field848 - class41.field823.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((class115.field1808 == 1 || !MessageNode.field229 && class115.field1808 == 4) && class115.field1809 >= class41.field848 + 765 - 50 && class115.field1806 >= 453) {
            Tile.field1343.field688 = !Tile.field1343.field688;
            class3.method42();
            if(!Tile.field1343.field688) {
               class184 var10 = class34.field746;
               var2 = var10.method3350("scape main");
               var3 = var10.method3345(var2, "");
               class119.method2349(var10, var2, var3, 255, false);
            } else {
               class13.method186();
            }
         }

         if(Client.gameState != 5) {
            ++class41.field852;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.field289 == 0) {
                  if(class115.field1808 == 1 || !MessageNode.field229 && class115.field1808 == 4) {
                     var1 = class41.field848 + 5;
                     short var11 = 463;
                     byte var12 = 100;
                     byte var4 = 35;
                     if(class115.field1809 >= var1 && class115.field1809 <= var1 + var12 && class115.field1806 >= var11 && class115.field1806 <= var11 + var4) {
                        if(GroundObject.loadWorlds()) {
                           class41.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(null != class206.worldServersDownload && GroundObject.loadWorlds()) {
                     class41.worldSelectShown = true;
                  }
               }

               var1 = class115.field1808;
               var2 = class115.field1809;
               var3 = class115.field1806;
               if(!MessageNode.field229 && var1 == 4) {
                  var1 = 1;
               }

               short var5;
               if(class41.loginIndex == 0) {
                  var13 = class41.loginWindowX + 180 - 80;
                  var5 = 291;
                  if(var1 == 1 && var2 >= var13 - 75 && var2 <= 75 + var13 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                     MessageNode.method217(Item.method825("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var13 = class41.loginWindowX + 180 + 80;
                  if(var1 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                     if((Client.flags & 33554432) != 0) {
                        class41.field836 = "";
                        class41.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class41.loginMessage2 = "Your normal account will not be affected.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class41.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other almost everywhere";
                           class41.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class41.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other";
                           class41.loginMessage3 = "almost everywhere.";
                        }

                        class41.field836 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class41.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class41.loginMessage2 = "The Protect Item prayer will";
                        class41.loginMessage3 = "not work on this world.";
                        class41.field836 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }
                  }
               } else if(class41.loginIndex != 1) {
                  short var14;
                  if(class41.loginIndex == 2) {
                     var14 = 231;
                     var13 = var14 + 30;
                     if(var1 == 1 && var3 >= var13 - 15 && var3 < var13) {
                        class41.loginIndex2 = 0;
                     }

                     var13 += 15;
                     if(var1 == 1 && var3 >= var13 - 15 && var3 < var13) {
                        class41.loginIndex2 = 1;
                     }

                     var13 += 15;
                     var14 = 361;
                     if(var1 == 1 && var3 >= var14 - 15 && var3 < var14) {
                        class3.method44("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class41.loginIndex = 5;
                        return;
                     }

                     int var15 = class41.loginWindowX + 180 - 80;
                     short var6 = 321;
                     if(var1 == 1 && var2 >= var15 - 75 && var2 <= 75 + var15 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                        class41.username = class41.username.trim();
                        if(class41.username.length() == 0) {
                           class3.method44("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class41.field834.length() == 0) {
                           class3.method44("", "Please enter your password.", "");
                           return;
                        }

                        class3.method44("", "Connecting to server...", "");
                        class41.field842 = Tile.field1343.field693.containsKey(Integer.valueOf(class152.method2924(class41.username)))?class97.field1627:class97.field1625;
                        class186.setGameState(20);
                        return;
                     }

                     var15 = 180 + class41.loginWindowX + 80;
                     if(var1 == 1 && var2 >= var15 - 75 && var2 <= var15 + 75 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                        class41.loginIndex = 0;
                        class41.username = "";
                        class41.field834 = "";
                        class60.field1075 = 0;
                        class22.authCode = "";
                        class41.field843 = true;
                     }

                     while(true) {
                        while(NPC.method748()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class164.field2317 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(class2.field25 == 13) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field834 = "";
                              class60.field1075 = 0;
                              class22.authCode = "";
                              class41.field843 = true;
                           } else if(class41.loginIndex2 == 0) {
                              if(class2.field25 == 85 && class41.username.length() > 0) {
                                 class41.username = class41.username.substring(0, class41.username.length() - 1);
                              }

                              if(class2.field25 == 84 || class2.field25 == 80) {
                                 class41.loginIndex2 = 1;
                              }

                              if(var7 && class41.username.length() < 320) {
                                 class41.username = class41.username + class164.field2317;
                              }
                           } else if(class41.loginIndex2 == 1) {
                              if(class2.field25 == 85 && class41.field834.length() > 0) {
                                 class41.field834 = class41.field834.substring(0, class41.field834.length() - 1);
                              }

                              if(class2.field25 == 84 || class2.field25 == 80) {
                                 class41.loginIndex2 = 0;
                              }

                              if(class2.field25 == 84) {
                                 class41.username = class41.username.trim();
                                 if(class41.username.length() == 0) {
                                    class3.method44("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class41.field834.length() == 0) {
                                    class3.method44("", "Please enter your password.", "");
                                    return;
                                 }

                                 class3.method44("", "Connecting to server...", "");
                                 class41.field842 = Tile.field1343.field693.containsKey(Integer.valueOf(class152.method2924(class41.username)))?class97.field1627:class97.field1625;
                                 class186.setGameState(20);
                                 return;
                              }

                              if(var7 && class41.field834.length() < 20) {
                                 class41.field834 = class41.field834 + class164.field2317;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class41.loginIndex == 3) {
                     var13 = class41.loginWindowX + 180;
                     var5 = 276;
                     if(var1 == 1 && var2 >= var13 - 75 && var2 <= 75 + var13 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }

                     var13 = 180 + class41.loginWindowX;
                     var5 = 326;
                     if(var1 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                        class3.method44("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class41.loginIndex = 5;
                        return;
                     }
                  } else {
                     boolean var16;
                     int var17;
                     if(class41.loginIndex == 4) {
                        var13 = 180 + class41.loginWindowX - 80;
                        var5 = 321;
                        if(var1 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                           class22.authCode.trim();
                           if(class22.authCode.length() != 6) {
                              class3.method44("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class60.field1075 = Integer.parseInt(class22.authCode);
                           class22.authCode = "";
                           class41.field842 = class41.field843?class97.field1624:class97.field1626;
                           class3.method44("", "Connecting to server...", "");
                           class186.setGameState(20);
                           return;
                        }

                        if(var1 == 1 && var2 >= class41.loginWindowX + 180 - 9 && var2 <= 130 + 180 + class41.loginWindowX && var3 >= 263 && var3 <= 296) {
                           class41.field843 = !class41.field843;
                        }

                        if(var1 == 1 && var2 >= class41.loginWindowX + 180 - 34 && var2 <= class41.loginWindowX + 180 + 34 && var3 >= 351 && var3 <= 363) {
                           MessageNode.method217(Item.method825("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var13 = 180 + class41.loginWindowX + 80;
                        if(var1 == 1 && var2 >= var13 - 75 && var2 <= 75 + var13 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                           class41.loginIndex = 0;
                           class41.username = "";
                           class41.field834 = "";
                           class60.field1075 = 0;
                           class22.authCode = "";
                        }

                        while(NPC.method748()) {
                           var16 = false;

                           for(var17 = 0; var17 < "1234567890".length(); ++var17) {
                              if(class164.field2317 == "1234567890".charAt(var17)) {
                                 var16 = true;
                                 break;
                              }
                           }

                           if(class2.field25 == 13) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field834 = "";
                              class60.field1075 = 0;
                              class22.authCode = "";
                           } else {
                              if(class2.field25 == 85 && class22.authCode.length() > 0) {
                                 class22.authCode = class22.authCode.substring(0, class22.authCode.length() - 1);
                              }

                              if(class2.field25 == 84) {
                                 class22.authCode.trim();
                                 if(class22.authCode.length() != 6) {
                                    class3.method44("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class60.field1075 = Integer.parseInt(class22.authCode);
                                 class22.authCode = "";
                                 class41.field842 = class41.field843?class97.field1624:class97.field1626;
                                 class3.method44("", "Connecting to server...", "");
                                 class186.setGameState(20);
                                 return;
                              }

                              if(var16 && class22.authCode.length() < 6) {
                                 class22.authCode = class22.authCode + class164.field2317;
                              }
                           }
                        }
                     } else if(class41.loginIndex == 5) {
                        var13 = class41.loginWindowX + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var2 >= var13 - 75 && var2 <= 75 + var13 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                           class30.method686();
                           return;
                        }

                        var13 = 80 + class41.loginWindowX + 180;
                        if(var1 == 1 && var2 >= var13 - 75 && var2 <= 75 + var13 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                           class41.field834 = "";
                        }

                        while(NPC.method748()) {
                           var16 = false;

                           for(var17 = 0; var17 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var17) {
                              if(class164.field2317 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var17)) {
                                 var16 = true;
                                 break;
                              }
                           }

                           if(class2.field25 == 13) {
                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field834 = "";
                           } else {
                              if(class2.field25 == 85 && class41.username.length() > 0) {
                                 class41.username = class41.username.substring(0, class41.username.length() - 1);
                              }

                              if(class2.field25 == 84) {
                                 class30.method686();
                                 return;
                              }

                              if(var16 && class41.username.length() < 320) {
                                 class41.username = class41.username + class164.field2317;
                              }
                           }
                        }
                     } else if(class41.loginIndex == 6) {
                        while(true) {
                           do {
                              if(!NPC.method748()) {
                                 var14 = 321;
                                 if(var1 == 1 && var3 >= var14 - 20 && var3 <= var14 + 20) {
                                    class41.loginMessage1 = "";
                                    class41.loginMessage2 = "Enter your username/email & password.";
                                    class41.loginMessage3 = "";
                                    class41.loginIndex = 2;
                                    class41.loginIndex2 = 0;
                                    class41.field834 = "";
                                 }

                                 return;
                              }
                           } while(class2.field25 != 84 && class2.field25 != 13);

                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                           class41.field834 = "";
                        }
                     }
                  }
               } else {
                  while(NPC.method748()) {
                     if(class2.field25 == 84) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     } else if(class2.field25 == 13) {
                        class41.loginIndex = 0;
                     }
                  }

                  var13 = class41.loginWindowX + 180 - 80;
                  var5 = 321;
                  if(var1 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                     class41.loginMessage1 = "";
                     class41.loginMessage2 = "Enter your username/email & password.";
                     class41.loginMessage3 = "";
                     class41.loginIndex = 2;
                     class41.loginIndex2 = 0;
                  }

                  var13 = class41.loginWindowX + 180 + 80;
                  if(var1 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                     class41.loginIndex = 0;
                  }
               }

            }
         }
      }
   }
}
