import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("CollisionData")
public class class111 {
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -275464703
   )
   @Export("x")
   int field1965 = 0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1416092625
   )
   @Export("y")
   int field1966 = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1015862213
   )
   @Export("width")
   int field1967;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1529323925
   )
   @Export("height")
   int field1968;
   @ObfuscatedName("ap")
   @Export("flags")
   public int[][] field1969;
   @ObfuscatedName("s")
   public static class170 field1970;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void method2493() {
      for(int var1 = 0; var1 < this.field1967; ++var1) {
         for(int var2 = 0; var2 < this.field1968; ++var2) {
            if(var1 != 0 && var2 != 0 && var1 < this.field1967 - 5 && var2 < this.field1968 - 5) {
               this.field1969[var1][var2] = 16777216;
            } else {
               this.field1969[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "292561370"
   )
   public void method2495(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1965;
      var2 -= this.field1966;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2502(var1, var2, 128);
            this.method2502(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2502(var1, var2, 2);
            this.method2502(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2502(var1, var2, 8);
            this.method2502(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2502(var1, var2, 32);
            this.method2502(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2502(var1, var2, 1);
            this.method2502(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2502(var1, var2, 4);
            this.method2502(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2502(var1, var2, 16);
            this.method2502(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2502(var1, var2, 64);
            this.method2502(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2502(var1, var2, 130);
            this.method2502(var1 - 1, var2, 8);
            this.method2502(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2502(var1, var2, 10);
            this.method2502(var1, var2 + 1, 32);
            this.method2502(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2502(var1, var2, 40);
            this.method2502(var1 + 1, var2, 128);
            this.method2502(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2502(var1, var2, 160);
            this.method2502(var1, var2 - 1, 2);
            this.method2502(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2502(var1, var2, 65536);
               this.method2502(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2502(var1, var2, 1024);
               this.method2502(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2502(var1, var2, 4096);
               this.method2502(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2502(var1, var2, 16384);
               this.method2502(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2502(var1, var2, 512);
               this.method2502(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2502(var1, var2, 2048);
               this.method2502(1 + var1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2502(var1, var2, 8192);
               this.method2502(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2502(var1, var2, '耀');
               this.method2502(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2502(var1, var2, 66560);
               this.method2502(var1 - 1, var2, 4096);
               this.method2502(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2502(var1, var2, 5120);
               this.method2502(var1, 1 + var2, 16384);
               this.method2502(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2502(var1, var2, 20480);
               this.method2502(1 + var1, var2, 65536);
               this.method2502(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2502(var1, var2, 81920);
               this.method2502(var1, var2 - 1, 1024);
               this.method2502(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-529331909"
   )
   public void method2497(int var1, int var2) {
      var1 -= this.field1965;
      var2 -= this.field1966;
      this.field1969[var1][var2] |= 2097152;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1658567892"
   )
   void method2499(int var1, int var2, int var3) {
      this.field1969[var1][var2] |= var3;
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1577300762"
   )
   static final void method2500(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class14.method179(var0)) {
         class10.field169 = null;
         class42.method887(class176.field2836[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class10.field169 != null) {
            class42.method887(class10.field169, -1412584499, var1, var2, var3, var4, class9.field160, class31.field726, var7);
            class10.field169 = null;
         }

      } else {
         if(var7 != -1) {
            client.field498[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               client.field498[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "-1441344225"
   )
   public void method2501(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.field1965;
      var2 -= this.field1966;
      int var8;
      if(var5 == 1 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var1 + var3; ++var8) {
         if(var8 >= 0 && var8 < this.field1967) {
            for(int var9 = var2; var9 < var4 + var2; ++var9) {
               if(var9 >= 0 && var9 < this.field1968) {
                  this.method2502(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1714211425"
   )
   void method2502(int var1, int var2, int var3) {
      this.field1969[var1][var2] &= ~var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1758764559"
   )
   public void method2503(int var1, int var2) {
      var1 -= this.field1965;
      var2 -= this.field1966;
      this.field1969[var1][var2] &= -262145;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1699950016"
   )
   public void method2506(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.field1965;
      var2 -= this.field1966;

      for(int var7 = var1; var7 < var1 + var3; ++var7) {
         if(var7 >= 0 && var7 < this.field1967) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if(var8 >= 0 && var8 < this.field1968) {
                  this.method2499(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-81"
   )
   public void method2513(int var1, int var2) {
      var1 -= this.field1965;
      var2 -= this.field1966;
      this.field1969[var1][var2] |= 262144;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public class111(int var1, int var2) {
      this.field1967 = var1;
      this.field1968 = var2;
      this.field1969 = new int[this.field1967][this.field1968];
      this.method2493();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1643508967"
   )
   public void method2517(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1965;
      var2 -= this.field1966;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2499(var1, var2, 128);
            this.method2499(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2499(var1, var2, 2);
            this.method2499(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2499(var1, var2, 8);
            this.method2499(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2499(var1, var2, 32);
            this.method2499(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2499(var1, var2, 1);
            this.method2499(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2499(var1, var2, 4);
            this.method2499(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2499(var1, var2, 16);
            this.method2499(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2499(var1, var2, 64);
            this.method2499(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2499(var1, var2, 130);
            this.method2499(var1 - 1, var2, 8);
            this.method2499(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2499(var1, var2, 10);
            this.method2499(var1, var2 + 1, 32);
            this.method2499(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2499(var1, var2, 40);
            this.method2499(var1 + 1, var2, 128);
            this.method2499(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2499(var1, var2, 160);
            this.method2499(var1, var2 - 1, 2);
            this.method2499(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2499(var1, var2, 65536);
               this.method2499(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2499(var1, var2, 1024);
               this.method2499(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2499(var1, var2, 4096);
               this.method2499(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2499(var1, var2, 16384);
               this.method2499(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2499(var1, var2, 512);
               this.method2499(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2499(var1, var2, 2048);
               this.method2499(1 + var1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2499(var1, var2, 8192);
               this.method2499(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2499(var1, var2, '耀');
               this.method2499(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2499(var1, var2, 66560);
               this.method2499(var1 - 1, var2, 4096);
               this.method2499(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2499(var1, var2, 5120);
               this.method2499(var1, 1 + var2, 16384);
               this.method2499(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2499(var1, var2, 20480);
               this.method2499(1 + var1, var2, 65536);
               this.method2499(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2499(var1, var2, 81920);
               this.method2499(var1, var2 - 1, 1024);
               this.method2499(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass47;",
      garbageValue = "1445596518"
   )
   public static class47 method2533(int var0) {
      class47 var1 = (class47)class47.field1073.method3905((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class47.field1076.method3411(19, var0);
         var1 = new class47();
         if(var2 != null) {
            var1.method999(new class122(var2));
         }

         class47.field1073.method3907(var1, (long)var0);
         return var1;
      }
   }
}
