import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class163 extends Node {
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -309177579
   )
   int field2643;
   @ObfuscatedName("ap")
   String field2644;
   @ObfuscatedName("m")
   boolean field2646;
   @ObfuscatedName("am")
   boolean field2647;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 436214701
   )
   int field2651;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1895225161
   )
   int field2652;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 588832183
   )
   int field2653;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1569304859
   )
   int field2654;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1353639967
   )
   int field2655;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 508066507
   )
   int field2656;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -344773569
   )
   int field2657;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1939549189
   )
   int field2658;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1276335749
   )
   int field2659;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1673784719
   )
   int field2660;
   @ObfuscatedName("ak")
   String field2661;
   @ObfuscatedName("ag")
   String field2662;
   @ObfuscatedName("az")
   String field2663;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1791522545
   )
   int field2664;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -427286041
   )
   int field2665;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -713056167
   )
   int field2667;
   @ObfuscatedName("ad")
   String field2668;
   @ObfuscatedName("an")
   String field2669;
   @ObfuscatedName("ab")
   int[] field2670 = new int[3];
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1390741341
   )
   int field2671;

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class163(boolean var1) {
      if(class22.field590.startsWith("win")) {
         this.field2667 = 1;
      } else if(class22.field590.startsWith("mac")) {
         this.field2667 = 2;
      } else if(class22.field590.startsWith("linux")) {
         this.field2667 = 3;
      } else {
         this.field2667 = 4;
      }

      String var2;
      try {
         var2 = System.getProperty("os.arch").toLowerCase();
      } catch (Exception var13) {
         var2 = "";
      }

      String var3;
      try {
         var3 = System.getProperty("os.version").toLowerCase();
      } catch (Exception var12) {
         var3 = "";
      }

      String var4 = "Unknown";
      String var5 = "1.1";

      try {
         var4 = System.getProperty("java.vendor");
         var5 = System.getProperty("java.version");
      } catch (Exception var11) {
         ;
      }

      if(!var2.startsWith("amd64") && !var2.startsWith("x86_64")) {
         this.field2646 = false;
      } else {
         this.field2646 = true;
      }

      if(this.field2667 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field2655 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field2655 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field2655 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field2655 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field2655 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field2655 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field2655 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field2655 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field2655 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field2655 = 10;
         }
      } else if(this.field2667 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field2655 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field2655 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field2655 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field2655 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field2655 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field2655 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field2655 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field2651 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field2651 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field2651 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field2651 = 5;
      } else {
         this.field2651 = 4;
      }

      int var9 = 2;
      int var7 = 0;

      char var8;
      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = 10 * var7 + (var8 - 48);
            ++var9;
         }
      } catch (Exception var16) {
         ;
      }

      this.field2652 = var7;
      var9 = var5.indexOf(46, 2) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + var7 * 10;
            ++var9;
         }
      } catch (Exception var15) {
         ;
      }

      this.field2653 = var7;
      var9 = var5.indexOf(95, 4) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = 10 * var7 + (var8 - 48);
            ++var9;
         }
      } catch (Exception var14) {
         ;
      }

      this.field2654 = var7;
      this.field2647 = false;
      this.field2656 = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
      if(this.field2652 > 3) {
         this.field2657 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field2657 = 0;
      }

      this.field2658 = 0;
      if(this.field2644 == null) {
         this.field2644 = "";
      }

      if(null == this.field2661) {
         this.field2661 = "";
      }

      if(null == this.field2662) {
         this.field2662 = "";
      }

      if(this.field2663 == null) {
         this.field2663 = "";
      }

      if(null == this.field2668) {
         this.field2668 = "";
      }

      if(this.field2669 == null) {
         this.field2669 = "";
      }

      this.method3199();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "70"
   )
   void method3199() {
      if(this.field2644.length() > 40) {
         this.field2644 = this.field2644.substring(0, 40);
      }

      if(this.field2661.length() > 40) {
         this.field2661 = this.field2661.substring(0, 40);
      }

      if(this.field2662.length() > 10) {
         this.field2662 = this.field2662.substring(0, 10);
      }

      if(this.field2663.length() > 10) {
         this.field2663 = this.field2663.substring(0, 10);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "25"
   )
   public void method3200(Buffer var1) {
      var1.method2518(6);
      var1.method2518(this.field2667);
      var1.method2518(this.field2646?1:0);
      var1.method2518(this.field2655);
      var1.method2518(this.field2651);
      var1.method2518(this.field2652);
      var1.method2518(this.field2653);
      var1.method2518(this.field2654);
      var1.method2518(this.field2647?1:0);
      var1.method2519(this.field2656);
      var1.method2518(this.field2657);
      var1.method2520(this.field2658);
      var1.method2519(this.field2659);
      var1.method2525(this.field2644);
      var1.method2525(this.field2661);
      var1.method2525(this.field2662);
      var1.method2525(this.field2663);
      var1.method2518(this.field2665);
      var1.method2519(this.field2643);
      var1.method2525(this.field2668);
      var1.method2525(this.field2669);
      var1.method2518(this.field2664);
      var1.method2518(this.field2660);

      for(int var2 = 0; var2 < this.field2670.length; ++var2) {
         var1.method2521(this.field2670[var2]);
      }

      var1.method2521(this.field2671);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2029319519"
   )
   public int method3201() {
      byte var1 = 38;
      int var2 = var1 + class28.method653(this.field2644);
      var2 += class28.method653(this.field2661);
      var2 += class28.method653(this.field2662);
      var2 += class28.method653(this.field2663);
      var2 += class28.method653(this.field2668);
      var2 += class28.method653(this.field2669);
      return var2;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "488882820"
   )
   static final void method3208(int var0) {
      int[] var1 = DecorativeObject.field1660.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = 24628 + 2048 * (103 - var3);

         for(var5 = 1; var5 < 103; ++var5) {
            if((class5.tileSettings[var0][var5][var3] & 24) == 0) {
               class9.region.method2013(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class5.tileSettings[1 + var0][var5][var3] & 8) != 0) {
               class9.region.method2013(var1, var4, 512, 1 + var0, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      DecorativeObject.field1660.method1814();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class5.tileSettings[var0][var6][var5] & 24) == 0) {
               DecorativeObject.method2203(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class5.tileSettings[1 + var0][var6][var5] & 8) != 0) {
               DecorativeObject.method2203(1 + var0, var6, var5, var3, var4);
            }
         }
      }

      Client.field509 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class9.region.method2026(XItemContainer.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class8.getObjectDefinition(var7).field942;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var13 = Client.collisionMaps[XItemContainer.plane].flags;

                     for(int var14 = 0; var14 < 10; ++var14) {
                        int var15 = (int)(Math.random() * 4.0D);
                        if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var15 == 1 && var9 < 103 && var9 < 3 + var5 && (var13[1 + var9][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var15 == 3 && var10 < 103 && var10 < 3 + var6 && (var13[var9][var10 + 1] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  Client.field512[Client.field509] = class14.field205[var8];
                  Client.field534[Client.field509] = var9;
                  Client.field511[Client.field509] = var10;
                  ++Client.field509;
               }
            }
         }
      }

      XClanMember.bufferProvider.method1730();
   }
}
