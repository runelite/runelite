import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("NPC")
public final class class34 extends class37 {
   @ObfuscatedName("f")
   @Export("composition")
   class39 field782;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "1761466268"
   )
   final void method753(int var1, int var2, boolean var3) {
      if(super.field822 != -1 && method768(super.field822).field997 == 1) {
         super.field822 = -1;
      }

      if(!var3) {
         int var4 = var1 - super.field875[0];
         int var5 = var2 - super.field876[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field874 < 9) {
               ++super.field874;
            }

            for(int var6 = super.field874; var6 > 0; --var6) {
               super.field875[var6] = super.field875[var6 - 1];
               super.field876[var6] = super.field876[var6 - 1];
               super.field828[var6] = super.field828[var6 - 1];
            }

            super.field875[0] = var1;
            super.field876[0] = var2;
            super.field828[0] = 1;
            return;
         }
      }

      super.field874 = 0;
      super.field879 = 0;
      super.field865 = 0;
      super.field875[0] = var1;
      super.field876[0] = var2;
      super.field837 = super.field825 * 64 + super.field875[0] * 128;
      super.field880 = super.field876[0] * 128 + super.field825 * 64;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)Lclass105;",
      garbageValue = "1006"
   )
   protected final class105 vmethod1968() {
      if(this.field782 == null) {
         return null;
      } else {
         class42 var1 = super.field822 != -1 && super.field855 == 0?method768(super.field822):null;
         class42 var2 = super.field849 != -1 && (super.field849 != super.field826 || null == var1)?method768(super.field849):null;
         class105 var3 = this.field782.method811(var1, super.field853, var2, super.field868);
         if(var3 == null) {
            return null;
         } else {
            var3.method2357();
            super.field870 = var3.field1468;
            if(super.field857 != -1 && super.field821 != -1) {
               class105 var4 = class1.method12(super.field857).method952(super.field821);
               if(null != var4) {
                  var4.method2365(0, -super.field842, 0);
                  class105[] var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(this.field782.field907 == 1) {
               var3.field1829 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1658145806"
   )
   final boolean vmethod790() {
      return this.field782 != null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-1177655431"
   )
   final void method758(int var1, byte var2) {
      int var3 = super.field875[0];
      int var4 = super.field876[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.field822 != -1 && method768(super.field822).field997 == 1) {
         super.field822 = -1;
      }

      if(super.field874 < 9) {
         ++super.field874;
      }

      for(int var5 = super.field874; var5 > 0; --var5) {
         super.field875[var5] = super.field875[var5 - 1];
         super.field876[var5] = super.field876[var5 - 1];
         super.field828[var5] = super.field828[var5 - 1];
      }

      super.field875[0] = var3;
      super.field876[0] = var4;
      super.field828[0] = var2;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIS)V",
      garbageValue = "1337"
   )
   @Export("menuAction")
   static final void method761(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 43) {
         client.field333.method2773(204);
         client.field333.method2586(var3);
         client.field333.method2585(var0);
         client.field333.method2595(var1);
         client.field401 = 0;
         class59.field1225 = class153.method3177(var1);
         client.field402 = var0;
      }

      if(var2 == 22) {
         client.field346 = var6;
         client.field398 = var7;
         client.field394 = 2;
         client.field511 = 0;
         client.field482 = var0;
         client.field522 = var1;
         client.field333.method2773(71);
         client.field333.method2585(var1 + class20.field576);
         client.field333.method2654(class137.field2114[82]?1:0);
         client.field333.method2540(var3);
         client.field333.method2585(var0 + class172.field2734);
      }

      if(var2 == 17) {
         client.field346 = var6;
         client.field398 = var7;
         client.field394 = 2;
         client.field511 = 0;
         client.field482 = var0;
         client.field522 = var1;
         client.field333.method2773(54);
         client.field333.method2585(class20.field576 + var1);
         client.field333.method2595(class17.field253);
         client.field333.method2586(var0 + class172.field2734);
         client.field333.method2549(class137.field2114[82]?1:0);
         client.field333.method2585(client.field443);
         client.field333.method2586(var3);
      }

      if(var2 == 40) {
         client.field333.method2773(77);
         client.field333.method2585(var0);
         client.field333.method2594(var1);
         client.field333.method2584(var3);
         client.field401 = 0;
         class59.field1225 = class153.method3177(var1);
         client.field402 = var0;
      }

      class34 var8;
      if(var2 == 13) {
         var8 = client.field328[var3];
         if(var8 != null) {
            client.field346 = var6;
            client.field398 = var7;
            client.field394 = 2;
            client.field511 = 0;
            client.field482 = var0;
            client.field522 = var1;
            client.field333.method2773(59);
            client.field333.method2549(class137.field2114[82]?1:0);
            client.field333.method2585(var3);
         }
      }

      class2 var17;
      if(var2 == 50) {
         var17 = client.field302[var3];
         if(var17 != null) {
            client.field346 = var6;
            client.field398 = var7;
            client.field394 = 2;
            client.field511 = 0;
            client.field482 = var0;
            client.field522 = var1;
            client.field333.method2773(8);
            client.field333.method2586(var3);
            client.field333.method2578(class137.field2114[82]?1:0);
         }
      }

      if(var2 == 8) {
         var8 = client.field328[var3];
         if(null != var8) {
            client.field346 = var6;
            client.field398 = var7;
            client.field394 = 2;
            client.field511 = 0;
            client.field482 = var0;
            client.field522 = var1;
            client.field333.method2773(119);
            client.field333.method2539(class17.field253);
            client.field333.method2585(client.field443);
            client.field333.method2584(var3);
            client.field333.method2578(class137.field2114[82]?1:0);
         }
      }

      if(var2 == 32) {
         client.field333.method2773(137);
         client.field333.method2584(client.field443);
         client.field333.method2585(var3);
         client.field333.method2585(var0);
         client.field333.method2539(class17.field253);
         client.field333.method2539(var1);
         client.field401 = 0;
         class59.field1225 = class153.method3177(var1);
         client.field402 = var0;
      }

      if(var2 == 51) {
         var17 = client.field302[var3];
         if(null != var17) {
            client.field346 = var6;
            client.field398 = var7;
            client.field394 = 2;
            client.field511 = 0;
            client.field482 = var0;
            client.field522 = var1;
            client.field333.method2773(158);
            client.field333.method2584(var3);
            client.field333.method2549(class137.field2114[82]?1:0);
         }
      }

      if(var2 == 16) {
         client.field346 = var6;
         client.field398 = var7;
         client.field394 = 2;
         client.field511 = 0;
         client.field482 = var0;
         client.field522 = var1;
         client.field333.method2773(28);
         client.field333.method2540(class101.field1761);
         client.field333.method2549(class137.field2114[82]?1:0);
         client.field333.method2540(class20.field576 + var1);
         client.field333.method2586(var0 + class172.field2734);
         client.field333.method2540(class42.field1016);
         client.field333.method2586(var3);
         client.field333.method2539(class110.field1956);
      }

      if(var2 == 35) {
         client.field333.method2773(80);
         client.field333.method2593(var1);
         client.field333.method2584(var3);
         client.field333.method2586(var0);
         client.field401 = 0;
         class59.field1225 = class153.method3177(var1);
         client.field402 = var0;
      }

      if(var2 == 20) {
         client.field346 = var6;
         client.field398 = var7;
         client.field394 = 2;
         client.field511 = 0;
         client.field482 = var0;
         client.field522 = var1;
         client.field333.method2773(244);
         client.field333.method2586(var1 + class20.field576);
         client.field333.method2584(class172.field2734 + var0);
         client.field333.method2549(class137.field2114[82]?1:0);
         client.field333.method2585(var3);
      }

      if(var2 == 46) {
         var17 = client.field302[var3];
         if(var17 != null) {
            client.field346 = var6;
            client.field398 = var7;
            client.field394 = 2;
            client.field511 = 0;
            client.field482 = var0;
            client.field522 = var1;
            client.field333.method2773(188);
            client.field333.method2578(class137.field2114[82]?1:0);
            client.field333.method2585(var3);
         }
      }

      if(var2 == 19) {
         client.field346 = var6;
         client.field398 = var7;
         client.field394 = 2;
         client.field511 = 0;
         client.field482 = var0;
         client.field522 = var1;
         client.field333.method2773(229);
         client.field333.method2540(var0 + class172.field2734);
         client.field333.method2585(var3);
         client.field333.method2654(class137.field2114[82]?1:0);
         client.field333.method2584(class20.field576 + var1);
      }

      if(var2 == 4) {
         client.field346 = var6;
         client.field398 = var7;
         client.field394 = 2;
         client.field511 = 0;
         client.field482 = var0;
         client.field522 = var1;
         client.field333.method2773(108);
         client.field333.method2584(var1 + class20.field576);
         client.field333.method2584(var3 >> 14 & 32767);
         client.field333.method2586(class172.field2734 + var0);
         client.field333.method2654(class137.field2114[82]?1:0);
      }

      if(var2 == 9) {
         var8 = client.field328[var3];
         if(var8 != null) {
            client.field346 = var6;
            client.field398 = var7;
            client.field394 = 2;
            client.field511 = 0;
            client.field482 = var0;
            client.field522 = var1;
            client.field333.method2773(181);
            client.field333.method2654(class137.field2114[82]?1:0);
            client.field333.method2585(var3);
         }
      }

      if(var2 == 30 && null == client.field312) {
         class26.method678(var1, var0);
         client.field312 = class172.method3425(var1, var0);
         class39.method818(client.field312);
      }

      class173 var19;
      if(var2 == 58) {
         var19 = class172.method3425(var1, var0);
         if(var19 != null) {
            client.field333.method2773(84);
            client.field333.method2586(client.field443);
            client.field333.method2586(var19.field2764);
            client.field333.method2593(class17.field253);
            client.field333.method2584(client.field470);
            client.field333.method2586(var0);
            client.field333.method2594(var1);
         }
      }

      if(var2 == 7) {
         var8 = client.field328[var3];
         if(null != var8) {
            client.field346 = var6;
            client.field398 = var7;
            client.field394 = 2;
            client.field511 = 0;
            client.field482 = var0;
            client.field522 = var1;
            client.field333.method2773(179);
            client.field333.method2594(class110.field1956);
            client.field333.method2584(class101.field1761);
            client.field333.method2577(class137.field2114[82]?1:0);
            client.field333.method2584(var3);
            client.field333.method2584(class42.field1016);
         }
      }

      if(var2 == 37) {
         client.field333.method2773(27);
         client.field333.method2593(var1);
         client.field333.method2584(var3);
         client.field333.method2584(var0);
         client.field401 = 0;
         class59.field1225 = class153.method3177(var1);
         client.field402 = var0;
      }

      if(var2 == 25) {
         var19 = class172.method3425(var1, var0);
         if(null != var19) {
            class12.method165();
            int var12 = class18.method205(var19);
            int var11 = var12 >> 11 & 63;
            class13.method174(var1, var0, var11, var19.field2764);
            client.field353 = 0;
            int var15 = class18.method205(var19);
            int var14 = var15 >> 11 & 63;
            String var13;
            if(var14 == 0) {
               var13 = null;
            } else if(var19.field2795 != null && var19.field2795.trim().length() != 0) {
               var13 = var19.field2795;
            } else {
               var13 = null;
            }

            client.field445 = var13;
            if(null == client.field445) {
               client.field445 = "Null";
            }

            if(var19.field2860) {
               client.field446 = var19.field2833 + class164.method3251(16777215);
            } else {
               client.field446 = class164.method3251('\uff00') + var19.field2870 + class164.method3251(16777215);
            }
         }

      } else {
         if(var2 == 14) {
            var17 = client.field302[var3];
            if(null != var17) {
               client.field346 = var6;
               client.field398 = var7;
               client.field394 = 2;
               client.field511 = 0;
               client.field482 = var0;
               client.field522 = var1;
               client.field333.method2773(142);
               client.field333.method2585(class42.field1016);
               client.field333.method2539(class110.field1956);
               client.field333.method2586(class101.field1761);
               client.field333.method2586(var3);
               client.field333.method2549(class137.field2114[82]?1:0);
            }
         }

         if(var2 == 23) {
            class129.field2056.method2129(class14.field212, var0, var1);
         }

         if(var2 == 1004) {
            client.field346 = var6;
            client.field398 = var7;
            client.field394 = 2;
            client.field511 = 0;
            client.field333.method2773(133);
            client.field333.method2584(var3);
         }

         if(var2 == 47) {
            var17 = client.field302[var3];
            if(var17 != null) {
               client.field346 = var6;
               client.field398 = var7;
               client.field394 = 2;
               client.field511 = 0;
               client.field482 = var0;
               client.field522 = var1;
               client.field333.method2773(221);
               client.field333.method2549(class137.field2114[82]?1:0);
               client.field333.method2586(var3);
            }
         }

         if(var2 == 10) {
            var8 = client.field328[var3];
            if(var8 != null) {
               client.field346 = var6;
               client.field398 = var7;
               client.field394 = 2;
               client.field511 = 0;
               client.field482 = var0;
               client.field522 = var1;
               client.field333.method2773(226);
               client.field333.method2584(var3);
               client.field333.method2654(class137.field2114[82]?1:0);
            }
         }

         if(var2 == 49) {
            var17 = client.field302[var3];
            if(var17 != null) {
               client.field346 = var6;
               client.field398 = var7;
               client.field394 = 2;
               client.field511 = 0;
               client.field482 = var0;
               client.field522 = var1;
               client.field333.method2773(91);
               client.field333.method2586(var3);
               client.field333.method2577(class137.field2114[82]?1:0);
            }
         }

         if(var2 == 11) {
            var8 = client.field328[var3];
            if(null != var8) {
               client.field346 = var6;
               client.field398 = var7;
               client.field394 = 2;
               client.field511 = 0;
               client.field482 = var0;
               client.field522 = var1;
               client.field333.method2773(155);
               client.field333.method2577(class137.field2114[82]?1:0);
               client.field333.method2540(var3);
            }
         }

         if(var2 == 21) {
            client.field346 = var6;
            client.field398 = var7;
            client.field394 = 2;
            client.field511 = 0;
            client.field482 = var0;
            client.field522 = var1;
            client.field333.method2773(140);
            client.field333.method2586(class20.field576 + var1);
            client.field333.method2584(var3);
            client.field333.method2585(var0 + class172.field2734);
            client.field333.method2654(class137.field2114[82]?1:0);
         }

         if(var2 == 48) {
            var17 = client.field302[var3];
            if(null != var17) {
               client.field346 = var6;
               client.field398 = var7;
               client.field394 = 2;
               client.field511 = 0;
               client.field482 = var0;
               client.field522 = var1;
               client.field333.method2773(233);
               client.field333.method2585(var3);
               client.field333.method2549(class137.field2114[82]?1:0);
            }
         }

         if(var2 == 31) {
            client.field333.method2773(196);
            client.field333.method2595(var1);
            client.field333.method2594(class110.field1956);
            client.field333.method2540(class101.field1761);
            client.field333.method2540(var3);
            client.field333.method2586(class42.field1016);
            client.field333.method2585(var0);
            client.field401 = 0;
            class59.field1225 = class153.method3177(var1);
            client.field402 = var0;
         }

         if(var2 == 57 || var2 == 1007) {
            var19 = class172.method3425(var1, var0);
            if(var19 != null) {
               class96.method2260(var3, var1, var0, var19.field2764, var5);
            }
         }

         int var9;
         if(var2 == 28) {
            client.field333.method2773(141);
            client.field333.method2539(var1);
            var19 = class153.method3177(var1);
            if(var19.field2866 != null && var19.field2866[0][0] == 5) {
               var9 = var19.field2866[0][1];
               class176.field2905[var9] = 1 - class176.field2905[var9];
               class21.method615(var9);
            }
         }

         if(var2 == 38) {
            class12.method165();
            var19 = class153.method3177(var1);
            client.field353 = 1;
            class42.field1016 = var0;
            class110.field1956 = var1;
            class101.field1761 = var3;
            class39.method818(var19);
            client.field441 = class164.method3251(16748608) + class141.method3001(var3).field1128 + class164.method3251(16777215);
            if(client.field441 == null) {
               client.field441 = "null";
            }

         } else {
            if(var2 == 3) {
               client.field346 = var6;
               client.field398 = var7;
               client.field394 = 2;
               client.field511 = 0;
               client.field482 = var0;
               client.field522 = var1;
               client.field333.method2773(52);
               client.field333.method2540(class172.field2734 + var0);
               client.field333.method2540(var3 >> 14 & 32767);
               client.field333.method2549(class137.field2114[82]?1:0);
               client.field333.method2540(class20.field576 + var1);
            }

            if(var2 == 41) {
               client.field333.method2773(139);
               client.field333.method2585(var0);
               client.field333.method2540(var3);
               client.field333.method2594(var1);
               client.field401 = 0;
               class59.field1225 = class153.method3177(var1);
               client.field402 = var0;
            }

            if(var2 == 15) {
               var17 = client.field302[var3];
               if(var17 != null) {
                  client.field346 = var6;
                  client.field398 = var7;
                  client.field394 = 2;
                  client.field511 = 0;
                  client.field482 = var0;
                  client.field522 = var1;
                  client.field333.method2773(248);
                  client.field333.method2540(var3);
                  client.field333.method2549(class137.field2114[82]?1:0);
                  client.field333.method2540(client.field443);
                  client.field333.method2539(class17.field253);
               }
            }

            if(var2 == 36) {
               client.field333.method2773(157);
               client.field333.method2595(var1);
               client.field333.method2586(var3);
               client.field333.method2585(var0);
               client.field401 = 0;
               class59.field1225 = class153.method3177(var1);
               client.field402 = var0;
            }

            if(var2 == 1005) {
               var19 = class153.method3177(var1);
               if(null != var19 && var19.field2750[var0] >= 100000) {
                  class52.method1147(27, "", var19.field2750[var0] + " x " + class141.method3001(var3).field1128);
               } else {
                  client.field333.method2773(133);
                  client.field333.method2584(var3);
               }

               client.field401 = 0;
               class59.field1225 = class153.method3177(var1);
               client.field402 = var0;
            }

            if(var2 == 1002) {
               client.field346 = var6;
               client.field398 = var7;
               client.field394 = 2;
               client.field511 = 0;
               client.field333.method2773(11);
               client.field333.method2584(var3 >> 14 & 32767);
            }

            if(var2 == 12) {
               var8 = client.field328[var3];
               if(var8 != null) {
                  client.field346 = var6;
                  client.field398 = var7;
                  client.field394 = 2;
                  client.field511 = 0;
                  client.field482 = var0;
                  client.field522 = var1;
                  client.field333.method2773(163);
                  client.field333.method2585(var3);
                  client.field333.method2654(class137.field2114[82]?1:0);
               }
            }

            if(var2 == 2) {
               client.field346 = var6;
               client.field398 = var7;
               client.field394 = 2;
               client.field511 = 0;
               client.field482 = var0;
               client.field522 = var1;
               client.field333.method2773(33);
               client.field333.method2595(class17.field253);
               client.field333.method2586(var3 >> 14 & 32767);
               client.field333.method2585(class20.field576 + var1);
               client.field333.method2540(class172.field2734 + var0);
               client.field333.method2578(class137.field2114[82]?1:0);
               client.field333.method2584(client.field443);
            }

            if(var2 == 5) {
               client.field346 = var6;
               client.field398 = var7;
               client.field394 = 2;
               client.field511 = 0;
               client.field482 = var0;
               client.field522 = var1;
               client.field333.method2773(186);
               client.field333.method2584(var3 >> 14 & 32767);
               client.field333.method2577(class137.field2114[82]?1:0);
               client.field333.method2586(var0 + class172.field2734);
               client.field333.method2540(var1 + class20.field576);
            }

            if(var2 == 24) {
               var19 = class153.method3177(var1);
               boolean var18 = true;
               if(var19.field2758 > 0) {
                  var18 = class11.method150(var19);
               }

               if(var18) {
                  client.field333.method2773(141);
                  client.field333.method2539(var1);
               }
            }

            if(var2 == 34) {
               client.field333.method2773(224);
               client.field333.method2595(var1);
               client.field333.method2586(var0);
               client.field333.method2586(var3);
               client.field401 = 0;
               class59.field1225 = class153.method3177(var1);
               client.field402 = var0;
            }

            if(var2 == 1001) {
               client.field346 = var6;
               client.field398 = var7;
               client.field394 = 2;
               client.field511 = 0;
               client.field482 = var0;
               client.field522 = var1;
               client.field333.method2773(85);
               client.field333.method2577(class137.field2114[82]?1:0);
               client.field333.method2540(var1 + class20.field576);
               client.field333.method2585(var0 + class172.field2734);
               client.field333.method2586(var3 >> 14 & 32767);
            }

            if(var2 == 29) {
               client.field333.method2773(141);
               client.field333.method2539(var1);
               var19 = class153.method3177(var1);
               if(var19.field2866 != null && var19.field2866[0][0] == 5) {
                  var9 = var19.field2866[0][1];
                  if(var19.field2868[0] != class176.field2905[var9]) {
                     class176.field2905[var9] = var19.field2868[0];
                     class21.method615(var9);
                  }
               }
            }

            if(var2 == 18) {
               client.field346 = var6;
               client.field398 = var7;
               client.field394 = 2;
               client.field511 = 0;
               client.field482 = var0;
               client.field522 = var1;
               client.field333.method2773(209);
               client.field333.method2585(class20.field576 + var1);
               client.field333.method2584(class172.field2734 + var0);
               client.field333.method2585(var3);
               client.field333.method2577(class137.field2114[82]?1:0);
            }

            if(var2 == 39) {
               client.field333.method2773(230);
               client.field333.method2594(var1);
               client.field333.method2585(var0);
               client.field333.method2584(var3);
               client.field401 = 0;
               class59.field1225 = class153.method3177(var1);
               client.field402 = var0;
            }

            if(var2 == 6) {
               client.field346 = var6;
               client.field398 = var7;
               client.field394 = 2;
               client.field511 = 0;
               client.field482 = var0;
               client.field522 = var1;
               client.field333.method2773(37);
               client.field333.method2586(class172.field2734 + var0);
               client.field333.method2578(class137.field2114[82]?1:0);
               client.field333.method2586(var3 >> 14 & 32767);
               client.field333.method2584(var1 + class20.field576);
            }

            if(var2 == 26) {
               class98.method2267();
            }

            if(var2 == 1003) {
               client.field346 = var6;
               client.field398 = var7;
               client.field394 = 2;
               client.field511 = 0;
               var8 = client.field328[var3];
               if(var8 != null) {
                  class39 var16 = var8.field782;
                  if(var16.field910 != null) {
                     var16 = var16.method813();
                  }

                  if(var16 != null) {
                     client.field333.method2773(249);
                     client.field333.method2586(var16.field899);
                  }
               }
            }

            if(var2 == 42) {
               client.field333.method2773(112);
               client.field333.method2586(var0);
               client.field333.method2584(var3);
               client.field333.method2595(var1);
               client.field401 = 0;
               class59.field1225 = class153.method3177(var1);
               client.field402 = var0;
            }

            if(var2 == 33) {
               client.field333.method2773(125);
               client.field333.method2585(var3);
               client.field333.method2539(var1);
               client.field333.method2584(var0);
               client.field401 = 0;
               class59.field1225 = class153.method3177(var1);
               client.field402 = var0;
            }

            if(var2 == 1) {
               client.field346 = var6;
               client.field398 = var7;
               client.field394 = 2;
               client.field511 = 0;
               client.field482 = var0;
               client.field522 = var1;
               client.field333.method2773(250);
               client.field333.method2540(class20.field576 + var1);
               client.field333.method2585(class42.field1016);
               client.field333.method2585(class101.field1761);
               client.field333.method2585(var3 >> 14 & 32767);
               client.field333.method2584(var0 + class172.field2734);
               client.field333.method2594(class110.field1956);
               client.field333.method2577(class137.field2114[82]?1:0);
            }

            if(var2 == 44) {
               var17 = client.field302[var3];
               if(null != var17) {
                  client.field346 = var6;
                  client.field398 = var7;
                  client.field394 = 2;
                  client.field511 = 0;
                  client.field482 = var0;
                  client.field522 = var1;
                  client.field333.method2773(241);
                  client.field333.method2549(class137.field2114[82]?1:0);
                  client.field333.method2586(var3);
               }
            }

            if(var2 == 45) {
               var17 = client.field302[var3];
               if(null != var17) {
                  client.field346 = var6;
                  client.field398 = var7;
                  client.field394 = 2;
                  client.field511 = 0;
                  client.field482 = var0;
                  client.field522 = var1;
                  client.field333.method2773(143);
                  client.field333.method2585(var3);
                  client.field333.method2578(class137.field2114[82]?1:0);
               }
            }

            if(client.field353 != 0) {
               client.field353 = 0;
               class39.method818(class153.method3177(class110.field1956));
            }

            if(client.field442) {
               class12.method165();
            }

            if(null != class59.field1225 && client.field401 == 0) {
               class39.method818(class59.field1225);
            }

         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1669151822"
   )
   public static int method766(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "767210213"
   )
   static final void method767(int var0, int var1) {
      if(class135.method2897(var0)) {
         class32.method740(class173.field2770[var0], var1);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Lclass42;",
      garbageValue = "-28691506"
   )
   @Export("getAnimation")
   public static class42 method768(int var0) {
      class42 var1 = (class42)class42.field1013.method3797((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class42.field1011.method3286(12, var0);
         var1 = new class42();
         if(var2 != null) {
            var1.method929(new class119(var2));
         }

         var1.method901();
         class42.field1013.method3788(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "8"
   )
   public static int method769(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }
}
