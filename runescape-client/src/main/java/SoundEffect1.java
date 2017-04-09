import java.util.Random;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
@Implements("SoundEffect1")
public class SoundEffect1 {
   @ObfuscatedName("i")
   SoundEffect2 field1173;
   @ObfuscatedName("u")
   SoundEffect2 field1174;
   @ObfuscatedName("n")
   SoundEffect2 field1175;
   @ObfuscatedName("y")
   int field1176 = 500;
   @ObfuscatedName("j")
   int[] field1177 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("l")
   SoundEffect2 field1178;
   @ObfuscatedName("w")
   int[] field1179 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("m")
   int[] field1180 = new int[]{0, 0, 0, 0, 0};
   @ObfuscatedName("f")
   SoundEffect2 field1181;
   @ObfuscatedName("d")
   SoundEffect3 field1182;
   @ObfuscatedName("r")
   SoundEffect2 field1183;
   @ObfuscatedName("q")
   int field1184 = 100;
   @ObfuscatedName("e")
   static int[] field1185;
   @ObfuscatedName("p")
   SoundEffect2 field1186;
   @ObfuscatedName("s")
   int field1187 = 0;
   @ObfuscatedName("a")
   int field1188 = 0;
   @ObfuscatedName("v")
   static int[] field1189;
   @ObfuscatedName("z")
   static int[] field1190 = new int['耀'];
   @ObfuscatedName("x")
   static int[] field1191;
   @ObfuscatedName("o")
   SoundEffect2 field1192;
   @ObfuscatedName("h")
   SoundEffect2 field1193;
   @ObfuscatedName("k")
   static int[] field1194;
   @ObfuscatedName("t")
   static int[] field1195;
   @ObfuscatedName("c")
   static int[] field1196;
   @ObfuscatedName("b")
   static int[] field1197;

