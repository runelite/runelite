import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bn")
public class class70 {
   @ObfuscatedName("y")
   class58 field1150;
   @ObfuscatedName("b")
   static int[] field1151;
   @ObfuscatedName("o")
   class58 field1152;
   @ObfuscatedName("r")
   class58 field1153;
   @ObfuscatedName("q")
   class58 field1154;
   @ObfuscatedName("j")
   class58 field1155;
   @ObfuscatedName("v")
   class67 field1156;
   @ObfuscatedName("d")
   class58 field1157;
   @ObfuscatedName("n")
   int[] field1158 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("c")
   int[] field1159 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("k")
   class58 field1160;
   @ObfuscatedName("g")
   int field1161 = 0;
   @ObfuscatedName("w")
   class58 field1162;
   @ObfuscatedName("l")
   static int[] field1163;
   @ObfuscatedName("a")
   class58 field1164;
   @ObfuscatedName("i")
   int field1165 = 100;
   @ObfuscatedName("e")
   static int[] field1166;
   @ObfuscatedName("t")
   static int[] field1167;
   @ObfuscatedName("f")
   static int[] field1168 = new int['耀'];
   @ObfuscatedName("z")
   static int[] field1169;
   @ObfuscatedName("p")
   int field1171 = 0;
   @ObfuscatedName("m")
   static int[] field1172;
   @ObfuscatedName("s")
   int[] field1173 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("h")
   int field1174 = 500;
   @ObfuscatedName("x")
   static int[] field1175;

   @ObfuscatedName("o")
   final void method1378(Buffer var1) {
      this.field1160 = new class58();
      this.field1160.method1116(var1);
      this.field1150 = new class58();
      this.field1150.method1116(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1152 = new class58();
         this.field1152.method1116(var1);
         this.field1153 = new class58();
         this.field1153.method1116(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1162 = new class58();
         this.field1162.method1116(var1);
         this.field1155 = new class58();
         this.field1155.method1116(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1154 = new class58();
         this.field1154.method1116(var1);
         this.field1157 = new class58();
         this.field1157.method1116(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2939();
         if(var4 == 0) {
            break;
         }

         this.field1158[var3] = var4;
         this.field1159[var3] = var1.readShortSmart();
         this.field1173[var3] = var1.method2939();
      }

      this.field1161 = var1.method2939();
      this.field1165 = var1.method2939();
      this.field1174 = var1.readUnsignedShort();
      this.field1171 = var1.readUnsignedShort();
      this.field1156 = new class67();
      this.field1164 = new class58();
      this.field1156.method1345(var1, this.field1164);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1168[var1] = (var0.nextInt() & 2) - 1;
      }

      field1169 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1169[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1167 = new int[220500];
      field1151 = new int[5];
      field1172 = new int[5];
      field1166 = new int[5];
      field1163 = new int[5];
      field1175 = new int[5];
   }

   @ObfuscatedName("y")
   final int method1383(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1169[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1168[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("k")
   final int[] method1384(int var1, int var2) {
      class170.method3224(field1167, 0, var1);
      if(var2 < 10) {
         return field1167;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1160.method1106();
         this.field1150.method1106();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1152 != null) {
            this.field1152.method1106();
            this.field1153.method1106();
            var5 = (int)((double)(this.field1152.field1067 - this.field1152.field1063) * 32.768D / var3);
            var6 = (int)((double)this.field1152.field1063 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1162 != null) {
            this.field1162.method1106();
            this.field1155.method1106();
            var8 = (int)((double)(this.field1162.field1067 - this.field1162.field1063) * 32.768D / var3);
            var9 = (int)((double)this.field1162.field1063 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1158[var11] != 0) {
               field1151[var11] = 0;
               field1172[var11] = (int)((double)this.field1173[var11] * var3);
               field1166[var11] = (this.field1158[var11] << 14) / 100;
               field1163[var11] = (int)((double)(this.field1160.field1067 - this.field1160.field1063) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1159[var11]) / var3);
               field1175[var11] = (int)((double)this.field1160.field1063 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1160.method1110(var1);
            var13 = this.field1150.method1110(var1);
            if(this.field1152 != null) {
               var14 = this.field1152.method1110(var1);
               var15 = this.field1153.method1110(var1);
               var12 += this.method1383(var7, var15, this.field1152.field1066) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1162 != null) {
               var14 = this.field1162.method1110(var1);
               var15 = this.field1155.method1110(var1);
               var13 = var13 * ((this.method1383(var10, var15, this.field1162.field1066) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1158[var14] != 0) {
                  var15 = var11 + field1172[var14];
                  if(var15 < var1) {
                     field1167[var15] += this.method1383(field1151[var14], var13 * field1166[var14] >> 15, this.field1160.field1066);
                     field1151[var14] += (var12 * field1163[var14] >> 16) + field1175[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1154 != null) {
            this.field1154.method1106();
            this.field1157.method1106();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1154.method1110(var1);
               var16 = this.field1157.method1110(var1);
               if(var20) {
                  var12 = this.field1154.field1063 + ((this.field1154.field1067 - this.field1154.field1063) * var15 >> 8);
               } else {
                  var12 = this.field1154.field1063 + ((this.field1154.field1067 - this.field1154.field1063) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1167[var14] = 0;
               }
            }
         }

         if(this.field1161 > 0 && this.field1165 > 0) {
            var11 = (int)((double)this.field1161 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1167[var12] += field1167[var12 - var11] * this.field1165 / 100;
            }
         }

         if(this.field1156.field1137[0] > 0 || this.field1156.field1137[1] > 0) {
            this.field1164.method1106();
            var11 = this.field1164.method1110(var1 + 1);
            var12 = this.field1156.method1344(0, (float)var11 / 65536.0F);
            var13 = this.field1156.method1344(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1167[var14 + var12] * (long)class67.field1138 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1167[var14 + var12 - 1 - var17] * (long)class67.field1136[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1167[var14 - 1 - var17] * (long)class67.field1136[1][var17] >> 16);
                  }

                  field1167[var14] = var16;
                  var11 = this.field1164.method1110(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1167[var14 + var12] * (long)class67.field1138 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1167[var14 + var12 - 1 - var18] * (long)class67.field1136[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1167[var14 - 1 - var18] * (long)class67.field1136[1][var18] >> 16);
                     }

                     field1167[var14] = var17;
                     var11 = this.field1164.method1110(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1167[var14 + var12 - 1 - var18] * (long)class67.field1136[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1167[var14 - 1 - var18] * (long)class67.field1136[1][var18] >> 16);
                        }

                        field1167[var14] = var17;
                        this.field1164.method1110(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1156.method1344(0, (float)var11 / 65536.0F);
                  var13 = this.field1156.method1344(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1167[var11] < -32768) {
               field1167[var11] = -32768;
            }

            if(field1167[var11] > 32767) {
               field1167[var11] = 32767;
            }
         }

         return field1167;
      }
   }
}
