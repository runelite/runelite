import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class99 extends class109 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1686246831
   )
   int field1630 = 256;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1691211653
   )
   int field1631;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -4145962273242635469L
   )
   long field1632 = class9.method117();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -283183753
   )
   int field1633 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 581523307
   )
   int field1636 = 1;
   @ObfuscatedName("u")
   long[] field1637 = new long[10];

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-489141503"
   )
   public void vmethod2003() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1637[var1] = 0L;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "1"
   )
   int vmethod2004(int var1, int var2) {
      int var3 = this.field1630;
      int var4 = this.field1636;
      this.field1630 = 300;
      this.field1636 = 1;
      this.field1632 = class9.method117();
      if(this.field1637[this.field1631] == 0L) {
         this.field1630 = var3;
         this.field1636 = var4;
      } else if(this.field1632 > this.field1637[this.field1631]) {
         this.field1630 = (int)((long)(var1 * 2560) / (this.field1632 - this.field1637[this.field1631]));
      }

      if(this.field1630 < 25) {
         this.field1630 = 25;
      }

      if(this.field1630 > 256) {
         this.field1630 = 256;
         this.field1636 = (int)((long)var1 - (this.field1632 - this.field1637[this.field1631]) / 10L);
      }

      if(this.field1636 > var1) {
         this.field1636 = var1;
      }

      this.field1637[this.field1631] = this.field1632;
      this.field1631 = (this.field1631 + 1) % 10;
      int var5;
      if(this.field1636 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field1637[var5]) {
               this.field1637[var5] += (long)this.field1636;
            }
         }
      }

      if(this.field1636 < var2) {
         this.field1636 = var2;
      }

      VertexNormal.method1598((long)this.field1636);

      for(var5 = 0; this.field1633 < 256; this.field1633 += this.field1630) {
         ++var5;
      }

      this.field1633 &= 255;
      return var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1173893216"
   )
   public static int method1893() {
      return ++class115.mouseIdleTicks - 1;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "3"
   )
   static final void method1897(int var0) {
      int[] var1 = class179.field2668.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = 24628 + (103 - var3) * 2048;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class10.tileSettings[var0][var5][var3] & 24) == 0) {
               class6.region.method1704(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class10.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               class6.region.method1704(var1, var4, 512, 1 + var0, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class179.field2668.method4112();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class10.tileSettings[var0][var6][var5] & 24) == 0) {
               class116.method2222(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class10.tileSettings[1 + var0][var6][var5] & 8) != 0) {
               class116.method2222(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field362 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class6.region.method1699(class60.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = Tile.getObjectDefinition(var7).field2882;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var11 = Client.collisionMaps[class60.plane].flags;

                     for(int var12 = 0; var12 < 10; ++var12) {
                        int var13 = (int)(Math.random() * 4.0D);
                        if(var13 == 0 && var9 > 0 && var9 > var5 - 3 && (var11[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var13 == 1 && var9 < 103 && var9 < 3 + var5 && (var11[1 + var9][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var13 == 2 && var10 > 0 && var10 > var6 - 3 && (var11[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var13 == 3 && var10 < 103 && var10 < 3 + var6 && (var11[var9][var10 + 1] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  Client.field305[Client.field362] = class210.field3104[var8];
                  Client.field511[Client.field362] = var9;
                  Client.field512[Client.field362] = var10;
                  ++Client.field362;
               }
            }
         }
      }

      GameEngine.bufferProvider.method4046();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "64"
   )
   public static void method1898() {
      Widget.field2203.reset();
      Widget.field2180.reset();
      Widget.field2305.reset();
      Widget.field2199.reset();
   }

   class99() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1637[var1] = this.field1632;
      }

   }
}
