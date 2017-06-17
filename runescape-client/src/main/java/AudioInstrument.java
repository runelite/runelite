import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dv")
@Implements("AudioInstrument")
public class AudioInstrument {
   @ObfuscatedName("i")
   AudioEnvelope field1723;
   @ObfuscatedName("m")
   AudioEnvelope field1724;
   @ObfuscatedName("e")
   AudioEnvelope field1725;
   @ObfuscatedName("v")
   int field1726;
   @ObfuscatedName("w")
   AudioEnvelope field1727;
   @ObfuscatedName("z")
   AudioEnvelope field1728;
   @ObfuscatedName("p")
   AudioEnvelope field1729;
   @ObfuscatedName("o")
   int[] field1730;
   @ObfuscatedName("f")
   int[] field1731;
   @ObfuscatedName("s")
   int field1732;
   @ObfuscatedName("c")
   @Export("oscillatorPitch")
   int[] oscillatorPitch;
   @ObfuscatedName("t")
   AudioEnvelope field1734;
   @ObfuscatedName("n")
   int field1735;
   @ObfuscatedName("q")
   int field1736;
   @ObfuscatedName("g")
   AudioEnvelope field1737;
   @ObfuscatedName("j")
   AudioEnvelope field1738;
   @ObfuscatedName("u")
   static int[] field1739;
   @ObfuscatedName("k")
   static int[] field1740;
   @ObfuscatedName("r")
   static int[] field1741;
   @ObfuscatedName("l")
   static int[] field1742;
   @ObfuscatedName("d")
   static int[] field1744;
   @ObfuscatedName("x")
   static int[] field1745;
   @ObfuscatedName("b")
   static int[] field1746;
   @ObfuscatedName("a")
   SoundEffect3 field1747;
   @ObfuscatedName("y")
   static int[] field1748;

