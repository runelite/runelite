import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -29389011
   )
   @Export("x")
   int x;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1516225475
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1894624443
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -514910083
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1199754801
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("w")
   public static short[][] field1321;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1516358795"
   )
   static final void method1565(int var0) {
      short var1 = 256;
      class41.field856 += var0 * 128;
      int var2;
      if(class41.field856 > Friend.field159.length) {
         class41.field856 -= Friend.field159.length;
         var2 = (int)(Math.random() * 12.0D);
         class10.method138(class41.field837[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class25.field603[var3 + var2] - Friend.field159[class41.field856 + var2 & Friend.field159.length - 1] * var0 / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class25.field603[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class25.field603[var6 + var7] = 255;
            } else {
               class25.field603[var7 + var6] = 0;
            }
         }
      }

      if(class41.field845 > 0) {
         class41.field845 -= var0 * 4;
      }

      if(class41.field846 > 0) {
         class41.field846 -= var0 * 4;
      }

      if(class41.field845 == 0 && class41.field846 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class41.field845 = 1024;
         }

         if(var5 == 1) {
            class41.field846 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class41.field843[var5] = class41.field843[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class41.field843[var5] = (int)(Math.sin((double)class41.field850 / 14.0D) * 16.0D + Math.sin((double)class41.field850 / 15.0D) * 14.0D + Math.sin((double)class41.field850 / 16.0D) * 12.0D);
         ++class41.field850;
      }

      class41.field844 += var0;
      var5 = ((Client.gameCycle & 1) + var0) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class41.field844 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class25.field603[(var8 << 7) + var7] = 192;
         }

         class41.field844 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var5 + var9 < 128) {
                  var7 += class25.field603[var5 + var8 + var9];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class25.field603[var9 + var8 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  MessageNode.field249[var9 + var8] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var5 + var8 < var1) {
                  var7 += MessageNode.field249[var5 * 128 + var9 + var6];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= MessageNode.field249[var9 + var6 - (var5 + 1) * 128];
               }

               if(var8 >= 0) {
                  class25.field603[var9 + var6] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("qv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "456625709"
   )
   protected static final void method1566() {
      FaceNormal.field1590.vmethod2090();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field1791[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field1795[var0] = 0L;
      }

      FaceNormal.field1583 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "-1377566805"
   )
   static void method1567(Sequence var0, int var1, int var2, int var3) {
      if(Client.field545 < 50 && Client.field544 != 0 && var0.field3063 != null && var1 < var0.field3063.length) {
         int var4 = var0.field3063[var1];
         if(var4 != 0) {
            int var5 = var4 >> 8;
            int var6 = var4 >> 4 & 7;
            int var7 = var4 & 15;
            Client.field546[Client.field545] = var5;
            Client.field547[Client.field545] = var6;
            Client.field334[Client.field545] = 0;
            Client.field550[Client.field545] = null;
            int var8 = (var2 - 64) / 128;
            int var9 = (var3 - 64) / 128;
            Client.field464[Client.field545] = var7 + (var9 << 8) + (var8 << 16);
            ++Client.field545;
         }
      }

   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-1207671307"
   )
   static final boolean method1568(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field355 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field509.method3228(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field509.method3202(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field509.method3203(false);
         }

         if(var1 == 325) {
            Client.field509.method3203(true);
         }

         if(var1 == 326) {
            Client.secretCipherBuffer1.putOpcode(5);
            Client.field509.method3204(Client.secretCipherBuffer1);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "-470890791"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3071.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         IndexDataBase var2 = Sequence.field3078;
         IndexDataBase var3 = class5.field55;
         boolean var4 = true;
         int[] var5 = var2.method3345(var0);

         for(int var6 = 0; var6 < var5.length; ++var6) {
            byte[] var7 = var2.method3371(var0, var5[var6]);
            if(var7 == null) {
               var4 = false;
            } else {
               int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
               byte[] var9 = var3.method3371(var8, 0);
               if(var9 == null) {
                  var4 = false;
               }
            }
         }

         Frames var11;
         if(!var4) {
            var11 = null;
         } else {
            try {
               var11 = new Frames(var2, var3, var0, false);
            } catch (Exception var10) {
               var11 = null;
            }
         }

         if(var11 != null) {
            Sequence.field3071.put(var11, (long)var0);
         }

         return var11;
      }
   }
}
