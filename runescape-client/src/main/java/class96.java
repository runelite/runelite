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
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1792224243
   )
   static int field1521;
   @ObfuscatedName("k")
   static int[] field1522;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 930908255
   )
   static int field1523;
   @ObfuscatedName("j")
   static int[] field1524;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 957137555
   )
   static int field1525;
   @ObfuscatedName("e")
   static int[] field1526;
   @ObfuscatedName("o")
   static int[] field1527;
   @ObfuscatedName("l")
   static int[] field1529;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 1653494903
   )
   @Export("myWorldPort")
   static int myWorldPort;
   @ObfuscatedName("v")
   static int[] field1531;
   @ObfuscatedName("c")
   static Buffer field1533;

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

               for(int var5 = 0; var5 < 100; ++var5) {
                  int var6 = class238.field3272.available();
                  if(var6 < 0) {
                     throw new IOException();
                  }

                  if(var6 == 0) {
                     break;
                  }

                  class238.field3261 = 0;
                  byte var7 = 0;
                  if(class7.currentRequest == null) {
                     var7 = 8;
                  } else if(class238.field3273 == 0) {
                     var7 = 1;
                  }

                  int var8;
                  int var9;
                  int var10;
                  int var11;
                  if(var7 > 0) {
                     var8 = var7 - class238.field3264.offset;
                     if(var8 > var6) {
                        var8 = var6;
                     }

                     class238.field3272.read(class238.field3264.payload, class238.field3264.offset, var8);
                     if(class238.field3276 != 0) {
                        for(var9 = 0; var9 < var8; ++var9) {
                           class238.field3264.payload[var9 + class238.field3264.offset] ^= class238.field3276;
                        }
                     }

                     class238.field3264.offset += var8;
                     if(class238.field3264.offset < var7) {
                        break;
                     }

                     if(class7.currentRequest == null) {
                        class238.field3264.offset = 0;
                        var9 = class238.field3264.readUnsignedByte();
                        var10 = class238.field3264.readUnsignedShort();
                        int var12 = class238.field3264.readUnsignedByte();
                        var11 = class238.field3264.readInt();
                        long var13 = (long)(var10 + (var9 << 16));
                        FileRequest var15 = (FileRequest)class238.field3275.get(var13);
                        class181.field2441 = true;
                        if(var15 == null) {
                           var15 = (FileRequest)class238.field3270.get(var13);
                           class181.field2441 = false;
                        }

                        if(var15 == null) {
                           throw new IOException();
                        }

                        int var16 = var12 == 0?5:9;
                        class7.currentRequest = var15;
                        class39.field559 = new Buffer(var11 + var16 + class7.currentRequest.padding);
                        class39.field559.putByte(var12);
                        class39.field559.putInt(var11);
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
                     var8 = class39.field559.payload.length - class7.currentRequest.padding;
                     var9 = 512 - class238.field3273;
                     if(var9 > var8 - class39.field559.offset) {
                        var9 = var8 - class39.field559.offset;
                     }

                     if(var9 > var6) {
                        var9 = var6;
                     }

                     class238.field3272.read(class39.field559.payload, class39.field559.offset, var9);
                     if(class238.field3276 != 0) {
                        for(var10 = 0; var10 < var9; ++var10) {
                           class39.field559.payload[class39.field559.offset + var10] ^= class238.field3276;
                        }
                     }

                     class39.field559.offset += var9;
                     class238.field3273 += var9;
                     if(var8 == class39.field559.offset) {
                        if(16711935L == class7.currentRequest.hash) {
                           FaceNormal.field2150 = class39.field559;

                           for(var10 = 0; var10 < 256; ++var10) {
                              IndexData var20 = class238.field3262[var10];
                              if(var20 != null) {
                                 FaceNormal.field2150.offset = var10 * 8 + 5;
                                 var11 = FaceNormal.field2150.readInt();
                                 int var21 = FaceNormal.field2150.readInt();
                                 var20.setInformation(var11, var21);
                              }
                           }
                        } else {
                           class238.field3274.reset();
                           class238.field3274.update(class39.field559.payload, 0, var8);
                           var10 = (int)class238.field3274.getValue();
                           if(var10 != class7.currentRequest.crc) {
                              try {
                                 class238.field3272.close();
                              } catch (Exception var18) {
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
         } catch (IOException var19) {
            try {
               class238.field3272.close();
            } catch (Exception var17) {
               ;
            }

            ++class238.field3278;
            class238.field3272 = null;
            return false;
         }
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
         Enum var10 = (Enum)Enum.field3415.get((long)var3);
         Enum var11;
         if(var10 != null) {
            var11 = var10;
         } else {
            byte[] var12 = Enum.field3409.getConfigData(8, var3);
            var10 = new Enum();
            if(var12 != null) {
               var10.decode(new Buffer(var12));
            }

            Enum.field3415.put(var10, (long)var3);
            var11 = var10;
         }

         var10 = var11;
         if(var11.valType != 115) {
            ;
         }

         for(int var13 = 0; var13 < var10.size; ++var13) {
            if(var10.keys[var13] == var4) {
               class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var10.stringVals[var13];
               var10 = null;
               break;
            }
         }

         if(var10 != null) {
            class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var10.defaultString;
         }

         return 1;
      } else if(var0 == 3408) {
         class46.intStackSize -= 4;
         var3 = class83.intStack[class46.intStackSize];
         var4 = class83.intStack[class46.intStackSize + 1];
         int var5 = class83.intStack[class46.intStackSize + 2];
         int var6 = class83.intStack[class46.intStackSize + 3];
         Enum var7 = (Enum)Enum.field3415.get((long)var5);
         Enum var8;
         if(var7 != null) {
            var8 = var7;
         } else {
            byte[] var9 = Enum.field3409.getConfigData(8, var5);
            var7 = new Enum();
            if(var9 != null) {
               var7.decode(new Buffer(var9));
            }

            Enum.field3415.put(var7, (long)var5);
            var8 = var7;
         }

         var7 = var8;
         if(var3 == var8.keyType && var8.valType == var4) {
            for(int var14 = 0; var14 < var7.size; ++var14) {
               if(var7.keys[var14] == var6) {
                  if(var4 == 115) {
                     class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var7.stringVals[var14];
                  } else {
                     class83.intStack[++class46.intStackSize - 1] = var7.intVals[var14];
                  }

                  var7 = null;
                  break;
               }
            }

            if(var7 != null) {
               if(var4 == 115) {
                  class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var7.defaultString;
               } else {
                  class83.intStack[++class46.intStackSize - 1] = var7.defaultInt;
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-88"
   )
   static int method1801() {
      return 9;
   }

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
}
