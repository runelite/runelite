import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("AbstractSoundSystem")
public class AbstractSoundSystem {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 315819539
   )
   @Export("priority")
   static int priority;
   @ObfuscatedName("v")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldj;"
   )
   TaskDataNode field1519;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 623605133
   )
   int field1520;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 6942576047878252441L
   )
   long field1521;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -947771389
   )
   @Export("offset")
   int offset;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1500914289
   )
   int field1531;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1874726671
   )
   int field1524;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 5267518311043507009L
   )
   long field1533;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2116351025
   )
   int field1525;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1328199307
   )
   int field1527;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1549611011
   )
   int field1528;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -1201158554202080805L
   )
   long field1529;
   @ObfuscatedName("c")
   boolean field1530;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -568997033
   )
   int field1516;
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "[Ldj;"
   )
   TaskDataNode[] field1532;
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "[Ldj;"
   )
   TaskDataNode[] field1518;

   protected AbstractSoundSystem() {
      this.field1520 = 32;
      this.field1521 = ScriptVarType.currentTimeMs();
      this.field1533 = 0L;
      this.field1525 = 0;
      this.field1527 = 0;
      this.field1528 = 0;
      this.field1529 = 0L;
      this.field1530 = true;
      this.field1516 = 0;
      this.field1532 = new TaskDataNode[8];
      this.field1518 = new TaskDataNode[8];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1683722552"
   )
   protected void vmethod2190() throws Exception {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1068140209"
   )
   protected void create(int var1) throws Exception {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2128153695"
   )
   @Export("size")
   protected int size() throws Exception {
      return this.offset;
   }

   @ObfuscatedName("s")
   protected void write() throws Exception {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-627008747"
   )
   protected void close() {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-818336944"
   )
   protected void flush() throws Exception {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ldj;I)V",
      garbageValue = "1254296999"
   )
   public final synchronized void method2219(TaskDataNode var1) {
      this.field1519 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1505321756"
   )
   public final synchronized void method2184() {
      if(this.samples != null) {
         long var1 = ScriptVarType.currentTimeMs();

         try {
            if(this.field1533 != 0L) {
               if(var1 < this.field1533) {
                  return;
               }

               this.create(this.offset);
               this.field1533 = 0L;
               this.field1530 = true;
            }

            int var3 = this.size();
            if(this.field1528 - var3 > this.field1525) {
               this.field1525 = this.field1528 - var3;
            }

            int var4 = this.field1531 + this.field1524;
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
               this.field1530 = true;
               if(var4 + 256 > this.offset) {
                  var4 = this.offset - 256;
                  this.field1524 = var4 - this.field1531;
               }
            }

            while(var3 < var4) {
               this.method2188(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if(var1 > this.field1529) {
               if(!this.field1530) {
                  if(this.field1525 == 0 && this.field1527 == 0) {
                     this.close();
                     this.field1533 = 2000L + var1;
                     return;
                  }

                  this.field1524 = Math.min(this.field1527, this.field1525);
                  this.field1527 = this.field1525;
               } else {
                  this.field1530 = false;
               }

               this.field1525 = 0;
               this.field1529 = var1 + 2000L;
            }

            this.field1528 = var3;
         } catch (Exception var7) {
            this.close();
            this.field1533 = 2000L + var1;
         }

         try {
            if(var1 > this.field1521 + 500000L) {
               var1 = this.field1521;
            }

            while(var1 > this.field1521 + 5000L) {
               this.method2187(256);
               this.field1521 += (long)(256000 / class20.sampleRate);
            }
         } catch (Exception var6) {
            this.field1521 = var1;
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-52625115"
   )
   public final void method2214() {
      this.field1530 = true;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1265167650"
   )
   @Export("tryFlush")
   public final synchronized void tryFlush() {
      this.field1530 = true;

      try {
         this.flush();
      } catch (Exception var2) {
         this.close();
         this.field1533 = ScriptVarType.currentTimeMs() + 2000L;
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1133208412"
   )
   @Export("shutdown")
   public final synchronized void shutdown() {
      if(class188.task != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class188.task.systems[var2]) {
               class188.task.systems[var2] = null;
            }

            if(class188.task.systems[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            GrandExchangeOffer.field295.shutdownNow();
            GrandExchangeOffer.field295 = null;
            class188.task = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1465374535"
   )
   final void method2187(int var1) {
      this.field1516 -= var1;
      if(this.field1516 < 0) {
         this.field1516 = 0;
      }

      if(this.field1519 != null) {
         this.field1519.vmethod4144(var1);
      }

   }

   @ObfuscatedName("ar")
   final void method2188(int[] var1, int var2) {
      int var3 = var2;
      if(BoundingBox3DDrawMode.highMemory) {
         var3 = var2 << 1;
      }

      class194.method3713(var1, 0, var3);
      this.field1516 -= var2;
      if(this.field1519 != null && this.field1516 <= 0) {
         this.field1516 += class20.sampleRate >> 4;
         class173.method3300(this.field1519);
         this.method2189(this.field1519, this.field1519.vmethod2452());
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
                  TaskDataNode var11 = this.field1532[var7];

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
                           var11 = var11.field1599;
                        } else {
                           var11.field1598 = true;
                           int var13 = var11.vmethod4158();
                           var4 += var13;
                           if(var12 != null) {
                              var12.int1 += var13;
                           }

                           if(var4 >= this.field1520) {
                              break label104;
                           }

                           TaskDataNode var14 = var11.vmethod4155();
                           if(var14 != null) {
                              for(int var15 = var11.field1601; var14 != null; var14 = var11.vmethod4141()) {
                                 this.method2189(var14, var15 * var14.vmethod2452() >> 8);
                              }
                           }

                           TaskDataNode var18 = var11.field1599;
                           var11.field1599 = null;
                           if(var10 == null) {
                              this.field1532[var7] = var18;
                           } else {
                              var10.field1599 = var18;
                           }

                           if(var18 == null) {
                              this.field1518[var7] = var10;
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
            TaskDataNode var16 = this.field1532[var6];
            TaskDataNode[] var17 = this.field1532;
            this.field1518[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var10) {
               var10 = var16.field1599;
               var16.field1599 = null;
            }
         }
      }

      if(this.field1516 < 0) {
         this.field1516 = 0;
      }

      if(this.field1519 != null) {
         this.field1519.vmethod4145(var1, 0, var2);
      }

      this.field1521 = ScriptVarType.currentTimeMs();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ldj;II)V",
      garbageValue = "179666291"
   )
   final void method2189(TaskDataNode var1, int var2) {
      int var3 = var2 >> 5;
      TaskDataNode var4 = this.field1518[var3];
      if(var4 == null) {
         this.field1532[var3] = var1;
      } else {
         var4.field1599 = var1;
      }

      this.field1518[var3] = var1;
      var1.field1601 = var2;
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-5980992"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[MessageNode.plane][var0][var1];
      if(var2 == null) {
         class48.region.removeGroundItemPile(MessageNode.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = CombatInfo1.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class48.region.removeGroundItemPile(MessageNode.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var5.id != var6.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class48.region.addItemPile(MessageNode.plane, var0, var1, GameCanvas.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, MessageNode.plane), var5, var9, var11, var10);
         }
      }
   }
}
