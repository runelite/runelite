import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bk")
public class class70 {
   @ObfuscatedName("b")
   static int[] field1141;
   @ObfuscatedName("x")
   class58 field1142;
   @ObfuscatedName("i")
   class58 field1143;
   @ObfuscatedName("u")
   class58 field1144;
   @ObfuscatedName("s")
   static int[] field1145;
   @ObfuscatedName("z")
   int[] field1146 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("d")
   class58 field1147;
   @ObfuscatedName("t")
   int[] field1148 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("g")
   int[] field1149 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("m")
   int field1150 = 0;
   @ObfuscatedName("l")
   class58 field1151;
   @ObfuscatedName("c")
   class58 field1152;
   @ObfuscatedName("q")
   int field1153 = 100;
   @ObfuscatedName("e")
   class67 field1154;
   @ObfuscatedName("v")
   class58 field1155;
   @ObfuscatedName("j")
   int field1156 = 500;
   @ObfuscatedName("p")
   int field1157 = 0;
   @ObfuscatedName("k")
   static int[] field1158;
   @ObfuscatedName("f")
   class58 field1159;
   @ObfuscatedName("y")
   static int[] field1160;
   @ObfuscatedName("r")
   static int[] field1162 = new int['耀'];
   @ObfuscatedName("a")
   class58 field1163;
   @ObfuscatedName("n")
   static int[] field1164;
   @ObfuscatedName("o")
   static int[] field1165;
   @ObfuscatedName("w")
   static int[] field1166;

   @ObfuscatedName("u")
   final int[] method1325(int var1, int var2) {
      class163.method3094(field1158, 0, var1);
      if(var2 < 10) {
         return field1158;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1144.method1061();
         this.field1142.method1061();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1143 != null) {
            this.field1143.method1061();
            this.field1163.method1061();
            var5 = (int)((double)(this.field1143.field1061 - this.field1143.field1067) * 32.768D / var3);
            var6 = (int)((double)this.field1143.field1067 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1159 != null) {
            this.field1159.method1061();
            this.field1152.method1061();
            var8 = (int)((double)(this.field1159.field1061 - this.field1159.field1067) * 32.768D / var3);
            var9 = (int)((double)this.field1159.field1067 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1149[var11] != 0) {
               field1145[var11] = 0;
               field1166[var11] = (int)((double)this.field1148[var11] * var3);
               field1164[var11] = (this.field1149[var11] << 14) / 100;
               field1165[var11] = (int)((double)(this.field1144.field1061 - this.field1144.field1067) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1146[var11]) / var3);
               field1141[var11] = (int)((double)this.field1144.field1067 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1144.method1062(var1);
            var13 = this.field1142.method1062(var1);
            if(this.field1143 != null) {
               var14 = this.field1143.method1062(var1);
               var15 = this.field1163.method1062(var1);
               var12 += this.method1326(var7, var15, this.field1143.field1062) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1159 != null) {
               var14 = this.field1159.method1062(var1);
               var15 = this.field1152.method1062(var1);
               var13 = var13 * ((this.method1326(var10, var15, this.field1159.field1062) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1149[var14] != 0) {
                  var15 = var11 + field1166[var14];
                  if(var15 < var1) {
                     field1158[var15] += this.method1326(field1145[var14], var13 * field1164[var14] >> 15, this.field1144.field1062);
                     field1145[var14] += (var12 * field1165[var14] >> 16) + field1141[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1147 != null) {
            this.field1147.method1061();
            this.field1151.method1061();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1147.method1062(var1);
               var16 = this.field1151.method1062(var1);
               if(var20) {
                  var12 = this.field1147.field1067 + ((this.field1147.field1061 - this.field1147.field1067) * var15 >> 8);
               } else {
                  var12 = this.field1147.field1067 + ((this.field1147.field1061 - this.field1147.field1067) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1158[var14] = 0;
               }
            }
         }

         if(this.field1150 > 0 && this.field1153 > 0) {
            var11 = (int)((double)this.field1150 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1158[var12] += field1158[var12 - var11] * this.field1153 / 100;
            }
         }

         if(this.field1154.field1126[0] > 0 || this.field1154.field1126[1] > 0) {
            this.field1155.method1061();
            var11 = this.field1155.method1062(var1 + 1);
            var12 = this.field1154.method1283(0, (float)var11 / 65536.0F);
            var13 = this.field1154.method1283(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1158[var14 + var12] * (long)class67.field1129 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1158[var14 + var12 - 1 - var17] * (long)class67.field1121[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1158[var14 - 1 - var17] * (long)class67.field1121[1][var17] >> 16);
                  }

                  field1158[var14] = var16;
                  var11 = this.field1155.method1062(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1158[var14 + var12] * (long)class67.field1129 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1158[var14 + var12 - 1 - var18] * (long)class67.field1121[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1158[var14 - 1 - var18] * (long)class67.field1121[1][var18] >> 16);
                     }

                     field1158[var14] = var17;
                     var11 = this.field1155.method1062(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1158[var14 + var12 - 1 - var18] * (long)class67.field1121[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1158[var14 - 1 - var18] * (long)class67.field1121[1][var18] >> 16);
                        }

                        field1158[var14] = var17;
                        this.field1155.method1062(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1154.method1283(0, (float)var11 / 65536.0F);
                  var13 = this.field1154.method1283(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1158[var11] < -32768) {
               field1158[var11] = -32768;
            }

            if(field1158[var11] > 32767) {
               field1158[var11] = 32767;
            }
         }

         return field1158;
      }
   }

   @ObfuscatedName("x")
   final int method1326(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1160[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1162[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("i")
   final void method1327(Buffer var1) {
      this.field1144 = new class58();
      this.field1144.method1064(var1);
      this.field1142 = new class58();
      this.field1142.method1064(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1143 = new class58();
         this.field1143.method1064(var1);
         this.field1163 = new class58();
         this.field1163.method1064(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1159 = new class58();
         this.field1159.method1064(var1);
         this.field1152 = new class58();
         this.field1152.method1064(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1147 = new class58();
         this.field1147.method1064(var1);
         this.field1151 = new class58();
         this.field1151.method1064(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2963();
         if(var4 == 0) {
            break;
         }

         this.field1149[var3] = var4;
         this.field1146[var3] = var1.readShortSmart();
         this.field1148[var3] = var1.method2963();
      }

      this.field1150 = var1.method2963();
      this.field1153 = var1.method2963();
      this.field1156 = var1.readUnsignedShort();
      this.field1157 = var1.readUnsignedShort();
      this.field1154 = new class67();
      this.field1155 = new class58();
      this.field1154.method1284(var1, this.field1155);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1162[var1] = (var0.nextInt() & 2) - 1;
      }

      field1160 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1160[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1158 = new int[220500];
      field1145 = new int[5];
      field1166 = new int[5];
      field1164 = new int[5];
      field1165 = new int[5];
      field1141 = new int[5];
   }
}
