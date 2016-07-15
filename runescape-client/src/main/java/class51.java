import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class51 extends class207 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 911899863
   )
   public int field1120 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1095748897
   )
   public int field1121 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -526282005
   )
   public int field1122 = 0;
   @ObfuscatedName("h")
   static class196 field1123 = new class196(64);
   @ObfuscatedName("r")
   @Export("spriteCache")
   static class196 field1124 = new class196(64);
   @ObfuscatedName("a")
   static class196 field1125 = new class196(20);
   @ObfuscatedName("c")
   public static class170 field1126;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -387864671
   )
   public int field1128 = 16777215;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1383773457
   )
   public int field1129 = 70;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -692696717
   )
   int field1130 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 908700049
   )
   int field1131 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1687615699
   )
   int field1132 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1331325097
   )
   int field1133 = -1;
   @ObfuscatedName("eo")
   static class83[] field1135;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1105780287
   )
   int field1136 = -1;
   @ObfuscatedName("v")
   String field1137 = "";
   @ObfuscatedName("e")
   public static class170 field1138;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 758151293
   )
   public int field1139 = 0;
   @ObfuscatedName("l")
   public static class170 field1141;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1103661903
   )
   public int field1143 = -1;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "1943806193"
   )
   void method1089(class122 var1, int var2) {
      if(var2 == 1) {
         this.field1131 = var1.method2624();
      } else if(var2 == 2) {
         this.field1128 = var1.method2703();
      } else if(var2 == 3) {
         this.field1130 = var1.method2624();
      } else if(var2 == 4) {
         this.field1132 = var1.method2624();
      } else if(var2 == 5) {
         this.field1136 = var1.method2624();
      } else if(var2 == 6) {
         this.field1133 = var1.method2624();
      } else if(var2 == 7) {
         this.field1121 = var1.method2613();
      } else if(var2 == 8) {
         this.field1137 = var1.method2618();
      } else if(var2 == 9) {
         this.field1129 = var1.method2612();
      } else if(var2 == 10) {
         this.field1122 = var1.method2613();
      } else if(var2 == 11) {
         this.field1120 = 0;
      } else if(var2 == 12) {
         this.field1143 = var1.method2610();
      } else if(var2 == 13) {
         this.field1139 = var1.method2613();
      } else if(var2 == 14) {
         this.field1120 = var1.method2612();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1729376427"
   )
   public String method1090(int var1) {
      String var2 = this.field1137;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         String var4 = var2.substring(0, var3);
         String var5 = Integer.toString(var1);
         var2 = var4 + var5 + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lclass81;",
      garbageValue = "957932644"
   )
   public class81 method1091() {
      if(this.field1130 < 0) {
         return null;
      } else {
         class81 var1 = (class81)field1124.method3834((long)this.field1130);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class117.method2533(field1141, this.field1130, 0);
            if(null != var1) {
               field1124.method3836(var1, (long)this.field1130);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "2063265209"
   )
   void method1092(class122 var1) {
      while(true) {
         int var2 = var1.method2610();
         if(var2 == 0) {
            return;
         }

         this.method1089(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Lclass81;",
      garbageValue = "-1274474643"
   )
   public class81 method1093() {
      if(this.field1132 < 0) {
         return null;
      } else {
         class81 var1 = (class81)field1124.method3834((long)this.field1132);
         if(null != var1) {
            return var1;
         } else {
            var1 = class117.method2533(field1141, this.field1132, 0);
            if(null != var1) {
               field1124.method3836(var1, (long)this.field1132);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Lclass227;",
      garbageValue = "313201856"
   )
   public class227 method1095() {
      if(this.field1131 == -1) {
         return null;
      } else {
         class227 var1 = (class227)field1125.method3834((long)this.field1131);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class116.method2519(field1141, field1126, this.field1131, 0);
            if(null != var1) {
               field1125.method3836(var1, (long)this.field1131);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Lclass81;",
      garbageValue = "1457357219"
   )
   public class81 method1109() {
      if(this.field1136 < 0) {
         return null;
      } else {
         class81 var1 = (class81)field1124.method3834((long)this.field1136);
         if(null != var1) {
            return var1;
         } else {
            var1 = class117.method2533(field1141, this.field1136, 0);
            if(null != var1) {
               field1124.method3836(var1, (long)this.field1136);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lclass81;",
      garbageValue = "-2120779431"
   )
   public class81 method1116() {
      if(this.field1133 < 0) {
         return null;
      } else {
         class81 var1 = (class81)field1124.method3834((long)this.field1133);
         if(null != var1) {
            return var1;
         } else {
            var1 = class117.method2533(field1141, this.field1133, 0);
            if(var1 != null) {
               field1124.method3836(var1, (long)this.field1133);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Lclass27;",
      garbageValue = "-91"
   )
   static class27 method1119() {
      return class27.field679 < class27.field673?class118.field2032[++class27.field679 - 1]:null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1519346278"
   )
   public static int method1120(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(IIIILclass81;Lclass178;I)V",
      garbageValue = "-1985843197"
   )
   static final void method1121(int var0, int var1, int var2, int var3, class81 var4, class178 var5) {
      if(var4 != null) {
         int var6 = client.field365 + client.field514 & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = class94.field1655[var6];
            int var9 = class94.field1653[var6];
            var8 = 256 * var8 / (256 + client.field327);
            var9 = 256 * var9 / (256 + client.field327);
            int var10 = var3 * var8 + var9 * var2 >> 16;
            int var11 = var9 * var3 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method1815(var5.field2940 / 2 + var10 - var4.field1471 / 2, var5.field2938 / 2 - var11 - var4.field1469 / 2, var0, var1, var5.field2940, var5.field2938, var5.field2937, var5.field2939);
            } else {
               var4.method1873(var5.field2940 / 2 + var0 + var10 - var4.field1471 / 2, var5.field2938 / 2 + var1 - var11 - var4.field1469 / 2);
            }

         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1566088616"
   )
   static void method1122(int var0, int var1, int var2, int var3) {
      class15 var4 = (class15)class15.field227.method3864((long)var0);
      if(var4 == null) {
         var4 = new class15();
         class15.field227.method3865(var4, (long)var0);
      }

      if(var4.field226.length <= var1) {
         int[] var5 = new int[1 + var1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.field226.length; ++var7) {
            var5[var7] = var4.field226[var7];
            var6[var7] = var4.field228[var7];
         }

         for(var7 = var4.field226.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.field226 = var5;
         var4.field228 = var6;
      }

      var4.field226[var1] = var2;
      var4.field228[var1] = var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass122;IIIIIII)V",
      garbageValue = "-1257139915"
   )
   static final void method1123(class122 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.field89[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2610();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class5.field78[0][var2];
                  int var11 = var2 + 932731 + var4;
                  int var12 = var5 + 556238 + var3;
                  int var13 = class127.method2903(var11 + '넵', 91923 + var12, 4) - 128 + (class127.method2903(var11 + 10294, '鎽' + var12, 2) - 128 >> 1) + (class127.method2903(var11, var12, 1) - 128 >> 2);
                  var13 = (int)((double)var13 * 0.3D) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = -var13 * 8;
               } else {
                  class5.field78[var1][var2][var3] = class5.field78[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.method2610();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class5.field78[0][var2][var3] = -var14 * 8;
               } else {
                  class5.field78[var1][var2][var3] = class5.field78[var1 - 1][var2][var3] - 8 * var14;
               }
               break;
            }

            if(var7 <= 49) {
               class5.field91[var1][var2][var3] = var0.method2611();
               class219.field3204[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class5.field81[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class5.field89[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class5.field80[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2610();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.method2610();
               break;
            }

            if(var7 <= 49) {
               var0.method2610();
            }
         }
      }

   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)V",
      garbageValue = "516296398"
   )
   static void method1124(class176 var0) {
      if(var0.field2821 == client.field499) {
         client.field500[var0.field2925] = true;
      }

   }
}
