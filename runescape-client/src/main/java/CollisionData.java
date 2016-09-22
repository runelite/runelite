import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("at")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1919702517
   )
   @Export("height")
   int height;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 2143404205
   )
   @Export("x")
   public int x = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1834561341
   )
   @Export("y")
   public int y = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1972742187
   )
   @Export("width")
   int width;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 8497694495608059067L
   )
   public static long field1982;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "124413061"
   )
   public static int method2410(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var6 + var4] = -128;
            } else if(var7 == 8218) {
               var3[var4 + var6] = -126;
            } else if(var7 == 402) {
               var3[var6 + var4] = -125;
            } else if(var7 == 8222) {
               var3[var4 + var6] = -124;
            } else if(var7 == 8230) {
               var3[var4 + var6] = -123;
            } else if(var7 == 8224) {
               var3[var4 + var6] = -122;
            } else if(var7 == 8225) {
               var3[var6 + var4] = -121;
            } else if(var7 == 710) {
               var3[var4 + var6] = -120;
            } else if(var7 == 8240) {
               var3[var4 + var6] = -119;
            } else if(var7 == 352) {
               var3[var4 + var6] = -118;
            } else if(var7 == 8249) {
               var3[var6 + var4] = -117;
            } else if(var7 == 338) {
               var3[var6 + var4] = -116;
            } else if(var7 == 381) {
               var3[var4 + var6] = -114;
            } else if(var7 == 8216) {
               var3[var4 + var6] = -111;
            } else if(var7 == 8217) {
               var3[var6 + var4] = -110;
            } else if(var7 == 8220) {
               var3[var4 + var6] = -109;
            } else if(var7 == 8221) {
               var3[var6 + var4] = -108;
            } else if(var7 == 8226) {
               var3[var4 + var6] = -107;
            } else if(var7 == 8211) {
               var3[var4 + var6] = -106;
            } else if(var7 == 8212) {
               var3[var6 + var4] = -105;
            } else if(var7 == 732) {
               var3[var6 + var4] = -104;
            } else if(var7 == 8482) {
               var3[var4 + var6] = -103;
            } else if(var7 == 353) {
               var3[var4 + var6] = -102;
            } else if(var7 == 8250) {
               var3[var6 + var4] = -101;
            } else if(var7 == 339) {
               var3[var6 + var4] = -100;
            } else if(var7 == 382) {
               var3[var4 + var6] = -98;
            } else if(var7 == 376) {
               var3[var4 + var6] = -97;
            } else {
               var3[var6 + var4] = 63;
            }
         } else {
            var3[var4 + var6] = (byte)var7;
         }
      }

      return var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "118"
   )
   public void method2411(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2415(var1, var2, 128);
            this.method2415(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2415(var1, var2, 2);
            this.method2415(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2415(var1, var2, 8);
            this.method2415(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2415(var1, var2, 32);
            this.method2415(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2415(var1, var2, 1);
            this.method2415(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2415(var1, var2, 4);
            this.method2415(var1 + 1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2415(var1, var2, 16);
            this.method2415(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2415(var1, var2, 64);
            this.method2415(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2415(var1, var2, 130);
            this.method2415(var1 - 1, var2, 8);
            this.method2415(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2415(var1, var2, 10);
            this.method2415(var1, 1 + var2, 32);
            this.method2415(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2415(var1, var2, 40);
            this.method2415(1 + var1, var2, 128);
            this.method2415(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2415(var1, var2, 160);
            this.method2415(var1, var2 - 1, 2);
            this.method2415(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2415(var1, var2, 65536);
               this.method2415(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2415(var1, var2, 1024);
               this.method2415(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2415(var1, var2, 4096);
               this.method2415(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2415(var1, var2, 16384);
               this.method2415(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2415(var1, var2, 512);
               this.method2415(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2415(var1, var2, 2048);
               this.method2415(1 + var1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2415(var1, var2, 8192);
               this.method2415(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2415(var1, var2, '耀');
               this.method2415(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2415(var1, var2, 66560);
               this.method2415(var1 - 1, var2, 4096);
               this.method2415(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2415(var1, var2, 5120);
               this.method2415(var1, 1 + var2, 16384);
               this.method2415(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2415(var1, var2, 20480);
               this.method2415(var1 + 1, var2, 65536);
               this.method2415(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2415(var1, var2, 81920);
               this.method2415(var1, var2 - 1, 1024);
               this.method2415(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1583701336"
   )
   public void method2412(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;

      for(int var7 = var1; var7 < var1 + var3; ++var7) {
         if(var7 >= 0 && var7 < this.width) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if(var8 >= 0 && var8 < this.height) {
                  this.method2415(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "111"
   )
   public void method2413(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1451643412"
   )
   public void method2414(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1195953912"
   )
   void method2415(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-557743164"
   )
   public void method2416(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2418(var1, var2, 128);
            this.method2418(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2418(var1, var2, 2);
            this.method2418(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2418(var1, var2, 8);
            this.method2418(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2418(var1, var2, 32);
            this.method2418(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2418(var1, var2, 1);
            this.method2418(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2418(var1, var2, 4);
            this.method2418(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2418(var1, var2, 16);
            this.method2418(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2418(var1, var2, 64);
            this.method2418(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2418(var1, var2, 130);
            this.method2418(var1 - 1, var2, 8);
            this.method2418(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2418(var1, var2, 10);
            this.method2418(var1, var2 + 1, 32);
            this.method2418(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2418(var1, var2, 40);
            this.method2418(1 + var1, var2, 128);
            this.method2418(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2418(var1, var2, 160);
            this.method2418(var1, var2 - 1, 2);
            this.method2418(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2418(var1, var2, 65536);
               this.method2418(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2418(var1, var2, 1024);
               this.method2418(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2418(var1, var2, 4096);
               this.method2418(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2418(var1, var2, 16384);
               this.method2418(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2418(var1, var2, 512);
               this.method2418(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2418(var1, var2, 2048);
               this.method2418(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2418(var1, var2, 8192);
               this.method2418(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2418(var1, var2, '耀');
               this.method2418(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2418(var1, var2, 66560);
               this.method2418(var1 - 1, var2, 4096);
               this.method2418(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2418(var1, var2, 5120);
               this.method2418(var1, 1 + var2, 16384);
               this.method2418(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2418(var1, var2, 20480);
               this.method2418(var1 + 1, var2, 65536);
               this.method2418(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2418(var1, var2, 81920);
               this.method2418(var1, var2 - 1, 1024);
               this.method2418(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-27"
   )
   public void method2417() {
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1625827231"
   )
   void method2418(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "256"
   )
   public void method2419(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public CollisionData(int var1, int var2) {
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.method2417();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "1226835630"
   )
   public void method2423(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
            for(int var9 = var2; var9 < var4 + var2; ++var9) {
               if(var9 >= 0 && var9 < this.height) {
                  this.method2418(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
      garbageValue = "-65"
   )
   public static void method2430(Applet var0, String var1) {
      class141.field2204 = var0;
      class141.field2205 = var1;
   }
}
