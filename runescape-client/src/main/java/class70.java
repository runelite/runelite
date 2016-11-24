import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bf")
public class class70 {
   @ObfuscatedName("m")
   class58 field1141;
   @ObfuscatedName("d")
   class58 field1142;
   @ObfuscatedName("q")
   int[] field1143 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("h")
   class58 field1144;
   @ObfuscatedName("o")
   static int[] field1145;
   @ObfuscatedName("v")
   static int[] field1146;
   @ObfuscatedName("c")
   class58 field1147;
   @ObfuscatedName("n")
   class58 field1148;
   @ObfuscatedName("g")
   int[] field1149 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("z")
   int[] field1150 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("p")
   class58 field1151;
   @ObfuscatedName("l")
   int field1152 = 0;
   @ObfuscatedName("y")
   int field1153 = 100;
   @ObfuscatedName("e")
   class67 field1154;
   @ObfuscatedName("x")
   class58 field1155;
   @ObfuscatedName("f")
   int field1156 = 500;
   @ObfuscatedName("r")
   class58 field1157;
   @ObfuscatedName("a")
   static int[] field1158;
   @ObfuscatedName("i")
   static int[] field1159 = new int['耀'];
   @ObfuscatedName("s")
   int field1160 = 0;
   @ObfuscatedName("j")
   static int[] field1162;
   @ObfuscatedName("k")
   static int[] field1163;
   @ObfuscatedName("w")
   class58 field1164;
   @ObfuscatedName("u")
   static int[] field1165;
   @ObfuscatedName("t")
   static int[] field1166;

   @ObfuscatedName("n")
   final int[] method1395(int var1, int var2) {
      class170.method3293(field1145, 0, var1);
      if(var2 < 10) {
         return field1145;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1148.method1097();
         this.field1142.method1097();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1141 != null) {
            this.field1141.method1097();
            this.field1144.method1097();
            var5 = (int)((double)(this.field1141.field1063 - this.field1141.field1058) * 32.768D / var3);
            var6 = (int)((double)this.field1141.field1058 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1164 != null) {
            this.field1164.method1097();
            this.field1157.method1097();
            var8 = (int)((double)(this.field1164.field1063 - this.field1164.field1058) * 32.768D / var3);
            var9 = (int)((double)this.field1164.field1058 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1149[var11] != 0) {
               field1162[var11] = 0;
               field1163[var11] = (int)((double)this.field1143[var11] * var3);
               field1146[var11] = (this.field1149[var11] << 14) / 100;
               field1165[var11] = (int)((double)(this.field1148.field1063 - this.field1148.field1058) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1150[var11]) / var3);
               field1166[var11] = (int)((double)this.field1148.field1058 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1148.method1098(var1);
            var13 = this.field1142.method1098(var1);
            if(this.field1141 != null) {
               var14 = this.field1141.method1098(var1);
               var15 = this.field1144.method1098(var1);
               var12 += this.method1396(var7, var15, this.field1141.field1061) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1164 != null) {
               var14 = this.field1164.method1098(var1);
               var15 = this.field1157.method1098(var1);
               var13 = var13 * ((this.method1396(var10, var15, this.field1164.field1061) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1149[var14] != 0) {
                  var15 = var11 + field1163[var14];
                  if(var15 < var1) {
                     field1145[var15] += this.method1396(field1162[var14], var13 * field1146[var14] >> 15, this.field1148.field1061);
                     field1162[var14] += (var12 * field1165[var14] >> 16) + field1166[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1147 != null) {
            this.field1147.method1097();
            this.field1151.method1097();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1147.method1098(var1);
               var16 = this.field1151.method1098(var1);
               if(var20) {
                  var12 = this.field1147.field1058 + ((this.field1147.field1063 - this.field1147.field1058) * var15 >> 8);
               } else {
                  var12 = this.field1147.field1058 + ((this.field1147.field1063 - this.field1147.field1058) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1145[var14] = 0;
               }
            }
         }

         if(this.field1152 > 0 && this.field1153 > 0) {
            var11 = (int)((double)this.field1152 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1145[var12] += field1145[var12 - var11] * this.field1153 / 100;
            }
         }

         if(this.field1154.field1126[0] > 0 || this.field1154.field1126[1] > 0) {
            this.field1155.method1097();
            var11 = this.field1155.method1098(var1 + 1);
            var12 = this.field1154.method1366(0, (float)var11 / 65536.0F);
            var13 = this.field1154.method1366(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1145[var14 + var12] * (long)class67.field1129 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1145[var14 + var12 - 1 - var17] * (long)class67.field1127[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1145[var14 - 1 - var17] * (long)class67.field1127[1][var17] >> 16);
                  }

                  field1145[var14] = var16;
                  var11 = this.field1155.method1098(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1145[var14 + var12] * (long)class67.field1129 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1145[var14 + var12 - 1 - var18] * (long)class67.field1127[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1145[var14 - 1 - var18] * (long)class67.field1127[1][var18] >> 16);
                     }

                     field1145[var14] = var17;
                     var11 = this.field1155.method1098(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1145[var14 + var12 - 1 - var18] * (long)class67.field1127[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1145[var14 - 1 - var18] * (long)class67.field1127[1][var18] >> 16);
                        }

                        field1145[var14] = var17;
                        this.field1155.method1098(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1154.method1366(0, (float)var11 / 65536.0F);
                  var13 = this.field1154.method1366(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1145[var11] < -32768) {
               field1145[var11] = -32768;
            }

            if(field1145[var11] > 32767) {
               field1145[var11] = 32767;
            }
         }

         return field1145;
      }
   }

   @ObfuscatedName("d")
   final int method1396(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1158[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1159[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("m")
   final void method1397(Buffer var1) {
      this.field1148 = new class58();
      this.field1148.method1095(var1);
      this.field1142 = new class58();
      this.field1142.method1095(var1);
      int var2 = var1.method3033();
      if(var2 != 0) {
         --var1.offset;
         this.field1141 = new class58();
         this.field1141.method1095(var1);
         this.field1144 = new class58();
         this.field1144.method1095(var1);
      }

      var2 = var1.method3033();
      if(var2 != 0) {
         --var1.offset;
         this.field1164 = new class58();
         this.field1164.method1095(var1);
         this.field1157 = new class58();
         this.field1157.method1095(var1);
      }

      var2 = var1.method3033();
      if(var2 != 0) {
         --var1.offset;
         this.field1147 = new class58();
         this.field1147.method1095(var1);
         this.field1151 = new class58();
         this.field1151.method1095(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method3003();
         if(var4 == 0) {
            break;
         }

         this.field1149[var3] = var4;
         this.field1150[var3] = var1.method3002();
         this.field1143[var3] = var1.method3003();
      }

      this.field1152 = var1.method3003();
      this.field1153 = var1.method3003();
      this.field1156 = var1.method3097();
      this.field1160 = var1.method3097();
      this.field1154 = new class67();
      this.field1155 = new class58();
      this.field1154.method1368(var1, this.field1155);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1159[var1] = (var0.nextInt() & 2) - 1;
      }

      field1158 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1158[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1145 = new int[220500];
      field1162 = new int[5];
      field1163 = new int[5];
      field1146 = new int[5];
      field1165 = new int[5];
      field1166 = new int[5];
   }
}
