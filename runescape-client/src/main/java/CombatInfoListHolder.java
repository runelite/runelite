import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.management.GarbageCollectorMXBean;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("ab")
   static int[] field1288;
   @ObfuscatedName("af")
   static GarbageCollectorMXBean field1280;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -1630149879
   )
   public static int field1289;
   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   static SpritePixels[] field1287;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;

   @ObfuscatedSignature(
      signature = "(Liz;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-2014908861"
   )
   void method1756(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method3741(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method3743()) {
         ++var6;
         if(var7.field1205 == var1) {
            var7.method1633(var1, var2, var3, var4);
            return;
         }

         if(var7.field1205 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method3740(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method3738(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method3741().unlink();
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Lcn;",
      garbageValue = "-31"
   )
   CombatInfo1 method1757(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method3741();
      if(var2 != null && var2.field1205 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method3743(); var3 != null && var3.field1205 <= var1; var3 = (CombatInfo1)this.combatInfo1.method3743()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3426 + var2.field1205 + var2.field1206 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "17"
   )
   boolean method1758() {
      return this.combatInfo1.method3744();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(class8.validInterfaces[var0]) {
         return true;
      } else if(!class46.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = class46.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            class8.validInterfaces[var0] = true;
            return true;
         } else {
            if(class243.widgets[var0] == null) {
               class243.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class243.widgets[var0][var2] == null) {
                  byte[] var3 = class46.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     class243.widgets[var0][var2] = new Widget();
                     class243.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class243.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        class243.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            class8.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1945552380"
   )
   public static void method1768() {
      Varbit.varbits.reset();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfv;IIIIIII)V",
      garbageValue = "-855133753"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class61.tileHeights[0][var2];
                  int var11 = var2 + var4 + 932731;
                  int var12 = var3 + var5 + 556238;
                  int var13 = class31.getSmoothNoise(45365 + var11, var12 + 91923, 4) - 128 + (class31.getSmoothNoise(var11 + 10294, 37821 + var12, 2) - 128 >> 1) + (class31.getSmoothNoise(var11, var12, 1) - 128 >> 2);
                  var13 = (int)((double)var13 * 0.3D) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = -var13 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.readUnsignedByte();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var14 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var14 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class285.field3790[var1][var2][var3] = var0.readByte();
               class61.field727[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class37.field490[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class61.field726[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2057179614"
   )
   static void method1762() {
      class91.username = class91.username.trim();
      if(class91.username.length() == 0) {
         class8.method43("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = FaceNormal.method2977();
         byte var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            String var4 = class91.username;
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

            var6.encryptRsa(class86.field1304, class86.field1299);
            var7.putByte(10);

            for(var9 = 0; var9 < 3; ++var9) {
               var7.putInt(var5.nextInt());
            }

            var7.putLong(var5.nextLong());
            var7.method3273(var5.nextLong());
            class214.method4045(var7);
            var7.putLong(var5.nextLong());
            var7.encryptRsa(class86.field1304, class86.field1299);
            var9 = Projectile.getLength(var4);
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
            byte[] var13 = var11.payload;
            int var15 = var13.length;
            StringBuilder var16 = new StringBuilder();

            int var19;
            for(int var17 = 0; var17 < var15 + 0; var17 += 3) {
               int var18 = var13[var17] & 255;
               var16.append(class276.field3731[var18 >>> 2]);
               if(var17 < var15 - 1) {
                  var19 = var13[var17 + 1] & 255;
                  var16.append(class276.field3731[(var18 & 3) << 4 | var19 >>> 4]);
                  if(var17 < var15 - 2) {
                     int var20 = var13[var17 + 2] & 255;
                     var16.append(class276.field3731[(var19 & 15) << 2 | var20 >>> 6]).append(class276.field3731[var20 & 63]);
                  } else {
                     var16.append(class276.field3731[(var19 & 15) << 2]).append("=");
                  }
               } else {
                  var16.append(class276.field3731[(var18 & 3) << 4]).append("==");
               }
            }

            String var14 = var16.toString();
            var14 = var14;

            byte var3;
            try {
               URL var21 = new URL(class24.method198("services", false) + "m=accountappeal/login.ws");
               URLConnection var26 = var21.openConnection();
               var26.setDoInput(true);
               var26.setDoOutput(true);
               var26.setConnectTimeout(5000);
               OutputStreamWriter var22 = new OutputStreamWriter(var26.getOutputStream());
               var22.write("data2=" + class2.method5(var14) + "&dest=" + class2.method5("passwordchoice.ws"));
               var22.flush();
               InputStream var23 = var26.getInputStream();
               var11 = new Buffer(new byte[1000]);

               while(true) {
                  var19 = var23.read(var11.payload, var11.offset, 1000 - var11.offset);
                  if(var19 == -1) {
                     var22.close();
                     var23.close();
                     String var24 = new String(var11.payload);
                     if(var24.startsWith("OFFLINE")) {
                        var3 = 4;
                     } else if(var24.startsWith("WRONG")) {
                        var3 = 7;
                     } else if(var24.startsWith("RELOAD")) {
                        var3 = 3;
                     } else if(var24.startsWith("Not permitted for social network accounts.")) {
                        var3 = 6;
                     } else {
                        var11.decryptXtea(var8);

                        while(var11.offset > 0 && var11.payload[var11.offset - 1] == 0) {
                           --var11.offset;
                        }

                        var24 = new String(var11.payload, 0, var11.offset);
                        if(class31.method306(var24)) {
                           class139.method2967(var24, true, false);
                           var3 = 2;
                        } else {
                           var3 = 5;
                        }
                     }
                     break;
                  }

                  var11.offset += var19;
                  if(var11.offset >= 1000) {
                     var3 = 5;
                     break;
                  }
               }
            } catch (Throwable var25) {
               var25.printStackTrace();
               var3 = 5;
            }

            var0 = var3;
         }

         switch(var0) {
         case 2:
            class8.method43("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class91.loginIndex = 6;
            break;
         case 3:
            class8.method43("", "Error connecting to server.", "");
            break;
         case 4:
            class8.method43("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class8.method43("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class8.method43("", "Error connecting to server.", "");
            break;
         case 7:
            class8.method43("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-784087520"
   )
   static final void method1760() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == Ignore.plane && Client.gameCycle <= var0.cycle) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method1839(var1.x, var1.y, class70.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = class48.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method1839(var3.x, var3.y, class70.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.method1836(Client.field925);
               class56.region.method2920(Ignore.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }
}
