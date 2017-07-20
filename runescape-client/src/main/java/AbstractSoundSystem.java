import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("x")
   static ScheduledExecutorService field1593;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "[Ldk;"
   )
   class119[] field1596;
   @ObfuscatedName("d")
   boolean field1595;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   class119 field1602;
   @ObfuscatedName("h")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 330893493
   )
   int field1600;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1599162181
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1716032321
   )
   int field1597;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "[Ldk;"
   )
   class119[] field1610;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -6283073992830690133L
   )
   long field1592;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 3639507855000872593L
   )
   long field1603;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 291237085
   )
   int field1607;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 859882105
   )
   int field1605;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 850399631
   )
   int field1604;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1792370739
   )
   int field1599;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1170278313
   )
   int field1601;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -6089011649266243015L
   )
   long field1606;

   protected AbstractSoundSystem() {
      this.field1597 = 32;
      this.field1603 = class157.currentTimeMs();
      this.field1592 = 0L;
      this.field1607 = 0;
      this.field1604 = 0;
      this.field1605 = 0;
      this.field1606 = 0L;
      this.field1595 = true;
      this.field1600 = 0;
      this.field1610 = new class119[8];
      this.field1596 = new class119[8];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "32"
   )
   protected void vmethod1953() throws Exception {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1951583267"
   )
   protected void close() {
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "18"
   )
   public final synchronized void method1941() {
      if(this.samples != null) {
         long var1 = class157.currentTimeMs();

         try {
            if(0L != this.field1592) {
               if(var1 < this.field1592) {
                  return;
               }

               this.create(this.offset);
               this.field1592 = 0L;
               this.field1595 = true;
            }

            int var3 = this.size();
            if(this.field1605 - var3 > this.field1607) {
               this.field1607 = this.field1605 - var3;
            }

            int var4 = this.field1599 + this.field1601;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.offset) {
               this.offset += 1024;
               if(this.offset > 16384) {
                  this.offset = 16384;
               }

               this.close();
               this.create(this.offset);
               var3 = 0;
               this.field1595 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1601 = var4 - this.field1599;
               }
            }

            while(var3 < var4) {
               this.method1946(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1606) {
               if(!this.field1595) {
                  if(this.field1607 == 0 && this.field1604 == 0) {
                     this.close();
                     this.field1592 = var1 + 2000L;
                     return;
                  }

                  this.field1601 = Math.min(this.field1604, this.field1607);
                  this.field1604 = this.field1607;
               } else {
                  this.field1595 = false;
               }

               this.field1607 = 0;
               this.field1606 = 2000L + var1;
            }

            this.field1605 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1592 = 2000L + var1;
         }

         try {
            if(var1 > this.field1603 + 500000L) {
               var1 = this.field1603;
            }

            while(var1 > 5000L + this.field1603) {
               this.method1945(256);
               this.field1603 += (long)(256000 / CombatInfo1.sampleRate);
            }
         } catch (Exception var6) {
            this.field1603 = var1;
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "69"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-616733124"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-638658599"
   )
   public final synchronized void method1971() {
      this.field1595 = true;

      try {
         this.vmethod1953();
      } catch (Exception var2) {
         this.close();
         this.field1592 = class157.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-940206025"
   )
   final void method1945(int var1) {
      this.field1600 -= var1;
      if(this.field1600 < 0) {
         this.field1600 = 0;
      }

      if(this.field1602 != null) {
         this.field1602.vmethod3827(var1);
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ldk;II)V",
      garbageValue = "1549594883"
   )
   final void method1959(class119 var1, int var2) {
      int var3 = var2 >> 5;
      class119 var4 = this.field1596[var3];
      if(var4 == null) {
         this.field1610[var3] = var1;
      } else {
         var4.field1683 = var1;
      }

      this.field1596[var3] = var1;
      var1.field1680 = var2;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2074475078"
   )
   public final synchronized void method1944() {
      if(class243.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class243.task.systems[var2]) {
               class243.task.systems[var2] = null;
            }

            if(class243.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1593.shutdownNow();
            field1593 = null;
            class243.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "38346468"
   )
   public final void method1976() {
      this.field1595 = true;
   }

   @ObfuscatedName("an")
   final void method1946(int[] var1, int var2) {
      int var3 = var2;
      if(class8.highMemory) {
         var3 = var2 << 1;
      }

      class183.method3401(var1, 0, var3);
      this.field1600 -= var2;
      if(this.field1602 != null && this.field1600 <= 0) {
         this.field1600 += CombatInfo1.sampleRate >> 4;
         DynamicObject.method1789(this.field1602);
         this.method1959(this.field1602, this.field1602.vmethod2228());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class119 var10;
         label104:
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
                  class119 var11 = this.field1610[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        class122 var12 = var11.field1682;
                        if(var12 != null && var12.field1714 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1683;
                        } else {
                           var11.field1681 = true;
                           int var13 = var11.vmethod3825();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1714 += var13;
                           }

                           if(var4 >= this.field1597) {
                              break label104;
                           }

                           class119 var14 = var11.vmethod3823();
                           if(var14 != null) {
                              for(int var15 = var11.field1680; var14 != null; var14 = var11.vmethod3835()) {
                                 this.method1959(var14, var15 * var14.vmethod2228() >> 8);
                              }
                           }

                           class119 var18 = var11.field1683;
                           var11.field1683 = null;
                           if(var10 == null) {
                              this.field1610[var7] = var18;
                           } else {
                              var10.field1683 = var18;
                           }

                           if(var18 == null) {
                              this.field1596[var7] = var10;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class119 var16 = this.field1610[var6];
            class119[] var17 = this.field1610;
            this.field1596[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1683;
               var16.field1683 = null;
            }
         }
      }

      if(this.field1600 < 0) {
         this.field1600 = 0;
      }

      if(this.field1602 != null) {
         this.field1602.vmethod3826(var1, 0, var2);
      }

      this.field1603 = class157.currentTimeMs();
   }

   @ObfuscatedName("u")
   protected void write() throws Exception {
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ldk;B)V",
      garbageValue = "-90"
   )
   public final synchronized void method1940(class119 var1) {
      this.field1602 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1959858206"
   )
   protected void vmethod1948() throws Exception {
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(Lho;B)Z",
      garbageValue = "14"
   )
   static final boolean method1998(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = class175.method3312(var0, var1);
            int var3 = var0.field2641[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }
}
