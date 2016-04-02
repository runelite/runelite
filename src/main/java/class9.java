import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class9 {
   @ObfuscatedName("ac")
   static String field153;
   @ObfuscatedName("p")
   static final BigInteger field154 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("h")
   static final BigInteger field161 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("di")
   static int[] field163;

   @ObfuscatedName("e")
   public static void method124(class167 var0) {
      class52.field1134 = var0;
      class226.field3210 = class52.field1134.method3307(16);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass37;IIIIII)V",
      garbageValue = "1519013745"
   )
   static final void method125(class37 var0, int var1, int var2, int var3) {
      if(null != var0 && var0.vmethod744()) {
         if(var0 instanceof class34) {
            class39 var4 = ((class34)var0).field755;
            if(var4.field888 != null) {
               var4 = var4.method762();
            }

            if(var4 == null) {
               return;
            }
         }

         int var8 = class32.field731;
         int[] var5 = class32.field732;
         int var6;
         if(var1 < var8) {
            var6 = 30;
            class2 var7 = (class2)var0;
            if(var7.field54) {
               return;
            }

            if(-1 != var7.field34 || var7.field37 != -1) {
               class8.method118(var0, var0.field808 + 15);
               if(client.field300 > -1) {
                  if(var7.field34 != -1) {
                     class74.field1340[var7.field34].method1709(client.field300 + var2 - 12, var3 + client.field386 - var6);
                     var6 += 25;
                  }

                  if(-1 != var7.field37) {
                     class26.field630[var7.field37].method1709(client.field300 + var2 - 12, client.field386 + var3 - var6);
                     var6 += 25;
                  }
               }
            }

            if(var1 >= 0 && client.field297 == 10 && client.field299 == var5[var1]) {
               class8.method118(var0, var0.field808 + 15);
               if(client.field300 > -1) {
                  class123.field2014[1].method1709(client.field300 + var2 - 12, var3 + client.field386 - var6);
               }
            }
         } else {
            class39 var10 = ((class34)var0).field755;
            if(null != var10.field888) {
               var10 = var10.method762();
            }

            if(var10.field886 >= 0 && var10.field886 < class26.field630.length) {
               class8.method118(var0, 15 + var0.field808);
               if(client.field300 > -1) {
                  class26.field630[var10.field886].method1709(var2 + client.field300 - 12, var3 + client.field386 - 30);
               }
            }

            if(1 == client.field297 && client.field318[var1 - var8] == client.field298 && client.field289 % 20 < 10) {
               class8.method118(var0, var0.field808 + 15);
               if(client.field300 > -1) {
                  class123.field2014[0].method1709(client.field300 + var2 - 12, var3 + client.field386 - 28);
               }
            }
         }

         if(null != var0.field801 && (var1 >= var8 || !var0.field803 && (client.field518 == 4 || !var0.field802 && (client.field518 == 0 || client.field518 == 3 || client.field518 == 1 && method128(((class2)var0).field45, false))))) {
            class8.method118(var0, var0.field808);
            if(client.field300 > -1 && client.field373 < client.field537) {
               client.field378[client.field373] = class124.field2022.method4074(var0.field801) / 2;
               client.field405[client.field373] = class124.field2022.field3188;
               client.field356[client.field373] = client.field300;
               client.field376[client.field373] = client.field386;
               client.field395[client.field373] = var0.field805;
               client.field380[client.field373] = var0.field806;
               client.field381[client.field373] = var0.field837;
               client.field344[client.field373] = var0.field801;
               ++client.field373;
            }
         }

         if(var0.field810 > client.field289) {
            class8.method118(var0, var0.field808 + 15);
            if(client.field300 > -1) {
               if(var1 < var8) {
                  var6 = 30;
               } else {
                  class39 var9 = ((class34)var0).field755;
                  var6 = var9.field892;
               }

               int var11 = var6 * var0.field836 / var0.field812;
               if(var11 > var6) {
                  var11 = var6;
               } else if(0 == var11 && var0.field836 > 0) {
                  var11 = 1;
               }

               class79.method1809(var2 + client.field300 - var6 / 2, var3 + client.field386 - 3, var11, 5, '\uff00');
               class79.method1809(var2 + client.field300 - var6 / 2 + var11, var3 + client.field386 - 3, var6 - var11, 5, 16711680);
            }
         }

         for(var6 = 0; var6 < 4; ++var6) {
            if(var0.field809[var6] > client.field289) {
               class8.method118(var0, var0.field808 / 2);
               if(client.field300 > -1) {
                  if(var6 == 1) {
                     client.field386 -= 20;
                  }

                  if(var6 == 2) {
                     client.field300 -= 15;
                     client.field386 -= 10;
                  }

                  if(var6 == 3) {
                     client.field300 += 15;
                     client.field386 -= 10;
                  }

                  class121.field1997[var0.field818[var6]].method1709(client.field300 + var2 - 12, var3 + client.field386 - 12);
                  class34.field753.method4010(Integer.toString(var0.field807[var6]), client.field300 + var2 - 1, 3 + var3 + client.field386, 16777215, 0);
               }
            }
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1636268841"
   )
   static void method127(int var0) {
      if(var0 == -3) {
         class121.method2750("Connection timed out.", "Please try using a different world.", "");
      } else if(-2 == var0) {
         class121.method2750("", "Error connecting to server.", "");
      } else if(-1 == var0) {
         class121.method2750("No response from server.", "Please try using a different world.", "");
      } else if(3 == var0) {
         class31.field702 = 3;
      } else if(var0 == 4) {
         class121.method2750("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class121.method2750("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class121.method2750("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class121.method2750("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class121.method2750("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class121.method2750("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class121.method2750("Unable to connect.", "Bad session id.", "");
      } else if(11 == var0) {
         class121.method2750("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(12 == var0) {
         class121.method2750("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class121.method2750("Could not complete login.", "Please try using a different world.", "");
      } else if(14 == var0) {
         class121.method2750("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class121.method2750("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class121.method2750("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class121.method2750("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class121.method2750("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class121.method2750("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class121.method2750("Malformed login packet.", "Please try again.", "");
      } else if(23 == var0) {
         class121.method2750("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class121.method2750("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class121.method2750("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(26 == var0) {
         class121.method2750("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(27 == var0) {
         class121.method2750("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class121.method2750("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class121.method2750("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(37 == var0) {
         class121.method2750("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(38 == var0) {
         class121.method2750("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(55 == var0) {
         class121.method2750("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(56 == var0) {
            class121.method2750("Enter the 6-digit code generated by your", "authenticator app.", "");
            class141.method2971(11);
            return;
         }

         if(57 == var0) {
            class121.method2750("The code you entered was incorrect.", "Please try again.", "");
            class141.method2971(11);
            return;
         }

         class121.method2750("Unexpected server response", "Please try using a different world.", "");
      }

      class141.method2971(10);
   }

   @ObfuscatedName("dz")
   static boolean method128(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class122.method2773(var0, client.field283);

         for(int var3 = 0; var3 < client.field545; ++var3) {
            if(var2.equalsIgnoreCase(class122.method2773(client.field547[var3].field247, client.field283)) && (!var1 || client.field547[var3].field242 != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class122.method2773(class20.field572.field45, client.field283))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("e")
   public static void method129(class167 var0, class167 var1, boolean var2) {
      class40.field899 = var0;
      class40.field901 = var1;
      class40.field939 = var2;
   }

   @ObfuscatedName("db")
   static final String[] method130(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && null != var0[var2]) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("y")
   static void method131() {
      if(class169.method3352()) {
         class31.field721 = true;
      }

   }

   @ObfuscatedName("f")
   static char method132(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   @ObfuscatedName("dy")
   static void method133(class173 var0) {
      if(var0.field2861 == client.field379) {
         client.field483[var0.field2756] = true;
      }

   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1643600633"
   )
   static final void method134(int var0, int var1) {
      if(class113.method2462(var0)) {
         class6.method103(class173.field2837[var0], var1);
      }
   }
}
