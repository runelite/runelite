import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1385562627
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("t")
   static ScheduledExecutorService field1622;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "[Ldz;"
   )
   class121[] field1620;
   @ObfuscatedName("p")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("j")
   boolean field1630;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   class121 field1619;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 417852953
   )
   int field1631;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 324818283
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1353667003
   )
   int field1618;
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "[Ldz;"
   )
   class121[] field1632;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 6608270102751499047L
   )
   long field1625;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -8516031701922993873L
   )
   long field1621;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1204011043
   )
   int field1626;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -27545887
   )
   int field1628;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 885841813
   )
   int field1627;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -778790409
   )
   int field1623;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -180319161
   )
   int field1624;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -968285332397559361L
   )
   long field1629;

   protected AbstractSoundSystem() {
      this.field1618 = 32;
      this.field1621 = BuildType.currentTimeMs();
      this.field1625 = 0L;
      this.field1626 = 0;
      this.field1627 = 0;
      this.field1628 = 0;
      this.field1629 = 0L;
      this.field1630 = true;
      this.field1631 = 0;
      this.field1632 = new class121[8];
      this.field1620 = new class121[8];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1362352874"
   )
   protected void vmethod2089() throws Exception {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-526456117"
   )
   protected void close() {
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1502157451"
   )
   public final synchronized void method2077() {
      if(this.samples != null) {
         long var1 = BuildType.currentTimeMs();

         try {
            if(0L != this.field1625) {
               if(var1 < this.field1625) {
                  return;
               }

               this.create(this.offset);
               this.field1625 = 0L;
               this.field1630 = true;
            }

            int var3 = this.size();
            if(this.field1628 - var3 > this.field1626) {
               this.field1626 = this.field1628 - var3;
            }

            int var4 = this.field1623 + this.field1624;
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
               this.field1630 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1624 = var4 - this.field1623;
               }
            }

            while(var3 < var4) {
               this.method2082(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1629) {
               if(!this.field1630) {
                  if(this.field1626 == 0 && this.field1627 == 0) {
                     this.close();
                     this.field1625 = 2000L + var1;
                     return;
                  }

                  this.field1624 = Math.min(this.field1627, this.field1626);
                  this.field1627 = this.field1626;
               } else {
                  this.field1630 = false;
               }

               this.field1626 = 0;
               this.field1629 = 2000L + var1;
            }

            this.field1628 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1625 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1621) {
               var1 = this.field1621;
            }

            while(var1 > 5000L + this.field1621) {
               this.method2104(256);
               this.field1621 += (long)(256000 / sampleRate);
            }
         } catch (Exception var6) {
            this.field1621 = var1;
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "57"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-33"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1188910866"
   )
   final void method2104(int var1) {
      this.field1631 -= var1;
      if(this.field1631 < 0) {
         this.field1631 = 0;
      }

      if(this.field1619 != null) {
         this.field1619.vmethod3898(var1);
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-62"
   )
   public final synchronized void method2079() {
      this.field1630 = true;

      try {
         this.vmethod2089();
      } catch (Exception var2) {
         this.close();
         this.field1625 = BuildType.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Ldz;IB)V",
      garbageValue = "-122"
   )
   final void method2083(class121 var1, int var2) {
      int var3 = var2 >> 5;
      class121 var4 = this.field1620[var3];
      if(var4 == null) {
         this.field1632[var3] = var1;
      } else {
         var4.field1709 = var1;
      }

      this.field1620[var3] = var1;
      var1.field1707 = var2;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2139737389"
   )
   public final synchronized void method2080() {
      if(task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == task.systems[var2]) {
               task.systems[var2] = null;
            }

            if(task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1622.shutdownNow();
            field1622 = null;
            task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "360101606"
   )
   public final void method2130() {
      this.field1630 = true;
   }

   @ObfuscatedName("ad")
   final void method2082(int[] var1, int var2) {
      int var3 = var2;
      if(XClanMember.highMemory) {
         var3 = var2 << 1;
      }

      class183.method3507(var1, 0, var3);
      this.field1631 -= var2;
      if(this.field1619 != null && this.field1631 <= 0) {
         this.field1631 += sampleRate >> 4;
         Varcs.method1835(this.field1619);
         this.method2083(this.field1619, this.field1619.vmethod2352());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class121 var10;
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
                  class121 var11 = this.field1632[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        class124 var12 = var11.field1706;
                        if(var12 != null && var12.field1740 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1709;
                        } else {
                           var11.field1708 = true;
                           int var13 = var11.vmethod3916();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1740 += var13;
                           }

                           if(var4 >= this.field1618) {
                              break label104;
                           }

                           class121 var14 = var11.vmethod3913();
                           if(var14 != null) {
                              for(int var15 = var11.field1707; var14 != null; var14 = var11.vmethod3895()) {
                                 this.method2083(var14, var15 * var14.vmethod2352() >> 8);
                              }
                           }

                           class121 var18 = var11.field1709;
                           var11.field1709 = null;
                           if(var10 == null) {
                              this.field1632[var7] = var18;
                           } else {
                              var10.field1709 = var18;
                           }

                           if(var18 == null) {
                              this.field1620[var7] = var10;
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
            class121 var16 = this.field1632[var6];
            class121[] var17 = this.field1632;
            this.field1620[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1709;
               var16.field1709 = null;
            }
         }
      }

      if(this.field1631 < 0) {
         this.field1631 = 0;
      }

      if(this.field1619 != null) {
         this.field1619.vmethod3897(var1, 0, var2);
      }

      this.field1621 = BuildType.currentTimeMs();
   }

   @ObfuscatedName("y")
   protected void write() throws Exception {
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Ldz;B)V",
      garbageValue = "86"
   )
   public final synchronized void method2114(class121 var1) {
      this.field1619 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1385995989"
   )
   protected void vmethod2084() throws Exception {
   }
}
