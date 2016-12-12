import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public class class57 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1290809659
   )
   int field1039;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1986774973
   )
   int field1040 = 0;
   @ObfuscatedName("q")
   class68 field1041;
   @ObfuscatedName("x")
   boolean field1044 = true;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1955942969
   )
   int field1046 = 32;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 446495388590216693L
   )
   long field1047 = class72.method1385();
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 880370017
   )
   int field1048;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2130253403
   )
   int field1049 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -780038731
   )
   int field1050;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 7768315225008055663L
   )
   long field1051 = 0L;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1257832107
   )
   public static int field1053;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1446036635
   )
   int field1054 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -5998660364932682917L
   )
   long field1055 = 0L;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1079665093
   )
   public static int field1056;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -315622125
   )
   int field1059 = 0;
   @ObfuscatedName("o")
   class68[] field1060 = new class68[8];
   @ObfuscatedName("ak")
   class68[] field1061 = new class68[8];
   @ObfuscatedName("e")
   public static boolean field1062;
   @ObfuscatedName("a")
   int[] field1066;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "1967"
   )
   void vmethod1087(int var1) throws Exception {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass68;I)V",
      garbageValue = "-1320782788"
   )
   public final synchronized void method1015(class68 var1) {
      this.field1041 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-922531798"
   )
   public final synchronized void method1016() {
      if(null != this.field1066) {
         long var1 = class72.method1385();

         try {
            if(0L != this.field1051) {
               if(var1 < this.field1051) {
                  return;
               }

               this.vmethod1087(this.field1048);
               this.field1051 = 0L;
               this.field1044 = true;
            }

            int var3 = this.vmethod1088();
            if(this.field1054 - var3 > this.field1049) {
               this.field1049 = this.field1054 - var3;
            }

            int var4 = this.field1039 + this.field1050;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1048) {
               this.field1048 += 1024;
               if(this.field1048 > 16384) {
                  this.field1048 = 16384;
               }

               this.vmethod1090();
               this.vmethod1087(this.field1048);
               var3 = 0;
               this.field1044 = true;
               if(256 + var4 > this.field1048) {
                  var4 = this.field1048 - 256;
                  this.field1050 = var4 - this.field1039;
               }
            }

            while(var3 < var4) {
               this.method1021(this.field1066, 256);
               this.vmethod1089();
               var3 += 256;
            }

            if(var1 > this.field1055) {
               if(!this.field1044) {
                  if(this.field1049 == 0 && this.field1040 == 0) {
                     this.vmethod1090();
                     this.field1051 = var1 + 2000L;
                     return;
                  }

                  this.field1050 = Math.min(this.field1040, this.field1049);
                  this.field1040 = this.field1049;
               } else {
                  this.field1044 = false;
               }

               this.field1049 = 0;
               this.field1055 = var1 + 2000L;
            }

            this.field1054 = var3;
         } catch (Exception var7) {
            this.vmethod1090();
            this.field1051 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1047) {
               var1 = this.field1047;
            }

            while(var1 > this.field1047 + 5000L) {
               this.method1043(256);
               this.field1047 += (long)(256000 / field1053);
            }
         } catch (Exception var6) {
            this.field1047 = var1;
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-735957139"
   )
   public final void method1017() {
      this.field1044 = true;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public final synchronized void method1018() {
      this.field1044 = true;

      try {
         this.vmethod1102();
      } catch (Exception var2) {
         this.vmethod1090();
         this.field1051 = class72.method1385() + 2000L;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2087088824"
   )
   public final synchronized void method1019() {
      if(null != class186.field2770) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class186.field2770.field1090[var2]) {
               class186.field2770.field1090[var2] = null;
            }

            if(class186.field2770.field1090[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class186.field2770.field1089 = true;

            while(class186.field2770.field1091) {
               class10.method149(50L);
            }

            class186.field2770 = null;
         }
      }

      this.vmethod1090();
      this.field1066 = null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1021(int[] var1, int var2) {
      int var3 = var2;
      if(field1062) {
         var3 = var2 << 1;
      }

      class163.method3016(var1, 0, var3);
      this.field1059 -= var2;
      if(this.field1041 != null && this.field1059 <= 0) {
         this.field1059 += field1053 >> 4;
         GameEngine.method2156(this.field1041);
         this.method1063(this.field1041, this.field1041.vmethod1324());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class68 var10;
         label133:
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
                  class68 var11 = this.field1060[var7];

                  label127:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label127;
                        }

                        class71 var12 = var11.field1147;
                        if(var12 != null && var12.field1179 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1146;
                        } else {
                           var11.field1145 = true;
                           int var13 = var11.vmethod2649();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1179 += var13;
                           }

                           if(var4 >= this.field1046) {
                              break label133;
                           }

                           class68 var14 = var11.vmethod2666();
                           if(var14 != null) {
                              for(int var15 = var11.field1148; null != var14; var14 = var11.vmethod2658()) {
                                 this.method1063(var14, var15 * var14.vmethod1324() >> 8);
                              }
                           }

                           class68 var18 = var11.field1146;
                           var11.field1146 = null;
                           if(var10 == null) {
                              this.field1060[var7] = var18;
                           } else {
                              var10.field1146 = var18;
                           }

                           if(null == var18) {
                              this.field1061[var7] = var10;
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
            class68 var17 = this.field1060[var6];
            class68[] var16 = this.field1060;
            this.field1061[var6] = null;

            for(var16[var6] = null; null != var17; var17 = var10) {
               var10 = var17.field1146;
               var17.field1146 = null;
            }
         }
      }

      if(this.field1059 < 0) {
         this.field1059 = 0;
      }

      if(null != this.field1041) {
         this.field1041.vmethod2665(var1, 0, var2);
      }

      this.field1047 = class72.method1385();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;B)[LSpritePixels;",
      garbageValue = "47"
   )
   public static SpritePixels[] method1024(class182 var0, String var1, String var2) {
      int var3 = var0.method3225(var1);
      int var4 = var0.method3226(var3, var2);
      SpritePixels[] var5;
      if(!class178.method3196(var0, var3, var4)) {
         var5 = null;
      } else {
         SpritePixels[] var7 = new SpritePixels[class225.field3214];

         for(int var8 = 0; var8 < class225.field3214; ++var8) {
            SpritePixels var9 = var7[var8] = new SpritePixels();
            var9.field3210 = class225.field3215;
            var9.field3208 = class225.field3216;
            var9.field3207 = class225.field3217[var8];
            var9.field3206 = RSCanvas.field1748[var8];
            var9.width = class225.field3218[var8];
            var9.height = Item.field897[var8];
            int var10 = var9.width * var9.height;
            byte[] var11 = class154.field2106[var8];
            var9.image = new int[var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               var9.image[var12] = class167.field2191[var11[var12] & 255];
            }
         }

         class185.method3361();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1328991728"
   )
   int vmethod1088() throws Exception {
      return this.field1048;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "1901261212"
   )
   static final void method1026(Actor var0) {
      int var1 = var0.field602 - Client.gameCycle;
      int var2 = var0.field606 * 128 + var0.field640 * 64;
      int var3 = var0.field640 * 64 + var0.field642 * 128;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field603 = 0;
      var0.field649 = var0.field653;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void vmethod1090() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   final void method1043(int var1) {
      this.field1059 -= var1;
      if(this.field1059 < 0) {
         this.field1059 = 0;
      }

      if(null != this.field1041) {
         this.field1041.vmethod2651(var1);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "-10645"
   )
   static void method1046(int var0, int var1, int var2, int var3) {
      for(class31 var4 = (class31)class31.field706.method2359(); var4 != null; var4 = (class31)class31.field706.method2361()) {
         if(var4.field705 != -1 || var4.field707 != null) {
            int var5 = 0;
            if(var1 > var4.field702) {
               var5 += var1 - var4.field702;
            } else if(var1 < var4.field700) {
               var5 += var4.field700 - var1;
            }

            if(var2 > var4.field703) {
               var5 += var2 - var4.field703;
            } else if(var2 < var4.field701) {
               var5 += var4.field701 - var2;
            }

            if(var5 - 64 <= var4.field704 && Client.field527 != 0 && var4.field699 == var0) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field704 - var5) * Client.field527 / var4.field704;
               if(null == var4.field709) {
                  if(var4.field705 >= 0) {
                     class53 var7 = class53.method950(VertexNormal.field1425, var4.field705, 0);
                     if(var7 != null) {
                        class55 var8 = var7.method938().method989(MessageNode.field229);
                        class66 var9 = class66.method1159(var8, 100, var6);
                        var9.method1162(-1);
                        class0.field3.method882(var9);
                        var4.field709 = var9;
                     }
                  }
               } else {
                  var4.field709.method1163(var6);
               }

               if(var4.field714 == null) {
                  if(var4.field707 != null && (var4.field710 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field707.length);
                     class53 var12 = class53.method950(VertexNormal.field1425, var4.field707[var11], 0);
                     if(var12 != null) {
                        class55 var13 = var12.method938().method989(MessageNode.field229);
                        class66 var10 = class66.method1159(var13, 100, var6);
                        var10.method1162(0);
                        class0.field3.method882(var10);
                        var4.field714 = var10;
                        var4.field710 = var4.field713 + (int)(Math.random() * (double)(var4.field708 - var4.field713));
                     }
                  }
               } else {
                  var4.field714.method1163(var6);
                  if(!var4.field714.linked()) {
                     var4.field714 = null;
                  }
               }
            } else {
               if(var4.field709 != null) {
                  class0.field3.method911(var4.field709);
                  var4.field709 = null;
               }

               if(null != var4.field714) {
                  class0.field3.method911(var4.field714);
                  var4.field714 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1060492503"
   )
   void vmethod1102() throws Exception {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass68;II)V",
      garbageValue = "97871583"
   )
   final void method1063(class68 var1, int var2) {
      int var3 = var2 >> 5;
      class68 var4 = this.field1061[var3];
      if(null == var4) {
         this.field1060[var3] = var1;
      } else {
         var4.field1146 = var1;
      }

      this.field1061[var3] = var1;
      var1.field1148 = var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-321887627"
   )
   void vmethod1086(Component var1) throws Exception {
   }

   @ObfuscatedName("r")
   void vmethod1089() throws Exception {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1627332737"
   )
   public static int method1067(String var0) {
      return var0.length() + 1;
   }
}
