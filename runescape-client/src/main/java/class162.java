import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class162 implements Runnable {
   @ObfuscatedName("qi")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("indexStore255")
   static IndexFile indexStore255;
   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "[Llm;"
   )
   @Export("headIconsPrayer")
   static SpritePixels[] headIconsPrayer;
   @ObfuscatedName("b")
   Thread field2134;
   @ObfuscatedName("q")
   InputStream field2135;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -904500697
   )
   int field2137;
   @ObfuscatedName("p")
   byte[] field2139;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -888526145
   )
   int field2136;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -981908387
   )
   int field2138;
   @ObfuscatedName("l")
   IOException field2140;

   class162(InputStream var1, int var2) {
      this.field2136 = 0;
      this.field2138 = 0;
      this.field2135 = var1;
      this.field2137 = var2 + 1;
      this.field2139 = new byte[this.field2137];
      this.field2134 = new Thread(this);
      this.field2134.setDaemon(true);
      this.field2134.start();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   boolean method3194(int var1) throws IOException {
      if(var1 == 0) {
         return true;
      } else if(var1 > 0 && var1 < this.field2137) {
         synchronized(this) {
            int var3;
            if(this.field2136 <= this.field2138) {
               var3 = this.field2138 - this.field2136;
            } else {
               var3 = this.field2137 - this.field2136 + this.field2138;
            }

            if(var3 < var1) {
               if(this.field2140 != null) {
                  throw new IOException(this.field2140.toString());
               } else {
                  this.notifyAll();
                  return false;
               }
            } else {
               return true;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1701694856"
   )
   int method3195() throws IOException {
      synchronized(this) {
         int var2;
         if(this.field2136 <= this.field2138) {
            var2 = this.field2138 - this.field2136;
         } else {
            var2 = this.field2137 - this.field2136 + this.field2138;
         }

         if(var2 <= 0 && this.field2140 != null) {
            throw new IOException(this.field2140.toString());
         } else {
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "151338373"
   )
   int method3219() throws IOException {
      synchronized(this) {
         if(this.field2136 == this.field2138) {
            if(this.field2140 != null) {
               throw new IOException(this.field2140.toString());
            } else {
               return -1;
            }
         } else {
            int var2 = this.field2139[this.field2136] & 255;
            this.field2136 = (this.field2136 + 1) % this.field2137;
            this.notifyAll();
            return var2;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "517599735"
   )
   int method3196(byte[] var1, int var2, int var3) throws IOException {
      if(var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
         synchronized(this) {
            int var5;
            if(this.field2136 <= this.field2138) {
               var5 = this.field2138 - this.field2136;
            } else {
               var5 = this.field2137 - this.field2136 + this.field2138;
            }

            if(var3 > var5) {
               var3 = var5;
            }

            if(var3 == 0 && this.field2140 != null) {
               throw new IOException(this.field2140.toString());
            } else {
               if(var3 + this.field2136 <= this.field2137) {
                  System.arraycopy(this.field2139, this.field2136, var1, var2, var3);
               } else {
                  int var6 = this.field2137 - this.field2136;
                  System.arraycopy(this.field2139, this.field2136, var1, var2, var6);
                  System.arraycopy(this.field2139, 0, var1, var6 + var2, var3 - var6);
               }

               this.field2136 = (var3 + this.field2136) % this.field2137;
               this.notifyAll();
               return var3;
            }
         }
      } else {
         throw new IOException();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-682118896"
   )
   void method3197() {
      synchronized(this) {
         if(this.field2140 == null) {
            this.field2140 = new IOException("");
         }

         this.notifyAll();
      }

      try {
         this.field2134.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public void run() {
      while(true) {
         int var1;
         synchronized(this) {
            while(true) {
               if(this.field2140 != null) {
                  return;
               }

               if(this.field2136 == 0) {
                  var1 = this.field2137 - this.field2138 - 1;
               } else if(this.field2136 <= this.field2138) {
                  var1 = this.field2137 - this.field2138;
               } else {
                  var1 = this.field2136 - this.field2138 - 1;
               }

               if(var1 > 0) {
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var10) {
                  ;
               }
            }
         }

         int var7;
         try {
            var7 = this.field2135.read(this.field2139, this.field2138, var1);
            if(var7 == -1) {
               throw new EOFException();
            }
         } catch (IOException var11) {
            IOException var3 = var11;
            synchronized(this) {
               this.field2140 = var3;
               return;
            }
         }

         synchronized(this) {
            this.field2138 = (var7 + this.field2138) % this.field2137;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgu;IB)V",
      garbageValue = "53"
   )
   static final void method3217(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class92.field1382 = 0;
      int var3 = 0;
      var0.bitAccess();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class92.playerIndexesCount; ++var4) {
         var5 = class92.playerIndices[var4];
         if((class92.field1372[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class92.field1372[var5] = (byte)(class92.field1372[var5] | 2);
            } else {
               var6 = var0.getBits(1);
               if(var6 == 0) {
                  var3 = MapIconReference.method731(var0);
                  class92.field1372[var5] = (byte)(class92.field1372[var5] | 2);
               } else {
                  WorldMapData.decodeMovement(var0, var5);
               }
            }
         }
      }

      var0.byteAccess();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var4 = 0; var4 < class92.playerIndexesCount; ++var4) {
            var5 = class92.playerIndices[var4];
            if((class92.field1372[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class92.field1372[var5] = (byte)(class92.field1372[var5] | 2);
               } else {
                  var6 = var0.getBits(1);
                  if(var6 == 0) {
                     var3 = MapIconReference.method731(var0);
                     class92.field1372[var5] = (byte)(class92.field1372[var5] | 2);
                  } else {
                     WorldMapData.decodeMovement(var0, var5);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var4 = 0; var4 < class92.field1377; ++var4) {
               var5 = class92.field1383[var4];
               if((class92.field1372[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class92.field1372[var5] = (byte)(class92.field1372[var5] | 2);
                  } else {
                     var6 = var0.getBits(1);
                     if(var6 == 0) {
                        var3 = MapIconReference.method731(var0);
                        class92.field1372[var5] = (byte)(class92.field1372[var5] | 2);
                     } else if(BoundingBox.decodeRegionHash(var0, var5)) {
                        class92.field1372[var5] = (byte)(class92.field1372[var5] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var4 = 0; var4 < class92.field1377; ++var4) {
                  var5 = class92.field1383[var4];
                  if((class92.field1372[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class92.field1372[var5] = (byte)(class92.field1372[var5] | 2);
                     } else {
                        var6 = var0.getBits(1);
                        if(var6 == 0) {
                           var3 = MapIconReference.method731(var0);
                           class92.field1372[var5] = (byte)(class92.field1372[var5] | 2);
                        } else if(BoundingBox.decodeRegionHash(var0, var5)) {
                           class92.field1372[var5] = (byte)(class92.field1372[var5] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class92.playerIndexesCount = 0;
                  class92.field1377 = 0;

                  for(var4 = 1; var4 < 2048; ++var4) {
                     class92.field1372[var4] = (byte)(class92.field1372[var4] >> 1);
                     Player var7 = Client.cachedPlayers[var4];
                     if(var7 != null) {
                        class92.playerIndices[++class92.playerIndexesCount - 1] = var4;
                     } else {
                        class92.field1383[++class92.field1377 - 1] = var4;
                     }
                  }

                  class21.method173(var0);
                  if(var0.offset - var2 != var1) {
                     throw new RuntimeException(var0.offset - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "571118840"
   )
   @Export("parseInt")
   public static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILca;ZI)I",
      garbageValue = "-421972572"
   )
   static int method3200(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].type();
         return 1;
      } else if(var0 == 3904) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class80.intStack[--class80.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class80.intStack[++class80.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class80.intStack[--class80.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class80.intStack[++class80.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class80.intStack[--class80.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class80.intStack[++class80.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class80.intStack[--class80.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class80.intStack[++class80.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class80.intStack[--class80.intStackSize] == 1;
               if(class1.grandExchangeEvents != null) {
                  class1.grandExchangeEvents.sort(GrandExchangeEvents.field263, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class80.intStack[--class80.intStackSize] == 1;
               if(class1.grandExchangeEvents != null) {
                  class1.grandExchangeEvents.sort(GrandExchangeEvents.field262, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               class80.intStackSize -= 2;
               var13 = class80.intStack[class80.intStackSize] == 1;
               boolean var4 = class80.intStack[class80.intStackSize + 1] == 1;
               if(class1.grandExchangeEvents != null) {
                  Client.field860.field818 = var4;
                  class1.grandExchangeEvents.sort(Client.field860, var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class80.intStack[--class80.intStackSize] == 1;
               if(class1.grandExchangeEvents != null) {
                  class1.grandExchangeEvents.sort(GrandExchangeEvents.field260, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class80.intStack[--class80.intStackSize] == 1;
               if(class1.grandExchangeEvents != null) {
                  class1.grandExchangeEvents.sort(GrandExchangeEvents.field261, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class80.intStack[++class80.intStackSize - 1] = class1.grandExchangeEvents == null?0:class1.grandExchangeEvents.events.size();
               return 1;
            } else {
               GrandExchangeEvent var11;
               if(var0 == 3920) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)class1.grandExchangeEvents.events.get(var3);
                  class80.intStack[++class80.intStackSize - 1] = var11.world;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)class1.grandExchangeEvents.events.get(var3);
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var11.method76();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)class1.grandExchangeEvents.events.get(var3);
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var11.method83();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)class1.grandExchangeEvents.events.get(var3);
                  long var5 = class188.currentTimeMs() - class1.field0 - var11.field269;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)class1.grandExchangeEvents.events.get(var3);
                  class80.intStack[++class80.intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)class1.grandExchangeEvents.events.get(var3);
                  class80.intStack[++class80.intStackSize - 1] = var11.grandExchangeOffer.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)class1.grandExchangeEvents.events.get(var3);
                  class80.intStack[++class80.intStackSize - 1] = var11.grandExchangeOffer.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
