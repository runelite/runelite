import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class30 {
   @ObfuscatedName("h")
   boolean field688;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2028462161
   )
   static int field690 = 4;
   @ObfuscatedName("m")
   boolean field691;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1731834951
   )
   int field692 = 1;
   @ObfuscatedName("r")
   LinkedHashMap field693 = new LinkedHashMap();

   class30(Buffer var1) {
      if(var1 != null && null != var1.payload) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field690) {
            if(var1.readUnsignedByte() == 1) {
               this.field691 = true;
            }

            if(var2 > 1) {
               this.field688 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field692 = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2995();
                  int var6 = var1.method2995();
                  this.field693.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method677(true);
         }
      } else {
         this.method677(true);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)LBuffer;",
      garbageValue = "59"
   )
   Buffer method674() {
      Buffer var1 = new Buffer(100);
      var1.method2975(field690);
      var1.method2975(this.field691?1:0);
      var1.method2975(this.field688?1:0);
      var1.method2975(this.field692);
      var1.method2975(this.field693.size());
      Iterator var2 = this.field693.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2978(((Integer)var3.getKey()).intValue());
         var1.method2978(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "71"
   )
   static void method675() {
      class11.field105 = null;
      class11.field106 = null;
      class38.field797 = null;
      class11.field107 = null;
      class187.field2778 = null;
      class5.field51 = null;
      class48.field933 = null;
      class162.field2307 = null;
      class107.field1728 = null;
      class205.field3075 = null;
      class72.field1179 = null;
      class202.field3064 = null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "492927337"
   )
   void method677(boolean var1) {
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "1502327802"
   )
   static final void method683(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(null != var0.field3022) {
            var0 = var0.method3770();
         }

         if(null != var0) {
            if(var0.field3024) {
               if(!var0.field3027 || Client.field459 == var1) {
                  String var4 = var0.name;
                  int var8;
                  if(var0.combatLevel != 0) {
                     int var7 = var0.combatLevel;
                     var8 = class40.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var10;
                     if(var9 < -9) {
                        var10 = class13.method182(16711680);
                     } else if(var9 < -6) {
                        var10 = class13.method182(16723968);
                     } else if(var9 < -3) {
                        var10 = class13.method182(16740352);
                     } else if(var9 < 0) {
                        var10 = class13.method182(16756736);
                     } else if(var9 > 9) {
                        var10 = class13.method182('\uff00');
                     } else if(var9 > 6) {
                        var10 = class13.method182(4259584);
                     } else if(var9 > 3) {
                        var10 = class13.method182(8453888);
                     } else if(var9 > 0) {
                        var10 = class13.method182(12648192);
                     } else {
                        var10 = class13.method182(16776960);
                     }

                     var4 = var4 + var10 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(Client.field438 == 1) {
                     class166.addMenuEntry("Use", Client.field371 + " " + "->" + " " + class13.method182(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field440) {
                     if((class138.field1920 & 2) == 2) {
                        class166.addMenuEntry(Client.field297, Client.field444 + " " + "->" + " " + class13.method182(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.actions;
                     if(Client.field346) {
                        var5 = class204.method3858(var5);
                     }

                     int var6;
                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var11 = 0;
                              if(var6 == 0) {
                                 var11 = 9;
                              }

                              if(var6 == 1) {
                                 var11 = 10;
                              }

                              if(var6 == 2) {
                                 var11 = 11;
                              }

                              if(var6 == 3) {
                                 var11 = 12;
                              }

                              if(var6 == 4) {
                                 var11 = 13;
                              }

                              class166.addMenuEntry(var5[var6], class13.method182(16776960) + var4, var11, var1, var2, var3);
                           }
                        }
                     }

                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && var5[var6].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(class40.field806 != Client.field487) {
                                 if(class40.field811 == Client.field487 || Client.field487 == class40.field814 && var0.combatLevel > class40.localPlayer.combatLevel) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var6 == 0) {
                                    var8 = 9 + var12;
                                 }

                                 if(var6 == 1) {
                                    var8 = var12 + 10;
                                 }

                                 if(var6 == 2) {
                                    var8 = var12 + 11;
                                 }

                                 if(var6 == 3) {
                                    var8 = var12 + 12;
                                 }

                                 if(var6 == 4) {
                                    var8 = var12 + 13;
                                 }

                                 class166.addMenuEntry(var5[var6], class13.method182(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class166.addMenuEntry("Examine", class13.method182(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "55"
   )
   static boolean method684(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1299419310"
   )
   static final void method685(int var0) {
      int[] var1 = Projectile.field879.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = 2048 * (103 - var3) + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class11.tileSettings[var0][var5][var3] & 24) == 0) {
               class157.region.method1774(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class11.tileSettings[1 + var0][var5][var3] & 8) != 0) {
               class157.region.method1774(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      Projectile.field879.method4182();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class11.tileSettings[var0][var6][var5] & 24) == 0) {
               class143.method2773(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class11.tileSettings[1 + var0][var6][var5] & 8) != 0) {
               class143.method2773(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field515 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class157.region.method1744(class166.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class15.getObjectDefinition(var7).field2919;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var13 = Client.collisionMaps[class166.plane].flags;

                     for(int var14 = 0; var14 < 10; ++var14) {
                        int var15 = (int)(Math.random() * 4.0D);
                        if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var15 == 1 && var9 < 103 && var9 < var5 + 3 && (var13[var9 + 1][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var15 == 3 && var10 < 103 && var10 < var6 + 3 && (var13[var9][1 + var10] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  Client.field518[Client.field515] = class10.field96[var8];
                  Client.field393[Client.field515] = var9;
                  Client.field428[Client.field515] = var10;
                  ++Client.field515;
               }
            }
         }
      }

      class34.bufferProvider.method4112();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-303007495"
   )
   static void method686() {
      class41.username = class41.username.trim();
      if(class41.username.length() == 0) {
         class3.method44("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(Item.method825("services", false) + "m=accountappeal/login.ws");
            URLConnection var4 = var3.openConnection();
            var4.setRequestProperty("connection", "close");
            var4.setDoInput(true);
            var4.setDoOutput(true);
            var4.setConnectTimeout(5000);
            OutputStreamWriter var5 = new OutputStreamWriter(var4.getOutputStream());
            var5.write("data1=req");
            var5.flush();
            InputStream var6 = var4.getInputStream();
            Buffer var7 = new Buffer(new byte[1000]);

            while(true) {
               int var8 = var6.read(var7.payload, var7.offset, 1000 - var7.offset);
               if(var8 == -1) {
                  var7.offset = 0;
                  long var31 = var7.method3118();
                  var1 = var31;
                  break;
               }

               var7.offset += var8;
               if(var7.offset >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var28) {
            var1 = 0L;
         }

         byte var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            String var29 = class41.username;
            Random var30 = new Random();
            Buffer var23 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var30.nextInt(), var30.nextInt(), (int)(var1 >> 32), (int)var1};
            var23.method2975(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var23.method2978(var30.nextInt());
            }

            var23.method2978(var10[0]);
            var23.method2978(var10[1]);
            var23.method2980(var1);
            var23.method2980(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var23.method2978(var30.nextInt());
            }

            var23.method3056(class36.field763, class36.field762);
            var9.method2975(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.method2978(var30.nextInt());
            }

            var9.method2980(var30.nextLong());
            var9.method3164(var30.nextLong());
            class36.method752(var9);
            var9.method2980(var30.nextLong());
            var9.method3056(class36.field763, class36.field762);
            var11 = RSCanvas.method2132(var29);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var12 = new Buffer(var11);
            var12.method2981(var29);
            var12.offset = var11;
            var12.method3007(var10);
            Buffer var13 = new Buffer(var12.offset + var9.offset + var23.offset + 5);
            var13.method2975(2);
            var13.method2975(var23.offset);
            var13.method2984(var23.payload, 0, var23.offset);
            var13.method2975(var9.offset);
            var13.method2984(var9.payload, 0, var9.offset);
            var13.method2976(var12.offset);
            var13.method2984(var12.payload, 0, var12.offset);
            String var14 = Frames.method1931(var13.payload);

            byte var24;
            try {
               URL var15 = new URL(Item.method825("services", false) + "m=accountappeal/login.ws");
               URLConnection var16 = var15.openConnection();
               var16.setDoInput(true);
               var16.setDoOutput(true);
               var16.setConnectTimeout(5000);
               OutputStreamWriter var17 = new OutputStreamWriter(var16.getOutputStream());
               var17.write("data2=" + class212.method4022(var14) + "&dest=" + class212.method4022("passwordchoice.ws"));
               var17.flush();
               InputStream var18 = var16.getInputStream();
               var13 = new Buffer(new byte[1000]);

               while(true) {
                  int var19 = var18.read(var13.payload, var13.offset, 1000 - var13.offset);
                  if(var19 == -1) {
                     var17.close();
                     var18.close();
                     String var25 = new String(var13.payload);
                     if(var25.startsWith("OFFLINE")) {
                        var24 = 4;
                     } else if(var25.startsWith("WRONG")) {
                        var24 = 7;
                     } else if(var25.startsWith("RELOAD")) {
                        var24 = 3;
                     } else if(var25.startsWith("Not permitted for social network accounts.")) {
                        var24 = 6;
                     } else {
                        var13.method3008(var10);

                        while(var13.offset > 0 && var13.payload[var13.offset - 1] == 0) {
                           --var13.offset;
                        }

                        var25 = new String(var13.payload, 0, var13.offset);
                        boolean var20;
                        if(null == var25) {
                           var20 = false;
                        } else {
                           label114: {
                              try {
                                 new URL(var25);
                              } catch (MalformedURLException var26) {
                                 var20 = false;
                                 break label114;
                              }

                              var20 = true;
                           }
                        }

                        if(var20) {
                           MessageNode.method217(var25, true, false);
                           var24 = 2;
                        } else {
                           var24 = 5;
                        }
                     }
                     break;
                  }

                  var13.offset += var19;
                  if(var13.offset >= 1000) {
                     var24 = 5;
                     break;
                  }
               }
            } catch (Throwable var27) {
               var27.printStackTrace();
               var24 = 5;
            }

            var0 = var24;
         }

         switch(var0) {
         case 2:
            class3.method44("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class41.loginIndex = 6;
            break;
         case 3:
            class3.method44("", "Error connecting to server.", "");
            break;
         case 4:
            class3.method44("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class3.method44("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class3.method44("", "Error connecting to server.", "");
            break;
         case 7:
            class3.method44("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   class30() {
      this.method677(true);
   }
}
