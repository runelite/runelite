import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -73990281
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("ag")
   static FontMetrics field1648;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 553745123
   )
   @Export("priority")
   static int priority;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "[Lda;"
   )
   class120[] field1649;
   @ObfuscatedName("s")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("d")
   boolean field1646;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lda;"
   )
   class120 field1635;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 979244675
   )
   int field1639;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 903821141
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1247370413
   )
   int field1636;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "[Lda;"
   )
   class120[] field1640;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -7410462907015828335L
   )
   long field1641;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -2194576446215330107L
   )
   long field1637;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -634848101
   )
   int field1642;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -224138407
   )
   int field1644;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1603904159
   )
   int field1643;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -290835077
   )
   int field1633;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -4095825202256731565L
   )
   long field1645;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1711153283
   )
   int field1631;

   protected AbstractSoundSystem() {
      this.field1636 = 32;
      this.field1637 = class74.currentTimeMs();
      this.field1641 = 0L;
      this.field1642 = 0;
      this.field1643 = 0;
      this.field1644 = 0;
      this.field1645 = 0L;
      this.field1646 = true;
      this.field1639 = 0;
      this.field1640 = new class120[8];
      this.field1649 = new class120[8];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-44667823"
   )
   protected void vmethod2043() throws Exception {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-847316198"
   )
   protected void close() {
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1126430632"
   )
   public final synchronized void method2031() {
      if(this.samples != null) {
         long var1 = class74.currentTimeMs();

         try {
            if(this.field1641 != 0L) {
               if(var1 < this.field1641) {
                  return;
               }

               this.create(this.offset);
               this.field1641 = 0L;
               this.field1646 = true;
            }

            int var3 = this.size();
            if(this.field1644 - var3 > this.field1642) {
               this.field1642 = this.field1644 - var3;
            }

            int var4 = this.field1633 + this.field1631;
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
               this.field1646 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1631 = var4 - this.field1633;
               }
            }

            while(var3 < var4) {
               this.method2086(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1645) {
               if(!this.field1646) {
                  if(this.field1642 == 0 && this.field1643 == 0) {
                     this.close();
                     this.field1641 = var1 + 2000L;
                     return;
                  }

                  this.field1631 = Math.min(this.field1643, this.field1642);
                  this.field1643 = this.field1642;
               } else {
                  this.field1646 = false;
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
            if(var1 > this.field1637 + 500000L) {
               var1 = this.field1637;
            }

            while(var1 > 5000L + this.field1637) {
               this.method2079(256);
               this.field1637 += (long)(256000 / sampleRate);
            }
         } catch (Exception var6) {
            this.field1637 = var1;
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1323834146"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1192204293"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1320950630"
   )
   public final synchronized void method2033() {
      this.field1646 = true;

      try {
         this.vmethod2043();
      } catch (Exception var2) {
         this.close();
         this.field1641 = class74.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1271987454"
   )
   final void method2079(int var1) {
      this.field1639 -= var1;
      if(this.field1639 < 0) {
         this.field1639 = 0;
      }

      if(this.field1635 != null) {
         this.field1635.vmethod3893(var1);
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lda;II)V",
      garbageValue = "1014744792"
   )
   final void method2037(class120 var1, int var2) {
      int var3 = var2 >> 5;
      class120 var4 = this.field1649[var3];
      if(var4 == null) {
         this.field1640[var3] = var1;
      } else {
         var4.field1728 = var1;
      }

      this.field1649[var3] = var1;
      var1.field1726 = var2;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2074799920"
   )
   public final synchronized void method2034() {
      if(class66.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class66.task.systems[var2]) {
               class66.task.systems[var2] = null;
            }

            if(class66.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            WidgetNode.field842.shutdownNow();
            WidgetNode.field842 = null;
            class66.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "28"
   )
   public final void method2032() {
      this.field1646 = true;
   }

   @ObfuscatedName("at")
   final void method2086(int[] var1, int var2) {
      int var3 = var2;
      if(class135.highMemory) {
         var3 = var2 << 1;
      }

      class184.method3469(var1, 0, var3);
      this.field1639 -= var2;
      if(this.field1635 != null && this.field1639 <= 0) {
         this.field1639 += sampleRate >> 4;
         class99.method1859(this.field1635);
         this.method2037(this.field1635, this.field1635.vmethod2315());
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
                  class120 var11 = this.field1640[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        class123 var12 = var11.field1729;
                        if(var12 != null && var12.field1760 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1728;
                        } else {
                           var11.field1727 = true;
                           int var13 = var11.vmethod3889();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1760 += var13;
                           }

                           if(var4 >= this.field1636) {
                              break label104;
                           }

                           class120 var14 = var11.vmethod3894();
                           if(var14 != null) {
                              for(int var15 = var11.field1726; var14 != null; var14 = var11.vmethod3888()) {
                                 this.method2037(var14, var15 * var14.vmethod2315() >> 8);
                              }
                           }

                           class120 var18 = var11.field1728;
                           var11.field1728 = null;
                           if(var10 == null) {
                              this.field1640[var7] = var18;
                           } else {
                              var10.field1728 = var18;
                           }

                           if(var18 == null) {
                              this.field1649[var7] = var10;
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
            class120 var16 = this.field1640[var6];
            class120[] var17 = this.field1640;
            this.field1649[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1728;
               var16.field1728 = null;
            }
         }
      }

      if(this.field1639 < 0) {
         this.field1639 = 0;
      }

      if(this.field1635 != null) {
         this.field1635.vmethod3904(var1, 0, var2);
      }

      this.field1637 = class74.currentTimeMs();
   }

   @ObfuscatedName("p")
   protected void write() throws Exception {
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lda;I)V",
      garbageValue = "-457168862"
   )
   public final synchronized void method2030(class120 var1) {
      this.field1635 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "33"
   )
   protected void vmethod2048() throws Exception {
   }
}
