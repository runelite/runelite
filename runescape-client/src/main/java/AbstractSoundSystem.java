import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -397814515
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("n")
   @Export("audioHighMemory")
   protected static boolean audioHighMemory;
   @ObfuscatedName("x")
   static ScheduledExecutorService field1323;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -743750755
   )
   static int field1324;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lck;"
   )
   @Export("soundTaskDataProvider")
   static class89 soundTaskDataProvider;
   @ObfuscatedName("p")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ldu;"
   )
   TaskDataNode field1328;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -759205163
   )
   int field1329;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -913623916545243455L
   )
   long field1334;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2024020127
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -4910637
   )
   int field1322;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 700532029
   )
   int field1332;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -5023377774405903021L
   )
   long field1320;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -5737955
   )
   int field1326;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 741309427
   )
   int field1335;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1986148097
   )
   int field1337;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -5722049471560573075L
   )
   long field1338;
   @ObfuscatedName("o")
   boolean field1333;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1008236685
   )
   int field1340;
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "[Ldu;"
   )
   TaskDataNode[] field1341;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "[Ldu;"
   )
   TaskDataNode[] field1342;

   protected AbstractSoundSystem() {
      this.field1329 = 32;
      this.field1334 = class166.method3456();
      this.field1320 = 0L;
      this.field1326 = 0;
      this.field1335 = 0;
      this.field1337 = 0;
      this.field1338 = 0L;
      this.field1333 = true;
      this.field1340 = 0;
      this.field1341 = new TaskDataNode[8];
      this.field1342 = new TaskDataNode[8];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2011832996"
   )
   protected void vmethod2190() throws Exception {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "4"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1202910483"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("x")
   protected void write() throws Exception {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "82"
   )
   protected void close() {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2019010178"
   )
   protected void flush() throws Exception {
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Ldu;B)V",
      garbageValue = "102"
   )
   public final synchronized void method2226(TaskDataNode var1) {
      this.field1328 = var1;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1112855945"
   )
   public final synchronized void method2192() {
      if(this.samples != null) {
         long var1 = class166.method3456();

         try {
            if(0L != this.field1320) {
               if(var1 < this.field1320) {
                  return;
               }

               this.create(this.offset);
               this.field1320 = 0L;
               this.field1333 = true;
            }

            int var3 = this.size();
            if(this.field1337 - var3 > this.field1326) {
               this.field1326 = this.field1337 - var3;
            }

            int var4 = this.field1332 + this.field1322;
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
               this.field1333 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1332 = var4 - this.field1322;
               }
            }

            while(var3 < var4) {
               this.method2250(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1338) {
               if(!this.field1333) {
                  if(this.field1326 == 0 && this.field1335 == 0) {
                     this.close();
                     this.field1320 = 2000L + var1;
                     return;
                  }

                  this.field1332 = Math.min(this.field1335, this.field1326);
                  this.field1335 = this.field1326;
               } else {
                  this.field1333 = false;
               }

               this.field1326 = 0;
               this.field1338 = var1 + 2000L;
            }

            this.field1337 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1320 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1334) {
               var1 = this.field1334;
            }

            while(var1 > this.field1334 + 5000L) {
               this.method2196(256);
               this.field1334 += (long)(256000 / sampleRate);
            }
         } catch (Exception var6) {
            this.field1334 = var1;
         }

      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1529143507"
   )
   public final void method2193() {
      this.field1333 = true;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2058489673"
   )
   @Export("tryFlush")
   public final synchronized void tryFlush() {
      this.field1333 = true;

      try {
         this.flush();
      } catch (Exception var2) {
         this.close();
         this.field1320 = class166.method3456() + 2000L;
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "720259050"
   )
   @Export("shutdown")
   public final synchronized void shutdown() {
      if(class231.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class231.task.systems[var2]) {
               class231.task.systems[var2] = null;
            }

            if(class231.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1323.shutdownNow();
            field1323 = null;
            class231.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "29623"
   )
   final void method2196(int var1) {
      this.field1340 -= var1;
      if(this.field1340 < 0) {
         this.field1340 = 0;
      }

      if(this.field1328 != null) {
         this.field1328.vmethod4425(var1);
      }

   }

   @ObfuscatedName("ao")
   final void method2250(int[] var1, int var2) {
      int var3 = var2;
      if(audioHighMemory) {
         var3 = var2 << 1;
      }

      class193.method3935(var1, 0, var3);
      this.field1340 -= var2;
      if(this.field1328 != null && this.field1340 <= 0) {
         this.field1340 += sampleRate >> 4;
         WorldMapDecoration.method222(this.field1328);
         this.method2198(this.field1328, this.field1328.vmethod2484());
         int var4 = 0;
         int var5 = 255;

         int var6;
         TaskDataNode var10;
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
                  TaskDataNode var11 = this.field1341[var7];

                  label98:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label98;
                        }

                        AbstractIntegerNode0 var12 = var11.data;
                        if(var12 != null && var12.int1 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1407;
                        } else {
                           var11.field1409 = true;
                           int var13 = var11.vmethod4423();
                           var4 += var13;
                           if(var12 != null) {
                              var12.int1 += var13;
                           }

                           if(var4 >= this.field1329) {
                              break label104;
                           }

                           TaskDataNode var14 = var11.vmethod4421();
                           if(var14 != null) {
                              for(int var15 = var11.field1406; var14 != null; var14 = var11.vmethod4422()) {
                                 this.method2198(var14, var15 * var14.vmethod2484() >> 8);
                              }
                           }

                           TaskDataNode var18 = var11.field1407;
                           var11.field1407 = null;
                           if(var10 == null) {
                              this.field1341[var7] = var18;
                           } else {
                              var10.field1407 = var18;
                           }

                           if(var18 == null) {
                              this.field1342[var7] = var10;
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
            TaskDataNode var16 = this.field1341[var6];
            TaskDataNode[] var17 = this.field1341;
            this.field1342[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1407;
               var16.field1407 = null;
            }
         }
      }

      if(this.field1340 < 0) {
         this.field1340 = 0;
      }

      if(this.field1328 != null) {
         this.field1328.vmethod4424(var1, 0, var2);
      }

      this.field1334 = class166.method3456();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Ldu;II)V",
      garbageValue = "1162362988"
   )
   final void method2198(TaskDataNode var1, int var2) {
      int var3 = var2 >> 5;
      TaskDataNode var4 = this.field1342[var3];
      if(var4 == null) {
         this.field1341[var3] = var1;
      } else {
         var4.field1407 = var1;
      }

      this.field1342[var3] = var1;
      var1.field1406 = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1294539883"
   )
   public static final boolean method2208() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field348 == KeyFocusListener.field342) {
            return false;
         } else {
            WallObject.currentPressedKey = KeyFocusListener.field339[KeyFocusListener.field342];
            Occluder.currentTypedKey = KeyFocusListener.field344[KeyFocusListener.field342];
            KeyFocusListener.field342 = KeyFocusListener.field342 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2063770804"
   )
   static final void method2253() {
      Region.regionLowMemory = false;
      Client.lowMemory = false;
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(Lhl;B)I",
      garbageValue = "-40"
   )
   @Export("getWidgetClickMask")
   static int getWidgetClickMask(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.value:var0.clickMask;
   }
}
