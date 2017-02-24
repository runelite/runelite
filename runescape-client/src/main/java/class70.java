import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ba")
public class class70 {
   @ObfuscatedName("t")
   static int[] field1164;
   @ObfuscatedName("d")
   class58 field1165;
   @ObfuscatedName("h")
   class58 field1166;
   @ObfuscatedName("m")
   int[] field1167 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("l")
   static int[] field1168;
   @ObfuscatedName("n")
   class58 field1169;
   @ObfuscatedName("r")
   class58 field1170;
   @ObfuscatedName("z")
   int field1171 = 0;
   @ObfuscatedName("i")
   int[] field1172 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("o")
   int[] field1173 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("c")
   class58 field1174;
   @ObfuscatedName("s")
   int field1175 = 0;
   @ObfuscatedName("u")
   int field1176 = 100;
   @ObfuscatedName("p")
   class58 field1177;
   @ObfuscatedName("v")
   class58 field1178;
   @ObfuscatedName("f")
   int field1179 = 500;
   @ObfuscatedName("k")
   static int[] field1180;
   @ObfuscatedName("y")
   static int[] field1181 = new int['耀'];
   @ObfuscatedName("q")
   class58 field1182;
   @ObfuscatedName("w")
   static int[] field1183;
   @ObfuscatedName("b")
   class67 field1185;
   @ObfuscatedName("j")
   class58 field1186;
   @ObfuscatedName("x")
   static int[] field1187;
   @ObfuscatedName("g")
   static int[] field1188;
   @ObfuscatedName("e")
   static int[] field1189;

   @ObfuscatedName("q")
   final int[] method1420(int var1, int var2) {
      class163.method3154(field1164, 0, var1);
      if(var2 < 10) {
         return field1164;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1182.method1163();
         this.field1165.method1163();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1166 != null) {
            this.field1166.method1163();
            this.field1177.method1163();
            var5 = (int)((double)(this.field1166.field1087 - this.field1166.field1086) * 32.768D / var3);
            var6 = (int)((double)this.field1166.field1086 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1186 != null) {
            this.field1186.method1163();
            this.field1169.method1163();
            var8 = (int)((double)(this.field1186.field1087 - this.field1186.field1086) * 32.768D / var3);
            var9 = (int)((double)this.field1186.field1086 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1172[var11] != 0) {
               field1180[var11] = 0;
               field1168[var11] = (int)((double)this.field1167[var11] * var3);
               field1187[var11] = (this.field1172[var11] << 14) / 100;
               field1188[var11] = (int)((double)(this.field1182.field1087 - this.field1182.field1086) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1173[var11]) / var3);
               field1189[var11] = (int)((double)this.field1182.field1086 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1182.method1164(var1);
            var13 = this.field1165.method1164(var1);
            if(this.field1166 != null) {
               var14 = this.field1166.method1164(var1);
               var15 = this.field1177.method1164(var1);
               var12 += this.method1428(var7, var15, this.field1166.field1088) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1186 != null) {
               var14 = this.field1186.method1164(var1);
               var15 = this.field1169.method1164(var1);
               var13 = var13 * ((this.method1428(var10, var15, this.field1186.field1088) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1172[var14] != 0) {
                  var15 = var11 + field1168[var14];
                  if(var15 < var1) {
                     field1164[var15] += this.method1428(field1180[var14], var13 * field1187[var14] >> 15, this.field1182.field1088);
                     field1180[var14] += (var12 * field1188[var14] >> 16) + field1189[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1170 != null) {
            this.field1170.method1163();
            this.field1174.method1163();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1170.method1164(var1);
               var16 = this.field1174.method1164(var1);
               if(var20) {
                  var12 = this.field1170.field1086 + ((this.field1170.field1087 - this.field1170.field1086) * var15 >> 8);
               } else {
                  var12 = this.field1170.field1086 + ((this.field1170.field1087 - this.field1170.field1086) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1164[var14] = 0;
               }
            }
         }

         if(this.field1175 > 0 && this.field1176 > 0) {
            var11 = (int)((double)this.field1175 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1164[var12] += field1164[var12 - var11] * this.field1176 / 100;
            }
         }

         if(this.field1185.field1153[0] > 0 || this.field1185.field1153[1] > 0) {
            this.field1178.method1163();
            var11 = this.field1178.method1164(var1 + 1);
            var12 = this.field1185.method1384(0, (float)var11 / 65536.0F);
            var13 = this.field1185.method1384(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1164[var14 + var12] * (long)class67.field1148 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1164[var14 + var12 - 1 - var17] * (long)class67.field1145[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1164[var14 - 1 - var17] * (long)class67.field1145[1][var17] >> 16);
                  }

                  field1164[var14] = var16;
                  var11 = this.field1178.method1164(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1164[var14 + var12] * (long)class67.field1148 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1164[var14 + var12 - 1 - var18] * (long)class67.field1145[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1164[var14 - 1 - var18] * (long)class67.field1145[1][var18] >> 16);
                     }

                     field1164[var14] = var17;
                     var11 = this.field1178.method1164(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1164[var14 + var12 - 1 - var18] * (long)class67.field1145[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1164[var14 - 1 - var18] * (long)class67.field1145[1][var18] >> 16);
                        }

                        field1164[var14] = var17;
                        this.field1178.method1164(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1185.method1384(0, (float)var11 / 65536.0F);
                  var13 = this.field1185.method1384(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1164[var11] < -32768) {
               field1164[var11] = -32768;
            }

            if(field1164[var11] > 32767) {
               field1164[var11] = 32767;
            }
         }

         return field1164;
      }
   }

   @ObfuscatedName("h")
   final void method1422(Buffer var1) {
      this.field1182 = new class58();
      this.field1182.method1161(var1);
      this.field1165 = new class58();
      this.field1165.method1161(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1166 = new class58();
         this.field1166.method1161(var1);
         this.field1177 = new class58();
         this.field1177.method1161(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1186 = new class58();
         this.field1186.method1161(var1);
         this.field1169 = new class58();
         this.field1169.method1161(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1170 = new class58();
         this.field1170.method1161(var1);
         this.field1174 = new class58();
         this.field1174.method1161(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2846();
         if(var4 == 0) {
            break;
         }

         this.field1172[var3] = var4;
         this.field1173[var3] = var1.readShortSmart();
         this.field1167[var3] = var1.method2846();
      }

      this.field1175 = var1.method2846();
      this.field1176 = var1.method2846();
      this.field1179 = var1.readUnsignedShort();
      this.field1171 = var1.readUnsignedShort();
      this.field1185 = new class67();
      this.field1178 = new class58();
      this.field1185.method1380(var1, this.field1178);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1181[var1] = (var0.nextInt() & 2) - 1;
      }

      field1183 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1183[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1164 = new int[220500];
      field1180 = new int[5];
      field1168 = new int[5];
      field1187 = new int[5];
      field1188 = new int[5];
      field1189 = new int[5];
   }

   @ObfuscatedName("d")
   final int method1428(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1183[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1181[var1 / 2607 & 32767] * var2:0)));
   }
}
