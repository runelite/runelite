import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("y")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("p")
   @Export("name")
   String name;
   @ObfuscatedName("ii")
   static Widget field201;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = 530140967
   )
   static int field202;
   @ObfuscatedName("g")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("cu")
   static Font field204;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
      garbageValue = "-16"
   )
   static boolean method191(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class114.field1792.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var13 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var13.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var8) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var7 = class114.field1793;
            Object[] var5 = new Object[]{(new URL(class114.field1793.getCodeBase(), var0)).toString()};
            Object var3 = JSObject.getWindow(var7).call(var2, var5);
            return var3 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class114.field1793.getAppletContext().showDocument(new URL(class114.field1793.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class100.method1942(class114.field1793, "loggedout");
         } catch (Throwable var12) {
            ;
         }

         try {
            class114.field1793.getAppletContext().showDocument(new URL(class114.field1793.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-7"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(null == class13.worldServersDownload) {
            class13.worldServersDownload = new class26(class45.field899, new URL(class13.field136));
         } else {
            byte[] var0 = class13.worldServersDownload.method578();
            if(null != var0) {
               Buffer var1 = new Buffer(var0);
               World.field668 = var1.readUnsignedShort();
               class5.worldList = new World[World.field668];

               World var3;
               for(int var2 = 0; var2 < World.field668; var3.index = var2++) {
                  var3 = class5.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.method2819();
                  var3.address = var1.method2846();
                  var3.activity = var1.method2846();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               class6.method94(class5.worldList, 0, class5.worldList.length - 1, World.field671, World.field670);
               class13.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class13.worldServersDownload = null;
      }

      return false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass159;II)V",
      garbageValue = "821864925"
   )
   static void method193(class159 var0, int var1) {
      boolean var2 = var0.method3061(1) == 1;
      if(var2) {
         class45.field906[++class45.field909 - 1] = var1;
      }

      int var3 = var0.method3061(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field262 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class45.field902[var1] = (class3.baseY + var4.pathY[0] >> 13) + (var4.field259 << 28) + (var4.pathX[0] + Projectile.baseX >> 13 << 14);
            if(var4.field620 != -1) {
               class45.field903[var1] = var4.field620;
            } else {
               class45.field903[var1] = var4.field643;
            }

            class45.field904[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method3061(1) != 0) {
               class104.method1989(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method3061(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field262 = true;
                  var4.field245 = var6;
                  var4.field265 = var7;
               } else {
                  var4.field262 = false;
                  var4.method247(var6, var7, class45.field910[var1]);
               }
            } else {
               var4.method224(var6, var7);
               var4.field262 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method3061(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field262 = true;
                  var4.field245 = var6;
                  var4.field265 = var7;
               } else {
                  var4.field262 = false;
                  var4.method247(var6, var7, class45.field910[var1]);
               }
            } else {
               var4.method224(var6, var7);
               var4.field262 = false;
            }

         } else {
            var5 = var0.method3061(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method3061(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field262 = true;
                     var4.field245 = var10;
                     var4.field265 = var11;
                  } else {
                     var4.field262 = false;
                     var4.method247(var10, var11, class45.field910[var1]);
                  }
               } else {
                  var4.method224(var10, var11);
                  var4.field262 = false;
               }

               var4.field259 = (byte)(var4.field259 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  WallObject.plane = var4.field259;
               }

            } else {
               var6 = var0.method3061(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (Projectile.baseX + var4.pathX[0] + var8 & 16383) - Projectile.baseX;
               var11 = (var4.pathY[0] + class3.baseY + var9 & 16383) - class3.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field262 = true;
                     var4.field245 = var10;
                     var4.field265 = var11;
                  } else {
                     var4.field262 = false;
                     var4.method247(var10, var11, class45.field910[var1]);
                  }
               } else {
                  var4.method224(var10, var11);
                  var4.field262 = false;
               }

               var4.field259 = (byte)(var7 + var4.field259 & 3);
               if(var1 == Client.localInteractingIndex) {
                  WallObject.plane = var4.field259;
               }

            }
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "710338457"
   )
   static void method194(GameEngine var0) {
      if(class115.field1813 == 1 || !class48.field937 && class115.field1813 == 4) {
         int var1 = class41.field818 + 280;
         if(class115.field1811 >= var1 && class115.field1811 <= 14 + var1 && class115.field1812 >= 4 && class115.field1812 <= 18) {
            class6.method88(0, 0);
            return;
         }

         if(class115.field1811 >= var1 + 15 && class115.field1811 <= 80 + var1 && class115.field1812 >= 4 && class115.field1812 <= 18) {
            class6.method88(0, 1);
            return;
         }

         int var2 = 390 + class41.field818;
         if(class115.field1811 >= var2 && class115.field1811 <= var2 + 14 && class115.field1812 >= 4 && class115.field1812 <= 18) {
            class6.method88(1, 0);
            return;
         }

         if(class115.field1811 >= var2 + 15 && class115.field1811 <= 80 + var2 && class115.field1812 >= 4 && class115.field1812 <= 18) {
            class6.method88(1, 1);
            return;
         }

         int var3 = 500 + class41.field818;
         if(class115.field1811 >= var3 && class115.field1811 <= var3 + 14 && class115.field1812 >= 4 && class115.field1812 <= 18) {
            class6.method88(2, 0);
            return;
         }

         if(class115.field1811 >= 15 + var3 && class115.field1811 <= var3 + 80 && class115.field1812 >= 4 && class115.field1812 <= 18) {
            class6.method88(2, 1);
            return;
         }

         int var4 = class41.field818 + 610;
         if(class115.field1811 >= var4 && class115.field1811 <= 14 + var4 && class115.field1812 >= 4 && class115.field1812 <= 18) {
            class6.method88(3, 0);
            return;
         }

         if(class115.field1811 >= var4 + 15 && class115.field1811 <= var4 + 80 && class115.field1812 >= 4 && class115.field1812 <= 18) {
            class6.method88(3, 1);
            return;
         }

         if(class115.field1811 >= class41.field818 + 708 && class115.field1812 >= 4 && class115.field1811 <= class41.field818 + 708 + 50 && class115.field1812 <= 20) {
            class41.worldSelectShown = false;
            class41.field821.method4142(class41.field818, 0);
            CombatInfo1.field658.method4142(class41.field818 + 382, 0);
            class41.field819.method4083(382 + class41.field818 - class41.field819.originalWidth / 2, 18);
            return;
         }

         if(class41.field852 != -1) {
            World var5 = class5.worldList[class41.field852];
            class137.method2487(var5);
            class41.worldSelectShown = false;
            class41.field821.method4142(class41.field818, 0);
            CombatInfo1.field658.method4142(382 + class41.field818, 0);
            class41.field819.method4083(382 + class41.field818 - class41.field819.originalWidth / 2, 18);
            return;
         }
      }

   }
}
