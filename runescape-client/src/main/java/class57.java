import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class57 {
   @ObfuscatedName("b")
   class68[] field1031 = new class68[8];
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1608747519
   )
   int field1033;
   @ObfuscatedName("d")
   int[] field1035;
   @ObfuscatedName("l")
   class68 field1036;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 510154851
   )
   int field1037 = 32;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 8339841678932179819L
   )
   long field1038 = class9.method117();
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -365069075900223025L
   )
   long field1040 = 0L;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1303211605
   )
   int field1041;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 4517055403845030047L
   )
   long field1042 = 0L;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1192130097
   )
   int field1043 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1263353087
   )
   int field1044 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1200039841
   )
   int field1045 = 0;
   @ObfuscatedName("r")
   boolean field1047 = true;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1516751165
   )
   static int field1048;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -783677177
   )
   int field1049;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1253560457
   )
   int field1050 = 0;
   @ObfuscatedName("a")
   static class63 field1051;
   @ObfuscatedName("aj")
   class68[] field1052 = new class68[8];
   @ObfuscatedName("x")
   static boolean field1055;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2060669672"
   )
   void vmethod1080(int var1) throws Exception {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "99"
   )
   public final synchronized void method1019() {
      if(this.field1035 != null) {
         long var1 = class9.method117();

         try {
            if(0L != this.field1042) {
               if(var1 < this.field1042) {
                  return;
               }

               this.vmethod1080(this.field1033);
               this.field1042 = 0L;
               this.field1047 = true;
            }

            int var3 = this.vmethod1070();
            if(this.field1045 - var3 > this.field1043) {
               this.field1043 = this.field1045 - var3;
            }

            int var4 = this.field1041 + this.field1049;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1033) {
               this.field1033 += 1024;
               if(this.field1033 > 16384) {
                  this.field1033 = 16384;
               }

               this.vmethod1072();
               this.vmethod1080(this.field1033);
               var3 = 0;
               this.field1047 = true;
               if(var4 + 256 > this.field1033) {
                  var4 = this.field1033 - 256;
                  this.field1041 = var4 - this.field1049;
               }
            }

            while(var3 < var4) {
               this.method1027(this.field1035, 256);
               this.vmethod1075();
               var3 += 256;
            }

            if(var1 > this.field1040) {
               if(!this.field1047) {
                  if(this.field1043 == 0 && this.field1044 == 0) {
                     this.vmethod1072();
                     this.field1042 = var1 + 2000L;
                     return;
                  }

                  this.field1041 = Math.min(this.field1044, this.field1043);
                  this.field1044 = this.field1043;
               } else {
                  this.field1047 = false;
               }

               this.field1043 = 0;
               this.field1040 = 2000L + var1;
            }

            this.field1045 = var3;
         } catch (Exception var6) {
            this.vmethod1072();
            this.field1042 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1038) {
               var1 = this.field1038;
            }

            while(var1 > 5000L + this.field1038) {
               this.method1023(256);
               this.field1038 += (long)(256000 / class7.field65);
            }
         } catch (Exception var5) {
            this.field1038 = var1;
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "13"
   )
   public final void method1020() {
      this.field1047 = true;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-771649023"
   )
   public final synchronized void method1021() {
      this.field1047 = true;

      try {
         this.vmethod1073();
      } catch (Exception var2) {
         this.vmethod1072();
         this.field1042 = class9.method117() + 2000L;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-66"
   )
   public final synchronized void method1022() {
      if(field1051 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == field1051.field1087[var2]) {
               field1051.field1087[var2] = null;
            }

            if(null != field1051.field1087[var2]) {
               var1 = false;
            }
         }

         if(var1) {
            field1051.field1088 = true;

            while(field1051.field1089) {
               VertexNormal.method1598(50L);
            }

            field1051 = null;
         }
      }

      this.vmethod1072();
      this.field1035 = null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "38"
   )
   final void method1023(int var1) {
      this.field1050 -= var1;
      if(this.field1050 < 0) {
         this.field1050 = 0;
      }

      if(null != this.field1036) {
         this.field1036.vmethod2675(var1);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass68;S)V",
      garbageValue = "16680"
   )
   public final synchronized void method1024(class68 var1) {
      this.field1036 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass68;II)V",
      garbageValue = "-1437388638"
   )
   final void method1025(class68 var1, int var2) {
      int var3 = var2 >> 5;
      class68 var4 = this.field1052[var3];
      if(null == var4) {
         this.field1031[var3] = var1;
      } else {
         var4.field1133 = var1;
      }

      this.field1052[var3] = var1;
      var1.field1134 = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "804385944"
   )
   void vmethod1069(Component var1) throws Exception {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1027(int[] var1, int var2) {
      int var3 = var2;
      if(field1055) {
         var3 = var2 << 1;
      }

      class163.method3094(var1, 0, var3);
      this.field1050 -= var2;
      if(null != this.field1036 && this.field1050 <= 0) {
         this.field1050 += class7.field65 >> 4;
         class170.method3230(this.field1036);
         this.method1025(this.field1036, this.field1036.vmethod1300());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class68 var7;
         label106:
         for(var6 = 7; var5 != 0; --var6) {
            int var8;
            int var9;
            if(var6 < 0) {
               var8 = var6 & 3;
               var9 = -(var6 >> 2);
            } else {
               var8 = var6;
               var9 = 0;
            }

            for(int var10 = var5 >>> var8 & 286331153; var10 != 0; var10 >>>= 4) {
               if((var10 & 1) != 0) {
                  var5 &= ~(1 << var8);
                  var7 = null;
                  class68 var11 = this.field1031[var8];

                  label100:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label100;
                        }

                        class71 var12 = var11.field1136;
                        if(var12 != null && var12.field1167 > var9) {
                           var5 |= 1 << var8;
                           var7 = var11;
                           var11 = var11.field1133;
                        } else {
                           var11.field1135 = true;
                           int var13 = var11.vmethod2673();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1167 += var13;
                           }

                           if(var4 >= this.field1037) {
                              break label106;
                           }

                           class68 var14 = var11.vmethod2671();
                           if(null != var14) {
                              for(int var15 = var11.field1134; var14 != null; var14 = var11.vmethod2672()) {
                                 this.method1025(var14, var15 * var14.vmethod1300() >> 8);
                              }
                           }

                           class68 var18 = var11.field1133;
                           var11.field1133 = null;
                           if(null == var7) {
                              this.field1031[var8] = var18;
                           } else {
                              var7.field1133 = var18;
                           }

                           if(null == var18) {
                              this.field1052[var8] = var7;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var8 += 4;
               ++var9;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class68 var16 = this.field1031[var6];
            class68[] var17 = this.field1031;
            this.field1052[var6] = null;

            for(var17[var6] = null; null != var16; var16 = var7) {
               var7 = var16.field1133;
               var16.field1133 = null;
            }
         }
      }

      if(this.field1050 < 0) {
         this.field1050 = 0;
      }

      if(null != this.field1036) {
         this.field1036.vmethod2674(var1, 0, var2);
      }

      this.field1038 = class9.method117();
   }

   @ObfuscatedName("k")
   void vmethod1075() throws Exception {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-425903907"
   )
   int vmethod1070() throws Exception {
      return this.field1033;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "56360630"
   )
   void vmethod1073() throws Exception {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "540541292"
   )
   void vmethod1072() {
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIIB)V",
      garbageValue = "8"
   )
   static final void method1056(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field364) {
         Client.field365 = 32;
      } else {
         Client.field365 = 0;
      }

      Client.field364 = false;
      int var7;
      if(class115.field1787 == 1 || !GroundObject.field1297 && class115.field1787 == 4) {
         if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            class6.method87(var0);
         } else if(var5 >= var1 && var5 < 16 + var1 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            class6.method87(var0);
         } else if(var5 >= var1 - Client.field365 && var5 < var1 + 16 + Client.field365 && var6 >= var2 + 16 && var6 < var2 + var3 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = (var4 - var3) * var8 / var9;
            class6.method87(var0);
            Client.field364 = true;
         }
      }

      if(Client.field524 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var2 + var3) {
            var0.scrollY += Client.field524 * 45;
            class6.method87(var0);
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "1978929451"
   )
   public static String method1057(byte[] var0) {
      int var1 = var0.length;
      StringBuilder var2 = new StringBuilder();

      for(int var3 = 0; var3 < 0 + var1; var3 += 3) {
         int var4 = var0[var3] & 255;
         var2.append(class206.field3074[var4 >>> 2]);
         if(var3 < var1 - 1) {
            int var5 = var0[1 + var3] & 255;
            var2.append(class206.field3074[(var4 & 3) << 4 | var5 >>> 4]);
            if(var3 < var1 - 2) {
               int var6 = var0[var3 + 2] & 255;
               var2.append(class206.field3074[(var5 & 15) << 2 | var6 >>> 6]).append(class206.field3074[var6 & 63]);
            } else {
               var2.append(class206.field3074[(var5 & 15) << 2]).append("=");
            }
         } else {
            var2.append(class206.field3074[(var4 & 3) << 4]).append("==");
         }
      }

      String var7 = var2.toString();
      return var7;
   }
}
