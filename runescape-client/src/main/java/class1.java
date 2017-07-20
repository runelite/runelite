import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class1 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   static final class1 field10;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   static final class1 field5;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   static final class1 field2;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   static final class1 field3;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   static final class1 field0;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   static final class1 field6;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   static final class1 field9;
   @ObfuscatedName("or")
   @ObfuscatedSignature(
      signature = "Lch;"
   )
   static class102 field4;
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1792440289
   )
   final int field7;

   static {
      field10 = new class1(0);
      field5 = new class1(4);
      field2 = new class1(6);
      field3 = new class1(2);
      field0 = new class1(5);
      field6 = new class1(3);
      field9 = new class1(1);
   }

   class1(int var1) {
      this.field7 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "121"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1888135771"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      class140.method2791();
      ++Client.audioEffectCount;
      if(Client.audioEffectCount >= 50 || var0) {
         Client.audioEffectCount = 0;
         if(!Client.socketError && class13.rssocket != null) {
            Client.secretPacketBuffer1.putOpcode(251);

            try {
               class13.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0, Client.secretPacketBuffer1.offset);
               Client.secretPacketBuffer1.offset = 0;
            } catch (IOException var2) {
               Client.socketError = true;
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Lcw;II[I[II)V",
      garbageValue = "-595766116"
   )
   static void method1(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1507()?1:0;
                     var12 = var8.method1507()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1507()?1:0;
                     var12 = var8.method1507()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method1(var0, var1, var6, var3, var4);
         method1(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("ey")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1288193891"
   )
   static void method3(int var0, int var1) {
      if(Client.field1139 != 0 && var0 != -1) {
         class18.method136(class222.indexTrack2, var0, 0, Client.field1139, false);
         Client.field1141 = true;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "815248478"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = XGrandExchangeOffer.method101(var0 - 1, var1 - 1) + XGrandExchangeOffer.method101(var0 + 1, var1 - 1) + XGrandExchangeOffer.method101(var0 - 1, var1 + 1) + XGrandExchangeOffer.method101(var0 + 1, var1 + 1);
      int var3 = XGrandExchangeOffer.method101(var0 - 1, var1) + XGrandExchangeOffer.method101(var0 + 1, var1) + XGrandExchangeOffer.method101(var0, var1 - 1) + XGrandExchangeOffer.method101(var0, var1 + 1);
      int var4 = XGrandExchangeOffer.method101(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }
}
