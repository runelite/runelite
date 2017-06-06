import java.util.Random;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dj")
@Implements("SoundEffect1")
public class SoundEffect1 {
   @ObfuscatedName("s")
   static int[] field1740;
   @ObfuscatedName("c")
   SoundEffect2 field1741;
   @ObfuscatedName("e")
   SoundEffect2 field1742;
   @ObfuscatedName("v")
   SoundEffect2 field1743;
   @ObfuscatedName("b")
   SoundEffect2 field1744;
   @ObfuscatedName("y")
   SoundEffect2 field1745;
   @ObfuscatedName("h")
   SoundEffect2 field1746;
   @ObfuscatedName("x")
   SoundEffect2 field1747;
   @ObfuscatedName("f")
   int[] field1748;
   @ObfuscatedName("r")
   int field1749;
   @ObfuscatedName("d")
   static int[] field1750;
   @ObfuscatedName("o")
   int field1751;
   @ObfuscatedName("n")
   int[] field1752;
   @ObfuscatedName("q")
   SoundEffect3 field1753;
   @ObfuscatedName("j")
   SoundEffect2 field1754;
   @ObfuscatedName("m")
   static int[] field1756;
   @ObfuscatedName("z")
   int field1757;
   @ObfuscatedName("k")
   int field1758;
   @ObfuscatedName("a")
   int[] field1759;
   @ObfuscatedName("l")
   static int[] field1760;
   @ObfuscatedName("w")
   static int[] field1761;
   @ObfuscatedName("p")
   static int[] field1762;
   @ObfuscatedName("i")
   SoundEffect2 field1763;
   @ObfuscatedName("u")
   static int[] field1764;
   @ObfuscatedName("t")
   static int[] field1765;

