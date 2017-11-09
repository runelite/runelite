import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -105628855
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("x")
   @Export("highMemory")
   protected static boolean highMemory;
   @ObfuscatedName("l")
   static ScheduledExecutorService field1546;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1735942221
   )
   @Export("priority")
   static int priority;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lct;"
   )
   public static class102 field1567;
   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   static IndexData field1563;
   @ObfuscatedName("w")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ldq;"
   )
   class118 field1552;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 576936463
   )
   int field1547;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -1820246566660358713L
   )
   long field1554;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1572634535
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1110200411
   )
   int field1544;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1331446895
   )
   int field1565;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 6497417554997482799L
   )
   long field1558;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1196247227
   )
   int field1559;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1734561563
   )
   int field1566;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1015883689
   )
   int field1561;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 2029917496837600993L
   )
   long field1562;
   @ObfuscatedName("q")
   boolean field1550;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -828271095
   )
   int field1564;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "[Ldq;"
   )
   class118[] field1556;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "[Ldq;"
   )
   class118[] field1549;

   protected AbstractSoundSystem() {
      this.field1547 = 32;
      this.field1554 = class268.currentTimeMs();
      this.field1558 = 0L;
      this.field1559 = 0;
      this.field1566 = 0;
      this.field1561 = 0;
      this.field1562 = 0L;
      this.field1550 = true;
      this.field1564 = 0;
      this.field1556 = new class118[8];
      this.field1549 = new class118[8];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1401334584"
   )
   protected void vmethod2113() throws Exception {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1790157393"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-753278569"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("j")
   protected void write() throws Exception {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1311794284"
   )
   protected void close() {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "123"
   )
   protected void vmethod2128() throws Exception {
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Ldq;I)V",
      garbageValue = "-719319312"
   )
   public final synchronized void method2105(class118 var1) {
      this.field1552 = var1;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "809781866"
   )
   public final synchronized void method2106() {
      if(this.samples != null) {
         long var1 = class268.currentTimeMs();

         try {
            if(0L != this.field1558) {
               if(var1 < this.field1558) {
                  return;
               }

               this.create(this.offset);
               this.field1558 = 0L;
               this.field1550 = true;
            }

            int var3 = this.size();
            if(this.field1561 - var3 > this.field1559) {
               this.field1559 = this.field1561 - var3;
            }

            int var4 = this.field1565 + this.field1544;
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
               this.field1550 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1565 = var4 - this.field1544;
               }
            }

            while(var3 < var4) {
               this.method2111(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1562) {
               if(!this.field1550) {
                  if(this.field1559 == 0 && this.field1566 == 0) {
                     this.close();
                     this.field1558 = 2000L + var1;
                     return;
                  }

                  this.field1565 = Math.min(this.field1566, this.field1559);
                  this.field1566 = this.field1559;
               } else {
                  this.field1550 = false;
               }

               this.field1559 = 0;
               this.field1562 = 2000L + var1;
            }

            this.field1561 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1558 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1554) {
               var1 = this.field1554;
            }

            while(var1 > this.field1554 + 5000L) {
               this.method2124(256);
               this.field1554 += (long)(256000 / sampleRate);
            }
         } catch (Exception var6) {
            this.field1554 = var1;
         }

      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "746455476"
   )
   public final void method2116() {
      this.field1550 = true;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2021104689"
   )
   public final synchronized void method2108() {
      this.field1550 = true;

      try {
         this.vmethod2128();
      } catch (Exception var2) {
         this.close();
         this.field1558 = class268.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1569634202"
   )
   public final synchronized void method2112() {
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
            field1546.shutdownNow();
            field1546 = null;
            task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1155071475"
   )
   final void method2124(int var1) {
      this.field1564 -= var1;
      if(this.field1564 < 0) {
         this.field1564 = 0;
      }

      if(this.field1552 != null) {
         this.field1552.vmethod4051(var1);
      }

   }

   @ObfuscatedName("ap")
   final void method2111(int[] var1, int var2) {
      int var3 = var2;
      if(highMemory) {
         var3 = var2 << 1;
      }

      class190.method3623(var1, 0, var3);
      this.field1564 -= var2;
      if(this.field1552 != null && this.field1564 <= 0) {
         this.field1564 += sampleRate >> 4;
         class81.method1699(this.field1552);
         this.method2129(this.field1552, this.field1552.vmethod2407());
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
                  class118 var11 = this.field1556[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        class121 var12 = var11.field1635;
                        if(var12 != null && var12.field1667 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1633;
                        } else {
                           var11.field1636 = true;
                           int var13 = var11.vmethod4068();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1667 += var13;
                           }

                           if(var4 >= this.field1547) {
                              break label104;
                           }

                           class118 var14 = var11.vmethod4047();
                           if(var14 != null) {
                              for(int var15 = var11.field1634; var14 != null; var14 = var11.vmethod4048()) {
                                 this.method2129(var14, var15 * var14.vmethod2407() >> 8);
                              }
                           }

                           class118 var18 = var11.field1633;
                           var11.field1633 = null;
                           if(var10 == null) {
                              this.field1556[var7] = var18;
                           } else {
                              var10.field1633 = var18;
                           }

                           if(var18 == null) {
                              this.field1549[var7] = var10;
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
            class118 var16 = this.field1556[var6];
            class118[] var17 = this.field1556;
            this.field1549[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1633;
               var16.field1633 = null;
            }
         }
      }

      if(this.field1564 < 0) {
         this.field1564 = 0;
      }

      if(this.field1552 != null) {
         this.field1552.vmethod4050(var1, 0, var2);
      }

      this.field1554 = class268.currentTimeMs();
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Ldq;IB)V",
      garbageValue = "91"
   )
   final void method2129(class118 var1, int var2) {
      int var3 = var2 >> 5;
      class118 var4 = this.field1549[var3];
      if(var4 == null) {
         this.field1556[var3] = var1;
      } else {
         var4.field1633 = var1;
      }

      this.field1549[var3] = var1;
      var1.field1634 = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "340854525"
   )
   static String method2157(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }
}
