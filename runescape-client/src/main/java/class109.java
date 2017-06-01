import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class109 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1024670613
   )
   int field1637;
   @ObfuscatedName("x")
   static ScheduledExecutorService field1639;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 814314481
   )
   public static int field1640;
   @ObfuscatedName("q")
   protected int[] field1641;
   @ObfuscatedName("j")
   class119 field1642;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1723021811
   )
   int field1643;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -7349148786068121465L
   )
   long field1644;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 1412906487
   )
   static int field1645;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1049382093
   )
   int field1646;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1387237537
   )
   int field1647;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -2659675703090292029L
   )
   long field1648;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 216671495
   )
   int field1649;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -318980023
   )
   int field1650;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 970068785
   )
   int field1651;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 568075863386842077L
   )
   long field1652;
   @ObfuscatedName("t")
   boolean field1653;
   @ObfuscatedName("n")
   static class111 field1654;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 430121983
   )
   int field1656;
   @ObfuscatedName("ai")
   class119[] field1657;
   @ObfuscatedName("aw")
   class119[] field1658;
   @ObfuscatedName("as")
   protected static String field1659;
   @ObfuscatedName("gb")
   static SpritePixels field1660;

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1311061674"
   )
   final void method2011(int var1) {
      this.field1656 -= var1;
      if(this.field1656 < 0) {
         this.field1656 = 0;
      }

      if(this.field1642 != null) {
         this.field1642.vmethod3862(var1);
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public final synchronized void method2012() {
      if(this.field1641 != null) {
         long var1 = XGrandExchangeOffer.method96();

         try {
            if(this.field1648 != 0L) {
               if(var1 < this.field1648) {
                  return;
               }

               this.vmethod2020(this.field1649);
               this.field1648 = 0L;
               this.field1653 = true;
            }

            int var3 = this.vmethod2021();
            if(this.field1651 - var3 > this.field1647) {
               this.field1647 = this.field1651 - var3;
            }

            int var4 = this.field1646 + this.field1637;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1649) {
               this.field1649 += 1024;
               if(this.field1649 > 16384) {
                  this.field1649 = 16384;
               }

               this.vmethod2023();
               this.vmethod2020(this.field1649);
               var3 = 0;
               this.field1653 = true;
               if(var4 + 256 > this.field1649) {
                  var4 = this.field1649 - 256;
                  this.field1637 = var4 - this.field1646;
               }
            }

            while(var3 < var4) {
               this.method2017(this.field1641, 256);
               this.vmethod2022();
               var3 += 256;
            }

            if(var1 > this.field1652) {
               if(!this.field1653) {
                  if(this.field1647 == 0 && this.field1650 == 0) {
                     this.vmethod2023();
                     this.field1648 = var1 + 2000L;
                     return;
                  }

                  this.field1637 = Math.min(this.field1650, this.field1647);
                  this.field1650 = this.field1647;
               } else {
                  this.field1653 = false;
               }

               this.field1647 = 0;
               this.field1652 = var1 + 2000L;
            }

            this.field1651 = var3;
         } catch (Exception var7) {
            this.vmethod2023();
            this.field1648 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1644) {
               var1 = this.field1644;
            }

            while(var1 > this.field1644 + 5000L) {
               this.method2011(256);
               this.field1644 += (long)(256000 / field1640);
            }
         } catch (Exception var6) {
            this.field1644 = var1;
         }

      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-869344079"
   )
   public final synchronized void method2014() {
      this.field1653 = true;

      try {
         this.vmethod2024();
      } catch (Exception var2) {
         this.vmethod2023();
         this.field1648 = XGrandExchangeOffer.method96() + 2000L;
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method2017(int[] var1, int var2) {
      int var3 = var2;
      if(class275.field3732) {
         var3 = var2 << 1;
      }

      class183.method3435(var1, 0, var3);
      this.field1656 -= var2;
      if(this.field1642 != null && this.field1656 <= 0) {
         this.field1656 += field1640 >> 4;
         class29.method229(this.field1642);
         this.method2041(this.field1642, this.field1642.vmethod2273());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class119 var10;
         label140:
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
                  class119 var11 = this.field1657[var7];

                  label134:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label134;
                        }

                        class122 var12 = var11.field1734;
                        if(var12 != null && var12.field1766 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1733;
                        } else {
                           var11.field1732 = true;
                           int var13 = var11.vmethod3860();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1766 += var13;
                           }

                           if(var4 >= this.field1643) {
                              break label140;
                           }

                           class119 var14 = var11.vmethod3858();
                           if(var14 != null) {
                              for(int var15 = var11.field1735; var14 != null; var14 = var11.vmethod3886()) {
                                 this.method2041(var14, var15 * var14.vmethod2273() >> 8);
                              }
                           }

                           class119 var16 = var11.field1733;
                           var11.field1733 = null;
                           if(var10 == null) {
                              this.field1657[var7] = var16;
                           } else {
                              var10.field1733 = var16;
                           }

                           if(var16 == null) {
                              this.field1658[var7] = var10;
                           }

                           var11 = var16;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class119 var17 = this.field1657[var6];
            class119[] var18 = this.field1657;
            this.field1658[var6] = null;

            for(var18[var6] = null; var17 != null; var17 = var10) {
               var10 = var17.field1733;
               var17.field1733 = null;
            }
         }
      }

      if(this.field1656 < 0) {
         this.field1656 = 0;
      }

      if(this.field1642 != null) {
         this.field1642.vmethod3878(var1, 0, var2);
      }

      this.field1644 = XGrandExchangeOffer.method96();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2130181861"
   )
   protected void vmethod2019() throws Exception {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "426457422"
   )
   protected void vmethod2020(int var1) throws Exception {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-362612567"
   )
   protected int vmethod2021() throws Exception {
      return this.field1649;
   }

   @ObfuscatedName("v")
   protected void vmethod2022() throws Exception {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "548209644"
   )
   protected void vmethod2023() {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "99"
   )
   protected void vmethod2024() throws Exception {
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "-71"
   )
   public final synchronized void method2035(class119 var1) {
      this.field1642 = var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "121838175"
   )
   public final synchronized void method2036() {
      if(field1654 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(field1654.field1675[var2] == this) {
               field1654.field1675[var2] = null;
            }

            if(field1654.field1675[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1639.shutdownNow();
            field1639 = null;
            field1654 = null;
         }
      }

      this.vmethod2023();
      this.field1641 = null;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-736502273"
   )
   final void method2041(class119 var1, int var2) {
      int var3 = var2 >> 5;
      class119 var4 = this.field1658[var3];
      if(var4 == null) {
         this.field1657[var3] = var1;
      } else {
         var4.field1733 = var1;
      }

      this.field1658[var3] = var1;
      var1.field1735 = var2;
   }

   protected class109() {
      this.field1643 = 32;
      this.field1644 = XGrandExchangeOffer.method96();
      this.field1648 = 0L;
      this.field1647 = 0;
      this.field1650 = 0;
      this.field1651 = 0;
      this.field1652 = 0L;
      this.field1653 = true;
      this.field1656 = 0;
      this.field1657 = new class119[8];
      this.field1658 = new class119[8];
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2024883677"
   )
   public final void method2057() {
      this.field1653 = true;
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-567426727"
   )
   static final void method2058(Actor var0) {
      int var1 = var0.field1250 - Client.gameCycle;
      int var2 = var0.field1284 * 128 + var0.field1268 * 64;
      int var3 = var0.field1286 * 128 + var0.field1268 * 64;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field1300 = 0;
      var0.field1259 = var0.field1290;
   }
}
