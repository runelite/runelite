import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("n")
   @Export("highMemory")
   protected static boolean highMemory;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1026104421
   )
   @Export("priority")
   static int priority;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "[Lds;"
   )
   class118[] field1638;
   @ObfuscatedName("y")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   class118 field1632;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -634400027
   )
   int field1648;
   @ObfuscatedName("w")
   boolean field1651;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1576857389
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -304258541
   )
   int field1636;
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "[Lds;"
   )
   class118[] field1640;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -7646441585078765293L
   )
   long field1641;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 802403016429506099L
   )
   long field1637;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1475866567
   )
   int field1642;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -495876065
   )
   int field1644;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2078254017
   )
   int field1634;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1149465821
   )
   int field1639;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 4142533437580279735L
   )
   long field1645;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2082207203
   )
   int field1635;

   protected AbstractSoundSystem() {
      this.field1636 = 32;
      this.field1637 = class45.currentTimeMs();
      this.field1641 = 0L;
      this.field1642 = 0;
      this.field1634 = 0;
      this.field1644 = 0;
      this.field1645 = 0L;
      this.field1651 = true;
      this.field1648 = 0;
      this.field1640 = new class118[8];
      this.field1638 = new class118[8];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1510564929"
   )
   protected void vmethod2022() throws Exception {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1086892300"
   )
   protected void close() {
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1457005267"
   )
   public final synchronized void method2055() {
      if(this.samples != null) {
         long var1 = class45.currentTimeMs();

         try {
            if(0L != this.field1641) {
               if(var1 < this.field1641) {
                  return;
               }

               this.create(this.offset);
               this.field1641 = 0L;
               this.field1651 = true;
            }

            int var3 = this.size();
            if(this.field1644 - var3 > this.field1642) {
               this.field1642 = this.field1644 - var3;
            }

            int var4 = this.field1639 + this.field1635;
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
               this.field1651 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1635 = var4 - this.field1639;
               }
            }

            while(var3 < var4) {
               this.method2015(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1645) {
               if(!this.field1651) {
                  if(this.field1642 == 0 && this.field1634 == 0) {
                     this.close();
                     this.field1641 = var1 + 2000L;
                     return;
                  }

                  this.field1635 = Math.min(this.field1634, this.field1642);
                  this.field1634 = this.field1642;
               } else {
                  this.field1651 = false;
               }

               this.field1642 = 0;
               this.field1645 = var1 + 2000L;
            }

            this.field1644 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1641 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1637) {
               var1 = this.field1637;
            }

            while(var1 > this.field1637 + 5000L) {
               this.method2041(256);
               this.field1637 += (long)(256000 / class73.sampleRate);
            }
         } catch (Exception var6) {
            this.field1637 = var1;
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-96148960"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1797297061"
   )
   public final synchronized void method2013() {
      this.field1651 = true;

      try {
         this.vmethod2022();
      } catch (Exception var2) {
         this.close();
         this.field1641 = class45.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1782171697"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1332749288"
   )
   final void method2041(int var1) {
      this.field1648 -= var1;
      if(this.field1648 < 0) {
         this.field1648 = 0;
      }

      if(this.field1632 != null) {
         this.field1632.vmethod3937(var1);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lds;IB)V",
      garbageValue = "60"
   )
   final void method2016(class118 var1, int var2) {
      int var3 = var2 >> 5;
      class118 var4 = this.field1638[var3];
      if(var4 == null) {
         this.field1640[var3] = var1;
      } else {
         var4.field1726 = var1;
      }

      this.field1638[var3] = var1;
      var1.field1727 = var2;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2090866647"
   )
   public final synchronized void method2028() {
      if(class33.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class33.task.systems[var2]) {
               class33.task.systems[var2] = null;
            }

            if(class33.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class269.field3669.shutdownNow();
            class269.field3669 = null;
            class33.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1455254524"
   )
   public final void method2011() {
      this.field1651 = true;
   }

   @ObfuscatedName("aq")
   final void method2015(int[] var1, int var2) {
      int var3 = var2;
      if(highMemory) {
         var3 = var2 << 1;
      }

      class184.method3560(var1, 0, var3);
      this.field1648 -= var2;
      if(this.field1632 != null && this.field1648 <= 0) {
         this.field1648 += class73.sampleRate >> 4;
         class82.method1674(this.field1632);
         this.method2016(this.field1632, this.field1632.vmethod2317());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class118 var10;
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
                  class118 var11 = this.field1640[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        class121 var12 = var11.field1728;
                        if(var12 != null && var12.field1760 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1726;
                        } else {
                           var11.field1729 = true;
                           int var13 = var11.vmethod3950();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1760 += var13;
                           }

                           if(var4 >= this.field1636) {
                              break label104;
                           }

                           class118 var14 = var11.vmethod3943();
                           if(var14 != null) {
                              for(int var15 = var11.field1727; var14 != null; var14 = var11.vmethod3934()) {
                                 this.method2016(var14, var15 * var14.vmethod2317() >> 8);
                              }
                           }

                           class118 var18 = var11.field1726;
                           var11.field1726 = null;
                           if(var10 == null) {
                              this.field1640[var7] = var18;
                           } else {
                              var10.field1726 = var18;
                           }

                           if(var18 == null) {
                              this.field1638[var7] = var10;
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
            class118 var16 = this.field1640[var6];
            class118[] var17 = this.field1640;
            this.field1638[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1726;
               var16.field1726 = null;
            }
         }
      }

      if(this.field1648 < 0) {
         this.field1648 = 0;
      }

      if(this.field1632 != null) {
         this.field1632.vmethod3936(var1, 0, var2);
      }

      this.field1637 = class45.currentTimeMs();
   }

   @ObfuscatedName("r")
   protected void write() throws Exception {
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lds;I)V",
      garbageValue = "-1409567921"
   )
   public final synchronized void method2009(class118 var1) {
      this.field1632 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1976760408"
   )
   protected void vmethod2017() throws Exception {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1877397029"
   )
   public static int method2058(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 = var0 * var2;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lii;Lii;Lii;B)V",
      garbageValue = "8"
   )
   public static void method2059(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class255.field3419 = var0;
      class255.field3425 = var1;
      class255.field3429 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-16"
   )
   public static int method2024(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }
}
