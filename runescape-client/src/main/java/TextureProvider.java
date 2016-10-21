import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("TextureProvider")
public class TextureProvider implements class95 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -264637351
   )
   int field1673;
   @ObfuscatedName("e")
   Deque field1674 = new Deque();
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2031866253
   )
   int field1676 = 0;
   @ObfuscatedName("v")
   double field1677 = 1.0D;
   @ObfuscatedName("f")
   class86[] field1678;
   @ObfuscatedName("m")
   class170 field1679;
   @ObfuscatedName("mw")
   @Export("clanMembers")
   static XClanMember[] clanMembers;
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = 2122325333
   )
   static int field1683;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -387062229
   )
   int field1685 = 128;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2206(double var1) {
      this.field1677 = var1;
      this.method2212();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-108641568"
   )
   @Export("load")
   public int[] load(int var1) {
      class86 var2 = this.field1678[var1];
      if(null != var2) {
         if(null != var2.field1490) {
            this.field1674.method3910(var2);
            var2.field1502 = true;
            return var2.field1490;
         }

         boolean var3 = var2.method1943(this.field1677, this.field1685, this.field1679);
         if(var3) {
            if(this.field1676 == 0) {
               class86 var4 = (class86)this.field1674.method3905();
               var4.method1944();
            } else {
               --this.field1676;
            }

            this.field1674.method3910(var2);
            var2.field1502 = true;
            return var2.field1490;
         }
      }

      return null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "4"
   )
   public int vmethod2209(int var1) {
      return null != this.field1678[var1]?this.field1678[var1].field1494:0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-478318778"
   )
   public boolean vmethod2210(int var1) {
      return this.field1678[var1].field1495;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1657217275"
   )
   public boolean vmethod2211(int var1) {
      return this.field1685 == 64;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "121"
   )
   public void method2212() {
      for(int var1 = 0; var1 < this.field1678.length; ++var1) {
         if(null != this.field1678[var1]) {
            this.field1678[var1].method1944();
         }
      }

      this.field1674 = new Deque();
      this.field1676 = this.field1673;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "15"
   )
   public void method2213(int var1) {
      for(int var2 = 0; var2 < this.field1678.length; ++var2) {
         class86 var3 = this.field1678[var2];
         if(null != var3 && var3.field1497 != 0 && var3.field1502) {
            var3.method1946(var1);
            var3.field1502 = false;
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass125;IB)V",
      garbageValue = "113"
   )
   static void method2218(class125 var0, int var1) {
      boolean var2 = var0.method2771(1) == 1;
      if(var2) {
         class34.field775[++class34.field771 - 1] = var1;
      }

      int var3 = var0.method2771(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field54 = false;
         } else if(var1 == Client.localInteractingIndex) {
            throw new RuntimeException();
         } else {
            class34.field769[var1] = (var4.pathY[0] + class8.baseY >> 6) + (var4.pathX[0] + class32.baseX >> 6 << 14) + (var4.field41 << 28);
            if(var4.field844 != -1) {
               class34.field767[var1] = var4.field844;
            } else {
               class34.field767[var1] = var4.field873;
            }

            class34.field768[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method2771(1) != 0) {
               WidgetNode.method45(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2771(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field54 = true;
                  var4.field36 = var6;
                  var4.field48 = var7;
               } else {
                  var4.field54 = false;
                  var4.method21(var6, var7, class34.field760[var1]);
               }
            } else {
               var4.method22(var6, var7);
               var4.field54 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method2771(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field54 = true;
                  var4.field36 = var6;
                  var4.field48 = var7;
               } else {
                  var4.field54 = false;
                  var4.method21(var6, var7, class34.field760[var1]);
               }
            } else {
               var4.method22(var6, var7);
               var4.field54 = false;
            }

         } else {
            var5 = var0.method2771(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2771(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var4.pathY[0] + var9;
               if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method22(var10, var11);
                  var4.field54 = false;
               } else if(var2) {
                  var4.field54 = true;
                  var4.field36 = var10;
                  var4.field48 = var11;
               } else {
                  var4.field54 = false;
                  var4.method21(var10, var11, class34.field760[var1]);
               }

               var4.field41 = (byte)(var4.field41 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  XItemContainer.plane = var4.field41;
               }

            } else {
               var6 = var0.method2771(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var4.pathX[0] + class32.baseX + var8 & 16383) - class32.baseX;
               var11 = (var4.pathY[0] + class8.baseY + var9 & 16383) - class8.baseY;
               if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field54 = true;
                     var4.field36 = var10;
                     var4.field48 = var11;
                  } else {
                     var4.field54 = false;
                     var4.method21(var10, var11, class34.field760[var1]);
                  }
               } else {
                  var4.method22(var10, var11);
                  var4.field54 = false;
               }

               var4.field41 = (byte)(var7 + var4.field41 & 3);
               if(Client.localInteractingIndex == var1) {
                  XItemContainer.plane = var4.field41;
               }

            }
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class170 var1, class170 var2, int var3, double var4, int var6) {
      this.field1679 = var2;
      this.field1673 = var3;
      this.field1676 = this.field1673;
      this.field1677 = var4;
      this.field1685 = var6;
      int[] var7 = var1.method3311(0);
      int var8 = var7.length;
      this.field1678 = new class86[var1.method3321(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.method3304(0, var7[var9]));
         this.field1678[var7[var9]] = new class86(var10);
      }

   }
}