   @ObfuscatedName("f")
   final int[] method1402(int var1, int var2) {
      class163.method3153(field1189, 0, var1);
      if(var2 < 10) {
         return field1189;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         this.field1181.method1140();
         this.field1173.method1140();
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if(this.field1174 != null) {
            this.field1174.method1140();
            this.field1193.method1140();
            var5 = (int)((double)(this.field1174.field1089 - this.field1174.field1088) * 32.768D / var3);
            var6 = (int)((double)this.field1174.field1088 * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if(this.field1183 != null) {
            this.field1183.method1140();
            this.field1192.method1140();
            var8 = (int)((double)(this.field1183.field1089 - this.field1183.field1088) * 32.768D / var3);
            var9 = (int)((double)this.field1183.field1088 * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if(this.field1180[var11] != 0) {
               field1197[var11] = 0;
               field1194[var11] = (int)((double)this.field1177[var11] * var3);
               field1195[var11] = (this.field1180[var11] << 14) / 100;
               field1196[var11] = (int)((double)(this.field1181.field1089 - this.field1181.field1088) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field1179[var11]) / var3);
               field1185[var11] = (int)((double)this.field1181.field1088 * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = this.field1181.method1141(var1);
            var13 = this.field1173.method1141(var1);
            if(this.field1174 != null) {
               var14 = this.field1174.method1141(var1);
               var15 = this.field1193.method1141(var1);
               var12 += this.method1406(var7, var15, this.field1174.field1087) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if(this.field1183 != null) {
               var14 = this.field1183.method1141(var1);
               var15 = this.field1192.method1141(var1);
               var13 = var13 * ((this.method1406(var10, var15, this.field1183.field1087) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if(this.field1180[var14] != 0) {
                  var15 = var11 + field1194[var14];
                  if(var15 < var1) {
                     field1189[var15] += this.method1406(field1197[var14], var13 * field1195[var14] >> 15, this.field1181.field1087);
                     field1197[var14] += (var12 * field1196[var14] >> 16) + field1185[var14];
                  }
               }
            }
         }

         int var16;
         if(this.field1178 != null) {
            this.field1178.method1140();
            this.field1175.method1140();
            var11 = 0;
            boolean var17 = false;
            boolean var18 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = this.field1178.method1141(var1);
               var16 = this.field1175.method1141(var1);
               if(var18) {
                  var12 = this.field1178.field1088 + ((this.field1178.field1089 - this.field1178.field1088) * var15 >> 8);
               } else {
                  var12 = this.field1178.field1088 + ((this.field1178.field1089 - this.field1178.field1088) * var16 >> 8);
               }

               var11 += 256;
               if(var11 >= var12) {
                  var11 = 0;
                  var18 = !var18;
               }

               if(var18) {
                  field1189[var14] = 0;
               }
            }
         }

         if(this.field1187 > 0 && this.field1184 > 0) {
            var11 = (int)((double)this.field1187 * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               field1189[var12] += field1189[var12 - var11] * this.field1184 / 100;
            }
         }

         if(this.field1182.field1155[0] > 0 || this.field1182.field1155[1] > 0) {
            this.field1186.method1140();
            var11 = this.field1186.method1141(var1 + 1);
            var12 = this.field1182.method1370(0, (float)var11 / 65536.0F);
            var13 = this.field1182.method1370(1, (float)var11 / 65536.0F);
            if(var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if(var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var19;
               while(var14 < var15) {
                  var16 = (int)((long)field1189[var14 + var12] * (long)SoundEffect3.field1160 >> 16);

                  for(var19 = 0; var19 < var12; ++var19) {
                     var16 += (int)((long)field1189[var14 + var12 - 1 - var19] * (long)SoundEffect3.field1158[0][var19] >> 16);
                  }

                  for(var19 = 0; var19 < var14; ++var19) {
                     var16 -= (int)((long)field1189[var14 - 1 - var19] * (long)SoundEffect3.field1158[1][var19] >> 16);
                  }

                  field1189[var14] = var16;
                  var11 = this.field1186.method1141(var1 + 1);
                  ++var14;
               }

               var15 = 128;

               while(true) {
                  if(var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var20;
                  while(var14 < var15) {
                     var19 = (int)((long)field1189[var14 + var12] * (long)SoundEffect3.field1160 >> 16);

                     for(var20 = 0; var20 < var12; ++var20) {
                        var19 += (int)((long)field1189[var14 + var12 - 1 - var20] * (long)SoundEffect3.field1158[0][var20] >> 16);
                     }

                     for(var20 = 0; var20 < var13; ++var20) {
                        var19 -= (int)((long)field1189[var14 - 1 - var20] * (long)SoundEffect3.field1158[1][var20] >> 16);
                     }

                     field1189[var14] = var19;
                     var11 = this.field1186.method1141(var1 + 1);
                     ++var14;
                  }

                  if(var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var19 = 0;

                        for(var20 = var14 + var12 - var1; var20 < var12; ++var20) {
                           var19 += (int)((long)field1189[var14 + var12 - 1 - var20] * (long)SoundEffect3.field1158[0][var20] >> 16);
                        }

                        for(var20 = 0; var20 < var13; ++var20) {
                           var19 -= (int)((long)field1189[var14 - 1 - var20] * (long)SoundEffect3.field1158[1][var20] >> 16);
                        }

                        field1189[var14] = var19;
                        this.field1186.method1141(var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = this.field1182.method1370(0, (float)var11 / 65536.0F);
                  var13 = this.field1182.method1370(1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if(field1189[var11] < -32768) {
               field1189[var11] = -32768;
            }

            if(field1189[var11] > 32767) {
               field1189[var11] = 32767;
            }
         }

         return field1189;
      }
   }

   @ObfuscatedName("i")
   final int method1406(int var1, int var2, int var3) {
      return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?field1191[var1 & 32767] * var2 >> 14:(var3 == 3?((var1 & 32767) * var2 >> 14) - var2:(var3 == 4?field1190[var1 / 2607 & 32767] * var2:0)));
   }

   @ObfuscatedName("u")
   final void method1408(Buffer var1) {
      this.field1181 = new SoundEffect2();
      this.field1181.method1138(var1);
      this.field1173 = new SoundEffect2();
      this.field1173.method1138(var1);
      int var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1174 = new SoundEffect2();
         this.field1174.method1138(var1);
         this.field1193 = new SoundEffect2();
         this.field1193.method1138(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1183 = new SoundEffect2();
         this.field1183.method1138(var1);
         this.field1192 = new SoundEffect2();
         this.field1192.method1138(var1);
      }

      var2 = var1.readUnsignedByte();
      if(var2 != 0) {
         --var1.offset;
         this.field1178 = new SoundEffect2();
         this.field1178.method1138(var1);
         this.field1175 = new SoundEffect2();
         this.field1175.method1138(var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var1.method2880();
         if(var4 == 0) {
            break;
         }

         this.field1180[var3] = var4;
         this.field1179[var3] = var1.readShortSmart();
         this.field1177[var3] = var1.method2880();
      }

      this.field1187 = var1.method2880();
      this.field1184 = var1.method2880();
      this.field1176 = var1.readUnsignedShort();
      this.field1188 = var1.readUnsignedShort();
      this.field1182 = new SoundEffect3();
      this.field1186 = new SoundEffect2();
      this.field1182.method1362(var1, this.field1186);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < '耀'; ++var1) {
         field1190[var1] = (var0.nextInt() & 2) - 1;
      }

      field1191 = new int['耀'];

      for(var1 = 0; var1 < '耀'; ++var1) {
         field1191[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      field1189 = new int[220500];
      field1197 = new int[5];
      field1194 = new int[5];
      field1195 = new int[5];
      field1196 = new int[5];
      field1185 = new int[5];
   }
}
