import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
public class class234 extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1871811425
   )
   int field3209;
   @ObfuscatedName("e")
   byte field3210;
   @ObfuscatedName("i")
   IndexData field3214;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIILRegion;[LCollisionData;I)V",
      garbageValue = "1607554269"
   )
   static final void method4104(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.method3154();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.method3154();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.readUnsignedByte();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var1 + var11;
            int var17 = var2 + var10;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class61.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               class84.method1667(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "122"
   )
   public static boolean method4105() {
      long var0 = XGrandExchangeOffer.method96();
      int var2 = (int)(var0 - class238.field3251);
      class238.field3251 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class238.field3268 += var2;
      if(class238.field3250 == 0 && class238.field3255 == 0 && class238.field3258 == 0 && class238.field3259 == 0) {
         return true;
      } else if(class164.field2337 == null) {
         return false;
      } else {
         try {
            if(class238.field3268 > 30000) {
               throw new IOException();
            } else {
               class234 var3;
               Buffer var4;
               while(class238.field3255 < 20 && class238.field3259 > 0) {
                  var3 = (class234)class238.field3252.method3518();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class164.field2337.queueForWrite(var4.payload, 0, 4);
                  class238.field3266.method3516(var3, var3.hash);
                  --class238.field3259;
                  ++class238.field3255;
               }

               while(class238.field3250 < 20 && class238.field3258 > 0) {
                  var3 = (class234)class238.field3256.method3469();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class164.field2337.queueForWrite(var4.payload, 0, 4);
                  var3.method3600();
                  class238.field3269.method3516(var3, var3.hash);
                  --class238.field3258;
                  ++class238.field3250;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class164.field2337.available();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class238.field3268 = 0;
                  byte var5 = 0;
                  if(class54.field677 == null) {
                     var5 = 8;
                  } else if(class238.field3262 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class238.field3261.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class164.field2337.read(class238.field3261.payload, class238.field3261.offset, var6);
                     if(class238.field3260 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class238.field3261.payload[var7 + class238.field3261.offset] ^= class238.field3260;
                        }
                     }

                     class238.field3261.offset += var6;
                     if(class238.field3261.offset < var5) {
                        break;
                     }

                     if(class54.field677 == null) {
                        class238.field3261.offset = 0;
                        var7 = class238.field3261.readUnsignedByte();
                        var8 = class238.field3261.readUnsignedShort();
                        int var9 = class238.field3261.readUnsignedByte();
                        var10 = class238.field3261.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        class234 var13 = (class234)class238.field3266.method3520(var11);
                        FrameMap.field2072 = true;
                        if(var13 == null) {
                           var13 = (class234)class238.field3269.method3520(var11);
                           FrameMap.field2072 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class54.field677 = var13;
                        class224.field2849 = new Buffer(class54.field677.field3210 + var10 + var14);
                        class224.field2849.putByte(var9);
                        class224.field2849.putInt(var10);
                        class238.field3262 = 8;
                        class238.field3261.offset = 0;
                     } else if(class238.field3262 == 0) {
                        if(class238.field3261.payload[0] == -1) {
                           class238.field3262 = 1;
                           class238.field3261.offset = 0;
                        } else {
                           class54.field677 = null;
                        }
                     }
                  } else {
                     var6 = class224.field2849.payload.length - class54.field677.field3210;
                     var7 = 512 - class238.field3262;
                     if(var7 > var6 - class224.field2849.offset) {
                        var7 = var6 - class224.field2849.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class164.field2337.read(class224.field2849.payload, class224.field2849.offset, var7);
                     if(class238.field3260 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class224.field2849.payload[var8 + class224.field2849.offset] ^= class238.field3260;
                        }
                     }

                     class224.field2849.offset += var7;
                     class238.field3262 += var7;
                     if(class224.field2849.offset == var6) {
                        if(class54.field677.hash == 16711935L) {
                           class176.field2426 = class224.field2849;

                           for(var8 = 0; var8 < 256; ++var8) {
                              IndexData var17 = class238.field3265[var8];
                              if(var17 != null) {
                                 class176.field2426.offset = var8 * 8 + 5;
                                 var10 = class176.field2426.readInt();
                                 int var18 = class176.field2426.readInt();
                                 var17.method4221(var10, var18);
                              }
                           }
                        } else {
                           class238.field3264.reset();
                           class238.field3264.update(class224.field2849.payload, 0, var6);
                           var8 = (int)class238.field3264.getValue();
                           if(class54.field677.field3209 != var8) {
                              try {
                                 class164.field2337.method2981();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class238.field3267;
                              class164.field2337 = null;
                              class238.field3260 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class238.field3267 = 0;
                           class238.field3263 = 0;
                           class54.field677.field3214.method4222((int)(class54.field677.hash & 65535L), class224.field2849.payload, 16711680L == (class54.field677.hash & 16711680L), FrameMap.field2072);
                        }

                        class54.field677.unlink();
                        if(FrameMap.field2072) {
                           --class238.field3255;
                        } else {
                           --class238.field3250;
                        }

                        class238.field3262 = 0;
                        class54.field677 = null;
                        class224.field2849 = null;
                     } else {
                        if(class238.field3262 != 512) {
                           break;
                        }

                        class238.field3262 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class164.field2337.method2981();
            } catch (Exception var19) {
               ;
            }

            ++class238.field3263;
            class164.field2337 = null;
            return false;
         }
      }
   }
}
