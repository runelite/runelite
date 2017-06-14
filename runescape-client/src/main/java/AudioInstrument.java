import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dw")
@Implements("AudioInstrument")
public class AudioInstrument {
   @ObfuscatedName("z")
   AudioEnvelope field1731;
   @ObfuscatedName("p")
   AudioEnvelope field1732;
   @ObfuscatedName("e")
   int[] field1733;
   @ObfuscatedName("j")
   AudioEnvelope field1734;
   @ObfuscatedName("f")
   AudioEnvelope field1735;
   @ObfuscatedName("c")
   AudioEnvelope field1736;
   @ObfuscatedName("n")
   AudioEnvelope field1737;
   @ObfuscatedName("i")
   AudioEnvelope field1738;
   @ObfuscatedName("g")
   @Export("oscillatorPitch")
   int[] oscillatorPitch;
   @ObfuscatedName("m")
   AudioEnvelope field1741;
   @ObfuscatedName("o")
   int field1742;
   @ObfuscatedName("x")
   int field1743;
   @ObfuscatedName("a")
   SoundEffect3 field1744;
   @ObfuscatedName("y")
   AudioEnvelope field1745;
   @ObfuscatedName("r")
   int field1746;
   @ObfuscatedName("b")
   int field1747;
   @ObfuscatedName("s")
   static int[] field1748;
   @ObfuscatedName("v")
   static int[] field1749;
   @ObfuscatedName("t")
   static int[] field1750;
   @ObfuscatedName("h")
   int[] field1751;
   @ObfuscatedName("l")
   static int[] field1752;
   @ObfuscatedName("q")
   static int[] field1753;
   @ObfuscatedName("k")
   static int[] field1754;
   @ObfuscatedName("d")
   static int[] field1755;
   @ObfuscatedName("u")
   static int[] field1756;

