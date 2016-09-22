import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("v")
   boolean[] field267;
   @ObfuscatedName("r")
   boolean[] field268;
   @ObfuscatedName("z")
   int[] field270;
   @ObfuscatedName("n")
   boolean field271 = false;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -5099183624605776755L
   )
   long field272;
   @ObfuscatedName("s")
   static int[] field273;
   @ObfuscatedName("t")
   @Export("messages")
   String[] messages;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1294417638"
   )
   void method200() {
      if(this.field271 && this.field272 < class5.method63() - 60000L) {
         this.method207();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "11732"
   )
   int method202(int var1) {
      return this.field270[var1];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-766605535"
   )
   void method203(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field268[var1]) {
         this.field271 = true;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-35"
   )
   String method204(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "9"
   )
   void method205() {
      int var1;
      for(var1 = 0; var1 < this.field270.length; ++var1) {
         if(!this.field267[var1]) {
            this.field270[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field268[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-48"
   )
   void method206() {
      FileOnDisk var1 = this.method230(false);

      label203: {
         try {
            byte[] var2 = new byte[(int)var1.method4180()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4178(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var13 = new Buffer(var2);
            if(var13.payload.length - var13.offset < 1) {
               return;
            }

            int var14 = var13.method2528();
            if(var14 >= 0 && var14 <= 1) {
               int var15 = var13.method2717();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var15; ++var7) {
                  var8 = var13.method2717();
                  var9 = var13.method2533();
                  if(this.field267[var8]) {
                     this.field270[var8] = var9;
                  }
               }

               var7 = var13.method2717();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label203;
                  }

                  var9 = var13.method2717();
                  String var10 = var13.method2530();
                  if(this.field268[var9]) {
                     this.messages[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label203;
         } finally {
            try {
               var1.method4197();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field271 = false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-106"
   )
   void method207() {
      FileOnDisk var1 = this.method230(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field270.length; ++var4) {
            if(this.field267[var4] && this.field270[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field268[var5] && null != this.messages[var5]) {
               var2 += 2 + method229(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.method2513(1);
         var9.method2514(var3);

         int var6;
         for(var6 = 0; var6 < this.field270.length; ++var6) {
            if(this.field267[var6] && this.field270[var6] != -1) {
               var9.method2514(var6);
               var9.method2600(this.field270[var6]);
            }
         }

         var9.method2514(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field268[var6] && this.messages[var6] != null) {
               var9.method2514(var6);
               var9.method2519(this.messages[var6]);
            }
         }

         var1.method4175(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method4197();
         } catch (Exception var16) {
            ;
         }

      }

      this.field271 = false;
      this.field272 = class5.method63();
   }

   ChatMessages() {
      this.field270 = new int[class166.field2718.method3319(19)];
      this.messages = new String[class166.field2718.method3319(15)];
      this.field267 = new boolean[this.field270.length];

      int var1;
      byte[] var4;
      for(var1 = 0; var1 < this.field270.length; ++var1) {
         class47 var3 = (class47)class47.field1063.get((long)var1);
         class47 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            var4 = class47.field1064.method3309(19, var1);
            var3 = new class47();
            if(null != var4) {
               var3.method981(new Buffer(var4));
            }

            class47.field1063.put(var3, (long)var1);
            var2 = var3;
         }

         this.field267[var1] = var2.field1071;
      }

      this.field268 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class53 var6 = (class53)class53.field1164.get((long)var1);
         class53 var5;
         if(null != var6) {
            var5 = var6;
         } else {
            var4 = class53.field1155.method3309(15, var1);
            var6 = new class53();
            if(var4 != null) {
               var6.method1104(new Buffer(var4));
            }

            class53.field1164.put(var6, (long)var1);
            var5 = var6;
         }

         this.field268[var1] = var5.field1157;
      }

      for(var1 = 0; var1 < this.field270.length; ++var1) {
         this.field270[var1] = -1;
      }

      this.method206();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "577776030"
   )
   boolean method209() {
      return this.field271;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-1"
   )
   void method216(int var1, int var2) {
      this.field270[var1] = var2;
      if(this.field267[var1]) {
         this.field271 = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lclass51;",
      garbageValue = "1373992482"
   )
   public static class51 method224(int var0) {
      class51 var1 = (class51)class51.field1126.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class51.field1134.method3309(32, var0);
         var1 = new class51();
         if(null != var2) {
            var1.method1086(new Buffer(var2));
         }

         class51.field1126.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-2017911779"
   )
   public static int method229(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "962983965"
   )
   FileOnDisk method230(boolean var1) {
      return GameObject.method2224("2", Client.field548.field2347, var1);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIBB)V",
      garbageValue = "46"
   )
   static final void method236(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.method15();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.method15();
            class110 var9 = class138.method2909(var1, var2);
            CollisionData var10 = Client.collisionMaps[var0.field40];
            int[] var11 = Client.field561;
            int[] var12 = Client.field562;

            int var13;
            int var14;
            for(var13 = 0; var13 < 128; ++var13) {
               for(var14 = 0; var14 < 128; ++var14) {
                  class109.field1949[var13][var14] = 0;
                  class109.field1950[var13][var14] = 99999999;
               }
            }

            int var15;
            int var16;
            byte var18;
            int var19;
            int var20;
            int var22;
            int var24;
            int var25;
            int var26;
            boolean var33;
            int var35;
            int var36;
            int var38;
            if(var8 == 1) {
               var33 = class1.method12(var4, var5, var9, var10);
            } else if(var8 == 2) {
               var15 = var4;
               var16 = var5;
               byte var17 = 64;
               var18 = 64;
               var19 = var4 - var17;
               var20 = var5 - var18;
               class109.field1949[var17][var18] = 99;
               class109.field1950[var17][var18] = 0;
               byte var21 = 0;
               var22 = 0;
               class109.field1953[var21] = var4;
               var38 = var21 + 1;
               class109.field1954[var21] = var5;
               int[][] var32 = var10.flags;

               boolean var34;
               while(true) {
                  if(var38 == var22) {
                     class35.field800 = var15;
                     class109.field1948 = var16;
                     var34 = false;
                     break;
                  }

                  var15 = class109.field1953[var22];
                  var16 = class109.field1954[var22];
                  var22 = 1 + var22 & 4095;
                  var35 = var15 - var19;
                  var36 = var16 - var20;
                  var24 = var15 - var10.x;
                  var25 = var16 - var10.y;
                  if(var9.vmethod2408(2, var15, var16, var10)) {
                     class35.field800 = var15;
                     class109.field1948 = var16;
                     var34 = true;
                     break;
                  }

                  var26 = class109.field1950[var35][var36] + 1;
                  if(var35 > 0 && class109.field1949[var35 - 1][var36] == 0 && (var32[var24 - 1][var25] & 19136782) == 0 && (var32[var24 - 1][var25 + 1] & 19136824) == 0) {
                     class109.field1953[var38] = var15 - 1;
                     class109.field1954[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class109.field1949[var35 - 1][var36] = 2;
                     class109.field1950[var35 - 1][var36] = var26;
                  }

                  if(var35 < 126 && class109.field1949[1 + var35][var36] == 0 && (var32[2 + var24][var25] & 19136899) == 0 && (var32[var24 + 2][1 + var25] & 19136992) == 0) {
                     class109.field1953[var38] = var15 + 1;
                     class109.field1954[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class109.field1949[1 + var35][var36] = 8;
                     class109.field1950[1 + var35][var36] = var26;
                  }

                  if(var36 > 0 && class109.field1949[var35][var36 - 1] == 0 && (var32[var24][var25 - 1] & 19136782) == 0 && (var32[var24 + 1][var25 - 1] & 19136899) == 0) {
                     class109.field1953[var38] = var15;
                     class109.field1954[var38] = var16 - 1;
                     var38 = 1 + var38 & 4095;
                     class109.field1949[var35][var36 - 1] = 1;
                     class109.field1950[var35][var36 - 1] = var26;
                  }

                  if(var36 < 126 && class109.field1949[var35][1 + var36] == 0 && (var32[var24][var25 + 2] & 19136824) == 0 && (var32[var24 + 1][var25 + 2] & 19136992) == 0) {
                     class109.field1953[var38] = var15;
                     class109.field1954[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class109.field1949[var35][var36 + 1] = 4;
                     class109.field1950[var35][1 + var36] = var26;
                  }

                  if(var35 > 0 && var36 > 0 && class109.field1949[var35 - 1][var36 - 1] == 0 && (var32[var24 - 1][var25] & 19136830) == 0 && (var32[var24 - 1][var25 - 1] & 19136782) == 0 && (var32[var24][var25 - 1] & 19136911) == 0) {
                     class109.field1953[var38] = var15 - 1;
                     class109.field1954[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class109.field1949[var35 - 1][var36 - 1] = 3;
                     class109.field1950[var35 - 1][var36 - 1] = var26;
                  }

                  if(var35 < 126 && var36 > 0 && class109.field1949[1 + var35][var36 - 1] == 0 && (var32[1 + var24][var25 - 1] & 19136911) == 0 && (var32[2 + var24][var25 - 1] & 19136899) == 0 && (var32[var24 + 2][var25] & 19136995) == 0) {
                     class109.field1953[var38] = 1 + var15;
                     class109.field1954[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class109.field1949[1 + var35][var36 - 1] = 9;
                     class109.field1950[1 + var35][var36 - 1] = var26;
                  }

                  if(var35 > 0 && var36 < 126 && class109.field1949[var35 - 1][1 + var36] == 0 && (var32[var24 - 1][var25 + 1] & 19136830) == 0 && (var32[var24 - 1][2 + var25] & 19136824) == 0 && (var32[var24][2 + var25] & 19137016) == 0) {
                     class109.field1953[var38] = var15 - 1;
                     class109.field1954[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class109.field1949[var35 - 1][1 + var36] = 6;
                     class109.field1950[var35 - 1][var36 + 1] = var26;
                  }

                  if(var35 < 126 && var36 < 126 && class109.field1949[1 + var35][1 + var36] == 0 && (var32[var24 + 1][var25 + 2] & 19137016) == 0 && (var32[2 + var24][2 + var25] & 19136992) == 0 && (var32[2 + var24][var25 + 1] & 19136995) == 0) {
                     class109.field1953[var38] = var15 + 1;
                     class109.field1954[var38] = var16 + 1;
                     var38 = 1 + var38 & 4095;
                     class109.field1949[var35 + 1][var36 + 1] = 12;
                     class109.field1950[var35 + 1][1 + var36] = var26;
                  }
               }

               var33 = var34;
            } else {
               var33 = class139.method2935(var4, var5, var8, var9, var10);
            }

            int var7;
            label464: {
               var14 = var4 - 64;
               var15 = var5 - 64;
               var16 = class35.field800;
               var35 = class109.field1948;
               if(!var33) {
                  var36 = Integer.MAX_VALUE;
                  var19 = Integer.MAX_VALUE;
                  byte var37 = 10;
                  var38 = var9.field1962;
                  var22 = var9.field1960;
                  int var23 = var9.field1958;
                  var24 = var9.field1961;

                  for(var25 = var38 - var37; var25 <= var37 + var38; ++var25) {
                     for(var26 = var22 - var37; var26 <= var22 + var37; ++var26) {
                        int var27 = var25 - var14;
                        int var28 = var26 - var15;
                        if(var27 >= 0 && var28 >= 0 && var27 < 128 && var28 < 128 && class109.field1950[var27][var28] < 100) {
                           int var29 = 0;
                           if(var25 < var38) {
                              var29 = var38 - var25;
                           } else if(var25 > var23 + var38 - 1) {
                              var29 = var25 - (var23 + var38 - 1);
                           }

                           int var30 = 0;
                           if(var26 < var22) {
                              var30 = var22 - var26;
                           } else if(var26 > var22 + var24 - 1) {
                              var30 = var26 - (var24 + var22 - 1);
                           }

                           int var31 = var30 * var30 + var29 * var29;
                           if(var31 < var36 || var31 == var36 && class109.field1950[var27][var28] < var19) {
                              var36 = var31;
                              var19 = class109.field1950[var27][var28];
                              var16 = var25;
                              var35 = var26;
                           }
                        }
                     }
                  }

                  if(var36 == Integer.MAX_VALUE) {
                     var7 = -1;
                     break label464;
                  }
               }

               if(var4 == var16 && var35 == var5) {
                  var7 = 0;
               } else {
                  var18 = 0;
                  class109.field1953[var18] = var16;
                  var36 = var18 + 1;
                  class109.field1954[var18] = var35;

                  for(var19 = var20 = class109.field1949[var16 - var14][var35 - var15]; var16 != var4 || var5 != var35; var19 = class109.field1949[var16 - var14][var35 - var15]) {
                     if(var20 != var19) {
                        var20 = var19;
                        class109.field1953[var36] = var16;
                        class109.field1954[var36++] = var35;
                     }

                     if((var19 & 2) != 0) {
                        ++var16;
                     } else if((var19 & 8) != 0) {
                        --var16;
                     }

                     if((var19 & 1) != 0) {
                        ++var35;
                     } else if((var19 & 4) != 0) {
                        --var35;
                     }
                  }

                  var38 = 0;

                  while(var36-- > 0) {
                     var11[var38] = class109.field1953[var36];
                     var12[var38++] = class109.field1954[var36];
                     if(var38 >= var11.length) {
                        break;
                     }
                  }

                  var7 = var38;
               }
            }

            var13 = var7;
            if(var7 >= 1) {
               for(var14 = 0; var14 < var13 - 1; ++var14) {
                  var0.method19(Client.field561[var14], Client.field562[var14], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "152042248"
   )
   public static void method238(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class79.field1464 = var1.method2717();
      class79.field1462 = new int[class79.field1464];
      class79.field1458 = new int[class79.field1464];
      class59.field1268 = new int[class79.field1464];
      class79.field1461 = new int[class79.field1464];
      class8.field139 = new byte[class79.field1464][];
      var1.offset = var0.length - 7 - class79.field1464 * 8;
      class79.field1460 = var1.method2717();
      class79.field1456 = var1.method2717();
      int var2 = (var1.method2528() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class79.field1464; ++var3) {
         class79.field1462[var3] = var1.method2717();
      }

      for(var3 = 0; var3 < class79.field1464; ++var3) {
         class79.field1458[var3] = var1.method2717();
      }

      for(var3 = 0; var3 < class79.field1464; ++var3) {
         class59.field1268[var3] = var1.method2717();
      }

      for(var3 = 0; var3 < class79.field1464; ++var3) {
         class79.field1461[var3] = var1.method2717();
      }

      var1.offset = var0.length - 7 - class79.field1464 * 8 - (var2 - 1) * 3;
      class132.field2126 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class132.field2126[var3] = var1.method2532();
         if(class132.field2126[var3] == 0) {
            class132.field2126[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class79.field1464; ++var3) {
         int var4 = class59.field1268[var3];
         int var5 = class79.field1461[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class8.field139[var3] = var7;
         int var8 = var1.method2528();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2529();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var10 * var4 + var9] = var1.method2529();
               }
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1718582671"
   )
   public static int method240(int var0) {
      return var0 >> 11 & 63;
   }
}
