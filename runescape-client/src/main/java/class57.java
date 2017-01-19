import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class57 {
   @ObfuscatedName("mg")
   @Export("clanMembers")
   static XClanMember[] clanMembers;
   @ObfuscatedName("u")
   class68 field1037;
   @ObfuscatedName("h")
   static class63 field1038;
   @ObfuscatedName("z")
   boolean field1041 = true;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -918354979
   )
   int field1042 = 32;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -8083424298617766793L
   )
   long field1043 = class2.method27();
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 307060431
   )
   int field1044;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -7318401
   )
   int field1045 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -940174677
   )
   int field1046;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 6304695581561186431L
   )
   long field1047 = 0L;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1163889567
   )
   int field1048;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1373145715
   )
   int field1049 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1284215267
   )
   int field1050 = 0;
   @ObfuscatedName("k")
   int[] field1051;
   @ObfuscatedName("c")
   static boolean field1052;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 405975381
   )
   int field1053 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -7978041307077004433L
   )
   long field1054 = 0L;
   @ObfuscatedName("az")
   class68[] field1055 = new class68[8];
   @ObfuscatedName("v")
   class68[] field1056 = new class68[8];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1844529635
   )
   public static int field1057;
   @ObfuscatedName("qa")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;

   @ObfuscatedName("o")
   void vmethod1063() throws Exception {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass68;I)V",
      garbageValue = "82003021"
   )
   public final synchronized void method994(class68 var1) {
      this.field1037 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2039292152"
   )
   public static int method995() {
      return ++class115.mouseIdleTicks - 1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   public final synchronized void method996() {
      if(null != field1038) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(field1038.field1093[var2] == this) {
               field1038.field1093[var2] = null;
            }

            if(null != field1038.field1093[var2]) {
               var1 = false;
            }
         }

         if(var1) {
            field1038.field1091 = true;

            while(field1038.field1089) {
               Projectile.method757(50L);
            }

            field1038 = null;
         }
      }

      this.vmethod1076();
      this.field1051 = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "16007223"
   )
   final void method999(int var1) {
      this.field1053 -= var1;
      if(this.field1053 < 0) {
         this.field1053 = 0;
      }

      if(null != this.field1037) {
         this.field1037.vmethod2615(var1);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1000(int[] var1, int var2) {
      int var3 = var2;
      if(field1052) {
         var3 = var2 << 1;
      }

      class163.method3010(var1, 0, var3);
      this.field1053 -= var2;
      if(this.field1037 != null && this.field1053 <= 0) {
         this.field1053 += field1057 >> 4;
         class32.method668(this.field1037);
         this.method1001(this.field1037, this.field1037.vmethod1331());
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
                  class68 var11 = this.field1056[var7];

                  label131:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label131;
                        }

                        class71 var12 = var11.field1141;
                        if(null != var12 && var12.field1173 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1142;
                        } else {
                           var11.field1139 = true;
                           int var13 = var11.vmethod2632();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1173 += var13;
                           }

                           if(var4 >= this.field1042) {
                              break label137;
                           }

                           class68 var14 = var11.vmethod2611();
                           if(null != var14) {
                              for(int var15 = var11.field1140; var14 != null; var14 = var11.vmethod2612()) {
                                 this.method1001(var14, var15 * var14.vmethod1331() >> 8);
                              }
                           }

                           class68 var17 = var11.field1142;
                           var11.field1142 = null;
                           if(var10 == null) {
                              this.field1056[var7] = var17;
                           } else {
                              var10.field1142 = var17;
                           }

                           if(var17 == null) {
                              this.field1055[var7] = var10;
                           }

                           var11 = var17;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class68 var18 = this.field1056[var6];
            class68[] var16 = this.field1056;
            this.field1055[var6] = null;

            for(var16[var6] = null; null != var18; var18 = var10) {
               var10 = var18.field1142;
               var18.field1142 = null;
            }
         }
      }

      if(this.field1053 < 0) {
         this.field1053 = 0;
      }

      if(this.field1037 != null) {
         this.field1037.vmethod2614(var1, 0, var2);
      }

      this.field1043 = class2.method27();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass68;IB)V",
      garbageValue = "1"
   )
   final void method1001(class68 var1, int var2) {
      int var3 = var2 >> 5;
      class68 var4 = this.field1055[var3];
      if(var4 == null) {
         this.field1056[var3] = var1;
      } else {
         var4.field1142 = var1;
      }

      this.field1055[var3] = var1;
      var1.field1140 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-276519453"
   )
   void vmethod1061(Component var1) throws Exception {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1015404573"
   )
   void vmethod1062(int var1) throws Exception {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1667009384"
   )
   int vmethod1077() throws Exception {
      return this.field1044;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1270143511"
   )
   void vmethod1065() throws Exception {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "61"
   )
   public final synchronized void method1017() {
      this.field1041 = true;

      try {
         this.vmethod1065();
      } catch (Exception var2) {
         this.vmethod1076();
         this.field1047 = class2.method27() + 2000L;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-122"
   )
   public final void method1019() {
      this.field1041 = true;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "99639815"
   )
   void vmethod1076() {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1835567237"
   )
   public final synchronized void method1033() {
      if(null != this.field1051) {
         long var1 = class2.method27();

         try {
            if(this.field1047 != 0L) {
               if(var1 < this.field1047) {
                  return;
               }

               this.vmethod1062(this.field1044);
               this.field1047 = 0L;
               this.field1041 = true;
            }

            int var3 = this.vmethod1077();
            if(this.field1050 - var3 > this.field1045) {
               this.field1045 = this.field1050 - var3;
            }

            int var4 = this.field1046 + this.field1048;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1044) {
               this.field1044 += 1024;
               if(this.field1044 > 16384) {
                  this.field1044 = 16384;
               }

               this.vmethod1076();
               this.vmethod1062(this.field1044);
               var3 = 0;
               this.field1041 = true;
               if(256 + var4 > this.field1044) {
                  var4 = this.field1044 - 256;
                  this.field1046 = var4 - this.field1048;
               }
            }

            while(var3 < var4) {
               this.method1000(this.field1051, 256);
               this.vmethod1063();
               var3 += 256;
            }

            if(var1 > this.field1054) {
               if(!this.field1041) {
                  if(this.field1045 == 0 && this.field1049 == 0) {
                     this.vmethod1076();
                     this.field1047 = 2000L + var1;
                     return;
                  }

                  this.field1046 = Math.min(this.field1049, this.field1045);
                  this.field1049 = this.field1045;
               } else {
                  this.field1041 = false;
               }

               this.field1045 = 0;
               this.field1054 = var1 + 2000L;
            }

            this.field1050 = var3;
         } catch (Exception var7) {
            this.vmethod1076();
            this.field1047 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1043) {
               var1 = this.field1043;
            }

            while(var1 > this.field1043 + 5000L) {
               this.method999(256);
               this.field1043 += (long)(256000 / field1057);
            }
         } catch (Exception var6) {
            this.field1043 = var1;
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "-1267708809"
   )
   static void method1045(GameEngine var0) {
      if(class115.field1807 == 1 || !class10.field110 && class115.field1807 == 4) {
         int var1 = 280 + class41.field814;
         if(class115.field1809 >= var1 && class115.field1809 <= var1 + 14 && class115.field1796 >= 4 && class115.field1796 <= 18) {
            class157.method2956(0, 0);
            return;
         }

         if(class115.field1809 >= 15 + var1 && class115.field1809 <= 80 + var1 && class115.field1796 >= 4 && class115.field1796 <= 18) {
            class157.method2956(0, 1);
            return;
         }

         int var2 = class41.field814 + 390;
         if(class115.field1809 >= var2 && class115.field1809 <= 14 + var2 && class115.field1796 >= 4 && class115.field1796 <= 18) {
            class157.method2956(1, 0);
            return;
         }

         if(class115.field1809 >= var2 + 15 && class115.field1809 <= var2 + 80 && class115.field1796 >= 4 && class115.field1796 <= 18) {
            class157.method2956(1, 1);
            return;
         }

         int var3 = class41.field814 + 500;
         if(class115.field1809 >= var3 && class115.field1809 <= var3 + 14 && class115.field1796 >= 4 && class115.field1796 <= 18) {
            class157.method2956(2, 0);
            return;
         }

         if(class115.field1809 >= 15 + var3 && class115.field1809 <= var3 + 80 && class115.field1796 >= 4 && class115.field1796 <= 18) {
            class157.method2956(2, 1);
            return;
         }

         int var4 = 610 + class41.field814;
         if(class115.field1809 >= var4 && class115.field1809 <= var4 + 14 && class115.field1796 >= 4 && class115.field1796 <= 18) {
            class157.method2956(3, 0);
            return;
         }

         if(class115.field1809 >= 15 + var4 && class115.field1809 <= var4 + 80 && class115.field1796 >= 4 && class115.field1796 <= 18) {
            class157.method2956(3, 1);
            return;
         }

         if(class115.field1809 >= 708 + class41.field814 && class115.field1796 >= 4 && class115.field1809 <= 50 + class41.field814 + 708 && class115.field1796 <= 20) {
            class41.worldSelectShown = false;
            class41.field815.method3969(class41.field814, 0);
            class39.field798.method3969(class41.field814 + 382, 0);
            class41.field816.method3919(class41.field814 + 382 - class41.field816.originalWidth / 2, 18);
            return;
         }

         if(class41.field846 != -1) {
            World var5 = World.worldList[class41.field846];
            if(var5.method621() != Client.isMembers) {
               Client.isMembers = var5.method621();
               boolean var6 = var5.method621();
               if(ItemComposition.isMembersWorld != var6) {
                  ItemComposition.field2986.reset();
                  ItemComposition.itemModelCache.reset();
                  ItemComposition.itemSpriteCache.reset();
                  ItemComposition.isMembersWorld = var6;
               }
            }

            class178.host = var5.address;
            Client.world = var5.id;
            Client.flags = var5.mask;
            class0.field6 = Client.field297 == 0?'ꩊ':var5.id + '鱀';
            CombatInfo2.field2843 = Client.field297 == 0?443:var5.id + '썐';
            class26.field602 = class0.field6;
            class41.worldSelectShown = false;
            class41.field815.method3969(class41.field814, 0);
            class39.field798.method3969(class41.field814 + 382, 0);
            class41.field816.method3919(382 + class41.field814 - class41.field816.originalWidth / 2, 18);
            return;
         }
      }

   }
}
