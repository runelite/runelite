import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class96 {
   @ObfuscatedName("a")
   static byte[] field1516;
   @ObfuscatedName("t")
   static byte[] field1519;
   @ObfuscatedName("s")
   static Buffer[] field1520;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 1653494903
   )
   @Export("myWorldPort")
   static int myWorldPort;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1792224243
   )
   static int field1521;
   @ObfuscatedName("v")
   static int[] field1531;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 930908255
   )
   static int field1523;
   @ObfuscatedName("j")
   static int[] field1524;
   @ObfuscatedName("k")
   static int[] field1522;
   @ObfuscatedName("e")
   static int[] field1526;
   @ObfuscatedName("o")
   static int[] field1527;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 957137555
   )
   static int field1525;
   @ObfuscatedName("l")
   static int[] field1529;
   @ObfuscatedName("c")
   static Buffer field1533;

   static {
      field1516 = new byte[2048];
      field1519 = new byte[2048];
      field1520 = new Buffer[2048];
      field1521 = 0;
      field1531 = new int[2048];
      field1523 = 0;
      field1524 = new int[2048];
      field1522 = new int[2048];
      field1526 = new int[2048];
      field1527 = new int[2048];
      field1525 = 0;
      field1529 = new int[2048];
      field1533 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "9"
   )
   public static boolean method1799() {
      long var0 = DState.currentTimeMs();
      int var2 = (int)(var0 - class238.field3263);
      class238.field3263 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class238.field3261 += var2;
      if(class238.field3271 == 0 && class238.field3265 == 0 && class238.field3269 == 0 && class238.field3266 == 0) {
         return true;
      } else if(class238.field3272 == null) {
         return false;
      } else {
         try {
            if(class238.field3261 > 30000) {
               throw new IOException();
            } else {
               FileRequest var3;
               Buffer var4;
               while(class238.field3265 < 20 && class238.field3266 > 0) {
                  var3 = (FileRequest)class238.field3260.method3533();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class238.field3272.queueForWrite(var4.payload, 0, 4);
                  class238.field3275.put(var3, var3.hash);
                  --class238.field3266;
                  ++class238.field3265;
               }

               while(class238.field3271 < 20 && class238.field3269 > 0) {
                  var3 = (FileRequest)class238.field3267.peek();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class238.field3272.queueForWrite(var4.payload, 0, 4);
                  var3.unlinkDual();
                  class238.field3270.put(var3, var3.hash);
                  --class238.field3269;
                  ++class238.field3271;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class238.field3272.available();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class238.field3261 = 0;
                  byte var5 = 0;
                  if(class7.currentRequest == null) {
                     var5 = 8;
                  } else if(class238.field3273 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class238.field3264.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class238.field3272.read(class238.field3264.payload, class238.field3264.offset, var6);
                     if(class238.field3276 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class238.field3264.payload[var7 + class238.field3264.offset] ^= class238.field3276;
                        }
                     }

                     class238.field3264.offset += var6;
                     if(class238.field3264.offset < var5) {
                        break;
                     }

                     if(class7.currentRequest == null) {
                        class238.field3264.offset = 0;
                        var7 = class238.field3264.readUnsignedByte();
                        var8 = class238.field3264.readUnsignedShort();
                        int var17 = class238.field3264.readUnsignedByte();
                        var10 = class238.field3264.readInt();
                        long var18 = (long)(var8 + (var7 << 16));
                        FileRequest var13 = (FileRequest)class238.field3275.get(var18);
                        class181.field2441 = true;
                        if(var13 == null) {
                           var13 = (FileRequest)class238.field3270.get(var18);
                           class181.field2441 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var17 == 0?5:9;
                        class7.currentRequest = var13;
                        class39.field559 = new Buffer(var14 + var10 + class7.currentRequest.padding);
                        class39.field559.putByte(var17);
                        class39.field559.putInt(var10);
                        class238.field3273 = 8;
                        class238.field3264.offset = 0;
                     } else if(class238.field3273 == 0) {
                        if(class238.field3264.payload[0] == -1) {
                           class238.field3273 = 1;
                           class238.field3264.offset = 0;
                        } else {
                           class7.currentRequest = null;
                        }
                     }
                  } else {
                     var6 = class39.field559.payload.length - class7.currentRequest.padding;
                     var7 = 512 - class238.field3273;
                     if(var7 > var6 - class39.field559.offset) {
                        var7 = var6 - class39.field559.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class238.field3272.read(class39.field559.payload, class39.field559.offset, var7);
                     if(class238.field3276 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class39.field559.payload[class39.field559.offset + var8] ^= class238.field3276;
                        }
                     }

                     class39.field559.offset += var7;
                     class238.field3273 += var7;
                     if(var6 == class39.field559.offset) {
                        if(16711935L == class7.currentRequest.hash) {
                           FaceNormal.field2150 = class39.field559;

                           for(var8 = 0; var8 < 256; ++var8) {
                              IndexData var9 = class238.field3262[var8];
                              if(var9 != null) {
                                 FaceNormal.field2150.offset = var8 * 8 + 5;
                                 var10 = FaceNormal.field2150.readInt();
                                 int var11 = FaceNormal.field2150.readInt();
                                 var9.setInformation(var10, var11);
                              }
                           }
                        } else {
                           class238.field3274.reset();
                           class238.field3274.update(class39.field559.payload, 0, var6);
                           var8 = (int)class238.field3274.getValue();
                           if(var8 != class7.currentRequest.crc) {
                              try {
                                 class238.field3272.close();
                              } catch (Exception var21) {
                                 ;
                              }

                              ++class238.field3277;
                              class238.field3272 = null;
                              class238.field3276 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class238.field3277 = 0;
                           class238.field3278 = 0;
                           class7.currentRequest.index.method4219((int)(class7.currentRequest.hash & 65535L), class39.field559.payload, 16711680L == (class7.currentRequest.hash & 16711680L), class181.field2441);
                        }

                        class7.currentRequest.unlink();
                        if(class181.field2441) {
                           --class238.field3265;
                        } else {
                           --class238.field3271;
                        }

                        class238.field3273 = 0;
                        class7.currentRequest = null;
                        class39.field559 = null;
                     } else {
                        if(class238.field3273 != 512) {
                           break;
                        }

                        class238.field3273 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var22) {
            try {
               class238.field3272.close();
            } catch (Exception var20) {
               ;
            }

            ++class238.field3278;
            class238.field3272 = null;
            return false;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-88"
   )
   static int method1801() {
      return 9;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-46"
   )
   public static void method1798(int var0) {
      if(class203.field2508 != 0) {
         class203.field2513 = var0;
      } else {
         class203.field2509.method3694(var0);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-716792492"
   )
   static int method1800(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 3400) {
         class46.intStackSize -= 2;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         Enum var6 = (Enum)Enum.field3415.get((long)var3);
         Enum var5;
         if(var6 != null) {
            var5 = var6;
         } else {
            byte[] var14 = Enum.field3409.getConfigData(8, var3);
            var6 = new Enum();
            if(var14 != null) {
               var6.decode(new Buffer(var14));
            }

            Enum.field3415.put(var6, (long)var3);
            var5 = var6;
         }

         var6 = var5;
         if(var5.valType != 115) {
            ;
         }

         for(int var7 = 0; var7 < var6.size; ++var7) {
            if(var4 == var6.keys[var7]) {
               class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var6.stringVals[var7];
               var6 = null;
               break;
            }
         }

         if(var6 != null) {
            class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var6.defaultString;
         }

         return 1;
      } else if(var0 == 3408) {
         class46.intStackSize -= 4;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         int var11 = class83.intStack[class46.intStackSize + 2];
         int var12 = class83.intStack[class46.intStackSize + 3];
         Enum var8 = (Enum)Enum.field3415.get((long)var11);
         Enum var10;
         if(var8 != null) {
            var10 = var8;
         } else {
            byte[] var13 = Enum.field3409.getConfigData(8, var11);
            var8 = new Enum();
            if(var13 != null) {
               var8.decode(new Buffer(var13));
            }

            Enum.field3415.put(var8, (long)var11);
            var10 = var8;
         }

         var8 = var10;
         if(var3 == var10.keyType && var4 == var10.valType) {
            for(int var9 = 0; var9 < var8.size; ++var9) {
               if(var12 == var8.keys[var9]) {
                  if(var4 == 115) {
                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var8.stringVals[var9];
                  } else {
                     class83.intStack[++class46.intStackSize - 1] = var8.intVals[var9];
                  }

                  var8 = null;
                  break;
               }
            }

            if(var8 != null) {
               if(var4 == 115) {
                  class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var8.defaultString;
               } else {
                  class83.intStack[++class46.intStackSize - 1] = var8.defaultInt;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "null";
            } else {
               class83.intStack[++class46.intStackSize - 1] = 0;
            }

            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-183883918"
   )
   static final void method1797(String var0) {
      if(!var0.equals("")) {
         Client.secretPacketBuffer1.putOpcode(73);
         Client.secretPacketBuffer1.putByte(class261.getLength(var0));
         Client.secretPacketBuffer1.putString(var0);
      }
   }
}
