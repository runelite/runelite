import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("e")
   @Export("highMemory")
   public static boolean highMemory;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "[Ldf;"
   )
   class119[] field1637;
   @ObfuscatedName("k")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("y")
   boolean field1634;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldf;"
   )
   class119 field1620;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -579648551
   )
   int field1635;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2074906693
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -427699297
   )
   int field1624;
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "[Ldf;"
   )
   class119[] field1636;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 3452401226045911279L
   )
   long field1629;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 4378540255574520613L
   )
   long field1623;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2110280625
   )
   int field1630;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1271254203
   )
   int field1632;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1414127629
   )
   int field1638;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -151993601
   )
   int field1631;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1810761185
   )
   int field1628;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -5936030697425360049L
   )
   long field1633;

   protected AbstractSoundSystem() {
      this.field1624 = 32;
      this.field1623 = class46.currentTimeMs();
      this.field1629 = 0L;
      this.field1630 = 0;
      this.field1638 = 0;
      this.field1632 = 0;
      this.field1633 = 0L;
      this.field1634 = true;
      this.field1635 = 0;
      this.field1636 = new class119[8];
      this.field1637 = new class119[8];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1605457436"
   )
   protected void vmethod1997() throws Exception {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "55"
   )
   protected void close() {
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1732562430"
   )
   public final synchronized void method1985() {
      if(this.samples != null) {
         long var1 = class46.currentTimeMs();

         try {
            if(this.field1629 != 0L) {
               if(var1 < this.field1629) {
                  return;
               }

               this.create(this.offset);
               this.field1629 = 0L;
               this.field1634 = true;
            }

            int var3 = this.size();
            if(this.field1632 - var3 > this.field1630) {
               this.field1630 = this.field1632 - var3;
            }

            int var4 = this.field1631 + this.field1628;
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
               this.field1634 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1628 = var4 - this.field1631;
               }
            }

            while(var3 < var4) {
               this.method1990(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1633) {
               if(!this.field1634) {
                  if(this.field1630 == 0 && this.field1638 == 0) {
                     this.close();
                     this.field1629 = var1 + 2000L;
                     return;
                  }

                  this.field1628 = Math.min(this.field1638, this.field1630);
                  this.field1638 = this.field1630;
               } else {
                  this.field1634 = false;
               }

               this.field1630 = 0;
               this.field1633 = 2000L + var1;
            }

            this.field1632 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1629 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1623) {
               var1 = this.field1623;
            }

            while(var1 > this.field1623 + 5000L) {
               this.method1989(256);
               this.field1623 += (long)(256000 / ChatLineBuffer.sampleRate);
            }
         } catch (Exception var6) {
            this.field1623 = var1;
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1959206863"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-17"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1088661208"
   )
   public final synchronized void method1987() {
      this.field1634 = true;

      try {
         this.vmethod1997();
      } catch (Exception var2) {
         this.close();
         this.field1629 = class46.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   final void method1989(int var1) {
      this.field1635 -= var1;
      if(this.field1635 < 0) {
         this.field1635 = 0;
      }

      if(this.field1620 != null) {
         this.field1620.vmethod3869(var1);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ldf;II)V",
      garbageValue = "982288994"
   )
   final void method2022(class119 var1, int var2) {
      int var3 = var2 >> 5;
      class119 var4 = this.field1637[var3];
      if(var4 == null) {
         this.field1636[var3] = var1;
      } else {
         var4.field1705 = var1;
      }

      this.field1637[var3] = var1;
      var1.field1704 = var2;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-383466790"
   )
   public final synchronized void method1988() {
      if(class24.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class24.task.systems[var2]) {
               class24.task.systems[var2] = null;
            }

            if(class24.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class280.field3754.shutdownNow();
            class280.field3754 = null;
            class24.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2075709891"
   )
   public final void method2030() {
      this.field1634 = true;
   }

   @ObfuscatedName("aa")
   final void method1990(int[] var1, int var2) {
      int var3 = var2;
      if(highMemory) {
         var3 = var2 << 1;
      }

      class183.method3438(var1, 0, var3);
      this.field1635 -= var2;
      if(this.field1620 != null && this.field1635 <= 0) {
         this.field1635 += ChatLineBuffer.sampleRate >> 4;
         class61.method1077(this.field1620);
         this.method2022(this.field1620, this.field1620.vmethod2292());
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
                  class119 var11 = this.field1636[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        class122 var12 = var11.field1706;
                        if(var12 != null && var12.field1738 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1705;
                        } else {
                           var11.field1707 = true;
                           int var13 = var11.vmethod3871();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1738 += var13;
                           }

                           if(var4 >= this.field1624) {
                              break label104;
                           }

                           class119 var14 = var11.vmethod3883();
                           if(var14 != null) {
                              for(int var15 = var11.field1704; var14 != null; var14 = var11.vmethod3882()) {
                                 this.method2022(var14, var15 * var14.vmethod2292() >> 8);
                              }
                           }

                           class119 var18 = var11.field1705;
                           var11.field1705 = null;
                           if(var10 == null) {
                              this.field1636[var7] = var18;
                           } else {
                              var10.field1705 = var18;
                           }

                           if(var18 == null) {
                              this.field1637[var7] = var10;
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
            class119 var16 = this.field1636[var6];
            class119[] var17 = this.field1636;
            this.field1637[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1705;
               var16.field1705 = null;
            }
         }
      }

      if(this.field1635 < 0) {
         this.field1635 = 0;
      }

      if(this.field1620 != null) {
         this.field1620.vmethod3872(var1, 0, var2);
      }

      this.field1623 = class46.currentTimeMs();
   }

   @ObfuscatedName("r")
   protected void write() throws Exception {
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Ldf;B)V",
      garbageValue = "115"
   )
   public final synchronized void method1984(class119 var1) {
      this.field1620 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "52"
   )
   protected void vmethod1992() throws Exception {
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(Lhy;I)Z",
      garbageValue = "2056681027"
   )
   static final boolean method2039(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = class2.method4(var0, var1);
            int var3 = var0.field2654[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Lbv;",
      garbageValue = "-20"
   )
   static MessageNode method2025(int var0) {
      return (MessageNode)class98.field1520.method3482((long)var0);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-84503667"
   )
   public static boolean method2040(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
