import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
final class class95 implements Comparator {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public static IndexDataBase field1464;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   class95(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;I)I",
      garbageValue = "1479028002"
   )
   int method1787(class14 var1, class14 var2) {
      if(var2.field277 == var1.field277) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field277) {
               return -1;
            }

            if(var2.field277 == Client.world) {
               return 1;
            }
         }

         return var1.field277 < var2.field277?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method1787((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1791676875"
   )
   public static boolean method1777() {
      long var0 = BuildType.currentTimeMs();
      int var2 = (int)(var0 - class238.field3242);
      class238.field3242 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class238.field3237 += var2;
      if(class238.field3244 == 0 && class238.field3238 == 0 && class238.field3243 == 0 && class238.field3234 == 0) {
         return true;
      } else if(class238.field3235 == null) {
         return false;
      } else {
         try {
            if(class238.field3237 > 30000) {
               throw new IOException();
            } else {
               FileRequest var3;
               Buffer var4;
               while(class238.field3238 < 20 && class238.field3234 > 0) {
                  var3 = (FileRequest)class238.field3236.method3564();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class238.field3235.queueForWrite(var4.payload, 0, 4);
                  class238.field3246.put(var3, var3.hash);
                  --class238.field3234;
                  ++class238.field3238;
               }

               while(class238.field3244 < 20 && class238.field3243 > 0) {
                  var3 = (FileRequest)class238.field3240.peek();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class238.field3235.queueForWrite(var4.payload, 0, 4);
                  var3.unlinkDual();
                  class238.field3233.put(var3, var3.hash);
                  --class238.field3243;
                  ++class238.field3244;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class238.field3235.available();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class238.field3237 = 0;
                  byte var5 = 0;
                  if(Buffer.currentRequest == null) {
                     var5 = 8;
                  } else if(class238.field3247 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class238.field3239.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class238.field3235.read(class238.field3239.payload, class238.field3239.offset, var6);
                     if(class238.field3250 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class238.field3239.payload[var7 + class238.field3239.offset] ^= class238.field3250;
                        }
                     }

                     class238.field3239.offset += var6;
                     if(class238.field3239.offset < var5) {
                        break;
                     }

                     if(Buffer.currentRequest == null) {
                        class238.field3239.offset = 0;
                        var7 = class238.field3239.readUnsignedByte();
                        var8 = class238.field3239.readUnsignedShort();
                        int var9 = class238.field3239.readUnsignedByte();
                        var10 = class238.field3239.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        FileRequest var13 = (FileRequest)class238.field3246.get(var11);
                        class238.field3245 = true;
                        if(var13 == null) {
                           var13 = (FileRequest)class238.field3233.get(var11);
                           class238.field3245 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        Buffer.currentRequest = var13;
                        Ignore.field833 = new Buffer(var14 + var10 + Buffer.currentRequest.padding);
                        Ignore.field833.putByte(var9);
                        Ignore.field833.putInt(var10);
                        class238.field3247 = 8;
                        class238.field3239.offset = 0;
                     } else if(class238.field3247 == 0) {
                        if(class238.field3239.payload[0] == -1) {
                           class238.field3247 = 1;
                           class238.field3239.offset = 0;
                        } else {
                           Buffer.currentRequest = null;
                        }
                     }
                  } else {
                     var6 = Ignore.field833.payload.length - Buffer.currentRequest.padding;
                     var7 = 512 - class238.field3247;
                     if(var7 > var6 - Ignore.field833.offset) {
                        var7 = var6 - Ignore.field833.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class238.field3235.read(Ignore.field833.payload, Ignore.field833.offset, var7);
                     if(class238.field3250 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           Ignore.field833.payload[Ignore.field833.offset + var8] ^= class238.field3250;
                        }
                     }

                     Ignore.field833.offset += var7;
                     class238.field3247 += var7;
                     if(var6 == Ignore.field833.offset) {
                        if(16711935L == Buffer.currentRequest.hash) {
                           class56.field657 = Ignore.field833;

                           for(var8 = 0; var8 < 256; ++var8) {
                              IndexData var17 = class238.field3249[var8];
                              if(var17 != null) {
                                 class56.field657.offset = 5 + var8 * 8;
                                 var10 = class56.field657.readInt();
                                 int var18 = class56.field657.readInt();
                                 var17.setInformation(var10, var18);
                              }
                           }
                        } else {
                           class238.field3248.reset();
                           class238.field3248.update(Ignore.field833.payload, 0, var6);
                           var8 = (int)class238.field3248.getValue();
                           if(var8 != Buffer.currentRequest.crc) {
                              try {
                                 class238.field3235.close();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class238.field3251;
                              class238.field3235 = null;
                              class238.field3250 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class238.field3251 = 0;
                           class238.field3252 = 0;
                           Buffer.currentRequest.index.method4206((int)(Buffer.currentRequest.hash & 65535L), Ignore.field833.payload, 16711680L == (Buffer.currentRequest.hash & 16711680L), class238.field3245);
                        }

                        Buffer.currentRequest.unlink();
                        if(class238.field3245) {
                           --class238.field3238;
                        } else {
                           --class238.field3244;
                        }

                        class238.field3247 = 0;
                        Buffer.currentRequest = null;
                        Ignore.field833 = null;
                     } else {
                        if(class238.field3247 != 512) {
                           break;
                        }

                        class238.field3247 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class238.field3235.close();
            } catch (Exception var19) {
               ;
            }

            ++class238.field3252;
            class238.field3235 = null;
            return false;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfy;I)V",
      garbageValue = "1636855101"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = class224.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field865 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class33.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - class17.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class8.plane = var2.field881 = var4;
      if(class96.field1469[var1] != null) {
         var2.decodeApperance(class96.field1469[var1]);
      }

      class96.field1470 = 0;
      class96.field1468[++class96.field1470 - 1] = var1;
      class96.field1471[var1] = 0;
      class96.field1472 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class96.field1476[var7] = (var10 << 14) + var11 + (var9 << 28);
            class96.field1475[var7] = 0;
            class96.field1466[var7] = -1;
            class96.field1480[++class96.field1472 - 1] = var7;
            class96.field1471[var7] = 0;
         }
      }

      var0.byteAccess();
   }
}
