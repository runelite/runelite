import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class48 extends class207 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1768811115
   )
   public int field1071;
   @ObfuscatedName("w")
   public static class196 field1072 = new class196(64);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -660823671
   )
   public int field1073 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2065862541
   )
   public int field1074 = -1;
   @ObfuscatedName("g")
   public boolean field1075 = true;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1220246965
   )
   public int field1076 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 517295551
   )
   public int field1077;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1131737527
   )
   public int field1078;
   @ObfuscatedName("cl")
   public static char field1079;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -972407065
   )
   public int field1080;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 182961849
   )
   public int field1081;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1834491581
   )
   public int field1082;
   @ObfuscatedName("m")
   public static class170 field1083;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1731216907"
   )
   public void method994() {
      if(this.field1076 != -1) {
         this.method1011(this.field1076);
         this.field1071 = this.field1077;
         this.field1081 = this.field1078;
         this.field1082 = this.field1080;
      }

      this.method1011(this.field1073);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "800327786"
   )
   public void method995(class122 var1, int var2) {
      while(true) {
         int var3 = var1.method2556();
         if(var3 == 0) {
            return;
         }

         this.method996(var1, var3, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass122;III)V",
      garbageValue = "-1983961161"
   )
   void method996(class122 var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1073 = var1.method2576();
      } else if(var2 == 2) {
         this.field1074 = var1.method2556();
      } else if(var2 == 5) {
         this.field1075 = false;
      } else if(var2 == 7) {
         this.field1076 = var1.method2576();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "19688"
   )
   static final void method997(boolean var0) {
      client.field396 = 0;
      client.field311 = 0;
      class39.method785();

      int var1;
      class36 var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      while(client.field315.method2801(client.field283) >= 27) {
         var1 = client.field315.method2813(15);
         if(var1 == 32767) {
            break;
         }

         boolean var2 = false;
         if(null == client.field308[var1]) {
            client.field308[var1] = new class36();
            var2 = true;
         }

         var3 = client.field308[var1];
         client.field310[++client.field394 - 1] = var1;
         var3.field879 = client.field282;
         if(var0) {
            var4 = client.field315.method2813(8);
            if(var4 > 127) {
               var4 -= 256;
            }
         } else {
            var4 = client.field315.method2813(5);
            if(var4 > 15) {
               var4 -= 32;
            }
         }

         var5 = client.field315.method2813(1);
         var6 = client.field315.method2813(1);
         if(var6 == 1) {
            client.field312[++client.field311 - 1] = var1;
         }

         var3.field802 = class1.method7(client.field315.method2813(14));
         if(var0) {
            var7 = client.field315.method2813(8);
            if(var7 > 127) {
               var7 -= 256;
            }
         } else {
            var7 = client.field315.method2813(5);
            if(var7 > 15) {
               var7 -= 32;
            }
         }

         var8 = client.field306[client.field315.method2813(3)];
         if(var2) {
            var3.field881 = var3.field832 = var8;
         }

         var3.field858 = var3.field802.field906;
         var3.field883 = var3.field802.field933;
         if(var3.field883 == 0) {
            var3.field832 = 0;
         }

         var3.field839 = var3.field802.field931;
         var3.field878 = var3.field802.field917;
         var3.field840 = var3.field802.field918;
         var3.field841 = var3.field802.field919;
         var3.field847 = var3.field802.field913;
         var3.field876 = var3.field802.field924;
         var3.field837 = var3.field802.field915;
         var3.method734(class114.field2010.field885[0] + var4, var7 + class114.field2010.field886[0], var5 == 1);
      }

      client.field315.method2800();

      int var13;
      for(var1 = 0; var1 < client.field311; ++var1) {
         var13 = client.field312[var1];
         var3 = client.field308[var13];
         var4 = client.field315.method2556();
         if((var4 & 32) != 0) {
            var3.field834 = client.field315.method2606();
            var5 = client.field315.method2616();
            var3.field871 = var5 >> 16;
            var3.field870 = client.field282 + (var5 & '\uffff');
            var3.field868 = 0;
            var3.field869 = 0;
            if(var3.field870 > client.field282) {
               var3.field868 = -1;
            }

            if(var3.field834 == '\uffff') {
               var3.field834 = -1;
            }
         }

         if((var4 & 16) != 0) {
            var3.field856 = client.field315.method2655();
            if(var3.field856 == '\uffff') {
               var3.field856 = -1;
            }
         }

         if((var4 & 64) != 0) {
            var5 = client.field315.method2655();
            if(var5 == '\uffff') {
               var5 = -1;
            }

            var6 = client.field315.method2718();
            if(var5 == var3.field884 && var5 != -1) {
               var7 = class28.method646(var5).field1022;
               if(var7 == 1) {
                  var3.field863 = 0;
                  var3.field862 = 0;
                  var3.field865 = var6;
                  var3.field866 = 0;
               }

               if(var7 == 2) {
                  var3.field866 = 0;
               }
            } else if(var5 == -1 || var3.field884 == -1 || class28.method646(var5).field1005 >= class28.method646(var3.field884).field1005) {
               var3.field884 = var5;
               var3.field863 = 0;
               var3.field862 = 0;
               var3.field865 = var6;
               var3.field866 = 0;
               var3.field851 = var3.field875;
            }
         }

         if((var4 & 1) != 0) {
            var5 = client.field315.method2598();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = client.field315.method2585();
                  if(var7 == 32767) {
                     var7 = client.field315.method2585();
                     var9 = client.field315.method2585();
                     var8 = client.field315.method2585();
                     var10 = client.field315.method2585();
                  } else if(var7 != 32766) {
                     var9 = client.field315.method2585();
                  } else {
                     var7 = -1;
                  }

                  var11 = client.field315.method2585();
                  var3.method772(var7, var9, var8, var10, client.field282, var11);
               }
            }

            var6 = client.field315.method2718();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = client.field315.method2585();
                  var9 = client.field315.method2585();
                  if(var9 != 32767) {
                     var10 = client.field315.method2585();
                     var11 = client.field315.method2754();
                     int var12 = var9 > 0?client.field315.method2718():var11;
                     var3.method773(var8, client.field282, var9, var10, var11, var12);
                  } else {
                     var3.method774(var8);
                  }
               }
            }
         }

         if((var4 & 2) != 0) {
            var3.field802 = class1.method7(client.field315.method2706());
            var3.field858 = var3.field802.field906;
            var3.field883 = var3.field802.field933;
            var3.field839 = var3.field802.field931;
            var3.field878 = var3.field802.field917;
            var3.field840 = var3.field802.field918;
            var3.field841 = var3.field802.field919;
            var3.field847 = var3.field802.field913;
            var3.field876 = var3.field802.field924;
            var3.field837 = var3.field802.field915;
         }

         if((var4 & 4) != 0) {
            var3.field843 = client.field315.method2580();
            var3.field890 = 100;
         }

         if((var4 & 8) != 0) {
            var5 = client.field315.method2606();
            var6 = client.field315.method2606();
            var7 = var3.field864 - (var5 - class39.field838 - class39.field838) * 64;
            var8 = var3.field831 - (var6 - class13.field184 - class13.field184) * 64;
            if(var7 != 0 || var8 != 0) {
               var3.field867 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }
      }

      for(var1 = 0; var1 < client.field396; ++var1) {
         var13 = client.field431[var1];
         if(client.field282 != client.field308[var13].field879) {
            client.field308[var13].field802 = null;
            client.field308[var13] = null;
         }
      }

      if(client.field315.field2045 != client.field283) {
         throw new RuntimeException(client.field315.field2045 + "," + client.field283);
      } else {
         for(var1 = 0; var1 < client.field394; ++var1) {
            if(null == client.field308[client.field310[var1]]) {
               throw new RuntimeException(var1 + "," + client.field394);
            }
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-124"
   )
   void method1011(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var10 + var8) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1077 = (int)(var12 * 256.0D);
      this.field1078 = (int)(256.0D * var14);
      this.field1080 = (int)(256.0D * var16);
      if(this.field1078 < 0) {
         this.field1078 = 0;
      } else if(this.field1078 > 255) {
         this.field1078 = 255;
      }

      if(this.field1080 < 0) {
         this.field1080 = 0;
      } else if(this.field1080 > 255) {
         this.field1080 = 255;
      }

   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-179320268"
   )
   @Export("xteaChanged")
   static final void method1013(boolean var0) {
      client.field332 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!client.field332) {
         var1 = client.field315.method2608();
         var2 = client.field315.method2608();
         var3 = client.field315.method2706();
         client.field330 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               client.field330[var4][var5] = client.field315.method2577();
            }
         }

         class124.field2054 = new int[var3];
         class62.field1295 = new int[var3];
         class146.field2251 = new int[var3];
         class79.field1466 = new byte[var3][];
         class25.field632 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class124.field2054[var3] = var7;
                  class62.field1295[var3] = class129.field2097.method3319("m" + var5 + "_" + var6);
                  class146.field2251[var3] = class129.field2097.method3319("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class52.method1110(var1, var2);
      } else {
         var1 = client.field315.method2655();
         var2 = client.field315.method2655();
         var3 = client.field315.method2706();
         client.field315.method2799();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field315.method2813(1);
                  if(var7 == 1) {
                     client.field333[var4][var5][var6] = client.field315.method2813(26);
                  } else {
                     client.field333[var4][var5][var6] = -1;
                  }
               }
            }
         }

         client.field315.method2800();
         client.field330 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               client.field330[var4][var5] = client.field315.method2577();
            }
         }

         class124.field2054 = new int[var3];
         class62.field1295 = new int[var3];
         class146.field2251 = new int[var3];
         class79.field1466 = new byte[var3][];
         class25.field632 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field333[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(class124.field2054[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class124.field2054[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class62.field1295[var3] = class129.field2097.method3319("m" + var11 + "_" + var12);
                        class146.field2251[var3] = class129.field2097.method3319("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class52.method1110(var1, var2);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "256"
   )
   static void method1015() {
      client.field313.field2045 = 0;
      client.field315.field2045 = 0;
      client.field317 = -1;
      client.field320 = 1;
      client.field321 = -1;
      client.field290 = -1;
      client.field283 = 0;
      client.field318 = 0;
      client.field289 = 0;
      client.field412 = 0;
      client.field517 = false;
      client.field506 = 0;
      client.field504 = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         client.field393[var0] = null;
      }

      class114.field2010 = null;

      for(var0 = 0; var0 < client.field308.length; ++var0) {
         class36 var1 = client.field308[var0];
         if(null != var1) {
            var1.field856 = -1;
            var1.field857 = false;
         }
      }

      class3.method40();
      class171.method3414(30);

      for(var0 = 0; var0 < 100; ++var0) {
         client.field460[var0] = true;
      }

      class177.method3493();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "1745996799"
   )
   public static void method1017(class170 var0) {
      class43.field994 = var0;
   }
}
