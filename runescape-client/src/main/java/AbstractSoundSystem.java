import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = 1498735235
   )
   static int field1524;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1640349731
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lck;"
   )
   @Export("soundTaskDataProvider")
   public static TaskDataProvider soundTaskDataProvider;
   @ObfuscatedName("v")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ldn;"
   )
   TaskDataNode field1514;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1086367849
   )
   int field1515;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 300669682327017323L
   )
   long field1516;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2098764603
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -141272957
   )
   int field1519;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 233885597
   )
   int field1520;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 2304199028185896667L
   )
   long field1528;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 658303721
   )
   int field1521;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1833238455
   )
   int field1529;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1662839781
   )
   int field1523;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 4982542903384797105L
   )
   long field1511;
   @ObfuscatedName("i")
   boolean field1525;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1869977847
   )
   int field1526;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "[Ldn;"
   )
   TaskDataNode[] field1527;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "[Ldn;"
   )
   TaskDataNode[] field1517;

   protected AbstractSoundSystem() {
      this.field1515 = 32;
      this.field1516 = class188.currentTimeMs();
      this.field1528 = 0L;
      this.field1521 = 0;
      this.field1529 = 0;
      this.field1523 = 0;
      this.field1511 = 0L;
      this.field1525 = true;
      this.field1526 = 0;
      this.field1527 = new TaskDataNode[8];
      this.field1517 = new TaskDataNode[8];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "849505812"
   )
   protected void vmethod2209() throws Exception {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-84"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1337442219"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("p")
   protected void write() throws Exception {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-359113654"
   )
   protected void close() {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "2686"
   )
   protected void flush() throws Exception {
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Ldn;I)V",
      garbageValue = "22513026"
   )
   public final synchronized void method2202(TaskDataNode var1) {
      this.field1514 = var1;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public final synchronized void method2203() {
      if(this.samples != null) {
         long var1 = class188.currentTimeMs();

         try {
            if(this.field1528 != 0L) {
               if(var1 < this.field1528) {
                  return;
               }

               this.create(this.offset);
               this.field1528 = 0L;
               this.field1525 = true;
            }

            int var3 = this.size();
            if(this.field1523 - var3 > this.field1521) {
               this.field1521 = this.field1523 - var3;
            }

            int var4 = this.field1519 + this.field1520;
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
               this.field1525 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1520 = var4 - this.field1519;
               }
            }

            while(var3 < var4) {
               this.method2229(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1511) {
               if(!this.field1525) {
                  if(this.field1521 == 0 && this.field1529 == 0) {
                     this.close();
                     this.field1528 = var1 + 2000L;
                     return;
                  }

                  this.field1520 = Math.min(this.field1529, this.field1521);
                  this.field1529 = this.field1521;
               } else {
                  this.field1525 = false;
               }

               this.field1521 = 0;
               this.field1511 = var1 + 2000L;
            }

            this.field1523 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1528 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1516) {
               var1 = this.field1516;
            }

            while(var1 > 5000L + this.field1516) {
               this.method2207(256);
               this.field1516 += (long)(256000 / sampleRate);
            }
         } catch (Exception var6) {
            this.field1516 = var1;
         }

      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "80"
   )
   public final void method2216() {
      this.field1525 = true;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "827863784"
   )
   @Export("tryFlush")
   public final synchronized void tryFlush() {
      this.field1525 = true;

      try {
         this.flush();
      } catch (Exception var2) {
         this.close();
         this.field1528 = class188.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "479453502"
   )
   @Export("shutdown")
   public final synchronized void shutdown() {
      if(BoundingBox2D.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == BoundingBox2D.task.systems[var2]) {
               BoundingBox2D.task.systems[var2] = null;
            }

            if(BoundingBox2D.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class40.field505.shutdownNow();
            class40.field505 = null;
            BoundingBox2D.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "670849288"
   )
   final void method2207(int var1) {
      this.field1526 -= var1;
      if(this.field1526 < 0) {
         this.field1526 = 0;
      }

      if(this.field1514 != null) {
         this.field1514.vmethod4328(var1);
      }

   }

   @ObfuscatedName("az")
   final void method2229(int[] var1, int var2) {
      int var3 = var2;
      if(Frames.audioHighMemory) {
         var3 = var2 << 1;
      }

      class203.method3906(var1, 0, var3);
      this.field1526 -= var2;
      if(this.field1514 != null && this.field1526 <= 0) {
         this.field1526 += sampleRate >> 4;
         class239.method4485(this.field1514);
         this.method2221(this.field1514, this.field1514.vmethod2480());
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
                  TaskDataNode var11 = this.field1527[var7];

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
                           var11 = var11.field1600;
                        } else {
                           var11.field1603 = true;
                           int var13 = var11.vmethod4326();
                           var4 += var13;
                           if(var12 != null) {
                              var12.int1 += var13;
                           }

                           if(var4 >= this.field1515) {
                              break label104;
                           }

                           TaskDataNode var14 = var11.vmethod4324();
                           if(var14 != null) {
                              for(int var15 = var11.field1602; var14 != null; var14 = var11.vmethod4323()) {
                                 this.method2221(var14, var15 * var14.vmethod2480() >> 8);
                              }
                           }

                           TaskDataNode var18 = var11.field1600;
                           var11.field1600 = null;
                           if(var10 == null) {
                              this.field1527[var7] = var18;
                           } else {
                              var10.field1600 = var18;
                           }

                           if(var18 == null) {
                              this.field1517[var7] = var10;
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
            TaskDataNode var16 = this.field1527[var6];
            TaskDataNode[] var17 = this.field1527;
            this.field1517[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1600;
               var16.field1600 = null;
            }
         }
      }

      if(this.field1526 < 0) {
         this.field1526 = 0;
      }

      if(this.field1514 != null) {
         this.field1514.vmethod4344(var1, 0, var2);
      }

      this.field1516 = class188.currentTimeMs();
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Ldn;II)V",
      garbageValue = "-1836983200"
   )
   final void method2221(TaskDataNode var1, int var2) {
      int var3 = var2 >> 5;
      TaskDataNode var4 = this.field1517[var3];
      if(var4 == null) {
         this.field1527[var3] = var1;
      } else {
         var4.field1600 = var1;
      }

      this.field1517[var3] = var1;
      var1.field1602 = var2;
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-564693961"
   )
   static final void method2232(int var0) {
      NetWriter.method2041();
      ItemLayer.method2599();
      int var1 = PendingSpawn.method1617(var0).configType;
      if(var1 != 0) {
         int var2 = class231.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var2 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var2 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var2 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
            }

            ISAACCipher.method3879();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field971) {
               if(Client.field971 == 0 && Client.field1015 != -1) {
                  class152.method3129(class155.indexTrack1, Client.field1015, 0, var3, false);
                  Client.field1039 = false;
               } else if(var3 == 0) {
                  class155.field2105.method4140();
                  class223.field2646 = 1;
                  Huffman.field2471 = null;
                  Client.field1039 = false;
               } else if(class223.field2646 != 0) {
                  class223.field2645 = var3;
               } else {
                  class155.field2105.method4134(var3);
               }

               Client.field971 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field1040 = 127;
            }

            if(var2 == 1) {
               Client.field1040 = 96;
            }

            if(var2 == 2) {
               Client.field1040 = 64;
            }

            if(var2 == 3) {
               Client.field1040 = 32;
            }

            if(var2 == 4) {
               Client.field1040 = 0;
            }
         }

         if(var1 == 5) {
            Client.field940 = var2;
         }

         if(var1 == 6) {
            Client.field965 = var2;
         }

         if(var1 == 9) {
            Client.field966 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field1041 = 127;
            }

            if(var2 == 1) {
               Client.field1041 = 96;
            }

            if(var2 == 2) {
               Client.field1041 = 64;
            }

            if(var2 == 3) {
               Client.field1041 = 32;
            }

            if(var2 == 4) {
               Client.field1041 = 0;
            }
         }

         if(var1 == 17) {
            Client.field996 = var2 & 65535;
         }

         AttackOption[] var4;
         if(var1 == 18) {
            var4 = new AttackOption[]{AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_hidden};
            Client.playerAttackOption = (AttackOption)Tile.forOrdinal(var4, var2);
            if(Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field972 = -1;
            } else {
               Client.field972 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            var4 = new AttackOption[]{AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_hidden};
            Client.npcAttackOption = (AttackOption)Tile.forOrdinal(var4, var2);
            if(Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }
}
