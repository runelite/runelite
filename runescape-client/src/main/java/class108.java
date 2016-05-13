import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("CollisionData")
public class class108 {
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1741280729
   )
   @Export("height")
   int field1903;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1504866459
   )
   @Export("x")
   public int field1907 = 0;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1210124951
   )
   @Export("y")
   public int field1908 = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1714619317
   )
   @Export("width")
   int field1909;
   @ObfuscatedName("ax")
   @Export("flags")
   public int[][] field1911;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-473634394"
   )
   public void method2374() {
      for(int var1 = 0; var1 < this.field1909; ++var1) {
         for(int var2 = 0; var2 < this.field1903; ++var2) {
            if(var1 != 0 && var2 != 0 && var1 < this.field1909 - 5 && var2 < this.field1903 - 5) {
               this.field1911[var1][var2] = 16777216;
            } else {
               this.field1911[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "150936097"
   )
   public void method2376(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1907;
      var2 -= this.field1908;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2380(var1, var2, 128);
            this.method2380(var1 - 1, var2, 8);
         }

         if(1 == var4) {
            this.method2380(var1, var2, 2);
            this.method2380(var1, var2 + 1, 32);
         }

         if(2 == var4) {
            this.method2380(var1, var2, 8);
            this.method2380(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2380(var1, var2, 32);
            this.method2380(var1, var2 - 1, 2);
         }
      }

      if(1 == var3 || var3 == 3) {
         if(var4 == 0) {
            this.method2380(var1, var2, 1);
            this.method2380(var1 - 1, var2 + 1, 16);
         }

         if(1 == var4) {
            this.method2380(var1, var2, 4);
            this.method2380(1 + var1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2380(var1, var2, 16);
            this.method2380(1 + var1, var2 - 1, 1);
         }

         if(3 == var4) {
            this.method2380(var1, var2, 64);
            this.method2380(var1 - 1, var2 - 1, 4);
         }
      }

      if(2 == var3) {
         if(0 == var4) {
            this.method2380(var1, var2, 130);
            this.method2380(var1 - 1, var2, 8);
            this.method2380(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2380(var1, var2, 10);
            this.method2380(var1, var2 + 1, 32);
            this.method2380(1 + var1, var2, 128);
         }

         if(2 == var4) {
            this.method2380(var1, var2, 40);
            this.method2380(var1 + 1, var2, 128);
            this.method2380(var1, var2 - 1, 2);
         }

         if(3 == var4) {
            this.method2380(var1, var2, 160);
            this.method2380(var1, var2 - 1, 2);
            this.method2380(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(0 == var4) {
               this.method2380(var1, var2, 65536);
               this.method2380(var1 - 1, var2, 4096);
            }

            if(1 == var4) {
               this.method2380(var1, var2, 1024);
               this.method2380(var1, var2 + 1, 16384);
            }

            if(2 == var4) {
               this.method2380(var1, var2, 4096);
               this.method2380(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2380(var1, var2, 16384);
               this.method2380(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(0 == var4) {
               this.method2380(var1, var2, 512);
               this.method2380(var1 - 1, 1 + var2, 8192);
            }

            if(1 == var4) {
               this.method2380(var1, var2, 2048);
               this.method2380(1 + var1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2380(var1, var2, 8192);
               this.method2380(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2380(var1, var2, '耀');
               this.method2380(var1 - 1, var2 - 1, 2048);
            }
         }

         if(2 == var3) {
            if(var4 == 0) {
               this.method2380(var1, var2, 66560);
               this.method2380(var1 - 1, var2, 4096);
               this.method2380(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2380(var1, var2, 5120);
               this.method2380(var1, 1 + var2, 16384);
               this.method2380(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2380(var1, var2, 20480);
               this.method2380(1 + var1, var2, 65536);
               this.method2380(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2380(var1, var2, 81920);
               this.method2380(var1, var2 - 1, 1024);
               this.method2380(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "0"
   )
   public void method2377(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.field1907;
      var2 -= this.field1908;

      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         if(var7 >= 0 && var7 < this.field1909) {
            for(int var8 = var2; var8 < var4 + var2; ++var8) {
               if(var8 >= 0 && var8 < this.field1903) {
                  this.method2380(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "11"
   )
   public void method2378(int var1, int var2) {
      var1 -= this.field1907;
      var2 -= this.field1908;
      this.field1911[var1][var2] |= 2097152;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)V",
      garbageValue = "2"
   )
   public void method2379(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.field1907;
      var2 -= this.field1908;
      int var8;
      if(1 == var5 || 3 == var5) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var1 + var3; ++var8) {
         if(var8 >= 0 && var8 < this.field1909) {
            for(int var9 = var2; var9 < var4 + var2; ++var9) {
               if(var9 >= 0 && var9 < this.field1903) {
                  this.method2383(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "36"
   )
   void method2380(int var1, int var2, int var3) {
      this.field1911[var1][var2] |= var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "727566581"
   )
   public void method2381(int var1, int var2) {
      var1 -= this.field1907;
      var2 -= this.field1908;
      this.field1911[var1][var2] &= -262145;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[Lclass108;B)V",
      garbageValue = "0"
   )
   static final void method2382(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class108[] var8) {
      int var9;
      for(int var10 = 0; var10 < 8; ++var10) {
         for(var9 = 0; var9 < 8; ++var9) {
            if(var2 + var10 > 0 && var10 + var2 < 103 && var9 + var3 > 0 && var9 + var3 < 103) {
               var8[var1].field1911[var10 + var2][var3 + var9] &= -16777217;
            }
         }
      }

      class119 var13 = new class119(var0);

      for(var9 = 0; var9 < 4; ++var9) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var9 == var4 && var11 >= var5 && var11 < 8 + var5 && var12 >= var6 && var12 < var6 + 8) {
                  class43.method890(var13, var1, var2 + class115.method2443(var11 & 7, var12 & 7, var7), var3 + class45.method925(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  class43.method890(var13, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1081045464"
   )
   void method2383(int var1, int var2, int var3) {
      this.field1911[var1][var2] &= ~var3;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public class108(int var1, int var2) {
      this.field1909 = var1;
      this.field1903 = var2;
      this.field1911 = new int[this.field1909][this.field1903];
      this.method2374();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1885147894"
   )
   public void method2390(int var1, int var2) {
      var1 -= this.field1907;
      var2 -= this.field1908;
      this.field1911[var1][var2] |= 262144;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1950964870"
   )
   public void method2408(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1907;
      var2 -= this.field1908;
      if(0 == var3) {
         if(0 == var4) {
            this.method2383(var1, var2, 128);
            this.method2383(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2383(var1, var2, 2);
            this.method2383(var1, var2 + 1, 32);
         }

         if(var4 == 2) {
            this.method2383(var1, var2, 8);
            this.method2383(1 + var1, var2, 128);
         }

         if(3 == var4) {
            this.method2383(var1, var2, 32);
            this.method2383(var1, var2 - 1, 2);
         }
      }

      if(1 == var3 || 3 == var3) {
         if(0 == var4) {
            this.method2383(var1, var2, 1);
            this.method2383(var1 - 1, 1 + var2, 16);
         }

         if(1 == var4) {
            this.method2383(var1, var2, 4);
            this.method2383(var1 + 1, 1 + var2, 64);
         }

         if(2 == var4) {
            this.method2383(var1, var2, 16);
            this.method2383(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2383(var1, var2, 64);
            this.method2383(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(0 == var4) {
            this.method2383(var1, var2, 130);
            this.method2383(var1 - 1, var2, 8);
            this.method2383(var1, var2 + 1, 32);
         }

         if(1 == var4) {
            this.method2383(var1, var2, 10);
            this.method2383(var1, var2 + 1, 32);
            this.method2383(1 + var1, var2, 128);
         }

         if(2 == var4) {
            this.method2383(var1, var2, 40);
            this.method2383(1 + var1, var2, 128);
            this.method2383(var1, var2 - 1, 2);
         }

         if(3 == var4) {
            this.method2383(var1, var2, 160);
            this.method2383(var1, var2 - 1, 2);
            this.method2383(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(0 == var3) {
            if(var4 == 0) {
               this.method2383(var1, var2, 65536);
               this.method2383(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2383(var1, var2, 1024);
               this.method2383(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2383(var1, var2, 4096);
               this.method2383(1 + var1, var2, 65536);
            }

            if(3 == var4) {
               this.method2383(var1, var2, 16384);
               this.method2383(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(0 == var4) {
               this.method2383(var1, var2, 512);
               this.method2383(var1 - 1, 1 + var2, 8192);
            }

            if(1 == var4) {
               this.method2383(var1, var2, 2048);
               this.method2383(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2383(var1, var2, 8192);
               this.method2383(1 + var1, var2 - 1, 512);
            }

            if(3 == var4) {
               this.method2383(var1, var2, '耀');
               this.method2383(var1 - 1, var2 - 1, 2048);
            }
         }

         if(2 == var3) {
            if(var4 == 0) {
               this.method2383(var1, var2, 66560);
               this.method2383(var1 - 1, var2, 4096);
               this.method2383(var1, var2 + 1, 16384);
            }

            if(1 == var4) {
               this.method2383(var1, var2, 5120);
               this.method2383(var1, var2 + 1, 16384);
               this.method2383(var1 + 1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2383(var1, var2, 20480);
               this.method2383(1 + var1, var2, 65536);
               this.method2383(var1, var2 - 1, 1024);
            }

            if(3 == var4) {
               this.method2383(var1, var2, 81920);
               this.method2383(var1, var2 - 1, 1024);
               this.method2383(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "6657"
   )
   static final void method2409() {
      try {
         if(0 == client.field311) {
            if(class167.field2697 != null) {
               class167.field2697.method2960();
               class167.field2697 = null;
            }

            client.field321 = null;
            client.field333 = false;
            client.field312 = 0;
            client.field311 = 1;
         }

         if(1 == client.field311) {
            if(client.field321 == null) {
               client.field321 = class38.field878.method2864(class127.field2059, class52.field1170);
            }

            if(client.field321.field2226 == 2) {
               throw new IOException();
            }

            if(client.field321.field2226 == 1) {
               class167.field2697 = new class143((Socket)client.field321.field2224, class38.field878);
               client.field321 = null;
               client.field311 = 2;
            }
         }

         if(2 == client.field311) {
            client.field322.field2005 = 0;
            client.field322.method2477(14);
            class167.field2697.method2964(client.field322.field2007, 0, 1);
            client.field324.field2005 = 0;
            client.field311 = 3;
         }

         int var0;
         if(3 == client.field311) {
            if(null != class3.field63) {
               class3.field63.method1151();
            }

            if(class139.field2154 != null) {
               class139.field2154.method1151();
            }

            var0 = class167.field2697.method2979();
            if(null != class3.field63) {
               class3.field63.method1151();
            }

            if(class139.field2154 != null) {
               class139.field2154.method1151();
            }

            if(var0 != 0) {
               class133.method2846(var0);
               return;
            }

            client.field324.field2005 = 0;
            client.field311 = 5;
         }

         int var1;
         int var2;
         if(5 == client.field311) {
            int[] var3 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            client.field322.field2005 = 0;
            client.field322.method2477(1);
            client.field322.method2477(class31.field719.vmethod3150());
            client.field322.method2480(var3[0]);
            client.field322.method2480(var3[1]);
            client.field322.method2480(var3[2]);
            client.field322.method2480(var3[3]);
            switch(class31.field719.field2609) {
            case 0:
               client.field322.method2480(((Integer)class76.field1388.field146.get(Integer.valueOf(class36.method715(class31.field737)))).intValue());
               client.field322.field2005 += 4;
               break;
            case 1:
               client.field322.field2005 += 8;
               break;
            case 2:
            case 3:
               client.field322.method2606(class87.field1540);
               client.field322.field2005 += 5;
            }

            client.field322.method2483(class31.field740);
            client.field322.method2512(class4.field74, class4.field71);
            client.field546.field2005 = 0;
            if(40 == client.field286) {
               client.field546.method2477(18);
            } else {
               client.field546.method2477(16);
            }

            client.field546.method2661(0);
            var1 = client.field546.field2005;
            client.field546.method2480(114);
            client.field546.method2486(client.field322.field2007, 0, client.field322.field2005);
            var2 = client.field546.field2005;
            client.field546.method2483(class31.field737);
            client.field546.method2477((client.field336?1:0) << 1 | (client.field493?1:0));
            client.field546.method2661(class15.field214);
            client.field546.method2661(class15.field215);
            class101.method2267(client.field546);
            client.field546.method2483(class10.field164);
            client.field546.method2480(class15.field207);
            class119 var4 = new class119(class179.field2942.method3156());
            class179.field2942.method3158(var4);
            client.field546.method2486(var4.field2007, 0, var4.field2007.length);
            client.field546.method2477(class15.field208);
            client.field546.method2480(class14.field199.field2690);
            client.field546.method2480(class115.field1988.field2690);
            client.field546.method2480(class186.field3023.field2690);
            client.field546.method2480(class174.field2905.field2690);
            client.field546.method2480(class28.field682.field2690);
            client.field546.method2480(class7.field132.field2690);
            client.field546.method2480(class102.field1776.field2690);
            client.field546.method2480(class15.field212.field2690);
            client.field546.method2480(class127.field2058.field2690);
            client.field546.method2480(class96.field1644.field2690);
            client.field546.method2480(class164.field2663.field2690);
            client.field546.method2480(class3.field65.field2690);
            client.field546.method2480(class9.field155.field2690);
            client.field546.method2480(class8.field147.field2690);
            client.field546.method2480(client.field334.field2690);
            client.field546.method2480(class4.field75.field2690);
            client.field546.method2653(var3, var2, client.field546.field2005);
            client.field546.method2524(client.field546.field2005 - var1);
            class167.field2697.method2964(client.field546.field2007, 0, client.field546.field2005);
            client.field322.method2736(var3);

            for(int var5 = 0; var5 < 4; ++var5) {
               var3[var5] += 50;
            }

            client.field324.method2736(var3);
            client.field311 = 6;
         }

         if(client.field311 == 6 && class167.field2697.method2962() > 0) {
            var0 = class167.field2697.method2979();
            if(var0 == 21 && 20 == client.field286) {
               client.field311 = 7;
            } else if(2 == var0) {
               client.field311 = 9;
            } else if(15 == var0 && client.field286 == 40) {
               client.field325 = -1;
               client.field311 = 13;
            } else if(var0 == 23 && client.field313 < 1) {
               ++client.field313;
               client.field311 = 0;
            } else {
               if(29 != var0) {
                  class133.method2846(var0);
                  return;
               }

               client.field311 = 11;
            }
         }

         if(7 == client.field311 && class167.field2697.method2962() > 0) {
            client.field314 = (class167.field2697.method2979() + 3) * 60;
            client.field311 = 8;
         }

         if(8 == client.field311) {
            client.field312 = 0;
            class8.method107("You have only just left another world.", "Your profile will be transferred in:", client.field314 / 60 + " seconds.");
            if(--client.field314 <= 0) {
               client.field311 = 0;
            }
         } else {
            if(client.field311 == 9 && class167.field2697.method2962() >= 13) {
               boolean var9 = class167.field2697.method2979() == 1;
               class167.field2697.method2961(client.field324.field2007, 0, 4);
               client.field324.field2005 = 0;
               boolean var12 = false;
               if(var9) {
                  var1 = client.field324.method2738() << 24;
                  var1 |= client.field324.method2738() << 16;
                  var1 |= client.field324.method2738() << 8;
                  var1 |= client.field324.method2738();
                  var2 = class36.method715(class31.field737);
                  if(class76.field1388.field146.size() >= 10 && !class76.field1388.field146.containsKey(Integer.valueOf(var2))) {
                     Iterator var14 = class76.field1388.field146.entrySet().iterator();
                     var14.next();
                     var14.remove();
                  }

                  class76.field1388.field146.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class7.method101();
               }

               client.field517 = class167.field2697.method2979();
               client.field502 = class167.field2697.method2979() == 1;
               client.field291 = class167.field2697.method2979();
               client.field291 <<= 8;
               client.field291 += class167.field2697.method2979();
               client.field402 = class167.field2697.method2979();
               class167.field2697.method2961(client.field324.field2007, 0, 1);
               client.field324.field2005 = 0;
               client.field326 = client.field324.method2738();
               class167.field2697.method2961(client.field324.field2007, 0, 2);
               client.field324.field2005 = 0;
               client.field325 = client.field324.method2584();
               if(1 == client.field402) {
                  try {
                     class132.method2835(client.field276, "zap");
                  } catch (Throwable var7) {
                     ;
                  }
               } else {
                  try {
                     class132.method2835(client.field276, "unzap");
                  } catch (Throwable var6) {
                     ;
                  }
               }

               client.field311 = 10;
            }

            if(10 == client.field311) {
               if(class167.field2697.method2962() >= client.field325) {
                  client.field324.field2005 = 0;
                  class167.field2697.method2961(client.field324.field2007, 0, client.field325);
                  class51.method994();
                  class44.method907(client.field324);
                  class110.field1945 = -1;
                  class175.method3431(false);
                  client.field326 = -1;
               }
            } else {
               if(client.field311 == 11 && class167.field2697.method2962() >= 2) {
                  client.field324.field2005 = 0;
                  class167.field2697.method2961(client.field324.field2007, 0, 2);
                  client.field324.field2005 = 0;
                  class213.field3158 = client.field324.method2584();
                  client.field311 = 12;
               }

               if(client.field311 == 12 && class167.field2697.method2962() >= class213.field3158) {
                  client.field324.field2005 = 0;
                  class167.field2697.method2961(client.field324.field2007, 0, class213.field3158);
                  client.field324.field2005 = 0;
                  String var10 = client.field324.method2500();
                  String var13 = client.field324.method2500();
                  String var15 = client.field324.method2500();
                  class8.method107(var10, var13, var15);
                  class15.method188(10);
               }

               if(client.field311 != 13) {
                  ++client.field312;
                  if(client.field312 > 2000) {
                     if(client.field313 < 1) {
                        if(class52.field1170 == class59.field1223) {
                           class52.field1170 = class176.field2922;
                        } else {
                           class52.field1170 = class59.field1223;
                        }

                        ++client.field313;
                        client.field311 = 0;
                     } else {
                        class133.method2846(-3);
                     }
                  }
               } else {
                  if(-1 == client.field325) {
                     if(class167.field2697.method2962() < 2) {
                        return;
                     }

                     class167.field2697.method2961(client.field324.field2007, 0, 2);
                     client.field324.field2005 = 0;
                     client.field325 = client.field324.method2584();
                  }

                  if(class167.field2697.method2962() >= client.field325) {
                     class167.field2697.method2961(client.field324.field2007, 0, client.field325);
                     client.field324.field2005 = 0;
                     var0 = client.field325;
                     client.field322.field2005 = 0;
                     client.field324.field2005 = 0;
                     client.field326 = -1;
                     client.field329 = 1;
                     client.field330 = -1;
                     client.field331 = -1;
                     client.field325 = 0;
                     client.field510 = 0;
                     client.field295 = 0;
                     client.field496 = 0;
                     client.field418 = false;
                     client.field293 = 0;
                     client.field512 = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        client.field491[var1] = null;
                     }

                     class106.field1881 = null;

                     for(var1 = 0; var1 < client.field515.length; ++var1) {
                        class34 var11 = client.field515[var1];
                        if(var11 != null) {
                           var11.field837 = -1;
                           var11.field838 = false;
                        }
                     }

                     class10.method135();
                     class15.method188(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        client.field482[var1] = true;
                     }

                     class16.method195();
                     class44.method907(client.field324);
                     if(var0 != client.field324.field2005) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var8) {
         if(client.field313 < 1) {
            if(class59.field1223 == class52.field1170) {
               class52.field1170 = class176.field2922;
            } else {
               class52.field1170 = class59.field1223;
            }

            ++client.field313;
            client.field311 = 0;
         } else {
            class133.method2846(-2);
         }
      }

   }
}
