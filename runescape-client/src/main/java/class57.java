import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class57 {
   @ObfuscatedName("l")
   int[] field1038;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 1664352425302932401L
   )
   long field1039 = 0L;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2127760813
   )
   int field1040 = 32;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1435181965
   )
   public static int field1042;
   @ObfuscatedName("c")
   class68 field1043;
   @ObfuscatedName("m")
   public static boolean field1044;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -2802358103317853933L
   )
   long field1045 = class114.method2154();
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 261776397
   )
   int field1046;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -503361515
   )
   int field1047;
   @ObfuscatedName("g")
   static class63 field1048;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 347849303
   )
   int field1049 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2094003795
   )
   int field1050 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -1775447081766586153L
   )
   long field1051 = 0L;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -653882567
   )
   int field1052 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 205067683
   )
   int field1053;
   @ObfuscatedName("d")
   boolean field1054 = true;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 635250253
   )
   int field1055 = 0;
   @ObfuscatedName("e")
   class68[] field1057 = new class68[8];
   @ObfuscatedName("am")
   class68[] field1058 = new class68[8];
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = -1092859729
   )
   static int field1059;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1018(int[] var1, int var2) {
      int var3 = var2;
      if(field1044) {
         var3 = var2 << 1;
      }

      class163.method3024(var1, 0, var3);
      this.field1049 -= var2;
      if(null != this.field1043 && this.field1049 <= 0) {
         this.field1049 += field1042 >> 4;
         class25.method558(this.field1043);
         this.method1026(this.field1043, this.field1043.vmethod1329());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class68 var10;
         label137:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if(var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class68 var11 = this.field1057[var7];

                  label131:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label131;
                        }

                        class71 var12 = var11.field1143;
                        if(var12 != null && var12.field1177 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1144;
                        } else {
                           var11.field1146 = true;
                           int var13 = var11.vmethod2624();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1177 += var13;
                           }

                           if(var4 >= this.field1040) {
                              break label137;
                           }

                           class68 var14 = var11.vmethod2625();
                           if(null != var14) {
                              for(int var16 = var11.field1145; null != var14; var14 = var11.vmethod2626()) {
                                 this.method1026(var14, var16 * var14.vmethod1329() >> 8);
                              }
                           }

                           class68 var15 = var11.field1144;
                           var11.field1144 = null;
                           if(var10 == null) {
                              this.field1057[var7] = var15;
                           } else {
                              var10.field1144 = var15;
                           }

                           if(var15 == null) {
                              this.field1058[var7] = var10;
                           }

                           var11 = var15;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class68 var18 = this.field1057[var6];
            class68[] var17 = this.field1057;
            this.field1058[var6] = null;

            for(var17[var6] = null; null != var18; var18 = var10) {
               var10 = var18.field1144;
               var18.field1144 = null;
            }
         }
      }

      if(this.field1049 < 0) {
         this.field1049 = 0;
      }

      if(null != this.field1043) {
         this.field1043.vmethod2628(var1, 0, var2);
      }

      this.field1045 = class114.method2154();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass68;B)V",
      garbageValue = "0"
   )
   public final synchronized void method1019(class68 var1) {
      this.field1043 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "624649167"
   )
   public final synchronized void method1020() {
      if(null != this.field1038) {
         long var1 = class114.method2154();

         try {
            if(0L != this.field1051) {
               if(var1 < this.field1051) {
                  return;
               }

               this.vmethod1091(this.field1046);
               this.field1051 = 0L;
               this.field1054 = true;
            }

            int var3 = this.vmethod1092();
            if(this.field1052 - var3 > this.field1050) {
               this.field1050 = this.field1052 - var3;
            }

            int var4 = this.field1047 + this.field1053;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1046) {
               this.field1046 += 1024;
               if(this.field1046 > 16384) {
                  this.field1046 = 16384;
               }

               this.vmethod1094();
               this.vmethod1091(this.field1046);
               var3 = 0;
               this.field1054 = true;
               if(256 + var4 > this.field1046) {
                  var4 = this.field1046 - 256;
                  this.field1053 = var4 - this.field1047;
               }
            }

            while(var3 < var4) {
               this.method1018(this.field1038, 256);
               this.vmethod1093();
               var3 += 256;
            }

            if(var1 > this.field1039) {
               if(!this.field1054) {
                  if(this.field1050 == 0 && this.field1055 == 0) {
                     this.vmethod1094();
                     this.field1051 = var1 + 2000L;
                     return;
                  }

                  this.field1053 = Math.min(this.field1055, this.field1050);
                  this.field1055 = this.field1050;
               } else {
                  this.field1054 = false;
               }

               this.field1050 = 0;
               this.field1039 = 2000L + var1;
            }

            this.field1052 = var3;
         } catch (Exception var7) {
            this.vmethod1094();
            this.field1051 = 2000L + var1;
         }

         try {
            if(var1 > this.field1045 + 500000L) {
               var1 = this.field1045;
            }

            while(var1 > this.field1045 + 5000L) {
               this.method1051(256);
               this.field1045 += (long)(256000 / field1042);
            }
         } catch (Exception var6) {
            this.field1045 = var1;
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-192484087"
   )
   public final void method1021() {
      this.field1054 = true;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2028876921"
   )
   public final synchronized void method1022() {
      this.field1054 = true;

      try {
         this.vmethod1095();
      } catch (Exception var2) {
         this.vmethod1094();
         this.field1051 = class114.method2154() + 2000L;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass68;II)V",
      garbageValue = "-455897947"
   )
   final void method1026(class68 var1, int var2) {
      int var3 = var2 >> 5;
      class68 var4 = this.field1058[var3];
      if(var4 == null) {
         this.field1057[var3] = var1;
      } else {
         var4.field1144 = var1;
      }

      this.field1058[var3] = var1;
      var1.field1145 = var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1096175189"
   )
   void vmethod1091(int var1) throws Exception {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-680825398"
   )
   int vmethod1092() throws Exception {
      return this.field1046;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-44"
   )
   void vmethod1090(Component var1) throws Exception {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1595086682"
   )
   void vmethod1095() throws Exception {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2031097219"
   )
   public final synchronized void method1043() {
      if(field1048 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == field1048.field1092[var2]) {
               field1048.field1092[var2] = null;
            }

            if(field1048.field1092[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1048.field1090 = true;

            while(field1048.field1091) {
               XClanMember.method237(50L);
            }

            field1048 = null;
         }
      }

      this.vmethod1094();
      this.field1038 = null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "948621790"
   )
   final void method1051(int var1) {
      this.field1049 -= var1;
      if(this.field1049 < 0) {
         this.field1049 = 0;
      }

      if(this.field1043 != null) {
         this.field1043.vmethod2629(var1);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-80529995"
   )
   void vmethod1094() {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "0"
   )
   static final int method1066(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var2 * (var1 & 16711935) + var3 * (var0 & 16711935) & -16711936) + (var3 * (var0 & '\uff00') + var2 * (var1 & '\uff00') & 16711680) >> 8;
   }

   @ObfuscatedName("i")
   void vmethod1093() throws Exception {
   }
}
