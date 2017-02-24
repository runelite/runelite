import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
public class class57 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -6097400878031724447L
   )
   long field1060 = 0L;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -11397875
   )
   public static int field1061;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 348994999
   )
   public static int field1062;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1428706309
   )
   int field1063 = 0;
   @ObfuscatedName("p")
   static class63 field1064;
   @ObfuscatedName("c")
   class68 field1065;
   @ObfuscatedName("r")
   int[] field1066;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 2525237368665165763L
   )
   long field1067 = class0.method11();
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 922116773
   )
   int field1068;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -716460065
   )
   int field1069;
   @ObfuscatedName("d")
   public static boolean field1070;
   @ObfuscatedName("e")
   class68[] field1071 = new class68[8];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 270350671
   )
   int field1072 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 1917327591595987455L
   )
   long field1074 = 0L;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -906434983
   )
   int field1075 = 0;
   @ObfuscatedName("y")
   boolean field1076 = true;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1482938369
   )
   int field1078 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2021059297
   )
   int field1079 = 32;
   @ObfuscatedName("ae")
   class68[] field1080 = new class68[8];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -995786429
   )
   int field1082;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass68;I)V",
      garbageValue = "-772504638"
   )
   public final synchronized void method1110(class68 var1) {
      this.field1065 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1763074708"
   )
   public final synchronized void method1111() {
      if(this.field1066 != null) {
         long var1 = class0.method11();

         try {
            if(0L != this.field1060) {
               if(var1 < this.field1060) {
                  return;
               }

               this.vmethod1178(this.field1068);
               this.field1060 = 0L;
               this.field1076 = true;
            }

            int var3 = this.vmethod1177();
            if(this.field1063 - var3 > this.field1072) {
               this.field1072 = this.field1063 - var3;
            }

            int var4 = this.field1082 + this.field1069;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1068) {
               this.field1068 += 1024;
               if(this.field1068 > 16384) {
                  this.field1068 = 16384;
               }

               this.vmethod1179();
               this.vmethod1178(this.field1068);
               var3 = 0;
               this.field1076 = true;
               if(256 + var4 > this.field1068) {
                  var4 = this.field1068 - 256;
                  this.field1082 = var4 - this.field1069;
               }
            }

            while(var3 < var4) {
               this.method1116(this.field1066, 256);
               this.vmethod1174();
               var3 += 256;
            }

            if(var1 > this.field1074) {
               if(!this.field1076) {
                  if(this.field1072 == 0 && this.field1075 == 0) {
                     this.vmethod1179();
                     this.field1060 = 2000L + var1;
                     return;
                  }

                  this.field1082 = Math.min(this.field1075, this.field1072);
                  this.field1075 = this.field1072;
               } else {
                  this.field1076 = false;
               }

               this.field1072 = 0;
               this.field1074 = var1 + 2000L;
            }

            this.field1063 = var3;
         } catch (Exception var7) {
            this.vmethod1179();
            this.field1060 = 2000L + var1;
         }

         try {
            if(var1 > this.field1067 + 500000L) {
               var1 = this.field1067;
            }

            while(var1 > 5000L + this.field1067) {
               this.method1146(256);
               this.field1067 += (long)(256000 / field1061);
            }
         } catch (Exception var6) {
            this.field1067 = var1;
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "369599296"
   )
   public final void method1112() {
      this.field1076 = true;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "16930"
   )
   void vmethod1180() throws Exception {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-4"
   )
   public final synchronized void method1114() {
      if(field1064 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(field1064.field1107[var2] == this) {
               field1064.field1107[var2] = null;
            }

            if(null != field1064.field1107[var2]) {
               var1 = false;
            }
         }

         if(var1) {
            field1064.field1106 = true;

            while(field1064.field1110) {
               class115.method2292(50L);
            }

            field1064 = null;
         }
      }

      this.vmethod1179();
      this.field1066 = null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "-30"
   )
   static char method1115(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1116(int[] var1, int var2) {
      int var3 = var2;
      if(field1070) {
         var3 = var2 << 1;
      }

      class163.method3154(var1, 0, var3);
      this.field1078 -= var2;
      if(null != this.field1065 && this.field1078 <= 0) {
         this.field1078 += field1061 >> 4;
         class49.method973(this.field1065);
         this.method1117(this.field1065, this.field1065.vmethod1401());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class68 var10;
         label148:
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
                  class68 var11 = this.field1071[var17];

                  label142:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label142;
                        }

                        class71 var12 = var11.field1156;
                        if(null != var12 && var12.field1190 > var16) {
                           var5 |= 1 << var17;
                           var10 = var11;
                           var11 = var11.field1157;
                        } else {
                           var11.field1158 = true;
                           int var13 = var11.vmethod2716();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1190 += var13;
                           }

                           if(var4 >= this.field1079) {
                              break label148;
                           }

                           class68 var14 = var11.vmethod2734();
                           if(null != var14) {
                              for(int var15 = var11.field1159; var14 != null; var14 = var11.vmethod2717()) {
                                 this.method1117(var14, var15 * var14.vmethod1401() >> 8);
                              }
                           }

                           class68 var18 = var11.field1157;
                           var11.field1157 = null;
                           if(var10 == null) {
                              this.field1071[var17] = var18;
                           } else {
                              var10.field1157 = var18;
                           }

                           if(null == var18) {
                              this.field1080[var17] = var10;
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
            class68 var7 = this.field1071[var6];
            class68[] var8 = this.field1071;
            this.field1080[var6] = null;

            for(var8[var6] = null; var7 != null; var7 = var10) {
               var10 = var7.field1157;
               var7.field1157 = null;
            }
         }
      }

      if(this.field1078 < 0) {
         this.field1078 = 0;
      }

      if(null != this.field1065) {
         this.field1065.vmethod2718(var1, 0, var2);
      }

      this.field1067 = class0.method11();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass68;II)V",
      garbageValue = "416091442"
   )
   final void method1117(class68 var1, int var2) {
      int var3 = var2 >> 5;
      class68 var4 = this.field1080[var3];
      if(null == var4) {
         this.field1071[var3] = var1;
      } else {
         var4.field1157 = var1;
      }

      this.field1080[var3] = var1;
      var1.field1159 = var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1873899603"
   )
   void vmethod1175(Component var1) throws Exception {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "424306066"
   )
   void vmethod1178(int var1) throws Exception {
   }

   @ObfuscatedName("z")
   void vmethod1174() throws Exception {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1570225197"
   )
   void vmethod1179() {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "693082780"
   )
   int vmethod1177() throws Exception {
      return this.field1068;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "5"
   )
   final void method1146(int var1) {
      this.field1078 -= var1;
      if(this.field1078 < 0) {
         this.field1078 = 0;
      }

      if(this.field1065 != null) {
         this.field1065.vmethod2719(var1);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1296663208"
   )
   public final synchronized void method1150() {
      this.field1076 = true;

      try {
         this.vmethod1180();
      } catch (Exception var2) {
         this.vmethod1179();
         this.field1060 = class0.method11() + 2000L;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1910698101"
   )
   public static int method1156(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "-956968075"
   )
   public static Widget method1157(int var0, int var1) {
      Widget var2 = class179.method3296(var0);
      return var1 == -1?var2:(null != var2 && null != var2.children && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-55"
   )
   static int method1159(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2399((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var2.itemIds[var4] == var1) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }
}
