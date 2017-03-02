import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public class class101 extends RuntimeException {
   @ObfuscatedName("gm")
   static Widget field1644;
   @ObfuscatedName("b")
   static Applet field1645;
   @ObfuscatedName("k")
   String field1646;
   @ObfuscatedName("h")
   Throwable field1647;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -458890397
   )
   static int field1648;
   @ObfuscatedName("l")
   public static String field1649;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1230634921
   )
   static int field1650;

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1403269607"
   )
   static String method2008(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field295 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field295 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field295 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field295 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field295 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(MessageNode.field226 != null) {
         var3 = "/p=" + MessageNode.field226;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field289 + "/a=" + class175.field2644 + var3 + "/";
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILRegion;[LCollisionData;I)V",
      garbageValue = "-1833382306"
   )
   static final void method2012(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method2991();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method2991();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < 8 + var5 && var15 >= var6 && var15 < 8 + var6) {
               ObjectComposition var21 = class196.getObjectDefinition(var11);
               int var24 = var16 & 7;
               int var25 = var15 & 7;
               int var27 = var21.sizeX;
               int var28 = var21.sizeY;
               int var29;
               if((var20 & 1) == 1) {
                  var29 = var27;
                  var27 = var28;
                  var28 = var29;
               }

               int var26 = var7 & 3;
               int var23;
               if(var26 == 0) {
                  var23 = var24;
               } else if(var26 == 1) {
                  var23 = var25;
               } else if(var26 == 2) {
                  var23 = 7 - var24 - (var27 - 1);
               } else {
                  var23 = 7 - var25 - (var28 - 1);
               }

               var29 = var23 + var2;
               int var30 = var3 + TextureProvider.method1513(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
               if(var29 > 0 && var30 > 0 && var29 < 103 && var30 < 103) {
                  int var31 = var1;
                  if((class10.tileSettings[1][var29][var30] & 2) == 2) {
                     var31 = var1 - 1;
                  }

                  CollisionData var32 = null;
                  if(var31 >= 0) {
                     var32 = var9[var31];
                  }

                  ItemLayer.method1517(var1, var29, var30, var11, var20 + var7 & 3, var19, var8, var32);
               }
            }
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "-1744694500"
   )
   public static int method2013(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "78"
   )
   static final void method2015(String var0, boolean var1) {
      if(var0 != null) {
         if((Client.ignoreCount < 100 || Client.field407 == 1) && Client.ignoreCount < 400) {
            String var2 = class9.method122(var0, Client.field286);
            if(null != var2) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var4 = Client.ignores[var3];
                  var5 = class9.method122(var4.name, Client.field286);
                  if(var5 != null && var5.equals(var2)) {
                     class140.sendGameMessage(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(null != var4.previousName) {
                     var6 = class9.method122(var4.previousName, Client.field286);
                     if(null != var6 && var6.equals(var2)) {
                        class140.sendGameMessage(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var7 = Client.friends[var3];
                  var5 = class9.method122(var7.name, Client.field286);
                  if(var5 != null && var5.equals(var2)) {
                     class140.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var7.previousName != null) {
                     var6 = class9.method122(var7.previousName, Client.field286);
                     if(null != var6 && var6.equals(var2)) {
                        class140.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class9.method122(class9.localPlayer.name, Client.field286).equals(var2)) {
                  class140.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  Client.field327.method3124(50);
                  Client.field327.method3010(class25.method615(var0));
                  Client.field327.method2893(var0);
               }
            }
         } else {
            class140.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }
}
