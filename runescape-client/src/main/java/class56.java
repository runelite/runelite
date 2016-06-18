import java.awt.Component;
import java.awt.Font;
import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class56 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 1882665141153326909L
   )
   long field1145 = 0L;
   @ObfuscatedName("pc")
   static Clipboard field1146;
   @ObfuscatedName("l")
   int[] field1148;
   @ObfuscatedName("u")
   class66 field1149;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 767488953
   )
   int field1150 = 32;
   @ObfuscatedName("an")
   class66[] field1151 = new class66[8];
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 33036277
   )
   int field1152;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -295415371
   )
   public static int field1153;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1018267315
   )
   int field1154;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 351415951
   )
   int field1155 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1539842935
   )
   int field1156 = 0;
   @ObfuscatedName("f")
   boolean field1157 = true;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -599278519
   )
   int field1158;
   @ObfuscatedName("y")
   static class72 field1159;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 7686452207847694693L
   )
   long field1160 = class90.method2090();
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -614176061
   )
   int field1163 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 694779359
   )
   int field1164 = 0;
   @ObfuscatedName("ag")
   class66[] field1165 = new class66[8];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 9140758651590433895L
   )
   long field1166 = 0L;
   @ObfuscatedName("qg")
   protected static Font field1168;

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lclass66;I)V",
      garbageValue = "-1159149831"
   )
   public final synchronized void method1171(class66 var1) {
      this.field1149 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "4113"
   )
   static String method1172(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)I",
      garbageValue = "-167904775"
   )
   static int method1175(class122 var0) {
      int var1 = var0.method2784(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2784(5);
      } else if(var1 == 2) {
         var2 = var0.method2784(8);
      } else {
         var2 = var0.method2784(11);
      }

      return var2;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2143547587"
   )
   final void method1176(int var1) {
      this.field1163 -= var1;
      if(this.field1163 < 0) {
         this.field1163 = 0;
      }

      if(null != this.field1149) {
         this.field1149.vmethod3725(var1);
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1177(int[] var1, int var2) {
      int var3 = var2;
      if(class21.field581) {
         var3 = var2 << 1;
      }

      class120.method2768(var1, 0, var3);
      this.field1163 -= var2;
      if(this.field1149 != null && this.field1163 <= 0) {
         this.field1163 += field1153 >> 4;
         class130.method2861(this.field1149);
         this.method1178(this.field1149, this.field1149.vmethod1468());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class66 var10;
         label135:
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
                  class66 var11 = this.field1151[var7];

                  label129:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label129;
                        }

                        class65 var12 = var11.field1233;
                        if(null != var12 && var12.field1230 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1232;
                        } else {
                           var11.field1234 = true;
                           int var13 = var11.vmethod3724();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1230 += var13;
                           }

                           if(var4 >= this.field1150) {
                              break label135;
                           }

                           class66 var14 = var11.vmethod3722();
                           if(var14 != null) {
                              for(int var15 = var11.field1231; null != var14; var14 = var11.vmethod3736()) {
                                 this.method1178(var14, var15 * var14.vmethod1468() >> 8);
                              }
                           }

                           class66 var18 = var11.field1232;
                           var11.field1232 = null;
                           if(null == var10) {
                              this.field1151[var7] = var18;
                           } else {
                              var10.field1232 = var18;
                           }

                           if(null == var18) {
                              this.field1165[var7] = var10;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class66 var16 = this.field1151[var6];
            class66[] var17 = this.field1151;
            this.field1165[var6] = null;

            for(var17[var6] = null; null != var16; var16 = var10) {
               var10 = var16.field1232;
               var16.field1232 = null;
            }
         }
      }

      if(this.field1163 < 0) {
         this.field1163 = 0;
      }

      if(this.field1149 != null) {
         this.field1149.vmethod3721(var1, 0, var2);
      }

      this.field1160 = class90.method2090();
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lclass66;IS)V",
      garbageValue = "-12298"
   )
   final void method1178(class66 var1, int var2) {
      int var3 = var2 >> 5;
      class66 var4 = this.field1165[var3];
      if(var4 == null) {
         this.field1151[var3] = var1;
      } else {
         var4.field1232 = var1;
      }

      this.field1165[var3] = var1;
      var1.field1231 = var2;
   }

   @ObfuscatedName("b")
   void vmethod1535(Component var1) throws Exception {
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "833260754"
   )
   public final synchronized void method1181() {
      this.field1157 = true;

      try {
         this.vmethod1521();
      } catch (Exception var2) {
         this.vmethod1520();
         this.field1166 = class90.method2090() + 2000L;
      }

   }

   @ObfuscatedName("d")
   void vmethod1519() throws Exception {
   }

   @ObfuscatedName("x")
   void vmethod1520() {
   }

   @ObfuscatedName("y")
   void vmethod1521() throws Exception {
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-323386084"
   )
   public final synchronized void method1192() {
      if(null != this.field1148) {
         long var1 = class90.method2090();

         try {
            if(this.field1166 != 0L) {
               if(var1 < this.field1166) {
                  return;
               }

               this.vmethod1517(this.field1152);
               this.field1166 = 0L;
               this.field1157 = true;
            }

            int var3 = this.vmethod1518();
            if(this.field1164 - var3 > this.field1156) {
               this.field1156 = this.field1164 - var3;
            }

            int var4 = this.field1158 + this.field1154;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1152) {
               this.field1152 += 1024;
               if(this.field1152 > 16384) {
                  this.field1152 = 16384;
               }

               this.vmethod1520();
               this.vmethod1517(this.field1152);
               var3 = 0;
               this.field1157 = true;
               if(var4 + 256 > this.field1152) {
                  var4 = this.field1152 - 256;
                  this.field1154 = var4 - this.field1158;
               }
            }

            while(var3 < var4) {
               this.method1177(this.field1148, 256);
               this.vmethod1519();
               var3 += 256;
            }

            if(var1 > this.field1145) {
               if(!this.field1157) {
                  if(this.field1156 == 0 && this.field1155 == 0) {
                     this.vmethod1520();
                     this.field1166 = 2000L + var1;
                     return;
                  }

                  this.field1154 = Math.min(this.field1155, this.field1156);
                  this.field1155 = this.field1156;
               } else {
                  this.field1157 = false;
               }

               this.field1156 = 0;
               this.field1145 = var1 + 2000L;
            }

            this.field1164 = var3;
         } catch (Exception var7) {
            this.vmethod1520();
            this.field1166 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1160) {
               var1 = this.field1160;
            }

            while(var1 > 5000L + this.field1160) {
               this.method1176(256);
               this.field1160 += (long)(256000 / field1153);
            }
         } catch (Exception var6) {
            this.field1160 = var1;
         }

      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1536564795"
   )
   public final void method1193() {
      this.field1157 = true;
   }

   @ObfuscatedName("g")
   void vmethod1517(int var1) throws Exception {
   }

   @ObfuscatedName("j")
   int vmethod1518() throws Exception {
      return this.field1152;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1586040534"
   )
   public final synchronized void method1215() {
      if(field1159 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == field1159.field1317[var2]) {
               field1159.field1317[var2] = null;
            }

            if(null != field1159.field1317[var2]) {
               var1 = false;
            }
         }

         if(var1) {
            field1159.field1315 = true;

            while(field1159.field1318) {
               class116.method2459(50L);
            }

            field1159 = null;
         }
      }

      this.vmethod1520();
      this.field1148 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass46;",
      garbageValue = "-1746656046"
   )
   public static class46 method1230(int var0) {
      class46 var1 = (class46)class46.field1028.method3764((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class46.field1033.method3266(4, var0);
         var1 = new class46();
         if(null != var2) {
            var1.method958(new class119(var2), var0);
         }

         var1.method957();
         class46.field1028.method3759(var1, (long)var0);
         return var1;
      }
   }
}
