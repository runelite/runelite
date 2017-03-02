import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
public class class196 extends CacheableNode {
   @ObfuscatedName("t")
   public static NodeCache field2873 = new NodeCache(64);
   @ObfuscatedName("i")
   static class182 field2875;
   @ObfuscatedName("k")
   @Export("spriteCache")
   public static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1510701355
   )
   public int field2877 = -1;
   @ObfuscatedName("h")
   public static NodeCache field2878 = new NodeCache(20);
   @ObfuscatedName("b")
   static class182 field2880;
   @ObfuscatedName("l")
   static class182 field2881;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1839289669
   )
   public int field2882 = 70;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1736079333
   )
   int field2883 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1774825209
   )
   int field2884 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -242889135
   )
   int field2885 = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1739430571
   )
   public int field2886 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -995714247
   )
   public int field2887 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -70039981
   )
   int field2888 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -582172631
   )
   public int field2889 = 16777215;
   @ObfuscatedName("v")
   String field2890 = "";
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -127469929
   )
   int field2891 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 934507179
   )
   public int field2892 = 0;
   @ObfuscatedName("d")
   public int[] field2893;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1954483609
   )
   int field2894 = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -510749391
   )
   int field2895 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 357141915
   )
   public int field2896 = 0;

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1278631387"
   )
   static final void method3641(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         class44.menuAction(var1, var2, var3, var4, var5, var6, class115.field1808, class115.field1798);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "596060528"
   )
   void method3642(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2891 = var1.method2966();
      } else if(var2 == 2) {
         this.field2889 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field2883 = var1.method2966();
      } else if(var2 == 4) {
         this.field2885 = var1.method2966();
      } else if(var2 == 5) {
         this.field2884 = var1.method2966();
      } else if(var2 == 6) {
         this.field2888 = var1.method2966();
      } else if(var2 == 7) {
         this.field2887 = var1.readShort();
      } else if(var2 == 8) {
         this.field2890 = var1.method2865();
      } else if(var2 == 9) {
         this.field2882 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field2896 = var1.readShort();
      } else if(var2 == 11) {
         this.field2877 = 0;
      } else if(var2 == 12) {
         this.field2886 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field2892 = var1.readShort();
      } else if(var2 == 14) {
         this.field2877 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field2894 = var1.readUnsignedShort();
         if(this.field2894 == '\uffff') {
            this.field2894 = -1;
         }

         this.field2895 = var1.readUnsignedShort();
         if(this.field2895 == '\uffff') {
            this.field2895 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field2893 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field2893[var5] = var1.readUnsignedShort();
            if(this.field2893[var5] == '\uffff') {
               this.field2893[var5] = -1;
            }
         }

         this.field2893[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "1"
   )
   public SpritePixels method3646() {
      if(this.field2884 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2884);
         if(null != var1) {
            return var1;
         } else {
            var1 = NPCComposition.method3812(field2881, this.field2884, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2884);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "4"
   )
   public SpritePixels method3647() {
      if(this.field2885 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2885);
         if(var1 != null) {
            return var1;
         } else {
            var1 = NPCComposition.method3812(field2881, this.field2885, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2885);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-2106674774"
   )
   public SpritePixels method3648() {
      if(this.field2888 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2888);
         if(null != var1) {
            return var1;
         } else {
            var1 = NPCComposition.method3812(field2881, this.field2888, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field2888);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)LFont;",
      garbageValue = "-1455485975"
   )
   public Font method3649() {
      if(this.field2891 == -1) {
         return null;
      } else {
         Font var1 = (Font)field2878.get((long)this.field2891);
         if(null != var1) {
            return var1;
         } else {
            class182 var3 = field2881;
            class182 var4 = field2875;
            int var5 = this.field2891;
            Font var2;
            if(!class185.method3467(var3, var5, 0)) {
               var2 = null;
            } else {
               var2 = FileOnDisk.method1488(var4.getConfigData(var5, 0));
            }

            if(var2 != null) {
               field2878.put(var2, (long)this.field2891);
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1519634409"
   )
   void method3666(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3642(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Lclass196;",
      garbageValue = "2"
   )
   public final class196 method3671() {
      int var1 = -1;
      if(this.field2894 != -1) {
         var1 = class156.method3084(this.field2894);
      } else if(this.field2895 != -1) {
         var1 = class165.widgetSettings[this.field2895];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field2893.length - 1) {
         var2 = this.field2893[var1];
      } else {
         var2 = this.field2893[this.field2893.length - 1];
      }

      return var2 != -1?NPCComposition.method3832(var2):null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1961281227"
   )
   public SpritePixels method3674() {
      if(this.field2883 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field2883);
         if(null != var1) {
            return var1;
         } else {
            var1 = NPCComposition.method3812(field2881, this.field2883, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field2883);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "-18684703"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field2899.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class227.field3245.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.field2928 = var0;
         if(null != var2) {
            var1.method3694(new Buffer(var2));
         }

         var1.method3695();
         if(var1.isSolid) {
            var1.field2914 = 0;
            var1.field2915 = false;
         }

         ObjectComposition.field2899.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LGameEngine;B)V",
      garbageValue = "3"
   )
   static void method3677(GameEngine var0) {
      int var1;
      int var2;
      int var3;
      int var19;
      if(class41.worldSelectShown) {
         if(class115.field1796 == 1 || !class36.field769 && class115.field1796 == 4) {
            var1 = 280 + class41.field817;
            if(class115.field1808 >= var1 && class115.field1808 <= var1 + 14 && class115.field1798 >= 4 && class115.field1798 <= 18) {
               class20.method214(0, 0);
            } else if(class115.field1808 >= var1 + 15 && class115.field1808 <= 80 + var1 && class115.field1798 >= 4 && class115.field1798 <= 18) {
               class20.method214(0, 1);
            } else {
               var2 = class41.field817 + 390;
               if(class115.field1808 >= var2 && class115.field1808 <= var2 + 14 && class115.field1798 >= 4 && class115.field1798 <= 18) {
                  class20.method214(1, 0);
               } else if(class115.field1808 >= 15 + var2 && class115.field1808 <= var2 + 80 && class115.field1798 >= 4 && class115.field1798 <= 18) {
                  class20.method214(1, 1);
               } else {
                  var3 = 500 + class41.field817;
                  if(class115.field1808 >= var3 && class115.field1808 <= var3 + 14 && class115.field1798 >= 4 && class115.field1798 <= 18) {
                     class20.method214(2, 0);
                  } else if(class115.field1808 >= var3 + 15 && class115.field1808 <= var3 + 80 && class115.field1798 >= 4 && class115.field1798 <= 18) {
                     class20.method214(2, 1);
                  } else {
                     var19 = 610 + class41.field817;
                     if(class115.field1808 >= var19 && class115.field1808 <= 14 + var19 && class115.field1798 >= 4 && class115.field1798 <= 18) {
                        class20.method214(3, 0);
                     } else if(class115.field1808 >= var19 + 15 && class115.field1808 <= 80 + var19 && class115.field1798 >= 4 && class115.field1798 <= 18) {
                        class20.method214(3, 1);
                     } else if(class115.field1808 >= class41.field817 + 708 && class115.field1798 >= 4 && class115.field1808 <= class41.field817 + 708 + 50 && class115.field1798 <= 20) {
                        class41.worldSelectShown = false;
                        class41.field820.method4252(class41.field817, 0);
                        class41.field846.method4252(class41.field817 + 382, 0);
                        XGrandExchangeOffer.field43.method4191(382 + class41.field817 - XGrandExchangeOffer.field43.originalWidth / 2, 18);
                     } else if(class41.field849 != -1) {
                        World var5 = World.worldList[class41.field849];
                        Friend.method185(var5);
                        class41.worldSelectShown = false;
                        class41.field820.method4252(class41.field817, 0);
                        class41.field846.method4252(382 + class41.field817, 0);
                        XGrandExchangeOffer.field43.method4191(382 + class41.field817 - XGrandExchangeOffer.field43.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((class115.field1796 == 1 || !class36.field769 && class115.field1796 == 4) && class115.field1808 >= class41.field817 + 765 - 50 && class115.field1798 >= 453) {
            WallObject.field1551.field692 = !WallObject.field1551.field692;
            DecorativeObject.method1977();
            if(!WallObject.field1551.field692) {
               class184 var9 = XItemContainer.field122;
               var2 = var9.method3363("scape main");
               var3 = var9.method3407(var2, "");
               GameEngine.method2168(var9, var2, var3, 255, false);
            } else {
               class39.field800.method2668();
               class138.field1915 = 1;
               class138.field1918 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class41.field823;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.field289 == 0) {
                  if(class115.field1796 == 1 || !class36.field769 && class115.field1796 == 4) {
                     var1 = 5 + class41.field817;
                     short var16 = 463;
                     byte var17 = 100;
                     byte var4 = 35;
                     if(class115.field1808 >= var1 && class115.field1808 <= var17 + var1 && class115.field1798 >= var16 && class115.field1798 <= var4 + var16) {
                        if(class16.loadWorlds()) {
                           class41.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(class60.worldServersDownload != null && class16.loadWorlds()) {
                     class41.worldSelectShown = true;
                  }
               }

               var1 = class115.field1796;
               var2 = class115.field1808;
               var3 = class115.field1798;
               if(!class36.field769 && var1 == 4) {
                  var1 = 1;
               }

               short var6;
               int var10;
               if(class41.loginIndex == 0) {
                  boolean var18 = false;

                  while(class38.method809()) {
                     if(class20.field211 == 84) {
                        var18 = true;
                     }
                  }

                  var10 = class41.loginWindowX + 180 - 80;
                  var6 = 291;
                  if(var1 == 1 && var2 >= var10 - 75 && var2 <= var10 + 75 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                     label919: {
                        String var7 = class101.method2008("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                        if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                           try {
                              Desktop.getDesktop().browse(new URI(var7));
                              break label919;
                           } catch (Exception var15) {
                              ;
                           }
                        }

                        if(class114.field1787.startsWith("win")) {
                           class5.method84(var7, 0);
                        } else if(class114.field1787.startsWith("mac")) {
                           ChatMessages.method934(var7, 1, "openjs");
                        } else {
                           class5.method84(var7, 2);
                        }
                     }
                  }

                  var10 = 80 + class41.loginWindowX + 180;
                  if(var1 == 1 && var2 >= var10 - 75 && var2 <= var10 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20 || var18) {
                     if((Client.flags & 33554432) != 0) {
                        class41.field830 = "";
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

                        class41.field830 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class41.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class41.loginMessage2 = "The Protect Item prayer will";
                        class41.loginMessage3 = "not work on this world.";
                        class41.field830 = "Warning!";
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
               } else {
                  short var22;
                  if(class41.loginIndex != 1) {
                     short var20;
                     if(class41.loginIndex == 2) {
                        var20 = 231;
                        var19 = var20 + 30;
                        if(var1 == 1 && var3 >= var19 - 15 && var3 < var19) {
                           class41.loginIndex2 = 0;
                        }

                        var19 += 15;
                        if(var1 == 1 && var3 >= var19 - 15 && var3 < var19) {
                           class41.loginIndex2 = 1;
                        }

                        var19 += 15;
                        var20 = 361;
                        if(var1 == 1 && var3 >= var20 - 15 && var3 < var20) {
                           class108.method2095("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class41.loginIndex = 5;
                           return;
                        }

                        var10 = 180 + class41.loginWindowX - 80;
                        var6 = 321;
                        if(var1 == 1 && var2 >= var10 - 75 && var2 <= var10 + 75 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                           class41.username = class41.username.trim();
                           if(class41.username.length() == 0) {
                              class108.method2095("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class41.field841.length() == 0) {
                              class108.method2095("", "Please enter your password.", "");
                              return;
                           }

                           class108.method2095("", "Connecting to server...", "");
                           class41.field842 = WallObject.field1551.field688.containsKey(Integer.valueOf(class10.method163(class41.username)))?class97.field1630:class97.field1624;
                           GameObject.setGameState(20);
                           return;
                        }

                        var10 = class41.loginWindowX + 180 + 80;
                        if(var1 == 1 && var2 >= var10 - 75 && var2 <= var10 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                           class41.loginIndex = 0;
                           class41.username = "";
                           class41.field841 = "";
                           class41.field843 = 0;
                           class154.authCode = "";
                           class41.field844 = true;
                        }

                        while(true) {
                           while(class38.method809()) {
                              boolean var11 = false;

                              for(int var12 = 0; var12 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var12) {
                                 if(class3.field32 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var12)) {
                                    var11 = true;
                                    break;
                                 }
                              }

                              if(class20.field211 == 13) {
                                 class41.loginIndex = 0;
                                 class41.username = "";
                                 class41.field841 = "";
                                 class41.field843 = 0;
                                 class154.authCode = "";
                                 class41.field844 = true;
                              } else if(class41.loginIndex2 == 0) {
                                 if(class20.field211 == 85 && class41.username.length() > 0) {
                                    class41.username = class41.username.substring(0, class41.username.length() - 1);
                                 }

                                 if(class20.field211 == 84 || class20.field211 == 80) {
                                    class41.loginIndex2 = 1;
                                 }

                                 if(var11 && class41.username.length() < 320) {
                                    class41.username = class41.username + class3.field32;
                                 }
                              } else if(class41.loginIndex2 == 1) {
                                 if(class20.field211 == 85 && class41.field841.length() > 0) {
                                    class41.field841 = class41.field841.substring(0, class41.field841.length() - 1);
                                 }

                                 if(class20.field211 == 84 || class20.field211 == 80) {
                                    class41.loginIndex2 = 0;
                                 }

                                 if(class20.field211 == 84) {
                                    class41.username = class41.username.trim();
                                    if(class41.username.length() == 0) {
                                       class108.method2095("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class41.field841.length() == 0) {
                                       class108.method2095("", "Please enter your password.", "");
                                       return;
                                    }

                                    class108.method2095("", "Connecting to server...", "");
                                    class41.field842 = WallObject.field1551.field688.containsKey(Integer.valueOf(class10.method163(class41.username)))?class97.field1630:class97.field1624;
                                    GameObject.setGameState(20);
                                    return;
                                 }

                                 if(var11 && class41.field841.length() < 20) {
                                    class41.field841 = class41.field841 + class3.field32;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class41.loginIndex == 3) {
                        var19 = 180 + class41.loginWindowX;
                        var22 = 276;
                        if(var1 == 1 && var2 >= var19 - 75 && var2 <= 75 + var19 && var3 >= var22 - 20 && var3 <= var22 + 20) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                        }

                        var19 = class41.loginWindowX + 180;
                        var22 = 326;
                        if(var1 == 1 && var2 >= var19 - 75 && var2 <= var19 + 75 && var3 >= var22 - 20 && var3 <= var22 + 20) {
                           class108.method2095("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class41.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var21;
                        int var23;
                        if(class41.loginIndex == 4) {
                           var19 = 180 + class41.loginWindowX - 80;
                           var22 = 321;
                           if(var1 == 1 && var2 >= var19 - 75 && var2 <= var19 + 75 && var3 >= var22 - 20 && var3 <= var22 + 20) {
                              class154.authCode.trim();
                              if(class154.authCode.length() != 6) {
                                 class108.method2095("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class41.field843 = Integer.parseInt(class154.authCode);
                              class154.authCode = "";
                              class41.field842 = class41.field844?class97.field1628:class97.field1625;
                              class108.method2095("", "Connecting to server...", "");
                              GameObject.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var2 >= 180 + class41.loginWindowX - 9 && var2 <= class41.loginWindowX + 180 + 130 && var3 >= 263 && var3 <= 296) {
                              class41.field844 = !class41.field844;
                           }

                           if(var1 == 1 && var2 >= class41.loginWindowX + 180 - 34 && var2 <= 180 + class41.loginWindowX + 34 && var3 >= 351 && var3 <= 363) {
                              label934: {
                                 String var13 = class101.method2008("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                                 if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                    try {
                                       Desktop.getDesktop().browse(new URI(var13));
                                       break label934;
                                    } catch (Exception var14) {
                                       ;
                                    }
                                 }

                                 if(class114.field1787.startsWith("win")) {
                                    class5.method84(var13, 0);
                                 } else if(class114.field1787.startsWith("mac")) {
                                    ChatMessages.method934(var13, 1, "openjs");
                                 } else {
                                    class5.method84(var13, 2);
                                 }
                              }
                           }

                           var19 = 180 + class41.loginWindowX + 80;
                           if(var1 == 1 && var2 >= var19 - 75 && var2 <= var19 + 75 && var3 >= var22 - 20 && var3 <= var22 + 20) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field841 = "";
                              class41.field843 = 0;
                              class154.authCode = "";
                           }

                           while(class38.method809()) {
                              var21 = false;

                              for(var23 = 0; var23 < "1234567890".length(); ++var23) {
                                 if(class3.field32 == "1234567890".charAt(var23)) {
                                    var21 = true;
                                    break;
                                 }
                              }

                              if(class20.field211 == 13) {
                                 class41.loginIndex = 0;
                                 class41.username = "";
                                 class41.field841 = "";
                                 class41.field843 = 0;
                                 class154.authCode = "";
                              } else {
                                 if(class20.field211 == 85 && class154.authCode.length() > 0) {
                                    class154.authCode = class154.authCode.substring(0, class154.authCode.length() - 1);
                                 }

                                 if(class20.field211 == 84) {
                                    class154.authCode.trim();
                                    if(class154.authCode.length() != 6) {
                                       class108.method2095("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class41.field843 = Integer.parseInt(class154.authCode);
                                    class154.authCode = "";
                                    class41.field842 = class41.field844?class97.field1628:class97.field1625;
                                    class108.method2095("", "Connecting to server...", "");
                                    GameObject.setGameState(20);
                                    return;
                                 }

                                 if(var21 && class154.authCode.length() < 6) {
                                    class154.authCode = class154.authCode + class3.field32;
                                 }
                              }
                           }
                        } else if(class41.loginIndex == 5) {
                           var19 = class41.loginWindowX + 180 - 80;
                           var22 = 321;
                           if(var1 == 1 && var2 >= var19 - 75 && var2 <= var19 + 75 && var3 >= var22 - 20 && var3 <= 20 + var22) {
                              class41.method855();
                              return;
                           }

                           var19 = 80 + class41.loginWindowX + 180;
                           if(var1 == 1 && var2 >= var19 - 75 && var2 <= var19 + 75 && var3 >= var22 - 20 && var3 <= 20 + var22) {
                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field841 = "";
                           }

                           while(class38.method809()) {
                              var21 = false;

                              for(var23 = 0; var23 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var23) {
                                 if(class3.field32 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var23)) {
                                    var21 = true;
                                    break;
                                 }
                              }

                              if(class20.field211 == 13) {
                                 class41.loginMessage1 = "";
                                 class41.loginMessage2 = "Enter your username/email & password.";
                                 class41.loginMessage3 = "";
                                 class41.loginIndex = 2;
                                 class41.loginIndex2 = 0;
                                 class41.field841 = "";
                              } else {
                                 if(class20.field211 == 85 && class41.username.length() > 0) {
                                    class41.username = class41.username.substring(0, class41.username.length() - 1);
                                 }

                                 if(class20.field211 == 84) {
                                    class41.method855();
                                    return;
                                 }

                                 if(var21 && class41.username.length() < 320) {
                                    class41.username = class41.username + class3.field32;
                                 }
                              }
                           }
                        } else if(class41.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class38.method809()) {
                                    var20 = 321;
                                    if(var1 == 1 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                                       class41.loginMessage1 = "";
                                       class41.loginMessage2 = "Enter your username/email & password.";
                                       class41.loginMessage3 = "";
                                       class41.loginIndex = 2;
                                       class41.loginIndex2 = 0;
                                       class41.field841 = "";
                                    }

                                    return;
                                 }
                              } while(class20.field211 != 84 && class20.field211 != 13);

                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field841 = "";
                           }
                        }
                     }
                  } else {
                     while(class38.method809()) {
                        if(class20.field211 == 84) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                        } else if(class20.field211 == 13) {
                           class41.loginIndex = 0;
                        }
                     }

                     var19 = 180 + class41.loginWindowX - 80;
                     var22 = 321;
                     if(var1 == 1 && var2 >= var19 - 75 && var2 <= 75 + var19 && var3 >= var22 - 20 && var3 <= var22 + 20) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }

                     var19 = 80 + class41.loginWindowX + 180;
                     if(var1 == 1 && var2 >= var19 - 75 && var2 <= 75 + var19 && var3 >= var22 - 20 && var3 <= 20 + var22) {
                        class41.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "-1924378759"
   )
   public static void method3678(class182 var0) {
      Varbit.field2853 = var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1513434136"
   )
   public String method3679(int var1) {
      String var2 = this.field2890;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         String var4 = var2.substring(0, var3);
         String var5 = Integer.toString(var1);
         var2 = var4 + var5 + var2.substring(2 + var3);
      }
   }
}
