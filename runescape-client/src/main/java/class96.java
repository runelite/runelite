import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("VertexNormal")
public class class96 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1076118673
   )
   int field1600;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1508828965
   )
   int field1601;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1162125011
   )
   int field1602;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1964100777
   )
   int field1605;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass167;III)[Lclass78;",
      garbageValue = "1075606852"
   )
   static class78[] method2196(class167 var0, int var1, int var2) {
      return !class38.method766(var0, var1, var2)?null:class156.method3178();
   }

   class96(class96 var1) {
      this.field1605 = var1.field1605;
      this.field1601 = var1.field1601;
      this.field1602 = var1.field1602;
      this.field1600 = var1.field1600;
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lclass173;B)Ljava/lang/String;",
      garbageValue = "-43"
   )
   static String method2197(String var0, class173 var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + class113.method2450(class4.method42(var1, var2 - 1)) + var0.substring(2 + var3);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var4 = "";
            if(class17.field250 != null) {
               var4 = class26.method633(class17.field250.field2200);
               if(null != class17.field250.field2201) {
                  var4 = (String)class17.field250.field2201;
               }
            }

            var0 = var0.substring(0, var2) + var4 + var0.substring(4 + var2);
         }
      }

      return var0;
   }

   class96() {
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "-123"
   )
   @Export("menuAction")
   static final void method2198(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      class173 var8;
      if(var2 == 57 || var2 == 1007) {
         var8 = class165.method3247(var1, var0);
         if(var8 != null) {
            class48.method993(var3, var1, var0, var8.field2868, var5);
         }
      }

      if(var2 == 1005) {
         var8 = class161.method3205(var1);
         if(null != var8 && var8.field2745[var0] >= 100000) {
            class45.method955(27, "", var8.field2745[var0] + " x " + class35.method741(var3).field1090);
         } else {
            client.field331.method2781(138);
            client.field331.method2695(var3);
         }

         client.field401 = 0;
         class219.field3170 = class161.method3205(var1);
         client.field402 = var0;
      }

      if(var2 == 19) {
         client.field397 = var6;
         client.field398 = var7;
         client.field400 = 2;
         client.field304 = 0;
         client.field521 = var0;
         client.field522 = var1;
         client.field331.method2781(178);
         client.field331.method2693(var1 + class85.field1434);
         client.field331.method2693(var3);
         client.field331.method2650(class137.field2095[82]?1:0);
         client.field331.method2695(class4.field62 + var0);
      }

      if(var2 == 17) {
         client.field397 = var6;
         client.field398 = var7;
         client.field400 = 2;
         client.field304 = 0;
         client.field521 = var0;
         client.field522 = var1;
         client.field331.method2781(23);
         client.field331.method2547(var0 + class4.field62);
         client.field331.method2539(class137.field2095[82]?1:0);
         client.field331.method2695(var3);
         client.field331.method2547(var1 + class85.field1434);
         client.field331.method2502(class3.field56);
         client.field331.method2695(client.field443);
      }

      if(var2 == 38) {
         class22.method569();
         var8 = class161.method3205(var1);
         client.field352 = 1;
         class72.field1325 = var0;
         class0.field11 = var1;
         class178.field2909 = var3;
         class4.method37(var8);
         client.field349 = class158.method3184(16748608) + class35.method741(var3).field1090 + class158.method3184(16777215);
         if(client.field349 == null) {
            client.field349 = "null";
         }

      } else {
         class34 var11;
         if(var2 == 12) {
            var11 = client.field326[var3];
            if(var11 != null) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(230);
               client.field331.method2538(class137.field2095[82]?1:0);
               client.field331.method2547(var3);
            }
         }

         if(var2 == 1001) {
            client.field397 = var6;
            client.field398 = var7;
            client.field400 = 2;
            client.field304 = 0;
            client.field521 = var0;
            client.field522 = var1;
            client.field331.method2781(231);
            client.field331.method2547(class85.field1434 + var1);
            client.field331.method2545(var3 >> 14 & 32767);
            client.field331.method2597(class137.field2095[82]?1:0);
            client.field331.method2547(class4.field62 + var0);
         }

         if(var2 == 21) {
            client.field397 = var6;
            client.field398 = var7;
            client.field400 = 2;
            client.field304 = 0;
            client.field521 = var0;
            client.field522 = var1;
            client.field331.method2781(152);
            client.field331.method2695(class85.field1434 + var1);
            client.field331.method2693(var3);
            client.field331.method2545(class4.field62 + var0);
            client.field331.method2538(class137.field2095[82]?1:0);
         }

         if(var2 == 31) {
            client.field331.method2781(179);
            client.field331.method2502(class0.field11);
            client.field331.method2545(var0);
            client.field331.method2695(var3);
            client.field331.method2545(class72.field1325);
            client.field331.method2547(class178.field2909);
            client.field331.method2502(var1);
            client.field401 = 0;
            class219.field3170 = class161.method3205(var1);
            client.field402 = var0;
         }

         if(var2 == 30 && client.field451 == null) {
            client.field331.method2781(126);
            client.field331.method2695(var0);
            client.field331.method2502(var1);
            client.field451 = class165.method3247(var1, var0);
            class4.method37(client.field451);
         }

         class2 var12;
         if(var2 == 46) {
            var12 = client.field410[var3];
            if(null != var12) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(115);
               client.field331.method2650(class137.field2095[82]?1:0);
               client.field331.method2547(var3);
            }
         }

         if(var2 == 36) {
            client.field331.method2781(206);
            client.field331.method2545(var3);
            client.field331.method2557(var1);
            client.field331.method2545(var0);
            client.field401 = 0;
            class219.field3170 = class161.method3205(var1);
            client.field402 = var0;
         }

         if(var2 == 7) {
            var11 = client.field326[var3];
            if(null != var11) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(100);
               client.field331.method2695(class72.field1325);
               client.field331.method2547(var3);
               client.field331.method2538(class137.field2095[82]?1:0);
               client.field331.method2693(class178.field2909);
               client.field331.method2556(class0.field11);
            }
         }

         if(var2 == 48) {
            var12 = client.field410[var3];
            if(var12 != null) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(200);
               client.field331.method2547(var3);
               client.field331.method2597(class137.field2095[82]?1:0);
            }
         }

         if(var2 == 22) {
            client.field397 = var6;
            client.field398 = var7;
            client.field400 = 2;
            client.field304 = 0;
            client.field521 = var0;
            client.field522 = var1;
            client.field331.method2781(58);
            client.field331.method2547(class4.field62 + var0);
            client.field331.method2545(var3);
            client.field331.method2539(class137.field2095[82]?1:0);
            client.field331.method2693(class85.field1434 + var1);
         }

         if(var2 == 47) {
            var12 = client.field410[var3];
            if(var12 != null) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(250);
               client.field331.method2547(var3);
               client.field331.method2539(class137.field2095[82]?1:0);
            }
         }

         if(var2 == 10) {
            var11 = client.field326[var3];
            if(null != var11) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(235);
               client.field331.method2695(var3);
               client.field331.method2597(class137.field2095[82]?1:0);
            }
         }

         if(var2 == 1003) {
            client.field397 = var6;
            client.field398 = var7;
            client.field400 = 2;
            client.field304 = 0;
            var11 = client.field326[var3];
            if(null != var11) {
               class39 var10 = var11.field762;
               if(var10.field889 != null) {
                  var10 = var10.method773();
               }

               if(var10 != null) {
                  client.field331.method2781(161);
                  client.field331.method2547(var10.field867);
               }
            }
         }

         if(var2 == 50) {
            var12 = client.field410[var3];
            if(null != var12) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(228);
               client.field331.method2539(class137.field2095[82]?1:0);
               client.field331.method2695(var3);
            }
         }

         if(var2 == 8) {
            var11 = client.field326[var3];
            if(var11 != null) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(96);
               client.field331.method2545(client.field443);
               client.field331.method2539(class137.field2095[82]?1:0);
               client.field331.method2557(class3.field56);
               client.field331.method2693(var3);
            }
         }

         if(var2 == 3) {
            client.field397 = var6;
            client.field398 = var7;
            client.field400 = 2;
            client.field304 = 0;
            client.field521 = var0;
            client.field522 = var1;
            client.field331.method2781(176);
            client.field331.method2547(var3 >> 14 & 32767);
            client.field331.method2539(class137.field2095[82]?1:0);
            client.field331.method2547(class4.field62 + var0);
            client.field331.method2547(class85.field1434 + var1);
         }

         if(var2 == 1004) {
            client.field397 = var6;
            client.field398 = var7;
            client.field400 = 2;
            client.field304 = 0;
            client.field331.method2781(138);
            client.field331.method2695(var3);
         }

         if(var2 == 4) {
            client.field397 = var6;
            client.field398 = var7;
            client.field400 = 2;
            client.field304 = 0;
            client.field521 = var0;
            client.field522 = var1;
            client.field331.method2781(217);
            client.field331.method2545(var3 >> 14 & 32767);
            client.field331.method2650(class137.field2095[82]?1:0);
            client.field331.method2545(class4.field62 + var0);
            client.field331.method2547(var1 + class85.field1434);
         }

         if(var2 == 11) {
            var11 = client.field326[var3];
            if(null != var11) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(180);
               client.field331.method2693(var3);
               client.field331.method2597(class137.field2095[82]?1:0);
            }
         }

         if(var2 == 26) {
            class115.method2454();
         }

         if(var2 == 13) {
            var11 = client.field326[var3];
            if(var11 != null) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(27);
               client.field331.method2538(class137.field2095[82]?1:0);
               client.field331.method2695(var3);
            }
         }

         if(var2 == 34) {
            client.field331.method2781(50);
            client.field331.method2547(var0);
            client.field331.method2545(var3);
            client.field331.method2556(var1);
            client.field401 = 0;
            class219.field3170 = class161.method3205(var1);
            client.field402 = var0;
         }

         if(var2 == 41) {
            client.field331.method2781(81);
            client.field331.method2547(var0);
            client.field331.method2695(var3);
            client.field331.method2557(var1);
            client.field401 = 0;
            class219.field3170 = class161.method3205(var1);
            client.field402 = var0;
         }

         if(var2 == 33) {
            client.field331.method2781(232);
            client.field331.method2693(var0);
            client.field331.method2693(var3);
            client.field331.method2499(var1);
            client.field401 = 0;
            class219.field3170 = class161.method3205(var1);
            client.field402 = var0;
         }

         if(var2 == 49) {
            var12 = client.field410[var3];
            if(null != var12) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(162);
               client.field331.method2538(class137.field2095[82]?1:0);
               client.field331.method2545(var3);
            }
         }

         if(var2 == 42) {
            client.field331.method2781(149);
            client.field331.method2545(var0);
            client.field331.method2502(var1);
            client.field331.method2545(var3);
            client.field401 = 0;
            class219.field3170 = class161.method3205(var1);
            client.field402 = var0;
         }

         if(var2 == 24) {
            var8 = class161.method3205(var1);
            boolean var9 = true;
            if(var8.field2768 > 0) {
               var9 = class8.method110(var8);
            }

            if(var9) {
               client.field331.method2781(220);
               client.field331.method2502(var1);
            }
         }

         if(var2 == 39) {
            client.field331.method2781(119);
            client.field331.method2695(var0);
            client.field331.method2693(var3);
            client.field331.method2502(var1);
            client.field401 = 0;
            class219.field3170 = class161.method3205(var1);
            client.field402 = var0;
         }

         if(var2 == 18) {
            client.field397 = var6;
            client.field398 = var7;
            client.field400 = 2;
            client.field304 = 0;
            client.field521 = var0;
            client.field522 = var1;
            client.field331.method2781(122);
            client.field331.method2650(class137.field2095[82]?1:0);
            client.field331.method2545(var3);
            client.field331.method2545(var0 + class4.field62);
            client.field331.method2547(var1 + class85.field1434);
         }

         if(var2 == 1) {
            client.field397 = var6;
            client.field398 = var7;
            client.field400 = 2;
            client.field304 = 0;
            client.field521 = var0;
            client.field522 = var1;
            client.field331.method2781(101);
            client.field331.method2695(class178.field2909);
            client.field331.method2695(class72.field1325);
            client.field331.method2499(class0.field11);
            client.field331.method2695(var1 + class85.field1434);
            client.field331.method2693(var0 + class4.field62);
            client.field331.method2547(var3 >> 14 & 32767);
            client.field331.method2539(class137.field2095[82]?1:0);
         }

         int var13;
         if(var2 == 28) {
            client.field331.method2781(220);
            client.field331.method2502(var1);
            var8 = class161.method3205(var1);
            if(null != var8.field2860 && var8.field2860[0][0] == 5) {
               var13 = var8.field2860[0][1];
               class176.field2896[var13] = 1 - class176.field2896[var13];
               class4.method40(var13);
            }
         }

         if(var2 == 58) {
            var8 = class165.method3247(var1, var0);
            if(var8 != null) {
               client.field331.method2781(51);
               client.field331.method2556(class3.field56);
               client.field331.method2695(var0);
               client.field331.method2547(client.field319);
               client.field331.method2557(var1);
               client.field331.method2693(client.field443);
               client.field331.method2693(var8.field2868);
            }
         }

         if(var2 == 44) {
            var12 = client.field410[var3];
            if(null != var12) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(25);
               client.field331.method2539(class137.field2095[82]?1:0);
               client.field331.method2545(var3);
            }
         }

         if(var2 != 25) {
            if(var2 == 5) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(195);
               client.field331.method2547(var3 >> 14 & 32767);
               client.field331.method2597(class137.field2095[82]?1:0);
               client.field331.method2547(var0 + class4.field62);
               client.field331.method2547(var1 + class85.field1434);
            }

            if(var2 == 16) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(246);
               client.field331.method2693(var3);
               client.field331.method2547(class85.field1434 + var1);
               client.field331.method2650(class137.field2095[82]?1:0);
               client.field331.method2547(class178.field2909);
               client.field331.method2499(class0.field11);
               client.field331.method2695(class72.field1325);
               client.field331.method2545(class4.field62 + var0);
            }

            if(var2 == 32) {
               client.field331.method2781(216);
               client.field331.method2695(var0);
               client.field331.method2502(var1);
               client.field331.method2547(client.field443);
               client.field331.method2556(class3.field56);
               client.field331.method2693(var3);
               client.field401 = 0;
               class219.field3170 = class161.method3205(var1);
               client.field402 = var0;
            }

            if(var2 == 43) {
               client.field331.method2781(98);
               client.field331.method2556(var1);
               client.field331.method2693(var0);
               client.field331.method2547(var3);
               client.field401 = 0;
               class219.field3170 = class161.method3205(var1);
               client.field402 = var0;
            }

            if(var2 == 37) {
               client.field331.method2781(242);
               client.field331.method2557(var1);
               client.field331.method2547(var0);
               client.field331.method2547(var3);
               client.field401 = 0;
               class219.field3170 = class161.method3205(var1);
               client.field402 = var0;
            }

            if(var2 == 40) {
               client.field331.method2781(177);
               client.field331.method2545(var3);
               client.field331.method2557(var1);
               client.field331.method2695(var0);
               client.field401 = 0;
               class219.field3170 = class161.method3205(var1);
               client.field402 = var0;
            }

            if(var2 == 14) {
               var12 = client.field410[var3];
               if(var12 != null) {
                  client.field397 = var6;
                  client.field398 = var7;
                  client.field400 = 2;
                  client.field304 = 0;
                  client.field521 = var0;
                  client.field522 = var1;
                  client.field331.method2781(47);
                  client.field331.method2545(var3);
                  client.field331.method2545(class178.field2909);
                  client.field331.method2557(class0.field11);
                  client.field331.method2538(class137.field2095[82]?1:0);
                  client.field331.method2695(class72.field1325);
               }
            }

            if(var2 == 23) {
               class150.field2230.method1962(class144.field2193, var0, var1);
            }

            if(var2 == 51) {
               var12 = client.field410[var3];
               if(null != var12) {
                  client.field397 = var6;
                  client.field398 = var7;
                  client.field400 = 2;
                  client.field304 = 0;
                  client.field521 = var0;
                  client.field522 = var1;
                  client.field331.method2781(54);
                  client.field331.method2545(var3);
                  client.field331.method2539(class137.field2095[82]?1:0);
               }
            }

            if(var2 == 1002) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field331.method2781(74);
               client.field331.method2693(var3 >> 14 & 32767);
            }

            if(var2 == 20) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(62);
               client.field331.method2695(var3);
               client.field331.method2650(class137.field2095[82]?1:0);
               client.field331.method2693(var0 + class4.field62);
               client.field331.method2695(var1 + class85.field1434);
            }

            if(var2 == 29) {
               client.field331.method2781(220);
               client.field331.method2502(var1);
               var8 = class161.method3205(var1);
               if(null != var8.field2860 && var8.field2860[0][0] == 5) {
                  var13 = var8.field2860[0][1];
                  if(var8.field2862[0] != class176.field2896[var13]) {
                     class176.field2896[var13] = var8.field2862[0];
                     class4.method40(var13);
                  }
               }
            }

            if(var2 == 2) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(37);
               client.field331.method2547(client.field443);
               client.field331.method2693(var3 >> 14 & 32767);
               client.field331.method2547(var1 + class85.field1434);
               client.field331.method2556(class3.field56);
               client.field331.method2538(class137.field2095[82]?1:0);
               client.field331.method2547(var0 + class4.field62);
            }

            if(var2 == 15) {
               var12 = client.field410[var3];
               if(null != var12) {
                  client.field397 = var6;
                  client.field398 = var7;
                  client.field400 = 2;
                  client.field304 = 0;
                  client.field521 = var0;
                  client.field522 = var1;
                  client.field331.method2781(147);
                  client.field331.method2693(var3);
                  client.field331.method2695(client.field443);
                  client.field331.method2557(class3.field56);
                  client.field331.method2538(class137.field2095[82]?1:0);
               }
            }

            if(var2 == 45) {
               var12 = client.field410[var3];
               if(var12 != null) {
                  client.field397 = var6;
                  client.field398 = var7;
                  client.field400 = 2;
                  client.field304 = 0;
                  client.field521 = var0;
                  client.field522 = var1;
                  client.field331.method2781(30);
                  client.field331.method2693(var3);
                  client.field331.method2597(class137.field2095[82]?1:0);
               }
            }

            if(var2 == 35) {
               client.field331.method2781(34);
               client.field331.method2693(var0);
               client.field331.method2547(var3);
               client.field331.method2556(var1);
               client.field401 = 0;
               class219.field3170 = class161.method3205(var1);
               client.field402 = var0;
            }

            if(var2 == 9) {
               var11 = client.field326[var3];
               if(null != var11) {
                  client.field397 = var6;
                  client.field398 = var7;
                  client.field400 = 2;
                  client.field304 = 0;
                  client.field521 = var0;
                  client.field522 = var1;
                  client.field331.method2781(227);
                  client.field331.method2539(class137.field2095[82]?1:0);
                  client.field331.method2695(var3);
               }
            }

            if(var2 == 6) {
               client.field397 = var6;
               client.field398 = var7;
               client.field400 = 2;
               client.field304 = 0;
               client.field521 = var0;
               client.field522 = var1;
               client.field331.method2781(88);
               client.field331.method2547(var1 + class85.field1434);
               client.field331.method2597(class137.field2095[82]?1:0);
               client.field331.method2547(class4.field62 + var0);
               client.field331.method2693(var3 >> 14 & 32767);
            }

            if(client.field352 != 0) {
               client.field352 = 0;
               class4.method37(class161.method3205(class0.field11));
            }

            if(client.field442) {
               class22.method569();
            }

            if(class219.field3170 != null && client.field401 == 0) {
               class4.method37(class219.field3170);
            }

         } else {
            var8 = class165.method3247(var1, var0);
            if(var8 != null) {
               class22.method569();
               class107.method2386(var1, var0, class116.method2461(class34.method734(var8)), var8.field2868);
               client.field352 = 0;
               String var14;
               if(class116.method2461(class34.method734(var8)) == 0) {
                  var14 = null;
               } else if(null != var8.field2869 && var8.field2869.trim().length() != 0) {
                  var14 = var8.field2869;
               } else {
                  var14 = null;
               }

               client.field445 = var14;
               if(null == client.field445) {
                  client.field445 = "Null";
               }

               if(var8.field2741) {
                  client.field446 = var8.field2760 + class158.method3184(16777215);
               } else {
                  client.field446 = class158.method3184('\uff00') + var8.field2786 + class158.method3184(16777215);
               }
            }

         }
      }
   }
}
