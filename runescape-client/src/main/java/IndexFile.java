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
      String var11;
      if(var0 == 3100) {
         var11 = class32.scriptStringStack[--class32.scriptStringStackSize];
         Player.sendGameMessage(0, "", var11);
         return 1;
      } else if(var0 == 3101) {
         class30.field713 -= 2;
         Friend.method165(Projectile.localPlayer, class32.field743[class30.field713], class32.field743[class30.field713 + 1]);
         return 1;
      } else if(var0 == 3103) {
         class183.method3413();
         return 1;
      } else {
         int var5;
         int var14;
         if(var0 == 3104) {
            var11 = class32.scriptStringStack[--class32.scriptStringStackSize];
            var14 = 0;
            if(RSSocket.method2121(var11)) {
               var5 = FloorUnderlayDefinition.method3548(var11, 10, true);
               var14 = var5;
            }

            Client.secretCipherBuffer1.putOpcode(202);
            Client.secretCipherBuffer1.putInt(var14);
            return 1;
         } else if(var0 == 3105) {
            var11 = class32.scriptStringStack[--class32.scriptStringStackSize];
            Client.secretCipherBuffer1.putOpcode(127);
            Client.secretCipherBuffer1.putByte(var11.length() + 1);
            Client.secretCipherBuffer1.method2931(var11);
            return 1;
         } else if(var0 == 3106) {
            var11 = class32.scriptStringStack[--class32.scriptStringStackSize];
            Client.secretCipherBuffer1.putOpcode(168);
            Client.secretCipherBuffer1.putByte(var11.length() + 1);
            Client.secretCipherBuffer1.method2931(var11);
            return 1;
         } else {
            int var3;
            String var4;
            if(var0 != 3107) {
               if(var0 == 3108) {
                  class30.field713 -= 3;
                  var3 = class32.field743[class30.field713];
                  var14 = class32.field743[1 + class30.field713];
                  var5 = class32.field743[class30.field713 + 2];
                  Widget var13 = FaceNormal.method1932(var5);
                  class20.method187(var13, var3, var14);
                  return 1;
               } else if(var0 == 3109) {
                  class30.field713 -= 2;
                  var3 = class32.field743[class30.field713];
                  var14 = class32.field743[1 + class30.field713];
                  Widget var15 = var2?class154.field2123:class32.field746;
                  class20.method187(var15, var3, var14);
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
                  var11 = class32.scriptStringStack[--class32.scriptStringStackSize];
                  boolean var10 = class32.field743[--class30.field713] == 1;
                  World.method612(var11, var10, false);
                  return 1;
               } else if(var0 == 3115) {
                  var3 = class32.field743[--class30.field713];
                  Client.secretCipherBuffer1.putOpcode(121);
                  Client.secretCipherBuffer1.putShort(var3);
                  return 1;
               } else if(var0 == 3116) {
                  var3 = class32.field743[--class30.field713];
                  class32.scriptStringStackSize -= 2;
                  var4 = class32.scriptStringStack[class32.scriptStringStackSize];
                  String var12 = class32.scriptStringStack[1 + class32.scriptStringStackSize];
                  if(var4.length() > 500) {
                     return 1;
                  } else if(var12.length() > 500) {
                     return 1;
                  } else {
                     Client.secretCipherBuffer1.putOpcode(173);
                     Client.secretCipherBuffer1.putShort(1 + class72.method1439(var4) + class72.method1439(var12));
                     Client.secretCipherBuffer1.method2931(var12);
                     Client.secretCipherBuffer1.method2892(var3);
                     Client.secretCipherBuffer1.method2931(var4);
                     return 1;
                  }
               } else if(var0 == 3117) {
                  Client.field417 = class32.field743[--class30.field713] == 1;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               var3 = class32.field743[--class30.field713];
               var4 = class32.scriptStringStack[--class32.scriptStringStackSize];
               var5 = class45.field923;
               int[] var6 = class45.field918;
               boolean var7 = false;

               for(int var8 = 0; var8 < var5; ++var8) {
                  Player var9 = Client.cachedPlayers[var6[var8]];
                  if(null != var9 && Projectile.localPlayer != var9 && null != var9.name && var9.name.equalsIgnoreCase(var4)) {
                     if(var3 == 1) {
                        Client.secretCipherBuffer1.putOpcode(28);
                        Client.secretCipherBuffer1.putByte(0);
                        Client.secretCipherBuffer1.method2895(var6[var8]);
                     } else if(var3 == 4) {
                        Client.secretCipherBuffer1.putOpcode(135);
                        Client.secretCipherBuffer1.method2895(var6[var8]);
                        Client.secretCipherBuffer1.method2892(0);
                     } else if(var3 == 6) {
                        Client.secretCipherBuffer1.putOpcode(172);
                        Client.secretCipherBuffer1.method2895(var6[var8]);
                        Client.secretCipherBuffer1.putByte(0);
                     } else if(var3 == 7) {
                        Client.secretCipherBuffer1.putOpcode(45);
                        Client.secretCipherBuffer1.method2973(var6[var8]);
                        Client.secretCipherBuffer1.method2892(0);
                     }

                     var7 = true;
                     break;
                  }
               }

               if(!var7) {
                  Player.sendGameMessage(4, "", "Unable to find " + var4);
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
      synchronized(this.field1836) {
         if(var3 >= 0 && var3 <= this.field1834) {
            boolean var5 = this.method2314(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2314(var1, var2, var3, false);
            }

            return var5;
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
      } catch (Exception var6) {
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
      synchronized(this.field1836) {
         try {
            Object var10000;
            if(this.field1833.method1414() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field1833.method1437((long)(6 * var1));
               this.field1833.method1416(field1835, 0, 6);
               int var3 = ((field1835[0] & 255) << 16) + ((field1835[1] & 255) << 8) + (field1835[2] & 255);
               int var4 = ((field1835[4] & 255) << 8) + ((field1835[3] & 255) << 16) + (field1835[5] & 255);
               if(var3 < 0 || var3 > this.field1834) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field1836.method1414() / 520L) {
                  var10000 = null;
                  return (byte[])var10000;
               } else {
                  byte[] var5 = new byte[var3];
                  int var6 = 0;
                  int var7 = 0;

                  while(var6 < var3) {
                     if(var4 == 0) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     this.field1836.method1437((long)(520 * var4));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field1836.method1416(field1835, 0, 8 + var8);
                     int var9 = (field1835[1] & 255) + ((field1835[0] & 255) << 8);
                     int var10 = ((field1835[2] & 255) << 8) + (field1835[3] & 255);
                     int var11 = (field1835[6] & 255) + ((field1835[4] & 255) << 16) + ((field1835[5] & 255) << 8);
                     int var12 = field1835[7] & 255;
                     if(var9 == var1 && var7 == var10 && this.index == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field1836.method1414() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field1835[var13 + 8];
                           }

                           var4 = var11;
                           ++var7;
                           continue;
                        }

                        var10000 = null;
                        return (byte[])var10000;
                     }

                     var10000 = null;
                     return (byte[])var10000;
                  }

                  byte[] var18 = var5;
                  return var18;
               }
            }
         } catch (IOException var16) {
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
      synchronized(this.field1836) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field1833.method1414() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field1833.method1437((long)(var1 * 6));
               this.field1833.method1416(field1835, 0, 6);
               var6 = (field1835[5] & 255) + ((field1835[3] & 255) << 16) + ((field1835[4] & 255) << 8);
               if(var6 <= 0 || (long)var6 > this.field1836.method1414() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field1836.method1414() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field1835[0] = (byte)(var3 >> 16);
            field1835[1] = (byte)(var3 >> 8);
            field1835[2] = (byte)var3;
            field1835[3] = (byte)(var6 >> 16);
            field1835[4] = (byte)(var6 >> 8);
            field1835[5] = (byte)var6;
            this.field1833.method1437((long)(6 * var1));
            this.field1833.method1443(field1835, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label145: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field1836.method1437((long)(var6 * 520));

                        try {
                           this.field1836.method1416(field1835, 0, 8);
                        } catch (EOFException var16) {
                           break label145;
                        }

                        var14 = (field1835[1] & 255) + ((field1835[0] & 255) << 8);
                        int var11 = (field1835[3] & 255) + ((field1835[2] & 255) << 8);
                        var9 = ((field1835[4] & 255) << 16) + ((field1835[5] & 255) << 8) + (field1835[6] & 255);
                        int var12 = field1835[7] & 255;
                        if(var1 != var14 || var8 != var11 || var12 != this.index) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field1836.method1414() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field1836.method1414() + 519L) / 520L);
                        if(var9 == 0) {
                           ++var9;
                        }

                        if(var6 == var9) {
                           ++var9;
                        }
                     }

                     if(var3 - var7 <= 512) {
                        var9 = 0;
                     }

                     field1835[0] = (byte)(var1 >> 8);
                     field1835[1] = (byte)var1;
                     field1835[2] = (byte)(var8 >> 8);
                     field1835[3] = (byte)var8;
                     field1835[4] = (byte)(var9 >> 16);
                     field1835[5] = (byte)(var9 >> 8);
                     field1835[6] = (byte)var9;
                     field1835[7] = (byte)this.index;
                     this.field1836.method1437((long)(var6 * 520));
                     this.field1836.method1443(field1835, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field1836.method1443(var2, var7, var14);
                     var7 += var14;
                     var6 = var9;
                     ++var8;
                     continue;
                  }
               }

               var10000 = true;
               return var10000;
            }
         } catch (IOException var17) {
            return false;
         }
      }
   }
}
