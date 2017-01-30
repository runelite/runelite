import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class57 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2026947191
   )
   int field1040;
   @ObfuscatedName("s")
   class68 field1041;
   @ObfuscatedName("g")
   static boolean field1042;
   @ObfuscatedName("w")
   boolean field1043 = true;
   @ObfuscatedName("j")
   int[] field1045;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 118405189
   )
   int field1046 = 32;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -518608601
   )
   public static int field1047;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -8578285630214413971L
   )
   long field1048 = FrameMap.method1695();
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -771501001
   )
   int field1049;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -409820145
   )
   int field1050 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -440407077
   )
   int field1051;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 4947923654562990309L
   )
   long field1052 = 0L;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 535142929
   )
   int field1053 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1951287563
   )
   int field1054 = 0;
   @ObfuscatedName("q")
   static class63 field1056;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -4010380894479322395L
   )
   long field1057 = 0L;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -661654271
   )
   int field1059 = 0;
   @ObfuscatedName("e")
   class68[] field1060 = new class68[8];
   @ObfuscatedName("ai")
   class68[] field1061 = new class68[8];
   @ObfuscatedName("qh")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;
   @ObfuscatedName("gq")
   static Widget field1063;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "599172992"
   )
   final void method1021(int var1) {
      this.field1059 -= var1;
      if(this.field1059 < 0) {
         this.field1059 = 0;
      }

      if(this.field1041 != null) {
         this.field1041.vmethod2705(var1);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1004269124"
   )
   public static int method1022() {
      return ++class115.mouseIdleTicks - 1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "54"
   )
   public final synchronized void method1023() {
      this.field1043 = true;

      try {
         this.vmethod1097();
      } catch (Exception var2) {
         this.vmethod1091();
         this.field1052 = FrameMap.method1695() + 2000L;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1026(int[] var1, int var2) {
      int var3 = var2;
      if(field1042) {
         var3 = var2 << 1;
      }

      class163.method3092(var1, 0, var3);
      this.field1059 -= var2;
      if(this.field1041 != null && this.field1059 <= 0) {
         this.field1059 += field1047 >> 4;
         PlayerComposition.method3155(this.field1041);
         this.method1027(this.field1041, this.field1041.vmethod1331());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class68 var10;
         label142:
         for(var6 = 7; var5 != 0; --var6) {
            int var16;
            int var17;
            if(var6 < 0) {
               var17 = var6 & 3;
               var16 = -(var6 >> 2);
            } else {
               var17 = var6;
               var16 = 0;
            }

            for(int var9 = var5 >>> var17 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var17);
                  var10 = null;
                  class68 var11 = this.field1060[var17];

                  label136:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label136;
                        }

                        class71 var12 = var11.field1143;
                        if(null != var12 && var12.field1175 > var16) {
                           var5 |= 1 << var17;
                           var10 = var11;
                           var11 = var11.field1144;
                        } else {
                           var11.field1141 = true;
                           int var13 = var11.vmethod2703();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1175 += var13;
                           }

                           if(var4 >= this.field1046) {
                              break label142;
                           }

                           class68 var14 = var11.vmethod2701();
                           if(var14 != null) {
                              for(int var15 = var11.field1142; null != var14; var14 = var11.vmethod2702()) {
                                 this.method1027(var14, var15 * var14.vmethod1331() >> 8);
                              }
                           }

                           class68 var18 = var11.field1144;
                           var11.field1144 = null;
                           if(var10 == null) {
                              this.field1060[var17] = var18;
                           } else {
                              var10.field1144 = var18;
                           }

                           if(var18 == null) {
                              this.field1061[var17] = var10;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var17 += 4;
               ++var16;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class68 var7 = this.field1060[var6];
            class68[] var8 = this.field1060;
            this.field1061[var6] = null;

            for(var8[var6] = null; null != var7; var7 = var10) {
               var10 = var7.field1144;
               var7.field1144 = null;
            }
         }
      }

      if(this.field1059 < 0) {
         this.field1059 = 0;
      }

      if(this.field1041 != null) {
         this.field1041.vmethod2704(var1, 0, var2);
      }

      this.field1048 = FrameMap.method1695();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass68;II)V",
      garbageValue = "-774756124"
   )
   final void method1027(class68 var1, int var2) {
      int var3 = var2 >> 5;
      class68 var4 = this.field1061[var3];
      if(null == var4) {
         this.field1060[var3] = var1;
      } else {
         var4.field1144 = var1;
      }

      this.field1061[var3] = var1;
      var1.field1142 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass68;I)V",
      garbageValue = "-1552599906"
   )
   public final synchronized void method1028(class68 var1) {
      this.field1041 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-484375625"
   )
   void vmethod1088(int var1) throws Exception {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1017408769"
   )
   int vmethod1092() throws Exception {
      return this.field1049;
   }

   @ObfuscatedName("n")
   void vmethod1090() throws Exception {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-439249602"
   )
   public final void method1032() {
      this.field1043 = true;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1403695221"
   )
   void vmethod1097() throws Exception {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-403371012"
   )
   void vmethod1091() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "863575693"
   )
   public final synchronized void method1059() {
      if(this.field1045 != null) {
         long var1 = FrameMap.method1695();

         try {
            if(this.field1052 != 0L) {
               if(var1 < this.field1052) {
                  return;
               }

               this.vmethod1088(this.field1049);
               this.field1052 = 0L;
               this.field1043 = true;
            }

            int var3 = this.vmethod1092();
            if(this.field1050 - var3 > this.field1053) {
               this.field1053 = this.field1050 - var3;
            }

            int var4 = this.field1040 + this.field1051;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1049) {
               this.field1049 += 1024;
               if(this.field1049 > 16384) {
                  this.field1049 = 16384;
               }

               this.vmethod1091();
               this.vmethod1088(this.field1049);
               var3 = 0;
               this.field1043 = true;
               if(var4 + 256 > this.field1049) {
                  var4 = this.field1049 - 256;
                  this.field1051 = var4 - this.field1040;
               }
            }

            while(var3 < var4) {
               this.method1026(this.field1045, 256);
               this.vmethod1090();
               var3 += 256;
            }

            if(var1 > this.field1057) {
               if(!this.field1043) {
                  if(this.field1053 == 0 && this.field1054 == 0) {
                     this.vmethod1091();
                     this.field1052 = var1 + 2000L;
                     return;
                  }

                  this.field1051 = Math.min(this.field1054, this.field1053);
                  this.field1054 = this.field1053;
               } else {
                  this.field1043 = false;
               }

               this.field1053 = 0;
               this.field1057 = 2000L + var1;
            }

            this.field1050 = var3;
         } catch (Exception var7) {
            this.vmethod1091();
            this.field1052 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1048) {
               var1 = this.field1048;
            }

            while(var1 > this.field1048 + 5000L) {
               this.method1021(256);
               this.field1048 += (long)(256000 / field1047);
            }
         } catch (Exception var6) {
            this.field1048 = var1;
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-112"
   )
   public final synchronized void method1065() {
      if(null != field1056) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == field1056.field1092[var2]) {
               field1056.field1092[var2] = null;
            }

            if(field1056.field1092[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1056.field1094 = true;

            while(field1056.field1095) {
               class104.method1988(50L);
            }

            field1056 = null;
         }
      }

      this.vmethod1091();
      this.field1045 = null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "124"
   )
   void vmethod1086(Component var1) throws Exception {
   }
}
