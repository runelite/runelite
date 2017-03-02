import java.util.Random;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bt")
public class class70 {
   @ObfuscatedName("m")
   static int[] field1132;
   @ObfuscatedName("l")
   class58 field1133;
   @ObfuscatedName("i")
   class58 field1134;
   @ObfuscatedName("t")
   class58 field1135;
   @ObfuscatedName("j")
   static int[] field1136;
   @ObfuscatedName("h")
   class58 field1137;
   @ObfuscatedName("n")
   class58 field1138;
   @ObfuscatedName("f")
   class58 field1139;
   @ObfuscatedName("a")
   int[] field1140 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("x")
   int[] field1141 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("d")
   static int[] field1142;
   @ObfuscatedName("y")
   int field1143 = 500;
   @ObfuscatedName("p")
   int field1144 = 100;
   @ObfuscatedName("s")
   class67 field1145;
   @ObfuscatedName("r")
   int[] field1146 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("z")
   int field1147 = 0;
   @ObfuscatedName("w")
   int field1148 = 0;
   @ObfuscatedName("o")
   class58 field1149;
   @ObfuscatedName("u")
   static int[] field1150 = new int['耀'];
   @ObfuscatedName("q")
   static int[] field1151;
   @ObfuscatedName("v")
   static int[] field1153;
   @ObfuscatedName("e")
   static int[] field1154;
   @ObfuscatedName("g")
   static int[] field1155;
   @ObfuscatedName("k")
   class58 field1156;
   @ObfuscatedName("b")
   class58 field1157;

   @ObfuscatedName("b")
   final int[] method1420(int var1, int var2) {
      class163.method3187(field1132, 0, var1);
      if(var2 < 10) {
         return field1132;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1157.method1167();
         this.field1133.method1167();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1134 != null) {
            this.field1134.method1167();
            this.field1135.method1167();
            var5 = (int)((double)(this.field1134.field1051 - this.field1134.field1050) * 32.768D / var3);
            var6 = (int)((double)this.field1134.field1050 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1156 != null) {
            this.field1156.method1167();
            this.field1137.method1167();
            var8 = (int)((double)(this.field1156.field1051 - this.field1156.field1050) * 32.768D / var3);
            var9 = (int)((double)this.field1156.field1050 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1140[var11] != 0) {
               field1153[var11] = 0;
               field1154[var11] = (int)((double)this.field1141[var11] * var3);
               field1136[var11] = (this.field1140[var11] << 14) / 100;
               field1142[var11] = (int)((double)(this.field1157.field1051 - this.field1157.field1050) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1146[var11]) / var3);
               field1155[var11] = (int)((double)this.field1157.field1050 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1157.method1166(var1);
            var13 = this.field1133.method1166(var1);
            if(this.field1134 != null) {
               var14 = this.field1134.method1166(var1);
               var15 = this.field1135.method1166(var1);
               var12 += this.method1429(var7, var15, this.field1134.field1052) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1156 != null) {
               var14 = this.field1156.method1166(var1);
               var15 = this.field1137.method1166(var1);
               var13 = var13 * ((this.method1429(var10, var15, this.field1156.field1052) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1140[var14] != 0) {
                  var15 = var11 + field1154[var14];
                  if(var15 < var1) {
                     field1132[var15] += this.method1429(field1153[var14], var13 * field1136[var14] >> 15, this.field1157.field1052);
                     field1153[var14] += (var12 * field1142[var14] >> 16) + field1155[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1138 != null) {
            this.field1138.method1167();
            this.field1139.method1167();
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1138.method1166(var1);
               var16 = this.field1139.method1166(var1);
               if(var20) {
                  var12 = this.field1138.field1050 + ((this.field1138.field1051 - this.field1138.field1050) * var15 >> 8);
               } else {
                  var12 = this.field1138.field1050 + ((this.field1138.field1051 - this.field1138.field1050) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if(var20) {
                  field1132[var14] = 0;
               }
            }
         }

         if(this.field1147 > 0 && this.field1144 > 0) {
            var11 = (int)((double)this.field1147 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1132[var12] += field1132[var12 - var11] * this.field1144 / 100;
            }
         }

         if(this.field1145.field1123[0] > 0 || this.field1145.field1123[1] > 0) {
            this.field1149.method1167();
            var11 = this.field1149.method1166(var1 + 1);
            var12 = this.field1145.method1384(0, (float)var11 / 65536.0F);
            var13 = this.field1145.method1384(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)field1132[var14 + var12] * (long)class67.field1120 >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)field1132[var14 + var12 - 1 - var17] * (long)class67.field1118[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)field1132[var14 - 1 - var17] * (long)class67.field1118[1][var17] >> 16);
                  }

                  field1132[var14] = var16;
                  var11 = this.field1149.method1166(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)field1132[var14 + var12] * (long)class67.field1120 >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)field1132[var14 + var12 - 1 - var18] * (long)class67.field1118[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)field1132[var14 - 1 - var18] * (long)class67.field1118[1][var18] >> 16);
                     }

                     field1132[var14] = var17;
                     var11 = this.field1149.method1166(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)field1132[var14 + var12 - 1 - var18] * (long)class67.field1118[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)field1132[var14 - 1 - var18] * (long)class67.field1118[1][var18] >> 16);
                        }

                        field1132[var14] = var17;
                        this.field1149.method1166(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1145.method1384(0, (float)var11 / 65536.0F);
                  var13 = this.field1145.method1384(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1132[var11] < -32768) {
               field1132[var11] = -32768;
            }

            if(field1132[var11] > 32767) {
               field1132[var11] = 32767;
            }
         }

         return field1132;
      }
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1150[var1] = (var0.nextInt() & 2) - 1;
      }

      field1151 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1151[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1132 = new int[220500];
      field1153 = new int[5];
      field1154 = new int[5];
      field1136 = new int[5];
      field1142 = new int[5];
      field1155 = new int[5];
   }

   @ObfuscatedName("l")
   final int method1429(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1151[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1150[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("i")
   final void method1430(Buffer var1) {
      this.field1157 = new class58();
      this.field1157.method1164(var1);
      this.field1133 = new class58();
      this.field1133.method1164(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1134 = new class58();
         this.field1134.method1164(var1);
         this.field1135 = new class58();
         this.field1135.method1164(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1156 = new class58();
         this.field1156.method1164(var1);
         this.field1137 = new class58();
         this.field1137.method1164(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1138 = new class58();
         this.field1138.method1164(var1);
         this.field1139 = new class58();
         this.field1139.method1164(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2991();
         if(var4 == 0) {
            break;
         }

         this.field1140[var3] = var4;
         this.field1146[var3] = var1.readShortSmart();
         this.field1141[var3] = var1.method2991();
      }

      this.field1147 = var1.method2991();
      this.field1144 = var1.method2991();
      this.field1143 = var1.readUnsignedShort();
      this.field1148 = var1.readUnsignedShort();
      this.field1145 = new class67();
      this.field1149 = new class58();
      this.field1145.method1385(var1, this.field1149);
   }
}
