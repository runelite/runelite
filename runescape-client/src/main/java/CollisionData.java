import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
@Implements("CollisionData")
public class CollisionData {
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -554011319
   )
   @Export("x")
   public int x;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -767477007
   )
   @Export("width")
   int width;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1077067019
   )
   @Export("height")
   int height;
   @ObfuscatedName("ar")
   @Export("flags")
   public int[][] flags;
   @ObfuscatedName("b")
   static class103 field2276;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1394829419
   )
   @Export("y")
   public int y;
   @ObfuscatedName("ki")
   @ObfuscatedGetter(
      intValue = -854487207
   )
   static int field2278;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-51"
   )
   public void method3072(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 262144;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-60"
   )
   public void method3073() {
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
      this.method3073();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1799702276"
   )
   public void method3074(int var1, int var2, int var3, int var4, boolean var5) {
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
                  this.method3077(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-443520061"
   )
   public void method3075(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] |= 2097152;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-65343400"
   )
   void method3077(int var1, int var2, int var3) {
      this.flags[var1][var2] |= var3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1779808077"
   )
   public void method3078(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method3080(var1, var2, 128);
            this.method3080(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method3080(var1, var2, 2);
            this.method3080(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method3080(var1, var2, 8);
            this.method3080(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method3080(var1, var2, 32);
            this.method3080(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method3080(var1, var2, 1);
            this.method3080(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method3080(var1, var2, 4);
            this.method3080(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method3080(var1, var2, 16);
            this.method3080(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method3080(var1, var2, 64);
            this.method3080(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method3080(var1, var2, 130);
            this.method3080(var1 - 1, var2, 8);
            this.method3080(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method3080(var1, var2, 10);
            this.method3080(var1, var2 + 1, 32);
            this.method3080(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method3080(var1, var2, 40);
            this.method3080(var1 + 1, var2, 128);
            this.method3080(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method3080(var1, var2, 160);
            this.method3080(var1, var2 - 1, 2);
            this.method3080(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method3080(var1, var2, 65536);
               this.method3080(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method3080(var1, var2, 1024);
               this.method3080(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method3080(var1, var2, 4096);
               this.method3080(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method3080(var1, var2, 16384);
               this.method3080(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method3080(var1, var2, 512);
               this.method3080(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method3080(var1, var2, 2048);
               this.method3080(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method3080(var1, var2, 8192);
               this.method3080(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method3080(var1, var2, '耀');
               this.method3080(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method3080(var1, var2, 66560);
               this.method3080(var1 - 1, var2, 4096);
               this.method3080(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method3080(var1, var2, 5120);
               this.method3080(var1, var2 + 1, 16384);
               this.method3080(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method3080(var1, var2, 20480);
               this.method3080(var1 + 1, var2, 65536);
               this.method3080(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method3080(var1, var2, 81920);
               this.method3080(var1, var2 - 1, 1024);
               this.method3080(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-73"
   )
   public void method3079(int var1, int var2) {
      var1 -= this.x;
      var2 -= this.y;
      this.flags[var1][var2] &= -262145;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1468302457"
   )
   void method3080(int var1, int var2, int var3) {
      this.flags[var1][var2] &= ~var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)V",
      garbageValue = "-90"
   )
   public void method3088(int var1, int var2, int var3, int var4, int var5, boolean var6) {
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
                  this.method3080(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-979128395"
   )
   static final void method3094(String var0) {
      if(var0 != null) {
         String var1 = class27.method214(var0, class30.field423);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.friendCount; ++var2) {
               Friend var3 = Client.friends[var2];
               String var4 = var3.name;
               String var5 = class27.method214(var4, class30.field423);
               boolean var6;
               if(var0 != null && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.friendCount;

                  for(int var7 = var2; var7 < Client.friendCount; ++var7) {
                     Client.friends[var7] = Client.friends[var7 + 1];
                  }

                  Client.field1083 = Client.field1075;
                  Client.secretPacketBuffer1.putOpcode(61);
                  Client.secretPacketBuffer1.putByte(class46.method711(var0));
                  Client.secretPacketBuffer1.method3191(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "-78"
   )
   public void method3100(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.x;
      var2 -= this.y;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method3077(var1, var2, 128);
            this.method3077(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method3077(var1, var2, 2);
            this.method3077(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method3077(var1, var2, 8);
            this.method3077(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method3077(var1, var2, 32);
            this.method3077(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method3077(var1, var2, 1);
            this.method3077(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method3077(var1, var2, 4);
            this.method3077(var1 + 1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method3077(var1, var2, 16);
            this.method3077(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method3077(var1, var2, 64);
            this.method3077(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method3077(var1, var2, 130);
            this.method3077(var1 - 1, var2, 8);
            this.method3077(var1, var2 + 1, 32);
         }

         if(var4 == 1) {
            this.method3077(var1, var2, 10);
            this.method3077(var1, var2 + 1, 32);
            this.method3077(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method3077(var1, var2, 40);
            this.method3077(var1 + 1, var2, 128);
            this.method3077(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method3077(var1, var2, 160);
            this.method3077(var1, var2 - 1, 2);
            this.method3077(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method3077(var1, var2, 65536);
               this.method3077(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method3077(var1, var2, 1024);
               this.method3077(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method3077(var1, var2, 4096);
               this.method3077(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method3077(var1, var2, 16384);
               this.method3077(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method3077(var1, var2, 512);
               this.method3077(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method3077(var1, var2, 2048);
               this.method3077(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method3077(var1, var2, 8192);
               this.method3077(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method3077(var1, var2, '耀');
               this.method3077(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method3077(var1, var2, 66560);
               this.method3077(var1 - 1, var2, 4096);
               this.method3077(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method3077(var1, var2, 5120);
               this.method3077(var1, var2 + 1, 16384);
               this.method3077(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method3077(var1, var2, 20480);
               this.method3077(var1 + 1, var2, 65536);
               this.method3077(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method3077(var1, var2, 81920);
               this.method3077(var1, var2 - 1, 1024);
               this.method3077(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILIndexFile;LIndexData;B)V",
      garbageValue = "96"
   )
   static void method3103(int var0, IndexFile var1, IndexData var2) {
      class233 var3 = new class233();
      var3.field3190 = 1;
      var3.hash = (long)var0;
      var3.field3192 = var1;
      var3.field3193 = var2;
      Deque var4 = class236.field3226;
      synchronized(class236.field3226) {
         class236.field3226.method3655(var3);
      }

      class172.method3183();
   }
}
