import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class56 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1203309013
   )
   int field1149 = 0;
   @ObfuscatedName("h")
   static class72 field1150;
   @ObfuscatedName("r")
   int[] field1151;
   @ObfuscatedName("k")
   class66 field1152;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1551410087
   )
   public static int field1153;
   @ObfuscatedName("q")
   boolean field1154 = true;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -5739101706128163287L
   )
   long field1155 = class140.method2967();
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1823735967
   )
   int field1156;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -819019547
   )
   int field1157;
   @ObfuscatedName("ai")
   class66[] field1158 = new class66[8];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1694046267
   )
   int field1159 = 0;
   @ObfuscatedName("s")
   static boolean field1160;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 698489099
   )
   int field1161;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -569596354007057947L
   )
   long field1162 = 0L;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2112562151
   )
   int field1163 = 32;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -2068798723
   )
   int field1166 = 0;
   @ObfuscatedName("ap")
   class66[] field1167 = new class66[8];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1292497775
   )
   int field1168 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -6292661265466719187L
   )
   long field1169 = 0L;

   @ObfuscatedName("z")
   public final synchronized void method1174(class66 var1) {
      this.field1152 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "449467630"
   )
   public final synchronized void method1175() {
      if(null != this.field1151) {
         long var1 = class140.method2967();

         try {
            if(0L != this.field1169) {
               if(var1 < this.field1169) {
                  return;
               }

               this.vmethod1526(this.field1161);
               this.field1169 = 0L;
               this.field1154 = true;
            }

            int var3 = this.vmethod1512();
            if(this.field1149 - var3 > this.field1159) {
               this.field1159 = this.field1149 - var3;
            }

            int var4 = this.field1156 + this.field1157;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1161) {
               this.field1161 += 1024;
               if(this.field1161 > 16384) {
                  this.field1161 = 16384;
               }

               this.vmethod1513();
               this.vmethod1526(this.field1161);
               var3 = 0;
               this.field1154 = true;
               if(var4 + 256 > this.field1161) {
                  var4 = this.field1161 - 256;
                  this.field1157 = var4 - this.field1156;
               }
            }

            while(var3 < var4) {
               this.method1210(this.field1151, 256);
               this.vmethod1514();
               var3 += 256;
            }

            if(var1 > this.field1162) {
               if(!this.field1154) {
                  if(0 == this.field1159 && 0 == this.field1168) {
                     this.vmethod1513();
                     this.field1169 = var1 + 2000L;
                     return;
                  }

                  this.field1157 = Math.min(this.field1168, this.field1159);
                  this.field1168 = this.field1159;
               } else {
                  this.field1154 = false;
               }

               this.field1159 = 0;
               this.field1162 = var1 + 2000L;
            }

            this.field1149 = var3;
         } catch (Exception var6) {
            this.vmethod1513();
            this.field1169 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1155) {
               var1 = this.field1155;
            }

            while(var1 > 5000L + this.field1155) {
               this.method1199(256);
               this.field1155 += (long)(256000 / field1153);
            }
         } catch (Exception var5) {
            this.field1155 = var1;
         }

      }
   }

   @ObfuscatedName("aq")
   public final void method1176() {
      this.field1154 = true;
   }

   @ObfuscatedName("ap")
   public final synchronized void method1177() {
      this.field1154 = true;

      try {
         this.vmethod1511();
      } catch (Exception var2) {
         this.vmethod1513();
         this.field1169 = class140.method2967() + 2000L;
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "60"
   )
   public final synchronized void method1178() {
      if(field1150 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == field1150.field1321[var2]) {
               field1150.field1321[var2] = null;
            }

            if(null != field1150.field1321[var2]) {
               var1 = false;
            }
         }

         if(var1) {
            field1150.field1320 = true;

            while(field1150.field1322) {
               class130.method2818(50L);
            }

            field1150 = null;
         }
      }

      this.vmethod1513();
      this.field1151 = null;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "175773388"
   )
   static final void method1179(int var0, int var1, int var2, int var3, String var4, int var5, int var6) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(31 == var2) {
         client.field321.method2762(69);
         client.field321.method2713(class45.field1025);
         client.field321.method2617(class59.field1185);
         client.field321.method2713(var3);
         client.field321.method2556(var0);
         client.field321.method2713(class172.field2741);
         client.field321.method2563(var1);
         client.field436 = 0;
         class216.field3158 = class148.method3129(var1);
         client.field359 = var0;
      }

      if(var2 == 4) {
         client.field421 = var5;
         client.field277 = var6;
         client.field390 = 2;
         client.field389 = 0;
         client.field432 = var0;
         client.field513 = var1;
         client.field321.method2762(228);
         client.field321.method2556(var3 >> 14 & 32767);
         client.field321.method2713(class6.field128 + var1);
         client.field321.method2565(class137.field2103[82]?1:0);
         client.field321.method2556(class85.field1439 + var0);
      }

      class173 var12;
      if(38 == var2) {
         class135.method2870();
         var12 = class148.method3129(var1);
         client.field431 = 1;
         class172.field2741 = var0;
         class59.field1185 = var1;
         class45.field1025 = var3;
         class9.method133(var12);
         client.field392 = class39.method784(16748608) + class33.method711(var3).field1091 + class39.method784(16777215);
         if(client.field392 == null) {
            client.field392 = "null";
         }

      } else {
         class2 var7;
         if(45 == var2) {
            var7 = client.field387[var3];
            if(var7 != null) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field432 = var0;
               client.field513 = var1;
               client.field321.method2762(194);
               client.field321.method2546(class137.field2103[82]?1:0);
               client.field321.method2554(var3);
            }
         }

         if(50 == var2) {
            var7 = client.field387[var3];
            if(var7 != null) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field432 = var0;
               client.field513 = var1;
               client.field321.method2762(77);
               client.field321.method2548(var3);
               client.field321.method2565(class137.field2103[82]?1:0);
            }
         }

         if(25 == var2) {
            var12 = class40.method837(var1, var0);
            if(var12 != null) {
               class135.method2870();
               class20.method564(var1, var0, class170.method3363(class75.method1642(var12)), var12.field2822);
               client.field431 = 0;
               client.field377 = class84.method1918(var12);
               if(client.field377 == null) {
                  client.field377 = "Null";
               }

               if(var12.field2809) {
                  client.field437 = var12.field2828 + class39.method784(16777215);
               } else {
                  client.field437 = class39.method784('\uff00') + var12.field2803 + class39.method784(16777215);
               }
            }

         } else {
            class34 var11;
            if(var2 == 12) {
               var11 = client.field316[var3];
               if(var11 != null) {
                  client.field421 = var5;
                  client.field277 = var6;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field432 = var0;
                  client.field513 = var1;
                  client.field321.method2762(68);
                  client.field321.method2556(var3);
                  client.field321.method2708(class137.field2103[82]?1:0);
               }
            }

            if(24 == var2) {
               var12 = class148.method3129(var1);
               boolean var8 = true;
               if(var12.field2833 > 0) {
                  var8 = class184.method3711(var12);
               }

               if(var8) {
                  client.field321.method2762(253);
                  client.field321.method2617(var1);
               }
            }

            if(var2 == 42) {
               client.field321.method2762(107);
               client.field321.method2548(var3);
               client.field321.method2556(var0);
               client.field321.method2683(var1);
               client.field436 = 0;
               class216.field3158 = class148.method3129(var1);
               client.field359 = var0;
            }

            if(var2 == 36) {
               client.field321.method2762(9);
               client.field321.method2710(var1);
               client.field321.method2713(var0);
               client.field321.method2554(var3);
               client.field436 = 0;
               class216.field3158 = class148.method3129(var1);
               client.field359 = var0;
            }

            if(var2 == 43) {
               client.field321.method2762(26);
               client.field321.method2713(var0);
               client.field321.method2683(var1);
               client.field321.method2554(var3);
               client.field436 = 0;
               class216.field3158 = class148.method3129(var1);
               client.field359 = var0;
            }

            if(35 == var2) {
               client.field321.method2762(120);
               client.field321.method2563(var1);
               client.field321.method2554(var0);
               client.field321.method2548(var3);
               client.field436 = 0;
               class216.field3158 = class148.method3129(var1);
               client.field359 = var0;
            }

            if(var2 == 1004) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field321.method2762(254);
               client.field321.method2556(var3);
            }

            if(var2 == 3) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field432 = var0;
               client.field513 = var1;
               client.field321.method2762(255);
               client.field321.method2713(var1 + class6.field128);
               client.field321.method2546(class137.field2103[82]?1:0);
               client.field321.method2548(var3 >> 14 & 32767);
               client.field321.method2554(class85.field1439 + var0);
            }

            if(2 == var2) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field432 = var0;
               client.field513 = var1;
               client.field321.method2762(132);
               client.field321.method2554(var3 >> 14 & 32767);
               client.field321.method2713(class85.field1439 + var0);
               client.field321.method2555(class137.field2103[82]?1:0);
               client.field321.method2556(client.field416);
               client.field321.method2563(class39.field859);
               client.field321.method2554(class6.field128 + var1);
            }

            if(var2 == 18) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field432 = var0;
               client.field513 = var1;
               client.field321.method2762(118);
               client.field321.method2556(class85.field1439 + var0);
               client.field321.method2713(var3);
               client.field321.method2548(class6.field128 + var1);
               client.field321.method2546(class137.field2103[82]?1:0);
            }

            if(39 == var2) {
               client.field321.method2762(159);
               client.field321.method2556(var3);
               client.field321.method2548(var0);
               client.field321.method2683(var1);
               client.field436 = 0;
               class216.field3158 = class148.method3129(var1);
               client.field359 = var0;
            }

            if(var2 == 17) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field432 = var0;
               client.field513 = var1;
               client.field321.method2762(239);
               client.field321.method2554(var3);
               client.field321.method2565(class137.field2103[82]?1:0);
               client.field321.method2556(client.field416);
               client.field321.method2556(class6.field128 + var1);
               client.field321.method2563(class39.field859);
               client.field321.method2556(class85.field1439 + var0);
            }

            if(46 == var2) {
               var7 = client.field387[var3];
               if(null != var7) {
                  client.field421 = var5;
                  client.field277 = var6;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field432 = var0;
                  client.field513 = var1;
                  client.field321.method2762(187);
                  client.field321.method2556(var3);
                  client.field321.method2555(class137.field2103[82]?1:0);
               }
            }

            if(var2 == 13) {
               var11 = client.field316[var3];
               if(var11 != null) {
                  client.field421 = var5;
                  client.field277 = var6;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field432 = var0;
                  client.field513 = var1;
                  client.field321.method2762(73);
                  client.field321.method2546(class137.field2103[82]?1:0);
                  client.field321.method2556(var3);
               }
            }

            if(var2 == 9) {
               var11 = client.field316[var3];
               if(var11 != null) {
                  client.field421 = var5;
                  client.field277 = var6;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field432 = var0;
                  client.field513 = var1;
                  client.field321.method2762(94);
                  client.field321.method2546(class137.field2103[82]?1:0);
                  client.field321.method2556(var3);
               }
            }

            if(var2 == 10) {
               var11 = client.field316[var3];
               if(null != var11) {
                  client.field421 = var5;
                  client.field277 = var6;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field432 = var0;
                  client.field513 = var1;
                  client.field321.method2762(138);
                  client.field321.method2555(class137.field2103[82]?1:0);
                  client.field321.method2556(var3);
               }
            }

            if(1003 == var2) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               var11 = client.field316[var3];
               if(var11 != null) {
                  class39 var13 = var11.field755;
                  if(null != var13.field888) {
                     var13 = var13.method762();
                  }

                  if(null != var13) {
                     client.field321.method2762(55);
                     client.field321.method2713(var13.field882);
                  }
               }
            }

            if(40 == var2) {
               client.field321.method2762(45);
               client.field321.method2683(var1);
               client.field321.method2556(var3);
               client.field321.method2554(var0);
               client.field436 = 0;
               class216.field3158 = class148.method3129(var1);
               client.field359 = var0;
            }

            if(5 == var2) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field432 = var0;
               client.field513 = var1;
               client.field321.method2762(131);
               client.field321.method2556(class85.field1439 + var0);
               client.field321.method2713(var3 >> 14 & 32767);
               client.field321.method2556(class6.field128 + var1);
               client.field321.method2546(class137.field2103[82]?1:0);
            }

            if(var2 == 16) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field432 = var0;
               client.field513 = var1;
               client.field321.method2762(29);
               client.field321.method2546(class137.field2103[82]?1:0);
               client.field321.method2554(class85.field1439 + var0);
               client.field321.method2548(class45.field1025);
               client.field321.method2713(var3);
               client.field321.method2563(class59.field1185);
               client.field321.method2554(var1 + class6.field128);
               client.field321.method2556(class172.field2741);
            }

            if(var2 == 49) {
               var7 = client.field387[var3];
               if(var7 != null) {
                  client.field421 = var5;
                  client.field277 = var6;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field432 = var0;
                  client.field513 = var1;
                  client.field321.method2762(52);
                  client.field321.method2556(var3);
                  client.field321.method2565(class137.field2103[82]?1:0);
               }
            }

            if(var2 == 44) {
               var7 = client.field387[var3];
               if(null != var7) {
                  client.field421 = var5;
                  client.field277 = var6;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field432 = var0;
                  client.field513 = var1;
                  client.field321.method2762(216);
                  client.field321.method2708(class137.field2103[82]?1:0);
                  client.field321.method2554(var3);
               }
            }

            int var14;
            if(29 == var2) {
               client.field321.method2762(253);
               client.field321.method2617(var1);
               var12 = class148.method3129(var1);
               if(var12.field2867 != null && var12.field2867[0][0] == 5) {
                  var14 = var12.field2867[0][1];
                  if(class176.field2903[var14] != var12.field2808[0]) {
                     class176.field2903[var14] = var12.field2808[0];
                     class50.method1012(var14);
                  }
               }
            }

            if(34 == var2) {
               client.field321.method2762(85);
               client.field321.method2554(var0);
               client.field321.method2548(var3);
               client.field321.method2617(var1);
               client.field436 = 0;
               class216.field3158 = class148.method3129(var1);
               client.field359 = var0;
            }

            if(var2 == 48) {
               var7 = client.field387[var3];
               if(null != var7) {
                  client.field421 = var5;
                  client.field277 = var6;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field432 = var0;
                  client.field513 = var1;
                  client.field321.method2762(82);
                  client.field321.method2546(class137.field2103[82]?1:0);
                  client.field321.method2554(var3);
               }
            }

            if(var2 == 8) {
               var11 = client.field316[var3];
               if(var11 != null) {
                  client.field421 = var5;
                  client.field277 = var6;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field432 = var0;
                  client.field513 = var1;
                  client.field321.method2762(48);
                  client.field321.method2683(class39.field859);
                  client.field321.method2708(class137.field2103[82]?1:0);
                  client.field321.method2548(var3);
                  client.field321.method2554(client.field416);
               }
            }

            if(var2 == 11) {
               var11 = client.field316[var3];
               if(null != var11) {
                  client.field421 = var5;
                  client.field277 = var6;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field432 = var0;
                  client.field513 = var1;
                  client.field321.method2762(197);
                  client.field321.method2546(class137.field2103[82]?1:0);
                  client.field321.method2713(var3);
               }
            }

            if(1005 == var2) {
               var12 = class148.method3129(var1);
               if(null != var12 && var12.field2873[var0] >= 100000) {
                  class87.method2092(27, "", var12.field2873[var0] + " x " + class33.method711(var3).field1091);
               } else {
                  client.field321.method2762(254);
                  client.field321.method2556(var3);
               }

               client.field436 = 0;
               class216.field3158 = class148.method3129(var1);
               client.field359 = var0;
            }

            if(1 == var2) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field432 = var0;
               client.field513 = var1;
               client.field321.method2762(84);
               client.field321.method2556(var3 >> 14 & 32767);
               client.field321.method2713(class45.field1025);
               client.field321.method2548(var0 + class85.field1439);
               client.field321.method2556(class172.field2741);
               client.field321.method2708(class137.field2103[82]?1:0);
               client.field321.method2563(class59.field1185);
               client.field321.method2713(class6.field128 + var1);
            }

            if(20 == var2) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field432 = var0;
               client.field513 = var1;
               client.field321.method2762(37);
               client.field321.method2554(class85.field1439 + var0);
               client.field321.method2554(class6.field128 + var1);
               client.field321.method2555(class137.field2103[82]?1:0);
               client.field321.method2554(var3);
            }

            if(47 == var2) {
               var7 = client.field387[var3];
               if(null != var7) {
                  client.field421 = var5;
                  client.field277 = var6;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field432 = var0;
                  client.field513 = var1;
                  client.field321.method2762(151);
                  client.field321.method2546(class137.field2103[82]?1:0);
                  client.field321.method2556(var3);
               }
            }

            if(19 == var2) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field432 = var0;
               client.field513 = var1;
               client.field321.method2762(36);
               client.field321.method2713(var1 + class6.field128);
               client.field321.method2548(var0 + class85.field1439);
               client.field321.method2713(var3);
               client.field321.method2565(class137.field2103[82]?1:0);
            }

            if(var2 == 1002) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field321.method2762(28);
               client.field321.method2548(var3 >> 14 & 32767);
            }

            if(32 == var2) {
               client.field321.method2762(99);
               client.field321.method2683(class39.field859);
               client.field321.method2548(var0);
               client.field321.method2556(client.field416);
               client.field321.method2713(var3);
               client.field321.method2617(var1);
               client.field436 = 0;
               class216.field3158 = class148.method3129(var1);
               client.field359 = var0;
            }

            if(var2 == 51) {
               var7 = client.field387[var3];
               if(null != var7) {
                  client.field421 = var5;
                  client.field277 = var6;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field432 = var0;
                  client.field513 = var1;
                  client.field321.method2762(67);
                  client.field321.method2554(var3);
                  client.field321.method2708(class137.field2103[82]?1:0);
               }
            }

            if(var2 == 58) {
               var12 = class40.method837(var1, var0);
               if(null != var12) {
                  client.field321.method2762(110);
                  client.field321.method2548(var0);
                  client.field321.method2713(client.field416);
                  client.field321.method2617(class39.field859);
                  client.field321.method2713(var12.field2822);
                  client.field321.method2713(client.field435);
                  client.field321.method2710(var1);
               }
            }

            if(37 == var2) {
               client.field321.method2762(241);
               client.field321.method2556(var0);
               client.field321.method2617(var1);
               client.field321.method2556(var3);
               client.field436 = 0;
               class216.field3158 = class148.method3129(var1);
               client.field359 = var0;
            }

            if(var2 == 1001) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field432 = var0;
               client.field513 = var1;
               client.field321.method2762(1);
               client.field321.method2548(var0 + class85.field1439);
               client.field321.method2554(class6.field128 + var1);
               client.field321.method2556(var3 >> 14 & 32767);
               client.field321.method2546(class137.field2103[82]?1:0);
            }

            if(var2 == 41) {
               client.field321.method2762(224);
               client.field321.method2563(var1);
               client.field321.method2548(var0);
               client.field321.method2713(var3);
               client.field436 = 0;
               class216.field3158 = class148.method3129(var1);
               client.field359 = var0;
            }

            if(var2 == 14) {
               var7 = client.field387[var3];
               if(var7 != null) {
                  client.field421 = var5;
                  client.field277 = var6;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field432 = var0;
                  client.field513 = var1;
                  client.field321.method2762(150);
                  client.field321.method2548(class45.field1025);
                  client.field321.method2556(class172.field2741);
                  client.field321.method2683(class59.field1185);
                  client.field321.method2556(var3);
                  client.field321.method2546(class137.field2103[82]?1:0);
               }
            }

            if(var2 == 22) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field432 = var0;
               client.field513 = var1;
               client.field321.method2762(222);
               client.field321.method2554(var1 + class6.field128);
               client.field321.method2713(var3);
               client.field321.method2548(class85.field1439 + var0);
               client.field321.method2555(class137.field2103[82]?1:0);
            }

            if(15 == var2) {
               var7 = client.field387[var3];
               if(var7 != null) {
                  client.field421 = var5;
                  client.field277 = var6;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field432 = var0;
                  client.field513 = var1;
                  client.field321.method2762(231);
                  client.field321.method2554(client.field416);
                  client.field321.method2713(var3);
                  client.field321.method2565(class137.field2103[82]?1:0);
                  client.field321.method2710(class39.field859);
               }
            }

            if(var2 == 33) {
               client.field321.method2762(126);
               client.field321.method2548(var0);
               client.field321.method2713(var3);
               client.field321.method2710(var1);
               client.field436 = 0;
               class216.field3158 = class148.method3129(var1);
               client.field359 = var0;
            }

            if(var2 == 7) {
               var11 = client.field316[var3];
               if(null != var11) {
                  client.field421 = var5;
                  client.field277 = var6;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field432 = var0;
                  client.field513 = var1;
                  client.field321.method2762(122);
                  client.field321.method2548(class45.field1025);
                  client.field321.method2683(class59.field1185);
                  client.field321.method2548(var3);
                  client.field321.method2546(class137.field2103[82]?1:0);
                  client.field321.method2556(class172.field2741);
               }
            }

            if(30 == var2 && null == client.field442) {
               class157.method3170(var1, var0);
               client.field442 = class40.method837(var1, var0);
               class9.method133(client.field442);
            }

            if(6 == var2) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field432 = var0;
               client.field513 = var1;
               client.field321.method2762(205);
               client.field321.method2554(var3 >> 14 & 32767);
               client.field321.method2548(var0 + class85.field1439);
               client.field321.method2556(class6.field128 + var1);
               client.field321.method2555(class137.field2103[82]?1:0);
            }

            if(21 == var2) {
               client.field421 = var5;
               client.field277 = var6;
               client.field390 = 2;
               client.field389 = 0;
               client.field432 = var0;
               client.field513 = var1;
               client.field321.method2762(90);
               client.field321.method2548(var3);
               client.field321.method2708(class137.field2103[82]?1:0);
               client.field321.method2548(var0 + class85.field1439);
               client.field321.method2554(class6.field128 + var1);
            }

            if(var2 == 57 || var2 == 1007) {
               var12 = class40.method837(var1, var0);
               if(var12 != null) {
                  var14 = var12.field2822;
                  class173 var9 = class40.method837(var1, var0);
                  if(null != var9) {
                     if(var9.field2855 != null) {
                        class0 var10 = new class0();
                        var10.field2 = var9;
                        var10.field5 = var3;
                        var10.field9 = var4;
                        var10.field11 = var9.field2855;
                        class93.method2183(var10);
                     }

                     boolean var15 = true;
                     if(var9.field2833 > 0) {
                        var15 = class184.method3711(var9);
                     }

                     if(var15 && class14.method171(class75.method1642(var9), var3 - 1)) {
                        if(var3 == 1) {
                           client.field321.method2762(101);
                           client.field321.method2617(var1);
                           client.field321.method2713(var0);
                           client.field321.method2713(var14);
                        }

                        if(2 == var3) {
                           client.field321.method2762(220);
                           client.field321.method2617(var1);
                           client.field321.method2713(var0);
                           client.field321.method2713(var14);
                        }

                        if(3 == var3) {
                           client.field321.method2762(161);
                           client.field321.method2617(var1);
                           client.field321.method2713(var0);
                           client.field321.method2713(var14);
                        }

                        if(var3 == 4) {
                           client.field321.method2762(218);
                           client.field321.method2617(var1);
                           client.field321.method2713(var0);
                           client.field321.method2713(var14);
                        }

                        if(var3 == 5) {
                           client.field321.method2762(10);
                           client.field321.method2617(var1);
                           client.field321.method2713(var0);
                           client.field321.method2713(var14);
                        }

                        if(6 == var3) {
                           client.field321.method2762(217);
                           client.field321.method2617(var1);
                           client.field321.method2713(var0);
                           client.field321.method2713(var14);
                        }

                        if(7 == var3) {
                           client.field321.method2762(98);
                           client.field321.method2617(var1);
                           client.field321.method2713(var0);
                           client.field321.method2713(var14);
                        }

                        if(var3 == 8) {
                           client.field321.method2762(130);
                           client.field321.method2617(var1);
                           client.field321.method2713(var0);
                           client.field321.method2713(var14);
                        }

                        if(9 == var3) {
                           client.field321.method2762(168);
                           client.field321.method2617(var1);
                           client.field321.method2713(var0);
                           client.field321.method2713(var14);
                        }

                        if(10 == var3) {
                           client.field321.method2762(109);
                           client.field321.method2617(var1);
                           client.field321.method2713(var0);
                           client.field321.method2713(var14);
                        }
                     }
                  }
               }
            }

            if(26 == var2) {
               class106.method2400();
            }

            if(28 == var2) {
               client.field321.method2762(253);
               client.field321.method2617(var1);
               var12 = class148.method3129(var1);
               if(null != var12.field2867 && var12.field2867[0][0] == 5) {
                  var14 = var12.field2867[0][1];
                  class176.field2903[var14] = 1 - class176.field2903[var14];
                  class50.method1012(var14);
               }
            }

            if(var2 == 23) {
               class151.field2250.method1963(class48.field1063, var0, var1);
            }

            if(0 != client.field431) {
               client.field431 = 0;
               class9.method133(class148.method3129(class59.field1185));
            }

            if(client.field433) {
               class135.method2870();
            }

            if(class216.field3158 != null && client.field436 == 0) {
               class9.method133(class216.field3158);
            }

         }
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass66;II)V",
      garbageValue = "1559964492"
   )
   final void method1181(class66 var1, int var2) {
      int var3 = var2 >> 5;
      class66 var4 = this.field1158[var3];
      if(var4 == null) {
         this.field1167[var3] = var1;
      } else {
         var4.field1235 = var1;
      }

      this.field1158[var3] = var1;
      var1.field1236 = var2;
   }

   @ObfuscatedName("w")
   void vmethod1526(int var1) throws Exception {
   }

   @ObfuscatedName("f")
   int vmethod1512() throws Exception {
      return this.field1161;
   }

   @ObfuscatedName("p")
   void vmethod1513() {
   }

   @ObfuscatedName("h")
   void vmethod1511() throws Exception {
   }

   @ObfuscatedName("s")
   void vmethod1514() throws Exception {
   }

   @ObfuscatedName("e")
   void vmethod1510() throws Exception {
   }

   @ObfuscatedName("ae")
   final void method1199(int var1) {
      this.field1166 -= var1;
      if(this.field1166 < 0) {
         this.field1166 = 0;
      }

      if(null != this.field1152) {
         this.field1152.vmethod3717(var1);
      }

   }

   @ObfuscatedName("e")
   public static class82[] method1202() {
      return new class82[]{class82.field1412, class82.field1400, class82.field1402, class82.field1399, class82.field1411};
   }

   @ObfuscatedName("az")
   final void method1210(int[] var1, int var2) {
      int var3 = var2;
      if(field1160) {
         var3 = var2 << 1;
      }

      class120.method2724(var1, 0, var3);
      this.field1166 -= var2;
      if(this.field1152 != null && this.field1166 <= 0) {
         this.field1166 += field1153 >> 4;
         class4.method45(this.field1152);
         this.method1181(this.field1152, this.field1152.vmethod1461());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class66 var10;
         label136:
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

            for(int var9 = var5 >>> var7 & 286331153; 0 != var9; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class66 var11 = this.field1167[var7];

                  label130:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label130;
                        }

                        class65 var12 = var11.field1237;
                        if(null != var12 && var12.field1234 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1235;
                        } else {
                           var11.field1238 = true;
                           int var13 = var11.vmethod3715();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1234 += var13;
                           }

                           if(var4 >= this.field1163) {
                              break label136;
                           }

                           class66 var14 = var11.vmethod3713();
                           if(var14 != null) {
                              for(int var15 = var11.field1236; var14 != null; var14 = var11.vmethod3733()) {
                                 this.method1181(var14, var15 * var14.vmethod1461() >> 8);
                              }
                           }

                           class66 var18 = var11.field1235;
                           var11.field1235 = null;
                           if(null == var10) {
                              this.field1167[var7] = var18;
                           } else {
                              var10.field1235 = var18;
                           }

                           if(var18 == null) {
                              this.field1158[var7] = var10;
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
            class66 var16 = this.field1167[var6];
            class66[] var17 = this.field1167;
            this.field1158[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1235;
               var16.field1235 = null;
            }
         }
      }

      if(this.field1166 < 0) {
         this.field1166 = 0;
      }

      if(null != this.field1152) {
         this.field1152.vmethod3716(var1, 0, var2);
      }

      this.field1155 = class140.method2967();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass144;S)V",
      garbageValue = "289"
   )
   static void method1225() {
      if(class31.field721) {
         class137.method2909();
      } else {
         int var1;
         int var2;
         if((class140.field2146 == 1 || !class3.field66 && 4 == class140.field2146) && class140.field2135 >= class31.field696 + 765 - 50 && class140.field2148 >= 453) {
            class39.field865.field145 = !class39.field865.field145;
            class43.method915();
            if(!class39.field865.field145) {
               class168 var0 = class24.field611;
               var1 = var0.method3255("scape main");
               var2 = var0.method3271(var1, "");
               class99.method2218(var0, var1, var2, 255, false);
            } else {
               class39.method785();
            }
         }

         if(5 != client.field287) {
            ++class31.field714;
            if(10 == client.field287 || 11 == client.field287) {
               int var8;
               if(client.field286 == 0) {
                  if(1 == class140.field2146 || !class3.field66 && class140.field2146 == 4) {
                     var8 = 5 + class31.field696;
                     short var9 = 463;
                     byte var10 = 100;
                     byte var3 = 35;
                     if(class140.field2135 >= var8 && class140.field2135 <= var8 + var10 && class140.field2148 >= var9 && class140.field2148 <= var3 + var9) {
                        class9.method131();
                        return;
                     }
                  }

                  if(null != class27.field652) {
                     class9.method131();
                  }
               }

               var8 = class140.field2146;
               var1 = class140.field2135;
               var2 = class140.field2148;
               if(!class3.field66 && var8 == 4) {
                  var8 = 1;
               }

               short var4;
               int var11;
               if(class31.field702 == 0) {
                  var11 = class31.field699 + 180 - 80;
                  var4 = 291;
                  if(1 == var8 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                     class144.method3102(class25.method631("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var11 = 80 + class31.field699 + 180;
                  if(var8 == 1 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                     if((client.field280 & 33554432) != 0) {
                        class31.field710 = "";
                        class31.field711 = "This is a <col=00ffff>Tournament<col=ffffff> world.";
                        class31.field712 = "Max stats and high level gear are provided.";
                        class31.field713 = "Your normal account will not be affected.";
                        class31.field702 = 1;
                        class31.field718 = 0;
                     } else if((client.field280 & 4) != 0) {
                        if((client.field280 & 1024) != 0) {
                           class31.field711 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class31.field712 = "Players can attack each other almost everywhere";
                           class31.field713 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class31.field711 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class31.field712 = "Players can attack each other";
                           class31.field713 = "almost everywhere.";
                        }

                        class31.field710 = "Warning!";
                        class31.field702 = 1;
                        class31.field718 = 0;
                     } else if((client.field280 & 1024) != 0) {
                        class31.field711 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class31.field712 = "The Protect Item prayer will";
                        class31.field713 = "not work on this world.";
                        class31.field710 = "Warning!";
                        class31.field702 = 1;
                        class31.field718 = 0;
                     } else {
                        class31.field711 = "";
                        class31.field712 = "Enter your username/email & password.";
                        class31.field713 = "";
                        class31.field702 = 2;
                        class31.field718 = 0;
                     }
                  }
               } else if(1 != class31.field702) {
                  short var12;
                  if(2 == class31.field702) {
                     var12 = 231;
                     var11 = var12 + 30;
                     if(var8 == 1 && var2 >= var11 - 15 && var2 < var11) {
                        class31.field718 = 0;
                     }

                     var11 += 15;
                     if(1 == var8 && var2 >= var11 - 15 && var2 < var11) {
                        class31.field718 = 1;
                     }

                     var11 += 15;
                     var12 = 361;
                     if(var8 == 1 && var2 >= var12 - 15 && var2 < var12) {
                        class121.method2750("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field702 = 5;
                        return;
                     }

                     int var13 = 180 + class31.field699 - 80;
                     short var5 = 321;
                     if(var8 == 1 && var1 >= var13 - 75 && var1 <= var13 + 75 && var2 >= var5 - 20 && var2 <= var5 + 20) {
                        class31.field703 = class31.field703.trim();
                        if(class31.field703.length() == 0) {
                           class121.method2750("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class31.field715.length() == 0) {
                           class121.method2750("", "Please enter your password.", "");
                           return;
                        }

                        class121.method2750("", "Connecting to server...", "");
                        class31.field716 = class39.field865.field144.containsKey(Integer.valueOf(class16.method181(class31.field703)))?class159.field2602:class159.field2599;
                        class141.method2971(20);
                        return;
                     }

                     var13 = class31.field699 + 180 + 80;
                     if(var8 == 1 && var1 >= var13 - 75 && var1 <= 75 + var13 && var2 >= var5 - 20 && var2 <= var5 + 20) {
                        class31.field702 = 0;
                        class31.field703 = "";
                        class31.field715 = "";
                        class5.field99 = 0;
                        class9.field153 = "";
                        class31.field717 = true;
                     }

                     while(true) {
                        while(class124.method2790()) {
                           boolean var6 = false;

                           for(int var7 = 0; var7 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var7) {
                              if(class108.field1883 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var7)) {
                                 var6 = true;
                                 break;
                              }
                           }

                           if(13 == class141.field2158) {
                              class31.field702 = 0;
                              class31.field703 = "";
                              class31.field715 = "";
                              class5.field99 = 0;
                              class9.field153 = "";
                              class31.field717 = true;
                           } else if(class31.field718 == 0) {
                              if(85 == class141.field2158 && class31.field703.length() > 0) {
                                 class31.field703 = class31.field703.substring(0, class31.field703.length() - 1);
                              }

                              if(84 == class141.field2158 || class141.field2158 == 80) {
                                 class31.field718 = 1;
                              }

                              if(var6 && class31.field703.length() < 320) {
                                 class31.field703 = class31.field703 + class108.field1883;
                              }
                           } else if(class31.field718 == 1) {
                              if(class141.field2158 == 85 && class31.field715.length() > 0) {
                                 class31.field715 = class31.field715.substring(0, class31.field715.length() - 1);
                              }

                              if(84 == class141.field2158 || 80 == class141.field2158) {
                                 class31.field718 = 0;
                              }

                              if(class141.field2158 == 84) {
                                 class31.field703 = class31.field703.trim();
                                 if(class31.field703.length() == 0) {
                                    class121.method2750("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class31.field715.length() == 0) {
                                    class121.method2750("", "Please enter your password.", "");
                                    return;
                                 }

                                 class121.method2750("", "Connecting to server...", "");
                                 class31.field716 = class39.field865.field144.containsKey(Integer.valueOf(class16.method181(class31.field703)))?class159.field2602:class159.field2599;
                                 class141.method2971(20);
                                 return;
                              }

                              if(var6 && class31.field715.length() < 20) {
                                 class31.field715 = class31.field715 + class108.field1883;
                              }
                           }
                        }

                        return;
                     }
                  } else if(3 == class31.field702) {
                     var11 = class31.field699 + 180;
                     var4 = 276;
                     if(1 == var8 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                        class31.field711 = "";
                        class31.field712 = "Enter your username/email & password.";
                        class31.field713 = "";
                        class31.field702 = 2;
                        class31.field718 = 0;
                     }

                     var11 = class31.field699 + 180;
                     var4 = 326;
                     if(1 == var8 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                        class121.method2750("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field702 = 5;
                        return;
                     }
                  } else {
                     boolean var14;
                     int var15;
                     if(4 == class31.field702) {
                        var11 = class31.field699 + 180 - 80;
                        var4 = 321;
                        if(1 == var8 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                           class9.field153.trim();
                           if(class9.field153.length() != 6) {
                              class121.method2750("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class5.field99 = Integer.parseInt(class9.field153);
                           class9.field153 = "";
                           class31.field716 = class31.field717?class159.field2598:class159.field2597;
                           class121.method2750("", "Connecting to server...", "");
                           class141.method2971(20);
                           return;
                        }

                        if(1 == var8 && var1 >= class31.field699 + 180 - 9 && var1 <= 130 + 180 + class31.field699 && var2 >= 263 && var2 <= 296) {
                           class31.field717 = !class31.field717;
                        }

                        if(1 == var8 && var1 >= class31.field699 + 180 - 34 && var1 <= 180 + class31.field699 + 34 && var2 >= 351 && var2 <= 363) {
                           class144.method3102(class25.method631("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var11 = 80 + 180 + class31.field699;
                        if(1 == var8 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                           class31.field702 = 0;
                           class31.field703 = "";
                           class31.field715 = "";
                           class5.field99 = 0;
                           class9.field153 = "";
                        }

                        while(class124.method2790()) {
                           var14 = false;

                           for(var15 = 0; var15 < "1234567890".length(); ++var15) {
                              if(class108.field1883 == "1234567890".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(13 == class141.field2158) {
                              class31.field702 = 0;
                              class31.field703 = "";
                              class31.field715 = "";
                              class5.field99 = 0;
                              class9.field153 = "";
                           } else {
                              if(85 == class141.field2158 && class9.field153.length() > 0) {
                                 class9.field153 = class9.field153.substring(0, class9.field153.length() - 1);
                              }

                              if(84 == class141.field2158) {
                                 class9.field153.trim();
                                 if(class9.field153.length() != 6) {
                                    class121.method2750("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class5.field99 = Integer.parseInt(class9.field153);
                                 class9.field153 = "";
                                 class31.field716 = class31.field717?class159.field2598:class159.field2597;
                                 class121.method2750("", "Connecting to server...", "");
                                 class141.method2971(20);
                                 return;
                              }

                              if(var14 && class9.field153.length() < 6) {
                                 class9.field153 = class9.field153 + class108.field1883;
                              }
                           }
                        }
                     } else if(5 == class31.field702) {
                        var11 = 180 + class31.field699 - 80;
                        var4 = 321;
                        if(1 == var8 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                           class87.method2091();
                           return;
                        }

                        var11 = class31.field699 + 180 + 80;
                        if(1 == var8 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                           class31.field711 = "";
                           class31.field712 = "Enter your username/email & password.";
                           class31.field713 = "";
                           class31.field702 = 2;
                           class31.field718 = 0;
                           class31.field715 = "";
                        }

                        while(class124.method2790()) {
                           var14 = false;

                           for(var15 = 0; var15 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var15) {
                              if(class108.field1883 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(13 == class141.field2158) {
                              class31.field711 = "";
                              class31.field712 = "Enter your username/email & password.";
                              class31.field713 = "";
                              class31.field702 = 2;
                              class31.field718 = 0;
                              class31.field715 = "";
                           } else {
                              if(class141.field2158 == 85 && class31.field703.length() > 0) {
                                 class31.field703 = class31.field703.substring(0, class31.field703.length() - 1);
                              }

                              if(84 == class141.field2158) {
                                 class87.method2091();
                                 return;
                              }

                              if(var14 && class31.field703.length() < 320) {
                                 class31.field703 = class31.field703 + class108.field1883;
                              }
                           }
                        }
                     } else if(6 == class31.field702) {
                        while(true) {
                           do {
                              if(!class124.method2790()) {
                                 var12 = 321;
                                 if(var8 == 1 && var2 >= var12 - 20 && var2 <= var12 + 20) {
                                    class31.field711 = "";
                                    class31.field712 = "Enter your username/email & password.";
                                    class31.field713 = "";
                                    class31.field702 = 2;
                                    class31.field718 = 0;
                                    class31.field715 = "";
                                 }

                                 return;
                              }
                           } while(84 != class141.field2158 && class141.field2158 != 13);

                           class31.field711 = "";
                           class31.field712 = "Enter your username/email & password.";
                           class31.field713 = "";
                           class31.field702 = 2;
                           class31.field718 = 0;
                           class31.field715 = "";
                        }
                     }
                  }
               } else {
                  while(class124.method2790()) {
                     if(class141.field2158 == 84) {
                        class31.field711 = "";
                        class31.field712 = "Enter your username/email & password.";
                        class31.field713 = "";
                        class31.field702 = 2;
                        class31.field718 = 0;
                     } else if(class141.field2158 == 13) {
                        class31.field702 = 0;
                     }
                  }

                  var11 = class31.field699 + 180 - 80;
                  var4 = 321;
                  if(var8 == 1 && var1 >= var11 - 75 && var1 <= 75 + var11 && var2 >= var4 - 20 && var2 <= 20 + var4) {
                     class31.field711 = "";
                     class31.field712 = "Enter your username/email & password.";
                     class31.field713 = "";
                     class31.field702 = 2;
                     class31.field718 = 0;
                  }

                  var11 = 180 + class31.field699 + 80;
                  if(var8 == 1 && var1 >= var11 - 75 && var1 <= var11 + 75 && var2 >= var4 - 20 && var2 <= var4 + 20) {
                     class31.field702 = 0;
                  }
               }

            }
         }
      }
   }
}
