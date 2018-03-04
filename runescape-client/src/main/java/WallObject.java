import java.awt.Component;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1287637753
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1862551457
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 352703533
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2114859813
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1116633389
   )
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 999851309
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1880960343
   )
   @Export("config")
   int config;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1561584338"
   )
   static void method3134(Component var0) {
      var0.addMouseListener(MouseInput.mouse);
      var0.addMouseMotionListener(MouseInput.mouse);
      var0.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "-1889089168"
   )
   public static File method3131(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class185.jagexClDat = new File(AttackOption.userHome, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      Buffer var8;
      File var23;
      if(class185.jagexClDat.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class185.jagexClDat, "rw", 10000L);

            int var9;
            for(var8 = new Buffer((int)var7.length()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.read(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.readUnsignedByte();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.readUnsignedByte();
            }

            if(var9 <= 2) {
               var4 = var8.getJagString();
               if(var10 == 1) {
                  var5 = var8.getJagString();
               }
            } else {
               var4 = var8.getCESU8();
               if(var10 == 1) {
                  var5 = var8.getCESU8();
               }
            }

            var7.close();
         } catch (IOException var21) {
            var21.printStackTrace();
         }

         if(var4 != null) {
            var23 = new File(var4);
            if(!var23.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var23 = new File(var4, "test.dat");
            if(!class27.method221(var23, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label139:
         for(int var15 = 0; var15 < class167.field2194.length; ++var15) {
            for(int var16 = 0; var16 < class167.cacheLocations.length; ++var16) {
               File var17 = new File(class167.cacheLocations[var16] + class167.field2194[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && class27.method221(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label139;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = AttackOption.userHome + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      File var22;
      if(var5 != null) {
         var22 = new File(var5);
         var23 = new File(var4);

         try {
            File[] var24 = var22.listFiles();
            File[] var18 = var24;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var23, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var20) {
            var20.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         var22 = new File(var4);
         var8 = null;

         try {
            FileOnDisk var25 = new FileOnDisk(class185.jagexClDat, "rw", 10000L);
            Buffer var26 = new Buffer(500);
            var26.putByte(3);
            var26.putByte(var8 != null?1:0);
            var26.putCESU8(var22.getPath());
            if(var8 != null) {
               var26.putCESU8("");
            }

            var25.write(var26.payload, 0, var26.offset);
            var25.close();
         } catch (IOException var19) {
            var19.printStackTrace();
         }
      }

      return new File(var4);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILir;B)I",
      garbageValue = "120"
   )
   public static int method3130(int var0, class245 var1) {
      return (var0 << 8) + var1.field2966;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljk;Ljk;III)Lkw;",
      garbageValue = "-1202148828"
   )
   public static Font method3133(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      return !AbstractByteBuffer.method3843(var0, var2, var3)?null:Friend.method5560(var1.getConfigData(var2, var3));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "-1990178827"
   )
   static int method3135(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class5.getWidget(class81.intStack[--class81.intStackSize]);
      } else {
         var3 = var2?class20.field338:class81.field1267;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class81.intStack[--class81.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.setAction(var4, class81.scriptStringStack[--UrlRequester.scriptStringStackSize]);
            return 1;
         } else {
            --UrlRequester.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class81.intStackSize -= 2;
         var4 = class81.intStack[class81.intStackSize];
         int var5 = class81.intStack[class81.intStackSize + 1];
         var3.dragParent = class197.getWidgetChild(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2903 = class81.intStack[--class81.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2827 = class81.intStack[--class81.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2833 = class81.intStack[--class81.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1403713491"
   )
   static void method3132(int var0) {
      if(var0 == -3) {
         KeyFocusListener.method770("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         KeyFocusListener.method770("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         KeyFocusListener.method770("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class90.loginIndex = 3;
      } else if(var0 == 4) {
         KeyFocusListener.method770("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         KeyFocusListener.method770("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         KeyFocusListener.method770("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         KeyFocusListener.method770("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         KeyFocusListener.method770("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         KeyFocusListener.method770("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         KeyFocusListener.method770("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         KeyFocusListener.method770("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         KeyFocusListener.method770("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         KeyFocusListener.method770("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         KeyFocusListener.method770("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         KeyFocusListener.method770("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         KeyFocusListener.method770("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         KeyFocusListener.method770("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         KeyFocusListener.method770("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         KeyFocusListener.method770("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         KeyFocusListener.method770("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         KeyFocusListener.method770("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         KeyFocusListener.method770("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         KeyFocusListener.method770("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         KeyFocusListener.method770("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         KeyFocusListener.method770("", "Service unavailable.", "");
      } else if(var0 == 31) {
         KeyFocusListener.method770("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         KeyFocusListener.method770("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         KeyFocusListener.method770("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         KeyFocusListener.method770("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         KeyFocusListener.method770("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            KeyFocusListener.method770("Enter the 6-digit code generated by your", "authenticator app.", "");
            Enum.setGameState(11);
            return;
         }

         if(var0 == 57) {
            KeyFocusListener.method770("The code you entered was incorrect.", "Please try again.", "");
            Enum.setGameState(11);
            return;
         }

         KeyFocusListener.method770("Unexpected server response", "Please try using a different world.", "");
      }

      Enum.setGameState(10);
   }
}
