import java.util.Random;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
@Implements("SoundEffect1")
public class SoundEffect1 {
   @ObfuscatedName("c")
   static int[] field1711;
   @ObfuscatedName("h")
   SoundEffect2 field1712;
   @ObfuscatedName("s")
   static int[] field1713;
   @ObfuscatedName("q")
   SoundEffect2 field1714;
   @ObfuscatedName("g")
   SoundEffect2 field1715;
   @ObfuscatedName("v")
   SoundEffect2 field1716;
   @ObfuscatedName("t")
   SoundEffect2 field1717;
   @ObfuscatedName("p")
   SoundEffect2 field1718;
   @ObfuscatedName("z")
   static int[] field1720;
   @ObfuscatedName("j")
   int field1721;
   @ObfuscatedName("a")
   int[] field1722;
   @ObfuscatedName("b")
   int field1723;
   @ObfuscatedName("x")
   SoundEffect3 field1724;
   @ObfuscatedName("o")
   SoundEffect2 field1725;
   @ObfuscatedName("k")
   int[] field1726;
   @ObfuscatedName("m")
   int field1727;
   @ObfuscatedName("d")
   static int[] field1728;
   @ObfuscatedName("e")
   static int[] field1729;
   @ObfuscatedName("i")
   SoundEffect2 field1730;
   @ObfuscatedName("r")
   int field1731;
   @ObfuscatedName("y")
   static int[] field1732;
   @ObfuscatedName("w")
   static int[] field1733;
   @ObfuscatedName("f")
   static int[] field1734;
   @ObfuscatedName("u")
   SoundEffect2 field1735;
   @ObfuscatedName("l")
   int[] field1736;

