import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class51 extends class207 {
   @ObfuscatedName("g")
   public static class170 field1127;
   @ObfuscatedName("e")
   static class196 field1128 = new class196(64);
   @ObfuscatedName("h")
   @Export("spriteCache")
   static class196 field1129 = new class196(64);
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 343161613
   )
   int field1130 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 91035515
   )
   int field1131 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -465465731
   )
   public int field1133 = 16777215;
   @ObfuscatedName("l")
   public static class170 field1134;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2119655079
   )
   public int field1135 = 70;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1478067921
   )
   int field1136 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -901440423
   )
   int field1137 = -1;
   @ObfuscatedName("s")
   static class196 field1138 = new class196(20);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 132407137
   )
   int field1139 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1482299811
   )
   public int field1140 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -819716559
   )
   public int field1142 = -1;
   @ObfuscatedName("x")
   String field1143 = "";
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1200379707
   )
   public int field1144 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -59737953
   )
   public int field1145 = 0;
   @ObfuscatedName("ck")
   public static char field1146;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -428384161
   )
   public int field1150 = 0;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "1779459932"
   )
   void method1079(class122 var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method1080(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "1473135211"
   )
   void method1080(class122 var1, int var2) {
      if(var2 == 1) {
         this.field1131 = var1.method2698();
      } else if(var2 == 2) {
         this.field1133 = var1.method2637();
      } else if(var2 == 3) {
         this.field1130 = var1.method2698();
      } else if(var2 == 4) {
         this.field1136 = var1.method2698();
      } else if(var2 == 5) {
         this.field1137 = var1.method2698();
      } else if(var2 == 6) {
         this.field1139 = var1.method2698();
      } else if(var2 == 7) {
         this.field1140 = var1.method2636();
      } else if(var2 == 8) {
         this.field1143 = var1.method2642();
      } else if(var2 == 9) {
         this.field1135 = var1.method2635();
      } else if(var2 == 10) {
         this.field1150 = var1.method2636();
      } else if(var2 == 11) {
         this.field1142 = 0;
      } else if(var2 == 12) {
         this.field1144 = var1.method2633();
      } else if(var2 == 13) {
         this.field1145 = var1.method2636();
      } else if(var2 == 14) {
         this.field1142 = var1.method2635();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "67"
   )
   public String method1081(int var1) {
      String var2 = this.field1143;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + class21.method583(var1, false) + var2.substring(2 + var3);
      }
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "-10475"
   )
   static final void method1082(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field496; ++var4) {
         if(client.field503[var4] + client.field501[var4] > var0 && client.field501[var4] < var2 + var0 && client.field502[var4] + client.field504[var4] > var1 && client.field502[var4] < var3 + var1) {
            client.field498[var4] = true;
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Lclass81;",
      garbageValue = "-32"
   )
   public class81 method1084() {
      if(this.field1136 < 0) {
         return null;
      } else {
         class81 var1 = (class81)field1129.method3905((long)this.field1136);
         if(null != var1) {
            return var1;
         } else {
            var1 = class32.method699(field1127, this.field1136, 0);
            if(var1 != null) {
               field1129.method3907(var1, (long)this.field1136);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Lclass81;",
      garbageValue = "-116"
   )
   public class81 method1085() {
      if(this.field1139 < 0) {
         return null;
      } else {
         class81 var1 = (class81)field1129.method3905((long)this.field1139);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class32.method699(field1127, this.field1139, 0);
            if(var1 != null) {
               field1129.method3907(var1, (long)this.field1139);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "47"
   )
   @Export("menuAction")
   static final void method1090(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 39) {
         client.field337.method2903(182);
         client.field337.method2619(var0);
         client.field337.method2675(var1);
         client.field337.method2666(var3);
         client.field300 = 0;
         class42.field994 = class134.method2983(var1);
         client.field509 = var0;
      }

      if(var2 == 21) {
         client.field480 = var6;
         client.field404 = var7;
         client.field406 = 2;
         client.field537 = 0;
         client.field371 = var0;
         client.field529 = var1;
         client.field337.method2903(101);
         client.field337.method2619(var0 + class0.field11);
         client.field337.method2668(var3);
         client.field337.method2658(class140.field2171[82]?1:0);
         client.field337.method2668(var1 + class21.field592);
      }

      class2 var8;
      if(var2 == 49) {
         var8 = client.field302[var3];
         if(var8 != null) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(201);
            client.field337.method2619(var3);
            client.field337.method2657(class140.field2171[82]?1:0);
         }
      }

      if(var2 == 19) {
         client.field480 = var6;
         client.field404 = var7;
         client.field406 = 2;
         client.field537 = 0;
         client.field371 = var0;
         client.field529 = var1;
         client.field337.method2903(211);
         client.field337.method2654(class140.field2171[82]?1:0);
         client.field337.method2668(var3);
         client.field337.method2619(class0.field11 + var0);
         client.field337.method2619(class21.field592 + var1);
      }

      if(var2 == 2) {
         client.field480 = var6;
         client.field404 = var7;
         client.field406 = 2;
         client.field537 = 0;
         client.field371 = var0;
         client.field529 = var1;
         client.field337.method2903(127);
         client.field337.method2668(var0 + class0.field11);
         client.field337.method2666(var3 >> 14 & 32767);
         client.field337.method2675(class13.field209);
         client.field337.method2657(class140.field2171[82]?1:0);
         client.field337.method2668(client.field449);
         client.field337.method2619(var1 + class21.field592);
      }

      if(var2 == 23) {
         class136.field2126.method2028(class99.field1701, var0, var1);
      }

      if(var2 == 3) {
         client.field480 = var6;
         client.field404 = var7;
         client.field406 = 2;
         client.field537 = 0;
         client.field371 = var0;
         client.field529 = var1;
         client.field337.method2903(219);
         client.field337.method2666(var3 >> 14 & 32767);
         client.field337.method2666(class0.field11 + var0);
         client.field337.method2783(class140.field2171[82]?1:0);
         client.field337.method2666(var1 + class21.field592);
      }

      if(var2 == 1004) {
         client.field480 = var6;
         client.field404 = var7;
         client.field406 = 2;
         client.field537 = 0;
         client.field337.method2903(165);
         client.field337.method2668(var3);
      }

      if(var2 == 42) {
         client.field337.method2903(38);
         client.field337.method2668(var0);
         client.field337.method2675(var1);
         client.field337.method2668(var3);
         client.field300 = 0;
         class42.field994 = class134.method2983(var1);
         client.field509 = var0;
      }

      if(var2 == 37) {
         client.field337.method2903(116);
         client.field337.method2667(var0);
         client.field337.method2668(var3);
         client.field337.method2676(var1);
         client.field300 = 0;
         class42.field994 = class134.method2983(var1);
         client.field509 = var0;
      }

      int var10;
      class176 var11;
      if(var2 == 29) {
         client.field337.method2903(23);
         client.field337.method2728(var1);
         var11 = class134.method2983(var1);
         if(null != var11.field2919 && var11.field2919[0][0] == 5) {
            var10 = var11.field2919[0][1];
            if(class179.field2958[var10] != var11.field2921[0]) {
               class179.field2958[var10] = var11.field2921[0];
               class213.method4080(var10);
            }
         }
      }

      class36 var12;
      if(var2 == 8) {
         var12 = client.field332[var3];
         if(var12 != null) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(133);
            client.field337.method2783(class140.field2171[82]?1:0);
            client.field337.method2666(var3);
            client.field337.method2666(client.field449);
            client.field337.method2677(class13.field209);
         }
      }

      if(var2 == 5) {
         client.field480 = var6;
         client.field404 = var7;
         client.field406 = 2;
         client.field537 = 0;
         client.field371 = var0;
         client.field529 = var1;
         client.field337.method2903(99);
         client.field337.method2619(var0 + class0.field11);
         client.field337.method2619(var3 >> 14 & 32767);
         client.field337.method2658(class140.field2171[82]?1:0);
         client.field337.method2619(var1 + class21.field592);
      }

      if(var2 == 44) {
         var8 = client.field302[var3];
         if(null != var8) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(82);
            client.field337.method2783(class140.field2171[82]?1:0);
            client.field337.method2668(var3);
         }
      }

      if(var2 == 12) {
         var12 = client.field332[var3];
         if(null != var12) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(141);
            client.field337.method2666(var3);
            client.field337.method2783(class140.field2171[82]?1:0);
         }
      }

      if(var2 == 9) {
         var12 = client.field332[var3];
         if(var12 != null) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(248);
            client.field337.method2668(var3);
            client.field337.method2783(class140.field2171[82]?1:0);
         }
      }

      if(var2 == 1002) {
         client.field480 = var6;
         client.field404 = var7;
         client.field406 = 2;
         client.field537 = 0;
         client.field337.method2903(223);
         client.field337.method2619(var3 >> 14 & 32767);
      }

      if(var2 == 24) {
         var11 = class134.method2983(var1);
         boolean var13 = true;
         if(var11.field2811 > 0) {
            var13 = class126.method2917(var11);
         }

         if(var13) {
            client.field337.method2903(23);
            client.field337.method2728(var1);
         }
      }

      if(var2 == 34) {
         client.field337.method2903(147);
         client.field337.method2675(var1);
         client.field337.method2619(var3);
         client.field337.method2668(var0);
         client.field300 = 0;
         class42.field994 = class134.method2983(var1);
         client.field509 = var0;
      }

      if(var2 == 47) {
         var8 = client.field302[var3];
         if(null != var8) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(160);
            client.field337.method2657(class140.field2171[82]?1:0);
            client.field337.method2668(var3);
         }
      }

      if(var2 == 50) {
         var8 = client.field302[var3];
         if(null != var8) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(120);
            client.field337.method2658(class140.field2171[82]?1:0);
            client.field337.method2666(var3);
         }
      }

      if(var2 == 51) {
         var8 = client.field302[var3];
         if(var8 != null) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(63);
            client.field337.method2619(var3);
            client.field337.method2658(class140.field2171[82]?1:0);
         }
      }

      if(var2 == 58) {
         var11 = class151.method3265(var1, var0);
         if(var11 != null) {
            client.field337.method2903(213);
            client.field337.method2676(var1);
            client.field337.method2667(client.field449);
            client.field337.method2619(var0);
            client.field337.method2668(var11.field2879);
            client.field337.method2675(class13.field209);
            client.field337.method2668(client.field459);
         }
      }

      if(var2 == 1) {
         client.field480 = var6;
         client.field404 = var7;
         client.field406 = 2;
         client.field537 = 0;
         client.field371 = var0;
         client.field529 = var1;
         client.field337.method2903(89);
         client.field337.method2677(class97.field1688);
         client.field337.method2668(class21.field592 + var1);
         client.field337.method2619(class23.field618);
         client.field337.method2668(class0.field11 + var0);
         client.field337.method2619(var3 >> 14 & 32767);
         client.field337.method2783(class140.field2171[82]?1:0);
         client.field337.method2667(class10.field165);
      }

      if(var2 == 22) {
         client.field480 = var6;
         client.field404 = var7;
         client.field406 = 2;
         client.field537 = 0;
         client.field371 = var0;
         client.field529 = var1;
         client.field337.method2903(87);
         client.field337.method2658(class140.field2171[82]?1:0);
         client.field337.method2619(class21.field592 + var1);
         client.field337.method2667(class0.field11 + var0);
         client.field337.method2668(var3);
      }

      if(var2 == 14) {
         var8 = client.field302[var3];
         if(null != var8) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(66);
            client.field337.method2619(class23.field618);
            client.field337.method2675(class97.field1688);
            client.field337.method2657(class140.field2171[82]?1:0);
            client.field337.method2667(var3);
            client.field337.method2667(class10.field165);
         }
      }

      if(var2 == 48) {
         var8 = client.field302[var3];
         if(null != var8) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(156);
            client.field337.method2783(class140.field2171[82]?1:0);
            client.field337.method2668(var3);
         }
      }

      if(var2 == 45) {
         var8 = client.field302[var3];
         if(null != var8) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(140);
            client.field337.method2783(class140.field2171[82]?1:0);
            client.field337.method2619(var3);
         }
      }

      if(var2 == 30 && client.field376 == null) {
         class33.method718(var1, var0);
         client.field376 = class151.method3265(var1, var0);
         class79.method1777(client.field376);
      }

      if(var2 == 17) {
         client.field480 = var6;
         client.field404 = var7;
         client.field406 = 2;
         client.field537 = 0;
         client.field371 = var0;
         client.field529 = var1;
         client.field337.method2903(48);
         client.field337.method2658(class140.field2171[82]?1:0);
         client.field337.method2619(client.field449);
         client.field337.method2668(class21.field592 + var1);
         client.field337.method2666(class0.field11 + var0);
         client.field337.method2728(class13.field209);
         client.field337.method2666(var3);
      }

      if(var2 == 11) {
         var12 = client.field332[var3];
         if(null != var12) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(102);
            client.field337.method2666(var3);
            client.field337.method2783(class140.field2171[82]?1:0);
         }
      }

      if(var2 == 18) {
         client.field480 = var6;
         client.field404 = var7;
         client.field406 = 2;
         client.field537 = 0;
         client.field371 = var0;
         client.field529 = var1;
         client.field337.method2903(129);
         client.field337.method2668(var0 + class0.field11);
         client.field337.method2619(var3);
         client.field337.method2668(class21.field592 + var1);
         client.field337.method2658(class140.field2171[82]?1:0);
      }

      if(var2 == 28) {
         client.field337.method2903(23);
         client.field337.method2728(var1);
         var11 = class134.method2983(var1);
         if(var11.field2919 != null && var11.field2919[0][0] == 5) {
            var10 = var11.field2919[0][1];
            class179.field2958[var10] = 1 - class179.field2958[var10];
            class213.method4080(var10);
         }
      }

      if(var2 == 35) {
         client.field337.method2903(207);
         client.field337.method2675(var1);
         client.field337.method2619(var0);
         client.field337.method2668(var3);
         client.field300 = 0;
         class42.field994 = class134.method2983(var1);
         client.field509 = var0;
      }

      if(var2 == 38) {
         class0.method0();
         var11 = class134.method2983(var1);
         client.field439 = 1;
         class23.field618 = var0;
         class97.field1688 = var1;
         class10.field165 = var3;
         class79.method1777(var11);
         client.field447 = class16.method205(16748608) + class1.method14(var3).field1183 + class16.method205(16777215);
         if(null == client.field447) {
            client.field447 = "null";
         }

      } else {
         if(var2 == 4) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(13);
            client.field337.method2667(var3 >> 14 & 32767);
            client.field337.method2658(class140.field2171[82]?1:0);
            client.field337.method2619(var0 + class0.field11);
            client.field337.method2619(class21.field592 + var1);
         }

         if(var2 == 41) {
            client.field337.method2903(135);
            client.field337.method2668(var0);
            client.field337.method2728(var1);
            client.field337.method2668(var3);
            client.field300 = 0;
            class42.field994 = class134.method2983(var1);
            client.field509 = var0;
         }

         if(var2 == 6) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(36);
            client.field337.method2666(class21.field592 + var1);
            client.field337.method2667(var3 >> 14 & 32767);
            client.field337.method2619(class0.field11 + var0);
            client.field337.method2657(class140.field2171[82]?1:0);
         }

         if(var2 == 1005) {
            var11 = class134.method2983(var1);
            if(var11 != null && var11.field2926[var0] >= 100000) {
               class78.method1721(27, "", var11.field2926[var0] + " x " + class1.method14(var3).field1183);
            } else {
               client.field337.method2903(165);
               client.field337.method2668(var3);
            }

            client.field300 = 0;
            class42.field994 = class134.method2983(var1);
            client.field509 = var0;
         }

         if(var2 == 16) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(240);
            client.field337.method2667(var3);
            client.field337.method2668(class23.field618);
            client.field337.method2668(var0 + class0.field11);
            client.field337.method2667(class21.field592 + var1);
            client.field337.method2675(class97.field1688);
            client.field337.method2657(class140.field2171[82]?1:0);
            client.field337.method2619(class10.field165);
         }

         if(var2 == 7) {
            var12 = client.field332[var3];
            if(null != var12) {
               client.field480 = var6;
               client.field404 = var7;
               client.field406 = 2;
               client.field537 = 0;
               client.field371 = var0;
               client.field529 = var1;
               client.field337.method2903(46);
               client.field337.method2783(class140.field2171[82]?1:0);
               client.field337.method2667(var3);
               client.field337.method2668(class10.field165);
               client.field337.method2666(class23.field618);
               client.field337.method2676(class97.field1688);
            }
         }

         if(var2 == 10) {
            var12 = client.field332[var3];
            if(var12 != null) {
               client.field480 = var6;
               client.field404 = var7;
               client.field406 = 2;
               client.field537 = 0;
               client.field371 = var0;
               client.field529 = var1;
               client.field337.method2903(9);
               client.field337.method2667(var3);
               client.field337.method2657(class140.field2171[82]?1:0);
            }
         }

         if(var2 == 33) {
            client.field337.method2903(6);
            client.field337.method2667(var3);
            client.field337.method2666(var0);
            client.field337.method2675(var1);
            client.field300 = 0;
            class42.field994 = class134.method2983(var1);
            client.field509 = var0;
         }

         if(var2 == 20) {
            client.field480 = var6;
            client.field404 = var7;
            client.field406 = 2;
            client.field537 = 0;
            client.field371 = var0;
            client.field529 = var1;
            client.field337.method2903(252);
            client.field337.method2667(var3);
            client.field337.method2666(class0.field11 + var0);
            client.field337.method2668(class21.field592 + var1);
            client.field337.method2658(class140.field2171[82]?1:0);
         }

         if(var2 == 40) {
            client.field337.method2903(142);
            client.field337.method2666(var3);
            client.field337.method2666(var0);
            client.field337.method2728(var1);
            client.field300 = 0;
            class42.field994 = class134.method2983(var1);
            client.field509 = var0;
         }

         if(var2 == 26) {
            client.field337.method2903(197);

            for(class3 var14 = (class3)client.field475.method3939(); var14 != null; var14 = (class3)client.field475.method3935()) {
               if(var14.field60 == 0 || var14.field60 == 3) {
                  class145.method3130(var14, true);
               }
            }

            if(null != client.field376) {
               class79.method1777(client.field376);
               client.field376 = null;
            }
         }

         if(var2 == 31) {
            client.field337.method2903(131);
            client.field337.method2668(class23.field618);
            client.field337.method2666(var0);
            client.field337.method2728(class97.field1688);
            client.field337.method2666(var3);
            client.field337.method2666(class10.field165);
            client.field337.method2676(var1);
            client.field300 = 0;
            class42.field994 = class134.method2983(var1);
            client.field509 = var0;
         }

         if(var2 == 15) {
            var8 = client.field302[var3];
            if(null != var8) {
               client.field480 = var6;
               client.field404 = var7;
               client.field406 = 2;
               client.field537 = 0;
               client.field371 = var0;
               client.field529 = var1;
               client.field337.method2903(88);
               client.field337.method2783(class140.field2171[82]?1:0);
               client.field337.method2728(class13.field209);
               client.field337.method2667(var3);
               client.field337.method2667(client.field449);
            }
         }

         if(var2 == 36) {
            client.field337.method2903(245);
            client.field337.method2667(var3);
            client.field337.method2666(var0);
            client.field337.method2677(var1);
            client.field300 = 0;
            class42.field994 = class134.method2983(var1);
            client.field509 = var0;
         }

         if(var2 == 32) {
            client.field337.method2903(228);
            client.field337.method2728(var1);
            client.field337.method2619(client.field449);
            client.field337.method2619(var0);
            client.field337.method2619(var3);
            client.field337.method2676(class13.field209);
            client.field300 = 0;
            class42.field994 = class134.method2983(var1);
            client.field509 = var0;
         }

         if(var2 == 13) {
            var12 = client.field332[var3];
            if(null != var12) {
               client.field480 = var6;
               client.field404 = var7;
               client.field406 = 2;
               client.field537 = 0;
               client.field371 = var0;
               client.field529 = var1;
               client.field337.method2903(76);
               client.field337.method2783(class140.field2171[82]?1:0);
               client.field337.method2668(var3);
            }
         }

         if(var2 == 25) {
            var11 = class151.method3265(var1, var0);
            if(null != var11) {
               class0.method0();
               class6.method109(var1, var0, class215.method4089(class2.method39(var11)), var11.field2879);
               client.field439 = 0;
               client.field306 = class4.method48(var11);
               if(client.field306 == null) {
                  client.field306 = "Null";
               }

               if(var11.field2855) {
                  client.field452 = var11.field2902 + class16.method205(16777215);
               } else {
                  client.field452 = class16.method205('\uff00') + var11.field2809 + class16.method205(16777215);
               }
            }

         } else {
            if(var2 == 1001) {
               client.field480 = var6;
               client.field404 = var7;
               client.field406 = 2;
               client.field537 = 0;
               client.field371 = var0;
               client.field529 = var1;
               client.field337.method2903(111);
               client.field337.method2783(class140.field2171[82]?1:0);
               client.field337.method2666(var1 + class21.field592);
               client.field337.method2666(var3 >> 14 & 32767);
               client.field337.method2619(var0 + class0.field11);
            }

            if(var2 == 46) {
               var8 = client.field302[var3];
               if(null != var8) {
                  client.field480 = var6;
                  client.field404 = var7;
                  client.field406 = 2;
                  client.field537 = 0;
                  client.field371 = var0;
                  client.field529 = var1;
                  client.field337.method2903(25);
                  client.field337.method2783(class140.field2171[82]?1:0);
                  client.field337.method2619(var3);
               }
            }

            if(var2 == 1003) {
               client.field480 = var6;
               client.field404 = var7;
               client.field406 = 2;
               client.field537 = 0;
               var12 = client.field332[var3];
               if(null != var12) {
                  class41 var9 = var12.field803;
                  if(null != var9.field937) {
                     var9 = var9.method820();
                  }

                  if(var9 != null) {
                     client.field337.method2903(178);
                     client.field337.method2666(var9.field924);
                  }
               }
            }

            if(var2 == 57 || var2 == 1007) {
               var11 = class151.method3265(var1, var0);
               if(null != var11) {
                  class50.method1077(var3, var1, var0, var11.field2879, var5);
               }
            }

            if(var2 == 43) {
               client.field337.method2903(81);
               client.field337.method2675(var1);
               client.field337.method2668(var0);
               client.field337.method2666(var3);
               client.field300 = 0;
               class42.field994 = class134.method2983(var1);
               client.field509 = var0;
            }

            if(client.field439 != 0) {
               client.field439 = 0;
               class79.method1777(class134.method2983(class97.field1688));
            }

            if(client.field448) {
               class0.method0();
            }

            if(null != class42.field994 && client.field300 == 0) {
               class79.method1777(class42.field994);
            }

         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Lclass227;",
      garbageValue = "1705751998"
   )
   public class227 method1094() {
      if(this.field1131 == -1) {
         return null;
      } else {
         class227 var1 = (class227)field1138.method3905((long)this.field1131);
         if(var1 != null) {
            return var1;
         } else {
            class170 var3 = field1127;
            class170 var4 = class225.field3226;
            int var5 = this.field1131;
            class227 var2;
            if(!class4.method49(var3, var5, 0)) {
               var2 = null;
            } else {
               byte[] var7 = var4.method3411(var5, 0);
               class227 var6;
               if(null == var7) {
                  var6 = null;
               } else {
                  class227 var8 = new class227(var7, class79.field1457, class180.field2962, class192.field3106, class79.field1458, class79.field1459, class145.field2236);
                  class55.method1182();
                  var6 = var8;
               }

               var2 = var6;
            }

            Object var10000 = null;
            return var2;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Lclass81;",
      garbageValue = "-604983827"
   )
   public class81 method1099() {
      if(this.field1130 < 0) {
         return null;
      } else {
         class81 var1 = (class81)field1129.method3905((long)this.field1130);
         if(null != var1) {
            return var1;
         } else {
            var1 = class32.method699(field1127, this.field1130, 0);
            if(var1 != null) {
               field1129.method3907(var1, (long)this.field1130);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Lclass81;",
      garbageValue = "1366787254"
   )
   public class81 method1101() {
      if(this.field1137 < 0) {
         return null;
      } else {
         class81 var1 = (class81)field1129.method3905((long)this.field1137);
         if(null != var1) {
            return var1;
         } else {
            var1 = class32.method699(field1127, this.field1137, 0);
            if(var1 != null) {
               field1129.method3907(var1, (long)this.field1137);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1968848073"
   )
   public static void method1116() {
      class46.field1063.method3910();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-31"
   )
   public static boolean method1117(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
