import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 4163295
   )
   @Export("x")
   public int x;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1441084061
   )
   @Export("height")
   int height;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1662214135
   )
   @Export("width")
   int width;
   @ObfuscatedName("av")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1820762623
   )
   @Export("y")
   public int y;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "365729493"
   )
   public void method2250() {
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

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;B)Ljava/lang/String;",
      garbageValue = "-44"
   )
   static String method2251(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + class180.method3282(class3.method28(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var4 = "";
            if(class0.field1 != null) {
               var4 = class103.method1992(class0.field1.field1655);
               if(class0.field1.field1657 != null) {
                  var4 = (String)class0.field1.field1657;
               }
            }

            var0 = var0.substring(0, var2) + var4 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "-49"
   )
   public void method2252(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.x;
      var2 -= this.y;

      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         if(var7 >= 0 && var7 < this.width) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if(var8 >= 0 && var8 < this.height) {
                  this.method2273(var7, var8, var6);
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
      this.x = 0;
      this.y = 0;
      this.width = var1;
      this.height = var2;
      this.flags = new int[this.width][this.height];
      this.method2250();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-88"
   )
   public void method2253(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1500225587"
   )
   public void method2254(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2273(var1, var2, 128);
            this.method2273(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2273(var1, var2, 2);
            this.method2273(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2273(var1, var2, 8);
            this.method2273(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2273(var1, var2, 32);
            this.method2273(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2273(var1, var2, 1);
            this.method2273(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2273(var1, var2, 4);
            this.method2273(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2273(var1, var2, 16);
            this.method2273(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2273(var1, var2, 64);
            this.method2273(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2273(var1, var2, 130);
            this.method2273(var1 - 1, var2, 8);
            this.method2273(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2273(var1, var2, 10);
            this.method2273(var1, var2 + 1, 32);
            this.method2273(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2273(var1, var2, 40);
            this.method2273(var1 + 1, var2, 128);
            this.method2273(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2273(var1, var2, 160);
            this.method2273(var1, var2 - 1, 2);
            this.method2273(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2273(var1, var2, 65536);
               this.method2273(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2273(var1, var2, 1024);
               this.method2273(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2273(var1, var2, 4096);
               this.method2273(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2273(var1, var2, 16384);
               this.method2273(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2273(var1, var2, 512);
               this.method2273(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2273(var1, var2, 2048);
               this.method2273(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2273(var1, var2, 8192);
               this.method2273(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2273(var1, var2, '耀');
               this.method2273(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2273(var1, var2, 66560);
               this.method2273(var1 - 1, var2, 4096);
               this.method2273(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2273(var1, var2, 5120);
               this.method2273(var1, var2 + 1, 16384);
               this.method2273(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2273(var1, var2, 20480);
               this.method2273(var1 + 1, var2, 65536);
               this.method2273(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2273(var1, var2, 81920);
               this.method2273(var1, var2 - 1, 1024);
               this.method2273(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1325680262"
   )
   public void method2255(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-506391229"
   )
   public void method2258(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "1990433516"
   )
   public void method2262(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
                  this.method2281(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "4"
   )
   public void method2263(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2281(var1, var2, 128);
            this.method2281(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2281(var1, var2, 2);
            this.method2281(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2281(var1, var2, 8);
            this.method2281(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2281(var1, var2, 32);
            this.method2281(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2281(var1, var2, 1);
            this.method2281(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2281(var1, var2, 4);
            this.method2281(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2281(var1, var2, 16);
            this.method2281(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2281(var1, var2, 64);
            this.method2281(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2281(var1, var2, 130);
            this.method2281(var1 - 1, var2, 8);
            this.method2281(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2281(var1, var2, 10);
            this.method2281(var1, var2 + 1, 32);
            this.method2281(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2281(var1, var2, 40);
            this.method2281(var1 + 1, var2, 128);
            this.method2281(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2281(var1, var2, 160);
            this.method2281(var1, var2 - 1, 2);
            this.method2281(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2281(var1, var2, 65536);
               this.method2281(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2281(var1, var2, 1024);
               this.method2281(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2281(var1, var2, 4096);
               this.method2281(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2281(var1, var2, 16384);
               this.method2281(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2281(var1, var2, 512);
               this.method2281(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2281(var1, var2, 2048);
               this.method2281(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2281(var1, var2, 8192);
               this.method2281(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2281(var1, var2, '耀');
               this.method2281(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2281(var1, var2, 66560);
               this.method2281(var1 - 1, var2, 4096);
               this.method2281(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2281(var1, var2, 5120);
               this.method2281(var1, var2 + 1, 16384);
               this.method2281(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2281(var1, var2, 20480);
               this.method2281(var1 + 1, var2, 65536);
               this.method2281(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2281(var1, var2, 81920);
               this.method2281(var1, var2 - 1, 1024);
               this.method2281(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2040980934"
   )
   void method2273(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-1889804868"
   )
   static final String[] method2275(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lclass190;",
      garbageValue = "335380860"
   )
   public static class190 method2279(int var0) {
      class190 var1 = (class190)class190.field2793.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class190.field2789.getConfigData(19, var0);
         var1 = new class190();
         if(var2 != null) {
            var1.method3454(new Buffer(var2));
         }

         class190.field2793.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-93"
   )
   void method2281(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }
}
