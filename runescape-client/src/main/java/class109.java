import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class109 {
   @ObfuscatedName("y")
   class119 field1629;
   @ObfuscatedName("m")
   public static boolean field1630;
   @ObfuscatedName("g")
   static class111 field1632;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1101589019
   )
   public static int field1633;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 151993781
   )
   int field1634;
   @ObfuscatedName("x")
   static class103 field1635;
   @ObfuscatedName("a")
   protected int[] field1636;
   @ObfuscatedName("rm")
   @ObfuscatedGetter(
      intValue = 115776723
   )
   static int field1637;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -539868485
   )
   int field1638;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -123463907
   )
   int field1640;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1187200021
   )
   int field1641;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1094653799
   )
   int field1642;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 6137064208185275295L
   )
   long field1643;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 2042888127
   )
   int field1645;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1498122785
   )
   int field1646;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 7620470792651336227L
   )
   long field1647;
   @ObfuscatedName("u")
   boolean field1648;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1867350729
   )
   int field1649;
   @ObfuscatedName("al")
   class119[] field1650;
   @ObfuscatedName("at")
   class119[] field1651;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 5871501808008405339L
   )
   long field1654;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "16"
   )
   protected int vmethod1995() throws Exception {
      return this.field1640;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1665377322"
   )
   public final synchronized void method1996() {
      this.field1648 = true;

      try {
         this.vmethod2005();
      } catch (Exception var2) {
         this.vmethod2017();
         this.field1643 = class134.method2587() + 2000L;
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "-56"
   )
   public final synchronized void method1997(class119 var1) {
      this.field1629 = var1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1546037955"
   )
   final void method1998(int var1) {
      this.field1645 -= var1;
      if(this.field1645 < 0) {
         this.field1645 = 0;
      }

      if(this.field1629 != null) {
         this.field1629.vmethod3910(var1);
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1999(int[] var1, int var2) {
      int var3 = var2;
      if(field1630) {
         var3 = var2 << 1;
      }

      class183.method3442(var1, 0, var3);
      this.field1645 -= var2;
      if(this.field1629 != null && this.field1645 <= 0) {
         this.field1645 += field1633 >> 4;
         class166.method3082(this.field1629);
         this.method2040(this.field1629, this.field1629.vmethod2306());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class119 var10;
         label141:
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
                  class119 var11 = this.field1650[var7];

                  label135:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label135;
                        }

                        class122 var12 = var11.field1723;
                        if(var12 != null && var12.field1757 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1725;
                        } else {
                           var11.field1726 = true;
                           int var13 = var11.vmethod3908();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1757 += var13;
                           }

                           if(var4 >= this.field1638) {
                              break label141;
                           }

                           class119 var14 = var11.vmethod3906();
                           if(var14 != null) {
                              for(int var16 = var11.field1724; var14 != null; var14 = var11.vmethod3907()) {
                                 this.method2040(var14, var16 * var14.vmethod2306() >> 8);
                              }
                           }

                           class119 var15 = var11.field1725;
                           var11.field1725 = null;
                           if(var10 == null) {
                              this.field1650[var7] = var15;
                           } else {
                              var10.field1725 = var15;
                           }

                           if(var15 == null) {
                              this.field1651[var7] = var10;
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
            class119 var17 = this.field1650[var6];
            class119[] var18 = this.field1650;
            this.field1651[var6] = null;

            for(var18[var6] = null; var17 != null; var17 = var10) {
               var10 = var17.field1725;
               var17.field1725 = null;
            }
         }
      }

      if(this.field1645 < 0) {
         this.field1645 = 0;
      }

      if(this.field1629 != null) {
         this.field1629.vmethod3909(var1, 0, var2);
      }

      this.field1647 = class134.method2587();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "902341640"
   )
   protected void vmethod2001() throws Exception {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-647845185"
   )
   protected void vmethod2002(int var1) throws Exception {
   }

   protected class109() {
      this.field1638 = 32;
      this.field1647 = class134.method2587();
      this.field1643 = 0L;
      this.field1634 = 0;
      this.field1649 = 0;
      this.field1646 = 0;
      this.field1654 = 0L;
      this.field1648 = true;
      this.field1645 = 0;
      this.field1650 = new class119[8];
      this.field1651 = new class119[8];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1357874836"
   )
   protected void vmethod2005() throws Exception {
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1929398491"
   )
   public final synchronized void method2009() {
      if(this.field1636 != null) {
         long var1 = class134.method2587();

         try {
            if(0L != this.field1643) {
               if(var1 < this.field1643) {
                  return;
               }

               this.vmethod2002(this.field1640);
               this.field1643 = 0L;
               this.field1648 = true;
            }

            int var3 = this.vmethod1995();
            if(this.field1646 - var3 > this.field1634) {
               this.field1634 = this.field1646 - var3;
            }

            int var4 = this.field1641 + this.field1642;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1640) {
               this.field1640 += 1024;
               if(this.field1640 > 16384) {
                  this.field1640 = 16384;
               }

               this.vmethod2017();
               this.vmethod2002(this.field1640);
               var3 = 0;
               this.field1648 = true;
               if(var4 + 256 > this.field1640) {
                  var4 = this.field1640 - 256;
                  this.field1642 = var4 - this.field1641;
               }
            }

            while(var3 < var4) {
               this.method1999(this.field1636, 256);
               this.vmethod2022();
               var3 += 256;
            }

            if(var1 > this.field1654) {
               if(!this.field1648) {
                  if(this.field1634 == 0 && this.field1649 == 0) {
                     this.vmethod2017();
                     this.field1643 = var1 + 2000L;
                     return;
                  }

                  this.field1642 = Math.min(this.field1649, this.field1634);
                  this.field1649 = this.field1634;
               } else {
                  this.field1648 = false;
               }

               this.field1634 = 0;
               this.field1654 = var1 + 2000L;
            }

            this.field1646 = var3;
         } catch (Exception var7) {
            this.vmethod2017();
            this.field1643 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1647) {
               var1 = this.field1647;
            }

            while(var1 > this.field1647 + 5000L) {
               this.method1998(256);
               this.field1647 += (long)(256000 / field1633);
            }
         } catch (Exception var6) {
            this.field1647 = var1;
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-93901902"
   )
   protected void vmethod2017() {
   }

   @ObfuscatedName("j")
   protected void vmethod2022() throws Exception {
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "2090149034"
   )
   final void method2040(class119 var1, int var2) {
      int var3 = var2 >> 5;
      class119 var4 = this.field1651[var3];
      if(var4 == null) {
         this.field1650[var3] = var1;
      } else {
         var4.field1725 = var1;
      }

      this.field1651[var3] = var1;
      var1.field1724 = var2;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "84"
   )
   public final synchronized void method2050() {
      if(field1632 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == field1632.field1666[var2]) {
               field1632.field1666[var2] = null;
            }

            if(field1632.field1666[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class51.field644.shutdownNow();
            class51.field644 = null;
            field1632 = null;
         }
      }

      this.vmethod2017();
      this.field1636 = null;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-165118930"
   )
   public final void method2055() {
      this.field1648 = true;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2080037371"
   )
   static final int method2058(int var0, int var1) {
      int var2 = class261.method4767(var0 + '넵', var1 + 91923, 4) - 128 + (class261.method4767(var0 + 10294, var1 + '鎽', 2) - 128 >> 1) + (class261.method4767(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }
}
