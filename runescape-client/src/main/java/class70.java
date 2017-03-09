import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bs")
public class class70 {
   @ObfuscatedName("j")
   class58 field1155;
   @ObfuscatedName("d")
   class58 field1156;
   @ObfuscatedName("c")
   class58 field1157;
   @ObfuscatedName("x")
   class58 field1158;
   @ObfuscatedName("w")
   class58 field1159;
   @ObfuscatedName("i")
   static int[] field1160;
   @ObfuscatedName("u")
   class58 field1161;
   @ObfuscatedName("g")
   int[] field1163 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("y")
   int[] field1164 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("e")
   int[] field1165 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("q")
   int field1166 = 0;
   @ObfuscatedName("v")
   int field1167 = 100;
   @ObfuscatedName("l")
   class67 field1168;
   @ObfuscatedName("s")
   class58 field1169;
   @ObfuscatedName("h")
   class58 field1170;
   @ObfuscatedName("m")
   int field1171 = 0;
   @ObfuscatedName("f")
   static int[] field1172 = new int['耀'];
   @ObfuscatedName("r")
   int field1173 = 500;
   @ObfuscatedName("b")
   static int[] field1174;
   @ObfuscatedName("k")
   class58 field1175;
   @ObfuscatedName("z")
   static int[] field1176;
   @ObfuscatedName("p")
   static int[] field1177;
   @ObfuscatedName("n")
   static int[] field1178;
   @ObfuscatedName("a")
   static int[] field1179;
   @ObfuscatedName("o")
   static int[] field1180;

   @ObfuscatedName("x")
   final int[] method1434(int var1, int var2) {
      class163.method3134(field1160, 0, var1);
      if(var2 < 10) {
         return field1160;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1158.method1187();
         this.field1155.method1187();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1157 != null) {
            this.field1157.method1187();
            this.field1156.method1187();
            var5 = (int)((double)(this.field1157.field1071 - this.field1157.field1075) * 32.768D / var3);
            var6 = (int)((double)this.field1157.field1075 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1159 != null) {
            this.field1159.method1187();
            this.field1170.method1187();
            var8 = (int)((double)(this.field1159.field1071 - this.field1159.field1075) * 32.768D / var3);
            var9 = (int)((double)this.field1159.field1075 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1163[var11] != 0) {
               field1176[var11] = 0;
               field1177[var11] = (int)((double)this.field1165[var11] * var3);
               field1178[var11] = (this.field1163[var11] << 14) / 100;
               field1179[var11] = (int)((double)(this.field1158.field1071 - this.field1158.field1075) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1164[var11]) / var3);
               field1180[var11] = (int)((double)this.field1158.field1075 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1158.method1182(var1);
            var13 = this.field1155.method1182(var1);
            if(this.field1157 != null) {
               var14 = this.field1157.method1182(var1);
               var15 = this.field1156.method1182(var1);
               var12 += this.method1443(var7, var15, this.field1157.field1078) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1159 != null) {
               var14 = this.field1159.method1182(var1);
               var15 = this.field1170.method1182(var1);
               var13 = var13 * ((this.method1443(var10, var15, this.field1159.field1078) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1163[var14] != 0) {
                  var15 = var11 + field1177[var14];
                  if(var15 < var1) {
                     field1160[var15] += this.method1443(field1176[var14], var13 * field1178[var14] >> 15, this.field1158.field1078);
                     field1176[var14] += (var12 * field1179[var14] >> 16) + field1180[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1161 != null) {
            this.field1161.method1187();
            this.field1175.method1187();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1161.method1182(var1);
               var16 = this.field1175.method1182(var1);
               if(var20) {
                  var12 = this.field1161.field1075 + ((this.field1161.field1071 - this.field1161.field1075) * var15 >> 8);
               } else {
                  var12 = this.field1161.field1075 + ((this.field1161.field1071 - this.field1161.field1075) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1160[var14] = 0;
               }
            }
         }

         if(this.field1166 > 0 && this.field1167 > 0) {
            var11 = (int)((double)this.field1166 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1160[var12] += field1160[var12 - var11] * this.field1167 / 100;
            }
         }

         if(this.field1168.field1139[0] > 0 || this.field1168.field1139[1] > 0) {
            this.field1169.method1187();
            var11 = this.field1169.method1182(var1 + 1);
            var12 = this.field1168.method1400(0, (float)var11 / 65536.0F);
            var13 = this.field1168.method1400(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1160[var14 + var12] * (long)class67.field1143 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1160[var14 + var12 - 1 - var17] * (long)class67.field1141[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1160[var14 - 1 - var17] * (long)class67.field1141[1][var17] >> 16);
                  }

                  field1160[var14] = var16;
                  var11 = this.field1169.method1182(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1160[var14 + var12] * (long)class67.field1143 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1160[var14 + var12 - 1 - var18] * (long)class67.field1141[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1160[var14 - 1 - var18] * (long)class67.field1141[1][var18] >> 16);
                     }

                     field1160[var14] = var17;
                     var11 = this.field1169.method1182(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1160[var14 + var12 - 1 - var18] * (long)class67.field1141[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1160[var14 - 1 - var18] * (long)class67.field1141[1][var18] >> 16);
                        }

                        field1160[var14] = var17;
                        this.field1169.method1182(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1168.method1400(0, (float)var11 / 65536.0F);
                  var13 = this.field1168.method1400(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1160[var11] < -32768) {
               field1160[var11] = -32768;
            }

            if(field1160[var11] > 32767) {
               field1160[var11] = 32767;
            }
         }

         return field1160;
      }
   }

   @ObfuscatedName("c")
   final void method1437(Buffer var1) {
      this.field1158 = new class58();
      this.field1158.method1184(var1);
      this.field1155 = new class58();
      this.field1155.method1184(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1157 = new class58();
         this.field1157.method1184(var1);
         this.field1156 = new class58();
         this.field1156.method1184(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1159 = new class58();
         this.field1159.method1184(var1);
         this.field1170 = new class58();
         this.field1170.method1184(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1161 = new class58();
         this.field1161.method1184(var1);
         this.field1175 = new class58();
         this.field1175.method1184(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method3013();
         if(var4 == 0) {
            break;
         }

         this.field1163[var3] = var4;
         this.field1164[var3] = var1.readShortSmart();
         this.field1165[var3] = var1.method3013();
      }

      this.field1166 = var1.method3013();
      this.field1167 = var1.method3013();
      this.field1173 = var1.readUnsignedShort();
      this.field1171 = var1.readUnsignedShort();
      this.field1168 = new class67();
      this.field1169 = new class58();
      this.field1168.method1402(var1, this.field1169);
   }

   @ObfuscatedName("j")
   final int method1443(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1174[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1172[var1 / 2607 & 32767] * var2:0)));
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1172[var1] = (var0.nextInt() & 2) - 1;
      }

      field1174 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1174[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1160 = new int[220500];
      field1176 = new int[5];
      field1177 = new int[5];
      field1178 = new int[5];
      field1179 = new int[5];
      field1180 = new int[5];
   }
}
