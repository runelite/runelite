import java.util.Date;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public class class90 {
   @ObfuscatedName("l")
   static class80[] field1539;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIZIZB)V",
      garbageValue = "1"
   )
   static void method2088(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         class25 var8 = class25.field635[var6];
         class25.field635[var6] = class25.field635[var1];
         class25.field635[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class5.method53(class25.field635[var9], var8, var2, var3, var4, var5) <= 0) {
               class25 var10 = class25.field635[var9];
               class25.field635[var9] = class25.field635[var7];
               class25.field635[var7++] = var10;
            }
         }

         class25.field635[var1] = class25.field635[var7];
         class25.field635[var7] = var8;
         method2088(var0, var7 - 1, var2, var3, var4, var5);
         method2088(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "916458320"
   )
   static void method2089(int var0) {
      if(var0 == -3) {
         class12.method152("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class12.method152("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class12.method152("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class31.field715 = 3;
      } else if(var0 == 4) {
         class12.method152("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class12.method152("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class12.method152("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class12.method152("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class12.method152("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class12.method152("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class12.method152("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class12.method152("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class12.method152("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class12.method152("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class12.method152("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class12.method152("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class12.method152("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class12.method152("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class12.method152("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class12.method152("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class12.method152("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class12.method152("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class12.method152("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class12.method152("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class12.method152("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class12.method152("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class12.method152("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class12.method152("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class12.method152("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class12.method152("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class12.method152("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class12.method152("Enter the 6-digit code generated by your", "authenticator app.", "");
            class43.method919(11);
            return;
         }

         if(var0 == 57) {
            class12.method152("The code you entered was incorrect.", "Please try again.", "");
            class43.method919(11);
            return;
         }

         class12.method152("Unexpected server response", "Please try using a different world.", "");
      }

      class43.method919(10);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1096533658"
   )
   public static synchronized long method2090() {
      long var0 = System.currentTimeMillis();
      if(var0 < class115.field1956) {
         class115.field1952 += class115.field1956 - var0;
      }

      class115.field1956 = var0;
      return var0 + class115.field1952;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1619953940"
   )
   static final void method2091(int var0, int var1, int var2, int var3) {
      if(client.field352 == 0 && !client.field442) {
         class217.method3974("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class105.field1843; ++var6) {
         var7 = class105.field1844[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && class150.field2230.method1955(class144.field2193, var8, var9, var7) >= 0) {
               class40 var12 = class172.method3399(var11);
               if(null != var12.field949) {
                  var12 = var12.method805();
               }

               if(var12 == null) {
                  continue;
               }

               if(client.field352 == 1) {
                  class217.method3974("Use", client.field349 + " " + "->" + " " + class158.method3184('\uffff') + var12.field910, 1, var7, var8, var9);
               } else if(client.field442) {
                  if((class138.field2115 & 4) == 4) {
                     class217.method3974(client.field445, client.field446 + " " + "->" + " " + class158.method3184('\uffff') + var12.field910, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.field927;
                  if(client.field439) {
                     var13 = class0.method1(var13);
                  }

                  if(null != var13) {
                     for(int var18 = 4; var18 >= 0; --var18) {
                        if(var13[var18] != null) {
                           short var15 = 0;
                           if(var18 == 0) {
                              var15 = 3;
                           }

                           if(var18 == 1) {
                              var15 = 4;
                           }

                           if(var18 == 2) {
                              var15 = 5;
                           }

                           if(var18 == 3) {
                              var15 = 6;
                           }

                           if(var18 == 4) {
                              var15 = 1001;
                           }

                           class217.method3974(var13[var18], class158.method3184('\uffff') + var12.field910, var15, var7, var8, var9);
                        }
                     }
                  }

                  class217.method3974("Examine", class158.method3184('\uffff') + var12.field910, 1002, var12.field907 << 14, var8, var9);
               }
            }

            class34 var14;
            int var19;
            class2 var20;
            int[] var27;
            int var29;
            if(var10 == 1) {
               class34 var23 = client.field326[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.field762.field865 == 1 && (var23.field813 & 127) == 64 && (var23.field791 & 127) == 64) {
                  for(var19 = 0; var19 < client.field449; ++var19) {
                     var14 = client.field326[client.field318[var19]];
                     if(var14 != null && var14 != var23 && var14.field762.field865 == 1 && var14.field813 == var23.field813 && var23.field791 == var14.field791) {
                        class5.method78(var14.field762, client.field318[var19], var8, var9);
                     }
                  }

                  var19 = class32.field738;
                  var27 = class32.field739;

                  for(var29 = 0; var29 < var19; ++var29) {
                     var20 = client.field410[var27[var29]];
                     if(null != var20 && var23.field813 == var20.field813 && var23.field791 == var20.field791) {
                        class19.method197(var20, var27[var29], var8, var9);
                     }
                  }
               }

               class5.method78(var23.field762, var11, var8, var9);
            }

            if(var10 == 0) {
               class2 var24 = client.field410[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.field813 & 127) == 64 && (var24.field791 & 127) == 64) {
                  for(var19 = 0; var19 < client.field449; ++var19) {
                     var14 = client.field326[client.field318[var19]];
                     if(var14 != null && var14.field762.field865 == 1 && var14.field813 == var24.field813 && var14.field791 == var24.field791) {
                        class5.method78(var14.field762, client.field318[var19], var8, var9);
                     }
                  }

                  var19 = class32.field738;
                  var27 = class32.field739;

                  for(var29 = 0; var29 < var19; ++var29) {
                     var20 = client.field410[var27[var29]];
                     if(var20 != null && var20 != var24 && var20.field813 == var24.field813 && var20.field791 == var24.field791) {
                        class19.method197(var20, var27[var29], var8, var9);
                     }
                  }
               }

               if(var11 != client.field329) {
                  class19.method197(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               class199 var25 = client.field420[class144.field2193][var8][var9];
               if(var25 != null) {
                  for(class28 var26 = (class28)var25.method3824(); var26 != null; var26 = (class28)var25.method3826()) {
                     class51 var28 = class35.method741(var26.field672);
                     if(client.field352 == 1) {
                        class217.method3974("Use", client.field349 + " " + "->" + " " + class158.method3184(16748608) + var28.field1090, 16, var26.field672, var8, var9);
                     } else if(client.field442) {
                        if((class138.field2115 & 1) == 1) {
                           class217.method3974(client.field445, client.field446 + " " + "->" + " " + class158.method3184(16748608) + var28.field1090, 17, var26.field672, var8, var9);
                        }
                     } else {
                        String[] var22 = var28.field1099;
                        if(client.field439) {
                           var22 = class0.method1(var22);
                        }

                        for(int var16 = 4; var16 >= 0; --var16) {
                           if(var22 != null && null != var22[var16]) {
                              byte var17 = 0;
                              if(var16 == 0) {
                                 var17 = 18;
                              }

                              if(var16 == 1) {
                                 var17 = 19;
                              }

                              if(var16 == 2) {
                                 var17 = 20;
                              }

                              if(var16 == 3) {
                                 var17 = 21;
                              }

                              if(var16 == 4) {
                                 var17 = 22;
                              }

                              class217.method3974(var22[var16], class158.method3184(16748608) + var28.field1090, var17, var26.field672, var8, var9);
                           } else if(var16 == 2) {
                              class217.method3974("Take", class158.method3184(16748608) + var28.field1090, 20, var26.field672, var8, var9);
                           }
                        }

                        class217.method3974("Examine", class158.method3184(16748608) + var28.field1090, 1004, var26.field672, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         class2 var21 = client.field410[client.field329];
         class19.method197(var21, client.field329, var6, var7);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass0;IB)V",
      garbageValue = "200000"
   )
   static void method2092(class0 var0, int var1) {
      Object[] var2 = var0.field12;
      int var3 = ((Integer)var2[0]).intValue();
      class22 var4 = class24.method592(var3);
      if(null != var4) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field597;
         int[] var9 = var4.field590;
         byte var10 = -1;
         class36.field774 = 0;

         int var13;
         try {
            class36.field776 = new int[var4.field592];
            int var11 = 0;
            class36.field778 = new String[var4.field593];
            int var12 = 0;

            int var14;
            String var25;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field3;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field4;
                  }

                  if(var14 == -2147483645) {
                     var14 = var0.field10 != null?var0.field10.field2748:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field5;
                  }

                  if(var14 == -2147483643) {
                     var14 = null != var0.field10?var0.field10.field2749:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = null != var0.field6?var0.field6.field2748:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = var0.field6 != null?var0.field6.field2749:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field7;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field8;
                  }

                  class36.field776[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var25 = (String)var2[var13];
                  if(var25.equals("event_opbase")) {
                     var25 = var0.field9;
                  }

                  class36.field778[var12++] = var25;
               }
            }

            var13 = 0;
            class36.field787 = var0.field2;

            label3624:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var37 = var8[var7];
               int var15;
               int var19;
               int var20;
               int var21;
               int var26;
               int var28;
               String[] var51;
               int[] var53;
               byte[] var54;
               String var93;
               if(var37 < 100) {
                  if(var37 == 0) {
                     class36.field780[var5++] = var9[var7];
                     continue;
                  }

                  if(var37 == 1) {
                     var14 = var9[var7];
                     class36.field780[var5++] = class176.field2896[var14];
                     continue;
                  }

                  if(var37 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class176.field2896[var14] = class36.field780[var5];
                     class4.method40(var14);
                     continue;
                  }

                  if(var37 == 3) {
                     class36.field789[var6++] = var4.field591[var7];
                     continue;
                  }

                  if(var37 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var37 == 7) {
                     var5 -= 2;
                     if(class36.field780[var5 + 1] != class36.field780[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var37 == 8) {
                     var5 -= 2;
                     if(class36.field780[1 + var5] == class36.field780[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var37 == 9) {
                     var5 -= 2;
                     if(class36.field780[var5] < class36.field780[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var37 == 10) {
                     var5 -= 2;
                     if(class36.field780[var5] > class36.field780[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var37 == 21) {
                     if(class36.field774 == 0) {
                        return;
                     }

                     class14 var64 = class36.field783[--class36.field774];
                     var4 = var64.field213;
                     var8 = var4.field597;
                     var9 = var4.field590;
                     var7 = var64.field206;
                     class36.field776 = var64.field207;
                     class36.field778 = var64.field208;
                     continue;
                  }

                  if(var37 == 25) {
                     var14 = var9[var7];
                     class36.field780[var5++] = class7.method90(var14);
                     continue;
                  }

                  if(var37 == 27) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class36.field780[var5];
                     class47 var62 = (class47)class47.field1042.method3764((long)var14);
                     class47 var71;
                     if(var62 != null) {
                        var71 = var62;
                     } else {
                        var54 = class47.field1044.method3266(14, var14);
                        var62 = new class47();
                        if(var54 != null) {
                           var62.method976(new class119(var54));
                        }

                        class47.field1042.method3759(var62, (long)var14);
                        var71 = var62;
                     }

                     var26 = var71.field1043;
                     var19 = var71.field1045;
                     var20 = var71.field1047;
                     var21 = class176.field2898[var20 - var19];
                     if(var15 < 0 || var15 > var21) {
                        var15 = 0;
                     }

                     var21 <<= var19;
                     class176.field2896[var26] = class176.field2896[var26] & ~var21 | var15 << var19 & var21;
                     continue;
                  }

                  if(var37 == 31) {
                     var5 -= 2;
                     if(class36.field780[var5] <= class36.field780[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var37 == 32) {
                     var5 -= 2;
                     if(class36.field780[var5] >= class36.field780[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var37 == 33) {
                     class36.field780[var5++] = class36.field776[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var37 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class36.field776[var10001] = class36.field780[var5];
                     continue;
                  }

                  if(var37 == 35) {
                     class36.field789[var6++] = class36.field778[var9[var7]];
                     continue;
                  }

                  if(var37 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class36.field778[var10001] = class36.field789[var6];
                     continue;
                  }

                  if(var37 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     var93 = class156.method3177(class36.field789, var6, var14);
                     class36.field789[var6++] = var93;
                     continue;
                  }

                  if(var37 == 38) {
                     --var5;
                     continue;
                  }

                  if(var37 == 39) {
                     --var6;
                     continue;
                  }

                  if(var37 == 40) {
                     var14 = var9[var7];
                     class22 var98 = class24.method592(var14);
                     var53 = new int[var98.field592];
                     var51 = new String[var98.field593];

                     for(var26 = 0; var26 < var98.field588; ++var26) {
                        var53[var26] = class36.field780[var26 + (var5 - var98.field588)];
                     }

                     for(var26 = 0; var26 < var98.field595; ++var26) {
                        var51[var26] = class36.field789[var6 - var98.field595 + var26];
                     }

                     var5 -= var98.field588;
                     var6 -= var98.field595;
                     class14 var79 = new class14();
                     var79.field213 = var4;
                     var79.field206 = var7;
                     var79.field207 = class36.field776;
                     var79.field208 = class36.field778;
                     class36.field783[++class36.field774 - 1] = var79;
                     var4 = var98;
                     var8 = var98.field597;
                     var9 = var98.field590;
                     var7 = -1;
                     class36.field776 = var53;
                     class36.field778 = var51;
                     continue;
                  }

                  if(var37 == 42) {
                     class36.field780[var5++] = class139.field2124.method195(var9[var7]);
                     continue;
                  }

                  if(var37 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class139.field2124.method219(var10001, class36.field780[var5]);
                     continue;
                  }

                  if(var37 == 44) {
                     var14 = var9[var7] >> 16;
                     var15 = var9[var7] & '\uffff';
                     --var5;
                     var28 = class36.field780[var5];
                     if(var28 >= 0 && var28 <= 5000) {
                        class36.field782[var14] = var28;
                        byte var94 = -1;
                        if(var15 == 105) {
                           var94 = 0;
                        }

                        var26 = 0;

                        while(true) {
                           if(var26 >= var28) {
                              continue label3624;
                           }

                           class36.field779[var14][var26] = var94;
                           ++var26;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var37 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class36.field780[var5];
                     if(var15 >= 0 && var15 < class36.field782[var14]) {
                        class36.field780[var5++] = class36.field779[var14][var15];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var37 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var15 = class36.field780[var5];
                     if(var15 >= 0 && var15 < class36.field782[var14]) {
                        class36.field779[var14][var15] = class36.field780[var5 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var37 == 47) {
                     var25 = class139.field2124.method193(var9[var7]);
                     if(var25 == null) {
                        var25 = "null";
                     }

                     class36.field789[var6++] = var25;
                     continue;
                  }

                  if(var37 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class139.field2124.method192(var10001, class36.field789[var6]);
                     continue;
                  }
               }

               boolean var47;
               if(var9[var7] == 1) {
                  var47 = true;
               } else {
                  var47 = false;
               }

               class173 var27;
               int var29;
               class173 var41;
               class173 var44;
               class173 var63;
               boolean var69;
               boolean var70;
               if(var37 < 1000) {
                  if(var37 == 100) {
                     var5 -= 3;
                     var15 = class36.field780[var5];
                     var28 = class36.field780[1 + var5];
                     var29 = class36.field780[var5 + 2];
                     if(var28 == 0) {
                        throw new RuntimeException();
                     }

                     var44 = class161.method3205(var15);
                     if(null == var44.field2872) {
                        var44.field2872 = new class173[var29 + 1];
                     }

                     if(var44.field2872.length <= var29) {
                        class173[] var87 = new class173[var29 + 1];

                        for(var20 = 0; var20 < var44.field2872.length; ++var20) {
                           var87[var20] = var44.field2872[var20];
                        }

                        var44.field2872 = var87;
                     }

                     if(var29 > 0 && var44.field2872[var29 - 1] == null) {
                        throw new RuntimeException("" + (var29 - 1));
                     }

                     class173 var89 = new class173();
                     var89.field2833 = var28;
                     var89.field2777 = var89.field2748 = var44.field2748;
                     var89.field2749 = var29;
                     var89.field2741 = true;
                     var44.field2872[var29] = var89;
                     if(var47) {
                        class216.field3159 = var89;
                     } else {
                        class36.field781 = var89;
                     }

                     class4.method37(var44);
                     continue;
                  }

                  if(var37 == 101) {
                     var27 = var47?class216.field3159:class36.field781;
                     var63 = class161.method3205(var27.field2748);
                     var63.field2872[var27.field2749] = null;
                     class4.method37(var63);
                     continue;
                  }

                  if(var37 == 102) {
                     --var5;
                     var27 = class161.method3205(class36.field780[var5]);
                     var27.field2872 = null;
                     class4.method37(var27);
                     continue;
                  }

                  if(var37 == 200) {
                     var5 -= 2;
                     var15 = class36.field780[var5];
                     var28 = class36.field780[var5 + 1];
                     var41 = class165.method3247(var15, var28);
                     if(var41 != null && var28 != -1) {
                        class36.field780[var5++] = 1;
                        if(var47) {
                           class216.field3159 = var41;
                        } else {
                           class36.field781 = var41;
                        }
                        continue;
                     }

                     class36.field780[var5++] = 0;
                     continue;
                  }

                  if(var37 == 201) {
                     --var5;
                     var27 = class161.method3205(class36.field780[var5]);
                     if(null != var27) {
                        class36.field780[var5++] = 1;
                        if(var47) {
                           class216.field3159 = var27;
                        } else {
                           class36.field781 = var27;
                        }
                     } else {
                        class36.field780[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var91;
                  if(var37 >= 1000 && var37 < 1100 || var37 >= 2000 && var37 < 2100) {
                     var15 = -1;
                     if(var37 >= 2000) {
                        var37 -= 1000;
                        --var5;
                        var15 = class36.field780[var5];
                        var63 = class161.method3205(var15);
                     } else {
                        var63 = var47?class216.field3159:class36.field781;
                     }

                     if(var37 == 1000) {
                        var5 -= 4;
                        var63.field2762 = class36.field780[var5];
                        var63.field2784 = class36.field780[var5 + 1];
                        var63.field2753 = class36.field780[var5 + 2];
                        var63.field2754 = class36.field780[var5 + 3];
                        class4.method37(var63);
                        class39.method798(var63);
                        if(var15 != -1 && var63.field2833 == 0) {
                           class9.method121(class173.field2750[var15 >> 16], var63, false);
                        }
                        continue;
                     }

                     if(var37 == 1001) {
                        var5 -= 4;
                        var63.field2759 = class36.field780[var5];
                        var63.field2765 = class36.field780[var5 + 1];
                        var63.field2818 = class36.field780[2 + var5];
                        var63.field2756 = class36.field780[var5 + 3];
                        class4.method37(var63);
                        class39.method798(var63);
                        if(var15 != -1 && var63.field2833 == 0) {
                           class9.method121(class173.field2750[var15 >> 16], var63, false);
                        }
                        continue;
                     }

                     if(var37 == 1003) {
                        --var5;
                        var91 = class36.field780[var5] == 1;
                        if(var91 != var63.field2882) {
                           var63.field2882 = var91;
                           class4.method37(var63);
                        }
                        continue;
                     }

                     if(var37 == 1005) {
                        --var5;
                        var63.field2761 = class36.field780[var5] == 1;
                        continue;
                     }

                     if(var37 == 1006) {
                        --var5;
                        var63.field2737 = class36.field780[var5] == 1;
                        continue;
                     }
                  } else {
                     String var17;
                     if((var37 < 1100 || var37 >= 1200) && (var37 < 2100 || var37 >= 2200)) {
                        if(var37 >= 1200 && var37 < 1300 || var37 >= 2200 && var37 < 2300) {
                           if(var37 >= 2000) {
                              var37 -= 1000;
                              --var5;
                              var27 = class161.method3205(class36.field780[var5]);
                           } else {
                              var27 = var47?class216.field3159:class36.field781;
                           }

                           class4.method37(var27);
                           if(var37 == 1200 || var37 == 1205 || var37 == 1212) {
                              var5 -= 2;
                              var28 = class36.field780[var5];
                              var29 = class36.field780[1 + var5];
                              var27.field2868 = var28;
                              var27.field2871 = var29;
                              class51 var75 = class35.method741(var28);
                              var27.field2839 = var75.field1091;
                              var27.field2800 = var75.field1083;
                              var27.field2844 = var75.field1093;
                              var27.field2797 = var75.field1089;
                              var27.field2798 = var75.field1095;
                              var27.field2802 = var75.field1106;
                              if(var37 == 1205) {
                                 var27.field2806 = 0;
                              } else if(var37 == 1212 | var75.field1096 == 1) {
                                 var27.field2806 = 1;
                              } else {
                                 var27.field2806 = 2;
                              }

                              if(var27.field2803 > 0) {
                                 var27.field2802 = var27.field2802 * 32 / var27.field2803;
                              } else if(var27.field2759 > 0) {
                                 var27.field2802 = var27.field2802 * 32 / var27.field2759;
                              }
                              continue;
                           }

                           if(var37 == 1201) {
                              var27.field2791 = 2;
                              --var5;
                              var27.field2792 = class36.field780[var5];
                              continue;
                           }

                           if(var37 == 1202) {
                              var27.field2791 = 3;
                              var27.field2792 = class153.field2262.field49.method3494();
                              continue;
                           }
                        } else if(var37 >= 1300 && var37 < 1400 || var37 >= 2300 && var37 < 2400) {
                           if(var37 >= 2000) {
                              var37 -= 1000;
                              --var5;
                              var27 = class161.method3205(class36.field780[var5]);
                           } else {
                              var27 = var47?class216.field3159:class36.field781;
                           }

                           if(var37 == 1300) {
                              --var5;
                              var28 = class36.field780[var5] - 1;
                              if(var28 >= 0 && var28 <= 9) {
                                 --var6;
                                 var27.method3416(var28, class36.field789[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var37 == 1301) {
                              var5 -= 2;
                              var28 = class36.field780[var5];
                              var29 = class36.field780[1 + var5];
                              var27.field2810 = class165.method3247(var28, var29);
                              continue;
                           }

                           if(var37 == 1302) {
                              --var5;
                              var27.field2826 = class36.field780[var5] == 1;
                              continue;
                           }

                           if(var37 == 1303) {
                              --var5;
                              var27.field2824 = class36.field780[var5];
                              continue;
                           }

                           if(var37 == 1304) {
                              --var5;
                              var27.field2825 = class36.field780[var5];
                              continue;
                           }

                           if(var37 == 1305) {
                              --var6;
                              var27.field2760 = class36.field789[var6];
                              continue;
                           }

                           if(var37 == 1306) {
                              --var6;
                              var27.field2869 = class36.field789[var6];
                              continue;
                           }

                           if(var37 == 1307) {
                              var27.field2822 = null;
                              continue;
                           }
                        } else {
                           String var39;
                           int[] var42;
                           if(var37 >= 1400 && var37 < 1500 || var37 >= 2400 && var37 < 2500) {
                              if(var37 >= 2000) {
                                 var37 -= 1000;
                                 --var5;
                                 var27 = class161.method3205(class36.field780[var5]);
                              } else {
                                 var27 = var47?class216.field3159:class36.field781;
                              }

                              --var6;
                              var39 = class36.field789[var6];
                              var42 = null;
                              if(var39.length() > 0 && var39.charAt(var39.length() - 1) == 89) {
                                 --var5;
                                 var26 = class36.field780[var5];
                                 if(var26 > 0) {
                                    for(var42 = new int[var26]; var26-- > 0; var42[var26] = class36.field780[var5]) {
                                       --var5;
                                    }
                                 }

                                 var39 = var39.substring(0, var39.length() - 1);
                              }

                              Object[] var57 = new Object[var39.length() + 1];

                              for(var19 = var57.length - 1; var19 >= 1; --var19) {
                                 if(var39.charAt(var19 - 1) == 115) {
                                    --var6;
                                    var57[var19] = class36.field789[var6];
                                 } else {
                                    --var5;
                                    var57[var19] = new Integer(class36.field780[var5]);
                                 }
                              }

                              --var5;
                              var19 = class36.field780[var5];
                              if(var19 != -1) {
                                 var57[0] = new Integer(var19);
                              } else {
                                 var57 = null;
                              }

                              if(var37 == 1400) {
                                 var27.field2827 = var57;
                              }

                              if(var37 == 1401) {
                                 var27.field2875 = var57;
                              }

                              if(var37 == 1402) {
                                 var27.field2832 = var57;
                              }

                              if(var37 == 1403) {
                                 var27.field2834 = var57;
                              }

                              if(var37 == 1404) {
                                 var27.field2836 = var57;
                              }

                              if(var37 == 1405) {
                                 var27.field2769 = var57;
                              }

                              if(var37 == 1406) {
                                 var27.field2840 = var57;
                              }

                              if(var37 == 1407) {
                                 var27.field2841 = var57;
                                 var27.field2842 = var42;
                              }

                              if(var37 == 1408) {
                                 var27.field2847 = var57;
                              }

                              if(var37 == 1409) {
                                 var27.field2848 = var57;
                              }

                              if(var37 == 1410) {
                                 var27.field2804 = var57;
                              }

                              if(var37 == 1411) {
                                 var27.field2758 = var57;
                              }

                              if(var37 == 1412) {
                                 var27.field2864 = var57;
                              }

                              if(var37 == 1414) {
                                 var27.field2843 = var57;
                                 var27.field2881 = var42;
                              }

                              if(var37 == 1415) {
                                 var27.field2846 = var57;
                                 var27.field2812 = var42;
                              }

                              if(var37 == 1416) {
                                 var27.field2747 = var57;
                              }

                              if(var37 == 1417) {
                                 var27.field2837 = var57;
                              }

                              if(var37 == 1418) {
                                 var27.field2740 = var57;
                              }

                              if(var37 == 1419) {
                                 var27.field2807 = var57;
                              }

                              if(var37 == 1420) {
                                 var27.field2852 = var57;
                              }

                              if(var37 == 1421) {
                                 var27.field2877 = var57;
                              }

                              if(var37 == 1422) {
                                 var27.field2854 = var57;
                              }

                              if(var37 == 1423) {
                                 var27.field2835 = var57;
                              }

                              if(var37 == 1424) {
                                 var27.field2856 = var57;
                              }

                              if(var37 == 1425) {
                                 var27.field2858 = var57;
                              }

                              if(var37 == 1426) {
                                 var27.field2859 = var57;
                              }

                              if(var37 == 1427) {
                                 var27.field2857 = var57;
                              }

                              var27.field2767 = true;
                              continue;
                           }

                           if(var37 < 1600) {
                              var27 = var47?class216.field3159:class36.field781;
                              if(var37 == 1500) {
                                 class36.field780[var5++] = var27.field2796;
                                 continue;
                              }

                              if(var37 == 1501) {
                                 class36.field780[var5++] = var27.field2823;
                                 continue;
                              }

                              if(var37 == 1502) {
                                 class36.field780[var5++] = var27.field2763;
                                 continue;
                              }

                              if(var37 == 1503) {
                                 class36.field780[var5++] = var27.field2764;
                                 continue;
                              }

                              if(var37 == 1504) {
                                 class36.field780[var5++] = var27.field2882?1:0;
                                 continue;
                              }

                              if(var37 == 1505) {
                                 class36.field780[var5++] = var27.field2777;
                                 continue;
                              }
                           } else if(var37 < 1700) {
                              var27 = var47?class216.field3159:class36.field781;
                              if(var37 == 1600) {
                                 class36.field780[var5++] = var27.field2863;
                                 continue;
                              }

                              if(var37 == 1601) {
                                 class36.field780[var5++] = var27.field2770;
                                 continue;
                              }

                              if(var37 == 1602) {
                                 class36.field789[var6++] = var27.field2808;
                                 continue;
                              }

                              if(var37 == 1603) {
                                 class36.field780[var5++] = var27.field2771;
                                 continue;
                              }

                              if(var37 == 1604) {
                                 class36.field780[var5++] = var27.field2772;
                                 continue;
                              }

                              if(var37 == 1605) {
                                 class36.field780[var5++] = var27.field2802;
                                 continue;
                              }

                              if(var37 == 1606) {
                                 class36.field780[var5++] = var27.field2839;
                                 continue;
                              }

                              if(var37 == 1607) {
                                 class36.field780[var5++] = var27.field2844;
                                 continue;
                              }

                              if(var37 == 1608) {
                                 class36.field780[var5++] = var27.field2800;
                                 continue;
                              }

                              if(var37 == 1609) {
                                 class36.field780[var5++] = var27.field2830;
                                 continue;
                              }

                              if(var37 == 1610) {
                                 class36.field780[var5++] = var27.field2780;
                                 continue;
                              }

                              if(var37 == 1611) {
                                 class36.field780[var5++] = var27.field2773;
                                 continue;
                              }

                              if(var37 == 1612) {
                                 class36.field780[var5++] = var27.field2755;
                                 continue;
                              }

                              if(var37 == 1613) {
                                 class36.field780[var5++] = var27.field2778.vmethod3185();
                                 continue;
                              }
                           } else if(var37 < 1800) {
                              var27 = var47?class216.field3159:class36.field781;
                              if(var37 == 1700) {
                                 class36.field780[var5++] = var27.field2868;
                                 continue;
                              }

                              if(var37 == 1701) {
                                 if(var27.field2868 != -1) {
                                    class36.field780[var5++] = var27.field2871;
                                 } else {
                                    class36.field780[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var37 == 1702) {
                                 class36.field780[var5++] = var27.field2749;
                                 continue;
                              }
                           } else if(var37 < 1900) {
                              var27 = var47?class216.field3159:class36.field781;
                              if(var37 == 1800) {
                                 class36.field780[var5++] = class116.method2461(class34.method734(var27));
                                 continue;
                              }

                              if(var37 == 1801) {
                                 --var5;
                                 var28 = class36.field780[var5];
                                 --var28;
                                 if(null != var27.field2822 && var28 < var27.field2822.length && var27.field2822[var28] != null) {
                                    class36.field789[var6++] = var27.field2822[var28];
                                    continue;
                                 }

                                 class36.field789[var6++] = "";
                                 continue;
                              }

                              if(var37 == 1802) {
                                 if(var27.field2760 == null) {
                                    class36.field789[var6++] = "";
                                 } else {
                                    class36.field789[var6++] = var27.field2760;
                                 }
                                 continue;
                              }
                           } else if((var37 < 1900 || var37 >= 2000) && (var37 < 2900 || var37 >= 3000)) {
                              if(var37 < 2600) {
                                 --var5;
                                 var27 = class161.method3205(class36.field780[var5]);
                                 if(var37 == 2500) {
                                    class36.field780[var5++] = var27.field2796;
                                    continue;
                                 }

                                 if(var37 == 2501) {
                                    class36.field780[var5++] = var27.field2823;
                                    continue;
                                 }

                                 if(var37 == 2502) {
                                    class36.field780[var5++] = var27.field2763;
                                    continue;
                                 }

                                 if(var37 == 2503) {
                                    class36.field780[var5++] = var27.field2764;
                                    continue;
                                 }

                                 if(var37 == 2504) {
                                    class36.field780[var5++] = var27.field2882?1:0;
                                    continue;
                                 }

                                 if(var37 == 2505) {
                                    class36.field780[var5++] = var27.field2777;
                                    continue;
                                 }
                              } else if(var37 < 2700) {
                                 --var5;
                                 var27 = class161.method3205(class36.field780[var5]);
                                 if(var37 == 2600) {
                                    class36.field780[var5++] = var27.field2863;
                                    continue;
                                 }

                                 if(var37 == 2601) {
                                    class36.field780[var5++] = var27.field2770;
                                    continue;
                                 }

                                 if(var37 == 2602) {
                                    class36.field789[var6++] = var27.field2808;
                                    continue;
                                 }

                                 if(var37 == 2603) {
                                    class36.field780[var5++] = var27.field2771;
                                    continue;
                                 }

                                 if(var37 == 2604) {
                                    class36.field780[var5++] = var27.field2772;
                                    continue;
                                 }

                                 if(var37 == 2605) {
                                    class36.field780[var5++] = var27.field2802;
                                    continue;
                                 }

                                 if(var37 == 2606) {
                                    class36.field780[var5++] = var27.field2839;
                                    continue;
                                 }

                                 if(var37 == 2607) {
                                    class36.field780[var5++] = var27.field2844;
                                    continue;
                                 }

                                 if(var37 == 2608) {
                                    class36.field780[var5++] = var27.field2800;
                                    continue;
                                 }

                                 if(var37 == 2609) {
                                    class36.field780[var5++] = var27.field2830;
                                    continue;
                                 }

                                 if(var37 == 2610) {
                                    class36.field780[var5++] = var27.field2780;
                                    continue;
                                 }

                                 if(var37 == 2611) {
                                    class36.field780[var5++] = var27.field2773;
                                    continue;
                                 }

                                 if(var37 == 2612) {
                                    class36.field780[var5++] = var27.field2755;
                                    continue;
                                 }

                                 if(var37 == 2613) {
                                    class36.field780[var5++] = var27.field2778.vmethod3185();
                                    continue;
                                 }
                              } else if(var37 < 2800) {
                                 if(var37 == 2700) {
                                    --var5;
                                    var27 = class161.method3205(class36.field780[var5]);
                                    class36.field780[var5++] = var27.field2868;
                                    continue;
                                 }

                                 if(var37 == 2701) {
                                    --var5;
                                    var27 = class161.method3205(class36.field780[var5]);
                                    if(var27.field2868 != -1) {
                                       class36.field780[var5++] = var27.field2871;
                                    } else {
                                       class36.field780[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var37 == 2702) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    class3 var38 = (class3)client.field448.method3807((long)var15);
                                    if(var38 != null) {
                                       class36.field780[var5++] = 1;
                                    } else {
                                       class36.field780[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var37 == 2706) {
                                    class36.field780[var5++] = client.field456;
                                    continue;
                                 }
                              } else if(var37 < 2900) {
                                 --var5;
                                 var27 = class161.method3205(class36.field780[var5]);
                                 if(var37 == 2800) {
                                    class36.field780[var5++] = class116.method2461(class34.method734(var27));
                                    continue;
                                 }

                                 if(var37 == 2801) {
                                    --var5;
                                    var28 = class36.field780[var5];
                                    --var28;
                                    if(var27.field2822 != null && var28 < var27.field2822.length && var27.field2822[var28] != null) {
                                       class36.field789[var6++] = var27.field2822[var28];
                                       continue;
                                    }

                                    class36.field789[var6++] = "";
                                    continue;
                                 }

                                 if(var37 == 2802) {
                                    if(var27.field2760 == null) {
                                       class36.field789[var6++] = "";
                                    } else {
                                       class36.field789[var6++] = var27.field2760;
                                    }
                                    continue;
                                 }
                              } else if(var37 < 3200) {
                                 if(var37 == 3100) {
                                    --var6;
                                    var93 = class36.field789[var6];
                                    class45.method955(0, "", var93);
                                    continue;
                                 }

                                 if(var37 == 3101) {
                                    var5 -= 2;
                                    class153.method3164(class153.field2262, class36.field780[var5], class36.field780[1 + var5]);
                                    continue;
                                 }

                                 if(var37 == 3103) {
                                    class115.method2454();
                                    continue;
                                 }

                                 if(var37 == 3104) {
                                    --var6;
                                    var93 = class36.field789[var6];
                                    var28 = 0;
                                    if(class154.method3171(var93)) {
                                       var29 = class9.method117(var93, 10, true);
                                       var28 = var29;
                                    }

                                    client.field331.method2781(182);
                                    client.field331.method2502(var28);
                                    continue;
                                 }

                                 if(var37 == 3105) {
                                    --var6;
                                    var93 = class36.field789[var6];
                                    client.field331.method2781(99);
                                    client.field331.method2650(var93.length() + 1);
                                    client.field331.method2505(var93);
                                    continue;
                                 }

                                 if(var37 == 3106) {
                                    --var6;
                                    var93 = class36.field789[var6];
                                    client.field331.method2781(196);
                                    client.field331.method2650(var93.length() + 1);
                                    client.field331.method2505(var93);
                                    continue;
                                 }

                                 if(var37 == 3107) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    --var6;
                                    var39 = class36.field789[var6];
                                    class19.method222(var15, var39);
                                    continue;
                                 }

                                 if(var37 == 3108) {
                                    var5 -= 3;
                                    var15 = class36.field780[var5];
                                    var28 = class36.field780[1 + var5];
                                    var29 = class36.field780[2 + var5];
                                    var44 = class161.method3205(var29);
                                    class165.method3250(var44, var15, var28);
                                    continue;
                                 }

                                 if(var37 == 3109) {
                                    var5 -= 2;
                                    var15 = class36.field780[var5];
                                    var28 = class36.field780[1 + var5];
                                    var41 = var47?class216.field3159:class36.field781;
                                    class165.method3250(var41, var15, var28);
                                    continue;
                                 }

                                 if(var37 == 3110) {
                                    --var5;
                                    class161.field2631 = class36.field780[var5] == 1;
                                    continue;
                                 }

                                 if(var37 == 3111) {
                                    class36.field780[var5++] = class162.field2637.field132?1:0;
                                    continue;
                                 }

                                 if(var37 == 3112) {
                                    --var5;
                                    class162.field2637.field132 = class36.field780[var5] == 1;
                                    class8.method96();
                                    continue;
                                 }

                                 if(var37 == 3113) {
                                    --var6;
                                    var93 = class36.field789[var6];
                                    --var5;
                                    var70 = class36.field780[var5] == 1;
                                    class8.method111(var93, var70, "openjs", false);
                                    continue;
                                 }

                                 if(var37 == 3115) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    client.field331.method2781(153);
                                    client.field331.method2695(var15);
                                    continue;
                                 }

                                 if(var37 == 3116) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    var6 -= 2;
                                    var39 = class36.field789[var6];
                                    var17 = class36.field789[var6 + 1];
                                    if(var39.length() <= 500 && var17.length() <= 500) {
                                       client.field331.method2781(189);
                                       client.field331.method2695(1 + class4.method41(var39) + class4.method41(var17));
                                       client.field331.method2505(var39);
                                       client.field331.method2505(var17);
                                       client.field331.method2597(var15);
                                    }
                                    continue;
                                 }
                              } else if(var37 < 3300) {
                                 if(var37 == 3200) {
                                    var5 -= 3;
                                    class50.method1016(class36.field780[var5], class36.field780[var5 + 1], class36.field780[2 + var5]);
                                    continue;
                                 }

                                 if(var37 == 3201) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    if(var15 == -1 && !client.field526) {
                                       class183.field2952.method3614();
                                       class183.field2953 = 1;
                                       class50.field1075 = null;
                                    } else if(var15 != -1 && client.field525 != var15 && client.field524 != 0 && !client.field526) {
                                       class12.method155(2, client.field358, var15, 0, client.field524, false);
                                    }

                                    client.field525 = var15;
                                    continue;
                                 }

                                 if(var37 == 3202) {
                                    var5 -= 2;
                                    var15 = class36.field780[var5];
                                    int var10000 = class36.field780[var5 + 1];
                                    if(client.field524 != 0 && var15 != -1) {
                                       class85.method1922(class84.field1422, var15, 0, client.field524, false);
                                       client.field526 = true;
                                    }
                                    continue;
                                 }
                              } else {
                                 int var22;
                                 if(var37 < 3400) {
                                    if(var37 == 3300) {
                                       class36.field780[var5++] = client.field296;
                                       continue;
                                    }

                                    class15 var31;
                                    if(var37 == 3301) {
                                       var5 -= 2;
                                       var15 = class36.field780[var5];
                                       var28 = class36.field780[1 + var5];
                                       var42 = class36.field780;
                                       var26 = var5++;
                                       var31 = (class15)class15.field221.method3807((long)var15);
                                       if(null == var31) {
                                          var19 = -1;
                                       } else if(var28 >= 0 && var28 < var31.field216.length) {
                                          var19 = var31.field216[var28];
                                       } else {
                                          var19 = -1;
                                       }

                                       var42[var26] = var19;
                                       continue;
                                    }

                                    if(var37 == 3302) {
                                       var5 -= 2;
                                       var15 = class36.field780[var5];
                                       var28 = class36.field780[1 + var5];
                                       var42 = class36.field780;
                                       var26 = var5++;
                                       var31 = (class15)class15.field221.method3807((long)var15);
                                       if(var31 == null) {
                                          var19 = 0;
                                       } else if(var28 >= 0 && var28 < var31.field217.length) {
                                          var19 = var31.field217[var28];
                                       } else {
                                          var19 = 0;
                                       }

                                       var42[var26] = var19;
                                       continue;
                                    }

                                    if(var37 == 3303) {
                                       var5 -= 2;
                                       var15 = class36.field780[var5];
                                       var28 = class36.field780[var5 + 1];
                                       var42 = class36.field780;
                                       var26 = var5++;
                                       var31 = (class15)class15.field221.method3807((long)var15);
                                       if(null == var31) {
                                          var19 = 0;
                                       } else if(var28 == -1) {
                                          var19 = 0;
                                       } else {
                                          var21 = 0;

                                          for(var22 = 0; var22 < var31.field217.length; ++var22) {
                                             if(var31.field216[var22] == var28) {
                                                var21 += var31.field217[var22];
                                             }
                                          }

                                          var19 = var21;
                                       }

                                       var42[var26] = var19;
                                       continue;
                                    }

                                    if(var37 == 3304) {
                                       --var5;
                                       var15 = class36.field780[var5];
                                       class36.field780[var5++] = class106.method2382(var15).field1072;
                                       continue;
                                    }

                                    if(var37 == 3305) {
                                       --var5;
                                       var15 = class36.field780[var5];
                                       class36.field780[var5++] = client.field356[var15];
                                       continue;
                                    }

                                    if(var37 == 3306) {
                                       --var5;
                                       var15 = class36.field780[var5];
                                       class36.field780[var5++] = client.field425[var15];
                                       continue;
                                    }

                                    if(var37 == 3307) {
                                       --var5;
                                       var15 = class36.field780[var5];
                                       class36.field780[var5++] = client.field426[var15];
                                       continue;
                                    }

                                    if(var37 == 3308) {
                                       var15 = class144.field2193;
                                       var28 = (class153.field2262.field813 >> 7) + class4.field62;
                                       var29 = class85.field1434 + (class153.field2262.field791 >> 7);
                                       class36.field780[var5++] = (var28 << 14) + (var15 << 28) + var29;
                                       continue;
                                    }

                                    if(var37 == 3309) {
                                       --var5;
                                       var15 = class36.field780[var5];
                                       class36.field780[var5++] = var15 >> 14 & 16383;
                                       continue;
                                    }

                                    if(var37 == 3310) {
                                       --var5;
                                       var15 = class36.field780[var5];
                                       class36.field780[var5++] = var15 >> 28;
                                       continue;
                                    }

                                    if(var37 == 3311) {
                                       --var5;
                                       var15 = class36.field780[var5];
                                       class36.field780[var5++] = var15 & 16383;
                                       continue;
                                    }

                                    if(var37 == 3312) {
                                       class36.field780[var5++] = client.field290?1:0;
                                       continue;
                                    }

                                    if(var37 == 3313) {
                                       var5 -= 2;
                                       var15 = '耀' + class36.field780[var5];
                                       var28 = class36.field780[var5 + 1];
                                       var42 = class36.field780;
                                       var26 = var5++;
                                       var31 = (class15)class15.field221.method3807((long)var15);
                                       if(null == var31) {
                                          var19 = -1;
                                       } else if(var28 >= 0 && var28 < var31.field216.length) {
                                          var19 = var31.field216[var28];
                                       } else {
                                          var19 = -1;
                                       }

                                       var42[var26] = var19;
                                       continue;
                                    }

                                    if(var37 == 3314) {
                                       var5 -= 2;
                                       var15 = class36.field780[var5] + '耀';
                                       var28 = class36.field780[var5 + 1];
                                       var42 = class36.field780;
                                       var26 = var5++;
                                       var31 = (class15)class15.field221.method3807((long)var15);
                                       if(var31 == null) {
                                          var19 = 0;
                                       } else if(var28 >= 0 && var28 < var31.field217.length) {
                                          var19 = var31.field217[var28];
                                       } else {
                                          var19 = 0;
                                       }

                                       var42[var26] = var19;
                                       continue;
                                    }

                                    if(var37 == 3315) {
                                       var5 -= 2;
                                       var15 = class36.field780[var5] + '耀';
                                       var28 = class36.field780[var5 + 1];
                                       var42 = class36.field780;
                                       var26 = var5++;
                                       var31 = (class15)class15.field221.method3807((long)var15);
                                       if(var31 == null) {
                                          var19 = 0;
                                       } else if(var28 == -1) {
                                          var19 = 0;
                                       } else {
                                          var21 = 0;

                                          for(var22 = 0; var22 < var31.field217.length; ++var22) {
                                             if(var31.field216[var22] == var28) {
                                                var21 += var31.field217[var22];
                                             }
                                          }

                                          var19 = var21;
                                       }

                                       var42[var26] = var19;
                                       continue;
                                    }

                                    if(var37 == 3316) {
                                       if(client.field354 >= 2) {
                                          class36.field780[var5++] = client.field354;
                                       } else {
                                          class36.field780[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var37 == 3317) {
                                       class36.field780[var5++] = client.field519;
                                       continue;
                                    }

                                    if(var37 == 3318) {
                                       class36.field780[var5++] = client.field286;
                                       continue;
                                    }

                                    if(var37 == 3321) {
                                       class36.field780[var5++] = client.field452;
                                       continue;
                                    }

                                    if(var37 == 3322) {
                                       class36.field780[var5++] = client.field453;
                                       continue;
                                    }

                                    if(var37 == 3323) {
                                       if(client.field454) {
                                          class36.field780[var5++] = 1;
                                       } else {
                                          class36.field780[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var37 == 3324) {
                                       class36.field780[var5++] = client.field477;
                                       continue;
                                    }
                                 } else if(var37 < 3500) {
                                    if(var37 == 3400) {
                                       var5 -= 2;
                                       var15 = class36.field780[var5];
                                       var28 = class36.field780[var5 + 1];
                                       class48 var45 = (class48)class48.field1058.method3764((long)var15);
                                       class48 var46;
                                       if(var45 != null) {
                                          var46 = var45;
                                       } else {
                                          byte[] var73 = class48.field1053.method3266(8, var15);
                                          var45 = new class48();
                                          if(var73 != null) {
                                             var45.method985(new class119(var73));
                                          }

                                          class48.field1058.method3759(var45, (long)var15);
                                          var46 = var45;
                                       }

                                       var45 = var46;
                                       if(var46.field1051 != 115) {
                                          ;
                                       }

                                       for(var19 = 0; var19 < var45.field1054; ++var19) {
                                          if(var45.field1055[var19] == var28) {
                                             class36.field789[var6++] = var45.field1057[var19];
                                             var45 = null;
                                             break;
                                          }
                                       }

                                       if(var45 != null) {
                                          class36.field789[var6++] = var45.field1052;
                                       }
                                       continue;
                                    }

                                    if(var37 == 3408) {
                                       var5 -= 4;
                                       var15 = class36.field780[var5];
                                       var28 = class36.field780[1 + var5];
                                       var29 = class36.field780[var5 + 2];
                                       var26 = class36.field780[var5 + 3];
                                       class48 var81 = (class48)class48.field1058.method3764((long)var29);
                                       class48 var30;
                                       if(var81 != null) {
                                          var30 = var81;
                                       } else {
                                          byte[] var32 = class48.field1053.method3266(8, var29);
                                          var81 = new class48();
                                          if(var32 != null) {
                                             var81.method985(new class119(var32));
                                          }

                                          class48.field1058.method3759(var81, (long)var29);
                                          var30 = var81;
                                       }

                                       var81 = var30;
                                       if(var15 == var30.field1050 && var30.field1051 == var28) {
                                          for(var21 = 0; var21 < var81.field1054; ++var21) {
                                             if(var81.field1055[var21] == var26) {
                                                if(var28 == 115) {
                                                   class36.field789[var6++] = var81.field1057[var21];
                                                } else {
                                                   class36.field780[var5++] = var81.field1056[var21];
                                                }

                                                var81 = null;
                                                break;
                                             }
                                          }

                                          if(null != var81) {
                                             if(var28 == 115) {
                                                class36.field789[var6++] = var81.field1052;
                                             } else {
                                                class36.field780[var5++] = var81.field1059;
                                             }
                                          }
                                          continue;
                                       }

                                       if(var28 == 115) {
                                          class36.field789[var6++] = "null";
                                       } else {
                                          class36.field780[var5++] = 0;
                                       }
                                       continue;
                                    }
                                 } else {
                                    String var90;
                                    if(var37 < 3700) {
                                       if(var37 == 3600) {
                                          if(client.field555 == 0) {
                                             class36.field780[var5++] = -2;
                                          } else if(client.field555 == 1) {
                                             class36.field780[var5++] = -1;
                                          } else {
                                             class36.field780[var5++] = client.field340;
                                          }
                                          continue;
                                       }

                                       if(var37 == 3601) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(client.field555 == 2 && var15 < client.field340) {
                                             class36.field789[var6++] = client.field556[var15].field243;
                                             class36.field789[var6++] = client.field556[var15].field246;
                                             continue;
                                          }

                                          class36.field789[var6++] = "";
                                          class36.field789[var6++] = "";
                                          continue;
                                       }

                                       if(var37 == 3602) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(client.field555 == 2 && var15 < client.field340) {
                                             class36.field780[var5++] = client.field556[var15].field249;
                                             continue;
                                          }

                                          class36.field780[var5++] = 0;
                                          continue;
                                       }

                                       if(var37 == 3603) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(client.field555 == 2 && var15 < client.field340) {
                                             class36.field780[var5++] = client.field556[var15].field248;
                                             continue;
                                          }

                                          class36.field780[var5++] = 0;
                                          continue;
                                       }

                                       if(var37 == 3604) {
                                          --var6;
                                          var93 = class36.field789[var6];
                                          --var5;
                                          var28 = class36.field780[var5];
                                          client.field331.method2781(244);
                                          client.field331.method2650(class4.method41(var93) + 1);
                                          client.field331.method2539(var28);
                                          client.field331.method2505(var93);
                                          continue;
                                       }

                                       if(var37 == 3605) {
                                          --var6;
                                          var93 = class36.field789[var6];
                                          if(var93 == null) {
                                             continue;
                                          }

                                          if((client.field340 < 200 || client.field412 == 1) && client.field340 < 400) {
                                             var39 = class39.method796(var93, client.field289);
                                             if(var39 == null) {
                                                continue;
                                             }

                                             String var74;
                                             for(var29 = 0; var29 < client.field340; ++var29) {
                                                class17 var49 = client.field556[var29];
                                                var74 = class39.method796(var49.field243, client.field289);
                                                if(var74 != null && var74.equals(var39)) {
                                                   class45.method955(30, "", var93 + " is already on your friend list");
                                                   continue label3624;
                                                }

                                                if(null != var49.field246) {
                                                   var90 = class39.method796(var49.field246, client.field289);
                                                   if(var90 != null && var90.equals(var39)) {
                                                      class45.method955(30, "", var93 + " is already on your friend list");
                                                      continue label3624;
                                                   }
                                                }
                                             }

                                             for(var29 = 0; var29 < client.field513; ++var29) {
                                                class7 var52 = client.field559[var29];
                                                var74 = class39.method796(var52.field124, client.field289);
                                                if(var74 != null && var74.equals(var39)) {
                                                   class45.method955(30, "", "Please remove " + var93 + " from your ignore list first");
                                                   continue label3624;
                                                }

                                                if(null != var52.field122) {
                                                   var90 = class39.method796(var52.field122, client.field289);
                                                   if(null != var90 && var90.equals(var39)) {
                                                      class45.method955(30, "", "Please remove " + var93 + " from your ignore list first");
                                                      continue label3624;
                                                   }
                                                }
                                             }

                                             if(class39.method796(class153.field2262.field26, client.field289).equals(var39)) {
                                                class45.method955(30, "", "You can\'t add yourself to your own friend list");
                                             } else {
                                                client.field331.method2781(3);
                                                client.field331.method2650(class4.method41(var93));
                                                client.field331.method2505(var93);
                                             }
                                             continue;
                                          }

                                          class45.method955(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                          continue;
                                       }

                                       if(var37 == 3606) {
                                          --var6;
                                          var93 = class36.field789[var6];
                                          class31.method666(var93);
                                          continue;
                                       }

                                       if(var37 == 3607) {
                                          --var6;
                                          var93 = class36.field789[var6];
                                          class126.method2844(var93, false);
                                          continue;
                                       }

                                       if(var37 == 3608) {
                                          --var6;
                                          var93 = class36.field789[var6];
                                          class75.method1657(var93);
                                          continue;
                                       }

                                       if(var37 == 3609) {
                                          --var6;
                                          var93 = class36.field789[var6];
                                          class152[] var40 = class4.method39();

                                          for(var29 = 0; var29 < var40.length; ++var29) {
                                             class152 var48 = var40[var29];
                                             if(var48.field2249 != -1 && var93.startsWith(class56.method1172(var48.field2249))) {
                                                var93 = var93.substring(6 + Integer.toString(var48.field2249).length());
                                                break;
                                             }
                                          }

                                          class36.field780[var5++] = class11.method147(var93, false)?1:0;
                                          continue;
                                       }

                                       if(var37 == 3611) {
                                          if(null != client.field514) {
                                             class36.field789[var6++] = class50.method1014(client.field514);
                                          } else {
                                             class36.field789[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var37 == 3612) {
                                          if(null != client.field514) {
                                             class36.field780[var5++] = class116.field1957;
                                          } else {
                                             class36.field780[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(var37 == 3613) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(client.field514 != null && var15 < class116.field1957) {
                                             class36.field789[var6++] = class40.field923[var15].field617;
                                             continue;
                                          }

                                          class36.field789[var6++] = "";
                                          continue;
                                       }

                                       if(var37 == 3614) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(null != client.field514 && var15 < class116.field1957) {
                                             class36.field780[var5++] = class40.field923[var15].field619;
                                             continue;
                                          }

                                          class36.field780[var5++] = 0;
                                          continue;
                                       }

                                       if(var37 == 3615) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(client.field514 != null && var15 < class116.field1957) {
                                             class36.field780[var5++] = class40.field923[var15].field622;
                                             continue;
                                          }

                                          class36.field780[var5++] = 0;
                                          continue;
                                       }

                                       if(var37 == 3616) {
                                          class36.field780[var5++] = class153.field2264;
                                          continue;
                                       }

                                       if(var37 == 3617) {
                                          --var6;
                                          var93 = class36.field789[var6];
                                          if(null != class40.field923) {
                                             client.field331.method2781(185);
                                             client.field331.method2650(class4.method41(var93));
                                             client.field331.method2505(var93);
                                          }
                                          continue;
                                       }

                                       if(var37 == 3618) {
                                          class36.field780[var5++] = class119.field1986;
                                          continue;
                                       }

                                       if(var37 == 3619) {
                                          --var6;
                                          var93 = class36.field789[var6];
                                          if(!var93.equals("")) {
                                             client.field331.method2781(144);
                                             client.field331.method2650(class4.method41(var93));
                                             client.field331.method2505(var93);
                                          }
                                          continue;
                                       }

                                       if(var37 == 3620) {
                                          client.field331.method2781(144);
                                          client.field331.method2650(0);
                                          continue;
                                       }

                                       if(var37 == 3621) {
                                          if(client.field555 == 0) {
                                             class36.field780[var5++] = -1;
                                          } else {
                                             class36.field780[var5++] = client.field513;
                                          }
                                          continue;
                                       }

                                       if(var37 == 3622) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(client.field555 != 0 && var15 < client.field513) {
                                             class36.field789[var6++] = client.field559[var15].field124;
                                             class36.field789[var6++] = client.field559[var15].field122;
                                             continue;
                                          }

                                          class36.field789[var6++] = "";
                                          class36.field789[var6++] = "";
                                          continue;
                                       }

                                       if(var37 == 3623) {
                                          --var6;
                                          var93 = class36.field789[var6];
                                          if(var93.startsWith(class56.method1172(0)) || var93.startsWith(class56.method1172(1))) {
                                             var93 = var93.substring(7);
                                          }

                                          class36.field780[var5++] = class45.method953(var93)?1:0;
                                          continue;
                                       }

                                       if(var37 == 3624) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(class40.field923 != null && var15 < class116.field1957 && class40.field923[var15].field617.equalsIgnoreCase(class153.field2262.field26)) {
                                             class36.field780[var5++] = 1;
                                             continue;
                                          }

                                          class36.field780[var5++] = 0;
                                          continue;
                                       }

                                       if(var37 == 3625) {
                                          if(null != client.field515) {
                                             class36.field789[var6++] = class50.method1014(client.field515);
                                          } else {
                                             class36.field789[var6++] = "";
                                          }
                                          continue;
                                       }
                                    } else {
                                       long var84;
                                       if(var37 < 4000) {
                                          if(var37 == 3903) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = client.field528[var15].method3998();
                                             continue;
                                          }

                                          if(var37 == 3904) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = client.field528[var15].field3173;
                                             continue;
                                          }

                                          if(var37 == 3905) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = client.field528[var15].field3172;
                                             continue;
                                          }

                                          if(var37 == 3906) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = client.field528[var15].field3175;
                                             continue;
                                          }

                                          if(var37 == 3907) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = client.field528[var15].field3174;
                                             continue;
                                          }

                                          if(var37 == 3908) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = client.field528[var15].field3177;
                                             continue;
                                          }

                                          if(var37 == 3910) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var28 = client.field528[var15].method4006();
                                             class36.field780[var5++] = var28 == 0?1:0;
                                             continue;
                                          }

                                          if(var37 == 3911) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var28 = client.field528[var15].method4006();
                                             class36.field780[var5++] = var28 == 2?1:0;
                                             continue;
                                          }

                                          if(var37 == 3912) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var28 = client.field528[var15].method4006();
                                             class36.field780[var5++] = var28 == 5?1:0;
                                             continue;
                                          }

                                          if(var37 == 3913) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var28 = client.field528[var15].method4006();
                                             class36.field780[var5++] = var28 == 1?1:0;
                                             continue;
                                          }

                                          boolean var65;
                                          if(var37 == 3914) {
                                             --var5;
                                             var65 = class36.field780[var5] == 1;
                                             if(class143.field2172 != null) {
                                                class143.field2172.method4020(class221.field3184, var65);
                                             }
                                             continue;
                                          }

                                          if(var37 == 3915) {
                                             --var5;
                                             var65 = class36.field780[var5] == 1;
                                             if(null != class143.field2172) {
                                                class143.field2172.method4020(class221.field3181, var65);
                                             }
                                             continue;
                                          }

                                          if(var37 == 3916) {
                                             var5 -= 2;
                                             var65 = class36.field780[var5] == 1;
                                             var70 = class36.field780[var5 + 1] == 1;
                                             if(null != class143.field2172) {
                                                class143.field2172.method4020(new class21(var70), var65);
                                             }
                                             continue;
                                          }

                                          if(var37 == 3917) {
                                             --var5;
                                             var65 = class36.field780[var5] == 1;
                                             if(null != class143.field2172) {
                                                class143.field2172.method4020(class221.field3179, var65);
                                             }
                                             continue;
                                          }

                                          if(var37 == 3918) {
                                             --var5;
                                             var65 = class36.field780[var5] == 1;
                                             if(class143.field2172 != null) {
                                                class143.field2172.method4020(class221.field3182, var65);
                                             }
                                             continue;
                                          }

                                          if(var37 == 3919) {
                                             class36.field780[var5++] = null == class143.field2172?0:class143.field2172.field3185.size();
                                             continue;
                                          }

                                          class214 var43;
                                          if(var37 == 3920) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var43 = (class214)class143.field2172.field3185.get(var15);
                                             class36.field780[var5++] = var43.field3147;
                                             continue;
                                          }

                                          if(var37 == 3921) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var43 = (class214)class143.field2172.field3185.get(var15);
                                             class36.field789[var6++] = var43.method3946();
                                             continue;
                                          }

                                          if(var37 == 3922) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var43 = (class214)class143.field2172.field3185.get(var15);
                                             class36.field789[var6++] = var43.method3949();
                                             continue;
                                          }

                                          if(var37 == 3923) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var43 = (class214)class143.field2172.field3185.get(var15);
                                             var84 = method2090() - class157.field2576 - var43.field3151;
                                             var19 = (int)(var84 / 3600000L);
                                             var20 = (int)((var84 - (long)(var19 * 3600000)) / 60000L);
                                             var21 = (int)((var84 - (long)(var19 * 3600000) - (long)(var20 * '\uea60')) / 1000L);
                                             String var33 = var19 + ":" + var20 / 10 + var20 % 10 + ":" + var21 / 10 + var21 % 10;
                                             class36.field789[var6++] = var33;
                                             continue;
                                          }

                                          if(var37 == 3924) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var43 = (class214)class143.field2172.field3185.get(var15);
                                             class36.field780[var5++] = var43.field3148.field3175;
                                             continue;
                                          }

                                          if(var37 == 3925) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var43 = (class214)class143.field2172.field3185.get(var15);
                                             class36.field780[var5++] = var43.field3148.field3172;
                                             continue;
                                          }

                                          if(var37 == 3926) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var43 = (class214)class143.field2172.field3185.get(var15);
                                             class36.field780[var5++] = var43.field3148.field3173;
                                             continue;
                                          }
                                       } else if(var37 < 4100) {
                                          if(var37 == 4000) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[var5 + 1];
                                             class36.field780[var5++] = var28 + var15;
                                             continue;
                                          }

                                          if(var37 == 4001) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[var5 + 1];
                                             class36.field780[var5++] = var15 - var28;
                                             continue;
                                          }

                                          if(var37 == 4002) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[var5 + 1];
                                             class36.field780[var5++] = var15 * var28;
                                             continue;
                                          }

                                          if(var37 == 4003) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[1 + var5];
                                             class36.field780[var5++] = var15 / var28;
                                             continue;
                                          }

                                          if(var37 == 4004) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = (int)(Math.random() * (double)var15);
                                             continue;
                                          }

                                          if(var37 == 4005) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = (int)(Math.random() * (double)(var15 + 1));
                                             continue;
                                          }

                                          if(var37 == 4006) {
                                             var5 -= 5;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[1 + var5];
                                             var29 = class36.field780[2 + var5];
                                             var26 = class36.field780[3 + var5];
                                             var19 = class36.field780[var5 + 4];
                                             class36.field780[var5++] = var15 + (var19 - var29) * (var28 - var15) / (var26 - var29);
                                             continue;
                                          }

                                          if(var37 == 4007) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[var5 + 1];
                                             class36.field780[var5++] = var28 * var15 / 100 + var15;
                                             continue;
                                          }

                                          if(var37 == 4008) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[var5 + 1];
                                             class36.field780[var5++] = var15 | 1 << var28;
                                             continue;
                                          }

                                          if(var37 == 4009) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[var5 + 1];
                                             class36.field780[var5++] = var15 & -1 - (1 << var28);
                                             continue;
                                          }

                                          if(var37 == 4010) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[1 + var5];
                                             class36.field780[var5++] = (var15 & 1 << var28) != 0?1:0;
                                             continue;
                                          }

                                          if(var37 == 4011) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[1 + var5];
                                             class36.field780[var5++] = var15 % var28;
                                             continue;
                                          }

                                          if(var37 == 4012) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[1 + var5];
                                             if(var15 == 0) {
                                                class36.field780[var5++] = 0;
                                             } else {
                                                class36.field780[var5++] = (int)Math.pow((double)var15, (double)var28);
                                             }
                                             continue;
                                          }

                                          if(var37 == 4013) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[var5 + 1];
                                             if(var15 == 0) {
                                                class36.field780[var5++] = 0;
                                             } else if(var28 == 0) {
                                                class36.field780[var5++] = Integer.MAX_VALUE;
                                             } else {
                                                class36.field780[var5++] = (int)Math.pow((double)var15, 1.0D / (double)var28);
                                             }
                                             continue;
                                          }

                                          if(var37 == 4014) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[var5 + 1];
                                             class36.field780[var5++] = var15 & var28;
                                             continue;
                                          }

                                          if(var37 == 4015) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[var5 + 1];
                                             class36.field780[var5++] = var15 | var28;
                                             continue;
                                          }

                                          if(var37 == 4018) {
                                             var5 -= 3;
                                             long var82 = (long)class36.field780[var5];
                                             var84 = (long)class36.field780[1 + var5];
                                             long var66 = (long)class36.field780[2 + var5];
                                             class36.field780[var5++] = (int)(var82 * var66 / var84);
                                             continue;
                                          }
                                       } else if(var37 < 4200) {
                                          if(var37 == 4100) {
                                             --var6;
                                             var93 = class36.field789[var6];
                                             --var5;
                                             var28 = class36.field780[var5];
                                             class36.field789[var6++] = var93 + var28;
                                             continue;
                                          }

                                          if(var37 == 4101) {
                                             var6 -= 2;
                                             var93 = class36.field789[var6];
                                             var39 = class36.field789[var6 + 1];
                                             class36.field789[var6++] = var93 + var39;
                                             continue;
                                          }

                                          if(var37 == 4102) {
                                             --var6;
                                             var93 = class36.field789[var6];
                                             --var5;
                                             var28 = class36.field780[var5];
                                             var51 = class36.field789;
                                             var26 = var6++;
                                             if(var28 < 0) {
                                                var90 = Integer.toString(var28);
                                             } else {
                                                var90 = class85.method1911(var28, 10, true);
                                             }

                                             var51[var26] = var93 + var90;
                                             continue;
                                          }

                                          if(var37 == 4103) {
                                             --var6;
                                             var93 = class36.field789[var6];
                                             class36.field789[var6++] = var93.toLowerCase();
                                             continue;
                                          }

                                          if(var37 == 4104) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             long var95 = 86400000L * (11745L + (long)var15);
                                             class36.field785.setTime(new Date(var95));
                                             var26 = class36.field785.get(5);
                                             var19 = class36.field785.get(2);
                                             var20 = class36.field785.get(1);
                                             class36.field789[var6++] = var26 + "-" + class36.field786[var19] + "-" + var20;
                                             continue;
                                          }

                                          if(var37 == 4105) {
                                             var6 -= 2;
                                             var93 = class36.field789[var6];
                                             var39 = class36.field789[1 + var6];
                                             if(class153.field2262.field49 != null && class153.field2262.field49.field2913) {
                                                class36.field789[var6++] = var39;
                                                continue;
                                             }

                                             class36.field789[var6++] = var93;
                                             continue;
                                          }

                                          if(var37 == 4106) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field789[var6++] = Integer.toString(var15);
                                             continue;
                                          }

                                          if(var37 == 4107) {
                                             var6 -= 2;
                                             class36.field780[var5++] = class13.method156(class102.method2289(class36.field789[var6], class36.field789[1 + var6], client.field292));
                                             continue;
                                          }

                                          class224 var76;
                                          if(var37 == 4108) {
                                             --var6;
                                             var93 = class36.field789[var6];
                                             var5 -= 2;
                                             var28 = class36.field780[var5];
                                             var29 = class36.field780[1 + var5];
                                             var54 = class43.field995.method3266(var29, 0);
                                             var76 = new class224(var54);
                                             class36.field780[var5++] = var76.method4031(var93, var28);
                                             continue;
                                          }

                                          if(var37 == 4109) {
                                             --var6;
                                             var93 = class36.field789[var6];
                                             var5 -= 2;
                                             var28 = class36.field780[var5];
                                             var29 = class36.field780[var5 + 1];
                                             var54 = class43.field995.method3266(var29, 0);
                                             var76 = new class224(var54);
                                             class36.field780[var5++] = var76.method4030(var93, var28);
                                             continue;
                                          }

                                          if(var37 == 4110) {
                                             var6 -= 2;
                                             var93 = class36.field789[var6];
                                             var39 = class36.field789[1 + var6];
                                             --var5;
                                             if(class36.field780[var5] == 1) {
                                                class36.field789[var6++] = var93;
                                             } else {
                                                class36.field789[var6++] = var39;
                                             }
                                             continue;
                                          }

                                          if(var37 == 4111) {
                                             --var6;
                                             var93 = class36.field789[var6];
                                             class36.field789[var6++] = class223.method4032(var93);
                                             continue;
                                          }

                                          if(var37 == 4112) {
                                             --var6;
                                             var93 = class36.field789[var6];
                                             --var5;
                                             var28 = class36.field780[var5];
                                             class36.field789[var6++] = var93 + (char)var28;
                                             continue;
                                          }

                                          char var68;
                                          if(var37 == 4113) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var53 = class36.field780;
                                             var29 = var5++;
                                             var68 = (char)var15;
                                             if(var68 >= 32 && var68 <= 126) {
                                                var69 = true;
                                             } else if(var68 >= 160 && var68 <= 255) {
                                                var69 = true;
                                             } else if(var68 != 8364 && var68 != 338 && var68 != 8212 && var68 != 339 && var68 != 376) {
                                                var69 = false;
                                             } else {
                                                var69 = true;
                                             }

                                             var53[var29] = var69?1:0;
                                             continue;
                                          }

                                          if(var37 == 4114) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = class153.method3169((char)var15)?1:0;
                                             continue;
                                          }

                                          if(var37 == 4115) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var53 = class36.field780;
                                             var29 = var5++;
                                             var68 = (char)var15;
                                             var69 = var68 >= 65 && var68 <= 90 || var68 >= 97 && var68 <= 122;
                                             var53[var29] = var69?1:0;
                                             continue;
                                          }

                                          if(var37 == 4116) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var53 = class36.field780;
                                             var29 = var5++;
                                             var68 = (char)var15;
                                             var69 = var68 >= 48 && var68 <= 57;
                                             var53[var29] = var69?1:0;
                                             continue;
                                          }

                                          if(var37 == 4117) {
                                             --var6;
                                             var93 = class36.field789[var6];
                                             if(var93 != null) {
                                                class36.field780[var5++] = var93.length();
                                             } else {
                                                class36.field780[var5++] = 0;
                                             }
                                             continue;
                                          }

                                          if(var37 == 4118) {
                                             --var6;
                                             var93 = class36.field789[var6];
                                             var5 -= 2;
                                             var28 = class36.field780[var5];
                                             var29 = class36.field780[var5 + 1];
                                             class36.field789[var6++] = var93.substring(var28, var29);
                                             continue;
                                          }

                                          if(var37 == 4119) {
                                             --var6;
                                             var93 = class36.field789[var6];
                                             StringBuilder var50 = new StringBuilder(var93.length());
                                             var91 = false;

                                             for(var26 = 0; var26 < var93.length(); ++var26) {
                                                var68 = var93.charAt(var26);
                                                if(var68 == 60) {
                                                   var91 = true;
                                                } else if(var68 == 62) {
                                                   var91 = false;
                                                } else if(!var91) {
                                                   var50.append(var68);
                                                }
                                             }

                                             class36.field789[var6++] = var50.toString();
                                             continue;
                                          }

                                          if(var37 == 4120) {
                                             --var6;
                                             var93 = class36.field789[var6];
                                             --var5;
                                             var28 = class36.field780[var5];
                                             class36.field780[var5++] = var93.indexOf(var28);
                                             continue;
                                          }

                                          if(var37 == 4121) {
                                             var6 -= 2;
                                             var93 = class36.field789[var6];
                                             var39 = class36.field789[var6 + 1];
                                             --var5;
                                             var29 = class36.field780[var5];
                                             class36.field780[var5++] = var93.indexOf(var39, var29);
                                             continue;
                                          }
                                       } else if(var37 < 4300) {
                                          if(var37 == 4200) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field789[var6++] = class35.method741(var15).field1090;
                                             continue;
                                          }

                                          class51 var55;
                                          if(var37 == 4201) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[var5 + 1];
                                             var55 = class35.method741(var15);
                                             if(var28 >= 1 && var28 <= 5 && var55.field1099[var28 - 1] != null) {
                                                class36.field789[var6++] = var55.field1099[var28 - 1];
                                                continue;
                                             }

                                             class36.field789[var6++] = "";
                                             continue;
                                          }

                                          if(var37 == 4202) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[1 + var5];
                                             var55 = class35.method741(var15);
                                             if(var28 >= 1 && var28 <= 5 && var55.field1105[var28 - 1] != null) {
                                                class36.field789[var6++] = var55.field1105[var28 - 1];
                                                continue;
                                             }

                                             class36.field789[var6++] = "";
                                             continue;
                                          }

                                          if(var37 == 4203) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = class35.method741(var15).field1097;
                                             continue;
                                          }

                                          if(var37 == 4204) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = class35.method741(var15).field1096 == 1?1:0;
                                             continue;
                                          }

                                          class51 var59;
                                          if(var37 == 4205) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var59 = class35.method741(var15);
                                             if(var59.field1116 == -1 && var59.field1112 >= 0) {
                                                class36.field780[var5++] = var59.field1112;
                                                continue;
                                             }

                                             class36.field780[var5++] = var15;
                                             continue;
                                          }

                                          if(var37 == 4206) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var59 = class35.method741(var15);
                                             if(var59.field1116 >= 0 && var59.field1112 >= 0) {
                                                class36.field780[var5++] = var59.field1112;
                                                continue;
                                             }

                                             class36.field780[var5++] = var15;
                                             continue;
                                          }

                                          if(var37 == 4207) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = class35.method741(var15).field1098?1:0;
                                             continue;
                                          }

                                          if(var37 == 4208) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var59 = class35.method741(var15);
                                             if(var59.field1127 == -1 && var59.field1126 >= 0) {
                                                class36.field780[var5++] = var59.field1126;
                                                continue;
                                             }

                                             class36.field780[var5++] = var15;
                                             continue;
                                          }

                                          if(var37 == 4209) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var59 = class35.method741(var15);
                                             if(var59.field1127 >= 0 && var59.field1126 >= 0) {
                                                class36.field780[var5++] = var59.field1126;
                                                continue;
                                             }

                                             class36.field780[var5++] = var15;
                                             continue;
                                          }

                                          if(var37 == 4210) {
                                             --var6;
                                             var93 = class36.field789[var6];
                                             --var5;
                                             var28 = class36.field780[var5];
                                             var69 = var28 == 1;
                                             var17 = var93.toLowerCase();
                                             short[] var78 = new short[16];
                                             var20 = 0;
                                             var21 = 0;

                                             while(true) {
                                                if(var21 >= class51.field1078) {
                                                   class3.field57 = var78;
                                                   class16.field229 = 0;
                                                   class3.field58 = var20;
                                                   String[] var77 = new String[class3.field58];

                                                   for(var22 = 0; var22 < class3.field58; ++var22) {
                                                      var77[var22] = class35.method741(var78[var22]).field1090;
                                                   }

                                                   short[] var86 = class3.field57;
                                                   class150.method3152(var77, var86, 0, var77.length - 1);
                                                   break;
                                                }

                                                class51 var83 = class35.method741(var21);
                                                if((!var69 || var83.field1123) && var83.field1116 == -1 && var83.field1090.toLowerCase().indexOf(var17) != -1) {
                                                   if(var20 >= 250) {
                                                      class3.field58 = -1;
                                                      class3.field57 = null;
                                                      break;
                                                   }

                                                   if(var20 >= var78.length) {
                                                      short[] var23 = new short[var78.length * 2];

                                                      for(int var24 = 0; var24 < var20; ++var24) {
                                                         var23[var24] = var78[var24];
                                                      }

                                                      var78 = var23;
                                                   }

                                                   var78[var20++] = (short)var21;
                                                }

                                                ++var21;
                                             }

                                             class36.field780[var5++] = class3.field58;
                                             continue;
                                          }

                                          if(var37 == 4211) {
                                             if(null != class3.field57 && class16.field229 < class3.field58) {
                                                class36.field780[var5++] = class3.field57[++class16.field229 - 1] & '\uffff';
                                                continue;
                                             }

                                             class36.field780[var5++] = -1;
                                             continue;
                                          }

                                          if(var37 == 4212) {
                                             class16.field229 = 0;
                                             continue;
                                          }
                                       } else if(var37 < 5100) {
                                          if(var37 == 5000) {
                                             class36.field780[var5++] = client.field355;
                                             continue;
                                          }

                                          if(var37 == 5001) {
                                             var5 -= 3;
                                             client.field355 = class36.field780[var5];
                                             class10.field156 = class186.method3746(class36.field780[1 + var5]);
                                             if(null == class10.field156) {
                                                class10.field156 = class130.field2043;
                                             }

                                             client.field506 = class36.field780[var5 + 2];
                                             client.field331.method2781(156);
                                             client.field331.method2650(client.field355);
                                             client.field331.method2650(class10.field156.field2045);
                                             client.field331.method2650(client.field506);
                                             continue;
                                          }

                                          if(var37 == 5002) {
                                             --var6;
                                             var93 = class36.field789[var6];
                                             var5 -= 2;
                                             var28 = class36.field780[var5];
                                             var29 = class36.field780[1 + var5];
                                             client.field331.method2781(13);
                                             client.field331.method2650(class4.method41(var93) + 2);
                                             client.field331.method2505(var93);
                                             client.field331.method2650(var28 - 1);
                                             client.field331.method2650(var29);
                                             continue;
                                          }

                                          if(var37 == 5003) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var28 = class36.field780[1 + var5];
                                             class35 var58 = class77.method1694(var15, var28);
                                             if(null != var58) {
                                                class36.field780[var5++] = var58.field769;
                                                class36.field780[var5++] = var58.field764;
                                                class36.field789[var6++] = null != var58.field766?var58.field766:"";
                                                class36.field789[var6++] = var58.field767 != null?var58.field767:"";
                                                class36.field789[var6++] = var58.field768 != null?var58.field768:"";
                                             } else {
                                                class36.field780[var5++] = -1;
                                                class36.field780[var5++] = 0;
                                                class36.field789[var6++] = "";
                                                class36.field789[var6++] = "";
                                                class36.field789[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(var37 == 5004) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class35 var61 = (class35)class11.field169.method3808((long)var15);
                                             if(var61 != null) {
                                                class36.field780[var5++] = var61.field765;
                                                class36.field780[var5++] = var61.field764;
                                                class36.field789[var6++] = null != var61.field766?var61.field766:"";
                                                class36.field789[var6++] = null != var61.field767?var61.field767:"";
                                                class36.field789[var6++] = var61.field768 != null?var61.field768:"";
                                             } else {
                                                class36.field780[var5++] = -1;
                                                class36.field780[var5++] = 0;
                                                class36.field789[var6++] = "";
                                                class36.field789[var6++] = "";
                                                class36.field789[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(var37 == 5005) {
                                             if(class10.field156 == null) {
                                                class36.field780[var5++] = -1;
                                             } else {
                                                class36.field780[var5++] = class10.field156.field2045;
                                             }
                                             continue;
                                          }

                                          if(var37 == 5008) {
                                             --var6;
                                             var93 = class36.field789[var6];
                                             --var5;
                                             var28 = class36.field780[var5];
                                             var17 = var93.toLowerCase();
                                             byte var88 = 0;
                                             if(var17.startsWith("yellow:")) {
                                                var88 = 0;
                                                var93 = var93.substring("yellow:".length());
                                             } else if(var17.startsWith("red:")) {
                                                var88 = 1;
                                                var93 = var93.substring("red:".length());
                                             } else if(var17.startsWith("green:")) {
                                                var88 = 2;
                                                var93 = var93.substring("green:".length());
                                             } else if(var17.startsWith("cyan:")) {
                                                var88 = 3;
                                                var93 = var93.substring("cyan:".length());
                                             } else if(var17.startsWith("purple:")) {
                                                var88 = 4;
                                                var93 = var93.substring("purple:".length());
                                             } else if(var17.startsWith("white:")) {
                                                var88 = 5;
                                                var93 = var93.substring("white:".length());
                                             } else if(var17.startsWith("flash1:")) {
                                                var88 = 6;
                                                var93 = var93.substring("flash1:".length());
                                             } else if(var17.startsWith("flash2:")) {
                                                var88 = 7;
                                                var93 = var93.substring("flash2:".length());
                                             } else if(var17.startsWith("flash3:")) {
                                                var88 = 8;
                                                var93 = var93.substring("flash3:".length());
                                             } else if(var17.startsWith("glow1:")) {
                                                var88 = 9;
                                                var93 = var93.substring("glow1:".length());
                                             } else if(var17.startsWith("glow2:")) {
                                                var88 = 10;
                                                var93 = var93.substring("glow2:".length());
                                             } else if(var17.startsWith("glow3:")) {
                                                var88 = 11;
                                                var93 = var93.substring("glow3:".length());
                                             } else if(client.field292 != 0) {
                                                if(var17.startsWith("yellow:")) {
                                                   var88 = 0;
                                                   var93 = var93.substring("yellow:".length());
                                                } else if(var17.startsWith("red:")) {
                                                   var88 = 1;
                                                   var93 = var93.substring("red:".length());
                                                } else if(var17.startsWith("green:")) {
                                                   var88 = 2;
                                                   var93 = var93.substring("green:".length());
                                                } else if(var17.startsWith("cyan:")) {
                                                   var88 = 3;
                                                   var93 = var93.substring("cyan:".length());
                                                } else if(var17.startsWith("purple:")) {
                                                   var88 = 4;
                                                   var93 = var93.substring("purple:".length());
                                                } else if(var17.startsWith("white:")) {
                                                   var88 = 5;
                                                   var93 = var93.substring("white:".length());
                                                } else if(var17.startsWith("flash1:")) {
                                                   var88 = 6;
                                                   var93 = var93.substring("flash1:".length());
                                                } else if(var17.startsWith("flash2:")) {
                                                   var88 = 7;
                                                   var93 = var93.substring("flash2:".length());
                                                } else if(var17.startsWith("flash3:")) {
                                                   var88 = 8;
                                                   var93 = var93.substring("flash3:".length());
                                                } else if(var17.startsWith("glow1:")) {
                                                   var88 = 9;
                                                   var93 = var93.substring("glow1:".length());
                                                } else if(var17.startsWith("glow2:")) {
                                                   var88 = 10;
                                                   var93 = var93.substring("glow2:".length());
                                                } else if(var17.startsWith("glow3:")) {
                                                   var88 = 11;
                                                   var93 = var93.substring("glow3:".length());
                                                }
                                             }

                                             var17 = var93.toLowerCase();
                                             byte var72 = 0;
                                             if(var17.startsWith("wave:")) {
                                                var72 = 1;
                                                var93 = var93.substring("wave:".length());
                                             } else if(var17.startsWith("wave2:")) {
                                                var72 = 2;
                                                var93 = var93.substring("wave2:".length());
                                             } else if(var17.startsWith("shake:")) {
                                                var72 = 3;
                                                var93 = var93.substring("shake:".length());
                                             } else if(var17.startsWith("scroll:")) {
                                                var72 = 4;
                                                var93 = var93.substring("scroll:".length());
                                             } else if(var17.startsWith("slide:")) {
                                                var72 = 5;
                                                var93 = var93.substring("slide:".length());
                                             } else if(client.field292 != 0) {
                                                if(var17.startsWith("wave:")) {
                                                   var72 = 1;
                                                   var93 = var93.substring("wave:".length());
                                                } else if(var17.startsWith("wave2:")) {
                                                   var72 = 2;
                                                   var93 = var93.substring("wave2:".length());
                                                } else if(var17.startsWith("shake:")) {
                                                   var72 = 3;
                                                   var93 = var93.substring("shake:".length());
                                                } else if(var17.startsWith("scroll:")) {
                                                   var72 = 4;
                                                   var93 = var93.substring("scroll:".length());
                                                } else if(var17.startsWith("slide:")) {
                                                   var72 = 5;
                                                   var93 = var93.substring("slide:".length());
                                                }
                                             }

                                             client.field331.method2781(44);
                                             client.field331.method2650(0);
                                             var20 = client.field331.field1976;
                                             client.field331.method2650(var28);
                                             client.field331.method2650(var88);
                                             client.field331.method2650(var72);
                                             class122 var80 = client.field331;
                                             var22 = var80.field1976;
                                             byte[] var60 = class45.method954(var93);
                                             var80.method2512(var60.length);
                                             var80.field1976 += class209.field3118.method2443(var60, 0, var60.length, var80.field1982, var80.field1976);
                                             client.field331.method2511(client.field331.field1976 - var20);
                                             continue;
                                          }

                                          if(var37 == 5009) {
                                             var6 -= 2;
                                             var93 = class36.field789[var6];
                                             var39 = class36.field789[var6 + 1];
                                             client.field331.method2781(222);
                                             client.field331.method2695(0);
                                             var29 = client.field331.field1976;
                                             client.field331.method2505(var93);
                                             class122 var56 = client.field331;
                                             var19 = var56.field1976;
                                             byte[] var92 = class45.method954(var39);
                                             var56.method2512(var92.length);
                                             var56.field1976 += class209.field3118.method2443(var92, 0, var92.length, var56.field1982, var56.field1976);
                                             client.field331.method2510(client.field331.field1976 - var29);
                                             continue;
                                          }

                                          if(var37 == 5015) {
                                             if(class153.field2262 != null && null != class153.field2262.field26) {
                                                var93 = class153.field2262.field26;
                                             } else {
                                                var93 = "";
                                             }

                                             class36.field789[var6++] = var93;
                                             continue;
                                          }

                                          if(var37 == 5016) {
                                             class36.field780[var5++] = client.field506;
                                             continue;
                                          }

                                          if(var37 == 5017) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var53 = class36.field780;
                                             var29 = var5++;
                                             class27 var85 = (class27)class11.field166.get(Integer.valueOf(var15));
                                             if(null == var85) {
                                                var26 = 0;
                                             } else {
                                                var26 = var85.method641();
                                             }

                                             var53[var29] = var26;
                                             continue;
                                          }

                                          if(var37 == 5018) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = class23.method590(var15);
                                             continue;
                                          }

                                          if(var37 == 5019) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = class115.method2455(var15);
                                             continue;
                                          }

                                          if(var37 == 5020) {
                                             --var6;
                                             var93 = class36.field789[var6];
                                             if(var93.equalsIgnoreCase("toggleroof")) {
                                                class162.field2637.field132 = !class162.field2637.field132;
                                                class8.method96();
                                                if(class162.field2637.field132) {
                                                   class45.method955(99, "", "Roofs are now all hidden");
                                                } else {
                                                   class45.method955(99, "", "Roofs will only be removed selectively");
                                                }
                                             }

                                             if(var93.equalsIgnoreCase("displayfps")) {
                                                client.field302 = !client.field302;
                                             }

                                             if(client.field354 >= 2) {
                                                if(var93.equalsIgnoreCase("fpson")) {
                                                   client.field302 = true;
                                                }

                                                if(var93.equalsIgnoreCase("fpsoff")) {
                                                   client.field302 = false;
                                                }

                                                if(var93.equalsIgnoreCase("gc")) {
                                                   System.gc();
                                                }

                                                if(var93.equalsIgnoreCase("clientdrop")) {
                                                   class157.method3180();
                                                }

                                                if(var93.equalsIgnoreCase("errortest") && client.field548 == 2) {
                                                   throw new RuntimeException();
                                                }
                                             }

                                             client.field331.method2781(69);
                                             client.field331.method2650(var93.length() + 1);
                                             client.field331.method2505(var93);
                                             continue;
                                          }

                                          if(var37 == 5021) {
                                             --var6;
                                             client.field503 = class36.field789[var6].toLowerCase().trim();
                                             continue;
                                          }

                                          if(var37 == 5022) {
                                             class36.field789[var6++] = client.field503;
                                             continue;
                                          }
                                       }
                                    }
                                 }
                              }
                           } else {
                              if(var37 >= 2000) {
                                 var37 -= 1000;
                                 --var5;
                                 var27 = class161.method3205(class36.field780[var5]);
                              } else {
                                 var27 = var47?class216.field3159:class36.field781;
                              }

                              if(var37 == 1927) {
                                 if(class36.field787 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(var27.field2857 == null) {
                                    return;
                                 }

                                 class0 var16 = new class0();
                                 var16.field10 = var27;
                                 var16.field12 = var27.field2857;
                                 var16.field2 = 1 + class36.field787;
                                 client.field486.method3819(var0);
                                 continue;
                              }
                           }
                        }
                     } else {
                        var28 = -1;
                        if(var37 >= 2000) {
                           var37 -= 1000;
                           --var5;
                           var28 = class36.field780[var5];
                           var27 = class161.method3205(var28);
                        } else {
                           var27 = var47?class216.field3159:class36.field781;
                        }

                        if(var37 == 1100) {
                           var5 -= 2;
                           var27.field2863 = class36.field780[var5];
                           if(var27.field2863 > var27.field2771 - var27.field2763) {
                              var27.field2863 = var27.field2771 - var27.field2763;
                           }

                           if(var27.field2863 < 0) {
                              var27.field2863 = 0;
                           }

                           var27.field2770 = class36.field780[var5 + 1];
                           if(var27.field2770 > var27.field2772 - var27.field2764) {
                              var27.field2770 = var27.field2772 - var27.field2764;
                           }

                           if(var27.field2770 < 0) {
                              var27.field2770 = 0;
                           }

                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1101) {
                           --var5;
                           var27.field2773 = class36.field780[var5];
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1102) {
                           --var5;
                           var27.field2850 = class36.field780[var5] == 1;
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1103) {
                           --var5;
                           var27.field2830 = class36.field780[var5];
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1104) {
                           --var5;
                           var27.field2781 = class36.field780[var5];
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1105) {
                           --var5;
                           var27.field2783 = class36.field780[var5];
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1106) {
                           --var5;
                           var27.field2851 = class36.field780[var5];
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1107) {
                           --var5;
                           var27.field2853 = class36.field780[var5] == 1;
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1108) {
                           var27.field2791 = 1;
                           --var5;
                           var27.field2792 = class36.field780[var5];
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1109) {
                           var5 -= 6;
                           var27.field2797 = class36.field780[var5];
                           var27.field2798 = class36.field780[var5 + 1];
                           var27.field2839 = class36.field780[2 + var5];
                           var27.field2800 = class36.field780[var5 + 3];
                           var27.field2844 = class36.field780[4 + var5];
                           var27.field2802 = class36.field780[var5 + 5];
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1110) {
                           --var5;
                           var29 = class36.field780[var5];
                           if(var27.field2752 != var29) {
                              var27.field2752 = var29;
                              var27.field2870 = 0;
                              var27.field2855 = 0;
                              class4.method37(var27);
                           }
                           continue;
                        }

                        if(var37 == 1111) {
                           --var5;
                           var27.field2805 = class36.field780[var5] == 1;
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1112) {
                           --var6;
                           var17 = class36.field789[var6];
                           if(!var17.equals(var27.field2808)) {
                              var27.field2808 = var17;
                              class4.method37(var27);
                           }
                           continue;
                        }

                        if(var37 == 1113) {
                           --var5;
                           var27.field2838 = class36.field780[var5];
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1114) {
                           var5 -= 3;
                           var27.field2811 = class36.field780[var5];
                           var27.field2861 = class36.field780[1 + var5];
                           var27.field2813 = class36.field780[var5 + 2];
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1115) {
                           --var5;
                           var27.field2799 = class36.field780[var5] == 1;
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1116) {
                           --var5;
                           var27.field2787 = class36.field780[var5];
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1117) {
                           --var5;
                           var27.field2738 = class36.field780[var5];
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1118) {
                           --var5;
                           var27.field2789 = class36.field780[var5] == 1;
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1119) {
                           --var5;
                           var27.field2867 = class36.field780[var5] == 1;
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1120) {
                           var5 -= 2;
                           var27.field2771 = class36.field780[var5];
                           var27.field2772 = class36.field780[var5 + 1];
                           class4.method37(var27);
                           if(var28 != -1 && var27.field2833 == 0) {
                              class9.method121(class173.field2750[var28 >> 16], var27, false);
                           }
                           continue;
                        }

                        if(var37 == 1121) {
                           var29 = var27.field2748;
                           var26 = var27.field2749;
                           client.field331.method2781(126);
                           client.field331.method2695(var26);
                           client.field331.method2502(var29);
                           client.field451 = var27;
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1122) {
                           --var5;
                           var27.field2757 = class36.field780[var5];
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1123) {
                           --var5;
                           var27.field2755 = class36.field780[var5];
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1124) {
                           --var5;
                           var27.field2780 = class36.field780[var5];
                           class4.method37(var27);
                           continue;
                        }

                        if(var37 == 1125) {
                           --var5;
                           var29 = class36.field780[var5];
                           class82 var18 = (class82)class157.method3181(class169.method3375(), var29);
                           if(var18 != null) {
                              var27.field2778 = var18;
                              class4.method37(var27);
                           }
                           continue;
                        }
                     }
                  }
               }

               if(var37 < 5400) {
                  if(var37 == 5306) {
                     int[] var97 = class36.field780;
                     var28 = var5++;
                     var29 = client.field501?2:1;
                     var97[var28] = var29;
                     continue;
                  }

                  if(var37 == 5307) {
                     --var5;
                     var15 = class36.field780[var5];
                     if(var15 == 1 || var15 == 2) {
                        class72.method1602(var15);
                     }
                     continue;
                  }

                  if(var37 == 5308) {
                     class36.field780[var5++] = class162.field2637.field131;
                     continue;
                  }

                  if(var37 == 5309) {
                     --var5;
                     var15 = class36.field780[var5];
                     if(var15 == 1 || var15 == 2) {
                        class162.field2637.field131 = var15;
                        class8.method96();
                     }
                     continue;
                  }
               }

               if(var37 < 5600) {
                  if(var37 == 5504) {
                     var5 -= 2;
                     var15 = class36.field780[var5];
                     var28 = class36.field780[1 + var5];
                     if(!client.field535) {
                        client.field403 = var15;
                        client.field322 = var28;
                     }
                     continue;
                  }

                  if(var37 == 5505) {
                     class36.field780[var5++] = client.field403;
                     continue;
                  }

                  if(var37 == 5506) {
                     class36.field780[var5++] = client.field322;
                     continue;
                  }

                  if(var37 == 5530) {
                     --var5;
                     var15 = class36.field780[var5];
                     if(var15 < 0) {
                        var15 = 0;
                     }

                     client.field379 = var15;
                     continue;
                  }

                  if(var37 == 5531) {
                     class36.field780[var5++] = client.field379;
                     continue;
                  }
               }

               if(var37 < 5700 && var37 == 5630) {
                  client.field399 = 250;
               } else {
                  if(var37 < 6300) {
                     if(var37 == 6200) {
                        var5 -= 2;
                        client.field541 = (short)class36.field780[var5];
                        if(client.field541 <= 0) {
                           client.field541 = 256;
                        }

                        client.field542 = (short)class36.field780[var5 + 1];
                        if(client.field542 <= 0) {
                           client.field542 = 205;
                        }
                        continue;
                     }

                     if(var37 == 6201) {
                        var5 -= 2;
                        client.field543 = (short)class36.field780[var5];
                        if(client.field543 <= 0) {
                           client.field543 = 256;
                        }

                        client.field537 = (short)class36.field780[var5 + 1];
                        if(client.field537 <= 0) {
                           client.field537 = 320;
                        }
                        continue;
                     }

                     if(var37 == 6202) {
                        var5 -= 4;
                        client.field547 = (short)class36.field780[var5];
                        if(client.field547 <= 0) {
                           client.field547 = 1;
                        }

                        client.field546 = (short)class36.field780[1 + var5];
                        if(client.field546 <= 0) {
                           client.field546 = 32767;
                        } else if(client.field546 < client.field547) {
                           client.field546 = client.field547;
                        }

                        client.field328 = (short)class36.field780[var5 + 2];
                        if(client.field328 <= 0) {
                           client.field328 = 1;
                        }

                        client.field516 = (short)class36.field780[var5 + 3];
                        if(client.field516 <= 0) {
                           client.field516 = 32767;
                        } else if(client.field516 < client.field328) {
                           client.field516 = client.field328;
                        }
                        continue;
                     }

                     if(var37 == 6203) {
                        if(client.field459 != null) {
                           class106.method2383(0, 0, client.field459.field2763, client.field459.field2764, false);
                           class36.field780[var5++] = client.field551;
                           class36.field780[var5++] = client.field552;
                        } else {
                           class36.field780[var5++] = -1;
                           class36.field780[var5++] = -1;
                        }
                        continue;
                     }

                     if(var37 == 6204) {
                        class36.field780[var5++] = client.field543;
                        class36.field780[var5++] = client.field537;
                        continue;
                     }

                     if(var37 == 6205) {
                        class36.field780[var5++] = client.field541;
                        class36.field780[var5++] = client.field542;
                        continue;
                     }
                  }

                  if(var37 < 6600) {
                     if(var37 == 6500) {
                        class36.field780[var5++] = class85.method1923()?1:0;
                        continue;
                     }

                     class25 var96;
                     if(var37 == 6501) {
                        class25.field633 = 0;
                        var96 = class99.method2202();
                        if(null != var96) {
                           class36.field780[var5++] = var96.field636;
                           class36.field780[var5++] = var96.field640;
                           class36.field789[var6++] = var96.field646;
                           class36.field780[var5++] = var96.field641;
                           class36.field780[var5++] = var96.field638;
                           class36.field789[var6++] = var96.field637;
                        } else {
                           class36.field780[var5++] = -1;
                           class36.field780[var5++] = 0;
                           class36.field789[var6++] = "";
                           class36.field780[var5++] = 0;
                           class36.field780[var5++] = 0;
                           class36.field789[var6++] = "";
                        }
                        continue;
                     }

                     if(var37 == 6502) {
                        var96 = class99.method2202();
                        if(null != var96) {
                           class36.field780[var5++] = var96.field636;
                           class36.field780[var5++] = var96.field640;
                           class36.field789[var6++] = var96.field646;
                           class36.field780[var5++] = var96.field641;
                           class36.field780[var5++] = var96.field638;
                           class36.field789[var6++] = var96.field637;
                        } else {
                           class36.field780[var5++] = -1;
                           class36.field780[var5++] = 0;
                           class36.field789[var6++] = "";
                           class36.field780[var5++] = 0;
                           class36.field780[var5++] = 0;
                           class36.field789[var6++] = "";
                        }
                        continue;
                     }

                     class25 var67;
                     if(var37 == 6506) {
                        --var5;
                        var15 = class36.field780[var5];
                        var67 = null;

                        for(var29 = 0; var29 < class25.field627; ++var29) {
                           if(var15 == class25.field635[var29].field636) {
                              var67 = class25.field635[var29];
                              break;
                           }
                        }

                        if(null != var67) {
                           class36.field780[var5++] = var67.field636;
                           class36.field780[var5++] = var67.field640;
                           class36.field789[var6++] = var67.field646;
                           class36.field780[var5++] = var67.field641;
                           class36.field780[var5++] = var67.field638;
                           class36.field789[var6++] = var67.field637;
                        } else {
                           class36.field780[var5++] = -1;
                           class36.field780[var5++] = 0;
                           class36.field789[var6++] = "";
                           class36.field780[var5++] = 0;
                           class36.field780[var5++] = 0;
                           class36.field789[var6++] = "";
                        }
                        continue;
                     }

                     if(var37 == 6507) {
                        var5 -= 4;
                        var15 = class36.field780[var5];
                        var70 = class36.field780[1 + var5] == 1;
                        var29 = class36.field780[2 + var5];
                        var69 = class36.field780[3 + var5] == 1;
                        class75.method1658(var15, var70, var29, var69);
                        continue;
                     }

                     if(var37 == 6511) {
                        --var5;
                        var15 = class36.field780[var5];
                        if(var15 >= 0 && var15 < class25.field627) {
                           var67 = class25.field635[var15];
                           class36.field780[var5++] = var67.field636;
                           class36.field780[var5++] = var67.field640;
                           class36.field789[var6++] = var67.field646;
                           class36.field780[var5++] = var67.field641;
                           class36.field780[var5++] = var67.field638;
                           class36.field789[var6++] = var67.field637;
                           continue;
                        }

                        class36.field780[var5++] = -1;
                        class36.field780[var5++] = 0;
                        class36.field789[var6++] = "";
                        class36.field780[var5++] = 0;
                        class36.field780[var5++] = 0;
                        class36.field789[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var36) {
            StringBuilder var35 = new StringBuilder(30);
            var35.append("").append(var4.field3113).append(" ");

            for(var13 = class36.field774 - 1; var13 >= 0; --var13) {
               var35.append("").append(class36.field783[var13].field213.field3113).append(" ");
            }

            var35.append("").append(var10);
            class7.method94(var35.toString(), var36);
         }
      }
   }
}
