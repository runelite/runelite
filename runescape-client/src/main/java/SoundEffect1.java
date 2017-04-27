import java.util.Random;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bs")
@Implements("SoundEffect1")
public class SoundEffect1 {
   @ObfuscatedName("l")
   int[] field1130 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("c")
   SoundEffect2 field1131;
   @ObfuscatedName("y")
   static int[] field1132;
   @ObfuscatedName("j")
   int field1133 = 0;
   @ObfuscatedName("t")
   SoundEffect2 field1134;
   @ObfuscatedName("p")
   SoundEffect2 field1135;
   @ObfuscatedName("u")
   SoundEffect2 field1136;
   @ObfuscatedName("z")
   SoundEffect2 field1137;
   @ObfuscatedName("d")
   SoundEffect2 field1138;
   @ObfuscatedName("n")
   SoundEffect2 field1139;
   @ObfuscatedName("g")
   int[] field1140 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("w")
   int field1141 = 0;
   @ObfuscatedName("r")
   int field1142 = 100;
   @ObfuscatedName("q")
   SoundEffect2 field1143;
   @ObfuscatedName("k")
   SoundEffect2 field1144;
   @ObfuscatedName("e")
   int field1145 = 500;
   @ObfuscatedName("v")
   int[] field1146 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("s")
   SoundEffect3 field1147;
   @ObfuscatedName("a")
   static int[] field1149 = new int['耀'];
   @ObfuscatedName("b")
   static int[] field1150;
   @ObfuscatedName("x")
   static int[] field1151;
   @ObfuscatedName("f")
   static int[] field1152;
   @ObfuscatedName("o")
   static int[] field1153;
   @ObfuscatedName("m")
   static int[] field1154;
   @ObfuscatedName("i")
   static int[] field1155;

   @ObfuscatedName("c")
   final int method1384(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1151[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1149[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("d")
   final int[] method1385(int var1, int var2) {
      class139.method2677(field1155, 0, var1);
      if(var2 < 10) {
         return field1155;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1138.method1122();
         this.field1131.method1122();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1139 != null) {
            this.field1139.method1122();
            this.field1143.method1122();
            var5 = (int)((double)(this.field1139.field1054 - this.field1139.field1053) * 32.768D / var3);
            var6 = (int)((double)this.field1139.field1053 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1134 != null) {
            this.field1134.method1122();
            this.field1135.method1122();
            var8 = (int)((double)(this.field1134.field1054 - this.field1134.field1053) * 32.768D / var3);
            var9 = (int)((double)this.field1134.field1053 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1130[var11] != 0) {
               field1150[var11] = 0;
               field1152[var11] = (int)((double)this.field1140[var11] * var3);
               field1153[var11] = (this.field1130[var11] << 14) / 100;
               field1154[var11] = (int)((double)(this.field1138.field1054 - this.field1138.field1053) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1146[var11]) / var3);
               field1132[var11] = (int)((double)this.field1138.field1053 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1138.method1123(var1);
            var13 = this.field1131.method1123(var1);
            if(this.field1139 != null) {
               var14 = this.field1139.method1123(var1);
               var15 = this.field1143.method1123(var1);
               var12 += this.method1384(var7, var15, this.field1139.field1058) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1134 != null) {
               var14 = this.field1134.method1123(var1);
               var15 = this.field1135.method1123(var1);
               var13 = var13 * ((this.method1384(var10, var15, this.field1134.field1058) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1130[var14] != 0) {
                  var15 = var11 + field1152[var14];
                  if(var15 < var1) {
                     field1155[var15] += this.method1384(field1150[var14], var13 * field1153[var14] >> 15, this.field1138.field1058);
                     field1150[var14] += (var12 * field1154[var14] >> 16) + field1132[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1136 != null) {
            this.field1136.method1122();
            this.field1137.method1122();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1136.method1123(var1);
               var16 = this.field1137.method1123(var1);
               if(var20) {
                  var12 = this.field1136.field1053 + ((this.field1136.field1054 - this.field1136.field1053) * var15 >> 8);
               } else {
                  var12 = this.field1136.field1053 + ((this.field1136.field1054 - this.field1136.field1053) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1155[var14] = 0;
               }
            }
         }

         if(this.field1141 > 0 && this.field1142 > 0) {
            var11 = (int)((double)this.field1141 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1155[var12] += field1155[var12 - var11] * this.field1142 / 100;
            }
         }

         if(this.field1147.field1114[0] > 0 || this.field1147.field1114[1] > 0) {
            this.field1144.method1122();
            var11 = this.field1144.method1123(var1 + 1);
            var12 = this.field1147.method1347(0, (float)var11 / 65536.0F);
            var13 = this.field1147.method1347(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1155[var14 + var12] * (long)SoundEffect3.field1118 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1155[var14 + var12 - 1 - var17] * (long)SoundEffect3.field1111[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1155[var14 - 1 - var17] * (long)SoundEffect3.field1111[1][var17] >> 16);
                  }

                  field1155[var14] = var16;
                  var11 = this.field1144.method1123(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1155[var14 + var12] * (long)SoundEffect3.field1118 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1155[var14 + var12 - 1 - var18] * (long)SoundEffect3.field1111[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1155[var14 - 1 - var18] * (long)SoundEffect3.field1111[1][var18] >> 16);
                     }

                     field1155[var14] = var17;
                     var11 = this.field1144.method1123(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1155[var14 + var12 - 1 - var18] * (long)SoundEffect3.field1111[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1155[var14 - 1 - var18] * (long)SoundEffect3.field1111[1][var18] >> 16);
                        }

                        field1155[var14] = var17;
                        this.field1144.method1123(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1147.method1347(0, (float)var11 / 65536.0F);
                  var13 = this.field1147.method1347(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1155[var11] < -32768) {
               field1155[var11] = -32768;
            }

            if(field1155[var11] > 32767) {
               field1155[var11] = 32767;
            }
         }

         return field1155;
      }
   }

   @ObfuscatedName("n")
   final void method1386(Buffer var1) {
      this.field1138 = new SoundEffect2();
      this.field1138.method1120(var1);
      this.field1131 = new SoundEffect2();
      this.field1131.method1120(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1139 = new SoundEffect2();
         this.field1139.method1120(var1);
         this.field1143 = new SoundEffect2();
         this.field1143.method1120(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1134 = new SoundEffect2();
         this.field1134.method1120(var1);
         this.field1135 = new SoundEffect2();
         this.field1135.method1120(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1136 = new SoundEffect2();
         this.field1136.method1120(var1);
         this.field1137 = new SoundEffect2();
         this.field1137.method1120(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2395();
         if(var4 == 0) {
            break;
         }

         this.field1130[var3] = var4;
         this.field1146[var3] = var1.readShortSmart();
         this.field1140[var3] = var1.method2395();
      }

      this.field1141 = var1.method2395();
      this.field1142 = var1.method2395();
      this.field1145 = var1.readUnsignedShort();
      this.field1133 = var1.readUnsignedShort();
      this.field1147 = new SoundEffect3();
      this.field1144 = new SoundEffect2();
      this.field1147.method1358(var1, this.field1144);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1149[var1] = (var0.nextInt() & 2) - 1;
      }

      field1151 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1151[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1155 = new int[220500];
      field1150 = new int[5];
      field1152 = new int[5];
      field1153 = new int[5];
      field1154 = new int[5];
      field1132 = new int[5];
   }
}
