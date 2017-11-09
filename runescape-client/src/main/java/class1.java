import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class1 {
   @ObfuscatedName("lz")
   @ObfuscatedSignature(
      signature = "Lcu;"
   )
   @Export("chatMessages")
   static Varcs chatMessages;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final class1 field7;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final class1 field1;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final class1 field0;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final class1 field3;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final class1 field4;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final class1 field5;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final class1 field6;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1451070941
   )
   final int field2;

   static {
      field7 = new class1(4);
      field1 = new class1(0);
      field0 = new class1(6);
      field3 = new class1(1);
      field4 = new class1(3);
      field5 = new class1(5);
      field6 = new class1(2);
   }

   class1(int var1) {
      this.field2 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1314151968"
   )
   public static boolean method2() {
      long var0 = class268.currentTimeMs();
      int var2 = (int)(var0 - class245.field3315);
      class245.field3315 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class245.field3314 += var2;
      if(class245.field3324 == 0 && class245.field3323 == 0 && class245.field3327 == 0 && class245.field3320 == 0) {
         return true;
      } else if(class245.field3316 == null) {
         return false;
      } else {
         try {
            if(class245.field3314 > 30000) {
               throw new IOException();
            } else {
               FileRequest var3;
               Buffer var4;
               while(class245.field3323 < 20 && class245.field3320 > 0) {
                  var3 = (FileRequest)class245.field3322.method3721();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class245.field3316.queueForWrite(var4.payload, 0, 4);
                  class245.field3318.put(var3, var3.hash);
                  --class245.field3320;
                  ++class245.field3323;
               }

               while(class245.field3324 < 20 && class245.field3327 > 0) {
                  var3 = (FileRequest)class245.field3326.peek();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class245.field3316.queueForWrite(var4.payload, 0, 4);
                  var3.unlinkDual();
                  class245.field3313.put(var3, var3.hash);
                  --class245.field3327;
                  ++class245.field3324;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class245.field3316.available();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class245.field3314 = 0;
                  byte var5 = 0;
                  if(class149.currentRequest == null) {
                     var5 = 8;
                  } else if(class245.field3317 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class245.field3325.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class245.field3316.read(class245.field3325.payload, class245.field3325.offset, var6);
                     if(class245.field3329 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class245.field3325.payload[class245.field3325.offset + var7] ^= class245.field3329;
                        }
                     }

                     class245.field3325.offset += var6;
                     if(class245.field3325.offset < var5) {
                        break;
                     }

                     if(class149.currentRequest == null) {
                        class245.field3325.offset = 0;
                        var7 = class245.field3325.readUnsignedByte();
                        var8 = class245.field3325.readUnsignedShort();
                        int var9 = class245.field3325.readUnsignedByte();
                        var10 = class245.field3325.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        FileRequest var13 = (FileRequest)class245.field3318.get(var11);
                        class33.field450 = true;
                        if(var13 == null) {
                           var13 = (FileRequest)class245.field3313.get(var11);
                           class33.field450 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class149.currentRequest = var13;
                        DecorativeObject.field2078 = new Buffer(var10 + var14 + class149.currentRequest.padding);
                        DecorativeObject.field2078.putByte(var9);
                        DecorativeObject.field2078.putInt(var10);
                        class245.field3317 = 8;
                        class245.field3325.offset = 0;
                     } else if(class245.field3317 == 0) {
                        if(class245.field3325.payload[0] == -1) {
                           class245.field3317 = 1;
                           class245.field3325.offset = 0;
                        } else {
                           class149.currentRequest = null;
                        }
                     }
                  } else {
                     var6 = DecorativeObject.field2078.payload.length - class149.currentRequest.padding;
                     var7 = 512 - class245.field3317;
                     if(var7 > var6 - DecorativeObject.field2078.offset) {
                        var7 = var6 - DecorativeObject.field2078.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class245.field3316.read(DecorativeObject.field2078.payload, DecorativeObject.field2078.offset, var7);
                     if(class245.field3329 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           DecorativeObject.field2078.payload[DecorativeObject.field2078.offset + var8] ^= class245.field3329;
                        }
                     }

                     DecorativeObject.field2078.offset += var7;
                     class245.field3317 += var7;
                     if(var6 == DecorativeObject.field2078.offset) {
                        if(class149.currentRequest.hash == 16711935L) {
                           class56.field640 = DecorativeObject.field2078;

                           for(var8 = 0; var8 < 256; ++var8) {
                              IndexData var17 = class245.field3328[var8];
                              if(var17 != null) {
                                 class56.field640.offset = var8 * 8 + 5;
                                 var10 = class56.field640.readInt();
                                 int var18 = class56.field640.readInt();
                                 var17.setInformation(var10, var18);
                              }
                           }
                        } else {
                           class245.field3319.reset();
                           class245.field3319.update(DecorativeObject.field2078.payload, 0, var6);
                           var8 = (int)class245.field3319.getValue();
                           if(var8 != class149.currentRequest.crc) {
                              try {
                                 class245.field3316.close();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class245.field3330;
                              class245.field3316 = null;
                              class245.field3329 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class245.field3330 = 0;
                           class245.field3331 = 0;
                           class149.currentRequest.index.method4412((int)(class149.currentRequest.hash & 65535L), DecorativeObject.field2078.payload, 16711680L == (class149.currentRequest.hash & 16711680L), class33.field450);
                        }

                        class149.currentRequest.unlink();
                        if(class33.field450) {
                           --class245.field3323;
                        } else {
                           --class245.field3324;
                        }

                        class245.field3317 = 0;
                        class149.currentRequest = null;
                        DecorativeObject.field2078 = null;
                     } else {
                        if(class245.field3317 != 512) {
                           break;
                        }

                        class245.field3317 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class245.field3316.close();
            } catch (Exception var19) {
               ;
            }

            ++class245.field3331;
            class245.field3316 = null;
            return false;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "231842633"
   )
   static final int method0(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "21484656"
   )
   static final void method1(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class231.field2918 || class91.field1367 != var1) {
         class231.field2918 = var0;
         class91.field1367 = var1;
         class287.setGameState(25);
         class66.drawStatusBox("Loading - please wait.", true);
         int var3 = ItemLayer.baseX;
         int var4 = ItemLayer.baseY;
         ItemLayer.baseX = (var0 - 6) * 8;
         ItemLayer.baseY = (var1 - 6) * 8;
         int var5 = ItemLayer.baseX - var3;
         int var6 = ItemLayer.baseY - var4;
         var3 = ItemLayer.baseX;
         var4 = ItemLayer.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < 32768; ++var7) {
            NPC var8 = Client.cachedNPCs[var7];
            if(var8 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var8.pathX[var9] -= var5;
                  var8.pathY[var9] -= var6;
               }

               var8.x -= var5 * 128;
               var8.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var21 = Client.cachedPlayers[var7];
            if(var21 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var21.pathX[var9] -= var5;
                  var21.pathY[var9] -= var6;
               }

               var21.x -= var5 * 128;
               var21.y -= var6 * 128;
            }
         }

         byte var20 = 0;
         byte var18 = 104;
         byte var22 = 1;
         if(var5 < 0) {
            var20 = 103;
            var18 = -1;
            var22 = -1;
         }

         byte var10 = 0;
         byte var11 = 104;
         byte var12 = 1;
         if(var6 < 0) {
            var10 = 103;
            var11 = -1;
            var12 = -1;
         }

         int var14;
         for(int var13 = var20; var13 != var18; var13 += var22) {
            for(var14 = var10; var11 != var14; var14 += var12) {
               int var15 = var5 + var13;
               int var16 = var14 + var6;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if(var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItemDeque[var17][var13][var14] = Client.groundItemDeque[var17][var15][var16];
                  } else {
                     Client.groundItemDeque[var17][var13][var14] = null;
                  }
               }
            }
         }

         for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.getFront(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.getNext()) {
            var19.x -= var5;
            var19.y -= var6;
            if(var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
               var19.unlink();
            }
         }

         if(Client.destinationX != 0) {
            Client.destinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.field1091 = 0;
         Client.field1097 = false;
         Client.field1078 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }
}
