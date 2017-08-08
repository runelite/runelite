import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1022844451
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 567099077
   )
   static int field1623;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "[Ldl;"
   )
   class120[] field1635;
   @ObfuscatedName("h")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   class120 field1620;
   @ObfuscatedName("q")
   boolean field1627;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1142418835
   )
   int field1632;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -105154451
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1264547485
   )
   int field1619;
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "[Ldl;"
   )
   class120[] field1618;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -4018438610054297163L
   )
   long field1625;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -3254034508329271813L
   )
   long field1621;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1484189553
   )
   int field1626;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1749155729
   )
   int field1628;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1298695055
   )
   int field1616;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1068691987
   )
   int field1624;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -1751325912972313203L
   )
   long field1629;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 40447039
   )
   int field1633;

   protected AbstractSoundSystem() {
      this.field1619 = 32;
      this.field1621 = class170.currentTimeMs();
      this.field1625 = 0L;
      this.field1626 = 0;
      this.field1616 = 0;
      this.field1628 = 0;
      this.field1629 = 0L;
      this.field1627 = true;
      this.field1632 = 0;
      this.field1618 = new class120[8];
      this.field1635 = new class120[8];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-784678513"
   )
   protected void vmethod2051() throws Exception {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "28"
   )
   protected void close() {
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-621590121"
   )
   public final synchronized void method2039() {
      if(this.samples != null) {
         long var1 = class170.currentTimeMs();

         try {
            if(0L != this.field1625) {
               if(var1 < this.field1625) {
                  return;
               }

               this.create(this.offset);
               this.field1625 = 0L;
               this.field1627 = true;
            }

            int var3 = this.size();
            if(this.field1628 - var3 > this.field1626) {
               this.field1626 = this.field1628 - var3;
            }

            int var4 = this.field1624 + this.field1633;
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
               this.field1627 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1624 = var4 - this.field1633;
               }
            }

            while(var3 < var4) {
               this.method2044(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1629) {
               if(!this.field1627) {
                  if(this.field1626 == 0 && this.field1616 == 0) {
                     this.close();
                     this.field1625 = var1 + 2000L;
                     return;
                  }

                  this.field1624 = Math.min(this.field1616, this.field1626);
                  this.field1616 = this.field1626;
               } else {
                  this.field1627 = false;
               }

               this.field1626 = 0;
               this.field1629 = var1 + 2000L;
            }

            this.field1628 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1625 = var1 + 2000L;
         }

         try {
            if(var1 > this.field1621 + 500000L) {
               var1 = this.field1621;
            }

            while(var1 > 5000L + this.field1621) {
               this.method2043(256);
               this.field1621 += (long)(256000 / sampleRate);
            }
         } catch (Exception var6) {
            this.field1621 = var1;
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-112"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1775773269"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-272824638"
   )
   final void method2043(int var1) {
      this.field1632 -= var1;
      if(this.field1632 < 0) {
         this.field1632 = 0;
      }

      if(this.field1620 != null) {
         this.field1620.vmethod3890(var1);
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   public final synchronized void method2041() {
      this.field1627 = true;

      try {
         this.vmethod2051();
      } catch (Exception var2) {
         this.close();
         this.field1625 = class170.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ldl;IS)V",
      garbageValue = "28708"
   )
   final void method2045(class120 var1, int var2) {
      int var3 = var2 >> 5;
      class120 var4 = this.field1635[var3];
      if(var4 == null) {
         this.field1618[var3] = var1;
      } else {
         var4.field1706 = var1;
      }

      this.field1635[var3] = var1;
      var1.field1705 = var2;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   public final synchronized void method2042() {
      if(class164.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class164.task.systems[var2]) {
               class164.task.systems[var2] = null;
            }

            if(class164.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            IndexFile.field2258.shutdownNow();
            IndexFile.field2258 = null;
            class164.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-21"
   )
   public final void method2040() {
      this.field1627 = true;
   }

   @ObfuscatedName("ax")
   final void method2044(int[] var1, int var2) {
      int var3 = var2;
      if(class25.highMemory) {
         var3 = var2 << 1;
      }

      class184.method3454(var1, 0, var3);
      this.field1632 -= var2;
      if(this.field1620 != null && this.field1632 <= 0) {
         this.field1632 += sampleRate >> 4;
         Projectile.method1790(this.field1620);
         this.method2045(this.field1620, this.field1620.vmethod2312());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class120 var10;
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
                  class120 var11 = this.field1618[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        class123 var12 = var11.field1704;
                        if(var12 != null && var12.field1738 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1706;
                        } else {
                           var11.field1707 = true;
                           int var13 = var11.vmethod3904();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1738 += var13;
                           }

                           if(var4 >= this.field1619) {
                              break label104;
                           }

                           class120 var14 = var11.vmethod3906();
                           if(var14 != null) {
                              for(int var15 = var11.field1705; var14 != null; var14 = var11.vmethod3908()) {
                                 this.method2045(var14, var15 * var14.vmethod2312() >> 8);
                              }
                           }

                           class120 var18 = var11.field1706;
                           var11.field1706 = null;
                           if(var10 == null) {
                              this.field1618[var7] = var18;
                           } else {
                              var10.field1706 = var18;
                           }

                           if(var18 == null) {
                              this.field1635[var7] = var10;
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
            class120 var16 = this.field1618[var6];
            class120[] var17 = this.field1618;
            this.field1635[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1706;
               var16.field1706 = null;
            }
         }
      }

      if(this.field1632 < 0) {
         this.field1632 = 0;
      }

      if(this.field1620 != null) {
         this.field1620.vmethod3889(var1, 0, var2);
      }

      this.field1621 = class170.currentTimeMs();
   }

   @ObfuscatedName("y")
   protected void write() throws Exception {
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Ldl;I)V",
      garbageValue = "1372028014"
   )
   public final synchronized void method2038(class120 var1) {
      this.field1620 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "59"
   )
   protected void vmethod2046() throws Exception {
   }

   @ObfuscatedName("e")
   static final int method2082(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(0.0D != var2) {
         double var12;
         if(var4 < 0.5D) {
            var12 = (1.0D + var2) * var4;
         } else {
            var12 = var2 + var4 - var4 * var2;
         }

         double var14 = var4 * 2.0D - var12;
         double var16 = 0.3333333333333333D + var0;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(var16 * 6.0D < 1.0D) {
            var6 = var16 * (var12 - var14) * 6.0D + var14;
         } else if(2.0D * var16 < 1.0D) {
            var6 = var12;
         } else if(3.0D * var16 < 2.0D) {
            var6 = (var12 - var14) * (0.6666666666666666D - var16) * 6.0D + var14;
         } else {
            var6 = var14;
         }

         if(6.0D * var0 < 1.0D) {
            var8 = var14 + (var12 - var14) * 6.0D * var0;
         } else if(2.0D * var0 < 1.0D) {
            var8 = var12;
         } else if(var0 * 3.0D < 2.0D) {
            var8 = var14 + (var12 - var14) * (0.6666666666666666D - var0) * 6.0D;
         } else {
            var8 = var14;
         }

         if(var20 * 6.0D < 1.0D) {
            var10 = 6.0D * (var12 - var14) * var20 + var14;
         } else if(var20 * 2.0D < 1.0D) {
            var10 = var12;
         } else if(3.0D * var20 < 2.0D) {
            var10 = (var12 - var14) * (0.6666666666666666D - var20) * 6.0D + var14;
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(256.0D * var6);
      int var13 = (int)(var8 * 256.0D);
      int var23 = (int)(var10 * 256.0D);
      int var15 = var23 + (var13 << 8) + (var22 << 16);
      return var15;
   }
}
