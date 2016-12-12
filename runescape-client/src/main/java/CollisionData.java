import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -470843309
   )
   @Export("width")
   int width;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -34429263
   )
   @Export("y")
   int y = 0;
   @ObfuscatedName("az")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1559889231
   )
   @Export("x")
   int x = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -36502863
   )
   @Export("height")
   int height;
   @ObfuscatedName("br")
   static class184 field1837;
   @ObfuscatedName("bd")
   static class184 field1838;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1282001641"
   )
   public void method2210() {
      for(int var1 = 0; var1 < this.width; ++var1) {
         for(int var2 = 0; var2 < this.height; ++var2) {
            if(var1 != 0 && var2 != 0 && var1 < this.width - 5 && var2 < this.height - 5) {
               this.flags[var1][var2] = 16777216;
            } else {
               this.flags[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "0"
   )
   public void method2211(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2215(var1, var2, 128);
            this.method2215(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2215(var1, var2, 2);
            this.method2215(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2215(var1, var2, 8);
            this.method2215(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2215(var1, var2, 32);
            this.method2215(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2215(var1, var2, 1);
            this.method2215(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2215(var1, var2, 4);
            this.method2215(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2215(var1, var2, 16);
            this.method2215(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2215(var1, var2, 64);
            this.method2215(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2215(var1, var2, 130);
            this.method2215(var1 - 1, var2, 8);
            this.method2215(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2215(var1, var2, 10);
            this.method2215(var1, var2 + 1, 32);
            this.method2215(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2215(var1, var2, 40);
            this.method2215(var1 + 1, var2, 128);
            this.method2215(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2215(var1, var2, 160);
            this.method2215(var1, var2 - 1, 2);
            this.method2215(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2215(var1, var2, 65536);
               this.method2215(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2215(var1, var2, 1024);
               this.method2215(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2215(var1, var2, 4096);
               this.method2215(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2215(var1, var2, 16384);
               this.method2215(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2215(var1, var2, 512);
               this.method2215(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2215(var1, var2, 2048);
               this.method2215(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2215(var1, var2, 8192);
               this.method2215(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2215(var1, var2, '耀');
               this.method2215(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2215(var1, var2, 66560);
               this.method2215(var1 - 1, var2, 4096);
               this.method2215(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2215(var1, var2, 5120);
               this.method2215(var1, var2 + 1, 16384);
               this.method2215(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2215(var1, var2, 20480);
               this.method2215(1 + var1, var2, 65536);
               this.method2215(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2215(var1, var2, 81920);
               this.method2215(var1, var2 - 1, 1024);
               this.method2215(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1747455674"
   )
   public void method2212(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;

      for(int var7 = var1; var7 < var1 + var3; ++var7) {
         if(var7 >= 0 && var7 < this.width) {
            for(int var8 = var2; var8 < var4 + var2; ++var8) {
               if(var8 >= 0 && var8 < this.height) {
                  this.method2215(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1758015891"
   )
   public void method2213(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "0"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.field349 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.field349) {
         var1 = Client.field544.method2795();
         var2 = Client.field544.method2795();
         var3 = Client.field544.readUnsignedShort();
         class196.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class196.xteaKeys[var4][var5] = Client.field544.method2844();
            }
         }

         Client.mapRegions = new int[var3];
         XGrandExchangeOffer.field41 = new int[var3];
         class16.field171 = new int[var3];
         class179.field2690 = new byte[var3][];
         class18.field186 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (6 + var1) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  Client.mapRegions[var3] = var7;
                  XGrandExchangeOffer.field41[var3] = Friend.field150.method3225("m" + var5 + "_" + var6);
                  class16.field171[var3] = Friend.field150.method3225("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class9.method99(var1, var2);
      } else {
         var1 = Client.field544.method2797();
         var2 = Client.field544.readUnsignedShort();
         var3 = Client.field544.readUnsignedShort();
         Client.field544.method2977();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field544.method2978(1);
                  if(var7 == 1) {
                     Client.field350[var4][var5][var6] = Client.field544.method2978(26);
                  } else {
                     Client.field350[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field544.method2982();
         class196.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class196.xteaKeys[var4][var5] = Client.field544.method2844();
            }
         }

         Client.mapRegions = new int[var3];
         XGrandExchangeOffer.field41 = new int[var3];
         class16.field171 = new int[var3];
         class179.field2690 = new byte[var3][];
         class18.field186 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field350[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = var9 / 8 + (var8 / 8 << 8);

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(Client.mapRegions[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        Client.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        XGrandExchangeOffer.field41[var3] = Friend.field150.method3225("m" + var11 + "_" + var12);
                        class16.field171[var3] = Friend.field150.method3225("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class9.method99(var1, var2);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2140173603"
   )
   void method2215(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1611572201"
   )
   public void method2216(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2235(var1, var2, 128);
            this.method2235(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2235(var1, var2, 2);
            this.method2235(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2235(var1, var2, 8);
            this.method2235(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2235(var1, var2, 32);
            this.method2235(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2235(var1, var2, 1);
            this.method2235(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2235(var1, var2, 4);
            this.method2235(1 + var1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2235(var1, var2, 16);
            this.method2235(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2235(var1, var2, 64);
            this.method2235(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2235(var1, var2, 130);
            this.method2235(var1 - 1, var2, 8);
            this.method2235(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2235(var1, var2, 10);
            this.method2235(var1, var2 + 1, 32);
            this.method2235(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2235(var1, var2, 40);
            this.method2235(var1 + 1, var2, 128);
            this.method2235(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2235(var1, var2, 160);
            this.method2235(var1, var2 - 1, 2);
            this.method2235(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2235(var1, var2, 65536);
               this.method2235(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2235(var1, var2, 1024);
               this.method2235(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2235(var1, var2, 4096);
               this.method2235(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2235(var1, var2, 16384);
               this.method2235(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2235(var1, var2, 512);
               this.method2235(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2235(var1, var2, 2048);
               this.method2235(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2235(var1, var2, 8192);
               this.method2235(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2235(var1, var2, '耀');
               this.method2235(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2235(var1, var2, 66560);
               this.method2235(var1 - 1, var2, 4096);
               this.method2235(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2235(var1, var2, 5120);
               this.method2235(var1, 1 + var2, 16384);
               this.method2235(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2235(var1, var2, 20480);
               this.method2235(var1 + 1, var2, 65536);
               this.method2235(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2235(var1, var2, 81920);
               this.method2235(var1, var2 - 1, 1024);
               this.method2235(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1296391621"
   )
   public void method2218(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2126986625"
   )
   public void method2219(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "14033367"
   )
   public void method2220(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;
      int var8;
      if(var5 == 1 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var3 + var1; ++var8) {
         if(var8 >= 0 && var8 < this.width) {
            for(int var9 = var2; var9 < var2 + var4; ++var9) {
               if(var9 >= 0 && var9 < this.height) {
                  this.method2235(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public CollisionData(int var1, int var2) {
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.method2210();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2065326925"
   )
   void method2235(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }
}