   @ObfuscatedName("p")
   final int[] method2223(int var1, int var2) {
      class183.method3344(field1740, 0, var1);
      if(var2 < 10) {
         return field1740;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1729.method1974();
         this.field1724.method1974();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1725 != null) {
            this.field1725.method1974();
            this.field1734.method1974();
            var5 = (int)((double)(this.field1725.end - this.field1725.start) * 32.768D / var3);
            var6 = (int)((double)this.field1725.start * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1727 != null) {
            this.field1727.method1974();
            this.field1728.method1974();
            var8 = (int)((double)(this.field1727.end - this.field1727.start) * 32.768D / var3);
            var9 = (int)((double)this.field1727.start * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1731[var11] != 0) {
               field1744[var11] = 0;
               field1745[var11] = (int)((double)this.field1730[var11] * var3);
               field1746[var11] = (this.field1731[var11] << 14) / 100;
               field1748[var11] = (int)((double)(this.field1729.end - this.field1729.start) * 32.768D * Math.pow(1.0057929410678534D, (double)this.oscillatorPitch[var11]) / var3);
               field1739[var11] = (int)((double)this.field1729.start * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1729.method1975(var1);
            var13 = this.field1724.method1975(var1);
            if(this.field1725 != null) {
               var14 = this.field1725.method1975(var1);
               var15 = this.field1734.method1975(var1);
               var12 += this.method2230(var7, var15, this.field1725.field1650) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1727 != null) {
               var14 = this.field1727.method1975(var1);
               var15 = this.field1728.method1975(var1);
               var13 = var13 * ((this.method2230(var10, var15, this.field1727.field1650) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1731[var14] != 0) {
                  var15 = var11 + field1745[var14];
                  if(var15 < var1) {
                     field1740[var15] += this.method2230(field1744[var14], var13 * field1746[var14] >> 15, this.field1729.field1650);
                     field1744[var14] += (var12 * field1748[var14] >> 16) + field1739[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1738 != null) {
            this.field1738.method1974();
            this.field1723.method1974();
            var11 = 0;
            boolean var17 = false;
            boolean var18 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1738.method1975(var1);
               var16 = this.field1723.method1975(var1);
               if(var18) {
                  var12 = this.field1738.start + ((this.field1738.end - this.field1738.start) * var15 >> 8);
               } else {
                  var12 = this.field1738.start + ((this.field1738.end - this.field1738.start) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var18 = !var18;
               }

               if(var18) {
                  field1740[var14] = 0;
               }
            }
         }

         if(this.field1736 > 0 && this.field1735 > 0) {
            var11 = (int)((double)this.field1736 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1740[var12] += field1740[var12 - var11] * this.field1735 / 100;
            }
         }

         if(this.field1747.field1711[0] > 0 || this.field1747.field1711[1] > 0) {
            this.field1737.method1974();
            var11 = this.field1737.method1975(var1 + 1);
            var12 = this.field1747.method2182(0, (float)var11 / 65536.0F);
            var13 = this.field1747.method2182(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var19;
               while(var14 < var15) {
                  var16 = (int)((long)field1740[var14 + var12] * (long)SoundEffect3.field1704 >> 16);

                  for(var19 = 0; var19 < var12; ++var19) {
                     var16 += (int)((long)field1740[var14 + var12 - 1 - var19] * (long)SoundEffect3.field1706[0][var19] >> 16);
                  }

                  for(var19 = 0; var19 < var14; ++var19) {
                     var16 -= (int)((long)field1740[var14 - 1 - var19] * (long)SoundEffect3.field1706[1][var19] >> 16);
                  }

                  field1740[var14] = var16;
                  var11 = this.field1737.method1975(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var20;
                  while(var14 < var15) {
                     var19 = (int)((long)field1740[var14 + var12] * (long)SoundEffect3.field1704 >> 16);

                     for(var20 = 0; var20 < var12; ++var20) {
                        var19 += (int)((long)field1740[var14 + var12 - 1 - var20] * (long)SoundEffect3.field1706[0][var20] >> 16);
                     }

                     for(var20 = 0; var20 < var13; ++var20) {
                        var19 -= (int)((long)field1740[var14 - 1 - var20] * (long)SoundEffect3.field1706[1][var20] >> 16);
                     }

                     field1740[var14] = var19;
                     var11 = this.field1737.method1975(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var19 = 0;

                        for(var20 = var14 + var12 - var1; var20 < var12; ++var20) {
                           var19 += (int)((long)field1740[var14 + var12 - 1 - var20] * (long)SoundEffect3.field1706[0][var20] >> 16);
                        }

                        for(var20 = 0; var20 < var13; ++var20) {
                           var19 -= (int)((long)field1740[var14 - 1 - var20] * (long)SoundEffect3.field1706[1][var20] >> 16);
                        }

                        field1740[var14] = var19;
                        this.field1737.method1975(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1747.method2182(0, (float)var11 / 65536.0F);
                  var13 = this.field1747.method2182(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1740[var11] < -32768) {
               field1740[var11] = -32768;
            }

            if(field1740[var11] > 32767) {
               field1740[var11] = 32767;
            }
         }

         return field1740;
      }
   }

   @ObfuscatedName("e")
   final void method2225(Buffer var1) {
      this.field1729 = new AudioEnvelope();
      this.field1729.method1972(var1);
      this.field1724 = new AudioEnvelope();
      this.field1724.method1972(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1725 = new AudioEnvelope();
         this.field1725.method1972(var1);
         this.field1734 = new AudioEnvelope();
         this.field1734.method1972(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1727 = new AudioEnvelope();
         this.field1727.method1972(var1);
         this.field1728 = new AudioEnvelope();
         this.field1728.method1972(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1738 = new AudioEnvelope();
         this.field1738.method1972(var1);
         this.field1723 = new AudioEnvelope();
         this.field1723.method1972(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method3046();
         if(var4 == 0) {
            break;
         }

         this.field1731[var3] = var4;
         this.oscillatorPitch[var3] = var1.readShortSmart();
         this.field1730[var3] = var1.method3046();
      }

      this.field1736 = var1.method3046();
      this.field1735 = var1.method3046();
      this.field1726 = var1.readUnsignedShort();
      this.field1732 = var1.readUnsignedShort();
      this.field1747 = new SoundEffect3();
      this.field1737 = new AudioEnvelope();
      this.field1747.method2196(var1, this.field1737);
   }

   AudioInstrument() {
      this.field1731 = new int[]{0, 0, 0, 0, 0};
      this.oscillatorPitch = new int[]{0, 0, 0, 0, 0};
      this.field1730 = new int[]{0, 0, 0, 0, 0};
      this.field1736 = 0;
      this.field1735 = 100;
      this.field1726 = 500;
      this.field1732 = 0;
   }

   @ObfuscatedName("m")
   final int method2230(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1742[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1741[var1 / 2607 & 32767] * var2:0)));
   }

   static {
      field1741 = new int['耀'];
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1741[var1] = (var0.nextInt() & 2) - 1;
      }

      field1742 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1742[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1740 = new int[220500];
      field1744 = new int[5];
      field1745 = new int[5];
      field1746 = new int[5];
      field1748 = new int[5];
      field1739 = new int[5];
   }
}
