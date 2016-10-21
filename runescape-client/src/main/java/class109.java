import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class109 {
   @ObfuscatedName("t")
   public static int[][] field1925 = new int[128][128];
   @ObfuscatedName("n")
   public static int[][] field1927 = new int[128][128];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1626309195
   )
   public static int field1929;
   @ObfuscatedName("k")
   public static int[] field1932 = new int[4096];
   @ObfuscatedName("c")
   public static int[] field1933 = new int[4096];

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "-1545435931"
   )
   static final void method2392(class125 var0) {
      for(int var1 = 0; var1 < class34.field771; ++var1) {
         int var2 = class34.field775[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.method2656();
         if((var4 & 1) != 0) {
            var4 += var0.method2656() << 8;
         }

         byte var5 = -1;
         int var6;
         if((var4 & 8) != 0) {
            var6 = var0.method2656();
            byte[] var15 = new byte[var6];
            Buffer var14 = new Buffer(var15);
            var0.method2698(var15, 0, var6);
            class34.field761[var2] = var14;
            var3.method18(var14);
         }

         int var7;
         if((var4 & 16) != 0) {
            var6 = var0.method2535();
            if(var6 == '\uffff') {
               var6 = -1;
            }

            var7 = var0.method2656();
            class184.method3588(var3, var6, var7);
         }

         if((var4 & 32) != 0) {
            var3.interacting = var0.method2535();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }

         if((var4 & 128) != 0) {
            var3.overhead = var0.method2541();
            if(var3.overhead.charAt(0) == 126) {
               var3.overhead = var3.overhead.substring(1);
               class190.sendGameMessage(2, var3.name, var3.overhead);
            } else if(class34.localPlayer == var3) {
               class190.sendGameMessage(2, var3.name, var3.overhead);
            }

            var3.field830 = false;
            var3.field816 = 0;
            var3.field834 = 0;
            var3.field832 = 150;
         }

         int var9;
         int var10;
         int var13;
         if((var4 & 4) != 0) {
            var6 = var0.method2656();
            int var8;
            int var11;
            int var16;
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var9 = -1;
                  var10 = -1;
                  var11 = -1;
                  var8 = var0.method2546();
                  if(var8 == 32767) {
                     var8 = var0.method2546();
                     var10 = var0.method2546();
                     var9 = var0.method2546();
                     var11 = var0.method2546();
                  } else if(var8 != 32766) {
                     var10 = var0.method2546();
                  } else {
                     var8 = -1;
                  }

                  var16 = var0.method2546();
                  var3.method769(var8, var10, var9, var11, Client.gameCycle, var16);
               }
            }

            var7 = var0.method2656();
            if(var7 > 0) {
               for(var8 = 0; var8 < var7; ++var8) {
                  var9 = var0.method2546();
                  var10 = var0.method2546();
                  if(var10 != 32767) {
                     var11 = var0.method2546();
                     var16 = var0.method2656();
                     var13 = var10 > 0?var0.method2656():var16;
                     var3.method770(var9, Client.gameCycle, var10, var11, var16, var13);
                  } else {
                     var3.method767(var9);
                  }
               }
            }
         }

         if((var4 & 2) != 0) {
            var3.field844 = var0.method2535();
            if(var3.field867 == 0) {
               var3.field873 = var3.field844;
               var3.field844 = -1;
            }
         }

         if((var4 & 64) != 0) {
            var6 = var0.method2535();
            class155 var20 = (class155)class168.method3262(class158.method3190(), var0.method2656());
            boolean var18 = var0.method2656() == 1;
            var9 = var0.method2656();
            var10 = var0.offset;
            if(var3.name != null && null != var3.composition) {
               boolean var19 = false;
               if(var20.field2313 && class8.method104(var3.name)) {
                  var19 = true;
               }

               if(!var19 && Client.field401 == 0 && !var3.field52) {
                  class34.field770.offset = 0;
                  var0.method2698(class34.field770.payload, 0, var9);
                  class34.field770.offset = 0;
                  String var12 = class226.method4170(class31.method681(class189.method3797(class34.field770)));
                  var3.overhead = var12.trim();
                  var3.field816 = var6 >> 8;
                  var3.field834 = var6 & 255;
                  var3.field832 = 150;
                  var3.field830 = var18;
                  var3.inSequence = var3 != class34.localPlayer && var20.field2313 && Client.field499 != "" && var12.toLowerCase().indexOf(Client.field499) == -1;
                  if(var20.field2312) {
                     var13 = var18?91:1;
                  } else {
                     var13 = var18?90:2;
                  }

                  if(var20.field2311 != -1) {
                     class190.sendGameMessage(var13, class119.method2476(var20.field2311) + var3.name, var12);
                  } else {
                     class190.sendGameMessage(var13, var3.name, var12);
                  }
               }
            }

            var0.offset = var9 + var10;
         }

         if((var4 & 512) != 0) {
            var3.graphic = var0.method2535();
            var6 = var0.method2538();
            var3.field860 = var6 >> 16;
            var3.field846 = Client.gameCycle + (var6 & '\uffff');
            var3.field835 = 0;
            var3.field855 = 0;
            if(var3.field846 > Client.gameCycle) {
               var3.field835 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 256) != 0) {
            var3.field858 = var0.method2534();
            var3.field840 = var0.method2534();
            var3.field859 = var0.method2534();
            var3.field861 = var0.method2534();
            var3.field866 = var0.method2535() + Client.gameCycle;
            var3.field841 = var0.method2535() + Client.gameCycle;
            var3.field864 = var0.method2535();
            if(var3.field54) {
               var3.field858 += var3.field36;
               var3.field840 += var3.field48;
               var3.field859 += var3.field36;
               var3.field861 += var3.field48;
               var3.field867 = 0;
            } else {
               var3.field858 += var3.pathX[0];
               var3.field840 += var3.pathY[0];
               var3.field859 += var3.pathX[0];
               var3.field861 += var3.pathY[0];
               var3.field867 = 1;
            }

            var3.field875 = 0;
         }

         if((var4 & 2048) != 0) {
            class34.field760[var2] = var0.method2534();
         }

         if((var4 & 4096) != 0) {
            var5 = var0.method2534();
         }

         if((var4 & 1024) != 0) {
            for(var6 = 0; var6 < 3; ++var6) {
               var3.actions[var6] = var0.method2541();
            }
         }

         if(var3.field54) {
            if(var5 == 127) {
               var3.method22(var3.field36, var3.field48);
            } else {
               byte var17;
               if(var5 != -1) {
                  var17 = var5;
               } else {
                  var17 = class34.field760[var2];
               }

               var3.method21(var3.field36, var3.field48, var17);
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "34"
   )
   public static int method2394(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-1592998103"
   )
   static Class method2398(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "189722510"
   )
   static final int method2399(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
