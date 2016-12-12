import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bj")
public class class70 {
   @ObfuscatedName("a")
   class58 field1153;
   @ObfuscatedName("e")
   class58 field1154;
   @ObfuscatedName("f")
   class58 field1155;
   @ObfuscatedName("k")
   class58 field1156;
   @ObfuscatedName("g")
   class58 field1157;
   @ObfuscatedName("n")
   class58 field1158;
   @ObfuscatedName("r")
   int field1159 = 500;
   @ObfuscatedName("q")
   class58 field1160;
   @ObfuscatedName("w")
   int[] field1161 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("v")
   int[] field1162 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("h")
   int[] field1163 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("p")
   int field1164 = 0;
   @ObfuscatedName("l")
   int field1165 = 100;
   @ObfuscatedName("u")
   int field1166 = 0;
   @ObfuscatedName("i")
   class58 field1167;
   @ObfuscatedName("t")
   static int[] field1168;
   @ObfuscatedName("c")
   class67 field1169;
   @ObfuscatedName("m")
   class58 field1170;
   @ObfuscatedName("x")
   static int[] field1171 = new int['耀'];
   @ObfuscatedName("d")
   static int[] field1172;
   @ObfuscatedName("j")
   static int[] field1174;
   @ObfuscatedName("s")
   static int[] field1175;
   @ObfuscatedName("z")
   static int[] field1176;
   @ObfuscatedName("b")
   static int[] field1177;
   @ObfuscatedName("o")
   static int[] field1178;

   @ObfuscatedName("i")
   final int[] method1346(int var1, int var2) {
      class163.method3016(field1174, 0, var1);
      if(var2 < 10) {
         return field1174;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1167.method1080();
         this.field1154.method1080();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1155 != null) {
            this.field1155.method1080();
            this.field1156.method1080();
            var5 = (int)((double)(this.field1155.field1071 - this.field1155.field1070) * 32.768D / var3);
            var6 = (int)((double)this.field1155.field1070 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1157 != null) {
            this.field1157.method1080();
            this.field1158.method1080();
            var8 = (int)((double)(this.field1157.field1071 - this.field1157.field1070) * 32.768D / var3);
            var9 = (int)((double)this.field1157.field1070 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1161[var11] != 0) {
               field1175[var11] = 0;
               field1168[var11] = (int)((double)this.field1163[var11] * var3);
               field1176[var11] = (this.field1161[var11] << 14) / 100;
               field1177[var11] = (int)((double)(this.field1167.field1071 - this.field1167.field1070) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1162[var11]) / var3);
               field1178[var11] = (int)((double)this.field1167.field1070 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1167.method1075(var1);
            var13 = this.field1154.method1075(var1);
            if(this.field1155 != null) {
               var14 = this.field1155.method1075(var1);
               var15 = this.field1156.method1075(var1);
               var12 += this.method1347(var7, var15, this.field1155.field1076) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1157 != null) {
               var14 = this.field1157.method1075(var1);
               var15 = this.field1158.method1075(var1);
               var13 = var13 * ((this.method1347(var10, var15, this.field1157.field1076) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1161[var14] != 0) {
                  var15 = var11 + field1168[var14];
                  if(var15 < var1) {
                     field1174[var15] += this.method1347(field1175[var14], var13 * field1176[var14] >> 15, this.field1167.field1076);
                     field1175[var14] += (var12 * field1177[var14] >> 16) + field1178[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1153 != null) {
            this.field1153.method1080();
            this.field1160.method1080();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1153.method1075(var1);
               var16 = this.field1160.method1075(var1);
               if(var20) {
                  var12 = this.field1153.field1070 + ((this.field1153.field1071 - this.field1153.field1070) * var15 >> 8);
               } else {
                  var12 = this.field1153.field1070 + ((this.field1153.field1071 - this.field1153.field1070) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1174[var14] = 0;
               }
            }
         }

         if(this.field1164 > 0 && this.field1165 > 0) {
            var11 = (int)((double)this.field1164 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1174[var12] += field1174[var12 - var11] * this.field1165 / 100;
            }
         }

         if(this.field1169.field1141[0] > 0 || this.field1169.field1141[1] > 0) {
            this.field1170.method1080();
            var11 = this.field1170.method1075(var1 + 1);
            var12 = this.field1169.method1306(0, (float)var11 / 65536.0F);
            var13 = this.field1169.method1306(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1174[var14 + var12] * (long)class67.field1134 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1174[var14 + var12 - 1 - var17] * (long)class67.field1139[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1174[var14 - 1 - var17] * (long)class67.field1139[1][var17] >> 16);
                  }

                  field1174[var14] = var16;
                  var11 = this.field1170.method1075(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1174[var14 + var12] * (long)class67.field1134 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1174[var14 + var12 - 1 - var18] * (long)class67.field1139[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1174[var14 - 1 - var18] * (long)class67.field1139[1][var18] >> 16);
                     }

                     field1174[var14] = var17;
                     var11 = this.field1170.method1075(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1174[var14 + var12 - 1 - var18] * (long)class67.field1139[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1174[var14 - 1 - var18] * (long)class67.field1139[1][var18] >> 16);
                        }

                        field1174[var14] = var17;
                        this.field1170.method1075(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1169.method1306(0, (float)var11 / 65536.0F);
                  var13 = this.field1169.method1306(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1174[var11] < -32768) {
               field1174[var11] = -32768;
            }

            if(field1174[var11] > 32767) {
               field1174[var11] = 32767;
            }
         }

         return field1174;
      }
   }

   @ObfuscatedName("e")
   final int method1347(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1172[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1171[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("f")
   final void method1348(Buffer var1) {
      this.field1167 = new class58();
      this.field1167.method1072(var1);
      this.field1154 = new class58();
      this.field1154.method1072(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1155 = new class58();
         this.field1155.method1072(var1);
         this.field1156 = new class58();
         this.field1156.method1072(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1157 = new class58();
         this.field1157.method1072(var1);
         this.field1158 = new class58();
         this.field1158.method1072(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1153 = new class58();
         this.field1153.method1072(var1);
         this.field1160 = new class58();
         this.field1160.method1072(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2772();
         if(var4 == 0) {
            break;
         }

         this.field1161[var3] = var4;
         this.field1162[var3] = var1.readShortSmart();
         this.field1163[var3] = var1.method2772();
      }

      this.field1164 = var1.method2772();
      this.field1165 = var1.method2772();
      this.field1159 = var1.readUnsignedShort();
      this.field1166 = var1.readUnsignedShort();
      this.field1169 = new class67();
      this.field1170 = new class58();
      this.field1169.method1307(var1, this.field1170);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1171[var1] = (var0.nextInt() & 2) - 1;
      }

      field1172 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1172[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1174 = new int[220500];
      field1175 = new int[5];
      field1168 = new int[5];
      field1176 = new int[5];
      field1177 = new int[5];
      field1178 = new int[5];
   }
}
