import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("Tile")
public final class class101 extends class208 {
   @ObfuscatedName("k")
   int[] field1743 = new int[5];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1123069595
   )
   @Export("x")
   int field1744;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2069852833
   )
   @Export("y")
   int field1745;
   @ObfuscatedName("s")
   @Export("decorativeObject")
   class94 field1746;
   @ObfuscatedName("z")
   class89 field1747;
   @ObfuscatedName("r")
   class97 field1748;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 504470147
   )
   int field1749;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1961967275
   )
   int field1750 = 0;
   @ObfuscatedName("d")
   @Export("groundObject")
   class93 field1751;
   @ObfuscatedName("l")
   @Export("itemLayer")
   class99 field1752;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 38848541
   )
   int field1753;
   @ObfuscatedName("p")
   @Export("objects")
   class98[] field1754 = new class98[5];
   @ObfuscatedName("ac")
   static boolean field1755;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1744316835
   )
   int field1756;
   @ObfuscatedName("j")
   boolean field1757;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 145395691
   )
   @Export("plane")
   int field1758;
   @ObfuscatedName("a")
   boolean field1759;
   @ObfuscatedName("f")
   @Export("wallObject")
   class87 field1760;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2142852393
   )
   int field1761;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2011278001
   )
   int field1762;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1298858667
   )
   int field1763;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -487991673
   )
   int field1764;
   @ObfuscatedName("v")
   class101 field1765;
   @ObfuscatedName("mp")
   static class78 field1767;
   @ObfuscatedName("u")
   boolean field1768;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1804460182"
   )
   public static boolean method2232() {
      long var0 = class124.method2746();
      int var2 = (int)(var0 - class171.field2742);
      class171.field2742 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class171.field2746 += var2;
      if(class171.field2751 == 0 && class171.field2744 == 0 && class171.field2749 == 0 && class171.field2750 == 0) {
         return true;
      } else if(null == class43.field1023) {
         return false;
      } else {
         try {
            if(class171.field2746 > 30000) {
               throw new IOException();
            } else {
               class172 var3;
               class119 var4;
               while(class171.field2744 < 20 && class171.field2750 > 0) {
                  var3 = (class172)class171.field2753.method3751();
                  var4 = new class119(4);
                  var4.method2453(1);
                  var4.method2455((int)var3.field3125);
                  class43.field1023.method2964(var4.field2001, 0, 4);
                  class171.field2745.method3749(var3, var3.field3125);
                  --class171.field2750;
                  ++class171.field2744;
               }

               while(class171.field2751 < 20 && class171.field2749 > 0) {
                  var3 = (class172)class171.field2747.method3834();
                  var4 = new class119(4);
                  var4.method2453(0);
                  var4.method2455((int)var3.field3125);
                  class43.field1023.method2964(var4.field2001, 0, 4);
                  var3.method3844();
                  class171.field2754.method3749(var3, var3.field3125);
                  --class171.field2749;
                  ++class171.field2751;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class43.field1023.method2980();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class171.field2746 = 0;
                  byte var5 = 0;
                  if(null == class171.field2759) {
                     var5 = 8;
                  } else if(class171.field2743 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class171.field2741.field2000;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class43.field1023.method2963(class171.field2741.field2001, class171.field2741.field2000, var6);
                     if(class171.field2757 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class171.field2741.field2001[var7 + class171.field2741.field2000] ^= class171.field2757;
                        }
                     }

                     class171.field2741.field2000 += var6;
                     if(class171.field2741.field2000 < var5) {
                        break;
                     }

                     if(class171.field2759 == null) {
                        class171.field2741.field2000 = 0;
                        var7 = class171.field2741.method2494();
                        var8 = class171.field2741.method2470();
                        int var9 = class171.field2741.method2494();
                        var10 = class171.field2741.method2505();
                        long var11 = (long)((var7 << 16) + var8);
                        class172 var13 = (class172)class171.field2745.method3748(var11);
                        class45.field1048 = true;
                        if(null == var13) {
                           var13 = (class172)class171.field2754.method3748(var11);
                           class45.field1048 = false;
                        }

                        if(null == var13) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class171.field2759 = var13;
                        class141.field2201 = new class119(var10 + var14 + class171.field2759.field2763);
                        class141.field2201.method2453(var9);
                        class141.field2201.method2456(var10);
                        class171.field2743 = 8;
                        class171.field2741.field2000 = 0;
                     } else if(class171.field2743 == 0) {
                        if(class171.field2741.field2001[0] == -1) {
                           class171.field2743 = 1;
                           class171.field2741.field2000 = 0;
                        } else {
                           class171.field2759 = null;
                        }
                     }
                  } else {
                     var6 = class141.field2201.field2001.length - class171.field2759.field2763;
                     var7 = 512 - class171.field2743;
                     if(var7 > var6 - class141.field2201.field2000) {
                        var7 = var6 - class141.field2201.field2000;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class43.field1023.method2963(class141.field2201.field2001, class141.field2201.field2000, var7);
                     if(class171.field2757 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class141.field2201.field2001[var8 + class141.field2201.field2000] ^= class171.field2757;
                        }
                     }

                     class141.field2201.field2000 += var7;
                     class171.field2743 += var7;
                     if(class141.field2201.field2000 == var6) {
                        if(16711935L == class171.field2759.field3125) {
                           class189.field3063 = class141.field2201;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class168 var17 = class171.field2756[var8];
                              if(var17 != null) {
                                 class189.field3063.field2000 = var8 * 8 + 5;
                                 var10 = class189.field3063.method2505();
                                 int var21 = class189.field3063.method2505();
                                 var17.method3308(var10, var21);
                              }
                           }
                        } else {
                           class171.field2755.reset();
                           class171.field2755.update(class141.field2201.field2001, 0, var6);
                           var8 = (int)class171.field2755.getValue();
                           if(class171.field2759.field2764 != var8) {
                              try {
                                 class43.field1023.method2960();
                              } catch (Exception var19) {
                                 ;
                              }

                              ++class171.field2758;
                              class43.field1023 = null;
                              class171.field2757 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class171.field2758 = 0;
                           class171.field2752 = 0;
                           class171.field2759.field2762.method3309((int)(class171.field2759.field3125 & 65535L), class141.field2201.field2001, 16711680L == (class171.field2759.field3125 & 16711680L), class45.field1048);
                        }

                        class171.field2759.method3870();
                        if(class45.field1048) {
                           --class171.field2744;
                        } else {
                           --class171.field2751;
                        }

                        class171.field2743 = 0;
                        class171.field2759 = null;
                        class141.field2201 = null;
                     } else {
                        if(class171.field2743 != 512) {
                           break;
                        }

                        class171.field2743 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var20) {
            try {
               class43.field1023.method2960();
            } catch (Exception var18) {
               ;
            }

            ++class171.field2752;
            class43.field1023 = null;
            return false;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1608087971"
   )
   static void method2233(int var0) {
      if(var0 == -3) {
         class50.method987("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class50.method987("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class50.method987("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class31.field717 = 3;
      } else if(var0 == 4) {
         class50.method987("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class50.method987("Your account is already logged in.", "Try again in 60 secs...", "");
      } else if(var0 == 6) {
         class50.method987("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class50.method987("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class50.method987("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class50.method987("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class50.method987("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class50.method987("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class50.method987("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class50.method987("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class50.method987("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class50.method987("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class50.method987("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class50.method987("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class50.method987("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class50.method987("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class50.method987("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class50.method987("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class50.method987("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class50.method987("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class50.method987("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class50.method987("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class50.method987("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class50.method987("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class50.method987("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class50.method987("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class50.method987("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class50.method987("Enter the 6-digit code generated by your", "authenticator app.", "");
            class2.method14(11);
            return;
         }

         if(var0 == 57) {
            class50.method987("The code you entered was incorrect.", "Please try again.", "");
            class2.method14(11);
            return;
         }

         class50.method987("Unexpected server response", "Please try using a different world.", "");
      }

      class2.method14(10);
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(Lclass173;B)Z",
      garbageValue = "-91"
   )
   static final boolean method2234(class173 var0) {
      int var1 = var0.field2780;
      if(var1 == 205) {
         client.field335 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            client.field555.method3432(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            client.field555.method3449(var2, var3 == 1);
         }

         if(var1 == 324) {
            client.field555.method3452(false);
         }

         if(var1 == 325) {
            client.field555.method3452(true);
         }

         if(var1 == 326) {
            client.field325.method2733(161);
            client.field555.method3441(client.field325);
            return true;
         } else {
            return false;
         }
      }
   }

   class101(int var1, int var2, int var3) {
      this.field1756 = this.field1758 = var1;
      this.field1744 = var2;
      this.field1745 = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass167;IIIZI)V",
      garbageValue = "1687225444"
   )
   public static void method2235(class167 var0, int var1, int var2, int var3, boolean var4) {
      class183.field2981 = 1;
      class24.field614 = var0;
      class142.field2204 = var1;
      class183.field2977 = var2;
      class151.field2286 = var3;
      class29.field694 = var4;
      class183.field2980 = 10000;
   }
}
