import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class57 {
   @ObfuscatedName("ap")
   class68[] field1040 = new class68[8];
   @ObfuscatedName("d")
   class68 field1041;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -3549841675014838797L
   )
   long field1042 = 0L;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1034746273
   )
   int field1044 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -46622763
   )
   public static int field1045;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 103440107
   )
   int field1046 = 32;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 5629702528922752259L
   )
   long field1047 = class22.method224();
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1976867325
   )
   int field1048;
   @ObfuscatedName("r")
   static class63 field1049;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 228734465
   )
   int field1050;
   @ObfuscatedName("q")
   int[] field1051;
   @ObfuscatedName("bb")
   static ModIcon[] field1052;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 776673411
   )
   int field1053 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 32949339
   )
   int field1054 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -3897236045850335025L
   )
   long field1055 = 0L;
   @ObfuscatedName("f")
   boolean field1056 = true;
   @ObfuscatedName("y")
   public static boolean field1057;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1465656549
   )
   int field1058 = 0;
   @ObfuscatedName("x")
   class68[] field1059 = new class68[8];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 531209151
   )
   int field1060;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass68;B)V",
      garbageValue = "49"
   )
   public final synchronized void method1056(class68 var1) {
      this.field1041 = var1;
   }

   @ObfuscatedName("t")
   void vmethod1127() throws Exception {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "688812939"
   )
   int vmethod1126() throws Exception {
      return this.field1048;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "654163114"
   )
   public final synchronized void method1060() {
      if(null != field1049) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == field1049.field1095[var2]) {
               field1049.field1095[var2] = null;
            }

            if(field1049.field1095[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1049.field1091 = true;

            while(field1049.field1092) {
               class195.method3560(50L);
            }

            field1049 = null;
         }
      }

      this.vmethod1128();
      this.field1051 = null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "168042820"
   )
   final void method1061(int var1) {
      this.field1058 -= var1;
      if(this.field1058 < 0) {
         this.field1058 = 0;
      }

      if(this.field1041 != null) {
         this.field1041.vmethod2690(var1);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1062(int[] var1, int var2) {
      int var3 = var2;
      if(field1057) {
         var3 = var2 << 1;
      }

      class170.method3224(var1, 0, var3);
      this.field1058 -= var2;
      if(null != this.field1041 && this.field1058 <= 0) {
         this.field1058 += field1045 >> 4;
         class109.method2048(this.field1041);
         this.method1063(this.field1041, this.field1041.vmethod1354());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class68 var10;
         label143:
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
                  class68 var11 = this.field1059[var7];

                  label137:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label137;
                        }

                        class71 var12 = var11.field1145;
                        if(var12 != null && var12.field1176 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1144;
                        } else {
                           var11.field1142 = true;
                           int var13 = var11.vmethod2688();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1176 += var13;
                           }

                           if(var4 >= this.field1046) {
                              break label143;
                           }

                           class68 var14 = var11.vmethod2708();
                           if(var14 != null) {
                              for(int var16 = var11.field1143; var14 != null; var14 = var11.vmethod2687()) {
                                 this.method1063(var14, var16 * var14.vmethod1354() >> 8);
                              }
                           }

                           class68 var15 = var11.field1144;
                           var11.field1144 = null;
                           if(null == var10) {
                              this.field1059[var7] = var15;
                           } else {
                              var10.field1144 = var15;
                           }

                           if(null == var15) {
                              this.field1040[var7] = var10;
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
            class68 var17 = this.field1059[var6];
            class68[] var18 = this.field1059;
            this.field1040[var6] = null;

            for(var18[var6] = null; var17 != null; var17 = var10) {
               var10 = var17.field1144;
               var17.field1144 = null;
            }
         }
      }

      if(this.field1058 < 0) {
         this.field1058 = 0;
      }

      if(null != this.field1041) {
         this.field1041.vmethod2689(var1, 0, var2);
      }

      this.field1047 = class22.method224();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass68;II)V",
      garbageValue = "2077305087"
   )
   final void method1063(class68 var1, int var2) {
      int var3 = var2 >> 5;
      class68 var4 = this.field1040[var3];
      if(var4 == null) {
         this.field1059[var3] = var1;
      } else {
         var4.field1144 = var1;
      }

      this.field1040[var3] = var1;
      var1.field1143 = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "48"
   )
   void vmethod1141(Component var1) throws Exception {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1680339984"
   )
   void vmethod1125(int var1) throws Exception {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "127"
   )
   void vmethod1128() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public final synchronized void method1068() {
      this.field1056 = true;

      try {
         this.vmethod1129();
      } catch (Exception var2) {
         this.vmethod1128();
         this.field1042 = class22.method224() + 2000L;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2102006809"
   )
   void vmethod1129() throws Exception {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1062548573"
   )
   public final synchronized void method1094() {
      if(this.field1051 != null) {
         long var1 = class22.method224();

         try {
            if(0L != this.field1042) {
               if(var1 < this.field1042) {
                  return;
               }

               this.vmethod1125(this.field1048);
               this.field1042 = 0L;
               this.field1056 = true;
            }

            int var3 = this.vmethod1126();
            if(this.field1054 - var3 > this.field1044) {
               this.field1044 = this.field1054 - var3;
            }

            int var4 = this.field1050 + this.field1060;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1048) {
               this.field1048 += 1024;
               if(this.field1048 > 16384) {
                  this.field1048 = 16384;
               }

               this.vmethod1128();
               this.vmethod1125(this.field1048);
               var3 = 0;
               this.field1056 = true;
               if(256 + var4 > this.field1048) {
                  var4 = this.field1048 - 256;
                  this.field1050 = var4 - this.field1060;
               }
            }

            while(var3 < var4) {
               this.method1062(this.field1051, 256);
               this.vmethod1127();
               var3 += 256;
            }

            if(var1 > this.field1055) {
               if(!this.field1056) {
                  if(this.field1044 == 0 && this.field1053 == 0) {
                     this.vmethod1128();
                     this.field1042 = 2000L + var1;
                     return;
                  }

                  this.field1050 = Math.min(this.field1053, this.field1044);
                  this.field1053 = this.field1044;
               } else {
                  this.field1056 = false;
               }

               this.field1044 = 0;
               this.field1055 = var1 + 2000L;
            }

            this.field1054 = var3;
         } catch (Exception var7) {
            this.vmethod1128();
            this.field1042 = 2000L + var1;
         }

         try {
            if(var1 > this.field1047 + 500000L) {
               var1 = this.field1047;
            }

            while(var1 > 5000L + this.field1047) {
               this.method1061(256);
               this.field1047 += (long)(256000 / field1045);
            }
         } catch (Exception var6) {
            this.field1047 = var1;
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "19"
   )
   public final void method1096() {
      this.field1056 = true;
   }
}
