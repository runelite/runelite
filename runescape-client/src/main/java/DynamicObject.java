import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("DynamicObject")
public class DynamicObject extends Renderable {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   Sequence field1534;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 518834531
   )
   @Export("id")
   int id;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1019887821
   )
   int field1531;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1226224551
   )
   @Export("type")
   int type;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1053344191
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 414153285
   )
   @Export("level")
   int level;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1697000195
   )
   int field1535;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1179278593
   )
   @Export("sceneX")
   int sceneX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1381073551
   )
   @Export("sceneY")
   int sceneY;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLee;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.level = var4;
      this.sceneX = var5;
      this.sceneY = var6;
      if(var7 != -1) {
         this.field1534 = class204.getAnimation(var7);
         this.field1535 = 0;
         this.field1531 = Client.gameCycle - 1;
         if(this.field1534.replyMode == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.field1534 == this.field1534) {
               this.field1535 = var10.field1535;
               this.field1531 = var10.field1531;
               return;
            }
         }

         if(var8 && this.field1534.frameStep != -1) {
            this.field1535 = (int)(Math.random() * (double)this.field1534.frameIDs.length);
            this.field1531 -= (int)(Math.random() * (double)this.field1534.frameLenghts[this.field1535]);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Leb;",
      garbageValue = "1172124455"
   )
   protected final Model getModel() {
      if(this.field1534 != null) {
         int var1 = Client.gameCycle - this.field1531;
         if(var1 > 100 && this.field1534.frameStep > 0) {
            var1 = 100;
         }

         label56: {
            do {
               do {
                  if(var1 <= this.field1534.frameLenghts[this.field1535]) {
                     break label56;
                  }

                  var1 -= this.field1534.frameLenghts[this.field1535];
                  ++this.field1535;
               } while(this.field1535 < this.field1534.frameIDs.length);

               this.field1535 -= this.field1534.frameStep;
            } while(this.field1535 >= 0 && this.field1535 < this.field1534.frameIDs.length);

            this.field1534 = null;
         }

         this.field1531 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = Occluder.getObjectDefinition(this.id);
      if(var12.impostorIds != null) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.orientation != 1 && this.orientation != 3) {
            var2 = var12.sizeX;
            var3 = var12.sizeY;
         } else {
            var2 = var12.sizeY;
            var3 = var12.sizeX;
         }

         int var4 = (var2 >> 1) + this.sceneX;
         int var5 = (var2 + 1 >> 1) + this.sceneX;
         int var6 = (var3 >> 1) + this.sceneY;
         int var7 = (var3 + 1 >> 1) + this.sceneY;
         int[][] var8 = class61.tileHeights[this.level];
         int var9 = var8[var5][var7] + var8[var5][var6] + var8[var4][var6] + var8[var4][var7] >> 2;
         int var10 = (this.sceneX << 7) + (var2 << 6);
         int var11 = (this.sceneY << 7) + (var3 << 6);
         return var12.method4615(this.type, this.orientation, var8, var10, var9, var11, this.field1534, this.field1535);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1062947618"
   )
   public static boolean method1934() {
      try {
         if(class203.field2521 == 2) {
            if(class35.field516 == null) {
               class35.field516 = Track1.getMusicFile(class203.field2522, class203.field2520, Frames.field2138);
               if(class35.field516 == null) {
                  return false;
               }
            }

            if(class203.field2524 == null) {
               class203.field2524 = new class110(class203.field2517, class203.field2519);
            }

            if(class203.field2523.method3846(class35.field516, class203.field2518, class203.field2524, 22050)) {
               class203.field2523.method3800();
               class203.field2523.method3797(class148.field2203);
               class203.field2523.method3886(class35.field516, BufferProvider.field3778);
               class203.field2521 = 0;
               class35.field516 = null;
               class203.field2524 = null;
               class203.field2522 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class203.field2523.method3803();
         class203.field2521 = 0;
         class35.field516 = null;
         class203.field2524 = null;
         class203.field2522 = null;
      }

      return false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;B)V",
      garbageValue = "20"
   )
   public static void method1932(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "16711935"
   )
   public static boolean method1933() {
      long var0 = class147.currentTimeMs();
      int var2 = (int)(var0 - class238.field3268);
      class238.field3268 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class238.field3252 += var2;
      if(class238.field3262 == 0 && class238.field3253 == 0 && class238.field3254 == 0 && class238.field3255 == 0) {
         return true;
      } else if(class238.field3265 == null) {
         return false;
      } else {
         try {
            if(class238.field3252 > 30000) {
               throw new IOException();
            } else {
               FileRequest var3;
               Buffer var4;
               while(class238.field3253 < 20 && class238.field3255 > 0) {
                  var3 = (FileRequest)class238.field3251.method3646();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class238.field3265.queueForWrite(var4.payload, 0, 4);
                  class238.field3256.put(var3, var3.hash);
                  --class238.field3255;
                  ++class238.field3253;
               }

               while(class238.field3262 < 20 && class238.field3254 > 0) {
                  var3 = (FileRequest)class238.field3258.peek();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class238.field3265.queueForWrite(var4.payload, 0, 4);
                  var3.unlinkDual();
                  class238.field3261.put(var3, var3.hash);
                  --class238.field3254;
                  ++class238.field3262;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class238.field3265.available();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class238.field3252 = 0;
                  byte var5 = 0;
                  if(class238.currentRequest == null) {
                     var5 = 8;
                  } else if(class238.field3266 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class238.field3270.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class238.field3265.read(class238.field3270.payload, class238.field3270.offset, var6);
                     if(class238.field3269 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class238.field3270.payload[class238.field3270.offset + var7] ^= class238.field3269;
                        }
                     }

                     class238.field3270.offset += var6;
                     if(class238.field3270.offset < var5) {
                        break;
                     }

                     if(class238.currentRequest == null) {
                        class238.field3270.offset = 0;
                        var7 = class238.field3270.readUnsignedByte();
                        var8 = class238.field3270.readUnsignedShort();
                        int var9 = class238.field3270.readUnsignedByte();
                        var10 = class238.field3270.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        FileRequest var13 = (FileRequest)class238.field3256.get(var11);
                        class238.field3263 = true;
                        if(var13 == null) {
                           var13 = (FileRequest)class238.field3261.get(var11);
                           class238.field3263 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class238.currentRequest = var13;
                        RSCanvas.field678 = new Buffer(var14 + var10 + class238.currentRequest.padding);
                        RSCanvas.field678.putByte(var9);
                        RSCanvas.field678.putInt(var10);
                        class238.field3266 = 8;
                        class238.field3270.offset = 0;
                     } else if(class238.field3266 == 0) {
                        if(class238.field3270.payload[0] == -1) {
                           class238.field3266 = 1;
                           class238.field3270.offset = 0;
                        } else {
                           class238.currentRequest = null;
                        }
                     }
                  } else {
                     var6 = RSCanvas.field678.payload.length - class238.currentRequest.padding;
                     var7 = 512 - class238.field3266;
                     if(var7 > var6 - RSCanvas.field678.offset) {
                        var7 = var6 - RSCanvas.field678.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class238.field3265.read(RSCanvas.field678.payload, RSCanvas.field678.offset, var7);
                     if(class238.field3269 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           RSCanvas.field678.payload[RSCanvas.field678.offset + var8] ^= class238.field3269;
                        }
                     }

                     RSCanvas.field678.offset += var7;
                     class238.field3266 += var7;
                     if(var6 == RSCanvas.field678.offset) {
                        if(16711935L == class238.currentRequest.hash) {
                           SceneTilePaint.field2033 = RSCanvas.field678;

                           for(var8 = 0; var8 < 256; ++var8) {
                              IndexData var17 = class238.field3260[var8];
                              if(var17 != null) {
                                 SceneTilePaint.field2033.offset = var8 * 8 + 5;
                                 var10 = SceneTilePaint.field2033.readInt();
                                 int var18 = SceneTilePaint.field2033.readInt();
                                 var17.setInformation(var10, var18);
                              }
                           }
                        } else {
                           class238.field3267.reset();
                           class238.field3267.update(RSCanvas.field678.payload, 0, var6);
                           var8 = (int)class238.field3267.getValue();
                           if(var8 != class238.currentRequest.crc) {
                              try {
                                 class238.field3265.close();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class238.field3257;
                              class238.field3265 = null;
                              class238.field3269 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class238.field3257 = 0;
                           class238.field3271 = 0;
                           class238.currentRequest.index.method4318((int)(class238.currentRequest.hash & 65535L), RSCanvas.field678.payload, 16711680L == (class238.currentRequest.hash & 16711680L), class238.field3263);
                        }

                        class238.currentRequest.unlink();
                        if(class238.field3263) {
                           --class238.field3253;
                        } else {
                           --class238.field3262;
                        }

                        class238.field3266 = 0;
                        class238.currentRequest = null;
                        RSCanvas.field678 = null;
                     } else {
                        if(class238.field3266 != 512) {
                           break;
                        }

                        class238.field3266 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class238.field3265.close();
            } catch (Exception var19) {
               ;
            }

            ++class238.field3271;
            class238.field3265 = null;
            return false;
         }
      }
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-9"
   )
   static final void method1928() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints == -1) {
            var0.delay = 0;
            class132.method2677(var0);
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(Lhj;B)Lhj;",
      garbageValue = "32"
   )
   static Widget method1931(Widget var0) {
      Widget var1 = class223.method4190(var0);
      if(var1 == null) {
         var1 = var0.dragParent;
      }

      return var1;
   }
}
