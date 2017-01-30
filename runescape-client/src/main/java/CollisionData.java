import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -220967521
   )
   @Export("y")
   public int y = 0;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1311999483
   )
   @Export("x")
   public int x = 0;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 896428755
   )
   @Export("width")
   int width;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1268564205
   )
   @Export("height")
   int height;
   @ObfuscatedName("av")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("b")
   static int[] field1841;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "833082922"
   )
   public void method2254(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2258(var1, var2, 128);
            this.method2258(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2258(var1, var2, 2);
            this.method2258(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2258(var1, var2, 8);
            this.method2258(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2258(var1, var2, 32);
            this.method2258(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2258(var1, var2, 1);
            this.method2258(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2258(var1, var2, 4);
            this.method2258(var1 + 1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2258(var1, var2, 16);
            this.method2258(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2258(var1, var2, 64);
            this.method2258(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2258(var1, var2, 130);
            this.method2258(var1 - 1, var2, 8);
            this.method2258(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2258(var1, var2, 10);
            this.method2258(var1, 1 + var2, 32);
            this.method2258(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2258(var1, var2, 40);
            this.method2258(var1 + 1, var2, 128);
            this.method2258(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2258(var1, var2, 160);
            this.method2258(var1, var2 - 1, 2);
            this.method2258(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2258(var1, var2, 65536);
               this.method2258(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2258(var1, var2, 1024);
               this.method2258(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2258(var1, var2, 4096);
               this.method2258(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2258(var1, var2, 16384);
               this.method2258(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2258(var1, var2, 512);
               this.method2258(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2258(var1, var2, 2048);
               this.method2258(1 + var1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2258(var1, var2, 8192);
               this.method2258(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2258(var1, var2, '耀');
               this.method2258(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2258(var1, var2, 66560);
               this.method2258(var1 - 1, var2, 4096);
               this.method2258(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2258(var1, var2, 5120);
               this.method2258(var1, 1 + var2, 16384);
               this.method2258(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2258(var1, var2, 20480);
               this.method2258(1 + var1, var2, 65536);
               this.method2258(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2258(var1, var2, 81920);
               this.method2258(var1, var2 - 1, 1024);
               this.method2258(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "0"
   )
   public void method2255(int var1, int var2, int var3, int var4, boolean var5) {
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
                  this.method2258(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-412716743"
   )
   public void method2256(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1033620142"
   )
   public void method2257(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "940154381"
   )
   void method2258(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "105"
   )
   public void method2259(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2261(var1, var2, 128);
            this.method2261(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2261(var1, var2, 2);
            this.method2261(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2261(var1, var2, 8);
            this.method2261(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2261(var1, var2, 32);
            this.method2261(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2261(var1, var2, 1);
            this.method2261(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2261(var1, var2, 4);
            this.method2261(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2261(var1, var2, 16);
            this.method2261(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2261(var1, var2, 64);
            this.method2261(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2261(var1, var2, 130);
            this.method2261(var1 - 1, var2, 8);
            this.method2261(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method2261(var1, var2, 10);
            this.method2261(var1, 1 + var2, 32);
            this.method2261(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2261(var1, var2, 40);
            this.method2261(var1 + 1, var2, 128);
            this.method2261(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2261(var1, var2, 160);
            this.method2261(var1, var2 - 1, 2);
            this.method2261(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2261(var1, var2, 65536);
               this.method2261(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2261(var1, var2, 1024);
               this.method2261(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2261(var1, var2, 4096);
               this.method2261(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2261(var1, var2, 16384);
               this.method2261(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2261(var1, var2, 512);
               this.method2261(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2261(var1, var2, 2048);
               this.method2261(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2261(var1, var2, 8192);
               this.method2261(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2261(var1, var2, '耀');
               this.method2261(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2261(var1, var2, 66560);
               this.method2261(var1 - 1, var2, 4096);
               this.method2261(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2261(var1, var2, 5120);
               this.method2261(var1, var2 + 1, 16384);
               this.method2261(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2261(var1, var2, 20480);
               this.method2261(1 + var1, var2, 65536);
               this.method2261(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2261(var1, var2, 81920);
               this.method2261(var1, var2 - 1, 1024);
               this.method2261(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "2"
   )
   static boolean method2260(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "985325558"
   )
   void method2261(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "271802468"
   )
   public void method2264() {
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "203333030"
   )
   public void method2267(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
                  this.method2261(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-61"
   )
   public void method2269(int var1, int var2) {
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
      this.method2264();
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-782710750"
   )
   static final void method2284(String var0, boolean var1) {
      if(null != var0) {
         if((Client.ignoreCount < 100 || Client.field304 == 1) && Client.ignoreCount < 400) {
            String var2 = FrameMap.method1697(var0, FaceNormal.field1561);
            if(null != var2) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var4 = Client.ignores[var3];
                  var5 = FrameMap.method1697(var4.name, FaceNormal.field1561);
                  if(var5 != null && var5.equals(var2)) {
                     class103.sendGameMessage(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(null != var4.previousName) {
                     var6 = FrameMap.method1697(var4.previousName, FaceNormal.field1561);
                     if(var6 != null && var6.equals(var2)) {
                        class103.sendGameMessage(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var7 = Client.friends[var3];
                  var5 = FrameMap.method1697(var7.name, FaceNormal.field1561);
                  if(var5 != null && var5.equals(var2)) {
                     class103.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var7.previousName != null) {
                     var6 = FrameMap.method1697(var7.previousName, FaceNormal.field1561);
                     if(null != var6 && var6.equals(var2)) {
                        class103.sendGameMessage(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(FrameMap.method1697(class16.localPlayer.name, FaceNormal.field1561).equals(var2)) {
                  class103.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  Client.field394.method3037(83);
                  Client.field394.method2799(class37.method737(var0));
                  Client.field394.method2805(var0);
               }
            }
         } else {
            class103.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "1329419747"
   )
   public static void method2286(class182 var0) {
      class188.field2778 = var0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "662274007"
   )
   public static String method2288(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class206.field3080[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[1 + var4] & 255;
            var3.append(class206.field3080[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class206.field3080[(var6 & 15) << 2 | var7 >>> 6]).append(class206.field3080[var7 & 63]);
            } else {
               var3.append(class206.field3080[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class206.field3080[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }
}
