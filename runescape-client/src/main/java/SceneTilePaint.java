import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -134250751
   )
   int field2040;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1600085737
   )
   int field2041;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1270745717
   )
   int field2042;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -427996867
   )
   int field2043;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -956757785
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("z")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 157792485
   )
   @Export("rgb")
   int rgb;

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-31"
   )
   static final void method2573() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.method3487(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.method3512()) {
         if(var0.hitpoints > 0) {
            --var0.hitpoints;
         }

         if(var0.hitpoints == 0) {
            if(var0.field1191 < 0 || class92.method1636(var0.field1191, var0.field1193)) {
               class59.method962(var0.level, var0.type, var0.x, var0.y, var0.field1191, var0.field1195, var0.field1193);
               var0.unlink();
            }
         } else {
            if(var0.delay > 0) {
               --var0.delay;
            }

            if(var0.delay == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102 && (var0.id < 0 || class92.method1636(var0.id, var0.field1196))) {
               class59.method962(var0.level, var0.type, var0.x, var0.y, var0.id, var0.orientation, var0.field1196);
               var0.delay = -1;
               if(var0.field1191 == var0.id && var0.field1191 == -1) {
                  var0.unlink();
               } else if(var0.field1191 == var0.id && var0.orientation == var0.field1195 && var0.field1193 == var0.field1196) {
                  var0.unlink();
               }
            }
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.flatShade = true;
      this.field2040 = var1;
      this.field2041 = var2;
      this.field2042 = var3;
      this.field2043 = var4;
      this.texture = var5;
      this.rgb = var6;
      this.flatShade = var7;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "44"
   )
   public static boolean method2574() {
      long var0 = class166.method2970();
      int var2 = (int)(var0 - class238.field3278);
      class238.field3278 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class238.field3266 += var2;
      if(class238.field3268 == 0 && class238.field3269 == 0 && class238.field3261 == 0 && class238.field3267 == 0) {
         return true;
      } else if(class238.field3258 == null) {
         return false;
      } else {
         try {
            if(class238.field3266 > 30000) {
               throw new IOException();
            } else {
               class234 var3;
               Buffer var4;
               while(class238.field3269 < 20 && class238.field3267 > 0) {
                  var3 = (class234)class238.field3260.method3435();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class238.field3258.queueForWrite(var4.payload, 0, 4);
                  class238.field3262.method3426(var3, var3.hash);
                  --class238.field3267;
                  ++class238.field3269;
               }

               while(class238.field3268 < 20 && class238.field3261 > 0) {
                  var3 = (class234)class238.field3259.method3372();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class238.field3258.queueForWrite(var4.payload, 0, 4);
                  var3.method3520();
                  class238.field3263.method3426(var3, var3.hash);
                  --class238.field3261;
                  ++class238.field3268;
               }

               for(int var5 = 0; var5 < 100; ++var5) {
                  int var6 = class238.field3258.available();
                  if(var6 < 0) {
                     throw new IOException();
                  }

                  if(var6 == 0) {
                     break;
                  }

                  class238.field3266 = 0;
                  byte var7 = 0;
                  if(class51.field668 == null) {
                     var7 = 8;
                  } else if(class238.field3264 == 0) {
                     var7 = 1;
                  }

                  int var8;
                  int var9;
                  int var10;
                  int var11;
                  if(var7 > 0) {
                     var8 = var7 - class238.field3270.offset;
                     if(var8 > var6) {
                        var8 = var6;
                     }

                     class238.field3258.read(class238.field3270.payload, class238.field3270.offset, var8);
                     if(class238.field3274 != 0) {
                        for(var9 = 0; var9 < var8; ++var9) {
                           class238.field3270.payload[var9 + class238.field3270.offset] ^= class238.field3274;
                        }
                     }

                     class238.field3270.offset += var8;
                     if(class238.field3270.offset < var7) {
                        break;
                     }

                     if(class51.field668 == null) {
                        class238.field3270.offset = 0;
                        var9 = class238.field3270.readUnsignedByte();
                        var10 = class238.field3270.readUnsignedShort();
                        int var12 = class238.field3270.readUnsignedByte();
                        var11 = class238.field3270.readInt();
                        long var13 = (long)((var9 << 16) + var10);
                        class234 var15 = (class234)class238.field3262.method3425(var13);
                        class170.field2362 = true;
                        if(var15 == null) {
                           var15 = (class234)class238.field3263.method3425(var13);
                           class170.field2362 = false;
                        }

                        if(var15 == null) {
                           throw new IOException();
                        }

                        int var16 = var12 == 0?5:9;
                        class51.field668 = var15;
                        class77.field1207 = new Buffer(var11 + var16 + class51.field668.field3214);
                        class77.field1207.putByte(var12);
                        class77.field1207.putInt(var11);
                        class238.field3264 = 8;
                        class238.field3270.offset = 0;
                     } else if(class238.field3264 == 0) {
                        if(class238.field3270.payload[0] == -1) {
                           class238.field3264 = 1;
                           class238.field3270.offset = 0;
                        } else {
                           class51.field668 = null;
                        }
                     }
                  } else {
                     var8 = class77.field1207.payload.length - class51.field668.field3214;
                     var9 = 512 - class238.field3264;
                     if(var9 > var8 - class77.field1207.offset) {
                        var9 = var8 - class77.field1207.offset;
                     }

                     if(var9 > var6) {
                        var9 = var6;
                     }

                     class238.field3258.read(class77.field1207.payload, class77.field1207.offset, var9);
                     if(class238.field3274 != 0) {
                        for(var10 = 0; var10 < var9; ++var10) {
                           class77.field1207.payload[var10 + class77.field1207.offset] ^= class238.field3274;
                        }
                     }

                     class77.field1207.offset += var9;
                     class238.field3264 += var9;
                     if(var8 == class77.field1207.offset) {
                        if(16711935L == class51.field668.hash) {
                           class238.field3272 = class77.field1207;

                           for(var10 = 0; var10 < 256; ++var10) {
                              IndexData var20 = class238.field3273[var10];
                              if(var20 != null) {
                                 class238.field3272.offset = var10 * 8 + 5;
                                 var11 = class238.field3272.readInt();
                                 int var21 = class238.field3272.readInt();
                                 var20.method4126(var11, var21);
                              }
                           }
                        } else {
                           class238.field3271.reset();
                           class238.field3271.update(class77.field1207.payload, 0, var8);
                           var10 = (int)class238.field3271.getValue();
                           if(class51.field668.field3215 != var10) {
                              try {
                                 class238.field3258.close();
                              } catch (Exception var18) {
                                 ;
                              }

                              ++class238.field3275;
                              class238.field3258 = null;
                              class238.field3274 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class238.field3275 = 0;
                           class238.field3276 = 0;
                           class51.field668.field3218.method4117((int)(class51.field668.hash & 65535L), class77.field1207.payload, (class51.field668.hash & 16711680L) == 16711680L, class170.field2362);
                        }

                        class51.field668.unlink();
                        if(class170.field2362) {
                           --class238.field3269;
                        } else {
                           --class238.field3268;
                        }

                        class238.field3264 = 0;
                        class51.field668 = null;
                        class77.field1207 = null;
                     } else {
                        if(class238.field3264 != 512) {
                           break;
                        }

                        class238.field3264 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var19) {
            try {
               class238.field3258.close();
            } catch (Exception var17) {
               ;
            }

            ++class238.field3276;
            class238.field3258 = null;
            return false;
         }
      }
   }
}
