import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bv")
public class class70 {
   @ObfuscatedName("q")
   class58 field1149;
   @ObfuscatedName("g")
   class58 field1150;
   @ObfuscatedName("l")
   static int[] field1151;
   @ObfuscatedName("o")
   int[] field1152 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("n")
   static int[] field1153;
   @ObfuscatedName("k")
   class58 field1154;
   @ObfuscatedName("j")
   class58 field1155;
   @ObfuscatedName("s")
   class58 field1156;
   @ObfuscatedName("x")
   class58 field1157;
   @ObfuscatedName("a")
   int[] field1158 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("c")
   int[] field1159 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("m")
   int field1160 = 0;
   @ObfuscatedName("r")
   class67 field1161;
   @ObfuscatedName("p")
   class58 field1162;
   @ObfuscatedName("d")
   class58 field1163;
   @ObfuscatedName("h")
   int field1164 = 100;
   @ObfuscatedName("z")
   int field1165 = 0;
   @ObfuscatedName("i")
   int field1166 = 500;
   @ObfuscatedName("w")
   static int[] field1167 = new int['耀'];
   @ObfuscatedName("y")
   static int[] field1168;
   @ObfuscatedName("f")
   static int[] field1170;
   @ObfuscatedName("u")
   class58 field1171;
   @ObfuscatedName("t")
   static int[] field1172;
   @ObfuscatedName("b")
   static int[] field1173;
   @ObfuscatedName("e")
   static int[] field1174;

   @ObfuscatedName("g")
   final int method1359(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1168[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1167[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("p")
   final int[] method1360(int var1, int var2) {
      class163.method3092(field1153, 0, var1);
      if(var2 < 10) {
         return field1153;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1162.method1085();
         this.field1150.method1085();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1157 != null) {
            this.field1157.method1085();
            this.field1149.method1085();
            var5 = (int)((double)(this.field1157.field1068 - this.field1157.field1071) * 32.768D / var3);
            var6 = (int)((double)this.field1157.field1071 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1163 != null) {
            this.field1163.method1085();
            this.field1154.method1085();
            var8 = (int)((double)(this.field1163.field1068 - this.field1163.field1071) * 32.768D / var3);
            var9 = (int)((double)this.field1163.field1071 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1152[var11] != 0) {
               field1170[var11] = 0;
               field1151[var11] = (int)((double)this.field1159[var11] * var3);
               field1172[var11] = (this.field1152[var11] << 14) / 100;
               field1173[var11] = (int)((double)(this.field1162.field1068 - this.field1162.field1071) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1158[var11]) / var3);
               field1174[var11] = (int)((double)this.field1162.field1071 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1162.method1083(var1);
            var13 = this.field1150.method1083(var1);
            if(this.field1157 != null) {
               var14 = this.field1157.method1083(var1);
               var15 = this.field1149.method1083(var1);
               var12 += this.method1359(var7, var15, this.field1157.field1064) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1163 != null) {
               var14 = this.field1163.method1083(var1);
               var15 = this.field1154.method1083(var1);
               var13 = var13 * ((this.method1359(var10, var15, this.field1163.field1064) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1152[var14] != 0) {
                  var15 = var11 + field1151[var14];
                  if(var15 < var1) {
                     field1153[var15] += this.method1359(field1170[var14], var13 * field1172[var14] >> 15, this.field1162.field1064);
                     field1170[var14] += (var12 * field1173[var14] >> 16) + field1174[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1155 != null) {
            this.field1155.method1085();
            this.field1156.method1085();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1155.method1083(var1);
               var16 = this.field1156.method1083(var1);
               if(var20) {
                  var12 = this.field1155.field1071 + ((this.field1155.field1068 - this.field1155.field1071) * var15 >> 8);
               } else {
                  var12 = this.field1155.field1071 + ((this.field1155.field1068 - this.field1155.field1071) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1153[var14] = 0;
               }
            }
         }

         if(this.field1160 > 0 && this.field1164 > 0) {
            var11 = (int)((double)this.field1160 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1153[var12] += field1153[var12 - var11] * this.field1164 / 100;
            }
         }

         if(this.field1161.field1136[0] > 0 || this.field1161.field1136[1] > 0) {
            this.field1171.method1085();
            var11 = this.field1171.method1083(var1 + 1);
            var12 = this.field1161.method1321(0, (float)var11 / 65536.0F);
            var13 = this.field1161.method1321(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1153[var14 + var12] * (long)class67.field1137 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1153[var14 + var12 - 1 - var17] * (long)class67.field1129[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1153[var14 - 1 - var17] * (long)class67.field1129[1][var17] >> 16);
                  }

                  field1153[var14] = var16;
                  var11 = this.field1171.method1083(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1153[var14 + var12] * (long)class67.field1137 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1153[var14 + var12 - 1 - var18] * (long)class67.field1129[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1153[var14 - 1 - var18] * (long)class67.field1129[1][var18] >> 16);
                     }

                     field1153[var14] = var17;
                     var11 = this.field1171.method1083(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1153[var14 + var12 - 1 - var18] * (long)class67.field1129[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1153[var14 - 1 - var18] * (long)class67.field1129[1][var18] >> 16);
                        }

                        field1153[var14] = var17;
                        this.field1171.method1083(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1161.method1321(0, (float)var11 / 65536.0F);
                  var13 = this.field1161.method1321(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1153[var11] < -32768) {
               field1153[var11] = -32768;
            }

            if(field1153[var11] > 32767) {
               field1153[var11] = 32767;
            }
         }

         return field1153;
      }
   }

   @ObfuscatedName("x")
   final void method1362(Buffer var1) {
      this.field1162 = new class58();
      this.field1162.method1077(var1);
      this.field1150 = new class58();
      this.field1150.method1077(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1157 = new class58();
         this.field1157.method1077(var1);
         this.field1149 = new class58();
         this.field1149.method1077(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1163 = new class58();
         this.field1163.method1077(var1);
         this.field1154 = new class58();
         this.field1154.method1077(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1155 = new class58();
         this.field1155.method1077(var1);
         this.field1156 = new class58();
         this.field1156.method1077(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2979();
         if(var4 == 0) {
            break;
         }

         this.field1152[var3] = var4;
         this.field1158[var3] = var1.readShortSmart();
         this.field1159[var3] = var1.method2979();
      }

      this.field1160 = var1.method2979();
      this.field1164 = var1.method2979();
      this.field1166 = var1.readUnsignedShort();
      this.field1165 = var1.readUnsignedShort();
      this.field1161 = new class67();
      this.field1171 = new class58();
      this.field1161.method1329(var1, this.field1171);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1167[var1] = (var0.nextInt() & 2) - 1;
      }

      field1168 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1168[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1153 = new int[220500];
      field1170 = new int[5];
      field1151 = new int[5];
      field1172 = new int[5];
      field1173 = new int[5];
      field1174 = new int[5];
   }
}
