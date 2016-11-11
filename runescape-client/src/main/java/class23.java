import java.io.IOException;
import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("b")
public class class23 extends CacheableNode {
   @ObfuscatedName("h")
   int[] field615;
   @ObfuscatedName("e")
   int[] field617;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -694797093
   )
   int field618;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -262826665
   )
   int field619;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 555088155
   )
   int field620;
   @ObfuscatedName("i")
   static NodeCache field621 = new NodeCache(128);
   @ObfuscatedName("g")
   String[] field622;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1323719395
   )
   int field623;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lclass8;",
      garbageValue = "-1848902403"
   )
   static class8 method561() {
      FileOnDisk var0 = null;
      class8 var1 = new class8();

      try {
         var0 = GameEngine.method3132("", class114.field2004.field2341, false);
         byte[] var2 = new byte[(int)var0.method4160()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.method4157(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new class8(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4156();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[II)V",
      garbageValue = "1657962965"
   )
   static void method562(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var1 + var2) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method593()?1:0;
                     var12 = var8.method593()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method593()?1:0;
                     var12 = var8.method593()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method562(var0, var1, var6, var3, var4);
         method562(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2033144169"
   )
   static final void method563() {
      if(class173.plane != Client.field472) {
         Client.field472 = class173.plane;
         int var0 = class173.plane;
         int[] var1 = class178.field2953.image;
         int var2 = var1.length;

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            var1[var3] = 0;
         }

         int var4;
         int var5;
         for(var3 = 1; var3 < 103; ++var3) {
            var4 = 24628 + 2048 * (103 - var3);

            for(var5 = 1; var5 < 103; ++var5) {
               if((class5.tileSettings[var0][var5][var3] & 24) == 0) {
                  class128.region.method1986(var1, var4, 512, var0, var5, var3);
               }

               if(var0 < 3 && (class5.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
                  class128.region.method1986(var1, var4, 512, 1 + var0, var5, var3);
               }

               var4 += 4;
            }
         }

         var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
         var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
         class178.field2953.method1812();

         int var6;
         for(var5 = 1; var5 < 103; ++var5) {
            for(var6 = 1; var6 < 103; ++var6) {
               if((class5.tileSettings[var0][var6][var5] & 24) == 0) {
                  NPC.method763(var0, var6, var5, var3, var4);
               }

               if(var0 < 3 && (class5.tileSettings[1 + var0][var6][var5] & 8) != 0) {
                  NPC.method763(1 + var0, var6, var5, var3, var4);
               }
            }
         }

         Client.field309 = 0;

         for(var5 = 0; var5 < 104; ++var5) {
            for(var6 = 0; var6 < 104; ++var6) {
               int var7 = class128.region.method2052(class173.plane, var5, var6);
               if(var7 != 0) {
                  var7 = var7 >> 14 & 32767;
                  int var8 = class9.getObjectDefinition(var7).field972;
                  if(var8 >= 0) {
                     int var9 = var5;
                     int var10 = var6;
                     if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                        int[][] var13 = Client.collisionMaps[class173.plane].flags;

                        for(int var14 = 0; var14 < 10; ++var14) {
                           int var15 = (int)(Math.random() * 4.0D);
                           if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                              --var9;
                           }

                           if(var15 == 1 && var9 < 103 && var9 < 3 + var5 && (var13[1 + var9][var10] & 19136896) == 0) {
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

                     Client.field533[Client.field309] = NPC.field804[var8];
                     Client.field508[Client.field309] = var9;
                     Client.field532[Client.field309] = var10;
                     ++Client.field309;
                  }
               }
            }
         }

         class220.bufferProvider.method1734();
      }

   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1495007231"
   )
   static void method564(String var0) {
      class4.field79 = var0;

      try {
         String var1 = class168.field2706.getParameter(class193.field3120.field3125);
         String var2 = class168.field2706.getParameter(class193.field3123.field3125);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         String var5;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            String var4 = var3 + "; Expires=";
            long var6 = class34.method738() + 94608000000L;
            class114.field2003.setTime(new Date(var6));
            int var8 = class114.field2003.get(7);
            int var9 = class114.field2003.get(5);
            int var10 = class114.field2003.get(2);
            int var11 = class114.field2003.get(1);
            int var12 = class114.field2003.get(11);
            int var13 = class114.field2003.get(12);
            int var14 = class114.field2003.get(13);
            var5 = class114.field2002[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + class114.field2006[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
            var3 = var4 + var5 + "; Max-Age=" + 94608000L;
         }

         Client var16 = class168.field2706;
         var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var16).eval(var5);
      } catch (Throwable var15) {
         ;
      }

   }
}