   @ObfuscatedName("i")
   final int[] method2344(int var1, int var2) {
      class183.method3518(field1728, 0, var1);
      if(var2 < 10) {
         return field1728;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1730.method2105();
         this.field1712.method2105();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1735 != null) {
            this.field1735.method2105();
            this.field1714.method2105();
            var5 = (int)((double)(this.field1735.field1643 - this.field1735.field1642) * 32.768D / var3);
            var6 = (int)((double)this.field1735.field1642 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1715 != null) {
            this.field1715.method2105();
            this.field1716.method2105();
            var8 = (int)((double)(this.field1715.field1643 - this.field1715.field1642) * 32.768D / var3);
            var9 = (int)((double)this.field1715.field1642 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1736[var11] != 0) {
               field1732[var11] = 0;
               field1733[var11] = (int)((double)this.field1726[var11] * var3);
               field1734[var11] = (this.field1736[var11] << 14) / 100;
               field1711[var11] = (int)((double)(this.field1730.field1643 - this.field1730.field1642) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1722[var11]) / var3);
               field1720[var11] = (int)((double)this.field1730.field1642 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1730.method2111(var1);
            var13 = this.field1712.method2111(var1);
            if(this.field1735 != null) {
               var14 = this.field1735.method2111(var1);
               var15 = this.field1714.method2111(var1);
               var12 += this.method2350(var7, var15, this.field1735.field1644) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1715 != null) {
               var14 = this.field1715.method2111(var1);
               var15 = this.field1716.method2111(var1);
               var13 = var13 * ((this.method2350(var10, var15, this.field1715.field1644) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1736[var14] != 0) {
                  var15 = var11 + field1733[var14];
                  if(var15 < var1) {
                     field1728[var15] += this.method2350(field1732[var14], var13 * field1734[var14] >> 15, this.field1730.field1644);
                     field1732[var14] += (var12 * field1711[var14] >> 16) + field1720[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1717 != null) {
            this.field1717.method2105();
            this.field1718.method2105();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1717.method2111(var1);
               var16 = this.field1718.method2111(var1);
               if(var20) {
                  var12 = this.field1717.field1642 + ((this.field1717.field1643 - this.field1717.field1642) * var15 >> 8);
               } else {
                  var12 = this.field1717.field1642 + ((this.field1717.field1643 - this.field1717.field1642) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1728[var14] = 0;
               }
            }
         }

         if(this.field1731 > 0 && this.field1723 > 0) {
            var11 = (int)((double)this.field1731 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1728[var12] += field1728[var12 - var11] * this.field1723 / 100;
            }
         }

         if(this.field1724.field1691[0] > 0 || this.field1724.field1691[1] > 0) {
            this.field1725.method2105();
            var11 = this.field1725.method2111(var1 + 1);
            var12 = this.field1724.method2318(0, (float)var11 / 65536.0F);
            var13 = this.field1724.method2318(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1728[var14 + var12] * (long)SoundEffect3.field1699 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1728[var14 + var12 - 1 - var17] * (long)SoundEffect3.field1696[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1728[var14 - 1 - var17] * (long)SoundEffect3.field1696[1][var17] >> 16);
                  }

                  field1728[var14] = var16;
                  var11 = this.field1725.method2111(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1728[var14 + var12] * (long)SoundEffect3.field1699 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1728[var14 + var12 - 1 - var18] * (long)SoundEffect3.field1696[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1728[var14 - 1 - var18] * (long)SoundEffect3.field1696[1][var18] >> 16);
                     }

                     field1728[var14] = var17;
                     var11 = this.field1725.method2111(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1728[var14 + var12 - 1 - var18] * (long)SoundEffect3.field1696[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1728[var14 - 1 - var18] * (long)SoundEffect3.field1696[1][var18] >> 16);
                        }

                        field1728[var14] = var17;
                        this.field1725.method2111(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1724.method2318(0, (float)var11 / 65536.0F);
                  var13 = this.field1724.method2318(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1728[var11] < -32768) {
               field1728[var11] = -32768;
            }

            if(field1728[var11] > 32767) {
               field1728[var11] = 32767;
            }
         }

         return field1728;
      }
   }

   static {
      field1729 = new int['耀'];
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1729[var1] = (var0.nextInt() & 2) - 1;
      }

      field1713 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1713[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1728 = new int[220500];
      field1732 = new int[5];
      field1733 = new int[5];
      field1734 = new int[5];
      field1711 = new int[5];
      field1720 = new int[5];
   }

   @ObfuscatedName("u")
   final void method2345(Buffer var1) {
      this.field1730 = new SoundEffect2();
      this.field1730.method2103(var1);
      this.field1712 = new SoundEffect2();
      this.field1712.method2103(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1735 = new SoundEffect2();
         this.field1735.method2103(var1);
         this.field1714 = new SoundEffect2();
         this.field1714.method2103(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1715 = new SoundEffect2();
         this.field1715.method2103(var1);
         this.field1716 = new SoundEffect2();
         this.field1716.method2103(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1717 = new SoundEffect2();
         this.field1717.method2103(var1);
         this.field1718 = new SoundEffect2();
         this.field1718.method2103(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method3212();
         if(var4 == 0) {
            break;
         }

         this.field1736[var3] = var4;
         this.field1722[var3] = var1.readShortSmart();
         this.field1726[var3] = var1.method3212();
      }

      this.field1731 = var1.method3212();
      this.field1723 = var1.method3212();
      this.field1721 = var1.readUnsignedShort();
      this.field1727 = var1.readUnsignedShort();
      this.field1724 = new SoundEffect3();
      this.field1725 = new SoundEffect2();
      this.field1724.method2307(var1, this.field1725);
   }

   SoundEffect1() {
      this.field1736 = new int[]{0, 0, 0, 0, 0};
      this.field1722 = new int[]{0, 0, 0, 0, 0};
      this.field1726 = new int[]{0, 0, 0, 0, 0};
      this.field1731 = 0;
      this.field1723 = 100;
      this.field1721 = 500;
      this.field1727 = 0;
   }

   @ObfuscatedName("h")
   final int method2350(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1713[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1729[var1 / 2607 & 32767] * var2:0)));
   }
}
