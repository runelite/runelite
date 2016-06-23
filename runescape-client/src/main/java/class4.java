import java.io.IOException;
import java.math.BigInteger;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class4 {
   @ObfuscatedName("f")
   static final BigInteger field74 = new BigInteger("10001", 16);
   @ObfuscatedName("u")
   static final BigInteger field76 = new BigInteger("a145f32cc0061a676331cfa6dc1dc8dc300a3a08b42ed2dca3a70104aefc6fb3c9a84caf6c8e2dea05d8c06aa2ea1e8661aedc32fc071021e85711c7730a6d06b80dc1dd7f6143f927bfa204e8965820d2a736dc1fb5fa8092061636b247b34223f707ee55a25bb247cc3312a5724268f3997318e28c009159c5838077b54849", 16);

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-22"
   )
   static final void method48(String var0) {
      if(null != var0) {
         String var1 = class138.method2969(var0, client.field294);
         if(var1 != null) {
            for(int var2 = 0; var2 < client.field555; ++var2) {
               class17 var3 = client.field557[var2];
               String var4 = var3.field254;
               String var5 = class138.method2969(var4, client.field294);
               if(class26.method674(var0, var1, var4, var5)) {
                  --client.field555;

                  for(int var6 = var2; var6 < client.field555; ++var6) {
                     client.field557[var6] = client.field557[var6 + 1];
                  }

                  client.field480 = client.field563;
                  client.field333.method2773(53);
                  client.field333.method2654(class23.method629(var0));
                  client.field333.method2545(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lclass25;",
      garbageValue = "-2146196286"
   )
   static class25 method49() {
      class25.field637 = 0;
      class25 var0;
      if(class25.field637 < class25.field636) {
         var0 = class25.field635[++class25.field637 - 1];
      } else {
         var0 = null;
      }

      return var0;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1609"
   )
   static final void method50() {
      for(class6 var0 = (class6)client.field549.method3852(); null != var0; var0 = (class6)client.field549.method3857()) {
         if(var0.field108 == class14.field212 && client.field301 <= var0.field114) {
            if(client.field301 >= var0.field113) {
               if(var0.field117 > 0) {
                  class34 var1 = client.field328[var0.field117 - 1];
                  if(var1 != null && var1.field837 >= 0 && var1.field837 < 13312 && var1.field880 >= 0 && var1.field880 < 13312) {
                     var0.method96(var1.field837, var1.field880, class74.method1659(var1.field837, var1.field880, var0.field108) - var0.field112, client.field301);
                  }
               }

               if(var0.field117 < 0) {
                  int var2 = -var0.field117 - 1;
                  class2 var3;
                  if(client.field411 == var2) {
                     var3 = class15.field225;
                  } else {
                     var3 = client.field302[var2];
                  }

                  if(var3 != null && var3.field837 >= 0 && var3.field837 < 13312 && var3.field880 >= 0 && var3.field880 < 13312) {
                     var0.method96(var3.field837, var3.field880, class74.method1659(var3.field837, var3.field880, var0.field108) - var0.field112, client.field301);
                  }
               }

               var0.method104(client.field366);
               class129.field2056.method1986(class14.field212, (int)var0.field119, (int)var0.field120, (int)var0.field121, 60, var0, var0.field127, -1, false);
            }
         } else {
            var0.method3946();
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-3"
   )
   static final void method51() {
      try {
         if(client.field378 == 0) {
            if(null != class172.field2742) {
               class172.field2742.method3013();
               class172.field2742 = null;
            }

            class165.field2660 = null;
            client.field361 = false;
            client.field342 = 0;
            client.field378 = 1;
         }

         if(client.field378 == 1) {
            if(null == class165.field2660) {
               class165.field2660 = class7.field136.method2902(class3.field66, class15.field224);
            }

            if(class165.field2660.field2214 == 2) {
               throw new IOException();
            }

            if(class165.field2660.field2214 == 1) {
               class172.field2742 = new class143((Socket)class165.field2660.field2216, class7.field136);
               class165.field2660 = null;
               client.field378 = 2;
            }
         }

         if(client.field378 == 2) {
            client.field333.field1998 = 0;
            client.field333.method2654(14);
            class172.field2742.method3018(client.field333.field2000, 0, 1);
            client.field335.field1998 = 0;
            client.field378 = 3;
         }

         int var0;
         if(client.field378 == 3) {
            if(null != class39.field923) {
               class39.field923.method1237();
            }

            if(class6.field128 != null) {
               class6.field128.method1237();
            }

            var0 = class172.field2742.method3015();
            if(null != class39.field923) {
               class39.field923.method1237();
            }

            if(null != class6.field128) {
               class6.field128.method1237();
            }

            if(var0 != 0) {
               class44.method983(var0);
               return;
            }

            client.field335.field1998 = 0;
            client.field378 = 5;
         }

         int var1;
         int var2;
         if(client.field378 == 5) {
            int[] var7 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            client.field333.field1998 = 0;
            client.field333.method2654(1);
            client.field333.method2654(class31.field727.vmethod3194());
            client.field333.method2539(var7[0]);
            client.field333.method2539(var7[1]);
            client.field333.method2539(var7[2]);
            client.field333.method2539(var7[3]);
            switch(class31.field727.field2596) {
            case 0:
            case 3:
               client.field333.method2541(class107.field1880);
               client.field333.field1998 += 5;
               break;
            case 1:
               client.field333.field1998 += 8;
               break;
            case 2:
               client.field333.method2539(((Integer)class20.field580.field146.get(Integer.valueOf(class159.method3197(class31.field729)))).intValue());
               client.field333.field1998 += 4;
            }

            client.field333.method2545(class31.field736);
            client.field333.method2574(field74, field76);
            client.field451.field1998 = 0;
            if(client.field299 == 40) {
               client.field451.method2654(18);
            } else {
               client.field451.method2654(16);
            }

            client.field451.method2540(0);
            var1 = client.field451.field1998;
            client.field451.method2539(117);
            client.field451.method2591(client.field333.field2000, 0, client.field333.field1998);
            var2 = client.field451.field1998;
            client.field451.method2545(class31.field729);
            client.field451.method2654((client.field501?1:0) << 1 | (client.field296?1:0));
            client.field451.method2540(class30.field708);
            client.field451.method2540(class153.field2274);
            class122 var3 = client.field451;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class149.field2241.method4167(0L);
               class149.field2241.method4169(var4);

               for(var5 = 0; var5 < 24 && var4[var5] == 0; ++var5) {
                  ;
               }

               if(var5 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var12) {
               for(int var6 = 0; var6 < 24; ++var6) {
                  var4[var6] = -1;
               }
            }

            var3.method2591(var4, 0, 24);
            client.field451.method2545(client.field413);
            client.field451.method2539(class14.field220);
            class119 var17 = new class119(class46.field1074.method3200());
            class46.field1074.method3203(var17);
            client.field451.method2591(var17.field2000, 0, var17.field2000.length);
            client.field451.method2654(class43.field1036);
            client.field451.method2539(class131.field2068.field2678);
            client.field451.method2539(class130.field2062.field2678);
            client.field451.method2539(class11.field177.field2678);
            client.field451.method2539(class8.field143.field2678);
            client.field451.method2539(class136.field2101.field2678);
            client.field451.method2539(class89.field1563.field2678);
            client.field451.method2539(class17.field261.field2678);
            client.field451.method2539(class113.field1971.field2678);
            client.field451.method2539(class108.field1909.field2678);
            client.field451.method2539(class38.field889.field2678);
            client.field451.method2539(class29.field702.field2678);
            client.field451.method2539(class152.field2257.field2678);
            client.field451.method2539(class17.field255.field2678);
            client.field451.method2539(class186.field3004.field2678);
            client.field451.method2539(class144.field2208.field2678);
            client.field451.method2539(class31.field746.field2678);
            client.field451.method2543(var7, var2, client.field451.field1998);
            client.field451.method2550(client.field451.field1998 - var1);
            class172.field2742.method3018(client.field451.field2000, 0, client.field451.field1998);
            client.field333.method2772(var7);

            for(var5 = 0; var5 < 4; ++var5) {
               var7[var5] += 50;
            }

            client.field335.method2772(var7);
            client.field378 = 6;
         }

         if(client.field378 == 6 && class172.field2742.method3012() > 0) {
            var0 = class172.field2742.method3015();
            if(var0 == 21 && client.field299 == 20) {
               client.field378 = 7;
            } else if(var0 == 2) {
               client.field378 = 9;
            } else if(var0 == 15 && client.field299 == 40) {
               client.field419 = -1;
               client.field378 = 13;
            } else if(var0 == 23 && client.field326 < 1) {
               ++client.field326;
               client.field378 = 0;
            } else {
               if(var0 != 29) {
                  class44.method983(var0);
                  return;
               }

               client.field378 = 11;
            }
         }

         if(client.field378 == 7 && class172.field2742.method3012() > 0) {
            client.field327 = (class172.field2742.method3015() + 3) * 60;
            client.field378 = 8;
         }

         if(client.field378 == 8) {
            client.field342 = 0;
            class111.method2477("You have only just left another world.", "Your profile will be transferred in:", client.field327 / 60 + " seconds.");
            if(--client.field327 <= 0) {
               client.field378 = 0;
            }

         } else {
            if(client.field378 == 9 && class172.field2742.method3012() >= 13) {
               boolean var14 = class172.field2742.method3015() == 1;
               class172.field2742.method3036(client.field335.field2000, 0, 4);
               client.field335.field1998 = 0;
               boolean var15 = false;
               if(var14) {
                  var1 = client.field335.method2787() << 24;
                  var1 |= client.field335.method2787() << 16;
                  var1 |= client.field335.method2787() << 8;
                  var1 |= client.field335.method2787();
                  var2 = class159.method3197(class31.field729);
                  if(class20.field580.field146.size() >= 10 && !class20.field580.field146.containsKey(Integer.valueOf(var2))) {
                     Iterator var16 = class20.field580.field146.entrySet().iterator();
                     var16.next();
                     var16.remove();
                  }

                  class20.field580.field146.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class21.method613();
               }

               client.field454 = class172.field2742.method3015();
               client.field456 = class172.field2742.method3015() == 1;
               client.field411 = class172.field2742.method3015();
               client.field411 <<= 8;
               client.field411 += class172.field2742.method3015();
               client.field412 = class172.field2742.method3015();
               class172.field2742.method3036(client.field335.field2000, 0, 1);
               client.field335.field1998 = 0;
               client.field325 = client.field335.method2787();
               class172.field2742.method3036(client.field335.field2000, 0, 2);
               client.field335.field1998 = 0;
               client.field419 = client.field335.method2556();

               try {
                  class132.method2865(client.field530, "zap");
               } catch (Throwable var11) {
                  ;
               }

               client.field378 = 10;
            }

            if(client.field378 == 10) {
               if(class172.field2742.method3012() >= client.field419) {
                  client.field335.field1998 = 0;
                  class172.field2742.method3036(client.field335.field2000, 0, client.field419);
                  class106.method2425();
                  class7.method112(client.field335);
                  class170.field2709 = -1;
                  class32.method745(false);
                  client.field325 = -1;
               }

            } else {
               if(client.field378 == 11 && class172.field2742.method3012() >= 2) {
                  client.field335.field1998 = 0;
                  class172.field2742.method3036(client.field335.field2000, 0, 2);
                  client.field335.field1998 = 0;
                  class104.field1796 = client.field335.method2556();
                  client.field378 = 12;
               }

               if(client.field378 == 12 && class172.field2742.method3012() >= class104.field1796) {
                  client.field335.field1998 = 0;
                  class172.field2742.method3036(client.field335.field2000, 0, class104.field1796);
                  client.field335.field1998 = 0;
                  String var18 = client.field335.method2668();
                  String var10 = client.field335.method2668();
                  String var9 = client.field335.method2668();
                  class111.method2477(var18, var10, var9);
                  class11.method156(10);
               }

               if(client.field378 != 13) {
                  ++client.field342;
                  if(client.field342 > 2000) {
                     if(client.field326 < 1) {
                        if(class228.field3230 == class15.field224) {
                           class15.field224 = class18.field262;
                        } else {
                           class15.field224 = class228.field3230;
                        }

                        ++client.field326;
                        client.field378 = 0;
                     } else {
                        class44.method983(-3);
                     }
                  }
               } else {
                  if(client.field419 == -1) {
                     if(class172.field2742.method3012() < 2) {
                        return;
                     }

                     class172.field2742.method3036(client.field335.field2000, 0, 2);
                     client.field335.field1998 = 0;
                     client.field419 = client.field335.method2556();
                  }

                  if(class172.field2742.method3012() >= client.field419) {
                     class172.field2742.method3036(client.field335.field2000, 0, client.field419);
                     client.field335.field1998 = 0;
                     var0 = client.field419;
                     client.field333.field1998 = 0;
                     client.field335.field1998 = 0;
                     client.field325 = -1;
                     client.field304 = 1;
                     client.field483 = -1;
                     client.field417 = -1;
                     client.field419 = 0;
                     client.field338 = 0;
                     client.field309 = 0;
                     client.field429 = 0;
                     client.field310 = false;
                     client.field523 = 0;
                     client.field482 = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        client.field302[var1] = null;
                     }

                     class15.field225 = null;

                     for(var1 = 0; var1 < client.field328.length; ++var1) {
                        class34 var19 = client.field328[var1];
                        if(var19 != null) {
                           var19.field846 = -1;
                           var19.field847 = false;
                        }
                     }

                     class15.field229 = new class196(32);
                     class11.method156(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        client.field516[var1] = true;
                     }

                     client.field333.method2773(81);
                     class122 var20 = client.field333;
                     var2 = client.field501?2:1;
                     var20.method2654(var2);
                     client.field333.method2540(class30.field708);
                     client.field333.method2540(class153.field2274);
                     class7.method112(client.field335);
                     if(client.field335.field1998 != var0) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var13) {
         if(client.field326 < 1) {
            if(class228.field3230 == class15.field224) {
               class15.field224 = class18.field262;
            } else {
               class15.field224 = class228.field3230;
            }

            ++client.field326;
            client.field378 = 0;
         } else {
            class44.method983(-2);
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)[Lclass78;",
      garbageValue = "-1106817595"
   )
   static class78[] method52() {
      class78[] var0 = new class78[class76.field1399];

      for(int var1 = 0; var1 < class76.field1399; ++var1) {
         class78 var2 = var0[var1] = new class78();
         var2.field1412 = class76.field1396;
         var2.field1415 = class76.field1398;
         var2.field1410 = class76.field1397[var1];
         var2.field1411 = class52.field1178[var1];
         var2.field1408 = class28.field690[var1];
         var2.field1414 = class31.field744[var1];
         int var3 = var2.field1414 * var2.field1408;
         byte[] var4 = class76.field1400[var1];
         var2.field1409 = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.field1409[var5] = class7.field135[var4[var5] & 255];
         }
      }

      class33.method749();
      return var0;
   }
}
