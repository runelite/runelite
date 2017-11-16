import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("lt")
   @ObfuscatedSignature(
      signature = "Lcf;"
   )
   @Export("chatMessages")
   static Varcs chatMessages;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -201827079
   )
   @Export("modelHeight")
   public int modelHeight;

   protected Renderable() {
      this.modelHeight = 1000;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lev;",
      garbageValue = "1008738898"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("cy")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-3"
   )
   public static boolean method2868() {
      long var0 = ChatLineBuffer.currentTimeMs();
      int var2 = (int)(var0 - class245.field3306);
      class245.field3306 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class245.field3307 += var2;
      if(class245.field3315 == 0 && class245.field3310 == 0 && class245.field3322 == 0 && class245.field3308 == 0) {
         return true;
      } else if(class19.field299 == null) {
         return false;
      } else {
         try {
            if(class245.field3307 > 30000) {
               throw new IOException();
            } else {
               FileRequest var3;
               Buffer var4;
               while(class245.field3310 < 20 && class245.field3308 > 0) {
                  var3 = (FileRequest)class245.field3318.method3592();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class19.field299.queueForWrite(var4.payload, 0, 4);
                  class245.field3309.put(var3, var3.hash);
                  --class245.field3308;
                  ++class245.field3310;
               }

               while(class245.field3315 < 20 && class245.field3322 > 0) {
                  var3 = (FileRequest)class245.field3305.peek();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class19.field299.queueForWrite(var4.payload, 0, 4);
                  var3.unlinkDual();
                  class245.field3314.put(var3, var3.hash);
                  --class245.field3322;
                  ++class245.field3315;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class19.field299.available();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class245.field3307 = 0;
                  byte var5 = 0;
                  if(TextureProvider.currentRequest == null) {
                     var5 = 8;
                  } else if(class245.field3311 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class245.field3317.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class19.field299.read(class245.field3317.payload, class245.field3317.offset, var6);
                     if(class245.field3320 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class245.field3317.payload[class245.field3317.offset + var7] ^= class245.field3320;
                        }
                     }

                     class245.field3317.offset += var6;
                     if(class245.field3317.offset < var5) {
                        break;
                     }

                     if(TextureProvider.currentRequest == null) {
                        class245.field3317.offset = 0;
                        var7 = class245.field3317.readUnsignedByte();
                        var8 = class245.field3317.readUnsignedShort();
                        int var9 = class245.field3317.readUnsignedByte();
                        var10 = class245.field3317.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        FileRequest var13 = (FileRequest)class245.field3309.get(var11);
                        class245.field3316 = true;
                        if(var13 == null) {
                           var13 = (FileRequest)class245.field3314.get(var11);
                           class245.field3316 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        TextureProvider.currentRequest = var13;
                        SoundTask.field1574 = new Buffer(var10 + var14 + TextureProvider.currentRequest.padding);
                        SoundTask.field1574.putByte(var9);
                        SoundTask.field1574.putInt(var10);
                        class245.field3311 = 8;
                        class245.field3317.offset = 0;
                     } else if(class245.field3311 == 0) {
                        if(class245.field3317.payload[0] == -1) {
                           class245.field3311 = 1;
                           class245.field3317.offset = 0;
                        } else {
                           TextureProvider.currentRequest = null;
                        }
                     }
                  } else {
                     var6 = SoundTask.field1574.payload.length - TextureProvider.currentRequest.padding;
                     var7 = 512 - class245.field3311;
                     if(var7 > var6 - SoundTask.field1574.offset) {
                        var7 = var6 - SoundTask.field1574.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class19.field299.read(SoundTask.field1574.payload, SoundTask.field1574.offset, var7);
                     if(class245.field3320 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           SoundTask.field1574.payload[SoundTask.field1574.offset + var8] ^= class245.field3320;
                        }
                     }

                     SoundTask.field1574.offset += var7;
                     class245.field3311 += var7;
                     if(var6 == SoundTask.field1574.offset) {
                        if(16711935L == TextureProvider.currentRequest.hash) {
                           class36.field473 = SoundTask.field1574;

                           for(var8 = 0; var8 < 256; ++var8) {
                              IndexData var17 = class245.field3321[var8];
                              if(var17 != null) {
                                 class36.field473.offset = var8 * 8 + 5;
                                 var10 = class36.field473.readInt();
                                 int var18 = class36.field473.readInt();
                                 var17.setInformation(var10, var18);
                              }
                           }
                        } else {
                           class245.field3319.reset();
                           class245.field3319.update(SoundTask.field1574.payload, 0, var6);
                           var8 = (int)class245.field3319.getValue();
                           if(var8 != TextureProvider.currentRequest.crc) {
                              try {
                                 class19.field299.close();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class245.field3323;
                              class19.field299 = null;
                              class245.field3320 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class245.field3323 = 0;
                           class245.field3324 = 0;
                           TextureProvider.currentRequest.index.method4212((int)(TextureProvider.currentRequest.hash & 65535L), SoundTask.field1574.payload, 16711680L == (TextureProvider.currentRequest.hash & 16711680L), class245.field3316);
                        }

                        TextureProvider.currentRequest.unlink();
                        if(class245.field3316) {
                           --class245.field3310;
                        } else {
                           --class245.field3315;
                        }

                        class245.field3311 = 0;
                        TextureProvider.currentRequest = null;
                        SoundTask.field1574 = null;
                     } else {
                        if(class245.field3311 != 512) {
                           break;
                        }

                        class245.field3311 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class19.field299.close();
            } catch (Exception var19) {
               ;
            }

            ++class245.field3324;
            class19.field299 = null;
            return false;
         }
      }
   }
}
