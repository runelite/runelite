import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public class class109 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -253877885
   )
   int field1618;
   @ObfuscatedName("o")
   class119 field1620;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 216492657
   )
   int field1621;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 7989757045107792977L
   )
   long field1622;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1149140931
   )
   int field1623;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 594455791
   )
   int field1624;
   @ObfuscatedName("x")
   protected int[] field1625;
   @ObfuscatedName("z")
   boolean field1626;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1340308511
   )
   int field1627;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 252317699
   )
   public static int field1628;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -438020953
   )
   int field1629;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -401701349242099011L
   )
   long field1630;
   @ObfuscatedName("ax")
   class119[] field1631;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1469994825
   )
   int field1633;
   @ObfuscatedName("aj")
   class119[] field1634;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -3843789128556196805L
   )
   long field1635;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1740441319
   )
   int field1638;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1616517196"
   )
   protected void vmethod2044(int var1) throws Exception {
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1988337766"
   )
   public final synchronized void method2046() {
      if(this.field1625 != null) {
         long var1 = class226.method4147();

         try {
            if(this.field1635 != 0L) {
               if(var1 < this.field1635) {
                  return;
               }

               this.vmethod2044(this.field1623);
               this.field1635 = 0L;
               this.field1626 = true;
            }

            int var3 = this.vmethod2055();
            if(this.field1629 - var3 > this.field1627) {
               this.field1627 = this.field1629 - var3;
            }

            int var4 = this.field1624 + this.field1638;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1623) {
               this.field1623 += 1024;
               if(this.field1623 > 16384) {
                  this.field1623 = 16384;
               }

               this.vmethod2050();
               this.vmethod2044(this.field1623);
               var3 = 0;
               this.field1626 = true;
               if(var4 + 256 > this.field1623) {
                  var4 = this.field1623 - 256;
                  this.field1638 = var4 - this.field1624;
               }
            }

            while(var3 < var4) {
               this.method2051(this.field1625, 256);
               this.vmethod2053();
               var3 += 256;
            }

            if(var1 > this.field1630) {
               if(!this.field1626) {
                  if(this.field1627 == 0 && this.field1618 == 0) {
                     this.vmethod2050();
                     this.field1635 = var1 + 2000L;
                     return;
                  }

                  this.field1638 = Math.min(this.field1618, this.field1627);
                  this.field1618 = this.field1627;
               } else {
                  this.field1626 = false;
               }

               this.field1627 = 0;
               this.field1630 = 2000L + var1;
            }

            this.field1629 = var3;
         } catch (Exception var7) {
            this.vmethod2050();
            this.field1635 = 2000L + var1;
         }

         try {
            if(var1 > this.field1622 + 500000L) {
               var1 = this.field1622;
            }

            while(var1 > this.field1622 + 5000L) {
               this.method2052(256);
               this.field1622 += (long)(256000 / field1628);
            }
         } catch (Exception var6) {
            this.field1622 = var1;
         }

      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "920086046"
   )
   public final void method2047() {
      this.field1626 = true;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2054792002"
   )
   public final synchronized void method2049() {
      if(class83.field1308 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(class83.field1308.field1651[var2] == this) {
               class83.field1308.field1651[var2] = null;
            }

            if(class83.field1308.field1651[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class60.field737.shutdownNow();
            class60.field737 = null;
            class83.field1308 = null;
         }
      }

      this.vmethod2050();
      this.field1625 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1272424661"
   )
   protected void vmethod2050() {
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method2051(int[] var1, int var2) {
      int var3 = var2;
      if(class168.field2315) {
         var3 = var2 << 1;
      }

      class183.method3518(var1, 0, var3);
      this.field1633 -= var2;
      if(this.field1620 != null && this.field1633 <= 0) {
         this.field1633 += field1628 >> 4;
         ChatMessages.method1854(this.field1620);
         this.method2076(this.field1620, this.field1620.vmethod2322());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class119 var10;
         label139:
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

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class119 var11 = this.field1634[var7];

                  label133:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label133;
                        }

                        class122 var12 = var11.field1705;
                        if(var12 != null && var12.field1737 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1706;
                        } else {
                           var11.field1703 = true;
                           int var13 = var11.vmethod3946();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1737 += var13;
                           }

                           if(var4 >= this.field1621) {
                              break label139;
                           }

                           class119 var14 = var11.vmethod3944();
                           if(var14 != null) {
                              for(int var18 = var11.field1704; var14 != null; var14 = var11.vmethod3945()) {
                                 this.method2076(var14, var18 * var14.vmethod2322() >> 8);
                              }
                           }

                           class119 var15 = var11.field1706;
                           var11.field1706 = null;
                           if(var10 == null) {
                              this.field1634[var7] = var15;
                           } else {
                              var10.field1706 = var15;
                           }

                           if(var15 == null) {
                              this.field1631[var7] = var10;
                           }

                           var11 = var15;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class119 var16 = this.field1634[var6];
            class119[] var17 = this.field1634;
            this.field1631[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1706;
               var16.field1706 = null;
            }
         }
      }

      if(this.field1633 < 0) {
         this.field1633 = 0;
      }

      if(this.field1620 != null) {
         this.field1620.vmethod3949(var1, 0, var2);
      }

      this.field1622 = class226.method4147();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1070615642"
   )
   final void method2052(int var1) {
      this.field1633 -= var1;
      if(this.field1633 < 0) {
         this.field1633 = 0;
      }

      if(this.field1620 != null) {
         this.field1620.vmethod3969(var1);
      }

   }

   @ObfuscatedName("q")
   protected void vmethod2053() throws Exception {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-33"
   )
   protected int vmethod2055() throws Exception {
      return this.field1623;
   }

   protected class109() {
      this.field1621 = 32;
      this.field1622 = class226.method4147();
      this.field1635 = 0L;
      this.field1627 = 0;
      this.field1618 = 0;
      this.field1629 = 0;
      this.field1630 = 0L;
      this.field1626 = true;
      this.field1633 = 0;
      this.field1634 = new class119[8];
      this.field1631 = new class119[8];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16261270"
   )
   protected void vmethod2057() throws Exception {
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-1627986272"
   )
   public final synchronized void method2064(class119 var1) {
      this.field1620 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "196875046"
   )
   protected void vmethod2073() throws Exception {
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "32"
   )
   final void method2076(class119 var1, int var2) {
      int var3 = var2 >> 5;
      class119 var4 = this.field1631[var3];
      if(var4 == null) {
         this.field1634[var3] = var1;
      } else {
         var4.field1706 = var1;
      }

      this.field1631[var3] = var1;
      var1.field1704 = var2;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1693364796"
   )
   public final synchronized void method2093() {
      this.field1626 = true;

      try {
         this.vmethod2057();
      } catch (Exception var2) {
         this.vmethod2050();
         this.field1635 = class226.method4147() + 2000L;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;B)V",
      garbageValue = "-126"
   )
   public static void method2098(IndexDataBase var0) {
      class252.field3391 = var0;
   }
}
