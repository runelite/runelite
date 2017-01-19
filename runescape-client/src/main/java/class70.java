import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bg")
public class class70 {
   @ObfuscatedName("n")
   int field1147 = 0;
   @ObfuscatedName("c")
   class58 field1148;
   @ObfuscatedName("f")
   class58 field1149;
   @ObfuscatedName("o")
   int field1150 = 0;
   @ObfuscatedName("a")
   class58 field1151;
   @ObfuscatedName("u")
   class58 field1152;
   @ObfuscatedName("x")
   int[] field1153 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("v")
   static int[] field1154;
   @ObfuscatedName("s")
   class58 field1155;
   @ObfuscatedName("h")
   class58 field1156;
   @ObfuscatedName("r")
   int[] field1157 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("k")
   class58 field1158;
   @ObfuscatedName("w")
   class58 field1159;
   @ObfuscatedName("j")
   class67 field1160;
   @ObfuscatedName("p")
   int field1162 = 500;
   @ObfuscatedName("l")
   static int[] field1163;
   @ObfuscatedName("i")
   static int[] field1164;
   @ObfuscatedName("z")
   static int[] field1165 = new int['耀'];
   @ObfuscatedName("e")
   static int[] field1166;
   @ObfuscatedName("m")
   int field1167 = 100;
   @ObfuscatedName("t")
   static int[] field1168;
   @ObfuscatedName("q")
   static int[] field1169;
   @ObfuscatedName("y")
   static int[] field1170;
   @ObfuscatedName("g")
   class58 field1171;
   @ObfuscatedName("b")
   int[] field1172 = new int[]{0, 0, 0, 0, 0};

   @ObfuscatedName("c")
   final int method1333(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1166[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1165[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("f")
   final void method1334(Buffer var1) {
      this.field1155 = new class58();
      this.field1155.method1047(var1);
      this.field1148 = new class58();
      this.field1148.method1047(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1149 = new class58();
         this.field1149.method1047(var1);
         this.field1156 = new class58();
         this.field1156.method1047(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1151 = new class58();
         this.field1151.method1047(var1);
         this.field1171 = new class58();
         this.field1171.method1047(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1158 = new class58();
         this.field1158.method1047(var1);
         this.field1152 = new class58();
         this.field1152.method1047(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2735();
         if(var4 == 0) {
            break;
         }

         this.field1172[var3] = var4;
         this.field1153[var3] = var1.readShortSmart();
         this.field1157[var3] = var1.method2735();
      }

      this.field1147 = var1.method2735();
      this.field1167 = var1.method2735();
      this.field1162 = var1.readUnsignedShort();
      this.field1150 = var1.readUnsignedShort();
      this.field1160 = new class67();
      this.field1159 = new class58();
      this.field1160.method1297(var1, this.field1159);
   }

   @ObfuscatedName("s")
   final int[] method1335(int var1, int var2) {
      class163.method3010(field1164, 0, var1);
      if(var2 < 10) {
         return field1164;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1155.method1049();
         this.field1148.method1049();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1149 != null) {
            this.field1149.method1049();
            this.field1156.method1049();
            var5 = (int)((double)(this.field1149.field1072 - this.field1149.field1067) * 32.768D / var3);
            var6 = (int)((double)this.field1149.field1067 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1151 != null) {
            this.field1151.method1049();
            this.field1171.method1049();
            var8 = (int)((double)(this.field1151.field1072 - this.field1151.field1067) * 32.768D / var3);
            var9 = (int)((double)this.field1151.field1067 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1172[var11] != 0) {
               field1168[var11] = 0;
               field1169[var11] = (int)((double)this.field1157[var11] * var3);
               field1170[var11] = (this.field1172[var11] << 14) / 100;
               field1163[var11] = (int)((double)(this.field1155.field1072 - this.field1155.field1067) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1153[var11]) / var3);
               field1154[var11] = (int)((double)this.field1155.field1067 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1155.method1051(var1);
            var13 = this.field1148.method1051(var1);
            if(this.field1149 != null) {
               var14 = this.field1149.method1051(var1);
               var15 = this.field1156.method1051(var1);
               var12 += this.method1333(var7, var15, this.field1149.field1069) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1151 != null) {
               var14 = this.field1151.method1051(var1);
               var15 = this.field1171.method1051(var1);
               var13 = var13 * ((this.method1333(var10, var15, this.field1151.field1069) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1172[var14] != 0) {
                  var15 = var11 + field1169[var14];
                  if(var15 < var1) {
                     field1164[var15] += this.method1333(field1168[var14], var13 * field1170[var14] >> 15, this.field1155.field1069);
                     field1168[var14] += (var12 * field1163[var14] >> 16) + field1154[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1158 != null) {
            this.field1158.method1049();
            this.field1152.method1049();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1158.method1051(var1);
               var16 = this.field1152.method1051(var1);
               if(var20) {
                  var12 = this.field1158.field1067 + ((this.field1158.field1072 - this.field1158.field1067) * var15 >> 8);
               } else {
                  var12 = this.field1158.field1067 + ((this.field1158.field1072 - this.field1158.field1067) * var16 >> 8);
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

         if(this.field1147 > 0 && this.field1167 > 0) {
            var11 = (int)((double)this.field1147 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1164[var12] += field1164[var12 - var11] * this.field1167 / 100;
            }
         }

         if(this.field1160.field1127[0] > 0 || this.field1160.field1127[1] > 0) {
            this.field1159.method1049();
            var11 = this.field1159.method1051(var1 + 1);
            var12 = this.field1160.method1308(0, (float)var11 / 65536.0F);
            var13 = this.field1160.method1308(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1164[var14 + var12] * (long)class67.field1137 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1164[var14 + var12 - 1 - var17] * (long)class67.field1132[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1164[var14 - 1 - var17] * (long)class67.field1132[1][var17] >> 16);
                  }

                  field1164[var14] = var16;
                  var11 = this.field1159.method1051(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1164[var14 + var12] * (long)class67.field1137 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1164[var14 + var12 - 1 - var18] * (long)class67.field1132[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1164[var14 - 1 - var18] * (long)class67.field1132[1][var18] >> 16);
                     }

                     field1164[var14] = var17;
                     var11 = this.field1159.method1051(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1164[var14 + var12 - 1 - var18] * (long)class67.field1132[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1164[var14 - 1 - var18] * (long)class67.field1132[1][var18] >> 16);
                        }

                        field1164[var14] = var17;
                        this.field1159.method1051(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1160.method1308(0, (float)var11 / 65536.0F);
                  var13 = this.field1160.method1308(1, (float)var11 / 65536.0F);
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

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1165[var1] = (var0.nextInt() & 2) - 1;
      }

      field1166 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1166[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1164 = new int[220500];
      field1168 = new int[5];
      field1169 = new int[5];
      field1170 = new int[5];
      field1163 = new int[5];
      field1154 = new int[5];
   }
}