   @ObfuscatedName("n")
   final int[] method2322(int var1, int var2) {
      class183.method3442(field1748, 0, var1);
      if(var2 < 10) {
         return field1748;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1737.method2062();
         this.field1732.method2062();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1738 != null) {
            this.field1738.method2062();
            this.field1734.method2062();
            var5 = (int)((double)(this.field1738.end - this.field1738.start) * 32.768D / var3);
            var6 = (int)((double)this.field1738.start * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1735 != null) {
            this.field1735.method2062();
            this.field1741.method2062();
            var8 = (int)((double)(this.field1735.end - this.field1735.start) * 32.768D / var3);
            var9 = (int)((double)this.field1735.start * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1751[var11] != 0) {
               field1752[var11] = 0;
               field1753[var11] = (int)((double)this.field1733[var11] * var3);
               field1754[var11] = (this.field1751[var11] << 14) / 100;
               field1755[var11] = (int)((double)(this.field1737.end - this.field1737.start) * 32.768D * Math.pow(1.0057929410678534D, (double)this.oscillatorPitch[var11]) / var3);
               field1756[var11] = (int)((double)this.field1737.start * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1737.method2063(var1);
            var13 = this.field1732.method2063(var1);
            if(this.field1738 != null) {
               var14 = this.field1738.method2063(var1);
               var15 = this.field1734.method2063(var1);
               var12 += this.method2327(var7, var15, this.field1738.field1660) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1735 != null) {
               var14 = this.field1735.method2063(var1);
               var15 = this.field1741.method2063(var1);
               var13 = var13 * ((this.method2327(var10, var15, this.field1735.field1660) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1751[var14] != 0) {
                  var15 = var11 + field1753[var14];
                  if(var15 < var1) {
                     field1748[var15] += this.method2327(field1752[var14], var13 * field1754[var14] >> 15, this.field1737.field1660);
                     field1752[var14] += (var12 * field1755[var14] >> 16) + field1756[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1736 != null) {
            this.field1736.method2062();
            this.field1731.method2062();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1736.method2063(var1);
               var16 = this.field1731.method2063(var1);
               if(var20) {
                  var12 = this.field1736.start + ((this.field1736.end - this.field1736.start) * var15 >> 8);
               } else {
                  var12 = this.field1736.start + ((this.field1736.end - this.field1736.start) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1748[var14] = 0;
               }
            }
         }

         if(this.field1742 > 0 && this.field1743 > 0) {
            var11 = (int)((double)this.field1742 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1748[var12] += field1748[var12 - var11] * this.field1743 / 100;
            }
         }

         if(this.field1744.field1713[0] > 0 || this.field1744.field1713[1] > 0) {
            this.field1745.method2062();
            var11 = this.field1745.method2063(var1 + 1);
            var12 = this.field1744.method2284(0, (float)var11 / 65536.0F);
            var13 = this.field1744.method2284(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1748[var14 + var12] * (long)SoundEffect3.field1719 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1748[var14 + var12 - 1 - var17] * (long)SoundEffect3.field1721[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1748[var14 - 1 - var17] * (long)SoundEffect3.field1721[1][var17] >> 16);
                  }

                  field1748[var14] = var16;
                  var11 = this.field1745.method2063(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1748[var14 + var12] * (long)SoundEffect3.field1719 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1748[var14 + var12 - 1 - var18] * (long)SoundEffect3.field1721[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1748[var14 - 1 - var18] * (long)SoundEffect3.field1721[1][var18] >> 16);
                     }

                     field1748[var14] = var17;
                     var11 = this.field1745.method2063(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1748[var14 + var12 - 1 - var18] * (long)SoundEffect3.field1721[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1748[var14 - 1 - var18] * (long)SoundEffect3.field1721[1][var18] >> 16);
                        }

                        field1748[var14] = var17;
                        this.field1745.method2063(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1744.method2284(0, (float)var11 / 65536.0F);
                  var13 = this.field1744.method2284(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1748[var11] < -32768) {
               field1748[var11] = -32768;
            }

            if(field1748[var11] > 32767) {
               field1748[var11] = 32767;
            }
         }

         return field1748;
      }
   }

   @ObfuscatedName("i")
   final void method2325(Buffer var1) {
      this.field1737 = new AudioEnvelope();
      this.field1737.method2060(var1);
      this.field1732 = new AudioEnvelope();
      this.field1732.method2060(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1738 = new AudioEnvelope();
         this.field1738.method2060(var1);
         this.field1734 = new AudioEnvelope();
         this.field1734.method2060(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1735 = new AudioEnvelope();
         this.field1735.method2060(var1);
         this.field1741 = new AudioEnvelope();
         this.field1741.method2060(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1736 = new AudioEnvelope();
         this.field1736.method2060(var1);
         this.field1731 = new AudioEnvelope();
         this.field1731.method2060(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method3172();
         if(var4 == 0) {
            break;
         }

         this.field1751[var3] = var4;
         this.oscillatorPitch[var3] = var1.readShortSmart();
         this.field1733[var3] = var1.method3172();
      }

      this.field1742 = var1.method3172();
      this.field1743 = var1.method3172();
      this.field1746 = var1.readUnsignedShort();
      this.field1747 = var1.readUnsignedShort();
      this.field1744 = new SoundEffect3();
      this.field1745 = new AudioEnvelope();
      this.field1744.method2285(var1, this.field1745);
   }

   static {
      field1749 = new int['耀'];
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1749[var1] = (var0.nextInt() & 2) - 1;
      }

      field1750 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1750[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1748 = new int[220500];
      field1752 = new int[5];
      field1753 = new int[5];
      field1754 = new int[5];
      field1755 = new int[5];
      field1756 = new int[5];
   }

   @ObfuscatedName("p")
   final int method2327(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1750[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1749[var1 / 2607 & 32767] * var2:0)));
   }

   AudioInstrument() {
      this.field1751 = new int[]{0, 0, 0, 0, 0};
      this.oscillatorPitch = new int[]{0, 0, 0, 0, 0};
      this.field1733 = new int[]{0, 0, 0, 0, 0};
      this.field1742 = 0;
      this.field1743 = 100;
      this.field1746 = 500;
      this.field1747 = 0;
   }
}
