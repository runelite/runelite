import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bw")
public class class70 {
   @ObfuscatedName("n")
   class58 field1164;
   @ObfuscatedName("y")
   class58 field1165;
   @ObfuscatedName("g")
   class58 field1166;
   @ObfuscatedName("v")
   class58 field1167;
   @ObfuscatedName("q")
   class58 field1168;
   @ObfuscatedName("p")
   class58 field1169;
   @ObfuscatedName("m")
   class58 field1170;
   @ObfuscatedName("e")
   static int[] field1171;
   @ObfuscatedName("a")
   int[] field1172 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("i")
   int[] field1173 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("s")
   int[] field1174 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("k")
   int field1175 = 0;
   @ObfuscatedName("f")
   int field1176 = 100;
   @ObfuscatedName("o")
   class67 field1177;
   @ObfuscatedName("l")
   static int[] field1178 = new int['耀'];
   @ObfuscatedName("c")
   int field1179 = 500;
   @ObfuscatedName("b")
   int field1180 = 0;
   @ObfuscatedName("w")
   static int[] field1181;
   @ObfuscatedName("h")
   static int[] field1182;
   @ObfuscatedName("r")
   static int[] field1183;
   @ObfuscatedName("d")
   static int[] field1185;
   @ObfuscatedName("x")
   class58 field1186;
   @ObfuscatedName("j")
   class58 field1187;
   @ObfuscatedName("z")
   static int[] field1188;
   @ObfuscatedName("t")
   static int[] field1189;

   @ObfuscatedName("x")
   final int[] method1453(int var1, int var2) {
      class163.method3197(field1181, 0, var1);
      if(var2 < 10) {
         return field1181;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1186.method1181();
         this.field1164.method1181();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1166 != null) {
            this.field1166.method1181();
            this.field1167.method1181();
            var5 = (int)((double)(this.field1166.field1079 - this.field1166.field1077) * 32.768D / var3);
            var6 = (int)((double)this.field1166.field1077 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1165 != null) {
            this.field1165.method1181();
            this.field1169.method1181();
            var8 = (int)((double)(this.field1165.field1079 - this.field1165.field1077) * 32.768D / var3);
            var9 = (int)((double)this.field1165.field1077 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1172[var11] != 0) {
               field1171[var11] = 0;
               field1182[var11] = (int)((double)this.field1174[var11] * var3);
               field1185[var11] = (this.field1172[var11] << 14) / 100;
               field1188[var11] = (int)((double)(this.field1186.field1079 - this.field1186.field1077) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1173[var11]) / var3);
               field1189[var11] = (int)((double)this.field1186.field1077 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1186.method1196(var1);
            var13 = this.field1164.method1196(var1);
            if(this.field1166 != null) {
               var14 = this.field1166.method1196(var1);
               var15 = this.field1167.method1196(var1);
               var12 += this.method1454(var7, var15, this.field1166.field1082) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1165 != null) {
               var14 = this.field1165.method1196(var1);
               var15 = this.field1169.method1196(var1);
               var13 = var13 * ((this.method1454(var10, var15, this.field1165.field1082) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1172[var14] != 0) {
                  var15 = var11 + field1182[var14];
                  if(var15 < var1) {
                     field1181[var15] += this.method1454(field1171[var14], var13 * field1185[var14] >> 15, this.field1186.field1082);
                     field1171[var14] += (var12 * field1188[var14] >> 16) + field1189[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1187 != null) {
            this.field1187.method1181();
            this.field1170.method1181();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1187.method1196(var1);
               var16 = this.field1170.method1196(var1);
               if(var20) {
                  var12 = this.field1187.field1077 + ((this.field1187.field1079 - this.field1187.field1077) * var15 >> 8);
               } else {
                  var12 = this.field1187.field1077 + ((this.field1187.field1079 - this.field1187.field1077) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1181[var14] = 0;
               }
            }
         }

         if(this.field1175 > 0 && this.field1176 > 0) {
            var11 = (int)((double)this.field1175 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1181[var12] += field1181[var12 - var11] * this.field1176 / 100;
            }
         }

         if(this.field1177.field1152[0] > 0 || this.field1177.field1152[1] > 0) {
            this.field1168.method1181();
            var11 = this.field1168.method1196(var1 + 1);
            var12 = this.field1177.method1414(0, (float)var11 / 65536.0F);
            var13 = this.field1177.method1414(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1181[var14 + var12] * (long)class67.field1147 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1181[var14 + var12 - 1 - var17] * (long)class67.field1150[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1181[var14 - 1 - var17] * (long)class67.field1150[1][var17] >> 16);
                  }

                  field1181[var14] = var16;
                  var11 = this.field1168.method1196(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1181[var14 + var12] * (long)class67.field1147 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1181[var14 + var12 - 1 - var18] * (long)class67.field1150[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1181[var14 - 1 - var18] * (long)class67.field1150[1][var18] >> 16);
                     }

                     field1181[var14] = var17;
                     var11 = this.field1168.method1196(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1181[var14 + var12 - 1 - var18] * (long)class67.field1150[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1181[var14 - 1 - var18] * (long)class67.field1150[1][var18] >> 16);
                        }

                        field1181[var14] = var17;
                        this.field1168.method1196(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1177.method1414(0, (float)var11 / 65536.0F);
                  var13 = this.field1177.method1414(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1181[var11] < -32768) {
               field1181[var11] = -32768;
            }

            if(field1181[var11] > 32767) {
               field1181[var11] = 32767;
            }
         }

         return field1181;
      }
   }

   @ObfuscatedName("n")
   final int method1454(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1183[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1178[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("g")
   final void method1455(Buffer var1) {
      this.field1186 = new class58();
      this.field1186.method1182(var1);
      this.field1164 = new class58();
      this.field1164.method1182(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1166 = new class58();
         this.field1166.method1182(var1);
         this.field1167 = new class58();
         this.field1167.method1182(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1165 = new class58();
         this.field1165.method1182(var1);
         this.field1169 = new class58();
         this.field1169.method1182(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1187 = new class58();
         this.field1187.method1182(var1);
         this.field1170 = new class58();
         this.field1170.method1182(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method3039();
         if(var4 == 0) {
            break;
         }

         this.field1172[var3] = var4;
         this.field1173[var3] = var1.readShortSmart();
         this.field1174[var3] = var1.method3039();
      }

      this.field1175 = var1.method3039();
      this.field1176 = var1.method3039();
      this.field1179 = var1.readUnsignedShort();
      this.field1180 = var1.readUnsignedShort();
      this.field1177 = new class67();
      this.field1168 = new class58();
      this.field1177.method1410(var1, this.field1168);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1178[var1] = (var0.nextInt() & 2) - 1;
      }

      field1183 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1183[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1181 = new int[220500];
      field1171 = new int[5];
      field1182 = new int[5];
      field1185 = new int[5];
      field1188 = new int[5];
      field1189 = new int[5];
   }
}
