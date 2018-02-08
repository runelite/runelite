import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public final class class79 extends Node {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   static Deque field1233;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1947624773
   )
   int field1229;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -481082347
   )
   int field1221;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1576620727
   )
   int field1222;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -302589793
   )
   int field1235;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 185900527
   )
   int field1224;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -922039413
   )
   int field1225;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -453906209
   )
   int field1226;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1411471069
   )
   int field1227;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   class116 field1231;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1225302543
   )
   int field1230;
   @ObfuscatedName("o")
   int[] field1228;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -763899663
   )
   int field1232;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   class116 field1220;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   ObjectComposition field1234;

   static {
      field1233 = new Deque();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "10371234"
   )
   void method1760() {
      int var1 = this.field1227;
      ObjectComposition var2 = this.field1234.getImpostor();
      if(var2 != null) {
         this.field1227 = var2.ambientSoundId;
         this.field1226 = var2.int4 * 128;
         this.field1229 = var2.int5;
         this.field1230 = var2.int6;
         this.field1228 = var2.field3565;
      } else {
         this.field1227 = -1;
         this.field1226 = 0;
         this.field1229 = 0;
         this.field1230 = 0;
         this.field1228 = null;
      }

      if(var1 != this.field1227 && this.field1231 != null) {
         class33.field450.method2117(this.field1231);
         this.field1231 = null;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1929837062"
   )
   static void method1752() {
      class89.username = class89.username.trim();
      if(class89.username.length() == 0) {
         class47.method679("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(class167.method3392("services", false) + "m=accountappeal/login.ws");
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
                  long var24 = var7.readLong();
                  var1 = var24;
                  break;
               }

               var7.offset += var8;
               if(var7.offset >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var37) {
            var1 = 0L;
         }

         byte var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            String var38 = class89.username;
            Random var39 = new Random();
            Buffer var28 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var39.nextInt(), var39.nextInt(), (int)(var1 >> 32), (int)var1};
            var28.putByte(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var28.putInt(var39.nextInt());
            }

            var28.putInt(var10[0]);
            var28.putInt(var10[1]);
            var28.putLong(var1);
            var28.putLong(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var28.putInt(var39.nextInt());
            }

            var28.encryptRsa(class84.field1274, class84.field1275);
            var9.putByte(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.putInt(var39.nextInt());
            }

            var9.putLong(var39.nextLong());
            var9.method3496(var39.nextLong());
            if(Client.field1006 != null) {
               var9.putBytes(Client.field1006, 0, Client.field1006.length);
            } else {
               byte[] var12 = new byte[24];

               try {
                  class157.randomDat.seek(0L);
                  class157.randomDat.read(var12);

                  int var13;
                  for(var13 = 0; var13 < 24 && var12[var13] == 0; ++var13) {
                     ;
                  }

                  if(var13 >= 24) {
                     throw new IOException();
                  }
               } catch (Exception var36) {
                  for(int var14 = 0; var14 < 24; ++var14) {
                     var12[var14] = -1;
                  }
               }

               var9.putBytes(var12, 0, var12.length);
            }

            var9.putLong(var39.nextLong());
            var9.encryptRsa(class84.field1274, class84.field1275);
            var11 = FrameMap.getLength(var38);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var40 = new Buffer(var11);
            var40.putString(var38);
            var40.offset = var11;
            var40.encryptXtea2(var10);
            Buffer var29 = new Buffer(var28.offset + var9.offset + var40.offset + 5);
            var29.putByte(2);
            var29.putByte(var28.offset);
            var29.putBytes(var28.payload, 0, var28.offset);
            var29.putByte(var9.offset);
            var29.putBytes(var9.payload, 0, var9.offset);
            var29.putShort(var40.offset);
            var29.putBytes(var40.payload, 0, var40.offset);
            byte[] var15 = var29.payload;
            String var31 = Buffer.method3707(var15, 0, var15.length);
            String var16 = var31;

            byte var32;
            try {
               URL var17 = new URL(class167.method3392("services", false) + "m=accountappeal/login.ws");
               URLConnection var18 = var17.openConnection();
               var18.setDoInput(true);
               var18.setDoOutput(true);
               var18.setConnectTimeout(5000);
               OutputStreamWriter var19 = new OutputStreamWriter(var18.getOutputStream());
               var19.write("data2=" + Ignore.method5251(var16) + "&dest=" + Ignore.method5251("passwordchoice.ws"));
               var19.flush();
               InputStream var20 = var18.getInputStream();
               var29 = new Buffer(new byte[1000]);

               while(true) {
                  int var21 = var20.read(var29.payload, var29.offset, 1000 - var29.offset);
                  if(var21 == -1) {
                     var19.close();
                     var20.close();
                     String var33 = new String(var29.payload);
                     if(var33.startsWith("OFFLINE")) {
                        var32 = 4;
                     } else if(var33.startsWith("WRONG")) {
                        var32 = 7;
                     } else if(var33.startsWith("RELOAD")) {
                        var32 = 3;
                     } else if(var33.startsWith("Not permitted for social network accounts.")) {
                        var32 = 6;
                     } else {
                        var29.decryptXtea(var10);

                        while(var29.offset > 0 && var29.payload[var29.offset - 1] == 0) {
                           --var29.offset;
                        }

                        var33 = new String(var29.payload, 0, var29.offset);
                        boolean var22;
                        if(var33 == null) {
                           var22 = false;
                        } else {
                           label134: {
                              try {
                                 new URL(var33);
                              } catch (MalformedURLException var34) {
                                 var22 = false;
                                 break label134;
                              }

                              var22 = true;
                           }
                        }

                        if(var22) {
                           class233.method4474(var33, true, false);
                           var32 = 2;
                        } else {
                           var32 = 5;
                        }
                     }
                     break;
                  }

                  var29.offset += var21;
                  if(var29.offset >= 1000) {
                     var32 = 5;
                     break;
                  }
               }
            } catch (Throwable var35) {
               var35.printStackTrace();
               var32 = 5;
            }

            var0 = var32;
         }

         switch(var0) {
         case 2:
            class47.method679("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class89.loginIndex = 6;
            break;
         case 3:
            class47.method679("", "Error connecting to server.", "");
            break;
         case 4:
            class47.method679("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class47.method679("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class47.method679("", "Error connecting to server.", "");
            break;
         case 7:
            class47.method679("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILcf;ZI)I",
      garbageValue = "-974452885"
   )
   static int method1759(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(class35.friendManager.field1213 == 0) {
            class80.intStack[++class80.intStackSize - 1] = -2;
         } else if(class35.friendManager.field1213 == 1) {
            class80.intStack[++class80.intStackSize - 1] = -1;
         } else {
            class80.intStack[++class80.intStackSize - 1] = class35.friendManager.field1211.getCount();
         }

         return 1;
      } else {
         int var3;
         if(var0 == 3601) {
            var3 = class80.intStack[--class80.intStackSize];
            if(class35.friendManager.method1738() && var3 >= 0 && var3 < class35.friendManager.field1211.getCount()) {
               Friend var8 = (Friend)class35.friendManager.field1211.get(var3);
               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var8.method5137();
               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var8.method5145();
            } else {
               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var3 = class80.intStack[--class80.intStackSize];
            if(class35.friendManager.method1738() && var3 >= 0 && var3 < class35.friendManager.field1211.getCount()) {
               class80.intStack[++class80.intStackSize - 1] = ((Friend)class35.friendManager.field1211.get(var3)).world;
            } else {
               class80.intStack[++class80.intStackSize - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var3 = class80.intStack[--class80.intStackSize];
            if(class35.friendManager.method1738() && var3 >= 0 && var3 < class35.friendManager.field1211.getCount()) {
               class80.intStack[++class80.intStackSize - 1] = ((Friend)class35.friendManager.field1211.get(var3)).field3740;
            } else {
               class80.intStack[++class80.intStackSize - 1] = 0;
            }

            return 1;
         } else {
            String var5;
            if(var0 == 3604) {
               var5 = class80.scriptStringStack[--class294.scriptStringStackSize];
               int var6 = class80.intStack[--class80.intStackSize];
               class39.method523(var5, var6);
               return 1;
            } else if(var0 == 3605) {
               var5 = class80.scriptStringStack[--class294.scriptStringStackSize];
               class35.friendManager.method1690(var5);
               return 1;
            } else if(var0 == 3606) {
               var5 = class80.scriptStringStack[--class294.scriptStringStackSize];
               class35.friendManager.method1712(var5);
               return 1;
            } else if(var0 == 3607) {
               var5 = class80.scriptStringStack[--class294.scriptStringStackSize];
               class35.friendManager.method1749(var5);
               return 1;
            } else if(var0 == 3608) {
               var5 = class80.scriptStringStack[--class294.scriptStringStackSize];
               class35.friendManager.method1695(var5);
               return 1;
            } else if(var0 == 3609) {
               var5 = class80.scriptStringStack[--class294.scriptStringStackSize];
               var5 = AttackOption.method1886(var5);
               class80.intStack[++class80.intStackSize - 1] = class35.friendManager.isFriended(new Name(var5, class226.loginType), false)?1:0;
               return 1;
            } else if(var0 == 3611) {
               if(class22.clanMemberManager != null) {
                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = class22.clanMemberManager.field3731;
               } else {
                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3612) {
               if(class22.clanMemberManager != null) {
                  class80.intStack[++class80.intStackSize - 1] = class22.clanMemberManager.getCount();
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3613) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class22.clanMemberManager != null && var3 < class22.clanMemberManager.getCount()) {
                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = class22.clanMemberManager.get(var3).method5136().getName();
               } else {
                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3614) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class22.clanMemberManager != null && var3 < class22.clanMemberManager.getCount()) {
                  class80.intStack[++class80.intStackSize - 1] = ((ClanMember)class22.clanMemberManager.get(var3)).world;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3615) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class22.clanMemberManager != null && var3 < class22.clanMemberManager.getCount()) {
                  class80.intStack[++class80.intStackSize - 1] = ((ClanMember)class22.clanMemberManager.get(var3)).rank;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3616) {
               class80.intStack[++class80.intStackSize - 1] = class22.clanMemberManager != null?class22.clanMemberManager.field3737:0;
               return 1;
            } else if(var0 == 3617) {
               var5 = class80.scriptStringStack[--class294.scriptStringStackSize];
               if(class22.clanMemberManager != null) {
                  PacketNode var7 = Script.method2025(ClientPacket.field2326, Client.field937.field1454);
                  var7.packetBuffer.putByte(FrameMap.getLength(var5));
                  var7.packetBuffer.putString(var5);
                  Client.field937.method2044(var7);
               }

               return 1;
            } else if(var0 == 3618) {
               class80.intStack[++class80.intStackSize - 1] = class22.clanMemberManager != null?class22.clanMemberManager.field3733:0;
               return 1;
            } else if(var0 == 3619) {
               var5 = class80.scriptStringStack[--class294.scriptStringStackSize];
               class192.method3868(var5);
               return 1;
            } else if(var0 == 3620) {
               PacketNode var9 = Script.method2025(ClientPacket.field2334, Client.field937.field1454);
               var9.packetBuffer.putByte(0);
               Client.field937.method2044(var9);
               return 1;
            } else if(var0 == 3621) {
               if(!class35.friendManager.method1738()) {
                  class80.intStack[++class80.intStackSize - 1] = -1;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = class35.friendManager.field1212.getCount();
               }

               return 1;
            } else if(var0 == 3622) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class35.friendManager.method1738() && var3 >= 0 && var3 < class35.friendManager.field1212.getCount()) {
                  Ignore var4 = (Ignore)class35.friendManager.field1212.get(var3);
                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var4.method5137();
                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var4.method5145();
               } else {
                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3623) {
               var5 = class80.scriptStringStack[--class294.scriptStringStackSize];
               var5 = AttackOption.method1886(var5);
               class80.intStack[++class80.intStackSize - 1] = class35.friendManager.method1689(new Name(var5, class226.loginType))?1:0;
               return 1;
            } else if(var0 == 3624) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class22.clanMemberManager != null && var3 < class22.clanMemberManager.getCount() && class22.clanMemberManager.get(var3).method5136().equals(GroundObject.localPlayer.name)) {
                  class80.intStack[++class80.intStackSize - 1] = 1;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3625) {
               if(class22.clanMemberManager != null && class22.clanMemberManager.field3732 != null) {
                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = class22.clanMemberManager.field3732;
               } else {
                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3626) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class22.clanMemberManager != null && var3 < class22.clanMemberManager.getCount() && ((ClanMember)class22.clanMemberManager.get(var3)).method5119()) {
                  class80.intStack[++class80.intStackSize - 1] = 1;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 != 3627) {
               return 2;
            } else {
               var3 = class80.intStack[--class80.intStackSize];
               if(class22.clanMemberManager != null && var3 < class22.clanMemberManager.getCount() && ((ClanMember)class22.clanMemberManager.get(var3)).method5113()) {
                  class80.intStack[++class80.intStackSize - 1] = 1;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            }
         }
      }
   }
}
