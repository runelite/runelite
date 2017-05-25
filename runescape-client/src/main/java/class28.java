import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public abstract class class28 {
   @ObfuscatedName("p")
   short[][][] field403;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1386101547
   )
   int field404;
   @ObfuscatedName("t")
   short[][][] field405;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2095406667
   )
   int field406;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1749480755
   )
   int field407;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 346323063
   )
   int field408;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -984028433
   )
   int field409;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1346458601
   )
   int field410;
   @ObfuscatedName("l")
   byte[][][] field411;
   @ObfuscatedName("a")
   byte[][][] field412;
   @ObfuscatedName("k")
   class31[][][][] field413;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-1667720897"
   )
   static File method215(String var0) {
      if(!class157.field2236) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class157.field2235.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class157.field2234, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class157.field2235.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IILBuffer;II)V",
      garbageValue = "627486071"
   )
   void method217(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field403[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field405[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IILBuffer;II)V",
      garbageValue = "1527758461"
   )
   void method218(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field405[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var14 = var3.readUnsignedByte();
            if(var14 != 0) {
               this.field403[var9][var1][var2] = (short)var14;
               var11 = var3.readUnsignedByte();
               this.field411[var9][var1][var2] = (byte)(var11 >> 2);
               this.field412[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var10 = this.field413[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3214();
                  int var13 = var3.readUnsignedByte();
                  var10[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILBuffer;B)V",
      garbageValue = "61"
   )
   void method219(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method217(var1, var2, var3, var4);
         } else {
            this.method218(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2091183434"
   )
   int method220() {
      return this.field407;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1825138465"
   )
   int method221() {
      return this.field406;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1280816886"
   )
   int method222(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field405[0][var1][var2] - 1:-1):-1;
   }

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-237027570"
   )
   static int method236(int var0, Script var1, boolean var2) {
      if(var0 == 5306) {
         class83.intStack[++class83.intStackSize - 1] = class4.method8();
         return 1;
      } else {
         int var3;
         if(var0 == 5307) {
            var3 = class83.intStack[--class83.intStackSize];
            if(var3 == 1 || var3 == 2) {
               Client.field1103 = 0L;
               if(var3 >= 2) {
                  Client.isResized = true;
               } else {
                  Client.isResized = false;
               }

               int var4 = Client.isResized?2:1;
               if(var4 == 1) {
                  class24.field356.method841(765, 503);
               } else {
                  class24.field356.method841(7680, 2160);
               }

               if(Client.gameState >= 25) {
                  Client.secretPacketBuffer1.putOpcode(149);
                  PacketBuffer var5 = Client.secretPacketBuffer1;
                  int var6 = Client.isResized?2:1;
                  var5.putByte(var6);
                  Client.secretPacketBuffer1.putShort(class261.field3626);
                  Client.secretPacketBuffer1.putShort(class19.field320);
               }
            }

            return 1;
         } else if(var0 == 5308) {
            class83.intStack[++class83.intStackSize - 1] = class134.field1989.field1286;
            return 1;
         } else if(var0 != 5309) {
            return 2;
         } else {
            var3 = class83.intStack[--class83.intStackSize];
            if(var3 == 1 || var3 == 2) {
               class134.field1989.field1286 = var3;
               GroundObject.method2523();
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)LSpritePixels;",
      garbageValue = "46"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var4 << 40) + ((long)var2 << 38) + (long)var0 + ((long)var1 << 16);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class51.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var19 = 0; var19 < 10; ++var19) {
            if(var1 >= var9.countCo[var19] && var9.countCo[var19] != 0) {
               var10 = var9.countObj[var19];
            }
         }

         if(var10 != -1) {
            var9 = class51.getItemDefinition(var10);
         }
      }

      Model var20 = var9.getModel(1);
      if(var20 == null) {
         return null;
      } else {
         SpritePixels var11 = null;
         if(var9.notedTemplate != -1) {
            var11 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var11 == null) {
               return null;
            }
         } else if(var9.field3533 != -1) {
            var11 = createSprite(var9.field3529, var1, var2, var3, 0, false);
            if(var11 == null) {
               return null;
            }
         } else if(var9.field3535 != -1) {
            var11 = createSprite(var9.field3534, var1, 0, 0, 0, false);
            if(var11 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.method5000(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         Rasterizer2D.method5002();
         class136.method2651();
         class136.method2625(16, 16);
         class136.rasterGouraudLowRes = false;
         if(var9.field3535 != -1) {
            var11.method5207(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = var16 * class136.SINE[var9.xan2d] >> 16;
         int var18 = class136.COSINE[var9.xan2d] * var16 >> 16;
         var20.method2575();
         var20.method2552(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var20.modelHeight / 2 + var17 + var9.offsetY2d, var9.offsetY2d + var18);
         if(var9.field3533 != -1) {
            var11.method5207(0, 0);
         }

         if(var2 >= 1) {
            var8.method5184(1);
         }

         if(var2 >= 2) {
            var8.method5184(16777215);
         }

         if(var3 != 0) {
            var8.method5129(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.image, 36, 32);
         if(var9.notedTemplate != -1) {
            var11.method5207(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            ItemComposition.field3524.method4889(class177.method3455(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.method5001(var15);
         class136.method2651();
         class136.rasterGouraudLowRes = true;
         return var8;
      }
   }
}