   @ObfuscatedName("c")
   final int method2304(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1740[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1750[var1 / 2607 & 32767] * var2:0)));
   }

   SoundEffect1() {
      this.field1748 = new int[]{0, 0, 0, 0, 0};
      this.field1752 = new int[]{0, 0, 0, 0, 0};
      this.field1759 = new int[]{0, 0, 0, 0, 0};
      this.field1751 = 0;
      this.field1757 = 100;
      this.field1758 = 500;
      this.field1749 = 0;
   }

   static {
      field1750 = new int['耀'];
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1750[var1] = (var0.nextInt() & 2) - 1;
      }

      field1740 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1740[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1756 = new int[220500];
      field1761 = new int[5];
      field1762 = new int[5];
      field1760 = new int[5];
      field1764 = new int[5];
      field1765 = new int[5];
   }

   @ObfuscatedName("i")
   final int[] method2310(int var1, int var2) {
      class183.method3435(field1756, 0, var1);
      if(var2 < 10) {
         return field1756;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1763.method2060();
         this.field1741.method2060();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1742 != null) {
            this.field1742.method2060();
            this.field1743.method2060();
            var5 = (int)((double)(this.field1742.field1667 - this.field1742.field1664) * 32.768D / var3);
            var6 = (int)((double)this.field1742.field1664 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1744 != null) {
            this.field1744.method2060();
            this.field1745.method2060();
            var8 = (int)((double)(this.field1744.field1667 - this.field1744.field1664) * 32.768D / var3);
            var9 = (int)((double)this.field1744.field1664 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1748[var11] != 0) {
               field1761[var11] = 0;
               field1762[var11] = (int)((double)this.field1759[var11] * var3);
               field1760[var11] = (this.field1748[var11] << 14) / 100;
               field1764[var11] = (int)((double)(this.field1763.field1667 - this.field1763.field1664) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1752[var11]) / var3);
               field1765[var11] = (int)((double)this.field1763.field1664 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1763.method2062(var1);
            var13 = this.field1741.method2062(var1);
            if(this.field1742 != null) {
               var14 = this.field1742.method2062(var1);
               var15 = this.field1743.method2062(var1);
               var12 += this.method2304(var7, var15, this.field1742.field1668) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1744 != null) {
               var14 = this.field1744.method2062(var1);
               var15 = this.field1745.method2062(var1);
               var13 = var13 * ((this.method2304(var10, var15, this.field1744.field1668) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1748[var14] != 0) {
                  var15 = var11 + field1762[var14];
                  if(var15 < var1) {
                     field1756[var15] += this.method2304(field1761[var14], var13 * field1760[var14] >> 15, this.field1763.field1668);
                     field1761[var14] += (var12 * field1764[var14] >> 16) + field1765[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1746 != null) {
            this.field1746.method2060();
            this.field1747.method2060();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1746.method2062(var1);
               var16 = this.field1747.method2062(var1);
               if(var20) {
                  var12 = this.field1746.field1664 + ((this.field1746.field1667 - this.field1746.field1664) * var15 >> 8);
               } else {
                  var12 = this.field1746.field1664 + ((this.field1746.field1667 - this.field1746.field1664) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1756[var14] = 0;
               }
            }
         }

         if(this.field1751 > 0 && this.field1757 > 0) {
            var11 = (int)((double)this.field1751 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1756[var12] += field1756[var12 - var11] * this.field1757 / 100;
            }
         }

         if(this.field1753.field1727[0] > 0 || this.field1753.field1727[1] > 0) {
            this.field1754.method2060();
            var11 = this.field1754.method2062(var1 + 1);
            var12 = this.field1753.method2263(0, (float)var11 / 65536.0F);
            var13 = this.field1753.method2263(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1756[var14 + var12] * (long)SoundEffect3.field1729 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1756[var14 + var12 - 1 - var17] * (long)SoundEffect3.field1728[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1756[var14 - 1 - var17] * (long)SoundEffect3.field1728[1][var17] >> 16);
                  }

                  field1756[var14] = var16;
                  var11 = this.field1754.method2062(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1756[var14 + var12] * (long)SoundEffect3.field1729 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1756[var14 + var12 - 1 - var18] * (long)SoundEffect3.field1728[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1756[var14 - 1 - var18] * (long)SoundEffect3.field1728[1][var18] >> 16);
                     }

                     field1756[var14] = var17;
                     var11 = this.field1754.method2062(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1756[var14 + var12 - 1 - var18] * (long)SoundEffect3.field1728[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1756[var14 - 1 - var18] * (long)SoundEffect3.field1728[1][var18] >> 16);
                        }

                        field1756[var14] = var17;
                        this.field1754.method2062(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1753.method2263(0, (float)var11 / 65536.0F);
                  var13 = this.field1753.method2263(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1756[var11] < -32768) {
               field1756[var11] = -32768;
            }

            if(field1756[var11] > 32767) {
               field1756[var11] = 32767;
            }
         }

         return field1756;
      }
   }

   @ObfuscatedName("e")
   final void method2313(Buffer var1) {
      this.field1763 = new SoundEffect2();
      this.field1763.method2059(var1);
      this.field1741 = new SoundEffect2();
      this.field1741.method2059(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1742 = new SoundEffect2();
         this.field1742.method2059(var1);
         this.field1743 = new SoundEffect2();
         this.field1743.method2059(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1744 = new SoundEffect2();
         this.field1744.method2059(var1);
         this.field1745 = new SoundEffect2();
         this.field1745.method2059(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1746 = new SoundEffect2();
         this.field1746.method2059(var1);
         this.field1747 = new SoundEffect2();
         this.field1747.method2059(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method3154();
         if(var4 == 0) {
            break;
         }

         this.field1748[var3] = var4;
         this.field1752[var3] = var1.readShortSmart();
         this.field1759[var3] = var1.method3154();
      }

      this.field1751 = var1.method3154();
      this.field1757 = var1.method3154();
      this.field1758 = var1.readUnsignedShort();
      this.field1749 = var1.readUnsignedShort();
      this.field1753 = new SoundEffect3();
      this.field1754 = new SoundEffect2();
      this.field1753.method2262(var1, this.field1754);
   }
}
