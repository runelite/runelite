import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("IndexFile")
public final class IndexFile {
   @ObfuscatedName("bh")
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("h")
   class72 field1833 = null;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -158690073
   )
   int field1834 = '\ufde8';
   @ObfuscatedName("f")
   static byte[] field1835 = new byte[520];
   @ObfuscatedName("u")
   class72 field1836 = null;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2062101945
   )
   @Export("index")
   int index;
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = 297093831
   )
   static int field1839;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "177868534"
   )
   static int method2301(int var0, Script var1, boolean var2) {
      String var3;
      if(var0 == 3100) {
         var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
         Player.sendGameMessage(0, "", var3);
         return 1;
      } else if(var0 == 3101) {
         class30.field713 -= 2;
         Friend.method165(Projectile.localPlayer, class32.field743[class30.field713], class32.field743[class30.field713 + 1]);
         return 1;
      } else if(var0 == 3103) {
         class183.method3413();
         return 1;
      } else {
         int var4;
         int var5;
         if(var0 == 3104) {
            var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
            var5 = 0;
            if(RSSocket.method2121(var3)) {
               var4 = FloorUnderlayDefinition.method3548(var3, 10, true);
               var5 = var4;
            }

            Client.secretCipherBuffer1.putOpcode(202);
            Client.secretCipherBuffer1.putInt(var5);
            return 1;
         } else if(var0 == 3105) {
            var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
            Client.secretCipherBuffer1.putOpcode(127);
            Client.secretCipherBuffer1.putByte(var3.length() + 1);
            Client.secretCipherBuffer1.method2931(var3);
            return 1;
         } else if(var0 == 3106) {
            var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
            Client.secretCipherBuffer1.putOpcode(168);
            Client.secretCipherBuffer1.putByte(var3.length() + 1);
            Client.secretCipherBuffer1.method2931(var3);
            return 1;
         } else {
            int var6;
            String var7;
            boolean var9;
            if(var0 != 3107) {
               Widget var12;
               if(var0 == 3108) {
                  class30.field713 -= 3;
                  var6 = class32.field743[class30.field713];
                  var5 = class32.field743[class30.field713 + 1];
                  var4 = class32.field743[class30.field713 + 2];
                  var12 = FaceNormal.method1932(var4);
                  class20.method187(var12, var6, var5);
                  return 1;
               } else if(var0 == 3109) {
                  class30.field713 -= 2;
                  var6 = class32.field743[class30.field713];
                  var5 = class32.field743[class30.field713 + 1];
                  var12 = var2?class154.field2123:class32.field746;
                  class20.method187(var12, var6, var5);
                  return 1;
               } else if(var0 == 3110) {
                  class177.field2687 = class32.field743[--class30.field713] == 1;
                  return 1;
               } else if(var0 == 3111) {
                  class32.field743[++class30.field713 - 1] = class148.field2058.field716?1:0;
                  return 1;
               } else if(var0 == 3112) {
                  class148.field2058.field716 = class32.field743[--class30.field713] == 1;
                  class150.method2839();
                  return 1;
               } else if(var0 == 3113) {
                  var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                  var9 = class32.field743[--class30.field713] == 1;
                  World.method612(var3, var9, false);
                  return 1;
               } else if(var0 == 3115) {
                  var6 = class32.field743[--class30.field713];
                  Client.secretCipherBuffer1.putOpcode(121);
                  Client.secretCipherBuffer1.putShort(var6);
                  return 1;
               } else if(var0 == 3116) {
                  var6 = class32.field743[--class30.field713];
                  class32.scriptStringStackSize -= 2;
                  var7 = class32.scriptStringStack[class32.scriptStringStackSize];
                  String var13 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                  if(var7.length() > 500) {
                     return 1;
                  } else if(var13.length() > 500) {
                     return 1;
                  } else {
                     Client.secretCipherBuffer1.putOpcode(173);
                     Client.secretCipherBuffer1.putShort(class72.method1439(var7) + 1 + class72.method1439(var13));
                     Client.secretCipherBuffer1.method2931(var13);
                     Client.secretCipherBuffer1.method2892(var6);
                     Client.secretCipherBuffer1.method2931(var7);
                     return 1;
                  }
               } else if(var0 == 3117) {
                  Client.field417 = class32.field743[--class30.field713] == 1;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               var6 = class32.field743[--class30.field713];
               var7 = class32.scriptStringStack[--class32.scriptStringStackSize];
               var4 = class45.field923;
               int[] var8 = class45.field918;
               var9 = false;

               for(int var10 = 0; var10 < var4; ++var10) {
                  Player var11 = Client.cachedPlayers[var8[var10]];
                  if(var11 != null && Projectile.localPlayer != var11 && var11.name != null && var11.name.equalsIgnoreCase(var7)) {
                     if(var6 == 1) {
                        Client.secretCipherBuffer1.putOpcode(28);
                        Client.secretCipherBuffer1.putByte(0);
                        Client.secretCipherBuffer1.method2895(var8[var10]);
                     } else if(var6 == 4) {
                        Client.secretCipherBuffer1.putOpcode(135);
                        Client.secretCipherBuffer1.method2895(var8[var10]);
                        Client.secretCipherBuffer1.method2892(0);
                     } else if(var6 == 6) {
                        Client.secretCipherBuffer1.putOpcode(172);
                        Client.secretCipherBuffer1.method2895(var8[var10]);
                        Client.secretCipherBuffer1.putByte(0);
                     } else if(var6 == 7) {
                        Client.secretCipherBuffer1.putOpcode(45);
                        Client.secretCipherBuffer1.method2973(var8[var10]);
                        Client.secretCipherBuffer1.method2892(0);
                     }

                     var9 = true;
                     break;
                  }
               }

               if(!var9) {
                  Player.sendGameMessage(4, "", "Unable to find " + var7);
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "1"
   )
   public boolean method2303(int var1, byte[] var2, int var3) {
      class72 var4 = this.field1836;
      class72 var5 = this.field1836;
      class72 var6 = this.field1836;
      synchronized(this.field1836) {
         if(var3 >= 0 && var3 <= this.field1834) {
            boolean var7 = this.method2314(var1, var2, var3, true);
            if(!var7) {
               var7 = this.method2314(var1, var2, var3, false);
            }

            return var7;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)Ljava/lang/String;",
      garbageValue = "0"
   )
   public static String method2305(Buffer var0, int var1) {
      try {
         int var2 = var0.method2880();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class210.field3133.method2799(var0.payload, var0.offset, var3, 0, var2);
         String var4 = class139.method2679(var3, 0, var2);
         return var4;
      } catch (Exception var5) {
         return "Cabbage";
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "16"
   )
   public byte[] method2310(int var1) {
      class72 var2 = this.field1836;
      class72 var3 = this.field1836;
      class72 var4 = this.field1836;
      synchronized(this.field1836) {
         try {
            byte[] var5;
            Object var6;
            byte[] var10000;
            if(this.field1833.method1414() < (long)(var1 * 6 + 6)) {
               var6 = null;
               var5 = (byte[])((byte[])((byte[])var6));
               var10000 = var5;
               return var10000;
            } else {
               this.field1833.method1437((long)(var1 * 6));
               this.field1833.method1416(field1835, 0, 6);
               int var7 = ((field1835[0] & 255) << 16) + ((field1835[1] & 255) << 8) + (field1835[2] & 255);
               int var8 = ((field1835[4] & 255) << 8) + ((field1835[3] & 255) << 16) + (field1835[5] & 255);
               if(var7 < 0 || var7 > this.field1834) {
                  var6 = null;
                  var5 = (byte[])((byte[])((byte[])var6));
                  var10000 = var5;
                  return var10000;
               } else if(var8 <= 0 || (long)var8 > this.field1836.method1414() / 520L) {
                  var6 = null;
                  var5 = (byte[])((byte[])((byte[])var6));
                  return var5;
               } else {
                  byte[] var9 = new byte[var7];
                  int var10 = 0;
                  int var11 = 0;

                  while(var10 < var7) {
                     if(var8 == 0) {
                        var6 = null;
                        var5 = (byte[])((byte[])((byte[])var6));
                        var10000 = var5;
                        return var10000;
                     }

                     this.field1836.method1437((long)(var8 * 520));
                     int var12 = var7 - var10;
                     if(var12 > 512) {
                        var12 = 512;
                     }

                     this.field1836.method1416(field1835, 0, var12 + 8);
                     int var13 = (field1835[1] & 255) + ((field1835[0] & 255) << 8);
                     int var14 = ((field1835[2] & 255) << 8) + (field1835[3] & 255);
                     int var15 = (field1835[6] & 255) + ((field1835[4] & 255) << 16) + ((field1835[5] & 255) << 8);
                     int var16 = field1835[7] & 255;
                     if(var13 == var1 && var11 == var14 && this.index == var16) {
                        if(var15 >= 0 && (long)var15 <= this.field1836.method1414() / 520L) {
                           for(int var17 = 0; var17 < var12; ++var17) {
                              var9[var10++] = field1835[var17 + 8];
                           }

                           var8 = var15;
                           ++var11;
                           continue;
                        }

                        var6 = null;
                        var5 = (byte[])((byte[])((byte[])var6));
                        var10000 = var5;
                        return var10000;
                     }

                     var6 = null;
                     var5 = (byte[])((byte[])((byte[])var6));
                     var10000 = var5;
                     return var10000;
                  }

                  var10000 = var9;
                  return var10000;
               }
            }
         } catch (IOException var19) {
            return null;
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(ILclass72;Lclass72;I)V",
      garbageValue = "500000"
   )
   public IndexFile(int var1, class72 var2, class72 var3, int var4) {
      this.index = var1;
      this.field1836 = var2;
      this.field1833 = var3;
      this.field1834 = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "2006340856"
   )
   public static int method2313(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "1624593534"
   )
   boolean method2314(int var1, byte[] var2, int var3, boolean var4) {
      class72 var5 = this.field1836;
      class72 var6 = this.field1836;
      class72 var7 = this.field1836;
      synchronized(this.field1836) {
         try {
            int var8;
            boolean var9;
            boolean var10000;
            if(var4) {
               if(this.field1833.method1414() < (long)(var1 * 6 + 6)) {
                  var9 = false;
                  var10000 = var9;
                  return var10000;
               }

               this.field1833.method1437((long)(var1 * 6));
               this.field1833.method1416(field1835, 0, 6);
               var8 = (field1835[5] & 255) + ((field1835[3] & 255) << 16) + ((field1835[4] & 255) << 8);
               if(var8 <= 0 || (long)var8 > this.field1836.method1414() / 520L) {
                  var9 = false;
                  var10000 = var9;
                  return var10000;
               }
            } else {
               var8 = (int)((this.field1836.method1414() + 519L) / 520L);
               if(var8 == 0) {
                  var8 = 1;
               }
            }

            field1835[0] = (byte)(var3 >> 16);
            field1835[1] = (byte)(var3 >> 8);
            field1835[2] = (byte)var3;
            field1835[3] = (byte)(var8 >> 16);
            field1835[4] = (byte)(var8 >> 8);
            field1835[5] = (byte)var8;
            this.field1833.method1437((long)(var1 * 6));
            this.field1833.method1443(field1835, 0, 6);
            int var11 = 0;
            int var12 = 0;

            while(true) {
               if(var11 < var3) {
                  label129: {
                     int var13 = 0;
                     int var14;
                     if(var4) {
                        this.field1836.method1437((long)(var8 * 520));

                        try {
                           this.field1836.method1416(field1835, 0, 8);
                        } catch (EOFException var18) {
                           break label129;
                        }

                        var14 = (field1835[1] & 255) + ((field1835[0] & 255) << 8);
                        int var15 = (field1835[3] & 255) + ((field1835[2] & 255) << 8);
                        var13 = ((field1835[4] & 255) << 16) + ((field1835[5] & 255) << 8) + (field1835[6] & 255);
                        int var16 = field1835[7] & 255;
                        if(var1 != var14 || var12 != var15 || var16 != this.index) {
                           var9 = false;
                           var10000 = var9;
                           return var10000;
                        }

                        if(var13 < 0 || (long)var13 > this.field1836.method1414() / 520L) {
                           var9 = false;
                           var10000 = var9;
                           return var10000;
                        }
                     }

                     if(var13 == 0) {
                        var4 = false;
                        var13 = (int)((this.field1836.method1414() + 519L) / 520L);
                        if(var13 == 0) {
                           ++var13;
                        }

                        if(var8 == var13) {
                           ++var13;
                        }
                     }

                     if(var3 - var11 <= 512) {
                        var13 = 0;
                     }

                     field1835[0] = (byte)(var1 >> 8);
                     field1835[1] = (byte)var1;
                     field1835[2] = (byte)(var12 >> 8);
                     field1835[3] = (byte)var12;
                     field1835[4] = (byte)(var13 >> 16);
                     field1835[5] = (byte)(var13 >> 8);
                     field1835[6] = (byte)var13;
                     field1835[7] = (byte)this.index;
                     this.field1836.method1437((long)(var8 * 520));
                     this.field1836.method1443(field1835, 0, 8);
                     var14 = var3 - var11;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field1836.method1443(var2, var11, var14);
                     var11 += var14;
                     var8 = var13;
                     ++var12;
                     continue;
                  }
               }

               var9 = true;
               var10000 = var9;
               return var10000;
            }
         } catch (IOException var19) {
            return false;
         }
      }
   }
}
