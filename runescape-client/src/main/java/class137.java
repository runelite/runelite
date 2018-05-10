import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class137 implements Comparator {
   @ObfuscatedName("ru")
   static short[] field1889;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = 377740755
   )
   static int field1888;
   @ObfuscatedName("w")
   final boolean field1887;

   public class137(boolean var1) {
      this.field1887 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lkd;Lkd;I)I",
      garbageValue = "1479821814"
   )
   int method3146(ChatPlayer var1, ChatPlayer var2) {
      return this.field1887?var1.field3649 - var2.field3649:var2.field3649 - var1.field3649;
   }

   public int compare(Object var1, Object var2) {
      return this.method3146((ChatPlayer)var1, (ChatPlayer)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2074570907"
   )
   public static boolean method3141() {
      long var0 = class166.method3456();
      int var2 = (int)(var0 - class250.field3223);
      class250.field3223 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class250.field3209 += var2;
      if(class250.NetCache_pendingResponsesCount == 0 && class250.NetCache_pendingPriorityResponsesCount == 0 && class250.NetCache_pendingWritesCount == 0 && class250.NetCache_pendingPriorityWritesCount == 0) {
         return true;
      } else if(class250.NetCache_socket == null) {
         return false;
      } else {
         try {
            if(class250.field3209 > 30000) {
               throw new IOException();
            } else {
               FileRequest var3;
               Buffer var4;
               while(class250.NetCache_pendingPriorityResponsesCount < 200 && class250.NetCache_pendingPriorityWritesCount > 0) {
                  var3 = (FileRequest)class250.NetCache_pendingPriorityWrites.first();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class250.NetCache_socket.vmethod3385(var4.payload, 0, 4);
                  class250.NetCache_pendingPriorityResponses.put(var3, var3.hash);
                  --class250.NetCache_pendingPriorityWritesCount;
                  ++class250.NetCache_pendingPriorityResponsesCount;
               }

               while(class250.NetCache_pendingResponsesCount < 200 && class250.NetCache_pendingWritesCount > 0) {
                  var3 = (FileRequest)class250.NetCache_pendingWritesQueue.peek();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class250.NetCache_socket.vmethod3385(var4.payload, 0, 4);
                  var3.unlinkDual();
                  class250.NetCache_pendingResponses.put(var3, var3.hash);
                  --class250.NetCache_pendingWritesCount;
                  ++class250.NetCache_pendingResponsesCount;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class250.NetCache_socket.vmethod3354();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class250.field3209 = 0;
                  byte var5 = 0;
                  if(class320.currentRequest == null) {
                     var5 = 8;
                  } else if(class250.field3221 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class250.NetCache_responseHeaderBuffer.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class250.NetCache_socket.vmethod3356(class250.NetCache_responseHeaderBuffer.payload, class250.NetCache_responseHeaderBuffer.offset, var6);
                     if(class250.field3225 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class250.NetCache_responseHeaderBuffer.payload[class250.NetCache_responseHeaderBuffer.offset + var7] ^= class250.field3225;
                        }
                     }

                     class250.NetCache_responseHeaderBuffer.offset += var6;
                     if(class250.NetCache_responseHeaderBuffer.offset < var5) {
                        break;
                     }

                     if(class320.currentRequest == null) {
                        class250.NetCache_responseHeaderBuffer.offset = 0;
                        var7 = class250.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var8 = class250.NetCache_responseHeaderBuffer.readUnsignedShort();
                        int var9 = class250.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var10 = class250.NetCache_responseHeaderBuffer.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        FileRequest var13 = (FileRequest)class250.NetCache_pendingPriorityResponses.get(var11);
                        class250.field3220 = true;
                        if(var13 == null) {
                           var13 = (FileRequest)class250.NetCache_pendingResponses.get(var11);
                           class250.field3220 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class320.currentRequest = var13;
                        class232.NetCache_responseArchiveBuffer = new Buffer(var14 + var10 + class320.currentRequest.padding);
                        class232.NetCache_responseArchiveBuffer.putByte(var9);
                        class232.NetCache_responseArchiveBuffer.putInt(var10);
                        class250.field3221 = 8;
                        class250.NetCache_responseHeaderBuffer.offset = 0;
                     } else if(class250.field3221 == 0) {
                        if(class250.NetCache_responseHeaderBuffer.payload[0] == -1) {
                           class250.field3221 = 1;
                           class250.NetCache_responseHeaderBuffer.offset = 0;
                        } else {
                           class320.currentRequest = null;
                        }
                     }
                  } else {
                     var6 = class232.NetCache_responseArchiveBuffer.payload.length - class320.currentRequest.padding;
                     var7 = 512 - class250.field3221;
                     if(var7 > var6 - class232.NetCache_responseArchiveBuffer.offset) {
                        var7 = var6 - class232.NetCache_responseArchiveBuffer.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class250.NetCache_socket.vmethod3356(class232.NetCache_responseArchiveBuffer.payload, class232.NetCache_responseArchiveBuffer.offset, var7);
                     if(class250.field3225 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class232.NetCache_responseArchiveBuffer.payload[class232.NetCache_responseArchiveBuffer.offset + var8] ^= class250.field3225;
                        }
                     }

                     class232.NetCache_responseArchiveBuffer.offset += var7;
                     class250.field3221 += var7;
                     if(var6 == class232.NetCache_responseArchiveBuffer.offset) {
                        if(16711935L == class320.currentRequest.hash) {
                           class325.NetCache_reference = class232.NetCache_responseArchiveBuffer;

                           for(var8 = 0; var8 < 256; ++var8) {
                              IndexData var17 = class250.NetCache_indexCaches[var8];
                              if(var17 != null) {
                                 class325.NetCache_reference.offset = var8 * 8 + 5;
                                 var10 = class325.NetCache_reference.readInt();
                                 int var18 = class325.NetCache_reference.readInt();
                                 var17.setInformation(var10, var18);
                              }
                           }
                        } else {
                           class250.NetCache_crc.reset();
                           class250.NetCache_crc.update(class232.NetCache_responseArchiveBuffer.payload, 0, var6);
                           var8 = (int)class250.NetCache_crc.getValue();
                           if(var8 != class320.currentRequest.crc) {
                              try {
                                 class250.NetCache_socket.vmethod3368();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class250.field3226;
                              class250.NetCache_socket = null;
                              class250.field3225 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class250.field3226 = 0;
                           class250.field3227 = 0;
                           class320.currentRequest.index.write((int)(class320.currentRequest.hash & 65535L), class232.NetCache_responseArchiveBuffer.payload, (class320.currentRequest.hash & 16711680L) == 16711680L, class250.field3220);
                        }

                        class320.currentRequest.unlink();
                        if(class250.field3220) {
                           --class250.NetCache_pendingPriorityResponsesCount;
                        } else {
                           --class250.NetCache_pendingResponsesCount;
                        }

                        class250.field3221 = 0;
                        class320.currentRequest = null;
                        class232.NetCache_responseArchiveBuffer = null;
                     } else {
                        if(class250.field3221 != 512) {
                           break;
                        }

                        class250.field3221 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class250.NetCache_socket.vmethod3368();
            } catch (Exception var19) {
               ;
            }

            ++class250.field3227;
            class250.NetCache_socket = null;
            return false;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Ljh;",
      garbageValue = "-335324697"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)[Lip;",
      garbageValue = "1594770687"
   )
   public static BuildType[] method3149() {
      return new BuildType[]{BuildType.BUILD_LIVE, BuildType.LIVE, BuildType.RC, BuildType.WIP};
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "435577119"
   )
   static void method3148(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }
}
