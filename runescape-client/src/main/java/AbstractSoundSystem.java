import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -464310723
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("f")
   @Export("highMemory")
   protected static boolean highMemory;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 113846885
   )
   @Export("priority")
   static int priority;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldj;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lcu;"
   )
   public static class102 field1540;
   @ObfuscatedName("q")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   class118 field1542;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1014254083
   )
   int field1543;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 2815018585731230049L
   )
   long field1544;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -189606179
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -782733753
   )
   int field1546;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1424151855
   )
   int field1554;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 4577637123992117291L
   )
   long field1536;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -351344531
   )
   int field1535;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 179550143
   )
   int field1550;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1081680643
   )
   int field1552;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 6756067448418068989L
   )
   long field1547;
   @ObfuscatedName("w")
   boolean field1553;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -164062727
   )
   int field1548;
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "[Ldk;"
   )
   class118[] field1551;
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "[Ldk;"
   )
   class118[] field1556;

   protected AbstractSoundSystem() {
      this.field1543 = 32;
      this.field1544 = ChatLineBuffer.currentTimeMs();
      this.field1536 = 0L;
      this.field1535 = 0;
      this.field1550 = 0;
      this.field1552 = 0;
      this.field1547 = 0L;
      this.field1553 = true;
      this.field1548 = 0;
      this.field1551 = new class118[8];
      this.field1556 = new class118[8];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1496162243"
   )
   protected void vmethod2029() throws Exception {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "26676"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1040714578"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("g")
   protected void write() throws Exception {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-5"
   )
   protected void close() {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "901570304"
   )
   protected void vmethod2034() throws Exception {
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ldk;B)V",
      garbageValue = "12"
   )
   public final synchronized void method2021(class118 var1) {
      this.field1542 = var1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "295635402"
   )
   public final synchronized void method2069() {
      if(this.samples != null) {
         long var1 = ChatLineBuffer.currentTimeMs();

         try {
            if(0L != this.field1536) {
               if(var1 < this.field1536) {
                  return;
               }

               this.create(this.offset);
               this.field1536 = 0L;
               this.field1553 = true;
            }

            int var3 = this.size();
            if(this.field1552 - var3 > this.field1535) {
               this.field1535 = this.field1552 - var3;
            }

            int var4 = this.field1546 + this.field1554;
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
               this.field1553 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1554 = var4 - this.field1546;
               }
            }

            while(var3 < var4) {
               this.method2038(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1547) {
               if(!this.field1553) {
                  if(this.field1535 == 0 && this.field1550 == 0) {
                     this.close();
                     this.field1536 = var1 + 2000L;
                     return;
                  }

                  this.field1554 = Math.min(this.field1550, this.field1535);
                  this.field1550 = this.field1535;
               } else {
                  this.field1553 = false;
               }

               this.field1535 = 0;
               this.field1547 = 2000L + var1;
            }

            this.field1552 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1536 = var1 + 2000L;
         }

         try {
            if(var1 > this.field1544 + 500000L) {
               var1 = this.field1544;
            }

            while(var1 > 5000L + this.field1544) {
               this.method2026(256);
               this.field1544 += (long)(256000 / sampleRate);
            }
         } catch (Exception var6) {
            this.field1544 = var1;
         }

      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1518608244"
   )
   public final void method2023() {
      this.field1553 = true;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public final synchronized void method2024() {
      this.field1553 = true;

      try {
         this.vmethod2034();
      } catch (Exception var2) {
         this.close();
         this.field1536 = ChatLineBuffer.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2036262335"
   )
   public final synchronized void method2046() {
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
            FaceNormal.field2035.shutdownNow();
            FaceNormal.field2035 = null;
            task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "60"
   )
   final void method2026(int var1) {
      this.field1548 -= var1;
      if(this.field1548 < 0) {
         this.field1548 = 0;
      }

      if(this.field1542 != null) {
         this.field1542.vmethod3927(var1);
      }

   }

   @ObfuscatedName("am")
   final void method2038(int[] var1, int var2) {
      int var3 = var2;
      if(highMemory) {
         var3 = var2 << 1;
      }

      class190.method3515(var1, 0, var3);
      this.field1548 -= var2;
      if(this.field1542 != null && this.field1548 <= 0) {
         this.field1548 += sampleRate >> 4;
         Actor.method1498(this.field1542);
         this.method2028(this.field1542, this.field1542.vmethod2311());
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
                  class118 var11 = this.field1551[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        class121 var12 = var11.field1630;
                        if(var12 != null && var12.field1662 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1631;
                        } else {
                           var11.field1628 = true;
                           int var13 = var11.vmethod3925();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1662 += var13;
                           }

                           if(var4 >= this.field1543) {
                              break label104;
                           }

                           class118 var14 = var11.vmethod3931();
                           if(var14 != null) {
                              for(int var15 = var11.field1629; var14 != null; var14 = var11.vmethod3946()) {
                                 this.method2028(var14, var15 * var14.vmethod2311() >> 8);
                              }
                           }

                           class118 var18 = var11.field1631;
                           var11.field1631 = null;
                           if(var10 == null) {
                              this.field1551[var7] = var18;
                           } else {
                              var10.field1631 = var18;
                           }

                           if(var18 == null) {
                              this.field1556[var7] = var10;
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
            class118 var16 = this.field1551[var6];
            class118[] var17 = this.field1551;
            this.field1556[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1631;
               var16.field1631 = null;
            }
         }
      }

      if(this.field1548 < 0) {
         this.field1548 = 0;
      }

      if(this.field1542 != null) {
         this.field1542.vmethod3926(var1, 0, var2);
      }

      this.field1544 = ChatLineBuffer.currentTimeMs();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Ldk;II)V",
      garbageValue = "1601370189"
   )
   final void method2028(class118 var1, int var2) {
      int var3 = var2 >> 5;
      class118 var4 = this.field1556[var3];
      if(var4 == null) {
         this.field1551[var3] = var1;
      } else {
         var4.field1631 = var1;
      }

      this.field1556[var3] = var1;
      var1.field1629 = var2;
   }
}
