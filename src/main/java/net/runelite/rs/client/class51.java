package net.runelite.rs.client;

import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("an")
@Implements("ItemComposition")
public class class51 extends class203 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1429352995
   )
   public int field1089 = 0;
   @ObfuscatedName("u")
   static class166 field1091;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 933815231
   )
   public static int field1092;
   @ObfuscatedName("i")
   static class192 field1093 = new class192(64);
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1488997567
   )
   int field1094 = -1;
   @ObfuscatedName("k")
   public static class192 field1095 = new class192(200);
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1992984623
   )
   int field1096 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 5752205
   )
   public int field1097;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1109152797
   )
   int field1098;
   @ObfuscatedName("z")
   @Export("name")
   public String field1099 = "null";
   @ObfuscatedName("p")
   short[] field1100;
   @ObfuscatedName("r")
   short[] field1101;
   @ObfuscatedName("g")
   short[] field1102;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 504295945
   )
   public int field1103 = 0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1221468219
   )
   public int field1104 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1613633133
   )
   public int field1105 = 0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1121039703
   )
   int field1106 = 128;
   @ObfuscatedName("n")
   short[] field1107;
   @ObfuscatedName("ao")
   public String[] field1108 = new String[]{null, null, "Take", null, null};
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -301022625
   )
   int field1109 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 505705233
   )
   public int field1110 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1453507265
   )
   public int field1111 = 1;
   @ObfuscatedName("aa")
   @Export("isMembers")
   public boolean field1112 = false;
   @ObfuscatedName("s")
   static class223 field1113;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 782052635
   )
   public int field1114 = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 882419123
   )
   int field1115 = -1;
   @ObfuscatedName("as")
   public String[] field1116 = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 2047351829
   )
   int field1117 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -974075617
   )
   int field1118 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -233101163
   )
   int field1119 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -201361111
   )
   int field1120 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 722767725
   )
   int field1121 = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1254197041
   )
   int field1123 = -1;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -2013586615
   )
   public int field1124 = 0;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 301671791
   )
   int field1125 = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 859331687
   )
   int field1126 = -1;
   @ObfuscatedName("ah")
   int[] field1127;
   @ObfuscatedName("ak")
   int[] field1128;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1856464853
   )
   public int field1129 = 2000;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2068140537
   )
   public int field1130 = 0;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 561895613
   )
   int field1131 = -1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -409889251
   )
   int field1132 = 128;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1435879903
   )
   int field1133 = 128;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1698637451
   )
   public int field1134 = 0;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1586299195
   )
   public int field1135 = 0;
   @ObfuscatedName("t")
   static class192 field1136 = new class192(50);
   @ObfuscatedName("an")
   public boolean field1137 = false;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1972797439
   )
   int field1138 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 233412275
   )
   public int field1139 = 0;

   @ObfuscatedName("u")
   void method1069(class118 var1, int var2) {
      if(var2 == 1) {
         this.field1098 = var1.method2538();
      } else if(2 == var2) {
         this.field1099 = var1.method2544();
      } else if(4 == var2) {
         this.field1129 = var1.method2538();
      } else if(5 == var2) {
         this.field1105 = var1.method2538();
      } else if(var2 == 6) {
         this.field1103 = var1.method2538();
      } else if(7 == var2) {
         this.field1139 = var1.method2538();
         if(this.field1139 > 32767) {
            this.field1139 -= 65536;
         }
      } else if(8 == var2) {
         this.field1130 = var1.method2538();
         if(this.field1130 > 32767) {
            this.field1130 -= 65536;
         }
      } else if(11 == var2) {
         this.field1110 = 1;
      } else if(var2 == 12) {
         this.field1111 = var1.method2541();
      } else if(var2 == 16) {
         this.field1112 = true;
      } else if(23 == var2) {
         this.field1115 = var1.method2538();
         this.field1117 = var1.method2536();
      } else if(24 == var2) {
         this.field1096 = var1.method2538();
      } else if(25 == var2) {
         this.field1118 = var1.method2538();
         this.field1120 = var1.method2536();
      } else if(26 == var2) {
         this.field1119 = var1.method2538();
      } else if(var2 >= 30 && var2 < 35) {
         this.field1108[var2 - 30] = var1.method2544();
         if(this.field1108[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field1108[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.field1116[var2 - 35] = var1.method2544();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2536();
            this.field1100 = new short[var3];
            this.field1101 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1100[var4] = (short)var1.method2538();
               this.field1101[var4] = (short)var1.method2538();
            }
         } else if(var2 == 41) {
            var3 = var1.method2536();
            this.field1102 = new short[var3];
            this.field1107 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1102[var4] = (short)var1.method2538();
               this.field1107[var4] = (short)var1.method2538();
            }
         } else if(var2 == 65) {
            this.field1137 = true;
         } else if(var2 == 78) {
            this.field1121 = var1.method2538();
         } else if(var2 == 79) {
            this.field1094 = var1.method2538();
         } else if(var2 == 90) {
            this.field1123 = var1.method2538();
         } else if(var2 == 91) {
            this.field1109 = var1.method2538();
         } else if(var2 == 92) {
            this.field1131 = var1.method2538();
         } else if(var2 == 93) {
            this.field1126 = var1.method2538();
         } else if(var2 == 95) {
            this.field1089 = var1.method2538();
         } else if(97 == var2) {
            this.field1104 = var1.method2538();
         } else if(98 == var2) {
            this.field1114 = var1.method2538();
         } else if(var2 >= 100 && var2 < 110) {
            if(this.field1127 == null) {
               this.field1127 = new int[10];
               this.field1128 = new int[10];
            }

            this.field1127[var2 - 100] = var1.method2538();
            this.field1128[var2 - 100] = var1.method2538();
         } else if(var2 == 110) {
            this.field1106 = var1.method2538();
         } else if(111 == var2) {
            this.field1132 = var1.method2538();
         } else if(var2 == 112) {
            this.field1133 = var1.method2538();
         } else if(var2 == 113) {
            this.field1134 = var1.method2537();
         } else if(114 == var2) {
            this.field1135 = var1.method2537() * 5;
         } else if(115 == var2) {
            this.field1124 = var1.method2536();
         } else if(var2 == 139) {
            this.field1138 = var1.method2538();
         } else if(var2 == 140) {
            this.field1125 = var1.method2538();
         }
      }

   }

   @ObfuscatedName("a")
   void method1070(class51 var1, class51 var2) {
      this.field1098 = var1.field1098;
      this.field1129 = var1.field1129;
      this.field1105 = var1.field1105;
      this.field1103 = var1.field1103;
      this.field1089 = var1.field1089;
      this.field1139 = var1.field1139;
      this.field1130 = var1.field1130;
      this.field1100 = var1.field1100;
      this.field1101 = var1.field1101;
      this.field1102 = var1.field1102;
      this.field1107 = var1.field1107;
      this.field1099 = var2.field1099;
      this.field1112 = var2.field1112;
      this.field1111 = var2.field1111;
      this.field1110 = 1;
   }

   @ObfuscatedName("h")
   void method1071(class51 var1, class51 var2) {
      this.field1098 = var1.field1098;
      this.field1129 = var1.field1129;
      this.field1105 = var1.field1105;
      this.field1103 = var1.field1103;
      this.field1089 = var1.field1089;
      this.field1139 = var1.field1139;
      this.field1130 = var1.field1130;
      this.field1100 = var2.field1100;
      this.field1101 = var2.field1101;
      this.field1102 = var2.field1102;
      this.field1107 = var2.field1107;
      this.field1099 = var2.field1099;
      this.field1112 = var2.field1112;
      this.field1110 = var2.field1110;
      this.field1115 = var2.field1115;
      this.field1096 = var2.field1096;
      this.field1121 = var2.field1121;
      this.field1118 = var2.field1118;
      this.field1119 = var2.field1119;
      this.field1094 = var2.field1094;
      this.field1123 = var2.field1123;
      this.field1131 = var2.field1131;
      this.field1109 = var2.field1109;
      this.field1126 = var2.field1126;
      this.field1124 = var2.field1124;
      this.field1108 = var2.field1108;
      this.field1116 = new String[5];
      if(null != var2.field1116) {
         for(int var3 = 0; var3 < 4; ++var3) {
            this.field1116[var3] = var2.field1116[var3];
         }
      }

      this.field1116[4] = "Discard";
      this.field1111 = 0;
   }

   @ObfuscatedName("i")
   public final class99 method1072(int var1) {
      int var3;
      if(null != this.field1127 && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1128[var3] && this.field1128[var3] != 0) {
               var2 = this.field1127[var3];
            }
         }

         if(var2 != -1) {
            return class10.method158(var2).method1072(1);
         }
      }

      class99 var4 = class99.method2218(field1091, this.field1098, 0);
      if(null == var4) {
         return null;
      } else {
         if(128 != this.field1106 || 128 != this.field1132 || this.field1133 != 128) {
            var4.method2235(this.field1106, this.field1132, this.field1133);
         }

         if(null != this.field1100) {
            for(var3 = 0; var3 < this.field1100.length; ++var3) {
               var4.method2298(this.field1100[var3], this.field1101[var3]);
            }
         }

         if(this.field1102 != null) {
            for(var3 = 0; var3 < this.field1102.length; ++var3) {
               var4.method2233(this.field1102[var3], this.field1107[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("t")
   public final class104 method1073(int var1) {
      if(this.field1127 != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1128[var3] && this.field1128[var3] != 0) {
               var2 = this.field1127[var3];
            }
         }

         if(-1 != var2) {
            return class10.method158(var2).method1073(1);
         }
      }

      class104 var5 = (class104)field1136.method3808((long)this.field1097);
      if(null != var5) {
         return var5;
      } else {
         class99 var6 = class99.method2218(field1091, this.field1098, 0);
         if(null == var6) {
            return null;
         } else {
            if(this.field1106 != 128 || 128 != this.field1132 || 128 != this.field1133) {
               var6.method2235(this.field1106, this.field1132, this.field1133);
            }

            int var4;
            if(null != this.field1100) {
               for(var4 = 0; var4 < this.field1100.length; ++var4) {
                  var6.method2298(this.field1100[var4], this.field1101[var4]);
               }
            }

            if(null != this.field1102) {
               for(var4 = 0; var4 < this.field1102.length; ++var4) {
                  var6.method2233(this.field1102[var4], this.field1107[var4]);
               }
            }

            var5 = var6.method2247(this.field1134 + 64, this.field1135 + 768, -50, -10, -50);
            var5.field1821 = true;
            field1136.method3805(var5, (long)this.field1097);
            return var5;
         }
      }
   }

   @ObfuscatedName("k")
   public class51 method1074(int var1) {
      if(null != this.field1127 && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1128[var3] && 0 != this.field1128[var3]) {
               var2 = this.field1127[var3];
            }
         }

         if(var2 != -1) {
            return class10.method158(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("w")
   public final boolean method1075(boolean var1) {
      int var2 = this.field1115;
      int var3 = this.field1096;
      int var4 = this.field1121;
      if(var1) {
         var2 = this.field1118;
         var3 = this.field1119;
         var4 = this.field1094;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var5 = true;
         if(!field1091.method3314(var2, 0)) {
            var5 = false;
         }

         if(-1 != var3 && !field1091.method3314(var3, 0)) {
            var5 = false;
         }

         if(-1 != var4 && !field1091.method3314(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("e")
   public final class99 method1076(boolean var1) {
      int var2 = this.field1115;
      int var3 = this.field1096;
      int var4 = this.field1121;
      if(var1) {
         var2 = this.field1118;
         var3 = this.field1119;
         var4 = this.field1094;
      }

      if(-1 == var2) {
         return null;
      } else {
         class99 var5 = class99.method2218(field1091, var2, 0);
         if(-1 != var3) {
            class99 var6 = class99.method2218(field1091, var3, 0);
            if(-1 != var4) {
               class99 var7 = class99.method2218(field1091, var4, 0);
               class99[] var8 = new class99[]{var5, var6, var7};
               var5 = new class99(var8, 3);
            } else {
               class99[] var10 = new class99[]{var5, var6};
               var5 = new class99(var10, 2);
            }
         }

         if(!var1 && 0 != this.field1117) {
            var5.method2239(0, this.field1117, 0);
         }

         if(var1 && this.field1120 != 0) {
            var5.method2239(0, this.field1120, 0);
         }

         int var9;
         if(null != this.field1100) {
            for(var9 = 0; var9 < this.field1100.length; ++var9) {
               var5.method2298(this.field1100[var9], this.field1101[var9]);
            }
         }

         if(null != this.field1102) {
            for(var9 = 0; var9 < this.field1102.length; ++var9) {
               var5.method2233(this.field1102[var9], this.field1107[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("z")
   public final boolean method1077(boolean var1) {
      int var2 = this.field1123;
      int var3 = this.field1131;
      if(var1) {
         var2 = this.field1109;
         var3 = this.field1126;
      }

      if(-1 == var2) {
         return true;
      } else {
         boolean var4 = true;
         if(!field1091.method3314(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !field1091.method3314(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("f")
   void method1080() {
   }

   @ObfuscatedName("j")
   public static File method1093(String var0) {
      if(!class134.field2066) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class134.field2064.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class134.field2065, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class134.field2064.put(var0, var2);
                  return var2;
               }
            } catch (Exception var7) {
               try {
                  if(null != var3) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var6) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("p")
   public final class99 method1096(boolean var1) {
      int var2 = this.field1123;
      int var3 = this.field1131;
      if(var1) {
         var2 = this.field1109;
         var3 = this.field1126;
      }

      if(var2 == -1) {
         return null;
      } else {
         class99 var4 = class99.method2218(field1091, var2, 0);
         if(-1 != var3) {
            class99 var5 = class99.method2218(field1091, var3, 0);
            class99[] var6 = new class99[]{var4, var5};
            var4 = new class99(var6, 2);
         }

         int var7;
         if(null != this.field1100) {
            for(var7 = 0; var7 < this.field1100.length; ++var7) {
               var4.method2298(this.field1100[var7], this.field1101[var7]);
            }
         }

         if(this.field1102 != null) {
            for(var7 = 0; var7 < this.field1102.length; ++var7) {
               var4.method2233(this.field1102[var7], this.field1107[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("k")
   public static class223 method1105(byte[] var0) {
      if(null == var0) {
         return null;
      } else {
         class223 var1 = new class223(var0, class76.field1366, class76.field1370, class76.field1371, class76.field1373, class76.field1369, class17.field236);
         class135.method2935();
         return var1;
      }
   }

   @ObfuscatedName("z")
   public static int method1112(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   @ObfuscatedName("l")
   void method1114(class118 var1) {
      while(true) {
         int var2 = var1.method2536();
         if(var2 == 0) {
            return;
         }

         this.method1069(var1, var2);
      }
   }

   @ObfuscatedName("m")
   public static void method1115(int var0) {
      class182.field2940 = 1;
      class188.field3038 = null;
      class182.field2945 = -1;
      class35.field778 = -1;
      class182.field2942 = 0;
      class158.field2586 = false;
      class173.field2874 = var0;
   }
}
