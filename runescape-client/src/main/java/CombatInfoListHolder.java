import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("or")
   @ObfuscatedSignature(
      signature = "Lcr;"
   )
   static class100 field1364;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;

   @ObfuscatedSignature(
      signature = "(Liz;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-106"
   )
   void method1737(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method3664(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method3665()) {
         ++var6;
         if(var7.field1271 == var1) {
            var7.method1606(var1, var2, var3, var4);
            return;
         }

         if(var7.field1271 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method3661(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3662(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method3664().unlink();
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lbp;",
      garbageValue = "2055848259"
   )
   CombatInfo1 method1738(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method3664();
      if(var2 != null && var2.field1271 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method3665(); var3 != null && var3.field1271 <= var1; var3 = (CombatInfo1)this.combatInfo1.method3665()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3371 + var2.field1271 + var2.field1274 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1315138638"
   )
   boolean method1739() {
      return this.combatInfo1.method3667();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;B)Ljava/lang/String;",
      garbageValue = "42"
   )
   static String method1751(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class152) {
         class152 var2 = (class152)var0;
         var1 = var2.field2226 + " | ";
         var0 = var2.field2232;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(var7 == null) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2048703378"
   )
   public static void method1750() {
      class203.field2523.method3803();
      class203.field2521 = 1;
      class203.field2522 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "51"
   )
   static void method1746() {
      class90.username = class90.username.trim();
      if(class90.username.length() == 0) {
         class1.method3("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class28.method233();
         byte var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            String var4 = class90.username;
            Random var5 = new Random();
            Buffer var6 = new Buffer(128);
            Buffer var7 = new Buffer(128);
            int[] var8 = new int[]{var5.nextInt(), var5.nextInt(), (int)(var1 >> 32), (int)var1};
            var6.putByte(10);

            int var9;
            for(var9 = 0; var9 < 4; ++var9) {
               var6.putInt(var5.nextInt());
            }

            var6.putInt(var8[0]);
            var6.putInt(var8[1]);
            var6.putLong(var1);
            var6.putLong(0L);

            for(var9 = 0; var9 < 4; ++var9) {
               var6.putInt(var5.nextInt());
            }

            var6.encryptRsa(class85.field1376, class85.field1373);
            var7.putByte(10);

            for(var9 = 0; var9 < 3; ++var9) {
               var7.putInt(var5.nextInt());
            }

            var7.putLong(var5.nextLong());
            var7.method3224(var5.nextLong());
            if(Client.field981 != null) {
               var7.putBytes(Client.field981, 0, Client.field981.length);
            } else {
               byte[] var21 = DecorativeObject.method2965();
               var7.putBytes(var21, 0, var21.length);
            }

            var7.putLong(var5.nextLong());
            var7.encryptRsa(class85.field1376, class85.field1373);
            var9 = class162.getLength(var4);
            if(var9 % 8 != 0) {
               var9 += 8 - var9 % 8;
            }

            Buffer var10 = new Buffer(var9);
            var10.putString(var4);
            var10.offset = var9;
            var10.encryptXtea2(var8);
            Buffer var11 = new Buffer(var7.offset + var6.offset + var10.offset + 5);
            var11.putByte(2);
            var11.putByte(var6.offset);
            var11.putBytes(var6.payload, 0, var6.offset);
            var11.putByte(var7.offset);
            var11.putBytes(var7.payload, 0, var7.offset);
            var11.putShort(var10.offset);
            var11.putBytes(var10.payload, 0, var10.offset);
            String var12 = class86.method1772(var11.payload);

            byte var3;
            try {
               URL var13 = new URL(class44.method637("services", false) + "m=accountappeal/login.ws");
               URLConnection var14 = var13.openConnection();
               var14.setDoInput(true);
               var14.setDoOutput(true);
               var14.setConnectTimeout(5000);
               OutputStreamWriter var15 = new OutputStreamWriter(var14.getOutputStream());
               var15.write("data2=" + CollisionData.method3130(var12) + "&dest=" + CollisionData.method3130("passwordchoice.ws"));
               var15.flush();
               InputStream var16 = var14.getInputStream();
               var11 = new Buffer(new byte[1000]);

               while(true) {
                  int var17 = var16.read(var11.payload, var11.offset, 1000 - var11.offset);
                  if(var17 == -1) {
                     var15.close();
                     var16.close();
                     String var20 = new String(var11.payload);
                     if(var20.startsWith("OFFLINE")) {
                        var3 = 4;
                     } else if(var20.startsWith("WRONG")) {
                        var3 = 7;
                     } else if(var20.startsWith("RELOAD")) {
                        var3 = 3;
                     } else if(var20.startsWith("Not permitted for social network accounts.")) {
                        var3 = 6;
                     } else {
                        var11.decryptXtea(var8);

                        while(var11.offset > 0 && var11.payload[var11.offset - 1] == 0) {
                           --var11.offset;
                        }

                        var20 = new String(var11.payload, 0, var11.offset);
                        boolean var18;
                        if(var20 == null) {
                           var18 = false;
                        } else {
                           label102: {
                              try {
                                 new URL(var20);
                              } catch (MalformedURLException var22) {
                                 var18 = false;
                                 break label102;
                              }

                              var18 = true;
                           }
                        }

                        if(var18) {
                           ClanMember.method1197(var20, true, false);
                           var3 = 2;
                        } else {
                           var3 = 5;
                        }
                     }
                     break;
                  }

                  var11.offset += var17;
                  if(var11.offset >= 1000) {
                     var3 = 5;
                     break;
                  }
               }
            } catch (Throwable var23) {
               var23.printStackTrace();
               var3 = 5;
            }

            var0 = var3;
         }

         switch(var0) {
         case 2:
            class1.method3("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class90.loginIndex = 6;
            break;
         case 3:
            class1.method3("", "Error connecting to server.", "");
            break;
         case 4:
            class1.method3("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class1.method3("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class1.method3("", "Error connecting to server.", "");
            break;
         case 7:
            class1.method3("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "-582504208"
   )
   static boolean method1743(String var0, int var1) {
      return KeyFocusListener.method783(var0, var1, "openjs");
   }
}
