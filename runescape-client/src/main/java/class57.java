import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class57 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -420753879
   )
   public static int field1051;
   @ObfuscatedName("d")
   static class63 field1052;
   @ObfuscatedName("u")
   int[] field1053;
   @ObfuscatedName("an")
   class68[] field1054 = new class68[8];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -244661301
   )
   int field1055 = 0;
   @ObfuscatedName("k")
   class68 field1056;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 827574283
   )
   int field1057 = 32;
   @ObfuscatedName("j")
   public static boolean field1058;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -542265447
   )
   int field1059;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -421179299
   )
   int field1060;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -444244783
   )
   int field1061;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -2868067247382367121L
   )
   long field1062 = 0L;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1687597983
   )
   int field1063 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -3716090343765312053L
   )
   long field1065 = class99.method2005();
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 6472754379567542231L
   )
   long field1066 = 0L;
   @ObfuscatedName("f")
   boolean field1067 = true;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 641289067
   )
   int field1068 = 0;
   @ObfuscatedName("o")
   class68[] field1069 = new class68[8];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 461787561
   )
   int field1070 = 0;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1109152631"
   )
   public final synchronized void method1122() {
      if(this.field1053 != null) {
         long var1 = class99.method2005();

         try {
            if(this.field1062 != 0L) {
               if(var1 < this.field1062) {
                  return;
               }

               this.vmethod1198(this.field1059);
               this.field1062 = 0L;
               this.field1067 = true;
            }

            int var3 = this.vmethod1197();
            if(this.field1055 - var3 > this.field1063) {
               this.field1063 = this.field1055 - var3;
            }

            int var4 = this.field1060 + this.field1061;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1059) {
               this.field1059 += 1024;
               if(this.field1059 > 16384) {
                  this.field1059 = 16384;
               }

               this.vmethod1201();
               this.vmethod1198(this.field1059);
               var3 = 0;
               this.field1067 = true;
               if(var4 + 256 > this.field1059) {
                  var4 = this.field1059 - 256;
                  this.field1061 = var4 - this.field1060;
               }
            }

            while(var3 < var4) {
               this.method1148(this.field1053, 256);
               this.vmethod1200();
               var3 += 256;
            }

            if(var1 > this.field1066) {
               if(!this.field1067) {
                  if(this.field1063 == 0 && this.field1070 == 0) {
                     this.vmethod1201();
                     this.field1062 = 2000L + var1;
                     return;
                  }

                  this.field1061 = Math.min(this.field1070, this.field1063);
                  this.field1070 = this.field1063;
               } else {
                  this.field1067 = false;
               }

               this.field1063 = 0;
               this.field1066 = var1 + 2000L;
            }

            this.field1055 = var3;
         } catch (Exception var7) {
            this.vmethod1201();
            this.field1062 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1065) {
               var1 = this.field1065;
            }

            while(var1 > 5000L + this.field1065) {
               this.method1126(256);
               this.field1065 += (long)(256000 / class148.field2033);
            }
         } catch (Exception var6) {
            this.field1065 = var1;
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "441689683"
   )
   public final void method1123() {
      this.field1067 = true;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1065338865"
   )
   public final synchronized void method1124() {
      this.field1067 = true;

      try {
         this.vmethod1202();
      } catch (Exception var2) {
         this.vmethod1201();
         this.field1062 = class99.method2005() + 2000L;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-133617117"
   )
   public final synchronized void method1125() {
      if(null != field1052) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == field1052.field1096[var2]) {
               field1052.field1096[var2] = null;
            }

            if(field1052.field1096[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1052.field1095 = true;

            while(field1052.field1098) {
               class140.method2660(50L);
            }

            field1052 = null;
         }
      }

      this.vmethod1201();
      this.field1053 = null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "6490664"
   )
   final void method1126(int var1) {
      this.field1068 -= var1;
      if(this.field1068 < 0) {
         this.field1068 = 0;
      }

      if(this.field1056 != null) {
         this.field1056.vmethod2729(var1);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1814248783"
   )
   void vmethod1196(Component var1) throws Exception {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "119"
   )
   int vmethod1197() throws Exception {
      return this.field1059;
   }

   @ObfuscatedName("m")
   void vmethod1200() throws Exception {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   void vmethod1201() {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-11"
   )
   void vmethod1202() throws Exception {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1148(int[] var1, int var2) {
      int var3 = var2;
      if(field1058) {
         var3 = var2 << 1;
      }

      class163.method3134(var1, 0, var3);
      this.field1068 -= var2;
      if(this.field1056 != null && this.field1068 <= 0) {
         this.field1068 += class148.field2033 >> 4;
         class172.method3268(this.field1056);
         this.method1162(this.field1056, this.field1056.vmethod1412());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class68 var10;
         label140:
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
                  class68 var11 = this.field1069[var7];

                  label134:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label134;
                        }

                        class71 var12 = var11.field1147;
                        if(null != var12 && var12.field1181 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1150;
                        } else {
                           var11.field1149 = true;
                           int var13 = var11.vmethod2725();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1181 += var13;
                           }

                           if(var4 >= this.field1057) {
                              break label140;
                           }

                           class68 var14 = var11.vmethod2723();
                           if(var14 != null) {
                              for(int var15 = var11.field1148; null != var14; var14 = var11.vmethod2724()) {
                                 this.method1162(var14, var15 * var14.vmethod1412() >> 8);
                              }
                           }

                           class68 var16 = var11.field1150;
                           var11.field1150 = null;
                           if(null == var10) {
                              this.field1069[var7] = var16;
                           } else {
                              var10.field1150 = var16;
                           }

                           if(null == var16) {
                              this.field1054[var7] = var10;
                           }

                           var11 = var16;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class68 var17 = this.field1069[var6];
            class68[] var18 = this.field1069;
            this.field1054[var6] = null;

            for(var18[var6] = null; null != var17; var17 = var10) {
               var10 = var17.field1150;
               var17.field1150 = null;
            }
         }
      }

      if(this.field1068 < 0) {
         this.field1068 = 0;
      }

      if(this.field1056 != null) {
         this.field1056.vmethod2726(var1, 0, var2);
      }

      this.field1065 = class99.method2005();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-174800655"
   )
   public static void method1152() {
      class227.field3248 = new CombatInfoList();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass68;I)V",
      garbageValue = "925567235"
   )
   public final synchronized void method1155(class68 var1) {
      this.field1056 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass68;II)V",
      garbageValue = "2054224009"
   )
   final void method1162(class68 var1, int var2) {
      int var3 = var2 >> 5;
      class68 var4 = this.field1054[var3];
      if(var4 == null) {
         this.field1069[var3] = var1;
      } else {
         var4.field1150 = var1;
      }

      this.field1054[var3] = var1;
      var1.field1148 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-110"
   )
   static void method1163(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field694[var5]) {
            var2[var4] = World.field694[var5];
            var3[var4] = World.field708[var5];
            ++var4;
         }
      }

      World.field694 = var2;
      World.field708 = var3;
      class115.method2274(World.worldList, 0, World.worldList.length - 1, World.field694, World.field708);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-61"
   )
   void vmethod1198(int var1) throws Exception {
   }
}
