import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class57 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 118894815
   )
   static int field1025;
   @ObfuscatedName("mo")
   static byte field1026;
   @ObfuscatedName("n")
   int[] field1027;
   @ObfuscatedName("t")
   static class63 field1028;
   @ObfuscatedName("ap")
   class68[] field1029 = new class68[8];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 988371771
   )
   int field1030 = 32;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 2020007049011520881L
   )
   long field1031 = ChatMessages.method935();
   @ObfuscatedName("l")
   static boolean field1032;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2036979193
   )
   int field1033;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1522609439
   )
   int field1034;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -6297833892792708423L
   )
   long field1035 = 0L;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -643269531
   )
   int field1036 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 634141775
   )
   int field1037 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1244147539
   )
   int field1038 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -171369460332809909L
   )
   long field1039 = 0L;
   @ObfuscatedName("u")
   boolean field1040 = true;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1886754645
   )
   int field1042 = 0;
   @ObfuscatedName("g")
   class68[] field1043 = new class68[8];
   @ObfuscatedName("f")
   class68 field1045;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1322470021
   )
   int field1046;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass68;I)V",
      garbageValue = "1052222284"
   )
   public final synchronized void method1111(class68 var1) {
      this.field1045 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "49400399"
   )
   public final synchronized void method1112() {
      if(null != this.field1027) {
         long var1 = ChatMessages.method935();

         try {
            if(0L != this.field1035) {
               if(var1 < this.field1035) {
                  return;
               }

               this.vmethod1177(this.field1046);
               this.field1035 = 0L;
               this.field1040 = true;
            }

            int var3 = this.vmethod1178();
            if(this.field1038 - var3 > this.field1036) {
               this.field1036 = this.field1038 - var3;
            }

            int var4 = this.field1033 + this.field1034;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1046) {
               this.field1046 += 1024;
               if(this.field1046 > 16384) {
                  this.field1046 = 16384;
               }

               this.vmethod1185();
               this.vmethod1177(this.field1046);
               var3 = 0;
               this.field1040 = true;
               if(var4 + 256 > this.field1046) {
                  var4 = this.field1046 - 256;
                  this.field1034 = var4 - this.field1033;
               }
            }

            while(var3 < var4) {
               this.method1150(this.field1027, 256);
               this.vmethod1183();
               var3 += 256;
            }

            if(var1 > this.field1039) {
               if(!this.field1040) {
                  if(this.field1036 == 0 && this.field1037 == 0) {
                     this.vmethod1185();
                     this.field1035 = var1 + 2000L;
                     return;
                  }

                  this.field1034 = Math.min(this.field1037, this.field1036);
                  this.field1037 = this.field1036;
               } else {
                  this.field1040 = false;
               }

               this.field1036 = 0;
               this.field1039 = 2000L + var1;
            }

            this.field1038 = var3;
         } catch (Exception var7) {
            this.vmethod1185();
            this.field1035 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1031) {
               var1 = this.field1031;
            }

            while(var1 > this.field1031 + 5000L) {
               this.method1115(256);
               this.field1031 += (long)(256000 / class202.field3079);
            }
         } catch (Exception var6) {
            this.field1031 = var1;
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1782972313"
   )
   void vmethod1185() {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1008628985"
   )
   public final synchronized void method1114() {
      this.field1040 = true;

      try {
         this.vmethod1181();
      } catch (Exception var2) {
         this.vmethod1185();
         this.field1035 = ChatMessages.method935() + 2000L;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "841707343"
   )
   final void method1115(int var1) {
      this.field1042 -= var1;
      if(this.field1042 < 0) {
         this.field1042 = 0;
      }

      if(null != this.field1045) {
         this.field1045.vmethod2748(var1);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "256"
   )
   static void method1116(int var0) {
      if(var0 != -1) {
         if(class159.method3142(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2193 != null) {
                  class18 var4 = new class18();
                  var4.field185 = var3;
                  var4.field197 = var3.field2193;
                  class112.method2151(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass68;IB)V",
      garbageValue = "-7"
   )
   final void method1117(class68 var1, int var2) {
      int var3 = var2 >> 5;
      class68 var4 = this.field1029[var3];
      if(null == var4) {
         this.field1043[var3] = var1;
      } else {
         var4.field1125 = var1;
      }

      this.field1029[var3] = var1;
      var1.field1126 = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "445771997"
   )
   void vmethod1176(Component var1) throws Exception {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1188142474"
   )
   void vmethod1177(int var1) throws Exception {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2076567900"
   )
   public final void method1120() {
      this.field1040 = true;
   }

   @ObfuscatedName("q")
   void vmethod1183() throws Exception {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-625584532"
   )
   void vmethod1181() throws Exception {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "67"
   )
   int vmethod1178() throws Exception {
      return this.field1046;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2082692171"
   )
   public final synchronized void method1141() {
      if(null != field1028) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(field1028.field1074[var2] == this) {
               field1028.field1074[var2] = null;
            }

            if(field1028.field1074[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1028.field1075 = true;

            while(field1028.field1076) {
               class115.method2301(50L);
            }

            field1028 = null;
         }
      }

      this.vmethod1185();
      this.field1027 = null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1150(int[] var1, int var2) {
      int var3 = var2;
      if(field1032) {
         var3 = var2 << 1;
      }

      class163.method3187(var1, 0, var3);
      this.field1042 -= var2;
      if(this.field1045 != null && this.field1042 <= 0) {
         this.field1042 += class202.field3079 >> 4;
         XClanMember.method257(this.field1045);
         this.method1117(this.field1045, this.field1045.vmethod1397());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class68 var10;
         label137:
         for(var6 = 7; var5 != 0; --var6) {
            int var16;
            int var17;
            if(var6 < 0) {
               var16 = var6 & 3;
               var17 = -(var6 >> 2);
            } else {
               var16 = var6;
               var17 = 0;
            }

            for(int var9 = var5 >>> var16 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var16);
                  var10 = null;
                  class68 var11 = this.field1043[var16];

                  label131:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label131;
                        }

                        class71 var12 = var11.field1127;
                        if(null != var12 && var12.field1158 > var17) {
                           var5 |= 1 << var16;
                           var10 = var11;
                           var11 = var11.field1125;
                        } else {
                           var11.field1124 = true;
                           int var13 = var11.vmethod2763();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1158 += var13;
                           }

                           if(var4 >= this.field1030) {
                              break label137;
                           }

                           class68 var14 = var11.vmethod2744();
                           if(null != var14) {
                              for(int var15 = var11.field1126; var14 != null; var14 = var11.vmethod2746()) {
                                 this.method1117(var14, var15 * var14.vmethod1397() >> 8);
                              }
                           }

                           class68 var18 = var11.field1125;
                           var11.field1125 = null;
                           if(var10 == null) {
                              this.field1043[var16] = var18;
                           } else {
                              var10.field1125 = var18;
                           }

                           if(null == var18) {
                              this.field1029[var16] = var10;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var16 += 4;
               ++var17;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class68 var7 = this.field1043[var6];
            class68[] var8 = this.field1043;
            this.field1029[var6] = null;

            for(var8[var6] = null; null != var7; var7 = var10) {
               var10 = var7.field1125;
               var7.field1125 = null;
            }
         }
      }

      if(this.field1042 < 0) {
         this.field1042 = 0;
      }

      if(null != this.field1045) {
         this.field1045.vmethod2747(var1, 0, var2);
      }

      this.field1031 = ChatMessages.method935();
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "80933812"
   )
   static String method1161(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }
}
