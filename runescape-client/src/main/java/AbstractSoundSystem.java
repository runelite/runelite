import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2115451867
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("v")
   @Export("highMemory")
   public static boolean highMemory;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lcs;"
   )
   static class101 field1618;
   @ObfuscatedName("t")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   class117 field1631;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1136552967
   )
   int field1629;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -6640341752487438887L
   )
   long field1622;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1648554745
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 48437665
   )
   int field1628;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1472768785
   )
   int field1624;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 215130904572681017L
   )
   long field1626;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1848090313
   )
   int field1627;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -437750139
   )
   int field1621;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -844380605
   )
   int field1633;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 2963975151929951963L
   )
   long field1630;
   @ObfuscatedName("f")
   boolean field1634;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1385062951
   )
   int field1616;
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "[Ldm;"
   )
   class117[] field1625;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "[Ldm;"
   )
   class117[] field1632;

   protected AbstractSoundSystem() {
      this.field1629 = 32;
      this.field1622 = class174.currentTimeMs();
      this.field1626 = 0L;
      this.field1627 = 0;
      this.field1621 = 0;
      this.field1633 = 0;
      this.field1630 = 0L;
      this.field1634 = true;
      this.field1616 = 0;
      this.field1625 = new class117[8];
      this.field1632 = new class117[8];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   protected void vmethod2104() throws Exception {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "53"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-64"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("o")
   protected void write() throws Exception {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1706331776"
   )
   protected void close() {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "37"
   )
   protected void vmethod2099() throws Exception {
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ldm;B)V",
      garbageValue = "-63"
   )
   public final synchronized void method2068(class117 var1) {
      this.field1631 = var1;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-173028372"
   )
   public final synchronized void method2059() {
      if(this.samples != null) {
         long var1 = class174.currentTimeMs();

         try {
            if(0L != this.field1626) {
               if(var1 < this.field1626) {
                  return;
               }

               this.create(this.offset);
               this.field1626 = 0L;
               this.field1634 = true;
            }

            int var3 = this.size();
            if(this.field1633 - var3 > this.field1627) {
               this.field1627 = this.field1633 - var3;
            }

            int var4 = this.field1628 + this.field1624;
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
                  this.field1624 = var4 - this.field1628;
               }
            }

            while(var3 < var4) {
               this.method2082(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1630) {
               if(!this.field1634) {
                  if(this.field1627 == 0 && this.field1621 == 0) {
                     this.close();
                     this.field1626 = var1 + 2000L;
                     return;
                  }

                  this.field1624 = Math.min(this.field1621, this.field1627);
                  this.field1621 = this.field1627;
               } else {
                  this.field1634 = false;
               }

               this.field1627 = 0;
               this.field1630 = 2000L + var1;
            }

            this.field1633 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1626 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1622) {
               var1 = this.field1622;
            }

            while(var1 > this.field1622 + 5000L) {
               this.method2063(256);
               this.field1622 += (long)(256000 / sampleRate);
            }
         } catch (Exception var6) {
            this.field1622 = var1;
         }

      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   public final void method2089() {
      this.field1634 = true;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public final synchronized void method2061() {
      this.field1634 = true;

      try {
         this.vmethod2099();
      } catch (Exception var2) {
         this.close();
         this.field1626 = class174.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public final synchronized void method2062() {
      if(Varcs.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == Varcs.task.systems[var2]) {
               Varcs.task.systems[var2] = null;
            }

            if(Varcs.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class51.field682.shutdownNow();
            class51.field682 = null;
            Varcs.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2077218127"
   )
   final void method2063(int var1) {
      this.field1616 -= var1;
      if(this.field1616 < 0) {
         this.field1616 = 0;
      }

      if(this.field1631 != null) {
         this.field1631.vmethod3981(var1);
      }

   }

   @ObfuscatedName("at")
   final void method2082(int[] var1, int var2) {
      int var3 = var2;
      if(highMemory) {
         var3 = var2 << 1;
      }

      class183.method3544(var1, 0, var3);
      this.field1616 -= var2;
      if(this.field1631 != null && this.field1616 <= 0) {
         this.field1616 += sampleRate >> 4;
         class9.method53(this.field1631);
         this.method2065(this.field1631, this.field1631.vmethod2359());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class117 var10;
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
                  class117 var11 = this.field1625[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        class120 var12 = var11.field1705;
                        if(var12 != null && var12.field1737 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1703;
                        } else {
                           var11.field1704 = true;
                           int var13 = var11.vmethod3974();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1737 += var13;
                           }

                           if(var4 >= this.field1629) {
                              break label104;
                           }

                           class117 var14 = var11.vmethod3966();
                           if(var14 != null) {
                              for(int var15 = var11.field1706; var14 != null; var14 = var11.vmethod3967()) {
                                 this.method2065(var14, var15 * var14.vmethod2359() >> 8);
                              }
                           }

                           class117 var18 = var11.field1703;
                           var11.field1703 = null;
                           if(var10 == null) {
                              this.field1625[var7] = var18;
                           } else {
                              var10.field1703 = var18;
                           }

                           if(var18 == null) {
                              this.field1632[var7] = var10;
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
            class117 var16 = this.field1625[var6];
            class117[] var17 = this.field1625;
            this.field1632[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1703;
               var16.field1703 = null;
            }
         }
      }

      if(this.field1616 < 0) {
         this.field1616 = 0;
      }

      if(this.field1631 != null) {
         this.field1631.vmethod3968(var1, 0, var2);
      }

      this.field1622 = class174.currentTimeMs();
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Ldm;II)V",
      garbageValue = "-1109006787"
   )
   final void method2065(class117 var1, int var2) {
      int var3 = var2 >> 5;
      class117 var4 = this.field1632[var3];
      if(var4 == null) {
         this.field1625[var3] = var1;
      } else {
         var4.field1703 = var1;
      }

      this.field1632[var3] = var1;
      var1.field1706 = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lip;Lip;ZLjh;I)V",
      garbageValue = "494757002"
   )
   public static void method2115(IndexDataBase var0, IndexDataBase var1, boolean var2, Font var3) {
      ItemComposition.item_ref = var0;
      ItemComposition.field3491 = var1;
      ItemComposition.isMembersWorld = var2;
      class33.field483 = ItemComposition.item_ref.fileCount(10);
      class114.field1673 = var3;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "610577114"
   )
   protected static final void method2116() {
      DynamicObject.timer.vmethod3029();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field714[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field716[var0] = 0L;
      }

      GameEngine.field710 = 0;
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(Lhj;III)V",
      garbageValue = "-2047211995"
   )
   static void method2114(Widget var0, int var1, int var2) {
      if(var0.field2647 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2647 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2647 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2647 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2647 == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var0.originalX * var1 >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2732 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2732 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.field2732 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2732 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2732 == 4) {
         var0.relativeY = (var2 * var0.originalY >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field1084 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.relativeY + var0.height > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }
}
